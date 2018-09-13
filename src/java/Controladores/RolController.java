/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facade.RolFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author yesid
 */
@Named(value = "rolController")
@Dependent
public class RolController {

    /**
     * Creates a new instance of RolController
     */
    public RolController() 
    {
        rol = new Rol();
    }
    
    @EJB
    RolFacade rolFacade;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public void CrearRol()
    {
        rolFacade.create(rol);
        rol = new Rol();
    }
    
    public String ModificarRol(Rol newRol)
    {
        rol = newRol;
        return "/Rol/Modificar?faces-redirect=true";
    }
    
    public String ModificarRol()
    {
        rolFacade.edit(rol);
        rol = new Rol();
        return "/Rol/Listar?faces-redirect=true";
    }
    
    public void EliminarRol(Rol newRol)
    {
        rol = newRol;
        rolFacade.remove(rol);
        rol = new Rol();
    }
    
    public List<Rol> ListarRol()
    {
        return rolFacade.findAll();
    }
}
