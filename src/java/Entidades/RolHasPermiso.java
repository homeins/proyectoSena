/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "rol_has_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolHasPermiso.findAll", query = "SELECT r FROM RolHasPermiso r")
    , @NamedQuery(name = "RolHasPermiso.findByIdRolper", query = "SELECT r FROM RolHasPermiso r WHERE r.idRolper = :idRolper")})
public class RolHasPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROLPER")
    private Integer idRolper;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rolId;
    @JoinColumn(name = "PERMISO_ID", referencedColumnName = "ID_PERMISO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permiso permisoId;

    public RolHasPermiso() {
    }

    public RolHasPermiso(Integer idRolper) {
        this.idRolper = idRolper;
    }

    public Integer getIdRolper() {
        return idRolper;
    }

    public void setIdRolper(Integer idRolper) {
        this.idRolper = idRolper;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Permiso getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Permiso permisoId) {
        this.permisoId = permisoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolper != null ? idRolper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasPermiso)) {
            return false;
        }
        RolHasPermiso other = (RolHasPermiso) object;
        if ((this.idRolper == null && other.idRolper != null) || (this.idRolper != null && !this.idRolper.equals(other.idRolper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RolHasPermiso[ idRolper=" + idRolper + " ]";
    }
    
}
