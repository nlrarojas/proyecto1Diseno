package domain;

import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Game implements Serializable {

    protected Army army;
    protected int level;

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
}
