package group2.genetics.samples.tsp.ui;

import group2.genetics.samples.tsp.TSPBeing;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TSPUISubPanel extends JPanel {

    private TSPBeing model;
    private static Dimension PREFERRED_SIZE = new Dimension(200,200);
    
    TSPUISubPanel() {
        this(null);
    }
    
    TSPUISubPanel(TSPBeing b) {
        this.setModel(b);
        this.setPreferredSize(PREFERRED_SIZE);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        TSPBeingUI.DRAW(model, g2d);
    }
    
    public void setModel(TSPBeing b) {
        this.model = b;
        this.repaint();
    }
    
}
