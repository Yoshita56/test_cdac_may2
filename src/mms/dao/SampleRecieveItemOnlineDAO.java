package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class SampleRecieveItemOnlineDAO {
	private final String strProcName = "pkg_mms_dml.dml_sample_rec_online_dtls";
	private final String strFileName = "mms.dao.SampleRecieveItemDAO";
	private String strStoreId=""; 
	private String strSampleRecno= "";
	private String strItemId= ""; 
	private String strItemBrandId= ""; 
	private String strBatchSlNo= ""; 
	private String strGroupId= ""; 
	private String strSubgroupId= "";
	private String  strExpiryDate= ""; 
	private String  strConsumableFlag= ""; 
	private String  strRecieveQty= ""; 
	private String  strRecqtyUnitId= "";
	private String  strPassNo= "";
	private String strCommitteType="";
	private String strCommitteNo="";
	private String strCommRmksSlNo="";
	private String strRemarks = "";
	private String strHospitalCode = "";
	private String strApprovalStatus= "";
	private String strFileNo="";
	private String strPageNo="";
	private String strFileNameComm="";
	private String consumeQty="";
	private String strConsumeQtyUnit="";
	
	
	private String strReturnTo="";
	private String strErr = "";
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public int getNRowInserted() {
		return nRowInserted;
	}
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

//	Methods starts from here
	
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex = 0;
				
		try {
				nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				    
			    dao.setProcInValue(nProcIndex, "modval", "1");
				dao.setProcInValue(nProcIndex, "itemId", strItemId.trim());                      //1
				dao.setProcInValue(nProcIndex, "itembrandId", strItemBrandId.trim());            //2
				dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo.trim());               //3
				dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode.trim());     //4
				dao.setProcInValue(nProcIndex, "group_id", strGroupId.trim());                    //5
				dao.setProcInValue(nProcIndex, "subgroup_id", strSubgroupId.trim());              //6
				dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate.trim());              //7
				dao.setProcInValue(nProcIndex, "consumable_flag", strConsumableFlag.trim());      //8
				dao.setProcInValue(nProcIndex, "recieve_qty", strRecieveQty.trim());             //9
				dao.setProcInValue(nProcIndex, "recqty_unitid", strRecqtyUnitId.trim());         //10
				dao.setProcInValue(nProcIndex, "remarks", strRemarks.trim());                    //11
				dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecno.trim());           //12
				dao.setProcInValue(nProcIndex, "strId", strStoreId);          //13
				
				dao.setProcInValue(nProcIndex, "issue_qty", "0");           
				dao.setProcInValue(nProcIndex, "issqty_unitid", "0");           
				dao.setProcInValue(nProcIndex, "return_qty", "0");           
				dao.setProcInValue(nProcIndex, "retqty_unitid", "0");           
				dao.setProcInValue(nProcIndex, "condemned_qty", "0");           
				dao.setProcInValue(nProcIndex, "condqty_unitid", "0");          
				dao.setProcInValue(nProcIndex, "sample_item_status", "0");           
				dao.setProcInValue(nProcIndex, "passNo", "");
				dao.setProcInValue(nProcIndex, "approvalStatus", "");           
				dao.setProcInValue(nProcIndex, "committeTypeId", "");          
				dao.setProcInValue(nProcIndex, "memRemarksSlNo", "");           
				dao.setProcInValue(nProcIndex, "strReturnTo", "");           
				dao.setProcInValue(nProcIndex, "isvalid", "1");           
				dao.setProcInValue(nProcIndex, "committeNo", "");
				dao.setProcInValue(nProcIndex, "strFileNo", "");           
				dao.setProcInValue(nProcIndex, "strPageNo", "");
				dao.setProcInValue(nProcIndex, "strFileNameComm", "");
				dao.setProcInValue(nProcIndex, "consumeQty", "");
				dao.setProcInValue(nProcIndex, "strConsumeQtyUnit", "");
				
				dao.setProcOutValue(nProcIndex, "err", 1);             					 //14
				
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

	public void update(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex=0;
		
		try {
				nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				dao.setProcInValue(nProcIndex, "modval", "2");                      //1
				dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecno);
				dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo);
				dao.setProcInValue(nProcIndex, "itemId", strItemId);
				dao.setProcInValue(nProcIndex, "itembrandId", strItemBrandId);
				dao.setProcInValue(nProcIndex, "remarks", strRemarks);
				dao.setProcInValue(nProcIndex, "passNo", strPassNo);
				dao.setProcInValue(nProcIndex, "strReturnTo", strReturnTo);
				dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
				dao.setProcInValue(nProcIndex, "strId", strStoreId); 
				
				dao.setProcInValue(nProcIndex, "group_id", "");
				dao.setProcInValue(nProcIndex, "subgroup_id", "");
				dao.setProcInValue(nProcIndex, "expiry_date", "");
				dao.setProcInValue(nProcIndex, "consumable_flag", "1");
				dao.setProcInValue(nProcIndex, "recieve_qty", "");
				dao.setProcInValue(nProcIndex, "recqty_unitid", "");
				dao.setProcInValue(nProcIndex, "issue_qty", "0");
				dao.setProcInValue(nProcIndex, "issqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "return_qty", "0");
				dao.setProcInValue(nProcIndex, "retqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "condemned_qty", "0");
				dao.setProcInValue(nProcIndex, "condqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "sample_item_status", "0");
				dao.setProcInValue(nProcIndex, "approvalStatus", "");
				dao.setProcInValue(nProcIndex, "committeTypeId", "");
				dao.setProcInValue(nProcIndex, "memRemarksSlNo", "");
				dao.setProcInValue(nProcIndex, "isvalid", "1");
				dao.setProcInValue(nProcIndex, "committeNo", "");
				dao.setProcInValue(nProcIndex, "strFileNo", "");
				dao.setProcInValue(nProcIndex, "strPageNo", "");
				dao.setProcInValue(nProcIndex, "strFileNameComm", "");
				dao.setProcInValue(nProcIndex, "consumeQty", "");
				dao.setProcInValue(nProcIndex, "strConsumeQtyUnit", "");
				
				dao.setProcOutValue(nProcIndex, "err", 1); 
				dao.execute(nProcIndex, 1);
				this.nRowUpdated++;
		
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}

	}
	
	public void updateVerify(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex=0;
		
		try {
			
			
				nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				dao.setProcInValue(nProcIndex, "modval", "3");                      //1
				dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecno);
				dao.setProcInValue(nProcIndex, "remarks", strRemarks);
				dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo);
				dao.setProcInValue(nProcIndex, "itemId", strItemId);
				dao.setProcInValue(nProcIndex, "itembrandId", strItemBrandId);
				dao.setProcInValue(nProcIndex, "approvalStatus", strApprovalStatus);
				dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
				dao.setProcInValue(nProcIndex, "committeTypeId", strCommitteType);
				dao.setProcInValue(nProcIndex, "committeNo", strCommitteNo);
				dao.setProcInValue(nProcIndex, "memRemarksSlNo", strCommRmksSlNo);
				dao.setProcInValue(nProcIndex, "strId", strStoreId); 
				dao.setProcInValue(nProcIndex, "strFileNo", strFileNo);
				dao.setProcInValue(nProcIndex, "strPageNo", strPageNo);
				dao.setProcInValue(nProcIndex, "strFileNameComm", strFileNameComm);
				dao.setProcInValue(nProcIndex, "consumeQty", consumeQty);
				dao.setProcInValue(nProcIndex, "strConsumeQtyUnit", strConsumeQtyUnit.replace('^', '#').split("#")[0]);
				
				dao.setProcInValue(nProcIndex, "group_id", "");
				dao.setProcInValue(nProcIndex, "subgroup_id", "");
				dao.setProcInValue(nProcIndex, "expiry_date", "");
				dao.setProcInValue(nProcIndex, "consumable_flag", "1");
				dao.setProcInValue(nProcIndex, "recieve_qty", "");
				dao.setProcInValue(nProcIndex, "recqty_unitid", "");
				dao.setProcInValue(nProcIndex, "issue_qty", "0");
				dao.setProcInValue(nProcIndex, "issqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "return_qty", "0");
				dao.setProcInValue(nProcIndex, "retqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "condemned_qty", "0");
				dao.setProcInValue(nProcIndex, "condqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "sample_item_status", "0");
				dao.setProcInValue(nProcIndex, "passNo", "");
				dao.setProcInValue(nProcIndex, "strReturnTo", "");           
				dao.setProcInValue(nProcIndex, "isvalid", "1");
				
				dao.setProcOutValue(nProcIndex, "err", 1); 
				dao.execute(nProcIndex, 1);
				
				this.nRowUpdated++;
		
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}

	}

	
	public void condemnUpdate(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex=0;
		
		try {
				nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				dao.setProcInValue(nProcIndex, "modval", "4");                      //1
				dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecno);
				dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo);
				dao.setProcInValue(nProcIndex, "itemId", strItemId);
				dao.setProcInValue(nProcIndex, "itembrandId", strItemBrandId);
				dao.setProcInValue(nProcIndex, "remarks", strRemarks);
				dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
				dao.setProcInValue(nProcIndex, "strId", strStoreId);
				
				dao.setProcInValue(nProcIndex, "group_id", "");
				dao.setProcInValue(nProcIndex, "subgroup_id", "");
				dao.setProcInValue(nProcIndex, "expiry_date", "");
				dao.setProcInValue(nProcIndex, "consumable_flag", "1");
				dao.setProcInValue(nProcIndex, "recieve_qty", "");
				dao.setProcInValue(nProcIndex, "recqty_unitid", "");
				dao.setProcInValue(nProcIndex, "issue_qty", "0");
				dao.setProcInValue(nProcIndex, "issqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "return_qty", "0");
				dao.setProcInValue(nProcIndex, "retqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "condemned_qty", "0");
				dao.setProcInValue(nProcIndex, "condqty_unitid", "0");
				dao.setProcInValue(nProcIndex, "sample_item_status", "0");
				dao.setProcInValue(nProcIndex, "passNo", "");
				
				dao.setProcInValue(nProcIndex, "approvalStatus", "");
				dao.setProcInValue(nProcIndex, "committeTypeId", "");
				dao.setProcInValue(nProcIndex, "memRemarksSlNo", "");
				dao.setProcInValue(nProcIndex, "strReturnTo", "");
				dao.setProcInValue(nProcIndex, "isvalid", "1");
				dao.setProcInValue(nProcIndex, "committeNo", "");
				dao.setProcInValue(nProcIndex, "strFileNo", "");
				dao.setProcInValue(nProcIndex, "strPageNo", "");
				dao.setProcInValue(nProcIndex, "strFileNameComm", "");
				dao.setProcInValue(nProcIndex, "consumeQty", "");
				dao.setProcInValue(nProcIndex, "strConsumeQtyUnit", "");
				
				dao.setProcOutValue(nProcIndex, "err", 1); 
				dao.execute(nProcIndex, 1);
				
				this.nRowUpdated++;
		
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}

	}

	public void reset() {

		strSampleRecno="";
		strItemId= ""; 
		strItemBrandId= ""; 
		strBatchSlNo= ""; 
		strGroupId= ""; 
		strSubgroupId= "";
		strExpiryDate= ""; 
		strConsumableFlag= ""; 
		strRecieveQty= ""; 
		strRecqtyUnitId= ""; 
		strRemarks = "";
		strHospitalCode = "";
	}
	public String getStrSampleRecno() {
		return strSampleRecno;
	}
	public void setStrSampleRecno(String strSampleRecno) {
		this.strSampleRecno = strSampleRecno;
	}

	
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}
	public void setStrRecieveQty(String strRecieveQty) {
		this.strRecieveQty = strRecieveQty;
	}
	public void setStrRecqtyUnitId(String strRecqtyUnitId) {
		this.strRecqtyUnitId = strRecqtyUnitId;
	}
	
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public void setStrSubgroupId(String strSubgroupId) {
		this.strSubgroupId = strSubgroupId;
	}
	public void setStrPassNo(String strPassNo) {
		this.strPassNo = strPassNo;
	}
	public void setStrApprovalStatus(String strApprovalStatus) {
		this.strApprovalStatus = strApprovalStatus;
	}
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}
	public void setStrCommitteNo(String strCommitteNo) {
		this.strCommitteNo = strCommitteNo;
	}
	public void setStrCommRmksSlNo(String strCommRmksSlNo) {
		this.strCommRmksSlNo = strCommRmksSlNo;
	}
	public void setStrReturnTo(String strReturnTo) {
		this.strReturnTo = strReturnTo;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public void setStrFileNameComm(String strFileNameComm) {
		this.strFileNameComm = strFileNameComm;
	}
	/**
	 * @param strConsumeQtyUnit the strConsumeQtyUnit to set
	 */
	public void setStrConsumeQtyUnit(String strConsumeQtyUnit) {
		this.strConsumeQtyUnit = strConsumeQtyUnit;
	}
	/**
	 * @param consumeQty the consumeQty to set
	 */
	public void setConsumeQty(String consumeQty) {
		this.consumeQty = consumeQty;
	}
	
	

}
