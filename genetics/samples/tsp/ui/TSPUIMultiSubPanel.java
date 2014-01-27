package group2.genetics.samples.tsp.ui;

import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import group2.genetics.samples.tsp.TSPBeing;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class TSPUIMultiSubPanel extends JPanel {

    private List<TSPUISubPanel> panels;

    public TSPUIMultiSubPanel() {
        this.panels = new ArrayList<>();
    }

    public void setModel(Population p) {
        if (p.size() != panels.size()) {
            this.removeAll();
            this.panels.clear();
            TSPUISubPanel panel;
            for (Being b : p) {
                panel = new TSPUISubPanel((TSPBeing) b);
                this.panels.add(panel);
                this.add(panel);
            }
        } else {
            int size = p.size();
            for (int i = 0; i < size; i++) {
                this.panels.get(i).setModel((TSPBeing) p.get(i));
            }
        }
        this.revalidate();
        this.repaint();
    }
}
