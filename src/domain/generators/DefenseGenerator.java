package domain.generators;

/**
 *
 * @author Charlie
 *
 * TODO -must implement get weapons and connect with file processor
 */
public class DefenseGenerator {

    private static DefenseGenerator instance = null;

    private DefenseGenerator() {
    }

    public String getDefense() {

        throw new UnsupportedOperationException("Not implemented function get defense");
    }

    public DefenseGenerator GetInstance() {
        if (instance == null) {
            instance = new DefenseGenerator();
        }

        return instance;
    }
}
