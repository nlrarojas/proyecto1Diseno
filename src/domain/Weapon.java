package domain;

/**
 *
 * @author Nelson
 */
public class Weapon {
    protected String name;
    protected int scope;
    protected int damage;
    protected int level;
    protected int exposureRate;
    protected String image;

    public Weapon(String name, int scope, int damage, int level, int exposureRate, String image) {
        this.name = name;
        this.scope = scope;
        this.damage = damage;
        this.level = level;
        this.exposureRate = exposureRate;
        this.image = image;
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
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", scope=" + scope + ", damage=" + damage + ", level=" + level + ", exposureRate=" + exposureRate + ", image=" + image + '}';
    }    
}
