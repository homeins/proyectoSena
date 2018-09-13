/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Detalle;
import Entidades.Instalacion;
import Entidades.Usuario;
import Facade.InstalacionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author yesid
 */
@Named(value = "instalacionController")
@SessionScoped
public class InstalacionController implements Serializable {

    /**
     * Creates a new instance of InstalacionController
     */
    public InstalacionController() 
    {
        instalacion = new Instalacion();
        usuario = new Usuario();
        detalle = new Detalle();
    }
    
    @EJB
    InstalacionFacade instalacionFacade;
    private Instalacion instalacion;
    private Usuario usuario;
    private Detalle detalle;

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }
    
    public void CrearInstalacion()
    {
     instalacion.setUsuarioId(usuario);
     instalacion.setDetalleId(detalle);
     instalacionFacade.create(instalacion);
     instalacion = new Instalacion();
    }
    
    public String ModificarInstalacion(Instalacion newInstalacion)
    {
        instalacion = newInstalacion;
        return "/Instalacion/Modificar?faces-redirect=true";
    }
    
    public String ModificarInstalacion()
    {
        instalacion.setUsuarioId(usuario);
        instalacion.setDetalleId(detalle);
        instalacionFacade.edit(instalacion);
        instalacion = new Instalacion();
        detalle = new Detalle();
        usuario = new Usuario();
        return "/ListarInstalacion?faces-redirect=true";
    }
    
    public void EliminaInstalacion(Instalacion newInstalacion)
    {
        instalacion = newInstalacion;
        instalacionFacade.remove(instalacion);
        instalacion = new Instalacion();
    }
    
    public List<Instalacion> ListarInstalacion()
    {
        return instalacionFacade.findAll();
    }
}