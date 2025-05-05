package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlApprovalItemDtlDAO 
{
	private String  modval		  ="1";     
	private String  strId		  ="";  
	private String  toStrId		  ="0";  
	private String  reqNo		  ="";
	private String  reqTypeId	  ="0";  
	private String  catNo		  ="0";  
    private String  itemId		  ="0";  
    private String  itemBrandId	  ="0";  
    private String  batchNo		  ="0";  
    private String  itemSlNo	  ="0";  
    private String  stkStatus	  ="";  
    private String  expiryDate	  ="";  
    
    private String  reqQty		  ="0";  
    private String  reqQtyUnitId  ="";  
 
    private String  prevSancQty		  ="0";  
    private String  prevSancQtyUnitId ="";
    private String  lstStatus     ="0";    
    
    private String  sancQty		  ="0";  
    private String  sancQtyUnitId ="";            
    private String  reservedFlag  ="0";
    private String  status  	  ="0";  
    private String  appNo    	  ="0";  
    private String  hosp_code     ="";  
    private String  seatId        ="";  
    private String  retSlNo 	  ="0";
    private String  strRemarks="";
	
    //It is mandatory parameter, do not reset the following variables
	private String    strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.DML_APPROVALITEM_DTL";
	private final String strProcName1 = "PKG_MMS_DML.DML_OFFLINE_APPROVALITEM_DTL";

	private final String strFileName = "mms.dao.DmlApprovalItemDtlDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	public String getStrId() {
		return strId;
	}
	
	public void setPrevSancQty(String prevSancQty) {
		this.prevSancQty = prevSancQty;
	}
		
	public void setPrevSancQtyUnitId(String prevSancQtyUnitId) {
		this.prevSancQtyUnitId = prevSancQtyUnitId;
	}
	
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getReqNo() {
		return reqNo;
	}
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	public String getHosp_code() {
		return hosp_code;
	}
	public void setHosp_code(String hosp_code) {
		this.hosp_code = hosp_code;
	}
	
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getModval() {
		return modval;
	}
	public void setModval(String modval) {
		this.modval = modval;
	}
	public String getToStrId() {
		return toStrId;
	}
	public void setToStrId(String toStrId) {
		this.toStrId = toStrId;
	}
	public String getReqTypeId() {
		return reqTypeId;
	}
	public void setReqTypeId(String reqTypeId) {
		this.reqTypeId = reqTypeId;
	}
	public String getCatNo() {
		return catNo;
	}
	public void setCatNo(String catNo) {
		this.catNo = catNo;
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getItemSlNo() {
		return itemSlNo;
	}
	public void setItemSlNo(String itemSlNo) {
		this.itemSlNo = itemSlNo;
	}
	public String getStkStatus() {
		return stkStatus;
	}
	public void setStkStatus(String stkStatus) {
		this.stkStatus = stkStatus;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getReqQty() {
		return reqQty;
	}
	public void setReqQty(String reqQty) {
		this.reqQty = reqQty;
	}
	public String getReqQtyUnitId() {
		return reqQtyUnitId;
	}
	public void setReqQtyUnitId(String reqQtyUnitId) {
		this.reqQtyUnitId = reqQtyUnitId;
	}
	public String getSancQty() {
		return sancQty;
	}
	public void setSancQty(String sancQty) {
		this.sancQty = sancQty;
	}
	public String getSancQtyUnitId() {
		return sancQtyUnitId;
	}
	public void setSancQtyUnitId(String sancQtyUnitId) {
		this.sancQtyUnitId = sancQtyUnitId;
	}
	public String getReservedFlag() {
		return reservedFlag;
	}
	public void setReservedFlag(String reservedFlag) {
		this.reservedFlag = reservedFlag;
	}
	public String getRetSlNo() {
		return retSlNo;
	}
	public void setRetSlNo(String retSlNo) {
		this.retSlNo = retSlNo;
	}
	
	/**
	 * This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Store Id is blank or
	 *                   - when Request type Id is blank
	 */
	public int insert(HisDAO dao) throws Exception 
	{
		
		strErr = "";
		
		try 
		{			
			
			//if(this.nRowInserted == 0) 
			//{   
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?::numeric,?,?::numeric,?, ?,?::numeric,?::numeric,?,?, ?,?,?::numeric,?::numeric,?::numeric, ?::numeric,?,?,?,?, ?,?,?::numeric,?,?, ?,?)}");
			//}
			
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);
		   	dao.setProcInValue(nInsertedIndex,"toStrId",toStrId.trim(),3);
		   	dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim(),4);                   //3
		   	
		   	//System.out.println("reqTypeId::::::"+reqTypeId);
	
		 	//System.out.println("catNo::::::"+catNo);
		 	//System.out.println("itemId::::::"+itemId);
		 	//System.out.println("itemBrandId::::::"+itemBrandId);
		 	//System.out.println("batchNo::::::"+batchNo);
		 	//System.out.println("itemSlNo::::::"+itemSlNo);
		 	//System.out.println("Status:::"+status.trim());
		 	//System.out.println("stkStatus::::::"+stkStatus);
		    //System.out.println("strId"+strId.trim());
		 	//System.out.println("toStrId"+toStrId.trim());
		 	//System.out.println("reqNo"+reqNo.trim());  
		    //System.out.println("expiryDate"+expiryDate.trim());         //11
		 	//System.out.println("reqQty"+reqQty.trim());                 //12
		 			
		 		//System.out.println("reqQtyUnitId"+reqQtyUnitId.trim());     //13       
		 		//System.out.println("sancQty"+sancQty.trim());               //14
		 		//System.out.println("sancQtyUnitId"+sancQtyUnitId.trim());   //15
		 		//System.out.println("reservedFlag"+reservedFlag.trim());     //16
		 		//System.out.println("status"+status.trim());                 //17       
		 		//System.out.println("appNo"+appNo.trim());                   //18
		 		//System.out.println("hosp_code"+hosp_code.trim());           //19
		 		//System.out.println("seatId"+seatId.trim());                 //20
		 		
		 		//System.out.println("prevSancQty"+prevSancQty.trim());              //22
		 		//System.out.println("prevSancQtyUnitId"+prevSancQtyUnitId.trim());  //23
		 		//System.out.println("lstStatus"+lstStatus.trim());

		 	
	       	dao.setProcInValue(nInsertedIndex,"reqTypeId",reqTypeId.trim(),5);           //4
			
	       	dao.setProcInValue(nInsertedIndex,"catNo",catNo.trim(),6);                   //5
		   	dao.setProcInValue(nInsertedIndex,"itemId",itemId.trim(),7);                 //6
		   	dao.setProcInValue(nInsertedIndex,"itemBrandId",itemBrandId.trim(),8);       //7
	       	dao.setProcInValue(nInsertedIndex,"batchNo",batchNo.trim(),9);               //8
	       	
	       	dao.setProcInValue(nInsertedIndex,"itemSlNo",itemSlNo.trim(),10);             //9       
			dao.setProcInValue(nInsertedIndex,"stkStatus",stkStatus.trim(),11);           //10
			dao.setProcInValue(nInsertedIndex,"expiryDate",expiryDate.trim(),12);         //11
			dao.setProcInValue(nInsertedIndex,"reqqty",reqQty.trim(),13);                 //12
			
			dao.setProcInValue(nInsertedIndex,"reqqtyunitid",reqQtyUnitId.trim(),14);     //13       
			dao.setProcInValue(nInsertedIndex,"sancQty",sancQty.trim(),15);               //14
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId",sancQtyUnitId.trim(),16);   //15
			dao.setProcInValue(nInsertedIndex,"reservedFlag",reservedFlag.trim(),19);     //16
			dao.setProcInValue(nInsertedIndex,"status",status.trim(),20);                 //17       
			dao.setProcInValue(nInsertedIndex,"appNo",appNo.trim(),21);                   //18
			dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),23);           //19
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim(),24);                 //20
		
			dao.setProcInValue(nInsertedIndex,"prevSancQty",prevSancQty.trim(),17);              //22
			dao.setProcInValue(nInsertedIndex,"prevSancQtyUnitId",prevSancQtyUnitId.trim(),18);  //23
			dao.setProcInValue(nInsertedIndex,"lstStatus",lstStatus.trim(),22);                  //24
			dao.setProcInValue(nInsertedIndex,"strremarks",strRemarks.trim(),25);          //25
	    	//output value   
			
			dao.setProcOutValue(nInsertedIndex,"retSlNo",1,26);                           //26
			dao.setProcOutValue(nInsertedIndex,"err",1,27);                               //27
				
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
	
	/**
	 * This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Store Id is blank or
	 *                   - when Request type Id is blank
	 */
	public int insert1(HisDAO dao) throws Exception 
	{
		//System.out.println("DMLAPPDAO INERT!");
		
		strErr = "";
		
		try 
		{			
			if(this.nRowInserted == 0) 
			{   
				nInsertedIndex = dao.setProcedure("{call " + strProcName1 + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim());                   //2
		   	dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim());                   //3
		   	
//		   	//System.out.println("reqTypeId::::::"+reqTypeId);
//		 	//System.out.println("reqNo::::::"+reqNo);
//		 	//System.out.println("catNo::::::"+catNo);
//		 	//System.out.println("itemId::::::"+itemId);
//		 	//System.out.println("itemBrandId::::::"+itemBrandId);
//		 	//System.out.println("batchNo::::::"+batchNo);
//		 	//System.out.println("itemSlNo::::::"+itemSlNo);
//		 	//System.out.println("stkStatus::::::"+stkStatus);
//
//		 	//System.out.println("expiryDate::::::"+expiryDate);
//		 	//System.out.println("reqQty::::::"+reqQty);
//		 	//System.out.println("reqQtyUnitId::::::"+reqQtyUnitId);
//		 	//System.out.println("sancQty::::::"+sancQty);
//		 	//System.out.println("sancQtyUnitId::::::"+sancQtyUnitId);
//		 	//System.out.println("reservedFlag::::::"+reservedFlag);
//		 	//System.out.println("status::::::"+status);
//	       	
//		 	//System.out.println("appNo::::::"+appNo);
//		 	//System.out.println("hosp_code::::::"+hosp_code);
//		 	//System.out.println("seatId::::::"+seatId);
//		 	//System.out.println("toStrId::::::"+toStrId);
//		 	//System.out.println("prevSancQty::::::"+prevSancQty);
//		 	//System.out.println("prevSancQtyUnitId::::::"+prevSancQtyUnitId);
//		 	//System.out.println("lstStatus::::::"+lstStatus);
//		 	//System.out.println("strRemarks::::::"+strRemarks);
		 	
		 	
		 	
	       	dao.setProcInValue(nInsertedIndex,"reqTypeId",reqTypeId.trim());           //4
			
	       	dao.setProcInValue(nInsertedIndex,"catNo",catNo.trim());                   //5
		   	dao.setProcInValue(nInsertedIndex,"itemId",itemId.trim());                 //6
		   	dao.setProcInValue(nInsertedIndex,"itemBrandId",itemBrandId.trim());       //7
	       	dao.setProcInValue(nInsertedIndex,"batchNo",batchNo.trim());               //8
	       	
	       	dao.setProcInValue(nInsertedIndex,"itemSlNo",itemSlNo.trim());             //9    
	       	
			dao.setProcInValue(nInsertedIndex,"stkStatus",stkStatus.trim());           //10
			dao.setProcInValue(nInsertedIndex,"expiryDate",expiryDate.trim());         //11
			dao.setProcInValue(nInsertedIndex,"reqQty",reqQty.trim());                 //12
			
			dao.setProcInValue(nInsertedIndex,"reqQtyUnitId",reqQtyUnitId.trim());     //13       
			dao.setProcInValue(nInsertedIndex,"sancQty",sancQty.trim());               //14
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId",sancQtyUnitId.trim());   //15
			dao.setProcInValue(nInsertedIndex,"reservedFlag",reservedFlag.trim());     //16
			////System.out.println("status::::::"+status);
			dao.setProcInValue(nInsertedIndex,"status",status.trim());                 //17       
			dao.setProcInValue(nInsertedIndex,"appNo",appNo.trim());                   //18
			dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim());           //19
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim());                 //20
			dao.setProcInValue(nInsertedIndex,"toStrId",toStrId.trim());               //21
			
			
		
			dao.setProcInValue(nInsertedIndex,"prevSancQty",prevSancQty.trim());              //22
			dao.setProcInValue(nInsertedIndex,"prevSancQtyUnitId",prevSancQtyUnitId.trim());  //23
			dao.setProcInValue(nInsertedIndex,"lstStatus",lstStatus.trim());                  //24
			////System.out.println("Lst Status is--->>"+lstStatus.trim());
			dao.setProcInValue(nInsertedIndex,"strRemarks",strRemarks.trim());          //25
	    	//output value   
			
			dao.setProcOutValue(nInsertedIndex,"retSlNo",1);                           //26
			dao.setProcOutValue(nInsertedIndex,"err",1);                               //27
				
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e)
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert1() --> " + this.strErr);
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
		strId		  ="";
		hosp_code     ="";
		
		seatId		  ="";
        strErr = "";	
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	
	

}
