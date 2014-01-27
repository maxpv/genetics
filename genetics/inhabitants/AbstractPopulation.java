package group2.genetics.inhabitants;

import group2.genetics.events.Observable;
import group2.genetics.events.PopulationEvent;
import group2.genetics.ui.View;
import java.util.Iterator;

public interface AbstractPopulation extends Observable<PopulationEvent, View<PopulationEvent>>, Iterable<Being> {    
    
    public void add(Being... lives);
    public void addAll(Population pop);
    
    public void remove(Being b);
    public void remove(int index);
    
    public void clear();
    
    public int size();
    
    public Being get(int index);
    
    public void update(Population pop);
    
    public void sort();
    
    public Population subPopulation(int length);
    public Population subPopulation(int start, int end);
    
    @Override
    public Iterator<Being> iterator();
}
