package in.cdac.rajashthan.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ImageRetrievalData")
public class ImageRetrievalData {
	@XmlElement(name="empid")
    public final String HRGSTR_EMP_ID;
    @XmlElement(name="slno")
    public final String HRGNUM_SL_NO;
    @XmlElement(name="patientImage")
	public final String HRGBYTE_IMAGE;
 


    public ImageRetrievalData() {
        this.HRGSTR_EMP_ID = "";
        this.HRGNUM_SL_NO = "";
        this.HRGBYTE_IMAGE = "";
      
        
    }

    public ImageRetrievalData(String HRGSTR_EMP_ID, String HRGNUM_SL_NO,String HRGBYTE_IMAGE) {
    	 this.HRGSTR_EMP_ID = HRGSTR_EMP_ID;
         this.HRGNUM_SL_NO = HRGNUM_SL_NO;
         this.HRGBYTE_IMAGE = HRGBYTE_IMAGE;
        
    }
}