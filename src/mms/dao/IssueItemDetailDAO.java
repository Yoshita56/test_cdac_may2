/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 12/June/2009 * This class will
 * be used to insert the records Tables : HSTT_ISSUE_ITEM_DTL (insert)
 * HSTT_INDENT_ITEM_DTL (update)
 */

public class IssueItemDetailDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.IssueItemDetailDAO";

	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str issuing store id. */
	private String strIssuingStoreId = "";
	
	/** The str raising store id. */
	private String strRaisingStoreId = "";
	
	/** The str issue no. */
	private String strIssueNO = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";
	
	/** The str item slno. */
	private String strItemSlno = "0";
	
	/** The str stck status code. */
	//private String strStckStatusCode = "1";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str in hand qty. */
	private String strInHandQty = "0";
	
	/** The str in hand qty unit id. */
	private String strInHandQtyUnitId = "";
	
	/** The str bal qty. */
	private String strBalQty = "0";
	
	/** The str bal qty unit id. */
	private String strBalQtyUnitId = "";
	
	/** The str issue qty. */
	private String strIssueQty = "0";
	
	/** The str issue qty unit id. */
	private String strIssueQtyUnitId = "";
	
	/** The str manuf date. */
	private String strManufDate = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str rate. */
	private String strRate = "0";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str consumable flag. */
	private String strConsumableFlag = "0";
	
	/** The str cost. */
