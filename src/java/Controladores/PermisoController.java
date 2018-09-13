/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Permiso;
import Facade.PermisoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author yesid
 */
@Named(value = "permisoController")
@SessionScoped
public class PermisoController implements Serializable {

    /**
     * Creates a new instance of PermisoController
     */
    public PermisoController() 
    {
        permiso = new Permiso();
    }
    
    @EJB
    PermisoFacade permisoFacade;
    private Permiso permiso;

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
    public void CrearPermiso()
    {
        permisoFacade.create(permiso);
        permiso = new Permiso();
    }
    
    public String ModificarPermiso(Permiso newPermiso)
    {
        permiso = newPermiso;
        return "/Permiso/Modificar?faces-redirect=true";
    }
    
    public String ModificarPermiso()
    {
        permisoFacade.edit(permiso);
        permiso = new Permiso();
        return "/Permiso/Listar?faces-redirect=true";
    }
    
    public void EliminarPermiso(Permiso newPermiso)
    {
        permiso = newPermiso;
        permisoFacade.remove(permiso);
        permiso = new Permiso();
    }
    
    public List<Permiso> ListarPermiso()
    {
        return permisoFacade.findAll();
    }
}
