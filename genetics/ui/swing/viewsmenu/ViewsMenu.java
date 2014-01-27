package group2.genetics.ui.swing.viewsmenu;

import group2.genetics.engine.Configuration;
import group2.genetics.miscellaneous.SimpleClass;
import group2.genetics.ui.swing.ProblemFrame;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JMenu;

public class ViewsMenu extends JMenu {

    private Map<Class, ViewsMenuItem> map;

    public ViewsMenu() {      
        this.map = new HashMap<>();
        this.setText("Views");
        this.setModel(Configuration.getInstance().getViews());
    }
    
    private void setModel(Class[] classes) {
        SimpleClass sc;
        ViewsMenuItem item;
        for (Class c : classes) {
            sc = new SimpleClass(c);
            item = new ViewsMenuItem(sc);
            map.put(c, item);
            this.add(item);
        }
    }
    
    public void registerProblemFrame(ProblemFrame frame) {
        Class c = frame.getJView().getClass();
        if (map.containsKey(c)) {
            frame.addObserver(map.get(c));
        }
    }
    
}
