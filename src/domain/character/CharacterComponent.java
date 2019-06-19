package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.Appearance;
import domain.ICharacterObserver;
import domain.IPrototype;
import domain.Village;
import domain.VillageTile;
import domain.Weapon;
import java.io.Serializable;
import java.util.ArrayList;

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
    protected double elasepTime = 0;
    protected ArrayList<ICharacterObserver> observers = new ArrayList<ICharacterObserver>() ;
    
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
    public void simulate(double deltaTime,Village vil,int xCoord, int yCoord) {
        elasepTime += deltaTime;
        if(elasepTime > 1){
        elasepTime = 0;
        VillageTile currTile = vil.visitTile(xCoord, yCoord);
        int newX = (int)(-1  + Math.random()*2.99f  + xCoord);
        int newY = (int)(-1  + Math.random()*2.99f + yCoord) ;
        //System.out.println("moving... " + newX + ", "+newY);
        if(vil.freeTile(newX, newY) && (newX != xCoord || newY != yCoord)){
            VillageTile newTile = vil.visitTile(newX, newY);
            currTile.removeCharacter(this);
            newTile.addCharacter(this);
            //System.out.println("moving... " + newX + ", "+newY);
        }
        
        //attack routine
        int range = weapon.getScope();
        boolean finished = false;
        for(int x = -range; x <= range; x++){
            for(int y = -range; y < range; y++){
                int dist = (int)Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
                if(vil.validTile(x+xCoord, y+yCoord) && ! vil.freeTile(x+xCoord, y+yCoord) && dist <= range){
                    vil.visitTile(x + xCoord, y + yCoord).attackTile(punchesPerTime*weapon.getDamage());
                    //System.out.println("x: "+ (x) + " y: "+ (y) + "--" + weapon);
                    finished = true;
                    break;
                }else if(vil.validTile(x+xCoord, y+yCoord) && vil.isOverTownHall(x+xCoord, y+yCoord) && dist <= range){
                    vil.attackTheVillage(punchesPerTime*weapon.getDamage());
                    finished = true;
                    break;
                }
            }
            if(finished)break;
        }
        }
       
        
        
    }
    
    @Override
    public void attack(int damage) {
        life -= damage;
        System.out.println("attacked char: " + life);    
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
    @Override
    public void notifyObservers() {
        for(ICharacterObserver obs : observers){
            obs.notify(this);
        }
    }

    @Override
    public void addObserver(ICharacterObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ICharacterObserver observer) {
        observers.remove(observer);
    }
    
}
