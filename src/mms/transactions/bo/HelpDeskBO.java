package mms.transactions.bo;

import mms.transactions.dao.AcknowledgeTransDAO;
import mms.transactions.dao.HelpDeskDAO;
import mms.transactions.vo.AcknowledgeTransVO;
import mms.transactions.vo.HelpDeskVO;

/* @author 

* Developer : Brahmam Veluguri( TO CONTINUE AND CORRECTIONS)
* Version : 1.0 Date : 02/Jul/2012
* 
*/



public class HelpDeskBO {
	
	

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	/*public void initialAdd(HelpDeskVO vo) {
		
		HelpDeskDAO.initAddQuery(vo);
		//HelpDeskDAO.getItemName(vo);
		//HelpDeskDAO.getSuppliedByList(vo);
		//HelpDeskDAO.getCurrencyList(vo);
		//HelpDeskDAO.GetGroupNameCombo(vo);
		//HelpDeskDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("HelpDeskBO.inserthelp() --> "
					+ vo.getStrMsgString());
		}
	}
	*/

		
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void insert(HelpDeskVO vo) 
	{
		HelpDeskDAO.inserthelp(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("HelpDeskBO.insert() --> " + strErr);
		}

	}
	
	
	public void getAcknowledgeVal(HelpDeskVO vo)
	{
		
		HelpDeskDAO.getAcknowledgeVal(vo);
		//AcknowledgeTransDAO.getItemVal(vo);
				
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("HelpDeskBO.getAcknowledgeVal() --> "+ vo.getStrMsgString());
		  }
	   }
	
	public void getTransNo(HelpDeskVO vo)
	{
		HelpDeskDAO.getTransNo(vo);
		if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("HelpDeskBO.getTransNo() --> "+ vo.getStrMsgString());
		  }
	}
	
	public void getFileName(HelpDeskVO vo)
	{
		HelpDeskDAO.getFileName(vo);
		if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("HelpDeskBO.getFileName() --> "+ vo.getStrMsgString());
		  }
	}
	
}
