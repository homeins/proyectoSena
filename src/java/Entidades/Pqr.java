/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yesid
 */
@Entity
@Table(name = "pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqr.findAll", query = "SELECT p FROM Pqr p")
    , @NamedQuery(name = "Pqr.findByIdPqr", query = "SELECT p FROM Pqr p WHERE p.idPqr = :idPqr")
    , @NamedQuery(name = "Pqr.findByCodigoPqr", query = "SELECT p FROM Pqr p WHERE p.codigoPqr = :codigoPqr")
    , @NamedQuery(name = "Pqr.findByDocumentoUsu", query = "SELECT p FROM Pqr p WHERE p.documentoUsu = :documentoUsu")
    , @NamedQuery(name = "Pqr.findByNombreUsu", query = "SELECT p FROM Pqr p WHERE p.nombreUsu = :nombreUsu")
    , @NamedQuery(name = "Pqr.findByApellidoUsu", query = "SELECT p FROM Pqr p WHERE p.apellidoUsu = :apellidoUsu")
    , @NamedQuery(name = "Pqr.findByEmailUsu", query = "SELECT p FROM Pqr p WHERE p.emailUsu = :emailUsu")
    , @NamedQuery(name = "Pqr.findByDetalle", query = "SELECT p FROM Pqr p WHERE p.detalle = :detalle")})
public class Pqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PQR")
    private Integer idPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO_PQR")
    private String codigoPqr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO_USU")
    private int documentoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_USU")
    private String nombreUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "APELLIDO_USU")
    private String apellidoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL_USU")
    private String emailUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETALLE")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pqrId", fetch = FetchType.LAZY)
    private List<Garantia> garantiaList;
    @JoinColumn(name = "INSTALACION_ID", referencedColumnName = "ID_INSTALACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instalacion instalacionId;

    public Pqr() {
    }

    public Pqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public Pqr(Integer idPqr, String codigoPqr, int documentoUsu, String nombreUsu, String apellidoUsu, String emailUsu, String detalle) {
        this.idPqr = idPqr;
        this.codigoPqr = codigoPqr;
        this.documentoUsu = documentoUsu;
        this.nombreUsu = nombreUsu;
        this.apellidoUsu = apellidoUsu;
        this.emailUsu = emailUsu;
        this.detalle = detalle;
    }

    public Integer getIdPqr() {
        return idPqr;
    }

    public void setIdPqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public String getCodigoPqr() {
        return codigoPqr;
    }

    public void setCodigoPqr(String codigoPqr) {
        this.codigoPqr = codigoPqr;
    }

    public int getDocumentoUsu() {
        return documentoUsu;
    }

    public void setDocumentoUsu(int documentoUsu) {
        this.documentoUsu = documentoUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getApellidoUsu() {
        return apellidoUsu;
    }

    public void setApellidoUsu(String apellidoUsu) {
        this.apellidoUsu = apellidoUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public List<Garantia> getGarantiaList() {
        return garantiaList;
    }

    public void setGarantiaList(List<Garantia> garantiaList) {
        this.garantiaList = garantiaList;
    }

    public Instalacion getInstalacionId() {
        return instalacionId;
    }

    public void setInstalacionId(Instalacion instalacionId) {
        this.instalacionId = instalacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPqr != null ? idPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqr)) {
            return false;
        }
        Pqr other = (Pqr) object;
        if ((this.idPqr == null && other.idPqr != null) || (this.idPqr != null && !this.idPqr.equals(other.idPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pqr[ idPqr=" + idPqr + " ]";
    }
    
}
