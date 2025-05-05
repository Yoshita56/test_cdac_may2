/**
 * 
 */
package mms.transactions.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.DrugProfileVO;

/**
 * @author pankaj Date-- 22-Jan-2009 Data Access Object Class for Drug Profile
 *         Transaction
 * 
 */
public class DrugProfileDAO {
	public static void setGroupComboValues(DrugProfileVO _drugProfileVO) {
		String strproc_name = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.DrugProfileDAO.setGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.DrugProfileDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _drugProfileVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "item_category", "10",3);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
			dao.setProcInValue(nProcIndex, "strStoreId", "",5);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_drugProfileVO.setStrGroupComboValues(util.getOptionValue(
						wsResult, _drugProfileVO.getStrGroupID(), "0^Select Value", false));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_drugProfileVO
					.setStrMsgString("DrugProfileDAO.setGroupComboValues() --> "
							+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setSubGroupComboValues(DrugProfileVO _drugProfileVO) {
		String strproc_name = "{call pkg_mms_view.proc_store_subgroup_list(?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.DrugProfileDAO.setSubGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.DrugProfileDAO.setSubGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _drugProfileVO
					.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "group_id", _drugProfileVO
					.getStrGroupID(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_drugProfileVO.setStrSubGroupComboValues(util.getOptionValue(
						wsResult, _drugProfileVO.getStrSubGroupID(), "0^Select Value", false));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_drugProfileVO
					.setStrMsgString("DrugProfileDAO.setSubGroupComboValues() --> "
							+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setDrugComboValues(DrugProfileVO _drugProfileVO) {
		String strproc_name = "{call pkg_mms_view.proc_item_list(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.DrugProfileDAO.setDrugComboValues()");
			dao = new HisDAO("MMS",
					"transactions.DrugProfileDAO.setDrugComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,5);
			dao.setProcInValue(nProcIndex, "grpId", _drugProfileVO
					.getStrGroupID(),3);
			dao.setProcInValue(nProcIndex, "subgroup_id", _drugProfileVO
					.getStrSubGroupID(),4);
			dao.setProcInValue(nProcIndex, "catCode", "10",2);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");
			
			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_drugProfileVO.setStrDrugComboValues(util.getOptionValue(
						wsResult, _drugProfileVO.getStrItemID(), "0^Select Value", false));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_drugProfileVO
					.setStrMsgString("DrugProfileDAO.setDrugComboValues() --> "
							+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void setDosageAndIndicationData(DrugProfileVO _drugProfileVO) 
	{
		String strproc_name = "{call pkg_mms_view.proc_drugbrand_list(?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			dao = new HisDAO("MMS","transactions.DrugProfileDAO.setDosageAndIndicationData()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3");
			dao.setProcInValue(nProcIndex, "brandid", _drugProfileVO.getStrItemID().replace("^","#").split("#")[0]);
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) 
			{
					_drugProfileVO.setWsDosageAndIndicationData(wsResult);
					
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception _Err) 
		{
			_drugProfileVO.setStrMsgString("DrugProfileDAO.setDosageAndIndicationData() --> "+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void setSaftyAlertData(DrugProfileVO _drugProfileVO) {
		String strproc_name = "{call pkg_mms_view.proc_drugbrand_list(?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			dao = new HisDAO("MMS","transactions.DrugProfileDAO.setDosageAndIndicationData()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "4");
			dao.setProcInValue(nProcIndex, "brandid", _drugProfileVO.getStrItemID().replace("^","#").split("#")[0]);
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_drugProfileVO.setWsSaftyAlertData(wsResult);
				////System.out.println("wsResult"+wsResult.size());
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_drugProfileVO
					.setStrMsgString("DrugProfileDAO.setSaftyAlertData() --> "
							+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void setBrandedItemData(DrugProfileVO _drugProfileVO) {
		String strproc_name = "{call pkg_mms_view.proc_drugbrand_list(?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			dao = new HisDAO("MMS","transactions.DrugProfileDAO.setDosageAndIndicationData()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "5");
			dao.setProcInValue(nProcIndex, "brandid", _drugProfileVO.getStrItemID());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_drugProfileVO.setWsBrandedItemData(wsResult);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_drugProfileVO
					.setStrMsgString("DrugProfileDAO.setBrandedItemData() --> "
							+ _Err.getMessage());
			_drugProfileVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void brandItemCombo(DrugProfileVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_drugbrand_list(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "brandid", "0");
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
	
	public static void setGenericDtl(DrugProfileVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_drugbrand_list(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "brandid", vo.getStrItemID());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("wb"+wb.size());
			if (strerr.equals("")) {
				vo.setStrItemWS(wb);
				
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
}
