package group2.genetics.samples.tracking;
import group2.genetics.inhabitants.Being;
import java.awt.Point;
import java.util.Random;


public class TrackBeing extends Being {
    private int coordX;
    private int coordY;
    
    private int vX;
    private int vY;
    
    private boolean fixed;

    private static double glueCoeff = TrackProblem.getGlueCoeff();
        
    public TrackBeing() {
        Random r = new Random();
        this.coordX = r.nextInt(TrackProblem.dim.width);
        this.coordY = r.nextInt(TrackProblem.dim.height);  
        this.setRefVector();
        this.updateFixed();
     }
    
    /*
     * Créer un clone du point (fixé)
     * et le decale dans le sens opposé 
     * au vecteur v, pour épaissir la bordure
     */
    public TrackBeing(TrackBeing b) {
        this();
        this.translate(b);
        if(b.isFixed()) {
            this.setFixed(b.isFixed());
        } else {
            this.updateFixed();
        }
        
    }
    
    public void setRefVector() {
        Point d = TrackProblem.getRefPoint(); //prevent unsychronisation
        this.setvX(d.x);
        this.setvY(d.y);
    }

    public final void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public final void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public final void setvX(int vX) {
        this.vX = vX;
    }

    public final void setvY(int vY) {
        this.vY = vY;
    }
    
    public void translate(TrackBeing b) {
        this.setCoordX(this.coordX + (int) Math.round(glueCoeff*(-this.coordX +b.getVX())));
        this.setCoordY(this.coordY + (int) Math.round(glueCoeff*(-this.coordY +b.getVY())));
    }

    /*
     * fixed : means that the point is in
     *         the neighboorhood of a searched 
     *         color point.
     */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
    public void updateFixed() {
        setFixed(TrackProblem.isNear(this.coordX, this.coordY));
        if(this.isFixed()) {
            TrackProblem.setRefPoint(new Point(this.vX, this.vY));
            this.setvX(this.getX());
            this.setvY(this.getY());
        }
    }
    
    public int getX() { 
        return this.coordX;
    }
    
    public int getY() {
        return this.coordY;
    }
    
    public int getVX() {
        return this.vX;
    }
    
    public int getVY() {
        return this.vY;
    }
    
    public boolean isFixed() {
        return this.fixed;
    }
    
    public double getNorm() {
        return Math.sqrt(Math.pow(getX() - getVX(), 2) + Math.pow(getY() - getVY(), 2));
    }
    
    @Override
    public double evaluate() {
        return Math.exp(-getNorm());
    }

    @Override
    public Being clone() {
        return new TrackBeing(this);
    }
}
