package mms.transactions.bo;

import mms.transactions.dao.LocalPurchaseMRN_DAO;
import mms.transactions.vo.LocalPurchaseMRN_VO;

public class LocalPurchaseMRN_BO {

	public void initialGenAdd(LocalPurchaseMRN_VO vo){
		
		LocalPurchaseMRN_DAO.storeName(vo);
		LocalPurchaseMRN_DAO.getInstituteList(vo);
		LocalPurchaseMRN_DAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(LocalPurchaseMRN_VO vo){	
		LocalPurchaseMRN_DAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getGroupList(LocalPurchaseMRN_VO voObj) {

		LocalPurchaseMRN_DAO.getGroupList(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocalPurchaseMRN_VO.getGroupList()-->" + strErr);
		}

	}

	public void setViewPageDtl(LocalPurchaseMRN_VO _LocalPurchaseMRN_VO){
		LocalPurchaseMRN_DAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(LocalPurchaseMRN_VO vo){	
		LocalPurchaseMRN_DAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

}
