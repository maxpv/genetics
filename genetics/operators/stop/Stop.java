package group2.genetics.operators.stop;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.ProblemInitializable;
import group2.genetics.miscellaneous.Resetable;
import group2.genetics.problem.Problem;

public class Stop implements ProblemInitializable, Resetable {

    private StopGrowth stopProcess;
    
    public Stop() {
        this.stopProcess = new InfinityGrowth();
    }
    
    public void setProcess(StopGrowth process) {
        if (process != null) {
            this.stopProcess = process;
        }
    }
    
    public boolean stop(Population pop) {
        return this.stopProcess.stopPopulationGrowth(pop);
    }

    @Override
    public void initialize(Problem p) {
        this.setProcess(p.getStopGrowth());
    }

    @Override
    public void reset() {
        this.stopProcess.reset();
    }

}
