package mms.masters.controller.fb;

import org.apache.struts.upload.FormFile;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CircularMstFB.
 */
public class CircularMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	
	FormFile strCircularFileUploadx=null;
	public FormFile getStrCircularFileUploadx() {
		return strCircularFileUploadx;
	}

	public void setStrCircularFileUploadx(FormFile strCircularFileUploadx) {
		this.strCircularFileUploadx = strCircularFileUploadx;
	}
	
	public String getCircularId() {
		return circularId;
	}

	public void setCircularId(String circularId) {
		this.circularId = circularId;
	}
	private String test = "";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	private String circularId = "";
	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str invoice type id. */
	private String strInvoiceTypeId = "";
	
	private String strCircularId = "";
	/** The str invoice type name. */
	private String strInvoiceTypeName = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	private String strInvoiceType="0";
	
	private String strCircularDate="";
	
	private String strCircular="";
	
	private String strCircularName="";
	
	
	private FormFile strCircularFileUpload=null;
	
	private String strCircularLink = "";
	
	private String strCircularSubject = "";

	/**
	 * @return the strInvoiceType
	 */
	public String getStrInvoiceType() {
		return strInvoiceType;
	}

	/**
	 * @param strInvoiceType the strInvoiceType to set
	 */
	public void setStrInvoiceType(String strInvoiceType) {
		this.strInvoiceType = strInvoiceType;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str invoice type id.
	 * 
	 * @return the strInvoiceTypeId
	 */
	public String getStrInvoiceTypeId() {
		return strInvoiceTypeId;
	}

	/**
	 * Sets the str invoice type id.
	 * 
	 * @param strInvoiceTypeId the strInvoiceTypeId to set
	 */
	public void setStrInvoiceTypeId(String strInvoiceTypeId) {
		this.strInvoiceTypeId = strInvoiceTypeId;
	}

	/**
	 * Gets the str invoice type name.
	 * 
	 * @return the strInvoiceTypeName
	 */
	public String getStrInvoiceTypeName() {
		return strInvoiceTypeName;
	}

	/**
	 * Sets the str invoice type name.
	 * 
	 * @param strInvoiceTypeName the strInvoiceTypeName to set
	 */
	public void setStrInvoiceTypeName(String strInvoiceTypeName) {
		this.strInvoiceTypeName = strInvoiceTypeName;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the strLastModifiedDate
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the strLastModifiedDate to set
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
	}

	/**
	 * Gets the str last modified seat id.
	 * 
	 * @return the strLastModifiedSeatId
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the strLastModifiedSeatId to set
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	public String getStrCircularDate() {
		return strCircularDate;
	}

	public void setStrCircularDate(String strCircularDate) {
		this.strCircularDate = strCircularDate;
	}

	public String getStrCircularName() {
		return strCircularName;
	}

	public void setStrCircularName(String strCircularName) {
		this.strCircularName = strCircularName;
	}

	public String getStrCircularLink() {
		return strCircularLink;
	}

	public void setStrCircularLink(String strCircularLink) {
		this.strCircularLink = strCircularLink;
	}

	public String getStrCircularSubject() {
		return strCircularSubject;
	}

	public void setStrCircularSubject(String strCircularSubject) {
		this.strCircularSubject = strCircularSubject;
	}

	public String getStrCircular() {
		return strCircular;
	}

	public void setStrCircular(String strCircular) {
		this.strCircular = strCircular;
	}
	public FormFile getStrCircularFileUpload() {
		return strCircularFileUpload;
	}

	public void setStrCircularFileUpload(FormFile strCircularFileUpload) {
		this.strCircularFileUpload = strCircularFileUpload;
	}

	public String getStrCircularId() {
		return strCircularId;
	}

	public void setStrCircularId(String strCircularId) {
		this.strCircularId = strCircularId;
	}
}
