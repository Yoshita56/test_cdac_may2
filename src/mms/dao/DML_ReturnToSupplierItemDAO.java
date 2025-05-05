package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DML_ReturnToSupplierItemDAO {
	
	private final String strProcName = "Pkg_Mms_Dml.Dml_Return_To_Supplier_Item";
	private final String strFileName = "mms.dao.DML_ReturnToSupplierItemDAO";
	private String strHstNumStoreId="0";
	private String strSstNumItemCatNo="10";
	private String strHstNumItemSlNo ="0";
	private String strHstNumStockStatusCode ="1";
    private String strItemId =""; 			   						     
    private String strItemBrandId ="0"; 								
    private String strBatchSlNo = "";									
    private String strHospitalCode = "";  
    private String strInstituteCode = "";
	private String strInstituteSlNo = "";
    private String strSeatId = "";
    private String strGroupId = ""; 			
    private String strApproval_level = "0";
    private String strSubGroupId = "0"; 	
    private String strAccQty = "0";								
    private String strAccQtyUnitId = "0"; 
    private String strReqQty = "0";								
    private String strReqQtyUnitId = "0"; 								
    private String strSanctionQty = "0";							
    private String strSanctionQtyUnitId = "0"; 							
    private String strReturnQty = "0"; 										
    private String strReturnQtyUnitId = "0"; 								
    private String strInhandQty = "0"; 										
    private String strInhandQtyUnitId = ""; 	
    private String strCost = "0"; 
    private String strSupplierId = "";
    private String strRate = "0"; 										
    private String strRateUnitId = ""; 									
    private String strExpiryDate = ""; 	
    private String strManufactureDate = ""; 	
    private String strManufacturerId = ""; 								
    private String strConsumablesFlag = "1"; 								
    private String strReqNo = ""; 										
    private String strErr = "";
    
    private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
    
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrReqQtyUnitId() {
		return strReqQtyUnitId;
	}
	public void setStrReqQtyUnitId(String strReqQtyUnitId) {
		this.strReqQtyUnitId = strReqQtyUnitId;
	}
	public String getStrSanctionQty() {
		return strSanctionQty;
	}
	public void setStrSanctionQty(String strSanctionQty) {
		this.strSanctionQty = strSanctionQty;
	}
	public String getStrSanctionQtyUnitId() {
		return strSanctionQtyUnitId;
	}
	public void setStrSanctionQtyUnitId(String strSanctionQtyUnitId) {
		this.strSanctionQtyUnitId = strSanctionQtyUnitId;
	}
	
	
	public String getStrInhandQty() {
		return strInhandQty;
	}
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}
	public String getStrRate() {
		return strRate;
	}
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}
	public String getStrRateUnitId() {
		return strRateUnitId;
	}
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrManufacturerId() {
		return strManufacturerId;
	}
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}
	public String getStrConsumablesFlag() {
		return strConsumablesFlag;
	}
	public void setStrConsumablesFlag(String strConsumablesFlag) {
		this.strConsumablesFlag = strConsumablesFlag;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}                             				

