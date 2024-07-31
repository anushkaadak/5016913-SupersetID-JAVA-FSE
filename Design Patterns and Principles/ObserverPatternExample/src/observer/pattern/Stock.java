package observer.pattern;

public interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

