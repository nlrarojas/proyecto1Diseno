package domain.generators;

import domain.Defense;
import domain.character.ICharacterComponent;
import domain.IPrototype;
import domain.character.CharacterComponent;
import domain.character.CharacterFactory;
import domain.character.ICharacterDecorator;
import domain.character.LandWarrior;
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
 */
public class CharacterGenerator {

    private static CharacterGenerator instance = null;
    private CharacterFactory factory;

    private ArrayList<ICharacterDecorator> characters;
    
    //file procesors

    private FileProcessor characterFileProcessor;
    
    private CharacterGenerator() {
        factory = new CharacterFactory();

        characterFileProcessor = new FileProcessor("characters");
        
        InputStream characterStream = characterFileProcessor.readFileStream();
        //try to load stored data 
        try {

            ObjectInputStream characterIStream = new ObjectInputStream(characterStream);
            
            characters = (ArrayList<ICharacterDecorator>) characterIStream.readObject();
            //load prototypes on factory
            for(ICharacterDecorator charac : characters){
                ICharacterComponent comp = (ICharacterComponent)(charac.getComponent());
                factory.addPrototype(comp.getName(), (IPrototype)charac);
            }
            System.out.println(characters.size());

        } catch (IOException ex) {
            //if failed to read files try to create them
            initializeFiles();
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeFiles() {
        //if files do not exist create them with an empty arraylist
        characters = new ArrayList<ICharacterDecorator>();
        saveCharacters();

    }

    public ICharacterDecorator getCharacter(String name) {
        return (ICharacterDecorator)factory.factoryMethod(name);
    }
    
    public void registerCharacter(ICharacterDecorator newCharacter){
        characters.add(newCharacter);
        factory.addPrototype(((ICharacterComponent)newCharacter.getComponent()).getName(), (IPrototype)newCharacter);
    }

    public static CharacterGenerator getInstance() {
        if (instance == null) {
            instance = new CharacterGenerator();
        }

        return instance;
    }
    
    public void saveCharacters(){
        try {

            ByteArrayOutputStream characterByteArrayStream = new ByteArrayOutputStream();

            ObjectOutputStream cos = new ObjectOutputStream(characterByteArrayStream);

            cos.writeObject(characters);

            cos.close();

            characterFileProcessor.saveFile(characterByteArrayStream.toByteArray());
            
            System.out.println("SavedFile");
        } catch (IOException ex) {
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
