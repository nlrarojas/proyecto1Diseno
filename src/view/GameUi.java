package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Game;
import domain.Village;
import domain.generators.VillageGenerator;
import model.command.CommandManager;
import model.command.GameManagerCommand;

/**
 *
 * @author Charlie
 */
public class GameUi implements IUserInterface {

    public Stage stage;
    private final UiManager manager;
    private Village village;
    private Skin skin;


    public GameUi(UiManager manager) {
        this.manager = manager;
        //initialize command System----------------------------------------------------------------
        stage = new Stage();
        
        
        skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
         //add back button
        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(100, 50);
        
        
        stage.addActor(backButton);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                
                GameUi.this.setUi("menu");
                
            }
        });
        
         //add back button
        TextButton saveButton = new TextButton("Save", skin);
        saveButton.setSize(100, 50);
        saveButton.setPosition(100, 0);
        
        stage.addActor(saveButton);
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                GameManagerCommand command = (GameManagerCommand) GameUi.this.manager.getCommandManager().getCommand("game");
                command.execute();
                command.save();
                System.out.println("saved game");
                //GameUi.this.setUi("menu");
                
            }
        });
        
        
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
        GameManagerCommand command = (GameManagerCommand) manager.getCommandManager().getCommand("game");
        
        Game currentGame = command.getStorage().getCurrentGame();
        if(currentGame.getVillage() == null){
            currentGame.generateVillage();
        }
        
        village = currentGame.getVillage();
        
        
    }

    public void setUi(String name) {
        manager.setUi(name);
    }
    
    public void dispose(){
        village.dispose();
        stage.dispose();
    }
}
