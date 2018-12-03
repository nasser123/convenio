/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import util.Datas;
import util.ValidarValores;

/**
 *
 * @author Produção
 */
@Entity
@Table(name = "parcela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcela.findAll", query = "SELECT p FROM Parcela p"),
    @NamedQuery(name = "Parcela.findByIdparcela", query = "SELECT p FROM Parcela p WHERE p.idparcela = :idparcela"),
    @NamedQuery(name = "Parcela.findByIdvenda", query = "SELECT p FROM Parcela p WHERE p.idvenda = :idvenda"),
    @NamedQuery(name = "Parcela.filtroConvenioCompetencia", query = "SELECT p FROM Parcela p WHERE p.idvenda.idcliente.idconvenio = :idconvenio and p.vencimento >= :dataini and p.vencimento < :datafim"),
    @NamedQuery(name = "Parcela.findByDate", query = "SELECT p FROM Parcela p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "Parcela.findByNrparcela", query = "SELECT p FROM Parcela p WHERE p.nrparcela = :nrparcela")})
public class Parcela implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorparcela")
    private Float valorparcela;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparcela")
    private Integer idparcela;
    @Column(name = "nrparcela")
    private Integer nrparcela;
    @JoinColumn(name = "idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda idvenda;

    @Column(name = "pago")
    private boolean pago;

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        boolean oldPago = this.pago;
        this.pago = pago;
        changeSupport.firePropertyChange("pago", oldPago, pago);
    }
    public Parcela() {
    }

    public Parcela(Integer idparcela) {
        this.idparcela = idparcela;
    }

    public Integer getIdparcela() {
        return idparcela;
    }
    
    public List<Parcela> getParcelas(Float valor, Date data, Integer nrparcelas, boolean proximomes, Convenio convenio){
        List<Parcela> listaParcelas = new ArrayList();
        ArrayList<Float> valores = new ArrayList();
        valores = ValidarValores.calculaParcelas(valor, nrparcelas);
        for(int i = 1; i < nrparcelas+1 ; i++ ){
            Parcela p = new Parcela();
            p.setNrparcela(i);
            p.setVencimento(calculaVencimento(data, i, proximomes, convenio));
            p.setValorparcela(valores.get(i-1));
            listaParcelas.add(p);
            
        }
        
        return listaParcelas;
    
    }
    
    private Date calculaVencimento(Date dataVenda, Integer nrParcela, boolean proximomes, Convenio convenio){
        Date data = dataVenda;
        Date dataDesconto = null;
        boolean proxMes = proximomes;
        int nPrestacao = nrParcela;
        Integer nDiaVenda = Datas.getDia(data);
        Integer nMesVenda = Datas.getMes(data);
        Integer nAnoVenda = Datas.getAno(data);
        int nDiaDesconto = convenio.getVencimento();
        int nMesDesconto = 0;
        int nAnoDesconto = nAnoVenda;
        int nProxMes = 0;

        if (proxMes == true) {
            nProxMes = 1;
        }

        if (nDiaVenda <= convenio.getDatalimite()) {
            nMesDesconto = nMesVenda + nPrestacao + nProxMes;
        } else {
            nMesDesconto = nMesVenda + nPrestacao + 1 + nProxMes;
        }

        if (nMesDesconto > 12) {
            nMesDesconto = nMesDesconto - 12;
            nAnoDesconto++;
        }

        String sDataDesconto = nDiaDesconto + "/" + nMesDesconto + "/" + nAnoDesconto;
        //System.out.println(sDataDesconto);
        dataDesconto = Datas.transformaStringDate(sDataDesconto);
        return dataDesconto;
                
    }
    
    
    

    public void setIdparcela(Integer idparcela) {
        Integer oldIdparcela = this.idparcela;
        this.idparcela = idparcela;
        changeSupport.firePropertyChange("idparcela", oldIdparcela, idparcela);
    }

    public Integer getNrparcela() {
        return nrparcela;
    }

    public void setNrparcela(Integer nrparcela) {
        Integer oldNrparcela = this.nrparcela;
        this.nrparcela = nrparcela;
        changeSupport.firePropertyChange("nrparcela", oldNrparcela, nrparcela);
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        Venda oldIdvenda = this.idvenda;
        this.idvenda = idvenda;
        changeSupport.firePropertyChange("idvenda", oldIdvenda, idvenda);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparcela != null ? idparcela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) object;
        if ((this.idparcela == null && other.idparcela != null) || (this.idparcela != null && !this.idparcela.equals(other.idparcela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Parcela[ idparcela=" + idparcela + " ]";
    }

    public Float getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(Float valorparcela) {
        Float oldValorparcela = this.valorparcela;
        this.valorparcela = valorparcela;
        changeSupport.firePropertyChange("valorparcela", oldValorparcela, valorparcela);
    }

    
    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        Date oldVencimento = this.vencimento;
        this.vencimento = vencimento;
        changeSupport.firePropertyChange("vencimento", oldVencimento, vencimento);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
//    public double totalParcelas(List<Parcela> parcelas){
//        double valorParcelas = 0.0;
//        for(int i = 0; i < parcelas.size(); i++){
//            valorParcelas = valorParcelas + parcelas.get(i).getValorparcela();
//        
//        }
//        return valorParcelas;
//    }
    
}
