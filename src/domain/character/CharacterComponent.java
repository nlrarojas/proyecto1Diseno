package domain.character;

import domain.Appearance;
import domain.ICharacterComponent;
import domain.Weapon;

/**
 *
 * @author Nelson
 */
public class CharacterComponent extends ICharacterComponent implements ICharacterDecorator {

    public CharacterComponent(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        super(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void simulate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICharacterDecorator getComponent() {
        return this;
    }

}
