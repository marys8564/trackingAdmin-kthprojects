/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsersFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Users;

/**
 *
 * @author mary
 */
@Named(value = "loginManager")
@ConversationScoped
public class LoginManager implements Serializable {

    private String username;
    private String password;
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @EJB
    private UsersFacade UserFacade;
    @Inject
    private Conversation conversation;

    /**
     * Creates a new instance of LoginManager
     */
    public LoginManager() {
    }

    public void loginAccount() {
        if (username.equals("admin") || password.equals("admin")) {
            startConversation();
            admin = true;
        }

    }

    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
}
