package id.tech.verificareolx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.tech.POJO.OlxOutlet;
import id.tech.POJO.OlxLogin;
import id.tech.POJO.OlxJenisOutlet;
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
	Retrofit retrofit;
	Olx_DialogFragmentProgress dialogProgress ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		retrofit = new Retrofit.Builder().baseUrl(Parameter_Collections.URL_ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build();

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
					dialogProgress = new Olx_DialogFragmentProgress();
					dialogProgress.show(getSupportFragmentManager(), "");

					String cUsername = ed_Username.getText().toString();
					String cPassword = ed_Password.getText().toString();
					execute_Login(cUsername, cPassword);
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
				dialogProgress = new Olx_DialogFragmentProgress();
				dialogProgress.show(getSupportFragmentManager(), "");

				String cUsername = ed_Username.getText().toString();
				String cPassword = ed_Password.getText().toString();
				execute_Login(cUsername, cPassword);
			}
		});


		execute_getJenisOutlet();

//		Call<OlxOutlet> call = restAdapter.getOutlet();
//		call.enqueue(new Callback<OlxOutlet>() {
//			@Override
//			public void onResponse(Response<OlxOutlet> response, Retrofit retrofit) {
//
//				if(response.isSuccess()) {
////					Log.e("error =", response.message().toString());
////					Log.e("error =", response.raw().toString());
//					Log.e("data =", response.body().getData().toString());
//					Log.e("Nama outlet =", response.body().getData().get(0).getNamaOutlet().toString());
//					Toast.makeText(getApplicationContext(), retrofit.baseUrl().toString(), Toast.LENGTH_LONG).show();
//
//				}else{
//					Toast.makeText(getApplicationContext(), "Response is Faliled ", Toast.LENGTH_LONG).show();
////					Log.e("error =", response.errorBody().string().toString());
//					Log.e("error =", String.valueOf(response.code()));
//				}
//
//
//			}
//
//			@Override
//			public void onFailure(Throwable t) {
//				Toast.makeText(getApplicationContext(), "OnFailure = " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
//			}
//		});





	}

	private void execute_getJenisOutlet(){
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
					sh.edit().putString(Parameter_Collections.SH_STRINGSET_JENISOUTLET, json_jenisoutlet).commit();

				}else{
					Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onFailure(Throwable t) {
				Toast.makeText(getApplicationContext(), "Gagal mengkoneksi ke Server", Toast.LENGTH_LONG).show();
			}
		});
	}

	private void execute_Login(final String username, String password){
		Test_RestAdapter restAdapter = retrofit.create(Test_RestAdapter.class);
		Call<OlxLogin> call_login = restAdapter.login(username, password);
		call_login.enqueue(new Callback<OlxLogin>() {
			@Override
			public void onResponse(Response<OlxLogin> response, Retrofit retrofit) {
				if(response.isSuccess()){

					if(response.body().getJsonCode().equals("1")){
						String cIdPegawai = response.body().getData().getIdPegawai().toString();
						String cJabatan = response.body().getData().getJabatan().toString();

						sh.edit().putBoolean(Parameter_Collections.SH_LOGGED, true)
								.commit();
						sh.edit()
								.putString(Parameter_Collections.SH_LOG_USERNAME,
										username).commit();
						sh.edit()
								.putString(Parameter_Collections.SH_ID_PEGAWAI,
										cIdPegawai).commit();

						if (cJabatan.equals("Promotor")) {
							sh.edit()
									.putString(
											Parameter_Collections.SH_JABATAN_PEGAWAI,
											cJabatan).commit();
						} else {
							sh.edit()
									.putString(
											Parameter_Collections.SH_JABATAN_PEGAWAI,
											cJabatan).commit();
						}

						Intent load = new Intent(getApplicationContext(),
								Olx_MenuUtama_WP.class);
						startActivity(load);
						finish();
					}else{
						Toast.makeText(getApplicationContext(), "Username and Password Wrong ", Toast.LENGTH_LONG).show();
					}

					dialogProgress.dismiss();

				}else{
					Toast.makeText(getApplicationContext(), "Terjadi kesalahan dengan kode = " + response.code(), Toast.LENGTH_LONG).show();
				}

			}

			@Override
			public void onFailure(Throwable t) {
				Toast.makeText(getApplicationContext(), "Gagal mengkoneksi ke Server", Toast.LENGTH_LONG).show();
			}
		});
	}
}
