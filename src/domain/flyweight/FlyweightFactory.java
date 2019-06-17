package domain.flyweight;

import domain.Weapon;
import java.util.HashMap;

/**
 *
 * @author Charlie TODO proper weapon configuration
 *
 */
public class FlyweightFactory {

    HashMap<String, Weapon> weaponCache;

    public FlyweightFactory() {
        weaponCache = new HashMap<String, Weapon>();
    }

    public Weapon makeWeapon(String name, int scope, int damage, int level, int exposureRate, String image) {
        if (weaponCache.containsKey(name)) {
            return weaponCache.get(name);
        } else {

            Weapon newWeapon = new Weapon(name, scope, damage, level, exposureRate, "image");
            weaponCache.put(name, newWeapon);

            return newWeapon;
        }

    }
}
