package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.IObservableCharacter;
import domain.Village;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public interface ICharacterDecorator extends IObservableCharacter{

    public abstract void draw(SpriteBatch batch,int x ,int y);

    public abstract void simulate(double deltaTime,Village vil,int xCoord, int yCoord);

    public ICharacterDecorator getComponent();
    
    public void setSize(int width, int height);
    
    public void attack(int damage);

}
