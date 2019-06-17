package domain;

/**
 *
 * @author Nelson
 */
public class Village {

    protected int[] spaces;
    protected int gold;
    protected int level;
    protected int life;
    protected Defense[] defenses;

    public Village(int[] spaces, int gold, int level, Defense[] defenses) {
        this.spaces = spaces;
        this.gold = gold;
        this.level = level;
        this.defenses = defenses;
        this.life = 100;
    }

    public int[] getSpaces() {
        return spaces;
    }

    public void setSpaces(int[] spaces) {
        this.spaces = spaces;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Defense[] getDefenses() {
        return defenses;
    }

    public void setDefenses(Defense[] defenses) {
        this.defenses = defenses;
    }

    @Override
    public String toString() {
        return "Village{" + "spaces=" + spaces + ", gold=" + gold + ", level=" + level + ", life=" + life + ", defenses=" + defenses + '}';
    }
}
