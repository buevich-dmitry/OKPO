
package by.bsuir.buevich.jaxb;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Metric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Metric">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="reference-value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="maximal-value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="importance-factor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Metric", propOrder = {
    "value",
    "referenceValue",
    "maximalValue",
    "importanceFactor"
})
public class Metric extends Unmarshaller.Listener {

    protected double value;
    @XmlElement(name = "reference-value")
    protected Double referenceValue;
    @XmlElement(name = "maximal-value")
    protected Double maximalValue;
    @XmlElement(name = "importance-factor", defaultValue = "1")
    protected double importanceFactor;
    @XmlTransient
    private SubCharacteristic subCharacteristic;

    public SubCharacteristic getSubCharacteristic() {
        return subCharacteristic;
    }

    public void setSubCharacteristic(SubCharacteristic subCharacteristic) {
        this.subCharacteristic = subCharacteristic;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the value of the referenceValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReferenceValue() {
        return referenceValue;
    }

    /**
     * Sets the value of the referenceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReferenceValue(Double value) {
        this.referenceValue = value;
    }

    /**
     * Gets the value of the maximalValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaximalValue() {
        return maximalValue;
    }

    /**
     * Sets the value of the maximalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaximalValue(Double value) {
        this.maximalValue = value;
    }

    /**
     * Gets the value of the importanceFactor property.
     * 
     */
    public double getImportanceFactor() {
        return importanceFactor;
    }

    /**
     * Sets the value of the importanceFactor property.
     * 
     */
    public void setImportanceFactor(double value) {
        this.importanceFactor = value;
    }

}
