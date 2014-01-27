package group2.genetics.engine.playback;

public interface PlaybackController {
    
    PlaybackState state();    
    void Play();
    void Pause();
    void Stop();
    void Reset();
}
