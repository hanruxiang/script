package com.hrx.util;

import com.hrx.common.CommonConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片工具类
 * @author hrx
 */
public class ImageUtil {

    public static String getInfoByScreenPoint(int[] xy) throws Exception {
        //1、获取截图
        BufferedImage screenImage = ScreenUtil.getScreenImage(xy);
        //2、保存图片 todo
        String path = createImage("tempName.png", screenImage);
        //3、解析图片文字
        String name = OrcUtil.ocr("eng", CommonConstants.SystemConstants.ORC_DATA_ENG_PATH, path);
        //4、删除图片
        File file =new File(path);
        file.delete();
        return name;
    }

    public static String createImage(String imageName, BufferedImage image) throws IOException {
        //将缓存里面的屏幕信息以图片的格式存在制定的磁盘位置
        ImageIO.write(image, getFileSuffix(imageName), new File(CommonConstants.SystemConstants.ORC_BUFFER_IMAGE_AREA, imageName));
        return CommonConstants.SystemConstants.ORC_BUFFER_IMAGE_AREA + imageName;
    }

    public static String getFileSuffix(String path){
        String[] split = path.split("\\.");
        return split[split.length-1];
    }
}
