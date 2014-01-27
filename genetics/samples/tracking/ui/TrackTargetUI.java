package group2.genetics.samples.tracking.ui;

import group2.genetics.samples.tracking.TrackProblem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TrackTargetUI {
    private boolean free;
    
    private List<Point> points;
    private Graphics2D g2D;
    private Dimension canvasDimensions;
    private Point watershed;
    private List<Point> storedWatershed;
    
    public TrackTargetUI(int dynamic, Dimension canvasDim) {
        this.points = new ArrayList<>();
        this.canvasDimensions = canvasDim;
        this.watershed = new Point(0,0);
        this.storedWatershed = new LinkedList<>();
    }

    
    public void addTarget(Point d) {
        if(points.isEmpty()) {
            points.add(d);
        }
        Point last = points.get(points.size() - 1);
        if(last.x - d.x < 80 && last.y - d.y < 80) {
            points.add(d);
        }
    }
    
    public synchronized void refreshTrackZone(Graphics2D g) {
        if(free) {
            this.clear();
        }
    }
    
    public void lock() {
        this.free = false;
    }
    
    public void release() {
        this.free = true;
    }
    
    public void clear() {
        this.points.clear();
        this.watershed.setLocation(0, 0);
    }
    
    private void storeWatershed(Point p) {
        if(p.x + p.y == 0) {
            TrackProblem.setRefPoint(storedWatershed.get(storedWatershed.size()));
        } else {
            TrackProblem.setRefPoint(p);
            this.storedWatershed.add(p);
        }
    }
    
    public void setDirection() {
        if(this.points.isEmpty()) {
            this.watershed.setLocation(this.canvasDimensions.width/2, this.canvasDimensions.height/2);
        } else {
            Iterator<Point> it = points.iterator();
            Point p1;
            while(it.hasNext()) {
                p1 = it.next();

                watershed.x += p1.x;
                watershed.y += p1.y;
            }
            watershed.x = watershed.x / this.points.size();
            watershed.y = watershed.y / this.points.size();
            storeWatershed(watershed);
        }
    }
}
