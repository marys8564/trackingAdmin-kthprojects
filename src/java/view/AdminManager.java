/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import controller.UsersFacade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;
import model.Tasks;
import model.Users;

/**
 *
 * @author mary
 */
@Named(value = "adminManager")
@ConversationScoped
public class AdminManager implements Serializable {

    private String name;
    private String username;
    private String password;
    private String jobTitle;
    private String deviceId;
    private String agenda;
    private Long dateTime;
    private List<Users> userList;
    private List<Tasks> tasksList;
    private boolean employeeList;
    private boolean addEmployee;
    private boolean taskList;
    //   private Tasks tasks;
    @EJB
    private UsersFacade usersFacade;
    @Inject
    private Conversation conversation;

    /**
     * Creates a new instance of AdminManager
     */
    public AdminManager() {
        FacesContext context = FacesContext.getCurrentInstance();
        LoginManager loginManager = (LoginManager) context.getApplication().evaluateExpressionGet(context, "#{loginManager}", LoginManager.class);
        addEmployee = true;
        employeeList = false;
        taskList = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<Users> getUserList() {

        startConversation();
        userList = usersFacade.getUserList();
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public List<Tasks> getTasksList() {
        startConversation();
        tasksList = usersFacade.getTasksList();
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (Tasks tasks : tasksList) {
            date = new Date(Long.parseLong(tasks.getDateTime()));
            tasks.setDateTime(dateFormat.format(date));

        }
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public boolean isEmployeeList() {
        return employeeList;
    }

    public boolean isAddEmployee() {
        return addEmployee;
    }

    public boolean isTaskList() {
        return taskList;
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

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Start the conversation between the manager and the facade
     */
    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    /**
     * Stop the conversation between the manager and the facade
     */
    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public void addEmployeeTab() {
        addEmployee = true;
        employeeList = false;
        taskList = false;
    }

    /**
     * change the form of the inventory management page
     */
    public void employeeListTab() {
        addEmployee = false;
        employeeList = true;
        taskList = false;
    }

    public void taskListTab() {
        addEmployee = false;
        employeeList = false;
        taskList = true;


    }

    public void addEmployee() {
        startConversation();
        usersFacade.addUsers(username, name, password, jobTitle, deviceId);
        username = "";
        password = "";
        name = "";
        jobTitle = "";
        deviceId = "";
    }

    public void addAgenda(Users users) {
        Date date = new Date();
        dateTime = date.getTime();
        startConversation();
        usersFacade.addAgenda(users.getUsername(), agenda, String.valueOf(dateTime), "Infromed");

        agenda = "";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate();
        return "logout";
    }
}