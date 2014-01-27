package group2.genetics.samples.tsp;

import group2.genetics.inhabitants.Being;
import group2.genetics.operators.stop.StopGrowth;
import group2.genetics.problem.BeingProcess;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;
import group2.genetics.samples.tsp.ui.TSPUI;

public class TSPProblem implements Problem {
    
    private final int CROSS = 70;
    private final PopulationProcess CROSSP = new TSPCross();
    private final int MUTATE = 70;
    private final BeingProcess MUTATEP = new TSPMutate();
    private final StopGrowth STOP = null;
    private final static int GRAPH_SIZE = 10;
    private final Class[] VIEWS = { TSPUI.class };
    
    @Override
    public Being getBeing() {
        return new TSPBeing(TSPProblem.GRAPH_SIZE);
    }

    @Override
    public int getCrossProbability() {
        return this.CROSS;
    }

    @Override
    public PopulationProcess getCrossProcess() {
        return this.CROSSP;
    }

    @Override
    public int getMutateProbability() {
        return this.MUTATE;
    }

    @Override
    public BeingProcess getMutateProcess() {
        return this.MUTATEP;
    }

    @Override
    public StopGrowth getStopGrowth() {
        return this.STOP;
    }

    @Override
    public PopulationProcess getSelectProcess() {
        return null;
    }

    @Override
    public Class[] getViews() {
        return VIEWS;
    }

}
