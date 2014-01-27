package group2.genetics.samples.tracking;

import group2.genetics.inhabitants.Population;
import group2.genetics.problem.PopulationProcess;

public class TrackCross implements PopulationProcess {

    @Override
    public Population run(Population population) {
        Population pop = new Population(2);
        TrackBeing b1 = (TrackBeing) population.get(0);
        TrackBeing b2 = (TrackBeing) population.get(1);

        if (b1.isFixed() && !b2.isFixed()) {
            b2.translate(b1);
            b2.setvX(b1.getVX());
            b2.setvY(b1.getVY());
            b1.translate(b1);
        } else if (b2.isFixed() && !b1.isFixed()) {
            b1.translate(b2);
            b1.setvX(b2.getVX());
            b1.setvY(b2.getVY());
            b2.translate(b2);
        } else if (!b2.isFixed() && !b1.isFixed()) {
            b1.translate(b2);
            b2.translate(b1);
        } else {
            b2.translate(b2);
            b1.translate(b1);
        }

        b1.updateFixed();
        b2.updateFixed();
        pop.add(b1, b2);
        return pop;
    }

    @Override
    public void reset() {
    }
}
