package domain;

import domain.generators.VillageGenerator;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Game implements Serializable {

    protected Army army;
    protected int level;
    protected Village village;


    public Game(Army army, int level) {
        this.army = army;
        this.level = level;
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
    }
    
    public void generateVillage(){
        int diff = 100*level;
        VillageGenerator generator = new VillageGenerator();
        village = generator.generateVillage(diff);
    }
    
    
    
}
