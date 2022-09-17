package com.hrx.util;

import com.hrx.common.TwoTuple;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

import java.awt.event.KeyEvent;

/**
 * @author hrx
 */
public class DaMoApiTest {

    public static void main(String[] args) throws InterruptedException {
        //将当前Java线程初始化为STA单线程单元(影响Java-dll数据通信)
        ComThread.InitSTA();
        //利用ActiveXComponent实例化一个大漠组件对象
        ActiveXComponent dm = new ActiveXComponent("dm.dmsoft");
        //创建连接&调用对象Dispatch的实例
        Dispatch dmCom = dm.getObject();
        //绑定窗口
        DaMoApi.bindWindow(dmCom, 3478068);
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

        DaMoApi.setPath(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data");

      /*  TwoTuple<Integer, Integer> xy = DaMoApi.findPic(dmCom, 0,0, 2000,2000, "eee.bmp", "000000");
        DaMoApi.moveMouse(dmCom, xy.x,xy.y);
        Thread.sleep(1000);*/

        DaMoApi.setDict(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data\\ziku.txt");

        TwoTuple<Integer, Integer> xy = DaMoApi.findStr(dmCom, 0,0, 2000,2000, "九", "380000-000000|d28a38-000000|f5af62-000000|388ad2-000000");
        DaMoApi.moveMouse(dmCom, xy.x,xy.y);
        Thread.sleep(1000);
    }

}
