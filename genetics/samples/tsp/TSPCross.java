package group2.genetics.samples.tsp;

import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;
import java.util.Random;

public class TSPCross implements PopulationProcess {

    @Override
    public Population run(Population population) {

        Population newPop = new Population(2);

        TSPBeing[] parents = new TSPBeing[2];
        parents[0] = (TSPBeing) population.get(0);
        parents[1] = (TSPBeing) population.get(1);

        int size = parents[0].size();

        if (parents[0].size() != parents[1].size()) {
            return newPop;
        }

        TSPBeing[] children = new TSPBeing[2];
        children[0] = new TSPBeing(parents[0]);
        children[1] = new TSPBeing(parents[1]);

        Random rand = new Random();

        int leftcut = rand.nextInt(size - 2) + 1;
        int rightcut;
        do {
            rightcut = rand.nextInt(size - 2) + 1;
        } while (rightcut == leftcut);

        if (rightcut < leftcut) {
            int swap = leftcut;
            leftcut = rightcut;
            rightcut = swap;
        }
        
        leftcut = 4;
        rightcut = 8;

        for (int child = 0; child < 2; child++) {
            for (int i = 1; i < leftcut; i++) {
                children[child].set(i, 0);
            }
        }

        for (int child = 0; child < 2; child++) {
            for (int i = rightcut; i < size - 1; i++) {
                children[child].set(i, 0);
            }
        }

        int parentcity;
        for (int child = 0; child < 2; child++) {
            for (int i = 1; i < leftcut; i++) {
                parentcity = parents[1 - child].get(i);
                if (!children[child].contains(parentcity)) {
                    children[child].set(i, parentcity);
                }
            }
        }

        for (int child = 0; child < 2; child++) {
            for (int i = rightcut; i < size - 1; i++) {
                parentcity = parents[1 - child].get(i);
                if (!children[child].contains(parentcity)) {
                    children[child].set(i, parentcity);
                }
            }
        }
        
        int pos;
        int value;
        TSPBeing currentParent;
        TSPBeing nextParent;
        TSPBeing swap;
        for (int child = 0; child < 2; child++) {
            for (int i = 1; i < leftcut; i++) {
                currentParent = parents[1-child];
                nextParent = parents[child];
                pos = i;
                value = currentParent.get(pos);
                
                if (children[child].get(i) == 0) {
                    do {
                        pos = nextParent.indexOf(value);
                        value = currentParent.get(pos);
                    } while (children[child].contains(value));
                    children[child].set(i, value);
                }
            }
            for (int i = rightcut; i < size-1; i++) {
                currentParent = parents[1-child];
                nextParent = parents[child];
                pos = i;
                value = currentParent.get(pos);
                
                if (children[child].get(i) == 0) {
                    do {
                        pos = nextParent.indexOf(value);
                        value = currentParent.get(pos);
                    } while (children[child].contains(value));
                    children[child].set(i, value);
                }
            }
        }
        
        newPop.add(children);
        return newPop;

    }

    @Override
    public void reset() {
    }

}
