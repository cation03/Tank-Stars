package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TankStars;

import java.util.ArrayList;

public class InGameScreen implements Screen {
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
    private Texture aim;
    private Texture fireActive;
    private Texture fuelActive;
    private Texture smallBlazer;
    private Texture smallMark;
    private Texture sliderBar;
    private Texture sliderButton;
    private Pixmap sliderPix;
    private Pixmap sliderButtPix;
    private boolean sliderControl;
    private int sliderPositionX;
    private int sliderPositionY;
    private boolean aimControl;
    private int aimPositionX;
    private int aimPositionY;

    private float x  = 204;
    private float x2 = 1566;

    private Stage stage;
    public InGameScreen(TankStars game) {
        ground = new Texture("ground - Copy.jpeg");
        stage = new Stage(new StretchViewport(1920, 1080));
        img = new Texture("nightBG.png");
        healthBarR = new Texture("helth.png");
        healthBarL = new Texture("helthR.png");
        vs = new Texture("vs.png");
        fire = new Texture("FIRE.png");
        fireActive = new Texture("FIREACTIV.png");
        fuelActive = new Texture("FUEL-1.png");
        fuel = new Texture("fuel.png");
        power = new Texture("power.png");
        angle = new Texture("angle.png");
        pause = new Texture("pause.png");
        arrowDown = new Texture("arrowDown.png");
        pauseSel = new Texture("pauseSel.png");
        aim = new Texture("aim.png");
        smallBlazer = new Texture("blazerSmall.png");
        smallMark = new Texture("markSmall.png");
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        ScreenUtils.clear(0,0,0,1);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x = x + 4;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x = x - 4;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            x2 = x2 + 4;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            x2 = x2 - 4;
        }

        stage.getBatch().begin();
        stage.getBatch().draw(img, 0, 0);
//        for (int i = 0; i < 384; i++) {
//            stage.getBatch().draw(ground, i * 5, 0, 5, groundHeight.get(i));
//        }
        stage.getBatch().draw(ground,0,0);
        stage.getBatch().draw(healthBarL, 338, 909);
        stage.getBatch().draw(healthBarR, 1011, 909);
        stage.getBatch().draw(vs, 930, 920);
        stage.getBatch().draw(fire, 1090, 158);
        stage.getBatch().draw(fuel, 261, 293);
        stage.getBatch().draw(power, 213, 540);
        stage.getBatch().draw(angle, 295, 540);
        stage.getBatch().draw(pause, 25, 980);
        stage.getBatch().draw(smallBlazer, x2, 455);
        stage.getBatch().draw(smallMark, x, 450);
        stage.getBatch().draw(sliderBar, 261, 193);
        stage.getBatch().draw(sliderButton, sliderPositionX, sliderPositionY);
        stage.getBatch().draw(aim, aimPositionX, aimPositionY);
        // move slider Button
        if(Gdx.input.justTouched() && Gdx.input.getX() > 261 && Gdx.input.getX() < 261 + sliderBar.getWidth() && Gdx.input.getY() > 1080 - 193 - sliderBar.getHeight() && Gdx.input.getY() < 1080 - 193) {
            sliderControl = true;
        }

        if (sliderControl) {
            sliderPositionX = Gdx.input.getX() - sliderButton.getWidth()/2;
            if (sliderPositionX < 261) {
                sliderPositionX = 261;
            }
            if (sliderPositionX > 261 + sliderBar.getWidth() - sliderButton.getWidth()) {
                sliderPositionX = 261 + sliderBar.getWidth() - sliderButton.getWidth();
            }
            //move tank with speed proportional to slider position, reverse if slider is pulled behind
            if (sliderPositionX > 261 + sliderBar.getWidth()/2) {
                x = x + (sliderPositionX - 261 - sliderBar.getWidth()/2)/10;
            } else {
                x = x - (261 + sliderBar.getWidth()/2 - sliderPositionX)/10;
            }
        }

        if (sliderControl && !Gdx.input.isTouched()) {
            sliderControl = false;
            sliderPositionX = 341;
            sliderPositionY = 193;
        }

        // allow user to move aim button in fixed radius
        if (Gdx.input.justTouched() && Gdx.input.getX() > 1500 && Gdx.input.getX() < 1500 + aim.getWidth() && Gdx.input.getY() > 1080 - 200 - aim.getHeight() && Gdx.input.getY() < 1080 - 200) {
            aimControl = true;
        }
        if (aimControl) {
            //limiting radius is 80 px
            if (Math.sqrt(Math.pow(Gdx.input.getX() - 1500 - aim.getWidth()/2, 2) + Math.pow(Gdx.input.getY() - 1080 + 200 + aim.getHeight()/2, 2)) < 80) {
                aimPositionX = Gdx.input.getX() - aim.getWidth()/2;
                aimPositionY = 1080 - Gdx.input.getY() - aim.getHeight()/2;
            } else {
                aimPositionX = (int)(1500 + 80 * Math.cos(Math.atan2(Gdx.input.getY() - 1080 + 200 + aim.getHeight()/2, Gdx.input.getX() - 1500 - aim.getWidth()/2)));
                aimPositionY = (int)(200 - 80 * Math.sin(Math.atan2(Gdx.input.getY() - 1080 + 200 + aim.getHeight()/2, Gdx.input.getX() - 1500 - aim.getWidth()/2)));
            }
        }
        if (aimControl && !Gdx.input.isTouched()) {
            aimControl = false;
            aimPositionX = 1500;
            aimPositionY = 200;
        }

        //change fire button if hovered
        if (Gdx.input.getX() > 1090 && Gdx.input.getX() < 1090 + fire.getWidth() && Gdx.input.getY() > 1080 - 158 - fire.getHeight() && Gdx.input.getY() < 1080 - 158) {
            stage.getBatch().draw(fireActive, 1090, 158);
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
                game.setScreen(new PauseGameScreen(game));
            }
        }
        else{
            stage.getBatch().draw(pause, 25, 980);
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
