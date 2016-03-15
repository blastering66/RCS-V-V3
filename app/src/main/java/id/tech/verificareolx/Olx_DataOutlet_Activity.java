package id.tech.verificareolx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import id.tech.util.Parameter_Collections;
import id.tech.util.RowData_JenisOutlet;

/**
 * Created by macbook on 2/3/16.
 */
public class Olx_DataOutlet_Activity extends AppCompatActivity{
    private TextView tv_kodeToko;
    private EditText ed_outlet_lokasi, ed_outlet_address,ed_outlet_email, ed_outlet_phone, ed_outlet_region;
    private Button btn;
    private Spinner spinner_jenis_outlet;
    private SharedPreferences spf;
    private String nama_outlet, lati, longi;
    private List<RowData_JenisOutlet> array_jenis_outlet;
    private String selected_id_jenis_outlet;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataoutlet_olx);
        ActionBar ac = getSupportActionBar();
        ac.setTitle("Data Outlet");
        ac.setDisplayHomeAsUpEnabled(true);

        spf = getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);
//        kode_outlet = spf.getString(Parameter_Collections.SH_KODE_OUTLET, "0");
        nama_outlet = spf.getString(Parameter_Collections.SH_NAMA_OUTLET, "0");
        lati = spf.getString(Parameter_Collections.TAG_LATITUDE_NOW, "0");
        longi = spf.getString(Parameter_Collections.TAG_LONGITUDE_NOW, "0");

        getALlView();
    }

    private void getALlView(){
        ed_outlet_lokasi = (EditText)findViewById(R.id.ed_outlet_lokasi);
        ed_outlet_lokasi.setText(nama_outlet);
        ed_outlet_region = (EditText)findViewById(R.id.ed_outlet_region);
        ed_outlet_email= (EditText)findViewById(R.id.ed_store_email);
        ed_outlet_address = (EditText)findViewById(R.id.ed_outlet_address);
        ed_outlet_phone = (EditText)findViewById(R.id.ed_outlet_phone);
        btn = (Button)findViewById(R.id.btn);

        progressBar = (ProgressBar)findViewById(R.id.pg);
        spinner_jenis_outlet = (Spinner)findViewById(R.id.spinner_jenis_outlet);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new AsyncTask_UpdateDataOutlet().execute();
            }
        });

        Gson gson = new Gson();
        String json_jenisoutlet = spf.getString(Parameter_Collections.SH_STRINGSET_JENISOUTLET, null);

        if(json_jenisoutlet == null){
            List<RowData_JenisOutlet> array_jenis_outlet = new ArrayList<RowData_JenisOutlet>();
            String json_jenisoutlet_temp ="";
            for (int i = 0; i < 4; i++) {
                String id_jenis_outlet = "";
                String nama_jenis_outlet = "";

                switch (i){
                    case 0:
                        id_jenis_outlet = "1";
                        nama_jenis_outlet = "Showroom";

                        array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        break;
                    case 1:
                        id_jenis_outlet = "2";
                        nama_jenis_outlet = "Grosir";

                        array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        break;
                    case 2:
                        id_jenis_outlet = "3";
                        nama_jenis_outlet = "Apotik";

                        array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        break;
                    case 3:
                        id_jenis_outlet = "4";
                        nama_jenis_outlet = "Babyshop";

                        array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        break;
                    case 4:
                        id_jenis_outlet = "5";
                        nama_jenis_outlet = "ToysShop";

                        array_jenis_outlet.add(new RowData_JenisOutlet(id_jenis_outlet, nama_jenis_outlet));
                        break;
                }

                Gson gson_temp = new Gson();
                json_jenisoutlet_temp = gson_temp.toJson(array_jenis_outlet);
                spf.edit().putString(Parameter_Collections.SH_STRINGSET_JENISOUTLET, json_jenisoutlet).commit();

            }

            Type type = new TypeToken<ArrayList<RowData_JenisOutlet>>() {}.getType();
            ArrayList<RowData_JenisOutlet> array_jenis_outlet_temp = gson.fromJson(json_jenisoutlet_temp, type);

            String[] nama_outlet = new String[array_jenis_outlet_temp.size()];
            for(int i=0; i < array_jenis_outlet_temp.size(); i++){
                nama_outlet[i] = array_jenis_outlet_temp.get(i).nama_jenis_outlet;
            }

            final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item,
                    nama_outlet);
            spinnerAdapter.setDropDownViewResource(R.layout.spinner_item );
            spinner_jenis_outlet.setAdapter(spinnerAdapter);

        }else{
            Type type = new TypeToken<ArrayList<RowData_JenisOutlet>>() {}.getType();
            ArrayList<RowData_JenisOutlet> array_jenis_outlet = gson.fromJson(json_jenisoutlet, type);

            String[] nama_outlet = new String[array_jenis_outlet.size()];
            for(int i=0; i < array_jenis_outlet.size(); i++){
                nama_outlet[i] = array_jenis_outlet.get(i).nama_jenis_outlet;
            }

            final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item,
                    nama_outlet);
            spinnerAdapter.setDropDownViewResource(R.layout.spinner_item );
            spinner_jenis_outlet.setAdapter(spinnerAdapter);
        }



        spinner_jenis_outlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_id_jenis_outlet = String.valueOf(position +1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected_id_jenis_outlet = "1";
            }
        });
//        new AsyncTask_GetJenis_Outlet().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
    }
}
