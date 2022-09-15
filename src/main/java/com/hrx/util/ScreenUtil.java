package com.hrx.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 屏幕工具类
 * @author hrx
 */
public class ScreenUtil {

    /**
     *
     * @param area 截图区域，即给定的截图范围：{左上角的横坐标,左上角的纵坐标,右下角的横坐标,右下角的纵坐标}
     * @return
     * @throws AWTException
     * @throws IOException
     */
    public static BufferedImage getScreenImage(int[] area)throws AWTException {
        //电脑屏幕大小
        Dimension screen;
        //截图的宽高
        Rectangle screenRect;
        //暂存图片的缓存
        BufferedImage image;
        //负责截屏的操作者
        Robot robot;
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        //截图尺寸
        screen.height=area[3]-area[1];
        screen.width=area[2]-area[0];
        screenRect = new Rectangle(screen);
        //左上角得坐标
        screenRect.x=area[0];
        screenRect.y=area[1];
        robot = new Robot();
        //将得到的屏幕信息存放在缓存里面
        image = robot.createScreenCapture(screenRect);
        return image;
    }
}
