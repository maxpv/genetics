package group2.genetics.operators.stop;

import group2.genetics.inhabitants.Population;

public class InfinityGrowth implements StopGrowth {

    @Override
    public boolean stopPopulationGrowth(Population population) {
        return false;
    }

    @Override
    public void reset() {
    }

}
