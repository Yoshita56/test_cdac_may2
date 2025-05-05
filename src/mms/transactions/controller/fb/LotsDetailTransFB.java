package mms.transactions.controller.fb;


import org.apache.struts.action.ActionForm;





public class LotsDetailTransFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strAgendaNo="";
	private String strAgendaDate="";
	private String strItemCategoryNo="";
	
	private String strCommitteType="";
	private String strHospCode="";
	private String strCtDate="";
	private String chk="";
	
	private String combo[]=null;
	private String itemParamValue []=null;
	private String strRemarks="";
	private String strStoreId="";
	private String strStoreName="";
	
	private String strItemCategoryName="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";
	private String strCommitteTypeValue="";
	private String strSeatId="";
	private String strCondemnationType="";
	private String cnt_page="";
	
	private String strGroupValues="";
	private String comboName="";
	private String strPath="";
	private String strCondemnTypeVals="";
	
	/**
	 * @return the strCondemnTypeVals
	 */
	public String getStrCondemnTypeVals() {
		return strCondemnTypeVals;
	}
	/**
	 * @param strCondemnTypeVals the strCondemnTypeVals to set
	 */
	public void setStrCondemnTypeVals(String strCondemnTypeVals) {
		this.strCondemnTypeVals = strCondemnTypeVals;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrCommitteTypeValue() {
		return strCommitteTypeValue;
	}
	public void setStrCommitteTypeValue(String strCommitteTypeValue) {
		this.strCommitteTypeValue = strCommitteTypeValue;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	
	
	
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public void setCombo(String[] combo) {
		this.combo = combo;
	}
	public String[] getCombo() {
		return combo;
	}
	public String getCnt_page() {
		return cnt_page;
	}
	public void setCnt_page(String cnt_page) {
		this.cnt_page = cnt_page;
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
	
}
