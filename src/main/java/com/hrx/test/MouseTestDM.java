package com.hrx.test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class MouseTestDM {
    public static void main(String args[]){
        try{
            ComThread.InitSTA();//将当前Java线程初始化为STA单线程单元(影响Java-dll参数通信)
            ActiveXComponent axc = new ActiveXComponent("dm.dmsoft");
            Dispatch dmCom = (Dispatch)axc.getObject();

            //创建Variant参数数组接收Java-dll的数据通信
            Variant vars[] = new Variant[2];
            vars[0] = new Variant(-1,true);
            vars[1] = new Variant(-1,true);
            Variant variant = Dispatch.call(dmCom, "GetCursorPos",vars);
            System.out.println(variant);
            System.out.println("x="+vars[0]+",y="+vars[1]);

            ComThread.Release();//从Com中释放Java线程资源

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
