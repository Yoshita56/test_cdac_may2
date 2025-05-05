package mms.masters.dao;

import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.VOUnitMst;
public class DAOUnitMst {

	/**
	 * retrieves and executes insert Query
	 * 
	 * @param formBean
	 * @return true - if Record Inserted Successfully. <br>
	 *         false - if Record Not Inserted Successfully.
	 */
	public static boolean insertQuery(VOUnitMst formBean) {

		boolean fReturnValue = true;
		int nQueryIndex = 0;
		int qryIndex2 = 0;
		HisDAO dao = null;
		String strQuery = null;
		String strQuery2 = null;
		String[] strTemp = null;
		String strUnitId = "";
		String strFunc = "";
		strFunc = "{? = call MMS_MST.GetUnitId(?,?)}";
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("Unit Master", "DAOUnitMst.insertQuery()");

			// call a function to get unit id
			nfuncIndex = dao.setFunction(strFunc);
			dao.setFuncInValue(nfuncIndex, 2, formBean.getStrModuleVal());
			dao.setFuncInValue(nfuncIndex, 3, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setFuncOutValue(nfuncIndex, 3);
			//dao.executeFunction(nfuncIndex);
			dao.executeFuncForNumeric(nfuncIndex);
			strUnitId = (dao.getFuncNumeric(nfuncIndex)).toString();

		/*	//System.out.println("formBean.getStrBaseUnit()-"
					+ formBean.getStrBaseUnit());*/

			if (!formBean.getStrIsDecimal().equals("1")) {
				formBean.setStrIsDecimal("0");
			}

			// if unit is base unit 
			if (formBean.getStrBaseUnit() == null
					|| formBean.getStrBaseUnit().equals("")) {

			//	//System.out.println("if base unit");
				strQuery = mms.qryHandler_mms.getQuery(1,
						"insert.unitMst.0");

			} else { // if unit is sub unit 

			//	//System.out.println("else");
				strQuery = mms.qryHandler_mms.getQuery(1,
						"insert.unitMst.1");
				strTemp = formBean.getStrBaseUnit().split("#");
			}

			nQueryIndex = dao.setQuery(strQuery);

			/*//System.out.println("strUnitId-" + strUnitId);
			//System.out.println("formBean.getStrUnitName()-"
					+ formBean.getStrUnitName());
			//System.out.println("getStrModuleVal-" + formBean.getStrModuleVal());
			//System.out.println("getStrBaseUnit-" + formBean.getStrBaseUnit());
			//System.out.println("formBean.getStrEffectiveDate()-"
					+ formBean.getStrEffectiveDate());
			//System.out.println("getStrRemarks-" + formBean.getStrRemarks());
			//System.out.println("getStrSeatId-" + formBean.getStrSeatId());

			//System.out.println("formBean.getStrModuleVal()-"
					+ formBean.getStrModuleVal());
			//System.out.println("getStrHospitalCode-"
					+ formBean.getStrHospitalCode());
			//System.out.println("getStrIsDecimal-" + formBean.getStrIsDecimal());*/

			dao.setQryValue(nQueryIndex, 1, strUnitId);
			dao.setQryValue(nQueryIndex, 2, formBean.getStrUnitName());
			dao.setQryValue(nQueryIndex, 3, formBean.getStrModuleVal());

			// if unit is base unit 
			if (formBean.getStrIsBaseUnit().equals("1")) {

				/*//System.out.println("formBean.getStrBaseUnit());-"
						+ formBean.getStrBaseUnit());*/

				dao.setQryValue(nQueryIndex, 4, formBean.getStrBaseUnit().equalsIgnoreCase("")?"0":formBean.getStrBaseUnit());
			} else { // if unit is sub unit 

				dao.setQryValue(nQueryIndex, 4, strTemp[0]);
			}

			dao.setQryValue(nQueryIndex, 5, formBean.getStrEffectiveDate());
			dao.setQryValue(nQueryIndex, 6, formBean.getStrRemarks());
			dao.setQryValue(nQueryIndex, 7, formBean.getStrSeatId());
			dao.setQryValue(nQueryIndex, 8, "1");

			if (formBean.getStrBaseUnit() == null
					|| formBean.getStrBaseUnit().equals("")) {

			//	//System.out.println("2222 if base unit");
				dao.setQryValue(nQueryIndex, 9, formBean.getStrModuleVal());
				dao.setQryValue(nQueryIndex, 10, Config.SUPER_USER_HOSPITAL_CODE);
				dao.setQryValue(nQueryIndex, 11, Config.SUPER_USER_HOSPITAL_CODE);
				dao.setQryValue(nQueryIndex, 12, formBean.getStrIsDecimal());
			} else {

			//	//System.out.println("2222else");
				dao.setQryValue(nQueryIndex, 9, strTemp[1]);
				dao.setQryValue(nQueryIndex, 10, Config.SUPER_USER_HOSPITAL_CODE);
				dao.setQryValue(nQueryIndex, 11, strTemp[0]);
				dao.setQryValue(nQueryIndex, 12, Config.SUPER_USER_HOSPITAL_CODE);
			}

			strQuery2 = mms.qryHandler_mms.getQuery(1, "insert.unit.2");
			qryIndex2 = dao.setQuery(strQuery2);

			dao.setQryValue(qryIndex2, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(qryIndex2, 2, formBean.getStrModuleVal());
			dao.setQryValue(qryIndex2, 3, strUnitId);
			dao.setQryValue(qryIndex2, 4, strUnitId);
			dao.setQryValue(qryIndex2, 5, "1");
			dao.setQryValue(qryIndex2, 6, formBean.getStrEffectiveDate());
			dao.setQryValue(qryIndex2, 7, formBean.getStrSeatId());
			dao.setQryValue(qryIndex2, 8, formBean.getStrRemarks());
			dao.setQryValue(qryIndex2, 9, "1");
			dao.setQryValue(qryIndex2, 10, "1");

			dao.execute(nQueryIndex, 0);
			dao.execute(qryIndex2, 0);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
	 
			new HisException("Unit Master", "DAOUnitMst.insertQuery()", e
					.getMessage());
			formBean.setStrErr("Record Not Inserted");
			fReturnValue = false;
		} finally {
			dao.free();
			dao = null;
		}

		return fReturnValue;
	}

	/**
	 * retrieves and executes Modify Query
	 * 
	 * @param strChk
	 * @param formBean
	 */
	public static void modifyQuery(String chk, VOUnitMst formBean) {

		HisDAO dao = null;
		String strQuery = null;
		int nQryIndex;

		try {
			String strtemp[] = null;
			String strtemp2[] = null;
			dao = new HisDAO("Unit Master", "DAOUnitMst.modifyQuery()");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.unitMst.1");
			nQryIndex = dao.setQuery(strQuery);

			// change by anshul
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao.setQryValue(nQryIndex, 1, strtemp[0]);
			dao.setQryValue(nQryIndex, 2, strtemp[1]);

			WebRowSet web = dao.executeQry(nQryIndex);

			while (web.next()) {

				formBean.setStrModuleVal(web.getString(1));
				formBean.setStrUnitName(web.getString(2));
				formBean.setStrBaseUnit(web.getString(3));
				formBean.setStrEffectiveDate(web.getString(4));
				formBean.setStrRemarks(web.getString(5));
				formBean.setStrValid(web.getString(6));
				formBean.setStrIsDecimal(web.getString(7));
			}

		} catch (Exception e) {

			new HisException("Unit Master", "DAOUnitMst.modifyQuery()", e
					.getMessage());
		} finally {
			dao.free();
			dao = null;
		}
	}

	/**
	 * retrieves and executes update Query
	 * 
	 * @param strChk
	 * @param bean
	 * @return true - if Record Updated Successfully. <br>
	 *         false - if Record Not Updated Successfully.
	 */
	public static boolean updateQuery(String chk, VOUnitMst bean) {

		boolean returnValue = false;
		HisDAO dao = null;
		String strQuery = null;
		String strQuery2 = null;
		int nQryIndex = 0;
		int nQryIndex2 = 0;
		String strtemp[] = null;
		String strtemp2[] = null;

		try {
			// String strTemp1[] = null;
			dao = new HisDAO("Unit Master ", "DAOUnitMst.updateQuery()");
			////  //System.out.println("in dao update chk-->"+chk);
			// String strTemp[] = chk.replace('@', '#').split("#");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.unitMst.0");
			nQryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQryIndex, 1, bean.getStrUnitName());
			dao.setQryValue(nQryIndex, 2, bean.getStrEffectiveDate());
			dao.setQryValue(nQryIndex, 3, bean.getStrSeatId());
			dao.setQryValue(nQryIndex, 4, bean.getStrRemarks());
			dao.setQryValue(nQryIndex, 5, bean.getStrValid());

			if (bean.getStrIsDecimal() == null
					|| bean.getStrIsDecimal().equals("")) {
				bean.setStrIsDecimal("0");
			}

			dao.setQryValue(nQryIndex, 6, bean.getStrIsDecimal());

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao.setQryValue(nQryIndex, 7, strtemp[0]);
			dao.setQryValue(nQryIndex, 8, strtemp[1]);

			// added by anshul on 30th april 09 to update isdecimal of subunits
			strQuery2 = mms.qryHandler_mms.getQuery(1,
					"update.unitMst.1");
			nQryIndex2 = dao.setQuery(strQuery2);

		/*	//System.out.println("bean.getStrSeatId()" + bean.getStrSeatId());
			//System.out.println("bean.getStrIsDecimal()"
					+ bean.getStrIsDecimal());
			//System.out.println("bean.strtemp0()" + strtemp[0]);
			//System.out.println("bean.strtemp1()" + strtemp[1]);*/

			dao.setQryValue(nQryIndex2, 1, bean.getStrSeatId());
			dao.setQryValue(nQryIndex2, 2, bean.getStrIsDecimal());
			dao.setQryValue(nQryIndex2, 3, strtemp[0]);
			dao.setQryValue(nQryIndex2, 4, strtemp[1]);

			dao.execute(nQryIndex, 0);
			dao.execute(nQryIndex2, 0);

			synchronized (dao) {
				dao.fire();
			}
			returnValue = true;
		} catch (Exception e) {

			bean.setStrErr("Row Not Updated");
			returnValue = false;
			new HisException("Unit Master", "DAOUnitMst.updateQuery()", e
					.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

		return returnValue;

	}

	// //////// function by anshul- to get the values of second combo on add
	// page

	public static WebRowSet initialAddQuery(VOUnitMst vo) throws Exception {

		HisDAO dao = new HisDAO("Unit Master", "DAOUnitMst");

		int nqryIndex;

		WebRowSet wb = null;
		String strquery = mms.qryHandler_mms.getQuery(1,
				"select.unitMst.3");

		try {
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrModuleVal());
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);

			wb = dao.executeQry(nqryIndex);

		} catch (Exception e) {

			throw new Exception("DAOUnitMst.initialAddQuery() --> "
					+ e.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

		return wb;
	}

	public static String modNameQuery(VOUnitMst vo) throws Exception {

		HisDAO dao = new HisDAO("mms", "DAOUnitMst");

		int nqryIndex;
		String modName = "";

		WebRowSet wb = null;
		String strquery = mms.qryHandler_mms.getQuery(1,
				"select.moduleName.0");

		try {
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrModuleVal());
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				modName = wb.getString(1);
			}

		} catch (Exception e) {

			throw new Exception("DAOUnitMst.modNameQuery() --> "
					+ e.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

		return modName;
	}

}
