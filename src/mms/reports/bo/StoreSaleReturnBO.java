package mms.reports.bo;

import mms.reports.dao.StoreSaleReturnDAO;
import mms.reports.vo.StoreSaleReturnVO;


public class StoreSaleReturnBO 
{

	public void getInitializedValues(StoreSaleReturnVO voObj)
	{
	
    	StoreSaleReturnDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getInitializedValues()-->"+strErr);
		}
	}
	
	public void setViewPageDtl(StoreSaleReturnVO voObj)
	{
		
		StoreSaleReturnDAO.getReportViewDtl(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.setViewPageDtl()-->"+strErr);
		}
	}
	public void setYearWiseViewDtl(StoreSaleReturnVO voObj)
	{
		
		StoreSaleReturnDAO.getYearWiseViewDtl(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.setViewPageDtl()-->"+strErr);
		}
	}
	public void getImgHeader(StoreSaleReturnVO voObj)
	{
		StoreSaleReturnDAO.getImageHeader(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getImgHeader()-->"+strErr);
		}
	}
	//Voucher
	public void viewData(StoreSaleReturnVO voObj)
	{
		StoreSaleReturnDAO.getVoucherViewDtl(voObj);
		
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
					voObj.setStrMsgString("IssueTrackRptBO.getImgHeader()-->"+strErr);
		}
		  
	}
	
	
}
