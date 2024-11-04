
package com.sbigeneral.PINS.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Header"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Receiver" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                   &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="PartyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="TaskID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Request"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="StrTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="StrAttrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="StrValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlRootElement(name = "DocSearchRequest")
public class DocSearchRequest {

    @XmlElement(name = "Header", required = true)
    protected DocSearchRequest.Header header;
    @XmlElement(name = "Request", required = true)
    protected DocSearchRequest.Request request;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link DocSearchRequest.Header }
     *     
     */
    public DocSearchRequest.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocSearchRequest.Header }
     *     
     */
    public void setHeader(DocSearchRequest.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link DocSearchRequest.Request }
     *     
     */
    public DocSearchRequest.Request getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocSearchRequest.Request }
     *     
     */
    public void setRequest(DocSearchRequest.Request value) {
        this.request = value;
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
     *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Receiver" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="PartyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="TaskID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
        "sender",
        "receiver",
        "dateTime",
        "transactionID",
        "customerID",
        "partyID",
        "userID",
        "taskID"
    })
    public static class Header {

        @XmlElement(name = "Sender", required = true)
        protected String sender;
        @XmlElement(name = "Receiver", required = true)
        protected String receiver;
        @XmlElement(name = "DateTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateTime;
        @XmlElement(name = "TransactionID")
        protected String transactionID;
        @XmlElement(name = "CustomerID")
        protected String customerID;
        @XmlElement(name = "PartyID")
        protected String partyID;
        @XmlElement(name = "UserID", required = true)
        protected String userID;
        @XmlElement(name = "TaskID")
        protected String taskID;

        /**
         * Gets the value of the sender property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSender() {
            return sender;
        }

        /**
         * Sets the value of the sender property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSender(String value) {
            this.sender = value;
        }

        /**
         * Gets the value of the receiver property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReceiver() {
            return receiver;
        }

        /**
         * Sets the value of the receiver property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReceiver(String value) {
            this.receiver = value;
        }

        /**
         * Gets the value of the dateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateTime() {
            return dateTime;
        }

        /**
         * Sets the value of the dateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateTime(XMLGregorianCalendar value) {
            this.dateTime = value;
        }

        /**
         * Gets the value of the transactionID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionID() {
            return transactionID;
        }

        /**
         * Sets the value of the transactionID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionID(String value) {
            this.transactionID = value;
        }

        /**
         * Gets the value of the customerID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerID() {
            return customerID;
        }

        /**
         * Sets the value of the customerID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerID(String value) {
            this.customerID = value;
        }

        /**
         * Gets the value of the partyID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartyID() {
            return partyID;
        }

        /**
         * Sets the value of the partyID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartyID(String value) {
            this.partyID = value;
        }

        /**
         * Gets the value of the userID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserID() {
            return userID;
        }

        /**
         * Sets the value of the userID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserID(String value) {
            this.userID = value;
        }

        /**
         * Gets the value of the taskID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTaskID() {
            return taskID;
        }

        /**
         * Sets the value of the taskID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTaskID(String value) {
            this.taskID = value;
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
     *         &lt;element name="StrTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="StrAttrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="StrValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "strTypeName",
        "strAttrName",
        "strValue"
    })
    public static class Request {

        @XmlElement(name = "StrTypeName", required = true)
        protected String strTypeName;
        @XmlElement(name = "StrAttrName", required = true)
        protected String strAttrName;
        @XmlElement(name = "StrValue", required = true)
        protected String strValue;

        /**
         * Gets the value of the strTypeName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrTypeName() {
            return strTypeName;
        }

        /**
         * Sets the value of the strTypeName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrTypeName(String value) {
            this.strTypeName = value;
        }

        /**
         * Gets the value of the strAttrName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrAttrName() {
            return strAttrName;
        }

        /**
         * Sets the value of the strAttrName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrAttrName(String value) {
            this.strAttrName = value;
        }

        /**
         * Gets the value of the strValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrValue() {
            return strValue;
        }

        /**
         * Sets the value of the strValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrValue(String value) {
            this.strValue = value;
        }

    }

}
