package mms.reports.bo;

import mms.reports.dao.SaleReportCategoryDAO;
import mms.reports.vo.SaleReportCategoryVO;

public class SaleReportCategoryBO {

	public void getStoreList(SaleReportCategoryVO voObj) {

		SaleReportCategoryDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getStoreList()-->" + strErr);
		}

	}

	public void getItemCatList(SaleReportCategoryVO voObj) {

		SaleReportCategoryDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getItemCatList()-->" + strErr);
		}

	}

	public void getImgHeader(SaleReportCategoryVO vo){
		SaleReportCategoryDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("IssueToPatientBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getReplacementDtl(SaleReportCategoryVO vo){
		SaleReportCategoryDAO.getReplacementDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("IssueToPatientBO.getReplacementDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

}
