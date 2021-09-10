/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import beans.Cliente;
import beans.Empresa;
import util.ConfigurationFactory;

/**
 *
 * @author Nasser
 */
public class EmpresaController implements IDao {

    private EntityManager entity;

    public EmpresaController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object empresa) throws SQLException {
        if (empresa instanceof Empresa) {
            Empresa e = (Empresa) empresa;
            if (e.getCnpj() == "") {
                JOptionPane.showMessageDialog(null, "Preencha campo CNPJ");
            } else {
                if (ehValido(e)) {
                    
                        if (!entity.getTransaction().isActive()) {
                            entity.getTransaction().begin();
                        }
                        entity.persist(e);
                        entity.getTransaction().commit();
                    
                    JOptionPane.showMessageDialog(null, "Empresa salvo com sucesso.");
                    ConfigurationFactory.getLOG().info("Gravou: " + e.getIdEmpresa()+ ":" + e.getFantasia());
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean alterar(Object empresa, boolean mensagem) throws SQLException {
        if (empresa instanceof Empresa) {
            Empresa e = (Empresa) empresa;
            if (ehValido(e)) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(e);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Empresa salvo com sucesso.");
                    ConfigurationFactory.getLOG().info("Alterado: " + e.getIdEmpresa()+ ":" + e.getFantasia());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object cliente) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente cli = (Cliente) cliente;
            if (cli.getVendaList().isEmpty()) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.refresh(cliente);
                entity.remove(cliente);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
                ConfigurationFactory.getLOG().info("Excluido: " + cli.getIdcliente() + ":" + cli.getNome());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não pode ser excluído. \n Existem vendas cadastradas para este cliente!");
                ConfigurationFactory.getLOG().warn("Tentativa de exclusao do cliente: " + cli.getIdcliente() + ":" + cli.getNome() + "-Cliente possui vendas cadastradas");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Empresa pesquisarPorId(Integer id) throws SQLException {
        entity.getEntityManagerFactory().getCache().evictAll();
        entity.clear();
        Empresa emp = new Empresa();
        Integer idEmpresa = id;
        Query query = entity.createNamedQuery("Empresa.findAll");
        query.setParameter("idEmpresa", idEmpresa);
        if (!query.getResultList().isEmpty()) {
            emp = (Empresa) query.getResultList().get(0);
            entity.getTransaction().begin();
            entity.refresh(emp);

            entity.getTransaction().commit();
            return emp;
        }
        JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a empresa \n Código " + id, "Atenção!", 2);
        return null;
    }

    @Override
    public List<Empresa> pesquisarTodos() throws SQLException {
        List<Empresa> empresaList = new ArrayList();
        Query query = entity.createNamedQuery("Empresa.findAll");
        if (!query.getResultList().isEmpty()) {
            empresaList = query.getResultList();
            return empresaList;
        }
        return null;

    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    private boolean ehValido(Empresa empresa) {
        boolean validado = true;
        if (empresa.getFantasia()== null || empresa.getFantasia() == "") {
            JOptionPane.showMessageDialog(null, "Campo Fantasia vazio");
            return false;
        }
        return true;
    }

    
}
