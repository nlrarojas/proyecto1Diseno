package model.command;

import domain.Game;
import domain.IAlmacenable;
import java.io.InputStream;
import model.FileProcessor;
import model.GameStorage;

/**
 *
 * @author Charlie
 *
 * TODO -implement execute function -implement save function
 */
public class GameManagerCommand implements ICommand, IAlmacenable {
    GameStorage storage;
    Game game;
    
    public GameManagerCommand(Game game) {
        storage = new GameStorage("gamedata");
        this.game = game;
        storage.setCurrentGame(game);
    }
    
    
    
    @Override
    public void execute() {
        game.deployArmy();
        storage.setCurrentGame(game);
        
        
    }
    
    public void setGame(Game game){
        this.game = game;
    }

    @Override
    public void save() {
        storage.saveGame();
        storage.saveGames();
        
    }

    public GameStorage getStorage() {
        return storage;
    }
    
    
}
