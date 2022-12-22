package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TankStars;
import jdk.jfr.internal.tool.Main;

public class MainScreen implements Screen {
    private Texture img;
    private Texture newGameButton;
    private Texture exitButton;
    private Texture resumeButton;
    private Texture newGameButtonActive;
    private Texture exitButtonActive;
    private Texture resumeButtonActive;
    private float x;
    private float y;
    private Stage stage;
    final TankStars game;
    private static final int PLAY_BUTTON_WIDTH = 319;
    private static final int PLAY_BUTTON_HEIGHT = 146;
    private static final int EXIT_BUTTON_WIDTH = 319;
    private static final int EXIT_BUTTON_HEIGHT = 146;
    private static final int RESUME_BUTTON_WIDTH = 319;
    private static final int RESUME_BUTTON_HEIGHT = 146;
    private static final int PLAY_BUTTON_X = 800;
    private static final int PLAY_BUTTON_Y = 635;
    private static final int EXIT_BUTTON_X = 800;
    private static final int EXIT_BUTTON_Y = 249;
    private static final int RESUME_BUTTON_X = 800;
    private static final int RESUME_BUTTON_Y = 442;
    public MainScreen(TankStars game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        img = new Texture("GameLoading - 01.png");
        newGameButton = new Texture("Group 28.png");
        newGameButtonActive = new Texture("Group 29.png");
        exitButton = new Texture("exit.png");
        exitButtonActive = new Texture("exitSel.png");
        resumeButton = new Texture("Group 24.png");
        resumeButtonActive = new Texture("Group 23.png");
        x = 0;
        y = 0;
    }
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render (float delta) {
        stage = new Stage(new StretchViewport(1920, 1080));
        stage.act();
        stage.draw();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.getBatch().begin();
        stage.getBatch().draw(img, x, y);

        int x = TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2;
        if (Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
            stage.getBatch().draw(newGameButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new SelectTankScreen(game));
            }
        }
        else{
            stage.getBatch().draw(newGameButton, TankStars.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }
        if (Gdx.input.getX() < x + RESUME_BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < RESUME_BUTTON_Y + RESUME_BUTTON_HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > RESUME_BUTTON_Y) {
            stage.getBatch().draw(resumeButtonActive, x, RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new LoadGameScreen(game));

            }
        }
        else{
            stage.getBatch().draw(resumeButton, x, RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
        }

        if (Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
            stage.getBatch().draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                Gdx.app.exit();
            }
        }
        else{
            stage.getBatch().draw(exitButton,x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }
        stage.getBatch().end();
    }
    @Override
    public void show() {

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
