package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

public class HelpDeskVO {
	
	private static final long serialVersionUID = 02L;

	private Boolean BExistStatus = false;
	private String strMsgString = "";
	private String strMsgType = "";
	private String strCtDate = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strprobsub = "";
	private String strprobdesc = "";
	private String strsubmitby = "";
	private String Strstatusid="";
	
	private String strpriority="";
	
	private String strStoreId = "";
	private String strStoreName = "";
	private String strGroupId = "";
	private String strGroupName = "";
	private String strMenuId = "";

	private String strGroupNameCombo;
	private String strGroupCmbId;
	private String StrTransNo="";
	private WebRowSet StrAcknowledgeDtlWs=null;
	private WebRowSet StrTransnoWs=null;
	private WebRowSet StrFilenameWs=null;
	private String StrTransno="";
	

	private String strMode;

	
	private FormFile strLocation=null;
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileName = "";
	
	
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

	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
	}

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

	public String getStrCtDate() {
		return strCtDate;
	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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

	public String getStrpriority() {
		return strpriority;
	}

	public void setStrpriority(String strpriority) {
		this.strpriority = strpriority;
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

	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	public String getStrGroupCmbId() {
		return strGroupCmbId;
	}

	public void setStrGroupCmbId(String strGroupCmbId) {
		this.strGroupCmbId = strGroupCmbId;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStrstatusid() {
		return Strstatusid;
	}

	public void setStrstatusid(String strstatusid) {
		Strstatusid = strstatusid;
	}

	public String getStrTransNo() {
		return StrTransNo;
	}

	public void setStrTransNo(String strTransNo) {
		StrTransNo = strTransNo;
	}

	public WebRowSet getStrAcknowledgeDtlWs() {
		return StrAcknowledgeDtlWs;
	}

	public void setStrAcknowledgeDtlWs(WebRowSet strAcknowledgeDtlWs) {
		StrAcknowledgeDtlWs = strAcknowledgeDtlWs;
	}

	public WebRowSet getStrTransnoWs() {
		return StrTransnoWs;
	}

	public void setStrTransnoWs(WebRowSet strTransnoWs) {
		StrTransnoWs = strTransnoWs;
	}

	public String getStrTransno() {
		return StrTransno;
	}

	public void setStrTransno(String strTransno) {
		StrTransno = strTransno;
	}

	public String getStrMenuId() {
		return strMenuId;
	}

	public void setStrMenuId(String strMenuId) {
		this.strMenuId = strMenuId;
	}

	public WebRowSet getStrFilenameWs() {
		return StrFilenameWs;
	}

	public void setStrFilenameWs(WebRowSet strFilenameWs) {
		StrFilenameWs = strFilenameWs;
	}

	
	
	

}
