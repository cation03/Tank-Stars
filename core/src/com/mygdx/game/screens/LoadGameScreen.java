package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TankStars;

public class LoadGameScreen implements Screen {
    private TankStars game;
    private Stage stage;
    private Texture bg;
    private Texture backButton;
    private Texture backButtonSel;
    private final int BACK_BUTTON_WIDTH = 228;
    private final int BACK_BUTTON_HEIGHT = 66;
    private final int BACK_BUTTON_Y = 120;
    private Texture gameButton1;
    private Texture gameButton1Sel;
    private Texture gameButton2;
    private Texture gameButton2Sel;
    private Texture gameButton3;
    private Texture gameButton3Sel;
    private Texture gameButton4;
    private Texture gameButton4Sel;
    private final int GAME_BUTTON_WIDTH = 335;
    private final int GAME_BUTTON_HEIGHT = 131;
    private final int GAME_BUTTON_Y = 746;
    public LoadGameScreen(TankStars game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        bg = new Texture("Backdrop.png");
        backButton = new Texture("back.png");
        backButtonSel = new Texture("backActive.png");
        gameButton1 = new Texture("game1.png");
        gameButton1Sel = new Texture("GAME1ACTIVE.png");
        gameButton2 = new Texture("game2.png");
        gameButton2Sel = new Texture("GAME2ACTIVE.png");
        gameButton3 = new Texture("game3.png");
        gameButton3Sel = new Texture("GAME3ACTIVE.png");
        gameButton4 = new Texture("game4.png");
        gameButton4Sel = new Texture("GAME4ACTIVE.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        stage.getBatch().begin();
        stage.getBatch().draw(bg, 0, 0);

        int x = TankStars.WIDTH / 2 - BACK_BUTTON_WIDTH / 2;

        if (Gdx.input.getX() < x + BACK_BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < BACK_BUTTON_Y + BACK_BUTTON_HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > BACK_BUTTON_Y) {
            stage.getBatch().draw(backButtonSel, 846, 120, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new MainScreen(game));
            }
        }
        else{
            stage.getBatch().draw(backButton, 846, 120, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
        }

        int p = TankStars.WIDTH / 2 - GAME_BUTTON_WIDTH / 2;
        if (Gdx.input.getX() < 489 && Gdx.input.getX() > 154 && Gdx.input.getY() < 281 && Gdx.input.getY() > 150){
            stage.getBatch().draw(gameButton1Sel, 154, 746, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
//            if (Gdx.input.justTouched()) {
//            }
        }
        else{
            stage.getBatch().draw(gameButton1, 154, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        }

        if (Gdx.input.getX() < 915 && Gdx.input.getX() > 580 && Gdx.input.getY() < 281 && Gdx.input.getY() > 150) {
            stage.getBatch().draw(gameButton2Sel, 580, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
//            if (Gdx.input.justTouched()) {}
        }
        else{
            stage.getBatch().draw(gameButton2, 580, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        }

        if (Gdx.input.getX() < 1767 && Gdx.input.getX() > 1432 && Gdx.input.getY() < 281 && Gdx.input.getY() > 150){
            stage.getBatch().draw(gameButton4Sel, 1432, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
//            if (Gdx.input.justTouched()) {
//            }
        }
        else{
            stage.getBatch().draw(gameButton4, 1432, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        }

        if (Gdx.input.getX() < 1341 && Gdx.input.getX() > 1006 && Gdx.input.getY() < 281 && Gdx.input.getY() > 150) {
            stage.getBatch().draw(gameButton3Sel, 1006, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
//            if (Gdx.input.justTouched()) {
//            }
        }
        else{
            stage.getBatch().draw(gameButton3, 1006, GAME_BUTTON_Y, GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
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
