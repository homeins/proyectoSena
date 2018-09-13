/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByIdEncuesta", query = "SELECT e FROM Encuesta e WHERE e.idEncuesta = :idEncuesta")
    , @NamedQuery(name = "Encuesta.findByCodigoEncuesta", query = "SELECT e FROM Encuesta e WHERE e.codigoEncuesta = :codigoEncuesta")
    , @NamedQuery(name = "Encuesta.findByFechaRealizada", query = "SELECT e FROM Encuesta e WHERE e.fechaRealizada = :fechaRealizada")
    , @NamedQuery(name = "Encuesta.findByPuntualidad", query = "SELECT e FROM Encuesta e WHERE e.puntualidad = :puntualidad")
    , @NamedQuery(name = "Encuesta.findByCumplimiento", query = "SELECT e FROM Encuesta e WHERE e.cumplimiento = :cumplimiento")
    , @NamedQuery(name = "Encuesta.findByCumplimientoTiempos", query = "SELECT e FROM Encuesta e WHERE e.cumplimientoTiempos = :cumplimientoTiempos")
    , @NamedQuery(name = "Encuesta.findByValorPresupuesto", query = "SELECT e FROM Encuesta e WHERE e.valorPresupuesto = :valorPresupuesto")
    , @NamedQuery(name = "Encuesta.findByCalidad", query = "SELECT e FROM Encuesta e WHERE e.calidad = :calidad")
    , @NamedQuery(name = "Encuesta.findByAtencion", query = "SELECT e FROM Encuesta e WHERE e.atencion = :atencion")
    , @NamedQuery(name = "Encuesta.findByVolveria", query = "SELECT e FROM Encuesta e WHERE e.volveria = :volveria")
    , @NamedQuery(name = "Encuesta.findByRecomendaria", query = "SELECT e FROM Encuesta e WHERE e.recomendaria = :recomendaria")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENCUESTA")
    private Integer idEncuesta;
    @Size(max = 10)
    @Column(name = "CODIGO_ENCUESTA")
    private String codigoEncuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REALIZADA")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PUNTUALIDAD")
    private String puntualidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CUMPLIMIENTO")
    private String cumplimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CUMPLIMIENTO_TIEMPOS")
    private String cumplimientoTiempos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VALOR_PRESUPUESTO")
    private String valorPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CALIDAD")
    private String calidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ATENCION")
    private String atencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLVERIA")
    private Character volveria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECOMENDARIA")
    private Character recomendaria;
    @JoinColumn(name = "INSTALACION_ID", referencedColumnName = "ID_INSTALACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instalacion instalacionId;

    public Encuesta() {
    }

    public Encuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Encuesta(Integer idEncuesta, Date fechaRealizada, String puntualidad, String cumplimiento, String cumplimientoTiempos, String valorPresupuesto, String calidad, String atencion, Character volveria, Character recomendaria) {
        this.idEncuesta = idEncuesta;
        this.fechaRealizada = fechaRealizada;
        this.puntualidad = puntualidad;
        this.cumplimiento = cumplimiento;
        this.cumplimientoTiempos = cumplimientoTiempos;
        this.valorPresupuesto = valorPresupuesto;
        this.calidad = calidad;
        this.atencion = atencion;
        this.volveria = volveria;
        this.recomendaria = recomendaria;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getCodigoEncuesta() {
        return codigoEncuesta;
    }

    public void setCodigoEncuesta(String codigoEncuesta) {
        this.codigoEncuesta = codigoEncuesta;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public String getPuntualidad() {
        return puntualidad;
    }

    public void setPuntualidad(String puntualidad) {
        this.puntualidad = puntualidad;
    }

    public String getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(String cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public String getCumplimientoTiempos() {
        return cumplimientoTiempos;
    }

    public void setCumplimientoTiempos(String cumplimientoTiempos) {
        this.cumplimientoTiempos = cumplimientoTiempos;
    }

    public String getValorPresupuesto() {
        return valorPresupuesto;
    }

    public void setValorPresupuesto(String valorPresupuesto) {
        this.valorPresupuesto = valorPresupuesto;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }

    public Character getVolveria() {
        return volveria;
    }

    public void setVolveria(Character volveria) {
        this.volveria = volveria;
    }

    public Character getRecomendaria() {
        return recomendaria;
    }

    public void setRecomendaria(Character recomendaria) {
        this.recomendaria = recomendaria;
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
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Encuesta[ idEncuesta=" + idEncuesta + " ]";
    }
    
}
