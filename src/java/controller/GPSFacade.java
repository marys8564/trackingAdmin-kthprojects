/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GPS;

/**
 *
 * @author mary
 */
@Stateless
public class GPSFacade extends AbstractFacade<GPS> {
    @PersistenceContext(unitName = "TrackingAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GPSFacade() {
        super(GPS.class);
    }
    
}
