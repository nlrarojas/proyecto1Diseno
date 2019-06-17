package view;

import com.badlogic.gdx.Gdx;
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

/**
 *
 * @author Charlie
 */
public class CreatorUi implements IUserInterface {
    public Stage stage;
    private UiManager manager;
    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f, 0.44f, 0.46f, 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f, 0.23f, 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);
    
    //store new character data
    protected String name;
    protected int healt = 10;
    protected Appearance appearance ;
    protected float attacSpeed = 1.0f;
    protected int level = 1;
    protected int minimunLevel = 1;
    protected int price = 5;
    
    
    
    
    public CreatorUi(UiManager manager) {
        this.manager = manager;
        stage = new Stage();
        
        Skin skin = new Skin(Gdx.files.internal("comic/skin/comic-ui.json"));
        
        
        //ui widgets 
        TextField nameField = new TextField("", skin);        
        SelectBox<String> appearenceSelection=new SelectBox<String>(skin);
        appearenceSelection.setItems("Dark","Light","Goblin","Shiny");
        TextField healtField = new TextField("", skin);
        TextField attackSpeedField = new TextField("", skin);
        TextField levelField = new TextField("", skin);
        TextField minimunLevelField = new TextField("", skin);
        TextField priceField = new TextField("", skin);
        TextButton saveButton = new TextButton("Save", skin);
        
        //ui labels
        Label nameLabel = new Label("Name: ", skin);
        Label healtLabel = new Label("Healt: ", skin);
        Label appearanceLabel = new Label("Appearance: ", skin);
        Label attackSpeedLabel = new Label("Attack Speed: ", skin);
        Label levelLabel = new Label("Level: ", skin);
        Label minimunLevelLabel = new Label("Minimun Level: ", skin);
        Label priceLabel = new Label("Price: ", skin);
        
        //assign widget positions
        int widgetXpos = UiUtils.WIDHT/2 + 50;
        nameField.setPosition(widgetXpos, UiUtils.HEIGHT -100);
        healtField.setPosition(widgetXpos, UiUtils.HEIGHT -180);
        appearenceSelection.setPosition(widgetXpos, UiUtils.HEIGHT -260);
        attackSpeedField.setPosition(widgetXpos, UiUtils.HEIGHT -340);
        levelField.setPosition(widgetXpos, UiUtils.HEIGHT -420);
        minimunLevelField.setPosition(widgetXpos, UiUtils.HEIGHT -500);
        priceField.setPosition(widgetXpos, UiUtils.HEIGHT -580);
        saveButton.setPosition(UiUtils.WIDHT/2-50, UiUtils.HEIGHT -660);
        
        //asing label positions
        int labelXpos = UiUtils.WIDHT/2 - 100;
        nameLabel.setPosition(labelXpos, UiUtils.HEIGHT -100);
        healtLabel.setPosition(labelXpos, UiUtils.HEIGHT -180);
        appearanceLabel.setPosition(labelXpos, UiUtils.HEIGHT -260);
        attackSpeedLabel.setPosition(labelXpos, UiUtils.HEIGHT -340);
        levelLabel.setPosition(labelXpos, UiUtils.HEIGHT -420);
        minimunLevelLabel.setPosition(labelXpos, UiUtils.HEIGHT -500);
        priceLabel.setPosition(labelXpos, UiUtils.HEIGHT -580);
        
        //set widget sizes
        nameField.setSize(200, 50);
        healtField.setSize(200, 50);
        appearenceSelection.setSize(200, 50);
        attackSpeedField.setSize(200, 50);
        levelField.setSize(200, 50);
        minimunLevelField.setSize(200, 50);
        priceField.setSize(200, 50);
        saveButton.setSize(100, 50);
        nameLabel.setSize(200, 50);
        healtLabel.setSize(200, 50);
        appearanceLabel.setSize(200, 50);
        attackSpeedLabel.setSize(200, 50);
        levelLabel.setSize(200, 50);
        minimunLevelLabel.setSize(200, 50);
        priceLabel.setSize(200, 50);
        
        //add elements to stage
        stage.addActor(nameField);
        stage.addActor(healtField);
        stage.addActor(appearenceSelection);
        stage.addActor(attackSpeedField);
        stage.addActor(levelField);
        stage.addActor(minimunLevelField);
        stage.addActor(priceField);
        stage.addActor(saveButton);
        stage.addActor(nameLabel);
        stage.addActor(healtLabel);
        stage.addActor(appearanceLabel);
        stage.addActor(attackSpeedLabel);
        stage.addActor(levelLabel);
        stage.addActor(minimunLevelLabel);
        stage.addActor(priceLabel);
       
        //set default value
        healtField.setText(String.valueOf(healt));
        attackSpeedField.setText(String.valueOf(attacSpeed));
        levelField.setText(String.valueOf(level));
        minimunLevelField.setText(String.valueOf(minimunLevel));
        priceField.setText(String.valueOf(price));
        
        //event handling
        nameField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                CreatorUi.this.name = ((TextField)actor).getText();
                //System.out.println("Button Pressed");
            }
        });
        
        healtField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                System.out.println(currentText);
                if(UiUtils.isInt(currentText)){
                    CreatorUi.this.healt = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CreatorUi.this.healt));
                }
        }     
        });
        
        attackSpeedField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                System.out.println(currentText);
                if(UiUtils.isFloat(currentText)){
                    CreatorUi.this.attacSpeed = Float.parseFloat(currentText);
                }else{
                    textField.setText(String.valueOf(CreatorUi.this.attacSpeed));

                }
        }
       });
        
        
       levelField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                System.out.println(currentText);
                if(UiUtils.isInt(currentText)){
                    CreatorUi.this.level = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CreatorUi.this.level));
                }
        }     
        });
       
        minimunLevelField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                System.out.println(currentText);
                if(UiUtils.isInt(currentText)){
                    CreatorUi.this.minimunLevel = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CreatorUi.this.minimunLevel));
                }
        }     
        });
        
        priceField.setTextFieldListener(new TextFieldListener() {
        @Override
        public void keyTyped(TextField textField, char key) {
            String currentText = textField.getText();
                System.out.println(currentText);
                if(UiUtils.isInt(currentText)){
                    CreatorUi.this.price = Integer.parseInt(currentText);
                }else{
                    textField.setText(String.valueOf(CreatorUi.this.price));
                }
        }     
        });
        
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //TODO add logic of character saving
                
                CreatorUi.this.setUi("menu");
                
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
