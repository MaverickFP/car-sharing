
package it.car2go.servant.prenotazione;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.car2go.servant.prenotazione package. 
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

    private final static QName _AddPrenotazione_QNAME = new QName("http://prenotazione.servant.car2go.it/", "addPrenotazione");
    private final static QName _GetPrenotazioniByUserId_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazioniByUserId");
    private final static QName _GetPrenotazione_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazione");
    private final static QName _AddPrenotazioneResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "addPrenotazioneResponse");
    private final static QName _GetPrenotazioni_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazioni");
    private final static QName _UpdatePrenotazioneResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "updatePrenotazioneResponse");
    private final static QName _DelPrenotazioneResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "delPrenotazioneResponse");
    private final static QName _GetPrenotazioniResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazioniResponse");
    private final static QName _UpdatePrenotazione_QNAME = new QName("http://prenotazione.servant.car2go.it/", "updatePrenotazione");
    private final static QName _GetLastIdPrenotazioneResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getLastIdPrenotazioneResponse");
    private final static QName _GetPrenotazioneResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazioneResponse");
    private final static QName _DelPrenotazione_QNAME = new QName("http://prenotazione.servant.car2go.it/", "delPrenotazione");
    private final static QName _GetLastIdPrenotazione_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getLastIdPrenotazione");
    private final static QName _GetPrenotazioniByUserIdResponse_QNAME = new QName("http://prenotazione.servant.car2go.it/", "getPrenotazioniByUserIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.car2go.servant.prenotazione
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPrenotazioniResponse }
     * 
     */
    public GetPrenotazioniResponse createGetPrenotazioniResponse() {
        return new GetPrenotazioniResponse();
    }

    /**
     * Create an instance of {@link UpdatePrenotazione }
     * 
     */
    public UpdatePrenotazione createUpdatePrenotazione() {
        return new UpdatePrenotazione();
    }

    /**
     * Create an instance of {@link DelPrenotazioneResponse }
     * 
     */
    public DelPrenotazioneResponse createDelPrenotazioneResponse() {
        return new DelPrenotazioneResponse();
    }

    /**
     * Create an instance of {@link GetPrenotazioni }
     * 
     */
    public GetPrenotazioni createGetPrenotazioni() {
        return new GetPrenotazioni();
    }

    /**
     * Create an instance of {@link UpdatePrenotazioneResponse }
     * 
     */
    public UpdatePrenotazioneResponse createUpdatePrenotazioneResponse() {
        return new UpdatePrenotazioneResponse();
    }

    /**
     * Create an instance of {@link GetLastIdPrenotazione }
     * 
     */
    public GetLastIdPrenotazione createGetLastIdPrenotazione() {
        return new GetLastIdPrenotazione();
    }

    /**
     * Create an instance of {@link GetPrenotazioniByUserIdResponse }
     * 
     */
    public GetPrenotazioniByUserIdResponse createGetPrenotazioniByUserIdResponse() {
        return new GetPrenotazioniByUserIdResponse();
    }

    /**
     * Create an instance of {@link DelPrenotazione }
     * 
     */
    public DelPrenotazione createDelPrenotazione() {
        return new DelPrenotazione();
    }

    /**
     * Create an instance of {@link GetLastIdPrenotazioneResponse }
     * 
     */
    public GetLastIdPrenotazioneResponse createGetLastIdPrenotazioneResponse() {
        return new GetLastIdPrenotazioneResponse();
    }

    /**
     * Create an instance of {@link GetPrenotazioneResponse }
     * 
     */
    public GetPrenotazioneResponse createGetPrenotazioneResponse() {
        return new GetPrenotazioneResponse();
    }

    /**
     * Create an instance of {@link AddPrenotazione }
     * 
     */
    public AddPrenotazione createAddPrenotazione() {
        return new AddPrenotazione();
    }

    /**
     * Create an instance of {@link AddPrenotazioneResponse }
     * 
     */
    public AddPrenotazioneResponse createAddPrenotazioneResponse() {
        return new AddPrenotazioneResponse();
    }

    /**
     * Create an instance of {@link GetPrenotazione }
     * 
     */
    public GetPrenotazione createGetPrenotazione() {
        return new GetPrenotazione();
    }

    /**
     * Create an instance of {@link GetPrenotazioniByUserId }
     * 
     */
    public GetPrenotazioniByUserId createGetPrenotazioniByUserId() {
        return new GetPrenotazioniByUserId();
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
     * Create an instance of {@link Prenotazione }
     * 
     */
    public Prenotazione createPrenotazione() {
        return new Prenotazione();
    }

    /**
     * Create an instance of {@link Macchina }
     * 
     */
    public Macchina createMacchina() {
        return new Macchina();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPrenotazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "addPrenotazione")
    public JAXBElement<AddPrenotazione> createAddPrenotazione(AddPrenotazione value) {
        return new JAXBElement<AddPrenotazione>(_AddPrenotazione_QNAME, AddPrenotazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazioniByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazioniByUserId")
    public JAXBElement<GetPrenotazioniByUserId> createGetPrenotazioniByUserId(GetPrenotazioniByUserId value) {
        return new JAXBElement<GetPrenotazioniByUserId>(_GetPrenotazioniByUserId_QNAME, GetPrenotazioniByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazione")
    public JAXBElement<GetPrenotazione> createGetPrenotazione(GetPrenotazione value) {
        return new JAXBElement<GetPrenotazione>(_GetPrenotazione_QNAME, GetPrenotazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPrenotazioneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "addPrenotazioneResponse")
    public JAXBElement<AddPrenotazioneResponse> createAddPrenotazioneResponse(AddPrenotazioneResponse value) {
        return new JAXBElement<AddPrenotazioneResponse>(_AddPrenotazioneResponse_QNAME, AddPrenotazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazioni }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazioni")
    public JAXBElement<GetPrenotazioni> createGetPrenotazioni(GetPrenotazioni value) {
        return new JAXBElement<GetPrenotazioni>(_GetPrenotazioni_QNAME, GetPrenotazioni.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePrenotazioneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "updatePrenotazioneResponse")
    public JAXBElement<UpdatePrenotazioneResponse> createUpdatePrenotazioneResponse(UpdatePrenotazioneResponse value) {
        return new JAXBElement<UpdatePrenotazioneResponse>(_UpdatePrenotazioneResponse_QNAME, UpdatePrenotazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelPrenotazioneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "delPrenotazioneResponse")
    public JAXBElement<DelPrenotazioneResponse> createDelPrenotazioneResponse(DelPrenotazioneResponse value) {
        return new JAXBElement<DelPrenotazioneResponse>(_DelPrenotazioneResponse_QNAME, DelPrenotazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazioniResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazioniResponse")
    public JAXBElement<GetPrenotazioniResponse> createGetPrenotazioniResponse(GetPrenotazioniResponse value) {
        return new JAXBElement<GetPrenotazioniResponse>(_GetPrenotazioniResponse_QNAME, GetPrenotazioniResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePrenotazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "updatePrenotazione")
    public JAXBElement<UpdatePrenotazione> createUpdatePrenotazione(UpdatePrenotazione value) {
        return new JAXBElement<UpdatePrenotazione>(_UpdatePrenotazione_QNAME, UpdatePrenotazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastIdPrenotazioneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getLastIdPrenotazioneResponse")
    public JAXBElement<GetLastIdPrenotazioneResponse> createGetLastIdPrenotazioneResponse(GetLastIdPrenotazioneResponse value) {
        return new JAXBElement<GetLastIdPrenotazioneResponse>(_GetLastIdPrenotazioneResponse_QNAME, GetLastIdPrenotazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazioneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazioneResponse")
    public JAXBElement<GetPrenotazioneResponse> createGetPrenotazioneResponse(GetPrenotazioneResponse value) {
        return new JAXBElement<GetPrenotazioneResponse>(_GetPrenotazioneResponse_QNAME, GetPrenotazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelPrenotazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "delPrenotazione")
    public JAXBElement<DelPrenotazione> createDelPrenotazione(DelPrenotazione value) {
        return new JAXBElement<DelPrenotazione>(_DelPrenotazione_QNAME, DelPrenotazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastIdPrenotazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getLastIdPrenotazione")
    public JAXBElement<GetLastIdPrenotazione> createGetLastIdPrenotazione(GetLastIdPrenotazione value) {
        return new JAXBElement<GetLastIdPrenotazione>(_GetLastIdPrenotazione_QNAME, GetLastIdPrenotazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrenotazioniByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prenotazione.servant.car2go.it/", name = "getPrenotazioniByUserIdResponse")
    public JAXBElement<GetPrenotazioniByUserIdResponse> createGetPrenotazioniByUserIdResponse(GetPrenotazioniByUserIdResponse value) {
        return new JAXBElement<GetPrenotazioniByUserIdResponse>(_GetPrenotazioniByUserIdResponse_QNAME, GetPrenotazioniByUserIdResponse.class, null, value);
    }

}
