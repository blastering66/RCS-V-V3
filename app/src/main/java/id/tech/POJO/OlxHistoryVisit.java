package id.tech.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
public class OlxHistoryVisit {
    @SerializedName("json_code")
    @Expose
    private String jsonCode;
    @SerializedName("total_data")
    @Expose
    private Integer totalData;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     * @return The jsonCode
     */
    public String getJsonCode() {
        return jsonCode;
    }

    /**
     * @param jsonCode The json_code
     */
    public void setJsonCode(String jsonCode) {
        this.jsonCode = jsonCode;
    }

    /**
     * @return The totalData
     */
    public Integer getTotalData() {
        return totalData;
    }

    /**
     * @param totalData The total_data
     */
    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    /**
     * @return The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }


    public class Datum {

        @SerializedName("id_pegawai")
        @Expose
        private String idPegawai;
        @SerializedName("id_visit")
        @Expose
        private String idVisit;
        @SerializedName("kode_outlet")
        @Expose
        private String kodeOutlet;
        @SerializedName("username_visit")
        @Expose
        private String usernameVisit;
        @SerializedName("phone_visit")
        @Expose
        private String phoneVisit;
        @SerializedName("email_visit")
        @Expose
        private String emailVisit;
        @SerializedName("topup_visit")
        @Expose
        private String topupVisit;
        @SerializedName("desc_visit")
        @Expose
        private String descVisit;
        @SerializedName("latitude_visit")
        @Expose
        private String latitudeVisit;
        @SerializedName("longitude_visit")
        @Expose
        private String longitudeVisit;
        @SerializedName("confirm")
        @Expose
        private String confirm;
        @SerializedName("tanggal_buat")
        @Expose
        private String tanggalBuat;
        @SerializedName("jam_buat")
        @Expose
        private String jamBuat;
        @SerializedName("nama_pegawai")
        @Expose
        private String namaPegawai;
        @SerializedName("email_pegawai")
        @Expose
        private String emailPegawai;
        @SerializedName("telepon_pegawai")
        @Expose
        private String teleponPegawai;
        @SerializedName("jabatan")
        @Expose
        private String jabatan;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("id_absensi")
        @Expose
        private String idAbsensi;
        @SerializedName("jam_absensi")
        @Expose
        private String jamAbsensi;
        @SerializedName("tanggal_absensi")
        @Expose
        private String tanggalAbsensi;
        @SerializedName("nama_outlet")
        @Expose
        private String namaOutlet;
        @SerializedName("tipe_absensi")
        @Expose
        private String tipeAbsensi;
        @SerializedName("longitude_absensi")
        @Expose
        private String longitudeAbsensi;
        @SerializedName("latitude_absensi")
        @Expose
        private String latitudeAbsensi;
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

        /**
         *
         * @return
         * The idPegawai
         */
        public String getIdPegawai() {
            return idPegawai;
        }

        /**
         *
         * @param idPegawai
         * The id_pegawai
         */
        public void setIdPegawai(String idPegawai) {
            this.idPegawai = idPegawai;
        }

        /**
         *
         * @return
         * The idVisit
         */
        public String getIdVisit() {
            return idVisit;
        }

        /**
         *
         * @param idVisit
         * The id_visit
         */
        public void setIdVisit(String idVisit) {
            this.idVisit = idVisit;
        }

        /**
         *
         * @return
         * The kodeOutlet
         */
        public String getKodeOutlet() {
            return kodeOutlet;
        }

        /**
         *
         * @param kodeOutlet
         * The kode_outlet
         */
        public void setKodeOutlet(String kodeOutlet) {
            this.kodeOutlet = kodeOutlet;
        }

        /**
         *
         * @return
         * The usernameVisit
         */
        public String getUsernameVisit() {
            return usernameVisit;
        }

        /**
         *
         * @param usernameVisit
         * The username_visit
         */
        public void setUsernameVisit(String usernameVisit) {
            this.usernameVisit = usernameVisit;
        }

        /**
         *
         * @return
         * The phoneVisit
         */
        public String getPhoneVisit() {
            return phoneVisit;
        }

        /**
         *
         * @param phoneVisit
         * The phone_visit
         */
        public void setPhoneVisit(String phoneVisit) {
            this.phoneVisit = phoneVisit;
        }

