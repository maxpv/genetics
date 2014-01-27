package group2.genetics.problem;

import group2.genetics.inhabitants.Being;
import group2.genetics.operators.stop.StopGrowth;

public interface Problem {
    
    Being getBeing();
    
    int getCrossProbability();
    PopulationProcess getCrossProcess();
    
    int getMutateProbability();
    BeingProcess getMutateProcess();
    
    PopulationProcess getSelectProcess();

    StopGrowth getStopGrowth();
    
    Class[] getViews();
    
}
