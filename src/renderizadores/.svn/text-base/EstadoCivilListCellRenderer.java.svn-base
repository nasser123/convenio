/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderizadores;

/**
 *
 * @author nasser
 */
import beans.Estadocivil;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class EstadoCivilListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Estadocivil) {
            Estadocivil e = (Estadocivil) value;
            setText(e.getDescricao());
        }
        return this;
    }
}
