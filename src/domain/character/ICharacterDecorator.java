package domain.character;

import domain.Appearance;
import domain.ICharacterComponent;
import domain.Weapon;

/**
 *
 * @author Nelson
 */
public interface ICharacterDecorator {

    public abstract void draw();

    public abstract void simulate();
    
    public ICharacterDecorator getComponent();
    
}
