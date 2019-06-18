package domain;

import com.badlogic.gdx.graphics.Texture;
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
    protected Texture texture;

    public Weapon(String name, int scope, int damage, int level, int exposureRate, String image) {
        this.name = name;
        this.scope = scope;
        this.damage = damage;
        this.level = level;
        this.exposureRate = exposureRate;
        this.imageName = image;
        this.texture = new Texture(this.imageName);
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
}
