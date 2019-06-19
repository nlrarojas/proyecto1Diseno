package model;

import domain.Game;
import domain.IPrototype;
import domain.character.CharacterComponent;
import domain.character.ICharacterDecorator;
import domain.generators.CharacterGenerator;
import domain.memento.CareTaker;
import domain.memento.Memento;
import domain.memento.Originator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author Nelson
 *
 * TODO memento patter was added to the class but, needs revision i'm not sure
 * of intended usage
 */
public class GameStorage{

    //private ArrayList<Game> games;
    private CareTaker<Game> careTaker;
    private Originator<Game> originator;
    
    private FileProcessor gameFileProcessor;
    
    
    public GameStorage(String name) {
        careTaker = new CareTaker<Game>();
        originator = new Originator<Game>();
        loadGames(name);
    }
     
    private void loadGames(String name){
        
        gameFileProcessor = new FileProcessor(name);
       
        InputStream gameStream = gameFileProcessor.readFileStream();
        try {

            ObjectInputStream gameIStream = new ObjectInputStream(gameStream);
            
            ArrayList<Game> games = (ArrayList<Game>) gameIStream.readObject();
            careTaker.setMementoList(games);

            System.out.println("Games loaded: "+ games.size());

        } catch (IOException ex) {
            //if failed to read files try to create them
            initializeFiles();
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void saveGame() {
        //save game to memento
        Memento<Game> memento = originator.saveToMemento();
        //System.out.println(memento.getState());
        //System.out.println(SerializationUtils.clone(memento.getState()));
        memento.setState(SerializationUtils.clone(memento.getState()));
        careTaker.addMemento(memento);
    
    }

    public Game getSavedGame(int idGame) {
        return careTaker.getMemento(idGame).getState();
    }

    public ArrayList<Game> getGames() {
        return careTaker.getMementoList();
    }

    public void setGames(ArrayList<Game> games) {
        careTaker.setMementoList(games);
    }

    public void setCurrentGame(Game currGame){
        originator.set(currGame);
    }
    
    public void setCurrentGame(int currGameIndex){
        originator.set(careTaker.getMemento(currGameIndex).getState());
    }

    
    private void initializeFiles() {
        //if files do not exist create them with an empty arraylist
        saveGames();

    }
    
    public void saveGames(){
        //ArrayList<Game> games = new ArrayList<Game>();
        try {
            ArrayList<Game> games = careTaker.getMementoList();
            ByteArrayOutputStream gameByteArrayStream = new ByteArrayOutputStream();
            ObjectOutputStream gos = new ObjectOutputStream(gameByteArrayStream);
            gos.writeObject(games);
            gos.close();
            gameFileProcessor.saveFile(gameByteArrayStream.toByteArray());
            System.out.println("SavedGameFile");
        } catch (IOException ex) {
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Game getCurrentGame() {
        return originator.get();
    }
    
    
}
