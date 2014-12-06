
package it.car2go.servant.prenotazione;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per prenotazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="prenotazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="distanza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idMacchina" type="{http://prenotazione.servant.car2go.it/}macchina" minOccurs="0"/>
 *         &lt;element name="idPrenotazione" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUtente" type="{http://prenotazione.servant.car2go.it/}utente" minOccurs="0"/>
 *         &lt;element name="tempo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prenotazione", propOrder = {
    "data",
    "distanza",
    "idMacchina",
    "idPrenotazione",
    "idUtente",
    "tempo"
})
public class Prenotazione {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar data;
    protected int distanza;
    protected Macchina idMacchina;
    protected int idPrenotazione;
    protected Utente idUtente;
    protected int tempo;

    /**
     * Recupera il valore della proprietà data.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getData() {
        return data;
    }

    /**
     * Imposta il valore della proprietà data.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setData(XMLGregorianCalendar value) {
        this.data = value;
    }

    /**
     * Recupera il valore della proprietà distanza.
     * 
     */
    public int getDistanza() {
        return distanza;
    }

    /**
     * Imposta il valore della proprietà distanza.
     * 
     */
    public void setDistanza(int value) {
        this.distanza = value;
    }

    /**
     * Recupera il valore della proprietà idMacchina.
     * 
     * @return
     *     possible object is
     *     {@link Macchina }
     *     
     */
    public Macchina getIdMacchina() {
        return idMacchina;
    }

    /**
     * Imposta il valore della proprietà idMacchina.
     * 
     * @param value
     *     allowed object is
     *     {@link Macchina }
     *     
     */
    public void setIdMacchina(Macchina value) {
        this.idMacchina = value;
    }

    /**
     * Recupera il valore della proprietà idPrenotazione.
     * 
     */
    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    /**
     * Imposta il valore della proprietà idPrenotazione.
     * 
     */
    public void setIdPrenotazione(int value) {
        this.idPrenotazione = value;
    }

    /**
     * Recupera il valore della proprietà idUtente.
     * 
     * @return
     *     possible object is
     *     {@link Utente }
     *     
     */
    public Utente getIdUtente() {
        return idUtente;
    }

    /**
     * Imposta il valore della proprietà idUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link Utente }
     *     
     */
    public void setIdUtente(Utente value) {
        this.idUtente = value;
    }

    /**
     * Recupera il valore della proprietà tempo.
     * 
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Imposta il valore della proprietà tempo.
     * 
     */
    public void setTempo(int value) {
        this.tempo = value;
    }

}
