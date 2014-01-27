package group2.genetics.samples.tracking;

import group2.genetics.engine.GeneticSolver;


public class TrackingMain {
    public static void main(String[] args) {
        TrackProblem p = new TrackProblem();
        GeneticSolver solver = new GeneticSolver();
        solver.CREATE(p);
        solver.CREATEUI();
    }
}
