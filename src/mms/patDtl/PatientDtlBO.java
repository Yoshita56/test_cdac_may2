package mms.patDtl;

import hisglobal.exceptions.HisException;


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
			System.out.println(" ------- PatientDtlDAO.setAdmissionDtl-->pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL------- ");

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
	  public void setPatientTreatmentDtl_OPD(GlobalVO voObj)
	  {
	   		
		  PatientDtlDAO.setPatientTreatmentDtl_OPD(voObj);
		  if(voObj.getStrMsgType().equals("1"))
		  {
		   new HisException("Global Patient Details","PatientDtlBO.setPatientTreatmentDtl_OPD() -->",voObj.getStrMsgString()); 
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
			System.out.println(" ------- PatientDtlDAO.getAccountDtl-->PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL------- ");

		    if(voObj.getStrMsgType().equals("1"))
		    {
				  new HisException("HisGlobal","PatientDtlBO.getAccountDtl() -->",voObj.getStrMsgString());			  
			}
	  }
	  
}
