
package it.car2go.servant.prenotazione;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per macchina complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="macchina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="esterno" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idMacchina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="interno" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="latitudine" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="longitudine" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenotata" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serbatoio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "macchina", propOrder = {
    "codice",
    "esterno",
    "idMacchina",
    "indirizzo",
    "interno",
    "latitudine",
    "longitudine",
    "note",
    "prenotata",
    "serbatoio",
    "tipo"
})
public class Macchina {

    protected int codice;
    protected int esterno;
    protected int idMacchina;
    protected String indirizzo;
    protected int interno;
    protected float latitudine;
    protected float longitudine;
    protected String note;
    protected int prenotata;
    protected int serbatoio;
    protected String tipo;

    /**
     * Recupera il valore della proprietà codice.
     * 
     */
    public int getCodice() {
        return codice;
    }

    /**
     * Imposta il valore della proprietà codice.
     * 
     */
    public void setCodice(int value) {
        this.codice = value;
    }

    /**
     * Recupera il valore della proprietà esterno.
     * 
     */
    public int getEsterno() {
        return esterno;
    }

    /**
     * Imposta il valore della proprietà esterno.
     * 
     */
    public void setEsterno(int value) {
        this.esterno = value;
    }

    /**
     * Recupera il valore della proprietà idMacchina.
     * 
     */
    public int getIdMacchina() {
        return idMacchina;
    }

    /**
     * Imposta il valore della proprietà idMacchina.
     * 
     */
    public void setIdMacchina(int value) {
        this.idMacchina = value;
    }

    /**
     * Recupera il valore della proprietà indirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta il valore della proprietà indirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzo(String value) {
        this.indirizzo = value;
    }

    /**
     * Recupera il valore della proprietà interno.
     * 
     */
    public int getInterno() {
        return interno;
    }

    /**
     * Imposta il valore della proprietà interno.
     * 
     */
    public void setInterno(int value) {
        this.interno = value;
    }

    /**
     * Recupera il valore della proprietà latitudine.
     * 
     */
    public float getLatitudine() {
        return latitudine;
    }

    /**
     * Imposta il valore della proprietà latitudine.
     * 
     */
    public void setLatitudine(float value) {
        this.latitudine = value;
    }

    /**
     * Recupera il valore della proprietà longitudine.
     * 
     */
    public float getLongitudine() {
        return longitudine;
    }

    /**
     * Imposta il valore della proprietà longitudine.
     * 
     */
    public void setLongitudine(float value) {
        this.longitudine = value;
    }

    /**
     * Recupera il valore della proprietà note.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Imposta il valore della proprietà note.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Recupera il valore della proprietà prenotata.
     * 
     */
    public int getPrenotata() {
        return prenotata;
    }

    /**
     * Imposta il valore della proprietà prenotata.
     * 
     */
    public void setPrenotata(int value) {
        this.prenotata = value;
    }

    /**
     * Recupera il valore della proprietà serbatoio.
     * 
     */
    public int getSerbatoio() {
        return serbatoio;
    }

    /**
     * Imposta il valore della proprietà serbatoio.
     * 
     */
    public void setSerbatoio(int value) {
        this.serbatoio = value;
    }

    /**
     * Recupera il valore della proprietà tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Imposta il valore della proprietà tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
