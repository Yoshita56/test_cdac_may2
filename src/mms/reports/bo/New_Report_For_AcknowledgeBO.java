package mms.reports.bo;

import mms.reports.dao.BreakageAndLostDrugDetailsRptDAO;
import mms.reports.dao.New_Report_For_AcknowledgeDAO;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.New_Report_For_AcknowledgeVO;

public class New_Report_For_AcknowledgeBO {

	public void initialGenAdd(New_Report_For_AcknowledgeVO vo){
		
		New_Report_For_AcknowledgeDAO.storeName(vo);
		New_Report_For_AcknowledgeDAO.getInstituteList(vo);
		New_Report_For_AcknowledgeDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO_test.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(New_Report_For_AcknowledgeVO vo){	
		New_Report_For_AcknowledgeDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO_test.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(New_Report_For_AcknowledgeVO _LocalPurchaseMRN_VO){
		New_Report_For_AcknowledgeDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("LocalPurchaseMRN_BO_test.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(New_Report_For_AcknowledgeVO vo){	
		New_Report_For_AcknowledgeDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(New_Report_For_AcknowledgeVO voObj){
		New_Report_For_AcknowledgeDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("New_Report_For_AcknowledgeBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
