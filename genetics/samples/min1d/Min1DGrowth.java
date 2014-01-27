package group2.genetics.samples.min1d;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.PopulationUtils;
import group2.genetics.operators.stop.StopGrowth;


public class Min1DGrowth implements StopGrowth {
    
    private double dx = 0.00001;
    private int loopCount = 0;
    private int loopMax = 150;
   
    @Override
    public boolean stopPopulationGrowth(Population population) {
        boolean d= (this.dx >= PopulationUtils.getStandartDeviation(population) && this.loopCount > 50|| this.loopCount > loopMax );
        this.loopCount++;
        return d;
    }

    @Override
    public void reset() {
    }
}
