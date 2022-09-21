package com.hrx.util;

import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.elf.GlobalSetting;
import com.qiyou.javaelf.system.Elf;
import org.jawin.COMException;

import java.io.IOException;

/**
 * @author hrx
 */
public class DaMoApiTest {

    public static void main(String[] args) throws Exception {
        GlobalSetting.copy_dlls();
        Elf.init();//全局只调用一次,提供带参的方法自定义dm版本;
        Elf elf = new Elf();
        //绑定窗口
        DaMoApi.bindWindow(elf, 3478068);
        //移动鼠标
        //DaMoApi.moveMouse(dmCom, 355,180);
        //等1S
        //鼠标左击
        //DaMoApi.leftClick(dmCom);
        /*DaMoApi.rightClick(dmCom);
        Thread.sleep(1000);
        DaMoApi.moveMouse(dmCom, 382,225);
        Thread.sleep(1000);
        DaMoApi.leftClick(dmCom);*/
        //DaMoApi.keyPress(dmCom, KeyEvent.VK_A);

        DaMoApi.setPath(elf);



        TwoTuple<Integer, Integer> xy = DaMoApi.findStr(elf, 0,0, 2000,2000, "九", "380000-000000|d28a38-000000|f5af62-000000|388ad2-000000");
        DaMoApi.moveMouse(elf, xy.x,xy.y);
        Thread.sleep(1000);
    }

}
