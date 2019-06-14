/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import sun.security.jca.GetInstance;

/**
 *
 * @author Charlie
 * 
 * TODO
 * -must implement get weapons and connec with file processor
 */
public class DefenseGenerator {
    
    private static DefenseGenerator instance = null;
    
    private DefenseGenerator(){
    }
    
    public String getWeapons(){
        
        throw new UnsupportedOperationException("Not implemented function get weapons");
    }
    
    public DefenseGenerator GetInstance(){
        if(instance == null){
            instance = new DefenseGenerator();
        }
        
        return instance;
    }
}
