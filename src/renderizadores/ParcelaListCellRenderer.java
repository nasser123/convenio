/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderizadores;

/**
 *
 * @author nasser
 */
import beans.Convenio;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ParcelaListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Convenio) {
            Convenio c = (Convenio) value;
            setText(c.getNome());
        }
        return this;
    }
}
