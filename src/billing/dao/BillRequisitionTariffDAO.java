package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_BILLREQ_TARIFF_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_BILLREQ_TARIFF_DTL
*/
public final class BillRequisitionTariffDAO {
	
	private String strReqNo = "0";
	private String strTariffId = "0";
	private String strReqDate = "";
	private String strBServiceId = "0";
	private String strGroupId = "0";
	private String strGblTariffId = "";
	private String strRate = "0";
	private String strQty = "0";
	private String strReqQty = "0";
	private String strBillQty = "0";
	private String strTariffRate = "0";
	private String strAppId = "0";
	private String strDiscountType = "0";
	private String strStatus = "1";
	private String strIsValid = "1";
	private String strDiscountUnit = "0";
	private String strPuk = "0";
	private String strIsPackage = "0";
	private String strServiceTax = "0";
	private String strPenelty = "0";
	private String strCancelQty = "0";
	private String strQtyType = "1";
	private String strServiceId = "0";
	private String strTariffReceiptNo = "0";
	private String strHospitalCode = "0";
	private String strDepartmentCode = "0";
	
	//var for credit billing
	private String strCreditBillFlag="0";
	private String strCreditLetterRefNo="";
	private String strCreditLetterDate="";
	private String strCreditLetterUploadFilePath="";
	private String strClientNo="0";
	private String strCreditBillStatus="0";
	private String strCreditApprovedBy="0";
	private String strAmtPaidByPatient="0";
	private String strAmtPaidByClient="0";
	private String strStaffCardNoId="0";
	private String strStaffCardHolderName="0";
	private String strRelationWithStaffCardholder="0";
	private String strCardValidity="0";
	

	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_billreq_tariff_dtl";
	private final String strFileName = "billing.dao.dml_BillRequisitionTariffDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	/**
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}
	
	/**
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * @return Returns the strProcName.
	 */
	
	public String getStrProcName() {
		return strProcName;
	}
	
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @param strReqNo The strReqNo to set.
	 */

	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	
	
	/**
	 * @param strReqNo The strCancelQty to set.
	 */

	public void setStrCancelQty(String strCancelQty) {
		this.strCancelQty = strCancelQty;
	}
	
	
	
	/**
	 * @param strTariffId The strTariffId to set.
	 */

	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}
	
	/**
	 * @param strReqDate The strReqDate to set.
	 */

	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	
	/**
	 * @param strServiceId The strServiceId to set.
	 */

	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}
	
	/**
	 * @param strGroupId The strGroupId to set.
	 */

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	
	/**
	 * @param strGblTariffId The strGblTariffId to set.
	 */

	public void setStrGblTariffId(String strGblTariffId) {
		this.strGblTariffId = strGblTariffId;
	}
	
	/**
	 * @param strRate The strRate to set.
	 */

	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}
	
	/**
	 * @param strQty The strQty to set.
	 */

	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}
	
	/**
	 * @param strReqQty The strReqQty to set.
	 */

	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	
	/**
	 * @param strBillQty The strBillQty to set.
	 */

	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}
	
	/**
	 * @param strTariffRate The strTariffRate to set.
	 */

	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}
	
	/**
	 * @param strAppId The strAppId to set.
	 */

	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}
	
	/**
	 * @param strDiscountType The strDiscountType to set.
	 */

	public void setStrDiscountType(String strDiscountType) {
		this.strDiscountType = strDiscountType;
	}
	
	/**
	 * @param strStatus The strStatus to set.
	 */

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
	/**
	 * @param strIsValid The strIsValid to set.
	 */

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	/**
	 * @param strDiscountUnit The strDiscountUnit to set.
	 */

	public void setStrDiscountUnit(String strDiscountUnit) {
		this.strDiscountUnit = strDiscountUnit;
	}
	
	/**
	 * @param strPuk The strPuk to set.
	 */

	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}
	
	/**
	 * @param strIsPackage The strIsPackage to set.
	 */

	public void setStrIsPackage(String strIsPackage) {
		this.strIsPackage = strIsPackage;
	}
	
	/**
	 * @param strServiceTax The strServiceTax to set.
	 */

	public void setStrServiceTax(String strServiceTax) {
		this.strServiceTax = strServiceTax;
	}
	
	/**
	 * @param strPenelty The strPenelty to set.
	 */

	public void setStrPenelty(String strPenelty) {
		this.strPenelty = strPenelty;
	}
	
	/**
	 * @param strQtyType The strQtyType to set.
	 */

	public void setStrQtyType(String strQtyType) {
		this.strQtyType = strQtyType;
	}
	

	public String getStrServiceId() 
	{
		return strServiceId;
	}
	public void setStrServiceId(String strServiceId) 
	{
		this.strServiceId = strServiceId;
	}
	public void setStrTariffReceiptNo(String strTariffReceiptNo) 
	{
		this.strTariffReceiptNo = strTariffReceiptNo;
	}
	public void setStrDepartmentCode(String strDepartmentCode) 
	{
		this.strDepartmentCode = strDepartmentCode;
	}

			
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			
//			System.out.println("Req No-->"+strReqNo);
//			System.out.println("Tariff Id->"+strTariffId);
//			System.out.println("BService Id-->"+strBServiceId);
//			System.out.println("Group Id-->"+strGroupId);
//			System.out.println("Gbl Tariff Id->"+strGblTariffId);
//			System.out.println("Rate-->"+strRate);
//			System.out.println("Qty Unit ID-->"+strQty);
//			System.out.println("Bill Qty-->"+strBillQty);
//			System.out.println("Tariff rate-->"+strTariffRate);
//			System.out.println("App Id-->"+strAppId);
//			System.out.println("Discount Type->"+strDiscountType);
//			System.out.println("Status-->"+strStatus);
//			System.out.println("Is Valid-->"+strIsValid);
//			System.out.println("Dis Unit-->"+strDiscountUnit);
//			System.out.println("strPuk-->"+strPuk);
//			System.out.println("strIsPackage-->"+strIsPackage);
//			System.out.println("strServiceTax-->"+strServiceTax);
//			System.out.println("strPenelty-->"+strPenelty);
//			System.out.println("strQtyType-->"+strQtyType);
			
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo,2);			
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId,3);			
			dao.setProcInValue(nInsertedIndex,"hbldt_req_date","",4);			
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId,5);			
			dao.setProcInValue(nInsertedIndex,"hblnum_group_id",strGroupId,6);			
			dao.setProcInValue(nInsertedIndex,"gstr_tariff_id",strGblTariffId,7);			
			dao.setProcInValue(nInsertedIndex,"gnum_rate_unit_id",strRate,8);			
			dao.setProcInValue(nInsertedIndex,"gnum_qty_unit_id",strQty,9);			
			dao.setProcInValue(nInsertedIndex,"hblnum_req_qty",strReqQty,10);			
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_qty",strBillQty,11);			
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_rate",strTariffRate,12);			
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId,13);			
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_type",strDiscountType,14);			
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,15);			
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,16);			
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_unit",strDiscountUnit,17);			
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,18);			
			dao.setProcInValue(nInsertedIndex,"hblnum_is_package",strIsPackage,19);			
			dao.setProcInValue(nInsertedIndex,"hblnum_service_tax",strServiceTax,20);			
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty",strPenelty,21);			
			dao.setProcInValue(nInsertedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nInsertedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);			
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nInsertedIndex,"deptCode","0",26);
			
			dao.setProcOutValue(nInsertedIndex,"err",1,27);
			
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void update(HisDAO dao) throws Exception 
	{
		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			dao.setProcInValue(nUpdatedIndex,"modval","2",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex,"deptCode","0",26);
			dao.setProcOutValue(nUpdatedIndex,"err",1,27);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void update2(HisDAO dao) throws Exception 
	{		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(strTariffId.equals(""))
			{
				throw new Exception("Tariff Id can not be blank");
			}
			
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			dao.setProcInValue(nUpdatedIndex,"modval","3",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);			
			dao.setProcInValue(nUpdatedIndex,"deptCode","",26);
			dao.setProcOutValue(nUpdatedIndex,"err",1,27);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update2() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void update3(HisDAO dao) throws Exception 
	{		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			dao.setProcInValue(nUpdatedIndex,"modval","4",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex, "deptCode", strDepartmentCode,26);			
			dao.setProcOutValue(nUpdatedIndex,"err",1,27);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update3() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void update4(HisDAO dao) throws Exception 
	{
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			dao.setProcInValue(nUpdatedIndex,"modval","5",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex, "deptCode", strDepartmentCode,26);									
			dao.setProcOutValue(nUpdatedIndex,"err",1,27);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update4() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	

	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() 
	{
		strReqNo = "0";
		strTariffId = "0";
		strReqDate = "";
		strBServiceId = "0";
		strGroupId = "0";
		strGblTariffId = "";
		strRate = "0";
		strQty = "0";
		strReqQty = "0";
		strBillQty = "0";
		strTariffRate = "0";
		strAppId = "0";
		strDiscountType = "0";
		strStatus = "1";
		strIsValid = "1";
		strDiscountUnit = "0";
		strPuk = "0";
		strIsPackage = "0";
		strServiceTax = "0";
		strTariffReceiptNo = "0";
		strPenelty = "0";
		strQtyType = "1";
		strHospitalCode = "0";
		strDepartmentCode = "0";
	}
	
	//update for CreditBillApprovalProcess..
	public void updateForCreditBill(HisDAO dao) throws Exception 
	{
		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			dao.setProcInValue(nUpdatedIndex,"modval","5",1);	//to be changed..		
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex,"deptCode","0",26);
			dao.setProcOutValue(nUpdatedIndex,"err",1,27);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".updateForCreditBill() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	/**
	 *  update'HBLT_BILLREQ_TARIFF_DTL'
	 */
	public void updateCreditBillApproval(HisDAO dao) throws Exception 
	{
		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + "pkg_bill_dml.dml_hblt_billreq_tariff_dtl_creditbill" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
		
			dao.setProcInValue(nUpdatedIndex,"modval","1",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);//
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex,"deptcode","0",26);
			//new entries
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_flag",strCreditBillFlag,27);
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_ref_no",strCreditLetterRefNo,28);
			dao.setProcInValue(nUpdatedIndex,"hbldt_credit_letter_date",strCreditLetterDate,29);
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_upload_file_path",strCreditLetterUploadFilePath,30);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_no",strClientNo,31);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_status",strCreditBillStatus,32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_approved_by",strCreditApprovedBy,33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_patient",strAmtPaidByPatient,34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_client",strAmtPaidByClient,35);
			dao.setProcInValue(nUpdatedIndex,"hblnum_staff_card_no_id",strStaffCardNoId,36);
			dao.setProcInValue(nUpdatedIndex,"hblstr_staff_card_holder_name",strStaffCardHolderName,37);
			dao.setProcInValue(nUpdatedIndex,"hblnum_relation_with_staff_cardholder",strRelationWithStaffCardholder,38);
			dao.setProcInValue(nUpdatedIndex,"v_hbldt_card_validity",strCardValidity,39);
			
			dao.setProcOutValue(nUpdatedIndex,"err",1,40);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".updateCreditBillApproval() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	//for inserting/updating common values..
	public void updateCreditBillApproval2(HisDAO dao) throws Exception 
	{
		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + "pkg_bill_dml.dml_hblt_billreq_tariff_dtl_creditbill" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
		
			dao.setProcInValue(nUpdatedIndex,"modval","2",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);//
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex,"deptcode","0",26);
			//new entries
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_flag","1",27);
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_ref_no","",28);
			dao.setProcInValue(nUpdatedIndex,"hbldt_credit_letter_date","1-Jan-3000",29);//value not used in proc
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_upload_file_path","",30);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_no",strClientNo,31);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_status","1",32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_approved_by",strCreditApprovedBy,33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_patient","0",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_client","0",35);
			dao.setProcInValue(nUpdatedIndex,"hblnum_staff_card_no_id",strStaffCardNoId,36);
			dao.setProcInValue(nUpdatedIndex,"hblstr_staff_card_holder_name",strStaffCardHolderName,37);
			dao.setProcInValue(nUpdatedIndex,"hblnum_relation_with_staff_cardholder",strRelationWithStaffCardholder,38);
			dao.setProcInValue(nUpdatedIndex,"v_hbldt_card_validity",strCardValidity,39);
			
			dao.setProcOutValue(nUpdatedIndex,"err",1,40);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".updateCreditBillApproval2() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}
	
	//for updating hipt_admissionadvice
	public void updateCreditBillApproval3(HisDAO dao) throws Exception 
	{
		
		strErr = "";
	
		try 
		{
			if(strReqNo.equals("0") || strReqNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + "pkg_bill_dml.dml_hblt_billreq_tariff_dtl_creditbill" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
		
			if(strCreditBillStatus.equals("2"))//Direct -No Approval
				dao.setProcInValue(nUpdatedIndex,"modval","4",1);
			else
				dao.setProcInValue(nUpdatedIndex,"modval","3",1);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_req_date",strReqDate,4);
			dao.setProcInValue(nUpdatedIndex,"sblnum_bservice_id",strBServiceId,5);
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,6);
			dao.setProcInValue(nUpdatedIndex,"gstr_tariff_id",strGblTariffId,7);
			dao.setProcInValue(nUpdatedIndex,"gnum_rate_unit_id",strRate,8);//
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strReqQty,10);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,11);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id",strAppId,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_type",strDiscountType,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,16);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_unit",strDiscountUnit,17);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_is_package",strIsPackage,19);
			dao.setProcInValue(nUpdatedIndex,"hblnum_service_tax",strServiceTax,20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty",strPenelty,21);
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,22);			
			dao.setProcInValue(nUpdatedIndex,"sblnum_service_id","0",23);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strTariffReceiptNo,24);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,25);
			dao.setProcInValue(nUpdatedIndex,"deptcode","0",26);
			//new entries
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_flag",strCreditBillFlag,27);
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_ref_no","",28);
			dao.setProcInValue(nUpdatedIndex,"hbldt_credit_letter_date","1-Jan-3000",29);//value not used in proc
			dao.setProcInValue(nUpdatedIndex,"hblstr_credit_letter_upload_file_path","",30);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_no",strClientNo,31);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_bill_status",strCreditBillStatus,32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_credit_approved_by",strCreditApprovedBy,33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_patient","0",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_amt_paid_by_client","0",35);
			System.out.println("strStaffCardNoId"+strStaffCardNoId);
			dao.setProcInValue(nUpdatedIndex,"hblnum_staff_card_no_id",strStaffCardNoId,36);
			dao.setProcInValue(nUpdatedIndex,"hblstr_staff_card_holder_name",strStaffCardHolderName,37);
			dao.setProcInValue(nUpdatedIndex,"hblnum_relation_with_staff_cardholder",strRelationWithStaffCardholder,38);
			dao.setProcInValue(nUpdatedIndex,"v_hbldt_card_validity",strCardValidity,39);
			
			dao.setProcOutValue(nUpdatedIndex,"err",1,40);
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".updateCreditBillApproval3() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}

	public String getStrCreditBillFlag() {
		return strCreditBillFlag;
	}

	public void setStrCreditBillFlag(String strCreditBillFlag) {
		this.strCreditBillFlag = strCreditBillFlag;
	}

	public String getStrCreditLetterRefNo() {
		return strCreditLetterRefNo;
	}

	public void setStrCreditLetterRefNo(String strCreditLetterRefNo) {
		this.strCreditLetterRefNo = strCreditLetterRefNo;
	}

	public String getStrCreditLetterDate() {
		return strCreditLetterDate;
	}

	public void setStrCreditLetterDate(String strCreditLetterDate) {
		this.strCreditLetterDate = strCreditLetterDate;
	}

	public String getStrCreditLetterUploadFilePath() {
		return strCreditLetterUploadFilePath;
	}

	public void setStrCreditLetterUploadFilePath(
			String strCreditLetterUploadFilePath) {
		this.strCreditLetterUploadFilePath = strCreditLetterUploadFilePath;
	}

	public String getStrClientNo() {
		return strClientNo;
	}

	public void setStrClientNo(String strClientNo) {
		this.strClientNo = strClientNo;
	}

	public String getStrCreditBillStatus() {
		return strCreditBillStatus;
	}

	public void setStrCreditBillStatus(String strCreditBillStatus) {
		this.strCreditBillStatus = strCreditBillStatus;
	}

	public String getStrCreditApprovedBy() {
		return strCreditApprovedBy;
	}

	public void setStrCreditApprovedBy(String strCreditApprovedBy) {
		this.strCreditApprovedBy = strCreditApprovedBy;
	}

	public String getStrAmtPaidByPatient() {
		return strAmtPaidByPatient;
	}

	public void setStrAmtPaidByPatient(String strAmtPaidByPatient) {
		this.strAmtPaidByPatient = strAmtPaidByPatient;
	}

	public String getStrAmtPaidByClient() {
		return strAmtPaidByClient;
	}

	public void setStrAmtPaidByClient(String strAmtPaidByClient) {
		this.strAmtPaidByClient = strAmtPaidByClient;
	}

	public String getStrStaffCardNoId() {
		return strStaffCardNoId;
	}

	public void setStrStaffCardNoId(String strStaffCardNoId) {
		this.strStaffCardNoId = strStaffCardNoId;
	}

	public String getStrStaffCardHolderName() {
		return strStaffCardHolderName;
	}

	public void setStrStaffCardHolderName(String strStaffCardHolderName) {
		this.strStaffCardHolderName = strStaffCardHolderName;
	}

	public String getStrRelationWithStaffCardholder() {
		return strRelationWithStaffCardholder;
	}

	public void setStrRelationWithStaffCardholder(
			String strRelationWithStaffCardholder) {
		this.strRelationWithStaffCardholder = strRelationWithStaffCardholder;
	}

	public String getStrCardValidity() {
		return strCardValidity;
	}

	public void setStrCardValidity(String strCardValidity) {
		this.strCardValidity = strCardValidity;
	}
	
}