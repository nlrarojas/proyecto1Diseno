package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
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
public class GameUi implements IUserInterface {

    public Stage stage;
    TextButton button;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    CommandManager commandManager;
    private final UiManager manager;

    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f, 0.44f, 0.46f, 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f, 0.23f, 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);

    public GameUi(UiManager manager) {
        this.manager = manager;
        //initialize command System----------------------------------------------------------------
        commandManager = new CommandManager();
        commandManager.registerCommand("Army", new CommandArmyCreator());
        commandManager.registerCommand("Character", new CommandCharacterCreater());
        commandManager.registerCommand("Defense", new CommandDefenseCreator());
        commandManager.registerCommand("User", new CommandUserCreator());
        commandManager.registerCommand("Village", new CommandVillageSettingsManager());
        commandManager.registerCommand("Weapon", new CommandWeaponCreator());

        stage = new Stage();
        font = new BitmapFont();

        //styles -----------------------------------------------------------------------------------
        //button style
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = UiUtils.createButtonSprite(IDDLE_BUTTON, 100, 40);
        textButtonStyle.down = UiUtils.createButtonSprite(DOWN_BUTTON, 100, 40);
        //textButtonStyle.checked = createButtonSprite(CHECKED_BUTTON, 100, 40);

        //text field style
        TextFieldStyle textFieldStyle = new TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.background = UiUtils.createButtonSprite(IDDLE_BUTTON, 100, 40);
        textFieldStyle.cursor = UiUtils.createButtonSprite(Color.BLACK, 5, 40);
        textFieldStyle.selection = UiUtils.createRectSprite(SELECTED_TEXT, 10, 10);
        textFieldStyle.fontColor = Color.BLACK;

        //create ui elements -----------------------------------------------------------------------
        button = new TextButton("Button1", textButtonStyle);
        button.setPosition(0, 400);

        TextField textField = new TextField("Data", textFieldStyle);
        textField.setPosition(24, 73);
        textField.setSize(200, 40);

        //add ui elements to scene ------------------------------------------------------------------
        stage.addActor(button);
        stage.addActor(textField);

        //event listerner
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button Pressed");
            }
        });

        textField.addListener(new ChangeListener() {
            String previousValue = "";
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String currentText = ((TextField)actor).getText();
                if(UiUtils.isFloat(currentText)){
                    previousValue = currentText;
                    
                }
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
}
