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
@Table(name = "estadocivil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e"),
    @NamedQuery(name = "Estadocivil.findByIdestadocivil", query = "SELECT e FROM Estadocivil e WHERE e.idestadocivil = :idestadocivil"),
    @NamedQuery(name = "Estadocivil.findByDescricao", query = "SELECT e FROM Estadocivil e WHERE e.descricao = :descricao")})
public class Estadocivil implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadocivil")
    private Integer idestadocivil;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadocivil")
    private List<Cliente> clienteList;

    public Estadocivil() {
    }

    public Estadocivil(Integer idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public Integer getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(Integer idestadocivil) {
        Integer oldIdestadocivil = this.idestadocivil;
        this.idestadocivil = idestadocivil;
        changeSupport.firePropertyChange("idestadocivil", oldIdestadocivil, idestadocivil);
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
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadocivil != null ? idestadocivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.idestadocivil == null && other.idestadocivil != null) || (this.idestadocivil != null && !this.idestadocivil.equals(other.idestadocivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Estadocivil[ idestadocivil=" + idestadocivil + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
