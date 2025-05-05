package in.cdac.rajashthan.bo;

import in.cdac.rajashthan.bo.DGParametreList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HIS-PatientDemoGraphic")
public class PatientDemoGraphicDataSet {
    public final List<DGParametreList> dgParametreList;
    public final String error;
    public final String dateTime;

    public PatientDemoGraphicDataSet() {
        this.dgParametreList = null;
        this.error = "";
        this.dateTime = "";
    }

    public PatientDemoGraphicDataSet(String error, String dateTime) {
        this.dgParametreList = null;
        this.error = error;
        this.dateTime = dateTime;
    }

    public PatientDemoGraphicDataSet(List<DGParametreList> dgParametreList, String error, String dateTime) {
        this.dgParametreList = dgParametreList;
        this.error = error;
        this.dateTime = dateTime;
    }
}
