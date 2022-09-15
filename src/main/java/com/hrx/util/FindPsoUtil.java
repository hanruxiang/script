package com.hrx.util;

import cn.hutool.core.io.resource.ClassPathResource;
import com.hrx.common.TwoTuple;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 根据图片定位坐标
 * @author hrx
 */
public class FindPsoUtil {

    /**
     * 目标图片
     */
    BufferedImage keyImage;
    /**
     * 当前屏幕宽度
     */
    int scrShotImgWidth;
    /**
     * 当前屏幕高度
     */
    int scrShotImgHeight;
    /**
     * 目标图片宽度
     */
    int keyImgWidth;
    /**
     * 目标图片高度
     */
    int keyImgHeight;
    /**
     * 当前屏幕RGB数据
     */
    int[][] screenShotImageRGBData;
    /**
     * 目标图片RGB数据
     */
    int[][] keyImageRGBData;
    /**
     * 结果X
     */
    int findX;
    /**
     * 结果Y
     */
    int findY;

    private static  Robot robot = null;
    /**
     * 当前屏幕截屏
     */
    private static BufferedImage screenShotImage = null;
//    private static  Map map = new LinkedHashMap<>();

    public static void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        try {
            screenShotImage = robot.createScreenCapture(new Rectangle(0, 0, width, height));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FindPsoUtil(){
    }

    public FindPsoUtil(String keyImagePath, String screenshot) {
        init();
        //读取目标图片
        keyImage = this.getBfImageFromPath(keyImagePath);
        //获取截屏RGB
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        //获取图片RGB
        keyImageRGBData = this.getImageGRB(keyImage);
        //获取截屏长宽
        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        //获取图片长宽
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();
        //开始查找
        this.findImageXY();
    }

    public FindPsoUtil(BufferedImage keyImage, String screenshot) {
        //获取截屏RGB
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        //获取图片RGB
        keyImageRGBData = this.getImageGRB(keyImage);
        //获取截屏长宽
        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        //获取图片长宽
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();
        //开始查找
        this.findImageXY();
    }

    /**
     * 根据像素点定位
     * @author hrx
     */
    public void findImageXY() {
        //遍历屏幕截图像素点数据
        for (int y = 0; y < scrShotImgHeight - keyImgHeight; y++) {
            for (int x = 0; x < scrShotImgWidth - keyImgWidth; x++) {
                if ((keyImageRGBData[0][0] ^ screenShotImageRGBData[y][x]) == 0
                        && (keyImageRGBData[0][keyImgWidth - 1] ^ screenShotImageRGBData[y][x + keyImgWidth - 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][keyImgWidth - 1] ^ screenShotImageRGBData[y + keyImgHeight - 1][x + keyImgWidth - 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][0] ^ screenShotImageRGBData[y + keyImgHeight - 1][x]) == 0) {

                    boolean isFinded = isMatchAll(y, x);
                    //如果比较结果完全相同，则说明图片找到，填充查找到的位置坐标数据到查找结果数组。
                    if (isFinded) {
                        //0
                        int minY = y;
                        int maxY = y + keyImgHeight;
                        findY = ((minY + maxY) / 2);
                        //1
                        int minX = x;
                        int maxX = x + keyImgWidth;
                        findX = ((minX + maxX) / 2);
                    }
                }
            }
        }
    }


    /**
     * 根据图片获取IO
     * @author hrx
     */
    public BufferedImage getBfImageFromPath(String keyImagePath) {
        BufferedImage bfImage = null;
        try {
            ClassPathResource resource = new ClassPathResource(keyImagePath);
            File file = resource.getFile();
            bfImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    /**
     * 根据图片IO获取RGB
     * @author hrx
     */
    public int[][] getImageGRB(BufferedImage bfImage) {
        int width = bfImage.getWidth();
        int height = bfImage.getHeight();
        int[][] result = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                //使用getRGB(w, h)获取该点的颜色值是ARGB，而在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF。
                result[h][w] = bfImage.getRGB(w, h) & 0xFFFFFF;
            }
        }
        return result;
    }

    /**
     * 是否全部匹配
     * @author hrx
     * @param y
     * @param x
     * @return boolean
     */
    public boolean isMatchAll(int y, int x) {
        int biggerY = 0;
        int biggerX = 0;
        int xor = 0;
        for (int smallerY = 0; smallerY < keyImgHeight; smallerY++) {
            biggerY = y + smallerY;
            for (int smallerX = 0; smallerX < keyImgWidth; smallerX++) {
                biggerX = x + smallerX;
                if (biggerY >= scrShotImgHeight || biggerX >= scrShotImgWidth) {
                    return false;
                }
                xor = keyImageRGBData[smallerY][smallerX] ^ screenShotImageRGBData[biggerY][biggerX];
                if (xor != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static TwoTuple<Integer, Integer> findPoint(String path){
        FindPsoUtil demo = new FindPsoUtil(path,"");
        System.out.println("找到:" + demo.findX + "," + demo.findY);
        return new TwoTuple<>(demo.findX, demo.findY);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        TwoTuple<Integer, Integer> point = findPoint("picture.city/SU_ZHOU.png");
        // 移动五次以上才会比较精确
        for (int i = 0; i < 10; i++) {
            robot.mouseMove(point.x, point.y);
        }
    }
}
