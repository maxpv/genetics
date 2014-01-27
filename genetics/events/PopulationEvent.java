package group2.genetics.events;

import group2.genetics.inhabitants.Population;

public class PopulationEvent extends Event {

    protected Population pop;
    
    public PopulationEvent(Population pop) {
        super(pop.toString());
        this.pop = pop;
    }
    
    public PopulationEvent(Population pop, String text) {
        super(text);
        this.pop = pop;
    }
    
    public Population getPopulation() {
        return this.pop;
    }
}
