package group2.genetics.engine;

import group2.genetics.problem.Problem;
import group2.genetics.ui.GeneticUI;

public class GeneticSolver {

    private GeneticEngine engine;
    private Problem problem;
    
    public void CREATE(Problem p) {
        this.engine = GeneticEngine.getInstance();
        this.problem = p;
        this.engine.attachProblem(this.problem);
    }
    
    public void CREATEUI() {
        GeneticUI.CREATEUI(this.engine, this.problem, GeneticUI.Components.CONTROLS, GeneticUI.Components.PROBLEM);
    }
    
}
