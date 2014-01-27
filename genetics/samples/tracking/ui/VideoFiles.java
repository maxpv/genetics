package group2.genetics.samples.tracking.ui;

import java.awt.Color;
import java.awt.Dimension;

public enum VideoFiles {    
    ANT_MAZE("file:///var/www/java/ant_maze/sortie.avi", 
            new Dimension(480, 360), 
            new Color(95, 95, 100));
    
    private String url;
    private Dimension d;
    private Color c;
    VideoFiles(String url, Dimension d, Color refColor) {
        this.url = url;
        this.d = d;
        this.c = refColor;
    }
    
    public Dimension getDim() {
        return d;
    }
    
    public Color getColor() {
        return c;
    }
    
    public String getURL() {
        return url;
    }
}
