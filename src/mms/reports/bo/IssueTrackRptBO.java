package mms.reports.bo;

import mms.reports.dao.IssueTrackRptDAO;
import mms.reports.vo.IssueTrackRptVO;


public class IssueTrackRptBO 
{

	public void getInitializedValues(IssueTrackRptVO voObj)
	{
	
    	IssueTrackRptDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getInitializedValues()-->"+strErr);
		}
	}
	
	public void setViewPageDtl(IssueTrackRptVO voObj)
	{
		
		IssueTrackRptDAO.getReportViewDtl(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.setViewPageDtl()-->"+strErr);
		}
	}
	
	public void getImgHeader(IssueTrackRptVO voObj)
	{
		IssueTrackRptDAO.getImageHeader(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getImgHeader()-->"+strErr);
		}
	}
	//Voucher
	public void viewData(IssueTrackRptVO voObj)
	{
		IssueTrackRptDAO.getVoucherViewDtl(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getImgHeader()-->"+strErr);
		}
		  
	}
	
	// Issue Detail Voucher
	public void getIssueDetail(IssueTrackRptVO voObj)
	{
		IssueTrackRptDAO.getIssueDetail(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getIssueDetail()-->"+strErr);
		}
		  
	}
	
	// Issue Detail Voucher for sub store
		public void getIssueDtlForSubStore(IssueTrackRptVO voObj)
		{
			IssueTrackRptDAO.getIssueDtlForSubStore(voObj);
			
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();
						voObj.setStrMsgString("IssueTrackRptBO.getIssueDtlForSubStore()-->"+strErr);
			}
			  
		}
	
}
