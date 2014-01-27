package group2.genetics.operators.stop;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.PopulationUtils;

public class EvolveGrowth implements StopGrowth {

    private double previous_average = Double.NaN;
    private static double MIN_ERROR = 1/100;
    
    @Override
    public boolean stopPopulationGrowth(Population population) {
        double average = PopulationUtils.getAverage(population);
        if (Math.abs(average - previous_average)/previous_average > MIN_ERROR) {
            this.previous_average = average;
            return false;
        }
        return true;
    }

    @Override
    public void reset() {
    }
    
}
