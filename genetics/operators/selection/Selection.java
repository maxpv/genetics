package group2.genetics.operators.selection;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.ProblemInitializable;
import group2.genetics.miscellaneous.Resetable;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;

public class Selection implements ProblemInitializable, Resetable {

    private PopulationProcess choiceProcess;
    
    public Selection() {
        this.choiceProcess = new WheelOfFortune();
    }
    
    public void setProcess(PopulationProcess process) {
        if (process != null) {
            this.choiceProcess = process;
        }
    }
    
    public Population select(Population pop) {
        return this.choiceProcess.run(pop);
    }

    @Override
    public void initialize(Problem p) {
        this.setProcess(p.getSelectProcess());
    }

    @Override
    public void reset() {
        this.choiceProcess.reset();
    }
    
}
