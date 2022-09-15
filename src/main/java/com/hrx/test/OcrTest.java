package com.hrx.test;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.TessBaseAPI;

/**
 * orc图片识别
 * @author hrx
 */
public class OcrTest {

    public static String OCR(String lng, String dataPath, String imagePath) {
        TessBaseAPI api = new TessBaseAPI();
        if (api.Init(dataPath, lng) != 0){
            System.out.println("error");
        }
        PIX image= lept.pixRead(imagePath);
        if (image==null){
            return "";
        }
        api.SetImage(image);
        BytePointer outText = api.GetUTF8Text();
        String result = outText.getString();
        api.End();
        outText.deallocate();
        lept.pixDestroy(image);
        return result;
    }

    public static void main(String[] args) {
        String text= OCR("eng", "C:\\Users\\jianghui\\Desktop\\tl\\myscript", "C:\\Users\\jianghui\\Desktop\\tl\\test08.png");
        System.out.println(text);
    }
}
