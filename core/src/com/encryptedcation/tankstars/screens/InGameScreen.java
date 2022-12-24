package com.encryptedcation.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.encryptedcation.tankstars.*;

import java.io.Serializable;
import java.util.ArrayList;

public class InGameScreen implements Screen, Serializable {
    private Texture p1;
    private Texture p2;
    private Player player1 = null;
    private Player player2 = null;
    TankStars game;
    private Texture img;
    private Texture healthBarR;
    private Texture healthBarL;
    private Texture vs;
    private Texture fire;
    private Texture fuel;
    private Texture power;
    private Texture angle;
    private Texture pause;
    private Texture arrowDown;
    private float CURRENT_TANK_X;
    private float CURRENT_TANK_Y;
    private final int PAUSE_BUTTON_WIDTH = 69;
    private final int PAUSE_BUTTON_HEIGHT = 59;
    private final int PAUSE_BUTTON_Y = 980;
    private Texture pauseSel;
    private ArrayList<Float> groundHeight; // used to implement destructible terrain.
    private Texture ground;
    private Texture healthBarLine;
    private Texture aim;
    private Texture fireActive;
    private Texture smallBlazer;
    private Texture smallMark;
    private Texture sliderBar;
    private Texture blank;
    private Texture sliderButton;
    private Pixmap sliderPix;
    private Pixmap sliderButtPix;
    private boolean sliderControl;
    private int sliderPositionX;
    private int sliderPositionY;
    private boolean aimControl;
    private int aimPositionX;
    private int aimPositionY;
    private Label powerLabel;
    private Label angleLabel;


    private int turn; // 1 = player 1, 2 = player 2

    private Stage stage;
    private Texture fuelBar;
    private Skin skin;
    private Attack attack;
    private Texture bam;
    public InGameScreen(TankStars game, Player player1, Player player2) {
        blank = new Texture("blank.png");
        ground = new Texture("ground - Copy.jpeg");
        stage = new Stage(new StretchViewport(1920, 1080));
        img = new Texture("nightBG.png");
        healthBarR = new Texture("p2Health.png");
//        healthBarR = new Texture("testHealthBar.png");
        p1 = new Texture("PLAYER 1.png");
        p2 = new Texture("PLAYER 2.png");
        healthBarL = new Texture("p1Health.png");
        healthBarLine = new Texture("healthBarLine.png");
        vs = new Texture("vs.png");
        fire = new Texture("FIRE.png");
        fireActive = new Texture("FIREACTIV.png");
        fuel = new Texture("fuel.png");
        power = new Texture("power.png");
        angle = new Texture("angle.png");
        pause = new Texture("pause.png");
        arrowDown = new Texture("arrowDown.png");
        pauseSel = new Texture("pauseSel.png");
        aim = new Texture("aim.png");
        smallBlazer = new Texture("gameTanks/blazerSmall.png");
        smallMark = new Texture("gameTanks/markSmall.png");
        this.game = game;
        sliderBar = new Texture("sliderBar.png");
        sliderButton = new Texture("sliderCircle.png");
        sliderPix = new Pixmap(Gdx.files.internal("sliderBar.png"));
        Pixmap scaledPixmap = new Pixmap((int)(sliderPix.getWidth()*0.8), (int)(sliderPix.getHeight()*0.8), sliderPix.getFormat());
        scaledPixmap.drawPixmap(sliderPix, 0, 0, sliderPix.getWidth(), sliderPix.getHeight(), 0, 0, scaledPixmap.getWidth(), scaledPixmap.getHeight());
        sliderBar = new Texture(scaledPixmap);
        sliderButtPix = new Pixmap(Gdx.files.internal("sliderCircle.png"));
        Pixmap scaledPixmap2 = new Pixmap((int)(sliderButtPix.getWidth()*0.8), (int)(sliderButtPix.getHeight()*0.8), sliderButtPix.getFormat());
        scaledPixmap2.drawPixmap(sliderButtPix, 0, 0, sliderButtPix.getWidth(), sliderButtPix.getHeight(), 0, 0, scaledPixmap2.getWidth(), scaledPixmap2.getHeight());
        sliderButton = new Texture(scaledPixmap2);
        sliderPositionX = 341;
        sliderPositionY = 193;
        aimPositionX = 1500;
        aimPositionY = 200;
        fuelBar = new Texture("fuelBar.png");
        this.player1 = player1;
        this.player2 = player2;
        BitmapFont font = new BitmapFont();
        // increase font size
        font.getData().setScale(1.5F);
        powerLabel = new Label("100", new Label.LabelStyle(font, Color.WHITE));
        angleLabel = new Label("45", new Label.LabelStyle(font, Color.WHITE));
        this.player1.x  = 204;
        this.player2.x = 1566;
        turn = 1;
        attack = new Attack(20, 250, "mehul", "ananya");
        bam = new Texture("attack.png");

//        groundHeight = new ArrayList<Float>();
//        // initialise ground heights to hilly terrain.
//        float initialHeight = 500;
//        int flagIncreasing = 0;
//        for (int i = 0; i < 384; i++) {
//            groundHeight.add(initialHeight);
//            if (i%20 == 0 || i%47==0 || i%56==0) {
//                flagIncreasing = 1- flagIncreasing;
//            }
//            if (flagIncreasing == 1) {
//                initialHeight += Math.random()*2;
//            } else {
//                initialHeight -= Math.random();
//            }
//        }
    }

