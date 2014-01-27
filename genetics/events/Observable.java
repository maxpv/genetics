package group2.genetics.events;

import group2.genetics.ui.View;

public interface Observable<T extends Event, U extends View> {

    void addObserver(U obs);
    void removeObserver(U obs);
    void notifyObservers(T ev);    
}
