package mms.transactions.bo;

import mms.transactions.dao.IndentSuperApprovalTransDAO;
import mms.transactions.vo.IndentSuperApprovalTransVO;

public class IndentSuperApprovalTransBO {
	/*
	 * Get Approval Information Based on Seat Id
	 * */
	public void getAppLevelBasedOnSeatId(IndentSuperApprovalTransVO vo)
	{
		IndentSuperApprovalTransDAO.getAppLevelBasedOnSeatId(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentSuperApprovalTranBO.getAppLevelBasedOnSeatId() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void ApprovalData(IndentSuperApprovalTransVO vo)
	{
		if(vo.getStrReqTypeId().equals("69"))
		{	
			
		   //IndentSuperApprovalTransDAO.getItemDetails(vo);
		   IndentSuperApprovalTransDAO.getIndentDetails(vo);
		   IndentSuperApprovalTransDAO.callingFunctionIndentName(vo);
		   //IndentSuperApprovalTransDAO.getGrpIDFunction(vo);
		}
		else
		{
			if(vo.getStrReqTypeId().equals("64"))
			{
				IndentSuperApprovalTransDAO.callingFunctionIndentName(vo);
				IndentSuperApprovalTransDAO.getItemDetailsForReceiveFromThirdParty(vo);
				IndentSuperApprovalTransDAO.getIndentDetails(vo);
			
			}	
			else
			{	
			  IndentSuperApprovalTransDAO.getItemDetails(vo);
			  IndentSuperApprovalTransDAO.getIndentDetails(vo);
			  IndentSuperApprovalTransDAO.callingFunctionIndentName(vo);
			  IndentSuperApprovalTransDAO.setCommitteeTypeDtl(vo);
			}
			
		}	
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentSuperApprovalTranBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(IndentSuperApprovalTransVO vo)
	{
		//System.out.println("reqid is"+vo.getStrReqTypeId());
		if(vo.getStrReqTypeId().equals("69"))
		{	
			IndentSuperApprovalTransDAO.getIndentDetailsView(vo);
			IndentSuperApprovalTransDAO.callingFunctionIndentNameView(vo);
			IndentSuperApprovalTransDAO.getGrpIDFunction(vo);
		}
		else
		{
			if(vo.getStrReqTypeId().equals("47"))
			{
				IndentSuperApprovalTransDAO.getItemDetails(vo);
				IndentSuperApprovalTransDAO.getItemDetailsView(vo);
				IndentSuperApprovalTransDAO.getIndentDetailsView(vo);
				IndentSuperApprovalTransDAO.callingFunctionIndentNameView(vo);
			}
			else
			{
				if(vo.getStrReqTypeId().equals("64"))
				{
					IndentSuperApprovalTransDAO.getItemDetailsForReceiveFromThirdParty(vo);
					IndentSuperApprovalTransDAO.getIndentDetailsView(vo);
					IndentSuperApprovalTransDAO.callingFunctionIndentNameView(vo);
				
				}	
				else
				{	
				 IndentSuperApprovalTransDAO.getItemDetailsView(vo);
				 IndentSuperApprovalTransDAO.getIndentDetailsView(vo);
				 IndentSuperApprovalTransDAO.callingFunctionIndentNameView(vo);
				} 
			}
			
					
		}	
		
		
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentSuperApprovalTranBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(IndentSuperApprovalTransVO vo)
	{
		IndentSuperApprovalTransDAO.INSERT(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentSuperApprovalTranBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT_SPECIAL_APPROVAL  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT_SPECIAL_APPROVAL(IndentSuperApprovalTransVO vo)
	{
		IndentSuperApprovalTransDAO.INSERT_SPECIAL_APPROVAL(vo);
		 if (vo.getStrMsgType().equals("1")) 
		  {
			  vo.setStrMsgString("IndentSuperApprovalTranBO.INSERT_SPECIAL_APPROVAL() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * getBlockItemDtl Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void getBlockItemDtl(IndentSuperApprovalTransVO vo) 
	{
		IndentSuperApprovalTransDAO.getBlockItemDtl(vo);
		if(vo.getStrReqTypeId().equals("17"))
		{
			IndentSuperApprovalTransDAO.FunctionToGetResvQty(vo);
		}

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentSuperApprovalTranBO.getBlockItemDtl() --> "
							+ vo.getStrMsgString());
		}
	}

}
