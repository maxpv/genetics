package group2.genetics.operators.stop;

import group2.genetics.engine.Configuration;
import group2.genetics.inhabitants.Population;

public class StopIterations implements StopGrowth {

    private int iterations;
    
    public StopIterations() {
        this.iterations = 0;
    }
    
    @Override
    public boolean stopPopulationGrowth(Population population) {
        int stopIterations= Configuration.getInstance().getStopIterations();
        return !(stopIterations == 0 || (this.iterations++ < stopIterations));
    }

    @Override
    public void reset() {
        this.iterations = 0;
    }

}
