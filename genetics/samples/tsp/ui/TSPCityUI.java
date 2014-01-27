package group2.genetics.samples.tsp.ui;

import group2.genetics.samples.tsp.TSPCity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;

public class TSPCityUI {

    static void DRAW(TSPCity b, Graphics2D g2d) {
        g2d.setColor(Color.red);
        Rectangle clipBounds = g2d.getClipBounds();
        g2d.fill(new Arc2D.Double(b.getX()*clipBounds.width/200-5, b.getY()*clipBounds.height/200-5, 10.0d, 10.0d, 0.0d, 360.d, Arc2D.PIE));
    }
    
}
