package model.command;

import domain.IAlmacenable;

/**
 *
 * @author Charlie
 *
 *
 *
 */
public class CommandCharacterCreater implements ICommand, IAlmacenable {

    @Override
    public void execute() {

        throw new UnsupportedOperationException("Not implement command");
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not implement save function");
    }
}
