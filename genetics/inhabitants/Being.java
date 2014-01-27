package group2.genetics.inhabitants;

public abstract class Being implements Comparable<Being>, Cloneable {

    public abstract double evaluate();
    
    @Override
    public int compareTo(Being b) {
        return (int) Math.signum(this.evaluate() - b.evaluate());
    }
    
    @Override
    public abstract Being clone();
    
    @Override
    public String toString() {
        return String.valueOf(this.evaluate());
    }
    
}

