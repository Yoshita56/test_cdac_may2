package mms.dao;

import hisglobal.transactionmgnt.HisDAO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/June/2009
 * Modif Date : / /2009 
*/

public class DmlApprovalDtlDAO 
{
	private String  strId		  ="";  
	private String  reqNo         ="";
	private String  hosp_code     ="";
	private String  levelType	  ="";
	private String  approvalType  ="";
	private String  ipAddress	  ="";
	private String  finStartDate  ="";
	private String  finEndDate	  ="";
	private String  remarks		  ="";
	private String  seatId		  ="";
	private String  itemDetail    ="";
	private String  appNo         ="";
	private String  status        ="";
	private String  committeTypeID="";
	private String  commRemarks   ="";
	private String  deliveryDate  ="";
	private String  returnType    ="";
	
	private String  reqtype	      ="";
	private String  catno		  ="";
	private String  reqStatus	  ="";
	private String  newStatus     ="";
	private String  itemDtl       ="";
	private String  authNo        ="";
	private String  appId         ="";
	private String  toStore       ="";
	private String  instCode  	  ="";
	private String  instSlno      ="";
	private String  suppId    	  ="";
	private String  modval    	  ="";
	
	
		
    //It is mandatory parameter, do not reset the following variables
	private String    strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.DML_APPROVAL_DTL";
	private final String strProcName1 = "PKG_MMS_DML.DML_OFFLINE_APPROVAL_DTL";

