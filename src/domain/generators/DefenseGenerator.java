package domain.generators;

import domain.Defense;
import domain.IPrototype;
import domain.character.CharacterFactory;
import domain.character.ICharacterComponent;
import domain.character.ICharacterDecorator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FileProcessor;

/**
 *
 * @author Charlie
 *
 * TODO -must implement get weapons and connect with file processor
 */
public class DefenseGenerator {

    private static DefenseGenerator instance = null;
    //file procesors
    private FileProcessor defenseFileProcessor;
    private ArrayList<Defense> defense;
    private CharacterFactory factory;
    
    
    private DefenseGenerator() {
        factory = new CharacterFactory();
        defenseFileProcessor = new FileProcessor("defenses");
        InputStream defenseStream = defenseFileProcessor.readFileStream();
        
        //try to load stored data 
        try {

            ObjectInputStream characterIStream = new ObjectInputStream(defenseStream);
            
            defense = (ArrayList<Defense>) characterIStream.readObject();
            System.out.println(defense.size());

        } catch (IOException ex) {
            //if failed to read files try to create them
            initializeFiles();
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public Defense getDefense(String defenseName) {

        return (Defense)factory.factoryMethod(defenseName);
    }

    public static DefenseGenerator GetInstance() {
        if (instance == null) {
            instance = new DefenseGenerator();
        }

        return instance;
    }
    
    public void registerDefense(Defense newDefense){
        defense.add(newDefense);
        factory.addPrototype(newDefense.getName(), newDefense);
        
    }
    
    private void initializeFiles() {
        //if files do not exist create them with an empty arraylist
        defense = new ArrayList<Defense>();
        saveDefense();
    }
    
    public void saveDefense(){
        try {

            ByteArrayOutputStream defenseByteArrayStream = new ByteArrayOutputStream();

            ObjectOutputStream dos = new ObjectOutputStream(defenseByteArrayStream);
            dos.writeObject(defense);
            dos.close();

            defenseFileProcessor.saveFile(defenseByteArrayStream.toByteArray());
            
            System.out.println("SavedDefenseFile");
        } catch (IOException ex) {
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
