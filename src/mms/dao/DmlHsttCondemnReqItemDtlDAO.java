package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlHsttCondemnReqItemDtlDAO {
	
	  private String strStoreId = "";
	  private String strReqNo = "";
	  private String strItemId = "";
	  private String strItemBrandId = "0";
	  private String strBatchNo = "0";    
	  private String strHospCode = "";    
	  private String strItemSlNo = "0";
	  private String strStockStatusCode = ""; 
	  private String strGroupId = "";
	  private String strSubGroupId = "0";
	  private String strExpiryDate = "";
	  private String strInHandQty = "0";   
	  private String strInHandQtyUnitId = "";
	  private String strRate = "0";  
	  private String strRateUnitId = "";
	  private String strReqQty = "0";
	  private String strReqQtyUnitId = "";
	  private String strSancQty = "0";
	  private String strSancQtyUnitId = "";
	  private String strSuppId = "";
	  private String strLastPONo = "";
	  private String strLastPODate = "";
	  private String strLastRecDate = "";
	  private String strRemarks = "";
	  private String strReturnFlag ="";
	  private String strErr = "";
	  
	  private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Condemnation_item_Dtl";
	  private final String strFileName = "mms.dao.DmlHsttCondemnReqItemDtlDAO";
			
	  private int nRowInserted = 0;
	  private int nRowUpdated = 0;
      private int nRowDeleted = 0;
		
	  private int nInsertedIndex = 0;
	  private int nUpdatedIndex = 0;
	  private int nDeletedIndex = 0;
	  
	  public void setStrReturnFlag(String strReturnFlag) {
			this.strReturnFlag = strReturnFlag;
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
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
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
	public String getStrSancQty() {
		return strSancQty;
	}
	public void setStrSancQty(String strSancQty) {
		this.strSancQty = strSancQty;
	}
	public String getStrSancQtyUnitId() {
		return strSancQtyUnitId;
	}
	public void setStrSancQtyUnitId(String strSancQtyUnitId) {
		this.strSancQtyUnitId = strSancQtyUnitId;
	}
	public String getStrSuppId() {
		return strSuppId;
	}
	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}
	public String getStrLastPONo() {
		return strLastPONo;
	}
	public void setStrLastPONo(String strLastPONo) {
		this.strLastPONo = strLastPONo;
	}
	public String getStrLastPODate() {
		return strLastPODate;
	}
	public void setStrLastPODate(String strLastPODate) {
		this.strLastPODate = strLastPODate;
	}
	public String getStrLastRecDate() {
		return strLastRecDate;
	}
	public void setStrLastRecDate(String strLastRecDate) {
		this.strLastRecDate = strLastRecDate;
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
	
	public int insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		try 
		{
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
							
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");                           		//1
		   	dao.setProcInValue(nInsertedIndex,"strId",strStoreId.trim());                	//2
	       	dao.setProcInValue(nInsertedIndex,"retReqNo",strReqNo.trim());           			//3
			dao.setProcInValue(nInsertedIndex,"itemId ",strItemId.trim());          		//4 
			dao.setProcInValue(nInsertedIndex,"itemBrandId",strItemBrandId.trim());        	//5
			dao.setProcInValue(nInsertedIndex,"batchNo",strBatchNo.trim());           		//6
			dao.setProcInValue(nInsertedIndex,"hospCode",strHospCode.trim());         		//7  
			dao.setProcInValue(nInsertedIndex,"itemSlNo",strItemSlNo.trim()); 				//8
			dao.setProcInValue(nInsertedIndex,"stockStatusCode",strStockStatusCode.trim()); //9
			dao.setProcInValue(nInsertedIndex,"groupId",strGroupId.trim()); 				//10															   
			dao.setProcInValue(nInsertedIndex,"subGroupId",strSubGroupId.trim());          	//11
			dao.setProcInValue(nInsertedIndex,"expiryDate",strExpiryDate.trim());      		//12
	       	dao.setProcInValue(nInsertedIndex,"inHandQty",strInHandQty.trim());       		//13
			dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId ",strInHandQtyUnitId.trim());//14 
			dao.setProcInValue(nInsertedIndex,"rate",strRate.trim());     					//15
			dao.setProcInValue(nInsertedIndex,"rateUnitId",strRateUnitId.trim());			//16
			dao.setProcInValue(nInsertedIndex,"reqQty",strReqQty.trim());        			//17  
			dao.setProcInValue(nInsertedIndex,"reqQtyUnitId",strReqQtyUnitId.trim());		//18
			dao.setProcInValue(nInsertedIndex,"sancQty",strSancQty.trim());     			//19
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId", strSancQtyUnitId.trim());	//20
			dao.setProcInValue(nInsertedIndex,"supplierID",strSuppId.trim());       		//21
			dao.setProcInValue(nInsertedIndex,"lastPONo ",strLastPONo.trim());				//22 
			dao.setProcInValue(nInsertedIndex,"lastPODate",strLastPODate.trim());			//23
			dao.setProcInValue(nInsertedIndex,"lastRecDate",strLastRecDate.trim());			//24
			dao.setProcInValue(nInsertedIndex,"remarks",strRemarks.trim());        		    //25  
			dao.setProcInValue(nInsertedIndex,"returnFlag",strReturnFlag.trim());        	//26
				    	
			//output value                        
			dao.setProcOutValue(nInsertedIndex,"err",1);                               		//27
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e)
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		return nInsertedIndex;
	}
	
	private void reset() 
	{
	
		  strStoreId = "";
		  strReqNo = "";
		  strItemId = "";
		  strItemBrandId = "0";
		  strBatchNo = "0";    
		  strHospCode = "";    
		  strItemSlNo = "0";
		  strStockStatusCode = ""; 
		  strGroupId = "";
		  strSubGroupId = "0";
		  strExpiryDate = "";
		  strInHandQty = "0";   
		  strInHandQtyUnitId = "";
		  strRate = "0";  
		  strRateUnitId = "";
		  strReqQty = "0";
		  strReqQtyUnitId = "";
		  strSancQty = "0";
		  strSancQtyUnitId = "";
		  strSuppId = "";
		  strLastPONo = "";
		  strLastPODate = "";
		  strLastRecDate = "";
		  strRemarks = "";
	}
}
