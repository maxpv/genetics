package group2.genetics.ui.swing;

import group2.genetics.miscellaneous.SimpleClass;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class JList extends JComboBox<SimpleClass> {

    public JList() {
    }

    public JList(Class[] classes) {
        this.setModel(classes);
    }

    public void setModel(Class[] classes) {
        int size = classes.length;
        SimpleClass[] array = new SimpleClass[size];
        for (int i = 0; i < size; i++) {
            array[i] = new SimpleClass(classes[i]);
        }
        this.setModel(new DefaultComboBoxModel(array));
    }
    
    public SimpleClass getSelectedSimpleClass() {
        return (SimpleClass) this.getSelectedItem();
    }
   
}
