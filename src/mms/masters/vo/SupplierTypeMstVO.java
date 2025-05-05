/**
 * 
 */
package mms.masters.vo;

import hisglobal.utility.TransferObject;
/**
 * Developer : Tanvi Sappal
 * Create Date : 26/Oct/2009
 * Process Name : Supplier Type Master
 * Version : 1.1
 * Modify By/Date : 
 */
public class SupplierTypeMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str hospital name. */
	private String strHospitalName = "";
	
	/** The str Supplier type id. */
	private String strSupplierTypeId = "";
	
	/** The str Supplier type name. */
	private String strSupplierTypeName = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str lstmod date. */
	private String strLstmodDate = "";
	
	/** The str lstmod seat id. */
	private String strLstmodSeatId = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";

	/** The str chk. */
	private String strChk = "";
	
	/** The str chk1. */
	private String strChk1 = "";

	private String strSlNo;
	
	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public String getStrHospitalName() {
		return strHospitalName;
	}

	public void setStrHospitalName(String strHospitalName) {
		this.strHospitalName = strHospitalName;
	}

	public String getStrSupplierTypeId() {
		return strSupplierTypeId;
	}

	public void setStrSupplierTypeId(String strSupplierTypeId) {
		this.strSupplierTypeId = strSupplierTypeId;
	}

	public String getStrSupplierTypeName() {
		return strSupplierTypeName;
	}

	public void setStrSupplierTypeName(String strSupplierTypeName) {
		this.strSupplierTypeName = strSupplierTypeName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	public String getStrLstmodDate() {
		return strLstmodDate;
	}

	public void setStrLstmodDate(String strLstmodDate) {
		this.strLstmodDate = strLstmodDate;
	}

	public String getStrLstmodSeatId() {
		return strLstmodSeatId;
	}

	public void setStrLstmodSeatId(String strLstmodSeatId) {
		this.strLstmodSeatId = strLstmodSeatId;
	}

	public String getStrEntryDate() {
		return strEntryDate;
	}

	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrIsValid() {
		return strIsValid;
	}

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	public String getStrChk() {
		return strChk;
	}

	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStrChk1() {
		return strChk1;
	}

	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

}
