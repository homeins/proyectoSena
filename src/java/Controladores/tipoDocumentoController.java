/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.TipoDocumento;
import Facade.TipoDocumentoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author yesid
 */
@Named(value = "tipoDocumentoController")
@SessionScoped
public class TipoDocumentoController implements Serializable {

    /**
     * Creates a new instance of TipoDocumentoController
     */
    public TipoDocumentoController() 
    {
        tipoDocumento = new TipoDocumento();
    }
    
    @EJB
    TipoDocumentoFacade tipoDocumentoFacade;
    private TipoDocumento tipoDocumento;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public void CrearTipoDocumento()
    {
        tipoDocumentoFacade.create(tipoDocumento);
        tipoDocumento = new TipoDocumento();
    }
    
    public String ModificarTipoDocumento(TipoDocumento newTipoDocumento)
    {
        tipoDocumento = newTipoDocumento;
        return "/TipoDocumento/Modificar?faces-redirect=true";
    }
    
    public String ModificarTipoDocumento()
    {
        tipoDocumentoFacade.edit(tipoDocumento);
        tipoDocumento = new TipoDocumento();
        return "/TipoDocumento/Listar?faces-redirect=true";
    }
    
    public void EliminarTipoDocumento(TipoDocumento newTipoDocumento)
    {
        tipoDocumento = newTipoDocumento;
        tipoDocumentoFacade.remove(tipoDocumento);
        tipoDocumento = new TipoDocumento();
    }
    
    public List<TipoDocumento> ListarTipoDocumento()
    {
        return tipoDocumentoFacade.findAll();
    }
}
