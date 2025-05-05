package mms.transactions.bo;

import mms.transactions.dao.RequestForLPPatientDAO;
import mms.transactions.vo.RequestForLPPatientVO;

public class RequestForLPPatientBO 
{
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(RequestForLPPatientVO vo)
	{
		
		//RequestForLPPatientDAO.GetData(vo);
		RequestForLPPatientDAO.itemCategoryCombo(vo);
		RequestForLPPatientDAO.GetGroupNameCombo(vo);
		RequestForLPPatientDAO.callingFunctionStoreName(vo);
		RequestForLPPatientDAO.ToStoreCombo(vo);
		RequestForLPPatientDAO.GetGrantTypeCombo(vo);
		RequestForLPPatientDAO.GetRecommendByCombo(vo);
		RequestForLPPatientDAO.callingItemCategory(vo);
		RequestForLPPatientDAO.getPatientAccountBalance(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPPatientBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(RequestForLPPatientVO vo)
	{
		RequestForLPPatientDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("RequestForLPPatientBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	

	/**
	 * This procedure is used to set intial details for hospital diagnosis
	 * details display on the main screen
	 * 
	 * @param voObj
	 */
	public void setHospitalDiagnosis(RequestForLPPatientVO voObj) {

		try {
			RequestForLPPatientDAO.getHospitalDiagnosisDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPPatientBO.setHospitalDiagnosis() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}

	/**
	 * This procedure is used set initial details for icd diagnosis detail combo
	 * 
	 * @param voObj
	 */
	public void setIcdDiagnosis(RequestForLPPatientVO voObj) {

		try {

			RequestForLPPatientDAO.getIcd10DiagnosisDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPPatientBO.setIcdDiagnosis() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}
	
	/**
	 * This procedure is used to set intial details for hospital diagnosis
	 * details display on the main screen
	 * 
	 * @param voObj
	 */
	public void getPatientTreatmentDetailfrmIpd(RequestForLPPatientVO voObj) {

		try {
			    RequestForLPPatientDAO.getPatientTreatmentDetailfrmIpd(voObj);
				if(voObj.getStrHospitalCode().equals("23921"))
				{	
				  RequestForLPPatientDAO.getPatientDepartmentDtls(voObj);
				}
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPPatientBO.getPatientTreatmentDetailfrmIpd() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}
	
	/**
	 * This procedure is used to set intial details for hospital diagnosis
	 * details display on the main screen
	 * 
	 * @param voObj
	 */
	public void getUnitCombo(RequestForLPPatientVO voObj) {

		try {
			RequestForLPPatientDAO.getUnitCombo(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPPatientBO.setHospitalDiagnosis() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}

	public void PLACEREGULARINDENT(RequestForLPPatientVO vo)
	{
		RequestForLPPatientDAO.PLACEREGULARINDENT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPPatientBO.PLACEREGULARINDENT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	public void getPatientDiagDetails(RequestForLPPatientVO vo)
	{
		RequestForLPPatientDAO.getPatientDiagDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPPatientBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}

}
