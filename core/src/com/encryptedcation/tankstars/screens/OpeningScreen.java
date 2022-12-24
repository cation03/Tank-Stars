package com.encryptedcation.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.encryptedcation.tankstars.Tank;
import com.encryptedcation.tankstars.TankStars;

public class OpeningScreen implements Screen {
    private Texture loadingScreen;
    TankStars game;
    private Stage stage;

    public OpeningScreen(TankStars game) {
        stage = new Stage(new StretchViewport(1920, 1080));
        loadingScreen = new Texture("GameLoading - 01.png");
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        ScreenUtils.clear(0,0,0,1);
        stage.getBatch().begin();
        if (Gdx.input.isTouched()) {
            this.dispose();
            game.setScreen(new MainScreen(game));
        }
        else{
            stage.getBatch().draw(loadingScreen, 0, 0);
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
