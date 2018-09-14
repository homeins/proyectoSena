/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author yesid
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() 
    {
        usuario = new Usuario();
        tipoDocumento = new TipoDocumento();
        rol = new Rol();
        usuarioLogeado = new Usuario();
        mensajeController = new MensajeController();
    }
    
    @EJB
    UsuarioFacade usuarioFacade;
    private MensajeController mensajeController;
    private Usuario usuario;
    private TipoDocumento tipoDocumento;
    private Rol rol;
    private Usuario usuarioLogeado;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public MensajeController getMensajeController() {
        return mensajeController;
    }

    public void setMensajeController(MensajeController mensajeController) {
        this.mensajeController = mensajeController;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    
    public void CrearUsuario()
    {
        usuario.setDocumentoTipoId(tipoDocumento);
        usuario.setRolId(rol);
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        tipoDocumento = new TipoDocumento();
        rol = new Rol();
    }
    
    public String ModificarUsuario(Usuario newUsuario)
    {
        usuario = newUsuario;
        return "/Usuario/Modificar?faces-redirect=true";
    }
    
    public String ModificarUsuario()
    {
        usuario.setDocumentoTipoId(tipoDocumento);
        usuario.setRolId(rol);
        usuarioFacade.edit(usuario);
        usuario = new Usuario();
        tipoDocumento = new TipoDocumento();
        rol = new Rol();
        return "/Usuario/Listar?faces-redirect=true";
    }   
    
    public void EliminaUsuario(Usuario newUsuario)
    {
        usuario = newUsuario;
        usuarioFacade.remove(usuario);
        usuario = new Usuario();
    }
    
    public List<Usuario> ListarUsuario()
    {
        return usuarioFacade.findAll();
    }
    
    public List<Usuario> ListarClientes()
    {
        return usuarioFacade.ListadoCliente();
    }
    
    public List<Usuario> ListarTecnicos()
    {
        return usuarioFacade.ListadoTecnicos();
    }
    
    public String Login()
    {
        Usuario usu;
        String redireccion = "";
        usu = usuarioFacade.Login(usuario.getEmail(), usuario.getContrasena());
        if (usu != null)
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usu);
            usuarioLogeado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            switch (usu.getRolId().getIdRol()) 
            {
                case 1:
                    redireccion = "/Admin/Admin?faces-redirect=true";
                    usuario = new Usuario();
                    break;
                case 2:
                    redireccion = "/Disenador/Disenador?faces-redirect=true";
                    usuario = new Usuario();
                    break;
                case 3:
                    redireccion = "/Tecnico/Tecnico?faces-redirect=true";
                    usuario = new Usuario();
                    break;
                default:
                    break;
            }
        }
        else
        {
            System.out.println("USUARIO O CONTARSEÑA INCORRECTA");
            redireccion = "/index?faces-redirect=true";
            usuario = new Usuario();
        }
        return redireccion;
    }
    
    public String CerrarSesion()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarioLogeado = new Usuario();
        return "/index?faces-redirect=true";
    }

}
