package id.tech.verificareolx;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.tech.POJO.OlxJenisOutlet;
import id.tech.util.Parameter_Collections;
import id.tech.util.RowData_JenisOutlet;
import id.tech.util.Test_RestAdapter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by RebelCreative-A1 on 16/12/2015.
 */
public class Verificare_Olx_ExecuteUpdateJenisOutlet_Service extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};
    SharedPreferences sp;

    public Verificare_Olx_ExecuteUpdateJenisOutlet_Service() {
        super(TAG);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            sp = getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);

            Retrofit retrofit = new Retrofit.Builder().baseUrl(Parameter_Collections.URL_ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build();
            Test_RestAdapter restAdapter = retrofit.create(Test_RestAdapter.class);
            Call<OlxJenisOutlet> call_jenisoutlet = restAdapter.getJenisOutlet();
            call_jenisoutlet.enqueue(new Callback<OlxJenisOutlet>() {
                @Override
                public void onResponse(Response<OlxJenisOutlet> response, Retrofit retrofit) {
                    if(response.isSuccess()){
                        List<RowData_JenisOutlet> array_jenis_outlet = new ArrayList<RowData_JenisOutlet>();
                        for(int i=0; i< response.body().getData().size(); i++){
                            String id_jenis_outlet = response.body().getData().get(i).getIdJenisOutlet();
                            String nama_jenis_outlet = response.body().getData().get(i).getNamaJenisOutlet();

                            Log.e("nama jenis outlet = ", nama_jenis_outlet);

                            array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        }
                        Gson gson = new Gson();
                        String json_jenisoutlet = gson.toJson(array_jenis_outlet);
                        sp.edit().putString(Parameter_Collections.SH_STRINGSET_JENISOUTLET, json_jenisoutlet).commit();

                    }else{
                        //Gagal
                        Log.e("Error Service = ", "gagal update Jenis OUtlet Service");

                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e("Error Service = ", "Gagal Konek Ke Server");

                }
            });

        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);

        }
    }

}
