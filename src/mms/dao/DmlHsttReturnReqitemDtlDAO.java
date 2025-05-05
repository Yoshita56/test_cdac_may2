package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlHsttReturnReqitemDtlDAO {
	
	 	private String strRetReqNo   = "";
	 	private String strStoreId    = "";  
	 	private String strHospCode   = "";
	 	private String strGroupId    = "";
	 	private String strBatchNo    = "0";
	 	private String strItemSlNo   = "0";
	 	private String strStockStatusCode = "";
	 	private String strSubGroupId      = "";
	 	private String strItemId          = "";
	 	private String strItemBrandId     = "0";
	 	private String strRate            = "0";
	 	private String strRateUnitId	  = "";
	 	private String strReqQty          = "0";   
	 	private String strReqQtyUnitId    = "";
	 	private String strSancQty         = "0";
	 	private String strSancQtyUnitId   = "";
	 	private String strInHandQty       = "0";
	 	private String strInHandQtyUnitId = "";
	 	private String strReturnFlag      = "0";
	 	private String strConsumableFlag  = "1";
	 	private String strLastPONo        = "";
	 	private String strLastPODate      = "";
	 	private String strLastRecDate     = "";
	 	private String strRemarks         = "";
	 	private String strErr             = "";
	 	private String strExpiryDate      ="";; 
		  
		private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Return_Reqitem_Dtl";
		private final String strFileName = "mms.dao.DmlHsttReturnReqitemDtlDAO";
			
		private int nRowInserted = 0;
		private int nRowUpdated = 0;
	    private int nRowDeleted = 0;
			
		private int nInsertedIndex = 0;
		private int nUpdatedIndex = 0;
		private int nDeletedIndex = 0;
		
		public void setStrExpiryDate(String strExpiryDate) {
			this.strExpiryDate = strExpiryDate;
		}
		
		public String getStrRetReqNo() {
			return strRetReqNo;
		}
		public void setStrRetReqNo(String strRetReqNo) {
			this.strRetReqNo = strRetReqNo;
		}
		public String getStrHospCode() {
			return strHospCode;
		}
		public void setStrHospCode(String strHospCode) {
			this.strHospCode = strHospCode;
		}
		public String getStrGroupId() {
			return strGroupId;
		}
		public void setStrGroupId(String strGroupId) {
			this.strGroupId = strGroupId;
		}
		public String getStrBatchNo() {
			return strBatchNo;
		}
		public void setStrBatchNo(String strBatchNo) {
			this.strBatchNo = strBatchNo;
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
		public String getStrSubGroupId() {
			return strSubGroupId;
		}
		public void setStrSubGroupId(String strSubGroupId) {
			this.strSubGroupId = strSubGroupId;
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
		public String getStrInHandQty() {
			return strInHandQty;
		}
		public String getStrStoreId() {
			return strStoreId;
		}
		public void setStrStoreId(String strStoreId) {
			this.strStoreId = strStoreId;
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
		public String getStrReturnFlag() {
			return strReturnFlag;
		}
		public void setStrReturnFlag(String strReturnFlag) {
			this.strReturnFlag = strReturnFlag;
		}
		public String getStrConsumableFlag() {
			return strConsumableFlag;
		}
		public void setStrConsumableFlag(String strConsumableFlag) {
			this.strConsumableFlag = strConsumableFlag;
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
				//if(this.nRowInserted == 0) 
				//{
				System.out.println("-------" + strProcName + "-----[Mode- 1]-----");
				
					nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				//}
				//Input Value
				dao.setProcInValue(nInsertedIndex,"modval","1",1);                           			//1
			   	dao.setProcInValue(nInsertedIndex,"retReqNo",strRetReqNo.trim(),2);                	//2
		       	dao.setProcInValue(nInsertedIndex,"strId",strStoreId.trim(),3);           			//3
				dao.setProcInValue(nInsertedIndex,"hospCode ",strHospCode.trim(),4);          		//4 
				dao.setProcInValue(nInsertedIndex,"groupId",strGroupId.trim(),5);        				//5
				dao.setProcInValue(nInsertedIndex,"batchNo",strBatchNo.trim(),6);           			//6
				dao.setProcInValue(nInsertedIndex,"itemSlNo",strItemSlNo.trim(),7);         			//7  
				dao.setProcInValue(nInsertedIndex,"stockStatusCode",strStockStatusCode.trim(),8); 	//8			//8
				dao.setProcInValue(nInsertedIndex,"subGroupId",strSubGroupId.trim(),9); 				//9
				dao.setProcInValue(nInsertedIndex,"itemId",strItemId.trim(),10); 						//10																//10       
				dao.setProcInValue(nInsertedIndex,"itemBrandId",strItemBrandId.trim(),11);          	//11
				dao.setProcInValue(nInsertedIndex,"rate",strRate.trim(),12);      						//12
		       	dao.setProcInValue(nInsertedIndex,"rateUnitId",strRateUnitId.trim(),13);       		//13
				dao.setProcInValue(nInsertedIndex,"reqQty ",strReqQty.trim(),14);						//14
				dao.setProcInValue(nInsertedIndex,"reqQtyUnitId",strReqQtyUnitId.trim(),15);     		//15			//15
				dao.setProcInValue(nInsertedIndex,"sancQty",strSancQty.trim(),16);     				//16
				dao.setProcInValue(nInsertedIndex,"sancQtyUnitId", strSancQtyUnitId.trim(),17);		//17
				dao.setProcInValue(nInsertedIndex,"inHandQty",strInHandQty.trim(),18);					//18
				dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId",strInHandQtyUnitId.trim(),19);  	//19
				dao.setProcInValue(nInsertedIndex,"returnFlag",strReturnFlag.trim(),20);				//20
				dao.setProcInValue(nInsertedIndex,"consumableFlag",strConsumableFlag.trim(),21);  		//21
				dao.setProcInValue(nInsertedIndex,"lastPONo ",strLastPONo.trim(),22);					//22 
				dao.setProcInValue(nInsertedIndex,"lastPODate",strLastPODate.trim(),23);				//23
				dao.setProcInValue(nInsertedIndex,"lastRecDate",strLastRecDate.trim(),24);				//24
				dao.setProcInValue(nInsertedIndex,"remarks",strRemarks.trim(),25);        		    	//25 
				dao.setProcInValue(nInsertedIndex,"strExpiryDate",strExpiryDate.trim(),26);        	//26	    	//26  
				 	
				//output value                        
				dao.setProcOutValue(nInsertedIndex,"err",1,27);                               			//27
				
				//keep in batch
				dao.execute(nInsertedIndex,1);
				this.nRowInserted++;
				//System.out.println("procedure Dml_Hstt_Return_Reqitem_Dtl executed");
			} 
			catch(Exception e)
			{
				//System.out.println("came in dis exception in inserttable");
				this.strErr = e.getMessage();
				throw new Exception(strFileName + ".insert() --> " + this.strErr);
			}
			finally {
				this.reset();	//to reset the variables
			}
			return nInsertedIndex;
		}
		
		private void reset() {
			
			strRetReqNo = "";
		 	strStoreId = "";  
		 	strHospCode = "";
		 	strGroupId = "";
		 	strBatchNo = "0";
		 	strItemSlNo = "0";
		 	strStockStatusCode = "";
		 	strSubGroupId = "";
		 	strItemId = "";
		 	strItemBrandId = "0";
		 	strRate = "0";
		 	strRateUnitId	= "";
		 	strReqQty = "0";   
		 	strReqQtyUnitId = "";
		 	strSancQty = "0";
		 	strSancQtyUnitId = "";
		 	strInHandQty = "0";
		 	strInHandQtyUnitId = "";
		 	strReturnFlag = "0";
		 	strConsumableFlag = "1";
		 	strLastPONo = "";
		 	strLastPODate = "";
		 	strLastRecDate = "";
		 	strRemarks = "";
		}
		
}
