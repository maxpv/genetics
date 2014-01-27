package group2.genetics.samples.min1d;

import group2.genetics.inhabitants.Being;
import group2.genetics.problem.BeingProcess;
import java.util.Random;


public class Min1DMutate implements BeingProcess {
    private double delta_percent = 0.3;    
    private static Random rand = new Random();
    @Override
    public Being run(Being being) {
        int mult = (rand.nextBoolean() == false) ? -1 : 1;
        
        Min1DBeing b = (Min1DBeing)being;
        b.setAbscissa(b.getAbscissa() + mult*this.delta_percent*rand.nextDouble());
        return b;
    }

    @Override
    public void reset() {
    }
}