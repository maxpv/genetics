package group2.genetics.samples.tsp;

import java.awt.geom.Point2D;

public class TSPCity extends Point2D {

    double x, y;
    
    public TSPCity(double x, double y) {
        this.setLocation(x, y);
    }
    
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getDistance(Point2D p) {
        return Math.sqrt(Math.pow(this.getX()-p.getX(),2.0d)+Math.pow(this.getY()-p.getY(),2));
    }

}
