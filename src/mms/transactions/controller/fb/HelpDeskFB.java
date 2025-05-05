package mms.transactions.controller.fb;

import org.apache.struts.upload.FormFile;

import hisglobal.transactionutil.GenericFormBean;
import hisglobal.utility.HisUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class HelpDeskFB extends GenericFormBean {
	
	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";

	private String strEffectiveFrom = "";
	private String strPath = "";
	private String StrAcknowledgeDetails="";
	
	private String StrErrMsg="";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strpriority = "";
	private String strprobsub = "";
	private String strprobdesc = "";
	private String strsubmitby = "";
	private String StrComboVal="";

	private String strGroupId = "";
	private String strGroupName = "";
	private String strChk="";
	
	private FormFile strLocation=null;
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileName = "";
	private String StrMenuName = "";
	
	
	public String getStrMenuName() {
		return StrMenuName;
	}
	public void setStrMenuName(String strMenuName) {
		StrMenuName = strMenuName;
	}
	public FormFile getStrLocation() {
		return strLocation;
	}
	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
		
	}
	public String getStrFileNo() {
		return strFileNo;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	public String getStrpriority() {
		return strpriority;
	}
	public void setStrpriority(String strpriority) {
		this.strpriority = strpriority;
	}
	public String getStrprobsub() {
		return strprobsub;
	}
	public void setStrprobsub(String strprobsub) {
		this.strprobsub = strprobsub;
	}
	public String getStrprobdesc() {
		return strprobdesc;
	}
	public void setStrprobdesc(String strprobdesc) {
		this.strprobdesc = strprobdesc;
	}
	public String getStrsubmitby() {
		return strsubmitby;
	}
	public void setStrsubmitby(String strsubmitby) {
		this.strsubmitby = strsubmitby;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrComboVal() {
		return StrComboVal;
	}
	public void setStrComboVal(String strComboVal) {
		StrComboVal = strComboVal;
	}
	public String getStrAcknowledgeDetails() {
		return StrAcknowledgeDetails;
	}
	public void setStrAcknowledgeDetails(String strAcknowledgeDetails) {
		StrAcknowledgeDetails = strAcknowledgeDetails;
	}
	public String getStrErrMsg() {
		return StrErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		StrErrMsg = strErrMsg;
	}
	

	

}
