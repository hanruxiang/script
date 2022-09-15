package com.hrx.util;

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

}
