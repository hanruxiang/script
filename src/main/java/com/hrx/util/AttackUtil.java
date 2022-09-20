package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

/**
 * 打怪util
 * @author hrx
 */
public class AttackUtil {

    public static void autoChooseAttack(Elf elf, String monsterPicture, Integer num) throws Exception {
        int time = 0;
        for (int i =1 ; i <= 2 ; i++) {
            //1、选择目标
            KeyboardUtil.keyPress(CommonConstants.KeyboardConstants.自动选择目标);
            //2、判断是否目标怪
            TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf, 0, 0, 2000, 2000, monsterPicture, "000000");
            if (-1 == point.x &&  -1 == point.y) {
                continue;
            }
            //3、攻击
            KeyboardUtil.keyPress(CommonConstants.KeyboardConstants.平A健);
            //4、等待打完
            Thread.sleep(10*1000);
            time ++;
            if (time == num) {
                return;
            }
        }
    }
}
