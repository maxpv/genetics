package group2.genetics.samples.tsp;

import group2.genetics.inhabitants.Being;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TSPBeing extends Being implements Iterable<Integer> {

    private static List<TSPCity> cities = null;
    
    private static void initializeCities(int size) {
        cities = new ArrayList<>(size);
        
        Random rand = new Random();
        double x,y;
        
        while (cities.size() < size) {
            x = rand.nextDouble()*200;
            y = rand.nextDouble()*200;
            cities.add(new TSPCity(x,y));
        }
    }
    
    public static TSPCity getCity(int index) {
        return cities.get(index);
    }
    
    List<Integer> citiesid;
    
    public TSPBeing(int size) {
        if (cities == null) {
            initializeCities(size);
        }
        
        this.citiesid = new ArrayList<>(size);
        this.citiesid.add(0);
        
        List<Integer> remaining = new LinkedList<>();
        for (int i = 1; i < size-1; i++) {
            remaining.add(i);
        }
        
        Random rand = new Random();
        int randomint;
        for (int i = 1; i < size-1; i++) {
            randomint = rand.nextInt(size-i-1);
            this.citiesid.add(remaining.get(randomint));
            remaining.remove(randomint);
        }
        
        this.citiesid.add(0);
    }
    
    public TSPBeing(TSPBeing b) {
        this.citiesid = new ArrayList<>();
        for (int integer : b) {
            this.citiesid.add(integer);
        }
    }
    
    @Override
    public double evaluate() {
        double value = 0;
        
        Iterator<Integer> it = this.citiesid.iterator();
        if (this.citiesid.size() > 0) {
            int city = it.next();
            int next = city;
            while (it.hasNext()) {
                next = it.next();
                value += getCity(city).distance(getCity(next));
                city = next;
            }
        }
        
        return 1/value;
    }
    
    @Override
    public Being clone() {
        return new TSPBeing(this);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.citiesid.iterator();
    }
    
    public int size() {
        return this.citiesid.size();
    }
    
    public int get(int index) {
        return this.citiesid.get(index);
    }
    
    public void set(int index, int integer) {
        this.citiesid.set(index, integer);
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int city : this) {
            str += city;
            str += "-";
        }
        str = String.valueOf(str.toCharArray(), 0, str.length()-1);
        str += " soit "+this.evaluate();
        return str;
    }
    
    public boolean contains(int integer) {
        for (Integer city : this) {
            if (city == integer) {
                return true;
            }
        }
        return false;
    }
    
    public int indexOf(int integer) {
        int i = 0;
        for (Integer city : this) {
            if (city == integer) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
