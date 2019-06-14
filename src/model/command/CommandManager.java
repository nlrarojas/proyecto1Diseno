/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.command;

import java.util.HashMap;

/**
 *
 * @author Charlie
 * 
 */
public class CommandManager {
    HashMap<String, ICommand> commands;
    
    public CommandManager(){
        commands = new HashMap<String, ICommand>();
    }
    
    public ICommand getCommand(String key){
        return commands.get(key);
    }
    
    public void registerCommand(String key, ICommand newCommand){
        commands.put(key, newCommand);
    
    }
    
    
}