//	private String strCost = "0";
	
	/** The str remarks. */
	private String strRemarks = "";

	/** The str indent no. */
	private String strIndentNO = "";
	
	/** The str reserved qty flag. */
	private String strReservedQtyFlag = "";
	
	/** The str category no. */
	private String strCategoryNo = "";
	
	/** The str req type id. */
	private String strReqTypeId = "";
	
	/** The str stock status code. */
	private String strStockStatusCode = "";
	
	private String strTotIssueQty = "";
	private String strTotIssueQtyUnit = "";

	/** The str err. */
	private String strErr = "";
	
	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;
	
	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;

	private String NULL;

	/**
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHosCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str issuing store id.
	 * 
	 * @param strIssuingStoreId the strIssuingStoreId to set
	 */
	public void setStrIssuingStoreId(String strIssuingStoreId) {
		this.strIssuingStoreId = strIssuingStoreId;
	}

	/**
	 * Sets the str issue no.
	 * 
	 * @param strIssueNO the strIssueNO to set
	 */
	public void setStrIssueNO(String strIssueNO) {
		this.strIssueNO = strIssueNO;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	/**
	 * Sets the str item slno.
	 * 
	 * @param strItemSlno the strItemSlno to set
	 */
	public void setStrItemSlno(String strItemSlno) {
		this.strItemSlno = strItemSlno;
	}

	 

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str in hand qty.
	 * 
	 * @param strInHandQty the strInHandQty to set
	 */
	public void setStrInHandQty(String strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	/**
	 * Sets the str in hand qty unit id.
	 * 
	 * @param strInHandQtyUnitId the strInHandQtyUnitId to set
	 */
	public void setStrInHandQtyUnitId(String strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}

	/**
	 * Sets the str bal qty.
	 * 
	 * @param strBalQty the strBalQty to set
	 */
	public void setStrBalQty(String strBalQty) {
		this.strBalQty = strBalQty;
	}

	/**
	 * Sets the str bal qty unit id.
	 * 
	 * @param strBalQtyUnitId the strBalQtyUnitId to set
	 */
	public void setStrBalQtyUnitId(String strBalQtyUnitId) {
		this.strBalQtyUnitId = strBalQtyUnitId;
	}

	/**
	 * Sets the str issue qty.
	 * 
	 * @param strIssueQty the strIssueQty to set
	 */
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}

	/**
	 * Sets the str issue qty unit id.
	 * 
	 * @param strIssueQtyUnitId the strIssueQtyUnitId to set
	 */
	public void setStrIssueQtyUnitId(String strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}

	/**
	 * Sets the str manuf date.
	 * 
	 * @param strManufDate the strManufDate to set
	 */
	public void setStrManufDate(String strManufDate) {
		this.strManufDate = strManufDate;
	}

	/**
	 * Sets the str expiry date.
	 * 
	 * @param strExpiryDate the strExpiryDate to set
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Sets the str consumable flag.
	 * 
	 * @param strConsumableFlag the strConsumableFlag to set
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}

	 

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Sets the str indent no.
	 * 
	 * @param strIndentNO the strIndentNO to set
	 */
	public void setStrIndentNO(String strIndentNO) {
		this.strIndentNO = strIndentNO;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {
			// //System.out.println("dao insert");

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.Dml_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 30
			nProcIndex = dao.setProcedure(strProcName);

//			 //System.out.println("issueNo::"+ strIssueNO);
//			 //System.out.println("hospital_code::"+ strHospitalCode);
//			 //System.out.println("indent_No::"+ strIndentNO);
//			 //System.out.println("raising_store_id::"+ strRaisingStoreId);
//			 //System.out.println("issuing_store_id::"+ strIssuingStoreId);
//			 //System.out.println("reserved_qty_flag::"+ strReservedQtyFlag);
//			 //System.out.println("category_No::"+ strCategoryNo);
//			 //System.out.println("reqType_id::"+ strReqTypeId);
//			 //System.out.println("item_id::"+strItemId );
//			 //System.out.println("item_brand_id::"+strItemBrandId );
//			 //System.out.println("batchSl_no::"+ strBatchSlNo);
//			 //System.out.println("item_SlNo::"+strItemSlno);
//			 //System.out.println("stock_status_code::"+ strStockStatusCode);
//			 //System.out.println("group_id::"+ strGroupId);
//			 //System.out.println("subgroup_id::"+ strSubGroupId);
//			 //System.out.println("remarks::"+strRemarks );
//			 //System.out.println("seatId::"+ strSeatId);
//			 //System.out.println("inhand_qty::"+ strInHandQty);
//			 //System.out.println("inhand_qty_unitid::"+strInHandQtyUnitId );
//			 //System.out.println("bal_qty::"+strBalQty );
//			 //System.out.println("bal_qty_unitid::"+ strBalQtyUnitId);
//			 //System.out.println("issue_qty::"+strIssueQty);
//			 //System.out.println("issue_qty_unitid::"+ strIssueQtyUnitId);
//			 //System.out.println("rate::"+ strRate);
//			 //System.out.println("rate_unitid::"+ strRateUnitId);
//			 //System.out.println("manuf_date::"+ strManufDate);
//			 //System.out.println("expiry_date::"+ strExpiryDate);
//			 //System.out.println("comsumable_flag::"+ strConsumableFlag);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNO,2);			
			dao.setProcInValue(nProcIndex, "indent_No", strIndentNO,3);
			dao.setProcInValue(nProcIndex, "raising_store_id",	strRaisingStoreId,4);
			dao.setProcInValue(nProcIndex, "issuing_store_id",  strIssuingStoreId,5);
			dao.setProcInValue(nProcIndex, "reserved_qty_flag",	strReservedQtyFlag,6);
			dao.setProcInValue(nProcIndex, "category_No", strCategoryNo,7);
			dao.setProcInValue(nProcIndex, "reqType_id", strReqTypeId,8);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,9);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,10);
			dao.setProcInValue(nProcIndex, "batchSl_no", strBatchSlNo,11);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,12);
			dao.setProcInValue(nProcIndex, "item_SlNo", strItemSlno,13);
			dao.setProcInValue(nProcIndex, "stock_status_code",	strStockStatusCode,14);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,15);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,16);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInHandQty,17);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid",	strInHandQtyUnitId,18);
			dao.setProcInValue(nProcIndex, "bal_qty", strBalQty,19);
			dao.setProcInValue(nProcIndex, "bal_qty_unitid", strBalQtyUnitId,20);
			dao.setProcInValue(nProcIndex, "issue_qty", strIssueQty,21);
			dao.setProcInValue(nProcIndex, "issue_qty_unitid",strIssueQtyUnitId,22);
			dao.setProcInValue(nProcIndex, "manuf_date", strManufDate.equalsIgnoreCase("0")?"":strManufDate,23);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate,24);
			dao.setProcInValue(nProcIndex, "rate", strRate,25);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId,26);
			dao.setProcInValue(nProcIndex, "comsumable_flag",strConsumableFlag,27);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,28);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId,29);
			dao.setProcOutValue(nProcIndex, "err", 1,30);

			// dao.setProcOutValue(nProcIndex, "cost", 1);

			dao.setProcOutValue(nProcIndex, "err", 1,30);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}
		// return nProcIndex;

	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void insert2(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.Dml_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 24+6=30
			nProcIndex = dao.setProcedure(strProcName);

			/*
			 * //System.out.println("modeval"+ "2"); //System.out.println("issueNo"+
			 * strIssueNO); //System.out.println("hospital_code"+
			 * strHospitalCode); //System.out.println("indent_No"+ strIndentNO);
			 * //System.out.println("raising_store_id"+ strRaisingStoreId);
			 * //System.out.println("issuing_store_id"+ strIssuingStoreId);
			 * //System.out.println("reserved_qty_flag"+ strReservedQtyFlag);
			 * //System.out.println("category_No"+ strCategoryNo);
			 * //System.out.println("reqType_id"+ strReqTypeId);
			 * //System.out.println("rate"+ strRate);
			 * //System.out.println("item_id"+strItemId );
			 * //System.out.println("item_brand_id"+strItemBrandId ); //
			 * //System.out.println("batchSl_no"+ strBatchSlNo); //
			 * //System.out.println("item_SlNo"+strItemSlno); //
			 * //System.out.println("stock_status_code"+ strStockStatusCode);
			 * //System.out.println("group_id"+ strGroupId);
			 * //System.out.println("subgroup_id"+ strSubGroupId);
			 * //System.out.println("remarks"+strRemarks );
			 * //System.out.println("seatId"+ strSeatId);
			 * //System.out.println("inhand_qty"+ strInHandQty);
			 * //System.out.println("inhand_qty_unitid"+strInHandQtyUnitId );
			 * //System.out.println("bal_qty"+strBalQty );
			 * //System.out.println("bal_qty_unitid"+ strBalQtyUnitId);
			 * //System.out.println("issue_qty"+strIssueQty);
			 * //System.out.println("issue_qty_unitid"+ strIssueQtyUnitId); //
			 * //System.out.println("rate_unitid"+ strRateUnitId);
			 */
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNO,2);
			dao.setProcInValue(nProcIndex, "indent_No", strIndentNO,3);
			dao.setProcInValue(nProcIndex, "raising_store_id",strRaisingStoreId,4);
			dao.setProcInValue(nProcIndex, "issuing_store_id",strIssuingStoreId,5);
			dao.setProcInValue(nProcIndex, "reserved_qty_flag",strReservedQtyFlag,6);
			dao.setProcInValue(nProcIndex, "category_No", strCategoryNo,7);
			dao.setProcInValue(nProcIndex, "reqType_id", strReqTypeId,8);			
			dao.setProcInValue(nProcIndex, "item_id", strItemId,9);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,10);
			dao.setProcInValue(nProcIndex, "batchSl_no", "",11);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,12);
			dao.setProcInValue(nProcIndex, "item_SlNo", "",13);
			dao.setProcInValue(nProcIndex, "stock_status_code",	"",14);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,15);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,16);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInHandQty,17);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid",	strInHandQtyUnitId,18);
			dao.setProcInValue(nProcIndex, "bal_qty", strBalQty.trim(),19);
			dao.setProcInValue(nProcIndex, "bal_qty_unitid", strBalQtyUnitId,20);
			dao.setProcInValue(nProcIndex, "issue_qty", strIssueQty,21);
			dao.setProcInValue(nProcIndex, "issue_qty_unitid",strIssueQtyUnitId,22);
			dao.setProcInValue(nProcIndex, "manuf_date",(strManufDate==NULL||strManufDate=="")?"0":strManufDate,23);
			dao.setProcInValue(nProcIndex, "expiry_date",(strExpiryDate==NULL||strExpiryDate=="")?"0":strExpiryDate,24);
			dao.setProcInValue(nProcIndex, "rate", strRate,25);
			dao.setProcInValue(nProcIndex, "rate_unitid",strRateUnitId,26);
			dao.setProcInValue(nProcIndex, "comsumable_flag",strConsumableFlag,27);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,28);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId,29);
			dao.setProcOutValue(nProcIndex, "err", 1,30);
			//System.out.println("exp Date:::  "+((strExpiryDate==NULL||strExpiryDate=="")?"x":strExpiryDate));
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

		// return nProcIndex;
	}
	
	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update1(HisDAO dao) throws Exception
	{

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call PKG_MMS_DML.dml_update_store_item_dtls (?,?,?,?,?,?,?,?)}";// 8
			nProcIndex = dao.setProcedure(strProcName);

