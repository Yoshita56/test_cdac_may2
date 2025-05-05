package mms.dao;
import hisglobal.transactionmgnt.HisDAO;
public class DmlHsttPurIndentItemDtlDAO 
{
     private String strId	         ="";
	 private String strReqNo         ="";
	 private String itemId	         ="";
	 private String itemBrandId		 ="0";
	 private String hosp_code		 ="";
	 private String strPurchseReqDate=""; 
	 private String groupId			 ="";
	 private String subGroupId		 ="";
	 private String rate			 ="0";
	 private String rateUnitId		 ="";
	 private String IndentQty				="0";
	 private String IndentQtyUnitId			="";
	 private String sancQty                 ="0";
	 private String sancQtyUnitId           ="";
	 private String inHandQty               ="0";
	 private String inHandQtyUnitId         ="";
	 private String reOrderLevel			="";
	 private String reOrderUnitId			="";
	 private String manufacturerId          ="";
	 private String approxRate                ="";
	 private String approxRateUnitId          ="";
	 private String lstYearConsumption        ="";
	 private String lstYearConsumptionUnitId  ="0";
	 private String strJustification          ="";
	 private String remarks					  ="";
	 private String isValid                   ="1";
	 private String strLstPoNo				  =""; 
	 private String strLstPoDate		 	  ="";
	 private String strLstRecQty			  ="";
	 private String strLstRecQtyUnitId		  ="";
	 private String strLstRecDate			  ="0";
	 private String strLstSupplierId		  =""; 
	 private String strCHMOQty                ="0";
	 private String strMCQty                  ="0";
	
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl";

	private final String strFileName = "mms.dao.DmlHsttPurIndentItemDtlDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	

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

	public String getIndentQty() {
		return IndentQty;
	}

	public void setIndentQty(String indentQty) {
		IndentQty = indentQty;
	}

	public String getIndentQtyUnitId() {
		return IndentQtyUnitId;
	}

