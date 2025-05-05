package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlIndtCancelDtlImprdItemDAO 
{
	private String  storeId	      ="";
	private String  reqNo         ="";
	private String  hosp_code     ="";
	private String  reqTypeId     ="";
	private String  toStrId		  ="";
	private String  itemcatNo	  ="";
	private String  itemTypeId	  ="";
	private String  urgentFlag	  ="0";
	private String  indentPeriod  ="";
	private String  finStartDate  ="";
	private String  finEndDate	  ="";
	private String  remarks		  ="";
	private String  seatId		  ="";
	//It is mandatory parameter, do not reset the following variables
	private String    strErr = "";
	
	private final String strProcName = "pkg_mms_dml.DML_INDT_CANCEL_DTL_IMPRD_ITEM";
	private final String strFileName = "mms.dao.DmlIndtCancelDtlImprdItemDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getHosp_code() {
		return hosp_code;
	}
	public void setHosp_code(String hosp_code) {
		this.hosp_code = hosp_code;
	}
	public String getReqTypeId() {
		return reqTypeId;
	}
	public void setReqTypeId(String reqTypeId) {
		this.reqTypeId = reqTypeId;
	}
	public String getToStrId() {
		return toStrId;
	}
	public void setToStrId(String toStrId) {
		this.toStrId = toStrId;
	}
	public String getItemcatNo() {
		return itemcatNo;
	}
	public void setItemcatNo(String itemcatNo) {
		this.itemcatNo = itemcatNo;
	}
	public String getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public String getUrgentFlag() {
		return urgentFlag;
	}
	public void setUrgentFlag(String urgentFlag) {
		this.urgentFlag = urgentFlag;
	}
	public String getIndentPeriod() {
		return indentPeriod;
	}
	public void setIndentPeriod(String indentPeriod) {
		this.indentPeriod = indentPeriod;
	}
	public String getFinStartDate() {
		return finStartDate;
	}
	public void setFinStartDate(String finStartDate) {
		this.finStartDate = finStartDate;
	}
	public String getFinEndDate() {
		return finEndDate;
	}
	public void setFinEndDate(String finEndDate) {
		this.finEndDate = finEndDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
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
	public String getStrProcName() {
		return strProcName;
	}
	public String getStrFileName() {
		return strFileName;
	}
	/**
	 * This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Store Id is blank or
	 *                   - when Request No is blank
	 *                   - when Request type Id is blank
	 */
	public int Update(HisDAO dao) throws Exception 
	{
		strErr = "";
		try 
		{
			//check mandatory information
			if(storeId.equals("0") || storeId.equals(""))
			{
				throw new Exception("Store Id can not be blank");
			}
			if(reqNo.equals("0") || reqNo.equals(""))
			{
				throw new Exception("Request No can not be blank");
			}
			
			if(reqTypeId.equals("0") || reqTypeId.equals(""))
			{
				throw new Exception("Request Type Id can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?)}"); //8
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",storeId.trim());                 //2
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim());           //3
			dao.setProcInValue(nInsertedIndex,"reqTypeId ",reqTypeId.trim());          //4 
			
			dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim());                   //5
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim());               //6
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim());                 //7
	    	//output value                        
			
			dao.setProcOutValue(nInsertedIndex,"err",1);                               //8
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e)
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".Update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		return nInsertedIndex;
	}
		
	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() 
	{
		storeId		  ="";
		reqNo         ="";
		hosp_code     ="";
		reqTypeId     ="";
		toStrId		  ="";
		remarks		  ="";
		seatId		  ="";
		//It is mandatory parameter, do not reset the following variables
		  strErr = "";	
	}
	public String getReqNo() {
		return reqNo;
	}
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	

}

