package group2.genetics.events.views;

import group2.genetics.ui.View;

public class AttachedViewEvent extends ViewEvent {
    
    public AttachedViewEvent(Class view) {
        super(view, ViewEvent.Type.ATTACHED);
    }
    
}
