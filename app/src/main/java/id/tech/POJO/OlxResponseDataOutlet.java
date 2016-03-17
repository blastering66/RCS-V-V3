package id.tech.POJO;

/**
 * Created by RebelCreative-A1 on 16/03/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OlxResponseDataOutlet {
    @SerializedName("json_code")
    @Expose
    private Integer jsonCode;
    @SerializedName("row_count")
    @Expose
    private Integer rowCount;
    @SerializedName("kode_outlet")
    @Expose
    private String kodeOutlet;

    public Integer getJsonCode() {
        return jsonCode;
    }

    /**
     *
     * @param jsonCode
     * The json_code
     */
    public void setJsonCode(Integer jsonCode) {
        this.jsonCode = jsonCode;
    }

    /**
     *
     * @return
     * The rowCount
     */
    public Integer getRowCount() {
        return rowCount;
    }

    /**
     *
     * @param rowCount
     * The row_count
     */
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
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
}
