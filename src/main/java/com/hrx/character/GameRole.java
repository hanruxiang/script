package com.hrx.character;

import com.hrx.util.*;
import com.qiyou.javaelf.system.Elf;
import lombok.Data;

/**
 * 游戏角色
 * @author hrx
 */
@Data
public class GameRole extends Character {

    /**130
     *
     * 人物血量
     */
    private Integer bloodVolume;


    private Elf elf;

    public GameRole(String name, Elf elf) throws Exception {
        super();
        this.setName(name);
        //获取当前城市
        this.setCity(new City());
        this.setElf(elf);
    }

    public void moveToCity(City city) throws Exception {
        //1、已在目标场景不需要移动
        if (city.getName().equals(this.getCity().getName())) {
            return;
        }
        //2、移动到目标场景
        WorldMapUtil.moveToCity(city, elf);
        while (WorldMapUtil.isArrived(city, elf)) {
            //3、每5S检测一次
            Thread.sleep(5000);
        }
    }

    public void moveToNpc(Npc npc) throws Exception {
        //1、移动到城市
        moveToCity(npc.getCity());
        //2、移动到NPC坐标
        AutoRunUtil.moveToXy(elf, npc.getLocationX(), npc.getLocationY());
    }

    public void doTask(Npc npc, Elf elf) throws Exception{
        npc.doTask(elf);
    }


}
