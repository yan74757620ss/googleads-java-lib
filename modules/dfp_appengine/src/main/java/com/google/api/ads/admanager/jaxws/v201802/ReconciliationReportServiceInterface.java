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
 *       Provides methods for retrieving, submitting and reverting the {@link ReconciliationReport}
 *       objects.
 *       
 *       <p>A {@link ReconciliationReport} is a group of {@link ReconciliationReportRow} objects.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ReconciliationReportServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReconciliationReportServiceInterface {


    /**
     * 
     *         Gets an {@link ReconciliationReportPage} of {@link ReconciliationReport} objects that satisfy
     *         the given {@link Statement#query}. The following fields are supported for filtering.
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code id}</td>
     *         <td>{@link ReconciliationReport#id}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code status}</td>
     *         <td>{@link ReconciliationReport#status}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code startDate}</td>
     *         <td>{@link ReconciliationReport#startDate}</td>
     *         </tr>
     *         </table>
     *         
     *         @param filterStatement a Publisher Query Language statement used to
     *         filter a set of reconciliation reports
     *         @return the reconciliation reports that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
    @RequestWrapper(localName = "getReconciliationReportsByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportServiceInterfacegetReconciliationReportsByStatement")
    @ResponseWrapper(localName = "getReconciliationReportsByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportServiceInterfacegetReconciliationReportsByStatementResponse")
    public ReconciliationReportPage getReconciliationReportsByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates the specified {@link ReconciliationReport} objects.
     *         
     *         @param reconciliationReports the reconciliation reports to update
     *         @return the updated reconciliation reports
     *         @throws ApiException
     *       
     * 
     * @param reconciliationReports
     * @return
     *     returns java.util.List<com.google.api.ads.admanager.jaxws.v201802.ReconciliationReport>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
    @RequestWrapper(localName = "updateReconciliationReports", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportServiceInterfaceupdateReconciliationReports")
    @ResponseWrapper(localName = "updateReconciliationReportsResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802", className = "com.google.api.ads.admanager.jaxws.v201802.ReconciliationReportServiceInterfaceupdateReconciliationReportsResponse")
    public List<ReconciliationReport> updateReconciliationReports(
        @WebParam(name = "reconciliationReports", targetNamespace = "https://www.google.com/apis/ads/publisher/v201802")
        List<ReconciliationReport> reconciliationReports)
        throws ApiException_Exception
    ;

}
