package mms.dao;
import hisglobal.transactionmgnt.HisDAO;
/**
 * Developer : Amit Kr
 * Version : 1.0
 * Date : 27/May/2009
 * 
 * This class will be used to insert/update/delete the records
 * Table Name     : 
 * Procedure Name : 
*/
public class DmlIndentDtlImportedItemDAO 
{
	private String  strId		 ="";
	private String  hosp_code    ="";
	private String  reqTypeId    ="";
    private String  toStrId		 ="";
	private String  itemcatNo	 ="";
	private String  itemTypeId	 ="";
	private String  urgentFlag	 ="0";
	private String  indentPeriod ="";
	private String  finStartDate ="";
	private String  finEndDate	 ="";
	private String  remarks		 ="";
	private String  seatId		 ="";
    private String  grantTypeId	 ="0";
	private String  puk			 ="0";
	private String  empNo		 ="";
	private String  admNo		 ="0";
	private String  episodeCode	 ="0";
	private String  consultantId ="";
//	private String  memoNo		 ="";
  	private String  totCost      ="0";		 
	//reqd at the tiem of cancel
//	private String   cancelSeatId  ="";
//	private String   cancelDate	   ="";
//	private String   cancelReason  ="";
	//  --Variable for table  HSTT_IMPPUR_REQ_DTL 
	private String   strImpReqNo                  ="";  //1
	private String   strImpReqDate                ="";  //2
	private String   strCurrncyId                 ="";  //3
	private String   strTsInvoiceRecd             ="1"; //4
	private String   strInstallationReq           ="0"; //5
	private String   strInstallationChg           ="0"; //6
	private String   strQutnInvite                ="0"; //7
	private String   strQutnJustificn             ="";  //8 
	private String   strWarranty                  ="0"; //9
	private String   strPurpose                   ="";  //10
	private String   strJustificn                 ="";  //11
	private String   strGrpId                     ="";  //12
	private String   strSubGrpId                  ="0"; //13
	private String   strItemId                    ="";  //14
	private String   strItemBrandId               ="0"; //15
	private String   strInhandQty                 ="0"; //16
	private String   strInhandQtyUnitId           ="0"; //17
	private String   strRate                      ="0"; //18
	private String   strRateUnitId                ="0"; //19
	private String   strReqQty                    ="0"; //20
	private String   strReqQtyUnitId              ="";  //21
	private String   strSancQty                   ="0"; //22
	private String   strSancQtyUnitId             ="";  //23
	private String   strLstYearConsump            ="0"; //24
	private String   strLstYearConsumpUnitId      ="";  //25
	private String   strCost                      ="0"; //26
	private String   strSupplierId                ="";  //27
	private String   strLstPoNo                   ="";  //28
	private String   strLstPoDate                 ="";  //29
	private String   strLstRecDate                ="";  //30
	private String   strReqStatus                 ="0"; //31
//	private String   strEntryDate                 ="";  //35
//	private String   strIsValid                   ="1"; //36
	private String   strOrderQty                  ="0"; //37
	private String   strOrderQtyUnitId            ="0"; //38
	private String   strLstSupplierId             ="0"; //39
	  
	private String   strLstRate                   ="0"; //40 
	private String   strLstRateUnitId             ="0"; //41
	private String   strApproxRate                ="";  //42
	
  	//It is mandatory parameter, do not reset the following variables
	private String   strErr = "";
	
	private final String strProcName = "PKG_MMS_DML.DML_INDENT_DTL_IMPORTED_ITEM";
	private final String strFileName = "mms.dao.DmlIndentDtlImportedItemDAO";
	
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
	
	
	
	public void setStrApproxRate(String strApproxRate) {
		this.strApproxRate = strApproxRate;
	}
	
	
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public void setHosp_code(String hosp_code) {
		this.hosp_code = hosp_code;
	}
	public void setReqTypeId(String reqTypeId) {
		this.reqTypeId = reqTypeId;
	}
	public void setToStrId(String toStrId) {
		this.toStrId = toStrId;
	}
	public void setItemcatNo(String itemcatNo) {
		this.itemcatNo = itemcatNo;
	}
	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public void setUrgentFlag(String urgentFlag) {
		this.urgentFlag = urgentFlag;
	}
	public void setIndentPeriod(String indentPeriod) {
		this.indentPeriod = indentPeriod;
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
	public void setGrantTypeId(String grantTypeId) {
		this.grantTypeId = grantTypeId;
	}
	public void setPuk(String puk) {
		this.puk = puk;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}
	public void setEpisodeCode(String episodeCode) {
		this.episodeCode = episodeCode;
	}
	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}
 
