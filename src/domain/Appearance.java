package domain;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Nelson
 */
public class Appearance {
    protected String type;
    protected String armor;
    protected String helmet;
    protected String chothing;
    
    //appearence textures
    protected Texture armorTexture;
    protected Texture helmetTexture;
    protected Texture clothingTexture;

    
    public Appearance(String type, String armor, String helmet, String chothing) {
        this.type = type;
        this.armor = armor;
        this.helmet = helmet;
        this.chothing = chothing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getChothing() {
        return chothing;
    }

    public void setChothing(String chothing) {
        this.chothing = chothing;
    }

    @Override
    public String toString() {
        return "Appearance{" + "type=" + type + ", armor=" + armor + ", helmet=" + helmet + ", chothing=" + chothing + '}';
    }

    public Texture getArmorTexture() {
        return armorTexture;
    }

    public void setArmorTexture(Texture armorTexture) {
        this.armorTexture = armorTexture;
    }

    public Texture getHelmetTexture() {
        return helmetTexture;
    }

    public void setHelmetTexture(Texture helmetTexture) {
        this.helmetTexture = helmetTexture;
    }

    public Texture getClothingTexture() {
        return clothingTexture;
    }

    public void setClothingTexture(Texture clothingTexture) {
        this.clothingTexture = clothingTexture;
    }
    
    
}
