package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.awt.event.KeyEvent;

/**
 * 大漠APi
 * @author hrx
 */
public class DaMoApi {

    /**
     * 綁定窗口
     * @param dmCom 大漠对象
     * @param hwnd 窗口句柄
     * @return
     */
    public static boolean bindWindow(Dispatch dmCom, Integer hwnd) {
        /**
         * 通过Dispatch调用大漠dll中的BindWindow方法，并以Variant接受返回结果
         * long BindWindow(hwnd,display,mouse,keypad,mode)
         * hwnd 整形数: 指定的窗口句柄
         * display 屏幕模式 字符串："normal"(前台模式) "gdi"(后台模式)
         * mouse 鼠标模式 字符串："normal"(前台模式) "windows"(后台模式)
         * keypad 键盘模式 字符串："normal"(前台模式) "windows"(后台模式)
         * mode 模式 整形数：默认0
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "BindWindowEx",
                hwnd,
                CommonConstants.DaMoConstants.SCREEN_MODEL,
                CommonConstants.DaMoConstants.MOUSE_MODEL,
                CommonConstants.DaMoConstants.KEYPAD_MODEL,
                "dx.public.disable.window.position",
                CommonConstants.DaMoConstants.MODEL
        );
        System.out.println("绑定窗口成功,窗口句柄:" + hwnd);
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }


    /**
     * 移动鼠标
     * @param dmCom 大漠对象
     * @param x X坐标
     * @param y Y坐标
     * @return
     */
    public static boolean moveMouse(Dispatch dmCom, Integer x, Integer y) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(3000, 3500));
        /**
         * 通过Dispatch调用大漠dll中的long MoveTo(x,y)方法，并以Variant接受返回结果
         * x 整形数:X坐标
         * y 整形数:Y坐标
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "MoveTo",
                x,
                y
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }

    /**
     * 左击
     * @param dmCom 大漠对象
     * @return
     */
    public static boolean leftClick(Dispatch dmCom) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(3000, 3500));
        /**
         * 通过Dispatch调用大漠dll中的long MoveTo(x,y)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "LeftClick"
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }

    /**
     * 左双击
     * @param dmCom 大漠对象
     * @return
     */
    public static boolean leftDoubleClick(Dispatch dmCom) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long LeftDoubleClick()方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "LeftDoubleClick"
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }

    /**
     * 右击
     * @param dmCom 大漠对象
     * @return
     */
    public static boolean rightClick(Dispatch dmCom) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long RightClick()方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "RightClick"
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }

    /**
     * 按下键盘
     * @param dmCom 大漠对象
     * @return
     */
    public static boolean keyPress(Dispatch dmCom, Integer vkCode) {
        /**
         * 通过Dispatch调用大漠dll中的long KeyPress(vk_code)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "KeyPress",
                vkCode
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }

    /**
     * 指定区域找色
     * @param dmCom 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findMultiColor(Dispatch dmCom,
                                          Integer x1,
                                          Integer y1,
                                          Integer x2,
                                          Integer y2,
                                          String firstColor,
                                          String offsetColor) {
        /**
         * 通过Dispatch调用大漠dll中的long FindMultiColor(x1, y1, x2, y2,first_color,offset_color,sim, dir,intX,intY)方法，并以Variant接受返回结果
         * first_color 字符串:颜色格式为"RRGGBB-DRDGDB|RRGGBB-DRDGDB|…………",比如"123456-000000"
         *   这里的含义和按键自带Color插件的意义相同，只不过我的可以支持偏色和多种颜色组合
         *   所有的偏移色坐标都相对于此颜色.注意，这里只支持RGB颜色.
         * offset_color 字符串: 偏移颜色可以支持任意多个点 格式和按键自带的Color插件意义相同, 只不过我的可以支持偏色和多种颜色组合
         *   格式为"x1|y1|RRGGBB-DRDGDB|RRGGBB-DRDGDB……,……xn|yn|RRGGBB-DRDGDB|RRGGBB-DRDGDB……"
         *   比如"1|3|aabbcc|aaffaa-101010,-5|-3|123456-000000|454545-303030|565656"等任意组合都可以，支持偏色
         *   还可以支持反色模式，比如"1|3|-aabbcc|-334455-101010,-5|-3|-123456-000000|-353535|454545-101010","-"表示除了指定颜色之外的颜色.
         *
         *
         * sim 双精度浮点数:相似度,取值范围0.1-1.0
         * dir 整形数:查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
         * intX 变参指针:返回X坐标(坐标为first_color所在坐标)
         * intY 变参指针:返回Y坐标(坐标为first_color所在坐标)
         *
         */
        Variant vars[] = new Variant[10];
        vars[0] = new Variant(x1,true);
        vars[1] = new Variant(y1,true);
        vars[2] = new Variant(x2,true);
        vars[3] = new Variant(y2,true);
        vars[4] = new Variant(firstColor,true);
        vars[5] = new Variant(offsetColor,true);
        vars[6] = new Variant(0.9,true);
        vars[7] = new Variant(0,true);
        vars[8] = new Variant(-1,true);
        vars[9] = new Variant(-1,true);

        Variant variant = Dispatch.call(
                dmCom,
                "FindMultiColor",
                vars
        );
        System.out.println("variant : " + variant.toString());
        System.out.println("兑点找图坐标，x : " + vars[8] + "  y : " + vars[9]);
        return new TwoTuple(vars[8].getInt(), vars[9].getInt());
    }


    /**
     * 指定区域找色
     * @param dmCom 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findPic(Dispatch dmCom,
                                                            Integer x1,
                                                            Integer y1,
                                                            Integer x2,
                                                            Integer y2,
                                                            String picName,
                                                            String deltaColor) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * x1 整形数:区域的左上X坐标
         * y1 整形数:区域的左上Y坐标
         * x2 整形数:区域的右下X坐标
         * y2 整形数:区域的右下Y坐标
         * pic_name 字符串:图片名,可以是多个图片,比如"test.bmp|test2.bmp|test3.bmp"
         * delta_color 字符串:颜色色偏比如"203040" 表示RGB的色偏分别是20 30 40 (这里是16进制表示). 如果这里的色偏是2位，表示使用灰度找图. 比如"20"
         * sim 双精度浮点数:相似度,取值范围0.1-1.0
         * dir 整形数:查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
         * intX 变参指针:返回图片左上角的X坐标
         * intY 变参指针:返回图片左上角的Y坐标
         *
         */
        Variant vars[] = new Variant[10];
        vars[0] = new Variant(x1,true);
        vars[1] = new Variant(y1,true);
        vars[2] = new Variant(x2,true);
        vars[3] = new Variant(y2,true);
        vars[4] = new Variant(picName,true);
        vars[5] = new Variant(deltaColor,true);
        vars[6] = new Variant(0.9,true);
        vars[7] = new Variant(0,true);
        vars[8] = new Variant(-1,true);
        vars[9] = new Variant(-1,true);

        Variant variant = Dispatch.call(
                dmCom,
                "FindPic",
                vars
        );
        System.out.println("variant : " + variant.toString());
        System.out.println("兑点找图坐标，x : " + vars[8] + "  y : " + vars[9]);
        return new TwoTuple(vars[8].getInt(), vars[9].getInt());
    }

    /**
     * 指定区域找字
     * @param dmCom 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findStr(Dispatch dmCom,
                                                     Integer x1,
                                                     Integer y1,
                                                     Integer x2,
                                                     Integer y2,
                                                     String string,
                                                     String colorFormat) {
        /**
         * x1 整形数:区域的左上X坐标
         * y1 整形数:区域的左上Y坐标
         * x2 整形数:区域的右下X坐标
         * y2 整形数:区域的右下Y坐标
         * string 字符串:待查找的字符串,可以是字符串组合，比如"长安|洛阳|大雁塔",中间用"|"来分割字符串
         * color_format 字符串:颜色格式串, 可以包含换行分隔符,语法是","后加分割字符串. 具体可以查看下面的示例 .注意，RGB和HSV,以及灰度格式都支持.
         * sim 双精度浮点数:相似度,取值范围0.1-1.0
         * intX 变参指针:返回X坐标没找到返回-1
         * intY 变参指针:返回Y坐标没找到返回-1
         *
         */
        Variant vars[] = new Variant[10];
        vars[0] = new Variant(x1,true);
        vars[1] = new Variant(y1,true);
        vars[2] = new Variant(x2,true);
        vars[3] = new Variant(y2,true);
        vars[4] = new Variant(string,true);
        vars[5] = new Variant(colorFormat,true);
        vars[6] = new Variant(0.9,true);
        vars[8] = new Variant(-1,true);
        vars[9] = new Variant(-1,true);

        Variant variant = Dispatch.call(
                dmCom,
                "FindStr",
                vars
        );
        System.out.println("variant : " + variant.toString());
        System.out.println("兑点找字坐标，x : " + vars[8] + "  y : " + vars[9]);
        return new TwoTuple(vars[8].getInt(), vars[9].getInt());
    }


    /**
     * 设置资源路径
     * @param dmCom 大漠对象
     * @param path 字符串: 路径,可以是相对路径,也可以是绝对路径
     * @return
     */
    public static boolean setPath(Dispatch dmCom, String path) {
        /**
         * 通过Dispatch调用大漠dll中的long SetPath(path)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "SetPath",
                path
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }
    /**
     * 设置字库路径
     * @param dmCom 大漠对象
     * @param file 字符串: 路径,可以是相对路径,也可以是绝对路径
     * @return
     */
    public static boolean setDict(Dispatch dmCom, String file) {
        /**
         * 通过Dispatch调用大漠dll中的long SetDict(index,file)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Variant variant = Dispatch.call(
                dmCom,
                "SetDict",
                0,
                file
        );
        return CommonConstants.ONE_STRING.equals(variant.toString());
    }


}
