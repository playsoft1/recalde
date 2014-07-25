/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import rnegocio.clases.Usuario;
import rnegocio.funciones.FUsuario;

/**
 *
 * @author José
 */
@ManagedBean
@SessionScoped
@ViewScoped
public class Sesionjuego {
    Usuario usr;
   // @ManagedProperty(value = "#{sesion}")
    public static HttpSession sesion;

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public Sesionjuego() {
        usr = new Usuario();
    }

    
    
    public void autenticar()
    {
        try{
            
            
                sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
                usr = FUsuario.obtenerEstudianteCedula(usr.getCedulausuario());
                if (usr == null)
                {
                 FacesMessage facesMsg =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Mal clave o contrasenia");
                 FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                 FacesContext.getCurrentInstance().getExternalContext().redirect("faces/menugeneral.xhtml");
                }
                else
                {
                    sesion.setAttribute("user", usr);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/adminjuego.xhtml");
                }
                
           
        }
        catch(Exception es)
        {
            System.out.println(es.getMessage());
            FacesMessage facesMsg = 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "Error","Error desconocido");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        
    }
    
     public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;
        Usuario aux = new Usuario();
         
         //usr=null;
        try {  
            aux = FUsuario.obtener(usr.getCedulausuario());
        } catch (Exception ex) {
            //Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        usr=aux;
        
        if(!aux.getCedulausuario().isEmpty()) {  
            loggedIn = true;  
            sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
            sesion.setAttribute("usuario", usr);
            
           
            //msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "User"); 
            //FacesContext.getCurrentInstance().addMessage(null, msg); 
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("unDocente.xhtml");
                 FacesMessage facesMsg = 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "cooo","Error desconocido");
                 FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            } catch (IOException ex) {
                  FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Información","falsoooo correctamente");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                //Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {  
            loggedIn = false;  
            //msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
            
            //FacesContext.getCurrentInstance().addMessage(null, msg);
            sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
            sesion.setAttribute("usuario", usr);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                //Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
          
         
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
    
    
    
}
