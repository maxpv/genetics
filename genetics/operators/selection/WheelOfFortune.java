package group2.genetics.operators.selection;

import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.miscellaneous.PopulationUtils;
import java.util.Iterator;
import java.util.Random;

public class WheelOfFortune implements PopulationProcess {

    @Override
    public Population run(Population population) {
        Population selectedPopulation = new Population(population.size());
        
        int size = population.size()/2;
        
        double total = PopulationUtils.getSum(population);
        
        Random rand = new Random();
        double random, offset, value;
        boolean found;
        Iterator<Being> it;
        Being b;
        for (int i = 0; i < size; i++) {
            random = rand.nextDouble()*total;
            it = population.iterator();
            offset = 0;
            found = false;
            
            while (!found && it.hasNext()) {
                b = it.next();
                value = b.evaluate();
                if (random < offset + value) {
                    selectedPopulation.add(b.clone());
                    found = true;
                }
                offset += value;
            }
        }
        return selectedPopulation;
    }

    @Override
    public void reset() {
    }

}
