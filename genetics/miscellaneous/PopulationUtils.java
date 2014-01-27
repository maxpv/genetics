package group2.genetics.miscellaneous;

import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import java.util.Iterator;

public class PopulationUtils {
    
    public static String debug(Population p) {
        return p.toString()+ System.lineSeparator() +"Moyenne="+getAverage(p)+", Ecart-type="+getStandartDeviation(p)+", (min,max)=("+getMin(p)+", "+getMax(p)+")";
    }
    
    public static double getAverage(Population p) {
        return getSum(p)/p.size();
    }
    
    public static double getSum(Population p) {
        Iterator<Being> ite = p.iterator();
        double current = 0;
        while(ite.hasNext()) {
            current += ite.next().evaluate();
        }
        return current;
    }
    
    public static double getStandartDeviation(Population p) {
        Iterator<Being> ite = p.iterator();
        double average = getAverage(p);
        double current = 0;
        while(ite.hasNext()) {
            current += Math.pow(ite.next().evaluate() - average , 2);
        }
        return current/p.size();
    }
    
    public static double getMin(Population p) {
        return extremum(p,true);
    }
    
    public static double getMax(Population p) {
        return extremum(p,false);
    }
    
    private static double extremum(Population p, boolean minMax) {
        int factor = 1;
        if(!minMax) {
            factor = -1;
        }
        
        Iterator<Being> ite = p.iterator();
        double extrem = 0, current = 0;
        
        while(ite.hasNext()) {
            current = ite.next().evaluate();    
            if(current < factor*extrem) {
                extrem = current;
            }
        }
        return extrem;
    }
    
}
