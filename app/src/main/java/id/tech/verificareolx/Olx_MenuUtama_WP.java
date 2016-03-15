package id.tech.verificareolx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.tech.util.Olx_RecyclerAdapter_Slider_Empty;
import id.tech.util.Parameter_Collections;
import id.tech.util.RecyclerAdapter_Slider;

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

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Toast.makeText(getApplicationContext(), "Loading Data", Toast.LENGTH_SHORT).show();
		}

		@Override
		protected Void doInBackground(Void... params) {

//			Olx_ServiceHandlerJSON sh = new Olx_ServiceHandlerJSON();
//			JSONObject jObj = sh.json_get_pic_profile_target(id_pegawai);
			JSONObject jObj = null;

			try{
				cCode = jObj.getString(Parameter_Collections.TAG_JSON_CODE);

				if (cCode.equals("1")) {
					JSONObject jObj_Data = jObj
							.getJSONObject(Parameter_Collections.TAG_DATA);
					cNama_Pegawai = jObj_Data
							.getString(Parameter_Collections.TAG_NAMA_PEGAWAI);
					String img_no_data = jObj_Data.getString(Parameter_Collections.TAG_ARRAY_IMAGES);

					if(img_no_data.equals("no data")){
						cUrl_ImgProfilePic = "";

					}else{
						JSONArray jArray_Data = jObj_Data
								.getJSONArray(Parameter_Collections.TAG_ARRAY_IMAGES);
						for (int i = 0; i < jArray_Data.length(); i++) {
							JSONObject c = jArray_Data.getJSONObject(i);

							cUrl_ImgProfilePic = Parameter_Collections.URL_GAMBAR_THUMB
									+ c.getString(Parameter_Collections.TAG_NAMA_IMAGE);
						}
					}
					String total_visited = jObj_Data.getString(Parameter_Collections.TAG_TOTAL_VISIT_TOKO);
					String total_visited_daily = jObj_Data.getString(Parameter_Collections.TAG_TOTAL_VISIT_DAILY);
					String jumlah_target = jObj_Data.getString(Parameter_Collections.TAG_TARGET);
					String jumlah_target_daily = jObj_Data.getString(Parameter_Collections.TAG_TARGET_DAILY);

					Log.e("Total Daily = ", total_visited_daily + " / " +jumlah_target_daily);
					Log.e("Total Target = ", total_visited + " / " +jumlah_target);

					cTotalVisited = total_visited_daily + " / " +jumlah_target_daily;
					cTotalVisited_All = total_visited + " / " +jumlah_target;

					adapter_slider = new RecyclerAdapter_Slider(cNama_Pegawai, cUrl_ImgProfilePic, getApplicationContext(),
							activity, getSupportFragmentManager(),cTotalVisited, cTotalVisited_All,sp);

				}else{
					cCode = "0";
				}
			}catch (JSONException e){
				cCode = "0";

			}catch (Exception e){
				cCode = "0";
			}

			if(jObj == null){
				cCode = "0";
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);

			if(cCode.equals("1")) {
				rv_slider.setAdapter(adapter_slider);
			}else if (cCode.equals("0")) {
				Toast.makeText(getApplicationContext(), "Terjadi kesalahan, Silahkan Coba lagi", Toast.LENGTH_LONG).show();


			} else {
				Toast.makeText(getApplicationContext(), "Hubungi Admin untuk isi Target", Toast.LENGTH_LONG).show();
				finish();

			}
		}
	}
	

}
