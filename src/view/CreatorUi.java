package view;

import com.badlogic.gdx.graphics.Color;

/**
 *
 * @author Charlie
 */
public class CreatorUi implements IUserInterface {

    private UiManager manager;
    //constant colors 
    final Color IDDLE_BUTTON = new Color(0.3f, 0.44f, 0.46f, 1);
    final Color DOWN_BUTTON = new Color(0.15f, 0.22f, 0.23f, 1);
    final Color CHECKED_BUTTON = new Color(0.59f, 0.81f, 0.83f, 1);
    final Color SELECTED_TEXT = new Color(0.79f, 0.91f, 0.93f, 0.5f);

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
