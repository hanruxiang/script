package com.hrx.job;

import com.hrx.character.GameRole;
import com.hrx.common.CommonConstants;
import com.hrx.util.LoginUtil;

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
        Thread.sleep(2000);
        //1、获取当前角色名称
        String currentScreenGameRoleName = LoginUtil.getCurrentScreenGameRole();
        //2、匹配角色
        GameRole currentRole = getRoleByName(currentScreenGameRoleName);
        //3、找到NPC
        currentRole.moveToNpc(CommonConstants.NpcConstants.吴玠);
    }

    private static GameRole getRoleByName(String roleName) throws Exception {
        GameRole newGameRole;
        if (null == gameRoles || CommonConstants.ZERO == gameRoles.size()) {
            newGameRole = new GameRole(roleName);
            gameRoles.add(newGameRole);
            return newGameRole;
        }
        for (GameRole gameRole : gameRoles) {
            if (roleName.equals(gameRole.getName())) {
                newGameRole = gameRole;
                return gameRole;
            }
        }
        newGameRole = new GameRole(roleName);
        gameRoles.add(newGameRole);
        return newGameRole;
    }

}
