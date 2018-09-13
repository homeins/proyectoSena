/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yesid
 */
@Entity
@Table(name = "instalacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalacion.findAll", query = "SELECT i FROM Instalacion i")
    , @NamedQuery(name = "Instalacion.findByIdInstalacion", query = "SELECT i FROM Instalacion i WHERE i.idInstalacion = :idInstalacion")
    , @NamedQuery(name = "Instalacion.findByCodigoInstalacion", query = "SELECT i FROM Instalacion i WHERE i.codigoInstalacion = :codigoInstalacion")
    , @NamedQuery(name = "Instalacion.findByDireccion", query = "SELECT i FROM Instalacion i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Instalacion.findByFecha", query = "SELECT i FROM Instalacion i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Instalacion.findByHora", query = "SELECT i FROM Instalacion i WHERE i.hora = :hora")
    , @NamedQuery(name = "Instalacion.findByEstado", query = "SELECT i FROM Instalacion i WHERE i.estado = :estado")
    , @NamedQuery(name = "Instalacion.findByValorInstalacion", query = "SELECT i FROM Instalacion i WHERE i.valorInstalacion = :valorInstalacion")})
public class Instalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSTALACION")
    private Integer idInstalacion;
    @Size(max = 10)
    @Column(name = "CODIGO_INSTALACION")
    private String codigoInstalacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_INSTALACION")
    private double valorInstalacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instalacionId", fetch = FetchType.LAZY)
    private List<Encuesta> encuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instalacionId", fetch = FetchType.LAZY)
    private List<Documento> documentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instalacionId", fetch = FetchType.LAZY)
    private List<Pqr> pqrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instalacionId", fetch = FetchType.LAZY)
    private List<Novedad> novedadList;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioId;
    @JoinColumn(name = "DETALLE_ID", referencedColumnName = "ID_DETALLE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detalle detalleId;

    public Instalacion() {
    }

    public Instalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public Instalacion(Integer idInstalacion, String direccion, Date fecha, Date hora, String estado, double valorInstalacion) {
        this.idInstalacion = idInstalacion;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.valorInstalacion = valorInstalacion;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getCodigoInstalacion() {
        return codigoInstalacion;
    }

    public void setCodigoInstalacion(String codigoInstalacion) {
        this.codigoInstalacion = codigoInstalacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorInstalacion() {
        return valorInstalacion;
    }

    public void setValorInstalacion(double valorInstalacion) {
        this.valorInstalacion = valorInstalacion;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @XmlTransient
    public List<Pqr> getPqrList() {
        return pqrList;
    }

    public void setPqrList(List<Pqr> pqrList) {
        this.pqrList = pqrList;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Detalle getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Detalle detalleId) {
        this.detalleId = detalleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacion)) {
            return false;
        }
        Instalacion other = (Instalacion) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Instalacion[ idInstalacion=" + idInstalacion + " ]";
    }
    
}
