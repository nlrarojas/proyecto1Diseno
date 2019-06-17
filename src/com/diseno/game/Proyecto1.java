package com.diseno.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import view.CreatorUi;
import view.GameUi;
import view.MenuUi;
import view.UiManager;

public class Proyecto1 extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    private BitmapFont font;
    UiManager uiManager;

    //constants for screen with and height in pixels
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private float elapsedTime = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        font = new BitmapFont();
        font.setColor(Color.BLACK);

        //creat ui
        uiManager = new UiManager();
        uiManager.addUi("menu", new MenuUi(uiManager));
        uiManager.addUi("creator", new CreatorUi(uiManager));
        uiManager.addUi("game", new GameUi(uiManager));
        //set starting ui
        uiManager.setUi("menu");

    }

    @Override
    public void render() {
        //stores time passed on a variable
        elapsedTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(img, 0, 0);
        font.draw(batch, "Proyecto 1 Diseño!!", WIDTH / 2 - 100, HEIGHT - 20);
        batch.end();

        uiManager.render();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
