package view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 *
 * @author Charlie
 */
public class UiUtils {

    public static final int WIDHT = 1280;
    public static final int HEIGHT = 720;
    //utility function to create drawable for button background

    public static TextureRegionDrawable createButtonSprite(Color bgColor, int width, int height) {
        Pixmap newGraphicMap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        //Fill it red
        newGraphicMap.setColor(bgColor);
        newGraphicMap.fill();

        //Draw two lines forming an X
        newGraphicMap.setColor(Color.BLACK);

        //size constants
        int top = newGraphicMap.getHeight() - 1;
        int right = newGraphicMap.getWidth() - 1;
        //create border
        newGraphicMap.drawLine(0, 0, right, 0);
        newGraphicMap.drawLine(0, top, right, top);
        newGraphicMap.drawLine(right, top, right, 0);
        newGraphicMap.drawLine(0, top, 0, 0);

        Texture newTexture = new Texture(newGraphicMap);
        //deleta pixmap
        newGraphicMap.dispose();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(newTexture));

        return drawable;
    }

    public static TextureRegionDrawable createRectSprite(Color bgColor, int width, int height) {
        Pixmap newGraphicMap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        //Fill it red
        newGraphicMap.setColor(bgColor);
        newGraphicMap.fill();

        //Draw two lines forming an X
        newGraphicMap.setColor(Color.BLACK);

        Texture newTexture = new Texture(newGraphicMap);
        //deleta pixmap
        newGraphicMap.dispose();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(newTexture));

        return drawable;

    }
}
