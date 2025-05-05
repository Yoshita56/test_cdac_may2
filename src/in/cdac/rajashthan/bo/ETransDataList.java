package in.cdac.rajashthan.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ETransDataList")
public class ETransDataList {
    @XmlElement(name="DepartmentName")
    public final String departmentName;
    @XmlElement(name="DepartmentCode")
    public final String departmentCode;
    @XmlElement(name="ServiceName")
    public final String serviceName;
    @XmlElement(name="ServiceCode")
    public final String serviceCode;
    @XmlElement(name="DistrictName")
    public final String districtName;
    @XmlElement(name="DistrictCode")
    public final String districtCode;
    @XmlElement(name="ApplicationReceived")
    public final String applicationReceived;
    @XmlElement(name="ApplicationPending")
    public final String applicationPending;
    @XmlElement(name="ApplicationApprove")
    public final String applicationApprove;
    @XmlElement(name="ApplicationRejected")
    public final String applicationRejected;

    public ETransDataList() {
        this.departmentName = "Medical";
        this.departmentCode = "RAOL";
        this.serviceName = null;
        this.serviceCode = null;
        this.districtName = null;
        this.districtCode = null;
        this.applicationReceived = null;
        this.applicationPending = null;
        this.applicationApprove = null;
        this.applicationRejected = null;
    }

    public ETransDataList(String serviceName, String serviceCode, String districtName, String districtCode, String applicationReceived) {
        this.departmentName = "Medical Department";
        this.departmentCode = "001";
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.districtName = districtName;
        this.districtCode = districtCode;
        this.applicationReceived = applicationReceived;
        this.applicationPending = "0";
        this.applicationApprove = applicationReceived;
        this.applicationRejected = "0";
    }
}