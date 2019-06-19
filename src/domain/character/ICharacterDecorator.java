package domain.character;

import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public interface ICharacterDecorator extends Serializable{

    public abstract void draw();

    public abstract void simulate();

    public ICharacterDecorator getComponent();

}
