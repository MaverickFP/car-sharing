
package it.car2go.servant.ruolo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.car2go.servant.ruolo package. 
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

    private final static QName _CancellaRuolo_QNAME = new QName("http://ruolo.servant.car2go.it/", "cancellaRuolo");
    private final static QName _GetRuoloByIdResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoloByIdResponse");
    private final static QName _GetRuoloByNomeResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoloByNomeResponse");
    private final static QName _GetRuoliResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoliResponse");
    private final static QName _GetRuoloByNome_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoloByNome");
    private final static QName _AggiornaRuolo_QNAME = new QName("http://ruolo.servant.car2go.it/", "aggiornaRuolo");
    private final static QName _GetRuoloById_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoloById");
    private final static QName _SalvaRuoloResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "salvaRuoloResponse");
    private final static QName _AggiornaRuoloResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "aggiornaRuoloResponse");
    private final static QName _CancellaRuoloResponse_QNAME = new QName("http://ruolo.servant.car2go.it/", "cancellaRuoloResponse");
    private final static QName _SalvaRuolo_QNAME = new QName("http://ruolo.servant.car2go.it/", "salvaRuolo");
    private final static QName _GetRuoli_QNAME = new QName("http://ruolo.servant.car2go.it/", "getRuoli");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.car2go.servant.ruolo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRuoloById }
     * 
     */
    public GetRuoloById createGetRuoloById() {
        return new GetRuoloById();
    }

    /**
     * Create an instance of {@link SalvaRuoloResponse }
     * 
     */
    public SalvaRuoloResponse createSalvaRuoloResponse() {
        return new SalvaRuoloResponse();
    }

    /**
     * Create an instance of {@link GetRuoloByNome }
     * 
     */
    public GetRuoloByNome createGetRuoloByNome() {
        return new GetRuoloByNome();
    }

    /**
     * Create an instance of {@link AggiornaRuolo }
     * 
     */
    public AggiornaRuolo createAggiornaRuolo() {
        return new AggiornaRuolo();
    }

    /**
     * Create an instance of {@link GetRuoliResponse }
     * 
     */
    public GetRuoliResponse createGetRuoliResponse() {
        return new GetRuoliResponse();
    }

    /**
     * Create an instance of {@link CancellaRuolo }
     * 
     */
    public CancellaRuolo createCancellaRuolo() {
        return new CancellaRuolo();
    }

    /**
     * Create an instance of {@link GetRuoloByIdResponse }
     * 
     */
    public GetRuoloByIdResponse createGetRuoloByIdResponse() {
        return new GetRuoloByIdResponse();
    }

    /**
     * Create an instance of {@link GetRuoloByNomeResponse }
     * 
     */
    public GetRuoloByNomeResponse createGetRuoloByNomeResponse() {
        return new GetRuoloByNomeResponse();
    }

    /**
     * Create an instance of {@link GetRuoli }
     * 
     */
    public GetRuoli createGetRuoli() {
        return new GetRuoli();
    }

    /**
     * Create an instance of {@link CancellaRuoloResponse }
     * 
     */
    public CancellaRuoloResponse createCancellaRuoloResponse() {
        return new CancellaRuoloResponse();
    }

    /**
     * Create an instance of {@link SalvaRuolo }
     * 
     */
    public SalvaRuolo createSalvaRuolo() {
        return new SalvaRuolo();
    }

    /**
     * Create an instance of {@link AggiornaRuoloResponse }
     * 
     */
    public AggiornaRuoloResponse createAggiornaRuoloResponse() {
        return new AggiornaRuoloResponse();
    }

    /**
     * Create an instance of {@link Ruolo }
     * 
     */
    public Ruolo createRuolo() {
        return new Ruolo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaRuolo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "cancellaRuolo")
    public JAXBElement<CancellaRuolo> createCancellaRuolo(CancellaRuolo value) {
        return new JAXBElement<CancellaRuolo>(_CancellaRuolo_QNAME, CancellaRuolo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoloByIdResponse")
    public JAXBElement<GetRuoloByIdResponse> createGetRuoloByIdResponse(GetRuoloByIdResponse value) {
        return new JAXBElement<GetRuoloByIdResponse>(_GetRuoloByIdResponse_QNAME, GetRuoloByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloByNomeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoloByNomeResponse")
    public JAXBElement<GetRuoloByNomeResponse> createGetRuoloByNomeResponse(GetRuoloByNomeResponse value) {
        return new JAXBElement<GetRuoloByNomeResponse>(_GetRuoloByNomeResponse_QNAME, GetRuoloByNomeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoliResponse")
    public JAXBElement<GetRuoliResponse> createGetRuoliResponse(GetRuoliResponse value) {
        return new JAXBElement<GetRuoliResponse>(_GetRuoliResponse_QNAME, GetRuoliResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloByNome }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoloByNome")
    public JAXBElement<GetRuoloByNome> createGetRuoloByNome(GetRuoloByNome value) {
        return new JAXBElement<GetRuoloByNome>(_GetRuoloByNome_QNAME, GetRuoloByNome.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaRuolo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "aggiornaRuolo")
    public JAXBElement<AggiornaRuolo> createAggiornaRuolo(AggiornaRuolo value) {
        return new JAXBElement<AggiornaRuolo>(_AggiornaRuolo_QNAME, AggiornaRuolo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoloById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoloById")
    public JAXBElement<GetRuoloById> createGetRuoloById(GetRuoloById value) {
        return new JAXBElement<GetRuoloById>(_GetRuoloById_QNAME, GetRuoloById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvaRuoloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "salvaRuoloResponse")
    public JAXBElement<SalvaRuoloResponse> createSalvaRuoloResponse(SalvaRuoloResponse value) {
        return new JAXBElement<SalvaRuoloResponse>(_SalvaRuoloResponse_QNAME, SalvaRuoloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaRuoloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "aggiornaRuoloResponse")
    public JAXBElement<AggiornaRuoloResponse> createAggiornaRuoloResponse(AggiornaRuoloResponse value) {
        return new JAXBElement<AggiornaRuoloResponse>(_AggiornaRuoloResponse_QNAME, AggiornaRuoloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaRuoloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "cancellaRuoloResponse")
    public JAXBElement<CancellaRuoloResponse> createCancellaRuoloResponse(CancellaRuoloResponse value) {
        return new JAXBElement<CancellaRuoloResponse>(_CancellaRuoloResponse_QNAME, CancellaRuoloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvaRuolo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "salvaRuolo")
    public JAXBElement<SalvaRuolo> createSalvaRuolo(SalvaRuolo value) {
        return new JAXBElement<SalvaRuolo>(_SalvaRuolo_QNAME, SalvaRuolo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRuoli }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ruolo.servant.car2go.it/", name = "getRuoli")
    public JAXBElement<GetRuoli> createGetRuoli(GetRuoli value) {
        return new JAXBElement<GetRuoli>(_GetRuoli_QNAME, GetRuoli.class, null, value);
    }

}
