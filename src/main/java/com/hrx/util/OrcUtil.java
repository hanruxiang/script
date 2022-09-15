package com.hrx.util;

import cn.hutool.core.io.resource.ClassPathResource;
import org.bytedeco.javacpp.*;
import org.bytedeco.leptonica.*;
import org.bytedeco.tesseract.*;

import java.io.File;

import static org.bytedeco.leptonica.global.lept.*;

/**
 * @author hrx
 */
public class OrcUtil {
    public static String ocr(String language,String dataPath, String imageUrl) {
        ClassPathResource resource = new ClassPathResource(dataPath);
        File dataFile = resource.getFile();
        String dataAbsolutePath = dataFile.getAbsolutePath();

        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();

        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(dataAbsolutePath, language) != 0) {
            System.err.println("Could not initialize tesseract.");
            return null;
        }

        // Open input image with leptonica library
        PIX image = pixRead(imageUrl);
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        try {
            return outText.getString();
        }finally{
            // Destroy used object and release memory
            api.End();
            outText.deallocate();
            pixDestroy(image);
        }
    }

    public static void main(String[] args) {
        //填写语言包eng.traineddata的目录路径以及要识别的图片路径
        String ret= ocr("eng","C:\\Users\\jianghui\\Desktop\\tl\\myscript", "C:\\Users\\jianghui\\Desktop\\tl\\test08.png");
        System.out.println("OCR output:\n" +ret);
    }


}