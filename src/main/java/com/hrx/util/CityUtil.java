package com.hrx.util;

import com.hrx.character.City;
import com.hrx.common.CommonConstants;

/**
 * 城市util
 * @author hrx
 */
public class CityUtil {

    public static City getCurrentCity() throws Exception {
        String cityName = ImageUtil.getInfoByScreenPoint(CommonConstants.ScreenXyConstants.场景名称截屏位置);
        City city = new City(cityName, "", "");
        return city;
    }

    public static void main(String[] args) throws Exception {
        getCurrentCity();
    }

}
