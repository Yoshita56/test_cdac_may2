package mms.masters.controller.fb;

import javax.sql.rowset.WebRowSet;

import hisglobal.masterutil.GenericFormBean;

/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */

public class DistrictMstFB extends GenericFormBean{

		private static final long serialVersionUID = 8167076865491281349L;
		
		private String strErrMsg;
		private String strWarningMsg;
		private String strNormalMsg;
		
		private String strStatecode;    
		private String strCountryCode;
		private String strCountryName;
		private String strStateName;
		
		private String strCountryCombo="";
		private String strStateCombo="";
		
		private String strStateId="";
		private String strCountryId="";
		
		private String strDistrictId="";
		private String strDistrictName="";
		private String strDistrictShortName="";
		private String strEffectiveFrom="";
		private String strEffectiveTo="";
		private String strIsValid="";
		private String strSeatId="";
		private String strEntryDate="";
		private String strLastModifyDate="";
		private String strLastModifySeatId="";
		private String strRemarks="";
		private String strHospitalCode="";
		private String strCtDate="";
		private boolean isDepartmentNameExist = false;
		private boolean isDepartmentShortNameExist = false;
		
		
		private WebRowSet strCountryWS = null;
		private WebRowSet strStateWS = null;
		
		public String getStrCtDate() {
			return strCtDate;
		}
		public void setStrCtDate(String strCtDate) {
			this.strCtDate = strCtDate;
		}
		public String getStrErrMsg() {
			return strErrMsg;
		}
		public void setStrErrMsg(String strErrMsg) {
			this.strErrMsg = strErrMsg;
		}
		public String getStrWarningMsg() {
			return strWarningMsg;
		}
		public void setStrWarningMsg(String strWarningMsg) {
			this.strWarningMsg = strWarningMsg;
		}
		public String getStrNormalMsg() {
			return strNormalMsg;
		}
		public void setStrNormalMsg(String strNormalMsg) {
			this.strNormalMsg = strNormalMsg;
		}
		public String getStrStatecode() {
			return strStatecode;
		}
		public void setStrStatecode(String strStatecode) {
			this.strStatecode = strStatecode;
		}
		public String getStrCountryCode() {
			return strCountryCode;
		}
		public void setStrCountryCode(String strCountryCode) {
			this.strCountryCode = strCountryCode;
		}
		public String getStrDistrictId() {
			return strDistrictId;
		}
		public void setStrDistrictId(String strDistrictId) {
			this.strDistrictId = strDistrictId;
		}
		public String getStrDistrictName() {
			return strDistrictName;
		}
		public void setStrDistrictName(String strDistrictName) {
			this.strDistrictName = strDistrictName;
		}
		public String getStrDistrictShortName() {
			return strDistrictShortName;
		}
		public void setStrDistrictShortName(String strDistrictStateName) {
			this.strDistrictShortName = strDistrictStateName;
		}
		public String getStrEffectiveFrom() {
			return strEffectiveFrom;
		}
		public void setStrEffectiveFrom(String strEffectiveFrom) {
			this.strEffectiveFrom = strEffectiveFrom;
		}
		public String getStrEffectiveTo() {
			return strEffectiveTo;
		}
		public void setStrEffectiveTo(String strEffectiveTo) {
			this.strEffectiveTo = strEffectiveTo;
		}
		public String getStrIsValid() {
			return strIsValid;
		}
		public void setStrIsValid(String strIsValid) {
			this.strIsValid = strIsValid;
		}
		public String getStrSeatId() {
			return strSeatId;
		}
		public void setStrSeatId(String strSeatId) {
			this.strSeatId = strSeatId;
		}
		public String getStrEntryDate() {
			return strEntryDate;
		}
		public void setStrEntryDate(String strEntryDate) {
			this.strEntryDate = strEntryDate;
		}
		public String getStrLastModifyDate() {
			return strLastModifyDate;
		}
		public void setStrLastModifyDate(String strLastModifyDate) {
			this.strLastModifyDate = strLastModifyDate;
		}
		public String getStrLastModifySeatId() {
			return strLastModifySeatId;
		}
		public void setStrLastModifySeatId(String strLastModifySeatId) {
			this.strLastModifySeatId = strLastModifySeatId;
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
		public String getStrCountryName() {
			return strCountryName;
		}
		public void setStrCountryName(String strCountryName) {
			this.strCountryName = strCountryName;
		}
		public String getStrStateName() {
			return strStateName;
		}
		public void setStrStateName(String strStateName) {
			this.strStateName = strStateName;
		}
		public WebRowSet getStrCountryWS() {
			return strCountryWS;
		}
		public void setStrCountryWS(WebRowSet strCountryWS) {
			this.strCountryWS = strCountryWS;
		}
		public WebRowSet getStrStateWS() {
			return strStateWS;
		}
		public void setStrStateWS(WebRowSet strStateWS) {
			this.strStateWS = strStateWS;
		}
		public String getStrCountryCombo() {
			return strCountryCombo;
		}
		public void setStrCountryCombo(String strCountryCombo) {
			this.strCountryCombo = strCountryCombo;
		}
		public String getStrStateCombo() {
			return strStateCombo;
		}
		public void setStrStateCombo(String strStateCombo) {
			this.strStateCombo = strStateCombo;
		}
		public String getStrStateId() {
			return strStateId;
		}
		public void setStrStateId(String strStateId) {
			this.strStateId = strStateId;
		}
		public String getStrCountryId() {
			return strCountryId;
		}
		public void setStrCountryId(String strCountryId) {
			this.strCountryId = strCountryId;
		}
		public boolean isDepartmentNameExist() {
			return isDepartmentNameExist;
		}
		public void setDepartmentNameExist(boolean isDepartmentNameExist) {
			this.isDepartmentNameExist = isDepartmentNameExist;
		}
		public boolean isDepartmentShortNameExist() {
			return isDepartmentShortNameExist;
		}
		public void setDepartmentShortNameExist(boolean isDepartmentShortNameExist) {
			this.isDepartmentShortNameExist = isDepartmentShortNameExist;
		}
		
		  
}
