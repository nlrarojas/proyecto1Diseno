/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Appearance;
import domain.Defense;
import java.util.ArrayList;
import model.command.CommandDefenseCreator;

/**
 *
 * @author Charlie
 */
public class DefenseCreatorUi implements IUserInterface {
    public Stage stage;
    private UiManager manager;

    
    //store new character data
    protected String name;
    protected int healt = 10;
    protected int appearance ;
    protected float attacSpeed = 1.0f;
    protected int level = 1;
    protected int minimunLevel = 1;
    protected int size = 1;
    protected int price = 5;
    protected String target = "";
    protected FileHandle[] defences;
    protected String[] defenceNames;
    
    protected final String[] TARGET_TYPES = {"Air","Ground","All"};
    
    public DefenseCreatorUi(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        
        //initialize and load file selector
        
        defences = Gdx.files.internal("defense/").list();
        defenceNames = new String[defences.length];
        for(int i = 0 ; i < defences.length; i++){
            defenceNames[i] = defences[i].name();
        }
        
        
        Skin skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
        
        //ui widgets 
        TextField nameField = new TextField("", skin);        
        SelectBox<String> appearenceSelection=new SelectBox<String>(skin);
        appearenceSelection.setItems(defenceNames);
        TextField healtField = new TextField("", skin);
        TextField attackSpeedField = new TextField("", skin);
        TextField levelField = new TextField("", skin);
        TextField minimunLevelField = new TextField("", skin);
        TextField sizeField = new TextField("", skin);
        TextField priceField = new TextField("", skin);
        SelectBox<String> targetField = new SelectBox<String>(skin);
        targetField.setItems("Air","Ground","All");
        TextButton saveButton = new TextButton("Save", skin);
        
        //ui labels
        Label nameLabel = new Label("Name: ", skin);
        Label healtLabel = new Label("Healt: ", skin);
        Label appearanceLabel = new Label("Appearance: ", skin);
        Label attackSpeedLabel = new Label("Attack Speed: ", skin);
        Label levelLabel = new Label("Level: ", skin);
        Label minimunLevelLabel = new Label("Minimun Level: ", skin);
        Label sizeLabel = new Label("Size: ", skin);
        Label priceLabel = new Label("Price: ", skin);
        Label targetLabel = new Label("Target: ", skin);
        
        //assign widget positions
        int widgetXpos = UiUtils.WIDHT/2 + 50;
        nameField.setPosition(widgetXpos, UiUtils.HEIGHT -100);
        healtField.setPosition(widgetXpos, UiUtils.HEIGHT -160);
        appearenceSelection.setPosition(widgetXpos, UiUtils.HEIGHT -240);
        attackSpeedField.setPosition(widgetXpos, UiUtils.HEIGHT -300);
        levelField.setPosition(widgetXpos, UiUtils.HEIGHT -360);
        minimunLevelField.setPosition(widgetXpos, UiUtils.HEIGHT -420);
        sizeField.setPosition(widgetXpos, UiUtils.HEIGHT -480);
        priceField.setPosition(widgetXpos, UiUtils.HEIGHT -540);
        targetField.setPosition(widgetXpos, UiUtils.HEIGHT -600);
        saveButton.setPosition(UiUtils.WIDHT/2-50, UiUtils.HEIGHT -720);
        
        //asing label positions
        int labelXpos = UiUtils.WIDHT/2 - 100;
        nameLabel.setPosition(labelXpos, UiUtils.HEIGHT -100);
        healtLabel.setPosition(labelXpos, UiUtils.HEIGHT -160);
        appearanceLabel.setPosition(labelXpos, UiUtils.HEIGHT -240);
        attackSpeedLabel.setPosition(labelXpos, UiUtils.HEIGHT -300);
        levelLabel.setPosition(labelXpos, UiUtils.HEIGHT -360);
        minimunLevelLabel.setPosition(labelXpos, UiUtils.HEIGHT -420);
        sizeLabel.setPosition(labelXpos, UiUtils.HEIGHT -480);
        priceLabel.setPosition(labelXpos, UiUtils.HEIGHT -540);
        targetLabel.setPosition(labelXpos, UiUtils.HEIGHT -600);
        
        //set widget sizes
        nameField.setSize(200, 50);
        healtField.setSize(200, 50);
        appearenceSelection.setSize(200, 50);
        attackSpeedField.setSize(200, 50);
        levelField.setSize(200, 50);
        minimunLevelField.setSize(200, 50);
        sizeField.setSize(200, 50);
        priceField.setSize(200, 50);
        targetField.setSize(200, 50);
        saveButton.setSize(100, 50);
        nameLabel.setSize(200, 50);
        healtLabel.setSize(200, 50);
        appearanceLabel.setSize(200, 50);
        attackSpeedLabel.setSize(200, 50);
        levelLabel.setSize(200, 50);
        minimunLevelLabel.setSize(200, 50);
        sizeLabel.setSize(200, 50);
        priceLabel.setSize(200, 50);
        targetLabel.setSize(200, 50);
        
        //add elements to stage
        stage.addActor(nameField);
        stage.addActor(healtField);
        stage.addActor(appearenceSelection);
        stage.addActor(attackSpeedField);
        stage.addActor(levelField);
        stage.addActor(minimunLevelField);
        stage.addActor(sizeField);
        stage.addActor(priceField);
        stage.addActor(targetField);
        stage.addActor(saveButton);
        stage.addActor(nameLabel);
        stage.addActor(healtLabel);
        stage.addActor(appearanceLabel);
        stage.addActor(attackSpeedLabel);
        stage.addActor(levelLabel);
        stage.addActor(minimunLevelLabel);
        stage.addActor(sizeLabel);
        stage.addActor(priceLabel);
        stage.addActor(targetLabel);
        
       
        //set default value
        healtField.setText(String.valueOf(healt));
        attackSpeedField.setText(String.valueOf(attacSpeed));
        levelField.setText(String.valueOf(level));
        minimunLevelField.setText(String.valueOf(minimunLevel));
        sizeField.setText(String.valueOf(size));
        priceField.setText(String.valueOf(price));
        
        //event handling
        nameField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                DefenseCreatorUi.this.name = ((TextField)actor).getText();
                //System.out.println("Button Pressed");
            }
        });
        
        healtField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    DefenseCreatorUi.this.healt = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.healt));
                }
        }     
        });
        
        attackSpeedField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isFloat(currentText)){
                    DefenseCreatorUi.this.attacSpeed = Float.parseFloat(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.attacSpeed));

                }
        }
       });
        
        
       levelField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    DefenseCreatorUi.this.level = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.level));
                }
        }     
        });
       
        minimunLevelField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    DefenseCreatorUi.this.minimunLevel = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.minimunLevel));
                }
        }     
        });
        
        sizeField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    DefenseCreatorUi.this.size = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.size));
                }
        }     
        });
        
        
        priceField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    DefenseCreatorUi.this.price = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(DefenseCreatorUi.this.price));
                }
        }     
        });
        
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                DefenseCreatorUi.this.saveDefense();
                DefenseCreatorUi.this.setUi("menu");
                
            }
        });
        
        //event handling
        targetField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                int selIndex = ((SelectBox)actor).getSelectedIndex();
                String curentSelection = DefenseCreatorUi.this.TARGET_TYPES[selIndex];
                DefenseCreatorUi.this.target = curentSelection;
                System.out.println(curentSelection);
            }
        });
        
        appearenceSelection.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                DefenseCreatorUi.this.appearance = ((SelectBox<String>)actor).getSelectedIndex();
                //System.out.println("Button Pressed");
            }
        });
       
    }
    
    protected void saveDefense(){
        
        System.out.println("sel ind: " + appearance);
        System.out.println(defences[appearance]);
        
        Appearance newAppearance = new Appearance("defense", defences[appearance].path());
        
        Defense newDefense = new Defense(name, newAppearance, size, price, level, size, minimunLevel, size,TARGET_TYPES);
        CommandDefenseCreator command = (CommandDefenseCreator)manager.getCommandManager().getCommand("defense");
        command.setDefense(newDefense);
        command.execute();
        command.save();
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
