package com.diseno.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.generators.CharacterGenerator;
import domain.generators.DefenseGenerator;
import model.command.CommandArmyCreator;
import model.command.CommandCharacterCreater;
import model.command.CommandDefenseCreator;
import model.command.CommandManager;
import model.command.CommandUserCreator;
import model.command.CommandVillageSettingsManager;
import model.command.CommandWeaponCreator;
import model.command.GameManagerCommand;
import view.CharacterCreatorUi;
import view.DefenseCreatorUi;
import view.GameUi;
import view.MenuUi;
import view.UiManager;
import view.WeaponCreatorUi;

public class Proyecto1 extends ApplicationAdapter {

    //constants for screen with and height in pixels
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private float elapsedTime = 0;

    SpriteBatch batch;
    Texture img;
    private BitmapFont font;
    UiManager uiManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        font = new BitmapFont();
        font.setColor(Color.BLACK);


        //create all commands
        CommandManager command = new CommandManager();
        command.registerCommand("army", new CommandArmyCreator());
        command.registerCommand("character", new CommandCharacterCreater());
        command.registerCommand("defense", new CommandDefenseCreator());
        command.registerCommand("user", new CommandUserCreator());
        command.registerCommand("village", new CommandVillageSettingsManager());
        command.registerCommand("weapon", new CommandWeaponCreator());
        command.registerCommand("game", new GameManagerCommand());
        
        //creat ui
        uiManager = new UiManager(command);
        uiManager.addUi("menu", new MenuUi(uiManager));
        uiManager.addUi("character", new CharacterCreatorUi(uiManager));
        uiManager.addUi("game", new GameUi(uiManager));
        uiManager.addUi("weapon", new WeaponCreatorUi(uiManager));
        uiManager.addUi("defense", new DefenseCreatorUi(uiManager));
        //set starting ui
        uiManager.setUi("menu");


    }

    @Override
    public void render() {
        //stores time passed on a variable
        elapsedTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
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
        uiManager.dispose();
    }
}
