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
    private final UiManager manager;

    //ui elements
    //TextButton playButton;
    //TextButton createButton;
    //TextButton exitButton;
    //TextField textField;
    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f, 0.44f, 0.46f, 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f, 0.23f, 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);

    public MenuUi(UiManager manager) {
        this.manager = manager;

        stage = new Stage();
        //load style from skin
        Skin skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        //font.getData().setScale(2,2);

        int buttonWidht = 300;
        int buttonHeight = 60;

        //create ui elements -----------------------------------------------------------------------
        TextButton playButton = new TextButton("Play", skin);
        playButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 100);
        playButton.setSize(buttonWidht, buttonHeight);
        
        TextButton loadButton = new TextButton("Load Game", skin);
        loadButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 200);
        loadButton.setSize(buttonWidht, buttonHeight);

        TextButton characterButton = new TextButton("Character", skin);
        characterButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 300);
        characterButton.setSize(buttonWidht, buttonHeight);
        
        TextButton weaponButton = new TextButton("Weapon", skin);
        weaponButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 400);
        weaponButton.setSize(buttonWidht, buttonHeight);
        
        TextButton defenseButton = new TextButton("Defense", skin);
        defenseButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 500);
        defenseButton.setSize(buttonWidht, buttonHeight);
        
        TextButton armyButton = new TextButton("Army", skin);
        armyButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 600);
        armyButton.setSize(buttonWidht, buttonHeight);
        
        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.setPosition(UiUtils.WIDHT / 2 - 100, UiUtils.HEIGHT - 700);
        exitButton.setSize(buttonWidht, buttonHeight);


        //add ui elements to scene ------------------------------------------------------------------
        stage.addActor(playButton);
        stage.addActor(loadButton);
        stage.addActor(characterButton);
        stage.addActor(weaponButton);
        stage.addActor(defenseButton);
        stage.addActor(armyButton);
        stage.addActor(exitButton);
        
        //event listerner----------------------------------------------------------------------------
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("game");
                System.out.println("Going to game");
            }
        });
        
        loadButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("load");
                System.out.println("Going to load");
            }
        });

        characterButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("character");
                System.out.println("Going to creator");
            }
        });
        
        weaponButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("weapon");
                System.out.println("Going to weapon");
            }
        });
        
        defenseButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("defense");
                System.out.println("Going to defense");
            }
        });
        
        armyButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                MenuUi.this.setUi("army");
                System.out.println("Going to army");
            }
        });
        
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Going to exit");
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render() {
        stage.draw();
        stage.act();
    }

    @Override
    public void activate() {
        Gdx.input.setInputProcessor(stage);

    }

    public void setUi(String name) {
        manager.setUi(name);
    }
    public void dispose(){
        stage.dispose();
    }
}
