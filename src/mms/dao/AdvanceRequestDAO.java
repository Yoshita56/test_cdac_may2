package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class AdvanceRequestDAO {
	
	private final String strProcName = "pkg_mms_dml.Dml_Advance_Dtl";
	private final String strFileName = "mms.dao.AdvanceRequestDAO";
	
		
	private String strHospitalCode = "";
	private String strStoreId = "";
	private String strReqNo = "";
	private String strSupplierId = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strPOAmt = "";
	private String strItemCatId = "";
	private String strAdvAmt = "";
	private String strCurrencyId = "";
	private String strAdvStatus = "1";
	private String strDispatchNo = "";
	private String strReqPrefix = "";
	private String strRemarks = "";
	private String strSeatId = "";
	private String strIsValid = "1";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strPOStoreId="";
	
	private String strErr = "";
	private String strRequestNo = "";
	private String strBankAccName = "";
	private String strBankAccNo = "";
		
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrPOAmt() {
		return strPOAmt;
	}
	public void setStrPOAmt(String strPOAmt) {
		this.strPOAmt = strPOAmt;
	}
	public String getStrItemCatId() {
		return strItemCatId;
	}
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	public String getStrAdvAmt() {
		return strAdvAmt;
	}
	public void setStrAdvAmt(String strAdvAmt) {
		this.strAdvAmt = strAdvAmt;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	public String getStrAdvStatus() {
		return strAdvStatus;
	}
	public void setStrAdvStatus(String strAdvStatus) {
		this.strAdvStatus = strAdvStatus;
	}
	public String getStrDispatchNo() {
		return strDispatchNo;
	}
	public void setStrDispatchNo(String strDispatchNo) {
		this.strDispatchNo = strDispatchNo;
	}
	public String getStrReqPrefix() {
		return strReqPrefix;
	}
	public void setStrReqPrefix(String strReqPrefix) {
		this.strReqPrefix = strReqPrefix;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public int getNRowInserted() {
		return nRowInserted;
	}
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}
	public String getStrProcName() {
		return strProcName;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrRequestNo() {
		return strRequestNo;
	}
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	
public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if(strPONo.equals("0") || strPONo.equals("")) {
				throw new Exception("strPONo can not be blank");
			}
			//check mandatory information
		
			nProcIndex = dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
			dao.setProcInValue(nProcIndex, "modval", "1");
			
			dao.setProcInValue(nProcIndex, "storeId", strStoreId);
			dao.setProcInValue(nProcIndex, "reqNo", strReqNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "suppId", strSupplierId);
			dao.setProcInValue(nProcIndex, "po_No", strPONo);
			dao.setProcInValue(nProcIndex, "po_Date", strPODate);
			dao.setProcInValue(nProcIndex, "po_Amt", strPOAmt);
			dao.setProcInValue(nProcIndex, "itemcat_No", strItemCatId);
			dao.setProcInValue(nProcIndex, "adv_Amt", strAdvAmt);
			dao.setProcInValue(nProcIndex, "currencyId", strCurrencyId);
			dao.setProcInValue(nProcIndex, "adv_Status", strAdvStatus);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId);
			dao.setProcInValue(nProcIndex, "isValid", strIsValid);
			dao.setProcInValue(nProcIndex, "reqPrefix", strReqPrefix);
			dao.setProcInValue(nProcIndex, "finStartDate", strFinStartDate);
			dao.setProcInValue(nProcIndex, "finEndDate", strFinEndDate);
			dao.setProcInValue(nProcIndex, "poStoreId", strPOStoreId);
			dao.setProcInValue(nProcIndex, "bankAccName", strBankAccName);
			dao.setProcInValue(nProcIndex, "bankAccNo", strBankAccNo);
			
			dao.setProcInValue(nProcIndex, "dispatchno", "");// Default Value.
			
			dao.setProcOutValue(nProcIndex, "err", 1);
				
		    dao.execute(nProcIndex, 1);
		    this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
}
		public void reset() {
			
			strHospitalCode = "";
			strStoreId = "";
			strReqNo = "";
			strSupplierId = "";
			strPONo = "";
			strPODate = "";
			strPOAmt = "";
			strItemCatId = "";
			strAdvAmt = "";
			strCurrencyId = "";
			strAdvStatus = "1";
			strDispatchNo = "";
			strReqPrefix = "";
			strRemarks = "";
			strSeatId = "";
			strIsValid = "1";
			strReqPrefix = "";
			strPOStoreId = "";
			strBankAccName = "";
			strBankAccNo = "";
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
		public String getStrPOStoreId() {
			return strPOStoreId;
		}
		public void setStrPOStoreId(String strPOStoreId) {
			this.strPOStoreId = strPOStoreId;
		}
		/**
		 * @return the strBankAccName
		 */
		public String getStrBankAccName() {
			return strBankAccName;
		}
		/**
		 * @param strBankAccName the strBankAccName to set
		 */
		public void setStrBankAccName(String strBankAccName) {
			this.strBankAccName = strBankAccName;
		}
		/**
		 * @return the strBankAccNo
		 */
		public String getStrBankAccNo() {
			return strBankAccNo;
		}
		/**
		 * @param strBankAccNo the strBankAccNo to set
		 */
		public void setStrBankAccNo(String strBankAccNo) {
			this.strBankAccNo = strBankAccNo;
		}
		}

