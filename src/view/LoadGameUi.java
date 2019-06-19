/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Army;
import domain.Game;
import java.util.ArrayList;
import model.GameStorage;
import model.command.CommandArmyCreator;
import model.command.GameManagerCommand;

/**
 *
 * @author Charlie
 */
public class LoadGameUi implements IUserInterface{

    public  Stage stage;
    private UiManager manager;
    private Army army;
    private Skin skin;
    
    
    public LoadGameUi(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
    }
    
    
    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void activate() {
        displayGames();
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
    
    public void displayGames(){
        stage.dispose();
        stage = new Stage();
        
        //add back button
        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(200, 50);
        
        final GameManagerCommand command = (GameManagerCommand)manager.getCommandManager().getCommand("game");
        GameStorage storage = command.getStorage();
        ArrayList<Game> games = storage.getGames();
        
        
        final Table scrollTable = new Table();
        int count = 0;
        for(final Game game : games){
            final TextButton currentLoadButton = new TextButton("Game"+count, skin);
            currentLoadButton.setSize(100, 50);
            
            currentLoadButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //load level code
                
                command.setGame(game);
                command.execute();
                CommandArmyCreator commandArmy = (CommandArmyCreator) LoadGameUi.this.manager.getCommandManager().getCommand("army");
                commandArmy.setArmy(game.getArmy());
                LoadGameUi.this.setUi("menu");
            }
            });
            scrollTable.add(currentLoadButton);
            scrollTable.row();
            
            count++;
        }
        
        //generate scroll area
        final ScrollPane scroller = new ScrollPane(scrollTable);
        scroller.setPosition(50, UiUtils.HEIGHT -50);
        final Table table = new Table();
        table.setFillParent(true);
        table.add(scroller).fill().expand();        
        stage.addActor(table);
        
        
        stage.addActor(backButton);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                LoadGameUi.this.setUi("menu");
                
            }
        });
    }
    
    public void setUi(String name) {
        manager.setUi(name);
    }
    
    
}
