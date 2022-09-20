package com.hrx.util;

import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

/**
 * @author hrx
 */
public class MouseUtil {



    public static void findPictureAnkLeftClick(Elf elf, String pictureName) throws InterruptedException {
        //1、找到图片
        TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf, 0, 0, 2000, 2000, pictureName, "000000");
        if (-1 == point.x &&  -1 == point.y) {
            return;
        }
        //2、鼠标移动到图片上
        DaMoApi.moveMouse(elf, point.x, point.y);
        //3、点击图片
        DaMoApi.leftClick(elf);
    }

    public static void findPictureAnkRightClick(Elf elf, String pictureName) throws InterruptedException {
        //1、找到图片
        TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf, 0, 0, 2000, 2000, pictureName, "000000");
        if (-1 == point.x &&  -1 == point.y) {
            return;
        }
        //2、鼠标移动到图片上
        DaMoApi.moveMouse(elf, point.x, point.y);
        //3、点击图片
        DaMoApi.rightClick(elf);
    }

    public static void moveAndClick(Elf elf, Integer x, Integer y) throws InterruptedException {
        //1、鼠标移动到NPC坐标
        DaMoApi.moveMouse(elf, x, y);
        //2、点击NPC
        DaMoApi.leftClick(elf);
    }

    public static void moveAndDoubleClick(Elf elf, Integer x, Integer y) throws InterruptedException {
        //1、鼠标移动到NPC坐标
        DaMoApi.moveMouse(elf, x, y);
        //2、点击NPC
        DaMoApi.leftDoubleClick(elf);
    }

}