        /**
         *
         * @return
         * The emailVisit
         */
        public String getEmailVisit() {
            return emailVisit;
        }

        /**
         *
         * @param emailVisit
         * The email_visit
         */
        public void setEmailVisit(String emailVisit) {
            this.emailVisit = emailVisit;
        }

        /**
         *
         * @return
         * The topupVisit
         */
        public String getTopupVisit() {
            return topupVisit;
        }

        /**
         *
         * @param topupVisit
         * The topup_visit
         */
        public void setTopupVisit(String topupVisit) {
            this.topupVisit = topupVisit;
        }

        /**
         *
         * @return
         * The descVisit
         */
        public String getDescVisit() {
            return descVisit;
        }

        /**
         *
         * @param descVisit
         * The desc_visit
         */
        public void setDescVisit(String descVisit) {
            this.descVisit = descVisit;
        }

        /**
         *
         * @return
         * The latitudeVisit
         */
        public String getLatitudeVisit() {
            return latitudeVisit;
        }

        /**
         *
         * @param latitudeVisit
         * The latitude_visit
         */
        public void setLatitudeVisit(String latitudeVisit) {
            this.latitudeVisit = latitudeVisit;
        }

        /**
         *
         * @return
         * The longitudeVisit
         */
        public String getLongitudeVisit() {
            return longitudeVisit;
        }

        /**
         *
         * @param longitudeVisit
         * The longitude_visit
         */
        public void setLongitudeVisit(String longitudeVisit) {
            this.longitudeVisit = longitudeVisit;
        }

        /**
         *
         * @return
         * The confirm
         */
        public String getConfirm() {
            return confirm;
        }

        /**
         *
         * @param confirm
         * The confirm
         */
        public void setConfirm(String confirm) {
            this.confirm = confirm;
        }

        /**
         *
         * @return
         * The tanggalBuat
         */
        public String getTanggalBuat() {
            return tanggalBuat;
        }

        /**
         *
         * @param tanggalBuat
         * The tanggal_buat
         */
        public void setTanggalBuat(String tanggalBuat) {
            this.tanggalBuat = tanggalBuat;
        }

        /**
         *
         * @return
         * The jamBuat
         */
        public String getJamBuat() {
            return jamBuat;
        }

        /**
         *
         * @param jamBuat
         * The jam_buat
         */
        public void setJamBuat(String jamBuat) {
            this.jamBuat = jamBuat;
        }

        /**
         *
         * @return
         * The namaPegawai
         */
        public String getNamaPegawai() {
            return namaPegawai;
        }

        /**
         *
         * @param namaPegawai
         * The nama_pegawai
         */
        public void setNamaPegawai(String namaPegawai) {
            this.namaPegawai = namaPegawai;
        }

        /**
         *
         * @return
         * The emailPegawai
         */
        public String getEmailPegawai() {
            return emailPegawai;
        }

        /**
         *
         * @param emailPegawai
         * The email_pegawai
         */
        public void setEmailPegawai(String emailPegawai) {
            this.emailPegawai = emailPegawai;
        }

        /**
         *
         * @return
         * The teleponPegawai
         */
        public String getTeleponPegawai() {
            return teleponPegawai;
        }

        /**
         *
         * @param teleponPegawai
         * The telepon_pegawai
         */
        public void setTeleponPegawai(String teleponPegawai) {
            this.teleponPegawai = teleponPegawai;
        }

        /**
         *
         * @return
         * The jabatan
         */
        public String getJabatan() {
            return jabatan;
        }

        /**
         *
         * @param jabatan
         * The jabatan
         */
        public void setJabatan(String jabatan) {
            this.jabatan = jabatan;
        }

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The idAbsensi
         */
        public String getIdAbsensi() {
            return idAbsensi;
        }

        /**
         *
         * @param idAbsensi
         * The id_absensi
         */
        public void setIdAbsensi(String idAbsensi) {
            this.idAbsensi = idAbsensi;
        }

        /**
         *
         * @return
         * The jamAbsensi
         */
        public String getJamAbsensi() {
            return jamAbsensi;
        }

        /**
         *
         * @param jamAbsensi
         * The jam_absensi
         */
        public void setJamAbsensi(String jamAbsensi) {
            this.jamAbsensi = jamAbsensi;
        }

