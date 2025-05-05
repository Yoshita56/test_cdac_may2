package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlIndentDtlDAO 
{
	private String  strId		  ="";
	private String indentPeriodValue ="";
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
    private String  grantTypeId	  ="0";
	private String  puk			  ="0";
	private String  empNo		  ="";
	private String  admNo		  ="0";
	private String  episodeCode	  ="0";
	private String  consultantId  ="";
	private String  memoNo		  ="0";
	private String  totCost       ="0";		 
	//reqd at the tiem of cancel
	private String   cancelSeatId ="";
	private String   cancelDate	  ="";
	private String   cancelReason ="";
	private String strBSReqNo="" ;
	
	private String strDiagCode="";
	private String strEmpCode="";
	
	public void setStrDiagCode(String strDiagCode) {
		this.strDiagCode = strDiagCode;
	}
	
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	//It is mandatory parameter, do not reset the following variables
	private String    strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.DML_INDENT_DTL";
	private final String strFileName = "mms.dao.DmlIndentDtlDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	private String strIsUtilityIndent="";
	public String getStrIsUtilityIndent() {
		return strIsUtilityIndent;
	}

	public void setStrIsUtilityIndent(String strIsUtilityIndent) {
		this.strIsUtilityIndent = strIsUtilityIndent;
	}

	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
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
	public String getGrantTypeId() {
		return grantTypeId;
	}
	public void setGrantTypeId(String grantTypeId) {
		this.grantTypeId = grantTypeId;
	}
	public String getPuk() {
		return puk;
	}
	public void setPuk(String puk) {
		this.puk = puk;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getAdmNo() {
		return admNo;
	}
	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}
	public String getEpisodeCode() {
		return episodeCode;
	}
	public void setEpisodeCode(String episodeCode) {
		this.episodeCode = episodeCode;
	}
	public String getConsultantId() {
		return consultantId;
	}
	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}
	public String getMemoNo() {
		return memoNo;
	}
	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}
	public String getTotCost() {
		return totCost;
	}
	public void setTotCost(String totCost) {
		this.totCost = totCost;
	}
	public String getCancelSeatId() {
		return cancelSeatId;
	}
	public void setCancelSeatId(String cancelSeatId) {
		this.cancelSeatId = cancelSeatId;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
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
			if(reqTypeId.equals("0") || reqTypeId.equals(""))
			{
				throw new Exception("Request Type Id can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			System.out.println("<<------  DmlIndentDtlDAO       ------>>"+strProcName+" [ Mode  - 1 ]");
			
			//System.out.println("In Dao--1-->>>"+strId.trim());
			//System.out.println("In Dao--11-->>>"+reqTypeId.trim());
			//System.out.println("In Dao--11-->>>"+hosp_code.trim());
			//System.out.println("In Dao--11-->>>"+toStrId.trim());
			//System.out.println("In Dao--11-->>>"+itemcatNo.trim());
			//System.out.println("In Dao--11-->>>"+itemTypeId.trim());
			//System.out.println("In Dao--11-->>>"+urgentFlag.trim());
			//System.out.println("In Dao--11-->>>"+indentPeriod.trim());
			//System.out.println("In Dao--11-->>>"+finStartDate.trim());
			//System.out.println("In Dao--11-->>>"+finEndDate.trim());
			//System.out.println("In Dao--11-->>>"+remarks.trim());
			//System.out.println("In Dao--11-->>>"+seatId.trim());
			//System.out.println("In Dao--11-->>>"+grantTypeId.trim());
			//System.out.println("In Dao--11-->>>"+puk.trim());
			//System.out.println("In Dao--11-->>>"+empNo.trim());
			//System.out.println("In Dao--11-->>>"+admNo.trim());
			//System.out.println("In Dao--11-->>>"+episodeCode.trim());
			//System.out.println("In Dao--11-->>>"+consultantId.trim());
			//System.out.println("In Dao--11-->>>"+indentPeriod.trim());
			//System.out.println("In Dao--11-->>>"+totCost.trim());
						
			//set the value
			//Input Value
			//System.out.println("In Dao--11-->>>"+totCost.trim());			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);                   //2
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),3);           //3
			dao.setProcInValue(nInsertedIndex,"reqTypeId ",reqTypeId.trim(),4);          //4 
			dao.setProcInValue(nInsertedIndex,"toStrId",toStrId.trim(),5);               //5
			dao.setProcInValue(nInsertedIndex,"itemcatNo",itemcatNo.trim(),6);           //6
			dao.setProcInValue(nInsertedIndex,"itemTypeId",itemTypeId.trim(),7);         //7  
			dao.setProcInValue(nInsertedIndex,"urgentFlag",urgentFlag.trim(),8);
			//8
			dao.setProcInValue(nInsertedIndex,"indentPeriod",indentPeriod.trim(),9);     //9
			dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim(),10);     //10       
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim(),11);         //11
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),12);   
			//12
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim(),13);                 //13
			dao.setProcInValue(nInsertedIndex,"grantTypeId",grantTypeId.trim(),14);       //14
			dao.setProcInValue(nInsertedIndex,"puk ",puk.trim(),15);                      //15 
			dao.setProcInValue(nInsertedIndex,"empNo",empNo.trim(),16);                   //16
			dao.setProcInValue(nInsertedIndex,"admNo",admNo.trim(),17);  
			//17
			dao.setProcInValue(nInsertedIndex,"episodeCode",episodeCode.trim(),18);       //18  
			dao.setProcInValue(nInsertedIndex,"consultantId",consultantId.trim(),19);     //19
			dao.setProcInValue(nInsertedIndex,"memoNo",memoNo.trim(),20);           //20
			dao.setProcInValue(nInsertedIndex,"totCost", totCost.trim(),21);  
			//21  
			dao.setProcInValue(nInsertedIndex,"indentPeriodValue", indentPeriodValue.trim(),22); //22
			
			dao.setProcInValue(nInsertedIndex,"cancelSeatId", "",23);
			dao.setProcInValue(nInsertedIndex,"cancelDate", "",24);
			dao.setProcInValue(nInsertedIndex,"cancelReason", "",25);
			
			dao.setProcInValue(nInsertedIndex,"certificateNo", "0",26);
			dao.setProcInValue(nInsertedIndex,"certificateDate", "",27);
			dao.setProcInValue(nInsertedIndex,"rateContSuppId", "0",28);
			dao.setProcInValue(nInsertedIndex, "bsReqNo", (!strBSReqNo.equals("") && strBSReqNo != null)?strBSReqNo:"0",29);
			dao.setProcInValue(nInsertedIndex, "diagCode", (!strDiagCode.equals("") && strDiagCode != null)?strDiagCode:"0",30);
			dao.setProcInValue(nInsertedIndex, "empCode", (!strEmpCode.equals("") && strEmpCode != null)?strEmpCode:"0",31);
			if(reqTypeId.equals("86"))
				dao.setProcInValue(nInsertedIndex, "isutility","0" ,32);
			else
				dao.setProcInValue(nInsertedIndex, "isutility",(!strIsUtilityIndent.equals("") && strIsUtilityIndent != null)?strIsUtilityIndent:"0" ,32);
			//dao.setProcInValue(nInsertedIndex, "isutility",((strIsUtilityIndent == null) || strIsUtilityIndent.endsWith("")) ? "0" : strIsUtilityIndent ,32);
	    	//output value                        
			dao.setProcOutValue(nInsertedIndex,"approvalFlg",1,33);                       //23
			dao.setProcOutValue(nInsertedIndex,"indentNo",1,34);                         //24
			dao.setProcOutValue(nInsertedIndex,"err",1,35);                               //25
			
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
			if(reqTypeId.equals("0") || reqTypeId.equals(""))
			{
				throw new Exception("Request Type Id can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			/*
			//System.out.println("In Dao--1-->>>"+strId.trim());
			//System.out.println("In Dao--11-->>>"+reqTypeId.trim());
			//System.out.println("In Dao--11-->>>"+hosp_code.trim());
			//System.out.println("In Dao--11-->>>"+toStrId.trim());
			//System.out.println("In Dao--11-->>>"+itemcatNo.trim());
			//System.out.println("In Dao--11-->>>"+itemTypeId.trim());
			//System.out.println("In Dao--11-->>>"+urgentFlag.trim());
			//System.out.println("In Dao--11-->>>"+indentPeriod.trim());
			//System.out.println("In Dao--11-->>>"+finStartDate.trim());
			//System.out.println("In Dao--11-->>>"+finEndDate.trim());
			//System.out.println("In Dao--11-->>>"+remarks.trim());
			//System.out.println("In Dao--11-->>>"+seatId.trim());
			//System.out.println("In Dao--11-->>>"+grantTypeId.trim());
			//System.out.println("In Dao--11-->>>"+puk.trim());
			//System.out.println("In Dao--11-->>>"+empNo.trim());
			//System.out.println("In Dao--11-->>>"+admNo.trim());
			//System.out.println("In Dao--11-->>>"+episodeCode.trim());
			//System.out.println("In Dao--11-->>>"+consultantId.trim());
			//System.out.println("In Dao--11-->>>"+indentPeriod.trim());
			//System.out.println("In Dao--11-->>>"+totCost.trim());
				*/		
			//set the value
			//Input Value
						
			dao.setProcInValue(nInsertedIndex,"modval","1");                           //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim());                   //2
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim());           //3
			dao.setProcInValue(nInsertedIndex,"reqTypeId ",reqTypeId.trim());          //4 
			dao.setProcInValue(nInsertedIndex,"toStrId",toStrId.trim());               //5
			dao.setProcInValue(nInsertedIndex,"itemcatNo",itemcatNo.trim());           //6
			dao.setProcInValue(nInsertedIndex,"itemTypeId",itemTypeId.trim());         //7  
			dao.setProcInValue(nInsertedIndex,"urgentFlag",urgentFlag.trim());         //8
			dao.setProcInValue(nInsertedIndex,"indentPeriod",indentPeriod.trim());     //9
			dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim());     //10       
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim());         //11
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim());               //12
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim());                 //13
			dao.setProcInValue(nInsertedIndex,"grantTypeId",grantTypeId.trim());       //14
			dao.setProcInValue(nInsertedIndex,"puk ",puk.trim());                      //15 
			dao.setProcInValue(nInsertedIndex,"empNo",empNo.trim());                   //16
			dao.setProcInValue(nInsertedIndex,"admNo",admNo.trim());                   //17
			dao.setProcInValue(nInsertedIndex,"episodeCode",episodeCode.trim());       //18  
			dao.setProcInValue(nInsertedIndex,"consultantId",consultantId.trim());     //19
			dao.setProcInValue(nInsertedIndex,"memoNo",memoNo.trim());           //20
			dao.setProcInValue(nInsertedIndex,"totCost", totCost.trim());              //21  
			dao.setProcInValue(nInsertedIndex,"indentPeriodValue", indentPeriodValue.trim()); //22
			
			dao.setProcInValue(nInsertedIndex,"cancelSeatId", "");
			dao.setProcInValue(nInsertedIndex,"cancelDate", "");
			dao.setProcInValue(nInsertedIndex,"cancelReason", "");
			dao.setProcInValue(nInsertedIndex,"certificateNo", "0");
			dao.setProcInValue(nInsertedIndex,"certificateDate", "");
			dao.setProcInValue(nInsertedIndex,"rateContSuppId", "0");
	    	//output value                        
			dao.setProcOutValue(nInsertedIndex,"approvalFlg",1);                       //23
			dao.setProcOutValue(nInsertedIndex,"indentNo",1);                          //24
			dao.setProcOutValue(nInsertedIndex,"err",1);                               //25
			
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
	 * This method will be used to clear all the variables
	 */
	private void reset() 
	{
		strId		  ="";
		hosp_code     ="";
		reqTypeId     ="";
		toStrId		  ="";
		itemcatNo	  ="";
		itemTypeId	  ="";
		urgentFlag	  ="0";
		indentPeriod  ="";
		finStartDate  ="";
		finEndDate	  ="";
		remarks		  ="";
		seatId		  ="";
	    grantTypeId	  ="0";
		puk			  ="0";
		empNo		  ="";
		admNo		  ="0";
		episodeCode	  ="0";
		consultantId  ="";
		memoNo		  ="";
		totCost       ="0";		 
		//reqd at the tiem of cancel
		 cancelSeatId ="";
		 cancelDate	  ="";
		 cancelReason ="";
		//It is mandatory parameter, do not reset the following variables
		  strErr = "";	
	}
	public String getIndentPeriodValue() {
		return indentPeriodValue;
	}
	public void setIndentPeriodValue(String indentPeriodValue) {
		this.indentPeriodValue = indentPeriodValue;
	}

	

}

