package com.example.thecoffeehouse;

import java.io.Serializable;

public class Information implements Serializable {
    String id;
    String name;
    String email;
    String birhday;

    public Information() {
    }

    public Information(String ma, String id, String name, String sex, String job, String birhday) {
        this.id = id;
        this.name = name;
        this.email = job;
        this.birhday = birhday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirhday() {
        return birhday;
    }

    public void setBirhday(String birhday) {
        this.birhday = birhday;
    }
}
