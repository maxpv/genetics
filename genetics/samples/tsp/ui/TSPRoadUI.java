package group2.genetics.samples.tsp.ui;

import group2.genetics.samples.tsp.TSPCity;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class TSPRoadUI {
    
    static void DRAW(TSPCity a, TSPCity b, Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.green);
        Rectangle clipBounds = g2d.getClipBounds();
        
        g2d.draw(new Line2D.Double(a.getX()*clipBounds.width/200, a.getY()*clipBounds.height/200, b.getX()*clipBounds.width/200, b.getY()*clipBounds.height/200));
    }

}
