package mms.masters.dao;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;

import mms.masters.vo.VOUnitValueMst;
import hisglobal.utility.HisUtil;

public class DAOUnitValueMst {
	
	/*public static String modNameQuery(VOUnitValueMst vo) throws Exception {

		HisDAO dao = new HisDAO("billing", "DAOUnitValueMst");

		int nqryIndex;
		String modName = "";

		WebRowSet wb = null;
		String strquery = billing.qryHandler_billing.getQuery(1,
				"select.moduleName.0");

		try {
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrModuleId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				modName = wb.getString(1);
			}

		} catch (Exception e) {

			throw new Exception("DAOUnitValueMst.modNameQuery() --> "
					+ e.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

		return modName;
	}
*/

	public static boolean insertQuery(VOUnitValueMst vo) throws Exception {

		HisDAO dao1 = null;

		boolean retvalue = true;
		String fromUnitVal = "";

		dao1 = new HisDAO("Billing", "DAOUnitValueMst");
		String query = mms.qryHandler_mms.getQuery(1,
				"insert.unitvalue.0");
		String query2 = mms.qryHandler_mms.getQuery(1,
				"insert.unitvalue.0");

		int qryIndex = dao1.setQuery(query);
		int qryIndex2 = dao1.setQuery(query2);
		String temp[] = null;
		fromUnitVal = vo.getFromUnit();
		temp = fromUnitVal.split("#");
		vo.setFromUnit(temp[0]);
		String strConValue = vo.getConvertedValue();
		double conVal = Double.parseDouble(strConValue);
		double revVal = 1.0d / conVal;

		String strRevVal = HisUtil.getAmountWithDecimal(revVal, 3);

		try {

			dao1.setQryValue(qryIndex, 1, vo.getStrHospitalCode());
			dao1.setQryValue(qryIndex, 2, vo.getModuleName());
			dao1.setQryValue(qryIndex, 3, vo.getFromUnit());
			dao1.setQryValue(qryIndex, 4, vo.getToUnit());
			dao1.setQryValue(qryIndex, 5, vo.getConvertedValue());
			dao1.setQryValue(qryIndex, 6, vo.getEffectiveFrom());
			dao1.setQryValue(qryIndex, 7, vo.getStrSeatId());
			dao1.setQryValue(qryIndex, 8, vo.getRemark());
			dao1.setQryValue(qryIndex, 9, "1");
			dao1.setQryValue(qryIndex, 10, vo.getModuleName());
			dao1.setQryValue(qryIndex, 11, vo.getFromUnit());
			dao1.setQryValue(qryIndex, 12, vo.getToUnit());
			dao1.setQryValue(qryIndex, 13, vo.getStrHospitalCode());

			dao1.setQryValue(qryIndex2, 1, vo.getStrHospitalCode());
			dao1.setQryValue(qryIndex2, 2, vo.getModuleName());
			dao1.setQryValue(qryIndex2, 3, vo.getToUnit());
			dao1.setQryValue(qryIndex2, 4, vo.getFromUnit());
			dao1.setQryValue(qryIndex2, 5, strRevVal);
			dao1.setQryValue(qryIndex2, 6, vo.getEffectiveFrom());
			dao1.setQryValue(qryIndex2, 7, vo.getStrSeatId());
			dao1.setQryValue(qryIndex2, 8, vo.getRemark());
			dao1.setQryValue(qryIndex2, 9, "1");
			dao1.setQryValue(qryIndex2, 10, vo.getModuleName());
			dao1.setQryValue(qryIndex2, 11, vo.getFromUnit());
			dao1.setQryValue(qryIndex2, 12, vo.getToUnit());
			dao1.setQryValue(qryIndex2, 13, vo.getStrHospitalCode());

			dao1.execute(qryIndex, 0);
			if (!(vo.getFromUnit().equals(vo.getToUnit()))) {
				dao1.execute(qryIndex2, 0);
			}

			synchronized (dao1) {
				dao1.fire();
			}

			retvalue = true;

		} catch (Exception e) {
	 
			retvalue = false;
			throw new Exception("DAOUnitValueMst.insertQuery--->"
					+ e.getMessage());
		} finally {
			dao1.free();
			dao1 = null;
		}

		return retvalue;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////

	public static void modifyQuery(String chk1, VOUnitValueMst vo)
			throws Exception {

		// initializing Parameter
		HisDAO dao = null;
		String temp[] = null;
		int qryIndex;
		String query = new String();
		WebRowSet web = null;

		temp = chk1.replace('$', '#').split("#"); // Get P.K from Chk Value
		try {
			dao = new HisDAO("Billing", "DAOUnitValueMst");
			query = mms.qryHandler_mms.getQuery(1, "select.unitvalue.9");

			qryIndex = dao.setQuery(query);
			String[] temp1 = temp[0].replaceAll("@", "#").split("#");

			for (int i = 1; i <= temp1.length; i++) {
				//System.out.println("i-"+i+"-"+ temp1[i - 1]);
				dao.setQryValue(qryIndex, i, temp1[i - 1]);
			}

			web = dao.executeQry(qryIndex);

			while (web.next()) {

				
				vo.setModuleName(web.getString(1));
				vo.setFromUnit(web.getString(2));
				vo.setToUnit(web.getString(3));
				vo.setConvertedValue(web.getString(4));
				vo.setEffectiveFrom(web.getString(5));
				vo.setStrSeatId(web.getString(6));
				vo.setRemark(web.getString(7));
				vo.setIsValid(web.getString(8));

			}

		} catch (Exception e) {
			//e.printStackTrace();
			throw new Exception("DAOUnitValueMst.modifyQuery" + e.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean updateQuery(String chk, VOUnitValueMst vo)
			throws Exception {
		boolean retvalue = true;
		HisDAO dao = null;
		String temp[] = null;
		String temp2[] = null;
		int qryIndex = 0;
		int qryIndex2 = 0;
		String query = new String();
		String query2 = new String();
		String strConValue = "";

		strConValue = vo.getConvertedValue();
		double conVal = Double.parseDouble(strConValue);
		double revVal = 1.0d / conVal;

		String strRevVal = HisUtil.getAmountWithDecimal(revVal, 3);
	

		try {

			dao = new HisDAO("Billing", "DAOUnitValueMst");
			query = mms.qryHandler_mms.getQuery(1, "update.unitvalue.0");
			query2 = mms.qryHandler_mms.getQuery(1,
					"update.unitvalue.1");

			temp = chk.replace('@', '#').split("#");
			temp2 = temp[4].replace("$", "#").split("#");
			
			qryIndex = dao.setQuery(query);
			qryIndex2 = dao.setQuery(query2);

			
			dao.setQryValue(qryIndex, 1, vo.getConvertedValue());
			dao.setQryValue(qryIndex, 2, vo.getEffectiveFrom());
			dao.setQryValue(qryIndex, 3, vo.getStrSeatId());
			dao.setQryValue(qryIndex, 4, vo.getRemark());
			dao.setQryValue(qryIndex, 5, vo.getStrSeatId());
			dao.setQryValue(qryIndex, 6, vo.getIsValid());
			dao.setQryValue(qryIndex, 7, temp[0]);
			dao.setQryValue(qryIndex, 8, temp[1]);
			dao.setQryValue(qryIndex, 9, temp[2]);
			dao.setQryValue(qryIndex, 10, temp[3]);
			dao.setQryValue(qryIndex, 11, temp2[0]);

			
			dao.setQryValue(qryIndex2, 1, strRevVal);
			dao.setQryValue(qryIndex2, 2, vo.getEffectiveFrom());
			dao.setQryValue(qryIndex2, 3, vo.getStrSeatId());
			dao.setQryValue(qryIndex2, 4, vo.getRemark());
			dao.setQryValue(qryIndex2, 5, vo.getStrSeatId());
			dao.setQryValue(qryIndex2, 6, vo.getIsValid());
			dao.setQryValue(qryIndex2, 7, temp[0]);
			dao.setQryValue(qryIndex2, 8, temp[1]);
			dao.setQryValue(qryIndex2, 9, temp[3]);
			dao.setQryValue(qryIndex2, 10, temp[2]);

			dao.execute(qryIndex, 0);
			if (!(vo.getFromUnit().equals(vo.getToUnit()))) {
				dao.execute(qryIndex2, 0);
			}

			synchronized (dao) {
				dao.fire();
			}
			retvalue = true;
		}

		catch (Exception e) {
			vo.setStrErrorMsg("Record Not Updated");
			retvalue = false;
			new HisException("Unit Value Master",
					"DAOUnitValueMst.updateQuery()", e.getMessage());

		} finally {
			dao.free();
			dao = null;
		}

		return retvalue;

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean initialUpdateQuery(String chk, VOUnitValueMst vo)
			throws Exception {
		HisDAO dao = new HisDAO("Billing", "DAOUnitValueMst");
		String strtemp[] = null;
		String strtemp2[] = null;

		boolean returnValue = false;
		int qryIndex;
		int count = 0;
		WebRowSet wb = null;
		String query = mms.qryHandler_mms.getQuery(1,
				"select.unitvalue.8");

		try {

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			
			qryIndex = dao.setQuery(query);

			dao.setQryValue(qryIndex, 1, strtemp[0]);
			dao.setQryValue(qryIndex, 2, strtemp[1]);
			dao.setQryValue(qryIndex, 3, strtemp[2]);
			dao.setQryValue(qryIndex, 4, strtemp[3]);
			dao.setQryValue(qryIndex, 5, strtemp2[0]);
			wb = dao.executeQry(qryIndex);
			while (wb.next()) {
				count = Integer.parseInt(wb.getString(1));

			}
			if (count == 0) {
				returnValue = true;
			} else {
				returnValue = false;
			}

		} catch (Exception e) {
			returnValue = false;

			throw new Exception("billing.DAOUnitValueMst.initialUpdateQuery"
					+ e.getMessage());
		}

		finally {

			dao.free();
			dao = null;
		}

		return returnValue;
	}

	public static boolean initialAddQuery(VOUnitValueMst vo) throws Exception {
		HisDAO dao = new HisDAO("Billing", "DAOUnitValueMst");
		boolean returnValue = false;
		int qryIndex;
		int count = 0;
		String temp[] = new String[3];
		WebRowSet wb = null;
		String query = mms.qryHandler_mms.getQuery(1,
				"select.unitvalue.10");
		String val1 = vo.getModuleName();
		String frmUnit = vo.getFromUnit();
		try {
			temp = frmUnit.split("#");
			qryIndex = dao.setQuery(query);
			
			dao.setQryValue(qryIndex, 1, val1);
			dao.setQryValue(qryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(qryIndex, 3, temp[0]);
			dao.setQryValue(qryIndex, 4, vo.getToUnit());

			wb = dao.executeQry(qryIndex);

			while (wb.next()) {
				count = Integer.parseInt(wb.getString(1));
			}
			if (count == 0) {
				returnValue = true;
			} else {
				returnValue = false;
			}

		} catch (Exception e) {
			returnValue = false;
			throw new Exception("billing.DAOUnitValueMst.initialAddQuery"
					+ e.getMessage());
		} finally {
			dao.free();
			dao = null;
		}

		return returnValue;
	}

}
