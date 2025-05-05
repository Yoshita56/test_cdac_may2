package in.cdac.rajashthan.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DrugStockList")
public class DrugStockList {
    @XmlElement(name="ItemCode")
    public final String itemCode;
    @XmlElement(name="ItemDescription")
    public final String itemDescription;
    @XmlElement(name="BatchNum")
    public final String batchNum;
    @XmlElement(name="StockOnHand")
    public final String stockOnHand;
    @XmlElement(name="ItemUnit")
    public final String itemUnit;
    @XmlElement(name="UnitRate")
    public final String unitRate;
    @XmlElement(name="LocationCode")
    public final String locationCode;

    public DrugStockList() {
        this.itemCode = null;
        this.itemDescription = null;
        this.batchNum = null;
        this.stockOnHand = null;
        this.itemUnit = null;
        this.unitRate = null;
        this.locationCode = null;
    }

    public DrugStockList(String itemCode, String itemDescription, String batchNum, String stockOnHand, String itemUnit, String unitRate, String locationCode) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.batchNum = batchNum;
        this.stockOnHand = stockOnHand;
        this.itemUnit = itemUnit;
        this.unitRate = unitRate;
        this.locationCode = locationCode;
    }
}