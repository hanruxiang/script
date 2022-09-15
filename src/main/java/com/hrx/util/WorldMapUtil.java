package com.hrx.util;

import com.hrx.character.City;
import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;

import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * 世界地图util
 * @author hrx
 */
public class WorldMapUtil {

    public static void moveToCity(City city) throws Exception {
        //1、打开世界地图
        KeyboardUtil.keyPressMore(KeyEvent.VK_ALT, KeyEvent.VK_M);
        //2、找出目标坐标
        TwoTuple<Integer, Integer> cityPoint = FindPsoUtil.findPoint(city.getWorldMapPictureUrl());
        //3、单击世界地图进入场景地图
        MouseUtil.mouseLeftClick(cityPoint.x, cityPoint.y);
        //4、双击寻路进入场景
        MouseUtil.mouseLeftDoubleClick(cityPoint.x, cityPoint.y);
        //5、退出地图
        KeyboardUtil.keyPress(KeyEvent.VK_ESCAPE);
        //6、如果有确定按钮点击130
        /*TwoTuple<Integer, Integer> confirmButton = FindPsoUtil.findPoint(city.getWorldMapPictureUrl());
        if (Objects.nonNull(confirmButton) && !CommonConstants.ZERO.equals(confirmButton.x) && !CommonConstants.ZERO.equals(confirmButton.y)) {
            //7、单击确认按钮
            MouseUtil.mouseLeftClick(confirmButton.x, confirmButton.y);
        }*/
    }


    public static void main(String[] args) {

    }

}
