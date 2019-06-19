package domain;

import domain.character.ICharacterDecorator;
import domain.generators.VillageGenerator;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Game implements Serializable,IDefenseObserver,ICharacterObserver {
    private static final long serialVersionUID = 7529635555000999321L;
    protected Army army;
    protected int level;
    protected Village village;
    public boolean movingArmy;


    public Game(Army army, int level) {
        this.army = army;
        this.level = level;
        movingArmy = false;
        //deployArmy();
        
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        movingArmy = false;
    }

    @Override
    public String toString() {
        return "Game{" + "army=" + army + ", level=" + level + '}';
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
        movingArmy = false;
    }
    
    public void generateVillage(){
        int diff = 100*level;
        VillageGenerator generator = new VillageGenerator();
        village = generator.generateVillage(diff,this);
        
    }
    
    
    public void deployArmy(){
        System.out.println("deploying ...");
        if(!movingArmy){
            movingArmy = true;
            army.deploy(village);
        }
        
    }
    
    public void simulate(double deltaTime){
        if(village != null)
        village.simulate(deltaTime);
    }

    //on defense death
    @Override
    public void notify(Defense def) {
        System.out.println("notified tower!!!");
    }

    @Override
    public void notify(ICharacterDecorator character) {
        System.out.println("notified char!!!");
    }
    
    
}
