package group2.genetics.operators.mutation;

import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.ProblemInitializable;
import group2.genetics.miscellaneous.Resetable;
import group2.genetics.problem.BeingProcess;
import group2.genetics.problem.Problem;
import java.util.Random;

/*
 * Mutation appelle mutate sur chaque couple d'éléments dans la population
 */
public class Mutation implements ProblemInitializable, Resetable {

    private int mutation_chance = 0;
    private BeingProcess mutateProcess;

    public Mutation() {
    }

    /*
     * La population donnée au mutateProcess est un couple d'éléments
     */
    public Population mutate(Population pop) throws UnsupportedOperationException {
        if (this.mutateProcess == null) {
            throw new UnsupportedOperationException("No mutation process is defined");
        }

        Population newPop = new Population(pop.size());
        Random rand = new Random();
        for (Being b : pop) {
            double randomd = rand.nextDouble();
            if (randomd <= mutation_chance) {
                newPop.add(this.mutateProcess.run(b.clone()));

            } else {
                newPop.add(b.clone());
            }
        }
        return newPop;
    }

    public void setProcess(BeingProcess process) {
        if (process != null) {
            this.mutateProcess = process;
        }
    }
        
    public int getProbability() {
        return this.mutation_chance;
    }
    
    public void setProbability(int probability) {
        if (probability >= 0 && probability <= 100) {
            this.mutation_chance = probability;
        }
    }

    @Override
    public void initialize(Problem p) {
        this.mutateProcess = p.getMutateProcess();
        this.mutation_chance = p.getMutateProbability();
    }

    @Override
    public void reset() {
        this.mutateProcess.reset();
    }
}
