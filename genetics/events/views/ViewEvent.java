package group2.genetics.events.views;

import group2.genetics.events.Event;

public class ViewEvent extends Event {
    
    private Class view;
    private Type type;
    
    public enum Type {
        ATTACHED,
        DETACHED;
    }
    
    ViewEvent(Class view, Type type) {
        super(type.toString() + ": " + view);
        this.view = view;
        this.type = type;
    }
    
    public Type getType() {
        return type;
    }
    
    public Class getView() {
        return view;
    }
    
}
