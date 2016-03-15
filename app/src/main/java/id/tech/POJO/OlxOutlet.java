package id.tech.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by RebelCreative-A1 on 14/03/2016.
 */
public class OlxOutlet {
    @SerializedName("json_code")
    @Expose
    private String jsonCode;
    @SerializedName("total_data")
    @Expose
    private Integer totalData;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    public String getJsonCode() {
        return jsonCode;
    }

    public void setJsonCode(String jsonCode) {
        this.jsonCode = jsonCode;
    }

    public Integer getTotalData() {
        return totalData;
    }

    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {
            @SerializedName("id_outlet")
            @Expose
            private String idOutlet;
            @SerializedName("nama_outlet")
            @Expose
            private String namaOutlet;
            @SerializedName("kode_outlet")
            @Expose
            private String kodeOutlet;
            @SerializedName("alamat_outlet")
            @Expose
            private String alamatOutlet;
            @SerializedName("telepon_outlet")
            @Expose
            private String teleponOutlet;
            @SerializedName("email_outlet")
            @Expose
            private String emailOutlet;
            @SerializedName("id_jenis_outlet")
            @Expose
            private String idJenisOutlet;
            @SerializedName("region_outlet")
            @Expose
            private String regionOutlet;
            @SerializedName("latitude_outlet")
            @Expose
            private String latitudeOutlet;
            @SerializedName("longitude_outlet")
            @Expose
            private String longitudeOutlet;
            @SerializedName("created_date")
            @Expose
            private String createdDate;
            @SerializedName("nama_jenis_outlet")
            @Expose
            private String namaJenisOutlet;
            @SerializedName("description_jenis_outlet")
            @Expose
            private String descriptionJenisOutlet;

        public String getIdOutlet() {
            return idOutlet;
        }

        public void setIdOutlet(String idOutlet) {
            this.idOutlet = idOutlet;
        }

        public String getNamaOutlet() {
            return namaOutlet;
        }

        public void setNamaOutlet(String namaOutlet) {
            this.namaOutlet = namaOutlet;
        }

        public String getKodeOutlet() {
            return kodeOutlet;
        }

        public void setKodeOutlet(String kodeOutlet) {
            this.kodeOutlet = kodeOutlet;
        }

        public String getAlamatOutlet() {
            return alamatOutlet;
        }

        public void setAlamatOutlet(String alamatOutlet) {
            this.alamatOutlet = alamatOutlet;
        }

        public String getTeleponOutlet() {
            return teleponOutlet;
        }

        public void setTeleponOutlet(String teleponOutlet) {
            this.teleponOutlet = teleponOutlet;
        }

        public String getEmailOutlet() {
            return emailOutlet;
        }

        public void setEmailOutlet(String emailOutlet) {
            this.emailOutlet = emailOutlet;
        }

        public String getIdJenisOutlet() {
            return idJenisOutlet;
        }

        public void setIdJenisOutlet(String idJenisOutlet) {
            this.idJenisOutlet = idJenisOutlet;
        }

        public String getRegionOutlet() {
            return regionOutlet;
        }

        public void setRegionOutlet(String regionOutlet) {
            this.regionOutlet = regionOutlet;
        }

        public String getLatitudeOutlet() {
            return latitudeOutlet;
        }

        public void setLatitudeOutlet(String latitudeOutlet) {
            this.latitudeOutlet = latitudeOutlet;
        }

        public String getLongitudeOutlet() {
            return longitudeOutlet;
        }

        public void setLongitudeOutlet(String longitudeOutlet) {
            this.longitudeOutlet = longitudeOutlet;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getNamaJenisOutlet() {
            return namaJenisOutlet;
        }

        public void setNamaJenisOutlet(String namaJenisOutlet) {
            this.namaJenisOutlet = namaJenisOutlet;
        }

        public String getDescriptionJenisOutlet() {
            return descriptionJenisOutlet;
        }

        public void setDescriptionJenisOutlet(String descriptionJenisOutlet) {
            this.descriptionJenisOutlet = descriptionJenisOutlet;
        }
    }

}
