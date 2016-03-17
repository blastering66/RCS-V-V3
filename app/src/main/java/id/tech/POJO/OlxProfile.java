package id.tech.POJO;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
        private String images;

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
         * @return The images
         */
        public String getImages() {
            return images;
        }

        /**
         * @param images The images
         */
        public void setImages(String images) {
            this.images = images;
        }
    }
}
