package mms.reports.bo;

import mms.reports.dao.LPCStatusRptDAO;
import mms.reports.vo.LPCStatusRptVO;

public class LPCStatusRptBO {

	public void setViewPageDtl(LPCStatusRptVO VO){
		LPCStatusRptDAO.getViewDtl(VO);
		if (VO.getStrMsgType().equals("1")){
			VO.setStrMsgString("LPCStatusRptBO.setViewPageDtl() --> "+ VO.getStrMsgString());
		  }
		
	}
	
	public void getImgHeader(LPCStatusRptVO voObj){
		LPCStatusRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("LPCStatusRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
