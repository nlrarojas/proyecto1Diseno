package domain.iterator;

import domain.Village;

/**
 *
 * @author nelson
 */
public class VillageIterator implements Iterator {

    private Village village [];
    private int pos;
    
    public VillageIterator(int size) {
        this.village = new Village[size];
        this.pos = 0;
    }
    
    @Override
    public boolean hasNext() {
        return (this.pos >= this.village.length || this.village[this.pos] == null);
    }

    @Override
    public Object next() {
        Village village =  this.village[this.pos]; 
        this.pos += 1; 
        return village; 
    }
    
}
