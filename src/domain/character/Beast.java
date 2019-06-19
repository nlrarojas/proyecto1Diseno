package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.IPrototype;
import domain.Village;
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
    public void simulate(double deltaTime,Village vil,int xCoord, int yCoord) {
        ((CharacterComponent)component.getComponent()).simulate(deltaTime,vil,xCoord,yCoord);
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
