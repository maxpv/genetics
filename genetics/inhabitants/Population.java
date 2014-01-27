package group2.genetics.inhabitants;

import group2.genetics.events.PopulationEvent;
import group2.genetics.ui.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Population implements AbstractPopulation {

    private List<View<PopulationEvent>> observers;
    private List<Being> lives;
    
    private int displaySteps;
    private int countSteps;
    
    public Population() {
        this(0);
    }
    
    public Population(int size) {
        this.observers = new ArrayList<>();
        this.lives = new ArrayList<>(size);
        this.setDisplaySteps(3);
    }
    
    public Population(Being... lives) {
        this(lives.length);
        for (Being being : lives) {
            this.add(being);
        }
    }
    
    public void setDisplaySteps(int i) {
        if(i <= 3 && i >= 1) {
            this.displaySteps = i;
        } else {
            this.displaySteps = 3; //Affichage tous les cycle principal
        }
    }
    
    public int getDisplaySteps() {
        return this.displaySteps;
    }
    
    @Override
    public void add(Being... lives) {
        for (Being b : lives) {
            this.lives.add(b);
        }
    }
    
    @Override
    public void remove(Being b) {
        this.lives.remove(b);
    }
    
    @Override
    public void clear() {
        this.lives.clear();
    }

    @Override
    public Iterator<Being> iterator() {
        return this.lives.iterator();
    }
    
    @Override
    public int size() {
        return this.lives.size();
    }

    @Override
    public Being get(int index) {
        return this.lives.get(index);
    }

    @Override
    public void addAll(Population pop) {
        for (Being b : pop) {
            this.add(b);
        }
    }

    @Override
    public void remove(int index) {
        this.lives.remove(index);
    }

    @Override
    public void addObserver(View<PopulationEvent> obs) {
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(View<PopulationEvent> obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObservers(PopulationEvent ev) {     
        for (View<PopulationEvent> v : this.observers) {
            v.refresh(ev);
        }
    }

    public double[] toDoubleArray() {
        int size = this.size();
        double[] array = new double[size];
        int i;
        for(i = 0; i < size; i++) {
            array[i] = this.get(i).evaluate();
        }
        return array;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Being being : lives) {
            str += being + " ";
        }
        return str;
    }
    
    @Override
    public void update(Population pop) {
        this.clear();
        this.addAll(pop);
        this.countSteps++;
        if(this.countSteps == this.getDisplaySteps()) {
            this.notifyObservers(new PopulationEvent(pop, pop.toString()));
            this.countSteps = 0;
        }
    }
    
    @Override
    public void sort() {
        Collections.sort(lives);
    }
    
    @Override
    public Population subPopulation(int length) {
        if (length == 0) {
            return this;
        } else if (length < 0 && length > -this.size()) {
            return this.subPopulation(0,this.size()-length);
        } else if (length > 0) {
            return this.subPopulation(0,length);
        } else {
            return new Population();
        }
    }
    
    @Override
    public Population subPopulation(int start, int end) {
        
        int size = this.size();
        
        if (start < 0 || end < 0 || start >= end || start >= size ||end >= size) {
            return new Population();
        }
        
        Population p = new Population();
        Iterator<Being> i = this.iterator();
        
        int leftoffset = start;
        for (int j = 0; j < leftoffset; j++) {
            i.next();
        }
        
        int length = end-start;
        while (length > 0 && i.hasNext()) {
            p.add(i.next());
            length--;
        }
        
        return p;
    }
    
    @Override
    public Object clone() {
        Population p = new Population();
        for (Being b : this) {
            p.add(b);
        }        
        return p;
    }
    
}
