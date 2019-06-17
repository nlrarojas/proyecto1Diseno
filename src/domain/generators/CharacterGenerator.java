package domain.generators;

/**
 *
 * @author Charlie
 */
public class CharacterGenerator {

    private static CharacterGenerator instance = null;

    private CharacterGenerator() {
    }

    public String getCharacter() {

        throw new UnsupportedOperationException("Not implemented function get character");
    }

    public CharacterGenerator GetInstance() {
        if (instance == null) {
            instance = new CharacterGenerator();
        }

        return instance;
    }
}
