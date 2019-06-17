package model.command;

import java.util.HashMap;

/**
 *
 * @author Charlie
 *
 */
public class CommandManager {

    HashMap<String, ICommand> commands;

    public CommandManager() {
        commands = new HashMap<String, ICommand>();
    }

    public ICommand getCommand(String key) {
        return commands.get(key);
    }

    public void registerCommand(String key, ICommand newCommand) {
        commands.put(key, newCommand);

    }

}
