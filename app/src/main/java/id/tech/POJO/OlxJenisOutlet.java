package id.tech.POJO;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
public class OlxJenisOutlet {
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

        @SerializedName("id_jenis_outlet")
        @Expose
        private String idJenisOutlet;
        @SerializedName("nama_jenis_outlet")
        @Expose
        private String namaJenisOutlet;
        @SerializedName("description_jenis_outlet")
        @Expose
        private String descriptionJenisOutlet;

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
         * The namaJenisOutlet
         */
        public String getNamaJenisOutlet() {
            return namaJenisOutlet;
        }

        /**
         *
         * @param namaJenisOutlet
         * The nama_jenis_outlet
         */
        public void setNamaJenisOutlet(String namaJenisOutlet) {
            this.namaJenisOutlet = namaJenisOutlet;
        }

        /**
         *
         * @return
         * The descriptionJenisOutlet
         */
        public String getDescriptionJenisOutlet() {
            return descriptionJenisOutlet;
        }

        /**
         *
         * @param descriptionJenisOutlet
         * The description_jenis_outlet
         */
        public void setDescriptionJenisOutlet(String descriptionJenisOutlet) {
            this.descriptionJenisOutlet = descriptionJenisOutlet;
        }

    }
}
