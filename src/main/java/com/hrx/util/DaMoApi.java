package com.hrx.util;

import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.operation.*;
import com.qiyou.javaelf.system.Elf;
import org.jawin.COMException;

import java.io.File;


/**
 * 大漠APi
 * @author hrx
 */
public class DaMoApi {


    /**
     * 注册
     * @param elf 大漠对象
     * @return
     */
    public static boolean reg(Elf elf, String code, String ver) throws COMException {
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
        int result = elf.Reg(code,ver);
        if (CommonConstants.ONE_STRING.equals(result + "")) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败！");
        }
        return CommonConstants.ONE_STRING.equals(result + "");
    }

    /**
     * 枚举窗口
     * @param elf 大漠对象
     * @return 窗口句柄
     */
    public static String enumWindows(Elf elf) {
        /**
         * 通过Dispatch调用大漠dll中的BindWindow方法，并以Variant接受返回结果
         * string EnumWindow(parent,title,class_name,filter)
         * parent 整形数: 获得的窗口句柄是该窗口的子窗口的窗口句柄,取0时为获得桌面句柄
         * title 字符串: 窗口标题. 此参数是模糊匹配.
         * class_name 字符串: 窗口类名. 此参数是模糊匹配.
         * filter整形数: 取值定义如下
         * 1 : 匹配窗口标题,参数title有效
         * 2 : 匹配窗口类名,参数class_name有效.
         * 4 : 只匹配指定父窗口的第一层孩子窗口
         * 8 : 匹配父窗口为0的窗口,即顶级窗口
         * 16 : 匹配可见的窗口
         * 32 : 匹配出的窗口按照窗口打开顺序依次排列
         * 这些值可以相加,比如4+8+16就是类似于任务管理器中的窗口列表
         *
         */
        Object[] params = new Object[]{
                0,
                "新天龙八部",
                "TianLongBaBuHJ WndClass",
                1+2
        };
        String result = elf.execute(Window.class, WindowOperations.EnumWindow, params).toString();
        if (!CommonConstants.EMPTY_STRING.equals(result)) {
            System.out.println("枚举窗口成功,窗口句柄:" + result);
        } else {
            System.out.println("枚举窗口失败！");
        }
        return result;
    }

    /**
     * 綁定窗口
     * @param elf 大漠对象
     * @param hwnd 窗口句柄
     * @return
     */
    public static boolean bindWindow(Elf elf, Integer hwnd) {
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
        Object[] params = new Object[]{
                hwnd,
                CommonConstants.DaMoConstants.SCREEN_MODEL,
                CommonConstants.DaMoConstants.MOUSE_MODEL,
                CommonConstants.DaMoConstants.KEYPAD_MODEL,
                CommonConstants.DaMoConstants.MODEL
        };
        String result = elf.execute(Background.class, BackgroundOperations.BindWindow, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("绑定窗口成功,窗口句柄:" + hwnd);
        } else {
            System.out.println("绑定窗口失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 綁定窗口
     * @param elf 大漠对象
     * @param hwnd 窗口句柄
     * @return
     */
    public static boolean bindWindowEx(Elf elf, Integer hwnd) {
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
        Object[] params = new Object[]{
                hwnd,
                CommonConstants.DaMoConstants.SCREEN_MODEL,
                "dx.mouse.position.lock.api|dx.mouse.position.lock.message|dx.mouse.clip.lock.api|dx.mouse.input.lock.api|dx.mouse.state.api|dx.mouse.api|dx.mouse.cursor",
                "dx.keypad.input.lock.api|dx.keypad.state.api|dx.keypad.api",
                "",
                CommonConstants.DaMoConstants.MODEL
        };
        String result = elf.execute(Background.class, BackgroundOperations.BindWindowEx, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("绑定窗口成功,窗口句柄:" + hwnd);
        } else {
            System.out.println("绑定窗口失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 移动鼠标
     * @param elf 大漠对象
     * @param x X坐标
     * @param y Y坐标
     * @return
     */
    public static boolean moveMouse(Elf elf, Integer x, Integer y) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long MoveTo(x,y)方法，并以Variant接受返回结果
         * x 整形数:X坐标
         * y 整形数:Y坐标
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{
                x,
                y
        };
        String result = elf.execute(Mouse.class, MouseOperations.MoveTo, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("鼠标移动成功");
        } else {
            System.out.println("鼠标移动失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 左击
     * @param elf 大漠对象
     * @return
     */
    public static boolean leftClick(Elf elf) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long MoveTo(x,y)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{};
        String result = elf.execute(Mouse.class, MouseOperations.LeftClick, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("鼠标左击成功");
        } else {
            System.out.println("鼠标左击失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 左双击
     * @param elf 大漠对象
     * @return
     */
    public static boolean leftDoubleClick(Elf elf) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long LeftDoubleClick()方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{};
        String result = elf.execute(Mouse.class, MouseOperations.LeftDoubleClick, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("鼠标左双击成功");
        } else {
            System.out.println("鼠标左双击失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 右击
     * @param elf 大漠对象
     * @return
     */
    public static boolean rightClick(Elf elf) throws InterruptedException {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
        /**
         * 通过Dispatch调用大漠dll中的long RightClick()方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{};
        String result = elf.execute(Mouse.class, MouseOperations.RightClick, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("鼠标右击成功");
        } else {
            System.out.println("鼠标右击失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 按下键盘
     * @param elf 大漠对象
     * @return
     */
    public static boolean keyPress(Elf elf, Integer vkCode) {
        /**
         * 通过Dispatch调用大漠dll中的long KeyPress(vk_code)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{vkCode};
        String result = elf.execute(Keyboard.class, KeyboardOperations.KeyPress, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("按下键盘成功");
        } else {
            System.out.println("按下键盘失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 弹起键盘
     * @param elf 大漠对象
     * @return
     */
    public static boolean keyUp(Elf elf, Integer vkCode) {
        /**
         * 通过Dispatch调用大漠dll中的long KeyPress(vk_code)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{vkCode};
        String result = elf.execute(Keyboard.class, KeyboardOperations.KeyUp, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("弹起键盘成功");
        } else {
            System.out.println("弹起键盘失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }

    /**
     * 根据指定的字符串序列，依次按顺序按下其中的字符.
     * @param elf 大漠对象
     * @return
     */
    public static boolean keyPressStr(Elf elf, String str) {
        /**
         * 通过Dispatch调用大漠dll中的long KeyPressStr(key_str,delay)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{str};
        String result = elf.execute(Keyboard.class, KeyboardOperations.KeyPressStr, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("键盘输入成功");
        } else {
            System.out.println("键盘输入失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }


    /**
     * 指定区域找色
     * @param elf 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findMultiColor(Elf elf,
                                          Integer x1,
                                          Integer y1,
                                          Integer x2,
                                          Integer y2,
                                          String firstColor,
                                          String offsetColor) throws Exception {
        Thread.sleep(RandomUtil.getRandomInt(1000, 1500));
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
        Integer x = new Integer(-1);
        Integer y = new Integer(-1);
        Object[] params = new Object[]{
                x1,
                y1,
                x2,
                y2,
                firstColor,
                offsetColor,
                0.9,
                0,
                x,
                y};
        elf.execute(Picture.class, PictureOperations.FindMultiColor, params).toString();
        System.out.println("指定区域找色坐标，x : " + x + "  y : " + x);
        return new TwoTuple(x, y);
    }


    /**
     * 指定区域找图
     * @param elf 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findPic(Elf elf,
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
        Integer x = new Integer(-1);
        Integer y = new Integer(-1);
        Object[] params = new Object[]{
                x1,
                y1,
                x2,
                y2,
                picName,
                deltaColor,
                0.9,
                0,
                x,
                y};
        elf.execute(Picture.class, PictureOperations.FindPic, params).toString();
        System.out.println("指定区域找图坐标，x : " + x + "  y : " + x);
        return new TwoTuple(x, y);
    }

    /**
     * 指定区域找字
     * @param elf 大漠对象
     * @return
     */
    public static TwoTuple<Integer, Integer> findStr(Elf elf,
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

        Integer x = new Integer(-1);
        Integer y = new Integer(-1);
        Object[] params = new Object[]{
                x1,
                y1,
                x2,
                y2,
                string,
                colorFormat,
                0.9,
                0,
                x,
                y};
        elf.execute(Ocr.class, OcrOperations.FindStr, params).toString();
        System.out.println("指定区域找字坐标，x : " + x + "  y : " + x);
        return new TwoTuple(x, y);
    }

    /**
     * 设置资源路径
     * @param elf 大漠对象
     * @return
     */
    public static boolean setPath(Elf elf) throws Exception {
        /**
         * 通过Dispatch调用大漠dll中的long SetPath(path)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        String imagesPath = System.getProperty("java.home")+"/bin/image";
        int result = elf.SetPath(new File(imagesPath).getCanonicalPath());
        if (CommonConstants.ONE_STRING.equals(result + "")) {
            System.out.println("设置资源路径成功");
        } else {
            System.out.println("设置资源路径失败！");
        }
        return CommonConstants.ONE_STRING.equals(result + "");
    }

    /**
     * 设置字库路径
     * @param elf 大漠对象
     * @param file 字符串: 路径,可以是相对路径,也可以是绝对路径
     * @return
     */
    public static boolean setDict(Elf elf, String file) {
        /**
         * 通过Dispatch调用大漠dll中的long SetDict(index,file)方法，并以Variant接受返回结果
         * 返回值: 整形数: 0: 失败 1: 成功
         *
         */
        Object[] params = new Object[]{file};
        String result = elf.execute(Ocr.class, OcrOperations.SetDict, params).toString();
        if (CommonConstants.ONE_STRING.equals(result)) {
            System.out.println("设置字库路径成功");
        } else {
            System.out.println("设置字库路径失败！");
        }
        return CommonConstants.ONE_STRING.equals(result);
    }


}
