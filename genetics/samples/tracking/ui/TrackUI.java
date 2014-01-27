package group2.genetics.samples.tracking.ui;

import group2.genetics.events.PopulationEvent;
import group2.genetics.samples.tracking.TrackProblem;
import group2.genetics.ui.JView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class TrackUI extends JPanel implements JView<PopulationEvent> {
    private TracksLayer lpane;
    private boolean start;

    public TrackUI() {
        Dimension d = TrackProblem.dim;
        this.lpane = new TracksLayer(d);  
        this.lpane.setPreferredSize(d);
        this.setLayout(new BorderLayout());
        this.add(lpane);
        this.setVisible(true);
        start = true;
    }

    public class Play extends Thread {
        private TracksLayer l;

        public Play(TracksLayer l) {
          this.l = l;
        }
        public void run() {
            l.play();
        }
     }
    
    public void start() {
        Play thread = new Play(this.lpane);
        thread.start();
    }
    
    @Override
    public void refresh(PopulationEvent ev) {
        if(start) {
            start();
            start = false;
        }
        lpane.refresh(ev); 
    }

    @Override
    public JComponent toJComponent() {
        return this;
    }

}