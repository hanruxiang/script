package com.hrx.test;

import com.qiyou.javaelf.elf.GlobalSetting;
import com.qiyou.javaelf.operation.Background;
import com.qiyou.javaelf.operation.BackgroundOperations;
import com.qiyou.javaelf.system.Elf;
import org.jawin.COMException;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws COMException, IOException {
        GlobalSetting.copy_dlls();
        Elf.init();//全局只调用一次,提供带参的方法自定义dm版本;
        Elf elf = new Elf();
        System.out.println(elf.Ver()); //打印版本 7.2043
        Object[] params = new Object[]{ 591866,"dx2","windows","windows", 0 };
        String res = elf.execute(Background.class, BackgroundOperations.BindWindow, params).toString();
        System.out.printf(res);
    }
}
