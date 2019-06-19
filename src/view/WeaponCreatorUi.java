/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Weapon;
import model.command.CommandWeaponCreator;

/**
 *
 * @author Charlie
 */
public class WeaponCreatorUi implements IUserInterface{
    public Stage stage;
    private UiManager manager;
    
    
    protected String name   = "";
    protected int appearance  = 0;
    protected int range     = 1;
    protected int attack    = 1;
    protected int explotion = 0;
    protected FileHandle[] weapons;
    protected String[] weaponNames;
     //store new weapon data

    public WeaponCreatorUi(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        
        //initialize and load file selector
        weapons = Gdx.files.internal("weapon/").list();
        weaponNames = new String[weapons.length];
        for(int i = 0 ; i < weapons.length; i++){
            weaponNames[i] = weapons[i].name();
        }
        
        
        
        Skin skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
        
        //ui widgets 
        TextField nameField = new TextField("", skin);
        SelectBox<String> appearenceSelection=new SelectBox<String>(skin);
        appearenceSelection.setItems(weaponNames);
        TextField attackField = new TextField("", skin);
        TextField explotionField = new TextField("", skin);
        TextField rangeField = new TextField("", skin);
        TextButton saveButton = new TextButton("Save", skin);
        
        //ui labels
        Label nameLabel = new Label("Name: ", skin);
        Label imageLabel = new Label("Image: ", skin);
        Label attackLabel = new Label("Attack: ", skin);
        Label explotionLabel = new Label("Explotion: ", skin);
        Label rangeLabel = new Label("Range: ", skin);
        
        //assign widget positions
        int widgetXpos = UiUtils.WIDHT/2 + 50;
        nameField.setPosition(widgetXpos, UiUtils.HEIGHT -200);
        appearenceSelection.setPosition(widgetXpos, UiUtils.HEIGHT -280);
        attackField.setPosition(widgetXpos, UiUtils.HEIGHT -360);
        explotionField.setPosition(widgetXpos, UiUtils.HEIGHT -440);
        rangeField.setPosition(widgetXpos, UiUtils.HEIGHT -520);
        saveButton.setPosition(UiUtils.WIDHT/2-50, UiUtils.HEIGHT -720);
        
         //asing label positions
        int labelXpos = UiUtils.WIDHT/2 - 100;
        nameLabel.setPosition(labelXpos, UiUtils.HEIGHT -200);
        imageLabel.setPosition(labelXpos, UiUtils.HEIGHT -280);
        attackLabel.setPosition(labelXpos, UiUtils.HEIGHT -360);
        explotionLabel.setPosition(labelXpos, UiUtils.HEIGHT -440);
        rangeLabel.setPosition(labelXpos, UiUtils.HEIGHT -520);
        
        //set widget sizes
        nameField.setSize(200, 50);
        appearenceSelection.setSize(200, 50);
        attackField.setSize(200, 50);
        explotionField.setSize(200, 50);
        rangeField.setSize(200, 50);
        nameLabel.setSize(200, 50);
        imageLabel.setSize(200, 50);
        attackLabel.setSize(200, 50);
        explotionLabel.setSize(200, 50);
        rangeLabel.setSize(200, 50);
        saveButton.setSize(100, 50);
        
        //add elements to stage
        stage.addActor(nameField);
        stage.addActor(appearenceSelection);
        stage.addActor(attackField);
        stage.addActor(explotionField);
        stage.addActor(rangeField);
        stage.addActor(nameLabel);
        stage.addActor(imageLabel);
        stage.addActor(attackLabel);
        stage.addActor(explotionLabel);
        stage.addActor(rangeLabel);
        stage.addActor(saveButton);
        
        //set default value
        nameField.setText(String.valueOf(name));
        attackField.setText(String.valueOf(attack));
        explotionField.setText(String.valueOf(explotion));
        rangeField.setText(String.valueOf(range));
        
        //event handling
        nameField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
            WeaponCreatorUi.this.name = currentText;    
        }     
        });
        attackField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    WeaponCreatorUi.this.attack = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(WeaponCreatorUi.this.attack));
                }
        }     
        });
        explotionField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    WeaponCreatorUi.this.explotion = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(WeaponCreatorUi.this.explotion));
                }
        }     
        });
        rangeField.setTextFieldListener(new TextField.TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    WeaponCreatorUi.this.range = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(WeaponCreatorUi.this.range));
                }
        }     
        });
        
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                
                WeaponCreatorUi.this.setUi("menu");
                
            }
        });
        
        
        appearenceSelection.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                WeaponCreatorUi.this.appearance = ((SelectBox<String>)actor).getSelectedIndex();
                //System.out.println("Button Pressed");
            }
        });
        
    }
    
    
    protected void saveWeapon(){
        //load weapon path
        String fullImagePath = weapons[appearance].path();
        Weapon newWeapon = new Weapon(name, range, attack, 0, explotion, fullImagePath);
        CommandWeaponCreator command =  (CommandWeaponCreator)manager.getCommandManager().getCommand("weapon");
        command.setWeapon(newWeapon);
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
