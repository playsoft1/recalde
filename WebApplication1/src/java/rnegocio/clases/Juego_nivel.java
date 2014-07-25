/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.clases;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author ALEXANDRA
 */
public class Juego_nivel {
    Integer nota;
    Character tiempo;
    BaseCalendar.Date fecha;
    private Usuario usuario;
    private Nivel nivel;
    private Juego juego;

    public Juego_nivel() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Character getTiempo() {
        return tiempo;
    }

    public void setTiempo(Character tiempo) {
        this.tiempo = tiempo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Juego_nivel(Integer nota, Character tiempo, Date fecha, Usuario usuario, Nivel nivel, Juego juego) {
        this.nota = nota;
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nivel = nivel;
        this.juego = juego;
    }
    
    
}
