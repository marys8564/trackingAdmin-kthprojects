/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author mary
 */

@NamedQueries({
    @NamedQuery(name = "GET_EMPLOYEE_TASKS",
    query = "SELECT u "
    + "FROM Tasks u "
    )}
)

@Entity
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_TASKS= "GET_EMPLOYEE_TASKS";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String agenda;
    private String dateTime;
    private String status;
    

    public Tasks() {
    }
    

    public Tasks(String username, String agenda, String dateTime, String status) {
        this.username = username;
        this.agenda = agenda;
        this.dateTime = dateTime;
        this.status = status;
    }
    
    

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the value of dateTime
     *
     * @return the value of dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Set the value of dateTime
     *
     * @param dateTime new value of dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Get the value of agenda
     *
     * @return the value of agenda
     */
    public String getAgenda() {
        return agenda;
    }

    /**
     * Set the value of agenda
     *
     * @param agenda new value of agenda
     */
    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tasks[ id=" + id + " ]";
    }
}
