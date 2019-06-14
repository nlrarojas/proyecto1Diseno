package domain.memento;

public class Originator<T> {

    private T state;

    public void set(T newState) {
        this.state = newState;
    }

    public Memento saveToMemento() {
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento<T> targetMemento) {
        this.state = targetMemento.getState();
    }
}
