package group2.genetics.samples.min1d;

import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;


public class Min1DCross implements PopulationProcess {

    @Override
    public Population run(Population population) {
        Population pop = new Population(2);
        
        Min1DBeing ba = (Min1DBeing ) population.get(0), bb = (Min1DBeing) population.get(1);
        double xa = ba.getAbscissa(), xb = bb.getAbscissa();
        if(xa - xb < 0) { //b à gauche
            double tmp = xa;
            xa = xb;
            xb = tmp;
        }     
        
        double average = (0.3*(xa - xb));
        ba.setAbscissa(ba.getAbscissa() + average);
        bb.setAbscissa(bb.getAbscissa() - average);
        pop.add(ba, bb);
        return pop;
    }

    @Override
    public void reset() {
    }
}
