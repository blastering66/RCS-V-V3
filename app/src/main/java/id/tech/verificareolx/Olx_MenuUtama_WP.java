package id.tech.verificareolx;

import id.tech.POJO.OlxProfile;
import id.tech.util.Test_RestAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.tech.util.Olx_RecyclerAdapter_Slider_Empty;
import id.tech.util.Parameter_Collections;
import id.tech.util.RecyclerAdapter_Slider;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class Olx_MenuUtama_WP extends ActionBarActivity {
	RecyclerView rv, rv_slider;
	RecyclerView.Adapter adapter, adapter_slider;
	RecyclerView.LayoutManager layoutManager, layoutManager_slider;
	RecyclerView.ItemDecoration decoration;
	ImageView img_logout;
	private SharedPreferences sp;

	ActionBarDrawerToggle mDrawerToggle;
	DrawerLayout Drawer;
	
	Bundle currentState;
	Activity activity;
	private String id_pegawai;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_menuutama_wp);
		setContentView(R.layout.main);

		activity = this;

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		ActionBar ac = getSupportActionBar();
		ac.hide();

		sp = getSharedPreferences(Parameter_Collections.SH_NAME,
				Context.MODE_PRIVATE);
		id_pegawai = sp.getString(Parameter_Collections.SH_ID_PEGAWAI, "");

		rv_slider = (RecyclerView) findViewById(R.id.slider_content);
		Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

		layoutManager_slider = new LinearLayoutManager(this);
		rv_slider.setLayoutManager(layoutManager_slider);

		if (savedInstanceState == null) {
			currentState = savedInstanceState;
			FragmentManager fm = getSupportFragmentManager();
			Fragment fragment = new Olx_Fragment_MenuUtama();
			fm.beginTransaction().replace(R.id.frame_container, fragment)
					.commit();

//			new AsyncTask_LoadProfile().execute();
			adapter_slider = new Olx_RecyclerAdapter_Slider_Empty();
			rv_slider.setAdapter(adapter_slider);

			new AsyncTask_LoadProfile_Target().execute();

		}

		Drawer.openDrawer(Gravity.START);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (currentState == null) {
//			new AsyncTask_LoadProfile().execute();
			adapter_slider.notifyDataSetChanged();
			rv_slider.setAdapter(adapter_slider);
		}else{
		}

//		Drawer.openDrawer(Gravity.START);
	}

	private class AsyncTask_LoadProfile_Target extends AsyncTask<Void,Void,Void>{
		String result, cCode, cNama_Pegawai, cUrl_ImgProfilePic, cTotalVisited, cTotalVisited_All;
		Call<OlxProfile> call_profile;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Toast.makeText(getApplicationContext(), "Loading Data", Toast.LENGTH_SHORT).show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			Retrofit retrofit = new Retrofit.Builder().baseUrl(Parameter_Collections.URL_ENDPOINT).
					addConverterFactory(GsonConverterFactory.create()).build();
			Test_RestAdapter adapterRetrofit = retrofit.create(Test_RestAdapter.class);
			call_profile = adapterRetrofit.getProfile(id_pegawai);


			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);

			call_profile.enqueue(new Callback<OlxProfile>() {
				@Override
				public void onResponse(Response<OlxProfile> response, Retrofit retrofit) {


					if(response.isSuccess()){
						String cCode = response.body().getJsonCode().toString();
						if(cCode.equals("1")) {
							String cNama_Pegawai = response.body().getData().getNamaPegawai();
							String cUrl_ImgProfilePic = Parameter_Collections.URL_GAMBAR_THUMB +
									response.body().getData().getImages().get(0).getNamaImage();
							String total_visited = response.body().getData().getTotalVisit();
							String total_visited_daily = response.body().getData().getTotalVisitDaily();
							String jumlah_target = response.body().getData().getJumlahTarget();
							String jumlah_target_daily = response.body().getData().getTargetPerhari();
							cTotalVisited = total_visited_daily + " / " +jumlah_target_daily;
							cTotalVisited_All = total_visited + " / " +jumlah_target;

							adapter_slider = new RecyclerAdapter_Slider(cNama_Pegawai, cUrl_ImgProfilePic, getApplicationContext(),
									activity, getSupportFragmentManager(),cTotalVisited, cTotalVisited_All,sp);

							rv_slider.setAdapter(adapter_slider);

						}else if (cCode.equals("0")) {
							adapter_slider = new Olx_RecyclerAdapter_Slider_Empty();
							rv_slider.setAdapter(adapter_slider);


						} else {
							Toast.makeText(getApplicationContext(), "Hubungi Admin untuk isi Target", Toast.LENGTH_LONG).show();
							finish();

						}

						rv_slider.setAdapter(adapter_slider);
					}else{
						adapter_slider = new Olx_RecyclerAdapter_Slider_Empty();
						rv_slider.setAdapter(adapter_slider);
						Toast.makeText(getApplicationContext(), response.errorBody() +", Silahkan Coba lagi", Toast.LENGTH_LONG).show();
					}

				}

				@Override
				public void onFailure(Throwable t) {
					Log.e("Failure = ", t.getCause().toString());
					Log.e("Failure = ", t.getLocalizedMessage().toString());
					Log.e("Failure = ", t.getMessage().toString());
					adapter_slider = new Olx_RecyclerAdapter_Slider_Empty();
					rv_slider.setAdapter(adapter_slider);
					Toast.makeText(getApplicationContext(), "Gagal koneksi ke Server", Toast.LENGTH_LONG).show();
				}
			});


		}
	}


	@Override
	protected void onPause() {
		super.onPause();

	}
}
