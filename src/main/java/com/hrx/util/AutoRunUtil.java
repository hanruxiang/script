package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

import java.awt.event.KeyEvent;

/**
 * 自动寻路util
 * @author hrx
 */
public class AutoRunUtil {

    public static void moveToXy(Elf elf, Integer x, Integer y) throws Exception {
        //1、打开自动寻路窗口
        KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.自动寻路快捷键);
        //2、找坐标输入框的坐标
        MouseUtil.findPictureAnkLeftClick(elf,  CommonConstants.PictureConstants.自动寻路坐标输入框);
        //3、输入横坐标
        KeyboardUtil.write(elf, x.toString());
        //4、输入回车
        KeyboardUtil.keyPress(elf, KeyEvent.VK_ENTER);
        //5、输入纵坐标
        KeyboardUtil.write(elf, y.toString());
        //6、输入回车
        KeyboardUtil.keyPress(elf, KeyEvent.VK_ENTER);
    }

    public static void main(String[] args) throws Exception {
    }

}
