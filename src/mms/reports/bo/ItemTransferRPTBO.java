package mms.reports.bo;

import mms.reports.dao.ItemTransferRPTDAO;
import mms.reports.vo.ItemTransferRPTVO;

public class ItemTransferRPTBO {

	public void initialGenAdd(ItemTransferRPTVO vo){
		
		ItemTransferRPTDAO.storeName(vo);
		ItemTransferRPTDAO.getInstituteList(vo);
		ItemTransferRPTDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO_test.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(ItemTransferRPTVO vo){	
		ItemTransferRPTDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO_test.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(ItemTransferRPTVO _LocalPurchaseMRN_VO){
		ItemTransferRPTDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("LocalPurchaseMRN_BO_test.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(ItemTransferRPTVO vo){	
		ItemTransferRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(ItemTransferRPTVO voObj){
		ItemTransferRPTDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("New_Report_For_AcknowledgeBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
