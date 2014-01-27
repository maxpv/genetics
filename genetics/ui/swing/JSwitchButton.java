package group2.genetics.ui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class JSwitchButton extends JButton {
    
    private boolean bool;
    
    public JSwitchButton() {
        this(false);
    }
    
    public JSwitchButton(boolean bool) {
        this.bool = bool;
        this.setText(this.getStateText());
        
        this.addActionListener(new JSwitchButtonListener(this));
    }
        
    private void switchState() {
        this.bool = !this.bool;
        this.setText(this.getStateText());
    }
    
    private String getStateText() {
        return (this.bool) ? "Off" : "On";
    }
 
    private class JSwitchButtonListener implements ActionListener {

        private JSwitchButton button;
        
        JSwitchButtonListener(JSwitchButton button) {
            this.button = button;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            button.switchState();
        }
        
    }
    
}