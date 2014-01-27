package group2.genetics.ui;

import group2.genetics.events.Event;

public interface View<U extends Event> {

    void refresh(U ev);
}
