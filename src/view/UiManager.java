/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class UiManager{
    HashMap<String, IUserInterface> availableUi;
    private IUserInterface interfaz;
    
    public UiManager(){
        
        availableUi = new HashMap<String, IUserInterface>();
        
    }
    
    public void addUi(String UiName, IUserInterface newUi){
        
        availableUi.put(UiName, newUi);
    
    }
    
    public void setUi(String UiName){
        
        if(availableUi.containsKey(UiName)){
            interfaz = availableUi.get(UiName);
            interfaz.activate();
        }
        
    }
    
    
    public void render(){
        interfaz.render();
    }
    
    
    
}
