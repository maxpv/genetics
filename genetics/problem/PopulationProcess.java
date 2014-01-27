package group2.genetics.problem;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.Resetable;

public interface PopulationProcess extends Resetable {
    /*
     * Un Cross est appelé avec une population de 2
     */
    Population run(Population population);   
}
