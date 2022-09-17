package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.jacob.com.Dispatch;

import java.awt.event.KeyEvent;

/**
 * 自动寻路util
 * @author hrx
 */
public class AutoRunUtil {

    public static void moveToXy(Dispatch dmCom, Integer x, Integer y) throws Exception {
        //1、打开自动寻路窗口
        KeyboardUtil.keyPressMore(KeyEvent.VK_ALT, 192);
        //2、找坐标输入框的坐标
        MouseUtil.findPictureAnkLeftClick(dmCom,  CommonConstants.PictureConstants.自动寻路坐标输入框);
        //3、输入横坐标
        KeyboardUtil.write(x.toString());
        //4、输入回车
        KeyboardUtil.keyPress(KeyEvent.VK_ENTER);
        //5、输入纵坐标
        KeyboardUtil.write(y.toString());
        //6、输入回车
        KeyboardUtil.keyPress(KeyEvent.VK_ENTER);
    }

    public static void main(String[] args) throws Exception {
        //1、打开自动寻路窗口
        TwoTuple<Integer, Integer> autoRunButtonPoint = FindPsoUtil.findPoint(CommonConstants.PictureConstants.自动寻路按钮);
        //2、单击“自动寻路”按钮
        MouseUtil.mouseLeftClick(autoRunButtonPoint.x, autoRunButtonPoint.y);
    }

}
