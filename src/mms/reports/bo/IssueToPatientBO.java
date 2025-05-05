package mms.reports.bo;

import mms.reports.dao.IssueToPatientDAO;
import mms.reports.vo.IssueToPatientVO;

public class IssueToPatientBO {

	public void getStoreList(IssueToPatientVO voObj) {

		IssueToPatientDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getStoreList()-->" + strErr);
		}

	}

	public void getItemCatList(IssueToPatientVO voObj) {

		IssueToPatientDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getItemCatList()-->" + strErr);
		}

	}

	public void getReqTypeList(IssueToPatientVO voObj) {

		IssueToPatientDAO.getIReqTypeList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueToPatientBO.getItemCatList()-->" + strErr);
		}

	}
	
	public void getImgHeader(IssueToPatientVO vo){
		IssueToPatientDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("IssueToPatientBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getReplacementDtl(IssueToPatientVO vo){
		IssueToPatientDAO.getReplacementDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("IssueToPatientBO.getReplacementDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

}
