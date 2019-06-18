/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.generators;

import domain.Defense;
import domain.Village;

/**
 *
 * @author Charlie
 */
public class VillageGenerator {
    
    public Village generateVillage(int difficulty){
        int newLevel = difficulty/150;
        Village newVillage = new Village(12, 2000, newLevel);
        DefenseGenerator generator = DefenseGenerator.GetInstance();
        
        while(difficulty > 0){
            Defense currentDefense = generator.getRandomDefense();
            difficulty -= currentDefense.getDifficulty();
            newVillage.addRandomdefense(currentDefense);
            System.out.println(difficulty);
        }
        
        
        return newVillage;
    }
    
}
