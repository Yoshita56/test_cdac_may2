package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 05/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_STOREITEM_MST
 */

/**
 * Developer : Tanvi Sappal Version : 1.0 Modify Date : 13/May/2009
 * 
 */
public class StoreItemDAO {

	private String strToleranceLimit = "";
	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.StoreItemDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item sl no. */
	private String strItemSlNo = "";
	
	/** The str item short name. */
	private String strItemShortName = "";
	
	/** The str ved category. */
	private String strVEDCategory = "1";
	
	/** The str fore cast. */
	private String strForeCast = "0";
	
	/** The str reserved qty. */
	private String strReservedQty = "0";
	
	/** The str max qty. */
	private String strMaxQty = "0";
	
	/** The str min qty. */
	//private String strMinQty = "0";
	
	/** The str reorder qty. */
	private String strReorderQty = "0";
	
	/** The str level unit id. */
	private String strLevelUnitId = "";
	
	/** The str last indent qty. */
	//private String strLastIndentQty = "0";
	
	/** The str last indent unit id. */
//	private String strLastIndentUnitId = "";
	
	/** The str last issue qty. */
//	private String strLastIssueQty = "";
	
	/** The str last issue unit id. */
//	private String strLastIssueUnitId = "";
	
	/** The str last receive qty. */
//	private String strLastReceiveQty = "";
	
	/** The str last receive unit id. */
//	private String strLastReceiveUnitId = "";
	
	/** The str issueable flag. */
	private String strIssueableFlag = "0";
	
	/** The str is returnable. */
	private String strIsReturnable = "0";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str last mode seat id. */
//	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
//	private String strLastModeDate = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";

	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";

	/** The str item category no. */
	private String strItemCategoryNo = "";
	
	private String strMaxIndentQty;

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
	



	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	
	
	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrMaxIndentQty(String strMaxIndentQty) 
	{
		this.strMaxIndentQty = strMaxIndentQty;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}

	/**
	 * Sets the str item short name.
	 * 
	 * @param strItemShortName the strItemShortName to set
	 */
	public void setStrItemShortName(String strItemShortName) {
		this.strItemShortName = strItemShortName;
	}

	/**
	 * Sets the str ved category.
	 * 
	 * @param strVEDCategory the strVEDCategory to set
	 */
	public void setStrVEDCategory(String strVEDCategory) {
		this.strVEDCategory = strVEDCategory;
	}

	/**
	 * Sets the str fore cast.
	 * 
	 * @param strForeCast the strForeCast to set
	 */
	public void setStrForeCast(String strForeCast) {
		this.strForeCast = strForeCast;
	}

	/**
	 * Sets the str max qty.
	 * 
	 * @param strMaxQty the strMaxQty to set
	 */
	public void setStrMaxQty(String strMaxQty) {
		this.strMaxQty = strMaxQty;
	}

 

	/**
	 * Sets the str reorder qty.
	 * 
	 * @param strReorderQty the strReorderQty to set
	 */
	public void setStrReorderQty(String strReorderQty) {
		this.strReorderQty = strReorderQty;
	}

	/**
	 * Sets the str level unit id.
	 * 
	 * @param strLevelUnitId the strLevelUnitId to set
	 */
	public void setStrLevelUnitId(String strLevelUnitId) {
		this.strLevelUnitId = strLevelUnitId;
	}

	 

	/**
	 * Sets the str issueable flag.
	 * 
	 * @param strIssueableFlag the strIssueableFlag to set
	 */
	public void setStrIssueableFlag(String strIssueableFlag) {
		this.strIssueableFlag = strIssueableFlag;
	}

