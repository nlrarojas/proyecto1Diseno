package domain;

/**
 *
 * @author Nelson
 */
public abstract class CharacterDecorator extends ICharacterComponent {

    public CharacterDecorator(String name, Appearance appearance, int life, int punchesPerTime, int spaces, int appearanceLevel, int cost, Weapon weapon) {
        super(name, appearance, life, punchesPerTime, spaces, appearanceLevel, cost, weapon);
    }
        
    @Override
    public abstract void decorate();

    @Override
    public abstract void attack();
    
}
