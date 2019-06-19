/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Army;
import domain.character.CharacterComponent;
import domain.character.ICharacterDecorator;
import domain.generators.CharacterGenerator;
import java.util.ArrayList;
import model.command.CommandArmyCreator;

/**
 *
 * @author Charlie
 */
public class ArmyManager implements IUserInterface{
    public  Stage stage;
    private UiManager manager;
    private Army army;
    private Skin skin;
    
    
    public ArmyManager(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
        DisplayList();
        
    }
    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void activate() {
        DisplayList();
        Gdx.input.setInputProcessor(stage);
        
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
    
    public void DisplayList(){
        stage.dispose();
        stage = new Stage();
        CommandArmyCreator command = ((CommandArmyCreator)manager.getCommandManager().getCommand("army"));
        army = command.getArmy();
        command.setLevel(1);
        
        
        final Table scrollTable = new Table();
        CharacterGenerator generator = CharacterGenerator.getInstance();
        ArrayList<ICharacterDecorator> characters = generator.getCharacters();
        int ypos = 100;
        
        
        for(final ICharacterDecorator currentChar : characters){
            CharacterComponent currentComp = (CharacterComponent)(currentChar.getComponent());
            final String name = currentComp.getName();
            System.out.println(currentComp);
            System.out.println(name);
            
            final Label currentLabel = new Label (name + ": " + army.count(name),skin);
            final TextButton currentPlusButton = new TextButton("+", skin);
            final TextButton currentLessButton = new TextButton("-", skin);
            //update button size
            currentPlusButton.setSize(50, 50);
            currentLessButton.setSize(50, 50);
            
            //button event listener
            currentPlusButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                ArmyManager.this.army.addCharacter(currentChar);
                currentLabel.setText(name + ": " + army.count(name));
            }
            
            });
            currentLessButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                ArmyManager.this.army.remove(name);
                currentLabel.setText(name + ": " + army.count(name));
            }
            
            });
            
            scrollTable.add(currentLabel);
            scrollTable.add(currentPlusButton);
            scrollTable.add(currentLessButton);
            scrollTable.row();
        }
        
        
        


        final ScrollPane scroller = new ScrollPane(scrollTable);
        scroller.setPosition(50, UiUtils.HEIGHT -50);
        
        final Table table = new Table();
        table.setFillParent(true);
        table.add(scroller).fill().expand();
        
        
        stage.addActor(table);
        
        //add back button
        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(200, 50);
        
        
        stage.addActor(backButton);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                ArmyManager.this.setUi("menu");
                
            }
        });
    }
    
    public void setUi(String name) {
        manager.setUi(name);
    }
    
}
