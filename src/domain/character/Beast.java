package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public void draw(SpriteBatch batch,int x ,int y) {
        component.draw(batch, x, y);
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
    
    
    public void setSize(int width, int height){
        CharacterComponent character = (CharacterComponent)component.getComponent();
        character.setSize(width, height);
    }
    

}
