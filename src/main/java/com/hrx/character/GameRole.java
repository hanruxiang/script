package com.hrx.character;

import com.hrx.util.*;
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

    public GameRole(String name) throws Exception {
        super();
        this.setName(name);
        //获取当前城市
        this.setCity(new City());
    }

    public void moveToCity(City city) throws Exception {
        //1、已在目标场景不需要移动
        if (city.getName().equals(this.getCity().getName())) {
            return;
        }
        //2、移动到目标场景
        WorldMapUtil.moveToCity(city);
    }

    public void moveToNpc(Npc npc) throws Exception {
        //1、移动到城市
        moveToCity(npc.getCity());
        //2、等待时间
        Thread.sleep(2000);
        //2、移动到NPC坐标
        AutoRunUtil.moveToXy(npc.getLocationX(), npc.getLocationY());
    }
}
