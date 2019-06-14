/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.flyweight;

import domain.Weapon;
import java.util.HashMap;

/**
 *
 * @author Charlie
 * Todo proper weapon configuration
 * 
 */
public class FlyweightFactory {
    
    HashMap<String, Weapon> weaponCache;
    
    public FlyweightFactory(){
        weaponCache = new HashMap<String, Weapon>();
    }
    
    
    public Weapon makeWeapon(String name,int scope,int damage,int level,int exposureRate, String image ){
        if(weaponCache.containsKey(name)){
            return weaponCache.get(name);
        }else{
            
            Weapon newWeapon = new Weapon(name,scope, damage, level, exposureRate, "image");
            weaponCache.put(name,newWeapon);
            
            return newWeapon;
        }

    }
}
