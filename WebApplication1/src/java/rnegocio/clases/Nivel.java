/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.clases;

/**
 *
 * @author ALEXANDRA
 */
public class Nivel {
    
    Integer id;
    Character descropcion;

    public Nivel() {
    }

    public Character getDescropcion() {
        return descropcion;
    }

    public void setDescropcion(Character descropcion) {
        this.descropcion = descropcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nivel(Integer id, Character descropcion) {
        this.id = id;
        this.descropcion = descropcion;
    }
    
    
}
