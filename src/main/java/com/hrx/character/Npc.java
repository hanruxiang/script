package com.hrx.character;

import com.jacob.com.Dispatch;
import lombok.Data;

import java.util.List;

/**
 * NPC对象
 * @author hrx
 */
@Data
public class Npc extends Character {

    private List<String> pictureUrlList;

    private String taskPicture;

    public Npc(String name, City city, Integer locationX, Integer locationY, Integer screenX, Integer screenY, String taskPicture) {
        super();
        this.setCity(city);
        this.setName(name);
        this.setLocationX(locationX);
        this.setLocationY(locationY);
        this.setScreenX(screenX);
        this.setScreenY(screenY);
        this.taskPicture = taskPicture;
    }

    public void doTask(Dispatch dmCom) throws Exception{

    }

}
