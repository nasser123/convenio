/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderizadores;

/**
 *
 * @author nasser
 */
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ValorTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        
            DecimalFormat decimalFormat = new DecimalFormat("¤ #,##0.00");
            setHorizontalAlignment(RIGHT);
            try{
            setText(decimalFormat.format(value));
            }catch(java.lang.IllegalArgumentException ie){
                ie.printStackTrace();
            }
        
        return this;
    }
    
}
