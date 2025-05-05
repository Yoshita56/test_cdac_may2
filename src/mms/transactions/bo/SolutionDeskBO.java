package mms.transactions.bo;



import mms.transactions.dao.SolutionDeskDAO;

import mms.transactions.vo.SolutionDeskVO;

public class SolutionDeskBO {
	

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	/*public void initialAdd(SolutionDeskVO vo) {
		
		SolutionDeskDAO.initAddQuery(vo);
		//SolutionDeskDAO.getItemName(vo);
		//SolutionDeskDAO.getSuppliedByList(vo);
		//SolutionDeskDAO.getCurrencyList(vo);
		//SolutionDeskDAO.GetGroupNameCombo(vo);
		//SolutionDeskDAO.getStockStatusList(vo);
		
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

	public void insert(SolutionDeskVO vo) 
	{
		SolutionDeskDAO.insertsol(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SolutionDeskBO.insert() --> " + strErr);
		}

	}
	
	
	public void getAcknowledgeVal(SolutionDeskVO vo)
	{
		
		SolutionDeskDAO.getAcknowledgeVal(vo);
		//AcknowledgeTransDAO.getItemVal(vo);
				
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SolutionDeskBO.getAcknowledgeVal() --> "+ vo.getStrMsgString());
		  }
	   }
	

	public void getSolViewVal(SolutionDeskVO vo)
	{
		
		SolutionDeskDAO.getSolViewVal(vo);
		//AcknowledgeTransDAO.getItemVal(vo);
				
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SolutionDeskBO.getSolViewVal() --> "+ vo.getStrMsgString());
		  }
	   }
	

}
