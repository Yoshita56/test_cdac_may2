package mms.transactions.bo;

import mms.transactions.dao.IndentViewTransDAO;
import mms.transactions.vo.IndentViewTransVO;

public class IndentViewTransBO {
	
	 public void getImgHeader(IndentViewTransVO vo){
		 IndentViewTransDAO.getImageHeader(vo);
			if (vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentViewTransBO.getImgHeader() --> "+ vo.getStrMsgString());
			  }
		}
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(IndentViewTransVO vo)
	{
		IndentViewTransDAO.getItemDetails(vo);
		//IndentViewTransDAO.getApprovalDetails(vo);
		IndentViewTransDAO.getAvalBudgetDetails(vo);

		IndentViewTransDAO.getIndentDetails(vo);
		IndentViewTransDAO.callingFunctionIndentName(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentViewTransBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	public void ModifyData(IndentViewTransVO vo)
	{
		IndentViewTransDAO.getItemDetails(vo);
		//IndentViewTransDAO.getApprovalDetails(vo);
		IndentViewTransDAO.getAvalBudgetDetails(vo);

		IndentViewTransDAO.getIndentDetails(vo);
		IndentViewTransDAO.callingFunctionIndentName(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentViewTransBO.ModifyData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	public void INSERT(IndentViewTransVO vo)
	{
		IndentViewTransDAO.UpdateModify(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentViewTransBO.INSERT() --> "+ vo.getStrMsgString());
		  }
	}

}
