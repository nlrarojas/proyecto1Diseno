package domain;

/**
 *
 * @author Nelson
 */
public class Defense {

    protected String name;
    protected Appearance appearance;
    protected int life;
    protected int punchesPerTime;
    protected int level;
    protected int spaces;
    protected int appearanceLevel;
    protected int range;
    protected String[] targetWarriors;

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
}
