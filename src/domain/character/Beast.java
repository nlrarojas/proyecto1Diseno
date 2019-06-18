package domain.character;

import domain.IPrototype;
import java.io.Serializable;

/**
 *
 * @author Charlie
 */
public class Beast implements ICharacterDecorator, IPrototype, Serializable {

    ICharacterDecorator component;

    public Beast(ICharacterDecorator component) {
        this.component = component;
    }

    @Override
    public void simulate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICharacterDecorator getComponent() {
        return component.getComponent();
    }

    @Override
    public IPrototype deepClone() {
        return new Beast((ICharacterDecorator) ((CharacterComponent) component.getComponent()).deepClone());
    }

    @Override
    public IPrototype clone() {
        return new LandWarrior((ICharacterDecorator) ((CharacterComponent) component.getComponent()).clone());
    }

    @Override
    public String toString() {
        return "Beast{" + "component=" + component + '}';
    }
    
    

}
