package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.ICharacterObserver;
import domain.IPrototype;
import domain.Village;
import java.io.Serializable;

/**
 *
 * @author Charlie
 */
public class Monster implements ICharacterDecorator, IPrototype, Serializable {
    private static final long serialVersionUID = 7214685095444457690L;
    ICharacterDecorator component;

    public Monster(ICharacterDecorator component) {
        this.component = component;
    }

    @Override
    public void draw(SpriteBatch batch,int x ,int y) {
        component.draw(batch, x, y);
    }
    
    @Override
    public void attack(int damage) {
        component.attack(damage);
    }

    @Override
    public void simulate(double deltaTime,Village vil,int xCoord, int yCoord) {
        ((CharacterComponent)component.getComponent()).simulate(deltaTime,vil,xCoord,yCoord);
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

    @Override
    public String toString() {
        return "Monster{" + "component=" + component + '}';
    }
    public void setSize(int width, int height){
        CharacterComponent character = (CharacterComponent)component.getComponent();
        character.setSize(width, height);
    }
    
     @Override
    public void notifyObservers() {
        component.notifyObservers();
    }

    @Override
    public void addObserver(ICharacterObserver observer) {
        component.addObserver(observer);
    }

    @Override
    public void removeObserver(ICharacterObserver observer) {
        component.removeObserver(observer);
    }
}
