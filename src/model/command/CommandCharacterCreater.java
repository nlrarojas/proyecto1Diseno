/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;

import domain.IAlmacenable;

/**
 *
 * @author Charlie
 * 

 * 
 */
public class CommandCharacterCreater implements ICommand, IAlmacenable {
    
    
    
    public void execute(){
    
        throw new UnsupportedOperationException("Not implement command");
    }
    
     public void save(){
         throw new UnsupportedOperationException("Not implement save function");
    }
}
