package com.test.bean;

import com.test.dao.LoginDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;
    private String rol;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    //validate login
    public String validateUsernamePassword() {

        boolean valid = LoginDao.validate(user, pwd);
      //  boolean validEmp = LoginDao.validateEmp(user, pwd);

        if (valid) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", user);
            return "Registro";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario o contraseña incorrectas",""));
            return "index";
        }
    }

    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "index";
    }

    /*
     if (validEmp) {
     HttpSession session = SessionBean.getSession();
     session.setAttribute("username", user);
     return "Instructor_Medidas";
     }
                      
     } */
	//logout event, invalidate session
}
