package in.cdac.rajashthan.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PatientVisitData")
public class PatientIssueData {
    @XmlElement(name="patientID")
    public final String HRGNUM_PUK;
    @XmlElement(name="ninID")
    public final String GNUM_HOSPITAL_CODE;
    @XmlElement(name="visitID")
    public final String HRGNUM_VISIT_NO;
    @XmlElement(name="patientName")
    public final String HRGSTR_FNAME;
    @XmlElement(name="mobile")
    public final String HRGSTR_CONTACT_NO;
    @XmlElement(name="landline")
    public final String HRGSTR_LANDLINE_NO;
  //  @XmlElement(name="aadhaarNumber")
  //  public final String HRGSTR_AADHAR_NO;
    @XmlElement(name="visitDate")
    public final String HRGDT_EPISODE_DATE;
    @XmlElement(name="departmentID")
    public final String GNUM_DEPT_CODE;
    @XmlElement(name="patientTypeID")
    public final String GNUM_REG_CAT_CODE;
    @XmlElement(name="gender")
    public final String GNUM_GENDER_CODE;
    @XmlElement(name="age")
    public final String HRGDT_AGE;
    @XmlElement(name="visitTime")
    public final String HRGDT_VISITTIME;

    public PatientIssueData() {
        this.HRGNUM_PUK = "Medical";
        this.GNUM_HOSPITAL_CODE = "RAOL";
        this.HRGNUM_VISIT_NO = null;
        this.HRGSTR_FNAME = null;
        this.HRGSTR_CONTACT_NO = null;
        this.HRGSTR_LANDLINE_NO = null;
     //   this.HRGSTR_AADHAR_NO = null;
        this.HRGDT_EPISODE_DATE = null;
        this.GNUM_DEPT_CODE = null;
        this.GNUM_REG_CAT_CODE = null;
        this.GNUM_GENDER_CODE = null;
        this.HRGDT_AGE = null;
        this.HRGDT_VISITTIME = null;
    }

    public PatientIssueData(String HRGNUM_PUK, String GNUM_HOSPITAL_CODE, String HRGNUM_VISIT_NO, String HRGSTR_FNAME, String HRGSTR_CONTACT_NO, String HRGSTR_LANDLINE_NO, String HRGSTR_AADHAR_NO, String HRGDT_EPISODE_DATE, String GNUM_DEPT_CODE, String GNUM_REG_CAT_CODE, String GNUM_GENDER_CODE, String PATIENT_AGE, String HRGDT_VISITTIME) {
        this.HRGNUM_PUK = HRGNUM_PUK;
        this.GNUM_HOSPITAL_CODE = GNUM_HOSPITAL_CODE;
        this.HRGNUM_VISIT_NO = HRGNUM_VISIT_NO;
        this.HRGSTR_FNAME = HRGSTR_FNAME;
        this.HRGSTR_CONTACT_NO = HRGSTR_CONTACT_NO;
        this.HRGSTR_LANDLINE_NO = HRGSTR_LANDLINE_NO;
   //     this.HRGSTR_AADHAR_NO = HRGSTR_AADHAR_NO;
        this.HRGDT_EPISODE_DATE = HRGDT_EPISODE_DATE;
        this.GNUM_DEPT_CODE = GNUM_DEPT_CODE;
        this.GNUM_REG_CAT_CODE = GNUM_REG_CAT_CODE;
        this.GNUM_GENDER_CODE = GNUM_GENDER_CODE;
        this.HRGDT_AGE = PATIENT_AGE;
        this.HRGDT_VISITTIME = HRGDT_VISITTIME;
    }
}