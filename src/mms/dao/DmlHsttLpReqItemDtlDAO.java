package mms.dao;
import hisglobal.transactionmgnt.HisDAO;
public class DmlHsttLpReqItemDtlDAO 
{
    
	 
	 private String strLpReqNo      ="";
	 private String strId		    ="";  
	 private String hosp_code		="";
	 private String strLpReqDate    =""; 
	 private String groupId			="";
	 private String subGroupId		="";
	 private String itemId	        ="";
	 private String itemBrandId	    ="0";
	 private String rate		    ="0";
	 private String rateUnitId		="";
	 private String reqQty          ="0";
	 private String reqQtyUnitId    ="";
	 private String sancQty         ="0";
	 private String sancQtyUnitId   ="";
	 private String IssueQty	    ="0";
	 private String IssueQtyUnitId	="";
	 private String returnQty       ="";
	 private String   returnQtyUnitId      ="";
	 private String   remarks		       ="";
	 private String   isValid              ="1";
	 private String   inHandQty            ="0";
	 private String   inHandQtyUnitId      ="";
	 private String   lstRecvQty           ="0";
	 private String   lstRecvQtyUnitId     ="";
	 private String   strLstRecDate        ="";  
    
	private String strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.DML_HSTT_LP_REQ_ITEM_DTL";
	private final String strFileName = "mms.dao.DmlHsttLpReqItemDtlDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
		
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
	public String getStrLpReqNo() {
		return strLpReqNo;
	}
	public void setStrLpReqNo(String strLpReqNo) {
		this.strLpReqNo = strLpReqNo;
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
	public String getStrLpReqDate() {
		return strLpReqDate;
	}
	public void setStrLpReqDate(String strLpReqDate) {
		this.strLpReqDate = strLpReqDate;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSubGroupId() {
		return subGroupId;
	}
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getRateUnitId() {
		return rateUnitId;
	}
	public void setRateUnitId(String rateUnitId) {
		this.rateUnitId = rateUnitId;
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
	public String getIssueQty() {
		return IssueQty;
	}
	public void setIssueQty(String issueQty) {
		IssueQty = issueQty;
	}
	public String getIssueQtyUnitId() {
		return IssueQtyUnitId;
	}
	public void setIssueQtyUnitId(String issueQtyUnitId) {
		IssueQtyUnitId = issueQtyUnitId;
	}
	public String getReturnQty() {
		return returnQty;
	}
	public void setReturnQty(String returnQty) {
		this.returnQty = returnQty;
	}
	public String getReturnQtyUnitId() {
		return returnQtyUnitId;
	}
	public void setReturnQtyUnitId(String returnQtyUnitId) {
		this.returnQtyUnitId = returnQtyUnitId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getInHandQty() {
		return inHandQty;
	}
	public void setInHandQty(String inHandQty) {
		this.inHandQty = inHandQty;
	}
	public String getInHandQtyUnitId() {
		return inHandQtyUnitId;
	}
	public void setInHandQtyUnitId(String inHandQtyUnitId) {
		this.inHandQtyUnitId = inHandQtyUnitId;
	}
	public String getLstRecvQty() {
		return lstRecvQty;
	}
	public void setLstRecvQty(String lstRecvQty) {
		this.lstRecvQty = lstRecvQty;
	}
	public String getLstRecvQtyUnitId() {
		return lstRecvQtyUnitId;
	}
	public void setLstRecvQtyUnitId(String lstRecvQtyUnitId) {
		this.lstRecvQtyUnitId = lstRecvQtyUnitId;
	}
	public String getStrLstRecDate() {
		return strLstRecDate;
	}
	public void setStrLstRecDate(String strLstRecDate) {
		this.strLstRecDate = strLstRecDate;
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
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Approval Id is blank or
	 * Approval SlNo. is blank
	 */
	public int insert(HisDAO dao) throws Exception 
	{
	  strErr = "";
	  try 
		{
		   // if(this.nRowInserted == 0) 
			//{
		  System.out.println("<<------  DmlHsttLpReqItemDtlDAO       ------>>"+strProcName+" [ Mode  - 1 ]");
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//}
			//set the value
			//Input Value
			/*
			//System.out.println("In Dao--1-->>>"+strId.trim());
			//System.out.println("In Dao--11-->>>"+strLpReqNo.trim());
			//System.out.println("In Dao--11-->>>"+hosp_code.trim());
			//System.out.println("In Dao--11-->>>"+strId.trim());
			//System.out.println("In Dao--11-->>>"+strLpReqDate.trim());
			//System.out.println("In Dao--11-->>>"+ groupId.trim());
			//System.out.println("In Dao--11-->>>"+subGroupId.trim());
			//System.out.println("In Dao--11-->>>"+itemId.trim());
			//System.out.println("In Dao--11-->>>"+itemBrandId.trim());
			//System.out.println("In Dao--11-->>>"+rate.trim());
			//System.out.println("In Dao--11-->>>"+rateUnitId.trim());
			//System.out.println("In Dao--11-->>>"+reqQty.trim());
			//System.out.println("In Dao--11-->>>"+reqQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+sancQty.trim());
			//System.out.println("In Dao--11-->>>"+sancQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+IssueQty.trim());
			//System.out.println("In Dao--11-->>>"+IssueQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+returnQty.trim());
			//System.out.println("In Dao--11-->>>"+returnQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+remarks.trim());
			
			
			//System.out.println("In Dao--11-->>>"+isValid.trim());
			//System.out.println("In Dao--11-->>>"+inHandQty.trim());
			//System.out.println("In Dao--11-->>>"+inHandQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+lstRecvQty.trim());
			//System.out.println("In Dao--11-->>>"+lstRecvQtyUnitId.trim());
			//System.out.println("In Dao--11-->>>"+strLstRecDate.trim());
			*/			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           //1
		   	dao.setProcInValue(nInsertedIndex,"strLpReqNo",strLpReqNo.trim(),2);         //2
	       	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),3);                   //3
			dao.setProcInValue(nInsertedIndex,"hosp_code ",hosp_code.trim(),4);          //4 
			dao.setProcInValue(nInsertedIndex,"strLpReqDate",strLpReqDate.trim(),5);     //5
			dao.setProcInValue(nInsertedIndex,"groupId",groupId.trim(),6);               //6
			dao.setProcInValue(nInsertedIndex,"subGroupId",subGroupId.trim(),7);         //7  
			dao.setProcInValue(nInsertedIndex,"itemId",itemId.trim(),8);                 //8
			dao.setProcInValue(nInsertedIndex,"itemBrandId",itemBrandId.trim(),9);       //9
			dao.setProcInValue(nInsertedIndex,"rate",rate.trim(),10);                     //10       
			dao.setProcInValue(nInsertedIndex,"rateUnitId",rateUnitId.trim(),11);         //11
			dao.setProcInValue(nInsertedIndex,"reqQty",reqQty.trim(),12);                 //12
			dao.setProcInValue(nInsertedIndex,"reqQtyUnitId",reqQtyUnitId.trim(),13);     //13
	       	dao.setProcInValue(nInsertedIndex,"sancQty",sancQty.trim(),14);               //14
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId",sancQtyUnitId.trim(),15);   //15 
			dao.setProcInValue(nInsertedIndex,"IssueQty",IssueQty.trim(),16);             //16
			dao.setProcInValue(nInsertedIndex,"IssueQtyUnitId",IssueQtyUnitId.trim(),17); //17
			dao.setProcInValue(nInsertedIndex,"returnQty",returnQty.trim(),18);           //18  
			dao.setProcInValue(nInsertedIndex,"returnQtyUnitId",returnQtyUnitId.trim(),19); //19
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),20);                 //20
			dao.setProcInValue(nInsertedIndex,"isValid", isValid.trim(),21);                //21   
			dao.setProcInValue(nInsertedIndex,"inHandQty",inHandQty.trim(),22);             //22
	       	dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId",inHandQtyUnitId.trim(),23); //23
			dao.setProcInValue(nInsertedIndex,"lstRecvQty ",lstRecvQty.trim(),24);          //24 
			dao.setProcInValue(nInsertedIndex,"lstRecvQtyUnitId",lstRecvQtyUnitId.trim(),25);    //25
			dao.setProcInValue(nInsertedIndex,"strLstRecDate",strLstRecDate.trim(),26);          //26
			
			dao.setProcInValue(nInsertedIndex,"strItemCatNo","",27);// Default Value.
				    	
			dao.setProcOutValue(nInsertedIndex,"err",1,28);                                      //27
			
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
		  strLpReqNo      ="";
		  strId		      ="";  
		  hosp_code		  ="";
		  strLpReqDate    =""; 
		  groupId		  ="";
		  subGroupId	  ="";
		  itemId	      ="";
		  itemBrandId	  ="0";
		  rate		      ="0";
		  rateUnitId	  ="";
		  reqQty          ="0";
		  reqQtyUnitId    ="";
		  sancQty         ="0";
		  sancQtyUnitId   ="";
		  IssueQty	      ="0";
		  IssueQtyUnitId  ="";
		  returnQty       ="";
		  returnQtyUnitId      ="";
		  remarks		       ="";
		  isValid              ="1";
		  inHandQty            ="0";
		  inHandQtyUnitId      ="";
		  lstRecvQty           ="0";
		  lstRecvQtyUnitId     ="";
		   strLstRecDate       ="";  
	
	}

	

}

