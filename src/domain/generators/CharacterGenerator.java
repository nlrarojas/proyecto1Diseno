package domain.generators;

import domain.ICharacterComponent;
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
    private ArrayList<ICharacterComponent> warriors;
    private ArrayList<ICharacterComponent> beasts;
    private ArrayList<ICharacterComponent> monsters;

    //file procesors
    private FileProcessor warriorFileProcessor;
    private FileProcessor beastFileProcessor;
    private FileProcessor monsterFileProcessor;

    public CharacterGenerator() {
        factory = new CharacterFactory();
        warriorFileProcessor = new FileProcessor("warriors");
        beastFileProcessor = new FileProcessor("beasts");
        monsterFileProcessor = new FileProcessor("monsters");

        InputStream warriorStream = warriorFileProcessor.readFileStream();
        InputStream beastStream = beastFileProcessor.readFileStream();
        InputStream monsterStream = monsterFileProcessor.readFileStream();
        //try to load stored data 
        try {
            ObjectInputStream warriorIStream = new ObjectInputStream(warriorStream);
            ObjectInputStream beastIStream = new ObjectInputStream(beastStream);
            ObjectInputStream monsterIStream = new ObjectInputStream(monsterStream);

            warriors = (ArrayList<ICharacterComponent>) warriorIStream.readObject();
            beasts = (ArrayList< ICharacterComponent>) beastIStream.readObject();
            monsters = (ArrayList<ICharacterComponent>) monsterIStream.readObject();

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
        warriors = new ArrayList<ICharacterComponent>();
        beasts = new ArrayList<ICharacterComponent>();
        monsters = new ArrayList<ICharacterComponent>();

        try {
            ByteArrayOutputStream warriorByteArrayStream = new ByteArrayOutputStream();
            ByteArrayOutputStream beastByteArrayStream = new ByteArrayOutputStream();
            ByteArrayOutputStream monsterByteArrayStream = new ByteArrayOutputStream();

            ObjectOutputStream wos = new ObjectOutputStream(warriorByteArrayStream);
            ObjectOutputStream bos = new ObjectOutputStream(beastByteArrayStream);
            ObjectOutputStream mos = new ObjectOutputStream(monsterByteArrayStream);

            wos.writeObject(warriors);
            bos.writeObject(beasts);
            mos.writeObject(monsters);

            wos.close();
            bos.close();
            mos.close();

            warriorFileProcessor.saveFile(warriorByteArrayStream.toByteArray());
            beastFileProcessor.saveFile(beastByteArrayStream.toByteArray());
            monsterFileProcessor.saveFile(monsterByteArrayStream.toByteArray());
        } catch (IOException ex) {
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ICharacterDecorator getCharacter(String name) {

        return null;
    }

    public void registerWarrior(CharacterComponent newWarrior) {
        warriors.add(newWarrior);
        factory.addPrototype(newWarrior.getName(), new LandWarrior(newWarrior));
    }

    public void registerBeast(CharacterComponent newBeast) {
        beasts.add(newBeast);
        factory.addPrototype(newBeast.getName(), new LandWarrior(newBeast));
    }

    public void registerMonster(CharacterComponent newMonster) {
        monsters.add(newMonster);
        factory.addPrototype(newMonster.getName(), new LandWarrior(newMonster));
    }

    public CharacterGenerator GetInstance() {
        if (instance == null) {
            instance = new CharacterGenerator();
        }

        return instance;
    }
}
