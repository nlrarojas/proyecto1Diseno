/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.character.ICharacterDecorator;
import domain.iterator.Aggregate;
import domain.iterator.Iterator;
import domain.iterator.VillageIterator;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Charlie
 */

public class VillageTile implements Serializable, Aggregate {

    private static final long serialVersionUID = 1144637895267716690L;
    private ArrayList<Defense> defences;
    private ArrayList<ICharacterDecorator> characters;
    private int x;
    private int y;
    private transient Sprite tileSpirte;
    private int size;

    public VillageTile(Texture tileTexture) {
        this.defences = new ArrayList<Defense>();
        this.characters = new ArrayList<ICharacterDecorator>();
        this.tileSpirte = new Sprite(tileTexture);
        
    
    }
    
    public void addDefence(Defense newDefense){
        defences.add(newDefense);
        newDefense.setSize(size, size);
    }
    
    public void setTexture(Texture newTexture){
        this.tileSpirte = new Sprite(newTexture);
    }
    
    public void addCharacter(ICharacterDecorator newCharacter){
        characters.add(newCharacter);
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        tileSpirte.setPosition(x, y);

    }
    
    public void setsize(int size){
        this.size = size;
        tileSpirte.setSize(size, size);
        for(Defense def: defences){
            def.setSize(size, size);
        }
    }
    
    public void draw(SpriteBatch batch){
        tileSpirte.draw(batch);
        for(Defense def: defences){
            def.draw(batch,x,y);
        }
    }

    @Override
    public Iterator getIterator(int size) {
        return new VillageIterator(size);
    }
    
}
