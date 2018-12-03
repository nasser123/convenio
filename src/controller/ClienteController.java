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
import util.ConfigurationFactory;

/**
 *
 * @author Nasser
 */
public class ClienteController implements IDao {

    private EntityManager entity;

    public ClienteController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object cliente) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;
            if (ehValido(c)) {
                if (!existeCliente(c)) {
                    if (!entity.getTransaction().isActive()) {
                        entity.getTransaction().begin();
                    }
                    entity.persist(c);
                    entity.getTransaction().commit();
                } else {
                    JOptionPane.showMessageDialog(null, "Já existe cliente com esse nome/CPF/CNPJ.");
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.");
                ConfigurationFactory.getLOG().info("Gravou: " + c.getIdcliente() + ":" + c.getNome());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Object cliente, boolean mensagem) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;
            if (ehValido(c)) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(c);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.");
                    ConfigurationFactory.getLOG().info("Alterado: " + c.getIdcliente() + ":" + c.getNome());
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
    public Cliente pesquisarPorId(Integer id) throws SQLException {
        entity.getEntityManagerFactory().getCache().evictAll();
        entity.clear();
        Cliente cli = new Cliente();
        Integer idCliente = id;
        Query query = entity.createNamedQuery("Cliente.findByIdcliente");
        query.setParameter("idcliente", idCliente);
        if (!query.getResultList().isEmpty()) {
            cli = (Cliente) query.getResultList().get(0);
            entity.getTransaction().begin();
            entity.refresh(cli);

            entity.getTransaction().commit();
            return cli;
        }
        JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o cliente \n Código " + id, "Atenção!", 2);
        return null;
    }

    @Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        List<Cliente> clienteList = new ArrayList();
        Query query = entity.createNamedQuery("Cliente.findAll");
        if (!query.getResultList().isEmpty()) {
            clienteList = query.getResultList();
            return clienteList;
        }
        return null;

    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> filtroCliente(String filtro) {
        List<Cliente> clienteList = new ArrayList();
        Query query = entity.createNativeQuery("Select * from cliente where nome like '%" + filtro + "%'", Cliente.class);
        clienteList = query.getResultList();
        return clienteList;

    }

    private boolean ehValido(Cliente cliente) {
        boolean validado = true;
        if (cliente.getNome() == null || cliente.getNome() == "") {
            JOptionPane.showMessageDialog(null, "Campo Nome vazio");
            return false;
        }
        return true;
    }

    private boolean existeCliente(Cliente cliente) {
        List<Cliente> clienteList = new ArrayList();
        Query query = entity.createNamedQuery("Cliente.findByNome");
        query.setParameter("nome", cliente.getNome().toUpperCase());
        if (!query.getResultList().isEmpty()) {
            if (query.getResultList().size() == 1) {
                Cliente c = (Cliente) query.getSingleResult();
                if (c.getNome().toUpperCase().equals(cliente.getNome().toUpperCase())) {
                    return true;
                }
            }
        }

        query = entity.createNamedQuery("Cliente.findByCpf");
        query.setParameter("cpf", cliente.getCpf());
        if (!query.getResultList().isEmpty()) {
            if (query.getResultList().size() == 1) {
                Cliente c = (Cliente) query.getSingleResult();
                if (c.getCpf().equals(cliente.getCpf())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;

    }

}
