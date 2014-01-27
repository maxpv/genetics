package group2.genetics.ui.swing;

import group2.genetics.engine.playback.PlaybackState;
import group2.genetics.events.Event;
import group2.genetics.events.PlaybackEvent;
import group2.genetics.events.PopulationEvent;
import group2.genetics.ui.View;
import javax.swing.JLabel;

public class IterationsView extends JLabel implements View<Event> {

    private int count = 0;

    public IterationsView() {
        this.setText("0");
    }

    @Override
    public void refresh(Event ev) {
        if (ev instanceof PopulationEvent) {
            this.count++;
            this.setText(String.valueOf(count));
        } else if (ev instanceof PlaybackEvent && ((PlaybackEvent) ev).getState() == PlaybackState.STOPPED) {
            this.count = 0;
        }
    }
}
