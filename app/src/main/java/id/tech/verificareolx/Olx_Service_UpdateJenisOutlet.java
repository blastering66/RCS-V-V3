package id.tech.verificareolx;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import id.tech.util.Parameter_Collections;
import id.tech.util.RowData_JenisOutlet;

/**
 * Created by RebelCreative-A1 on 04/03/2016.
 */
public class Olx_Service_UpdateJenisOutlet extends Service {
    Intent myIntent;
    PendingIntent alarmIntent;
    AlarmManager alarams;
    SharedPreferences spf;
    String cContactId;
    Intent activate;

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        spf =  getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);

//		new AsyncTas_RegistedGCM().execute();

    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                Log.e(TAG, "Error");
            } else {
                Log.i(TAG, "This device is not supported.");

            }
            return false;
        }
        return true;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        myIntent = intent;

        Calendar c = Calendar.getInstance();

        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 113, activate,PendingIntent.FLAG_CANCEL_CURRENT);

        alarams = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarams.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                (1000 * 60 * 60) * 23, alarmIntent);
        Log.e("Service Started", "update Jenis Outlet");

//        new AsyncTas_RegistedGCM().execute();

       return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}

