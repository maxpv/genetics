package group2.genetics.ui.swing.slider;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost <maxence.prevost@isen-lille.fr>
 */
public class SynchronizedJTextField extends JTextField implements ChangeListener {

    public SynchronizedJTextField(String value) {
        super(value);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        this.setText(String.valueOf(slider.getValue()));
    }
    
}
