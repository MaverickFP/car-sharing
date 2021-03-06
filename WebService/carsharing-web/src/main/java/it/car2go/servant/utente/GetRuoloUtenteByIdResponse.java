
package it.car2go.servant.utente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getRuoloUtenteByIdResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getRuoloUtenteByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://utente.servant.car2go.it/}ruolo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRuoloUtenteByIdResponse", propOrder = {
    "_return"
})
public class GetRuoloUtenteByIdResponse {

    @XmlElement(name = "return")
    protected Ruolo _return;

    /**
     * Recupera il valore della proprietà return.
     * 
     * @return
     *     possible object is
     *     {@link Ruolo }
     *     
     */
    public Ruolo getReturn() {
        return _return;
    }

    /**
     * Imposta il valore della proprietà return.
     * 
     * @param value
     *     allowed object is
     *     {@link Ruolo }
     *     
     */
    public void setReturn(Ruolo value) {
        this._return = value;
    }

}
