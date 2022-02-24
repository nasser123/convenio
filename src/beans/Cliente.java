/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import util.Datas;

/**
 *
 * @author Produção
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")    ,
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente")    ,
    @NamedQuery(name = "Cliente.findByIdconvenio", query = "SELECT c FROM Cliente c WHERE c.idconvenio = :idconvenio")    ,
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")    ,
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")    ,
    @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco")    ,
    @NamedQuery(name = "Cliente.findByEndereconr", query = "SELECT c FROM Cliente c WHERE c.endereconr = :endereconr")    ,
    @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro")    ,
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")    ,
    @NamedQuery(name = "Cliente.findByIdentidade", query = "SELECT c FROM Cliente c WHERE c.identidade = :identidade")    ,
    @NamedQuery(name = "Cliente.findByNaturalidade", query = "SELECT c FROM Cliente c WHERE c.naturalidade = :naturalidade")    ,
    @NamedQuery(name = "Cliente.findByPai", query = "SELECT c FROM Cliente c WHERE c.pai = :pai")    ,
    @NamedQuery(name = "Cliente.findByMae", query = "SELECT c FROM Cliente c WHERE c.mae = :mae")    ,
    @NamedQuery(name = "Cliente.findByEmprego", query = "SELECT c FROM Cliente c WHERE c.emprego = :emprego")    ,
    @NamedQuery(name = "Cliente.findByCargo", query = "SELECT c FROM Cliente c WHERE c.cargo = :cargo")    ,
    @NamedQuery(name = "Cliente.findByDataadmissao", query = "SELECT c FROM Cliente c WHERE c.dataadmissao = :dataadmissao")    ,
    @NamedQuery(name = "Cliente.findByRenda", query = "SELECT c FROM Cliente c WHERE c.renda = :renda")})
public class Cliente implements Serializable {

    @Column(name = "celular")
    private String celular;

    @Column(name = "situacao")
    private String situacao;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "dataadmissao")
    @Temporal(TemporalType.DATE)
    private Date dataadmissao;
    @Column(name = "datanasc")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Column(name = "limite")
    private Double limite;
    @Column(name = "endereconr")
    private String endereconr;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "identidade")
    private String identidade;
    @Column(name = "naturalidade")
    private String naturalidade;
    @Column(name = "pai")
    private String pai;
    @Column(name = "mae")
    private String mae;
    @Column(name = "emprego")
    private String emprego;
    @Column(name = "cargo")
    private String cargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "renda")
    private Double renda;
    @JoinColumn(name = "idestadocivil", referencedColumnName = "idestadocivil")
    @ManyToOne(optional = false)
    private Estadocivil idestadocivil;
    @JoinColumn(name = "idsexo", referencedColumnName = "idsexo")
    @ManyToOne(optional = false)
    private Sexo idsexo;
    @JoinColumn(name = "idconvenio", referencedColumnName = "idconvenio")
    @ManyToOne(optional = false)
    private Convenio idconvenio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Venda> vendaList;
    
    //campos fora do banco de dados
    @Transient
    private BigDecimal totalFichas;
    @Transient
    private BigDecimal totalPagamentos;
    @Transient
    private BigDecimal totalAberto;
    

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        Integer oldIdcliente = this.idcliente;
        this.idcliente = idcliente;
        changeSupport.firePropertyChange("idcliente", oldIdcliente, idcliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome.toUpperCase();
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco.toUpperCase();
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro.toUpperCase();
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        String oldIdentidade = this.identidade;
        this.identidade = identidade;
        changeSupport.firePropertyChange("identidade", oldIdentidade, identidade);
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        String oldNaturalidade = this.naturalidade;
        this.naturalidade = naturalidade.toUpperCase();
        changeSupport.firePropertyChange("naturalidade", oldNaturalidade, naturalidade);
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        String oldPai = this.pai;
        this.pai = pai.toUpperCase();
        changeSupport.firePropertyChange("pai", oldPai, pai);
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        String oldMae = this.mae;
        this.mae = mae.toUpperCase();
        changeSupport.firePropertyChange("mae", oldMae, mae);
    }

    public String getEmprego() {
        return emprego;
    }

    public void setEmprego(String emprego) {
        String oldEmprego = this.emprego;
        this.emprego = emprego.toUpperCase();
        changeSupport.firePropertyChange("emprego", oldEmprego, emprego);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo.toUpperCase();
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        Double oldRenda = this.renda;
        if (renda != null) {
            this.renda = renda;
        } else {
            this.renda = 0.0;
        }
        changeSupport.firePropertyChange("renda", oldRenda, renda);
    }

    public Estadocivil getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(Estadocivil idestadocivil) {
        Estadocivil oldIdestadocivil = this.idestadocivil;
        this.idestadocivil = idestadocivil;
        changeSupport.firePropertyChange("idestadocivil", oldIdestadocivil, idestadocivil);
    }

    public Sexo getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Sexo idsexo) {
        Sexo oldIdsexo = this.idsexo;
        this.idsexo = idsexo;
        changeSupport.firePropertyChange("idsexo", oldIdsexo, idsexo);
    }

    public Convenio getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Convenio idconvenio) {
        Convenio oldIdconvenio = this.idconvenio;
        this.idconvenio = idconvenio;
        changeSupport.firePropertyChange("idconvenio", oldIdconvenio, idconvenio);
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Cliente[ idcliente=" + idcliente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getEndereconr() {
        return endereconr;
    }

    public void setEndereconr(String endereconr) {
        String oldEndereconr = this.endereconr;
        this.endereconr = endereconr;
        changeSupport.firePropertyChange("endereconr", oldEndereconr, endereconr);
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        Double oldLimite = this.limite;

        if (limite != null) {
            this.limite = limite;
        } else {
            this.limite = 0.0;
        }
        changeSupport.firePropertyChange("limite", oldLimite, limite);
    }

    public Date getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(Date dataadmissao) {
        Date oldDataadmissao = this.dataadmissao;
        this.dataadmissao = dataadmissao;
        changeSupport.firePropertyChange("dataadmissao", oldDataadmissao, dataadmissao);
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        Date oldDatanasc = this.datanasc;
        this.datanasc = datanasc;
        changeSupport.firePropertyChange("datanasc", oldDatanasc, datanasc);
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        changeSupport.firePropertyChange("situacao", oldSituacao, situacao);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }
    
    public Float getTotalAberto(){
        Float v = 0f;
        for(int i = 0; i < vendaList.size(); i++){
            v =v + vendaList.get(i).getPendente();
        }
        return v;
    }
    public Float getTotalGasto(){
        Float v = 0f;
        for(int i = 0; i < vendaList.size(); i++){
            v =v + vendaList.get(i).getValor();
        }
        return v;
    }
    
    
    
    public Float getVencido(){
        Float v = 0f;
        Date hoje = Datas.getCurrentTime();
        for(int i = 0 ; i < vendaList.size(); i++){
            v = v + vendaList.get(i).getVencidas();
        }
        
                
    return v;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