//			 //System.out.println("strTotIssueQty - "+ strTotIssueQty);
//			 //System.out.println("hospital_code-"+ strHospitalCode);
//			 //System.out.println( "item_id-"+ strItemId);
//			 //System.out.println("item_brand_id-"+ strItemBrandId);
//			 //System.out.println( "strTotIssueQtyUnit-"+ strTotIssueQtyUnit);
//			 //System.out.println("strRaisingStoreId-"+strRaisingStoreId );

		
			  dao.setProcInValue(nProcIndex, "modeval", "1",1);			
			  dao.setProcInValue(nProcIndex, "tot_issue_qty", strTotIssueQty,2);
			  dao.setProcInValue(nProcIndex, "tot_issue_qty_unit", strTotIssueQtyUnit,3);
			  dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			  dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			  dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			  dao.setProcInValue(nProcIndex, "raising_store_id", strRaisingStoreId,7);
			  dao.setProcOutValue(nProcIndex, "err", 1,8);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call dml_rate_contract_item_dtls (?,?,?,?,?,?,?,?,?,?)}";// 10
			nProcIndex = dao.setProcedure(strProcName);

			// //System.out.println(" strContractTypeID - "+ strContractTypeID);
			// //System.out.println("hospital_code"+ strHospitalCode);
			// //System.out.println( "item_id"+ strItemID);
			// //System.out.println("item_brand_id"+ strItemBrandID);
			// //System.out.println( "supplier_id"+ strSupplierId);
			// //System.out.println("cancel_remarks"+strCancelRemarks );
			// //System.out.println("seat_id"+ strSeatId);
			// // // //System.out.println("strRateContractSLNo"+
			// strRateContractSLNo);

			dao.setProcInValue(nProcIndex, "modeval", "2");
			/*
			 * dao.setProcInValue(nProcIndex, "contract_slNo",
			 * strRateContractSLNo); dao.setProcInValue(nProcIndex,
			 * "contract_type_id", strContractTypeID);
			 * dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			 * dao.setProcInValue(nProcIndex, "item_id", strItemID);
			 * dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandID);
			 * dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId);
			 * dao.setProcInValue(nProcIndex, "cancel_remarks",strCancelRemarks );
			 */
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strIssuingStoreId = "";
		strRaisingStoreId = "";
		strIssueNO = "";
		strItemId = "";
		strItemBrandId = "";
		strBatchSlNo = "";
		strItemSlno = "0";
	//	strStckStatusCode = "1";
		strGroupId = "";
		strSubGroupId = "0";
		strInHandQty = "0";
		strInHandQtyUnitId = "";
		strBalQty = "0";
		strBalQtyUnitId = "";
		strIssueQty = "0";
		strIssueQtyUnitId = "";
		strManufDate = "";
		strExpiryDate = "";
		strRate = "0";
		strRateUnitId = "";
		strConsumableFlag = "0";
	//	strCost = "0";
		strRemarks = "";

		strIndentNO = "";

	}

	/**
	 * Sets the str raising store id.
	 * 
	 * @param strRaisingStoreId the strRaisingStoreId to set
	 */
	public void setStrRaisingStoreId(String strRaisingStoreId) {
		this.strRaisingStoreId = strRaisingStoreId;
	}

	/**
	 * Sets the str reserved qty flag.
	 * 
	 * @param strReservedQtyFlag the strReservedQtyFlag to set
	 */
	public void setStrReservedQtyFlag(String strReservedQtyFlag) {
		this.strReservedQtyFlag = strReservedQtyFlag;
	}

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}

	/**
	 * Sets the str req type id.
	 * 
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	/**
	 * Sets the str stock status code.
	 * 
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}

	public String getStrTotIssueQty() {
		return strTotIssueQty;
	}

	public void setStrTotIssueQty(String strTotIssueQty) {
		this.strTotIssueQty = strTotIssueQty;
	}

	public String getStrTotIssueQtyUnit() {
		return strTotIssueQtyUnit;
	}

	public void setStrTotIssueQtyUnit(String strTotIssueQtyUnit) {
		this.strTotIssueQtyUnit = strTotIssueQtyUnit;
	}

}
