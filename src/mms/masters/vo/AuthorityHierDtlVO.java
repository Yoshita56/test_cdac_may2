/**
 * Developer : Deepak
 * Version : 1.0
 * Date : 31/Jan/2009
 */
package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlVO.
 */
public class AuthorityHierDtlVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;
	
	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str item cat cmb. */
	private String strItemCatCmb = "";
	
	/** The str req type cmb. */
	private String strReqTypeCmb = "";
	
	/** The str req type combo. */
	private String strReqTypeCombo = "";
	
	/** The str item category name. */
	private String strItemCategoryName = "";
	
	/** The str temp. */
	private String strTemp = "";
	
	/** The str level type. */
	private String strLevelType = "";
	
	/** The str caption name. */
	private String[] strCaptionName = { "Raising End", "Raising End::Admin",
			"Receiving End", "Receiving End::Admin" };
	
	/** The str item category combo ws. */
	private WebRowSet strItemCategoryComboWS = null;
	
	/** The str hier dtl ws. */
	private WebRowSet strHierDtlWS = null;
	
	/** The str prev hier dtl ws. */
	private WebRowSet strPrevHierDtlWS = null;
	
	/** The str hier dtl store ws. */
	private WebRowSet strHierDtlStoreWS = null;
	
	/** The str hier dtl admin ws. */
	private WebRowSet strHierDtlAdminWS = null;
	
	/** The str hier dtl store1 ws. */
	private WebRowSet strHierDtlStore1WS = null;
	
	/** The str hier dtl admin1 ws. */
	private WebRowSet strHierDtlAdmin1WS = null;
	
	/** The strr req type combo ws. */
	private WebRowSet strrReqTypeComboWS = null;
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** **********Variable Start Here*****************. */
	private String strBkgEntryDate = "";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str frm store id. */
	private String strFrmStoreId = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	/** The str to store name. */
	private String strToStoreName = "";
	
	/** The str update auth no. */
	private String strUpdateAuthNo = "0";
	
	/** The Group ws. */
	private WebRowSet GroupWs = null;
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str group id for item search. */
	private String strGroupIdForItemSearch = "";
	
	/** The chk_1. */
	private String[] chk_1 = null;
	
	/** The chk_2. */
	private String[] chk_2 = null;
	
	/** The chk_3. */
	private String[] chk_3 = null;
	
	/** The chk_4. */
	private String[] chk_4 = null;
	
	/** The chk_1text. */
	private String[] chk_1text = null;
	
	/** The chk_2text. */
	private String[] chk_2text = null;
	
	/** The chk_3text. */
	private String[] chk_3text = null;
	
	/** The chk_4text. */
	private String[] chk_4text = null;
	
	/** The h level type. */
	private String[] hLevelType = null;
	
	/** The str prev records sel. */
	private String strPrevRecordsSel = "";
	
	/** The str temp approval id. */
	private String strTempApprovalId = "";
	
	/** The str temp level type. */
	private String strTempLevelType = "";
	
	/** The str temp level. */
	private String strTempLevel = "";
	
	/** The str max auth no. */
	private String strMaxAuthNo = "";
	
	/** The str bkg qty. */
	private String[] strBkgQty = { "" };
	
	/** The str unit name. */
	private String[] strUnitName = { "" };
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str level type maxval. */
	private String strLevelTypeMaxval = "";
	
	/** The str transfer date. */
	private String strTransferDate = "";
	
	/** The str transfer qty. */
	private String[] strTransferQty = { "" };
	
	/** The str receive by. */
	private String strReceiveBy = "";
	
	/** The str net cost. */
	private String strNetCost = "0";
	
	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	private String strApprovalFlag;

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str bkg qty.
	 * 
	 * @return the str bkg qty
	 */
	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	/**
	 * Sets the str bkg qty.
	 * 
	 * @param strBkgQty the new str bkg qty
	 */
	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}

	/**
	 * Gets the str unit name.
	 * 
	 * @return the str unit name
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}

	/**
	 * Sets the str unit name.
	 * 
	 * @param strUnitName the new str unit name
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}

	/**
	 * Gets the str group id for item search.
	 * 
	 * @return the str group id for item search
	 */
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	/**
	 * Sets the str group id for item search.
	 * 
	 * @param strGroupIdForItemSearch the new str group id for item search
	 */
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str bkg entry date.
	 * 
	 * @return the str bkg entry date
	 */
	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	/**
	 * Sets the str bkg entry date.
	 * 
	 * @param strBkgEntryDate the new str bkg entry date
	 */
	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**
	 * ********Current Date************.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		HisUtil util = new HisUtil("Breakge Item Detail Transaction",
				"BreakgeItemDtlTransVO");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransVO.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

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
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the group ws.
	 * 
	 * @return the group ws
	 */
	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	/**
	 * Sets the group ws.
	 * 
	 * @param groupWs the new group ws
	 */
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	/**
	 * Gets the str financial start year.
	 * 
	 * @return the str financial start year
	 */
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}

	/**
	 * Sets the str financial start year.
	 * 
	 * @param strFinancialStartYear the new str financial start year
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	/**
	 * Gets the str financial end year.
	 * 
	 * @return the str financial end year
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}

	/**
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear the new str financial end year
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	/**
	 * Gets the str item category name.
	 * 
	 * @return the str item category name
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the new str item category name
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str item category combo ws.
	 * 
	 * @return the str item category combo ws
	 */
	public WebRowSet getStrItemCategoryComboWS() {
		return strItemCategoryComboWS;
	}

	/**
	 * Sets the str item category combo ws.
	 * 
	 * @param strItemCategoryComboWS the new str item category combo ws
	 */
	public void setStrItemCategoryComboWS(WebRowSet strItemCategoryComboWS) {
		this.strItemCategoryComboWS = strItemCategoryComboWS;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str to store name.
	 * 
	 * @return the str to store name
	 */
	public String getStrToStoreName() {
		return strToStoreName;
	}

	/**
	 * Sets the str to store name.
	 * 
	 * @param strToStoreName the new str to store name
	 */
	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}

	/**
	 * Gets the str frm store id.
	 * 
	 * @return the str frm store id
	 */
	public String getStrFrmStoreId() {
		return strFrmStoreId;
	}

	/**
	 * Sets the str frm store id.
	 * 
	 * @param strFrmStoreId the new str frm store id
	 */
	public void setStrFrmStoreId(String strFrmStoreId) {
		this.strFrmStoreId = strFrmStoreId;
	}

	/**
	 * Gets the str to store id.
	 * 
	 * @return the str to store id
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the new str to store id
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * Gets the str transfer date.
	 * 
	 * @return the str transfer date
	 */
	public String getStrTransferDate() {
		return strTransferDate;
	}

	/**
	 * Sets the str transfer date.
	 * 
	 * @param strTransferDate the new str transfer date
	 */
	public void setStrTransferDate(String strTransferDate) {
		this.strTransferDate = strTransferDate;
	}

	/**
	 * Gets the str receive by.
	 * 
	 * @return the str receive by
	 */
	public String getStrReceiveBy() {
		return strReceiveBy;
	}

	/**
	 * Sets the str receive by.
	 * 
	 * @param strReceiveBy the new str receive by
	 */
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}

	/**
	 * Gets the str net cost.
	 * 
	 * @return the str net cost
	 */
	public String getStrNetCost() {
		return strNetCost;
	}

	/**
	 * Sets the str net cost.
	 * 
	 * @param strNetCost the new str net cost
	 */
	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}

	/**
	 * Gets the str transfer qty.
	 * 
	 * @return the str transfer qty
	 */
	public String[] getStrTransferQty() {
		return strTransferQty;
	}

	/**
	 * Sets the str transfer qty.
	 * 
	 * @param strTransferQty the new str transfer qty
	 */
	public void setStrTransferQty(String[] strTransferQty) {
		this.strTransferQty = strTransferQty;
	}

	/**
	 * Gets the str item cat cmb.
	 * 
	 * @return the str item cat cmb
	 */
	public String getStrItemCatCmb() {
		return strItemCatCmb;
	}

	/**
	 * Sets the str item cat cmb.
	 * 
	 * @param strItemCatCmb the new str item cat cmb
	 */
	public void setStrItemCatCmb(String strItemCatCmb) {
		this.strItemCatCmb = strItemCatCmb;
	}

	/**
	 * Gets the str req type cmb.
	 * 
	 * @return the str req type cmb
	 */
	public String getStrReqTypeCmb() {
		return strReqTypeCmb;
	}

	/**
	 * Gets the str req type combo.
	 * 
	 * @return the str req type combo
	 */
	public String getStrReqTypeCombo() {
		return strReqTypeCombo;
	}

	/**
	 * Sets the str req type cmb.
	 * 
	 * @param strReqTypeCmb the new str req type cmb
	 */
	public void setStrReqTypeCmb(String strReqTypeCmb) {
		this.strReqTypeCmb = strReqTypeCmb;
	}

	/**
	 * Sets the str req type combo.
	 * 
	 * @param strReqTypeCombo the new str req type combo
	 */
	public void setStrReqTypeCombo(String strReqTypeCombo) {
		this.strReqTypeCombo = strReqTypeCombo;
	}

	/**
	 * Gets the strr req type combo ws.
	 * 
	 * @return the strr req type combo ws
	 */
	public WebRowSet getStrrReqTypeComboWS() {
		return strrReqTypeComboWS;
	}

	/**
	 * Sets the strr req type combo ws.
	 * 
	 * @param strrReqTypeComboWS the new strr req type combo ws
	 */
	public void setStrrReqTypeComboWS(WebRowSet strrReqTypeComboWS) {
		this.strrReqTypeComboWS = strrReqTypeComboWS;
	}

	/**
	 * Gets the str level type.
	 * 
	 * @return the str level type
	 */
	public String getStrLevelType() {
		return strLevelType;
	}

	/**
	 * Sets the str level type.
	 * 
	 * @param strLevelType the new str level type
	 */
	public void setStrLevelType(String strLevelType) {
		this.strLevelType = strLevelType;
	}

	/**
	 * Gets the str temp.
	 * 
	 * @return the str temp
	 */
	public String getStrTemp() {
		return strTemp;
	}

	/**
	 * Sets the str temp.
	 * 
	 * @param strTemp the new str temp
	 */
	public void setStrTemp(String strTemp) {
		this.strTemp = strTemp;
	}

	/**
	 * Gets the str hier dtl store ws.
	 * 
	 * @return the str hier dtl store ws
	 */
	public WebRowSet getStrHierDtlStoreWS() {
		return strHierDtlStoreWS;
	}

	/**
	 * Gets the str hier dtl admin ws.
	 * 
	 * @return the str hier dtl admin ws
	 */
	public WebRowSet getStrHierDtlAdminWS() {
		return strHierDtlAdminWS;
	}

	/**
	 * Sets the str hier dtl store ws.
	 * 
	 * @param strHierDtlStoreWS the new str hier dtl store ws
	 */
	public void setStrHierDtlStoreWS(WebRowSet strHierDtlStoreWS) {
		this.strHierDtlStoreWS = strHierDtlStoreWS;
	}

	/**
	 * Sets the str hier dtl admin ws.
	 * 
	 * @param strHierDtlAdminWS the new str hier dtl admin ws
	 */
	public void setStrHierDtlAdminWS(WebRowSet strHierDtlAdminWS) {
		this.strHierDtlAdminWS = strHierDtlAdminWS;
	}

	/**
	 * Gets the str hier dtl ws.
	 * 
	 * @return the str hier dtl ws
	 */
	public WebRowSet getStrHierDtlWS() {
		return strHierDtlWS;
	}

	/**
	 * Sets the str hier dtl ws.
	 * 
	 * @param strHierDtlWS the new str hier dtl ws
	 */
	public void setStrHierDtlWS(WebRowSet strHierDtlWS) {
		this.strHierDtlWS = strHierDtlWS;
	}

	/**
	 * Gets the str hier dtl store1 ws.
	 * 
	 * @return the str hier dtl store1 ws
	 */
	public WebRowSet getStrHierDtlStore1WS() {
		return strHierDtlStore1WS;
	}

	/**
	 * Gets the str hier dtl admin1 ws.
	 * 
	 * @return the str hier dtl admin1 ws
	 */
	public WebRowSet getStrHierDtlAdmin1WS() {
		return strHierDtlAdmin1WS;
	}

	/**
	 * Sets the str hier dtl store1 ws.
	 * 
	 * @param strHierDtlStore1WS the new str hier dtl store1 ws
	 */
	public void setStrHierDtlStore1WS(WebRowSet strHierDtlStore1WS) {
		this.strHierDtlStore1WS = strHierDtlStore1WS;
	}

	/**
	 * Sets the str hier dtl admin1 ws.
	 * 
	 * @param strHierDtlAdmin1WS the new str hier dtl admin1 ws
	 */
	public void setStrHierDtlAdmin1WS(WebRowSet strHierDtlAdmin1WS) {
		this.strHierDtlAdmin1WS = strHierDtlAdmin1WS;
	}

	/**
	 * Gets the chk_1.
	 * 
	 * @return the chk_1
	 */
	public String[] getChk_1() {
		return chk_1;
	}

	/**
	 * Gets the chk_2.
	 * 
	 * @return the chk_2
	 */
	public String[] getChk_2() {
		return chk_2;
	}

	/**
	 * Gets the chk_3.
	 * 
	 * @return the chk_3
	 */
	public String[] getChk_3() {
		return chk_3;
	}

	/**
	 * Gets the chk_4.
	 * 
	 * @return the chk_4
	 */
	public String[] getChk_4() {
		return chk_4;
	}

	/**
	 * Gets the chk_1text.
	 * 
	 * @return the chk_1text
	 */
	public String[] getChk_1text() {
		return chk_1text;
	}

	/**
	 * Gets the chk_2text.
	 * 
	 * @return the chk_2text
	 */
	public String[] getChk_2text() {
		return chk_2text;
	}

	/**
	 * Gets the chk_3text.
	 * 
	 * @return the chk_3text
	 */
	public String[] getChk_3text() {
		return chk_3text;
	}

	/**
	 * Gets the chk_4text.
	 * 
	 * @return the chk_4text
	 */
	public String[] getChk_4text() {
		return chk_4text;
	}

	/**
	 * Gets the h level type.
	 * 
	 * @return the h level type
	 */
	public String[] getHLevelType() {
		return hLevelType;
	}

	/**
	 * Sets the chk_1.
	 * 
	 * @param chk_1 the new chk_1
	 */
	public void setChk_1(String[] chk_1) {
		this.chk_1 = chk_1;
	}

	/**
	 * Sets the chk_2.
	 * 
	 * @param chk_2 the new chk_2
	 */
	public void setChk_2(String[] chk_2) {
		this.chk_2 = chk_2;
	}

	/**
	 * Sets the chk_3.
	 * 
	 * @param chk_3 the new chk_3
	 */
	public void setChk_3(String[] chk_3) {
		this.chk_3 = chk_3;
	}

	/**
	 * Sets the chk_4.
	 * 
	 * @param chk_4 the new chk_4
	 */
	public void setChk_4(String[] chk_4) {
		this.chk_4 = chk_4;
	}

	/**
	 * Sets the chk_1text.
	 * 
	 * @param chk_1text the new chk_1text
	 */
	public void setChk_1text(String[] chk_1text) {
		this.chk_1text = chk_1text;
	}

	/**
	 * Sets the chk_2text.
	 * 
	 * @param chk_2text the new chk_2text
	 */
	public void setChk_2text(String[] chk_2text) {
		this.chk_2text = chk_2text;
	}

	/**
	 * Sets the chk_3text.
	 * 
	 * @param chk_3text the new chk_3text
	 */
	public void setChk_3text(String[] chk_3text) {
		this.chk_3text = chk_3text;
	}

	/**
	 * Sets the chk_4text.
	 * 
	 * @param chk_4text the new chk_4text
	 */
	public void setChk_4text(String[] chk_4text) {
		this.chk_4text = chk_4text;
	}

	/**
	 * Sets the h level type.
	 * 
	 * @param levelType the new h level type
	 */
	public void setHLevelType(String[] levelType) {
		hLevelType = levelType;
	}

	/**
	 * Gets the str level type maxval.
	 * 
	 * @return the str level type maxval
	 */
	public String getStrLevelTypeMaxval() {
		return strLevelTypeMaxval;
	}

	/**
	 * Sets the str level type maxval.
	 * 
	 * @param strLevelTypeMaxval the new str level type maxval
	 */
	public void setStrLevelTypeMaxval(String strLevelTypeMaxval) {
		this.strLevelTypeMaxval = strLevelTypeMaxval;
	}

	/**
	 * Gets the str temp approval id.
	 * 
	 * @return the str temp approval id
	 */
	public String getStrTempApprovalId() {
		return strTempApprovalId;
	}

	/**
	 * Gets the str temp level type.
	 * 
	 * @return the str temp level type
	 */
	public String getStrTempLevelType() {
		return strTempLevelType;
	}

	/**
	 * Gets the str temp level.
	 * 
	 * @return the str temp level
	 */
	public String getStrTempLevel() {
		return strTempLevel;
	}

	/**
	 * Sets the str temp approval id.
	 * 
	 * @param strTempApprovalId the new str temp approval id
	 */
	public void setStrTempApprovalId(String strTempApprovalId) {
		this.strTempApprovalId = strTempApprovalId;
	}

	/**
	 * Sets the str temp level type.
	 * 
	 * @param strTempLevelType the new str temp level type
	 */
	public void setStrTempLevelType(String strTempLevelType) {
		this.strTempLevelType = strTempLevelType;
	}

	/**
	 * Sets the str temp level.
	 * 
	 * @param strTempLevel the new str temp level
	 */
	public void setStrTempLevel(String strTempLevel) {
		this.strTempLevel = strTempLevel;
	}

	/**
	 * Gets the str max auth no.
	 * 
	 * @return the str max auth no
	 */
	public String getStrMaxAuthNo() {
		return strMaxAuthNo;
	}

	/**
	 * Sets the str max auth no.
	 * 
	 * @param strMaxAuthNo the new str max auth no
	 */
	public void setStrMaxAuthNo(String strMaxAuthNo) {
		this.strMaxAuthNo = strMaxAuthNo;
	}

	/**
	 * Gets the str prev hier dtl ws.
	 * 
	 * @return the str prev hier dtl ws
	 */
	public WebRowSet getStrPrevHierDtlWS() {
		return strPrevHierDtlWS;
	}

	/**
	 * Sets the str prev hier dtl ws.
	 * 
	 * @param strPrevHierDtlWS the new str prev hier dtl ws
	 */
	public void setStrPrevHierDtlWS(WebRowSet strPrevHierDtlWS) {
		this.strPrevHierDtlWS = strPrevHierDtlWS;
	}

	/**
	 * Gets the str prev records sel.
	 * 
	 * @return the str prev records sel
	 */
	public String getStrPrevRecordsSel() {
		return strPrevRecordsSel;
	}

	/**
	 * Sets the str prev records sel.
	 * 
	 * @param strPrevRecordsSel the new str prev records sel
	 */
	public void setStrPrevRecordsSel(String strPrevRecordsSel) {
		this.strPrevRecordsSel = strPrevRecordsSel;
	}

	/**
	 * Gets the str caption name.
	 * 
	 * @return the str caption name
	 */
	public String[] getStrCaptionName() {
		return strCaptionName;
	}

	/**
	 * Sets the str caption name.
	 * 
	 * @param strCaptionName the new str caption name
	 */
	public void setStrCaptionName(String[] strCaptionName) {
		this.strCaptionName = strCaptionName;
	}

	/**
	 * Gets the str update auth no.
	 * 
	 * @return the str update auth no
	 */
	public String getStrUpdateAuthNo() {
		return strUpdateAuthNo;
	}

	/**
	 * Sets the str update auth no.
	 * 
	 * @param strUpdateAuthNo the new str update auth no
	 */
	public void setStrUpdateAuthNo(String strUpdateAuthNo) {
		this.strUpdateAuthNo = strUpdateAuthNo;
	}

	/**
	 * @param strApprovalFlag the strApprovalFlag to set
	 */
	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
	}

	/**
	 * @return the strApprovalFlag
	 */
	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

}
