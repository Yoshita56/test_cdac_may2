package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO {
	
	private final String strFileName = "mms.dao.DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO";
	
	private String strEmpNo= "";
	private String strReqTypeId = "";
	 private String strCrNo = ""; 
	 private String strEpisodeCode = ""; 
	 private String strVisitNo= ""; 
	 private String strAdmNo= ""; 
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strCost = "";
	private String strItemCatNo = "";
	private String strStoreId = "";
	private String strIssueNo = "";
	private String strItemId = "";
	private String strItemBrandId = "";
	private String strBatchSlNo = "";
	private String strItemSlNo = "0";
	private String strStockStatusCode = "1";
	private String strGroupId = "";
	private String strSubGroupId = "0";
	private String strInHandQty = "0";
	private String strInHandQtyUnitId = "";
	private String strBalQty = "0";
	private String strBalQtyUnitId = "";
	private String strIssueQty = "0";
	private String strIssueQtyUnitId = "";
	private String strManufDate = "";
	private String strExpiryDate = "";
	private String strRate = "0";
	private String strRateUnitId = "";
	private String strRemarks = "";
	private String strDescription = ""; 
	private String strItemCost = ""; 
	private String strConsumableFlag = ""; 
	private String strReqNo = "";
	private String strOrderBy = "";
	private String strDays = "";
	private String strIsUpdateOpdDrugReqDtl = "";
	private String strDosage = "";
	private String strFrequency = "";
	private String strPresDays = "";
	private String strPatientName="";
	private String strDrugIssueDate="";
	private static int intCost=0;
	
	private String strErr = "";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	//These fields Added By Vivek
	
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
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
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
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
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
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
	public String getStrInHandQty() {
		return strInHandQty;
	}
	public void setStrInHandQty(String strInHandQty) {
		this.strInHandQty = strInHandQty;
	}
	public String getStrInHandQtyUnitId() {
		return strInHandQtyUnitId;
	}
	public void setStrInHandQtyUnitId(String strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}
	public String getStrBalQty() {
		return strBalQty;
	}
	public void setStrBalQty(String strBalQty) {
		this.strBalQty = strBalQty;
	}
	public String getStrBalQtyUnitId() {
		return strBalQtyUnitId;
	}
	public void setStrBalQtyUnitId(String strBalQtyUnitId) {
		this.strBalQtyUnitId = strBalQtyUnitId;
	}
	public String getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	public String getStrIssueQtyUnitId() {
		return strIssueQtyUnitId;
	}
	public void setStrIssueQtyUnitId(String strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}
	public String getStrManufDate() {
		return strManufDate;
	}
	public void setStrManufDate(String strManufDate) {
		this.strManufDate = strManufDate;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
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
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String getStrFileName() {
		return strFileName;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//36        
			nProcIndex = dao.setProcedure(strProcName);
			
			
//			//System.out.println("issue no---"+strIssueNo); 
//			//System.out.println("req no---"+strReqNo); 
//			//System.out.println("hosp code---"+strHospitalCode); 
//			//System.out.println("store id---"+strStoreId); 
//			//System.out.println("item id---"+strItemId );
//			//System.out.println("brand id---"+strItemBrandId );
//			//System.out.println("batch slno---"+strBatchSlNo);
//			//System.out.println("item slno---"+strItemSlNo);
//			//System.out.println("stockstatus---"+strStockStatusCode);
//			//System.out.println("grpid----"+strGroupId);
//			//System.out.println("subgrpid---"+strSubGroupId);
//			//System.out.println("rate---"+strRate); 
//			//System.out.println("rateunit----"+strRateUnitId);
//			//System.out.println("bal---"+strBalQty );
//			//System.out.println("balunit---"+strBalQtyUnitId);
//			//System.out.println("issue---"+strIssueQty);
//			//System.out.println("issueunit---"+strIssueQtyUnitId);
//			//System.out.println("inhand---"+strInHandQty);
//			//System.out.println("inhandunit---"+strInHandQtyUnitId ); 
//			//System.out.println("manudate----"+strManufDate); 
//			//System.out.println("expdate----"+strExpiryDate); 
//			//System.out.println("remarks---"+strRemarks ); 
			
			                                   
		
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNo); 
			dao.setProcInValue(nProcIndex, "req_No", strReqNo); 
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode); 
			dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId); 
			dao.setProcInValue(nProcIndex, "item_id",strItemId );
			dao.setProcInValue(nProcIndex, "item_brand_id",strItemBrandId );
			dao.setProcInValue(nProcIndex, "batchSl_no", strBatchSlNo);
			dao.setProcInValue(nProcIndex, "item_SlNo",strItemSlNo);
			dao.setProcInValue(nProcIndex, "stock_status_code", strStockStatusCode);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "rate", strRate); 
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId);
			dao.setProcInValue(nProcIndex, "bal_qty",strBalQty );
			dao.setProcInValue(nProcIndex, "bal_qty_unitid", strBalQtyUnitId);
			dao.setProcInValue(nProcIndex, "issue_qty",strIssueQty);
			dao.setProcInValue(nProcIndex, "issue_qty_unitid", strIssueQtyUnitId);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInHandQty);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid",strInHandQtyUnitId ); 
			dao.setProcInValue(nProcIndex, "manuf_date", strManufDate); 
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate); 
			dao.setProcInValue(nProcIndex, "remarks",strRemarks); 
			dao.setProcInValue(nProcIndex, "crNo",strCrNo);
			dao.setProcInValue(nProcIndex, "empNo",strEmpNo);
			dao.setProcInValue(nProcIndex, "strEpiCode",strEpisodeCode);
			dao.setProcInValue(nProcIndex, "strVisitNo",strVisitNo);
			dao.setProcInValue(nProcIndex, "strAdmNo",strAdmNo);
			dao.setProcInValue(nProcIndex, "strOrderBy",strOrderBy);
			dao.setProcInValue(nProcIndex, "days",strDays);
			dao.setProcInValue(nProcIndex, "reqType_id",strReqTypeId);
			dao.setProcInValue(nProcIndex, "category_No",strItemCatNo);
			
			dao.setProcInValue(nProcIndex, "reserved_qty_flag","1");
			dao.setProcInValue(nProcIndex, "comsumable_flag","");
			dao.setProcInValue(nProcIndex, "cost","");
			dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl","1");
			dao.setProcInValue(nProcIndex, "seatId","");
		
			dao.setProcInValue(nProcIndex, "dosage",strDosage);
			dao.setProcInValue(nProcIndex, "frequency",strFrequency);
			dao.setProcInValue(nProcIndex, "presdays",strPresDays);
			
			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "costOut", 1);
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			//this.reset(); // to reset the variables
		}
	}
		public void insert1(HisDAO dao) throws Exception {

			strErr = "";
			String strProcName = "";
			int nProcIndex = 0;

			try {
			
				// check mandatory information
				if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
					throw new Exception("strHospitalCode can not be blank");
				}
		
				strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";//44
				nProcIndex = dao.setProcedure(strProcName);
				 
//					 //System.out.println( "modeval"+ "2");
//					 //System.out.println( "issuing_store_id"+ strStoreId); 
//					 //System.out.println( "issueNo"+ strIssueNo); 
//					 //System.out.println( "req_No"+ strReqNo); 
//					 //System.out.println( "item_id"+strItemId);
//					 //System.out.println( "item_brand_id"+strItemBrandId);
//					 //System.out.println( "hospital_code"+ strHospitalCode); 
//					 //System.out.println( "group_id"+ strGroupId);
//					 //System.out.println( "subgroup_id"+ strSubGroupId);
//					 //System.out.println( "bal_qty"+strBalQty);
//					 //System.out.println( "bal_qty_unitid"+ strBalQtyUnitId);
//					 //System.out.println( "remarks"+strRemarks);
//					 //System.out.println( "category_No"+strItemCatNo);
//					 //System.out.println( "issue_qty"+strIssueQty);
//					 //System.out.println( "issue_qty_unitid"+ strIssueQtyUnitId);
//				 	//System.out.println("crNo"+strCrNo);
//					//System.out.println("empNo"+strEmpNo);
//					//System.out.println("strEpiCode"+strEpisodeCode);
//					//System.out.println("strVisitNo"+strVisitNo);
//					//System.out.println("strAdmNo"+strAdmNo);
//					//System.out.println("strOrderBy"+strOrderBy);
//					//System.out.println("days"+strDays);
//					//System.out.println("reqType_id"+strReqTypeId);
//					
//					//System.out.println("dosage"+strDosage);
//					//System.out.println("frequency"+strFrequency);
//					//System.out.println("presdays"+strPresDays);
//					
//					//System.out.println("reserved_qty_flag"+"1");
//					//System.out.println("batchSl_no"+strBatchSlNo);
//					//System.out.println("item_SlNo"+"0");
//					//System.out.println("stock_status_code"+strStockStatusCode);
//					//System.out.println("inhand_qty"+strInHandQty);
//					//System.out.println("inhand_qty_unitid"+strInHandQtyUnitId);
//					//System.out.println("manuf_date"+strManufDate);
//					//System.out.println("expiry_date"+strExpiryDate);
//					//System.out.println("rate"+strRate);
//					//System.out.println("rate_unitid"+strRateUnitId);
				
				if(strGroupId == null) strGroupId = "0";
				if(strSubGroupId == null) strSubGroupId = "0";
				if(strBalQtyUnitId == null) strBalQtyUnitId = "6301";
				if(strRemarks == null) strRemarks = "--";
				if(strIssueQty == null) strIssueQty = "0";
				if(strBalQty == null) strBalQty = "0";
				if(strIssueQtyUnitId == null) strIssueQtyUnitId = "6301";
				if(strCrNo == null) strCrNo = "0";
				if(strEmpNo == null) strEmpNo = "0";
				if(strEpisodeCode == null) strEpisodeCode = "0";
				if(strVisitNo == null) strVisitNo = "0";
				if(strAdmNo == null) strAdmNo = "0";
				if(strOrderBy == null) strOrderBy = "";
				if(strDays == null) strDays = "0";
				if(strDosage == null) strDosage = "0";
				if(strFrequency == null) strFrequency = "0";
				if(strPresDays == null) strPresDays = "0";
				if(strBatchSlNo == null) strBatchSlNo = "0";
				if(strStockStatusCode == null) strStockStatusCode = "10";
				if(strInHandQtyUnitId == null) strInHandQtyUnitId = "6301";
				if(strInHandQty == null) strInHandQty = "0";
				if(strManufDate == null) strManufDate = "01-jan-2012";
				if(strRate == null) strRate = "0";
				if(strRateUnitId == null) strRateUnitId = "6301";
				if(strPatientName == null) strPatientName = "--";
				if(strDrugIssueDate == null) strDrugIssueDate = "";
				
				
				
				dao.setProcInValue(nProcIndex, "modeval", "1");
				dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId); 
				dao.setProcInValue(nProcIndex, "issueNo", strIssueNo); 
				dao.setProcInValue(nProcIndex, "req_No", strReqNo); 
				dao.setProcInValue(nProcIndex, "item_id",strItemId);
				dao.setProcInValue(nProcIndex, "item_brand_id",strItemBrandId);
				dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode); 
				dao.setProcInValue(nProcIndex, "group_id", strGroupId);
				dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
				dao.setProcInValue(nProcIndex, "bal_qty",strBalQty);
				dao.setProcInValue(nProcIndex, "bal_qty_unitid", strBalQtyUnitId);
				dao.setProcInValue(nProcIndex, "remarks",strRemarks);
				dao.setProcInValue(nProcIndex, "category_No",strItemCatNo);
				dao.setProcInValue(nProcIndex, "issue_qty",strIssueQty);
				dao.setProcInValue(nProcIndex, "issue_qty_unitid", strIssueQtyUnitId);
				dao.setProcInValue(nProcIndex, "crNo",strCrNo);
				dao.setProcInValue(nProcIndex, "empNo",strEmpNo);
				dao.setProcInValue(nProcIndex, "strEpiCode",strEpisodeCode);
				dao.setProcInValue(nProcIndex, "strVisitNo",strVisitNo);
				dao.setProcInValue(nProcIndex, "strAdmNo",strAdmNo);
				dao.setProcInValue(nProcIndex, "strOrderBy",strOrderBy);
				dao.setProcInValue(nProcIndex, "days",strDays);
				dao.setProcInValue(nProcIndex, "reqType_id",strReqTypeId);				
				dao.setProcInValue(nProcIndex, "dosage",strDosage);
				dao.setProcInValue(nProcIndex, "frequency",strFrequency);
				dao.setProcInValue(nProcIndex, "presdays",strPresDays);				
				dao.setProcInValue(nProcIndex, "reserved_qty_flag","1");
				dao.setProcInValue(nProcIndex, "batchSl_no",strBatchSlNo);
				dao.setProcInValue(nProcIndex, "item_SlNo","0");
				dao.setProcInValue(nProcIndex, "stock_status_code",strStockStatusCode);
				dao.setProcInValue(nProcIndex, "inhand_qty",strInHandQty);
				dao.setProcInValue(nProcIndex, "inhand_qty_unitid",strInHandQtyUnitId);
				dao.setProcInValue(nProcIndex, "manuf_date",strManufDate);
				dao.setProcInValue(nProcIndex, "expiry_date",strExpiryDate);
				dao.setProcInValue(nProcIndex, "rate",strRate);
				dao.setProcInValue(nProcIndex, "rate_unitid",strRateUnitId);
				dao.setProcInValue(nProcIndex, "comsumable_flag","0");
				dao.setProcInValue(nProcIndex, "cost","0");
				dao.setProcInValue(nProcIndex, "seatId",strSeatId);
				dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl","1");
				dao.setProcInValue(nProcIndex, "patName",strPatientName);
				dao.setProcInValue(nProcIndex, "issueDate",strDrugIssueDate);
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "costOut", 1);
				
				dao.execute(nProcIndex, 1);
				this.nRowInserted++;
			} catch (Exception e) {
				e.printStackTrace();

				this.strErr = e.getMessage();
				throw new Exception(strFileName + ".insert1() --> " + this.strErr);
			} finally {
				this.reset(); // to reset the variables
			}
		}	
		
		public void insert2(HisDAO dao) throws Exception {

			strErr = "";
			String strProcName = "";
			int nProcIndex = 0;

			try {
				// check mandatory information
				if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
					throw new Exception("strHospitalCode can not be blank");
				}
				strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//43              
				nProcIndex = dao.setProcedure(strProcName);
				
			
//				//System.out.println("issue no---"+strIssueNo); 
//				//System.out.println("req no---"+strReqNo); 
//				//System.out.println("hosp code---"+strHospitalCode); 
//				//System.out.println("store id---"+strStoreId); 
//				//System.out.println("item id---"+strItemId );
//				//System.out.println("brand id---"+strItemBrandId );
//				//System.out.println("batch slno---"+strBatchSlNo);
//				//System.out.println("item slno---"+strItemSlNo);
//				//System.out.println("stockstatus---"+strStockStatusCode);
//				//System.out.println("grpid----"+strGroupId);
//				//System.out.println("subgrpid---"+strSubGroupId);
//				//System.out.println("rate---"+strRate); 
//				//System.out.println("rateunit----"+strRateUnitId);
//				//System.out.println("bal---"+strBalQty );
//				//System.out.println("balunit---"+strBalQtyUnitId);
//				//System.out.println("issue---"+strIssueQty);
//				//System.out.println("issueunit---"+strIssueQtyUnitId);
//				//System.out.println("inhand---"+strInHandQty);
//				//System.out.println("inhandunit---"+strInHandQtyUnitId ); 
//				//System.out.println("manudate----"+strManufDate); 
//				//System.out.println("expdate----"+strExpiryDate); 
//				//System.out.println("remarks---"+strRemarks ); 
								
				dao.setProcInValue(nProcIndex, "modeval", "3");
				dao.setProcInValue(nProcIndex, "issueNo", strIssueNo); 
				dao.setProcInValue(nProcIndex, "req_No", strReqNo); 
				dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode); 
				dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId); 
				dao.setProcInValue(nProcIndex, "item_id",strItemId );
				dao.setProcInValue(nProcIndex, "item_brand_id",strItemBrandId );
				dao.setProcInValue(nProcIndex, "batchSl_no", strBatchSlNo);
				dao.setProcInValue(nProcIndex, "item_SlNo",strItemSlNo);
				dao.setProcInValue(nProcIndex, "stock_status_code", strStockStatusCode);
				dao.setProcInValue(nProcIndex, "group_id", strGroupId);
				dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
				dao.setProcInValue(nProcIndex, "rate", strRate); 
				dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId);
				dao.setProcInValue(nProcIndex, "bal_qty",strBalQty );
				dao.setProcInValue(nProcIndex, "bal_qty_unitid", strBalQtyUnitId);
				dao.setProcInValue(nProcIndex, "issue_qty",strIssueQty);
				dao.setProcInValue(nProcIndex, "issue_qty_unitid", strIssueQtyUnitId);
				dao.setProcInValue(nProcIndex, "inhand_qty", strInHandQty);
				dao.setProcInValue(nProcIndex, "inhand_qty_unitid",strInHandQtyUnitId ); 
				dao.setProcInValue(nProcIndex, "manuf_date", strManufDate); 
				dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate); 
				dao.setProcInValue(nProcIndex, "remarks",strRemarks); 
				dao.setProcInValue(nProcIndex, "cost",strCost);
				dao.setProcInValue(nProcIndex, "crNo",strCrNo);
				dao.setProcInValue(nProcIndex, "empNo",strEmpNo);
				dao.setProcInValue(nProcIndex, "strEpiCode",strEpisodeCode);
				dao.setProcInValue(nProcIndex, "strVisitNo",strVisitNo);
				dao.setProcInValue(nProcIndex, "strAdmNo",strAdmNo);
				dao.setProcInValue(nProcIndex, "strOrderBy",strOrderBy);
				dao.setProcInValue(nProcIndex, "days",strDays);
				dao.setProcInValue(nProcIndex, "reqType_id",strReqTypeId);
				dao.setProcInValue(nProcIndex, "category_No",strItemCatNo);
					
				
				dao.setProcInValue(nProcIndex, "dosage",strDosage);
				dao.setProcInValue(nProcIndex, "frequency",strFrequency);
				dao.setProcInValue(nProcIndex, "presdays",strPresDays);
				
				dao.setProcInValue(nProcIndex, "reserved_qty_flag","1");
				dao.setProcInValue(nProcIndex, "comsumable_flag","");
				dao.setProcInValue(nProcIndex, "seatId","");
				dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl","1");
				dao.setProcInValue(nProcIndex, "patName",strPatientName);			
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "costOut",1);
				dao.execute(nProcIndex, 1);
				this.nRowInserted++;
			} catch (Exception e) {
				e.printStackTrace();

				this.strErr = e.getMessage();
				throw new Exception(strFileName + ".insert() --> " + this.strErr);
			} finally {
				//this.reset(); // to reset the variables
			}
		}
		
	public void reset() {
		strSeatId = "";
		strHospitalCode = "";
		strStoreId = "";
		strIssueNo = "";
		strItemId = "";
		strItemBrandId = "";
		strBatchSlNo = "";
		strItemSlNo = "0";
		strStockStatusCode = "1";
		strGroupId = "";
		strSubGroupId = "0";
		strInHandQty = "0";
		strInHandQtyUnitId = "";
		strBalQty = "0";
		strBalQtyUnitId = "";
		strIssueQty = "0";
		strIssueQtyUnitId = "";
		strManufDate = "";
		strExpiryDate = "";
		strRate = "0";
		strRateUnitId = "";
		strRemarks = "";
	}
	public String getStrItemCost() {
		return strItemCost;
	}
	public void setStrItemCost(String strItemCost) {
		this.strItemCost = strItemCost;
	}
	public String getStrConsumableFlag() {
		return strConsumableFlag;
	}
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public void setStrIsUpdateOpdDrugReqDtl(String strIsUpdateOpdDrugReqDtl) {
		this.strIsUpdateOpdDrugReqDtl = strIsUpdateOpdDrugReqDtl;
	}
	public String getStrIsUpdateOpdDrugReqDtl() {
		return strIsUpdateOpdDrugReqDtl;
	}
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}
	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
	}
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}
	public void setStrOrderBy(String strOrderBy) {
		this.strOrderBy = strOrderBy;
	}
	public String getStrDays() {
		return strDays;
	}
	public void setStrDays(String strDays) {
		this.strDays = strDays;
	}
	/**
	 * @return the strDosage
	 */
	public String getStrDosage() {
		return strDosage;
	}
	/**
	 * @param strDosage the strDosage to set
	 */
	public void setStrDosage(String strDosage) {
		this.strDosage = strDosage;
	}
	/**
	 * @return the strFrequency
	 */
	public String getStrFrequency() {
		return strFrequency;
	}
	/**
	 * @param strFrequency the strFrequency to set
	 */
	public void setStrFrequency(String strFrequency) {
		this.strFrequency = strFrequency;
	}
	/**
	 * @return the strPresDays
	 */
	public String getStrPresDays() {
		return strPresDays;
	}
	/**
	 * @param strPresDays the strPresDays to set
	 */
	public void setStrPresDays(String strPresDays) {
		this.strPresDays = strPresDays;
	}
	/**
	 * @return the intCost
	 */
	public static int getIntCost() {
		return intCost;
	}
	/**
	 * @param intCost the intCost to set
	 */
	public static void setIntCost(int intCost) {
		DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO.intCost = intCost;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getStrDrugIssueDate() {
		return strDrugIssueDate;
	}
	public void setStrDrugIssueDate(String strDrugIssueDate) {
		this.strDrugIssueDate = strDrugIssueDate;
	}
	
	
}
