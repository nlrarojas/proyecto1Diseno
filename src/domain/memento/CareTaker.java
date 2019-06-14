package domain.memento;

import java.util.ArrayList;

public class CareTaker<T> {

    ArrayList<Memento<T>> mementos;

    public void addMemento(Memento<T> newMemento) {
        mementos.add(newMemento);
    }

    public Memento<T> getMemento(int mementoIndex) {
        return mementos.get(mementoIndex);
    }
    
    public void addAtIndex(int index, Memento<T> newMemento){
        if(index > mementos.size()-1) index = mementos.size()-1;
        mementos.removeAll(mementos.subList(index, mementos.size()-1));
        mementos.add(newMemento);
        
        
    }
    
    public int getTop(){
        return mementos.size() - 1;
    }

}
