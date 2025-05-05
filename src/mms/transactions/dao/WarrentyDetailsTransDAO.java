package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;


import mms.dao.WarrentyDetailsDAO;
import mms.transactions.vo.WarrentyDetailsTransVO;

public class WarrentyDetailsTransDAO {
	/**
	 * for getting option value of Manufacturer Name and Item Catagory combos 
	 * 
	 * @param vo
	 * 
	 */
	public static void getInitialValues(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		int nprocIndex;
		String proc_name = "";
		WebRowSet wb = null;
		String strErr="";
		
		try {
			dao = new HisDAO("mms", "WarrentyDetailsTransDAO");

			proc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "catCode", "0");
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			/* Setting Default Value End */
			
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			dao.executeProcedure(nprocIndex);
			
			strErr=dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			wb=dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setStrManufacturerNameComboValuesWS(wb);

			} else {
				throw new Exception(strErr);
			}
		
				
		
			proc_name = "{call pkg_mms_view.PROC_SSTT_ITEM_CATEGORY_MST(?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "mode_val", "2");
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			dao.setProcOutValue(nprocIndex, "Err", 1);
			dao.setProcOutValue(nprocIndex, "Resultset", 2);
			
			dao.executeProcedure(nprocIndex);
			strErr=dao.getString(nprocIndex, "Err");
			if (strErr == null)
				strErr = "";
			wb=dao.getWebRowSet(nprocIndex, "Resultset");
			
