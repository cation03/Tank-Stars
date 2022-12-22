package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TankStars;

public class PauseGameScreen implements Screen {
    TankStars game;
    private Stage stage;
    private Texture bg;
    private Texture resume;
    private Texture resumeSel;
    private Texture mainMenu;
    private Texture mainMenuSel;
    private Texture saveGame;
    private Texture saveGameSel;
    private Texture restart;
    private Texture restartSel;
    private final int WIDTH = 345;
    private final int HEIGHT = 150;



    public PauseGameScreen(TankStars game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        bg = new Texture("BG.png");
        resume = new Texture("RESUME.png");
        resumeSel = new Texture("RESUMEACTIVE.png");
        mainMenu = new Texture("MAINMENU.png");
        mainMenuSel = new Texture("MAINMENUACTIVE.png");
        saveGame = new Texture("SAVEGAME.png");
        saveGameSel = new Texture("SAVEGAMEACTIVE.png");
        restart = new Texture("RESTART.png");
        restartSel = new Texture("RESTARTACTIVE.png");
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
        stage.getBatch().draw(resume, 793, 754);
        stage.getBatch().draw(mainMenu, 793, 578);
        stage.getBatch().draw(saveGame, 793, 403);
        stage.getBatch().draw(restart, 793, 226);
        int x = TankStars.WIDTH / 2 - WIDTH / 2;

        // if resume is selected
        if (Gdx.input.getX() < x + WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < 754 + HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > 754) {
            stage.getBatch().draw(resumeSel, 793, 754, WIDTH, HEIGHT);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new InGameScreen(game));
            }
        }

        // if main menu is selected
        if (Gdx.input.getX() < x + WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < 578 + HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > 578) {
            stage.getBatch().draw(mainMenuSel, 793, 578, WIDTH, HEIGHT);
            if (Gdx.input.justTouched()) {
                game.setScreen(new MainScreen(game));
                this.dispose();
            }
        }

        // if save game is clicked
        if (Gdx.input.getX() < x + WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < 403 + HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > 403) {
            stage.getBatch().draw(saveGameSel, 793, 403, WIDTH, HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new SaveGameScreen(game));
            }
        }

        // if restart is clicked
        if (Gdx.input.getX() < x + WIDTH && Gdx.input.getX() > x && TankStars.HEIGHT - Gdx.input.getY() < 226 + HEIGHT && TankStars.HEIGHT - Gdx.input.getY() > 226) {
            stage.getBatch().draw(restartSel, x, 226, WIDTH, HEIGHT);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new SelectTankScreen(game));

            }
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
