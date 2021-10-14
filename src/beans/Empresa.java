/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByRazaosocial", query = "SELECT e FROM Empresa e WHERE e.razaosocial = :razaosocial"),
    @NamedQuery(name = "Empresa.findByFantasia", query = "SELECT e FROM Empresa e WHERE e.fantasia = :fantasia")
    , @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Empresa.findByEndereco", query = "SELECT e FROM Empresa e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "Empresa.findByCidade", query = "SELECT e FROM Empresa e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Empresa.findByValidanf", query = "SELECT e FROM Empresa e WHERE e.validanf = :validanf")
    , @NamedQuery(name = "Empresa.findByBloqinadimplente", query = "SELECT e FROM Empresa e WHERE e.bloqinadimplente = :bloqinadimplente")
    , @NamedQuery(name = "Empresa.findByBloqlimite", query = "SELECT e FROM Empresa e WHERE e.bloqlimite = :bloqlimite")})
public class Empresa implements Serializable {

    @Column(name = "validanf")
    private Short validanf;
    @Column(name = "bloqinadimplente")
    private Short bloqinadimplente;
    @Column(name = "bloqlimite")
    private Short bloqlimite;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Column(name = "razaosocial")
    private String razaosocial;
    @Column(name = "fantasia")
    private String fantasia;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "cidade")
    private String cidade;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Empresa_1[ idEmpresa=" + idEmpresa + " ]";
    }

    public Short getValidanf() {
        return validanf;
    }

    public void setValidanf(Short validanf) {
        this.validanf = validanf;
    }

    public Short getBloqinadimplente() {
        return bloqinadimplente;
    }

    public void setBloqinadimplente(Short bloqinadimplente) {
        this.bloqinadimplente = bloqinadimplente;
    }

    public Short getBloqlimite() {
        return bloqlimite;
    }

    public void setBloqlimite(Short bloqlimite) {
        this.bloqlimite = bloqlimite;
    }
    
}
