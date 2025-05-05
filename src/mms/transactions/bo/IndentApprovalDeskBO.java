package mms.transactions.bo;

import mms.transactions.dao.IndentApprovalDeskDAO;
import mms.transactions.vo.IndentApprovalDeskVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/June/2009
 * Modif Date : / /2009 
*/

public class IndentApprovalDeskBO 
{
	/*
	 * Get Approval Information Based on Seat Id
	 * */
	public void getAppLevelBasedOnSeatId(IndentApprovalDeskVO vo)
	{
		IndentApprovalDeskDAO.getAppLevelBasedOnSeatId(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentApprovalDeskBO.getAppLevelBasedOnSeatId() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/*
	 * Get Approval Information Based on Seat Id
	 * */
	public void getStockTableHLP(IndentApprovalDeskVO vo)
	{
		IndentApprovalDeskDAO.getStockTableHLP(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentApprovalDeskBO.getStockTableHLP() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void ApprovalData(IndentApprovalDeskVO vo)
	{
		if(vo.getStrReqTypeId().equals("69"))
		{	
			
		   //IndentApprovalDeskDAO.getItemDetails(vo);
		   IndentApprovalDeskDAO.getIndentDetails(vo);
		   IndentApprovalDeskDAO.callingFunctionIndentName(vo);
		   //IndentApprovalDeskDAO.getGrpIDFunction(vo);
		}
		else
		{
			if(vo.getStrReqTypeId().equals("64"))
			{
				IndentApprovalDeskDAO.callingFunctionIndentName(vo);
				IndentApprovalDeskDAO.getItemDetailsForReceiveFromThirdParty(vo);
				IndentApprovalDeskDAO.getIndentDetails(vo);
			
			}	
			else
			{	
			  IndentApprovalDeskDAO.getItemDetails(vo);
			  IndentApprovalDeskDAO.getIndentDetails(vo);
			  IndentApprovalDeskDAO.callingFunctionIndentName(vo);
			  IndentApprovalDeskDAO.setCommitteeTypeDtl(vo);
			}
			
		}	
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentApprovalDeskBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(IndentApprovalDeskVO vo)
	{
		//System.out.println("reqid is"+vo.getStrReqTypeId());
		if(vo.getStrReqTypeId().equals("69"))
		{	
			IndentApprovalDeskDAO.getIndentDetailsView(vo);
			IndentApprovalDeskDAO.callingFunctionIndentNameView(vo);
			IndentApprovalDeskDAO.getGrpIDFunction(vo);
		}
		else
		{
			if(vo.getStrReqTypeId().equals("47"))
			{
				IndentApprovalDeskDAO.getItemDetails(vo);
				IndentApprovalDeskDAO.getItemDetailsView(vo);
				IndentApprovalDeskDAO.getIndentDetailsView(vo);
				IndentApprovalDeskDAO.callingFunctionIndentNameView(vo);
			}
			else
			{
				if(vo.getStrReqTypeId().equals("64"))
				{
					IndentApprovalDeskDAO.getItemDetailsForReceiveFromThirdParty(vo);
					IndentApprovalDeskDAO.getIndentDetailsView(vo);
					IndentApprovalDeskDAO.callingFunctionIndentNameView(vo);
				
				}	
				else
				{	
				 IndentApprovalDeskDAO.getItemDetailsView(vo);
				 IndentApprovalDeskDAO.getIndentDetailsView(vo);
				 IndentApprovalDeskDAO.callingFunctionIndentNameView(vo);
				} 
			}
			
					
		}	
		
		
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentApprovalDeskBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(IndentApprovalDeskVO vo)
	{
		IndentApprovalDeskDAO.INSERT(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentApprovalDeskBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT_SPECIAL_APPROVAL  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT_SPECIAL_APPROVAL(IndentApprovalDeskVO vo)
	{
		IndentApprovalDeskDAO.INSERT_SPECIAL_APPROVAL(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentApprovalDeskBO.INSERT_SPECIAL_APPROVAL() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * getBlockItemDtl Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void getBlockItemDtl(IndentApprovalDeskVO vo) 
	{
		IndentApprovalDeskDAO.getBlockItemDtl(vo);
		if(vo.getStrReqTypeId().equals("17"))
		{
			IndentApprovalDeskDAO.FunctionToGetResvQty(vo);
		}

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentApprovalDeskBO.getBlockItemDtl() --> "
							+ vo.getStrMsgString());
		}
	}

}
