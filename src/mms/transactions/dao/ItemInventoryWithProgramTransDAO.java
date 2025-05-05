/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransDAO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.SimpleDateFormat;

import mms.transactions.vo.ItemInventoryWithProgramTransVO;

// TODO: Auto-generated Javadoc

/**
 * The Class DrugInventoryWithProgramTransDAO.
 * 
 * @author manish
 * @date Jul 1, 2014
 * @file DrugInventoryWithProgramTransDAO.java
 */
public class ItemInventoryWithProgramTransDAO {

	/**
	 * Inits the add query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void initAddQuery(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrSubGroupComboWs(wb);

			} else {
				throw new Exception(strerr);
			}

			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "sub_group_id", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.initAddQuery() --> "
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
	 * for getting option value of combo on add page (subgroup name ).
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void initAddQuery1(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrSubGroupComboWs(wb);
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.initAddQuery() --> "
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
	 * Phd item combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void phdItemCombo(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "8");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", "0");
			dao.setProcInValue(nprocIndex, "sub_group_id", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("wb"+wb.size());
			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);
				
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.phdItemCombo() --> "
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
	 * Gets the programme combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "4");
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrProgNameComboWS(wb);
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.phdItemCombo() --> "
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
	 * The following procedure is used to populate the value of Item Name combo
	 * using Pkg_Mms_View.proc_storeitem_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item name
	 */

