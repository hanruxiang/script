package com.hrx.common;

import com.hrx.character.City;
import com.hrx.character.Npc;
import com.hrx.util.*;
import com.qiyou.javaelf.system.Elf;

import java.awt.event.KeyEvent;

/**
 * 基础常量
 * @author hrx
 */
public class CommonConstants {

    public static final Integer ZERO = 0;

    public static final String ONE_STRING = "1";

    public static final String EMPTY_STRING = "";

    public static class CityConstants {

        /**
         * 苏州 苏州的图片 世界地图截取 todo
         */
        public static final City SU_ZHOU = new City("苏州", "SU_ZHOU_TEXT.bmp", "su_zhou.bmp");
    }

    public static class NpcConstants {

        /**
         * 吴玠
         * 苏州坐标：130,132
         * 屏幕坐标：todo
         */
        public static final Npc 吴玠 = new Npc("吴玠", CityConstants.SU_ZHOU, 130, 132, 298,401, "惩恶打图.bmp"){
            @Override
            public void doTask(Elf elf) throws Exception{
                //1、鼠标点击NPC坐标
                MouseUtil.moveAndClick(elf, getScreenX(), getScreenY());
                //2、点击惩恶打图任务图片
                MouseUtil.findPictureAnkLeftClick(elf, getTaskPicture());
                //3、点击继续按钮 交任务
                TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf, 0, 0, 2000, 2000, CommonConstants.PictureConstants.继续, "000000");
                if (-1 != point.x &&  -1 != point.y) {
                    DaMoApi.moveMouse(elf, point.x, point.y);
                    DaMoApi.leftClick(elf);
                    DaMoApi.leftClick(elf);
                    //1、鼠标点击NPC坐标
                    MouseUtil.moveAndClick(elf, getScreenX(), getScreenY());
                    //2、点击惩恶打图任务图片
                    MouseUtil.findPictureAnkLeftClick(elf, getTaskPicture());
                }
                //3、打开背包
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.打开包裹快捷键);
                //4、切换到任务物品
                MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.背包任务物品栏目);
                //5、右击打图令牌
                MouseUtil.findPictureAnkRightClick(elf, CommonConstants.PictureConstants.惩恶令牌);
                //6、点击坐标
                MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.打图坐标);
                //7、点击确认按钮
                MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.去往场景确认按钮);
                //8、确认是否已经到达 todo
                Thread.sleep(120000);
                //9、点击坐骑按钮
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.坐骑快捷键);
                //10、到达了使用隐身技能
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.隐身快捷键);
                //11、打开背包
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.打开包裹快捷键);
                //12、切换到任务物品
                MouseUtil.findPictureAnkLeftClick(elf, CommonConstants.PictureConstants.背包任务物品栏目);
                //13、右击打图令牌
                MouseUtil.findPictureAnkRightClick(elf, CommonConstants.PictureConstants.惩恶令牌);
                //14、加血
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.药品快捷键);
                //15、选择目标怪打
                AttackUtil.autoChooseAttack(elf, CommonConstants.PictureConstants.打图目标怪图片, 1);
                //16、捡包裹
                AutoPickUpBagsUtil.autoPickUp(elf);
                //17、使用隐身技能
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.隐身快捷键);
                //18、点击坐骑按钮
                KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.坐骑快捷键);
            }
        };

    }

    public static class PictureConstants {

        /**
         * 自动寻路按钮图片
         */
        public static final String 自动寻路按钮 = "自动寻路按钮.bmp";

        /**
         * 自动寻路坐标输入框图片
         */
        public static final String 自动寻路坐标输入框 = "自动寻路坐标.bmp";

        /**
         * 背包任务物品栏目框图片
         */
        public static final String 背包任务物品栏目 = "背包任务物品栏.bmp";

        /**
         * 继续
         */
        public static final String 继续 = "继续.bmp";

        /**
         * 确认 todo
         */
        public static final String 确认 = "确认.bmp";

        /**
         * 完成
         */
        public static final String 完成 = "完成.bmp";

        /**
         * 惩恶令牌图片
         */
        public static final String 惩恶令牌 = "惩恶令牌.bmp";

        /**
         * 打图坐标
         */
        public static final String 打图坐标 = "打图坐标.bmp";

        /**
         * 去往场景确认按钮
         */
        public static final String 去往场景确认按钮 = "去往场景确认按钮.bmp";

        /**
         * 打图目标怪图片
         */
        public static final String 打图目标怪图片 = "打图目标怪.bmp";

        /**
         * 包裹图片 todo
         */
        public static final String 包裹图片 = "包裹图片.bmp";

    }

    public static class KeyboardConstants {

        /**
         * 平A健
         */
        public static final Integer 平A健 = KeyEvent.VK_F1;

        /**
         * 坐骑快捷键
         */
        public static final Integer 坐骑快捷键 = KeyEvent.VK_F8;

        /**
         * 药品快捷键
         */
        public static final Integer 药品快捷键 = KeyEvent.VK_F9;

        /**
         * 隐身快捷键
         */
        public static final Integer 隐身快捷键 = KeyEvent.VK_F10;

        /**
         * 自动选择目标快捷键
         */
        public static final Integer 自动选择目标 = KeyEvent.VK_F11;

        /**
         * 打开世界地图
         */
        public static final int[] 打开世界地图快捷键 = new int[]{KeyEvent.VK_ALT, KeyEvent.VK_M};

        /**
         * 自动寻路快捷键
         */
        public static final int[] 自动寻路快捷键 = new int[]{KeyEvent.VK_ALT, 192};

        /**
         * 打开包裹快捷键
         */
        public static final int[] 打开包裹快捷键 = new int[]{KeyEvent.VK_ALT, KeyEvent.VK_A};

    }

    /**
     * 大漠脚本相关配置
     */
    public static class DaMoConstants {

        /**
         * 屏幕模式 字符串："normal"(前台模式) "gdi"(后台模式)
         */
        public static final String SCREEN_MODEL = "normal";

        /**
         * 鼠标模式 字符串："normal"(前台模式) "windows"(后台模式)
         */
        public static final String MOUSE_MODEL = "normal";

        /**
         * 键盘模式 字符串："normal"(前台模式) "windows"(后台模式)
         */
        public static final String KEYPAD_MODEL = "normal";

        /**
         * mode 模式 整形数：默认0
         */
        public static final Integer MODEL = 0;

        /**
         * 窗口1句柄
         */
        private static final String WINDOWS_01 = "窗口1";

        /**
         * 窗口2句柄
         */
        private static final String WINDOWS_02 = "窗口2";

    }


}
