package com.hrx.util;

import java.util.Random;

/**
 * @author hrx
 */
public class RandomUtil {

    public static Integer getRandomInt(Integer min, Integer max) {
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }

}
