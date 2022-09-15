package com.hrx.character;


import lombok.Data;

/**
 * 人物模型
 * @author hrx
 *
 */
@Data
public class Character {

    /**
     * 人物名称
     */
    private String name;

    /**
     * 屏幕位置X
     */
    private Integer screenX;

    /**
     * 屏幕位置Y
     */
    private Integer screenY;

    /**
     * 所在城市
     */
    private City city;

    /**
     * 所在城市地图X
     */
    private Integer locationX;

    /**
     * 所在城市地图Y
     */
    private Integer locationY;

}
