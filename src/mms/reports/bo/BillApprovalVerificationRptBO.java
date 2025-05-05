package mms.reports.bo;

import mms.reports.dao.BillApprovalVerificationRptDAO;
import mms.reports.vo.BillApprovalVerificationRptVO;

public class BillApprovalVerificationRptBO {

	public void getInitialAddList(BillApprovalVerificationRptVO voObj) {

		BillApprovalVerificationRptDAO.getStoreList(voObj);
		BillApprovalVerificationRptDAO.getItemCatList(voObj);
		BillApprovalVerificationRptDAO.getSupplierList(voObj);
		BillApprovalVerificationRptDAO.getBillTypeList(voObj);
		//BillApprovalVerificationRptDAO.getPODetailsSearchList(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("BillApprovalVerificationRptDAO.getInitialAddList()-->" + strErr);
		}

	}
	
	public void getPOCombo(BillApprovalVerificationRptVO voObj) {

		BillApprovalVerificationRptDAO.getPOCombo(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("BillApprovalVerificationRptDAO.getPOCombo()-->" + strErr);
		}

	}

	public void getItemCatList(BillApprovalVerificationRptVO voObj) {

		BillApprovalVerificationRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getItemCatList()-->" + strErr);
		}

	}

	public void getImgHeader(BillApprovalVerificationRptVO vo){
		BillApprovalVerificationRptDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("IssueToPatientBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getPOPrintDetails(BillApprovalVerificationRptVO voObj){

		BillApprovalVerificationRptDAO.getPOPrintDetails(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("BillApprovalVerificationRptBO.getPODetails()-->"+strErr);
		}
	}
	
	public void getPrintDetails(BillApprovalVerificationRptVO vo) {
		BillApprovalVerificationRptDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("BillApprovalTransBO.getPrintDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	
}