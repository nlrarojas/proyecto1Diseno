package domain.character;

import domain.IPrototype;

/**
 *
 * @author Charlie
 */
public class Monster implements ICharacterDecorator, IPrototype {

    ICharacterDecorator component;

    public Monster(ICharacterDecorator component) {
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
    public IPrototype deepClone() {
        return new Monster((ICharacterDecorator) ((CharacterComponent) component.getComponent()).deepClone());
    }

    @Override
    public IPrototype clone() {
        return new Monster((ICharacterDecorator) ((CharacterComponent) component.getComponent()).clone());
    }
}
