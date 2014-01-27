package group2.genetics.events.views;

import group2.genetics.ui.View;

public class DetachedViewEvent extends ViewEvent {
    
        public DetachedViewEvent(Class view) {
        super(view, ViewEvent.Type.DETACHED);
    }
    
}
