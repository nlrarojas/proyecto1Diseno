package domain.memento;

import java.io.Serializable;

public class Originator<T> implements Serializable{

    private T state;

    public void set(T newState) {
        this.state = newState;
    }
    
   public T get(){
       return this.state;
   }

    public Memento saveToMemento() {
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento<T> targetMemento) {
        this.state = targetMemento.getState();
    }
}
