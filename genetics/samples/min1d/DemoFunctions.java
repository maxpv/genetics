package group2.genetics.samples.min1d;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum DemoFunctions {
    A(4, "x*sin(x)+1"),
    B(8, "x^4 + x^3 - 4*(x-0.5)^2 +5"),
    C(30, "0.5*x^6+x^3"),
    D(2, "cos(x)/x +1");
    
    private int min;
    private int max;
    private Calculable expression;
    private String expression_input;
    
    DemoFunctions(int minMax, String expression) {
        this(minMax, -minMax, expression);
    }
    
    DemoFunctions(int max, int min, String expression) {
        this.min = min;
        this.max = max;
        try {
            this.expression = new ExpressionBuilder(expression).withVariableNames("x").build();
        } catch (UnknownFunctionException ex) {
            Logger.getLogger(DemoFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnparsableExpressionException ex) {
            Logger.getLogger(DemoFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        expression_input = expression;
    }
    
    public double f(double x) {
        try {
            return expression.calculate(x);
        } catch(Exception e) {
            return Integer.MAX_VALUE;
        }
    }
    
    public String getExpression() {
        return expression_input;
    }
    
    public int getMin() {
        return min;
    }
    
    public int getMax() {
        return max;
    }
}
