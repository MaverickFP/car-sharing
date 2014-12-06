
package it.car2go.servant.utente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.car2go.servant.utente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUtenteByUsernamePasswordResponse_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteByUsernamePasswordResponse");
    private final static QName _GetUtenteByUsernameResponse_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteByUsernameResponse");
    private final static QName _AggiornaUtente_QNAME = new QName("http://utente.servant.car2go.it/", "aggiornaUtente");
    private final static QName _GetUtenti_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenti");
    private final static QName _ElencoUtentiSemplici_QNAME = new QName("http://utente.servant.car2go.it/", "elencoUtentiSemplici");
    private final static QName _GetRuoloUtenteById_QNAME = new QName("http://utente.servant.car2go.it/", "getRuoloUtenteById");
    private final static QName _GetUtentiResponse_QNAME = new QName("http://utente.servant.car2go.it/", "getUtentiResponse");
    private final static QName _CancellaUtente_QNAME = new QName("http://utente.servant.car2go.it/", "cancellaUtente");
    private final static QName _ElencoUtentiSempliciResponse_QNAME = new QName("http://utente.servant.car2go.it/", "elencoUtentiSempliciResponse");
    private final static QName _GetUtenteByIdResponse_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteByIdResponse");
    private final static QName _SalvaUtente_QNAME = new QName("http://utente.servant.car2go.it/", "salvaUtente");
    private final static QName _VerificaPresenzaUsernameResponse_QNAME = new QName("http://utente.servant.car2go.it/", "verificaPresenzaUsernameResponse");
    private final static QName _SalvaUtenteResponse_QNAME = new QName("http://utente.servant.car2go.it/", "salvaUtenteResponse");
    private final static QName _VerificaPresenzaUsername_QNAME = new QName("http://utente.servant.car2go.it/", "verificaPresenzaUsername");
    private final static QName _CancellaUtenteResponse_QNAME = new QName("http://utente.servant.car2go.it/", "cancellaUtenteResponse");
    private final static QName _GetUtenteByUsernamePassword_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteByUsernamePassword");
    private final static QName _GetUtenteByUsername_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteByUsername");
    private final static QName _AggiornaUtenteResponse_QNAME = new QName("http://utente.servant.car2go.it/", "aggiornaUtenteResponse");
    private final static QName _GetRuoloUtenteByIdResponse_QNAME = new QName("http://utente.servant.car2go.it/", "getRuoloUtenteByIdResponse");
    private final static QName _GetUtenteById_QNAME = new QName("http://utente.servant.car2go.it/", "getUtenteById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.car2go.servant.utente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AggiornaUtente }
     * 
     */
    public AggiornaUtente createAggiornaUtente() {
        return new AggiornaUtente();
    }

    /**
     * Create an instance of {@link GetUtenti }
     * 
     */
    public GetUtenti createGetUtenti() {
        return new GetUtenti();
    }

    /**
     * Create an instance of {@link GetUtenteByUsernamePasswordResponse }
     * 
     */
    public GetUtenteByUsernamePasswordResponse createGetUtenteByUsernamePasswordResponse() {
        return new GetUtenteByUsernamePasswordResponse();
    }

    /**
     * Create an instance of {@link GetUtenteByUsernameResponse }
     * 
     */
    public GetUtenteByUsernameResponse createGetUtenteByUsernameResponse() {
        return new GetUtenteByUsernameResponse();
    }

    /**
     * Create an instance of {@link CancellaUtente }
     * 
     */
    public CancellaUtente createCancellaUtente() {
        return new CancellaUtente();
    }

    /**
     * Create an instance of {@link ElencoUtentiSempliciResponse }
     * 
     */
    public ElencoUtentiSempliciResponse createElencoUtentiSempliciResponse() {
        return new ElencoUtentiSempliciResponse();
    }

    /**
     * Create an instance of {@link GetUtenteByIdResponse }
     * 
     */
    public GetUtenteByIdResponse createGetUtenteByIdResponse() {
        return new GetUtenteByIdResponse();
    }

    /**
     * Create an instance of {@link ElencoUtentiSemplici }
     * 
     */
    public ElencoUtentiSemplici createElencoUtentiSemplici() {
        return new ElencoUtentiSemplici();
    }

    /**
     * Create an instance of {@link GetRuoloUtenteById }
     * 
     */
    public GetRuoloUtenteById createGetRuoloUtenteById() {
        return new GetRuoloUtenteById();
    }

    /**
     * Create an instance of {@link GetUtentiResponse }
     * 
     */
    public GetUtentiResponse createGetUtentiResponse() {
        return new GetUtentiResponse();
    }

    /**
     * Create an instance of {@link VerificaPresenzaUsername }
     * 
     */
    public VerificaPresenzaUsername createVerificaPresenzaUsername() {
        return new VerificaPresenzaUsername();
    }

    /**
     * Create an instance of {@link SalvaUtenteResponse }
     * 
     */
    public SalvaUtenteResponse createSalvaUtenteResponse() {
        return new SalvaUtenteResponse();
    }

    /**
     * Create an instance of {@link SalvaUtente }
     * 
     */
    public SalvaUtente createSalvaUtente() {
        return new SalvaUtente();
    }

    /**
     * Create an instance of {@link VerificaPresenzaUsernameResponse }
     * 
     */
    public VerificaPresenzaUsernameResponse createVerificaPresenzaUsernameResponse() {
        return new VerificaPresenzaUsernameResponse();
    }

    /**
     * Create an instance of {@link GetUtenteById }
     * 
     */
    public GetUtenteById createGetUtenteById() {
        return new GetUtenteById();
    }

    /**
     * Create an instance of {@link AggiornaUtenteResponse }
     * 
     */
    public AggiornaUtenteResponse createAggiornaUtenteResponse() {
        return new AggiornaUtenteResponse();
    }

    /**
     * Create an instance of {@link GetRuoloUtenteByIdResponse }
     * 
     */
    public GetRuoloUtenteByIdResponse createGetRuoloUtenteByIdResponse() {
        return new GetRuoloUtenteByIdResponse();
    }

    /**
     * Create an instance of {@link CancellaUtenteResponse }
     * 
     */
    public CancellaUtenteResponse createCancellaUtenteResponse() {
        return new CancellaUtenteResponse();
    }

    /**
     * Create an instance of {@link GetUtenteByUsernamePassword }
     * 
     */
    public GetUtenteByUsernamePassword createGetUtenteByUsernamePassword() {
        return new GetUtenteByUsernamePassword();
    }

    /**
     * Create an instance of {@link GetUtenteByUsername }
     * 
     */
    public GetUtenteByUsername createGetUtenteByUsername() {
        return new GetUtenteByUsername();
    }

    /**
     * Create an instance of {@link Utente }
     * 
     */
    public Utente createUtente() {
        return new Utente();
    }

    /**
     * Create an instance of {@link Ruolo }
     * 
     */
    public Ruolo createRuolo() {
        return new Ruolo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteByUsernamePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteByUsernamePasswordResponse")
    public JAXBElement<GetUtenteByUsernamePasswordResponse> createGetUtenteByUsernamePasswordResponse(GetUtenteByUsernamePasswordResponse value) {
        return new JAXBElement<GetUtenteByUsernamePasswordResponse>(_GetUtenteByUsernamePasswordResponse_QNAME, GetUtenteByUsernamePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteByUsernameResponse")
    public JAXBElement<GetUtenteByUsernameResponse> createGetUtenteByUsernameResponse(GetUtenteByUsernameResponse value) {
        return new JAXBElement<GetUtenteByUsernameResponse>(_GetUtenteByUsernameResponse_QNAME, GetUtenteByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaUtente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "aggiornaUtente")
    public JAXBElement<AggiornaUtente> createAggiornaUtente(AggiornaUtente value) {
        return new JAXBElement<AggiornaUtente>(_AggiornaUtente_QNAME, AggiornaUtente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenti")
    public JAXBElement<GetUtenti> createGetUtenti(GetUtenti value) {
        return new JAXBElement<GetUtenti>(_GetUtenti_QNAME, GetUtenti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElencoUtentiSemplici }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "elencoUtentiSemplici")
    public JAXBElement<ElencoUtentiSemplici> createElencoUtentiSemplici(ElencoUtentiSemplici value) {
        return new JAXBElement<ElencoUtentiSemplici>(_ElencoUtentiSemplici_QNAME, ElencoUtentiSemplici.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloUtenteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getRuoloUtenteById")
    public JAXBElement<GetRuoloUtenteById> createGetRuoloUtenteById(GetRuoloUtenteById value) {
        return new JAXBElement<GetRuoloUtenteById>(_GetRuoloUtenteById_QNAME, GetRuoloUtenteById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtentiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtentiResponse")
    public JAXBElement<GetUtentiResponse> createGetUtentiResponse(GetUtentiResponse value) {
        return new JAXBElement<GetUtentiResponse>(_GetUtentiResponse_QNAME, GetUtentiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaUtente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "cancellaUtente")
    public JAXBElement<CancellaUtente> createCancellaUtente(CancellaUtente value) {
        return new JAXBElement<CancellaUtente>(_CancellaUtente_QNAME, CancellaUtente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElencoUtentiSempliciResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "elencoUtentiSempliciResponse")
    public JAXBElement<ElencoUtentiSempliciResponse> createElencoUtentiSempliciResponse(ElencoUtentiSempliciResponse value) {
        return new JAXBElement<ElencoUtentiSempliciResponse>(_ElencoUtentiSempliciResponse_QNAME, ElencoUtentiSempliciResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteByIdResponse")
    public JAXBElement<GetUtenteByIdResponse> createGetUtenteByIdResponse(GetUtenteByIdResponse value) {
        return new JAXBElement<GetUtenteByIdResponse>(_GetUtenteByIdResponse_QNAME, GetUtenteByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvaUtente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "salvaUtente")
    public JAXBElement<SalvaUtente> createSalvaUtente(SalvaUtente value) {
        return new JAXBElement<SalvaUtente>(_SalvaUtente_QNAME, SalvaUtente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerificaPresenzaUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "verificaPresenzaUsernameResponse")
    public JAXBElement<VerificaPresenzaUsernameResponse> createVerificaPresenzaUsernameResponse(VerificaPresenzaUsernameResponse value) {
        return new JAXBElement<VerificaPresenzaUsernameResponse>(_VerificaPresenzaUsernameResponse_QNAME, VerificaPresenzaUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvaUtenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "salvaUtenteResponse")
    public JAXBElement<SalvaUtenteResponse> createSalvaUtenteResponse(SalvaUtenteResponse value) {
        return new JAXBElement<SalvaUtenteResponse>(_SalvaUtenteResponse_QNAME, SalvaUtenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerificaPresenzaUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "verificaPresenzaUsername")
    public JAXBElement<VerificaPresenzaUsername> createVerificaPresenzaUsername(VerificaPresenzaUsername value) {
        return new JAXBElement<VerificaPresenzaUsername>(_VerificaPresenzaUsername_QNAME, VerificaPresenzaUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaUtenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "cancellaUtenteResponse")
    public JAXBElement<CancellaUtenteResponse> createCancellaUtenteResponse(CancellaUtenteResponse value) {
        return new JAXBElement<CancellaUtenteResponse>(_CancellaUtenteResponse_QNAME, CancellaUtenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteByUsernamePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteByUsernamePassword")
    public JAXBElement<GetUtenteByUsernamePassword> createGetUtenteByUsernamePassword(GetUtenteByUsernamePassword value) {
        return new JAXBElement<GetUtenteByUsernamePassword>(_GetUtenteByUsernamePassword_QNAME, GetUtenteByUsernamePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteByUsername")
    public JAXBElement<GetUtenteByUsername> createGetUtenteByUsername(GetUtenteByUsername value) {
        return new JAXBElement<GetUtenteByUsername>(_GetUtenteByUsername_QNAME, GetUtenteByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaUtenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "aggiornaUtenteResponse")
    public JAXBElement<AggiornaUtenteResponse> createAggiornaUtenteResponse(AggiornaUtenteResponse value) {
        return new JAXBElement<AggiornaUtenteResponse>(_AggiornaUtenteResponse_QNAME, AggiornaUtenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloUtenteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getRuoloUtenteByIdResponse")
    public JAXBElement<GetRuoloUtenteByIdResponse> createGetRuoloUtenteByIdResponse(GetRuoloUtenteByIdResponse value) {
        return new JAXBElement<GetRuoloUtenteByIdResponse>(_GetRuoloUtenteByIdResponse_QNAME, GetRuoloUtenteByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtenteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://utente.servant.car2go.it/", name = "getUtenteById")
    public JAXBElement<GetUtenteById> createGetUtenteById(GetUtenteById value) {
        return new JAXBElement<GetUtenteById>(_GetUtenteById_QNAME, GetUtenteById.class, null, value);
    }

}
