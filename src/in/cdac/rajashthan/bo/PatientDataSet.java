package in.cdac.rajashthan.bo;

import in.cdac.rajashthan.bo.PatientVisitData;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="patientVisitData")
public class PatientDataSet {
    public final String source = "CDAC";
	//public final String source = "MGIMS Sevagram Wardha";
    public final List<PatientVisitData> data;
    public final String error;
    public final String dateTime;

    public PatientDataSet() {
        this.data = null;
        this.error = "";
        this.dateTime = "";
    }

    public PatientDataSet(String error, String dateTime) {
        this.data = null;
        this.error = error;
        this.dateTime = dateTime;
    }

    public PatientDataSet(List<PatientVisitData> Data, String error, String dateTime) {
        this.data = Data;
        this.error = error;
        this.dateTime = dateTime;
    }
}