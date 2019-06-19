package domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Appearance implements Serializable{
    private static final long serialVersionUID = 7529637895267716690L;
    protected String type;
    protected String path;
    protected transient Sprite appearanceSprite;
    protected transient Texture appearanceTexture;

    public Appearance(String type, String path) {
        this.type = type;
        this.path = path;
        this.appearanceTexture = new Texture(Gdx.files.absolute(path));
        this.appearanceSprite = new Sprite(appearanceTexture);
    }

    public Appearance(String type, String path,Texture appearanceTexture) {
        this.type = type;
        this.appearanceTexture = appearanceTexture;
        appearanceSprite = new Sprite(appearanceTexture); 
    }
    
    public void setSize(int width,int height){
        appearanceSprite.setSize(width, height);
    }
    
    public void draw(SpriteBatch batch, int x, int y){
        appearanceSprite.setPosition(x, y);
        appearanceSprite.draw(batch);
    }
    
    public void dispose(){
        appearanceTexture.dispose();
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Appearance{" + "type=" + type + ", path=" + path + ", appearanceTexture=" + appearanceTexture + '}';
    }
     private void writeObject(ObjectOutputStream oos) throws Exception 
    { 
        // to perform default serialization of Account object. 
        oos.defaultWriteObject(); 
  
        // epwd (encrypted password) 
        String savepath = path; 
  
        // writing encrypted password to the file 
        oos.writeObject(savepath); 
    } 
     private void readObject(ObjectInputStream ois) throws Exception 
    { 
        // performing default deserialization of Account object 
        ois.defaultReadObject(); 
        //load texture and create sprite after deserialization
        String savepath = (String)ois.readObject(); 
        //System.out.println("path: " + savepath);
        this.appearanceTexture = new Texture(Gdx.files.absolute(savepath));
        this.appearanceSprite = new Sprite(appearanceTexture);
    } 
    
}
