/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.character.CharacterComponent;
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
    private double elapsedTime = 0;
    

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
        newCharacter.setSize(size, size);
    }
    
    public void removeCharacter(ICharacterDecorator currentChar){
        CharacterComponent currentComp = (CharacterComponent)currentChar.getComponent();
        for (int i = characters.size()-1; i >=0; i--) {
            CharacterComponent comparedComp = (CharacterComponent)characters.get(i).getComponent();
            if(currentComp.getName().equals(comparedComp.getName())){
                characters.remove(i);
                break;
            }
        }
        characters.remove(currentChar);
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
        for(ICharacterDecorator character: characters){
            character.setSize(size,size);
        }
    }
    
    public void draw(SpriteBatch batch){
        tileSpirte.draw(batch);
        for(Defense def: defences){
            def.draw(batch,x,y);
            //System.out.println("draw deff");
        }
        
        for(ICharacterDecorator character: characters){
            character.draw(batch,x,y);
        }
    }

    @Override
    public Iterator getIterator(int size) {
        return new VillageIterator(size);
    }

    void simulate(double deltaTime,Village vill,int xCoord, int yCoord) {
        elapsedTime += deltaTime;
        //System.out.println(defences.size());
        
        
        for(int i = defences.size()-1 ; i >= 0; i--){
            if(i < defences.size()){
                defences.get(i).simulate(deltaTime,vill, xCoord, yCoord);
                //System.out.println("def simulation");
            }
        }
        for(int i = characters.size()-1 ; i >= 0; i--){
            //System.out.println("charsim");
            if(i < characters.size()){
            ICharacterDecorator currentChar = characters.get(i);
            currentChar.simulate(deltaTime,vill, xCoord, yCoord);
            }
        }
            //System.out.println("tile sym " + characters.size());
        
    }
    
    public boolean hasDefense(){
        return defences.size() > 0;
    }
    
    public boolean hasCharacter(){
        return characters.size() > 0;
    }
    
    
    public void attackTile(int damage){
        if(defences.size() > 0){
        defences.get(0).attack(damage);
            if(defences.get(0).getLife() <= 0){
                defences.remove(0);
            }
        }
        //System.out.println("attacked: " + damage);
    }
    
    public void attackUnit(int damage){
        //System.out.println("attacked: " + hasCharacter());
        if(characters.size() > 0){
        characters.get(0).attack(damage);
            if(((CharacterComponent)characters.get(0).getComponent()).getLife() <= 0){
                characters.remove(0);
            }
        }
        
    }
}
