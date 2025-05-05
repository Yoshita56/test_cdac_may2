package mms.transactions.bo;

import mms.transactions.dao.RequestForLPDeptDAO;
import mms.transactions.vo.RequestForLPDeptVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/May/2009
 * Modif Date : / /2009 
*/
public class RequestForLPDeptBO {
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(RequestForLPDeptVO vo)
	{
		//RequestForLPDeptDAO.GetData(vo);
		RequestForLPDeptDAO.itemCategoryCombo(vo);
		//RequestForLPDeptDAO.GetGroupNameCombo(vo);
		RequestForLPDeptDAO.callingFunctionStoreName(vo);
		RequestForLPDeptDAO.ToStoreCombo(vo);
		RequestForLPDeptDAO.GetGrantTypeCombo(vo);
		RequestForLPDeptDAO.GetRecommendByCombo(vo);
		RequestForLPDeptDAO.callingItemCategory(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPDeptBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(RequestForLPDeptVO vo)
	{
		RequestForLPDeptDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForLPDeptBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	

}

