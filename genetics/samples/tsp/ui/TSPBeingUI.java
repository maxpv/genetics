package group2.genetics.samples.tsp.ui;

import group2.genetics.samples.tsp.TSPBeing;
import group2.genetics.samples.tsp.TSPCity;
import java.awt.Graphics2D;
import java.util.Iterator;

public class TSPBeingUI {

    static void DRAW(TSPBeing b,Graphics2D g2d) {
        if (b == null || b.size() == 0) {
            return;
        }
        
        Iterator<Integer> it = b.iterator();
        
        int city = it.next();
        int next = city;
        TSPCity tspcity = TSPBeing.getCity(city);
        TSPCity tspnext = tspcity;
        while (it.hasNext()) {
            TSPCityUI.DRAW(tspcity, g2d);
            next = it.next();
            tspnext = TSPBeing.getCity(next);
            TSPRoadUI.DRAW(tspcity, tspnext, g2d);
            city = next;
            tspcity = TSPBeing.getCity(city);
        }
    }
    
}
