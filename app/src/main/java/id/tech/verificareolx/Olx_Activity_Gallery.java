package id.tech.verificareolx;

/**
 * Created by macbook on 2/29/16.
 */
import id.tech.POJO.OlxResponseRowCount;
import id.tech.util.Test_RestAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import id.tech.util.Parameter_Collections;
import id.tech.util.Public_Functions;
import id.tech.util.RowDataGallery;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Olx_Activity_Gallery extends AppCompatActivity {
    Button btn;
    String mUrl_Img_00, mUrl_Img_01, mUrl_Img_02, mUrl_Img_03, mUrl_Img_04, mUrl_Img_05, mUrl_Img_06;
    ImageView imgview_00, imgview_01, imgview_02, imgview_03,imgview_04,imgview_05, imgview_06;
    public static int CODE_UPLOAD = 111;
    HorizontalScrollView horizontalScroll;
    EditText ed_ket;
    SharedPreferences spf;
    private String id_pegawai;
    List<RowDataGallery> data_selected;

    String url_file00, url_file01, url_file02, url_file03, url_file04, url_file05, url_file06;
    File sourceFile00,sourceFile01, sourceFile02, sourceFile03,sourceFile04, sourceFile05, sourceFile06;
    RequestBody body00,body01,body02,body03,body04,body05, body06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//		getSupportActionBar().setTitle("Visit Activity");
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Input Photo Activity </font>"));

        spf = getSharedPreferences(Parameter_Collections.SH_NAME, Context.MODE_PRIVATE);
        id_pegawai = spf.getString(Parameter_Collections.SH_ID_PEGAWAI, "");

        mUrl_Img_00 = null;
        mUrl_Img_01 = null;
        mUrl_Img_02 = null;
        mUrl_Img_03 = null;
        mUrl_Img_04 = null;
        mUrl_Img_05 = null;
        mUrl_Img_06 = null;

        getAllView();
    }

    private void getAllView() {
        horizontalScroll = (HorizontalScrollView) findViewById(R.id.wrapper_horizontalview);
        imgview_00 = (ImageView) findViewById(R.id.img_00);
        imgview_01 = (ImageView) findViewById(R.id.img_01);
        imgview_02 = (ImageView) findViewById(R.id.img_02);
        imgview_03 = (ImageView) findViewById(R.id.img_03);
        imgview_04 = (ImageView) findViewById(R.id.img_04);
        imgview_05 = (ImageView) findViewById(R.id.img_05);
        imgview_06 = (ImageView) findViewById(R.id.img_06);

        ed_ket= (EditText)findViewById(R.id.ed_ket);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent upload = new Intent(getApplicationContext(),
//                        Olx_UploadImageDialog.class);
//                startActivityForResult(upload, CODE_UPLOAD);

                Intent upload = new Intent(getApplicationContext(),
                        Olx_GalleryView.class);
                startActivityForResult(upload, CODE_UPLOAD);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.upload_photo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Public_Functions.delete_IssuePhoto();
                Toast.makeText(getApplicationContext(), "Canceled. Images deleted", Toast.LENGTH_LONG).show();
                finish();
                overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
                break;

            case R.id.action_upload_photo:

                new AsyncTask_SubmitGallery().execute();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Public_Functions.delete_IssuePhoto();
        Toast.makeText(getApplicationContext(), "Canceled. Images deleted", Toast.LENGTH_LONG).show();
        finish();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
    }

    private class AsyncTask_SubmitGallery extends AsyncTask<Void,Void,Void>{
        Olx_DialogFragmentProgress dialogProgress;
        String cKet, cRowCount, cMessage;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialogProgress = new Olx_DialogFragmentProgress();
            dialogProgress.show(getSupportFragmentManager(), "");
            cKet = ed_ket.getText().toString();
        }

        @Override
        protected Void doInBackground(Void... params) {
            if (Public_Functions.isNetworkAvailable(getApplicationContext())) {
//				boolean b = true;
//				if (b) {
                if(data_selected != null){
//                        new Async_SubmitGallery().execute();


                    for(int i=0; i < data_selected.size(); i++){
                        if(i == 0){
                            url_file00 = data_selected.get(i).path;
                        }else if(i == 1){
                            url_file01 = data_selected.get(i).path;
                        }else if(i == 2){
                            url_file02 = data_selected.get(i).path;
                        }else if(i == 3){
                            url_file03 = data_selected.get(i).path;
                        }else if(i == 4){
                            url_file04 = data_selected.get(i).path;
                        }else if(i == 5){
                            url_file05 = data_selected.get(i).path;
                        }else if(i == 6){
                            url_file06 = data_selected.get(i).path;
                        }
                    }

                    if(url_file00 != null){
                        sourceFile00 = new File(url_file00);
                        body00 = RequestBody.create(MediaType.parse("image/*"), sourceFile00);
                    }
                    if(url_file01 != null){
                        sourceFile01 = new File(url_file01);
                        body01 = RequestBody.create(MediaType.parse("image/*"), sourceFile01);
                    }
                    if(url_file02 != null){
                        sourceFile02 = new File(url_file02);
                        body02 = RequestBody.create(MediaType.parse("image/*"), sourceFile02);
                    }if(url_file03 != null){
                        sourceFile03 = new File(url_file03);
                        body03 = RequestBody.create(MediaType.parse("image/*"), sourceFile03);
                    }if(url_file04 != null){
                        sourceFile04 = new File(url_file04);
                        body04 = RequestBody.create(MediaType.parse("image/*"), sourceFile04 );
                    }
                    if(url_file05 != null){
                        sourceFile05 = new File(url_file05);
                        body05 = RequestBody.create(MediaType.parse("image/*"), sourceFile05 );
                    }if(url_file06 != null){
                        sourceFile06 = new File(url_file06);
                        body06 = RequestBody.create(MediaType.parse("image/*"), sourceFile06 );
                    }

                    RequestBody cKind = RequestBody.create(MediaType.parse("text/plain"), "activities_photo");
                    RequestBody cId_pegawai = RequestBody.create(MediaType.parse("text/plain"), id_pegawai);
                    RequestBody cDesc  = RequestBody.create(MediaType.parse("text/plain"), cKet);

                    Retrofit retrofit = new Retrofit.Builder().baseUrl(Parameter_Collections.URL_ENDPOINT)
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    Test_RestAdapter restAdapter = retrofit.create(Test_RestAdapter.class);

                    Call<OlxResponseRowCount> call = restAdapter.uploadGallery(cKind, cId_pegawai
                            , cDesc, body00, body01, body02, body03, body04, body05, body06);

                    try{
                        Response<OlxResponseRowCount> response = call.execute();
                        if(response.isSuccess()){
                            Integer rowCount = response.body().getRowCount();
                            cRowCount = String.valueOf(rowCount);
                            Log.e("Row Count = " , String.valueOf(rowCount));
                        }else{
//                            Toast.makeText(getApplicationContext(),"Upload Gagal, message = " + response.errorBody().toString(),
//                                    Toast.LENGTH_LONG).show();
                            cRowCount = "0";
                            cMessage = "Upload Gagal, message = " + response.errorBody().toString();
                        }
                    }catch (IOException e){
                        cRowCount = "0";
                        cMessage = "IOException Occured";
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Harap Input Foto terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }else {
                Toast.makeText(getApplicationContext(),
                        "No Internet Connection, Cek Your Network",
                        Toast.LENGTH_LONG).show();
                cRowCount = "0";
                cMessage = "No Internet Connection, Cek Your Network";

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialogProgress.dismiss();
            if(cRowCount.equals("1")){
                spf.edit().putBoolean(Parameter_Collections.SH_OUTLET_VISITED, true).commit();

                Olx_DialogLocationConfirmation dialog = new Olx_DialogLocationConfirmation();
                dialog.setContext(getApplicationContext());
                dialog.setText("Input Photo Success");
                dialog.setFrom(9);
                dialog.setCancelable(false);
                dialog.show(getSupportFragmentManager(), "");
            }else{
                dialogProgress.dismiss();

                Olx_DialogLocationConfirmation dialog = new Olx_DialogLocationConfirmation();
                dialog.setContext(getApplicationContext());
                dialog.setText(cMessage);
                dialog.setFrom(9);
                dialog.setCancelable(false);
                dialog.show(getSupportFragmentManager(), "");
//				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
//				finish();
            }
        }
    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (resultCode == RESULT_OK) {

            if (requestCode == CODE_UPLOAD) {

                data_selected = Parameter_Collections.data_selected;

                for(int i=0; i< data_selected.size(); i++){
                    Bitmap b = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(data_selected.get(i).path),
                            100,150,true
                            );


                    if (i == 0) {
                        horizontalScroll.setVisibility(View.VISIBLE);
                        imgview_00.setVisibility(View.VISIBLE);
                        imgview_00.setImageBitmap(b);
                    } else if (i == 1) {
                        imgview_01.setVisibility(View.VISIBLE);
                        imgview_01.setImageBitmap(b);
                    } else if (i == 2) {
                        imgview_02.setVisibility(View.VISIBLE);
                        imgview_02.setImageBitmap(b);
                    } else if (i == 3) {
                        imgview_03.setVisibility(View.VISIBLE);
                        imgview_03.setImageBitmap(b);
                    }else if (i == 4) {
                        imgview_04.setVisibility(View.VISIBLE);
                        imgview_04.setImageBitmap(b);
                    } else if (i == 5) {
                        imgview_05.setVisibility(View.VISIBLE);
                        imgview_05.setImageBitmap(b);
                    } else if (i == 6) {
                        imgview_06.setVisibility(View.VISIBLE);
                        imgview_06.setImageBitmap(b);
                    }
                }



            }

        }

    }
}
