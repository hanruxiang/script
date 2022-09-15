package com.hrx.character;

import java.util.List;

/**
 * NPC对象
 * @author hrx
 */
public class Npc extends Character {

    private List<String> pictureUrlList;

    public Npc(String name, City city, Integer locationX, Integer locationY, Integer screenX, Integer screenY) {
        super();
        this.setCity(city);
        this.setName(name);
        this.setLocationX(locationX);
        this.setLocationY(locationY);
        this.setScreenX(screenX);
        this.setScreenY(screenY);
    }
}
