package com.hrx.job;

import com.hrx.character.GameRole;
import com.hrx.common.CommonConstants;
import com.hrx.util.DaMoApi;
import com.hrx.util.LoginUtil;
import com.hrx.util.MouseUtil;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 打图
 * @author hrx
 */
public class DaTuJob {

    /**
     * 游戏角色集合
     */
    private static List<GameRole> gameRoles = new ArrayList<>(16);

    public static void main(String[] args) throws Exception {
        new Thread(() ->{
            try {
                //将当前Java线程初始化为STA单线程单元(影响Java-dll数据通信)
                ComThread.InitSTA();
                //利用ActiveXComponent实例化一个大漠组件对象
                ActiveXComponent dm = new ActiveXComponent("dm.dmsoft");
                //创建连接&调用对象Dispatch的实例
                Dispatch dmCom = dm.getObject();
                //绑定窗口
                DaMoApi.bindWindow(dmCom, 198840);
                DaMoApi.setPath(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data");
                //DaMoApi.setDict(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data\\ziku.txt");
                Thread.sleep(2000);
                //执行任务
                doJob(dmCom,"Bigdecimal");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
   /*     new Thread(() ->{
            try {
                //将当前Java线程初始化为STA单线程单元(影响Java-dll数据通信)
                ComThread.InitSTA();
                //利用ActiveXComponent实例化一个大漠组件对象
                ActiveXComponent dm = new ActiveXComponent("dm.dmsoft");
                //创建连接&调用对象Dispatch的实例
                Dispatch dmCom = dm.getObject();
                //绑定窗口
                DaMoApi.bindWindow(dmCom, 1511302);
                DaMoApi.setPath(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data");
                //DaMoApi.setDict(dmCom, "D:\\hanruxiang\\code\\script\\src\\main\\resources\\data\\ziku.txt");
                Thread.sleep(2000);
                //执行任务
                doJob(dmCom, "Integer");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/
    }


    private static void doJob(Dispatch dmCom, String roleName) throws Exception {
        Thread.sleep(2000);
        //1、匹配角色
        GameRole currentRole = new GameRole(roleName, dmCom);
        //2、点击坐骑按钮
        MouseUtil.findPictureAnkLeftClick(dmCom, CommonConstants.PictureConstants.坐骑按钮);
        for (int i = 1; i < 50; i++) {
            Thread.sleep(3000);
            //3、找到NPC
            currentRole.moveToNpc(CommonConstants.NpcConstants.吴玠);
            //4、做任务
            currentRole.doTask(CommonConstants.NpcConstants.吴玠, dmCom);
        }

    }

    private static GameRole getRoleByName(String roleName, Dispatch dmCom) throws Exception {
        GameRole newGameRole;
        if (null == gameRoles || CommonConstants.ZERO == gameRoles.size()) {
            newGameRole = new GameRole(roleName, dmCom);
            gameRoles.add(newGameRole);
            return newGameRole;
        }
        for (GameRole gameRole : gameRoles) {
            if (roleName.equals(gameRole.getName())) {
                newGameRole = gameRole;
                return newGameRole;
            }
        }
        newGameRole = new GameRole(roleName, dmCom);
        gameRoles.add(newGameRole);
        return newGameRole;
    }

}
