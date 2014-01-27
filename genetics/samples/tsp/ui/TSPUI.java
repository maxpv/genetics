package group2.genetics.samples.tsp.ui;

import group2.genetics.events.PopulationEvent;
import group2.genetics.inhabitants.Population;
import group2.genetics.samples.tsp.TSPBeing;
import group2.genetics.ui.JView;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TSPUI extends JPanel implements JView<PopulationEvent> {
    
    private Population pop;        
    private TSPUISubPanel best;
    private JScrollPane pane;
    private TSPUIMultiSubPanel others;

    public TSPUI() {
        this.setLayout(new GridLayout(2,1));
        this.best = new TSPUISubPanel();
        this.add(best);
        
        this.others = new TSPUIMultiSubPanel();
        this.pane = new JScrollPane(this.others);
        this.add(pane);
    }
    
    @Override
    public void refresh(PopulationEvent ev) {
        this.pop = ev.getPopulation();        
        this.refresh(pop);
    }
    
    private void refresh(Population pop) {
        //Sort population
        pop.sort();
        //Update models
        this.best.setModel((TSPBeing) pop.get(0));
        this.others.setModel(pop.subPopulation(1,pop.size()-1));
    }

    @Override
    public JPanel toJComponent() {
        return this;
    }
    
}
