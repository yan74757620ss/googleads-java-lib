// Copyright 2017 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.google.api.ads.admanager.jaxws.v201711;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Performs action on {@link RateCard} objects that satisfy the
 *             given {@link Statement#query}.
 *             
 *             @param rateCardAction the action to perform
 *             @param filterStatement a Publisher Query Language statement used to filter
 *             a set of rate cards.
 *             @return the result of the action performed
 *           
 * 
 * <p>Java class for performRateCardAction element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="performRateCardAction">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="rateCardAction" type="{https://www.google.com/apis/ads/publisher/v201711}RateCardAction" minOccurs="0"/>
 *           &lt;element name="filterStatement" type="{https://www.google.com/apis/ads/publisher/v201711}Statement" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rateCardAction",
    "filterStatement"
})
@XmlRootElement(name = "performRateCardAction")
public class RateCardServiceInterfaceperformRateCardAction {

    protected RateCardAction rateCardAction;
    protected Statement filterStatement;

    /**
     * Gets the value of the rateCardAction property.
     * 
     * @return
     *     possible object is
     *     {@link RateCardAction }
     *     
     */
    public RateCardAction getRateCardAction() {
        return rateCardAction;
    }

    /**
     * Sets the value of the rateCardAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateCardAction }
     *     
     */
    public void setRateCardAction(RateCardAction value) {
        this.rateCardAction = value;
    }

    /**
     * Gets the value of the filterStatement property.
     * 
     * @return
     *     possible object is
     *     {@link Statement }
     *     
     */
    public Statement getFilterStatement() {
        return filterStatement;
    }

    /**
     * Sets the value of the filterStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statement }
     *     
     */
    public void setFilterStatement(Statement value) {
        this.filterStatement = value;
    }

}