	/**
	 * Sets the str is returnable.
	 * 
	 * @param strIsReturnable the strIsReturnable to set
	 */
	public void setStrIsReturnable(String strIsReturnable) {
		this.strIsReturnable = strIsReturnable;
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
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemShortName or strHospitalCode or strStoreId is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemShortName.equals("0") || strItemShortName.equals("")) {
				throw new Exception("strItemShortName can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;
			if(strIssueableFlag.equalsIgnoreCase(""))
			{
				strIssueableFlag="0";
				
			}
			if(strIsReturnable.equalsIgnoreCase(""))
			{
				strIsReturnable="0";
				
			}
			if(strLevelUnitId.equalsIgnoreCase(""))
			{
				strLevelUnitId="0";
				
			}

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.StoreItem.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strItemBrandId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strItemBrandId);
			dao.setQryValue(nQueryIndex, 4, strItemId);
			dao.setQryValue(nQueryIndex, 5, strStoreId);
			dao.setQryValue(nQueryIndex, 6, strStoreId);
			dao.setQryValue(nQueryIndex, 7, strHospitalCode);
			dao.setQryValue(nQueryIndex, 8, strItemId);
			dao.setQryValue(nQueryIndex, 9, strItemShortName);
			dao.setQryValue(nQueryIndex, 10, strVEDCategory);
			dao.setQryValue(nQueryIndex, 11, strForeCast);
			dao.setQryValue(nQueryIndex, 12, strReservedQty);
			dao.setQryValue(nQueryIndex, 13, strReorderQty);
			// dao.setQryValue(nQueryIndex, 14, strMinQty);
			dao.setQryValue(nQueryIndex, 14, strLevelUnitId);
			dao.setQryValue(nQueryIndex, 15, strRemarks);
			dao.setQryValue(nQueryIndex, 16, strIssueableFlag);
			dao.setQryValue(nQueryIndex, 17, strIsReturnable);
			dao.setQryValue(nQueryIndex, 18, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 19, strSeatId);
			dao.setQryValue(nQueryIndex, 20, strIsValid);
			dao.setQryValue(nQueryIndex, 21, strGroupId);
			dao.setQryValue(nQueryIndex, 22, strSubGroupId);
			dao.setQryValue(nQueryIndex, 23, strItemCategoryNo);
			dao.setQryValue(nQueryIndex, 24, strToleranceLimit);
			dao.setQryValue(nQueryIndex, 25, strMaxQty);
			dao.setQryValue(nQueryIndex, 26, strMaxIndentQty);			
			// //System.out.println("strGroupId:::"+strGroupId+"strSubGroupId::::"+strSubGroupId+"strItemCategoryNo::"+strItemCategoryNo);
			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
			////System.out.println(strQuery);
		} 
		catch (Exception e) {
            e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemSlNo or strHospitalCode OR strItemId or strSeatId
	 * or strStoreId is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemSlNo.equals("0") || strItemSlNo.equals("")) {
				throw new Exception("strItemSlNo can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
//			if (strSeatId.equals("0") || strSeatId.equals("")) {
//				throw new Exception("strSeatId can not be blank");
//			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.StoreItem.1");
			nQueryIndex = dao.setQuery(strQuery);
		/*
			//System.out.println("Hosp Code:::"+strHospitalCode);
			//System.out.println("Item Brand ID::::"+strItemBrandId);
			//System.out.println("Item Id:::"+strItemId);
			//System.out.println("Store Id:::"+strStoreId);
			//System.out.println("Item Sl No::::"+strItemSlNo);
			//System.out.println("Grp Id:::"+strGroupId);
			//System.out.println("Sub Grp Id:::"+strSubGroupId);
        */
			
			
			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strStoreId);
			dao.setQryValue(nQueryIndex, 3, strItemId);
			dao.setQryValue(nQueryIndex, 4, strItemBrandId);
			dao.setQryValue(nQueryIndex, 5, strGroupId);
			dao.setQryValue(nQueryIndex, 6, strItemSlNo);
			dao.setQryValue(nQueryIndex, 7, strSubGroupId);
		
			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strHospitalCode = "";
		strItemId = "";
		strItemBrandId = "";
		strItemSlNo = "";
		strItemShortName = "";
		strVEDCategory = "1";
		strForeCast = "0";
		strMaxQty = "0";
	//	strMinQty = "0";
		strReorderQty = "0";
		strLevelUnitId = "";
		/*strLastIndentQty = "0";
		strLastIndentUnitId = "";
		strLastIssueQty = "";
		strLastIssueUnitId = "";
		strLastReceiveQty = "";
		strLastReceiveUnitId = "";*/
		strIssueableFlag = "0";
		strIsReturnable = "0";

		strRemarks = "";
		strEffectiveFrom = "";
	/*	strLastModeSeatId = "";
		strLastModeDate = "";
		strEntryDate = "";*/
		strSeatId = "";
		strIsValid = "1";
		strItemCategoryNo = "1";

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
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the new str item category no
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * Sets the str reserved qty.
	 * 
	 * @param strReservedQty the new str reserved qty
	 */
	public void setStrReservedQty(String strReservedQty) {
		this.strReservedQty = strReservedQty;
	}

	/**
	 * @param strToleranceLimit the strToleranceLimit to set
	 */
	public void setStrToleranceLimit(String strToleranceLimit) {
		this.strToleranceLimit = strToleranceLimit;
	}

}
