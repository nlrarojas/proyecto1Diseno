package domain;

/**
 *
 * @author Nelson
 */
public abstract class ICharacterComponent {
    protected String name;
    protected Appearance appearance;
    protected int life;
    protected int punchesPerTime;
    protected int spaces;
    protected int appearanceLevel;
    protected int cost;
    protected Weapon weapon;
    
    public abstract void decorate();
    public abstract void attack();

    public ICharacterComponent(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        this.name = name;
        this.appearance = appearance;
        this.life = life;
        this.punchesPerTime = punchesPerTime;
        this.spaces = spaces;
        this.appearanceLevel = appearanceLevel;
        this.cost = cost;
        this.weapon = weapon;
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
        return "ICharacterComponent{" + "name=" + name + ", appearance=" + appearance + ", life=" + life + ", punchesPerTime=" + punchesPerTime + ", spaces=" + spaces + ", appearanceLevel=" + appearanceLevel + ", cost=" + cost + ", weapon=" + weapon + '}';
    }    
}
