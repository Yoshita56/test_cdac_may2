package mms.transactions.bo;

import mms.transactions.dao.CostEstimationDAO;
import mms.transactions.vo.CostEstimationVO;

public class CostEstimationBO 
{	
	/**
	 * <p>Method::itemCategory is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <CostEstimationVO>vo
	 */
	public void itemCategory(CostEstimationVO vo) 
	{
		CostEstimationDAO.itemCategory(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
		  vo.setStrMsgString("CostEstimationBO.itemCategory() --> "+ vo.getStrMsgString());
		}
	}
	

}
