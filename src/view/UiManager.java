package view;

import domain.Army;
import java.util.HashMap;
import model.command.CommandArmyCreator;
import model.command.CommandManager;

/**
 *
 * @author Charlie
 */
public class UiManager {

    HashMap<String, IUserInterface> availableUi;
    private IUserInterface interfaz;
    private CommandManager command;
    
    public UiManager(CommandManager command) {

        availableUi = new HashMap<String, IUserInterface>();
        this.command = command;
        

    }

    public void addUi(String UiName, IUserInterface newUi) {

        availableUi.put(UiName, newUi);

    }

    public void setUi(String UiName) {

        if (availableUi.containsKey(UiName)) {
            interfaz = availableUi.get(UiName);
            interfaz.activate();
        }

    }

    public void render() {
        interfaz.render();
    }

    public CommandManager getCommandManager() {
        return command;
    }
    
    

}
