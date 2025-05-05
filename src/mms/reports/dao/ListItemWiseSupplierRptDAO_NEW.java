/**
 * 
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.ListItemWiseSupplierRptVO;
import mms.reports.vo.ListItemWiseSupplierRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptDAO.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptDAO_NEW {

	/**
	 * for getting option value of Item Category Name on page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void itemCategoryName(ListItemWiseSupplierRptVO_NEW vo) {
		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			daoObj.setProcInValue(nProcIndex, "storeId", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws"+ws.size());
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.itemCategoryName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Group Name on page.
	 * 
	 * @param vo
	 *            the vo
	 */
	
	
	public static void groupName(ListItemWiseSupplierRptVO_NEW vo) {
		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			daoObj.setProcInValue(nProcIndex, "item_category",vo.getStrItemCategoryNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws"+ws.size());
			if (strErr.equals("")) {
				vo.setGroupIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.groupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
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

	public static void getSuppliedByList(ListItemWiseSupplierRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ListItemWiseSupplierRptDAO");
			//
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", "100");

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
			e.printStackTrace();
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.getSuppliedByList() --> "
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
	 * for getting option value of SubGroup Name on page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void subGroupName(ListItemWiseSupplierRptVO_NEW vo) {
		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_subgroup_list(?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			daoObj.setProcInValue(nProcIndex, "groupId", vo.getStrGroupId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws size of sub group"+ws.size());
			if (strErr.equals("")) {
				vo.setSubGroupIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.subGroupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Generic Item Name on page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void ItemName(ListItemWiseSupplierRptVO_NEW vo) {
		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "catCode",vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgrpid", (vo.getStrSubGroupId() == null || vo.getStrSubGroupId().equals("")) ? "0" : vo.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			//daoObj.setProcInValue(nProcIndex, "drug_class", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws item name "+ws.size());
			if (strErr.equals("")) {
				vo.setItemIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.ItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Generic Item Name on page.
	 * 
	 * @param vo
	 *            the vo
	 * @return the drug code cmb
	 */
	public static void getDrugCodeCmb(ListItemWiseSupplierRptVO_NEW vo) {
		String strProcName = "{call Pkg_Mms_Rpt.rptm_itemCode_list(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "catCode",vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgrpid", (vo.getStrSubGroupId() == null || vo.getStrSubGroupId().equals("")) ? "0" : vo.getStrSubGroupId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setDrugCodeWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.getDrugCodeCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * The following procedure is used to populate the value of Contract Type
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the contract type list
	 */

	public static void getContractTypeList(ListItemWiseSupplierRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ListItemWiseSupplierRptDAO");
			//
			strproc_name = "{call PKG_MMS_VIEW.proc_rate_contracttype_mst_cmb(?,?,?,?)}"; // Total
																							// 4
																							// var
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "p_mode", "1");
			dao.setProcInValue(nprocIndex, "p_gnum_hospital_code",
					vo.getStrHospitalCode());

			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				
				vo.setStrContractTypeWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.getContractTypeList() --> "
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
