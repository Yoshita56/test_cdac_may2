package mms.reports.bo;

import mms.reports.dao.IndentWiseIssueRPTDAO;
import mms.reports.vo.IndentWiseIssueRPTVO;

public class IndentWiseIssueRPTBO {

	public void initialGenAdd(IndentWiseIssueRPTVO vo){
		
		IndentWiseIssueRPTDAO.storeName(vo);
		IndentWiseIssueRPTDAO.getInstituteList(vo);
		IndentWiseIssueRPTDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("IndentWiseIssueRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(IndentWiseIssueRPTVO vo){	
		IndentWiseIssueRPTDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(IndentWiseIssueRPTVO _LocalPurchaseMRN_VO){
		IndentWiseIssueRPTDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTBO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(IndentWiseIssueRPTVO vo){	
		IndentWiseIssueRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(IndentWiseIssueRPTVO voObj){
		IndentWiseIssueRPTDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IndentWiseIssueRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
