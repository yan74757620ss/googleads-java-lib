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


package com.google.api.ads.admanager.jaxws.v201802;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "AdExclusionRuleService", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", wsdlLocation = "https://ads.google.com/apis/ads/publisher/v201802/AdExclusionRuleService?wsdl")
public class AdExclusionRuleService
    extends Service
{

    private final static URL ADEXCLUSIONRULESERVICE_WSDL_LOCATION;
    private final static WebServiceException ADEXCLUSIONRULESERVICE_EXCEPTION;
    private final static QName ADEXCLUSIONRULESERVICE_QNAME = new QName("https://www.google.com/apis/ads/publisher/v201802", "AdExclusionRuleService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ads.google.com/apis/ads/publisher/v201802/AdExclusionRuleService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADEXCLUSIONRULESERVICE_WSDL_LOCATION = url;
        ADEXCLUSIONRULESERVICE_EXCEPTION = e;
    }

    public AdExclusionRuleService() {
        super(__getWsdlLocation(), ADEXCLUSIONRULESERVICE_QNAME);
    }

    public AdExclusionRuleService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns AdExclusionRuleServiceInterface
     */
    @WebEndpoint(name = "AdExclusionRuleServiceInterfacePort")
    public AdExclusionRuleServiceInterface getAdExclusionRuleServiceInterfacePort() {
        return super.getPort(new QName("https://www.google.com/apis/ads/publisher/v201802", "AdExclusionRuleServiceInterfacePort"), AdExclusionRuleServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdExclusionRuleServiceInterface
     */
    @WebEndpoint(name = "AdExclusionRuleServiceInterfacePort")
    public AdExclusionRuleServiceInterface getAdExclusionRuleServiceInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("https://www.google.com/apis/ads/publisher/v201802", "AdExclusionRuleServiceInterfacePort"), AdExclusionRuleServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADEXCLUSIONRULESERVICE_EXCEPTION!= null) {
            throw ADEXCLUSIONRULESERVICE_EXCEPTION;
        }
        return ADEXCLUSIONRULESERVICE_WSDL_LOCATION;
    }

}
