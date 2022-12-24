package com.encryptedcation.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class Toxic extends Tank {
    public Toxic(String name, int positionX, int positionY, int direction, int fuel, Attack defaultAttack) {
        super(name, positionX, positionY, direction, fuel, defaultAttack);
        this.pathToTexture = "gameTanks/toxicSmall.png";
    }
}
