package com.encryptedcation.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.encryptedcation.tankstars.SavedGame;
import com.encryptedcation.tankstars.TankStars;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PauseGameScreen extends SelectTankScreen implements Screen {
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
    private SavedGame savedGame;



    public PauseGameScreen(TankStars game, SavedGame savedGame) {
        super(game);
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
        this.savedGame = savedGame;
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
                game.setScreen(new InGameScreen(game, savedGame));
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
                try{
                    // if savedGame1.ser exists, try to save to savedGame2.ser, else save to savedGame3.ser else save to savedGame4.ser else save to savedGame1.ser
                    FileOutputStream fileOut = null;
                    if (Gdx.files.local("savedGame1.ser").exists()) {
                        if (Gdx.files.local("savedGame2.ser").exists()) {
                            if (Gdx.files.local("savedGame3.ser").exists()) {
                                if (Gdx.files.local("savedGame4.ser").exists()) {
                                    fileOut = new FileOutputStream("savedGame1.ser");
                                } else {
                                    fileOut = new FileOutputStream("savedGame4.ser");
                                }
                            } else {
                                fileOut = new FileOutputStream("savedGame3.ser");
                            }
                        } else {
                            fileOut = new FileOutputStream("savedGame2.ser");
                        }
                    } else {
                        fileOut = new FileOutputStream("savedGame1.ser");
                    }
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(this.savedGame);
                    out.close();
                    fileOut.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                game.setScreen(new SaveGameScreen(game, savedGame));
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
