package group2.genetics.miscellaneous;

public class SimpleClass {

    private Class c;
    
    public SimpleClass(Class c) {
        this.c = c;
    }
    
    public Class toClass() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return c.getSimpleName();
    }
    
}
