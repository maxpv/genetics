package group2.genetics.engine;

import group2.genetics.chronometer.Chronometer;
import group2.genetics.engine.playback.PlaybackController;
import group2.genetics.engine.playback.PlaybackState;
import group2.genetics.inhabitants.Population;

public class EngineThread extends Thread implements PlaybackController {

    private Population generation;
    private boolean stepbystep;
    private Chronometer chronometer;
    private PlaybackState state = PlaybackState.STOPPED;

    public EngineThread(Population generation, boolean stepbystep, Chronometer chrono) {
        this.generation = generation;
        this.stepbystep = stepbystep;
        this.chronometer = chrono;
    }

    @Override
    public void run() {
        this.chronometer.start();
        Configuration configuration;
        do {
            configuration = Configuration.getInstance();
            this.generation.update(configuration.getSelection().select(this.generation));
            this.generation.update(configuration.getCrossOver().cross(this.generation));
            this.generation.update(configuration.getMutation().mutate(this.generation));
        } while (!configuration.getStop().stop(generation) && this.state == PlaybackState.PLAYING && !stepbystep);
        this.chronometer.stop();
    }

    @Override
    public PlaybackState state() {
        return this.state;
    }

    @Override
    public void Play() {
        this.state = PlaybackState.PLAYING;
    }

    @Override
    public void Pause() {
        this.state = PlaybackState.PAUSED;
    }

    @Override
    public void Stop() {
        this.state = PlaybackState.STOPPED;
    }
    
    @Override
    public void Reset() {
    }
    
}
