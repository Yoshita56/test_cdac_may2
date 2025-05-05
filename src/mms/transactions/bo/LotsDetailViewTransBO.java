package mms.transactions.bo;

import mms.transactions.dao.LotsViewTransDAO;
import mms.transactions.vo.LotsViewDtlTransVO;

public class LotsDetailViewTransBO {
	
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
	public void viewData(LotsViewDtlTransVO _LotsViewDtlTransVO)
	{
		LotsViewTransDAO.getLotsDetails(_LotsViewDtlTransVO);
						
		  if (_LotsViewDtlTransVO.getStrMsgType().equals("1")) 
		  {
			  _LotsViewDtlTransVO.setStrMsgString("LotsDetailViewTransBO.viewData() --> "+ _LotsViewDtlTransVO.getStrMsgString());
		  }
	   }
	}
