package group2.genetics.ui;

import group2.genetics.events.Event;
import javax.swing.JComponent;

public interface JView<U extends Event> extends View<U> {

    JComponent toJComponent();
   
}
