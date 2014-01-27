/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group2.genetics.ui.swing.viewsmenu;

import group2.genetics.events.views.ViewEvent;
import group2.genetics.miscellaneous.SimpleClass;
import group2.genetics.ui.JView;
import group2.genetics.ui.View;
import group2.genetics.ui.swing.ProblemFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Samaël
 */
public class ViewsMenuItem extends JMenuItem implements ActionListener, View<ViewEvent> {
    
    private boolean active = false;
    private SimpleClass sc;
    
    public ViewsMenuItem(SimpleClass sc) {
        this.sc = sc;
        this.setText(sc.toString());
        this.addActionListener(this);
    }
    
    @Override
    public void refresh(ViewEvent ev) {
        if (ev.getType() == ViewEvent.Type.DETACHED && ev.getView() == this.sc.toClass()) {
            this.active = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.active) {
            try {
                this.active = false;
                Class view = sc.toClass();
                JView v = (JView) view.newInstance();
                ProblemFrame.showDialog("Problem View", v).addObserver(this);
            } catch (Exception ex) {
            }
        }
    }
}
