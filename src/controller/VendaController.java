/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Cliente;
import util.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import beans.Parcela;
import beans.Venda;
import util.ConfigurationFactory;
import util.Datas;

/**
 *
 * @author Nasser
 */
public class VendaController implements IDao {

    private EntityManager entity;

    public VendaController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object venda) throws SQLException {
        if (venda instanceof Venda) {
            Venda v = (Venda) venda;
            List<Parcela> parcelas = new ArrayList<>();
            parcelas.addAll(v.getParcelaList());
            v.getParcelaList().clear();
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.persist(v);
            entity.getTransaction().commit();

            Parcela p = new Parcela();
            String msg = new String();
            for (int i = 0; i < parcelas.size(); i++) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                p = parcelas.get(i);
                p.setIdvenda(v);
               // msg = msg + p.getNrparcela().toString() + "ª parcela: " + p.getValorparcela().toString() + " - " + Datas.getDate(p.getVencimento()) + "\n";
                entity.persist(p);
                entity.getTransaction().commit();
            }
            //JOptionPane.showMessageDialog(null, "Venda gravada com sucesso.\n " + msg);
            ConfigurationFactory.getLOG().info("Venda cadastrada:" + v.getValor().toString() + "-Cliente: " + v.getIdcliente().getIdcliente() + "-" + v.getIdcliente().getNome());

            entity.getEntityManagerFactory().getCache().evictAll();
            entity.clear();
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Object venda, boolean mensagem) throws SQLException {
        if (venda instanceof Venda) {
            Venda v = (Venda) venda;
            if (v.verificaParcelas()) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.merge(v);
                entity.getTransaction().commit();
                if (mensagem) {
                    JOptionPane.showMessageDialog(null, "Venda gravada com sucesso.");
                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Soma das parcelas é diferente do total da venda.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean excluir(Object venda) throws SQLException {
        if (venda instanceof Venda) {
            Venda v = (Venda) venda;
            if (v.getParcelaList().isEmpty()) {
                if (!entity.getTransaction().isActive()) {
                    entity.getTransaction().begin();
                }
                entity.remove(v);
                entity.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Venda excluida com sucesso.");
                ConfigurationFactory.getLOG().warn("Excluida venda id: " + v.getIdvenda() + "- Cliente: " + v.getIdcliente().getNome() +" no valor de: " + v.getValor().toString() + " realizada no dia : " + v.getsData());
                return true;
            } else {
                if (!v.existeParcelaPaga()) {
                    if (!entity.getTransaction().isActive()) {
                        entity.getTransaction().begin();
                    }
                    entity.remove(v);
                    entity.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Venda excluida com sucesso.");
                    ConfigurationFactory.getLOG().warn("Excluida venda id: " + v.getIdvenda() + "- Cliente: " + v.getIdcliente().getNome() +" no valor de: " + v.getValor().toString() + " realizada no dia : " + v.getsData());
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir a venda. Já existem parcela(s) paga(s)");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public Venda pesquisarPorId(Integer id) throws SQLException {
        entity.getEntityManagerFactory().getCache().evictAll();
        entity.clear();
        Venda ven = new Venda();
        Integer idVenda = id;
        Query query = entity.createNamedQuery("Venda.findByIdvenda");
        query.setParameter("idvenda", idVenda);
        if (!query.getResultList().isEmpty()) {
            ven = (Venda) query.getResultList().get(0);
            entity.getTransaction().begin();
            entity.refresh(ven);

            entity.getTransaction().commit();
            return ven;
        }
        return null;
    }

    public List<Venda> pesquisarPorIdCliente(Cliente id) throws SQLException {
        entity.getEntityManagerFactory().getCache().evictAll();
        entity.clear();
        List<Venda> vendaList = new ArrayList();
        Cliente idCliente = id;
        Query query = entity.createNamedQuery("Venda.findByIdcliente");
        query.setParameter("idcliente", idCliente);
        if (!query.getResultList().isEmpty()) {
            vendaList = query.getResultList();
            return vendaList;
        }
        return null;
    }

    @Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        List<Venda> vendaList = new ArrayList();
        Query query = entity.createNamedQuery("Venda.findAll");
        if (!query.getResultList().isEmpty()) {
            vendaList = query.getResultList();
            return vendaList;
        }
        return null;

    }

    @Override
    public List<? extends Object> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
