/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Cliente;
import beans.Convenio;
import static convenio.Convenio.EMPRESA;
import java.util.Date;
import relatorios.ExecutaRelatorio;
import util.ConfigTelas;
import util.ConfigurationFactory;
import util.ConnectionFactory;
import util.Datas;

/**
 *
 * @author Produção
 */
public class TelaRelatorioComprovantePagamento extends javax.swing.JFrame {

    /**
     * Creates new form TelaPadrao
     */
    Cliente c;

    public TelaRelatorioComprovantePagamento(Cliente cliente) {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        this.c = new Cliente();
        this.c = cliente;
        
        jDateChooser1.setDate(Datas.getCurrentTime());
        jRadioButtonCliente.setSelected(true);
        jButtonRelatorio.setEnabled(true);
        preencheTela();
        this.jTextFieldClienteNome.setText(this.c.getNome());
        
        

    }

    public TelaRelatorioComprovantePagamento() {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        
        jDateChooser1.setDate(Datas.getCurrentTime());
        jRadioButtonConvenio.setSelected(true);
        preencheTela();
        jButtonRelatorio.setEnabled(true);

    }

    public void preencheTela() {
        if (jRadioButtonConvenio.isSelected()) {
            jComboBoxConvenio.setVisible(true);
            jButtonPesquisar.setVisible(false);
            jLabel3.setVisible(false);
            jTextFieldClienteNome.setVisible(false);
            jButtonRelatorio.setEnabled(true);
        } else {
            if(this.c != null){
                jButtonRelatorio.setEnabled(true);
            }else{
                jButtonRelatorio.setEnabled(false);
            }
            jComboBoxConvenio.setVisible(false);
            jButtonPesquisar.setVisible(true);
            jLabel3.setVisible(true);
            jTextFieldClienteNome.setVisible(true);
        }
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

        convenioPUEntityManager = ConnectionFactory.getEntityManager();
        convenioQuery = java.beans.Beans.isDesignTime() ? null : convenioPUEntityManager.createQuery("SELECT c FROM Convenio c ORDER BY c.nome");
        convenioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : convenioQuery.getResultList();
        convenioListCellRenderer1 = new renderizadores.ConvenioListCellRenderer();
        convenioQuery1 = java.beans.Beans.isDesignTime() ? null : convenioPUEntityManager.createQuery("SELECT c FROM Convenio c");
        convenioList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : convenioQuery1.getResultList();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonRelatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxConvenio = new javax.swing.JComboBox<>();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldClienteNome = new javax.swing.JTextField();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jRadioButtonConvenio = new javax.swing.JRadioButton();

        convenioListCellRenderer1.setText("convenioListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVoltar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/8416_32x32.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comprovante de Pagamento");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Data Pagamento");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Convênio:");

        jComboBoxConvenio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxConvenio.setRenderer(convenioListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, convenioList1, jComboBoxConvenio);
        bindingGroup.addBinding(jComboBoxBinding);

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/16x16/1408_16x16.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        jTextFieldClienteNome.setEditable(false);
        jTextFieldClienteNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonGroup2.add(jRadioButtonCliente);
        jRadioButtonCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonCliente.setText("Cliente");
        jRadioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonClienteActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonConvenio);
        jRadioButtonConvenio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonConvenio.setSelected(true);
        jRadioButtonConvenio.setText("Convênio");
        jRadioButtonConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConvenioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxConvenio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jRadioButtonConvenio)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonCliente)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCliente)
                    .addComponent(jRadioButtonConvenio))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setSize(new java.awt.Dimension(530, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
        ExecutaRelatorio er = new ExecutaRelatorio();

        if (jRadioButtonCliente.isSelected() && (this.c != null)) {
            
            Date data = jDateChooser1.getDate();
            Object datapgto = data;
            er.abrirRelatorioParcelasClienteComprovante(datapgto, this.c.getIdcliente(), EMPRESA.getIdEmpresa());
            


        } else {
            Convenio convenio = new Convenio();
            convenio = (Convenio)jComboBoxConvenio.getSelectedItem();
            Date data = jDateChooser1.getDate();
            Object datapgto = data;
            er.abrirRelatorioParcelasConvenioComprovante(datapgto, convenio.getIdconvenio(), EMPRESA.getIdEmpresa());

        }

    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        TelaPesquisaCliente tpc = new TelaPesquisaCliente("TelaRelatorioComprovantePagamento");
        tpc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jRadioButtonConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConvenioActionPerformed

        preencheTela();

    }//GEN-LAST:event_jRadioButtonConvenioActionPerformed

    private void jRadioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonClienteActionPerformed
        preencheTela();
    }//GEN-LAST:event_jRadioButtonClienteActionPerformed

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
                //new TelaRelatorioVendasCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private java.util.List<beans.Convenio> convenioList;
    private java.util.List<beans.Convenio> convenioList1;
    private renderizadores.ConvenioListCellRenderer convenioListCellRenderer1;
    private javax.persistence.EntityManager convenioPUEntityManager;
    private javax.persistence.Query convenioQuery;
    private javax.persistence.Query convenioQuery1;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxConvenio;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JRadioButton jRadioButtonConvenio;
    private javax.swing.JTextField jTextFieldClienteNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
