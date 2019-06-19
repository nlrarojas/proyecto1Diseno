package domain.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public interface ICharacterDecorator extends Serializable{

    public abstract void draw(SpriteBatch batch,int x ,int y);

    public abstract void simulate();

    public ICharacterDecorator getComponent();
    
    public void setSize(int width, int height);

}
