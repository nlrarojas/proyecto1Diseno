package domain;

/**
 *
 * @author Charlie
 */
public interface IPrototype {

    public IPrototype clone();
    public IPrototype deepClone();
}
