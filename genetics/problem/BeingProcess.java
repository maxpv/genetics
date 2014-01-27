package group2.genetics.problem;

import group2.genetics.inhabitants.Being;
import group2.genetics.miscellaneous.Resetable;

public interface BeingProcess extends Resetable {
    Being run(Being being);   
}
