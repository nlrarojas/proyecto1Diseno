package domain.memento;

import java.io.Serializable;

public class Memento<T> implements Serializable{

    private T state;

    public Memento(T initialState) {
        this.state = initialState;
    }

    public void setState(T newState) {
        this.state = newState;
    }

    public T getState() {
        return this.state;
    }
}
