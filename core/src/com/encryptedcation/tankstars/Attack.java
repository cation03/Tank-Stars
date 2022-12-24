package com.encryptedcation.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class Attack {
    private int damage;
    private float range;
    private String type;
    private String name;
    private Texture texture = new Texture("attack.png");

    public Attack(int damage, float range, String type, String name) {
        this.damage = damage;
        this.range = range;
        this.type = type;
        this.name = name;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getDamage() {
        return damage;
    }

    public float getRange() {
        return range;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
