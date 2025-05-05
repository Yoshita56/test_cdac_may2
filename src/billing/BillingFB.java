package billing;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class BillingFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;

	private String strTariffName = "";
	private String chargeTypeId = "";
	private String categoryCode = "";
	private String wardCode = "";
	private String wardId = "";
	private String departmentCode = "";
	private String groupId = "";
	private String searchText = "";
	private String strSearchType = "";
	private String hospitalCode = "";
	private String seatId = "";
	private String pkgflag = "";
	private String strMsgType = "";
	private String strWarning = "";
	private String strMsg ="";
	private String strErrMsg ="";
	private String strMode = "0";
	private String strPackageId ="";
	private String strCrNo ="";
	private String strAccNo = "0";
	private String usrFuncName = "";
	private String usrArg = "";
	
	private WebRowSet strResultWs = null;
	private String strResultValues = "";
	private String gblCRValue="";
	private String strTariffNameCombo="";
	
	public String getStrCrNo() {
		return strCrNo;
	}

	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	public String getStrAccNo() {
		return strAccNo;
	}

	public void setStrAccNo(String strAccNo) {
		this.strAccNo = strAccNo;
	}
	public String getStrTariffNameCombo() {
		return strTariffNameCombo;
	}

	public void setStrTariffNameCombo(String strTariffNameCombo) {
		this.strTariffNameCombo = strTariffNameCombo;
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
	 * @param hospitalCode the hospitalCode to set
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	/**
	 * @return the hospitalCode
	 */
	public String getHospitalCode() {
		return hospitalCode;
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

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrPackageId() {
		return strPackageId;
	}

	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getStrSearchType() {
		return strSearchType;
	}

	public void setStrSearchType(String strSearchType) {
		this.strSearchType = strSearchType;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getGblCRValue() {
		return gblCRValue;
	}

	public void setGblCRValue(String gblCRValue) {
		this.gblCRValue = gblCRValue;
	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}
	
}
