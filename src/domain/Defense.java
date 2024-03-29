package domain;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Nelson
 */
public class Defense implements IPrototype,Serializable, IObservableDefense {
    
    private static final long serialVersionUID = 6529685095267757690L;
    protected String name;
    protected Appearance appearance;
    protected int life;
    protected int punchesPerTime;
    protected int level;
    protected int spaces;
    protected int appearanceLevel;
    protected int range;
    protected String[] targetWarriors;
    protected transient ArrayList<IDefenseObserver> observers = new ArrayList<IDefenseObserver>();
    private double elapsedTime = 0;

    public Defense(String name, Appearance appearance, int life, int punchesPerTime, int level, int spaces, int appearanceLevel, int range, String[] targetWarriors) {
        this.name = name;
        this.appearance = appearance;
        this.life = life;
        this.punchesPerTime = punchesPerTime;
        this.level = level;
        this.spaces = spaces;
        this.appearanceLevel = appearanceLevel;
        this.range = range;
        this.targetWarriors = targetWarriors;
    }
    
    public void draw(SpriteBatch batch, int x, int y){
        appearance.draw(batch,x,y);
    }
    

    public void setSize(int width,int height){
        appearance.setSize(width, height);
    }
    
    public void dispose(){
        appearance.dispose();
    }
    
    //difficulty added to the game by the defense, is an aproximation
    public int getDifficulty(){
        return life + punchesPerTime*range*2 + level*5;
    }
    
    
    
    public String getName() {
        return name;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String[] getTargetWarriors() {
        return targetWarriors;
    }

    public void setTargetWarriors(String[] targetWarriors) {
        this.targetWarriors = targetWarriors;
    }

    @Override
    public String toString() {
        return "Defense{" + "name=" + name + ", appearance=" + appearance + ", life=" + life + ", punchesPerTime=" + punchesPerTime + ", level=" + level + ", spaces=" + spaces + ", appearanceLevel=" + appearanceLevel + ", range=" + range + ", targetWarriors=" + targetWarriors + '}';
    }

    @Override
    public IPrototype clone() {
        return new Defense(name, appearance, life, punchesPerTime, level, spaces, appearanceLevel, range, targetWarriors);
    }

    @Override
    public IPrototype deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void simulate(double deltaTime,Village vill,int xCoord, int yCoord){
        elapsedTime += deltaTime;
        
        if(elapsedTime >= 1){
            //System.out.println("simulating deff");
            elapsedTime = 0;
            boolean finished = false;
            for(int x = -range; x <= range; x++){
                for(int y = -range; y < range; y++){
                    int dist = (int)Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
                    if(vill.validTile(x+xCoord, y+yCoord) && vill.isUnit(x+xCoord, y+yCoord) && dist <= range){
                        vill.visitTile(x + xCoord, y + yCoord).attackUnit(punchesPerTime);
                        
                        System.out.println("x: "+ (x) + " y: "+ (y) );
                        finished = true;
                        break;
                    }
                }
                if(finished)break;
            }
            }
        
    }
    
    public void attack(int damage){
        life -= damage;
        if(life <= 0){
            notifyObservers();
        }
        
    }

    @Override
    public void notifyObservers() {
        for(IDefenseObserver obs : observers){
            obs.notify(this);
        }
    }

    @Override
    public void addObserver(IDefenseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IDefenseObserver observer) {
        observers.remove(this);
    }
}
