package group2.genetics.operators.crossover;

import group2.genetics.engine.Configuration;
import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.ProblemInitializable;
import group2.genetics.miscellaneous.Resetable;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;
import java.util.Random;


/* 
 * La classe CrossOver contient la boucle qui appelle le croisement crossProcess sur chaque couple de la population
 */
public class CrossOver implements ProblemInitializable, Resetable {

    private int probability;
    private PopulationProcess crossProcess;

    public CrossOver() {
    }

    public Population cross(Population pop) throws UnsupportedOperationException {
        if (this.crossProcess == null) {
            throw new UnsupportedOperationException("No crossover process is defined");
        }

        int size = pop.size();
        int maxsize = Configuration.getInstance().getPopulationSize();

        Population newPop = new Population(maxsize);
        Population p = new Population(2);

        int i, j;
        Random rand = new Random();
        while (newPop.size() < maxsize && size > 0) {
            i = rand.nextInt(size);
            j = rand.nextInt(size);

            if (rand.nextDouble() < this.probability) {
                p.add(pop.get(i), pop.get(j));
                newPop.addAll(this.crossProcess.run(p));

                p.clear();
            } else {
                newPop.add(pop.get(i));
                newPop.add(pop.get(j));
            }
        }

        int difference = newPop.size() - maxsize;
        while (difference > 0) {
            newPop.remove(rand.nextInt(maxsize + difference - 1));
            difference--;
        }

        return newPop;
    }

    public void setProcess(PopulationProcess process) {
        if (process != null) {
            this.crossProcess = process;
        }
    }
    
    public int getProbability() {
        return this.probability;
    }
    
    public void setProbability(int probability) {
        if (probability >= 0 && probability <= 100) {
            this.probability = probability;
        }
    }

    @Override
    public void initialize(Problem p) {
        this.probability = p.getCrossProbability();
        this.crossProcess = p.getCrossProcess();
    }

    @Override
    public void reset() {
        this.crossProcess.reset();
    }
}
