package group2.genetics.ui;

import group2.genetics.engine.GeneticEngine;
import group2.genetics.problem.Problem;
import group2.genetics.ui.swing.ControlsFrame;
import group2.genetics.ui.swing.ProblemFrame;
import java.lang.reflect.Method;

public class GeneticUI {
    
    private static ControlsFrame CONTROLS_INSTANCE;
    private static ProblemFrame PROBLEM_INSTANCE;
    
    public enum Components {

        CONTROLS(ControlsFrame.class, "Genetic Engine Controls"),
        PROBLEM(ProblemFrame.class, "Problem View");
        Class c;
        String t;

        Components(Class c, String t) {
            this.c = c;
            this.t = t;
        }

        Class getComponentClass() {
            return this.c;
        }
        
        String getTitle() {
            return this.t;
        }
    }

    public static void CREATEUI(GeneticEngine e, Problem p, Components... components) {
        for (Components c : components) {
            try {
                if (c == Components.CONTROLS) {
                    Method declaredMethod = c.getComponentClass().getDeclaredMethod("showDialog", String.class);
                    CONTROLS_INSTANCE = (ControlsFrame) declaredMethod.invoke(null, c.getTitle());
                } else if (c == Components.PROBLEM) {
                    Class view = (p.getViews().length > 0) ? p.getViews()[0] : null;
                    JView v = (JView) view.newInstance();
                    e.attachPopulationView(v);
                    
                    Method declaredMethod = c.getComponentClass().getDeclaredMethod("showDialog", String.class, JView.class);
                    PROBLEM_INSTANCE = (ProblemFrame) declaredMethod.invoke(null, c.getTitle(), v);
                    
                    if (CONTROLS_INSTANCE != null) {
                        CONTROLS_INSTANCE.getViewsMenu().registerProblemFrame(PROBLEM_INSTANCE);
                    }
                }
            } catch (Exception ex) {
            }
        }
    }
}
