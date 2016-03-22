package id.tech.verificareolx;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.Calendar;

import id.tech.util.Parameter_Collections;

public class Olx_UpdateJenisOutlet_Service extends Service{
	Intent myIntent;
	PendingIntent alarmIntent;
	AlarmManager alarams;
	SharedPreferences sp;
	Intent activate;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sp =  getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);
}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		myIntent = intent;
		
		Calendar c = Calendar.getInstance();
		
		alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 113, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);
		
		alarams = (AlarmManager)getSystemService(ALARM_SERVICE);
		alarams.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
				(1000 * 60 * 60)  * 23, alarmIntent);
		Log.e("Service Started", "Update JenisOutlet");

		Intent intent_gcm = new Intent(this, Verificare_Olx_ExecuteUpdateJenisOutlet_Service.class);
		startService(intent_gcm);
		
		return Service.START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
