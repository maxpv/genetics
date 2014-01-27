package group2.genetics.operators.selection;

import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;
import java.util.Random;

public class Tournament implements PopulationProcess {

    @Override
    public Population run(Population population) {
        Population duplicated = (Population) population.clone();
        Population winners = new Population();
        
        int time = population.size()/2;
        int size;
        Random rand = new Random();
        Being firstb, secondb;
        for (int i = 0; i < time; i++) {
            size = duplicated.size();
            int first = rand.nextInt(size);
            firstb = duplicated.get(first);
            duplicated.remove(firstb);
            int second = rand.nextInt(size-1);
            secondb = duplicated.get(second);
            duplicated.remove(secondb);
            
            if (firstb.compareTo(secondb) >= 0) {
                winners.add(firstb);
            } else {
                winners.add(secondb);
            }
        }
        
        return winners;
    }

    @Override
    public void reset() {
    }
    
}
