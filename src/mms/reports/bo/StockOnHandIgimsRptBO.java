/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.StockOnHandIgimsRptDAO;
import mms.reports.dao.StockOnHandRptDAO_NEW;
import mms.reports.vo.StockOnHandIgimsRptVO;
import mms.reports.vo.StockOnHandRptVO_NEW;

public class StockOnHandIgimsRptBO {
	
	public void getStoreList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getStoreList()-->" + strErr);
		}

	}
	
	public void getItemCatList(StockOnHandIgimsRptVO voObj) {
		StockOnHandIgimsRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getItemCatList()-->"
					+ strErr);
		}

	}

	public void getCircleList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getCircleList()-->"
					+ strErr);
		}

	}

	public void getDistrictList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getDistrictList()-->"
					+ strErr);
		}

	}

	public void getStoreTypeList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getStoreTypeList()-->"
					+ strErr);
		}

	}

	public void getSubStoreList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getStoreList()-->" + strErr);
		}

	}

	public void getGroupList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getGroupList(voObj);
		StockOnHandIgimsRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getDrugList(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getDrugList()-->" + strErr);
		}

	}


	public void GetUserLevel(StockOnHandIgimsRptVO voObj) {
		StockOnHandIgimsRptDAO.GetUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.GetUserLevel()-->" + strErr);
		}
	}

	public void getProgrammeCombo(StockOnHandIgimsRptVO voObj) {

		StockOnHandIgimsRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandIgimsRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	 public void getImgHeader(StockOnHandIgimsRptVO voObj){
	    	StockOnHandIgimsRptDAO.getImageHeader(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("StockOnHandIgimsRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
			  }
		}
	
	
	public void getReport(StockOnHandIgimsRptVO vo) {
		StockOnHandIgimsRptDAO.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockOnHandIgimsRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}
	
	 
    public void getReportZeroStock(StockOnHandIgimsRptVO vo) {
    	StockOnHandIgimsRptDAO.getReportZeroStock(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockOnHandIgimsRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}
	

}
