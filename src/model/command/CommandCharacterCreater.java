package model.command;

import domain.IAlmacenable;
import domain.character.Beast;
import domain.character.CharacterComponent;
import domain.character.ICharacterDecorator;
import domain.generators.CharacterGenerator;

/**
 *
 * @author Charlie
 *
 *
 *
 */
public class CommandCharacterCreater implements ICommand, IAlmacenable {
    
    private CharacterGenerator generator;
    private ICharacterDecorator target;
    
    public CommandCharacterCreater() {
        generator = CharacterGenerator.getInstance();
        
    }
    
    
    
    @Override
    public void execute() {
        generator.registerCharacter(target);
    }
    
    public void setCharacter(ICharacterDecorator targetCharacter){
        target = targetCharacter;
    }

    @Override
    public void save() {
        generator.saveCharacters();
    }
}
