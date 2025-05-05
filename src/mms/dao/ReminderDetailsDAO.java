package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class ReminderDetailsDAO {
	
	private final String strFileName = "mms.dao.ReminderDetailsDAO";
	private String strErr = "";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	private String strStoreId = "";
	private String strPONo = "";
	private String strReminderNo = "";
	private String strHospitalCode = "";
	private String strItemCatNo = "";
	private String strPOPrefix = "";
	private String StrReminderPrefix = "";
	private String strReminderType = "";
	private String strSupplierId = "";
	private String strScheduleNo = "";
	private String strPODate = "";
	private String strPOStoreId = "";
	
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrReminderNo() {
		return strReminderNo;
	}
	public void setStrReminderNo(String strReminderNo) {
		this.strReminderNo = strReminderNo;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrPOPrefix() {
		return strPOPrefix;
	}
	public void setStrPOPrefix(String strPOPrefix) {
		this.strPOPrefix = strPOPrefix;
	}
	public String getStrReminderPrefix() {
		return StrReminderPrefix;
	}
	public void setStrReminderPrefix(String strReminderPrefix) {
		StrReminderPrefix = strReminderPrefix;
	}
	public String getStrReminderType() {
		return strReminderType;
	}
	public void setStrReminderType(String strReminderType) {
		this.strReminderType = strReminderType;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrScheduleNo() {
		return strScheduleNo;
	}
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	
	
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";
	
		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strReminderNo.equals("0") || strReminderNo.equals("")) {
				throw new Exception("strReminderNo can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}
			
			
			proc_name = "{call PKG_MMS_DML.Dml_Reminder_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "storeId",strStoreId);
			dao.setProcInValue(nprocIndex, "poNo",strPONo);
			dao.setProcInValue(nprocIndex, "reminderNo",strReminderNo);
			dao.setProcInValue(nprocIndex, "hospCode",strHospitalCode);
			dao.setProcInValue(nprocIndex, "itemCatNo",strItemCatNo);
			dao.setProcInValue(nprocIndex, "poPrefix",strPOPrefix);
			dao.setProcInValue(nprocIndex, "remPrefix",StrReminderPrefix);
			dao.setProcInValue(nprocIndex, "remType",strReminderType);
			dao.setProcInValue(nprocIndex, "suppId",strSupplierId);
			dao.setProcInValue(nprocIndex, "scheduleNo",strScheduleNo);
			dao.setProcInValue(nprocIndex, "poDate",strPODate);
			dao.setProcInValue(nprocIndex, "poStoreId",strPOStoreId);
			         		
			dao.setProcOutValue(nprocIndex, "err", 1);
			
			dao.execute(nprocIndex,1);
			
		
			this.nInsertedIndex ++ ;
			
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}
	
	public void reset() {

		strStoreId = "";
		strPONo = "";
		strReminderNo = "";
		strHospitalCode = "";
		strItemCatNo = "";
		strPOPrefix = "";
		StrReminderPrefix = "";
		strReminderType = "";
		strSupplierId = "";
		strScheduleNo = "";
		strPODate = "";
		strPOStoreId = "";

	}
	
}
