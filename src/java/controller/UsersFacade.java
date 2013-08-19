/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Tasks;
import model.Users;

/**
 *
 * @author mary
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

   

    @PersistenceContext(unitName = "TrackingAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

     public Users addUsers(String username, String name, String password, String jobTitle, String deviceId) {
            Users newUser = new Users(username, name, password, jobTitle, deviceId);
            em.persist(newUser);
            return newUser;
     }

     public List<Users> getUserList() {
        
        return em.createNamedQuery(Users.GET_USER, Users.class).
                getResultList();
    }

    public Tasks addAgenda(String username, String agenda, String dateTime, String status) {
        Tasks newTasks = new Tasks(username, agenda, dateTime, status);
        em.merge(newTasks);
//        em.persist(newTasks);
        return newTasks;
        
    }

    public List<Tasks> getTasksList() {
        return em.createNamedQuery(Tasks.GET_TASKS, Tasks.class).
                getResultList();
    }

}
