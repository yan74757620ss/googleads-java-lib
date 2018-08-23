// Copyright 2018 Google LLC
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

/**
 * OptimizedPoddingAdRuleSlot.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.admanager.axis.v201808;


/**
 * Ad rule slot with optimized podding. Optimized pods are defined
 * by a
 *             {@link BaseAdRuleSlot#maxPodDuration} and a {@link BaseAdRuleSlot#maxAdsInPod},
 * and the ad
 *             server chooses the best ads for the alloted duration.
 */
public class OptimizedPoddingAdRuleSlot  extends com.google.api.ads.admanager.axis.v201808.BaseAdRuleSlot  implements java.io.Serializable {
    public OptimizedPoddingAdRuleSlot() {
    }

    public OptimizedPoddingAdRuleSlot(
           com.google.api.ads.admanager.axis.v201808.AdRuleSlotBehavior slotBehavior,
           java.lang.Long minVideoAdDuration,
           java.lang.Long maxVideoAdDuration,
           com.google.api.ads.admanager.axis.v201808.MidrollFrequencyType videoMidrollFrequencyType,
           java.lang.String videoMidrollFrequency,
           com.google.api.ads.admanager.axis.v201808.AdRuleSlotBumper bumper,
           java.lang.Long maxBumperDuration,
           java.lang.Long minPodDuration,
           java.lang.Long maxPodDuration,
           java.lang.Integer maxAdsInPod) {
        super(
            slotBehavior,
            minVideoAdDuration,
            maxVideoAdDuration,
            videoMidrollFrequencyType,
            videoMidrollFrequency,
            bumper,
            maxBumperDuration,
            minPodDuration,
            maxPodDuration,
            maxAdsInPod);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this.getClass())
            .omitNullValues()
            .add("bumper", getBumper())
            .add("maxAdsInPod", getMaxAdsInPod())
            .add("maxBumperDuration", getMaxBumperDuration())
            .add("maxPodDuration", getMaxPodDuration())
            .add("maxVideoAdDuration", getMaxVideoAdDuration())
            .add("minPodDuration", getMinPodDuration())
            .add("minVideoAdDuration", getMinVideoAdDuration())
            .add("slotBehavior", getSlotBehavior())
            .add("videoMidrollFrequency", getVideoMidrollFrequency())
            .add("videoMidrollFrequencyType", getVideoMidrollFrequencyType())
            .toString();
    }
    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OptimizedPoddingAdRuleSlot)) return false;
        OptimizedPoddingAdRuleSlot other = (OptimizedPoddingAdRuleSlot) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OptimizedPoddingAdRuleSlot.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201808", "OptimizedPoddingAdRuleSlot"));
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
