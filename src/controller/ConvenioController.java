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
import beans.Convenio;
import util.ConfigurationFactory;

/**
 *
 * @author Nasser
 */
public class ConvenioController implements IDao {

    private EntityManager entity;

    public ConvenioController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object convenio) throws SQLException {
        if (convenio instanceof Convenio) {
            Convenio c = (Convenio) convenio;
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.persist(c);
            entity.getTransaction().commit();
            ConfigurationFactory.getLOG().info("Gravou: " + c.getIdconvenio() + ":" + c.getNome());
            
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Object convenio, boolean mensagem) throws SQLException {
        if (convenio instanceof Convenio) {
            Convenio c = (Convenio) convenio;

            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.merge(c);
            entity.getTransaction().commit();
            if (mensagem) {
                JOptionPane.showMessageDialog(null, "Convênio alterado com sucesso.");
                ConfigurationFactory.getLOG().info("Alterou: " + c.getIdconvenio() + ":" + c.getNome());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean excluir(Object convenio) throws SQLException {
        if (convenio instanceof Convenio) {
            Convenio c = (Convenio) convenio;
            if (c.getClienteList().isEmpty()) {
                if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
                entity.refresh(convenio);
                entity.remove(convenio);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Convênio excluido com sucesso.");
                ConfigurationFactory.getLOG().info("Excluido: " + c.getIdconvenio() + ":" + c.getNome());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir o convênio. \n Existem clientes cadastrados para este convênio!");
                ConfigurationFactory.getLOG().warn("Erro ao excluir: " + c.getIdconvenio() + ":" + c.getNome());
                return false;
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o convênio.");
            return false;
        }
    }

    @Override
    public Convenio pesquisarPorId(Integer id) throws SQLException {
        Convenio con = new Convenio();
        Integer idConvenio = id;
        Query query = entity.createNamedQuery("Convenio.findByIdconvenio");
        query.setParameter("idconvenio", idConvenio);
        if (!query.getResultList().isEmpty()) {
            con = (Convenio) query.getResultList().get(0);
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.refresh(con);

            entity.getTransaction().commit();
            return con;
        }
        return null;
    }

    @Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        List<Convenio> convenioList = new ArrayList();
        Query query = entity.createNamedQuery("Convenio.findAll");
        if (!query.getResultList().isEmpty()) {
            convenioList = query.getResultList();
            return convenioList;
        }
        return null;

    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
