package id.tech.POJO;

import com.google.gson.annotations.SerializedName;

import retrofit.http.Query;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
public class OlxAbsensi_Object {
    @SerializedName("nama_outlet")
    String nama_outlet;

    @SerializedName("id_pegawai")
    String id_pegawai;

    @SerializedName("tipe_absensi")
    String tipe_absensi;

    @SerializedName("latitude_absensi")
    String latitude_absensi;

    @SerializedName("longitude_absensi")
    String longitude_absensi;

    public OlxAbsensi_Object(String nama_outlet, String id_pegawai, String tipe_absensi, String latitude_absensi, String longitude_absensi) {
        this.nama_outlet = nama_outlet;
        this.id_pegawai = id_pegawai;
        this.tipe_absensi = tipe_absensi;
        this.latitude_absensi = latitude_absensi;
        this.longitude_absensi = longitude_absensi;
    }
}
