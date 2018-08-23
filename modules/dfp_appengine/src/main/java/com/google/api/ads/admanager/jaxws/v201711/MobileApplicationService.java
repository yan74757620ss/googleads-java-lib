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
@WebServiceClient(name = "MobileApplicationService", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", wsdlLocation = "https://ads.google.com/apis/ads/publisher/v201711/MobileApplicationService?wsdl")
public class MobileApplicationService
    extends Service
{

    private final static URL MOBILEAPPLICATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException MOBILEAPPLICATIONSERVICE_EXCEPTION;
    private final static QName MOBILEAPPLICATIONSERVICE_QNAME = new QName("https://www.google.com/apis/ads/publisher/v201711", "MobileApplicationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ads.google.com/apis/ads/publisher/v201711/MobileApplicationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MOBILEAPPLICATIONSERVICE_WSDL_LOCATION = url;
        MOBILEAPPLICATIONSERVICE_EXCEPTION = e;
    }

    public MobileApplicationService() {
        super(__getWsdlLocation(), MOBILEAPPLICATIONSERVICE_QNAME);
    }

    public MobileApplicationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns MobileApplicationServiceInterface
     */
    @WebEndpoint(name = "MobileApplicationServiceInterfacePort")
    public MobileApplicationServiceInterface getMobileApplicationServiceInterfacePort() {
        return super.getPort(new QName("https://www.google.com/apis/ads/publisher/v201711", "MobileApplicationServiceInterfacePort"), MobileApplicationServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MobileApplicationServiceInterface
     */
    @WebEndpoint(name = "MobileApplicationServiceInterfacePort")
    public MobileApplicationServiceInterface getMobileApplicationServiceInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("https://www.google.com/apis/ads/publisher/v201711", "MobileApplicationServiceInterfacePort"), MobileApplicationServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MOBILEAPPLICATIONSERVICE_EXCEPTION!= null) {
            throw MOBILEAPPLICATIONSERVICE_EXCEPTION;
        }
        return MOBILEAPPLICATIONSERVICE_WSDL_LOCATION;
    }

}
