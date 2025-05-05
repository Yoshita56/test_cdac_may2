
package mms.transactions.bo;

import mms.transactions.dao.IndentTransDAO;
import mms.transactions.vo.IndentTransVO;

public class IndentTransBO 
{
	/**
	 * LIST PAGE COMBO  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void getListPageCombo(IndentTransVO vo)
	{
		IndentTransDAO.getStoreList(vo);	
		IndentTransDAO.getRequestTypeCombo(vo);		
		IndentTransDAO.getCatgCombo(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IndentTransBO.getListPageCombo() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	public void getRequestTypeCombo(IndentTransVO vo)
	{		
		IndentTransDAO.getRequestTypeCombo(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IndentTransBO.getRequestTypeCombo() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	public void getCatgCombo(IndentTransVO vo)
	{		
		IndentTransDAO.getCatgCombo(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IndentTransBO.getRequestTypeCombo() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	public void getListPageData(IndentTransVO vo)
	{		
		IndentTransDAO.getListPageData(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IndentTransBO.getListPageData() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void CANCEL(IndentTransVO vo)
	{
		IndentTransDAO.CANCEL(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransBO.CANCEL() --> "+ vo.getStrMsgString());
		  }
		  
	}

}
