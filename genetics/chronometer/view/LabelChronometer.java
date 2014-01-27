package group2.genetics.chronometer.view;

import group2.genetics.chronometer.events.TicTacEvent;
import group2.genetics.ui.View;
import javax.swing.JLabel;

public class LabelChronometer extends JLabel implements View<TicTacEvent> {
    
    private float seconds = 0;
    
    public LabelChronometer() {
        this.setText("0");
    }
    
    @Override
    public void refresh(TicTacEvent e) {
        this.seconds = e.getDeciSeconds();
        this.setText(String.valueOf(this.seconds));
    }
    
}
