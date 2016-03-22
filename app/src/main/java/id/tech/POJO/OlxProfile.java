package id.tech.POJO;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OlxProfile {
    @SerializedName("json_code")
    @Expose
    private String jsonCode;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     *
     * @return
     * The jsonCode
     */
    public String getJsonCode() {
        return jsonCode;
    }

    /**
     *
     * @param jsonCode
     * The json_code
     */
    public void setJsonCode(String jsonCode) {
        this.jsonCode = jsonCode;
    }

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("id_target")
        @Expose
        private String idTarget;
        @SerializedName("id_pegawai")
        @Expose
        private String idPegawai;
        @SerializedName("tanggal_mulai")
        @Expose
        private String tanggalMulai;
        @SerializedName("tanggal_selesai")
        @Expose
        private String tanggalSelesai;
        @SerializedName("jumlah_target")
        @Expose
        private String jumlahTarget;
        @SerializedName("target_perhari")
        @Expose
        private String targetPerhari;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("all_data")
        @Expose
        private Object allData;
        @SerializedName("nama_pegawai")
        @Expose
        private String namaPegawai;
        @SerializedName("email_pegawai")
        @Expose
        private String emailPegawai;
        @SerializedName("jabatan")
        @Expose
        private String jabatan;
        @SerializedName("total_visit")
        @Expose
        private String totalVisit;
        @SerializedName("total_visit_daily")
        @Expose
        private String totalVisitDaily;
        @SerializedName("images")
        @Expose
        private List<Image> images = new ArrayList<Image>();

        /**
         * @return The idTarget
         */
        public String getIdTarget() {
            return idTarget;
        }

        /**
         * @param idTarget The id_target
         */
        public void setIdTarget(String idTarget) {
            this.idTarget = idTarget;
        }

        /**
         * @return The idPegawai
         */
        public String getIdPegawai() {
            return idPegawai;
        }

        /**
         * @param idPegawai The id_pegawai
         */
        public void setIdPegawai(String idPegawai) {
            this.idPegawai = idPegawai;
        }

        /**
         * @return The tanggalMulai
         */
        public String getTanggalMulai() {
            return tanggalMulai;
        }

        /**
         * @param tanggalMulai The tanggal_mulai
         */
        public void setTanggalMulai(String tanggalMulai) {
            this.tanggalMulai = tanggalMulai;
        }

        /**
         * @return The tanggalSelesai
         */
        public String getTanggalSelesai() {
            return tanggalSelesai;
        }

        /**
         * @param tanggalSelesai The tanggal_selesai
         */
        public void setTanggalSelesai(String tanggalSelesai) {
            this.tanggalSelesai = tanggalSelesai;
        }

        /**
         * @return The jumlahTarget
         */
        public String getJumlahTarget() {
            return jumlahTarget;
        }

        /**
         * @param jumlahTarget The jumlah_target
         */
        public void setJumlahTarget(String jumlahTarget) {
            this.jumlahTarget = jumlahTarget;
        }

        /**
         * @return The targetPerhari
         */
        public String getTargetPerhari() {
            return targetPerhari;
        }

        /**
         * @param targetPerhari The target_perhari
         */
        public void setTargetPerhari(String targetPerhari) {
            this.targetPerhari = targetPerhari;
        }

        /**
         * @return The createdDate
         */
        public String getCreatedDate() {
            return createdDate;
        }

        /**
         * @param createdDate The created_date
         */
        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        /**
         * @return The allData
         */
        public Object getAllData() {
            return allData;
        }

        /**
         * @param allData The all_data
         */
        public void setAllData(Object allData) {
            this.allData = allData;
        }

        /**
         * @return The namaPegawai
         */
        public String getNamaPegawai() {
            return namaPegawai;
        }

        /**
         * @param namaPegawai The nama_pegawai
         */
        public void setNamaPegawai(String namaPegawai) {
            this.namaPegawai = namaPegawai;
        }

        /**
         * @return The emailPegawai
         */
        public String getEmailPegawai() {
            return emailPegawai;
        }

        /**
         * @param emailPegawai The email_pegawai
         */
        public void setEmailPegawai(String emailPegawai) {
            this.emailPegawai = emailPegawai;
        }

        /**
         * @return The jabatan
         */
        public String getJabatan() {
            return jabatan;
        }

        /**
         * @param jabatan The jabatan
         */
        public void setJabatan(String jabatan) {
            this.jabatan = jabatan;
        }

        /**
         * @return The totalVisit
         */
        public String getTotalVisit() {
            return totalVisit;
        }

        /**
         * @param totalVisit The total_visit
         */
        public void setTotalVisit(String totalVisit) {
            this.totalVisit = totalVisit;
        }

        /**
         * @return The totalVisitDaily
         */
        public String getTotalVisitDaily() {
            return totalVisitDaily;
        }

        /**
         * @param totalVisitDaily The total_visit_daily
         */
        public void setTotalVisitDaily(String totalVisitDaily) {
            this.totalVisitDaily = totalVisitDaily;
        }


        /**
         *
         * @return
         * The images
         */
        public List<Image> getImages() {
            return images;
        }

        /**
         *
         * @param images
         * The images
         */
        public void setImages(List<Image> images) {
            this.images = images;
        }
    }

    public class Image {

        @SerializedName("id_image")
        @Expose
        private String idImage;
        @SerializedName("nama_image")
        @Expose
        private String namaImage;
        @SerializedName("deskripsi")
        @Expose
        private String deskripsi;
        @SerializedName("tipe_image")
        @Expose
        private String tipeImage;
        @SerializedName("id_tipe_image")
        @Expose
        private String idTipeImage;
        @SerializedName("created_date")
        @Expose
        private String createdDate;

        /**
         *
         * @return
         * The idImage
         */
        public String getIdImage() {
            return idImage;
        }

        /**
         *
         * @param idImage
         * The id_image
         */
        public void setIdImage(String idImage) {
            this.idImage = idImage;
        }

        /**
         *
         * @return
         * The namaImage
         */
        public String getNamaImage() {
            return namaImage;
        }

        /**
         *
         * @param namaImage
         * The nama_image
         */
        public void setNamaImage(String namaImage) {
            this.namaImage = namaImage;
        }

        /**
         *
         * @return
         * The deskripsi
         */
        public String getDeskripsi() {
            return deskripsi;
        }

        /**
         *
         * @param deskripsi
         * The deskripsi
         */
        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        /**
         *
         * @return
         * The tipeImage
         */
        public String getTipeImage() {
            return tipeImage;
        }

        /**
         *
         * @param tipeImage
         * The tipe_image
         */
        public void setTipeImage(String tipeImage) {
            this.tipeImage = tipeImage;
        }

        /**
         *
         * @return
         * The idTipeImage
         */
        public String getIdTipeImage() {
            return idTipeImage;
        }

        /**
         *
         * @param idTipeImage
         * The id_tipe_image
         */
        public void setIdTipeImage(String idTipeImage) {
            this.idTipeImage = idTipeImage;
        }

        /**
         *
         * @return
         * The createdDate
         */
        public String getCreatedDate() {
            return createdDate;
        }

        /**
         *
         * @param createdDate
         * The created_date
         */
        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

    }

}
