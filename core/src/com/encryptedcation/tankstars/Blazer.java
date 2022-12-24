package com.encryptedcation.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class Blazer extends Tank {
    public Blazer(String name, int positionX, int positionY, int direction, int fuel, Attack defaultAttack) {
        super(name, positionX, positionY, direction, fuel, defaultAttack);
        this.pathToTexture = "gameTanks/blazerSmall.png";
    }
}
