// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package admanager.axis.v201805.inventoryservice;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.beust.jcommander.Parameter;
import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.utils.v201805.StatementBuilder;
import com.google.api.ads.admanager.axis.v201805.AdUnit;
import com.google.api.ads.admanager.axis.v201805.AdUnitPage;
import com.google.api.ads.admanager.axis.v201805.ApiError;
import com.google.api.ads.admanager.axis.v201805.ApiException;
import com.google.api.ads.admanager.axis.v201805.InventoryServiceInterface;
import com.google.api.ads.admanager.axis.v201805.UpdateResult;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.admanager.lib.utils.examples.ArgumentNames;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.ads.common.lib.utils.examples.CodeSampleParams;
import com.google.api.client.auth.oauth2.Credential;
import java.rmi.RemoteException;

/**
 * This example archives ad units underneath a parent ad unit, as well as the
 * parent ad unit. To create ad units, run CreateAdUnits.java. To determine
 * which ad units exist, run GetAllAdUnits.java.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class ArchiveAdUnits {

  private static class ArchiveAdUnitsParams extends CodeSampleParams {
    @Parameter(names = ArgumentNames.PARENT_AD_UNIT_ID, required = true,
        description = "The ad unit ID to archive underneath.")
    private String parentAdUnitId;
  }

  /**
   * Runs the example.
   *
   * @param adManagerServices the services factory.
   * @param session the session.
   * @param parentAdUnitId the ad unit ID to archive underneath.
   * @throws ApiException if the API request failed with one or more service errors.
   * @throws RemoteException if the API request failed due to other errors.
   */
  public static void runExample(
      AdManagerServices adManagerServices, AdManagerSession session, String parentAdUnitId)
      throws RemoteException {
    // Get the InventoryService.
    InventoryServiceInterface inventoryService =
        adManagerServices.get(session, InventoryServiceInterface.class);

    // Create a statement to select ad units under the parent ad unit and the
    // parent ad unit.
    StatementBuilder statementBuilder = new StatementBuilder()
        .where("parentId = :parentId or id = :parentId")
        .orderBy("id ASC")
        .limit(StatementBuilder.SUGGESTED_PAGE_LIMIT)
        .withBindVariableValue("parentId", parentAdUnitId);

    // Default for total result set size.
    int totalResultSetSize = 0;

    do {
      // Get ad units by statement.
      AdUnitPage page = inventoryService.getAdUnitsByStatement(statementBuilder.toStatement());

      if (page.getResults() != null) {
        totalResultSetSize = page.getTotalResultSetSize();
        int i = page.getStartIndex();
        for (AdUnit adUnit : page.getResults()) {
          System.out.printf(
              "%d) Ad unit with ID '%s' and name '%s' will be archived.%n", i++,
              adUnit.getId(), adUnit.getName());
        }
      }

      statementBuilder.increaseOffsetBy(StatementBuilder.SUGGESTED_PAGE_LIMIT);
    } while (statementBuilder.getOffset() < totalResultSetSize);

    System.out.printf("Number of ad units to be archived: %d%n", totalResultSetSize);

    if (totalResultSetSize > 0) {
      // Remove limit and offset from statement.
      statementBuilder.removeLimitAndOffset();

      // Create action.
      com.google.api.ads.admanager.axis.v201805.ArchiveAdUnits action =
          new com.google.api.ads.admanager.axis.v201805.ArchiveAdUnits();

      // Perform action.
      UpdateResult result =
          inventoryService.performAdUnitAction(action, statementBuilder.toStatement());

      if (result != null && result.getNumChanges() > 0) {
        System.out.printf("Number of ad units archived: %d%n", result.getNumChanges());
      } else {
        System.out.println("No ad units were archived.");
      }
    }
  }

  public static void main(String[] args) {
    AdManagerSession session;
    try {
      // Generate a refreshable OAuth2 credential.
      Credential oAuth2Credential =
          new OfflineCredentials.Builder()
              .forApi(Api.AD_MANAGER)
              .fromFile()
              .build()
              .generateCredential();

      // Construct a AdManagerSession.
      session =
          new AdManagerSession.Builder().fromFile().withOAuth2Credential(oAuth2Credential).build();
    } catch (ConfigurationLoadException cle) {
      System.err.printf(
          "Failed to load configuration from the %s file. Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, cle);
      return;
    } catch (ValidationException ve) {
      System.err.printf(
          "Invalid configuration in the %s file. Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, ve);
      return;
    } catch (OAuthException oe) {
      System.err.printf(
          "Failed to create OAuth credentials. Check OAuth settings in the %s file. "
              + "Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, oe);
      return;
    }

    AdManagerServices adManagerServices = new AdManagerServices();

    ArchiveAdUnitsParams params = new ArchiveAdUnitsParams();
    if (!params.parseArguments(args)) {
      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.parentAdUnitId = "INSERT_PARENT_AD_UNIT_ID_HERE";
    }

    try {
      runExample(adManagerServices, session, params.parentAdUnitId);
    } catch (ApiException apiException) {
      // ApiException is the base class for most exceptions thrown by an API request. Instances
      // of this exception have a message and a collection of ApiErrors that indicate the
      // type and underlying cause of the exception. Every exception object in the admanager.axis
      // packages will return a meaningful value from toString
      //
      // ApiException extends RemoteException, so this catch block must appear before the
      // catch block for RemoteException.
      System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
      if (apiException.getErrors() != null) {
        int i = 0;
        for (ApiError apiError : apiException.getErrors()) {
          System.err.printf("  Error %d: %s%n", i++, apiError);
        }
      }
    } catch (RemoteException re) {
      System.err.printf("Request failed unexpectedly due to RemoteException: %s%n", re);
    }
  }
}
