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
 * @author stive
 */
@Named(value = "instalacionController")
@SessionScoped
public class InstalacionController implements Serializable {

    /**
     * Creates a new instance of InstalacionController
     */
    public InstalacionController() {
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

    public List<Instalacion> listarInstalaciones() {
        return instalacionFacade.findAll();

    }

    public void crearInstalacion() {
        instalacion.setDetalleId(detalle);
        instalacion.setUsuarioId(usuario);
        instalacionFacade.create(instalacion);
        instalacion = new Instalacion();
    }

    public String modificarInstalacion(Instalacion newInstalacion) {
        instalacion = newInstalacion;
        return "Instalacion/Modificar";
    }

    public String modificarInstalacion() {
        instalacion.setDetalleId(detalle);
        instalacion.setUsuarioId(usuario);
        instalacionFacade.edit(instalacion);
        instalacion = new Instalacion();
        usuario = new Usuario();
        detalle = new Detalle();
        return "Instalacion/ListaInstalaciones";
    }

    public void eliminarInstalacion(Instalacion newInstalacion) {
        instalacion = newInstalacion;
        instalacionFacade.remove(instalacion);
        instalacion = new Instalacion();
    }

}
