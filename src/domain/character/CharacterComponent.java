package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.Appearance;
import domain.IPrototype;
import domain.Weapon;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class CharacterComponent implements ICharacterDecorator, IPrototype {
    private static final long serialVersionUID = 7214685095267757690L;
    protected String name;
    protected Appearance appearance;
    protected int life;
    protected int punchesPerTime;
    protected int spaces;
    protected int appearanceLevel;
    protected int cost;
    protected Weapon weapon;
    
    public CharacterComponent(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        
        this.name = name;
        this.appearance = appearance;
        this.life = life;
        this.punchesPerTime = punchesPerTime;
        this.spaces = spaces;
        this.appearanceLevel = appearanceLevel;
        this.cost = cost;
        this.weapon = weapon;
    }
    
    public String getName(){
        return name;
    }

    @Override
    public void draw(SpriteBatch batch,int x ,int y) {
        appearance.draw(batch, x, y);
        
    }

    @Override
    public void simulate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICharacterDecorator getComponent() {
        return this;
    }

    @Override
    public IPrototype clone() {
        return new CharacterComponent(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }

    @Override
    public IPrototype deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean equals(CharacterComponent obj) {
        if (obj == null) return false;
        return obj.name.equals(name);
       
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPunchesPerTime() {
        return punchesPerTime;
    }

    public void setPunchesPerTime(int punchesPerTime) {
        this.punchesPerTime = punchesPerTime;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getAppearanceLevel() {
        return appearanceLevel;
    }

    public void setAppearanceLevel(int appearanceLevel) {
        this.appearanceLevel = appearanceLevel;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "CharacterComponent{" + "name=" + name + ", appearance=" + appearance + ", life=" + life + ", punchesPerTime=" + punchesPerTime + ", spaces=" + spaces + ", appearanceLevel=" + appearanceLevel + ", cost=" + cost + ", weapon=" + weapon + '}';
    }
    
    public void setSize(int width, int height){
        appearance.setSize(width, height);
    }
    
}
