package group2.genetics.chronometer;

import group2.genetics.chronometer.events.StartEvent;
import group2.genetics.chronometer.events.StopEvent;
import group2.genetics.chronometer.events.TicTacEvent;
import group2.genetics.events.Observable;
import group2.genetics.ui.View;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost
 * <maxence.prevost@isen-lille.fr>
 */

public class ChronometerModel implements Observable<TicTacEvent, View<TicTacEvent>> {
    private long time;
    private int precision;
    private Collection<View> views;
    
    public ChronometerModel(int precision) {
        this.views = new ArrayList<>();
        this.precision = precision;
        this.reset();
    }
    
    public int getPrecision() {
        return this.precision;
    }
    
    public long getTime() {
        return this.time;
    }
    
    public void reset() {
        this.time = 0;
    }
    
    public void stop() {
        notifyObservers(new StopEvent(time));
    }
    
    public void start() {
        notifyObservers(new StartEvent(0));
    }
    
    public void tic() {
        time += precision;
        notifyObservers(new TicTacEvent(time));
    }     

    @Override
    public void addObserver(View<TicTacEvent> v) {
        this.views.add(v);
    }

    @Override
    public void removeObserver(View<TicTacEvent> v) {
        this.views.add(v);
    }

    @Override
    public void notifyObservers(TicTacEvent ev) {
        for (View v : views) {
            v.refresh(ev);
        }
    }
 }
