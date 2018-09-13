package Controladores;

import Entidades.Rol;
import Entidades.TipoDocumento;
import Entidades.Usuario;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author stive
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    /**
     * Creates a new instance of usuarioController
     */
    public usuarioController() {
        usuario = new Usuario();
        tipoDoc = new TipoDocumento();
        rol = new Rol();

    }
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private TipoDocumento tipoDoc;
    private Rol rol;
    Usuario usuarioLogeado; 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Usuario> listarUsuario() {
        return usuarioFacade.findAll();
    }

    public void crearUsuario() {
        usuario.setDocumentoTipoId(tipoDoc);
        usuario.setRolId(rol);
        usuarioFacade.create(usuario);
        usuario = new Usuario();
    }

    public String modificarUsuario(Usuario newUsuario) {

        usuario = newUsuario;
        return "";

    }

    public String modificarUsuario() {
        usuario.setDocumentoTipoId(tipoDoc);
        usuario.setRolId(rol);
        usuarioFacade.edit(usuario);
        usuario = new Usuario();
        tipoDoc = new TipoDocumento();
        rol = new Rol();
        return "";
    }

    public void eliminarUsuario(Usuario newUsuario) {
        usuario = newUsuario;
        usuarioFacade.remove(usuario);
        usuario = new Usuario();
    }
    
    public String Login(){
    
    Usuario usu;
    String redireccion = "";
    usu = usuarioFacade.Login(usuario.getEmail(), usuario.getContrasena());
    
        if (usu != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usu);
            usuarioLogeado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            System.out.println("validacion correcta");
            
            redireccion = "/Disenador/Disenador?faces-redirect=true";
        } else {
            System.out.println("EMAIL O CONTRASEÑA INCORRECTA");
            redireccion = "/index?faces-redirect=true";
        }
        return redireccion;
    }
}
