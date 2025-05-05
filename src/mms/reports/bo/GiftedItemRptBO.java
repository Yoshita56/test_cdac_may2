package mms.reports.bo;

import mms.reports.dao.GiftedItemRptDAO;
import mms.reports.vo.GiftedItemRptvo;

public class GiftedItemRptBO {

	public void initialGenAdd(GiftedItemRptvo vo){
		
		GiftedItemRptDAO.storeName(vo);
		GiftedItemRptDAO.getInstituteList(vo);
		GiftedItemRptDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(GiftedItemRptvo vo){	
		GiftedItemRptDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(GiftedItemRptvo _GiftedItemRptvo){
		GiftedItemRptDAO.getViewDtl(_GiftedItemRptvo);
		if (_GiftedItemRptvo.getStrMsgType().equals("1")){
			_GiftedItemRptvo.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _GiftedItemRptvo.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(GiftedItemRptvo vo){	
		GiftedItemRptDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

}
