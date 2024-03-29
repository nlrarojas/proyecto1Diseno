package domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Weapon implements Serializable, IPrototype{

    protected String name;
    protected int scope;
    protected int damage;
    protected int level;
    protected int exposureRate;
    protected String imageName;
    protected transient Texture texture;
    protected transient Sprite sprite;

    public Weapon(String name, int scope, int damage, int level, int exposureRate, String image) {
        this.name = name;
        this.scope = scope;
        this.damage = damage;
        this.level = level;
        this.exposureRate = exposureRate;
        this.imageName = image;
        this.texture = new Texture(Gdx.files.absolute(image));
        this.sprite = new Sprite(this.texture);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExposureRate() {
        return exposureRate;
    }

    public void setExposureRate(int exposureRate) {
        this.exposureRate = exposureRate;
    }

    public String getImage() {
        return imageName;
    }

    public void setImage(String image) {
        this.imageName = image;
    }

    public Texture getTexture() {
        return texture;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", scope=" + scope + ", damage=" + damage + ", level=" + level + ", exposureRate=" + exposureRate + ", image=" + imageName + '}';
    }

    @Override
    public IPrototype clone() {
        return new Weapon(name, scope, damage, level, exposureRate, imageName);
    }

    @Override
    public IPrototype deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Texture loading patch
    private void writeObject(ObjectOutputStream oos) throws Exception 
    { 
        // to perform default serialization of Account object. 
        oos.defaultWriteObject(); 
  
        // epwd (encrypted password) 
        String savepath = imageName; 
  
        // writing encrypted password to the file 
        oos.writeObject(savepath); 
    } 
    
    
    private void readObject(ObjectInputStream ois) throws Exception 
    { 
        // performing default deserialization of Account object 
        ois.defaultReadObject(); 
        //load texture and create sprite after deserialization
        String savepath = (String)ois.readObject(); 
        System.out.println("path: " + savepath);
        this.texture = new Texture(Gdx.files.absolute(savepath));
        this.sprite = new Sprite(this.texture);
        
    } 
}
