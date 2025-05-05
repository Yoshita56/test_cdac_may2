package ipd;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class IpdFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;

	private String strTariffName = "";
	private String chargeTypeId = "";
	private String categoryCode = "";
	private String wardCode = "";
	private String groupId = "";
	private String searchText = "";
	private int strWinResize = 0;
	private String strSeatId = "";
	private String strDeptCode = "";
	private String strWardCode = "";
	private String strRoomCode = "";
	private String strBedTypeCode = "";
	private String strDeptUnitCode = "";
	private String strHospCode = "";
	private String strErrMsgString = "";
	private String strBedProperty = "";
	private String strMsgType = "0";
	private String hospitalCode = "";
	private String pkgflag = "";
	private String strBedChartMode = "";
	private String strUsrId="";
	private String strProcessName="";
	private String strMenuName="";
	private String strModuleName="";

	private String strUserVal = "";

	
	private String usrFuncName = "";
	private String usrArg = "";
	
	private String strFromDate = "";
	private String strToDate = "";
	private String strFromDateActivitylog = "";
	private String strToDateActivitylog = "";
	
	private WebRowSet strResultWs = null;
	private String strResultValues = "";
	
	private String strTotalPresentPat="";
	private String strTotalAdmittedPat="";
	private String strTotalNewPat="";
	private String strTotalNonAcceptedPat="";
	private String strTotalTransitPat="";
	private String strTotalTransferInPat="";
	private String strTotalTransferOutPat="";
	private String strTotalDischargePat="";
	private String strTotalDeathPat="";
	private String strTotalBedAval="";
	private String strDeptName="";
	private String strDeptUnitName="";
	private String strWardName="";
	private String strRoomName="";
	private String gblCRValue="";
	
	private String bedStatusDash="";
	private String totalBedDiv="";
	
	public String getTotalBedDiv() {
		return totalBedDiv;
	}

	public void setTotalBedDiv(String totalBedDiv) {
		this.totalBedDiv = totalBedDiv;
	}

	public String getStrResultValues() {
		return strResultValues;
	}

	public void setStrResultValues(String strResultValues) {
		this.strResultValues = strResultValues;
	}

	public String getStrTariffName() {
		return strTariffName;
	}

	public void setStrTariffName(String strTariffName) {
		this.strTariffName = strTariffName;
	}

	public String getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(String chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public WebRowSet getStrResultWs() {
		return strResultWs;
	}

	public void setStrResultWs(WebRowSet strResultWs) {
		this.strResultWs = strResultWs;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getUsrFuncName() {
		return usrFuncName;
	}

	public void setUsrFuncName(String usrFuncName) {
		this.usrFuncName = usrFuncName;
	}

	public String getUsrArg() {
		return usrArg;
	}

	public void setUsrArg(String usrArg) {
		this.usrArg = usrArg;
	}

	/**
	 * @param pkgflag the pkgflag to set
	 */
	public void setPkgflag(String pkgflag) {
		this.pkgflag = pkgflag;
	}

	/**
	 * @return the pkgflag
	 */
	public String getPkgflag() {
		return pkgflag;
	}

	public String getStrWardCode() {
		return strWardCode;
	}

	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	public String getStrRoomCode() {
		return strRoomCode;
	}

	public void setStrRoomCode(String strRoomCode) {
		this.strRoomCode = strRoomCode;
	}

	public String getStrBedTypeCode() {
		return strBedTypeCode;
	}

	public void setStrBedTypeCode(String strBedTypeCode) {
		this.strBedTypeCode = strBedTypeCode;
	}

	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}

	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}


	public String getStrHospCode() {
		return strHospCode;
	}

	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStrErrMsgString() {
		return strErrMsgString;
	}

	public void setStrErrMsgString(String strErrMsgString) {
		this.strErrMsgString = strErrMsgString;
	}

	public String getStrBedProperty() {
		return strBedProperty;
	}

	public void setStrBedProperty(String strBedProperty) {
		this.strBedProperty = strBedProperty;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public int getStrWinResize() {
		return strWinResize;
	}

	public void setStrWinResize(int strWinResize) {
		this.strWinResize = strWinResize;
	}

	public String getStrBedChartMode() {
		return strBedChartMode;
	}

	public void setStrBedChartMode(String strBedChartMode) {
		this.strBedChartMode = strBedChartMode;
	}

	public String getStrDeptCode() {
		return strDeptCode;
	}

	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	public String getStrTotalPresentPat() {
		return strTotalPresentPat;
	}

	public void setStrTotalPresentPat(String strTotalPresentPat) {
		this.strTotalPresentPat = strTotalPresentPat;
	}

	public String getStrTotalAdmittedPat() {
		return strTotalAdmittedPat;
	}

	public void setStrTotalAdmittedPat(String strTotalAdmittedPat) {
		this.strTotalAdmittedPat = strTotalAdmittedPat;
	}

	public String getStrTotalNewPat() {
		return strTotalNewPat;
	}

	public void setStrTotalNewPat(String strTotalNewPat) {
		this.strTotalNewPat = strTotalNewPat;
	}

	public String getStrTotalNonAcceptedPat() {
		return strTotalNonAcceptedPat;
	}

	public void setStrTotalNonAcceptedPat(String strTotalNonAcceptedPat) {
		this.strTotalNonAcceptedPat = strTotalNonAcceptedPat;
	}

	public String getStrTotalTransitPat() {
		return strTotalTransitPat;
	}

	public void setStrTotalTransitPat(String strTotalTransitPat) {
		this.strTotalTransitPat = strTotalTransitPat;
	}

	public String getStrTotalTransferInPat() {
		return strTotalTransferInPat;
	}

	public void setStrTotalTransferInPat(String strTotalTransferInPat) {
		this.strTotalTransferInPat = strTotalTransferInPat;
	}

	public String getStrTotalTransferOutPat() {
		return strTotalTransferOutPat;
	}

	public void setStrTotalTransferOutPat(String strTotalTransferOutPat) {
		this.strTotalTransferOutPat = strTotalTransferOutPat;
	}

	public String getStrTotalDischargePat() {
		return strTotalDischargePat;
	}

	public void setStrTotalDischargePat(String strTotalDischargePat) {
		this.strTotalDischargePat = strTotalDischargePat;
	}

	public String getStrTotalDeathPat() {
		return strTotalDeathPat;
	}

	public void setStrTotalDeathPat(String strTotalDeathPat) {
		this.strTotalDeathPat = strTotalDeathPat;
	}

	public String getStrTotalBedAval() {
		return strTotalBedAval;
	}

	public void setStrTotalBedAval(String strTotalBedAval) {
		this.strTotalBedAval = strTotalBedAval;
	}

	public String getStrDeptName() {
		return strDeptName;
	}

	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}

	public String getStrDeptUnitName() {
		return strDeptUnitName;
	}

	public void setStrDeptUnitName(String strDeptUnitName) {
		this.strDeptUnitName = strDeptUnitName;
	}

	public String getStrWardName() {
		return strWardName;
	}

	public void setStrWardName(String strWardName) {
		this.strWardName = strWardName;
	}

	public String getStrRoomName() {
		return strRoomName;
	}

	public void setStrRoomName(String strRoomName) {
		this.strRoomName = strRoomName;
	}

	public String getGblCRValue() {
		return gblCRValue;
	}

	public void setGblCRValue(String gblCRValue) {
		this.gblCRValue = gblCRValue;
	}
	public String getBedStatusDash() {
		return bedStatusDash;
	}
	public void setBedStatusDash(String bedStatusDash) {
		this.bedStatusDash = bedStatusDash;
	}

	public String getStrFromDate() {
		return strFromDate;
	}

	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	public String getStrToDate() {
		return strToDate;
	}

	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

	public String getStrUsrId() {
		return strUsrId;
	}

	public void setStrUsrId(String strUsrId) {
		this.strUsrId = strUsrId;
	}

	public String getStrFromDateActivitylog() {
		return strFromDateActivitylog;
	}

	public void setStrFromDateActivitylog(String strFromDateActivitylog) {
		this.strFromDateActivitylog = strFromDateActivitylog;
	}

	public String getStrToDateActivitylog() {
		return strToDateActivitylog;
	}

	public void setStrToDateActivitylog(String strToDateActivitylog) {
		this.strToDateActivitylog = strToDateActivitylog;
	}

	public String getStrProcessName() {
		return strProcessName;
	}

	public void setStrProcessName(String strProcessName) {
		this.strProcessName = strProcessName;
	}

	public String getStrMenuName() {
		return strMenuName;
	}

	public void setStrMenuName(String strMenuName) {
		this.strMenuName = strMenuName;
	}

	public String getStrUserVal() {
		return strUserVal;
	}

	public void setStrUserVal(String strUserVal) {
		this.strUserVal = strUserVal;
	}

	public String getStrModuleName() {
		return strModuleName;
	}

	public void setStrModuleName(String strModuleName) {
		this.strModuleName = strModuleName;
	}
	
	
}