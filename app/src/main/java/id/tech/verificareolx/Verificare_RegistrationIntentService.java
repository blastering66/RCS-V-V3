package id.tech.verificareolx;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import org.json.JSONObject;
import id.tech.POJO.*;
import id.tech.util.*;
import java.io.IOException;

import id.tech.util.Parameter_Collections;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by RebelCreative-A1 on 16/12/2015.
 */
public class Verificare_RegistrationIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};
    SharedPreferences sp;

    public Verificare_RegistrationIntentService() {
        super(TAG);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        try {
            // [START register_for_gcm]
            // Initially this call goes out to the network to retrieve the token, subsequent calls
            // are local.
            // R.string.gcm_defaultSenderId (the Sender ID) is typically derived from google-services.json.
            // See https://developers.google.com/cloud-messaging/android/start for details on this file.
            // [START get_token]
            sp = getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);

            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(getString(R.string.GCM_SENDER_ID),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            // [END get_token]
            Log.e(TAG, "GCM Registration Token: " + token);

            // TODO: Implement this method to send any registration to your app's servers.
            boolean registered = sp.getBoolean(Parameter_Collections.SH_GCM_REGISTERED, false);
            if(!registered){
                sendRegistrationToServer(token);
            }

            // Subscribe to topic channels
            subscribeTopics(token);

            // You should store a boolean that indicates whether the generated token has been
            // sent to your server. If the boolean is false, send the token to your server,
            // otherwise your server should have already received the token.
            sharedPreferences.edit().putBoolean(Verificare_QuickstartPreferences.SENT_TOKEN_TO_SERVER, true).apply();

            // [END register_for_gcm]
        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
            sharedPreferences.edit().putBoolean(Verificare_QuickstartPreferences.SENT_TOKEN_TO_SERVER, false).apply();
        }
        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(Verificare_QuickstartPreferences.REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    /**
     * Persist registration to third-party servers.
     *
     * Modify this method to associate the user's GCM registration token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(final String token) {
        // Add custom implementation, as needed.
        TelephonyManager mngr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String imei = mngr.getDeviceId();

//        Olx_ServiceHandlerJSON sh = new Olx_ServiceHandlerJSON();
//        JSONObject jObj = sh.json_register_GCM_to_Server(token,imei);

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Parameter_Collections.URL_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Test_RestAdapter restAdapter = retrofit.create(Test_RestAdapter.class);
            Call<OlxResponseRowCount> call = restAdapter.registerGCM(Parameter_Collections.KIND_DEVICE,
                    token,"1", imei);
            call.enqueue(new Callback<OlxResponseRowCount>() {
                @Override
                public void onResponse(Response<OlxResponseRowCount> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
//                    sp.edit().putString(Parameter_Collections.SH_TOKEN_GCM, "dP3VpV9cEDc:APA91bEnlqfpZBstMk2H42uiLU0yvxR2nbvCAnA0FbNPJeOlXh9MkH9Obsh6G3HgiP42v_0ccBsEsZX0kwTBzBJ8q98jTi5NszdqdJGvI4Boq1tPtDrKe3EKvm4TrdC42BiwDtvrCGmV").commit();
                        sp.edit().putString(Parameter_Collections.SH_TOKEN_GCM, token).commit();
                        sp.edit().putString(Parameter_Collections.SH_GCM_REGISTERED, "1").commit();
                        sp.edit().putBoolean(Parameter_Collections.SH_GCM_REGISTERED, true).commit();

                        Log.e("RESULT GCM = ", "Registered = " + token);
                    } else {
                        sp.edit().putString(Parameter_Collections.SH_GCM_REGISTERED, "0").commit();
                        sp.edit().putBoolean(Parameter_Collections.SH_GCM_REGISTERED, false).commit();
                        Log.e("RESULT GCM = ", "Failed to Registered = " + token);
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    sp.edit().putString(Parameter_Collections.SH_GCM_REGISTERED, "0").commit();
                    sp.edit().putBoolean(Parameter_Collections.SH_GCM_REGISTERED, false).commit();
                    Log.e("RESULT GCM = ", "Failed to Registered");
                }
            });







    }

    /**
     * Subscribe to any GCM topics of interest, as defined by the TOPICS constant.
     *
     * @param token GCM token
     * @throws IOException if unable to reach the GCM PubSub service
     */
    // [START subscribe_topics]
    private void subscribeTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }
    // [END subscribe_topics]

}
