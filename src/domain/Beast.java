package domain;

/**
 *
 * @author Nelson
 */
public class Beast extends CharacterDecorator {

    public Beast(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        super(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }

    @Override
    public void decorate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void customBeastDecorate () {
        
    }
}