    public InGameScreen(TankStars game, SavedGame savedGame) {
        this(game, savedGame.getPlayer1(), savedGame.getPlayer2());
        turn = savedGame.getTurn();
    }

    public int getWinner() {
        if (player1.getHealth() <= 0) {
            return 2;
        } else if (player2.getHealth() <= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    @Override
    public void show() {

    }

    private void handleInput(Player player){
        if (player.getTank().getFuel() > 0) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                player.x = player.x + 3;
                player.getTank().setFuel(player.getTank().getFuel() - 1);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                player.x = player.x - 3;
                player.getTank().setFuel(player.getTank().getFuel() - 1);
            }
        }
    }

    public float gravity = -9.8f;
    public Vector2 initialVelocity = new Vector2();
    public Vector2 initialPosition = new Vector2();

    public float getX(float time) {
        return initialPosition.x + initialVelocity.x * time;
    }

    public float getY(float time) {
        return initialPosition.y + initialVelocity.y * time + 0.5f * gravity * time * time;
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        ScreenUtils.clear(0,0,0,1);
        if (turn == 1) {
            handleInput(player1);
        } else {
            handleInput(player2);
        }
        stage.getBatch().begin();
        stage.getBatch().draw(img, 0, 0);
//        for (int i = 0; i < 384; i++) {
//            stage.getBatch().draw(ground, i * 5, 0, 5, groundHeight.get(i));
//        }
        stage.getBatch().draw(ground,0,0);
        stage.getBatch().draw(healthBarL, 270, 909);

        int xHealthLineStart = 795;
        int width = 27;
        // full bar
        if (player1.getHealth() == 100) {
            stage.getBatch().draw(healthBarLine, 280, 925, width * 20, 68);
        }
        else {
            // partial bar
            stage.getBatch().draw(healthBarLine, 280, 925, width * (int) (player1.getHealth() / 5), 68);
        }

        stage.getBatch().draw(healthBarR, 1011, 909);

        if (player2.getHealth() == 100) {
            stage.getBatch().draw(healthBarLine, 1124, 925, width * 20, 68);
        }
        else {
            // partial bar
            stage.getBatch().draw(healthBarLine, 1124, 925, width * (int) (player2.getHealth() / 5), 68);
        }
//        }
//

//        stage.getBatch().draw(healthBarR, 1011, 909);
        stage.getBatch().draw(vs, 930, 920);
        stage.getBatch().draw(p1, 320, 950);
        stage.getBatch().draw(p2, 1500, 950);
        stage.getBatch().draw(fire, 1090, 158);
        int currPlayerFuel = 0;
        if (turn == 1) {
            currPlayerFuel = player1.getTank().getFuel();
        } else {
            currPlayerFuel = player2.getTank().getFuel();
        }
        if (currPlayerFuel == 100) {
            stage.getBatch().draw(fuelBar, 263, 293, fuel.getWidth()-4, fuel.getHeight());
        }
        else {
            stage.getBatch().draw(fuelBar, 263, 293, (int) (currPlayerFuel * (fuel.getWidth()-4) /100), fuel.getHeight());
        }
        stage.getBatch().draw(fuel, 261, 293);
        stage.getBatch().draw(power, 213, 540);
        stage.getBatch().draw(angle, 295, 540);
        if (turn == 1) {
            powerLabel.setText(Integer.toString((int) player1.getPowerOfShooting()));
            angleLabel.setText(Integer.toString((int) player1.getAngleOfShooting()));
        }
        else {
            powerLabel.setText(Integer.toString((int) player2.getPowerOfShooting()));
            angleLabel.setText(Integer.toString((int) player2.getAngleOfShooting()));
        }
        powerLabel.setPosition(223, 560);
        angleLabel.setPosition(305, 560);
        powerLabel.draw(stage.getBatch(), 1);
        angleLabel.draw(stage.getBatch(), 1);
        stage.getBatch().draw(pause, 25, 980);
        // select tank and draw it at player.x
        stage.getBatch().draw(player2.getTank().getTexture(), player2.x, 455);
        stage.getBatch().draw(player1.getTank().getTexture(), player1.x, 450);
//        stage.getBatch().draw(sliderBar, 261, 193);
//        stage.getBatch().draw(sliderButton, sliderPositionX, sliderPositionY);
        stage.getBatch().draw(aim, aimPositionX, aimPositionY);


        // if player 1 attacks and it hits player 2 then player 2 loses health
//            stage.getBatch().draw(blank, Gdx.graphics.getWidth()*p1.getHealth(), 909);
//        stage.getBatch().draw(blank, Gdx.graphics.getWidth()*10, 909); // player 1 health bar
//        stage.getBatch().draw(blank, 1011, 909, Gdx.graphics.getWidth(), 909); // player 2 health bar

//        }
        //


//        if(Gdx.input.justTouched() && Gdx.input.getX() > 261 && Gdx.input.getX() < 261 + sliderBar.getWidth() && Gdx.input.getY() > 1080 - 193 - sliderBar.getHeight() && Gdx.input.getY() < 1080 - 193) {
//            sliderControl = true;
//        }
//
//        if (sliderControl) {
//            sliderPositionX = Gdx.input.getX() - sliderButton.getWidth()/2;
//            if (sliderPositionX < 261) {
//                sliderPositionX = 261;
//            }
//            if (sliderPositionX > 261 + sliderBar.getWidth() - sliderButton.getWidth()) {
//                sliderPositionX = 261 + sliderBar.getWidth() - sliderButton.getWidth();
//            }
//            //move tank with speed proportional to slider position, reverse if slider is pulled behind
//            if (sliderPositionX > 261 + sliderBar.getWidth()/2) {
//                x = x + (sliderPositionX - 261 - sliderBar.getWidth()/2)/10;
//            } else {
//                x = x - (261 + sliderBar.getWidth()/2 - sliderPositionX)/10;
//            }
//        }
//
//        if (sliderControl && !Gdx.input.isTouched()) {
//            sliderControl = false;
//            sliderPositionX = 341;
//            sliderPositionY = 193;
//        }

        // allow user to move aim button in fixed radius
        if (Gdx.input.justTouched() && Gdx.input.getX() > 1500 && Gdx.input.getX() < 1500 + aim.getWidth() && Gdx.input.getY() > 1080 - 200 - aim.getHeight() && Gdx.input.getY() < 1080 - 200) {
            aimControl = true;
        }
        if (aimControl) {
            //limiting radius is 80 px
            //restrict movement in first and second quadrant
            if (Gdx.input.getX() > 1500 + aim.getWidth()/2 && Gdx.input.getY() < 1080 - 200 - aim.getHeight()/2) {
                if (Math.sqrt(Math.pow(Gdx.input.getX() - 1500 - aim.getWidth()/2, 2) + Math.pow(1080 - 200 - aim.getHeight()/2 - Gdx.input.getY(), 2)) < 80) {
                    aimPositionX = Gdx.input.getX() - aim.getWidth()/2;
                    aimPositionY = 1080 - Gdx.input.getY() - aim.getHeight()/2;
                }
            } else {
                aimPositionX = (int)(1500 + 80 * Math.cos(Math.atan2(Gdx.input.getY() - 1080 + 200 + aim.getHeight()/2, Gdx.input.getX() - 1500 - aim.getWidth()/2)));
                aimPositionY = (int)(200 - 80 * Math.sin(Math.atan2(Gdx.input.getY() - 1080 + 200 + aim.getHeight()/2, Gdx.input.getX() - 1500 - aim.getWidth()/2)));
            }
            // power is proportional to radius, angle is proportional to angle
            // forward x axis is at 0 degrees, positive Y at 90 degrees
            // max power = 100
            if (turn == 1) {
                player1.setPowerOfShooting((int) (Math.sqrt(Math.pow(aimPositionX - 1500, 2) + Math.pow(aimPositionY - 200, 2)) * 100 / 80));
                player1.setAngleOfShooting((int) (Math.atan2(aimPositionY - 200, aimPositionX - 1500) * 180 / Math.PI));
            }
            else {
                player2.setPowerOfShooting((int) (Math.sqrt(Math.pow(aimPositionX - 1500, 2) + Math.pow(aimPositionY - 200, 2)) * 100 / 80));
                player2.setAngleOfShooting((int) (Math.atan2(aimPositionY - 200, aimPositionX - 1500) * 180 / Math.PI));
            }
        }
        if (aimControl && !Gdx.input.isTouched()) {
            aimControl = false;
            aimPositionX = 1500;
            aimPositionY = 200;
        }

        Player currentPlayer = turn == 1 ? player1 : player2;
        initialPosition.x = currentPlayer.x + currentPlayer.getTank().getTexture().getWidth()/2;
        initialPosition.y = 465;
        initialVelocity = new Vector2((float) (currentPlayer.getPowerOfShooting() * Math.cos(currentPlayer.getAngleOfShooting() * Math.PI / 180)), (float) (currentPlayer.getPowerOfShooting() * Math.sin(currentPlayer.getAngleOfShooting() * Math.PI / 180)));
        float timeForFall = (float) (2 * initialVelocity.y / 9.8);

        // draw projectile trajectory using small circles and getX and getY methods
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fillCircle(0, 0, 1);
        Texture whiteCircle = new Texture(pixmap);


        for (float t = 0; t < timeForFall; t += 0.5) {
            stage.getBatch().draw(whiteCircle, getX(t), getY(t), 5, 5);
        }

        //change fire button if hovered
        if (Gdx.input.getX() > 1090 && Gdx.input.getX() < 1090 + fire.getWidth() && Gdx.input.getY() > 1080 - 158 - fire.getHeight() && Gdx.input.getY() < 1080 - 158) {
            stage.getBatch().draw(fireActive, 1090, 158);
            if (Gdx.input.justTouched()) {
                float ProjectileLandedX = getX(timeForFall);
                Player targetPlayer = turn == 1 ? player2 : player1;
                float impactPositionX = getX(timeForFall);
                float impactPositionY = targetPlayer.y;
                stage.getBatch().draw(bam, impactPositionX, impactPositionY);

                float distanceFromTarget = Math.abs(ProjectileLandedX - targetPlayer.x - targetPlayer.getTank().getTexture().getWidth()/2);
                if (attack.getRange() >= distanceFromTarget) {
                    int reductionInHealth = (int) (attack.getDamage() * (1 - distanceFromTarget / attack.getRange()));
                    targetPlayer.setHealth(targetPlayer.getHealth() - reductionInHealth);
                    // move target player in direction of initial velocity of projectile proportional to damage
                    targetPlayer.x = targetPlayer.x + (int) (initialVelocity.x * reductionInHealth / attack.getDamage());
                }
                System.out.println("Projectile landed at " + ProjectileLandedX);
                System.out.println("Target tank at " + targetPlayer.x);
                System.out.println("Distance from target " + distanceFromTarget);
                System.out.println("Health of target " + targetPlayer.getHealth());
                turn = turn == 1 ? 2 : 1;
                player1.setPowerOfShooting(0);
                player1.setAngleOfShooting(0);
                player1.getTank().setFuel(100);
                player2.setAngleOfShooting(0);
                player2.setPowerOfShooting(0);
                player2.getTank().setFuel(100);
            }
        }

        // USE THE BELOW LINE WHILE IMPLEMENTING
//        stage.getBatch().draw(arrowDown, CURRENT_TANK_X, CURRENT_TANK_Y + 200);
        stage.getBatch().draw(arrowDown, 1613, 649);
        //draw ground here
        

        // if pause is clicked then go to PauseGameScreen
        int x = TankStars.WIDTH/2 - PAUSE_BUTTON_WIDTH/2;
        if (Gdx.input.getX() < 94 && Gdx.input.getX() > 25 && TankStars.HEIGHT - Gdx.input.getY() < PAUSE_BUTTON_Y + PAUSE_BUTTON_HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > PAUSE_BUTTON_Y) {
            stage.getBatch().draw(pauseSel, 25, 980);
            if (Gdx.input.isTouched()) {
                this.dispose();
                // make a SavedGame class object and pass it to PauseGameScreen
                SavedGame savedGame = new SavedGame(player1, player2, turn);
                game.setScreen(new PauseGameScreen(game, savedGame));
            }
        }
        else{
            stage.getBatch().draw(pause, 25, 980);
        }

        // if health of any player is 0 then go to VictoryScreen
        if (player1.getHealth() <= 0) {
            this.dispose();
            game.setScreen(new VictoryPage(game, 2));
        }
        if (player2.getHealth() <= 0) {
            this.dispose();
            game.setScreen(new VictoryPage(game, 1));
        }



        stage.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}