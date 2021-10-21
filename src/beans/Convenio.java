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
@Table(name = "convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c ORDER BY c.nome"),
    @NamedQuery(name = "Convenio.findByIdconvenio", query = "SELECT c FROM Convenio c WHERE c.idconvenio = :idconvenio"),
    @NamedQuery(name = "Convenio.findByNome", query = "SELECT c FROM Convenio c WHERE c.nome = :nome"),
    @NamedQuery(name = "Convenio.findByResponsavel", query = "SELECT c FROM Convenio c WHERE c.responsavel = :responsavel"),
    @NamedQuery(name = "Convenio.findByTelefone", query = "SELECT c FROM Convenio c WHERE c.telefone = :telefone")})
public class Convenio implements Serializable,  Comparable<Convenio> {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comissao")
    private Double comissao;

    

    @Column(name = "vencimento")
    private Integer vencimento;
    @Column(name = "datalimite")
    private Integer datalimite;

    @Column(name = "nrparcelas")
    private Integer nrparcelas;

    @Column(name = "situacao")
    private String situacao;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconvenio")
    private Integer idconvenio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconvenio")
    private List<Cliente> clienteList;

    public Convenio() {
    }

    public Convenio(Integer idconvenio) {
        this.idconvenio = idconvenio;
    }

    public Integer getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Integer idconvenio) {
        Integer oldIdconvenio = this.idconvenio;
        this.idconvenio = idconvenio;
        changeSupport.firePropertyChange("idconvenio", oldIdconvenio, idconvenio);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome.toUpperCase();
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        String oldResponsavel = this.responsavel;
        if(responsavel != null)
        this.responsavel = responsavel.toUpperCase();
        else
            this.responsavel = "";
        changeSupport.firePropertyChange("responsavel", oldResponsavel, responsavel);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        if(telefone != null)
        this.telefone = telefone;
        else
            this.telefone = "";
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
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
        hash += (idconvenio != null ? idconvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idconvenio == null && other.idconvenio != null) || (this.idconvenio != null && !this.idconvenio.equals(other.idconvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Convenio[ idconvenio=" + idconvenio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        changeSupport.firePropertyChange("situacao", oldSituacao, situacao);
    }

    @Override
    public int compareTo(Convenio outroConvenio) {
        if (this.getIdconvenio() < outroConvenio.getIdconvenio()) {
            return -1;
        }
        if (this.getIdconvenio() > outroConvenio.getIdconvenio()) {
            return 1;
        }
        return 0;
    }

    public Integer getNrparcelas() {
        return nrparcelas;
    }

    public void setNrparcelas(Integer nrparcelas) {
        Integer oldNrparcelas = this.nrparcelas;
        if(nrparcelas != null)
            this.nrparcelas = nrparcelas;
        else
            this.nrparcelas = 10;
        changeSupport.firePropertyChange("nrparcelas", oldNrparcelas, nrparcelas);
    }

    public Integer getVencimento() {
        return vencimento;
    }

    public void setVencimento(Integer vencimento) {
        Integer oldVencimento = this.vencimento;
        if(vencimento != null)
            this.vencimento = vencimento;
        else
            this.vencimento = 10;
        changeSupport.firePropertyChange("vencimento", oldVencimento, vencimento);
    }

    public Integer getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(Integer datalimite) {
        Integer oldDatalimite = this.datalimite;
        if(datalimite != null)
            this.datalimite = datalimite;
        else
            this.datalimite = 25;
        changeSupport.firePropertyChange("datalimite", oldDatalimite, datalimite);
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        Double oldComissao = this.comissao;
        if(comissao != null)
            this.comissao = comissao;
        else
            this.comissao = 5.0;
        changeSupport.firePropertyChange("comissao", oldComissao, comissao);
    }

    

   


}
