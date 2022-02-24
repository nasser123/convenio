package renderizadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nasser
 */
public class VencidoTableCellRenderer extends DefaultTableCellRenderer {

    /**
     *
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        System.out.println("vencido_table_cell");
        setHorizontalAlignment(CENTER);
        String texto = this.getText();
        if (table.getColumnName(column).equals("Local")){
            c.setBackground(getCorLocal(row, isSelected, texto));
        }
        if (table.getColumnName(column).equals("Situação")){
            c.setBackground(getCor(row, isSelected, texto));
        }
        
        //c.setBackground(getCor(row, isSelected, texto));

        return c;
    }
    
    private Color getCor (int linha, boolean selecionada, String value){
        if(selecionada){
            return Color.CYAN;
        }
        if (value.equals("Aguardando Cliente")){
            return Color.YELLOW;
        }
        if (value.equals("Aberta")){
            return Color.RED;
        }
        if (value.equals("Fechada")){
            return Color.GRAY;
        }
        if (value.equals("Entregue")){
            return Color.WHITE;
        }
        if(value.equals("Pendente")){
            return Color.ORANGE;
        }
        if(value.equals("Cancelada")){
            return Color.PINK;
        }
       
        return Color.GREEN;
    }
    
    private Color getCorLocal(int linha, boolean selecionada, String value){
        if(selecionada){
            return Color.CYAN;
        }
        if (value.equals("Externo")){
            return Color.YELLOW;
        }
        if (value.equals("Contrato-Rotineira")){
            return Color.GREEN;
        }
        if (value.equals("Contrato-Corretiva")){
            return Color.RED;
        }
        if (value.equals("Terceirizada")){
            return Color.LIGHT_GRAY;
        }
        return Color.WHITE;
    
    }

}
