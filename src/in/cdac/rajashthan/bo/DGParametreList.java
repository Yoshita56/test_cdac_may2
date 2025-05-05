package in.cdac.rajashthan.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HIS-PatientDemoGraphic")
public class DGParametreList {
	@XmlElement(name="CR")
	public final String CR;
	@XmlElement(name="PatientName")
    public final String patientName;
    @XmlElement(name="Age")
    public final String age;
    @XmlElement(name="Gender")
    public final String gender;
    @XmlElement(name="FatherName")
    public final String fathername;
    @XmlElement(name="SpouseName")
    public final String spousename;
    @XmlElement(name="Cateogry")
    public final String cateogry;
    @XmlElement(name="ContactNo")
    public final String contactNo;
    @XmlElement(name="AadharNo")
    public final String aadhaNo;
    @XmlElement(name="BhamashahId")
    public final String bhamashahId;
    @XmlElement(name="UniqueId")
    public final String uniqueId;
   
    public DGParametreList() {
    	this.CR = null;
    	this.patientName = null;
        this.age = null;
        this.gender = null;
        this.fathername = null;
        this.spousename = null;
        this.cateogry = null;
        this.contactNo = null;
        this.aadhaNo = null;
        this.bhamashahId = null;
        this.uniqueId = null;
    }

    public DGParametreList(String CR,String patientName, String age, String gender,String fathername, String spousename, String cateogry, String contactNo, String aadhaNo, String bhamashahId,String uniqueId) {
    	  this.CR = CR;  
    	  this.patientName = patientName;
          this.age = age;
          this.gender = gender;
          this.fathername = fathername;
          this.spousename = spousename;
          this.cateogry = cateogry;
          this.contactNo = contactNo;
          this.aadhaNo = aadhaNo;
          this.bhamashahId = bhamashahId;
          this.uniqueId = uniqueId; 
    }
}
