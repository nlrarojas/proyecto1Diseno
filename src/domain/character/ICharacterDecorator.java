package domain.character;

/**
 *
 * @author Nelson
 */
public interface ICharacterDecorator {

    public abstract void draw();

    public abstract void simulate();

    public ICharacterDecorator getComponent();

}
