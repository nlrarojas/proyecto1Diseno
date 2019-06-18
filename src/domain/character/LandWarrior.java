package domain.character;

import domain.IPrototype;
import java.io.Serializable;

/**
 *
 * @author Charlie
 */
public class LandWarrior implements ICharacterDecorator, IPrototype, Serializable {

    ICharacterDecorator component;

    public LandWarrior(ICharacterDecorator component) {
        this.component = component;
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
        return component.getComponent();
    }

    @Override
    public IPrototype clone() {
        return new LandWarrior((ICharacterDecorator) ((CharacterComponent) component.getComponent()).clone());
    }

    @Override
    public IPrototype deepClone() {
        return new LandWarrior((ICharacterDecorator) ((CharacterComponent) component.getComponent()).deepClone());
    }

}
