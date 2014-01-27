package group2.genetics.engine;

import group2.genetics.chronometer.Chronometer;
import group2.genetics.engine.playback.PlaybackController;
import group2.genetics.engine.playback.PlaybackState;
import group2.genetics.events.Observable;
import group2.genetics.events.PlaybackEvent;
import group2.genetics.events.PopulationEvent;
import group2.genetics.inhabitants.Population;
import group2.genetics.problem.Problem;
import group2.genetics.ui.View;
import java.util.ArrayList;
import java.util.List;

/*
 * Le GeneticEngine contient la boucle appelant les processus nécessaires
 */
public class GeneticEngine implements PlaybackController, Observable<PlaybackEvent, View<PlaybackEvent>> {

    private static GeneticEngine INSTANCE;
    private Chronometer chrono;
    private Population generation;
    private EngineThread thread;
    protected boolean stepbystep = false;
    private List<View<PlaybackEvent>> observers;
    private List<View<PopulationEvent>> populationviews;

    public static GeneticEngine getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeneticEngine();
        }
        return INSTANCE;
    }

    private GeneticEngine() {
        this.chrono = new Chronometer();
        this.observers = new ArrayList<>();
        this.populationviews = new ArrayList<>();
    }

    public void attachProblem(Problem p) {
        Configuration.getInstance().initialize(p);
        this.generateFirstGeneration();
        this.thread = new EngineThread(this.generation, this.stepbystep, this.chrono);
    }

    public void generateFirstGeneration() {
        this.generation = Configuration.getInstance().getFirstGeneration();
    }

    public void attachPopulationView(View v) {
        this.generation.addObserver(v);
        this.populationviews.add(v);
    }

    public void removePopulationView(View v) {
        this.generation.removeObserver(v);
        this.populationviews.remove(v);
    }

    private void restoreViews() {
        for (View<PopulationEvent> v : populationviews) {
            this.generation.addObserver(v);
        }
    }

    public void attachPlaybackView(View v) {
        this.addObserver(v);
    }

    public void removePlaybackView(View v) {
        this.removeObserver(v);
    }
    
    public void attachChronometerView(View v) {
        this.chrono.addObserver(v);
    }
    
    public void removeChronometerView(View v) {
        this.chrono.removeObserver(v);
    }

    public boolean toggleStepByStep() {
        this.stepbystep = !this.stepbystep;
        if (this.stepbystep) {
            this.Pause();
        }
        return this.stepbystep;
    }

    public PlaybackState getState() {
        return this.thread.state();
    }

    @Override
    public PlaybackState state() {
        return this.thread.state();
    }
    
    //TODO check difference between STOP and RESET

    @Override
    public void Play() {
        this.thread = new EngineThread(this.generation, this.stepbystep, this.chrono);
        this.thread.Play();
        this.thread.start();
        this.notifyObservers(new PlaybackEvent(state()));
    }

    @Override
    public void Pause() {
        if (this.thread.state() == PlaybackState.PLAYING) {
            this.thread.Pause();
            this.notifyObservers(new PlaybackEvent(state()));
        }
    }

    @Override
    public void Stop() {
        this.thread.Stop();
        this.chrono.reset();
        this.generateFirstGeneration();
        this.restoreViews();
        this.notifyObservers(new PlaybackEvent(state()));
    }
    
    @Override
    public void Reset() {
        Configuration.getInstance().reset();
        this.Stop();
    }

    @Override
    public void addObserver(View<PlaybackEvent> obs) {
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(View<PlaybackEvent> obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObservers(PlaybackEvent ev) {
        for (View<PlaybackEvent> v : observers) {
            v.refresh(ev);
        }
    }
}
