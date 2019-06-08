package domain;

/**
 *
 * @author Nelson
 */
public class Army {
    protected int numberOfSoldiers;
    protected ICharacterComponent[] soldiers;

    public Army() {
        this.numberOfSoldiers = 20;
        this.soldiers = new ICharacterComponent[this.numberOfSoldiers];
    }   
    
    public int upLevel(int level) {
        switch (level) {
            case 1:
                break;
            default:
        }
        return level;
    }                
}