	private final String strFileName = "mms.dao.DmlIndentDtlDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	public void setHosp_code(String hosp_code) {
		this.hosp_code = hosp_code;
	}
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}
	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public void setFinStartDate(String finStartDate) {
		this.finStartDate = finStartDate;
	}
	public void setFinEndDate(String finEndDate) {
		this.finEndDate = finEndDate;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}
	public String getStrId() {
		return strId;
	}
	public String getReqNo() {
		return reqNo;
	}
	public String getHosp_code() {
		return hosp_code;
	}
	public String getLevelType() {
		return levelType;
	}
	public String getApprovalType() {
		return approvalType;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public String getFinStartDate() {
		return finStartDate;
	}
	public String getFinEndDate() {
		return finEndDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getSeatId() {
		return seatId;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public String getAppNo() {
		return appNo;
	}
	public String getStatus() {
		return status;
	}
	public String getStrErr() {
		return strErr;
	}
	public String getStrProcName() {
		return strProcName;
	}
	public String getStrFileName() {
		return strFileName;
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
			//check mandatory information
			if(strId.equals("0") || strId.equals(""))
			{
				throw new Exception("Store Id can not be blank");
			}
			
			if(reqNo.equals("0") || reqNo.equals(""))
			{
				throw new Exception("Req No can not be blank");
			}
			
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?::numeric,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
						
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);                   //2
		   	dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim(),3);                   //3
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),4);           //4
			
	       	dao.setProcInValue(nInsertedIndex,"levelType",levelType.trim(),5);           //5
		   	dao.setProcInValue(nInsertedIndex,"approvalType",approvalType.trim(),6);     //6
		   	dao.setProcInValue(nInsertedIndex,"ipAddress",ipAddress.trim(),7);           //7
	       	dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim(),8);     //8  
	        	
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim(),9);         //9
			
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),10);               //10
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim(),11);                 //11
			
			/* This Is For Return From Supplier */
			
			dao.setProcInValue(nInsertedIndex,"deliveryDate",deliveryDate.trim(),12);     //12
			dao.setProcInValue(nInsertedIndex,"returnType",returnType.trim(),13);         //13
			
			/* This Is For Condemnation request */
			
			dao.setProcInValue(nInsertedIndex,"commTypeId",committeTypeID.trim(),14);     //14
			dao.setProcInValue(nInsertedIndex,"commRemarks",commRemarks.trim(),15);       //15			
	    	//output value                        
			dao.setProcOutValue(nInsertedIndex,"itemDetail",1,16);                        //16
			dao.setProcOutValue(nInsertedIndex,"appNo",1,17);                             //17
			dao.setProcOutValue(nInsertedIndex,"status",1,18);                            //18
			dao.setProcOutValue(nInsertedIndex,"lstStatus",1,19);                         //19
			dao.setProcOutValue(nInsertedIndex,"err",1,20);                               //20
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
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
		return nInsertedIndex;
	}
	
	public int insert_Special(HisDAO dao) throws Exception 
	{
		
		strErr = "";
		
		try 
		{
			//check mandatory information
			if(strId.equals("0") || strId.equals(""))
			{
				throw new Exception("Store Id can not be blank");
			}
			
			if(reqNo.equals("0") || reqNo.equals(""))
			{
				throw new Exception("Req No can not be blank");
			}
			
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?::numeric,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
						
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","2",1);                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);                   //2
		   	dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim(),3);                   //3
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),4);           //4
			
	       	dao.setProcInValue(nInsertedIndex,"levelType",levelType.trim(),5);           //5
		   	dao.setProcInValue(nInsertedIndex,"approvalType",approvalType.trim(),6);     //6
		   	dao.setProcInValue(nInsertedIndex,"ipAddress",ipAddress.trim(),7);           //7
	       	dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim(),8);     //8  
	        	
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim(),9);         //9
			
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),10);               //10
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim(),11);                 //11
			
			/* This Is For Return From Supplier */
			
			dao.setProcInValue(nInsertedIndex,"deliveryDate",deliveryDate.trim(),12);     //12
			dao.setProcInValue(nInsertedIndex,"returnType",returnType.trim(),13);         //13
			
			/* This Is For Condemnation request */
			
			dao.setProcInValue(nInsertedIndex,"commTypeId",committeTypeID.trim(),14);     //14
			dao.setProcInValue(nInsertedIndex,"commRemarks",commRemarks.trim(),15);       //15			
	    	//output value                        
			dao.setProcOutValue(nInsertedIndex,"itemDetail",1,16);                        //16
			dao.setProcOutValue(nInsertedIndex,"appNo",1,17);                             //17
			dao.setProcOutValue(nInsertedIndex,"status",1,18);                            //18
			dao.setProcOutValue(nInsertedIndex,"lstStatus",1,19);                         //19
			dao.setProcOutValue(nInsertedIndex,"err",1,20);                               //20
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
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
		
		strErr = "";
		
		try 
		{
			//check mandatory information
			if(strId.equals("0") || strId.equals(""))
			{
				throw new Exception("Store Id can not be blank");
			}
			
			if(reqNo.equals("0") || reqNo.equals(""))
			{
				throw new Exception("Req No can not be blank");
			}
			
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName1 + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // Total 24 variables
			}
						
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval",modval.trim(),1);                 //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);                   //2
		   	dao.setProcInValue(nInsertedIndex,"reqNo",reqNo.trim(),3);                   //3
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),4);           //4
			
	       	dao.setProcInValue(nInsertedIndex,"levelType",levelType.trim(),5);           //5
		   	dao.setProcInValue(nInsertedIndex,"approvalType",approvalType.trim(),6);     //6
		   	dao.setProcInValue(nInsertedIndex,"ipAddress",ipAddress.trim(),7);           //7
	       	dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim(),8);     //8  
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim(),9);         //9
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),10);               //10
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim(),11);                 //11
			dao.setProcInValue(nInsertedIndex,"reqtype",reqtype.trim(),12);               //12
			dao.setProcInValue(nInsertedIndex,"catno",catno.trim(),13);                   //13
			dao.setProcInValue(nInsertedIndex,"reqStatus",reqStatus.trim(),14);           //14
			dao.setProcInValue(nInsertedIndex,"newStatus",newStatus.trim(),15);           //15	
			dao.setProcInValue(nInsertedIndex,"itemDtl",itemDtl.trim(),16);               //16
			dao.setProcInValue(nInsertedIndex,"authNo",authNo.trim(),17);                 //17
			dao.setProcInValue(nInsertedIndex,"appId",appId.trim(),18);                   //18
			dao.setProcInValue(nInsertedIndex,"toStore",toStore.trim(),19);               //19	
			dao.setProcInValue(nInsertedIndex,"instCode",instCode.trim(),20);             //20
			dao.setProcInValue(nInsertedIndex,"instSlno",instSlno.trim(),21);             //21
			dao.setProcInValue(nInsertedIndex,"suppId",suppId.trim(),22);                 //22	
			dao.setProcInValue(nInsertedIndex,"appNo",appNo.trim(),23);                   //23	
			
	    	//output value                        			
			
			dao.setProcOutValue(nInsertedIndex,"err",1,24);                               //24
						
			//keep in batch
			dao.execute(nInsertedIndex,1);
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
		return nInsertedIndex;
	}
	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() 
	{
		strId		  ="";
		hosp_code     ="";
		finStartDate  ="";
		finEndDate	  ="";
		remarks		  ="";
		seatId		  ="";
        strErr = "";	
	}
	public String getCommitteTypeID() {
		return committeTypeID;
	}
	public void setCommitteTypeID(String committeTypeID) {
		this.committeTypeID = committeTypeID;
	}
	public String getCommRemarks() {
		return commRemarks;
	}
	public void setCommRemarks(String commRemarks) {
		this.commRemarks = commRemarks;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getReqtype() {
		return reqtype;
	}
	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}
	public String getCatno() {
		return catno;
	}
	public void setCatno(String catno) {
		this.catno = catno;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getItemDtl() {
		return itemDtl;
	}
	public void setItemDtl(String itemDtl) {
		this.itemDtl = itemDtl;
	}
	public String getAuthNo() {
		return authNo;
	}
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getToStore() {
		return toStore;
	}
	public void setToStore(String toStore) {
		this.toStore = toStore;
	}
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	public String getInstSlno() {
		return instSlno;
	}
	public void setInstSlno(String instSlno) {
		this.instSlno = instSlno;
	}
	public String getSuppId() {
		return suppId;
	}
	public void setSuppId(String suppId) {
		this.suppId = suppId;
	}
	public String getStrProcName1() {
		return strProcName1;
	}
	public String getModval() {
		return modval;
	}
	public void setModval(String modval) {
		this.modval = modval;
	}

	
	

}
