/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author yesid
 */
@Named(value = "mensajeController")
@SessionScoped
public class MensajeController implements Serializable {

    /**
     * Creates a new instance of MensajeController
     */
    public MensajeController()     
    {
    }
    
    public void mensaje(String men)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Informacion",men));
    }
    
    /*public void mensaje(String titulo, String tipo, String mensaje) {
        //RequestContext.getCurrentInstance().execute("play()");
        RequestContext.getCurrentInstance().execute(String.format("play()",titulo,tipo,mensaje));
    } */
}
