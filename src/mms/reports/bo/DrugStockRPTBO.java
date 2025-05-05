package mms.reports.bo;

import mms.reports.dao.DrugStockRPTDAO;
import mms.reports.vo.DrugStockRPTVO;

public class DrugStockRPTBO {

	public void initialGenAdd(DrugStockRPTVO vo){
		
		DrugStockRPTDAO.storeName(vo);
		DrugStockRPTDAO.getInstituteList(vo);
		DrugStockRPTDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("IndentWiseIssueRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(DrugStockRPTVO vo){	
		DrugStockRPTDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(DrugStockRPTVO _LocalPurchaseMRN_VO){
		DrugStockRPTDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTBO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(DrugStockRPTVO vo){	
		DrugStockRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(DrugStockRPTVO voObj){
		DrugStockRPTDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IndentWiseIssueRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
