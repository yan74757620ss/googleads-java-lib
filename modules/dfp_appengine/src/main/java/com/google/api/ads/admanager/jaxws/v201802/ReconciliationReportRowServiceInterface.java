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
 *       Provides methods for retrieving and updating the {@link ReconciliationReportRow} objects.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ReconciliationReportRowServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReconciliationReportRowServiceInterface {


    /**
     * 
     *         Gets a {@link ReconciliationReportRowPage} of {@link ReconciliationReportRow} objects that
     *         satisfy the given {@link Statement#query}. The following fields are supported for filtering:
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code reconciliationReportId}</td>
     *         <td>{@link ReconciliationReportRow#reconciliationReportId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code advertiserId}</td>
     *         <td>{@link ReconciliationReportRow#advertiserId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code orderId}</td>
     *         <td>{@link ReconciliationReportRow#orderId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code lineItemId}</td>
     *         <td>{@link ReconciliationReportRow#lineItemId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code proposalLineItemId}</td>
     *         <td>{@link ReconciliationReportRow#proposalLineItemId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code creativeId}</td>
     *         <td>{@link ReconciliationReportRow#creativeId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code lineItemCostType}</td>
     *         <td>{@link ReconciliationReportRow#lineItemCostType}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code dfpClicks}</td>
     *         <td>{@link ReconciliationReportRow#dfpClicks}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code dfpImpressions}</td>
     *         <td>{@link ReconciliationReportRow#dfpImpressions}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code dfpLineItemDays}</td>
     *         <td>{@link ReconciliationReportRow#dfpLineItemDays}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code thirdPartyClicks}</td>
     *         <td>{@link ReconciliationReportRow#thirdPartyClicks}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code thirdPartyImpressions}</td>
     *         <td>{@link ReconciliationReportRow#thirdPartyImpressions}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code thirdPartyLineItemDays}</td>
     *         <td>{@link ReconciliationReportRow#thirdPartyLineItemDays}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code manualClicks}</td>
     *         <td>{@link ReconciliationReportRow#manualClicks}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code manualImpressions}</td>
     *         <td>{@link ReconciliationReportRow#manualImpressions}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code manualLineItemDays}</td>
     *         <td>{@link ReconciliationReportRow#manualLineItemDays}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code reconciledClicks}</td>
     *         <td>{@link ReconciliationReportRow#reconciledClicks}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code reconciledImpressions}</td>
     *         <td>{@link ReconciliationReportRow#reconciledImpressions}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code reconciledLineItemDays}</td>
     *         <td>{@link ReconciliationReportRow#reconciledLineItemDays}</td>
     *         </tr>
     *         </table>
     *         
     *         The {@code reconciliationReportId} field is required and can only be combined with an
     *         {@code AND} to other conditions. Furthermore, the results may only belong to
     *         one {@link ReconciliationReport}.
     *         
     *         @param filterStatement a Publisher Query Language statement used to
     *         filter a set of reconciliation report rows
     *         @return the reconciliation report rows that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRowPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
    @RequestWrapper(localName = "getReconciliationReportRowsByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRowServiceInterfacegetReconciliationReportRowsByStatement")
    @ResponseWrapper(localName = "getReconciliationReportRowsByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRowServiceInterfacegetReconciliationReportRowsByStatementResponse")
    public ReconciliationReportRowPage getReconciliationReportRowsByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates a list of {@link ReconciliationReportRow} which belong to same
     *         {@link ReconciliationReport}.
     *         
     *         @param reconciliationReportRows a list of reconciliation report rows to update
     *         @return the updated reconciliation report rows
     *       
     * 
     * @param reconciliationReportRows
     * @return
     *     returns java.util.List<com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRow>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
    @RequestWrapper(localName = "updateReconciliationReportRows", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRowServiceInterfaceupdateReconciliationReportRows")
    @ResponseWrapper(localName = "updateReconciliationReportRowsResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportRowServiceInterfaceupdateReconciliationReportRowsResponse")
    public List<ReconciliationReportRow> updateReconciliationReportRows(
        @WebParam(name = "reconciliationReportRows", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
        List<ReconciliationReportRow> reconciliationReportRows)
        throws ApiException_Exception
    ;

}