        /**
         *
         * @return
         * The tanggalAbsensi
         */
        public String getTanggalAbsensi() {
            return tanggalAbsensi;
        }

        /**
         *
         * @param tanggalAbsensi
         * The tanggal_absensi
         */
        public void setTanggalAbsensi(String tanggalAbsensi) {
            this.tanggalAbsensi = tanggalAbsensi;
        }

        /**
         *
         * @return
         * The namaOutlet
         */
        public String getNamaOutlet() {
            return namaOutlet;
        }

        /**
         *
         * @param namaOutlet
         * The nama_outlet
         */
        public void setNamaOutlet(String namaOutlet) {
            this.namaOutlet = namaOutlet;
        }

        /**
         *
         * @return
         * The tipeAbsensi
         */
        public String getTipeAbsensi() {
            return tipeAbsensi;
        }

        /**
         *
         * @param tipeAbsensi
         * The tipe_absensi
         */
        public void setTipeAbsensi(String tipeAbsensi) {
            this.tipeAbsensi = tipeAbsensi;
        }

        /**
         *
         * @return
         * The longitudeAbsensi
         */
        public String getLongitudeAbsensi() {
            return longitudeAbsensi;
        }

        /**
         *
         * @param longitudeAbsensi
         * The longitude_absensi
         */
        public void setLongitudeAbsensi(String longitudeAbsensi) {
            this.longitudeAbsensi = longitudeAbsensi;
        }

        /**
         *
         * @return
         * The latitudeAbsensi
         */
        public String getLatitudeAbsensi() {
            return latitudeAbsensi;
        }

        /**
         *
         * @param latitudeAbsensi
         * The latitude_absensi
         */
        public void setLatitudeAbsensi(String latitudeAbsensi) {
            this.latitudeAbsensi = latitudeAbsensi;
        }

        /**
         *
         * @return
         * The alamatOutlet
         */
        public String getAlamatOutlet() {
            return alamatOutlet;
        }

        /**
         *
         * @param alamatOutlet
         * The alamat_outlet
         */
        public void setAlamatOutlet(String alamatOutlet) {
            this.alamatOutlet = alamatOutlet;
        }

        /**
         *
         * @return
         * The teleponOutlet
         */
        public String getTeleponOutlet() {
            return teleponOutlet;
        }

        /**
         *
         * @param teleponOutlet
         * The telepon_outlet
         */
        public void setTeleponOutlet(String teleponOutlet) {
            this.teleponOutlet = teleponOutlet;
        }

        /**
         *
         * @return
         * The emailOutlet
         */
        public String getEmailOutlet() {
            return emailOutlet;
        }

        /**
         *
         * @param emailOutlet
         * The email_outlet
         */
        public void setEmailOutlet(String emailOutlet) {
            this.emailOutlet = emailOutlet;
        }

        /**
         *
         * @return
         * The idJenisOutlet
         */
        public String getIdJenisOutlet() {
            return idJenisOutlet;
        }

        /**
         *
         * @param idJenisOutlet
         * The id_jenis_outlet
         */
        public void setIdJenisOutlet(String idJenisOutlet) {
            this.idJenisOutlet = idJenisOutlet;
        }

        /**
         *
         * @return
         * The regionOutlet
         */
        public String getRegionOutlet() {
            return regionOutlet;
        }

        /**
         *
         * @param regionOutlet
         * The region_outlet
         */
        public void setRegionOutlet(String regionOutlet) {
            this.regionOutlet = regionOutlet;
        }

        /**
         *
         * @return
         * The latitudeOutlet
         */
        public String getLatitudeOutlet() {
            return latitudeOutlet;
        }

        /**
         *
         * @param latitudeOutlet
         * The latitude_outlet
         */
        public void setLatitudeOutlet(String latitudeOutlet) {
            this.latitudeOutlet = latitudeOutlet;
        }

        /**
         *
         * @return
         * The longitudeOutlet
         */
        public String getLongitudeOutlet() {
            return longitudeOutlet;
        }

        /**
         *
         * @param longitudeOutlet
         * The longitude_outlet
         */
        public void setLongitudeOutlet(String longitudeOutlet) {
            this.longitudeOutlet = longitudeOutlet;
        }

    }
}