	public void setTotCost(String totCost) {
		this.totCost = totCost;
	}
	 
	public void setStrImpReqNo(String strImpReqNo) {
		this.strImpReqNo = strImpReqNo;
	}
	public void setStrImpReqDate(String strImpReqDate) {
		this.strImpReqDate = strImpReqDate;
	}
	public void setStrCurrncyId(String strCurrncyId) {
		this.strCurrncyId = strCurrncyId;
	}
	public void setStrTsInvoiceRecd(String strTsInvoiceRecd) {
		this.strTsInvoiceRecd = strTsInvoiceRecd;
	}
	public void setStrInstallationReq(String strInstallationReq) {
		this.strInstallationReq = strInstallationReq;
	}
	public void setStrInstallationChg(String strInstallationChg) {
		this.strInstallationChg = strInstallationChg;
	}
	public void setStrQutnInvite(String strQutnInvite) {
		this.strQutnInvite = strQutnInvite;
	}
	public void setStrQutnJustificn(String strQutnJustificn) {
		this.strQutnJustificn = strQutnJustificn;
	}
	public void setStrWarranty(String strWarranty) {
		this.strWarranty = strWarranty;
	}
	public void setStrPurpose(String strPurpose) {
		this.strPurpose = strPurpose;
	}
	public void setStrJustificn(String strJustificn) {
		this.strJustificn = strJustificn;
	}
	public void setStrGrpId(String strGrpId) {
		this.strGrpId = strGrpId;
	}
	public void setStrSubGrpId(String strSubGrpId) {
		this.strSubGrpId = strSubGrpId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public void setStrReqQtyUnitId(String strReqQtyUnitId) {
		this.strReqQtyUnitId = strReqQtyUnitId;
	}
	public void setStrSancQty(String strSancQty) {
		this.strSancQty = strSancQty;
	}
	public void setStrSancQtyUnitId(String strSancQtyUnitId) {
		this.strSancQtyUnitId = strSancQtyUnitId;
	}
	public void setStrLstYearConsump(String strLstYearConsump) {
		this.strLstYearConsump = strLstYearConsump;
	}
	public void setStrLstYearConsumpUnitId(String strLstYearConsumpUnitId) {
		this.strLstYearConsumpUnitId = strLstYearConsumpUnitId;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public void setStrLstPoNo(String strLstPoNo) {
		this.strLstPoNo = strLstPoNo;
	}
	public void setStrLstPoDate(String strLstPoDate) {
		this.strLstPoDate = strLstPoDate;
	}
	public void setStrLstRecDate(String strLstRecDate) {
		this.strLstRecDate = strLstRecDate;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
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
	 * @throws Exception - when Store Id is blank or
	 * 
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try 
		{
			//check mandatory information
			if(strId.equals("0") || strId.equals(""))
			{
				throw new Exception("Store Id can not be blank");
			}
				
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//59+11=70
			}
		
//			//System.out.println("In Dao--1-->>>"+strId.trim());
//			//System.out.println("In Dao--2-->>>"+reqTypeId.trim());
//			//System.out.println("In Dao--3-->>>"+hosp_code.trim());
//			//System.out.println("In Dao--4-->>>"+toStrId.trim());
//			//System.out.println("In Dao--5-->>>"+itemcatNo.trim());
//			//System.out.println("In Dao--6-->>>"+itemTypeId.trim());
//			//System.out.println("In Dao--7-->>>"+urgentFlag.trim());
//			//System.out.println("In Dao--8-->>>"+indentPeriod.trim());
//			//System.out.println("In Dao--9-->>>"+finStartDate.trim());
//			//System.out.println("In Dao--10-->>>"+finEndDate.trim());
//			//System.out.println("In Dao--11-->>>"+remarks.trim());
//			//System.out.println("In Dao--12-->>>"+seatId.trim());
//			//System.out.println("In Dao--13-->>>"+grantTypeId.trim());
//			//System.out.println("In Dao--14-->>>"+puk.trim());
//			//System.out.println("In Dao--15-->>>"+empNo.trim());
//			//System.out.println("In Dao--16-->>>"+admNo.trim());
//			//System.out.println("In Dao--17-->>>"+episodeCode.trim());
//			//System.out.println("In Dao--18-->>>"+consultantId.trim());
//			//System.out.println("In Dao--19-->>>"+indentPeriod.trim());
//			//System.out.println("In Dao--20-->>>"+totCost.trim());
//			//System.out.println("In Dao--21-->>>"+strImpReqNo.trim());
//			//System.out.println("In Dao--22-->>>"+strImpReqDate.trim());
//			//System.out.println("In Dao--23-->>>"+strCurrncyId.trim());
//			//System.out.println("In Dao--24-->>>"+strTsInvoiceRecd.trim());
//			//System.out.println("In Dao--25-->>>"+strInstallationReq.trim());
//			//System.out.println("In Dao--26-->>>"+strInstallationChg.trim());
//			//System.out.println("In Dao--27-->>>"+strQutnInvite.trim());
//			//System.out.println("In Dao--28-->>>"+strQutnJustificn.trim());
//			//System.out.println("In Dao--29-->>>"+strWarranty.trim());
//			//System.out.println("In Dao--30-->>>"+strPurpose.trim());
//			//System.out.println("In Dao--31-->>>"+strJustificn.trim());
//			//System.out.println("In Dao--32-->>>"+strGrpId.trim());
//			//System.out.println("In Dao--33-->>>"+strSubGrpId.trim());
//			//System.out.println("In Dao--34-->>>"+strItemId.trim());
//			//System.out.println("In Dao--35-->>>"+strItemBrandId.trim());
//			//System.out.println("In Dao--36-->>>"+strInhandQty.trim());
//			//System.out.println("In Dao--37-->>>"+strInhandQtyUnitId.trim());
//			//System.out.println("In Dao--38-->>>"+strRate.trim());
//			//System.out.println("In Dao--39-->>>"+strRateUnitId.trim());
//			//System.out.println("In Dao--40-->>>"+strReqQty.trim());
//			//System.out.println("In Dao--41-->>>"+strReqQtyUnitId.trim());
//			//System.out.println("In Dao--42-->>>"+strSancQty.trim());
//			//System.out.println("In Dao--43-->>>"+strSancQtyUnitId.trim());
//			//System.out.println("In Dao--44-->>>"+strLstYearConsump.trim());
//			//System.out.println("In Dao--45-->>>"+strLstYearConsumpUnitId.trim());
//			//System.out.println("In Dao--46-->>>"+strCost.trim());
//			//System.out.println("In Dao--47-->>>"+strSupplierId.trim());
//			//System.out.println("In Dao--48-->>>"+strLstPoNo.trim());
//			//System.out.println("In Dao--49-->>>"+strLstPoDate.trim());
//			//System.out.println("In Dao--50-->>>"+strLstRecDate.trim());
//			//System.out.println("In Dao--51-->>>"+strReqStatus.trim());
//			
//			//System.out.println("In Dao--52-->>>"+strOrderQty.trim());
//			//System.out.println("In Dao--53-->>>"+strOrderQtyUnitId.trim());
//			//System.out.println("In Dao--54-->>>"+strLstSupplierId.trim());
//			//System.out.println("In Dao--55-->>>"+strLstRate.trim());
//			//System.out.println("In Dao--56-->>>"+strLstRateUnitId.trim());
			
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");                          //1
		   	dao.setProcInValue(nInsertedIndex,"strId",strId.trim());                  //2
	       	dao.setProcInValue(nInsertedIndex,"hosp_code",hosp_code.trim());          //3
			dao.setProcInValue(nInsertedIndex,"reqTypeId ",reqTypeId.trim());         //4 
			dao.setProcInValue(nInsertedIndex,"toStrId",toStrId.trim());              //5
			dao.setProcInValue(nInsertedIndex,"itemcatNo",itemcatNo.trim());          //6
			dao.setProcInValue(nInsertedIndex,"itemTypeId",itemTypeId.trim());        //7  
			dao.setProcInValue(nInsertedIndex,"urgentFlag",urgentFlag.trim());        //8
			dao.setProcInValue(nInsertedIndex,"indentPeriod",indentPeriod.trim());    //9
			dao.setProcInValue(nInsertedIndex,"finStartDate",finStartDate.trim());    //10       
			dao.setProcInValue(nInsertedIndex,"finEndDate",finEndDate.trim());        //11
			dao.setProcInValue(nInsertedIndex,"remarks",remarks.trim());              //12
			dao.setProcInValue(nInsertedIndex,"seatId",seatId.trim());                //13
	       	dao.setProcInValue(nInsertedIndex,"grantTypeId",grantTypeId.trim());      //14
			dao.setProcInValue(nInsertedIndex,"puk ",puk.trim());                     //15 
			dao.setProcInValue(nInsertedIndex,"empNo",empNo.trim());                  //16
			dao.setProcInValue(nInsertedIndex,"admNo",admNo.trim());                  //17
			dao.setProcInValue(nInsertedIndex,"episodeCode",episodeCode.trim());      //18  
			dao.setProcInValue(nInsertedIndex,"consultantId",consultantId.trim());    //19
			dao.setProcInValue(nInsertedIndex,"memoNo",indentPeriod.trim());          //20
			dao.setProcInValue(nInsertedIndex,"totCost", totCost.trim());             //21       
			dao.setProcInValue(nInsertedIndex,"strImpReqNo",strImpReqNo.trim());      //22
			dao.setProcInValue(nInsertedIndex,"strImpReqDate",strImpReqDate.trim());  //23
			dao.setProcInValue(nInsertedIndex,"strCurrncyId ",strCurrncyId.trim());   //24 
			dao.setProcInValue(nInsertedIndex,"strTsInvoiceRecd",strTsInvoiceRecd.trim());      //25
			dao.setProcInValue(nInsertedIndex,"strInstallationReq",strInstallationReq.trim());  //26
			dao.setProcInValue(nInsertedIndex,"strInstallationChg",strInstallationChg.trim());  //27  
			dao.setProcInValue(nInsertedIndex,"strQutnInvite",strQutnInvite.trim());            //28
			dao.setProcInValue(nInsertedIndex,"strQutnJustificn",strQutnJustificn.trim());      //29
			dao.setProcInValue(nInsertedIndex,"strWarranty", strWarranty.trim());               //30       
			dao.setProcInValue(nInsertedIndex,"strPurpose",strPurpose.trim());                  //31
			dao.setProcInValue(nInsertedIndex,"strJustificn",strJustificn.trim());              //32
            dao.setProcInValue(nInsertedIndex,"strGrpId ",strGrpId.trim());                     //33 
			dao.setProcInValue(nInsertedIndex,"strSubGrpId",strSubGrpId.trim());                //34
			dao.setProcInValue(nInsertedIndex,"strItemId",strItemId.trim());                    //35
			dao.setProcInValue(nInsertedIndex,"strItemBrandId",strItemBrandId.trim());          //36  
			dao.setProcInValue(nInsertedIndex,"strInhandQty",strInhandQty.trim());              //37
			dao.setProcInValue(nInsertedIndex,"strInhandQtyUnitId ",strInhandQtyUnitId .trim());//38
			dao.setProcInValue(nInsertedIndex,"strRate", strRate.trim());                       //39       
			dao.setProcInValue(nInsertedIndex,"strRateUnitId ",strRateUnitId .trim());          //40
			dao.setProcInValue(nInsertedIndex,"strReqQty",strReqQty.trim());                    //41
			dao.setProcInValue(nInsertedIndex,"strReqQtyUnitId ",strReqQtyUnitId.trim());       //42 
			dao.setProcInValue(nInsertedIndex,"strSancQty",strSancQty.trim());                  //43
			dao.setProcInValue(nInsertedIndex,"strSancQtyUnitId",strSancQtyUnitId.trim());      //44
			dao.setProcInValue(nInsertedIndex,"strLstYearConsump",strLstYearConsump.trim());    //45 
			dao.setProcInValue(nInsertedIndex,"strLstYearConsumpUnitId",strLstYearConsumpUnitId.trim()); //46
			dao.setProcInValue(nInsertedIndex,"strCost",strCost.trim());                                 //47
			dao.setProcInValue(nInsertedIndex,"strSupplierId", strSupplierId.trim());                    //48       
			dao.setProcInValue(nInsertedIndex,"strLstPoNo ",strLstPoNo .trim());                         //49
			dao.setProcInValue(nInsertedIndex,"strLstPoDate",strLstPoDate.trim());                       //50
			dao.setProcInValue(nInsertedIndex,"strLstRecDate ",strLstRecDate.trim());                    //51
			dao.setProcInValue(nInsertedIndex,"strReqStatus",strReqStatus.trim());                       //52
			dao.setProcInValue(nInsertedIndex,"strOrderQty", strOrderQty.trim());                        //53       
			dao.setProcInValue(nInsertedIndex,"strOrderQtyUnitId ",strOrderQtyUnitId .trim());           //54
			dao.setProcInValue(nInsertedIndex,"strLstSupplierId",strLstSupplierId.trim());               //55
			dao.setProcInValue(nInsertedIndex,"strLstRate ",strLstRate.trim());                          //56
			dao.setProcInValue(nInsertedIndex,"strLstRateUnitId",strLstRateUnitId.trim());               //57			
			dao.setProcInValue(nInsertedIndex,"strApproxRate",strApproxRate.trim());                     //58			
		    //output value                        
			dao.setProcOutValue(nInsertedIndex,"err",1);                                                 //59
			
			/* Start Adding Default value*/
			dao.setProcInValue(nInsertedIndex,"cancelSeatId","");
			dao.setProcInValue(nInsertedIndex,"cancelDate","");
			dao.setProcInValue(nInsertedIndex,"cancelReason","");
			dao.setProcInValue(nInsertedIndex,"certificateNo ","0");
			dao.setProcInValue(nInsertedIndex,"certificateDate","");
			dao.setProcInValue(nInsertedIndex,"rateContSuppId","0");
			dao.setProcInValue(nInsertedIndex,"itemSpecification","");
			dao.setProcInValue(nInsertedIndex,"itemMake","0");
			dao.setProcInValue(nInsertedIndex,"suggSupplier","0");
			dao.setProcInValue(nInsertedIndex,"rateContractSupp","0");
			dao.setProcInValue(nInsertedIndex,"brandResFlag","1");
			/* End Adding Default value*/
			
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
		strId		 ="";
		hosp_code    ="";
		reqTypeId    ="";
	    toStrId		 ="";
		itemcatNo	 ="";
		itemTypeId	 ="";
		urgentFlag	 ="0";
		indentPeriod ="";
		finStartDate ="";
		finEndDate	 ="";
		remarks		 ="";
		seatId		 ="";
	    grantTypeId	 ="0";
		puk			 ="0";
		empNo		 ="";
		admNo		 ="0";
		episodeCode	 ="0";
		consultantId ="";
	//	memoNo		 ="";
	  	totCost      ="0";		 
		//reqd at the tiem of cancel
	//	 cancelSeatId  ="";
	//	 cancelDate	   ="";
	//	 cancelReason  ="";
		//  --Variable for table  HSTT_IMPPUR_REQ_DTL 
		 strImpReqNo                  ="";
		 strImpReqDate                ="";
		 strCurrncyId                 ="";
		 strTsInvoiceRecd             ="1";
		 strInstallationReq           ="0"; 
		 strInstallationChg           ="0";
		 strQutnInvite                ="0";
		 strQutnJustificn             ="";
		 strWarranty                  ="0";
		 strPurpose                   ="";
		 strJustificn                 ="";
		 strGrpId                     ="";
		 strSubGrpId                  ="0";
		 strItemId                    ="";
		 strItemBrandId               ="0";
		 strInhandQty                 ="0";
		 strInhandQtyUnitId           ="0";
		 strRate                      ="0";
		 strRateUnitId                ="0";
		 strReqQty                    ="0";
		 strReqQtyUnitId              ="";
		 strSancQty                   ="0";
		 strSancQtyUnitId             ="";
		 strLstYearConsump            ="0";
		 strLstYearConsumpUnitId      ="";
		 strCost                      ="0";
		 strSupplierId                ="";
		 strLstPoNo                   ="";
		 strLstPoDate                 ="";
		 strLstRecDate                ="";
		 strReqStatus                 ="0";
	//	 strEntryDate                 ="";
	//	 strIsValid                   ="1";
	}
	public void setStrOrderQty(String strOrderQty) {
		this.strOrderQty = strOrderQty;
	}
	public void setStrOrderQtyUnitId(String strOrderQtyUnitId) {
		this.strOrderQtyUnitId = strOrderQtyUnitId;
	}
	public void setStrLstSupplierId(String strLstSupplierId) {
		this.strLstSupplierId = strLstSupplierId;
	}
	public void setStrLstRate(String strLstRate) {
		this.strLstRate = strLstRate;
	}
	public void setStrLstRateUnitId(String strLstRateUnitId) {
		this.strLstRateUnitId = strLstRateUnitId;
	}
}
