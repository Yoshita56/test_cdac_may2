package in.cdac.rajashthan.bo;

import in.cdac.rajashthan.bo.DrugStockList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NewDataSet")
public class NewDataSet {
    public final List<DrugStockList> drugStockList;
    public final String error;
    public final String dateTime;

    public NewDataSet() {
        this.drugStockList = null;
        this.error = "";
        this.dateTime = "";
    }

    public NewDataSet(String error, String dateTime) {
        this.drugStockList = null;
        this.error = error;
        this.dateTime = dateTime;
    }

    public NewDataSet(List<DrugStockList> drugStockList, String error, String dateTime) {
        this.drugStockList = drugStockList;
        this.error = error;
        this.dateTime = dateTime;
    }
}