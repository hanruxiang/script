package com.hrx.test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.awt.*;

/**
 * @author hrx
 */
public class TestDM {

    public static void main(String args[]) throws AWTException {
        //将当前Java线程初始化为STA单线程单元(影响Java-dll数据通信)
        ComThread.InitSTA();

        //利用ActiveXComponent实例化一个大漠组件对象
        ActiveXComponent dm = new ActiveXComponent("dm.dmsoft");
        //创建连接&调用对象Dispatch的实例
        Dispatch dmCom = dm.getObject();
        //通过Dispatch调用大漠dll中的Ver方法，并以Variant接受返回结果，此处为版本号
        Variant variant = Dispatch.call(dmCom, "Ver");
        System.out.println(variant.toString());

        ComThread.Release();//从Com中释放Java线程资源
    }

}
