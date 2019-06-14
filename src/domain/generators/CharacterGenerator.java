/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.generators;

/**
 *
 * @author Charlie
 */
public class CharacterGenerator {
    private static CharacterGenerator instance = null;
    
    private CharacterGenerator(){
    }
    
    public String getCharacter(){
        
        throw new UnsupportedOperationException("Not implemented function get character");
    }
    
    public CharacterGenerator GetInstance(){
        if(instance == null){
            instance = new CharacterGenerator();
        }
        
        return instance;
    }
}
