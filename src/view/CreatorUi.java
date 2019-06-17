package view;

/**
 *
 * @author Charlie
 */
public class CreatorUi implements IUserInterface {

    private final UiManager manager;

    public CreatorUi(UiManager manager) {
        this.manager = manager;
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUi(String name) {
        manager.setUi(name);
    }

}
