package domain;

import model.GameStorage;

/**
 *
 * @author Nelson
 */
public class Player extends User {
    private String nickName;
    private GameStorage gameStorage;
    
    public Player(String userName, String password, GameStorage gameStorage) {
        super(userName, password);
        this.gameStorage = gameStorage;
    }
    
}
