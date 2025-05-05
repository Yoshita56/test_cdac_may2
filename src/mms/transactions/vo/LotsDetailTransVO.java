package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;


public class LotsDetailTransVO
{
    private static final long serialVersionUID = 02L;
    private String strAgendaNo="";
    private String strItemId="";
    private String strItemBrandId="";
	private String strAgendaDate="";
	private String strCommitteType="";
	private String strHospCode="";
	private String strMsgType="";
	private String strStoreId="";
	private String strStoreName="";
	private String strMsgString="";
	private String strCondemnationType="";
	private String strGroupValues="";
	private String strRemarks="";
	private String itemParamValue []=null;
	private String strItemCategoryNo="";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private WebRowSet groupWS=null;
	private WebRowSet wsCondemnType=null;
	private String strSeatId="";
	
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrAgendaNo() {
		return strAgendaNo;
	}
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}
	public String getStrAgendaDate() {
		return strAgendaDate;
	}
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}
	
	public String getStrCommitteType() {
		return strCommitteType;
	}
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public WebRowSet getGroupWS() {
		return groupWS;
	}
	public void setGroupWS(WebRowSet groupWS) {
		this.groupWS = groupWS;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	/**
	 * @return the wsCondemnType
	 */
	public WebRowSet getWsCondemnType() {
		return wsCondemnType;
	}
	/**
	 * @param wsCondemnType the wsCondemnType to set
	 */
	public void setWsCondemnType(WebRowSet wsCondemnType) {
		this.wsCondemnType = wsCondemnType;
	}
	
}
