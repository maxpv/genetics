package group2.genetics.operators.stop;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.Resetable;

public interface StopGrowth extends Resetable {
    boolean stopPopulationGrowth(Population population);
}
