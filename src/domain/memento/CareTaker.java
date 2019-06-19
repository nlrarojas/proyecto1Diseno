package domain.memento;

import java.io.Serializable;
import java.util.ArrayList;

public class CareTaker<T> implements Serializable{

    ArrayList<Memento<T>> mementos;

    public CareTaker(){
        mementos = new ArrayList<Memento<T>>();
    }
    
    public void addMemento(Memento<T> newMemento) {
        mementos.add(newMemento);
    }

    public Memento<T> getMemento(int mementoIndex) {
        return mementos.get(mementoIndex);
    }

    public void addAtIndex(int index, Memento<T> newMemento) {
        if (index > mementos.size() - 1) {
            index = mementos.size() - 1;
        }
        mementos.removeAll(mementos.subList(index, mementos.size() - 1));
        mementos.add(newMemento);

    }

    public int getTop() {
        return mementos.size() - 1;
    }
    
    public ArrayList<T> getMementoList(){
        ArrayList<T> list = new ArrayList<T>();
        for(Memento<T> mem : mementos){
            list.add(mem.getState());
        }
        
        return list;
    }
    
    public void setMementoList(ArrayList<T> newStates){
        for(T obj : newStates){
            mementos.add(new Memento<T>(obj));
        }
    }
    

}
