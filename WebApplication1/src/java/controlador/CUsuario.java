/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import rnegocio.clases.Usuario;
import rnegocio.funciones.FUsuario;


/**
 *
 * @author jorgeskoll
 */
@ManagedBean
@ViewScoped

public class CUsuario {
    private ArrayList<Usuario> listaUsuario;
    private Usuario usuarioNuevo;
    private Usuario usuarioSel;
    public CUsuario() throws Exception {
        cargar();
    }

    public void cargar() {
//***Carga todos los datos de los procesos al Llama a la clase FProceso y la función listar proceso 
        listaUsuario = FUsuario.obtenerUsuario();
        usuarioNuevo = new Usuario();//Asigna los datos de un nuevo 
        usuarioSel = new Usuario();//Asigna los datos de un  seleccionado        
    }
    
    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(Usuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    
    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

public void ingresar_usuario() throws Exception{  
        if(!FUsuario.f_inserta_usuario(usuarioNuevo)){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Información","Ingresado correctamente");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
           FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
           cargar();
        }else{
           FacesMessage facesMsg = 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "Error","Error desconocido");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
          
            
    }
public void eliminar_usuario() throws Exception{  
        if(FUsuario.f_eliminar_usuario(usuarioNuevo.getCedulausuario())){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Información","eliminado correctamente");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            cargar();
        }else{
           FacesMessage facesMsg = 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "Error","Error desconocido");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
            
}

public void modificar_usuario() throws Exception{  
        if(FUsuario.ModificarUsuario(usuarioNuevo)){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Información","modificado correctamente");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            cargar();
        }else{
           FacesMessage facesMsg = 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                 "Error","Error desconocido");
           FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
            
}
}

