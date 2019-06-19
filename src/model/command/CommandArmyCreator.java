package model.command;

import domain.Army;

/**
 *
 * @author Charlie TODO -implement execute function
 */
public class CommandArmyCreator implements ICommand {
    
    int level;
    Army army;
    int newLevel = 1;
    
    
    public CommandArmyCreator() {
        army = new Army(1);
        
    }
    
    @Override
    public void execute() {
        army.updateLevel(newLevel);
    }
    
    public void setLevel(int newLevel){
        this.newLevel = newLevel;
    }
    
    public Army getArmy(){
        return army;
    }
    
    

}
