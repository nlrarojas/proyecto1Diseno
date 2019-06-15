/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import model.command.CommandArmyCreator;
import model.command.CommandCharacterCreater;
import model.command.CommandDefenseCreator;
import model.command.CommandManager;
import model.command.CommandUserCreator;
import model.command.CommandVillageSettingsManager;
import model.command.CommandWeaponCreator;

/**
 *
 * @author Charlie
 */
public class MenuUi implements IUserInterface {
    public Stage stage;
    //TextButton button;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    CommandManager commandManager;
    private UiManager manager;
    
    
    //ui elements
    //TextButton playButton;
    //TextButton createButton;
    //TextButton exitButton;
    //TextField textField;
    
    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f,0.44f ,0.46f , 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f,0.23f , 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);    
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);

    
    public MenuUi(UiManager manager) { 
        this.manager = manager;
        //initiali ze command System----------------------------------------------------------------
        commandManager = new CommandManager();
        commandManager.registerCommand("Army", new CommandArmyCreator());
        commandManager.registerCommand("Character", new CommandCharacterCreater());
        commandManager.registerCommand("Defense", new CommandDefenseCreator());
        commandManager.registerCommand("User", new CommandUserCreator());
        commandManager.registerCommand("Village", new CommandVillageSettingsManager());
        commandManager.registerCommand("Weapon", new CommandWeaponCreator());
        
        
        
        stage = new Stage();
        font = new BitmapFont();
        //font.getData().setScale(2,2);
        
        //styles -----------------------------------------------------------------------------------
        
        //button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = UiUtils.createButtonSprite(IDDLE_BUTTON, 200, 60);
        textButtonStyle.down = UiUtils.createButtonSprite(DOWN_BUTTON, 200, 60);
        //textButtonStyle.checked = createButtonSprite(CHECKED_BUTTON, 100, 40);
        
        //text field style
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.background = UiUtils.createButtonSprite(IDDLE_BUTTON, 100, 40);
        textFieldStyle.cursor = UiUtils.createButtonSprite(Color.BLACK, 5, 40);
        textFieldStyle.selection = UiUtils.createRectSprite(SELECTED_TEXT, 10, 10);
        textFieldStyle.fontColor = Color.BLACK;
        
        
        //create ui elements -----------------------------------------------------------------------
        TextButton playButton = new TextButton("Play", textButtonStyle);
        playButton.setPosition( UiUtils.WIDHT/2 - 100,UiUtils.HEIGHT-300);
        
        TextButton createButton = new TextButton("Create", textButtonStyle);
        createButton.setPosition(UiUtils.WIDHT/2 - 100,UiUtils.HEIGHT-450);
        
        TextButton exitButton = new TextButton("Exit", textButtonStyle);
        exitButton.setPosition(UiUtils.WIDHT/2 - 100,UiUtils.HEIGHT-600);
        
        TextField textField = new TextField("Data",textFieldStyle);
        textField.setPosition(24,73);
        textField.setSize(200, 40);
        
        
        //add ui elements to scene ------------------------------------------------------------------
        stage.addActor(playButton);
        stage.addActor(createButton);
        stage.addActor(exitButton);
        stage.addActor(textField);
        
        
        //event listerner----------------------------------------------------------------------------
        playButton.addListener(new ChangeListener() {
        @Override
        public void changed (ChangeListener.ChangeEvent event, Actor actor) {
            MenuUi.this.setUi("game");
            System.out.println("Going to game");
        }
        });
        
        createButton.addListener(new ChangeListener() {
        @Override
        public void changed (ChangeListener.ChangeEvent event, Actor actor) {
            MenuUi.this.setUi("creator");
            System.out.println("Going to creator");
        }
        });
        
        exitButton.addListener(new ChangeListener() {
        @Override
        public void changed (ChangeListener.ChangeEvent event, Actor actor) {
            System.out.println("Going to exit");
              Gdx.app.exit();
        }
        });
         
        
        
    }
    

    public void render() {      
        stage.draw();
        stage.act();
    }
    

    public void activate(){
        Gdx.input.setInputProcessor(stage);
        
        
    }
    
    public void setUi(String name){
        manager.setUi(name);
    }
    
}