public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			if(strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if(strBatchSlNo.equals("")) {
				throw new Exception("strBatchSlNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			//check mandatory information
			
			/*//System.out.println( "approval_level->"+ strApproval_level);
			//System.out.println( "store_id->"+ strHstNumStoreId);
			//System.out.println( "stock_status_code->"+strHstNumStockStatusCode);
			//System.out.println( "itemSlNo->"+ strHstNumItemSlNo);
			//System.out.println( "itemcat_no->"+ strSstNumItemCatNo);
			//System.out.println( "item_id->"+ strItemId);
			//System.out.println( "itembrand_id->"+ strItemBrandId);
			//System.out.println( "batch_slno->"+ strBatchSlNo);
			//System.out.println( "hosp_code->"+ strHospitalCode);
			//System.out.println( "group_id->"+ strGroupId);
			//System.out.println( "subgroup_id->"+ strSubGroupId);
			//System.out.println( "acc_qty->"+ strAccQty);
			//System.out.println( "acc_qty_unitid->"+ strAccQtyUnitId);
			//System.out.println( "req_qty->"+ strReqQty);
			//System.out.println( "req_qty_unitid->"+ strReqQtyUnitId);
			//System.out.println( "sanc_qty->"+ strSanctionQty);
			//System.out.println( "sanc_qty_unitid->"+ strSanctionQtyUnitId);
			//System.out.println( "ret_qty->"+ strReturnQty);
			//System.out.println( "ret_qty_unitid->"+strReturnQtyUnitId);
			//System.out.println( "inhand_qty->"+ strInhandQty);
			//System.out.println( "inhand_qty_unitid->"+ strInhandQtyUnitId);
			//System.out.println( "rate->"+ strRate);
			//System.out.println( "rate_unitid->"+ strRateUnitId);
			//System.out.println( "expiry_date->"+ strExpiryDate);
			//System.out.println( "ret_no->"+ strReqNo);
			//System.out.println( "manuf_date->"+ this.strManufactureDate);
			//System.out.println( "cost->"+ this.strCost);
			//System.out.println( "supp_id->"+ this.strSupplierId);
			//System.out.println( "seat_id->"+strSeatId); */
			
		
			nProcIndex = dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			
			
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "approval_level", strApproval_level);
			dao.setProcInValue(nProcIndex, "store_id", strHstNumStoreId);
			dao.setProcInValue(nProcIndex, "stock_status_code",strHstNumStockStatusCode);
			dao.setProcInValue(nProcIndex, "itemSlNo", strHstNumItemSlNo);
			dao.setProcInValue(nProcIndex, "itemcat_no", strSstNumItemCatNo);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "batch_slno", strBatchSlNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "acc_qty", strAccQty);
			dao.setProcInValue(nProcIndex, "acc_qty_unitid", strAccQtyUnitId);
			dao.setProcInValue(nProcIndex, "req_qty", strReqQty);
			dao.setProcInValue(nProcIndex, "req_qty_unitid", strReqQtyUnitId);
			dao.setProcInValue(nProcIndex, "sanc_qty", strSanctionQty);
			dao.setProcInValue(nProcIndex, "sanc_qty_unitid", strSanctionQtyUnitId);
			dao.setProcInValue(nProcIndex, "ret_qty", strReturnQty);
			dao.setProcInValue(nProcIndex, "ret_qty_unitid",strReturnQtyUnitId);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInhandQty);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid", strInhandQtyUnitId);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate);
			dao.setProcInValue(nProcIndex, "ret_no", strReqNo);
			dao.setProcInValue(nProcIndex, "manuf_date",strManufactureDate);
			dao.setProcInValue(nProcIndex, "cost", strCost);
			dao.setProcInValue(nProcIndex, "supp_id",strSupplierId);
			dao.setProcInValue(nProcIndex, "seat_id",strSeatId);
			dao.setProcInValue(nProcIndex, "isvalid", "1");
			dao.setProcOutValue(nProcIndex, "err", 1); 
			dao.setProcOutValue(nProcIndex, "dml_count", 1); 
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1);
				
		    dao.execute(nProcIndex, 1);
		    this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		

	}

	public void reset() {
		strHstNumStoreId="0";
		strSstNumItemCatNo="";
		strHstNumItemSlNo ="0";
		strHstNumStockStatusCode ="1";
	    strItemId =""; 			   						     
	    strItemBrandId ="0"; 								
	    strBatchSlNo = "";									
	    strHospitalCode = "";  
	    strInstituteCode = "";
		strInstituteSlNo = "";
	    strSeatId = "";
	    strGroupId = ""; 			
	    strApproval_level = "0";
	    strSubGroupId = "0"; 	
	    strAccQty = "0";								
	    strAccQtyUnitId = "0"; 
	    strReqQty = "0";								
	    strReqQtyUnitId = "0"; 								
	    strSanctionQty = "0";							
	    strSanctionQtyUnitId = "0"; 							
	    strReturnQty = "0"; 										
	    strReturnQtyUnitId = "0"; 								
	    strInhandQty = "0"; 										
	    strInhandQtyUnitId = ""; 	
	    strCost = "0"; 
	    strSupplierId = "";
	    strRate = "0"; 										
	    strRateUnitId = ""; 									
	    strExpiryDate = ""; 	
	    strManufactureDate = ""; 	
	    strManufacturerId = ""; 								
	    strConsumablesFlag = "1"; 								
	    strReqNo = ""; 										
	    strErr = "";									
	   }
	public String getStrHstNumStoreId() {
		return strHstNumStoreId;
	}
	public void setStrHstNumStoreId(String strHstNumStoreId) {
		this.strHstNumStoreId = strHstNumStoreId;
	}
	public String getStrSstNumItemCatNo() {
		return strSstNumItemCatNo;
	}
	public void setStrSstNumItemCatNo(String strSstNumItemCatNo) {
		this.strSstNumItemCatNo = strSstNumItemCatNo;
	}
	public String getStrHstNumItemSlNo() {
		return strHstNumItemSlNo;
	}
	public void setStrHstNumItemSlNo(String strHstNumItemSlNo) {
		this.strHstNumItemSlNo = strHstNumItemSlNo;
	}
	public String getStrHstNumStockStatusCode() {
		return strHstNumStockStatusCode;
	}
	public void setStrHstNumStockStatusCode(String strHstNumStockStatusCode) {
		this.strHstNumStockStatusCode = strHstNumStockStatusCode;
	}
	public String getStrApproval_level() {
		return strApproval_level;
	}
	public void setStrApproval_level(String strApproval_level) {
		this.strApproval_level = strApproval_level;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrInstituteCode() {
		return strInstituteCode;
	}
	public String getStrInstituteSlNo() {
		return strInstituteSlNo;
	}
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}
	public void setStrInstituteSlNo(String strInstituteSlNo) {
		this.strInstituteSlNo = strInstituteSlNo;
	}
	public String getStrReturnQty() {
		return strReturnQty;
	}
	public String getStrReturnQtyUnitId() {
		return strReturnQtyUnitId;
	}
	public String getStrManufactureDate() {
		return strManufactureDate;
	}
	public void setStrReturnQty(String strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	public void setStrReturnQtyUnitId(String strReturnQtyUnitId) {
		this.strReturnQtyUnitId = strReturnQtyUnitId;
	}
	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}
	public String getStrCost() {
		return strCost;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrAccQty() {
		return strAccQty;
	}
	public String getStrAccQtyUnitId() {
		return strAccQtyUnitId;
	}
	public void setStrAccQty(String strAccQty) {
		this.strAccQty = strAccQty;
	}
	public void setStrAccQtyUnitId(String strAccQtyUnitId) {
		this.strAccQtyUnitId = strAccQtyUnitId;
	}
}
