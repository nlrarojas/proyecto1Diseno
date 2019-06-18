package domain.generators;

import domain.Defense;
import domain.Weapon;
import domain.character.CharacterFactory;
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
 * TODO -implement weapon load system
 */
public class WeaponGenerator {

    private static WeaponGenerator instance = null;
    
    private CharacterFactory factory;
    private ArrayList<Weapon> weapons;
    private FileProcessor weaponFileProcessor;

    private WeaponGenerator() {
        factory = new CharacterFactory();
        weaponFileProcessor = new FileProcessor("weapons");
        InputStream weaponStream = weaponFileProcessor.readFileStream();
        
        //try to load stored data 
        try {

            ObjectInputStream WeaponIStream = new ObjectInputStream(weaponStream);
            
            weapons = (ArrayList<Weapon>) WeaponIStream.readObject();
            //load prototypes on factory
            for(Weapon wp : weapons){
                factory.addPrototype(wp.getName(), wp);
            }
            System.out.println(weapons.size());

        } catch (IOException ex) {
            //if failed to read files try to create them
            initializeFiles();
            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CharacterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Weapon getWeapon(String name) {
        return (Weapon)factory.factoryMethod(name);
        
    }

    public static WeaponGenerator GetInstance() {
        if (instance == null) {
            instance = new WeaponGenerator();
        }

        return instance;
    }
    
    public void registerWeapon(Weapon newWeapon){
        weapons.add(newWeapon);
        factory.addPrototype(newWeapon.getName(), newWeapon);
        
    }
    
    private void initializeFiles() {
        //if files do not exist create them with an empty arraylist
        weapons = new ArrayList<Weapon>();
        saveWeapons();
    }
    
    public void saveWeapons(){
        try {

            ByteArrayOutputStream weaponByteArrayStream = new ByteArrayOutputStream();

            ObjectOutputStream wos = new ObjectOutputStream(weaponByteArrayStream);
            wos.writeObject(weapons);
            wos.close();

            weaponFileProcessor.saveFile(weaponByteArrayStream.toByteArray());
            
            System.out.println("SaveWeaponFile");
        } catch (IOException ex) {
            Logger.getLogger(WeaponGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
