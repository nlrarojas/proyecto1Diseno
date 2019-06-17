package model;

import domain.Game;
import domain.memento.CareTaker;
import domain.memento.Originator;

/**
 *
 * @author Nelson
 *
 * TODO memento patter was added to the class but, needs revision i'm not sure
 * of intended usage
 */
public class GameStorage {

    private Game[] games;
    private CareTaker<Game> careTaker;
    private Originator<Game> originator;

    public GameStorage(Game[] games) {
        this.games = games;
        careTaker = new CareTaker<Game>();
        originator = new Originator<Game>();

    }

    public void saveGame(Game game) {
        //save game to memento
        originator.set(game);
        careTaker.addMemento(originator.saveToMemento());
    }

    public Game getSavedGame(int idGame) {
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
