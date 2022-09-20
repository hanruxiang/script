package com.hrx.util;

import cn.hutool.core.io.resource.ClassPathResource;
import com.hrx.common.CommonConstants;
import com.hrx.common.TwoTuple;
import com.qiyou.javaelf.system.Elf;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * 登录用户util
 * @author hrx
 */
public class LoginUtil {

    public static String getCurrentScreenGameRole(Elf elf) throws Exception {
        ClassPathResource resource = new ClassPathResource(CommonConstants.SystemConstants.ROLE_INFO_PICTURE_PATH);
        File file = resource.getFile();
        List<File> allFile = FileUtil.getAllFile(file.getAbsolutePath());
        for (File roleFile : allFile) {
            String name = roleFile.getName();
            TwoTuple<Integer, Integer> point = DaMoApi.findPic(elf,0,0,2000,2000, name,"000000");
            if(Objects.nonNull(point) && !CommonConstants.ZERO.equals(point.x) && !CommonConstants.ZERO.equals(point.y)) {
                return name.replace(".bmp", "");
            }
        }
        return null;
    }

}
