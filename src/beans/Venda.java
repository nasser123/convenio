/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Produção
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
    ,
    @NamedQuery(name = "Venda.findByIdvenda", query = "SELECT v FROM Venda v WHERE v.idvenda = :idvenda")
    ,
    @NamedQuery(name = "Venda.findByData", query = "SELECT v FROM Venda v WHERE v.data = :data")
    ,
    @NamedQuery(name = "Venda.findByNrparcelas", query = "SELECT v FROM Venda v WHERE v.nrparcelas = :nrparcelas")
    ,
    @NamedQuery(name = "Venda.findByNotafiscal", query = "SELECT v FROM Venda v WHERE v.notafiscal = :notafiscal")
    ,
    @NamedQuery(name = "Venda.findByIdcliente", query = "SELECT v FROM Venda v WHERE v.idcliente = :idcliente")
    ,
    @NamedQuery(name = "Venda.findByValor", query = "SELECT v FROM Venda v WHERE v.valor = :valor")})
public class Venda implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvenda")
    private Integer idvenda;
    @Column(name = "nrparcelas")
    private Integer nrparcelas;
    @Column(name = "notafiscal")
    private Integer notafiscal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvenda")
    private List<Parcela> parcelaList;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Venda(Date data, Integer nrparcelas, Float valor, Integer notafiscal, Cliente idcliente, boolean proximomes) {
        Parcela p = new Parcela();
        //Venda v = new Venda();
        this.setData(data);
        this.setNrparcelas(nrparcelas);
        this.setValor(valor);
        this.setNotafiscal(notafiscal);
        this.setIdcliente(idcliente);
        this.parcelaList = p.getParcelas(valor, data, nrparcelas, proximomes, idcliente.getIdconvenio());
        this.setParcelaList(parcelaList);

    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        Integer oldIdvenda = this.idvenda;
        this.idvenda = idvenda;
        changeSupport.firePropertyChange("idvenda", oldIdvenda, idvenda);
    }

    public Integer getNrparcelas() {
        return nrparcelas;
    }

    private void setNrparcelas(Integer nrparcelas) {
        Integer oldNrparcelas = this.nrparcelas;
        this.nrparcelas = nrparcelas;
        changeSupport.firePropertyChange("nrparcelas", oldNrparcelas, nrparcelas);
    }

    public Integer getNotafiscal() {
        return notafiscal;
    }

    private void setNotafiscal(Integer notafiscal) {
        Integer oldNotafiscal = this.notafiscal;
        this.notafiscal = notafiscal;
        changeSupport.firePropertyChange("notafiscal", oldNotafiscal, notafiscal);
    }

    public Float getValor() {
        return valor;
    }

    private void setValor(Float valor) {
        Float oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    private void setIdcliente(Cliente idcliente) {
        Cliente oldIdcliente = this.idcliente;
        this.idcliente = idcliente;
        changeSupport.firePropertyChange("idcliente", oldIdcliente, idcliente);
    }

    @XmlTransient
    public List<Parcela> getParcelaList() {
        return parcelaList;
    }

    private void setParcelaList(List<Parcela> parcelaList) {
        this.parcelaList = parcelaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Venda[ idvenda=" + idvenda + " ]";
    }

    public Date getData() {
        return data;
    }

    private void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public boolean existeParcelaPaga() {
        for (int i = 0; i < this.parcelaList.size(); i++) {
            if (parcelaList.get(i).isPago()) {
                return true;
            }
        }
        return false;
    }
    
    public Float getPendente(){
        Float p = 0f;
        for (int i = 0 ; i < parcelaList.size(); i++){
            if(!parcelaList.get(i).isPago())
                p = p + parcelaList.get(i).getValorparcela();
            
        }
        
        return p;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
