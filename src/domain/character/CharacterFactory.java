package domain.character;

import domain.IPrototype;
import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class CharacterFactory {

    private HashMap<String, IPrototype> prototypes;

    public CharacterFactory() {
        prototypes = new HashMap<String, IPrototype>();
    }
    
    

    public void addPrototype(String name, IPrototype newPrototype) {
        prototypes.put(name, newPrototype);
    }

    public IPrototype factoryMethod(String name) {
        if (prototypes.containsKey(name)) {
            return prototypes.get(name).deepClone();
        }
        return null;

    }
}
