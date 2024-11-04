
package com.sbigeneral.PINS.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Response" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Fault" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FaultCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="FaultString" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="FaultFactor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Detail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "DocSearchResponse")
public class DocSearchResponse {

    @XmlElement(name = "Response")
    protected DocSearchResponse.Response response;
    @XmlElement(name = "Fault")
    protected DocSearchResponse.Fault fault;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link DocSearchResponse.Response }
     *     
     */
    public DocSearchResponse.Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocSearchResponse.Response }
     *     
     */
    public void setResponse(DocSearchResponse.Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link DocSearchResponse.Fault }
     *     
     */
    public DocSearchResponse.Fault getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocSearchResponse.Fault }
     *     
     */
    public void setFault(DocSearchResponse.Fault value) {
        this.fault = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="FaultCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="FaultString" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="FaultFactor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Detail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "faultCode",
        "faultString",
        "faultFactor",
        "detail"
    })
    public static class Fault {

        @XmlElement(name = "FaultCode", required = true)
        protected String faultCode;
        @XmlElement(name = "FaultString", required = true)
        protected String faultString;
        @XmlElement(name = "FaultFactor", required = true)
        protected String faultFactor;
        @XmlElement(name = "Detail", required = true)
        protected String detail;

        /**
         * Gets the value of the faultCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFaultCode() {
            return faultCode;
        }

        /**
         * Sets the value of the faultCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFaultCode(String value) {
            this.faultCode = value;
        }

        /**
         * Gets the value of the faultString property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFaultString() {
            return faultString;
        }

        /**
         * Sets the value of the faultString property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFaultString(String value) {
            this.faultString = value;
        }

        /**
         * Gets the value of the faultFactor property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFaultFactor() {
            return faultFactor;
        }

        /**
         * Sets the value of the faultFactor property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFaultFactor(String value) {
            this.faultFactor = value;
        }

        /**
         * Gets the value of the detail property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetail() {
            return detail;
        }

        /**
         * Sets the value of the detail property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetail(String value) {
            this.detail = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "url"
    })
    public static class Response {

        @XmlElement(name = "URL")
        protected List<String> url;

        /**
         * Gets the value of the url property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the url property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getURL().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getURL() {
            if (url == null) {
                url = new ArrayList<String>();
            }
            return this.url;
        }

    }

}
