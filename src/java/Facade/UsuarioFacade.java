/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stive
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "HomeInsFase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario Login(String email, String contrasena) {
        Usuario usuario = null;

        try {
            Query consulta = em.createNativeQuery("SELECT * FROM USUARIO WHERE EMAIL = ? AND CONTRASENA = ?", Usuario.class);
            consulta.setParameter(1, email);
            consulta.setParameter(2, contrasena);
            usuario = (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return usuario;
    }
}