	public void setIndentQtyUnitId(String indentQtyUnitId) {
		IndentQtyUnitId = indentQtyUnitId;
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

	
	public String getReOrderLevel() {
		return reOrderLevel;
	}

	public void setReOrderLevel(String reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	public String getReOrderUnitId() {
		return reOrderUnitId;
	}

	public void setReOrderUnitId(String reOrderUnitId) {
		this.reOrderUnitId = reOrderUnitId;
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

	
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Approval Id is blank or
	 * Approval SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try 
		{
			
			System.out.println("<<------  DmlHsttPurIndentItemDtlDAO       ------>>"+strProcName+" [ Mode  - 1 ]");
			//check mandatory information
			
//			if(this.nRowInserted == 0) 
//			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//			}
			//set the value
			//Input Value                 
			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                                   //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim(),2);                           //2
	       	dao.setProcInValue(nInsertedIndex,"strReqNo",strReqNo.trim(),3);                     //3
	       	dao.setProcInValue(nInsertedIndex,"itemId",itemId.trim(),4);                         //4
			dao.setProcInValue(nInsertedIndex,"itemBrandId",itemBrandId.trim(),5);               //5
			dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim(),6);                   //6 
			dao.setProcInValue(nInsertedIndex,"strPurchseReqDate",strPurchseReqDate.trim(),7);   //7
			dao.setProcInValue(nInsertedIndex,"groupId",groupId.trim(),8);                       //8
			dao.setProcInValue(nInsertedIndex,"subGroupId",subGroupId.trim(),9);                 //9  
			dao.setProcInValue(nInsertedIndex,"rate",rate.trim(),10);                             //10       
			dao.setProcInValue(nInsertedIndex,"rateUnitId",rateUnitId.trim(),11);                 //11
			dao.setProcInValue(nInsertedIndex,"IndentQty",IndentQty.trim(),12);                   //12
			dao.setProcInValue(nInsertedIndex,"IndentQtyUnitId",IndentQtyUnitId.trim(),13);       //13
			dao.setProcInValue(nInsertedIndex,"sancQty",sancQty.trim(),14);                       //14 
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId",sancQtyUnitId.trim(),15);           //15
			dao.setProcInValue(nInsertedIndex,"inHandQty",inHandQty.trim(),16);                   //16
			dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId",inHandQtyUnitId.trim(),17);       //17
			dao.setProcInValue(nInsertedIndex,"reOrderLevel",reOrderLevel.trim(),18);             //18
			dao.setProcInValue(nInsertedIndex,"reOrderUnitId",reOrderUnitId.trim(),19);           //19
			dao.setProcInValue(nInsertedIndex,"manufacturerId",manufacturerId.trim(),20);         //20
			dao.setProcInValue(nInsertedIndex,"approxRate",approxRate.trim(),21);                 //21
			dao.setProcInValue(nInsertedIndex,"approxRateUnitId",approxRateUnitId.trim(),22);     //22
			dao.setProcInValue(nInsertedIndex,"lstYearConsumption",lstYearConsumption.trim(),23); //23
			dao.setProcInValue(nInsertedIndex,"lstYearConsumptionUnitId",lstYearConsumptionUnitId.trim(),24); //24  
			dao.setProcInValue(nInsertedIndex,"strJustification",strJustification.trim(),25);                 //25 
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim(),26);                                   //26  
			dao.setProcInValue(nInsertedIndex,"isValid ",isValid .trim(),27);                                 //27
			
			dao.setProcInValue(nInsertedIndex,"strLstPoNo",strLstPoNo.trim(),28);                 //28
			dao.setProcInValue(nInsertedIndex,"strLstPoDate",strLstPoDate.trim(),29);             //29  
			dao.setProcInValue(nInsertedIndex,"strLstRecQty",strLstRecQty.trim(),30);             //30 
			dao.setProcInValue(nInsertedIndex,"strLstRecQtyUnitId",strLstRecQtyUnitId.trim(),31); //31  
			dao.setProcInValue(nInsertedIndex,"strLstRecDate ",strLstRecDate.trim(),32);         //32
			dao.setProcInValue(nInsertedIndex,"strLstSupplierId ",strLstSupplierId .trim(),33);   //33
			
			dao.setProcInValue(nInsertedIndex,"itemSpecification","0",34);
			dao.setProcInValue(nInsertedIndex,"itemMake","0",35);
			dao.setProcInValue(nInsertedIndex,"suggSupplier","0",36);
			dao.setProcInValue(nInsertedIndex,"rateContractSupp","0",37);
			dao.setProcInValue(nInsertedIndex,"brandResFlag","1",38);
			dao.setProcInValue(nInsertedIndex,"itemSlNo","0",39);
			dao.setProcInValue(nInsertedIndex,"uploadfileid","0",40);
			dao.setProcInValue(nInsertedIndex,"uploadfilename","0",41);
			
			dao.setProcInValue(nInsertedIndex,"strChMOQty",strCHMOQty,42);
			dao.setProcInValue(nInsertedIndex,"strMCQty",strMCQty,43);
			//output value                        
			dao.setProcOutValue(nInsertedIndex,"err",1,44);                                       //34 
			
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
	}
	
	
	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset()
	{
		 
		     
			 strId			    ="";	  
			 hosp_code			="";
			 
			 groupId			="";
			 subGroupId			="";
			 itemId				="";
			 itemBrandId		="0";
			 rate				="0";
			 rateUnitId			="";
     		 IndentQty			="0";
			 IndentQtyUnitId	="";
			 sancQty            ="0";
			 sancQtyUnitId      ="";
			 
			 inHandQty          ="0";
			 inHandQtyUnitId    ="";
			 
			 reOrderLevel		="";
			 reOrderUnitId		="";
	         
			 remarks			="";
			 isValid            ="1";
					
		 
	
	}

	public String getStrReqNo() {
		return strReqNo;
	}

	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	public String getStrPurchseReqDate() {
		return strPurchseReqDate;
	}

	public void setStrPurchseReqDate(String strPurchseReqDate) {
		this.strPurchseReqDate = strPurchseReqDate;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getApproxRateUnitId() {
		return approxRateUnitId;
	}

	public void setApproxRateUnitId(String approxRateUnitId) {
		this.approxRateUnitId = approxRateUnitId;
	}

	public String getLstYearConsumption() {
		return lstYearConsumption;
	}

	public void setLstYearConsumption(String lstYearConsumption) {
		this.lstYearConsumption = lstYearConsumption;
	}

	public String getLstYearConsumptionUnitId() {
		return lstYearConsumptionUnitId;
	}

	public void setLstYearConsumptionUnitId(String lstYearConsumptionUnitId) {
		this.lstYearConsumptionUnitId = lstYearConsumptionUnitId;
	}

	public String getStrJustification() {
		return strJustification;
	}

	public void setStrJustification(String strJustification) {
		this.strJustification = strJustification;
	}

	public String getApproxRate() {
		return approxRate;
	}

	public void setApproxRate(String approxRate) {
		this.approxRate = approxRate;
	}

	public void setStrLstPoNo(String strLstPoNo) {
		this.strLstPoNo = strLstPoNo;
	}

	public void setStrLstPoDate(String strLstPoDate) {
		this.strLstPoDate = strLstPoDate;
	}

	public void setStrLstRecQty(String strLstRecQty) {
		this.strLstRecQty = strLstRecQty;
	}

	public void setStrLstRecQtyUnitId(String strLstRecQtyUnitId) {
		this.strLstRecQtyUnitId = strLstRecQtyUnitId;
	}

	public void setStrLstRecDate(String strLstRecDate) {
		this.strLstRecDate = strLstRecDate;
	}

	public void setStrLstSupplierId(String strLstSupplierId) {
		this.strLstSupplierId = strLstSupplierId;
	}

	public String getStrLstPoNo() {
		return strLstPoNo;
	}

	public String getStrLstPoDate() {
		return strLstPoDate;
	}

	public String getStrLstRecQty() {
		return strLstRecQty;
	}

	public String getStrLstRecQtyUnitId() {
		return strLstRecQtyUnitId;
	}

	public String getStrLstRecDate() {
		return strLstRecDate;
	}

	public String getStrLstSupplierId() {
		return strLstSupplierId;
	}

	public String getStrCHMOQty() {
		return strCHMOQty;
	}

	public void setStrCHMOQty(String strCHMOQty) {
		this.strCHMOQty = strCHMOQty;
	}

	public String getStrMCQty() {
		return strMCQty;
	}

	public void setStrMCQty(String strMCQty) {
		this.strMCQty = strMCQty;
	}

	

}
