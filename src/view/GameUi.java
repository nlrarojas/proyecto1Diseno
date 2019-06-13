/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 *
 * @author Charlie
 */
public class GameUi {
    public Stage stage;
    TextButton button;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    
    
    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f,0.44f ,0.46f , 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f,0.23f , 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);    
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);

    
    public GameUi() {      
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        
        //styles -----------------------------------------------------------------------------------
        
        //button style
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = createButtonSprite(IDDLE_BUTTON, 100, 40);
        textButtonStyle.down = createButtonSprite(DOWN_BUTTON, 100, 40);
        //textButtonStyle.checked = createButtonSprite(CHECKED_BUTTON, 100, 40);
        
        //text field style
        TextFieldStyle textFieldStyle = new TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.background = createButtonSprite(IDDLE_BUTTON, 100, 40);
        textFieldStyle.cursor = createButtonSprite(Color.BLACK, 5, 40);
        textFieldStyle.selection = createRectSprite(SELECTED_TEXT, 10, 10);
        textFieldStyle.fontColor = Color.BLACK;
        
        
        //create ui elements -----------------------------------------------------------------------
        button = new TextButton("Button1", textButtonStyle);
        button.setPosition(0, 400);
        
        TextField textField = new TextField("Data",textFieldStyle);
        textField.setPosition(24,73);
        textField.setSize(200, 40);
        
        
        //add ui elements to scene ------------------------------------------------------------------
        stage.addActor(button);
        stage.addActor(textField);
        Gdx.input.setInputProcessor(stage);
        
        
        //event listerner
        button.addListener(new ChangeListener() {
        @Override
        public void changed (ChangeEvent event, Actor actor) {
            System.out.println("Button Pressed");
        }
        });
        
        
        textField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println(((TextField)actor).getText());
            }
        });
    }
    

    public void render() {      
        stage.draw();
        stage.act();
    }
    
    
    
    
    //utility function to create drawable for button background
    private TextureRegionDrawable createButtonSprite(Color bgColor, int width, int height){
        Pixmap newGraphicMap = new Pixmap(width,height, Pixmap.Format.RGBA8888);
        
        //Fill it red
        newGraphicMap.setColor(bgColor);
        newGraphicMap.fill();
        
        //Draw two lines forming an X
        newGraphicMap.setColor(Color.BLACK);
        
        //size constants
        int top = newGraphicMap.getHeight()-1;
        int right = newGraphicMap.getWidth()-1;
        //create border
        newGraphicMap.drawLine(0, 0, right, 0);
        newGraphicMap.drawLine(0, top, right, top);
        newGraphicMap.drawLine(right, top, right, 0);
        newGraphicMap.drawLine(0, top, 0, 0);

       
        
        Texture newTexture = new Texture(newGraphicMap);
        //deleta pixmap
        newGraphicMap.dispose();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(newTexture));
        
        return drawable;
    }
    
     private TextureRegionDrawable createRectSprite(Color bgColor, int width, int height){
        Pixmap newGraphicMap = new Pixmap(width,height, Pixmap.Format.RGBA8888);
        
        //Fill it red
        newGraphicMap.setColor(bgColor);
        newGraphicMap.fill();
        
        //Draw two lines forming an X
        newGraphicMap.setColor(Color.BLACK);
       
        Texture newTexture = new Texture(newGraphicMap);
        //deleta pixmap
        newGraphicMap.dispose();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(newTexture));
        
        return drawable;
    }
    
     
}
