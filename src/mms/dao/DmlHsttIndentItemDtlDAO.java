package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlHsttIndentItemDtlDAO {
	
	  private String strIndentNo = ""; 
	  private String strStoreId = "";
	  private String strHospCode = "";
	  private String strGroupId = "";
	  private String strSubGroupId = "";
	  private String strItemId = "";
	  private String strItemBrandId = "0";
	  private String strRate = "0";
	  private String strRateUnitId = "";
	  private String strIndentQty = "0";
	  private String strIndentQtyUnitId = "";
	  private String strSancQty = "0";
	  private String strSancQtyUnitId = "";
	  private String strIssueQty = "0";
	  private String strIssueqtyUnitId = "";
	  private String strinHandQty = "0";
	  private String strInHandQtyUnitId = "";
	  private String strConsumableFlag = "1";
	  private String strReOrderLevel = "0";
	  private String strReOrderLevelUnitId = "";
	  private String strLastIndentQty = "0";
	  private String strLastIndentQtyUnitId = "";
	  private String strLastIssueQty = "";
	  private String strLastIssueQtyUnitId = "";
	  private String strRemarks = "";
	  	  
	  private String strErr = "";
	  
	  private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Indent_Item_Dtl";
	  private final String strFileName = "mms.dao.DmlHsttIndentItemDtlDAO";
			
	  private int nRowInserted = 0;
	  private int nRowUpdated = 0;
      private int nRowDeleted = 0;
		
	  private int nInsertedIndex = 0;
	  private int nUpdatedIndex = 0;
	  private int nDeletedIndex = 0;
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	public String getStrIndentQty() {
		return strIndentQty;
	}
	public void setStrIndentQty(String strIndentQty) {
		this.strIndentQty = strIndentQty;
	}
	public String getStrIndentQtyUnitId() {
		return strIndentQtyUnitId;
	}
	public void setStrIndentQtyUnitId(String strIndentQtyUnitId) {
		this.strIndentQtyUnitId = strIndentQtyUnitId;
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
	public String getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	public String getStrIssueqtyUnitId() {
		return strIssueqtyUnitId;
	}
	public void setStrIssueqtyUnitId(String strIssueqtyUnitId) {
		this.strIssueqtyUnitId = strIssueqtyUnitId;
	}
	public String getStrinHandQty() {
		return strinHandQty;
	}
	public void setStrinHandQty(String strinHandQty) {
		this.strinHandQty = strinHandQty;
	}
	public String getStrInHandQtyUnitId() {
		return strInHandQtyUnitId;
	}
	public void setStrInHandQtyUnitId(String strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}
	public String getStrConsumableFlag() {
		return strConsumableFlag;
	}
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}
	public String getStrReOrderLevel() {
		return strReOrderLevel;
	}
	public void setStrReOrderLevel(String strReOrderLevel) {
		this.strReOrderLevel = strReOrderLevel;
	}
	public String getStrReOrderLevelUnitId() {
		return strReOrderLevelUnitId;
	}
	public void setStrReOrderLevelUnitId(String strReOrderLevelUnitId) {
		this.strReOrderLevelUnitId = strReOrderLevelUnitId;
	}
	public String getStrLastIndentQty() {
		return strLastIndentQty;
	}
	public void setStrLastIndentQty(String strLastIndentQty) {
		this.strLastIndentQty = strLastIndentQty;
	}
	public String getStrLastIssueQty() {
		return strLastIssueQty;
	}
	public void setStrLastIssueQty(String strLastIssueQty) {
		this.strLastIssueQty = strLastIssueQty;
	}
	public String getStrLastIssueQtyUnitId() {
		return strLastIssueQtyUnitId;
	}
	public void setStrLastIssueQtyUnitId(String strLastIssueQtyUnitId) {
		this.strLastIssueQtyUnitId = strLastIssueQtyUnitId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrLastIndentQtyUnitId() {
		return strLastIndentQtyUnitId;
	}
	public void setStrLastIndentQtyUnitId(String strLastIndentQtyUnitId) {
		this.strLastIndentQtyUnitId = strLastIndentQtyUnitId;
	}
	
	public int insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		try 
		{
			//{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//}
		//System.out.println("strProcName"+strProcName);
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           				//1
		   	dao.setProcInValue(nInsertedIndex,"strIndentNo",strIndentNo.trim(),2);                	//2
//		   	System.out.println("strStoreId.trim()==>"+strStoreId.trim());
//			System.out.println("itemId.trim()==>"+strItemId.trim());
//			System.out.println("strItemBrandId.trim()==>"+strItemBrandId.trim());		
	       	dao.setProcInValue(nInsertedIndex,"strId",strStoreId.trim(),3);           				//3
			dao.setProcInValue(nInsertedIndex,"hosp_code ",strHospCode.trim(),4);          			//4 
			dao.setProcInValue(nInsertedIndex,"groupId",strGroupId.trim(),5);        					//5
			dao.setProcInValue(nInsertedIndex,"subGroupId",strSubGroupId.trim(),6);           		//6
			dao.setProcInValue(nInsertedIndex,"itemId",strItemId.trim(),7);         					//7  
			dao.setProcInValue(nInsertedIndex,"itemBrandId",strItemBrandId.trim(),8); 				//8
			dao.setProcInValue(nInsertedIndex,"rate",strRate.trim(),9); 								//9
			dao.setProcInValue(nInsertedIndex,"rateUnitId",strRateUnitId.trim(),10); 					//10																//10       
			dao.setProcInValue(nInsertedIndex,"indentQty",strIndentQty.trim(),11);          			//11
			//System.out.println("Indent Qty-->>"+strIndentQty.trim());
			dao.setProcInValue(nInsertedIndex,"indentQtyUnitId",strIndentQtyUnitId.trim(),12);      	//12
	       	//System.out.println("Indent Qty Unit Id-->>"+strIndentQtyUnitId.trim());
			dao.setProcInValue(nInsertedIndex,"sancQty",strSancQty.trim(),13);       					//13
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId ",strSancQtyUnitId.trim(),14);			//14 
			dao.setProcInValue(nInsertedIndex,"issueQty",strIssueQty.trim(),15);     					//15
			dao.setProcInValue(nInsertedIndex,"issueQtyUnitId",strIssueqtyUnitId.trim(),16);			//16
			dao.setProcInValue(nInsertedIndex,"inHandQty",strinHandQty.trim(),17);        				//17  
			dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId",strInHandQtyUnitId.trim(),18);			//18
			dao.setProcInValue(nInsertedIndex,"consumableFlag",strConsumableFlag.trim(),19);     		//19
			dao.setProcInValue(nInsertedIndex,"reOrderLevel", strReOrderLevel.trim(),20);				//20
			dao.setProcInValue(nInsertedIndex,"reOrderLevelUnitId",strReOrderLevelUnitId.trim(),21);   //21
			dao.setProcInValue(nInsertedIndex,"lstIndentQty",strLastIndentQty.trim(),22);				//22 
			dao.setProcInValue(nInsertedIndex,"lstIndentUnitId",strLastIndentQtyUnitId.trim(),23);		//23
			dao.setProcInValue(nInsertedIndex,"lstIssueQty",strIssueQty.trim(),24);					//24
			dao.setProcInValue(nInsertedIndex,"lstIssueUnitId",strIssueqtyUnitId.trim(),25);			//25
			dao.setProcInValue(nInsertedIndex,"remarks",strRemarks.trim(),26);        		    		//26
				    	
			//output value                        
			dao.setProcOutValue(nInsertedIndex,"err",1,27);                               				//27
			
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
	
	private void reset() {
		
		strIndentNo = ""; 
		strStoreId = "";
		strHospCode = "";
		strGroupId = "";
		strSubGroupId = "";
		strItemId = "";
		strItemBrandId = "0";
		strRate = "0";
		strRateUnitId = "";
		strIndentQty = "0";
		strIndentQtyUnitId = "";
		strSancQty = "0";
		strSancQtyUnitId = "";
		strIssueQty = "0";
		strIssueqtyUnitId = "";
		strinHandQty = "0";
		strInHandQtyUnitId = "";
		strConsumableFlag = "1";
		strReOrderLevel = "0";
		strReOrderLevelUnitId = "";
		strLastIndentQty = "0";
		strLastIndentQtyUnitId = "";
		strLastIssueQty = "";
		strLastIssueQtyUnitId = "";
		strRemarks = "";
		
		 
	}

}
