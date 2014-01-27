package group2.genetics.samples.tracking.ui;

import group2.genetics.samples.tracking.TrackBeing;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;


public class TrackBeingUI {
    private static Polygon ui = new Polygon();
    private static Point p = new Point(0,0);
    private static int count = 0;
    public static void prepare(TrackBeing b) {
        if(b.isFixed()) {   
            p.x += b.getVX();
            p.y += b.getVY();
            count++;
        }
    }
    
    public static void DRAW(Graphics2D g) {
        g.setColor(Color.GREEN);
        if(p.x != 0 && p.y != 0) {
           ui.addPoint(p.x/count, p.y/count);
           p.x = p.y =  0;
        }
        count = 0;
        g.draw(ui);
    }
}
