package com.hrx.common;

import com.hrx.character.City;
import com.hrx.character.Npc;

/**
 * 基础常量
 * @author hrx
 */
public class CommonConstants {

    public static final Integer ZERO = 0;


    public static class CityConstants {

        /**
         * 苏州 苏州的图片 世界地图截取
         */
        public static final City SU_ZHOU = new City("苏州", "", "picture.city/SU_ZHOU.png");
    }

    public static class NpcConstants {

        /**
         * 吴玠
         * 苏州坐标：130,132
         * 屏幕坐标：todo
         */
        public static final Npc 吴玠 = new Npc("吴玠", CityConstants.SU_ZHOU, 130, 132, 130,132);

    }

    public static class PictureConstants {

        /**
         * 自动寻路按钮图片地址 todo
         */
        public static final String 自动寻路按钮 = "picture.button/AUTO_GO_BUTTON.png";

        /**
         * 自动寻路坐标输入框图片地址 todo
         */
        public static final String 自动寻路坐标输入框 = "picture.common/auto_run_text.png";

    }

    public static class ScreenXyConstants {

        /**
         * 左上角的横坐标,左上角的纵坐标,右下角的横坐标,右下角的纵坐标
         * 角色名称截屏位置 todo
         */
        public static final int[] 角色名称截屏位置 = {100,29,255,75};

        /**
         * 左上角的横坐标,左上角的纵坐标,右下角的横坐标,右下角的纵坐标
         * 场景名称截屏位置 todo
         */
        public static final int[] 场景名称截屏位置 = {1729,41,1829,67};

    }

    public static class SystemConstants {

        /**
         * ORC翻译数据包存放路径-eng todo
         */
        public static final String ORC_DATA_ENG_PATH = "orc.data";

        /**
         * ORC临时图片存放目录 todo
         */
        public static final String ORC_BUFFER_IMAGE_AREA = "C:\\Users\\jianghui\\Desktop\\tl\\myscript\\image\\";

        /**
         * 角色图片地址- todo
         */
        public static final String ROLE_INFO_PICTURE_PATH = "picture.role";

    }

}
