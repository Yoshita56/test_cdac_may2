package mms.transactions.bo;

import mms.transactions.dao.CondemnationRegisterViewTransDAO;
import mms.transactions.vo.CondemnationRegisterViewTransVO;

public class CondemnationRegisterViewTransBO {
	
	/*
	 * Developer : Kapil Khurana
	 * Version : 1.0 
	 * Date : 02/April/2009
	 *  Module:MMS
	 * Unit:Bill Approval View  
	*/
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(CondemnationRegisterViewTransVO vo)
	{
		CondemnationRegisterViewTransDAO.getCondemnationDetails(vo);
		//CondemnationRegisterViewTransDAO.getRequestDetails(vo);
		CondemnationRegisterViewTransDAO.getItemDetails(vo);
						
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("CondemnationRegisterViewTransBO.viewData() --> "+ vo.getStrMsgString());
		  }
	   }
	
public void viewReqData(CondemnationRegisterViewTransVO vo)
{
	CondemnationRegisterViewTransDAO.getLotsDetails(vo);			
	  if (vo.getStrMsgType().equals("1")) 
	  {
		vo.setStrMsgString("CondemnationRegisterViewTransBO.viewReqData() --> "+ vo.getStrMsgString());
	  }
   }
}