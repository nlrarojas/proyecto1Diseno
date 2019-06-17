package domain.memento;

public class Memento<T> {

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
