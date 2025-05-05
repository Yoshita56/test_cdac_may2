package mms.reports.bo;

import mms.reports.dao.IssueAgainstIndentRptDAO;
import mms.reports.vo.IssueAgainstIndentRptVO;

import mms.reports.vo.IssueAgainstIndentRptVO;
import mms.reports.dao.IssueAgainstIndentRptDAO;

public class IssueAgainstIndentRptBO {

	public void initialGenAdd(IssueAgainstIndentRptVO vo){
		
		IssueAgainstIndentRptDAO.storeName(vo);
		IssueAgainstIndentRptDAO.getInstituteList(vo);
		IssueAgainstIndentRptDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(IssueAgainstIndentRptVO vo){	
		IssueAgainstIndentRptDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(IssueAgainstIndentRptVO _IssueAgainstIndentRptVO){
		IssueAgainstIndentRptDAO.getViewDtl(_IssueAgainstIndentRptVO);
		if (_IssueAgainstIndentRptVO.getStrMsgType().equals("1")){
			_IssueAgainstIndentRptVO.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _IssueAgainstIndentRptVO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(IssueAgainstIndentRptVO vo){	
		IssueAgainstIndentRptDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

}
