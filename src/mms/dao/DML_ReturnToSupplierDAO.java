package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DML_ReturnToSupplierDAO {
	
	private final String strProcName = "Pkg_Mms_Dml.Dml_Return_To_Supplier";
	private final String strFileName = "mms.dao.DML_ReturnToSupplierDAO";
	
	private String strHospitalCode = "";
	private String strReqDate = "";
	private String strItemCatNo = "";
	private String strIssueDate = "";
	private String strStoreId = "";
	
	private String strReturnStatus = "1";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String strRemarks = "";
	private String strEntryDate = "";
	private String strSeatId = "";
	private String strGnumIsValid = "";
	private String strReturnNo = "";
	
	private String strPONo = "";
	private String strPOStoreId = "";
	private String strPODate = "";
	private String strSupplierId = "";
	private String strReturnType = "";
	private String strDeliveryDate = "";
	private String strReturnFlag = "";
	private String strOnLineFlag = "";
	private String strNetCost = "";
	
	private String strErr = "";
	private String strApproval_level = "0";
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
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public int insert(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			
			if(strReturnNo.equals("0") || strReturnNo.equals("")) {
				throw new Exception("strReturnNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			//check mandatory information
		
			nProcIndex = dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "po_no",this.strPONo);
			dao.setProcInValue(nProcIndex, "ret_no",strReturnNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "req_date", this.strReqDate);
			dao.setProcInValue(nProcIndex, "itemcat_no", strItemCatNo);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "po_store_id", this.strPOStoreId);
			dao.setProcInValue(nProcIndex, "poType_id", "47");
			dao.setProcInValue(nProcIndex, "po_date", this.strPODate);
			dao.setProcInValue(nProcIndex, "supp_id", this.strSupplierId);
			dao.setProcInValue(nProcIndex, "ret_status", this.strReturnStatus);
			dao.setProcInValue(nProcIndex, "ret_flag ", this.strReturnFlag);
			dao.setProcInValue(nProcIndex, "ret_type", this.strReturnType);
			dao.setProcInValue(nProcIndex, "delivery_date", this.strDeliveryDate);
			dao.setProcInValue(nProcIndex, "onLine_flg", this.strOnLineFlag);
			dao.setProcInValue(nProcIndex, "financial_start_date",strFinancialStartYear);
			dao.setProcInValue(nProcIndex, "financial_end_date",strFinancialEndYear);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "entry_date", this.strEntryDate);
			dao.setProcInValue(nProcIndex, "net_cost", this.strNetCost);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId);
			dao.setProcInValue(nProcIndex, "isvalid", this.strGnumIsValid);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "ret_date", "");
			dao.setProcInValue(nProcIndex, "challan_no", "");
			dao.setProcInValue(nProcIndex, "challan_date", "");
			dao.setProcInValue(nProcIndex, "cancel_seatid", "");
			dao.setProcInValue(nProcIndex, "cancel_date", "");
			dao.setProcInValue(nProcIndex, "cancel_remarks", "");
			dao.setProcInValue(nProcIndex, "puk", "0");
			dao.setProcInValue(nProcIndex, "schedule_no", "1");
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1);
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "dml_count", 1);
			dao.setProcOutValue(nProcIndex, "approval_level", 1);
		    dao.execute(nProcIndex, 1);
		    this.nRowInserted++;
		    return nProcIndex;
		    //this.setStrApproval_level(dao.getString(nProcIndex, "approval_level"));
		} 
		catch(Exception e) {
			//e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		
	}
	
   public void update_Return_Details(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			
			if(strReturnNo.equals("0") || strReturnNo.equals("")) {
				throw new Exception("strReturnNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			//check mandatory information
		
			nProcIndex = dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			dao.setProcInValue(nProcIndex, "modval", "2");
			dao.setProcInValue(nProcIndex, "ret_no",strReturnNo);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "itemcat_no", strItemCatNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "ret_status", this.strReturnStatus); 
			dao.setProcInValue(nProcIndex, "ret_flag", this.strReturnFlag);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_no", "");
			dao.setProcInValue(nProcIndex, "req_date", "");
			dao.setProcInValue(nProcIndex, "ret_date", "");
			dao.setProcInValue(nProcIndex, "po_store_id", "");
			dao.setProcInValue(nProcIndex, "potype_id", "47");
			dao.setProcInValue(nProcIndex, "po_date", "");
			dao.setProcInValue(nProcIndex, "supp_id", "");
			dao.setProcInValue(nProcIndex, "ret_type", "1");
			dao.setProcInValue(nProcIndex, "delivery_date", "");
			dao.setProcInValue(nProcIndex, "challan_no", "");
			dao.setProcInValue(nProcIndex, "challan_date", "");
			dao.setProcInValue(nProcIndex, "online_flg", "0");
			dao.setProcInValue(nProcIndex, "financial_start_date", "");
			dao.setProcInValue(nProcIndex, "financial_end_date", "");
			dao.setProcInValue(nProcIndex, "entry_date", "");
			dao.setProcInValue(nProcIndex, "net_cost", "0");
			dao.setProcInValue(nProcIndex, "seat_id", "");
			dao.setProcInValue(nProcIndex, "isvalid", "1");
			dao.setProcInValue(nProcIndex, "cancel_seatid", "");
			dao.setProcInValue(nProcIndex, "cancel_date", "");
			dao.setProcInValue(nProcIndex, "cancel_remarks", "");
			dao.setProcInValue(nProcIndex, "puk", "0");
			dao.setProcInValue(nProcIndex, "schedule_no", "1");
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1);     
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1);
			dao.setProcOutValue(nProcIndex, "dml_count", 1);
			dao.setProcOutValue(nProcIndex, "approval_level", 1);
			
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
	
