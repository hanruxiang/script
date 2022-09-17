package com.hrx.util;

import com.hrx.character.City;
import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.jacob.com.Dispatch;

import java.awt.event.KeyEvent;

/**
 * 世界地图util
 * @author hrx
 */
public class WorldMapUtil {

    public static void moveToCity(City city, Dispatch dmCom) throws Exception {
        //1、打开世界地图
        KeyboardUtil.keyPressMore(KeyEvent.VK_ALT, KeyEvent.VK_M);
        //2、找出目标坐标单击
        MouseUtil.findPictureAnkLeftClick(dmCom, city.getWorldMapPicture());
        //3、随便点个点
        DaMoApi.moveMouse(dmCom, 300, 300);
        //4、双击寻路进入场景
        DaMoApi.leftDoubleClick(dmCom);
        //5、退出地图
        KeyboardUtil.keyPress(KeyEvent.VK_ESCAPE);
        //6、如果有确定按钮点击130
        /*TwoTuple<Integer, Integer> confirmButton = FindPsoUtil.findPoint(city.getWorldMapPictureUrl());
        if (Objects.nonNull(confirmButton) && !CommonConstants.ZERO.equals(confirmButton.x) && !CommonConstants.ZERO.equals(confirmButton.y)) {
            //7、单击确认按钮
            MouseUtil.mouseLeftClick(confirmButton.x, confirmButton.y);
        }*/
    }

}
