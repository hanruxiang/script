package com.hrx.job;

import com.hrx.character.GameRole;
import com.hrx.common.CommonConstants;
import com.hrx.util.DaMoApi;
import com.hrx.util.KeyboardUtil;
import com.hrx.util.RandomUtil;
import com.qiyou.javaelf.system.Elf;
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
        Elf.init();//全局只调用一次,提供带参的方法自定义dm版本;
        new Thread(() ->{
            try {
                Elf elf = new Elf();
                //绑定窗口
                DaMoApi.bindWindow(elf, 591866);
                DaMoApi.setPath(elf);
                Thread.sleep(2000);
                //执行任务
                doJob(elf,"Integer");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void doJob(Elf elf, String roleName) throws Exception {
        Thread.sleep(RandomUtil.getRandomInt(1000, 2000));
        //1、匹配角色
        GameRole currentRole = new GameRole(roleName, elf);
        //2、点击坐骑按钮
        KeyboardUtil.keyPressMore(elf, CommonConstants.KeyboardConstants.坐骑快捷键);
        for (int i = 1; i < 50; i++) {
            Thread.sleep(RandomUtil.getRandomInt(1000, 3000));
            //3、找到NPC
            currentRole.moveToNpc(CommonConstants.NpcConstants.吴玠);
            //4、做任务
            currentRole.doTask(CommonConstants.NpcConstants.吴玠, elf);
        }
    }

    private static GameRole getRoleByName(String roleName, Elf elf) throws Exception {
        GameRole newGameRole;
        if (null == gameRoles || CommonConstants.ZERO == gameRoles.size()) {
            newGameRole = new GameRole(roleName, elf);
            gameRoles.add(newGameRole);
            return newGameRole;
        }
        for (GameRole gameRole : gameRoles) {
            if (roleName.equals(gameRole.getName())) {
                newGameRole = gameRole;
                return newGameRole;
            }
        }
        newGameRole = new GameRole(roleName, elf);
        gameRoles.add(newGameRole);
        return newGameRole;
    }

    public static void execute(String code, String ver) throws Exception {
        //1、全局只调用一次,提供带参的方法自定义dm版本;
        Elf.init();
        Elf elf = new Elf();
        //2、登录
        DaMoApi.reg(elf, code, ver);
        //3、枚举窗口
        String windowHandleStr = DaMoApi.enumWindows(elf);
        String[] windowHandleList = windowHandleStr.split(",");
        for (String windowHandle : windowHandleList) {
            new Thread(() ->{
                try {
                    //4、绑定窗口
                    DaMoApi.bindWindow(elf, Integer.valueOf(windowHandle));
                    DaMoApi.setPath(elf);
                    Thread.sleep(2000);
                    //5、执行任务
                    doJob(elf,"role");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