	public static void getItemName(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "sub_group_id",
					vo.getStrSubGroupId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getItemName() --> "
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
	 * The following procedure is used to populate the value of Item Name combo
	 * using Pkg_Mms_View.proc_storeitem_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the dummy item name
	 */

	public static void getDummyItemName(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?, ?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId());
			dao.setProcInValue(nprocIndex, "grpId", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "subGrpId", "0");
			dao.setProcInValue(nprocIndex, "setFlag", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");			

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getDummyItemName() --> "
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
	 * Gets the group name combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void GetGroupNameCombo(ItemInventoryWithProgramTransVO vo) {
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "DrugInventoryTransDAO");
			dao = new HisDAO("mms",
					"DrugInventoryTransDAO.GetGroupNameCombo(ItemInventoryWithProgramTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "item_category",
					vo.getStrItemCategoryNo());
			dao.setProcInValue(procIndex1, "strPhyStockNo", "0");
			dao.setProcInValue(procIndex1, "strStoreId", "0");
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
														// value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "0", "0^Select Value", true);
				vo.setStrGroupNameCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupNameCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.GetGroupNameCombo() --> "
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
	 * The following procedure is used to populate the value of ItemBrand Name
	 * combo using Pkg_Mms_View.proc_itembrand_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item brand name
	 */

	public static void getItemBrandName(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId());
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "sub_group_id", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				vo.setStrItemBrandComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getItemBrandName() --> "
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
	 * Gets the unit list.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the unit list
	 */
	public static void getUnitList(ItemInventoryWithProgramTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			dao = new HisDAO("mms", "global.MmsDAO.getUnitList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "unit_id",vo.getStrInventoryUnitId());
			dao.setProcInValue(procIndex1, "module_id", "0");
			dao.setProcInValue(procIndex1, "modeval", "7"); 
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			//System.out.println("ws"+ws.size());
			vo.setStrUnitListWs(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getUnitList() --> "
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
	 * Gets the group id.
	 * 
	 * @param vo
	 *            the vo
	 * @return the group id
	 */
	public static void getGroupId(ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_groupNameAndId_dtl(?, ?, ?)}";
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);

			vo.setStrGroupId(strRegFlag.split("\\^")[0]);
			vo.setStrGroupName(strRegFlag.split("\\^")[1]);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getGroupId() --> "
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
	 * method name : getItemQCType.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item qc type
	 */

	public static void getItemQCType(ItemInventoryWithProgramTransVO vo) {
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_ItemQc_Type(?, ?, ?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);

			vo.setStrQcTypeFlg(strRegFlag);
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getItemQCType() --> "
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
	 * method name : getBrandDetails.
	 * 
	 * @param vo
	 *            the vo
	 * @return the brand details
	 */
	public static void getBrandDetails(ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_brand_ResFlag(?, ?, ?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);

			vo.setStrRegFlag(strRegFlag);

			String strFuncName2 = "{? = call mms_mst.get_brand_dtl(?, ?, ?)}";

			int nFuncIndex2 = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex2, 2, "1");
			dao.setFuncInValue(nFuncIndex2, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex2, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex2, 1);
			dao.executeFunction(nFuncIndex2);

			String strBrandDetails = dao.getFuncString(nFuncIndex2);

			vo.setStrBrandDetails(strBrandDetails);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getBrandDetails() --> "
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
	 * The following procedure is used to populate the value of Already Existing
	 * Batch in HSTT_DRUG_CURRSTOCK_DTL combo using
	 * Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch in stock
	 */

	public static void getExistingBatchInStock(
			ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;

		try {
			 
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_BatchExist_Flag(?,?,?,?,?,?,?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemBrandId());
			dao.setFuncInValue(nFuncIndex, 6, vo.getStrBatchNo());
			dao.setFuncInValue(nFuncIndex, 7, "");
			dao.setFuncInValue(nFuncIndex, 8, vo.getStrStoreId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String strRegFlag = dao.getFuncString(nFuncIndex);
			vo.setStrBatchExistInStockFlg(strRegFlag);
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchInStock() --> "
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
	 * The following procedure is used to populate the value of Already Existing
	 * Batch in HSTT_DRUG_CURRSTOCK_DTL combo using
	 * Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing supp batch in stock
	 */

	public static void getExistingSuppBatchInStock(
			ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_SuppBatchExist_Flag(?,?,?,?)}"; // 4

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrBatchNo());
			dao.setFuncInValue(nFuncIndex, 5, "");
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String strSuppFlag = dao.getFuncString(nFuncIndex);
			vo.setStrBatchExistSuppBatchInStockFlg(strSuppFlag);

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchInStock() --> "
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
	 * The following procedure is used to populate the value of Already Existing
	 * Batch in HSTT_DRUG_CURRSTOCK_DTL combo using
	 * Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch list
	 */

	public static void getExistingBatchList(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			 
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_existingbatch_list(?,?,?,?,?,?,?)}";

			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "p_modeval", "1");
			dao.setProcInValue(nprocIndex, "p_HSTNUM_STORE_ID",vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_ID",vo.getStrItemId());
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId());
			dao.setProcInValue(nprocIndex, "p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode());
			//dao.setProcInValue(nprocIndex, "p_GNUM_PROGRAMME_ID",vo.getStrProgrammeId());
			//System.out.println("vo.getStrStoreId()"+vo.getStrStoreId());
			//System.out.println("vo.getStrItemId()"+vo.getStrItemId());
			//System.out.println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
			//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			//System.out.println("strerr"+strerr);
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("wb"+wb.size());
			if (strerr.equals("")) {
				vo.setStrExistingBatchComboWS(wb);
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchList() --> "
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
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the supplied by list
	 */

	public static void getSuppliedByList(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());

			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getSuppliedByList() --> "
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
	 * method name : getCurrencyList.
	 * 
	 * @param vo
	 *            the vo
	 * @return the currency list
	 */

	public static void getCurrencyList(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_currency_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "isDefault", "0");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrCurrencyCodeWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getCurrencyList() --> "
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
	 * Gets the stock status list.
	 * 
	 * @param vo
	 *            the vo
	 * @return the stock status list
	 */
	public static void getStockStatusList(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "itemCat", ""); // Aritra
			dao.setProcInValue(nprocIndex, "itemBrandId", "0");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrStockStatusWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getStockStatusList() --> "
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
	 * Gets the manufectute name.
	 * 
	 * @param vo
	 *            the vo
	 * @return the manufectute name
	 */
	public static void getmanufectuteName(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeVal", "2");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", vo.getStrStoreId()); 
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("wb"+wb.size());
			if (strerr.equals("")) {
				vo.setStrManufactureComboWS(wb);
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getmanufectuteName() --> "
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
	 * method name : getSupplierName.
	 * 
	 * @param vo
	 *            the vo
	 * @return the supplier name
	 */

	public static void getSupplierName(ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "contractType", "0"); // Aritra
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setStrSupplierComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getSupplierName() --> "
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
	 * Insert.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void insert(ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";
		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		HisDAO daoObj = null;
		int j = 0, actualQty = 0, freeItemQty = 0, actQtyplusFreeQty = 0, k = 0;
		String[] freeItemDtl = null;
		boolean flag = false;
		try {
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 54
																																												// Variable
			nProcIndex = daoObj.setProcedure(strProcName);
			// Start Logic Here to add Free Item Qty with In-hand Qty if Free
			// Item is in Same Category
			// And Save data into Drug Current Stock Details OtherWise If
			// Different Category then save into
			// Free Item Table [Added By Amit Kr 10-Dec-2010]
			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0) {
				freeItemDtl = new String[vo.getStrItemOtherDtls().length];
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) {

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					if (!strItemOtherVal[0].equals(vo.getStrItemCategoryNo())) {

						freeItemDtl[k] = strItemOtherVal[0] + "^"
								+ strItemOtherVal[1] + "^" + strItemOtherVal[2]
								+ "^" + strItemOtherVal[3] + "^"
								+ strItemOtherVal[4] + "^" + strItemOtherVal[5]
								+ "^" + strItemOtherVal[6];
						k++;

					} else {

						actualQty = Integer.parseInt(vo.getStrInHandQuantity());
						freeItemQty = Integer.parseInt(strItemOtherVal[6]);

						if (j > 0) {
							actQtyplusFreeQty = actQtyplusFreeQty + freeItemQty;
						} else {
							actQtyplusFreeQty = actualQty + freeItemQty;
						}
						j++;
					}
				}
			}// Logic End Here
			Date date = new Date();  
		    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
		    String strDate = formatter.format(date);
			daoObj.setProcInValue(nProcIndex, "modval", "1"); // 1
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId()); // 2
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId()); // 3
			daoObj.setProcInValue(nProcIndex, "itembrandid",
					vo.getStrItemBrandId());// 4
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo()+"~"+strDate); // 5
			daoObj.setProcInValue(nProcIndex, "itemcatno",
					vo.getStrItemCategoryNo()); // 6
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId()); // 7
			daoObj.setProcInValue(nProcIndex, "subgroupid",
					vo.getStrSubGroupId()); // 8
			daoObj.setProcInValue(nProcIndex, "expirydate",
					vo.getStrExpiryDate()); // 9
			daoObj.setProcInValue(nProcIndex, "manufdate",
					vo.getStrManufactureDate()); // 10
			daoObj.setProcInValue(nProcIndex, "stockstatuscode",
					vo.getStrStockStatus()); // 11
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0"); // 12
			daoObj.setProcInValue(nProcIndex, "inhandqty",
					vo.getStrInHandQuantity());// 13
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid",
					vo.getStrInHandQuantityUnitID());// 14
			daoObj.setProcInValue(nProcIndex, "suppid",
					vo.getStrManufactureId()); // 15
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate()); // 16
			daoObj.setProcInValue(nProcIndex, "rateunitid",
					vo.getStrUnitRateID()); // 17
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice()); // 18
			daoObj.setProcInValue(nProcIndex, "salepriceunitid",
					vo.getStrUnitSaleID()); // 19
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo()); // 20
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate()); // 21
			daoObj.setProcInValue(nProcIndex, "suppliedBy",
					vo.getStrSuppliedBy()); // 22
			daoObj.setProcInValue(nProcIndex, "recievedDate",
					vo.getStrReceivedDate()); // 23
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId()); // 24
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode()); // 25
			daoObj.setProcInValue(nProcIndex, "description",
					"Stock Quantity added though Inventory Process"); // 26
			daoObj.setProcInValue(nProcIndex, "currencyCode",
					vo.getStrCurrencyCode()); // 27
			daoObj.setProcInValue(nProcIndex, "currencyValue",
					vo.getStrCurrencyValue()); // 28
			daoObj.setProcInValue(nProcIndex, "item_specification",
					vo.getStrItemSpecification()); // 29
			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0) {
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1"); // 30
			} else {
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0"); // 30
			}

			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrBillNo()); // 31
			daoObj.setProcInValue(nProcIndex, "invoiceDate",
					vo.getStrBillDate()); // 32
			/* Start */
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1"); // 33
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0"); // 34
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0"); // 35
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0"); // 36
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0"); // 37
			daoObj.setProcInValue(nProcIndex, "old_strid", "0"); // 38
			daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0"); // 39
			daoObj.setProcInValue(nProcIndex, "partFlag", "0"); // 40
			daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0"); // 41
			daoObj.setProcInValue(nProcIndex, "toStrId", ""); // 42
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0"); // 43
			daoObj.setProcInValue(nProcIndex, "transNo", "0"); // 44
			daoObj.setProcInValue(nProcIndex, "transDate", ""); // 45
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "58"); // 46
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0"); // 47
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0"); // 48
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0"); // 49
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0"); // 50
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0"); // 51
			daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1"); // 52
			/* End */

			daoObj.setProcOutValue(nProcIndex, "err", 1); // 53
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1); // 54

			daoObj.execute(nProcIndex, 1);
			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) {

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");
					nProcIndex2 = daoObj.setProcedure(strProcName2);
					String strFreeBatch = strItemOtherVal[3];

					if (strFreeBatch == null || strFreeBatch.length() == 0) {
						strFreeBatch = "0";
					}

					daoObj.setProcInValue(nProcIndex2, "modval", "1"); // 1
					daoObj.setProcInValue(nProcIndex2, "itemid",
							vo.getStrItemId()); // 2
					daoObj.setProcInValue(nProcIndex2, "itembrandid",
							vo.getStrItemBrandId()); // 3
					daoObj.setProcInValue(nProcIndex2, "batchno",
							vo.getStrBatchNo()); // 4
					daoObj.setProcInValue(nProcIndex2, "freeitemid",
							strItemOtherVal[1]); // 5
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",
							strItemOtherVal[2]); // 6
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
							strFreeBatch); // 7
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",
							strItemOtherVal[0]); // 8
					daoObj.setProcInValue(nProcIndex2, "expirydate",
							strItemOtherVal[4]); // 9
					daoObj.setProcInValue(nProcIndex2, "manufdate",
							strItemOtherVal[5]); // 10
					daoObj.setProcInValue(nProcIndex2, "qty",
							strItemOtherVal[6]); // 11
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",
							strItemOtherVal[7]); // 12
					daoObj.setProcInValue(nProcIndex2, "hosp_code",
							vo.getStrHospitalCode()); // 13

					/* Start */
					daoObj.setProcInValue(nProcIndex2, "transNo", "0"); // 14
					daoObj.setProcInValue(nProcIndex2, "strId", "0"); // 15
					/* End */

					daoObj.setProcOutValue(nProcIndex2, "err", 1);// 16
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1); // 17

					daoObj.execute(nProcIndex2, 1);

				}

			strProcName3 = "{call PKG_MMS_DML.proc_HSTT_SUPP_CONS_DELVRY_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 26
																																	// Varibale's

			nProcIndex3 = daoObj.setProcedure(strProcName3);
			daoObj.setProcInValue(nProcIndex3, "p_mode", "1"); // 1
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID",
					vo.getStrStoreId()); // 2
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",
					vo.getStrHospitalCode()); // 3
			daoObj.setProcInValue(
					nProcIndex3,
					"p_HSTSTR_PO_NO",
					(vo.getStrPoNo() == null || vo.getStrPoNo().equals("") || vo
							.getStrPoNo().equals("---")) ? "0" : vo
							.getStrPoNo()); // 4
			daoObj.setProcInValue(
					nProcIndex3,
					"p_HSTDT_PO_DATE",
					(vo.getStrPoDate() == null || vo.getStrPoDate().equals("") || vo
							.getStrPoDate().equals("---")) ? "" : vo
							.getStrPoDate()); // 5
			daoObj.setProcInValue(
					nProcIndex3,
					"p_HSTSTR_CHALLAN_NO",
					(vo.getStrBillNo() == null || vo.getStrBillNo().equals("") || vo
							.getStrBillNo().equals("---")) ? "0" : vo
							.getStrBillNo()); // 6
			daoObj.setProcInValue(
					nProcIndex3,
					"p_HSTDT_CHALLAN_DATE",
					(vo.getStrBillDate() == null
							|| vo.getStrBillDate().equals("") || vo
							.getStrBillDate().equals("---")) ? vo
							.getStrReceivedDate() : vo.getStrBillDate()); // 7
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_REQTYPE_ID", "58"); // Drug
																				// Inventory
																				// //8
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",
					vo.getStrSuppliedBy()); // 9
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_GROUP_ID",
					vo.getStrGroupId()); // 10
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",
					vo.getStrItemBrandId()); // 11
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_NO",
					vo.getStrBatchNo()); // 12
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE",
					vo.getStrExpiryDate()); // 13
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECIEVED_QTY",
					vo.getStrInHandQuantity()); // 14
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECQTY_UNITID",
					vo.getStrInHandQuantityUnitID()); // 15
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETURNED_QTY", "0"); // 16
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETQTY_UNITID", ""); // 17
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PURCHASE_RATE",
					vo.getStrRate()); // 18
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ISSUE_RATE",
					vo.getStrSalePrice()); // 19
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",
					vo.getStrUnitRateID()); // 20
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECIEVE_COST", (vo
					.getStrDrugTotCost() == null || vo.getStrDrugTotCost()
					.equals("")) ? "0" : vo.getStrDrugTotCost()); // 21
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETURN_COST", "0"); // 22
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID", "1"); // 23
			daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE", ""); // 24
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",
					vo.getStrSeatId()); // 25
			daoObj.setProcOutValue(nProcIndex3, "err", 1); // 26

			daoObj.execute(nProcIndex3, 1);

			daoObj.fire();
			flag = true;

			if (flag) {
				ItemInventoryWithProgramTransDAO.updateCurrStock(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (vo.getStrMsgString().split("\\##").length > 2 &&  vo.getStrMsgString().split("\\##")[2].equals("998")) {
				vo.setStrMsgString(vo.getStrMsgString().split("\\##")[1]);
				vo.setStrMsgType("5");
			} else {
				vo.setStrMsgString(e.getMessage());
				vo.setStrMsgType("1");
			}
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * method name : getNewSupplierId.
	 * 
	 * @param vo
	 *            the vo
	 * @return the new supplier id
	 */
	public static void getNewSupplierId(ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_supp_id(?,?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, "10");
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);

			vo.setStrQcTypeFlg(strRegFlag);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getNewSupplierId() --> "
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
	 * method name : insertDummy.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void insertDummy(
			ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";
		int nProcIndex = 0;
		String strProcName1 = "";
		int nProcIndex1 = 0;
		HisDAO daoObj = null;
		
		String strFuncName = null;
		String strNewSupplierId = null;
		String strSavedBatchName="", stockStatus="0";
		String batchNumers="";
		try {
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");

			
			
			strProcName = "{call PKG_MMS_DML.dml_item_stock_update_new(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}"; // 22+3 Variable
			strProcName1 = "{call PKG_MMS_DML.dml_Supplier_new_dtls(?,?,?,?,?,?,?,?)}"; // 8 Variable
			if (vo.getStrMultiRowFinalBatchNo() != null && vo.getStrMultiRowFinalBatchNo().length > 0) {
				for (int i = 0; i < vo.getStrMultiRowFinalBatchNo().length; i++) 
				{					
					
					batchNumers=batchNumers+vo.getStrMultiRowFinalBatchNo()[i]+",";

					if ( vo.getStrMultiRowMfgId() != null && !vo.getStrMultiRowMfgId().equals("") && vo.getStrMultiRowMfgId()[i].equals("1")) 
					{
						strFuncName = "{? = call mms_mst.get_supp_id(?,?)}";
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						nProcIndex = daoObj.setProcedure(strProcName);
						if (vo.getStrMultiRowActiveQty()[i].length() > 0 || vo.getStrMultiRowInActiveQty()[i].length() > 0 || vo.getStrMultiRowQuarnQty()[i].length() > 0) {
							
							if(!vo.getStrMultiRowExistingBatchId()[i].equals("0"))
								   stockStatus = vo.getStrMultiRowExistingBatchId()[i].split("\\#")[12];
							
							/*
							 * Genrate Supplier Id for New Supplier
							 */

							int nFuncIndex = daoObj.setFunction(strFuncName);
							daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
							daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrItemCategoryNo());
							daoObj.setFuncOutValue(nFuncIndex, 1);
							daoObj.executeFunction(nFuncIndex);

							strNewSupplierId = daoObj.getFuncString(nFuncIndex);
							/*
							 * Insert New Supplier Details
							 */

							daoObj.setProcInValue(nProcIndex1, "modval", "1",1); // 1
							daoObj.setProcInValue(nProcIndex1, "supplierId",strNewSupplierId,2);// 2
							daoObj.setProcInValue(nProcIndex1, "hospcode",vo.getStrHospitalCode(),3); // 3
							daoObj.setProcInValue(nProcIndex1, "catgNo",vo.getStrItemCategoryNo(),4); // 4
							daoObj.setProcInValue(nProcIndex1, "supplierName",vo.getStrMultiRowMfgName()[i],5); // 5
							daoObj.setProcInValue(nProcIndex1, "storeId",vo.getStrStoreId().split("\\^")[0],6); // 6
							daoObj.setProcInValue(nProcIndex1, "seatId",vo.getStrSeatId(),7); // 7
							daoObj.setProcOutValue(nProcIndex1, "err", 1,8); // 8
							daoObj.execute(nProcIndex1, 1);

							daoObj.setProcInValue(nProcIndex, "modval","1",1); // 1
							daoObj.setProcInValue(nProcIndex, "strId",vo.getStrStoreId().split("\\^")[0],2); // 1
							daoObj.setProcInValue(nProcIndex, "brandId",vo.getStrMultiRowItemId()[0].split("\\^")[0],3);// 2
							daoObj.setProcInValue(nProcIndex, "batchNo",vo.getStrMultiRowFinalBatchNo()[i],4); // 3
							daoObj.setProcInValue(nProcIndex, "expDate",vo.getStrMultiRowExpiryDate()[i],5); // 4
							daoObj.setProcInValue(nProcIndex, "mfgDate",vo.getStrMultiRowMfgDate()[i],6); // 5
							daoObj.setProcInValue(nProcIndex, "manufId",strNewSupplierId,7); // 6
							daoObj.setProcInValue(nProcIndex, "activeQty",vo.getStrMultiRowActiveQty()[i],8); // 7
							daoObj.setProcInValue(nProcIndex, "inactiveQty",vo.getStrMultiRowInActiveQty()[i],9); // 8
							daoObj.setProcInValue(nProcIndex, "quartineQty",vo.getStrMultiRowQuarnQty()[i],10); // 9
							daoObj.setProcInValue(nProcIndex, "seatId",	vo.getStrSeatId(),11); // 10
							daoObj.setProcInValue(nProcIndex, "rate",vo.getStrMultiRowCosttoPat()[i],12); // 11
							daoObj.setProcInValue(nProcIndex, "rateUnitId",	vo.getStrMultiRowRateUnitId()[i].split("\\^")[0],13); // 12
							daoObj.setProcInValue(nProcIndex, "tenderNo","000",14); // 13
							daoObj.setProcInValue(nProcIndex, "poNo",vo.getStrMultiRowPONo()[i],15); // 14
							daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),16); // 15
							daoObj.setProcInValue(nProcIndex, "supplierId",strNewSupplierId,17); // 16
							daoObj.setProcInValue(nProcIndex, "prgid",vo.getStrProgrammeId(),18); // 17
							daoObj.setProcInValue(nProcIndex, "existingbatch",	vo.getStrMultiRowExistingBatchId()[i].split("\\#")[0],19); // 18
							daoObj.setProcInValue(nProcIndex, "existstockstatus", stockStatus,20); // 19
							daoObj.setProcInValue(nProcIndex, "item_cat_no",vo.getStrCatId().split("\\^")[0] ,21); // 20
							daoObj.setProcInValue(nProcIndex, "dcno", vo.getStrMultiRowTenderNo()[i],22);
							daoObj.setProcInValue(nProcIndex, "invoiceno", vo.getStrMultiRowInvoiceNo()[i],23);
							daoObj.setProcInValue(nProcIndex, "invoicedate", vo.getStrMultiRowInvoiceDate()[i],24);
							daoObj.setProcInValue(nProcIndex, "purrate",vo.getStrMultiRowPurRate()[i],25); // 11
							daoObj.setProcInValue(nProcIndex, "handlingcharges",vo.getStrMultiRowHandlingCharges()[i],26); // 11
							daoObj.setProcInValue(nProcIndex, "tax",vo.getStrMultiRowTax()[i],27); // 11
							daoObj.setProcInValue(nProcIndex, "invFlag",vo.getStrMultiRowFlag()[i],28);
							daoObj.setProcOutValue(nProcIndex, "err", 1,29);
							daoObj.execute(nProcIndex, 1);
						}

					}
					else 
					{
						System.out.println("----------PKG_MMS_DML.dml_item_stock_update_new-[ Mode - 1 ]------------");
						nProcIndex = daoObj.setProcedure(strProcName);
						if (vo.getStrMultiRowActiveQty()[i].length() > 0 || vo.getStrMultiRowInActiveQty()[i].length() > 0	|| vo.getStrMultiRowQuarnQty()[i].length() > 0) {
							if(vo.getStrMultiRowExistingBatchId()[i] != null)
							if(!vo.getStrMultiRowExistingBatchId()[i].equals("0"))
								   stockStatus = vo.getStrMultiRowExistingBatchId()[i].split("\\#")[12];
							
							daoObj.setProcInValue(nProcIndex, "modval",			"1",1); // 1
							daoObj.setProcInValue(nProcIndex, "strId",			vo.getStrStoreId().split("\\^")[0],2); // 1
							daoObj.setProcInValue(nProcIndex, "brandId",		vo.getStrMultiRowItemId()[0].split("\\^")[0],3);// 2
							daoObj.setProcInValue(nProcIndex, "batchNo",		vo.getStrMultiRowFinalBatchNo()[i],4); // 3
							daoObj.setProcInValue(nProcIndex, "expDate",		vo.getStrMultiRowExpiryDate()[i],5); // 4
							daoObj.setProcInValue(nProcIndex, "mfgDate",		vo.getStrMultiRowMfgDate()[i],6); // 5
							daoObj.setProcInValue(nProcIndex, "manufId",		vo.getStrMultiRowMfgId()[i],7); // 6
							daoObj.setProcInValue(nProcIndex, "activeQty",		vo.getStrMultiRowActiveQty()[i],8); // 7
							daoObj.setProcInValue(nProcIndex, "inactiveQty",	vo.getStrMultiRowInActiveQty()[i],9); // 8
							daoObj.setProcInValue(nProcIndex, "quartineQty",	vo.getStrMultiRowQuarnQty()[i],10); // 9
							daoObj.setProcInValue(nProcIndex, "seatId",			vo.getStrSeatId(),11); // 10
							daoObj.setProcInValue(nProcIndex, "rate",			vo.getStrMultiRowCosttoPat()[i],12); // 12
							daoObj.setProcInValue(nProcIndex, "rateUnitId",		vo.getStrMultiRowRateUnitId()[i].split("\\^")[0],13); // 13
							daoObj.setProcInValue(nProcIndex, "tenderNo",		"00",14); // 15
							daoObj.setProcInValue(nProcIndex, "poNo",			vo.getStrMultiRowPONo()[i],15); // 16
							daoObj.setProcInValue(nProcIndex, "hosp_code",		vo.getStrHospitalCode(),16); // 17
							daoObj.setProcInValue(nProcIndex, "supplierId",		vo.getStrMultiRowMfgId()[i],17); // 18
							daoObj.setProcInValue(nProcIndex, "prgid",			"000",18); // 17
							daoObj.setProcInValue(nProcIndex, "existingbatch",	vo.getStrMultiRowExistingBatchId()[i].split("\\#")[0],19); // 18
							daoObj.setProcInValue(nProcIndex, "existstockstatus", stockStatus,20); // 19	
							daoObj.setProcInValue(nProcIndex, "item_cat_no",	vo.getStrCatId().split("\\^")[0] ,21); // 20
							daoObj.setProcInValue(nProcIndex, "dcno", 			vo.getStrMultiRowTenderNo()[i],22);
							daoObj.setProcInValue(nProcIndex, "invoiceno", 		vo.getStrMultiRowInvoiceNo()[i],23);
							daoObj.setProcInValue(nProcIndex, "invoicedate", 	vo.getStrMultiRowInvoiceDate()[i],24);
							daoObj.setProcInValue(nProcIndex, "purrate",		vo.getStrMultiRowPurRate()[i],25); // 11
							daoObj.setProcInValue(nProcIndex, "handlingcharges",vo.getStrMultiRowHandlingCharges()[i],26); // 11
							daoObj.setProcInValue(nProcIndex, "tax",			vo.getStrMultiRowTax()[i],27); // 11
							daoObj.setProcInValue(nProcIndex, "invFlag",		vo.getStrMultiRowFlag()[i],28);
							daoObj.setProcOutValue(nProcIndex, "err", 			1,29);
							daoObj.execute(nProcIndex, 1);
						}

					}
					
					if(strSavedBatchName.equals("")){
						strSavedBatchName = vo.getStrMultiRowFinalBatchNo()[i];
					}
					else {
						strSavedBatchName = strSavedBatchName+","+vo.getStrMultiRowFinalBatchNo()[i];
					}
				}

				// DAO Fire Here
				daoObj.fire();
				vo.setStrSavedBatchName(strSavedBatchName);
				
				vo.setTotalBatchNumber(batchNumers.substring(0,batchNumers.length()-1));
				vo.setStrItemBrandId(vo.getStrMultiRowItemId()[0].split("\\^")[0]);
				vo.setStrStoreId(vo.getStrStoreId().split("\\^")[0]);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public synchronized static void updateRecord(
			ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";
		int nProcIndex = 0;
		String strProcName1 = "";
		int nProcIndex1 = 0;
		HisDAO daoObj = null;
		
		String strFuncName = null;
		String strNewSupplierId = null;
		String strSavedBatchName="", stockStatus="0";
		String strCmbNames =vo.getStrStoreId();
		//System.out.println("strCmbNames"+strCmbNames);
		String[] temp = strCmbNames.replace("^", "#").split("#");
		
		try {
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");

			strProcName = "{call PKG_MMS_DML.dml_item_stock_update(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,? ,?,?,?,?)}"; // 22 Variable
			strProcName1 = "{call PKG_MMS_DML.dml_Supplier_new_dtls(?,?,?,?,?,?,?,?)}"; // 8 Variable
			if (vo.getStrMultiRowFinalBatchNo() != null && vo.getStrMultiRowFinalBatchNo().length > 0) {
				for (int i = 0; i < vo.getStrMultiRowFinalBatchNo().length; i++) {					

					if (vo.getStrMultiRowMfgId()[i].equals("1")) {
						strFuncName = "{? = call mms_mst.get_supp_id(?,?)}";
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						nProcIndex = daoObj.setProcedure(strProcName);
						if (!vo.getStrMultiRowActiveQty()[i].equals("") || !vo.getStrMultiRowInActiveQty()[i].equals("") || !vo.getStrMultiRowQuarnQty()[i].equals("")) {
							
							if(!vo.getStrMultiRowExistingBatchId()[i].equals("0"))
								   stockStatus = vo.getStrMultiRowExistingBatchId()[i].split("\\#")[13];
								
							
							/*
							 * Genrate Supplier Id for New Supplier
							 */

							int nFuncIndex = daoObj.setFunction(strFuncName);
							daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
							daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrItemCategoryNo());
							daoObj.setFuncOutValue(nFuncIndex, 1);
							daoObj.executeFunction(nFuncIndex);

							strNewSupplierId = daoObj.getFuncString(nFuncIndex);
							/*
							 * Insert New Supplier Details
							 */

							daoObj.setProcInValue(nProcIndex1, "modval", "1",1); // 1
							daoObj.setProcInValue(nProcIndex1, "supplierId",strNewSupplierId,2);// 2
							daoObj.setProcInValue(nProcIndex1, "hospcode",vo.getStrHospitalCode(),3); // 3
							daoObj.setProcInValue(nProcIndex1, "catgNo",vo.getStrItemCategoryNo(),4); // 4
							daoObj.setProcInValue(nProcIndex1, "supplierName",vo.getStrMultiRowMfgName()[i],5); // 5
							daoObj.setProcInValue(nProcIndex1, "storeId",vo.getStrStoreId(),6); // 6
							daoObj.setProcInValue(nProcIndex1, "seatId",vo.getStrSeatId(),7); // 7
							daoObj.setProcOutValue(nProcIndex1, "err", 1,8); // 8
							daoObj.execute(nProcIndex1, 1);

							daoObj.setProcInValue(nProcIndex, "modval","2",1); // 1
							daoObj.setProcInValue(nProcIndex, "strId",vo.getStrStoreId(),2); // 1
							daoObj.setProcInValue(nProcIndex, "brandId",vo.getStrMultiRowItemId()[0].split("\\^")[0],3);// 2
							daoObj.setProcInValue(nProcIndex, "batchNo",vo.getStrMultiRowFinalBatchNo()[i],4); // 3
							daoObj.setProcInValue(nProcIndex, "expDate",vo.getStrMultiRowExpiryDate()[i],5); // 4
							daoObj.setProcInValue(nProcIndex, "mfgDate",vo.getStrMultiRowMfgDate()[i],6); // 5
							daoObj.setProcInValue(nProcIndex, "manufId",strNewSupplierId,7); // 6
							daoObj.setProcInValue(nProcIndex, "activeQty",vo.getStrMultiRowActiveQty()[i],8); // 7
							daoObj.setProcInValue(nProcIndex, "inactiveQty",vo.getStrMultiRowInActiveQty()[i],9); // 8
							daoObj.setProcInValue(nProcIndex, "quartineQty",vo.getStrMultiRowQuarnQty()[i],10); // 9
							daoObj.setProcInValue(nProcIndex, "seatId",	vo.getStrSeatId(),11); // 10
							daoObj.setProcInValue(nProcIndex, "rate",vo.getStrMultiRowRate()[i],12); // 11
							daoObj.setProcInValue(nProcIndex, "rateUnitId",	vo.getStrMultiRowRateUnitId()[i].split("\\^")[0],13); // 12
							daoObj.setProcInValue(nProcIndex, "tenderNo",vo.getStrMultiRowTenderNo()[i],14); // 13
							daoObj.setProcInValue(nProcIndex, "poNo",vo.getStrMultiRowPONo()[i],15); // 14
							daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),16); // 15
							daoObj.setProcInValue(nProcIndex, "supplierId",strNewSupplierId,17); // 16
							daoObj.setProcInValue(nProcIndex, "prgid",vo.getStrProgrammeId(),18); // 17
							daoObj.setProcInValue(nProcIndex, "existingbatch",	vo.getStrMultiRowExistingBatchId()[i].split("\\#")[0],19); // 18
							daoObj.setProcInValue(nProcIndex, "existstockstatus", stockStatus,20); // 19
							daoObj.setProcInValue(nProcIndex, "item_cat_no", vo.getStrItemCategoryNo(),21); // 19
							daoObj.setProcInValue(nProcIndex, "dcno", vo.getStrMultiRowTenderNo()[i],22);
							daoObj.setProcInValue(nProcIndex, "invoiceno", vo.getStrMultiRowInvoiceNo()[i],23);
							daoObj.setProcInValue(nProcIndex, "invoicedate", vo.getStrMultiRowInvoiceDate()[i],24);
							daoObj.setProcOutValue(nProcIndex, "err", 1,25);
							daoObj.execute(nProcIndex, 1);
						}

					} else {
						nProcIndex = daoObj.setProcedure(strProcName);
						if (!vo.getStrMultiRowActiveQty()[i].equals("") || !vo.getStrMultiRowInActiveQty()[i].equals("") || !vo.getStrMultiRowQuarnQty()[i].equals("")) {

							if(!vo.getStrMultiRowExistingBatchId()[i].equals("0"))
								   stockStatus = vo.getStrMultiRowExistingBatchId()[i].split("\\#")[13];
									//System.out.println("stock status"+vo.getStrMultiRowExistingBatchId()[i].split("\\#")[13]);
							
							daoObj.setProcInValue(nProcIndex, "modval","2",1); // 1
							daoObj.setProcInValue(nProcIndex, "strId",vo.getStrStoreId(),2); // 1
							daoObj.setProcInValue(nProcIndex,"brandId",vo.getStrMultiRowItemId()[0].split("\\^")[0],3);// 2
							daoObj.setProcInValue(nProcIndex, "batchNo",vo.getStrMultiRowFinalBatchNo()[i],4); // 3
							daoObj.setProcInValue(nProcIndex, "expDate",vo.getStrMultiRowExpiryDate()[i],5); // 4
							daoObj.setProcInValue(nProcIndex, "mfgDate",vo.getStrMultiRowMfgDate()[i],6); // 5
							daoObj.setProcInValue(nProcIndex, "manufId",vo.getStrMultiRowMfgId()[i],7); // 6
							daoObj.setProcInValue(nProcIndex, "activeQty",vo.getStrMultiRowActiveQty()[i],8); // 7
							daoObj.setProcInValue(nProcIndex, "inactiveQty",vo.getStrMultiRowInActiveQty()[i],9); // 8
							daoObj.setProcInValue(nProcIndex, "quartineQty",vo.getStrMultiRowQuarnQty()[i],10); // 9
							daoObj.setProcInValue(nProcIndex, "seatId",	vo.getStrSeatId(),11); // 10
							daoObj.setProcInValue(nProcIndex, "rate",vo.getStrMultiRowRate()[i],12); // 12
							daoObj.setProcInValue(nProcIndex, "rateUnitId",	vo.getStrMultiRowRateUnitId()[i].split("\\^")[0],13); // 13
							daoObj.setProcInValue(nProcIndex, "tenderNo",vo.getStrMultiRowTenderNo()[i],14); // 15
							daoObj.setProcInValue(nProcIndex, "poNo",vo.getStrMultiRowPONo()[i],15); // 16
							daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),16); // 17
							daoObj.setProcInValue(nProcIndex, "supplierId",	vo.getStrMultiRowMfgId()[i],17); // 18
							daoObj.setProcInValue(nProcIndex, "prgid",	"000",18); // 17
							daoObj.setProcInValue(nProcIndex, "existingbatch",	vo.getStrMultiRowExistingBatchId()[i].split("\\#")[0],19); // 18
							daoObj.setProcInValue(nProcIndex, "existstockstatus", stockStatus,20); // 19
							daoObj.setProcInValue(nProcIndex, "item_cat_no", vo.getStrItemCategoryNo(),21);
							daoObj.setProcInValue(nProcIndex, "dcno", vo.getStrMultiRowTenderNo()[i],22);
							daoObj.setProcInValue(nProcIndex, "invoiceno", vo.getStrMultiRowInvoiceNo()[i],23);
							daoObj.setProcInValue(nProcIndex, "invoicedate", vo.getStrMultiRowInvoiceDate()[i],24);
							daoObj.setProcOutValue(nProcIndex, "err", 1,25);
							daoObj.execute(nProcIndex, 1);
						}

					}
					
					if(strSavedBatchName.equals("")){
						strSavedBatchName = vo.getStrMultiRowFinalBatchNo()[i];
					}
					else {
						strSavedBatchName = strSavedBatchName+","+vo.getStrMultiRowFinalBatchNo()[i];
					}
				}

				// DAO Fire Here
				daoObj.fire();
				vo.setStrSavedBatchName(strSavedBatchName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * method name : updateCurrStock.
	 * 
	 * @param vo
	 *            the vo
	 */

	public synchronized static void updateCurrStock(
			ItemInventoryWithProgramTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?,?,?,?,?,?,?)}"; // 11
																								// variables

			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modval", "1"); // 1
			dao.setProcInValue(nprocIndex, "strid", vo.getStrStoreId()); // 2
			dao.setProcInValue(nprocIndex, "itemid", vo.getStrItemId()); // 3
			dao.setProcInValue(nprocIndex, "itembrandid",
					vo.getStrItemBrandId());// 4
			dao.setProcInValue(nprocIndex, "batchno", vo.getStrBatchNo()); // 5
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode()); // 6
			dao.setProcInValue(nprocIndex, "item_cat_no",
					vo.getStrItemCategoryNo());// 7
			dao.setProcInValue(nprocIndex, "stockstatuscode", "10"); // 8
			dao.setProcInValue(nprocIndex, "rackNumber", vo.getStrRackNumber());// 9
			dao.setProcInValue(nprocIndex, "old_itemserialno", "0");// 10
			dao.setProcOutValue(nprocIndex, "err", 1);// 11
			dao.executeProcedure(nprocIndex);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.updateCurrStock() --> "
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
	 * retrieves and executes modify.
	 * 
	 * @param vo
	 *            the vo
	 */

	public synchronized static void modifyRecord(
			ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";
		int nProcIndex = 0;
		HisDAO daoObj = null;
		WebRowSet web = null;

		try {
			 
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_hstt_drug_currstock_view(?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itembrand_id",
					vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "batch_no", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "stockStatus",
					vo.getStrStockStatus());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			/*
			 * synchronized (daoObj) { daoObj.fire(); }
			 */
			web = daoObj.getWebRowSet(nProcIndex, "resultset");
			while (web.next()) {
				vo.setStrStoreName(web.getString(1));
				vo.setStrGroupName(web.getString(2));
				vo.setStrSubGroupName(web.getString(3));
				vo.setStrItemName(web.getString(4));
				vo.setStrItemBrandName(web.getString(5));
				vo.setStrManufactureName(web.getString(6));
				vo.setStrBatchNo(web.getString(7));
				vo.setStrExpiryDate(web.getString(8));
				vo.setStrManufactureDate(web.getString(9));
				vo.setStrInHandQuantity(web.getString(10));
				vo.setStrInHandQuantityUnitName(web.getString(11));
				vo.setStrInHandQuantityUnitID(web.getString(12));
				vo.setStrRate(web.getString(13));
				vo.setStrUnitRateName(web.getString(14));
				vo.setStrUnitRateID(web.getString(15));				
				vo.setStrSalePrice(web.getString(16));
				vo.setStrUnitNameSale(web.getString(17));
				vo.setStrUnitSaleID(web.getString(18));
				vo.setStrPoNo(web.getString(19));
				vo.setStrPoDate(web.getString(20));
				vo.setStrSuppliedBy(web.getString(21));
				vo.setStrReceivedDate(web.getString(22));
				vo.setStrCurrencyCode(web.getString(23));
				vo.setStrCurrencyValue(web.getString(24));
				vo.setStrBillNo(web.getString(25));
				vo.setStrBillDate(web.getString(26));
				vo.setStrItemSpecification(web.getString(27));
				vo.setStrManufactureId(web.getString("manufacturer_id"));
				vo.setStrRackNumber(web.getString(29));
			}

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.modifyRecord() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * retrieves and executes update.
	 * 
	 * @param vo
	 *            the vo
	 */

	public synchronized static void update(ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";

		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		boolean flag = false;

		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			Date date = new Date();  
		    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
		    String strDate = formatter.format(date);
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid",
					vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "old_strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "old_itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "old_itembrandid",
					vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode",
					vo.getStrOldStockStatus());
			daoObj.setProcInValue(nProcIndex, "old_batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo()+"~"+strDate);
			daoObj.setProcInValue(nProcIndex, "itemcatno",
					vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "expirydate",
					vo.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "manufdate",
					vo.getStrManufactureDate());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode",
					vo.getStrStockStatus());
			daoObj.setProcInValue(nProcIndex, "inhandqty",
					vo.getStrInHandQuantity());
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid",
					vo.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "suppid",
					vo.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate());
			daoObj.setProcInValue(nProcIndex, "rateunitid",
					vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice());
			daoObj.setProcInValue(nProcIndex, "salepriceunitid",
					vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "suppliedBy",
					vo.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate",
					vo.getStrReceivedDate());
			daoObj.setProcInValue(nProcIndex, "description",
					"Stock Qty Modified through Inventory Process");
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "currencyCode",
					vo.getStrCurrencyCode());
			daoObj.setProcInValue(nProcIndex, "currencyValue",
					vo.getStrCurrencyValue());

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0");
			}
			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrBillNo());
			daoObj.setProcInValue(nProcIndex, "invoiceDate",
					vo.getStrBillDate());
			daoObj.setProcInValue(nProcIndex, "item_specification",
					vo.getStrItemSpecification());

			/* Start */
			daoObj.setProcInValue(nProcIndex, "groupid", "");
			daoObj.setProcInValue(nProcIndex, "subgroupid", "0");
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "");
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0");
			daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
			daoObj.setProcInValue(nProcIndex, "partFlag", "0");
			daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
			daoObj.setProcInValue(nProcIndex, "toStrId", "");
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0");
			daoObj.setProcInValue(nProcIndex, "transNo", "0");
			daoObj.setProcInValue(nProcIndex, "transDate", "");
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "0");
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0");
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0");
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0");
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0");
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0");
			daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1");
			/* End */

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);

			daoObj.execute(nProcIndex, 1);

			strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex3 = daoObj.setProcedure(strProcName3);

			daoObj.setProcInValue(nProcIndex3, "modval", "2");
			daoObj.setProcInValue(nProcIndex3, "itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex3, "itembrandid",
					vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex3, "batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex3, "hosp_code",
					vo.getStrHospitalCode());

			/* Start */
			daoObj.setProcInValue(nProcIndex3, "freeitemid", "");
			daoObj.setProcInValue(nProcIndex3, "freeitembrandid", "");
			daoObj.setProcInValue(nProcIndex3, "freeitembatchno", "0");
			daoObj.setProcInValue(nProcIndex3, "freeitemcatno", "1");
			daoObj.setProcInValue(nProcIndex3, "expirydate", "");
			daoObj.setProcInValue(nProcIndex3, "manufdate", "");
			daoObj.setProcInValue(nProcIndex3, "qty", "0");
			daoObj.setProcInValue(nProcIndex3, "qtyunitid", "");
			daoObj.setProcInValue(nProcIndex3, "transNo", "0");
			daoObj.setProcInValue(nProcIndex3, "strId", "0");
			/* End */

			daoObj.setProcOutValue(nProcIndex3, "err", 1);
			daoObj.setProcOutValue(nProcIndex3, "dml_count", 1);

			daoObj.execute(nProcIndex3, 1);

			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) {

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					daoObj.setProcInValue(nProcIndex2, "modval", "1");
					daoObj.setProcInValue(nProcIndex2, "itemid",
							vo.getStrItemId());
					daoObj.setProcInValue(nProcIndex2, "itembrandid",
							vo.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex2, "batchno",
							vo.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex2, "freeitemid",
							strItemOtherVal[1]);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",
							strItemOtherVal[2]);
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
							strItemOtherVal[3]);
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",
							strItemOtherVal[0]);
					daoObj.setProcInValue(nProcIndex2, "expirydate",
							strItemOtherVal[4]);
					daoObj.setProcInValue(nProcIndex2, "manufdate",
							strItemOtherVal[5]);
					daoObj.setProcInValue(nProcIndex2, "qty",
							strItemOtherVal[6]);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",
							strItemOtherVal[7]);
					daoObj.setProcInValue(nProcIndex2, "hosp_code",
							vo.getStrHospitalCode());

					/* Start */
					daoObj.setProcInValue(nProcIndex2, "transNo", "0");
					daoObj.setProcInValue(nProcIndex2, "strId", "0");
					/* End */

					daoObj.setProcOutValue(nProcIndex2, "err", 1);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1);

					daoObj.execute(nProcIndex2, 1);

				}

			daoObj.fire();
			flag = true;

			if (flag) {
				ItemInventoryWithProgramTransDAO.updateCurrStock(vo);
			}

			vo.setBExistStatus(true);

		} catch (Exception e) {
			vo.setBExistStatus(false);
			vo.setStrMsgString("DrugInventoryTransDAO.update() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * The following procedure is used to populate the value of Unit Name combo
	 * using Pkg_Mms_View.Proc_Gblt_Unit_Mst procedure.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void unitNameCombo(ItemInventoryWithProgramTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?, ?, ?, ?)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());

			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strUnitRate = daoObj.getFuncString(nFuncIndex);
			vo.setStrUnitRateID(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "module_id", "0");// Aritra
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrUnitRateComboWS(ws);
				

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Unit sale name combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void unitSaleNameCombo(ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "module_id", "0");// Aritra
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitSaleComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTrans.unitSaleNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Unit rate name combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void unitRateNameCombo(ItemInventoryWithProgramTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "module_id", "0");// Aritra
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitRateComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTrans.unitRateNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Unit in hand name combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void unitInHandNameCombo(ItemInventoryWithProgramTransVO vo) {
	
		String strProcName = "";
	
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
	
		try {
	
			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
	
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";
	
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id",
					vo.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "module_id", "0");// Aritra
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
	
				vo.setStrUnitNameComboWS(ws);
	
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTrans.unitInHandNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the stock modify value.
	 * 
	 * @param vo
	 *            the vo
	 * @return the stock modify value
	 */
	public static void getStockModifyValue(ItemInventoryWithProgramTransVO vo) {
		String strFuncName = "";

		int nFuncIndex = 0;

		HisDAO daoObj = null;
		String strModify = "";

		try {
			  

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			strFuncName = "{? = call Mms_Mst.get_StockModify_Dtls(?, ?, ?, ?, ?, ?, ?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, "1");
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 5, "0");
			daoObj.setFuncInValue(nFuncIndex, 6, vo.getStrBatchNo());
			daoObj.setFuncInValue(nFuncIndex, 7, vo.getStrItemId());
			daoObj.setFuncInValue(nFuncIndex, 8, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strModify = daoObj.getFuncString(nFuncIndex);

			vo.setStrModifyValue(strModify);

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTrans.getStockModifyValue() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * method name : getDwhType.
	 * 
	 * @param vo
	 *            the vo
	 * @return the brand details
	 */
	public static void getStoreType(ItemInventoryWithProgramTransVO vo) {

		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_store_type_flg(?, ?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());			
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String strStoreTypeFlag = dao.getFuncString(nFuncIndex);
			vo.setStrStoreTypeFlag(strStoreTypeFlag);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getStoreType() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getItemDtls(ItemInventoryWithProgramTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.proc_added_item_dtl(?,?,?,?,?,?,?)}"; //7
		try 
		{
			
			dao = new HisDAO("mms","global.IssueTransDAO.getItemDtls(IssueTransVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			
			//System.out.println("vo.getTotalBatchNumber()-------"+vo.getTotalBatchNumber());
			//System.out.println("vo.getStrItemBrandId()---------"+vo.getStrItemBrandId());
			
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			
			dao.setProcInValue(procIndex1, "batchno", vo.getTotalBatchNumber(),2);
			
			dao.setProcInValue(procIndex1, "itembrandid", vo.getStrItemBrandId(),3);
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),4);
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),5);
			dao.setProcOutValue(procIndex1,"ERR", 1,6); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsItemDetails(ws);
		 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
}
