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

package admanager.axis.v201802.customfieldservice;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.v201802.ApiError;
import com.google.api.ads.admanager.axis.v201802.ApiException;
import com.google.api.ads.admanager.axis.v201802.CustomField;
import com.google.api.ads.admanager.axis.v201802.CustomFieldDataType;
import com.google.api.ads.admanager.axis.v201802.CustomFieldEntityType;
import com.google.api.ads.admanager.axis.v201802.CustomFieldOption;
import com.google.api.ads.admanager.axis.v201802.CustomFieldServiceInterface;
import com.google.api.ads.admanager.axis.v201802.CustomFieldVisibility;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * This example creates custom fields and options. To determine which custom
 * fields exist, run GetAllCustomFields.java.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class CreateCustomFieldsAndOptions {

  /**
   * Runs the example.
   *
   * @param adManagerServices the services factory.
   * @param session the session.
   * @throws ApiException if the API request failed with one or more service errors.
   * @throws RemoteException if the API request failed due to other errors.
   */
  public static void runExample(AdManagerServices adManagerServices, AdManagerSession session)
      throws RemoteException {
    // Get the CustomFieldService.
    CustomFieldServiceInterface customFieldService =
        adManagerServices.get(session, CustomFieldServiceInterface.class);

    // Create a number custom field that can be used for an external ID in the
    // API.
    CustomField numberCustomField = new CustomField();
    numberCustomField.setName("External ID #" + new Random().nextInt(Integer.MAX_VALUE));
    numberCustomField.setEntityType(CustomFieldEntityType.LINE_ITEM);
    numberCustomField.setDataType(CustomFieldDataType.NUMBER);
    numberCustomField.setVisibility(CustomFieldVisibility.API_ONLY);

    // Create a drop-down custom field that can be used in the UI.
    CustomField dropDownCustomField = new CustomField();
    dropDownCustomField.setName(
        "Internal approval status #" + new Random().nextInt(Integer.MAX_VALUE));
    dropDownCustomField.setEntityType(CustomFieldEntityType.LINE_ITEM);
    dropDownCustomField.setDataType(CustomFieldDataType.DROP_DOWN);
    dropDownCustomField.setVisibility(CustomFieldVisibility.FULL);

    // Create the custom fields on the server.
    CustomField[] customFields = customFieldService.createCustomFields(
        new CustomField[] {numberCustomField, dropDownCustomField});

    for (CustomField createdCustomField : customFields) {
      System.out.printf("A custom field with ID %d and name '%s' was created.%n",
          createdCustomField.getId(), createdCustomField.getName());
    }

    // Set the created drop-down custom field.
    dropDownCustomField = customFields[1];

    // Create approved custom field option.
    CustomFieldOption approvedCustomFieldOption = new CustomFieldOption();
    approvedCustomFieldOption.setDisplayName("APPROVED");
    approvedCustomFieldOption.setCustomFieldId(dropDownCustomField.getId());

    // Create unapproved custom field option.
    CustomFieldOption unapprovedCustomFieldOption = new CustomFieldOption();
    unapprovedCustomFieldOption.setDisplayName("UNAPPROVED");
    unapprovedCustomFieldOption.setCustomFieldId(dropDownCustomField.getId());

    // Create the custom field options on the server.
    CustomFieldOption[] customFieldOptions = customFieldService.createCustomFieldOptions(
        new CustomFieldOption[] {approvedCustomFieldOption, unapprovedCustomFieldOption});

    for (CustomFieldOption createdCustomFieldOption : customFieldOptions) {
      System.out.printf(
          "A custom field option with ID %d and display name '%s' was created.%n",
          createdCustomFieldOption.getId(), createdCustomFieldOption.getDisplayName());
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

    try {
      runExample(adManagerServices, session);
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
