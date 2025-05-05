package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlIndentReturnRequestDAO {
	
	private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Return_Req_Item_Dtl";
	private final String strProcNameCondemn = "PKG_MMS_DML.DML_HSTT_CONDEMN_REQITEM_DTL";
	private final String strFileName = "mms.dao.DmlIndentReturnRequestDAO";
	private String  modval                                         ="" ;
	private String  hosp_code                                      ="";
	private String  reqTypeId                                      ="";
	private String  transNo                                        ="";
	private String  toStoreId                                      =""; 
	private String  transDate                                      ="";
	private String  strId                                          ="";
	private String  strItemCatgNo                                  ="";  
	private String  strFinancialStarDate                           ="";
	private String  strFinancialEndDate                            ="";
	private String  strEntryDate                                   ="";
	private String  strIsValid                                     ="";
	private String  strBatchNo                                     ="";
	private String  strStockStatusCode                             =""; 
	private String  agendaNo                                       ="";
	private String  reqNo                                          ="";
	
	private String  itemId                                         ="";
	private String  itemBrandId                                    ="";
	private String  strSancQty									   ="";
	private String  strSancQtyUnit								   ="";
	private String  strQty                                         ="";
	private String  strCategNo                                     ="0";
	private String  strSeatId                                      ="";
	private String  strUnitId                                      ="";  
	private String  strRemarks                                     =""; 
    private String  strRecevedBy                                   ="";   
    private String  strSlNo                                        ="";   
	private String  strErr = ""; 

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	public void insert(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			/**
     
			 */
			nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//24
			 					//System.out.println(strProcName);	
			dao.setProcInValue(nProcIndex, "modval","1",1); //1
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim(),2); //2
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId,3); //7
			dao.setProcInValue(nProcIndex, "toStoreId", toStoreId.trim(),4); //21
			dao.setProcInValue(nProcIndex, "strId", strId.trim(),5); //3
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo,6);//6
			dao.setProcInValue(nProcIndex, "strFinancialStarDate",strFinancialStarDate,7);//8
			dao.setProcInValue(nProcIndex, "strFinancialEndDate", strFinancialEndDate,8);//9
			dao.setProcInValue(nProcIndex, "strIsValid", "1",9); //22
			dao.setProcInValue(nProcIndex, "strBatchNo", strBatchNo.trim(),10);//14
			dao.setProcInValue(nProcIndex, "strStockStatusCode", strStockStatusCode.trim(),11);//13
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim(),12);//4
			dao.setProcInValue(nProcIndex, "strRecevBy", strRecevedBy.trim(),13);//11
			dao.setProcInValue(nProcIndex, "strSancQty", strSancQty.trim(),14);//17
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", strSancQtyUnit.trim(),15);//18
			dao.setProcInValue(nProcIndex, "itemId", itemId.trim(),16);//15
			dao.setProcInValue(nProcIndex, "itemBrandId", itemBrandId.trim(),17);//16
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim(),18);//19
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo,19);//5
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim(),20);//12
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim(),21);//20
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim(),22);//10
			dao.setProcInValue(nProcIndex, "old_itemserialno", strSlNo,23); //23
			dao.setProcOutValue(nProcIndex, "err", 1,24);//24
			dao.execute(nProcIndex,1);
			this.nRowInserted++;
			//System.out.println("procedure Dml_Hstt_Return_Req_Item_Dtl executed");
		} 
		catch(Exception e) {
			e.printStackTrace();
			//System.out.println("came in dis exception in inserttable dusra");
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			//this.reset();	//to reset the variables
		}
	}
	
	public void insertCondemnation(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			/**
     
			 */
			nProcIndex=dao.setProcedure("{call "+strProcNameCondemn+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //24
			 						
			dao.setProcInValue(nProcIndex, "modval","1"); //1
			
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim()); //2
			
			dao.setProcInValue(nProcIndex, "strId", strId.trim()); //3
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim());//4
			
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo);//5
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo);//6
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId); //7
			
			dao.setProcInValue(nProcIndex, "strFinancialStarDate",strFinancialStarDate);//8
			dao.setProcInValue(nProcIndex, "strFinancialEndDate", strFinancialEndDate);//9
			
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim());//10
			dao.setProcInValue(nProcIndex, "strRecevBy", strRecevedBy.trim());//11
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim());//12
			
			dao.setProcInValue(nProcIndex, "strStockStatusCode", strStockStatusCode.trim());//13
			dao.setProcInValue(nProcIndex, "strBatchNo", strBatchNo.trim());//14
						
			
			dao.setProcInValue(nProcIndex, "itemId", itemId.trim());//15
			dao.setProcInValue(nProcIndex, "itemBrandId", itemBrandId.trim());//16
			
			dao.setProcInValue(nProcIndex, "strSancQty", strSancQty.trim());//17
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", strSancQtyUnit.trim());//18
			
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim());//19
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim());//20
			dao.setProcInValue(nProcIndex, "toStoreId", toStoreId.trim()); //21
			dao.setProcInValue(nProcIndex, "strIsValid", "1"); //22
			dao.setProcInValue(nProcIndex, "old_itemserialno", strSlNo); //23
					
			dao.setProcOutValue(nProcIndex, "err", 1);//24
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insertCondemnation() --> " + this.strErr);
		}
		finally {
			//this.reset();	//to reset the variables
		}
	}
	
	public void insertCondemnationReq(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			/**
     
			 */
			nProcIndex=dao.setProcedure("{call "+strProcNameCondemn+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //24
			 						
			dao.setProcInValue(nProcIndex, "modval","3"); //1
			
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim()); //2
			
			dao.setProcInValue(nProcIndex, "strId", strId.trim()); //3
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim());//4
			
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo);//5
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo);//6
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId); //7
			
			dao.setProcInValue(nProcIndex, "strFinancialStarDate",strFinancialStarDate);//8
			dao.setProcInValue(nProcIndex, "strFinancialEndDate", strFinancialEndDate);//9
			
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim());//10
			dao.setProcInValue(nProcIndex, "strRecevBy", strRecevedBy.trim());//11
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim());//12
			
			dao.setProcInValue(nProcIndex, "strStockStatusCode", strStockStatusCode.trim());//13
			dao.setProcInValue(nProcIndex, "strBatchNo", strBatchNo.trim());//14
						
			
			dao.setProcInValue(nProcIndex, "itemId", itemId.trim());//15
			dao.setProcInValue(nProcIndex, "itemBrandId", itemBrandId.trim());//16
			
			dao.setProcInValue(nProcIndex, "strSancQty", strSancQty.trim());//17
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", strSancQtyUnit.trim());//18
			
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim());//19
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim());//20
			dao.setProcInValue(nProcIndex, "toStoreId", toStoreId.trim()); //21
			dao.setProcInValue(nProcIndex, "strIsValid", "1"); //22
			dao.setProcInValue(nProcIndex, "old_itemserialno", strSlNo); //23
					
			dao.setProcOutValue(nProcIndex, "err", 1);//24
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insertCondemnationReq() --> " + this.strErr);
		}
		finally {
			//this.reset();	//to reset the variables
		}
	}
	
	public void insert1(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			
			nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //23+1=24
				
			dao.setProcInValue(nProcIndex, "modval","2"); //1
			
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim()); //2
			
			dao.setProcInValue(nProcIndex, "strId", strId.trim()); //3
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim());//4
			
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo);//5
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo);//6
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId); //7
			
			dao.setProcInValue(nProcIndex, "strFinancialStarDate",strFinancialStarDate);//8
			dao.setProcInValue(nProcIndex, "strFinancialEndDate", strFinancialEndDate);//9
			
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim());//10
			dao.setProcInValue(nProcIndex, "strRecevBy", strRecevedBy.trim());//11
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim());//12
			
			dao.setProcInValue(nProcIndex, "strStockStatusCode", strStockStatusCode.trim());//13
			dao.setProcInValue(nProcIndex, "strBatchNo", strBatchNo.trim());//14
						
			
			dao.setProcInValue(nProcIndex, "itemId", itemId.trim());//15
			dao.setProcInValue(nProcIndex, "itemBrandId", itemBrandId.trim());//16
			
			dao.setProcInValue(nProcIndex, "strSancQty", strSancQty.trim());//17
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", strSancQtyUnit.trim());//18
			
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim());//19
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim());//20
			dao.setProcInValue(nProcIndex, "toStoreId", toStoreId.trim()); //21
			dao.setProcInValue(nProcIndex, "strIsValid", "1"); //22
					
			dao.setProcOutValue(nProcIndex, "err", 1);//23

			/* Start Adding Default value*/
			dao.setProcInValue(nProcIndex, "old_itemserialno ","0"); //24
			/* End Adding Default value*/
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert1() --> " + this.strErr);
		}
		finally {
			///this.reset();	//to reset the variables
		}
	}
	//strProcNameCondemn
	
	public void insert12(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			
			nProcIndex=dao.setProcedure("{call "+strProcNameCondemn+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //8+16=24
				
			dao.setProcInValue(nProcIndex, "modval","2"); //1
			
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim()); //2
			
			dao.setProcInValue(nProcIndex, "strId", strId.trim()); //3
		
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim());//4
			
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim());//5
			
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId.trim());//6
			
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo.trim());//7
			
			dao.setProcOutValue(nProcIndex, "err", 1);//8

			/* Start Adding Default value*/
			dao.setProcInValue(nProcIndex, "toStoreId","");
			dao.setProcInValue(nProcIndex, "strFinancialStarDate","");
			dao.setProcInValue(nProcIndex, "strFinancialEndDate","");
			dao.setProcInValue(nProcIndex, "strIsValid","");
			dao.setProcInValue(nProcIndex, "strBatchNo","");
			dao.setProcInValue(nProcIndex, "strStockStatusCode","");
			dao.setProcInValue(nProcIndex, "strRecevBy","");
			dao.setProcInValue(nProcIndex, "strSancQty","");
			dao.setProcInValue(nProcIndex, "strSancQtyUnit","");
			dao.setProcInValue(nProcIndex, "itemId","");
			dao.setProcInValue(nProcIndex, "itemBrandId","");
			dao.setProcInValue(nProcIndex, "strQty","");
			dao.setProcInValue(nProcIndex, "strCategNo","0");
			dao.setProcInValue(nProcIndex, "strSeatId","");
			dao.setProcInValue(nProcIndex, "strUnitId","");
			dao.setProcInValue(nProcIndex, "old_itemserialno","0");
			/* End Adding Default value*/
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert12() --> " + this.strErr);
		}
		finally {
			///this.reset();	//to reset the variables
		}
	}
	
	public void insert11(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			
			nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //8+16=24 
				
			dao.setProcInValue(nProcIndex, "modval","2"); //1
			
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim()); //2
			
			dao.setProcInValue(nProcIndex, "strId", strId.trim()); //3
		
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim());//4
			
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim());//5
			
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId.trim());//6
			
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo.trim());//7
								
			dao.setProcOutValue(nProcIndex, "err", 1);//8

			/* Start Adding Default value*/
			dao.setProcInValue(nProcIndex, "toStoreId","");
			dao.setProcInValue(nProcIndex, "strFinancialStarDate","");
			dao.setProcInValue(nProcIndex, "strFinancialEndDate","");
			dao.setProcInValue(nProcIndex, "strIsValid","");
			dao.setProcInValue(nProcIndex, "strBatchNo","");
			dao.setProcInValue(nProcIndex, "strStockStatusCode","");
			dao.setProcInValue(nProcIndex, "strRecevBy","");
			dao.setProcInValue(nProcIndex, "strSancQty","");
			dao.setProcInValue(nProcIndex, "strSancQtyUnit","");
			dao.setProcInValue(nProcIndex, "itemId","");
			dao.setProcInValue(nProcIndex, "itemBrandId","");
			dao.setProcInValue(nProcIndex, "strQty","");
			dao.setProcInValue(nProcIndex, "strCategNo","0");
			dao.setProcInValue(nProcIndex, "strSeatId","");
			dao.setProcInValue(nProcIndex, "strUnitId","");
			dao.setProcInValue(nProcIndex, "old_itemserialno","0");
			/* End Adding Default value*/
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert11() --> " + this.strErr);
		}
		finally {
			///this.reset();	//to reset the variables
		}
	}
	public void insert2(HisDAO dao) throws Exception
	{
		strErr = "";
		int nProcIndex = 0;
		
		try {
			
			System.out.println("-------"+strProcName+"-----[Mode- 3]-----");
			
			nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
			dao.setProcInValue(nProcIndex, "modval","3",1); //1
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code.trim(),2); //2
			dao.setProcInValue(nProcIndex, "reqTypeId", reqTypeId,3); //6
			dao.setProcInValue(nProcIndex, "toStoreId", toStoreId.trim(),4); //20
			dao.setProcInValue(nProcIndex, "strId", strId.trim(),5); //3
			dao.setProcInValue(nProcIndex, "strItemCatgNo", strItemCatgNo,6);//5
			dao.setProcInValue(nProcIndex, "strFinancialStarDate",strFinancialStarDate,7);//7
			dao.setProcInValue(nProcIndex, "strFinancialEndDate", strFinancialEndDate,8);//8
			dao.setProcInValue(nProcIndex, "strIsValid", "1",9); //21
			dao.setProcInValue(nProcIndex, "strBatchNo", strBatchNo.trim(),10);//13
			dao.setProcInValue(nProcIndex, "strStockStatusCode", strStockStatusCode.trim(),11);//12
			dao.setProcInValue(nProcIndex, "reqNo", reqNo.trim(),12);//4
			dao.setProcInValue(nProcIndex, "strRecevBy", strRecevedBy.trim(),13);//10			
			dao.setProcInValue(nProcIndex, "strSancQty", strSancQty.trim(),14);//16
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", strSancQtyUnit.trim(),15);//17
			////System.out.println("Item Catg No in Table DAO -->>"+strItemCatgNo);
			dao.setProcInValue(nProcIndex, "itemId", itemId.trim(),16);//14
			dao.setProcInValue(nProcIndex, "itemBrandId", itemBrandId.trim(),17);//15
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim(),18);//18
			dao.setProcInValue(nProcIndex, "strCategNo","0",19); //1
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim(),20);//11
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim(),21);//19
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim(),22);//9
			dao.setProcInValue(nProcIndex, "old_itemserialno","0",23); //1
			dao.setProcOutValue(nProcIndex, "err", 1,24);//22
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	public String getModval() {
		return modval;
	}
	public void setModval(String modval) {
		this.modval = modval;
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
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	public String getToStoreId() {
		return toStoreId;
	}
	public void setToStoreId(String toStoreId) {
		this.toStoreId = toStoreId;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}
	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
	}
	public String getStrFinancialStarDate() {
		return strFinancialStarDate;
	}
	public void setStrFinancialStarDate(String strFinancialStarDate) {
		this.strFinancialStarDate = strFinancialStarDate;
	}
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	public String getStrEntryDate() {
		return strEntryDate;
	}
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getAgendaNo() {
		return agendaNo;
	}
	public void setAgendaNo(String agendaNo) {
		this.agendaNo = agendaNo;
	}
	public String getReqNo() {
		return reqNo;
	}
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemBrandId() {
		return itemBrandId;
	}
	public void setItemBrandId(String itemBrandId) {
		this.itemBrandId = itemBrandId;
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
	public void reset()
	{
		modval                                         ="" ;
		hosp_code                                      ="";
		reqTypeId                                      ="";
		transNo                                        ="";
		toStoreId                                      =""; 
		transDate                                      ="";
		strId                                          ="";
		strItemCatgNo                                  ="";  
		strFinancialStarDate                           ="";
		strFinancialEndDate                            ="";
		strEntryDate                                   ="";
		strIsValid                                     ="";
		strBatchNo                                     ="";
		strStockStatusCode                             =""; 
		agendaNo                                       ="";
		reqNo                                          ="";
		
		itemId                                         ="";
		itemBrandId                                    ="";
		strErr = "";
	}

	public String getStrSancQty() {
		return strSancQty;
	}

	public void setStrSancQty(String strSancQty) {
		this.strSancQty = strSancQty;
	}

	public String getStrSancQtyUnit() {
		return strSancQtyUnit;
	}

	public void setStrSancQtyUnit(String strSancQtyUnit) {
		this.strSancQtyUnit = strSancQtyUnit;
	}

	public String getStrQty() {
		return strQty;
	}

	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}

	public String getStrCategNo() {
		return strCategNo;
	}

	public void setStrCategNo(String strCategNo) {
		this.strCategNo = strCategNo;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrRecevedBy() {
		return strRecevedBy;
	}

	public void setStrRecevedBy(String strRecevedBy) {
		this.strRecevedBy = strRecevedBy;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}
	
}