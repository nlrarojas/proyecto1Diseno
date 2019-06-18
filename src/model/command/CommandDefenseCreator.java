package model.command;

import domain.Defense;
import domain.IAlmacenable;
import domain.character.CharacterFactory;
import domain.generators.DefenseGenerator;

/**
 *
 * @author Charlie
 *
 * TODO -implement execute function -implement save function
 */
public class CommandDefenseCreator implements ICommand, IAlmacenable {
    
    private DefenseGenerator generator;
    private Defense target;
   
    
    
    public CommandDefenseCreator() {
        generator = DefenseGenerator.GetInstance();
        
    }
    
    
    
    
    @Override
    public void execute() {
        generator.registerDefense(target);
        
    }

    @Override
    public void save() {
        generator.saveDefense();

    }
    
    public void setDefense(Defense target){
        this.target = target;
    }
}
