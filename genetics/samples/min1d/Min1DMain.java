package group2.genetics.samples.min1d;

import group2.genetics.engine.GeneticSolver;

public class Min1DMain {
    public static void main(String[] args) {
        Min1DProblem p = new Min1DProblem();
        GeneticSolver solver = new GeneticSolver();
        solver.CREATE(p);
        solver.CREATEUI();
    }
}
