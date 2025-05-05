package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class JobDetailsRptFB extends ActionForm {
	private static final long serialVersionUID = 02L;
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strTypeId = "";
	private String strTypeName = "";
	private String StrUserName = "";
	private String strCurrentDate;
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	public String getStrTypeId() {
		return strTypeId;
	}
	public void setStrTypeId(String strTypeId) {
		this.strTypeId = strTypeId;
	}
	public String getStrTypeName() {
		return strTypeName;
	}
	public void setStrTypeName(String strTypeName) {
		this.strTypeName = strTypeName;
	}
	public String getStrUserName() {
		return StrUserName;
	}
	public void setStrUserName(String strUserName) {
		StrUserName = strUserName;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	
	

}
