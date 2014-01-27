package group2.genetics.operators.selection;

import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;
import java.util.Random;

public class Rank implements PopulationProcess {

    @Override
    public Population run(Population population) {
        Population pop = new Population();
        Population sortedpop = (Population) population.clone();
        sortedpop.sort();
        
        int size = sortedpop.size();
        int total = size*(size+1)/2;
        
        Random rand = new Random();
        int random;
        for (int i = 0; i < size/2; i++) {
            random = rand.nextInt(total)+1;
            //solve polynome n²+n-2*random=0
            int det = 1+8*random;
            int solution = (int) Math.ceil((-1+Math.sqrt(det))/2);
            
            pop.add(sortedpop.get(solution-1));
        }
        
        return pop;
    }

    @Override
    public void reset() {
    }
    
}
