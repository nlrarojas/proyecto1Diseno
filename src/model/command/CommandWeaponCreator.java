package model.command;

import domain.IAlmacenable;
import domain.Weapon;
import domain.generators.WeaponGenerator;

/**
 *
 * @author Charlie
 *
 * TODO -implement execute function -implement save function
 */
public class CommandWeaponCreator implements ICommand, IAlmacenable {
    private WeaponGenerator generator;
    private Weapon target;
    
    public CommandWeaponCreator() {
        generator = WeaponGenerator.GetInstance();
    }
    
    
       
    @Override
    public void execute() {
        generator.registerWeapon(target);
        
    }

    @Override
    public void save() {
       generator.saveWeapons();
    }
    
    public void setWeapon(Weapon target){
        this.target = target;
    }
}
