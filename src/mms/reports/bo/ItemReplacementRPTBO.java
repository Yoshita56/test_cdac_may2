package mms.reports.bo;

import mms.reports.dao.ItemReplacementRPTDAO;
import mms.reports.vo.ItemReplacementRPTVO;

public class ItemReplacementRPTBO {

	public void initialGenAdd(ItemReplacementRPTVO vo){
		ItemReplacementRPTDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("ItemReplacementRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getImgHeader(ItemReplacementRPTVO vo){
		ItemReplacementRPTDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ItemReplacementRPTBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	public void getCategoryList(ItemReplacementRPTVO vo){	
		ItemReplacementRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ItemReplacementRPTBO.getCategoryList---->"+vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}	
	  
	public void getReplacementDtl(ItemReplacementRPTVO vo){
		ItemReplacementRPTDAO.getReplacementDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ItemReplacementRPTBO.getReplacementDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getVoucherDtl(ItemReplacementRPTVO vo){
		ItemReplacementRPTDAO.getVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ItemReplacementRPTBO.getVoucherDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	
}
