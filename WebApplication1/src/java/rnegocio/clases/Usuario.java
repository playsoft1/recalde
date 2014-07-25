/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.clases;

/**
 *
 * @author jorgeskoll
 */
public class Usuario {
    


    String cedulausuario;
    String nombreusuario;
    String clave;
    String tipo;

    public Usuario() {
    }

    public Usuario(String cedulausuario, String nombreusuario, String clave, String tipo) {
        this.cedulausuario = cedulausuario;
        this.nombreusuario = nombreusuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public String getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(String cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    
}

