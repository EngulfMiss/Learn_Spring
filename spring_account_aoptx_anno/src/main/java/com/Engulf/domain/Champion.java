package com.Engulf.domain;

import java.io.Serializable;

/**
 * 英雄的实体类
 */

public class Champion implements Serializable {

    private Integer id;
    private String name;
    private Float gold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGold() {
        return gold;
    }

    public void setGold(Float gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
