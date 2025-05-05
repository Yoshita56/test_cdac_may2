package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Dec/2008
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_STORE_MST
 */

public class StoreDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.StoreDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str store level. */
	private String strStoreLevel = "";
	
	/** The str building code. */
	private String strBuildingCode = "";
	
	/** The str emp code. */
	private String strEmpCode = "";
	
	/** The str block id. */
	private String strBlockId = "";
	
	/** The str floor id. */
	private String strFloorId = "";
	
	/** The str owner name. */
	private String strOwnerName = "";
	
	/** The str phone no. */
	private String strPhoneNo = "";
	
	/** The str owner address. */
	private String strOwnerAddress = "";
	
	/** The str dept code. */
	private String strDeptCode = "";
	
	private String strCatgCode;
	
	private String strLocation;
	
	/** The str ward code. */
	private String strWardCode = "";
	
	/** The str contact no. */
	private String strContactNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str owner. */
	private String strOwner = "";

	/** The str last mode seat id. */
	//private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	//private String strLastModeDate = "";
	
	/**New Item can be inserted **/
	
	private String strIsNewItemFlag="0";
	private String strCatgSlNo;
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";

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
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	
	private String strItemBounded="1";
	private String strSection="1";
	private String strPurchasingMode="0";
	
	
	private String strTimeBoundFlag;
	private String strFromTime;
	private String strToTime;
	private String strDistrictId;
	private String strDrugWarehouseTypeId;
	private String strCode;
	private String strNoOfBeds;
	private String strParentDistricWarehouseId;
	
	private String strHeader1;
	private String strHeader2;
	private String strHeader3;
	private String strMapHospId;
	private String strDLNo;
	private String strEmdType;
	public String getStrEmdType() {
		return strEmdType;
	}

	public void setStrEmdType(String strEmdType) {
		this.strEmdType = strEmdType;
	}

	public String getStrDLNo() {
		return strDLNo;
	}

	public void setStrDLNo(String strDLNo) {
		this.strDLNo = strDLNo;
	}

	public String getStrMapHospId() {
		return strMapHospId;
	}

	public void setStrMapHospId(String strMapHospId) {
		this.strMapHospId = strMapHospId;
	}

	public String getStrHeader1() {
		return strHeader1;
	}

	public void setStrHeader1(String strHeader1) {
		this.strHeader1 = strHeader1;
	}

	public String getStrHeader2() {
		return strHeader2;
	}

	public void setStrHeader2(String strHeader2) {
		this.strHeader2 = strHeader2;
	}

	public String getStrHeader3() {
		return strHeader3;
	}

	public void setStrHeader3(String strHeader3) {
		this.strHeader3 = strHeader3;
	}

	/**
	 * @return the strTimeBoundFlag
	 */
	public String getStrTimeBoundFlag() {
		return strTimeBoundFlag;
	}

	/**
	 * @param strTimeBoundFlag the strTimeBoundFlag to set
	 */
	public void setStrTimeBoundFlag(String strTimeBoundFlag) {
		this.strTimeBoundFlag = strTimeBoundFlag;
	}

	/**
	 * @return the strFromTime
	 */
	public String getStrFromTime() {
		return strFromTime;
	}

	/**
	 * @param strFromTime the strFromTime to set
	 */
	public void setStrFromTime(String strFromTime) {
		this.strFromTime = strFromTime;
	}

	/**
	 * @return the strToTime
	 */
	public String getStrToTime() {
		return strToTime;
	}

	/**
	 * @param strToTime the strToTime to set
	 */
	public void setStrToTime(String strToTime) {
		this.strToTime = strToTime;
	}

	/**
	 * @param strSection the strSection to set
	 */
	public void setStrSection(String strSection) {
		this.strSection = strSection;
	}

	/**
	 * @param strPurchasingMode the strPurchasingMode to set
	 */
	public void setStrPurchasingMode(String strPurchasingMode) {
		this.strPurchasingMode = strPurchasingMode;
	}

	/**
	 * @param strItemBounded the strItemBounded to set
	 */
	public void setStrItemBounded(String strItemBounded) {
		this.strItemBounded = strItemBounded;
	}

	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}

	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

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
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Sets the str store level.
	 * 
	 * @param strStoreLevel the strStoreLevel to set
	 */
	public void setStrStoreLevel(String strStoreLevel) {
		this.strStoreLevel = strStoreLevel;
	}

	/**
	 * Sets the str building code.
	 * 
	 * @param strBuildingCode the strBuildingCode to set
	 */
	public void setStrBuildingCode(String strBuildingCode) {
		this.strBuildingCode = strBuildingCode;
	}

	/**
	 * Sets the str emp code.
	 * 
	 * @param strEmpCode the strEmpCode to set
	 */
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}

	/**
	 * Sets the str block id.
	 * 
	 * @param strBlockId the strBlockId to set
	 */
	public void setStrBlockId(String strBlockId) {
		this.strBlockId = strBlockId;
	}

	/**
	 * Sets the str floor id.
	 * 
	 * @param strFloorId the strFloorId to set
	 */
	public void setStrFloorId(String strFloorId) {
		this.strFloorId = strFloorId;
	}

	/**
	 * Sets the str owner name.
	 * 
	 * @param strOwnerName the strOwnerName to set
	 */
	public void setStrOwnerName(String strOwnerName) {
		this.strOwnerName = strOwnerName;
	}

	/**
	 * Sets the str phone no.
	 * 
	 * @param strPhoneNo the strPhoneNo to set
	 */
	public void setStrPhoneNo(String strPhoneNo) {
		this.strPhoneNo = strPhoneNo;
	}

	/**
	 * Sets the str owner address.
	 * 
	 * @param strOwnerAddress the strOwnerAddress to set
	 */
	public void setStrOwnerAddress(String strOwnerAddress) {
		this.strOwnerAddress = strOwnerAddress;
	}

	/**
	 * Sets the str dept code.
	 * 
	 * @param strDeptCode the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * Sets the str contact no.
	 * 
	 * @param strContactNo the strContactNo to set
	 */
	public void setStrContactNo(String strContactNo) {
		this.strContactNo = strContactNo;
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
	 * Sets the str owner.
	 * 
	 * @param strOwner the strOwner to set
	 */
	public void setStrOwner(String strOwner) {
		this.strOwner = strOwner;
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
	 * Sets the str ward code.
	 * 
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}


	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strStoreName or strHospitalCode or strStoreTypeId is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		try 
		{
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) 
			{
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreName.equals("0") || strStoreName.equals("")) 
			{
				throw new Exception("strStoreName can not be blank");
			}
			if (strStoreTypeId.equals("0") || strStoreTypeId.equals("")) 
			{
				throw new Exception("strStoreTypeId can not be blank");
			}

			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.Store.0");
			//strQuery="INSERT INTO HSTT_STORE_MST (GNUM_HOSPITAL_CODE , HSTNUM_STORE_ID  ,HSTNUM_STORETYPE_ID ,GDT_EFFECTIVE_FRM,GNUM_ISVALID , HSTSTR_STORE_NAME,  HSTNUM_STORE_LEVEL, NUM_BUILDING_CODE, HGSTR_EMP_CODE, NUM_BLOCK_ID, NUM_FLOOR_ID, HSTSTR_OWNER_NAME, HSTSTR_PHONE_NO, HSTSTR_OWNER_ADDRESS,  GNUM_DEPT_CODE,  HSTSTR_CONTACT_NO, GSTR_REMARKS, HSTNUM_OWNER, GDT_ENTRY_DATE , GNUM_SEATID,GNUM_WARD_CODE,HSTDT_FINANCIAL_START_DATE,HSTDT_FINANCIAL_END_DATE, HSTNUM_IS_ITEMBOUND,HSTNUM_NEWITEM_FLAG,HSTNUM_SECTION_MODE,HSTNUM_PURCHASING_MODE,HSTNUM_IS_TIME_BOUND,HSTSTR_FROM_TIME,HSTSTR_TO_TIME, HSTSTR_LOCATION , NUM_DIST_ID, SSTNUM_DWH_TYPE_ID,HSTSTR_STORE_CODE,HSTNUM_NO_BEDS,HSTNUM_PARENT_STORE_ID, HSTSTR_HEADER1, HSTSTR_HEADER2, HSTSTR_HEADER3,HSTSTR_DLNO,hstnum_emd_type,hstnum_map_hosp_id) VALUES(?\:\:numeric, ?\:\:numeric, ?\:\:numeric, to_date(to_char(?\:\:timestamp,'dd-Mon-yyyy'),'dd-Mon-yyyy'), ?\:\:numeric, ?,?\:\:numeric,?\:\:numeric, ?, ?\:\:numeric, ?\:\:numeric, ?,  ?\:\:numeric, ?, ?\:\:numeric, ?\:\:numeric, ?, ?\:\:numeric, SYSDATE, ?\:\:numeric, ?\:\:numeric, to_date(to_char(?\:\:timestamp,'dd-Mon-yyyy'),'dd-Mon-yyyy'), to_date(to_char(?\:\:timestamp,'dd-Mon-yyyy'),'dd-Mon-yyyy'), ?\:\:numeric, ?\:\:numeric, ?\:\:numeric, ?\:\:numeric, ?\:\:numeric,?,?, ?, ?\:\:numeric, ?\:\:numeric, ?, ?\:\:numeric, ?\:\:numeric, ?, ?, ? ,?,?,?::numeric )";
			System.out.println("Query--->>"+strQuery);
			
			/*
			System.out.println("strHospitalCode--->>"+strHospitalCode);
			System.out.println("strStoreId--->>"+strStoreId);
			System.out.println("strStoreTypeId--->>"+strStoreTypeId);
			System.out.println("strEffectiveFrom--->>"+strEffectiveFrom);
			
			System.out.println("strIsValid--->>"+strIsValid);
			System.out.println("strStoreName--->>"+strStoreName);
			System.out.println("strStoreLevel--->>"+strStoreLevel);
			System.out.println("strBuildingCode--->>"+strBuildingCode);
			System.out.println("strEmpCode--->>"+strEmpCode);
			System.out.println("strBlockId--->>"+strBlockId);
			System.out.println("strFloorId--->>"+strFloorId);
			System.out.println("strOwnerName--->>"+strOwnerName);
			System.out.println("strPhoneNo--->>"+strPhoneNo);
			System.out.println("strRemarks--->>"+strRemarks);
			System.out.println("strOwner--->>"+strOwner);
			System.out.println("strSeatId--->>"+strSeatId);
			
			System.out.println("strWardCode--->>"+strWardCode);
			System.out.println("strFinStartDate--->>"+strFinStartDate);
			System.out.println("strFinEndDate--->>"+strFinEndDate);
			System.out.println("strItemBounded--->>"+strItemBounded);
			System.out.println("strIsNewItemFlag--->>"+strIsNewItemFlag);		
			System.out.println("strSection--->>"+strSection);
			System.out.println("strPurchasingMode--->>"+strPurchasingMode);
			System.out.println("strTimeBoundFlag--->>"+strTimeBoundFlag);
			System.out.println("strFromTime--->>"+strFromTime);
			System.out.println("strToTime--->>"+strToTime);		
			System.out.println("strLocation--->>"+strLocation);
			System.out.println("strDistrictId--->>"+strDistrictId);
			System.out.println("strDrugWarehouseTypeId--->>"+strDrugWarehouseTypeId);
			System.out.println("strCode--->>"+strCode);
			System.out.println("strNoOfBeds--->>"+strNoOfBeds);		
			System.out.println("strParentDistricWarehouseId--->>"+strParentDistricWarehouseId);
			System.out.println("strHeader1--->>"+strHeader1);
			System.out.println("strHeader2--->>"+strHeader2);
			System.out.println("strHeader3--->>"+strHeader3);
			System.out.println("strDLNo--->>"+strDLNo);
			System.out.println("strEmdType-40-->>"+strEmdType);
			System.out.println("strMapHospId-41-->>"+strMapHospId);			
			*/
			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strStoreId);			
			dao.setQryValue(nQueryIndex, 3, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 4, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 5, strIsValid);
			dao.setQryValue(nQueryIndex, 6, strStoreName);
			dao.setQryValue(nQueryIndex, 7, strStoreLevel);
			dao.setQryValue(nQueryIndex, 8, strBuildingCode);
			dao.setQryValue(nQueryIndex, 9, strEmpCode);
			dao.setQryValue(nQueryIndex, 10, strBlockId);
			dao.setQryValue(nQueryIndex, 11, strFloorId);
			dao.setQryValue(nQueryIndex, 12, strOwnerName);
			dao.setQryValue(nQueryIndex, 13, strPhoneNo);
			dao.setQryValue(nQueryIndex, 14, strOwnerAddress);
			dao.setQryValue(nQueryIndex, 15, strDeptCode);
			dao.setQryValue(nQueryIndex, 16, strPhoneNo);
			dao.setQryValue(nQueryIndex, 17, strRemarks);
			dao.setQryValue(nQueryIndex, 18, strOwner);
			//dao.setQryValue(nQueryIndex, 19, strEntryDate);
			dao.setQryValue(nQueryIndex, 19, strSeatId);
			
			dao.setQryValue(nQueryIndex, 20, strWardCode);
			dao.setQryValue(nQueryIndex, 21, strFinStartDate);
			dao.setQryValue(nQueryIndex, 22, strFinEndDate);
			dao.setQryValue(nQueryIndex, 23, strItemBounded);
			dao.setQryValue(nQueryIndex, 24, strIsNewItemFlag);
			dao.setQryValue(nQueryIndex, 25, strSection);
			dao.setQryValue(nQueryIndex, 26, strPurchasingMode);			
			dao.setQryValue(nQueryIndex, 27, strTimeBoundFlag);
			dao.setQryValue(nQueryIndex, 28, strFromTime);
			dao.setQryValue(nQueryIndex, 29, strToTime);
			dao.setQryValue(nQueryIndex, 30, strLocation);
			dao.setQryValue(nQueryIndex, 31, strDistrictId);
			dao.setQryValue(nQueryIndex, 32, strDrugWarehouseTypeId);
			dao.setQryValue(nQueryIndex, 33, strCode);
			dao.setQryValue(nQueryIndex, 34, strNoOfBeds);
			dao.setQryValue(nQueryIndex, 35, strParentDistricWarehouseId);			
			dao.setQryValue(nQueryIndex, 36, strHeader1);
			dao.setQryValue(nQueryIndex, 37, strHeader2);
			dao.setQryValue(nQueryIndex, 38, strHeader3);
			dao.setQryValue(nQueryIndex, 39, strDLNo);
			dao.setQryValue(nQueryIndex, 40, (strEmdType.equals("0")? "1" : strEmdType));
			dao.setQryValue(nQueryIndex, 41, strMapHospId.equalsIgnoreCase("")?"0":strMapHospId);
			
			
			
			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) 
		{

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
	 * when strStoreName or strHospitalCode OR strStoreId is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreName.equals("0") || strStoreName.equals("")) {
				throw new Exception("strStoreName can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.Store.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strStoreName);
			dao.setQryValue(nQueryIndex, 2, strStoreLevel);
			dao.setQryValue(nQueryIndex, 3, strBuildingCode);
			dao.setQryValue(nQueryIndex, 4, strEmpCode);
			dao.setQryValue(nQueryIndex, 5, strBlockId);
			dao.setQryValue(nQueryIndex, 6, strFloorId);
			dao.setQryValue(nQueryIndex, 7, strOwnerName);
			dao.setQryValue(nQueryIndex, 8, strPhoneNo);
			dao.setQryValue(nQueryIndex, 9, strOwnerAddress);
			dao.setQryValue(nQueryIndex, 10, strDeptCode);
			dao.setQryValue(nQueryIndex, 11, strContactNo);
			dao.setQryValue(nQueryIndex, 12, strOwner);
			dao.setQryValue(nQueryIndex, 13, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 14, strSeatId);
			dao.setQryValue(nQueryIndex, 15, strRemarks);
			dao.setQryValue(nQueryIndex, 16, strIsValid);
			dao.setQryValue(nQueryIndex, 17, strWardCode);
			dao.setQryValue(nQueryIndex, 18, strItemBounded);
			dao.setQryValue(nQueryIndex, 19, strIsNewItemFlag);
			dao.setQryValue(nQueryIndex, 20, strSection);
			dao.setQryValue(nQueryIndex, 21, strPurchasingMode);
			dao.setQryValue(nQueryIndex, 22, strFinStartDate);
			dao.setQryValue(nQueryIndex, 23, strFinEndDate);
			dao.setQryValue(nQueryIndex, 24, strTimeBoundFlag);
			dao.setQryValue(nQueryIndex, 25, strFromTime);
			dao.setQryValue(nQueryIndex, 26, strToTime);
			dao.setQryValue(nQueryIndex, 27, strLocation);
			dao.setQryValue(nQueryIndex, 28, strDistrictId);
			dao.setQryValue(nQueryIndex, 29, strDrugWarehouseTypeId);
			dao.setQryValue(nQueryIndex, 30, strCode);
			dao.setQryValue(nQueryIndex, 31, strNoOfBeds);
			dao.setQryValue(nQueryIndex, 32, strParentDistricWarehouseId);
			dao.setQryValue(nQueryIndex, 33, strHeader1);
			dao.setQryValue(nQueryIndex, 34, strHeader2);
			dao.setQryValue(nQueryIndex, 35, strHeader3);
			dao.setQryValue(nQueryIndex, 36, strMapHospId);
			dao.setQryValue(nQueryIndex, 37, strDLNo);
			dao.setQryValue(nQueryIndex, 38, strEmdType.equals("0")? "1" : strEmdType);
			dao.setQryValue(nQueryIndex, 39, strHospitalCode);
			dao.setQryValue(nQueryIndex, 40, strStoreId);
			
			
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
		strStoreId = "";
		strStoreTypeId = "";
		strEffectiveFrom = "";
		strIsValid = "1";
		strStoreName = "";
		strStoreLevel = "";
		strBuildingCode = "";
		strEmpCode = "";
		strBlockId = "";
		strFloorId = "";
		strOwnerName = "";
		strPhoneNo = "";
		strOwnerAddress = "";
		strDeptCode = "";
		strContactNo = "";
		strRemarks = "";
		strOwner = "";
    
		strCatgCode = "";
		strSeatId = "";

		strErr = "";

	}

	/**
	 * @param strIsNewItemFlag the strIsNewItemFlag to set
	 */
	public void setStrIsNewItemFlag(String strIsNewItemFlag) {
		this.strIsNewItemFlag = strIsNewItemFlag;
	}

	public void setStrCatgCode(String strCatgCode) {
		this.strCatgCode = strCatgCode;
	}

	public void setStrCatgSlNo(String strCatgSlNo) {
		this.strCatgSlNo = strCatgSlNo;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrDistrictId() {
		return strDistrictId;
	}

	public void setStrDistrictId(String strDistrictId) {
		this.strDistrictId = strDistrictId;
	}

	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}

	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}

	public String getStrCode() {
		return strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	public String getStrNoOfBeds() {
		return strNoOfBeds;
	}

	public void setStrNoOfBeds(String strNoOfBeds) {
		this.strNoOfBeds = strNoOfBeds;
	}

	public String getStrParentDistricWarehouseId() {
		return strParentDistricWarehouseId;
	}

	public void setStrParentDistricWarehouseId(String strParentDistricWarehouseId) {
		this.strParentDistricWarehouseId = strParentDistricWarehouseId;
	}

	
}
