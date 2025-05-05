package mms.transactions.bo;

import mms.transactions.dao.AnnualPurchaseIndentDAO;

import mms.transactions.vo.AnnualPurchaseIndentVO;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/May/2009
 * Modif Date : / /2009 
*/
public class AnnualPurchaseIndentBO {
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(AnnualPurchaseIndentVO vo)
	{
		//AnnualPurchaseIndentDAO.GetData(vo);
		AnnualPurchaseIndentDAO.IndentPeriodCombo(vo);
		AnnualPurchaseIndentDAO.itemCategoryCombo(vo);
		AnnualPurchaseIndentDAO.GetGroupNameCombo(vo);
		AnnualPurchaseIndentDAO.callingFunctionStoreName(vo);
		AnnualPurchaseIndentDAO.ToStoreCombo(vo);
		AnnualPurchaseIndentDAO.GetItemTypeCombo(vo);
		AnnualPurchaseIndentDAO.GetRecommendByCombo(vo);
		AnnualPurchaseIndentDAO.callingItemCategory(vo);
		if(vo.getStrReqType().equals("11"))
		{
		    AnnualPurchaseIndentDAO.getStoreNADrugsList(vo);
		}
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("AnnualPurchaseIndentBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(AnnualPurchaseIndentVO vo)
	{
		AnnualPurchaseIndentDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("AnnualPurchaseIndentBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}

}

