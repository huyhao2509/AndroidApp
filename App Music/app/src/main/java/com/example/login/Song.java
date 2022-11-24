package com.example.login;

import java.io.Serializable;

public class Song implements Serializable {

    String image;
    String name;
    String describe;

    public Song(String image, String name, String describe) {
        this.image = image;
        this.name = name;
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
