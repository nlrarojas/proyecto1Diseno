package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import domain.Appearance;
import domain.Weapon;
import domain.character.CharacterComponent;
import domain.character.ICharacterDecorator;
import domain.character.LandWarrior;
import domain.generators.WeaponGenerator;
import model.command.CommandCharacterCreater;

/**
 *
 * @author Charlie
 */
public class CharacterCreatorUi implements IUserInterface {
    public Stage stage;
    private UiManager manager;

    
    //store new character data
    protected String name;
    protected int healt = 10;
    protected int appearance ;
    protected int attacSpeed = 1;
    protected int level = 1;
    protected int minimunLevel = 1;
    protected int size = 1;
    protected int price = 5;
    protected int weapon = 0;
    private SelectBox<String> weaponSelection;
    protected FileHandle[] characters;
    protected String[] characterNames;
    String[] weaponNames;
    
    
    
    
    
    
    public CharacterCreatorUi(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        
        //initialize and load file selector
        characters = Gdx.files.internal("character/").list();
        characterNames = new String[characters.length];
        for(int i = 0 ; i < characters.length; i++){
            characterNames[i] = characters[i].name();
        }
        
        Skin skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        WeaponGenerator generator = WeaponGenerator.GetInstance();
        weaponNames = generator.getWeaponNames();
        
        //ui widgets 
        TextField nameField = new TextField("", skin);        
        SelectBox<String> appearenceSelection=new SelectBox<String>(skin);
        appearenceSelection.setItems(characterNames);
        TextField healtField = new TextField("", skin);
        TextField attackSpeedField = new TextField("", skin);
        TextField levelField = new TextField("", skin);
        TextField minimunLevelField = new TextField("", skin);
        TextField sizeField = new TextField("", skin);
        TextField priceField = new TextField("", skin);
        weaponSelection = new SelectBox<String>(skin);
        weaponSelection.setItems(weaponNames);
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
        Label weaponLabel = new Label("Weapon: ", skin);
        
        //assign widget positions
        int widgetXpos = UiUtils.WIDHT/2 + 50;
        nameField.setPosition(widgetXpos, UiUtils.HEIGHT -100);
        healtField.setPosition(widgetXpos, UiUtils.HEIGHT -180);
        appearenceSelection.setPosition(widgetXpos, UiUtils.HEIGHT -260);
        attackSpeedField.setPosition(widgetXpos, UiUtils.HEIGHT -340);
        levelField.setPosition(widgetXpos, UiUtils.HEIGHT -420);
        minimunLevelField.setPosition(widgetXpos, UiUtils.HEIGHT -500);
        sizeField.setPosition(widgetXpos, UiUtils.HEIGHT -580);
        priceField.setPosition(widgetXpos, UiUtils.HEIGHT -660);
        weaponSelection.setPosition(widgetXpos,  UiUtils.HEIGHT -720);
        saveButton.setPosition(0, 0);
        
        //asing label positions
        int labelXpos = UiUtils.WIDHT/2 - 100;
        nameLabel.setPosition(labelXpos, UiUtils.HEIGHT -100);
        healtLabel.setPosition(labelXpos, UiUtils.HEIGHT -180);
        appearanceLabel.setPosition(labelXpos, UiUtils.HEIGHT -260);
        attackSpeedLabel.setPosition(labelXpos, UiUtils.HEIGHT -340);
        levelLabel.setPosition(labelXpos, UiUtils.HEIGHT -420);
        minimunLevelLabel.setPosition(labelXpos, UiUtils.HEIGHT -500);
        sizeLabel.setPosition(labelXpos, UiUtils.HEIGHT -580);
        priceLabel.setPosition(labelXpos, UiUtils.HEIGHT -660);
        weaponLabel.setPosition(labelXpos, UiUtils.HEIGHT -720);
        
        //set widget sizes
        nameField.setSize(200, 50);
        healtField.setSize(200, 50);
        appearenceSelection.setSize(200, 50);
        attackSpeedField.setSize(200, 50);
        levelField.setSize(200, 50);
        minimunLevelField.setSize(200, 50);
        sizeField.setSize(200, 50);
        priceField.setSize(200, 50);
        weaponSelection.setSize(200, 50);
        saveButton.setSize(100, 50);
        nameLabel.setSize(200, 50);
        healtLabel.setSize(200, 50);
        appearanceLabel.setSize(200, 50);
        attackSpeedLabel.setSize(200, 50);
        levelLabel.setSize(200, 50);
        minimunLevelLabel.setSize(200, 50);
        sizeLabel.setSize(200, 50);
        priceLabel.setSize(200, 50);
        weaponLabel.setSize(200, 50);
        
        
        //add elements to stage
        stage.addActor(nameField);
        stage.addActor(healtField);
        stage.addActor(appearenceSelection);
        stage.addActor(attackSpeedField);
        stage.addActor(levelField);
        stage.addActor(minimunLevelField);
        stage.addActor(sizeField);
        stage.addActor(priceField);
        stage.addActor(weaponSelection);
        stage.addActor(saveButton);
        stage.addActor(nameLabel);
        stage.addActor(healtLabel);
        stage.addActor(appearanceLabel);
        stage.addActor(attackSpeedLabel);
        stage.addActor(levelLabel);
        stage.addActor(minimunLevelLabel);
        stage.addActor(sizeLabel);
        stage.addActor(priceLabel);
        stage.addActor(weaponLabel);
       
        //set default value
        healtField.setText(String.valueOf(healt));
        attackSpeedField.setText(String.valueOf(attacSpeed));
        levelField.setText(String.valueOf(level));
        minimunLevelField.setText(String.valueOf(minimunLevel));
        sizeField.setText(String.valueOf(size));
        priceField.setText(String.valueOf(price));
        
        //event handling
        nameField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
            CharacterCreatorUi.this.name = currentText;
        }     
        });
        
        healtField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.healt = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.healt));
                }
        }     
        });
        
        attackSpeedField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.attacSpeed = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.attacSpeed));

                }
        }
       });
        
        
       levelField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.level = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.level));
                }
        }     
        });
       
        minimunLevelField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.minimunLevel = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.minimunLevel));
                }
        }     
        });
        
        sizeField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.size = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.size));
                }
        }     
        });
        
        
        priceField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                if(UiUtils.isInt(currentText)){
                    CharacterCreatorUi.this.price = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CharacterCreatorUi.this.price));
                }
        }     
        });
        
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                CharacterCreatorUi.this.createCharacter();
                CharacterCreatorUi.this.setUi("menu");
                
            }
        });
        
        appearenceSelection.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                CharacterCreatorUi.this.appearance = ((SelectBox<String>)actor).getSelectedIndex();
                //System.out.println("Button Pressed");
            }
        });
       
        weaponSelection.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                CharacterCreatorUi.this.weapon = ((SelectBox<String>)actor).getSelectedIndex();
                //System.out.println("Button Pressed");
            }
        });
        
        
        //add back button
        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(100, 50);
        backButton.setPosition(100, 0);
        
        
        stage.addActor(backButton);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                CharacterCreatorUi.this.setUi("menu");
                
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
        WeaponGenerator generator = WeaponGenerator.GetInstance();
        weaponNames = generator.getWeaponNames();
        weaponSelection.setItems(weaponNames);
    }
    
    protected void createCharacter(){
        CommandCharacterCreater commandCharacter = (CommandCharacterCreater)manager.getCommandManager().getCommand("character");
        Weapon dummyWeapon = WeaponGenerator.GetInstance().getWeapon(weaponNames[weapon]);
        Appearance newAppearance = new Appearance("character", characters[appearance].path());
        CharacterComponent newCharacter= new CharacterComponent(name, newAppearance, healt, attacSpeed, size, minimunLevel, healt, dummyWeapon);
        ICharacterDecorator newFullCharacter = new LandWarrior(newCharacter);
        commandCharacter.setCharacter(newFullCharacter);
        
        commandCharacter.execute();
        commandCharacter.save();
    }
    
    public void setUi(String name) {
        manager.setUi(name);
    }
    
    public void dispose(){
        stage.dispose();
    }
}