public void modify_Return_Request_Details(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			
			if(strReturnNo.equals("0") || strReturnNo.equals("")) {
				throw new Exception("strReturnNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			//check mandatory information
		
			nProcIndex = dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			dao.setProcInValue(nProcIndex, "modval", "4");
			dao.setProcInValue(nProcIndex, "ret_no",strReturnNo);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "ret_type", this.strReturnType);
			dao.setProcInValue(nProcIndex, "delivery_date", this.strDeliveryDate);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_no", "");
			dao.setProcInValue(nProcIndex, "req_date", "");
			dao.setProcInValue(nProcIndex, "itemcat_no", "1");
			dao.setProcInValue(nProcIndex, "ret_date", "");
			dao.setProcInValue(nProcIndex, "po_store_id", "");
			dao.setProcInValue(nProcIndex, "potype_id", "47");
			dao.setProcInValue(nProcIndex, "po_date", "");
			dao.setProcInValue(nProcIndex, "supp_id", "");
			dao.setProcInValue(nProcIndex, "ret_status", "1");
			dao.setProcInValue(nProcIndex, "ret_flag", "1");
			dao.setProcInValue(nProcIndex, "challan_no", "");
			dao.setProcInValue(nProcIndex, "challan_date", "");
			dao.setProcInValue(nProcIndex, "online_flg", "0");
			dao.setProcInValue(nProcIndex, "financial_start_date", "");
			dao.setProcInValue(nProcIndex, "financial_end_date", "");
			dao.setProcInValue(nProcIndex, "entry_date", "");
			dao.setProcInValue(nProcIndex, "net_cost", "0");
			dao.setProcInValue(nProcIndex, "seat_id", "");
			dao.setProcInValue(nProcIndex, "isvalid", "1");
			dao.setProcInValue(nProcIndex, "cancel_seatid", "");
			dao.setProcInValue(nProcIndex, "cancel_date", "");
			dao.setProcInValue(nProcIndex, "cancel_remarks", "");
			dao.setProcInValue(nProcIndex, "puk", "0");
			dao.setProcInValue(nProcIndex, "schedule_no", "1");
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1);     
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1);
			dao.setProcOutValue(nProcIndex, "dml_count", 1);
			dao.setProcOutValue(nProcIndex, "approval_level", 1);
			
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
			strReqDate = "";
			strItemCatNo = "";
			strReturnStatus = "1";
			strFinancialStartYear = "";
			strFinancialEndYear = "";
			strRemarks = "";
			strSeatId = "";
			strStoreId = "";
			strIssueDate = "";
			strEntryDate = "";
			strSeatId = "";
			strReturnNo = "";
			}
		public String getStrGnumIsValid() {
			return strGnumIsValid;
		}
		public void setStrGnumIsValid(String strGnumIsValid) {
			this.strGnumIsValid = strGnumIsValid;
		}
	
		public String getStrApproval_level() {
			return strApproval_level;
		}
		public void setStrApproval_level(String strApproval_level) {
			this.strApproval_level = strApproval_level;
		}
		public String getStrReturnNo() {
			return strReturnNo;
		}
		public void setStrReturnNo(String strReturnNo) {
			this.strReturnNo = strReturnNo;
		}
		public String getStrReturnStatus() {
			return strReturnStatus;
		}
		public String getStrPONo() {
			return strPONo;
		}
		public String getStrPOStoreId() {
			return strPOStoreId;
		}
		public String getStrPODate() {
			return strPODate;
		}
		public String getStrSupplierId() {
			return strSupplierId;
		}
		public String getStrReturnType() {
			return strReturnType;
		}
		public String getStrDeliveryDate() {
			return strDeliveryDate;
		}
		public String getStrReturnFlag() {
			return strReturnFlag;
		}
		public void setStrReturnStatus(String strReturnStatus) {
			this.strReturnStatus = strReturnStatus;
		}
		public void setStrPONo(String strPONo) {
			this.strPONo = strPONo;
		}
		public void setStrPOStoreId(String strPOStoreId) {
			this.strPOStoreId = strPOStoreId;
		}
		public void setStrPODate(String strPODate) {
			this.strPODate = strPODate;
		}
		public void setStrSupplierId(String strSupplierId) {
			this.strSupplierId = strSupplierId;
		}
		public void setStrReturnType(String strReturnType) {
			this.strReturnType = strReturnType;
		}
		public void setStrDeliveryDate(String strDeliveryDate) {
			this.strDeliveryDate = strDeliveryDate;
		}
		public void setStrReturnFlag(String strReturnFlag) {
			this.strReturnFlag = strReturnFlag;
		}
		public String getStrOnLineFlag() {
			return strOnLineFlag;
		}
		public String getStrNetCost() {
			return strNetCost;
		}
		public void setStrOnLineFlag(String strOnLineFlag) {
			this.strOnLineFlag = strOnLineFlag;
		}
		public void setStrNetCost(String strNetCost) {
			this.strNetCost = strNetCost;
		}
		}
