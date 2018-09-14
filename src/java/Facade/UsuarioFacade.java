/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author yesid
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    
    @PersistenceContext(unitName = "HomeInstallationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> ListadoCliente()
    {
        List<Usuario> usuario = null;
        try
        {
            Query Consulta = em.createNativeQuery("SELECT * FROM USUARIO WHERE ROL_ID = 4;", Usuario.class);
            usuario = (List<Usuario>) Consulta.getResultList();
        }
        catch (Exception e) 
        {
            System.out.println("ERROR" + e.getMessage());
        }
        return usuario;
    }
    
    public List<Usuario> ListadoTecnicos()
    {
        List<Usuario> usuario = null;
        try
        {
            Query Consulta = em.createNativeQuery("SELECT * FROM USUARIO WHERE ROL_ID = 3;", Usuario.class);
            usuario = (List<Usuario>) Consulta.getResultList();
        }
        catch (Exception e) 
        {
            System.out.println("ERROR" + e.getMessage());
        }
        return usuario;
    }

    public Usuario Login(String email, String contrasena)
    {
        Usuario usuario = null;
        try 
        {
            Query Consulta = em.createNativeQuery("SELECT * FROM USUARIO WHERE EMAIL = ? AND CONTRASENA = ?", Usuario.class);
            Consulta.setParameter(1, email);
            Consulta.setParameter(2, contrasena);
            usuario = (Usuario) Consulta.getSingleResult();
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR" + e.getMessage());
        }
        return usuario;    
    }
}
