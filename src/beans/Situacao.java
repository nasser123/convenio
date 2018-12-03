/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Produção
 */
@Entity
@Table(name = "situacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findByIdsituacao", query = "SELECT s FROM Situacao s WHERE s.idsituacao = :idsituacao"),
    @NamedQuery(name = "Situacao.findByDescricao", query = "SELECT s FROM Situacao s WHERE s.descricao = :descricao")})
public class Situacao implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsituacao")
    private Integer idsituacao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsituacao")
    private List<Parcela> parcelaList;

    public Situacao() {
    }

    public Situacao(Integer idsituacao) {
        this.idsituacao = idsituacao;
    }

    public Integer getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(Integer idsituacao) {
        Integer oldIdsituacao = this.idsituacao;
        this.idsituacao = idsituacao;
        changeSupport.firePropertyChange("idsituacao", oldIdsituacao, idsituacao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @XmlTransient
    public List<Parcela> getParcelaList() {
        return parcelaList;
    }

    public void setParcelaList(List<Parcela> parcelaList) {
        this.parcelaList = parcelaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsituacao != null ? idsituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idsituacao == null && other.idsituacao != null) || (this.idsituacao != null && !this.idsituacao.equals(other.idsituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Situacao[ idsituacao=" + idsituacao + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
