package group2.genetics.events;

import group2.genetics.engine.playback.PlaybackState;

public class PlaybackEvent extends Event {

    private PlaybackState state;
    
    public PlaybackEvent(PlaybackState state) {
        super(state.toString());
        this.state = state;
    }
    
    public PlaybackEvent(PlaybackState state, String string) {
        super(string);
        this.state = state;
    }
    
    public PlaybackState getState() {
        return this.state;
    }
    
}
