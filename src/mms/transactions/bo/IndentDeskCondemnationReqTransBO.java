package mms.transactions.bo;

import mms.transactions.dao.IndentDeskCondemnationReqTransDAO;
import mms.transactions.vo.IndentDeskCondemnationReqTransVO;

/**
 * @author Amit Kumar
 * Date of Creation : 27/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentDeskCondemnationReqTransBO 
{
	/**
	 * GetData Method is Used to Populate the Data  for Indent Desk Condemnation Request Transaction
	 * @param vo
	 */
	public void GetData(IndentDeskCondemnationReqTransVO vo)
	{
		IndentDeskCondemnationReqTransDAO.GetData(vo);
		IndentDeskCondemnationReqTransDAO.GetItemCombo(vo);
		//IndentDeskCondemnationReqTransDAO.GetItemType(vo);
		IndentDeskCondemnationReqTransDAO.ToStoreCombo(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentDeskCondemnationReqTransBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Calling Function Method is Used to Populate the Data for Indent Desk Condemnation Request Transaction
	 * @param vo
	 */
	public void CallFunction(IndentDeskCondemnationReqTransVO vo)
	{
		  
		IndentDeskCondemnationReqTransDAO.callingFunctionStoreName(vo);
		IndentDeskCondemnationReqTransDAO.callingItemCategory(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentDeskCondemnationReqTransBO.CallFunction() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(IndentDeskCondemnationReqTransVO vo)
	{
		IndentDeskCondemnationReqTransDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentDeskCondemnationReqTransBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	

}
