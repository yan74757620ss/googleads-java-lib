// Copyright 2016 Google Inc. All Rights Reserved.
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

package adwords.axis.v201609.campaignmanagement;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.utils.v201609.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201609.cm.ApiError;
import com.google.api.ads.adwords.axis.v201609.cm.Operator;
import com.google.api.ads.adwords.axis.v201609.cm.Selector;
import com.google.api.ads.adwords.axis.v201609.cm.Trial;
import com.google.api.ads.adwords.axis.v201609.cm.TrialAsyncError;
import com.google.api.ads.adwords.axis.v201609.cm.TrialAsyncErrorPage;
import com.google.api.ads.adwords.axis.v201609.cm.TrialAsyncErrorServiceInterface;
import com.google.api.ads.adwords.axis.v201609.cm.TrialOperation;
import com.google.api.ads.adwords.axis.v201609.cm.TrialServiceInterface;
import com.google.api.ads.adwords.axis.v201609.cm.TrialStatus;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.selectorfields.v201609.cm.TrialAsyncErrorField;
import com.google.api.ads.adwords.lib.selectorfields.v201609.cm.TrialField;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.client.auth.oauth2.Credential;

/**
 * This example illustrates how to create a trial and wait for it to complete.
 *
 * <p>See the Campaign Drafts and Experiments guide for more information:
 * https://developers.google.com/adwords/api/docs/guides/campaign-drafts-experiments
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class AddTrial {

  /**
   * Maximum number of {@code TrialService.get} calls to make to query the progress of trial
   * creation.
   */
  private static final int MAX_POLL_ATTEMPTS = 6;

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.ADWORDS)
        .fromFile()
        .build()
        .generateCredential();

    // Construct an AdWordsSession.
    AdWordsSession session = new AdWordsSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    // Replace with valid values of your account.
    long draftId = Long.parseLong("INSERT_DRAFT_ID_HERE");
    long baseCampaignId = Long.parseLong("INSERT_BASE_CAMPAIGN_ID_HERE");

    AdWordsServices adWordsServices = new AdWordsServices();

    runExample(adWordsServices, session, draftId, baseCampaignId);
  }

  public static void runExample(
      AdWordsServices adWordsServices, AdWordsSession session, long draftId, long baseCampaignId)
      throws Exception {
    // Get the TrialService.
    TrialServiceInterface trialService = adWordsServices.get(session, TrialServiceInterface.class);

    Trial trial = new Trial();
    trial.setDraftId(draftId);
    trial.setBaseCampaignId(baseCampaignId);
    trial.setName("Test Trial #" + System.currentTimeMillis());
    trial.setTrafficSplitPercent(50);

    TrialOperation trialOperation = new TrialOperation();
    trialOperation.setOperator(Operator.ADD);
    trialOperation.setOperand(trial);

    long trialId = trialService.mutate(new TrialOperation[] {trialOperation}).getValue(0).getId();

    // Since creating a trial is asynchronous, we have to poll it to wait for it to finish.
    Selector trialSelector =
        new SelectorBuilder()
            .fields(
                TrialField.Id,
                TrialField.Status,
                TrialField.BaseCampaignId,
                TrialField.TrialCampaignId)
            .equalsId(trialId)
            .build();

    trial = null;
    boolean isPending = true;
    int pollAttempts = 0;
    do {
      long sleepSeconds = (long) Math.scalb(30d, pollAttempts);
      System.out.printf("Sleeping for %d seconds.%n", sleepSeconds);
      Thread.sleep(sleepSeconds * 1000);
      trial = trialService.get(trialSelector).getEntries(0);

      System.out.printf("Trial ID %d has status '%s'.%n", trial.getId(), trial.getStatus());
      pollAttempts++;
      isPending = TrialStatus.CREATING.equals(trial.getStatus());
    } while (isPending && pollAttempts < MAX_POLL_ATTEMPTS);

    if (TrialStatus.ACTIVE.equals(trial.getStatus())) {
      // The trial creation was successful.
      System.out.printf(
          "Trial created with ID %d and trial campaign ID %d.%n",
          trial.getId(),
          trial.getTrialCampaignId());
    } else if (TrialStatus.CREATION_FAILED.equals(trial.getStatus())) {
      // The trial creation failed, and errors can be fetched from the TrialAsyncErrorService.
      Selector errorsSelector =
          new SelectorBuilder()
              .fields(TrialAsyncErrorField.TrialId, TrialAsyncErrorField.AsyncError)
              .equals(TrialAsyncErrorField.TrialId, trial.getId().toString())
              .build();

      TrialAsyncErrorServiceInterface trialAsyncErrorService =
          adWordsServices.get(session, TrialAsyncErrorServiceInterface.class);
      TrialAsyncErrorPage trialAsyncErrorPage = trialAsyncErrorService.get(errorsSelector);
      if (trialAsyncErrorPage.getEntries() == null
          || trialAsyncErrorPage.getEntries().length == 0) {
        System.out.printf(
            "Could not retrieve errors for trial ID %d for draft ID %d.%n", trial.getId(), draftId);
      } else {
        System.out.printf(
            "Could not create trial ID %d for draft ID %d due to the following errors:%n",
            trial.getId(),
            draftId);
        int i = 0;
        for (TrialAsyncError error : trialAsyncErrorPage.getEntries()) {
          ApiError asyncError = error.getAsyncError();
          System.out.printf(
              "Error #%d: errorType='%s', errorString='%s', trigger='%s', fieldPath='%s'%n",
              i++,
              asyncError.getApiErrorType(),
              asyncError.getErrorString(),
              asyncError.getTrigger(),
              asyncError.getFieldPath());
        }
      }
    } else {
      // Most likely, the trial is still being created. You can continue polling,
      // but we have limited the number of attempts in the example.
      System.out.printf(
          "Timed out waiting to create trial from draft ID %d with base campaign ID %d.%n",
          draftId,
          baseCampaignId);
    }
  }
}