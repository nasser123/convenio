/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderizadores;

/**
 *
 * @author nasser
 */
import beans.Cliente;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ClienteListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Cliente) {
            Cliente c = (Cliente) value;
            setText(c.getNome());
        }
        return this;
    }
}
