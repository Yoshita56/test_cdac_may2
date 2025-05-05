package mms.reports.bo;

import mms.reports.dao.BreakageItemDAO;
import mms.reports.vo.BreakageItemVO;

public class BreakageItemBO {

	public void initialGenAdd(BreakageItemVO vo){
		
		BreakageItemDAO.storeName(vo);
		BreakageItemDAO.getInstituteList(vo);
		BreakageItemDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(BreakageItemVO vo){	
		BreakageItemDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(BreakageItemVO _BreakageItemVO){
		BreakageItemDAO.getViewDtl(_BreakageItemVO);
		if (_BreakageItemVO.getStrMsgType().equals("1")){
			_BreakageItemVO.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _BreakageItemVO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(BreakageItemVO vo){	
		BreakageItemDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

}
