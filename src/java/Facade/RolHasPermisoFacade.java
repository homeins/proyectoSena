/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.RolHasPermiso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yesid
 */
@Stateless
public class RolHasPermisoFacade extends AbstractFacade<RolHasPermiso> {

    @PersistenceContext(unitName = "HomeInstallationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolHasPermisoFacade() {
        super(RolHasPermiso.class);
    }
    
}
