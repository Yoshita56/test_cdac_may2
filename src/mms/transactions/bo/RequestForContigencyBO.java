package mms.transactions.bo;

import mms.transactions.dao.RequestForContigencyDAO;
import mms.transactions.vo.RequestForContigencyVO;

public class RequestForContigencyBO
{
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(RequestForContigencyVO vo)
	{
		//RequestForContigencyDAO.GetData(vo);
		RequestForContigencyDAO.itemCategoryCombo(vo);
		RequestForContigencyDAO.GetGroupNameCombo(vo);
		RequestForContigencyDAO.callingFunctionStoreName(vo);
		RequestForContigencyDAO.ToStoreCombo(vo);
		RequestForContigencyDAO.GetGrantTypeCombo(vo);
		RequestForContigencyDAO.GetRecommendByCombo(vo);
		RequestForContigencyDAO.callingItemCategory(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForContigencyBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(RequestForContigencyVO vo)
	{
		RequestForContigencyDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("RequestForContigencyBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	


}
