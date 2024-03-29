/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Convenio;
import static convenio.Convenio.EMPRESA;
import javax.swing.JOptionPane;
import relatorios.ExecutaRelatorio;
import util.ConfigTelas;
import util.ConfigurationFactory;
import util.ConnectionFactory;

/**
 *
 * @author Produção
 */
public class TelaRelatorioClientesPorConvenio extends javax.swing.JFrame {

    /**
     * Creates new form TelaPadrao
     */
    public TelaRelatorioClientesPorConvenio() {
        initComponents();
        jRadioButtonPorConvenio.setSelected(true);
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);

//        ConvenioComparator comparator = new ConvenioComparator();
//        java.util.Collections.sort(convenioList, comparator);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        entityManager = ConnectionFactory.getEntityManager();
        convenioQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Convenio c ORDER by c.nome");
        convenioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(convenioQuery.getResultList());
        convenioListCellRenderer1 = new renderizadores.ParcelaListCellRenderer();
        jPanel1 = new javax.swing.JPanel();
        jButtonVolta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonRelatorio = new javax.swing.JButton();
        jComboBoxConvenios = new javax.swing.JComboBox();
        jRadioButtonCompleto = new javax.swing.JRadioButton();
        jRadioButtonPorConvenio = new javax.swing.JRadioButton();
        jLabelTituloSelecao = new javax.swing.JLabel();

        convenioListCellRenderer1.setText("convenioListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVolta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/8416_32x32.png"))); // NOI18N
        jButtonVolta.setText("Voltar");
        jButtonVolta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVolta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Clientes");

        jButtonRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/phone_book.png"))); // NOI18N
        jButtonRelatorio.setText("Relatório");
        jButtonRelatorio.setToolTipText("");
        jButtonRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioActionPerformed(evt);
            }
        });

        jComboBoxConvenios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxConvenios.setRenderer(convenioListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, convenioList, jComboBoxConvenios);
        bindingGroup.addBinding(jComboBoxBinding);

        jRadioButtonCompleto.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonCompleto);
        jRadioButtonCompleto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonCompleto.setText("Completo(Todos os convênios)");
        jRadioButtonCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCompletoActionPerformed(evt);
            }
        });

        jRadioButtonPorConvenio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonPorConvenio);
        jRadioButtonPorConvenio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonPorConvenio.setText("Por convênio");
        jRadioButtonPorConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPorConvenioActionPerformed(evt);
            }
        });

        jLabelTituloSelecao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTituloSelecao.setText("Selecione o convênio abaixo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCompleto)
                    .addComponent(jRadioButtonPorConvenio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTituloSelecao)
                    .addComponent(jComboBoxConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPorConvenio)
                    .addComponent(jLabelTituloSelecao))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCompleto)
                    .addComponent(jComboBoxConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(725, 403));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCompletoActionPerformed
        organizaTela();
    }//GEN-LAST:event_jRadioButtonCompletoActionPerformed

    private void jButtonVoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVoltaActionPerformed

    private void jRadioButtonPorConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPorConvenioActionPerformed
        organizaTela();
    }//GEN-LAST:event_jRadioButtonPorConvenioActionPerformed

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
       ExecutaRelatorio er = new ExecutaRelatorio();
       //teste
       
       
        if(jRadioButtonPorConvenio.isSelected()){
           Convenio c = (Convenio)jComboBoxConvenios.getSelectedItem();
           er.abrirRelatorioClientesPorConvenio(c.getIdconvenio(), EMPRESA.getIdEmpresa());
       
       }else{
            JOptionPane.showMessageDialog(rootPane, "Não implementado ainda");
        
        }
    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void organizaTela() {
        if (jRadioButtonCompleto.isSelected()) {
            jComboBoxConvenios.setVisible(false);
            jLabelTituloSelecao.setVisible(false);
        } else {
            jComboBoxConvenios.setVisible(true);
            jLabelTituloSelecao.setVisible(true);

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        } catch (InstantiationException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        } catch (IllegalAccessException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaRelatorioClientesPorConvenio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private java.util.List<beans.Convenio> convenioList;
    private renderizadores.ParcelaListCellRenderer convenioListCellRenderer1;
    private javax.persistence.Query convenioQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonVolta;
    private javax.swing.JComboBox jComboBoxConvenios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTituloSelecao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCompleto;
    private javax.swing.JRadioButton jRadioButtonPorConvenio;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
