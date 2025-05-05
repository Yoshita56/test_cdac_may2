package mms.transactions.bo;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import mms.transactions.dao.PatientDtlDAO;


public class PatientDtlBO {

	  public void getPatientDetails(GlobalVO voObj)
	  {
	    PatientDtlDAO.setPatientDtl(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			  new HisException("Global Patient Details","PatientDtlBO.getPatientDetails() -->",voObj.getStrMsgString());			  
		}
		  
	  }	
	  public void getAdmissionDetails(GlobalVO voObj)
	  {
		    PatientDtlDAO.setAdmissionDtl(voObj);		  
		    if(voObj.getStrMsgType().equals("1"))
		    {
				  new HisException("HisGlobal","PatientDtlBO.getAdmissionDetails() -->",voObj.getStrMsgString());			  
			}
	  }
	  public void getAdmissionDetailsReturn(GlobalVO voObj)
	  {
		    PatientDtlDAO.setAdmissionDtlReturn(voObj);		  
		    if(voObj.getStrMsgType().equals("1"))
		    {
				  new HisException("HisGlobal","PatientDtlBO.getAdmissionDetails() -->",voObj.getStrMsgString());			  
			}
	  }
//added by shefali garg on 26-Aug-2014 for patient treatment detail in issu eto patient
	  public void getPatientTreatmentDetails(GlobalVO voObj)
	  {
	   		
		  PatientDtlDAO.setPatientTreatmentDtl(voObj);
		  if(voObj.getStrMsgType().equals("1"))
		  {
		   new HisException("Global Patient Details","PatientDtlBO.getPatientTreatmentDetails() -->",voObj.getStrMsgString()); 
		  }
		  
	  }
	  public void getPatientDetailsWithoutCateXpiryCheck(GlobalVO voObj)
	  {
	    PatientDtlDAO.setPatientDtlWithoutCatExpiryCheck(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			  new HisException("Global Patient Details","PatientDtlBO.getPatientDetails() -->",voObj.getStrMsgString());			  
		}
		  
	  }	
	  public void getAdmissionDetailsView(GlobalVO voObj){
	   		
		  PatientDtlDAO.setAdmissionDtlView(voObj);
		  
 if(voObj.getStrMsgType().equals("1")){
			  
			  new HisException(
						"Global Patient Details",
						"PatientDtlBO.getAdmissionDetails() -->",
						voObj.getStrMsgString());
			  
		  }
		  
		}
	  public void getAccountDtl(GlobalVO voObj)
	  {
		    PatientDtlDAO.getAccountDtl(voObj);		  
		    if(voObj.getStrMsgType().equals("1"))
		    {
				  new HisException("HisGlobal","PatientDtlBO.getAccountDtl() -->",voObj.getStrMsgString());			  
			}
	  }
	  
}
