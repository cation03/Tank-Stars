package com.encryptedcation.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.encryptedcation.tankstars.exceptions.OutOfFuelException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Tank implements java.io.Serializable, Iterable<Attack> {
    // default tank is Mark 1
    private int fuel;
    public String name;
    public int positionX;
    public int positionY;
    public int direction;
    private ArrayList<Tank> tanks = new ArrayList<Tank>();
    protected String pathToTexture;
    ArrayList<Attack> attacks = new ArrayList<Attack>();
    public Tank(String name, int positionX, int positionY, int direction, int fuel, Attack defaultAttack) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.fuel = fuel;
        attacks.add(defaultAttack);
    }

    public void move(int distance) throws OutOfFuelException {
        if (distance > fuel) {
            throw new OutOfFuelException("Not enough fuel to move " + distance + " units");
        }
        fuel -= distance;
        switch (direction) {
            case 0:
                positionY += distance;
                break;
            case 1:
                positionX += distance;
                break;
            case 2:
                positionY -= distance;
                break;
            case 3:
                positionX -= distance;
                break;
        }
    }

    // get position x
    public int getPositionX() {
        return positionX;
    }

    // get position y
    public int getPositionY() {
        return positionY;
    }

    // set position x
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    // set position y
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    // get direction
    public int getDirection() {
        return direction;
    }

    // set direction
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // get fuel
    public int getFuel() {
        return fuel;
    }

    // set fuel
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    // get name
    public String getName() {
        return name;
    }

    public void getTanks() {
        // use iterator design pattern

    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }

    public void removeAttack(Attack attack) {
        attacks.remove(attack);
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public Texture getTexture(
    ) {
        return new Texture(pathToTexture);
    }

    @Override
    public Iterator<Attack> iterator() {
        return attacks.iterator();
    }

    public void iterateOverTanks() {
        Collection<Tank> c = tanks;
        Iterator<Tank> itr = c.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // get default attack
//    public Attack getDefaultAttack() {
//        return defaultAttack;
//    }
}
