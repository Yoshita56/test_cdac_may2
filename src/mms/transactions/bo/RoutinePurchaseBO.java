package mms.transactions.bo;

import mms.transactions.dao.RoutinePurchaseDAO;
import mms.transactions.vo.RoutinePurchaseVO;

public class RoutinePurchaseBO
{
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(RoutinePurchaseVO vo)
	{
		//RoutinePurchaseDAO.GetData(vo);
		RoutinePurchaseDAO.itemCategoryCombo(vo);
		RoutinePurchaseDAO.GetGroupNameCombo(vo);
		RoutinePurchaseDAO.callingFunctionStoreName(vo);
		RoutinePurchaseDAO.ToStoreCombo(vo);
		RoutinePurchaseDAO.IndentPeriodCombo(vo);
		RoutinePurchaseDAO.GetRecommendByCombo(vo);
		RoutinePurchaseDAO.callingItemCategory(vo);
		RoutinePurchaseDAO.GetIndentItemList(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RoutinePurchaseBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetModifyIndent(RoutinePurchaseVO vo)
	{
		
		RoutinePurchaseDAO.GetIndentItemListForModify(vo);
		RoutinePurchaseDAO.getIndentDetails(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RoutinePurchaseBO.GetModifyIndent() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(RoutinePurchaseVO vo)
	{
		RoutinePurchaseDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RoutinePurchaseBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * MODIFY  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void MODIFY(RoutinePurchaseVO vo)
	{
		RoutinePurchaseDAO.MODIFY(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RoutinePurchaseBO.MODIFY() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * UPDATE  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void UPDATE(RoutinePurchaseVO vo)
	{
		RoutinePurchaseDAO.UpdateIndentDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RoutinePurchaseBO.UPDATE() --> "+ vo.getStrMsgString());
		  }
		  
	}
	


}
