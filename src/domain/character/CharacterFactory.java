/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.character;

import domain.Appearance;
import domain.IPrototype;
import domain.Weapon;
import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class CharacterFactory {
    private HashMap<String, IPrototype> prototypes;


    public void addPrototype(String name,IPrototype newPrototype){
        prototypes.put(name, newPrototype);
    }
    
    
    public IPrototype factoryMethod(String name){
        if(prototypes.containsKey(name)) return prototypes.get(name).deepClone();
        return null;
        
    }
    
    
    
  
    
    
    
    
}
