/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entidades.Permiso;
import Entidades.Rol;
import Entidades.RolHasPermiso;
import Facade.RolHasPermisoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author yesid
 */
@Named(value = "rolHasPermisoController")
@SessionScoped
public class RolHasPermisoController implements Serializable {

    /**
     * Creates a new instance of RolHasPermisoController
     */
    public RolHasPermisoController() 
    {
        rol = new Rol();
        permiso = new Permiso();
        rolHasPermiso = new RolHasPermiso();
    }
    
    @EJB
    RolHasPermisoFacade rolHasPermisoFacade;
    private Rol rol;
    private Permiso permiso;
    private RolHasPermiso rolHasPermiso;
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
    public RolHasPermiso getRolHasPermiso() {
        return rolHasPermiso;
    }

    public void setRolHasPermiso(RolHasPermiso rolHasPermiso) {
        this.rolHasPermiso = rolHasPermiso;
    }
    
    public void CrearRolHasPermiso()
    {
        rolHasPermiso.setRolId(rol);
        rolHasPermiso.setPermisoId(permiso);
        rolHasPermisoFacade.create(rolHasPermiso);
        rolHasPermiso = new RolHasPermiso();
    }
    
    public String ModificarRolHasPermiso(RolHasPermiso newRolHasPermiso)
    {
        rolHasPermiso = newRolHasPermiso;
        return "/RolHasPermiso/Modificar?faces-redirect=true";
    }
    
    public String ModificarRolHasPermiso()
    {
        rolHasPermiso.setRolId(rol);
        rolHasPermiso.setPermisoId(permiso);
        rolHasPermisoFacade.edit(rolHasPermiso);
        rolHasPermiso = new RolHasPermiso();
        rol = new Rol();
        permiso = new Permiso();
        return "/RolHasPermiso/Listar?faces-redirect=true";
    }
    
    public void EliminarRolHasPermiso(RolHasPermiso newRolHasPermiso)
    {
        rolHasPermiso = newRolHasPermiso;
        rolHasPermisoFacade.remove(rolHasPermiso);
        rolHasPermiso = new RolHasPermiso();
    }        
    
    public List<RolHasPermiso> ListarRolHasPermiso()
    {
        return rolHasPermisoFacade.findAll();
    }        
}
