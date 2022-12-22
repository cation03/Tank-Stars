package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TankStars;

public class SaveGameScreen implements Screen {
    private TankStars game;
    private Stage stage;
    private Texture bg;
    private Texture backButton;
    private Texture backButtonSel;
    private final int BACK_BUTTON_WIDTH = 228;
    private final int BACK_BUTTON_HEIGHT = 66;
    private final int BACK_BUTTON_Y = 448;

    public SaveGameScreen(TankStars game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        bg = new Texture("SavedGamePage.png");
        backButton = new Texture("back.png");
        backButtonSel = new Texture("backActive.png");
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
            stage.getBatch().draw(backButtonSel, 846, 448, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new PauseGameScreen(game));
            }
        }
        else{
            stage.getBatch().draw(backButton, x, BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
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
