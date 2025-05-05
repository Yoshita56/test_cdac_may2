package mms.reports.bo;

import mms.reports.dao.INJStoreIssueRptDAO;
import mms.reports.vo.INJStoreIssueRptVO;

public class INJStoreIssueRptBO {

	public void initialGenAdd(INJStoreIssueRptVO vo){
		
		INJStoreIssueRptDAO.storeName(vo);
		INJStoreIssueRptDAO.getInstituteList(vo);	
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("IndentWiseIssueRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(INJStoreIssueRptVO vo){	
		INJStoreIssueRptDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(INJStoreIssueRptVO _LocalPurchaseMRN_VO){
		INJStoreIssueRptDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTBO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(INJStoreIssueRptVO vo){	
		INJStoreIssueRptDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(INJStoreIssueRptVO voObj){
		INJStoreIssueRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IndentWiseIssueRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	
		

}
