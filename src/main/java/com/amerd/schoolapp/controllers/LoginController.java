
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;


@RequestScoped
@Named
public class LoginController implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String _username;
    @NotEmpty
    private String _password;
    
    private Appuser _currentUser;
    private boolean _isLoggedIn;
    private boolean _loginVisible;
    
    @Inject
    AppuserFacadeLocal appuserFacade;
    @Inject
    FacesContext facesContext;
    @Inject
    SecurityContext securityContext;
    @Inject
    ViewNavigator nav;

    public LoginController() {
    }
    
    @PostConstruct
    public void onInit() { 
        this._username = null;
        this._password = null;
        this._isLoggedIn = false;
        this._loginVisible = true;
        this._currentUser = null;
        
        if(null != (this._username = ((HttpServletRequest)getExternalContext().getRequest()).getRemoteUser())) {
            this._currentUser = appuserFacade.retrieveAppuserByUsername(this._username).get();
            this._isLoggedIn = true;
            this._loginVisible = false;
        }
    }
    
    public void login() {    
        if(null != (((HttpServletRequest)getExternalContext().getRequest()).getRemoteUser())) {
            nav.directFromLogin();
            return;
        }
        switch(processAuthentication()){
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null));
                break;
            case SUCCESS:
               nav.directFromLogin();
               break;
        }
    }
    
    public void logout() {
        try {
            this._username = null;
            this._password = null;
            ((HttpServletRequest)getExternalContext().getRequest()).logout();
        } catch (ServletException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        nav.toLoginPage();
    }
    
    private AuthenticationStatus processAuthentication(){
        ExternalContext ec = getExternalContext();
        
        AuthenticationStatus status = securityContext.authenticate((HttpServletRequest)ec.getRequest(), 
                                            (HttpServletResponse)ec.getResponse(), 
                                            AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(_username, _password)));
        if(status == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentication error!", null));
            return null;
        }
        return status;
    }
    
    private ExternalContext getExternalContext(){
        return facesContext.getExternalContext();
    }
    
     public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public Appuser getCurrentUser() {
        return _currentUser;
    }

    public void setCurrentUser(Appuser _currentUser) {
        this._currentUser = _currentUser;
    }

    public boolean isIsLoggedIn() {
        return _isLoggedIn;
    }

    public void setIsLoggedIn(boolean _isLoggedIn) {
        this._isLoggedIn = _isLoggedIn;
    }

    public boolean isLoginVisible() {
        return _loginVisible;
    }

    public void setLoginVisible(boolean _loginVisible) {
        this._loginVisible = _loginVisible;
    }
   
}