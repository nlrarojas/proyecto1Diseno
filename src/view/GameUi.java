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
import domain.Village;
import domain.generators.VillageGenerator;
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
    CommandManager commandManager;
    private final UiManager manager;
    private Village village;


    public GameUi(UiManager manager) {
        this.manager = manager;
        //initialize command System----------------------------------------------------------------
        commandManager = manager.getCommandManager();
        stage = new Stage();
        
        
        
        
    }

    @Override
    public void render() {
        stage.draw();
        stage.act();
        village.draw();
    }

    @Override
    public void activate() {
        Gdx.input.setInputProcessor(stage);
        VillageGenerator generator = new VillageGenerator();
        village = generator.generateVillage(300);
    }

    public void setUi(String name) {
        manager.setUi(name);
    }
    
    public void dispose(){
        village.dispose();
        stage.dispose();
    }
}
