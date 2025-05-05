package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class DiscrepancyReportGlobalVO {
	
	private String strHospitalCode="";
	private String strStockNo="";
	private String strStoreId="";
	private String strItemIdBatchWise="";
	private String strItemIdBrandBatchWise="";
	private String strGroupId="";
	private WebRowSet batchWiseWS=null;
	private WebRowSet strGroupWs=null;
	private WebRowSet discrepancyWs=null;
	
	private String strMsgString="";
	private String strMsgType="";
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrStockNo() {
		return strStockNo;
	}
	public void setStrStockNo(String strStockNo) {
		this.strStockNo = strStockNo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemIdBatchWise() {
		return strItemIdBatchWise;
	}
	public void setStrItemIdBatchWise(String strItemIdBatchWise) {
		this.strItemIdBatchWise = strItemIdBatchWise;
	}
	public String getStrItemIdBrandBatchWise() {
		return strItemIdBrandBatchWise;
	}
	public void setStrItemIdBrandBatchWise(String strItemIdBrandBatchWise) {
		this.strItemIdBrandBatchWise = strItemIdBrandBatchWise;
	}
	public WebRowSet getBatchWiseWS() {
		return batchWiseWS;
	}
	public void setBatchWiseWS(WebRowSet batchWiseWS) {
		this.batchWiseWS = batchWiseWS;
	}
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public WebRowSet getDiscrepancyWs() {
		return discrepancyWs;
	}
	public void setDiscrepancyWs(WebRowSet discrepancyWs) {
		this.discrepancyWs = discrepancyWs;
	}
	

}
