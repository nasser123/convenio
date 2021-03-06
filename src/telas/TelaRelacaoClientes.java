/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Cliente;
import controller.ClienteController;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import util.ConfigurationFactory;
import util.ConnectionFactory;

/**
 *
 * @author Produção
 */
public class TelaRelacaoClientes extends javax.swing.JFrame {

    /**
     * Creates new form TelaPadrao
     */
    public TelaRelacaoClientes() {
        initComponents();
        entityManager.getEntityManagerFactory().getCache().evictAll();
        entityManager.clear();

//         ConvenioComparator comparator = new ConvenioComparator();
//        java.util.Collections.sort(convenioList, comparator);
        jComboBoxSelecionado.setVisible(false);
        BufferedImage ico = null;
        try {
            ico = ImageIO.read(this.getClass().getResource("/imagens/vendas64.png"));
            this.setIconImage(ico);
        } catch (IllegalArgumentException iae) {
            System.out.println("Erro ao carregar icone!");
        } catch (java.lang.NullPointerException npe) {
            System.out.println("Erro ao carregar icone!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar icone!");
        }

//        if (!Beans.isDesignTime()) {
//            if (!convenioPUEntityManager.getTransaction().isActive()) {
//                convenioPUEntityManager.getTransaction().begin();
//            }
//        }
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

        convenioListCellRenderer1 = new renderizadores.ConvenioListCellRenderer();
        entityManager = ConnectionFactory.getEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(clienteQuery.getResultList()));
        jPanel1 = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jComboBoxSelecionado = new javax.swing.JComboBox();
        jTextFieldFiltro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonNovaVenda = new javax.swing.JButton();
        jButtonListaVenda = new javax.swing.JButton();

        convenioListCellRenderer1.setText("convenioListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVoltar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/8416_32x32.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/edit.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/7687_32x32.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/7143_32x32.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonExcluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relação de Clientes");

        jButtonRelatorio.setBackground(new java.awt.Color(255, 255, 255));
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

        jTableClientes.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList, jTableClientes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idcliente}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpf}"));
        columnBinding.setColumnName("Cpf");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefone}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idsexo.descricao}"));
        columnBinding.setColumnName("Sexo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${limite}"));
        columnBinding.setColumnName("Limite");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idconvenio.nome}"));
        columnBinding.setColumnName("Convênio");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${situacao}"));
        columnBinding.setColumnName("Situação");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);
        jTableClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(65);
            jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTableClientes.getColumnModel().getColumn(4).setMinWidth(80);
            jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTableClientes.getColumnModel().getColumn(6).setMinWidth(200);
            jTableClientes.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList, jComboBoxSelecionado);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement}"), jComboBoxSelecionado, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jTextFieldFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFiltroKeyTyped(evt);
            }
        });

        jLabel3.setText("Cliente");

        jButtonNovaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/add_to_shopping_cart.png"))); // NOI18N
        jButtonNovaVenda.setText("Nova Venda");
        jButtonNovaVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNovaVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonNovaVenda, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendaActionPerformed(evt);
            }
        });

        jButtonListaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/shopping_cart.png"))); // NOI18N
        jButtonListaVenda.setText("Lista");
        jButtonListaVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonListaVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonListaVenda, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonListaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaVendaActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jComboBoxSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonListaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jComboBoxSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonListaVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonRelatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButtonNovaVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(552, 552, 552))))
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

        setSize(new java.awt.Dimension(1040, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        Cliente c = new Cliente();

        Cliente cli = (Cliente) jComboBoxSelecionado.getSelectedItem();
        ClienteController cc = new ClienteController();
        try {
            cli = cc.pesquisarPorId(cli.getIdcliente());
        } catch (SQLException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        }
        TelaCadastroCliente tcc = new TelaCadastroCliente(cli);
        tcc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        Cliente cli = (Cliente) jComboBoxSelecionado.getSelectedItem();
        ClienteController cc = new ClienteController();
        try {
            boolean excluiu = cc.excluir(cli);
            if (excluiu) {
                new TelaRelacaoClientes().setVisible(true);
                this.dispose();
            }

        } catch (SQLException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        new TelaCadastroCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextFieldFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltroKeyTyped
        if (jTextFieldFiltro.getText() != null) {
            String filtro = jTextFieldFiltro.getText();
            ClienteController cc = new ClienteController();
            clienteList.clear();
            List<Cliente> teste = cc.filtroCliente(filtro);
            clienteList.addAll(teste);
        }

    }//GEN-LAST:event_jTextFieldFiltroKeyTyped

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        if (evt.getClickCount() > 1) {
            Cliente cli = (Cliente) jComboBoxSelecionado.getSelectedItem();
            ClienteController cc = new ClienteController();
            try {
                cli = cc.pesquisarPorId(cli.getIdcliente());
            } catch (SQLException ex) {
                ConfigurationFactory.getLOG().warn(ex.getMessage());
            }
            TelaCadastroCliente tcc = new TelaCadastroCliente(cli);
            tcc.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
        new TelaRelatorioClientesPorConvenio().setVisible(true);
    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void jButtonNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVendaActionPerformed
        Cliente cli = new Cliente();
        if (jComboBoxSelecionado.getSelectedIndex() != -1) {
            cli = (Cliente) jComboBoxSelecionado.getSelectedItem();
            new TelaCadastroVenda(cli).setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jButtonNovaVendaActionPerformed

    private void jButtonListaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaVendaActionPerformed
        Cliente cli = new Cliente();
        if (jComboBoxSelecionado.getSelectedIndex() != -1) {
            cli = (Cliente) jComboBoxSelecionado.getSelectedItem();
            new TelaVendaCliente(cli).setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jButtonListaVendaActionPerformed

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
//                new TelaListaClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<beans.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private renderizadores.ConvenioListCellRenderer convenioListCellRenderer1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonListaVenda;
    private javax.swing.JButton jButtonNovaVenda;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxSelecionado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldFiltro;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
