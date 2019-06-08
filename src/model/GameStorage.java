package model;

import domain.Game;

/**
 *
 * @author Nelson
 */
public class GameStorage {
    private Game[] games;

    public GameStorage(Game[] games) {
        this.games = games;
    }
    
    public void saveGame (Game game) {
        
    }
    
    public Game getSavedGame (int idGame) {
        return null;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GameStorage{" + "games=" + games + '}';
    }        
}
