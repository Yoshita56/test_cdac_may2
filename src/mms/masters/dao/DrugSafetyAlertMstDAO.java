package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DrugSaftyAlertDAO;
import mms.masters.vo.DrugSafetyAlertMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstDAO.
 */
public class DrugSafetyAlertMstDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialModifyQuery(DrugSafetyAlertMstVO vo) {

		HisDAO dao = null;
		int nqryIndex, nqryIndex1, nqryIndex2, nqryIndex3;
		WebRowSet wb = null, wb1 = null, wb2 = null, wb3 = null;
		String strquery = "";
		String strquery1 = "";
		String strquery2 = "";
		String strquery3 = "";
		String strtemp[] = null;
		String chk1 = null;

		try {

			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			chk1 = vo.getStrChk1();
			chk1 = chk1.replace('@', '$');
			strtemp = chk1.replace('$', '#').split("#");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.0"); // 3 Values
			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.1"); // 10 Values
			strquery3 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.2");
			strquery2 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.data.11");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);
			nqryIndex2 = dao.setQuery(strquery2);
			nqryIndex3 = dao.setQuery(strquery3);

			dao.setQryValue(nqryIndex, 1, strtemp[0].trim());
			dao.setQryValue(nqryIndex, 2, strtemp[1].trim());

			dao.setQryValue(nqryIndex1, 1, strtemp[0]);
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 3, "1");

			dao.setQryValue(nqryIndex2, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex2, 2, "1");

			dao.setQryValue(nqryIndex3, 1, strtemp[0]);
			dao.setQryValue(nqryIndex3, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex3, 3, "1");

			// System.out.println("Before Ws");
			wb = dao.executeQry(nqryIndex);
			// System.out.println("wb size::"+wb.size());

			wb1 = dao.executeQry(nqryIndex1);
			// System.out.println("wb1::"+wb1.size());

			wb2 = dao.executeQry(nqryIndex2);
			// System.out.println("wb2 size:::"+wb2.size());

			wb3 = dao.executeQry(nqryIndex3);
			// System.out.println("wb3 size:::"+wb3.size());

			while (wb.next()) {
				vo.setStrDrugName(wb.getString(1));
				vo.setStrGroupName(wb.getString(2));
				vo.setStrSubGroupName(wb.getString(3));
			}
			while (wb3.next()) {

				vo.setStrRemarks(wb3.getString(1));
				vo.setStrEffectiveFrom(wb3.getString(2));
			}

