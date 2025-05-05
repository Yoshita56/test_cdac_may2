package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.SetItemDetailsDAO;
import mms.dao.SetSachetDetailsDAO;
import mms.transactions.vo.SetSachetDetailsTransVO;

public class SetSachetDetailsTransDAO {

	/**
	 * The following function is used to populate the value of Store name combo
	 * box using Pkg_Mms_View.proc_hstt_store_mst() procedure.
	 * 
	 * @param voObj
	 */
	public static void getInitialValues(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStoreNameValuesWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getInitialValues() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * The following procedure is used to populate the value of Group Name combo
	 * box using Pkg_Mms_View.proc_store_group_list() procedure.
	 * 
	 * @param voObj
	 */
	public static void getGroupNameValues(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "item_category", voObj
					.getStrSetCategoryNo());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "");
			daoObj.setProcInValue(nProcIndex, "strStoreId", "");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrGroupNameValuesWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getGroupNameValues() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * The following procedure is used to populate the value of Category combo
	 * by store id
	 * 
	 * @param voObj
	 */
	public static void getCategoryValues(SetSachetDetailsTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "2");
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "reqType", "60");
			dao
					.setProcInValue(nProcIndex, "hosp_code", vo
							.getStrHospitalCode()); 

			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setStrCategoryValuesWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo
					.setStrMsgString("SetSachetDetailsTransDAO.getCategoryValues() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * The following function is used to populate the value of Sub-Group name
	 * combo box using Pkg_Mms_View.proc_store_subgroup_list() procedure.
	 * 
	 * @param voObj
	 */
	public static void getSubGroupNameValues(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_store_subgroup_list(?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj
					.setProcInValue(nProcIndex, "group_id", voObj
							.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrSubGroupNameValuesWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.setStrSubGroupNameValues --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * This function is used to populate the value of Set/Sachet Name combo box
	 * using pkg_mms_view.proc_item_list() procedure
	 * 
	 * @param voObj
	 */
	public static void getSachetNameValues(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call pkg_mms_view.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "catCode", voObj
					.getStrSetCategoryNo());
			daoObj.setProcInValue(nProcIndex, "grpId", voObj.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "item_id", "0");
			daoObj.setProcInValue(nProcIndex, "subGrpId", voObj
					.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "setFlag", "1");

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrSetSachetNameValuesWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getSetSachetNameValues --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * The following method is used to fetch the item details using
	 * Pkg_Mms_View.proc_itemsets_item_dtl() procedure.
	 * 
	 * @param voObj
	 */
	public static void getItemDetails(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_hstt_setsatchet_item_dtls(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "set_id", voObj
					.getStrSetSachetId());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj
					.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrItemListWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getItemDetails --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * The following method is used to populate the Brand Name Combo using
	 * Pkg_Mms_View.proc_itembrand_list() procedure.
	 * 
	 * @param voObj
	 */
	public static void getBrandNameCombo(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "item_id", voObj.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "catCode", "0");
			daoObj.setProcInValue(nProcIndex, "grpId", "0");
			daoObj.setProcInValue(nProcIndex, "subGrpId", "0");
			daoObj.setProcInValue(nProcIndex, "setFlag", "0");
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrBrandNameWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getBrandNameCombo --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * This function is used to to populate the value of Unit combo using
	 * Pkg_Mms_View.proc_GBLT_UNIT_MST() procedure
	 * 
	 * @param voObj
	 */
	public static void getUnitCombo(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj
					.getStrUsedQtyUnitId());
			daoObj.setProcInValue(nProcIndex, "module_id", "");
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setUnitNameWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.getUnitCombo --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * This function is used to first get the strSetSachetNo using
	 * MMS_MST.get_set_sachet_no function and this set sachet no will be used in
	 * insert insert the set sachet details in HSTT_SET_SACHET_DTL using
	 * PKG_MMS_DML.dml_set_sachet_dtls() procdure .
	 * 
	 * @param voObj
	 */
	public static void insertData(SetSachetDetailsTransVO voObj) {

		HisDAO daoObj = null;
		SetSachetDetailsDAO setSachetDetailsDAO = null;
		SetItemDetailsDAO setItemDetailsDAO = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strSetSachetNo = "";
		String strNetSetRate = "0";
		String strNetSalePrice = "0";
	//	Float netSetRate = 0.0f;
	//	Float netSalePrice = 0.0f;
		

		try {
			setSachetDetailsDAO = new SetSachetDetailsDAO();
			setItemDetailsDAO = new SetItemDetailsDAO();

			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strFuncName = "{? = call MMS_MST.get_set_sachet_no(?,?,?,?,?)}";
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrSetSachetId());
			daoObj.setFuncInValue(nFuncIndex, 5, voObj.getStrSetCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 6, "60"); // req type id for set sachet details
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strSetSachetNo = daoObj.getFuncString(nFuncIndex);
			////System.out.println("strSetSachetNo-" + strSetSachetNo);

			// insert data in HSTT_SET_SACHET_DTL

			setSachetDetailsDAO.setStrSetSachetNo(strSetSachetNo);
			setSachetDetailsDAO.setStrHospitalCode(voObj.getStrHospitalCode());
			setSachetDetailsDAO.setStrSetId(voObj.getStrSetSachetId());
			setSachetDetailsDAO.setStrNetRate(strNetSetRate);
			setSachetDetailsDAO.setStrNetRateUnitId(voObj
					.getStrInvUnitIdArray()[0]);
			setSachetDetailsDAO.setStrNetSalePrice(strNetSalePrice);
			setSachetDetailsDAO.setStrNetSalePriceUnitId(voObj
					.getStrInvUnitIdArray()[0]);
			setSachetDetailsDAO.setStrStoreId(voObj.getStrStoreId());
			setSachetDetailsDAO.setStrPreparedQty(voObj.getStrPreparedQty());
			setSachetDetailsDAO.setStrRemarks(voObj.getStrRemarks());
			setSachetDetailsDAO.setStrGroupId(voObj.getStrGroupId());
			setSachetDetailsDAO.setStrSubGroupId(voObj.getStrSubGroupId());
			setSachetDetailsDAO.setStrSeatId(voObj.getStrSeatId());
			setSachetDetailsDAO.setStrFinancialStartYear(voObj
					.getStrFinancialStartYear());
			setSachetDetailsDAO.setStrFinancialEndYear(voObj
					.getStrFinancialEndYear());
			setSachetDetailsDAO.setStrExpiryDate(voObj.getStrExpiryDate());
			setSachetDetailsDAO.setStrQtyUnitId(voObj.getStrSetUnitId());
			setSachetDetailsDAO.setStrCategoryNo(voObj.getStrSetCategoryNo());
			setSachetDetailsDAO.insert(daoObj);

			// insert data in HSTT_SET_ITEM_DTL

			for (int i = 0; i < voObj.getStrItemIdArray().length; i++) {

				setItemDetailsDAO.setStrCategoryNo(voObj
						.getStrCategoryNoArray()[i]);
				setItemDetailsDAO.setStrHosCode(voObj.getStrHospitalCode());
				setItemDetailsDAO
						.setStrItemBrandId(voObj.getStrBrandIdArray()[i]);
				setItemDetailsDAO.setStrItemId(voObj.getStrItemIdArray()[i]);
				setItemDetailsDAO.setStrSetId(voObj.getStrSetSachetId());
				setItemDetailsDAO.setStrSetSachetNO(strSetSachetNo);
				setItemDetailsDAO.setStrStoreId(voObj.getStrStoreId());
				setItemDetailsDAO.setStrSeatId(voObj.getStrSeatId());
				setItemDetailsDAO.setStrInvUnitId(voObj.getStrInvUnitIdArray()[i]); // inventory unit id
				setItemDetailsDAO.setStrReqQtyWithPrepQty(voObj.getStrReqQtyWithPrepQtyArray()[i]); // req qty in inv unit * prep qty

				setItemDetailsDAO.setStrGroupId(voObj.getStrGroupId());
				setItemDetailsDAO.setStrSubGroupId(voObj.getStrSubGroupId());
				setItemDetailsDAO.setStrExpiryDate(voObj.getStrExpiryDate());
				setItemDetailsDAO.setStrPreparedQty(voObj.getStrPreparedQty());
				setItemDetailsDAO.setStrSetUnitId(voObj.getStrSetUnitId());
				setItemDetailsDAO.setStrCategoryNo(voObj.getStrSetCategoryNo());
				setItemDetailsDAO.setStrSetGenericItemId(voObj.getStrSetGenericItemId());
				
				if(i==voObj.getStrItemIdArray().length-1)
				setItemDetailsDAO.setStrLastItemFlag("1");
				else
				setItemDetailsDAO.setStrLastItemFlag("0");
				
				 setItemDetailsDAO.insert(daoObj);

			/*	strNetSalePrice = daoObj.getString(nProcIndex, "netSalePrice");
				strNetSalePriceUnit = daoObj.getString(nProcIndex, "netSalePriceUnit");
				strNetItemRate = daoObj.getString(nProcIndex, "netRate");
				netSetRate = netSetRate + Float.parseFloat(strNetItemRate);*/
				
			//	netSetRate = netSetRate + Float.parseFloat(voObj.getStrCost()[i]);// commented on 11-july-09
			//	netSalePrice = netSalePrice + Float.parseFloat(voObj.getStrSalePriceArray()[i]); // commented on 11-july-09
				 
			}

			// strNetSetRate = Float.toString(netSetRate); // commented on 11-july-09
			// strNetSalePrice = Float.toString(netSalePrice); // commented on 11-july-09
			//////System.out.println("strNetSetRate-"+strNetSetRate);
			// ////System.out.println("strNetSalePrice-"+strNetSalePrice);

			
			synchronized (daoObj) {

				daoObj.fire();

			}

		} catch (Exception e) {
			e.printStackTrace();

			voObj
					.setStrMsgString("SetSachetDetailsTransDAO.insertSachetValues --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				setSachetDetailsDAO = null;

			}
		}

	}

}
