package mms.reports.bo;

import mms.reports.dao.AcknowledgeReceiptPORptDAO;
import mms.reports.vo.AcknowledgeReceiptPORptVO;

public class AcknowledgeReceiptPORptBO {

	public void initialGenAdd(AcknowledgeReceiptPORptVO vo){
		
		AcknowledgeReceiptPORptDAO.getInstituteList(vo);
		AcknowledgeReceiptPORptDAO.getSupplierCombo(vo);
		AcknowledgeReceiptPORptDAO.itemCategory(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(AcknowledgeReceiptPORptVO vo){	
		AcknowledgeReceiptPORptDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(AcknowledgeReceiptPORptVO _AcknowledgeReceiptPORptVO){
		AcknowledgeReceiptPORptDAO.getViewDtl(_AcknowledgeReceiptPORptVO);
		if (_AcknowledgeReceiptPORptVO.getStrMsgType().equals("1")){
			_AcknowledgeReceiptPORptVO.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _AcknowledgeReceiptPORptVO.getStrMsgString());
		  }
		
	}
	
//	public void getCategoryList(AcknowledgeReceiptPORptVO vo){	
//		AcknowledgeReceiptPORptDAO.itemCategory(vo);		
//		if(vo.getStrMsgType().equals("1")){
//				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
//				vo.setStrMsgType("1");
//		}
//	}	

}
