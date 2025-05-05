package mms.reports.bo;

import mms.reports.dao.ReturnAcknowledgeRPTDAO;
import mms.reports.vo.ReturnAcknowledgeRPTVO;

public class ReturnAcknowledgeRPTBO {

	public void initialGenAdd(ReturnAcknowledgeRPTVO vo){
		ReturnAcknowledgeRPTDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("ReturnAcknowledgeRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getImgHeader(ReturnAcknowledgeRPTVO vo){
		ReturnAcknowledgeRPTDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReturnAcknowledgeRPTBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	public void getCategoryList(ReturnAcknowledgeRPTVO vo){	
		ReturnAcknowledgeRPTDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReturnAcknowledgeRPTBO.getCategoryList---->"+vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}	
	  
	public void getReplacementDtl(ReturnAcknowledgeRPTVO vo){
		ReturnAcknowledgeRPTDAO.getReplacementDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReturnAcknowledgeRPTBO.getReplacementDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
}
