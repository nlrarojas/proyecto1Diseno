package domain.character;

import domain.Appearance;
import domain.IPrototype;
import domain.Weapon;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class CharacterComponent extends ICharacterComponent implements ICharacterDecorator, IPrototype, Serializable {
    private static final long serialVersionUID = 7214685095267757690L;
    
    public CharacterComponent(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        super(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }
    
    public CharacterComponent(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, String weapon) {
        super(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, null);
    }
    
    public String getName(){
        return name;
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

    @Override
    public IPrototype clone() {
        return new CharacterComponent(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }

    @Override
    public IPrototype deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
