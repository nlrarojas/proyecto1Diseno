package domain;

import domain.character.CharacterComponent;
import domain.character.ICharacterDecorator;
import java.util.ArrayList;

/**
 *
 * @author Nelson
 */
public class Army {

    protected int numberOfSoldiers;
    protected int actualNumberOfSoldiers;
    protected ArrayList<ICharacterDecorator> soldiers;
    
    
    
    public Army(int level) {
        this.numberOfSoldiers = upLevel(level);
        this.soldiers = new ArrayList<ICharacterDecorator>();
        actualNumberOfSoldiers = 0;
        
        
    }
    
    public boolean addCharacter(ICharacterDecorator newCharacter){
        CharacterComponent comp = (CharacterComponent)newCharacter.getComponent();
        if(numberOfSoldiers >= actualNumberOfSoldiers + comp.getSpaces()){
            actualNumberOfSoldiers += comp.getSpaces();
            soldiers.add(newCharacter);
            return true;
        }
        
        return false;
        
    }
    
    public boolean remove(String name){
        for(int i = 0; i < soldiers.size(); i++){
            CharacterComponent comp = (CharacterComponent)soldiers.get(i).getComponent();
            //found it
            if(comp.getName().equals(name)){
                ICharacterDecorator removed = soldiers.remove(i);
                CharacterComponent removedComp = (CharacterComponent)removed.getComponent();
                actualNumberOfSoldiers -= removedComp.getSpaces();
                return true;
            }
        }
        
        return false;
        
    }
    
    public int count(String name){
        int count = 0;
        for(int i = 0; i < soldiers.size(); i++){
            CharacterComponent comp = (CharacterComponent)soldiers.get(i).getComponent();
            //found it
            if(comp.getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    public int upLevel(int level) {
        return 20 + 5*level;
    }
    
    public void updateLevel(int level){
        numberOfSoldiers = upLevel(level);
    }
}
