package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

/**
 * @author hrx
 */
public class AutoPickUpBagsUtil {

    public static void autoPickUp(Elf elf) throws InterruptedException {
        //1、判断是不是有包裹
        while (checkIsFind(DaMoApi.findPic(elf, 0, 0, 2000, 2000, CommonConstants.PictureConstants.包裹图片, "000000"))) {
            //2、点击包裹
            MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.包裹图片);
            //3、点击全部拾取
            MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.包裹图片);
        }
    }

    public static boolean checkIsFind(TwoTuple<Integer, Integer> point) {
        if (-1 != point.x &&  -1 != point.y) {
            return false;
        }
        return true;
    }


}
