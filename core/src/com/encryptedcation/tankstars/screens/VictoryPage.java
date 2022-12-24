package com.encryptedcation.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.encryptedcation.tankstars.Player;
import com.encryptedcation.tankstars.TankStars;

public class VictoryPage implements Screen {
    TankStars game;
    private Stage stage;
    private Texture img;
    private Texture victory;
    private Texture MainMenu;
    private Texture MainMenuActive;
    private int Winner;
    private Texture button;


    public VictoryPage(TankStars game, int Winner) {
        this.game = game;
        stage = new Stage();
        img = new Texture("bg-1.png");
        MainMenu = new Texture("MAINMENU.png");
        MainMenuActive = new Texture("MAINMENUACTIVE.png");
        button = new Texture("Rectangle 23.png");
        this.Winner = Winner;
        if (Winner == 1) {
            victory = new Texture("PLAYER 1 WON.png");
        }
        else {
            victory = new Texture("PLAYER 2 WON.png");
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.getBatch().begin();
        stage.getBatch().draw(img, 0, 0);
        stage.getBatch().draw(button, 760, 850);
        stage.getBatch().draw(victory, 795, 920);
        stage.getBatch().draw(MainMenu, 770, 425);
        int MAINMENUWIDTH = 335;
        int MAINMENUHEIGHT = 131;

        // if main menu button is hovered over, change texture to active
        if (Gdx.input.getX() > 770 && Gdx.input.getX() < 770 + MAINMENUWIDTH && Gdx.input.getY() > 425 && Gdx.input.getY() < 425 + MAINMENUHEIGHT) {
            stage.getBatch().draw(MainMenuActive, 770, 425);
            if (Gdx.input.isTouched()) {
                game.setScreen(new MainScreen(game));
            }
        }
        else {
            stage.getBatch().draw(MainMenu, 770, 425);
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
