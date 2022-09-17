package com.hrx.character;

import com.hrx.util.*;
import com.jacob.com.Dispatch;
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


    private Dispatch dmCom;

    public GameRole(String name, Dispatch dmCom) throws Exception {
        super();
        this.setName(name);
        //获取当前城市
        this.setCity(new City());
        this.setDmCom(dmCom);
    }

    public void moveToCity(City city) throws Exception {
        //1、已在目标场景不需要移动
        if (city.getName().equals(this.getCity().getName())) {
            return;
        }
        //2、移动到目标场景
        WorldMapUtil.moveToCity(city, dmCom);
    }

    public void moveToNpc(Npc npc) throws Exception {
        //1、移动到城市
        moveToCity(npc.getCity());
        //2、等待时间
        Thread.sleep(8000);
        //2、移动到NPC坐标
        AutoRunUtil.moveToXy(dmCom, npc.getLocationX(), npc.getLocationY());
    }

    public void doTask(Npc npc, Dispatch dmCom) throws Exception{
        npc.doTask(dmCom);
    }


}
