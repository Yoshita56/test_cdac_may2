package mms.transactions.bo;


import mms.transactions.dao.RequestForLPStaffDAO;

import mms.transactions.vo.RequestForLPStaffVO;

public class RequestForLPStaffBO {
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(RequestForLPStaffVO vo)
	{
		//RequestForLPStaffDAO.GetData(vo);
		RequestForLPStaffDAO.itemCategoryCombo(vo);
		RequestForLPStaffDAO.GetGroupNameCombo(vo);
		RequestForLPStaffDAO.callingFunctionStoreName(vo);
		RequestForLPStaffDAO.callingItemCategory(vo);
		RequestForLPStaffDAO.ToStoreCombo(vo);
		RequestForLPStaffDAO.GetGrantTypeCombo(vo);
		RequestForLPStaffDAO.GetRecommendByCombo(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPStaffBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(RequestForLPStaffVO vo)
	{
		RequestForLPStaffDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("RequestForLPStaffBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This procedure is used to set intial details for hospital diagnosis
	 * details display on the main screen
	 * 
	 * @param voObj
	 */
	public void setHospitalDiagnosis(RequestForLPStaffVO voObj) {

		try {
			RequestForLPStaffDAO.getHospitalDiagnosisDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPStaffBO.setHospitalDiagnosis() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}

	/**
	 * This procedure is used set initial details for icd diagnosis detail combo
	 * 
	 * @param voObj
	 */
	public void setIcdDiagnosis(RequestForLPStaffVO voObj) {

		try {

			RequestForLPStaffDAO.getIcd10DiagnosisDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		} catch (Exception e) {

			voObj
					.setStrMsgString("RequestForLPStaffBO.setIcdDiagnosis() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}


	

}



