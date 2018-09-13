
package Facade;

import Entidades.Pqr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stive
 */
@Stateless
public class PqrFacade extends AbstractFacade<Pqr> {

    @PersistenceContext(unitName = "HomeInsFase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrFacade() {
        super(Pqr.class);
    }
    
}
