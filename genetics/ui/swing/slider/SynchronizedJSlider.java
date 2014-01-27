package group2.genetics.ui.swing.slider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost <maxence.prevost@isen-lille.fr>
 */
public class SynchronizedJSlider extends JSlider implements ActionListener {

    public SynchronizedJSlider(int min, int max, int value) {
        super(min, max, value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField field = (JTextField)e.getSource();
        int value = this.getValue();
        //Judging from the JTextField implementation, e.getActionCommand() is right too
        try {
            value = Integer.valueOf(field.getText());
        } catch (Exception ex) {
        }
        
        if (value >= this.getMinimum() &&
            value <= this.getMaximum() &&
            value != this.getValue()) {
            this.setValue(value);
        }
    }
    
}
