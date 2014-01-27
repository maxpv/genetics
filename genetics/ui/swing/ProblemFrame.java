 package group2.genetics.ui.swing;

import group2.genetics.events.Observable;
import group2.genetics.events.views.DetachedViewEvent;
import group2.genetics.events.views.ViewEvent;
import group2.genetics.ui.JView;
import group2.genetics.ui.View;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ProblemFrame extends JFrame implements Observable<ViewEvent, View<ViewEvent> >, WindowListener {
    
    private JView jview;
    private List<View<ViewEvent>> obs;
    
    private ProblemFrame(String title, JView jview) {
        this.obs = new ArrayList<>();
        this.jview = jview;
        this.setLayout(new BorderLayout());
        this.add(jview.toJComponent(), BorderLayout.CENTER);
        this.addWindowListener(this);
        this.setBounds(500, 0, 500, 500);
        this.setTitle(title);
    }
    
    public JView getJView() {
        return this.jview;
    }

    public static ProblemFrame showDialog(String title, JView jview) {
        ProblemFrame problemFrame = new ProblemFrame(title, jview);
        problemFrame.setSize(800, 600);
        problemFrame.setVisible(true);
        return problemFrame;
    }
    
    
    @Override
    public void addObserver(View<ViewEvent> obs) {
        this.obs.add(obs);
    }

    @Override
    public void removeObserver(View<ViewEvent> obs) {
        this.obs.remove(obs);
    }

    @Override
    public void notifyObservers(ViewEvent ev) {
        for (View<ViewEvent> v : obs) {
            v.refresh(ev);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Class view = this.getJView().getClass();
        this.notifyObservers(new DetachedViewEvent(view));
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
