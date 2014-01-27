package group2.genetics.samples.min1d;

import group2.genetics.inhabitants.Being;
import group2.genetics.operators.stop.StopGrowth;
import group2.genetics.problem.BeingProcess;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;
import group2.genetics.samples.min1d.ui.Min1DUI; 
import java.util.Random;

public class Min1DProblem implements Problem {

    private final int CROSS = 70;
    private final PopulationProcess CROSSP = new Min1DCross();
    private final int MUTATE = 30;
    private final BeingProcess MUTATEP = new Min1DMutate();
    private final StopGrowth STOP = new Min1DGrowth();
    
    private static DemoFunctions func = DemoFunctions.A;
    
    private static int max = func.getMax();
    private static int min = func.getMin();
    
    private int initIndex;
    
    public static double f(double x) {
        return func.f(x);
    }
    
    public static String getFExpression() {
        return func.getExpression();
    }
     
    public Min1DProblem() {
        this.initIndex = min;
    }
    
    @Override 
    public Being getBeing() {
        Random r = new Random();
        double minus = r.nextDouble() +1;
        double delta = (r.nextInt()%3) / (minus); //delta belongs to [0,2]
        this.initIndex++;
        this.initIndex = (this.initIndex == max) ? min : this.initIndex;
        return (Being) new Min1DBeing(initIndex + delta);
    }

    public static int getUpperBound() {
        return max;
    }
    
    public static int getLowerBound() {
        return min;
    }
    
    @Override
    public int getCrossProbability() {
        return CROSS;
    }

    @Override
    public PopulationProcess getCrossProcess() {
        return CROSSP;
    }

    @Override
    public int getMutateProbability() {
        return MUTATE;
    }

    @Override
    public BeingProcess getMutateProcess() {
        return MUTATEP;
    }

    @Override
    public StopGrowth getStopGrowth() {
        return STOP;
    }

    @Override
    public PopulationProcess getSelectProcess() {
        return null;
    }

    @Override
    public Class[] getViews() {
        Class[] views = {Min1DUI.class};
        return views;
    }
}
