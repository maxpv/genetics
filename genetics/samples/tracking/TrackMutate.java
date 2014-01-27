package group2.genetics.samples.tracking;

import group2.genetics.inhabitants.Being;
import group2.genetics.problem.BeingProcess;

public class TrackMutate implements BeingProcess {

    @Override
    public Being run(Being being) {
        TrackBeing t = (TrackBeing) being;
        t.setCoordX(t.getX() + (int) 0.6 * (t.getVX() - t.getX()));
        t.setCoordY(t.getY() + (int) 0.6 * (t.getVY() - t.getY()));
        return t;
    }

    @Override
    public void reset() {
    }
}
