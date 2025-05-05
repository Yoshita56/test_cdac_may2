package mms.transactions.bo;

import mms.transactions.dao.CondemnationRequestForNonConsumTransDAO;
import mms.transactions.vo.CondemnationRequestForNonConsumTransVO;

public class CondemnationRequestForNonConsumTransBO {
	
	public void GetData(CondemnationRequestForNonConsumTransVO vo)
	{
		CondemnationRequestForNonConsumTransDAO.GetData(vo);
		CondemnationRequestForNonConsumTransDAO.GetItemCombo(vo);
		//CondemnationRequestForNonConsumTransDAO.GetItemType(vo);
		CondemnationRequestForNonConsumTransDAO.ToStoreCombo(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("CondemnationRequestForNonConsumTransBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Calling Function Method is Used to Populate the Data for Indent Desk Condemnation Request Transaction
	 * @param vo
	 */
	public void CallFunction(CondemnationRequestForNonConsumTransVO vo)
	{
		  
		CondemnationRequestForNonConsumTransDAO.callingFunctionStoreName(vo);
		CondemnationRequestForNonConsumTransDAO.callingItemCategory(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("CondemnationRequestForNonConsumTransBO.CallFunction() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(CondemnationRequestForNonConsumTransVO vo)
	{
		CondemnationRequestForNonConsumTransDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("CondemnationRequestForNonConsumTransBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	

}
