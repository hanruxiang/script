package com.hrx.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hrx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private String name = "";

    private String pictureUrl = "";

    private String worldMapPicture = "";

    public City(String name) {
        this.name = name;
    }
}
