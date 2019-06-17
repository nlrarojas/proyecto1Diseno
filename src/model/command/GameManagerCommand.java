package model.command;

import domain.IAlmacenable;

/**
 *
 * @author Charlie
 *
 * TODO -implement execute function -implement save function
 */
public class GameManagerCommand implements ICommand, IAlmacenable {

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not implement command");

    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not implement save function");
    }
}
