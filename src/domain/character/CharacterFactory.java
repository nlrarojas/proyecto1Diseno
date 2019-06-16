/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.character;

import domain.Appearance;
import domain.Weapon;

/**
 *
 * @author Charlie
 */
public class CharacterFactory {
    
    
    public ICharacterDecorator factoryMethod(CharacterType type, String name, Appearance appearence, Weapon weapon){
        switch(type){
            case BEAST:
                return createBeast(name, appearence, weapon);
            case MONSTER:
                return createMonster(name, appearence, weapon);
            case WARRIOR:
                return createWarrior(name, appearence, weapon);
            default:
                throw new AssertionError(type.name());
        }
    }
    
    
    
    
    private ICharacterDecorator createWarrior(String name, Appearance appearence,Weapon weapon){
        
        ICharacterDecorator newWarrior = new CharacterComponent(name, appearence, 0, 0, 0, 0, 0, weapon);
        newWarrior = new LandWarrior(newWarrior);
        
        return newWarrior;
        
    }
    
    private ICharacterDecorator createBeast(String name, Appearance appearence,Weapon weapon){
        
        ICharacterDecorator newBeast = new CharacterComponent(name, appearence, 0, 0, 0, 0, 0, weapon);
        newBeast = new Beast(newBeast);
        
        return newBeast;
        
    }
    
    private ICharacterDecorator createMonster(String name, Appearance appearence,Weapon weapon){
        
        ICharacterDecorator newMonster = new CharacterComponent(name, appearence, 0, 0, 0, 0, 0, weapon);
        newMonster = new Monster(newMonster);
        
        return newMonster;
        
    }
    
    
    
}
