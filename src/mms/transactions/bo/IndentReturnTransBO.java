package mms.transactions.bo;

import mms.transactions.dao.IndentReturnTransDAO;

import mms.transactions.vo.IndentReturnTransVO;

public class IndentReturnTransBO 
{
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(IndentReturnTransVO vo)
	{
		//IndentReturnTransDAO.getIndentDetails(vo);
		IndentReturnTransDAO.getIndentDetailsView(vo);
		
		IndentReturnTransDAO.getItemDetails(vo);
		IndentReturnTransDAO.callingFunctionIndentName(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentReturnTransBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(IndentReturnTransVO vo)
	{
		IndentReturnTransDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentReturnTransBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}

}
