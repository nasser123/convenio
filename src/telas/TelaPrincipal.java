/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Empresa;
import static convenio.Convenio.EMPRESA;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import util.ConfigTelas;
import util.ConfigurationFactory;
import util.ConnectionFactory;

/**
 *
 * @author Produção
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        initComponents();
        
        EntityManager entity = ConnectionFactory.getEntityManager();
        
        BufferedImage ico = null;
        try {
            ico = ImageIO.read(this.getClass().getResource("/imagens/vendas64.png"));
            this.setIconImage(ico);
        } catch (IllegalArgumentException iae) {
            ConfigurationFactory.getLOG().warn(iae.getMessage());
            System.out.println("Erro ao carregar icone!");
        } catch (java.lang.NullPointerException npe) {
            ConfigurationFactory.getLOG().warn(npe.getMessage());
            System.out.println("Erro ao carregar icone!");
        } catch (IOException e) {
            ConfigurationFactory.getLOG().warn(e.getMessage());
            System.out.println("Erro ao carregar icone!");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonClientes = new javax.swing.JButton();
        jButtonConvenios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuConvenio = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemVendaCliente = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuItemParcelasConvenio = new javax.swing.JMenuItem();
        jMenuItemVendasPeriodo = new javax.swing.JMenuItem();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuConfiguracao = new javax.swing.JMenu();
        jMenuItemBackup = new javax.swing.JMenuItem();
        jMenuItemConfiguracao = new javax.swing.JMenuItem();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Controle de Convênios");

        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/64x64/user_accept.png"))); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonConvenios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/64x64/phone_book.png"))); // NOI18N
        jButtonConvenios.setText("Convênios");
        jButtonConvenios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConvenios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConvenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConveniosActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/64x64/vendas64.png"))); // NOI18N
        jButton1.setText("Pagamentos");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/64x64/add_to_shopping_cart.png"))); // NOI18N
        jButton2.setText("Vendas");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/32x32/8416_32x32.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConvenios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jMenuCadastros.setText("Cadastros");

        jMenuConvenio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/phone_book_edit.png"))); // NOI18N
        jMenuConvenio.setText("Convenio");
        jMenuConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConvenioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuConvenio);

        jMenuItemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/user_accept.png"))); // NOI18N
        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCliente);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/16x16/7161_16x16.png"))); // NOI18N
        jMenuItem2.setText("Empresa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItem2);

        jMenuBar1.add(jMenuCadastros);

        jMenuVendas.setText("Vendas");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/add_to_shopping_cart.png"))); // NOI18N
        jMenuItem1.setText("Nova Venda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItem1);

        jMenuItemVendaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/shopping_cart_accept.png"))); // NOI18N
        jMenuItemVendaCliente.setText("Venda por Cliente");
        jMenuItemVendaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVendaClienteActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItemVendaCliente);

        jMenuBar1.add(jMenuVendas);

        jMenuRelatorios.setText("Relatórios");
        jMenuRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatoriosActionPerformed(evt);
            }
        });

        jMenuItemParcelasConvenio.setText("Parcelas por Convênio");
        jMenuItemParcelasConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemParcelasConvenioActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemParcelasConvenio);

        jMenuItemVendasPeriodo.setText("Vendas por Período");
        jMenuItemVendasPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVendasPeriodoActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemVendasPeriodo);

        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemClientes);

        jMenuBar1.add(jMenuRelatorios);

        jMenuConfiguracao.setText("Ferramentas");
        jMenuConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConfiguracaoActionPerformed(evt);
            }
        });

        jMenuItemBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/database.png"))); // NOI18N
        jMenuItemBackup.setText("Backup");
        jMenuItemBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBackupActionPerformed(evt);
            }
        });
        jMenuConfiguracao.add(jMenuItemBackup);

        jMenuItemConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/sistema.png"))); // NOI18N
        jMenuItemConfiguracao.setText("Configuração");
        jMenuItemConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfiguracaoActionPerformed(evt);
            }
        });
        jMenuConfiguracao.add(jMenuItemConfiguracao);

        jMenuItemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/24x24/support.png"))); // NOI18N
        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuConfiguracao.add(jMenuItemSobre);

        jMenuBar1.add(jMenuConfiguracao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(617, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        TelaRelacaoClientes tlc = new TelaRelacaoClientes();
        tlc.setVisible(true);
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jMenuRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatoriosActionPerformed


    }//GEN-LAST:event_jMenuRelatoriosActionPerformed

    private void jMenuItemParcelasConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemParcelasConvenioActionPerformed
        TelaRelatorioParcelasConvenio trpc = new TelaRelatorioParcelasConvenio();
        trpc.setVisible(true);

    }//GEN-LAST:event_jMenuItemParcelasConvenioActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        new TelaRelatorioClientesPorConvenio().setVisible(true);

    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemVendasPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVendasPeriodoActionPerformed
        TelaRelatorioVendasPorPeriodo trvp = new TelaRelatorioVendasPorPeriodo();
        trvp.setVisible(true);
    }//GEN-LAST:event_jMenuItemVendasPeriodoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaCadastroVenda tcv = new TelaCadastroVenda();
        tcv.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        TelaCadastroCliente tcc = new TelaCadastroCliente();
        tcc.setVisible(true);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemVendaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVendaClienteActionPerformed
        TelaVendaCliente tvc = new TelaVendaCliente();
        tvc.setVisible(true);

    }//GEN-LAST:event_jMenuItemVendaClienteActionPerformed

    private void jMenuConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConvenioActionPerformed
        new TelaListaConvenio().setVisible(true);
    }//GEN-LAST:event_jMenuConvenioActionPerformed

    private void jButtonConveniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConveniosActionPerformed
        new TelaListaConvenio().setVisible(true);
    }//GEN-LAST:event_jButtonConveniosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPagamentos().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaCadastroVenda().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConfiguracaoActionPerformed

    }//GEN-LAST:event_jMenuConfiguracaoActionPerformed

    private void jMenuItemBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackupActionPerformed
        new TelaBackupJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItemBackupActionPerformed

    private void jMenuItemConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfiguracaoActionPerformed
        new TelaConfiguracaoJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItemConfiguracaoActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        new TelaSobreJDialog(this, true).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja sair do programa?");
        if (sair == 0) {
            int backup = JOptionPane.showConfirmDialog(rootPane, "Você deseja realizar backup?");
            if(backup == 0){
                Connection con = ConnectionFactory.getConnection();
                boolean gravou = ConnectionFactory.geraBackup();
                if(gravou){
                    JOptionPane.showMessageDialog(rootPane, "Arquivo gravado com sucesso");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o arquivo");
                }
            }
            
            System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaCadastroEmpresa tce = new TelaCadastroEmpresa(EMPRESA);
        tce.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonConvenios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuConfiguracao;
    private javax.swing.JMenuItem jMenuConvenio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemBackup;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemConfiguracao;
    private javax.swing.JMenuItem jMenuItemParcelasConvenio;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuItemVendaCliente;
    private javax.swing.JMenuItem jMenuItemVendasPeriodo;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
