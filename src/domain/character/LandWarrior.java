package domain.character;

/**
 *
 * @author Charlie
 */
public class LandWarrior implements ICharacterDecorator {

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

}
