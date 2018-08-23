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

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       Provides operations for retrieving information related to the publisher's
 *       networks. This service can be used to obtain the list of all networks
 *       that the current login has access to, or to obtain information about a
 *       specific network.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "NetworkServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NetworkServiceInterface {


    /**
     * 
     *         Returns the list of {@link Network} objects to which the current login has
     *         access.
     *         <p>
     *         Intended to be used without a network code in the SOAP header when the
     *         login may have more than one network associated with it.
     *         </p>
     *         
     *         @return the networks to which the current login has access
     *       
     * 
     * @return
     *     returns java.util.List<com.google.api.ads.admanager.jaxws.v201711.Network>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
    @RequestWrapper(localName = "getAllNetworks", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacegetAllNetworks")
    @ResponseWrapper(localName = "getAllNetworksResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacegetAllNetworksResponse")
    public List<Network> getAllNetworks()
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns the current network for which requests are being made.
     *         
     *         @return the network for which the user is currently making the request
     *       
     * 
     * @return
     *     returns com.google.api.ads.admanager.jaxws.v201711.Network
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
    @RequestWrapper(localName = "getCurrentNetwork", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacegetCurrentNetwork")
    @ResponseWrapper(localName = "getCurrentNetworkResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacegetCurrentNetworkResponse")
    public Network getCurrentNetwork()
        throws ApiException_Exception
    ;

    /**
     * 
     *         Creates a new blank network for testing purposes using the current login.
     *         <p>
     *         Each login(i.e. email address) can only have one test network. Data from
     *         any of your existing networks will not be transferred to the new test network.
     *         Once the test network is created, the test network can be used in the API
     *         by supplying the {@link Network#networkCode} in the SOAP header or by
     *         logging into the Ad Manager UI.
     *         <p>
     *         Test networks are limited in the following ways:
     *         <ul>
     *         <li>Test networks cannot serve ads.</li>
     *         <li>Because test networks cannot serve ads, reports will always come
     *         back without data.</li>
     *         <li>Since forecasting requires serving history, forecast service results
     *         will be faked. See {@link ForecastService} for more info.</li>
     *         <li>Test networks are, by default, Ad Manager networks and don't have any features
     *         from Ad Manager 360. To have additional features turned on, please contact your
     *         account manager. </li>
     *         <li>Test networks are limited to 10,000 objects per entity type.</li>
     *         </ul>
     *         </p>
     *       
     * 
     * @return
     *     returns com.google.api.ads.admanager.jaxws.v201711.Network
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
    @RequestWrapper(localName = "makeTestNetwork", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacemakeTestNetwork")
    @ResponseWrapper(localName = "makeTestNetworkResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfacemakeTestNetworkResponse")
    public Network makeTestNetwork()
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates the specified network. Currently, only the network display name can
     *         be updated.
     *         
     *         @param network the network that needs to be updated
     *         @return the updated network
     *       
     * 
     * @param network
     * @return
     *     returns com.google.api.ads.admanager.jaxws.v201711.Network
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
    @RequestWrapper(localName = "updateNetwork", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfaceupdateNetwork")
    @ResponseWrapper(localName = "updateNetworkResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711", className = "com.google.api.ads.admanager.jaxws.v201711.NetworkServiceInterfaceupdateNetworkResponse")
    public Network updateNetwork(
        @WebParam(name = "network", targetNamespace = "https://www.google.com/apis/ads/publisher/v201711")
        Network network)
        throws ApiException_Exception
    ;

}
