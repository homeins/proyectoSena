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
@Table(name = "garantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g")
    , @NamedQuery(name = "Garantia.findByIdGarantia", query = "SELECT g FROM Garantia g WHERE g.idGarantia = :idGarantia")
    , @NamedQuery(name = "Garantia.findByCodigoGrarantia", query = "SELECT g FROM Garantia g WHERE g.codigoGrarantia = :codigoGrarantia")
    , @NamedQuery(name = "Garantia.findByEstado", query = "SELECT g FROM Garantia g WHERE g.estado = :estado")
    , @NamedQuery(name = "Garantia.findByFechaSolicitud", query = "SELECT g FROM Garantia g WHERE g.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Garantia.findByFechaVencimiento", query = "SELECT g FROM Garantia g WHERE g.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Garantia.findByDetalleProducto", query = "SELECT g FROM Garantia g WHERE g.detalleProducto = :detalleProducto")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GARANTIA")
    private Integer idGarantia;
    @Size(max = 10)
    @Column(name = "CODIGO_GRARANTIA")
    private String codigoGrarantia;
    @Size(max = 45)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DETALLE_PRODUCTO")
    private String detalleProducto;
    @JoinColumn(name = "PQR_ID", referencedColumnName = "ID_PQR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pqr pqrId;

    public Garantia() {
    }

    public Garantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Garantia(Integer idGarantia, Date fechaSolicitud, Date fechaVencimiento, String detalleProducto) {
        this.idGarantia = idGarantia;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaVencimiento = fechaVencimiento;
        this.detalleProducto = detalleProducto;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public String getCodigoGrarantia() {
        return codigoGrarantia;
    }

    public void setCodigoGrarantia(String codigoGrarantia) {
        this.codigoGrarantia = codigoGrarantia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public Pqr getPqrId() {
        return pqrId;
    }

    public void setPqrId(Pqr pqrId) {
        this.pqrId = pqrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGarantia != null ? idGarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantia)) {
            return false;
        }
        Garantia other = (Garantia) object;
        if ((this.idGarantia == null && other.idGarantia != null) || (this.idGarantia != null && !this.idGarantia.equals(other.idGarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Garantia[ idGarantia=" + idGarantia + " ]";
    }
    
}
