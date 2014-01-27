package group2.genetics.samples.min1d;

import group2.genetics.inhabitants.Being;


public class Min1DBeing extends Being {
    private double x;
    
    public Min1DBeing() {
        this(0);
    }
    
    public void setAbscissa(double x) {
        this.x = x;
    }
    
    public double getAbscissa() {
        return this.x;
    }
    
    public Min1DBeing(double x) {
        this.setAbscissa(x);
    }
    
    @Override
    public double evaluate() {
        return 5*Math.exp(-Min1DProblem.f(x)/0.5);
    }
    
    @Override
    public Being clone() {
        return new Min1DBeing(this.x);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.x);
    }

}
