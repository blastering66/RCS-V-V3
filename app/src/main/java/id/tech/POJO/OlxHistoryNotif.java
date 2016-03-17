package id.tech.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
public class OlxHistoryNotif {
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
     * The totalData
     */
    public Integer getTotalData() {
        return totalData;
    }

    /**
     *
     * @param totalData
     * The total_data
     */
    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id_notification")
        @Expose
        private String idNotification;
        @SerializedName("notification_title")
        @Expose
        private String notificationTitle;
        @SerializedName("notification_message")
        @Expose
        private String notificationMessage;
        @SerializedName("notification_sender")
        @Expose
        private String notificationSender;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("tanggal_buat")
        @Expose
        private String tanggalBuat;
        @SerializedName("jam_buat")
        @Expose
        private String jamBuat;

        /**
         *
         * @return
         * The idNotification
         */
        public String getIdNotification() {
            return idNotification;
        }

        /**
         *
         * @param idNotification
         * The id_notification
         */
        public void setIdNotification(String idNotification) {
            this.idNotification = idNotification;
        }

        /**
         *
         * @return
         * The notificationTitle
         */
        public String getNotificationTitle() {
            return notificationTitle;
        }

        /**
         *
         * @param notificationTitle
         * The notification_title
         */
        public void setNotificationTitle(String notificationTitle) {
            this.notificationTitle = notificationTitle;
        }

        /**
         *
         * @return
         * The notificationMessage
         */
        public String getNotificationMessage() {
            return notificationMessage;
        }

        /**
         *
         * @param notificationMessage
         * The notification_message
         */
        public void setNotificationMessage(String notificationMessage) {
            this.notificationMessage = notificationMessage;
        }

        /**
         *
         * @return
         * The notificationSender
         */
        public String getNotificationSender() {
            return notificationSender;
        }

        /**
         *
         * @param notificationSender
         * The notification_sender
         */
        public void setNotificationSender(String notificationSender) {
            this.notificationSender = notificationSender;
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

    }
}
