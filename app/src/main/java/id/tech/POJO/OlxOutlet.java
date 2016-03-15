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
    @Expose
    private String jsonCode;
    @Expose
    private Integer totalData;
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
            @Expose
            private String idOutlet;
            @Expose
            private String namaOutlet;
            @Expose
            private String kodeOutlet;
            @Expose
            private String alamatOutlet;
            @Expose
            private String teleponOutlet;
            @Expose
            private String emailOutlet;
            @Expose
            private String idJenisOutlet;
            @Expose
            private String regionOutlet;
            @Expose
            private String latitudeOutlet;
            @Expose
            private String longitudeOutlet;
            @Expose
            private String createdDate;
            @Expose
            private String namaJenisOutlet;
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
