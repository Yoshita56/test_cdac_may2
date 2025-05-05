package mms.masters.bo;

import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import mms.masters.dao.DAOUnitMst;
import mms.masters.vo.VOUnitMst;

public class BOUnitMst {

	public BOUnitMst() {

	}

	/**
	 * inserts new record by checking the existence of Record with same content.
	 * 
	 * @param formBean
	 * @return true - if New Record Inserted Successfully. <br>
	 *         false - if New Record Not Inserted Successfully.
	 */
	public boolean insert(VOUnitMst formBean) {

		String strmsgText = null;
		String strQry = mms.qryHandler_mms.getQuery(1,"select.unitMst.5");
		HisDAO hisDao = new HisDAO("Unit Master", "BOUnitMst.insert()");
		int nQryIndex = hisDao.setQuery(strQry);

		try {
			hisDao.setQryValue(nQryIndex, 1, formBean.getStrUnitName());
			//System.out.println(" Config.SUPER_USER_HOSPITAL_CODE"+ Config.SUPER_USER_HOSPITAL_CODE);
			hisDao.setQryValue(nQryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			hisDao.setQryValue(nQryIndex, 3, formBean.getStrModuleVal());
			WebRowSet wb = hisDao.executeQry(nQryIndex);

			while (wb.next()) {
				if (wb.getInt(1) > 0) {

					formBean.setStrWarning("Record '"
							+ formBean.getStrUnitName() + "'already Exist ");

					return false;
				}
			}
		} catch (SQLException e) {

			strmsgText = "mms.masters.BOUnitMst.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("Billing",
					"UnitMaster->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
			return false;

		} catch (Exception e) {

			strmsgText = "mms.masters.BOUnitMst.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("Billing",
					"UnitMaster->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;

			return false;

		} finally {
			hisDao.free();
			hisDao = null;
		}

		boolean fReturnValue = DAOUnitMst.insertQuery(formBean);

		if (fReturnValue) {

			formBean.setStrMsg("Data Inserted Successfully");
		}

		return fReturnValue;
	}

	/**
	 * invokes modifyQuery Method to retrieve Data's from Database
	 * 
	 * @param strChk
	 * @param formBean
	 */
	public void modify(String strChk, VOUnitMst formBean) {

		DAOUnitMst.modifyQuery(strChk, formBean);

			if(formBean.getStrBaseUnit().length() > 1){
				
				formBean.setStrIsBaseUnit("No");
				
			}else{
				
				formBean.setStrIsBaseUnit("Yes");
			}
			
			
	}

	/**
	 * invokes UpdateQuery method based on existence of Record and returns
	 * Update Status
	 * 
	 * @param strChk
	 * @param formBean
	 * @return true - if record Updated Successfully. <br>
	 *         false - if record not updated Successfully.
	 */
	public boolean update(String strChk, VOUnitMst formBean) {
		String strtemp[] = null;
		String strtemp2[] = null;
		int ncount = 0;
		boolean freturnValue = false;
		boolean returnValue = false;

		String qry = mms.qryHandler_mms.getQuery(1, "select.unitMst.6");
		HisDAO hisDao = new HisDAO("Unit Master", "BOUnitMst.insert()");

		try {
			////  //System.out.println("in bo update chk-->"+strChk);
			int nQryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(nQryIndex, 1, formBean.getStrUnitName());
			/*
			 * String strTemp[] = formBean.chk[0].replace('$', '#').split("#");
			 * hisDao.setQryValue(nQryIndex, 2, strTemp[0]);
			 */

			strtemp = formBean.chk[0].replace('@', '#').split("#");// changes
																	// by anshul
																	// after
																	// addition
																	// of
																	// hospital
																	// code in
																	// primary
																	// key
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];
			////  //System.out.println("in bo update()--strtmp0 shud b unit
			// id-->"+strtemp[0]);
			////  //System.out.println("in bo update()--strtmp1 shud b hos
			// code-->"+strtemp[1]);
			hisDao.setQryValue(nQryIndex, 2, strtemp[1]);
			hisDao.setQryValue(nQryIndex, 3, strtemp[0]);
			hisDao.setQryValue(nQryIndex, 4, formBean.getStrModuleVal());

			WebRowSet wb = hisDao.executeQry(nQryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
				////  //System.out.println("in dao initial update getting wb
				// ncount"+ncount);
			}

			if (ncount > 1) {
				freturnValue = false;
				formBean.setStrWarning("Record '" + formBean.getStrUnitName()
						+ "' already Exists");
			} else {
				freturnValue = true;
			}
			/*
			 * if (freturnValue == false) {
			 * 
			 * formBean.setStrWarning("Record '"+ formBean.getStrUnitName()+ "'
			 * already Exists");
			 * 
			 * return false; }
			 */

		} catch (Exception e) {

			new HisException("Unit Master", "BOUnitMst.insert()", e
					.getMessage());
			// formBean.setStrWarning("Record '" + formBean.getStrUnitName()+ "'
			// already Exists");

			return false;
		} finally {
			hisDao.free();
			hisDao = null;
		}
		if (freturnValue) {
			returnValue = DAOUnitMst.updateQuery(strChk, formBean);
		}
		if (returnValue) {

			formBean.setStrMsg("Data Inserted Successfully");
		}

		return returnValue;
	}

	public void initialAdd(VOUnitMst vo) throws Exception
	// for getting option value of combo on add page
	{
		WebRowSet wb = null;

		////  //System.out.println("bo init add calling");

		try {
			wb = DAOUnitMst.initialAddQuery(vo);

			HisUtil hisutil = new HisUtil("Unit Master", "BoUnitMst");
			/*
			 * while(wb.next()) {//  //System.out.println("cmb
			 * CODE-->"+wb.getString(1));//  //System.out.println("cmb
			 * VAL-->"+wb.getString(2)); }
			 */
			String cmb = hisutil.getOptionValue(wb, "0#Select Value",
					"Select Value", false);
			////  //System.out.println("in bo cmb-->"+cmb);
			vo.setStrUnitComboValues(cmb);
			////  //System.out.println("IN BO VO CMB
			// VALUE-->"+vo.getStrUnitComboValues());

		} catch (Exception e) {
			throw new Exception("BOUnitMst.initialAdd() -->" + e.getMessage());
		}

	}

	public void modName(VOUnitMst vo) throws Exception
	// for getting option value of combo on add page
	{
		// WebRowSet wb=null;
		String modName = "";

		try {

			modName = DAOUnitMst.modNameQuery(vo);

			/*
			 * HisUtil hisutil = new HisUtil("store","BOStoreGroupMst"); String
			 * cmb = hisutil.getOptionValue(wb, "0^Select Value" ,"Select Value"
			 * ,true );
			 */

			vo.setStrModuleName(modName);

		} catch (Exception e) {
			throw new Exception("BOUnitMst.modName() -->" + e.getMessage());
		}

	}

}
