package in.cdac.rajashthan.bo;

import in.cdac.rajashthan.bo.ETransDataList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EtransectionData")
public class NewCountDataSet {
    public final List<ETransDataList> Data;

    public NewCountDataSet() {
        this.Data = null;
    }

    public NewCountDataSet(String error) {
        this.Data = null;
    }

    public NewCountDataSet(List<ETransDataList> Data, String error) {
        this.Data = Data;
    }
}