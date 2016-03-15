package id.tech.verificareolx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.tech.POJO.OlxOutlet;
import id.tech.POJO.OlxLogin;
import id.tech.util.Parameter_Collections;
import id.tech.util.Public_Functions;
import id.tech.util.RowData_JenisOutlet;
import retrofit.Call;
import retrofit.Callback;
//import retrofit.RestAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import id.tech.util.Test_RestAdapter;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
//import retrofit.RetrofitError;
//import retrofit.client.Response;

public class Olx_Login_Activity extends ActionBarActivity {
	Button btn_login;
	EditText ed_Username, ed_Password;
	SharedPreferences sh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		MultiDex.

		setContentView(R.layout.activity_login);
		getSupportActionBar().hide();

		sh = getSharedPreferences(Parameter_Collections.SH_NAME,
				Context.MODE_PRIVATE);

		ed_Username = (EditText) findViewById(R.id.ed_username);
		ed_Password = (EditText) findViewById(R.id.ed_password);

		ed_Password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(actionId == EditorInfo.IME_ACTION_DONE){
//					new Async_Login().execute();
				}
				return false;
			}
		});

		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				new Async_Login().execute();
			}
		});

		String url = "http://verificare-activation.com/api/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
		Test_RestAdapter restAdapter = retrofit.create(Test_RestAdapter.class);
		Call<OlxOutlet> call = restAdapter.getOutlet();
		call.enqueue(new Callback<OlxOutlet>() {
			@Override
			public void onResponse(Response<OlxOutlet> response, Retrofit retrofit) {

				if(response.isSuccess()) {
//					Log.e("error =", response.message().toString());
//					Log.e("error =", response.raw().toString());
					Log.e("data =", response.body().getData().toString());
					Log.e("Nama outlet =", response.body().getData().get(0).getNamaOutlet().toString());
					Toast.makeText(getApplicationContext(), retrofit.baseUrl().toString(), Toast.LENGTH_LONG).show();

				}else{
					Toast.makeText(getApplicationContext(), "Response is Faliled ", Toast.LENGTH_LONG).show();
//					Log.e("error =", response.errorBody().string().toString());
					Log.e("error =", String.valueOf(response.code()));
				}


			}

			@Override
			public void onFailure(Throwable t) {
				Toast.makeText(getApplicationContext(), "OnFailure = " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
			}
		});

//		Call<OlxLogin> call_2 = restAdapter.login();
//		call_2.enqueue(new Callback<OlxLogin>() {
//			@Override
//			public void onResponse(Response<OlxLogin> response, Retrofit retrofit) {
//				if(response.isSuccess()){
//					Log.e("raw =", response.raw().toString());
//					Log.e("data =", response.body().getData().toString());
//					}else{
//					Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
//				}
//
//			}
//
//			@Override
//			public void onFailure(Throwable t) {
//				Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
//			}
//		});

//		RestAdapter test_adapter = new RestAdapter.Builder().setEndpoint(url).build();
//
//		Test_RestAdapter restAdapter = test_adapter.create(Test_RestAdapter.class);
//		restAdapter.getOutlet(new Callback<OlxOutlet>() {
//			@Override
//			public void success(OlxOutlet olxOutlet, Response response) {
//				String namaOutlet = olxOutlet.getData().get(0).getNamaOutlet();
//				Toast.makeText(getApplicationContext(), namaOutlet, Toast.LENGTH_LONG).show();
//			}
//
//			@Override
//			public void failure(RetrofitError error) {
//				Toast.makeText(getApplicationContext(),"Erro = " + error.getMessage().toString(), Toast.LENGTH_LONG).show();
//			}
//		});

	}
}
