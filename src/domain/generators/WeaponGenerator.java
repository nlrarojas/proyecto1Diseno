/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.generators;

import domain.Weapon;

/**
 *
 * @author Charlie
 * 
 * Todo
 * -implement weapon load system
 */
public class WeaponGenerator {
    private static WeaponGenerator instance = null;
    
    private Weapon[] weapons;
    
    private WeaponGenerator(){
    }
    
    public Weapon[] getWeapon(String type){
        
        throw new UnsupportedOperationException("Not implemented function get weapons");
    }
    
    public WeaponGenerator GetInstance(){
        if(instance == null){
            instance = new WeaponGenerator();
        }
        
        return instance;
    }
}
