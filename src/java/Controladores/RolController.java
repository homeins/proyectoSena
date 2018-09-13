/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facade.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author stive
 */
@Named(value = "rolController")
@SessionScoped
public class RolController implements Serializable {

    /**
     * Creates a new instance of RolController
     */
    public RolController() {
        rol = new Rol();
    }
    @EJB
    RolFacade rolFac;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> listarRoles() {

        return rolFac.findAll();

    }
}
