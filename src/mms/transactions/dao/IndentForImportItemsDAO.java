/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlIndentDtlImportedItemDAO;
import mms.transactions.vo.IndentForImportItemsVO;

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 27/Apr/2009
 * 
 */
public class IndentForImportItemsDAO {

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void ToStoreCombo(IndentForImportItemsVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "IndentForImportItemsDAO");
			dao = new HisDAO("mms",
					"IndentForImportItemsDAO.GetDeptCombo(IndentForImportItemsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());

			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());

			dao.setProcInValue(procIndex1, "reqType", vo.getStrReqType());

			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "", true);
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentForImportItemsDAO.ToStoreCombo() --> "
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
	 * To get Store Name
	 * 
	 * @param vo
	 */
	public static void getStoreName(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strStoreName = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strFuncName = "{? = call MMS_MST.get_store_dtl(?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strStoreName = dao.getFuncString(nFuncIndex);

			vo.setStrStoreName(strStoreName);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getStoreName() --> "
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
	 * To get Category Name
	 * 
	 * 
	 * @param vo
	 */
	public static void getCategoryName(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strCategoryName = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strFuncName = "{? = call MMS_MST.get_itemcat_dtl(?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strCategoryName = dao.getFuncString(nFuncIndex);

			vo.setStrItemCategory(strCategoryName);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getStoreName() --> "
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
	 * To get values of GRANT NAME COMBO
	 * 
	 * @param vo
	 */
	public static void getGrantList(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call Pkg_Mms_View.proc_grant_list(?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSGrantTypeNameCmb(ws);
				// //System.out.println("grant name ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getGrantList() --> "
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
	 * To get values of GROUP NAME COMBO BY STORE TYPE ID
	 * 
	 * @param vo
	 */
	public static void getGroupList(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_store_group_list(?,?,?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "item_category",
					vo.getStrItemCategoryNo(),3);

			/* Setting Default Value Start */
			dao.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
			dao.setProcInValue(nProcIndex, "strStoreId", "",5);
			/* Setting Default Value End */

			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSGroupNameCmb(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getGroupList() --> "
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
	 * To get values of CURRENCY NAME COMBO
	 * 
	 * @param vo
	 */
	public static void getCurrencyList(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call Pkg_Mms_View.proc_currency_list(?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);

			dao.setProcInValue(nProcIndex, "isDefault", "0",3);// Default value

			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSCurrencyNameCmb(ws);
				// //System.out.println("ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getCurrencyList() --> "
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
	 * To get SUPPLIER COMBO VALUES
	 * 
	 * @param vo
	 */
	public static void getSupplierList(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo(),2);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);

			/* Setting Default Value Start */
			dao.setProcInValue(nProcIndex, "branditem_id", "0",4);
			dao.setProcInValue(nProcIndex, "contractType", "0",5);
			/* Setting Default Value End */

			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSSupplierNameCmb(ws);
				// //System.out.println("ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSupplierList() --> "
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
	 * To get PURPOSE COMBO VALUES
	 * 
	 * @param vo
	 */
	public static void getPurposeList(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_purpose_list(?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeVal", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSPurposeCmb(ws);
				// //System.out.println("setWSPurposeCmb size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSupplierList() --> "
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
	 * To get SUBGROUP COMBO IN THE BASIS OF SELECTED GROUP
	 * 
	 * @param vo
	 */
	public static void getSubGroupCombo(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			// //System.out.println("dao subgrp vo.getStrGroupId()"+vo.getStrGroupId());
			dao.setProcInValue(nProcIndex, "modeVal", "1",1);
			dao.setProcInValue(nProcIndex, "group_id", vo.getStrGroupId(),2);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSSubGroupNameCmb(ws);
				// //System.out.println("ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSubGroupCombo() --> "
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
	 * To get ITEM NAME COMBO IN THE BASIS OF SELECTED GROUP
	 * 
	 * @param vo
	 */
	public static void getItemCombo(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			// //System.out.println( "group_id-->>"+ vo.getStrGroupId());
			// //System.out.println( "cat_no-->>"+ vo.getStrItemCategoryNo());
			// //System.out.println( "store_id-->>"+ vo.getStrStoreId());
			// //System.out.println( "hosp_code-->>"+ vo.getStrHospitalCode());
			// //System.out.println( "sub_group_id--->>"+ vo.getStrSubGroupId());

			strProcName = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeVal", "1",1);
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo(),3);
			dao.setProcInValue(nProcIndex, "group_id", vo.getStrGroupId(),4);
			dao.setProcInValue(nProcIndex, "sub_group_id",
					vo.getStrSubGroupId(),5);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),6);
			dao.setProcInValue(nProcIndex, "item_id", "0",7);// Default value
			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSItemNameCmb(ws);
				// //System.out.println("ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getItemCombo() --> "
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
	 * To get BRAND NAME COMBO IN THE BASIS OF SELECTED ITEM
	 * 
	 * @param vo
	 */
	public static void getBrandCombo(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo(),2);

			dao.setProcInValue(nProcIndex, "item_id", vo.getStrItemId(),3);
			dao.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId(),4);

			dao.setProcInValue(nProcIndex, "subGrpId", vo.getStrSubGroupId(),5);

			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),6);

			dao.setProcInValue(nProcIndex, "setFlag", "0",7); // Default value.

			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setWSBrandNameCmb(ws);
				// //System.out.println("ws size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getBrandCombo() --> "
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
	 * To get SUPPLIER ADDRESS IN THE BASIS OF SELECTED SUPPLIER
	 * 
	 * @param vo
	 */
	public static void getSupplierAddress(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call Pkg_Mms_View.proc_supplier_dtl(?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "supplier_id", vo.getStrSupplierId(),3);

			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				// //System.out.println("ws size" + ws.size());
				while (ws.next()) {
					vo.setStrSupplierAddress(ws.getString(4));

				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSupplierAddress() --> "
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
	 * To insert the data // incomplete on 28th april, table not exists
	 * 
	 * @param vo
	 */
	public static void insert(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		String[] temp3 = null;
		String[] temp2 = null;
		// String strExistingStock = "";
		String strPoNo = "";
		String strPODate = "";
		String strRate = "";
		// String strRateUnitName="";
		String strRateUnitId = "";
		// String strSuuplierName ="";
		String strRecevDate = "";
		String strSuppId = "";
		String strLstYearQty = "";
		// String strQtyUnitName ="";
		String strQtyUnitId = "";
		DmlIndentDtlImportedItemDAO globalDao = null;

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			String[] temp = vo.getStrApproxRateUnitId().split("\\^");
			String[] temp4 = vo.getStrQtyUnitName().split("\\^");

			globalDao = new DmlIndentDtlImportedItemDAO();

			temp3 = vo.getStrHiddenStockDtl().replace("^", "#").split("#");
			String[] temp1 = temp3[1].replace("@", "#").split("#");
			temp2 = vo.getStrHiddenStockPosition().replace("^", "#").split("#");

			vo.setStrInhandQty(temp1[0]);
			vo.setStrInhandQtyUnit(temp1[1]);

			// strExistingStock =temp[0];

			strPoNo = temp2[0];

			strPODate = temp2[1];

			strRate = temp2[2];

			// strRateUnitName = temp2[3];

			strRateUnitId = temp2[4];

			// strSuuplierName =temp2[5];

			strRecevDate = temp2[6];

			strSuppId = temp2[7];

			strLstYearQty = temp2[8];

			// strQtyUnitName =temp2[9];

			strQtyUnitId = "0";
			/*
			 * vo.setStrApproxRate(formBean.getStrApproxRate());
			 * vo.setStrApproxRateUnitId(formBean.getStrApproxRateUnitId());
			 * vo.setStrQunatityReq(formBean.getStrQunatityReq());
			 * vo.setStrQtyUnitName(formBean.getStrQtyUnitName());
			 */
			globalDao.setStrReqQty(vo.getStrQunatityReq());
			globalDao.setStrReqQtyUnitId(temp4[0]);
			globalDao.setStrOrderQty(vo.getStrQunatityReq());
			globalDao.setStrOrderQtyUnitId(temp[0]);
			globalDao.setStrApproxRate(vo.getStrApproxRate());

			globalDao.setStrId(vo.getStrStoreId());
			globalDao.setHosp_code(vo.getStrHospitalCode());
			globalDao.setReqTypeId(vo.getStrReqType());

			globalDao.setToStrId(vo.getStrToStoreCombo());
			globalDao.setItemcatNo(vo.getStrItemCategoryNo());
			globalDao.setItemTypeId("0");
			globalDao.setUrgentFlag(vo.getStrIsUrgent());
			globalDao.setIndentPeriod("0"); // check

			globalDao.setFinStartDate(vo.getStrFinancialStartYear());
			globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			globalDao.setRemarks(vo.getStrJustification());
			globalDao.setSeatId(vo.getStrSeatId());

			globalDao.setGrantTypeId(vo.getStrGrantTypeCode());
			globalDao.setPuk("0");
			globalDao.setEmpNo("0");
			globalDao.setAdmNo("0");
			globalDao.setEpisodeCode("0");
			globalDao.setConsultantId("0");
			// globalDao.setMemoNo("0");

			globalDao.setTotCost("0");

			globalDao.setStrImpReqNo("0"); // Check
			globalDao.setStrImpReqDate(vo.getStrFinancialStartYear()); // Check
			globalDao.setStrCurrncyId(vo.getStrCurrencyId());
			globalDao.setStrTsInvoiceRecd(vo.getStrPInvoiceRecvd());

			globalDao.setStrInstallationReq("0"); // Check
			globalDao.setStrInstallationReq("0");
			globalDao.setStrWarranty("0");
			globalDao.setStrInstallationChg("0");
			globalDao.setStrQutnInvite("0"); // Check
			globalDao.setStrQutnJustificn(vo.getStrQuotationJustification());
			globalDao.setStrPurpose(vo.getStrOtherPurpose());
			globalDao.setStrJustificn(vo.getStrJustification());
			globalDao.setStrGrpId(vo.getStrGroupId());
			globalDao.setStrSubGrpId(vo.getStrSubGroupId());
			globalDao.setStrItemId(vo.getStrItemId());
			globalDao.setStrItemBrandId(vo.getStrBrandId());
			globalDao.setStrInhandQty(temp1[0]);
			globalDao.setStrInhandQtyUnitId(temp1[1]);
			globalDao.setStrRate(vo.getStrApproxRate());
			globalDao.setStrRateUnitId(temp[0]);

			globalDao.setStrSancQty("0"); // Enter In Procedure
			globalDao.setStrSancQtyUnitId("0"); // Enter In Procedure
			globalDao.setStrLstYearConsump(strLstYearQty);
			globalDao.setStrLstYearConsumpUnitId(strQtyUnitId);
			globalDao.setStrCost("0"); // Enter In Procedure
			globalDao.setStrSupplierId(vo.getStrSupplierId());
			globalDao.setStrLstPoNo(strPoNo);
			globalDao.setStrLstPoDate(strPODate);
			globalDao.setStrLstRecDate(strRecevDate);
			globalDao.setStrReqStatus("0");

			globalDao.setStrLstSupplierId(strSuppId);
			globalDao.setStrLstRate(strRate);
			globalDao.setStrLstRateUnitId(strRateUnitId);

			globalDao.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSupplierAddress() --> "
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
	 * To get Stock Details(existing stock, consumed qty and manufacturer
	 * name)with unit id
	 * 
	 * 
	 * @param vo
	 */
	public static void getStockDtls(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strStockDtl = "";
		String StockDtl = "";
		/*
		 * itemId NUMBER, itemBrandId NUMBER, batchNo NUMBER, stockStatus
		 * NUMBER, strId NUMBER, slNo NUMBER DEFAULT 0,
		 */
		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");
			strFuncName = "{? = call MMS_MST.get_stock_dtl(?::numeric,?::numeric,?::numeric,?::numeric,?,?::numeric,?::numeric,?,?::numeric,?::numeric)}"; // This
																					// Dummy
																					// Function
																					// Plz
																					// Check
																					// It
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "2");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());

			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrBrandId());
			dao.setFuncInValue(nFuncIndex, 6, "0");
			dao.setFuncInValue(nFuncIndex, 7, "0");
			dao.setFuncInValue(nFuncIndex, 8, vo.getStrStoreId());

			/* Setting Default Value Start */
			dao.setFuncInValue(nFuncIndex, 9, "0");
			dao.setFuncInValue(nFuncIndex, 10, "1");
			dao.setFuncInValue(nFuncIndex, 11, "1");
			/* Setting Default Value End */

			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			StockDtl = dao.getFuncString(nFuncIndex);

			if (StockDtl.equals("0") || StockDtl.equals("null")) {
				strStockDtl = 1 + "^" + 2;
			} else {
				strStockDtl = StockDtl;
			}
			vo.setStrStockDtl(strStockDtl);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getStoreName() --> "
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
	 * To get Stock Details(existing stock, consumed qty and manufacturer
	 * name)with unit id
	 * 
	 * 
	 * @param vo
	 */
	public static void getRemainingStockDtls(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strStockDtl = "";
		String StockDtl = "";
		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");
			strFuncName = "{? = call MMS_MST.Get_item_property(?::numeric,?::numeric,?::numeric,?::numeric,?::numeric)}"; // This
																				// Dummy
																				// Function
																				// Plz
																				// Check
																				// It
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "6");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrBrandId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrStoreId());

			dao.setFuncInValue(nFuncIndex, 6, "0");// Default value.

			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			StockDtl = dao.getFuncString(nFuncIndex);

			if (StockDtl.equals("0") || StockDtl.equals("null")) {
				strStockDtl = 1 + "^" + 2;
			} else {
				strStockDtl = StockDtl;
			}
			vo.setStrRemaingStockDtl(strStockDtl);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getRemainingStockDtls() --> "
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
	 * To get SUPPLIER ADDRESS IN THE BASIS OF SELECTED SUPPLIER
	 * 
	 * @param vo
	 */
	public static void getUnitCmb(IndentForImportItemsVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IndentForImportItemsDAO");

			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id", vo.getStrItemUnitId(),2);
			dao.setProcInValue(nProcIndex, "modeval", "1",3);
			dao.setProcInValue(nProcIndex, "module_id", "",4);// Default value.
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				// //System.out.println("ws size" + ws.size());
				vo.setWSApproxRateUnitCmb(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentForImportItemsDAO.getSupplierAddress() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

}
