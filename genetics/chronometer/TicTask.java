package group2.genetics.chronometer;

import java.util.TimerTask;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost
 * <maxence.prevost@isen-lille.fr>
 */
public class TicTask extends TimerTask {
    private ChronometerModel model;
    
    public TicTask(ChronometerModel model) {
        this.model = model;
    }
    
    @Override
    public void run() {
        model.tic();
    }
    
}
