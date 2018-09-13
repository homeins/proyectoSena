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
 * @author stive
 */
@Named(value = "tipoDocumentoController")
@SessionScoped
public class tipoDocumentoController implements Serializable {

    /**
     * Creates a new instance of tipoDocumentoController
     */
    public tipoDocumentoController() {
        tipoDoc = new TipoDocumento();
    }
    @EJB

    TipoDocumentoFacade tipoDocFac;
    private TipoDocumento tipoDoc;

    public TipoDocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public List<TipoDocumento> listarDocumento() {
        return tipoDocFac.findAll();
    }
}
