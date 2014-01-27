package group2.genetics.ui.swing.slider;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost
 * <maxence.prevost@isen-lille.fr>
 */
public class CustomCompleteSlider extends JComponent implements ChangeListener {

    private JLabel label;
    private SynchronizedJSlider slider;
    private SynchronizedJTextField textfield;
    private Collection<ActionListener> actionListeners;

    public CustomCompleteSlider() {
        this("",0,100,50,5,10);
    }
    
    public CustomCompleteSlider(String label, int min, int max, int defaultval, int mininterspace, int maxinterspace) {
        this.actionListeners = new ArrayList<>();

        this.label = new JLabel(label);

        this.slider = new SynchronizedJSlider(min, max, defaultval);
        this.slider.setMajorTickSpacing(maxinterspace);
        this.slider.setMinorTickSpacing(mininterspace);
        this.slider.setPaintLabels(true);
        this.slider.setPaintTicks(true);

        this.textfield = new SynchronizedJTextField(String.valueOf(defaultval));
        this.textfield.setColumns(5);

        this.slider.addChangeListener(this.textfield);
        this.slider.addChangeListener(this);
        this.textfield.addActionListener(this.slider);

        this.setLayout(new FlowLayout());
        this.add(this.label);
        this.add(this.slider);
        this.add(this.textfield);
    }

    public int getMinimum() {
        return this.slider.getMinimum();
    }

    public int getMaximum() {
        return this.slider.getMaximum();
    }
    
    public int getMajorTickSpacing() {
        return this.slider.getMajorTickSpacing();
    }
    
    public void setMajorTickSpacing(int tick) {
        this.slider.setMajorTickSpacing(tick);
    }
    
    public int getMinorTickSpacing() {
        return this.slider.getMinorTickSpacing();
    }
    
    public void setMinorTickSpacing(int tick) {
        this.slider.setMinorTickSpacing(tick);
    }

    public int getValue() {
        return this.slider.getValue();
    }
    
    public void setPaintLabels(boolean bool) {
        this.slider.setPaintLabels(bool);
    }
    
    public boolean getPaintLabels() {
        return this.slider.getPaintLabels();
    }

    public void setValue(int value) {
        if (value >= this.getMinimum() && value <= this.getMaximum()) {
            this.slider.setValue(value);
            this.textfield.setText(String.valueOf(value));
            this.fireActionPerformed();
        }
    }
    
    public void setMaximum(int value) {
        if (value >= this.getMinimum()) {
            if (this.slider.getValue() < value) {
                this.slider.setValue(value);
            }
            this.slider.setMaximum(value);
        }
    }
    
    public void setMinimum(int value) {
        if (value <= this.getMaximum()) {
            if (this.slider.getValue() > value) {
                this.slider.setValue(value);
            }
            this.slider.setMinimum(value);
        }
    }

    public void addActionListener(ActionListener listener) {
        this.actionListeners.add(listener);
    }

    public void removeActionListener(ActionListener listener) {
        this.actionListeners.remove(listener);
    }

    protected void fireActionPerformed() {
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(this.getValue())));
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        this.setValue(slider.getValue());
    }
}