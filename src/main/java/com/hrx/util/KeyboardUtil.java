package com.hrx.util;

import com.qiyou.javaelf.system.Elf;

/**
 * @author hrx
 */
public class KeyboardUtil {

    /**
     * 单个按键
     * @param key
     * @param elf
     */
    public static void keyPress(Elf elf, int key) throws Exception {
        DaMoApi.keyPress(elf, key);
        DaMoApi.keyUp(elf, key);
        Thread.sleep(100);
        Thread.sleep(1000);
    }

    /**
     * 多个按键配合快捷键
     * @param elf
     * @param keys
     */
    public static void keyPressMore(Elf elf, int ...keys) throws Exception {
        for (int i = 0; i < keys.length; i++) {
            DaMoApi.keyPress(elf, keys[i]);
            Thread.sleep(100);
        }
        for (int i = 0; i < keys.length; i++) {
            DaMoApi.keyUp(elf, keys[i]);
            Thread.sleep(100);
        }
        // 等待动画时间
        Thread.sleep(1200);
    }


    public static void write(Elf elf, String str) throws Exception {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        DaMoApi.keyPressStr(elf, str);
    }


}
