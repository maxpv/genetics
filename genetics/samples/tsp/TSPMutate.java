package group2.genetics.samples.tsp;

import group2.genetics.inhabitants.Being;
import group2.genetics.problem.BeingProcess;
import java.util.Random;

public class TSPMutate implements BeingProcess {

    @Override
    public Being run(Being being) {
        Random rand = new Random();
        TSPBeing tspbeing = (TSPBeing) being;
        
        int max = tspbeing.size()-2;
        int first = rand.nextInt(max)+1;
        int second;
        
        do {
            second = rand.nextInt(max)+1;
        } while (second == first);
        
        int tmp = tspbeing.get(first);
        tspbeing.set(first, tspbeing.get(second));
        tspbeing.set(second, tmp);
        
        return tspbeing;
    }

    @Override
    public void reset() {
    }

}
