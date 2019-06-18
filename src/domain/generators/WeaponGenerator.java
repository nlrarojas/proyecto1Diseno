package domain.generators;

import domain.Weapon;

/**
 *
 * @author Charlie
 *
 * TODO -implement weapon load system
 */
public class WeaponGenerator {

    private static WeaponGenerator instance = null;

    private Weapon[] weapons;

    private WeaponGenerator() {
    }

    public Weapon[] getWeapon(String type) {

        throw new UnsupportedOperationException("Not implemented function get weapons");
    }

    public static WeaponGenerator GetInstance() {
        if (instance == null) {
            instance = new WeaponGenerator();
        }

        return instance;
    }
}
