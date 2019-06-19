package domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import domain.character.ICharacterDecorator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Nelson
 */
public class Village implements Serializable{
    private static final long serialVersionUID = 7529637895000426690L;
    //square size of village
    protected int size;
    protected int gold;
    protected int level;
    protected int life;
    protected VillageTile[][] tiles;
    private transient Texture tileTexture;
    private transient Texture cityTexture; 
    private transient Sprite citySprite;
    private transient SpriteBatch villageBatch;
    
    public Village(int size, int gold, int level) {
        this.size = size;
        this.gold = gold;
        this.level = level;
        this.life = 100;
        this.tiles = new VillageTile[size][size];
        
        InitializeTiles();
    }
    
    private void InitializeTiles(){
        this.tileTexture = new Texture(Gdx.files.internal("village/tile.jpg"));
        this.villageBatch = new SpriteBatch();
        cityTexture = new Texture(Gdx.files.internal("village/city.png"));
        citySprite = new Sprite(cityTexture);
        
        int tileSize = 620/size;
        int initialX = (1280 - 720)/2;
        int initialY = (720 - 620)/2;
        citySprite.setSize(tileSize*2, tileSize*2);
        citySprite.setPosition(initialX+(size/2-1)*tileSize,initialY+(size/2-1)*tileSize);
        
        //initialize each tile
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                //initialize tile values
                VillageTile currentTile = new VillageTile(tileTexture);
                currentTile.setPosition(initialX + tileSize*x, initialY+ tileSize*y);
                currentTile.setsize(tileSize);
                //store new tile
                tiles[x][y] = currentTile;
            }
        }
    }
    
    public void addRandomdefense(Defense newDefense){
        //use cordinates avoiding borders
        int newX =  1 + (int)(Math.random()*(size-3));
        int newY = 1 + (int)(Math.random()*(size-3));
        
        //if is over town hall reasign building
        while(isOverTownHall(newX, newY)){
            newX =  1 + (int)(Math.random()*(size-3));
            newY = 1 + (int)(Math.random()*(size-3));
        }
        
        
        System.out.println("x: " + newX + " ,y: "+ newY);
        tiles[newX][newY].addDefence(newDefense);
    }
    
    private boolean isOverTownHall(int x, int y){
        return (x >= size/2-1 && x <= size/2) && ( y >=  size/2-1 &&  y <= size/2);
    }
    
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Village{" + "size=" + size + ", gold=" + gold + ", level=" + level + ", life=" + life + ", tiles=" + tiles + '}';
    }

    public void dispose(){  
        tileTexture.dispose();
        villageBatch.dispose();
    }
    
    public void draw(){
        villageBatch.begin();
        drawTiles();
        citySprite.draw(villageBatch);
        villageBatch.end();
    }
    
    private void drawTiles(){
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                tiles[x][y].draw(villageBatch);
            }
        }
    }
    

     private void readObject(ObjectInputStream ois) throws Exception 
    { 
        // performing default deserialization of Account object 
        ois.defaultReadObject(); 
        
        //do all image loading
        this.tileTexture = new Texture(Gdx.files.internal("village/tile.jpg"));
        this.villageBatch = new SpriteBatch();
        cityTexture = new Texture(Gdx.files.internal("village/city.png"));
        citySprite = new Sprite(cityTexture);
        
        System.out.println(tiles);
        
        int tileSize = 620/size;
        int initialX = (1280 - 720)/2;
        int initialY = (720 - 620)/2;
        citySprite.setSize(tileSize*2, tileSize*2);
        citySprite.setPosition(initialX+(size/2-1)*tileSize,initialY+(size/2-1)*tileSize);
        for(int x = 0; x < size;x++){
            for (int y = 0; y < size; y++) {
                tiles[x][y].setTexture(tileTexture);
                tiles[x][y].setPosition(initialX + tileSize*x, initialY+ tileSize*y);
                tiles[x][y].setsize(tileSize);
            }
        }
    }
     
      public void addRandomChar(ICharacterDecorator newChar){
        //use cordinates avoiding borders
        int newX;
        int newY;
        
        float side = (float)Math.random();
        if(side < 0.25){
            newX = (int)(Math.random()*(size-0.01));
            newY = size -1;
        }else if(side < 0.5){
            newX = size-1;
            newY = (int)(Math.random()*(size-0.01));
        }else if(side < 0.75){
            newX = (int)(Math.random()*(size-0.01));
            newY = 0;
        }else{
            newX = 0;
            newY = (int)(Math.random()*(size-0.01));
        }
        

        
        System.out.println("x: " + newX + " ,y: "+ newY);
        tiles[newX][newY].addCharacter(newChar);
    }
      
    public void simulate(double deltaTime){
          for(int x = 0; x < size;x++){
            for (int y = 0; y < size; y++) {
                tiles[x][y].simulate(deltaTime,this,x,y);

            }
        }
      }
      
    public boolean freeTile(int x,int y){
          if(x < 0 || y < 0 || x >= size || y >= size){
              return false;
          }
          if(tiles[x][y].hasDefense()) return false;
          if(isOverTownHall(x, y)) return false;
          
          return true;
    }
    
    public VillageTile visitTile(int x, int y){
        return tiles[x][y];
    }
     
}
