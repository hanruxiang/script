package com.hrx.util;

import com.hrx.character.City;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

import java.awt.event.KeyEvent;

/**
 * 世界地图util
 * @author hrx
 */
public class WorldMapUtil {

    public static void moveToCity(City city, Elf elf) throws Exception {
        //1、打开世界地图
        KeyboardUtil.keyPressMore(KeyEvent.VK_ALT, KeyEvent.VK_M);
        //2、找出目标坐标单击
        MouseUtil.findPictureAnkLeftClick(elf, city.getWorldMapPicture());
        //3、随便点个点
        DaMoApi.moveMouse(elf, 300, 300);
        //4、双击寻路进入场景
        DaMoApi.leftDoubleClick(elf);
        //5、退出地图
        KeyboardUtil.keyPress(KeyEvent.VK_ESCAPE);
        //6、如果有确定按钮点击130
        /*TwoTuple<Integer, Integer> confirmButton = FindPsoUtil.findPoint(city.getWorldMapPictureUrl());
        if (Objects.nonNull(confirmButton) && !CommonConstants.ZERO.equals(confirmButton.x) && !CommonConstants.ZERO.equals(confirmButton.y)) {
            //7、单击确认按钮
            MouseUtil.mouseLeftClick(confirmButton.x, confirmButton.y);
        }*/
    }

    public static boolean isArrived(City city, Elf elf) throws Exception {
        //1、找到图片
        TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf, 0, 0, 2000, 2000, city.getPicture(), "000000");
        if (-1 == point.x &&  -1 == point.y) {
            return false;
        }
        return true;
    }

}
