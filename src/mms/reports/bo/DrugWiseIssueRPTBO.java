package mms.reports.bo;

import mms.reports.dao.DrugWiseIssueRPTDAO;
import mms.reports.vo.DrugWiseIssueRPTVO;

public class DrugWiseIssueRPTBO {

	public void initialGenAdd(DrugWiseIssueRPTVO vo){
		
		DrugWiseIssueRPTDAO.storeName(vo);
		DrugWiseIssueRPTDAO.getInstituteList(vo);
		DrugWiseIssueRPTDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("IndentWiseIssueRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(DrugWiseIssueRPTVO vo){	
		DrugWiseIssueRPTDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(DrugWiseIssueRPTVO _LocalPurchaseMRN_VO){
		DrugWiseIssueRPTDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTBO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(DrugWiseIssueRPTVO vo){	
		DrugWiseIssueRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(DrugWiseIssueRPTVO voObj){
		DrugWiseIssueRPTDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IndentWiseIssueRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
