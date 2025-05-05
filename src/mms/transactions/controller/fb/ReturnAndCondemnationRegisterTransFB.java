package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;
import org.apache.struts.action.ActionForm;

import javax.sql.rowset.WebRowSet;

public class ReturnAndCondemnationRegisterTransFB extends GenericFormBean {	

	
	private static final long serialVersionUID = 1L;
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";	
	private String strMsgString="";
	private String strRemarks="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";	
	private String strStoreName="";
	private String strItemId="";	
	private String strCatName="";
	private String strSupplierName="";
	private String strcatno="";
	private String strsupplierno="";
	private String strActionsId="";
	private WebRowSet wbsStoreNameCombo=null;
    private String strMode;    
  
    private String strCtDate;
    private String strReturnDate;
    private String strCondemnationDate;
    
    private String[] strReplacedQty={""};
    private String[] strNosqDrugs={""};
    
    public String[] getStrNosqDrugs() {
		return strNosqDrugs;
	}
	public void setStrNosqDrugs(String[] strNosqDrugs) {
		this.strNosqDrugs = strNosqDrugs;
	}
	private String strCondemnationType="";
    private String strReturnTo="";
    private String strHiddenItemDtl="";
    private String strActionId="";
    
    private String strCondemnationRemarks="";
    
    private String strCondemnationTypeCmbOptions="";
    private String strVoucherFlag="0";
    private String strTmpStoreId="0";
    
    private String strTmpItemcatId="0";
    private String strTmpitembrandId="0";
    private String strTmpSupplierId="0";
    private String strsaveflag="0";    
    
	public String getStrTmpItemcatId() {
		return strTmpItemcatId;
	}
	public void setStrTmpItemcatId(String strTmpItemcatId) {
		this.strTmpItemcatId = strTmpItemcatId;
	}
	public String getStrTmpitembrandId() {
		return strTmpitembrandId;
	}
	public void setStrTmpitembrandId(String strTmpitembrandId) {
		this.strTmpitembrandId = strTmpitembrandId;
	}
	public String getStrTmpSupplierId() {
		return strTmpSupplierId;
	}
	public void setStrTmpSupplierId(String strTmpSupplierId) {
		this.strTmpSupplierId = strTmpSupplierId;
	}
	public String getStrTmpStoreId() {
		return strTmpStoreId;
	}
	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
	}
	public String getStrVoucherFlag() {
		return strVoucherFlag;
	}
	public void setStrVoucherFlag(String strVoucherFlag) {
		this.strVoucherFlag = strVoucherFlag;
	}
	public String getStrCondemnationRemarks() {
		return strCondemnationRemarks;
	}
	public void setStrCondemnationRemarks(String strCondemnationRemarks) {
		this.strCondemnationRemarks = strCondemnationRemarks;
	}
	public String getStrActionId() {
		return strActionId;
	}
	public void setStrActionId(String strActionId) {
		this.strActionId = strActionId;
	}
	public String getStrHiddenItemDtl() {
		return strHiddenItemDtl;
	}
	public void setStrHiddenItemDtl(String strHiddenItemDtl) {
		this.strHiddenItemDtl = strHiddenItemDtl;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}	
	public WebRowSet getWbsStoreNameCombo() {
		return wbsStoreNameCombo;
	}
	public void setWbsStoreNameCombo(WebRowSet wbsStoreNameCombo) {
		this.wbsStoreNameCombo = wbsStoreNameCombo;
	}	
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}	
	public String[] getStrReplacedQty() {
		return strReplacedQty;
	}
	public void setStrReplacedQty(String[] strReplacedQty) {
		this.strReplacedQty = strReplacedQty;
	}
	public String getStrReturnDate() {
		return strReturnDate;
	}
	public void setStrReturnDate(String strReturnDate) {
		this.strReturnDate = strReturnDate;
	}
	public String getStrCondemnationDate() {
		return strCondemnationDate;
	}
	public void setStrCondemnationDate(String strCondemnationDate) {
		this.strCondemnationDate = strCondemnationDate;
	}
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrReturnTo() {
		return strReturnTo;
	}
	public void setStrReturnTo(String strReturnTo) {
		this.strReturnTo = strReturnTo;
	}
	public String getStrCondemnationTypeCmbOptions() {
		return strCondemnationTypeCmbOptions;
	}
	public void setStrCondemnationTypeCmbOptions(
			String strCondemnationTypeCmbOptions) {
		this.strCondemnationTypeCmbOptions = strCondemnationTypeCmbOptions;
	}	
	public String getStrActionsId() {
		return strActionsId;
	}
	public void setStrActionsId(String strActionsId) {
		this.strActionsId = strActionsId;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrcatno() {
		return strcatno;
	}
	public void setStrcatno(String strcatno) {
		this.strcatno = strcatno;
	}
	public String getStrsupplierno() {
		return strsupplierno;
	}
	public void setStrsupplierno(String strsupplierno) {
		this.strsupplierno = strsupplierno;
	}
	public String getStrCatName() {
		return strCatName;
	}
	public void setStrCatName(String strCatName) {
		this.strCatName = strCatName;
	}
	public String getStrsaveflag() {
		return strsaveflag;
	}
	public void setStrsaveflag(String strsaveflag) {
		this.strsaveflag = strsaveflag;
	}
}