			if (strErr.equals("")) {
				vo.setStrItemCategoryComboValuesWS(wb);
			

			} else {
				throw new Exception(strErr);
			}
			
			
			

		} catch (Exception e) {
			
			vo.setStrMsgString("-->WarrentyDetailsTransDAO.getInitialValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb=null;
		}
	}
	/** To get option value of Group Name combo 
	 * @param vo
	 */
	public static void getGroupNameCombo(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		
		WebRowSet wb = null;
		
		int nprocIndex;
		String proc_name = "";
		
		String strErr="";
		
			
			try {
				dao = new HisDAO("mms", "WarrentyDetailsTransDAO");

				proc_name = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(proc_name);

				dao.setProcInValue(nprocIndex, "modeval", "3");
				dao.setProcInValue(nprocIndex, "item_category", vo.getStrItemCategoryID());
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				
				/* Setting Default Value Start*/
				dao.setProcInValue(nprocIndex, "strPhyStockNo", "");
				dao.setProcInValue(nprocIndex, "strStoreId", "");
				/* Setting Default Value End */
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				
				dao.executeProcedure(nprocIndex);
				
				strErr=dao.getString(nprocIndex, "err");
				if (strErr == null)
					strErr = "";
				wb=dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strErr.equals("")) {
					vo.setStrGroupNameComboValuesWS(wb);

				} else {
					throw new Exception(strErr);
				}
			
			
			

		} catch (Exception e) {
			vo.setStrMsgString(" --> WarrentyDetailsTransDAO.getGroupNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao!=null){
			dao.free();
			dao = null;}
			wb=null;
		}

	}
	/** To get option value of Sub Group Name combo 
	 * @param vo
	 */
	public static void getSubGroupNameCombo(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		
		WebRowSet wb = null;
		
		int nprocIndex;
		String proc_name = "";
		
		String strErr="";
		
			
			try {
				dao = new HisDAO("mms", "WarrentyDetailsTransDAO");

				proc_name = "{call pkg_mms_view.proc_store_subgroup_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(proc_name);

				dao.setProcInValue(nprocIndex, "modeval", "1");
				dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupID());
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				
				dao.executeProcedure(nprocIndex);
				
				strErr=dao.getString(nprocIndex, "err");
				if (strErr == null)
					strErr = "";
				wb=dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strErr.equals("")) {
					vo.setStrSubGroupNameComboValuesWS(wb);

				} else {
					throw new Exception(strErr);
				}
			
			
			

		} catch (Exception e) {
			vo.setStrMsgString(" --> WarrentyDetailsTransDAO.getSubGroupNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao!=null){
			dao.free();
			dao = null;}
			wb=null;
		}

	}
	/** To get option value of Item Name combo 
	 * @param vo
	 */
	public static void getItemNameCombo(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		
		WebRowSet wb = null;
		
		int nprocIndex;
		String proc_name = "";
		
		String strErr="";
		String strSubGroupId="";
			
			try {
				
				dao = new HisDAO("mms", "WarrentyDetailsTransDAO");

				proc_name = "{call pkg_mms_view.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(proc_name);
				
				strSubGroupId=vo.getStrSubGroupID();
				
				if(strSubGroupId.equals("")){
				
				dao.setProcInValue(nprocIndex, "modeval", "2");
				dao.setProcInValue(nprocIndex, "group_id",vo.getStrGroupID());
				dao.setProcInValue(nprocIndex, "sub_group_id", "0"); //default
				}else{
					
					dao.setProcInValue(nprocIndex, "modeval", "3");
					dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupID());
					dao.setProcInValue(nprocIndex, "group_id","0"); //default
				}
				
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				
				/* Setting Default Value Start*/
				dao.setProcInValue(nprocIndex, "store_id", "0");
				dao.setProcInValue(nprocIndex, "item_id", "0");
				dao.setProcInValue(nprocIndex, "cat_no", "0");
				/* Setting Default Value End */
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				
				dao.executeProcedure(nprocIndex);
				
				strErr=dao.getString(nprocIndex, "err");
				if (strErr == null)
					strErr = "";
				wb=dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strErr.equals("")) {
					vo.setStrItemnameComboValuesWS(wb);
					

				} else {
					throw new Exception(strErr);
				}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(" --> WarrentyDetailsTransDAO.getItemNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao!=null){
			dao.free();
			dao = null;}
			wb=null;
		}

	}
	/** To get option value of Brand Name combo 
	 * @param vo
	 */
	public static void getBrandNameCombo(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		
		WebRowSet wb = null;
		
		int nprocIndex;
		String proc_name = "";
		
		String strErr="";
		
			
			try {
				
				dao = new HisDAO("mms", "WarrentyDetailsTransDAO");

				proc_name = "{call pkg_mms_view.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(proc_name);
				
				
				
				
				dao.setProcInValue(nprocIndex, "modeval", "1");
				dao.setProcInValue(nprocIndex, "item_id",vo.getStrItemID());
							
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				
				/* Setting Default Value Start*/
				dao.setProcInValue(nprocIndex, "catCode", "0");
				dao.setProcInValue(nprocIndex, "grpId", "0");
				dao.setProcInValue(nprocIndex, "subGrpId", "0");
				dao.setProcInValue(nprocIndex, "setFlag", "0");
				/* Setting Default Value End */
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				
				dao.executeProcedure(nprocIndex);
				
				strErr=dao.getString(nprocIndex, "err");
				if (strErr == null)
					strErr = "";
				wb=dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strErr.equals("")) {
					vo.setStrBrandNameComboValuesWS(wb);
					

				} else {
					throw new Exception(strErr);
				}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(" --> WarrentyDetailsTransDAO.getBrandNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao!=null){
			dao.free();
			dao = null;}
			wb=null;
		}

	}
	/**
	 * To insert the data
	 * @param vo
	 * 
	 */
	public static void insertProcedure(WarrentyDetailsTransVO vo) {

		HisDAO dao = null;
		
		WarrentyDetailsDAO warrentyDetailsDao=null;
		
		try {
			dao = new HisDAO("mms", "WarrentyDetailsTransDAO");
			warrentyDetailsDao=new WarrentyDetailsDAO();
			
			warrentyDetailsDao.setStrHospitalCode(vo.getStrHospitalCode());
			warrentyDetailsDao.setStrFinancialEndYear(vo.getStrFinancialEndYear());
			warrentyDetailsDao.setStrFinancialStartyear(vo.getStrFinancialStartyear());
			
			warrentyDetailsDao.setStrSeatId(vo.getStrSeatId());
			warrentyDetailsDao.setStrBrandID(vo.getStrBrandID());
			warrentyDetailsDao.setStrGroupID(vo.getStrGroupID());
			warrentyDetailsDao.setStrItemCategoryID(vo.getStrItemCategoryID());
			warrentyDetailsDao.setStrItemID(vo.getStrItemID());
			warrentyDetailsDao.setStrManufacturerID(vo.getStrManufacturerID());
			warrentyDetailsDao.setStrPoNo(vo.getStrPoNo());
			warrentyDetailsDao.setStrQuotationNo(vo.getStrQuotationNo());
			warrentyDetailsDao.setStrRemarks(vo.getStrRemarks());
			warrentyDetailsDao.setStrSubGroupID(vo.getStrSubGroupID());
			warrentyDetailsDao.setStrTenderNo(vo.getStrTenderNo());
			warrentyDetailsDao.setStrWarrentyStartDate(vo.getStrWarrentyStartDate());
			warrentyDetailsDao.setStrWarrentyUnit(vo.getStrWarrentyUnit());
			warrentyDetailsDao.setStrWarrentyUpto(vo.getStrWarrentyUpto());
			warrentyDetailsDao.setStrBatchSlNo(vo.getStrBatchSlNo());
			
			warrentyDetailsDao.insert(dao);
			
			synchronized(dao)
			{
				dao.fire();
			}
			
			
		} catch (Exception e) {
			vo.setStrMsgString("-->WarrentyDetailsTransDAO.insertProcedure()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			warrentyDetailsDao=null;
		}
	}
}


