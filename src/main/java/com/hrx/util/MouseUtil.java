package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.jacob.com.Dispatch;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author hrx
 */
public class MouseUtil {

    /**
     * 鼠标移动至指定位置后点击左键
     * @param clickX
     * @param clickY
     */
    public static void mouseLeftClick(int clickX, int clickY) throws Exception {
        Robot robot = new Robot();
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(clickX, clickY);
        }
        // 按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        // 松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        // 等待动画时间
        Thread.sleep(1200);
    }

    /**
     * 鼠标移动至指定位置后点击右键
     * @param clickX
     * @param clickY
     */
    public static void mouseRightClick(int clickX, int clickY) throws Exception {
        Robot robot = new Robot();
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(clickX, clickY);
        }
        // 按下右键
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.delay(1000);
        // 松开右键
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        // 等待动画时间
        Thread.sleep(1200);
    }

    /**
     * 双击左键
     * @param clickX
     * @param clickY
     * @throws Exception
     */
    public static void mouseLeftDoubleClick(int clickX, int clickY) throws Exception {
        Robot robot = new Robot();
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(clickX, clickY);
        }
        // 按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        // 松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(100);
        robot.mouseMove((int) clickX, (int) clickY);
        // 按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        // 松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        // 等待动画时间
        Thread.sleep(1200);
    }

    public static void findPictureAnkLeftClick(Dispatch dmCom, String pictureName) throws InterruptedException {
        //1、找到图片
        TwoTuple<Integer, Integer> point = DaMoApi.findPic(dmCom, 0, 0, 2000, 2000, pictureName, "000000");
        if (-1 == point.x &&  -1 == point.y) {
            return;
        }
        //2、鼠标移动到图片上
        DaMoApi.moveMouse(dmCom, point.x, point.y);
        //3、点击图片
        DaMoApi.leftClick(dmCom);
    }

    public static void findPictureAnkRightClick(Dispatch dmCom, String pictureName) throws InterruptedException {
        //1、找到图片
        TwoTuple<Integer, Integer> point = DaMoApi.findPic(dmCom, 0, 0, 2000, 2000, pictureName, "000000");
        if (-1 == point.x &&  -1 == point.y) {
            return;
        }
        //2、鼠标移动到图片上
        DaMoApi.moveMouse(dmCom, point.x, point.y);
        //3、点击图片
        DaMoApi.rightClick(dmCom);
    }

    public static void moveAndClick(Dispatch dmCom, Integer x, Integer y) throws InterruptedException {
        //1、鼠标移动到NPC坐标
        DaMoApi.moveMouse(dmCom, x, y);
        //2、点击NPC
        DaMoApi.leftClick(dmCom);
    }

}
