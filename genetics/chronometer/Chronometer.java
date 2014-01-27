package group2.genetics.chronometer;

import group2.genetics.chronometer.events.TicTacEvent;
import group2.genetics.events.Observable;
import group2.genetics.ui.View;
import java.util.Timer;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost
 * <maxence.prevost@isen-lille.fr>
 */
public class Chronometer {

    private Timer controller;
    private TicTask tic;
    private ChronometerModel model;
    private boolean active;

    public Chronometer() {
        this(100);
    }

    public Chronometer(int precision) {
        this.model = new ChronometerModel(precision);
        this.init();
    }

    private void init() {
        this.active = false;
        this.controller = new Timer();
        this.tic = new TicTask(this.model);
    }

    public int getPrecision() {
        return model.getPrecision();
    }
    
    public int getSeconds() {
        return (int) this.model.getTime() / 1000;
    }

    public void start() {
        if (!this.active) {
            this.active = true;
            this.controller.schedule(this.tic, 0, this.getPrecision());
        }
    }

    public void stop() {
        this.controller.cancel();
        this.model.stop();
        this.init();
    }

    public boolean isActive() {
        return this.active;
    }
    
    public void reset() {
        this.model.reset();
    }
    
    public void addObserver(View v) {
        model.addObserver(v);
    }
    
    public void removeObserver(View v) {
        model.removeObserver(v);
    }
}
