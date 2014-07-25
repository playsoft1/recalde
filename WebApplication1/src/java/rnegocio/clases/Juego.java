/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.clases;

/**
 *
 * @author ALEXANDRA
 */
public class Juego {

    Integer id;
    Character descripcion;

    public Juego() {
    }

    public Character getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Character descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Juego(Integer id, Character descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    
}
