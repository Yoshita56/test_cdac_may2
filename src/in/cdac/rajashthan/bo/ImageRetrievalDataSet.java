package in.cdac.rajashthan.bo;

import in.cdac.rajashthan.bo.ImageRetrievalData;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="patientVisitData")
public class ImageRetrievalDataSet {
    public final String source = "CDAC";
    public final List<ImageRetrievalData> data;
    public final String error;
    public final String dateTime;

    public ImageRetrievalDataSet() {
        this.data = null;
        this.error = "";
        this.dateTime = "";
    }

    public ImageRetrievalDataSet(String error, String dateTime) {
        this.data = null;
        this.error = error;
        this.dateTime = dateTime;
    }

    public ImageRetrievalDataSet(List<ImageRetrievalData> Data, String error, String dateTime) {
        this.data = Data;
        this.error = error;
        this.dateTime = dateTime;
    }
}