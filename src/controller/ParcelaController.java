/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Convenio;
import util.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import beans.Parcela;
import beans.Venda;
import java.util.Date;
import javax.swing.JOptionPane;
import util.ConfigurationFactory;

/**
 *
 * @author Nasser
 */
public class ParcelaController {

    private EntityManager entity;

    public ParcelaController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

//    public boolean inserir(Object venda) throws SQLException {
//        if (venda instanceof Venda) {
//            Venda v = (Venda) venda;
//            List<Parcela> parcelas = new ArrayList<>();
//            parcelas.addAll(v.getParcelaList());
//            v.getParcelaList().clear();
//            if (!entity.getTransaction().isActive()) {
//                entity.getTransaction().begin();
//            }
//            entity.persist(v);
//            entity.getTransaction().commit();
//
//            Parcela p = new Parcela();
//
//            for (int i = 0; i < parcelas.size(); i++) {
//                if (!entity.getTransaction().isActive()) {
//                    entity.getTransaction().begin();
//                }
//                p = parcelas.get(i);
//                p.setIdvenda(v);
//                entity.persist(p);
//                entity.getTransaction().commit();
//            }
//
//            return true;
//        }
//        return false;
//    }
    public boolean alterar(Object parcela, boolean mensagem) throws SQLException {
        if (parcela instanceof Parcela) {
            Parcela p = (Parcela) parcela;

            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.merge(p);
            entity.getTransaction().commit();
            if (mensagem) {
                JOptionPane.showMessageDialog(null, "Venda gravada com sucesso.");
                ConfigurationFactory.getLOG().info("Alterada parcela id: " + p.getIdparcela() + 
                        "-" + p.getNrparcela() + 
                        " no valor de: " + p.getValorparcela().toString() + 
                        " para: " + p.isPago() + 
                        " Data:" + p.getDatapgto());
            }
            return true;
        }
        return false;
    }

    public List<Parcela> alterarListaParcelas(List<Parcela> pList, boolean mensagem) throws SQLException {

        List<Parcela> parcelaList = pList;

        for (int i = 0; i < parcelaList.size(); i++) {
            if (!entity.getTransaction().isActive()) {
                entity.getTransaction().begin();
            }
            entity.merge(parcelaList.get(i));
            ConfigurationFactory.getLOG().info(" Alterada parcela id: " + parcelaList.get(i).getIdparcela().toString() +
                    "-" + parcelaList.get(i).getNrparcela() + 
                    " no valor de: " + parcelaList.get(i).getValorparcela().toString() + 
                    " para: " + parcelaList.get(i).isPago() + 
                    "-Cliente:" + parcelaList.get(i).getIdvenda().getIdcliente().getIdcliente() + 
                    " Data:" + parcelaList.get(i).getDatapgto());

            entity.getTransaction().commit();
        }
        if (mensagem) {
            JOptionPane.showMessageDialog(null, "Parcelas gravadas com sucesso.");
        }

        return parcelaList;
    }

//
//    @Override
//    public boolean excluir(Object venda) throws SQLException {
//        if (venda instanceof Venda) {
//            Venda v = (Venda) venda;
//            if (v.getParcelaList().isEmpty()) {
//                if (!entity.getTransaction().isActive()) {
//                entity.getTransaction().begin();
//            }
//                entity.remove(v);
//                entity.getTransaction().commit();
//                JOptionPane.showMessageDialog(null, "Venda excluida com sucesso.");
//                return true;
//            } else {
//                JOptionPane.showMessageDialog(null, "Não foi possivel excluir a venda.");
//            }
//            return false;
//        } else {
//            return false;
//        }
//    }
    //@Override
    public Parcela pesquisarPorId(Integer id) throws SQLException {
        Parcela par = new Parcela();
        Integer idParcela = id;
        Query query = entity.createNamedQuery("Parcela.findByIdparcela");
        query.setParameter("idparcela", idParcela);
        if (!query.getResultList().isEmpty()) {
            par = (Parcela) query.getResultList().get(0);
            entity.getTransaction().begin();
            entity.refresh(par);

            entity.getTransaction().commit();
            return par;
        }
        return null;
    }

    //@Override
    public List<? extends Object> pesquisarTodos() throws SQLException {
        List<Venda> vendaList = new ArrayList();
        Query query = entity.createNamedQuery("Venda.findAll");
        if (!query.getResultList().isEmpty()) {
            vendaList = query.getResultList();
            return vendaList;
        }
        return null;

    }

    public List<Parcela> filtroConvenioCompetencia(Convenio convenio, Date dataIni, Date dataFim, boolean todos) {
        entity.getEntityManagerFactory().getCache().evictAll();
        entity.clear();

        List<Parcela> parcelaList = new ArrayList();
        Convenio con = new Convenio();
        con = convenio;
        Date dataini = dataIni;
        Date datafim = dataFim;
        Query query;
        if (todos) {
            query = entity.createNamedQuery("Parcela.filtroConvenioCompetencia");
            query.setParameter("idconvenio", con);
            query.setParameter("dataini", dataini);
            query.setParameter("datafim", datafim);
        } else {
            query = entity.createNamedQuery("Parcela.filtroConvenioCompetenciaNaoPagos");
            query.setParameter("idconvenio", con);
            query.setParameter("dataini", dataini);
            query.setParameter("datafim", datafim);

        }

        if (!query.getResultList().isEmpty()) {
            parcelaList = query.getResultList();
            return parcelaList;
        }
        return null;
    }


}
