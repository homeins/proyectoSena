/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Encuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yesid
 */
@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> {

    @PersistenceContext(unitName = "HomeInstallationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }
    
}