			vo.setStrAddedDataWs(wb1);
			vo.setStrDataWs(wb2);
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("--> DrugSaftyAlertMstDAO.initialModifyQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(DrugSafetyAlertMstVO vo) {

		DrugSaftyAlertDAO drugSaftyAlertDAO = null;
		HisDAO dao = null;

		try {
			drugSaftyAlertDAO = new DrugSaftyAlertDAO();
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			int length = vo.getStrAddedData().length;

			drugSaftyAlertDAO.setStrHstnumItemId(vo.getStrItemId());
			drugSaftyAlertDAO.setStrHospitalCode(vo.getStrHospitalCode());

			for (int i = 0; i < length; i++) {

				drugSaftyAlertDAO.setStrHstrCl(vo.getStrAddedData()[0]);

				drugSaftyAlertDAO.setStrHstrSp(vo.getStrAddedData()[1]);

				drugSaftyAlertDAO.setStrHstrInt(vo.getStrAddedData()[2]);

				drugSaftyAlertDAO.setStrHstrAdr(vo.getStrAddedData()[3]);

				drugSaftyAlertDAO.setStrHstrIntPotHaz(vo.getStrAddedData()[4]);

				drugSaftyAlertDAO.setStrHstrAdrPotLt(vo.getStrAddedData()[5]);

				drugSaftyAlertDAO.setStrHstrLabInt(vo.getStrAddedData()[6]);

				drugSaftyAlertDAO.setStrHstrintFood(vo.getStrAddedData()[7]);

			}
			drugSaftyAlertDAO.setStrRemarks(vo.getStrRemarks());

			drugSaftyAlertDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			drugSaftyAlertDAO.setStrLstModSeatId(vo.getStrSeatId());

			drugSaftyAlertDAO.setStrLstModDate(vo.getStrCtDate());

			drugSaftyAlertDAO.setStrEntryDate(vo.getStrCtDate());

			drugSaftyAlertDAO.setStrSeatId(vo.getStrSeatId());

			drugSaftyAlertDAO.setStrIsValid("1");

			drugSaftyAlertDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void updateQuery(DrugSafetyAlertMstVO vo) {

		DrugSaftyAlertDAO drugSaftyAlertDAO = null;
		HisDAO dao = null;
		String strtemp[] = null;
		// String strtemp2[] = null;
		String chk1 = null;

		try {
			drugSaftyAlertDAO = new DrugSaftyAlertDAO();
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			int length = vo.getStrAddedData().length;

			chk1 = vo.getStrChk1();
			chk1 = chk1.replace('@', '$');
			strtemp = chk1.replace('$', '#').split("#");

			// System.out.println("Inside:::"+strtemp[0]);
			// System.out.println("Inside 2:::"+strtemp[1]);
			// System.out.println("Hosp Code:::"+vo.getStrHospitalCode());

			drugSaftyAlertDAO.setStrHstnumItemId(strtemp[0]);
			drugSaftyAlertDAO.setStrHospitalCode(vo.getStrHospitalCode());

			for (int i = 0; i < length; i++) {

				drugSaftyAlertDAO.setStrHstrCl(vo.getStrAddedData()[0]);

				drugSaftyAlertDAO.setStrHstrSp(vo.getStrAddedData()[1]);

				drugSaftyAlertDAO.setStrHstrInt(vo.getStrAddedData()[2]);

				drugSaftyAlertDAO.setStrHstrAdr(vo.getStrAddedData()[3]);

				drugSaftyAlertDAO.setStrHstrIntPotHaz(vo.getStrAddedData()[4]);

				drugSaftyAlertDAO.setStrHstrAdrPotLt(vo.getStrAddedData()[5]);

				drugSaftyAlertDAO.setStrHstrLabInt(vo.getStrAddedData()[6]);

				drugSaftyAlertDAO.setStrHstrintFood(vo.getStrAddedData()[7]);

			}
			drugSaftyAlertDAO.setStrRemarks(vo.getStrRemarks());

			drugSaftyAlertDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			drugSaftyAlertDAO.setStrLstModSeatId(vo.getStrSeatId());

			drugSaftyAlertDAO.setStrLstModDate(vo.getStrCtDate());

			drugSaftyAlertDAO.setStrEntryDate(vo.getStrCtDate());

			drugSaftyAlertDAO.setStrSeatId(vo.getStrSeatId());

			drugSaftyAlertDAO.setStrIsValid("1");

			drugSaftyAlertDAO.update(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(DrugSafetyAlertMstVO vo) {

		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		WebRowSet wb = null, wb1 = null;
		String strquery = "";
		String strquery1 = "";

		try {

			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.combo.2");
			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.data.1");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);

			dao.setQryValue(nqryIndex1, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 2, "1");

			wb = dao.executeQry(nqryIndex);
			wb1 = dao.executeQry(nqryIndex1);

			while (wb1.next()) {
				vo.setStrRemarks(wb1.getString(9));
				vo.setStrEffectiveFrom(wb1.getString(10));
			}

			wb1.beforeFirst();
			vo.setStrDataWs(wb1);

			vo.setStrGroupNameComboValuesWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.initialAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the sub group combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the sub group combo
	 */
	public static void getSubGroupCombo(DrugSafetyAlertMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.combo.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrSubGroupNameComboValuesWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getSubGroupCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the drug combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the drug combo
	 */
	public static void getDrugCombo(DrugSafetyAlertMstVO vo) {

		HisDAO dao = null;
		int nqryIndex1;
		WebRowSet wb1 = null;
		// String strquery = "";
		String strquery1 = "";
	//	String str2 = null;
	//	HisUtil hisutil = null;

		try {
		//	hisutil = new HisUtil("master", "DrugSaftyAlertMstDAO");
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

//			System.out.println(" vo.getStrSubGrpId() -->>"+vo.getStrSubGrpId());
//			System.out.println(" vo.getStrHospitalCode() -->>"+vo.getStrHospitalCode());
//			System.out.println(" vo.getStrGrpId() -->>"+vo.getStrGrpId());
			if (vo.getStrSubGrpId().equals("0")
					
					|| vo.getStrSubGrpId().equals("")
					|| vo.getStrSubGrpId() == null) {
				strquery1 = mms.qryHandler_mms.getQuery(1,
						"select.drugSafteyAlertMst.drug.combo.1");

				nqryIndex1 = dao.setQuery(strquery1);

				dao.setQryValue(nqryIndex1, 1, vo.getStrGrpId());
				dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());

			} else {
				strquery1 = mms.qryHandler_mms.getQuery(1,
						"select.drugSafteyAlertMst.drug.combo.2");

				nqryIndex1 = dao.setQuery(strquery1);
				dao.setQryValue(nqryIndex1, 1, vo.getStrGrpId());
				dao.setQryValue(nqryIndex1, 2, vo.getStrSubGrpId());
				dao.setQryValue(nqryIndex1, 3, vo.getStrHospitalCode());

			}

			wb1 = dao.executeQry(nqryIndex1);
			//System.out.println("Size -->>"+wb1.size());
			vo.setStrDrugNameComboValuesWS(wb1);

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getDrugCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(DrugSafetyAlertMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.duplicate.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.chkDuplicate()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(DrugSafetyAlertMstVO vo) {

		HisDAO dao = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		String strquery = "";

		try {

			strtemp = vo.getStrChk1().replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, strtemp[1]);

			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrStoreTypeId(web.getString(1));
				vo.setStrGroupName(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(DrugSafetyAlertMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.4");

			nqryIndex = dao.setQuery(strquery);

			strtemp = vo.getStrChk1().replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupName());
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 3, strtemp[1]);
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeId());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));

			}

			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DrugSaftyAlertMstDAO.initialUpdateQuery()-->"
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
