package group2.genetics.samples.tsp;

import group2.genetics.engine.GeneticSolver;

public class TSPMain {
    public static void main(String[] args) {
        TSPProblem p = new TSPProblem();
        GeneticSolver solver = new GeneticSolver();
        solver.CREATE(p);
        solver.CREATEUI();
    }
}
