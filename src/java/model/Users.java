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
    @NamedQuery(name = "GET_USER_LIST",
    query = "SELECT u "
    + "FROM Users u "
    )}
)

@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String GET_USER= "GET_USER_LIST";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String name;
    private String password;
    private String jobTitle;
    private String deviceID;
    
    public Users() {
    }

    
    public Users(String username, String name, String password, String jobTitle, String deviceID) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.jobTitle = jobTitle;
        this.deviceID = deviceID;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the username fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Users[ id=" + username + " ]";
    }
    
}
