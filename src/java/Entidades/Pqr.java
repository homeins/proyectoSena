/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
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
 * @author stive
 */
@Entity
@Table(name = "pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqr.findAll", query = "SELECT p FROM Pqr p")
    , @NamedQuery(name = "Pqr.findByIdPqr", query = "SELECT p FROM Pqr p WHERE p.idPqr = :idPqr")
    , @NamedQuery(name = "Pqr.findByCodigoPqr", query = "SELECT p FROM Pqr p WHERE p.codigoPqr = :codigoPqr")
    , @NamedQuery(name = "Pqr.findByNombreUsu", query = "SELECT p FROM Pqr p WHERE p.nombreUsu = :nombreUsu")
    , @NamedQuery(name = "Pqr.findByEmailUsu", query = "SELECT p FROM Pqr p WHERE p.emailUsu = :emailUsu")
    , @NamedQuery(name = "Pqr.findByTelefonoUsu", query = "SELECT p FROM Pqr p WHERE p.telefonoUsu = :telefonoUsu")
    , @NamedQuery(name = "Pqr.findByAsunto", query = "SELECT p FROM Pqr p WHERE p.asunto = :asunto")
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
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_USU")
    private String nombreUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL_USU")
    private String emailUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TELEFONO_USU")
    private String telefonoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ASUNTO")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETALLE")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pqrId", fetch = FetchType.LAZY)
    private Collection<Garantia> garantiaCollection;
    @JoinColumn(name = "INSTALACION_ID", referencedColumnName = "ID_INSTALACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instalacion instalacionId;

    public Pqr() {
    }

    public Pqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public Pqr(Integer idPqr, String codigoPqr, String nombreUsu, String emailUsu, String telefonoUsu, String asunto, String detalle) {
        this.idPqr = idPqr;
        this.codigoPqr = codigoPqr;
        this.nombreUsu = nombreUsu;
        this.emailUsu = emailUsu;
        this.telefonoUsu = telefonoUsu;
        this.asunto = asunto;
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

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getTelefonoUsu() {
        return telefonoUsu;
    }

    public void setTelefonoUsu(String telefonoUsu) {
        this.telefonoUsu = telefonoUsu;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public Collection<Garantia> getGarantiaCollection() {
        return garantiaCollection;
    }

    public void setGarantiaCollection(Collection<Garantia> garantiaCollection) {
        this.garantiaCollection = garantiaCollection;
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
