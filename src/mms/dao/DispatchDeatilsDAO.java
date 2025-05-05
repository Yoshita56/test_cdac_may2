package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DispatchDeatilsDAO {
	private final String strFileName = "mms.dao.AdvanceDetailsDAO";
	
	private String strStoreId="";
	private String strDispatchNo="";
	private String strHospitalCode="";
	private String strPoNo="";
	private String strPoDate="";
	private String strSupplierId="";
	private String strInsRecDate="";
	private String strInsNo="";
	private String strInsDate="";
	private String strInsType="";
	private String strInsAmt="";
	private String strDispatchFor="";
	private String strValidity="";
	private String strBankName="";
	private String strDispatchModeId="";
	private String strRemarks="";
	private String strSeatId="";
	private String strCurrValuePO = "";
	private String strCurrValue = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strCurrencyId = "";
	private String strPOStoreId="";
	
	
	private String strErr = "";
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	/**
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}
	/**
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	/**
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	/**
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	/**
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	/**
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @param strDispatchNo the strDispatchNo to set
	 */
	public void setStrDispatchNo(String strDispatchNo) {
		this.strDispatchNo = strDispatchNo;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @param strPoNo the strPoNo to set
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	/**
	 * @param strPoDate the strPoDate to set
	 */
	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}
	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	/**
	 * @param strInsRecDate the strInsRecDate to set
	 */
	public void setStrInsRecDate(String strInsRecDate) {
		this.strInsRecDate = strInsRecDate;
	}
	/**
	 * @param strInsNo the strInsNo to set
	 */
	public void setStrInsNo(String strInsNo) {
		this.strInsNo = strInsNo;
	}
	/**
	 * @param strInsDate the strInsDate to set
	 */
	public void setStrInsDate(String strInsDate) {
		this.strInsDate = strInsDate;
	}
	/**
	 * @param strInsType the strInsType to set
	 */
	public void setStrInsType(String strInsType) {
		this.strInsType = strInsType;
	}
	/**
	 * @param strInsAmt the strInsAmt to set
	 */
	public void setStrInsAmt(String strInsAmt) {
		this.strInsAmt = strInsAmt;
	}
	/**
	 * @param strDispatchFor the strDispatchFor to set
	 */
	public void setStrDispatchFor(String strDispatchFor) {
		this.strDispatchFor = strDispatchFor;
	}
	/**
	 * @param strValidity the strValidity to set
	 */
	public void setStrValidity(String strValidity) {
		this.strValidity = strValidity;
	}
	/**
	 * @param strDispatchModeId the strDispatchModeId to set
	 */
	public void setStrDispatchModeId(String strDispatchModeId) {
		this.strDispatchModeId = strDispatchModeId;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**This method is used to insert the data in HSTT_CHEQUE_DISPATCH_DTL
	 * @param dao 
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";
	
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strDispatchNo.equals("0") || strDispatchNo.equals("")) {
				throw new Exception("strDispatchNo can not be blank");
			}
			if (strPoNo.equals("0") || strPoNo.equals("")) {
				throw new Exception("strPoNo can not be blank");
			}
			
			
			proc_name = "{call Pkg_Mms_Dml.Dml_dispatch_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

					
			dao.setProcInValue(nprocIndex,"modval","1");
			dao.setProcInValue(nprocIndex,"storeId",strStoreId);
			dao.setProcInValue(nprocIndex,"dispatchNo",strDispatchNo);
			dao.setProcInValue(nprocIndex,"hosp_code",strHospitalCode);
			dao.setProcInValue(nprocIndex,"poNo",strPoNo);
			dao.setProcInValue(nprocIndex,"poDate",strPoDate);
			dao.setProcInValue(nprocIndex,"supplierId",strSupplierId);
			dao.setProcInValue(nprocIndex,"insRecDate",strInsRecDate);
			dao.setProcInValue(nprocIndex,"insNo",strInsNo);
			dao.setProcInValue(nprocIndex,"insDate",strInsDate);
			dao.setProcInValue(nprocIndex,"insType",strInsType);
			dao.setProcInValue(nprocIndex,"insAmt",strInsAmt);
			dao.setProcInValue(nprocIndex,"dispatchFor",strDispatchFor);
			dao.setProcInValue(nprocIndex,"validity",strValidity);
			dao.setProcInValue(nprocIndex,"bankName",strBankName);
			dao.setProcInValue(nprocIndex,"dispatchModeId",strDispatchModeId);
			dao.setProcInValue(nprocIndex,"remarks",strRemarks);
			dao.setProcInValue(nprocIndex,"seatId",strSeatId);
			dao.setProcInValue(nprocIndex,"currValuePo",strCurrValuePO);
			dao.setProcInValue(nprocIndex,"currValue",strCurrValue);
			dao.setProcInValue(nprocIndex,"finStartDate",strFinStartDate);
			dao.setProcInValue(nprocIndex,"finEndDate",strFinEndDate);
			dao.setProcInValue(nprocIndex,"currId",strCurrencyId);
			dao.setProcInValue(nprocIndex,"poStoreId",strPOStoreId);
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			
			dao.execute(nprocIndex,1);
			
		
			this.nInsertedIndex ++ ;
			
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	/**This Method is used to reset all the data
	 *
	 */
	public void reset() {

	
	
		 strStoreId="";
		strDispatchNo="";
		strHospitalCode="";
		strPoNo="";
		strPoDate="";
		strSupplierId="";
		strInsRecDate="";
		strInsNo="";
		strInsDate="";
		strInsType="";
		strInsAmt="";
		strDispatchFor="";
		strValidity="";
		strBankName="";
		strDispatchModeId="";
		strRemarks="";
		strSeatId="";
		strPOStoreId = "";
		

	}
	/**
	 * @param strBankName the strBankName to set
	 */
	public void setStrBankName(String strBankName) {
		this.strBankName = strBankName;
	}
	public String getStrCurrValuePO() {
		return strCurrValuePO;
	}
	public void setStrCurrValuePO(String strCurrValuePO) {
		this.strCurrValuePO = strCurrValuePO;
	}
	public String getStrCurrValue() {
		return strCurrValue;
	}
	public void setStrCurrValue(String strCurrValue) {
		this.strCurrValue = strCurrValue;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
}
