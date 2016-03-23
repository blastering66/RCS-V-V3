package id.tech.util;

import com.squareup.okhttp.RequestBody;

import java.util.List;


/**
 * Created by RebelCreative-A1 on 14/03/2016.
 */
import id.tech.POJO.OlxOutlet;
import id.tech.POJO.OlxLogin;
import id.tech.POJO.OlxJenisOutlet;
import id.tech.POJO.OlxProfile;
import id.tech.POJO.OlxAbsensi;
import id.tech.POJO.OlxHistoryVisit;
import id.tech.POJO.OlxHistoryNotif;
import id.tech.POJO.OlxResponseRowCount;
import id.tech.POJO.OlxResponseDataOutlet;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;


public interface Test_RestAdapter {

    @GET("get.php?kind=outlet")
    Call<OlxOutlet> getOutlet();

    @GET("login.php?kind=mobile")
    Call<OlxLogin> login(@Query("username") String username,
                         @Query("password") String password
                         );

    @GET("get.php?kind=jenis_outlet")
    Call<OlxJenisOutlet> getJenisOutlet();

    @GET("get.php?kind=target_profile")
    Call<OlxProfile> getProfile(
            @Query("id_pegawai") String pegawai);

    @GET("get.php?kind=history")
    Call<OlxHistoryVisit> getHistoryPegawai(
            @Query("id_pegawai") String pegawai);

    @GET("get.php?kind=notification")
    Call<OlxHistoryNotif> getHistoryNotif();

    @Multipart
    @POST("insert.php?")
    Call<OlxResponseRowCount> uploadGallery(
            @Part("kind") RequestBody  kind,
            @Part("id_pegawai") RequestBody  id_pegawai,
            @Part("activities_description") RequestBody  activities_description,

            @Part("img0\"; filename=\"img0.png\" ")RequestBody img0,
            @Part("img1\"; filename=\"img1.png\" ")RequestBody img1,
            @Part("img2\"; filename=\"img2.png\" ")RequestBody img2,
            @Part("img3\"; filename=\"img3.png\" ")RequestBody img3,
            @Part("img4\"; filename=\"img4.png\" ")RequestBody img4,
            @Part("img5\"; filename=\"img5.png\" ")RequestBody img5,
            @Part("img6\"; filename=\"img6.png\" ")RequestBody img6
    );

    @FormUrlEncoded
    @POST("insert.php?")
    Call<OlxAbsensi> absensi(
            @Field("kind") String kind,
            @Field("mobile") String mobile,
            @Field("nama_outlet") String nama_outlet,
            @Field("id_pegawai") String id_pegawai,
            @Field("tipe_absensi") String tipe_absensi,
            @Field("latitude_absensi") String latitude_absensi,
            @Field("longitude_absensi") String longitude_absensi
    );


    @FormUrlEncoded
    @POST("insert.php?")
    Call<OlxResponseDataOutlet> inputDataOutlet(
            @Field("kind") String kind,
            @Field("nama_outlet") String nama_outlet,
            @Field("alamat_outlet") String alamat_outlet,
            @Field("telepon_outlet") String telepon_outlet,
            @Field("id_jenis_outlet") String id_jenis_outlet,
            @Field("region_outlet") String region_outlet,
            @Field("latitude_outlet") String latitude_outlet,
            @Field("longitude_outlet") String longitude_outlet,
            @Field("email_outlet") String email_outlet
    );

    @FormUrlEncoded
    @POST("insert.php?")
    Call<OlxResponseRowCount> visit(
            @Field("kind") String kind,
            @Field("mobile") String mobile,
            @Field("kode_outlet") String kode_outlet,
            @Field("id_pegawai") String id_pegawai,
            @Field("username_visit") String username_visit,
            @Field("email_visit") String email_visit,
            @Field("phone_visit") String phone_visit,
            @Field("topup_visit") String topup_visit,
            @Field("desc_visit") String desc_visit,
            @Field("latitude_visit") String latitude_visit,
            @Field("longitude_visit") String longitude_visit
    );

    @FormUrlEncoded
    @POST("insert.php?")
    Call<OlxResponseRowCount> registerGCM(
            @Field("kind") String kind,
            @Field("device_token") String device_token,
            @Field("device_active") String device_active,
            @Field("device_unique_id") String device_unique_id

    );
}
