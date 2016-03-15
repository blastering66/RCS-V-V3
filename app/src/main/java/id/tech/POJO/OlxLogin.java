package id.tech.POJO;
import com.google.gson.annotations.Expose;

public class OlxLogin {
//    @SerializedName("json_code")
    @Expose
    private String jsonCode;
//    @SerializedName("message")
    @Expose
    private String message;
//    @SerializedName("data")
    @Expose
    private Data data;

    public String getJsonCode() {
        return jsonCode;
    }

    public void setJsonCode(String jsonCode) {
        this.jsonCode = jsonCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private class Data{
//        @SerializedName("id_pegawai")
        @Expose
        private Integer idPegawai;
//        @SerializedName("nama_pegawai")
        @Expose
        private String namaPegawai;
//        @SerializedName("email_pegawai")
        @Expose
        private String emailPegawai;
//        @SerializedName("telepon_pegawai")
        @Expose
        private String teleponPegawai;
//        @SerializedName("jabatan")
        @Expose
        private String jabatan;
//        @SerializedName("region")
        @Expose
        private String region;
//        @SerializedName("username")
        @Expose
        private String username;
//        @SerializedName("password")
        @Expose
        private Object password;
//        @SerializedName("created_date")
        @Expose
        private String createdDate;

        public Integer getIdPegawai() {
            return idPegawai;
        }

        public void setIdPegawai(Integer idPegawai) {
            this.idPegawai = idPegawai;
        }

        public String getNamaPegawai() {
            return namaPegawai;
        }

        public void setNamaPegawai(String namaPegawai) {
            this.namaPegawai = namaPegawai;
        }

        public String getEmailPegawai() {
            return emailPegawai;
        }

        public void setEmailPegawai(String emailPegawai) {
            this.emailPegawai = emailPegawai;
        }

        public String getTeleponPegawai() {
            return teleponPegawai;
        }

        public void setTeleponPegawai(String teleponPegawai) {
            this.teleponPegawai = teleponPegawai;
        }

        public String getJabatan() {
            return jabatan;
        }

        public void setJabatan(String jabatan) {
            this.jabatan = jabatan;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }
    }
}
