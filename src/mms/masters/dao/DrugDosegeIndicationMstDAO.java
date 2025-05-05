package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DrugDosegeIndicationDAO;
import mms.masters.vo.DrugDosegeIndicationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosegeIndicationMstDAO.
 */
public class DrugDosegeIndicationMstDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialModifyQuery(DrugDosegeIndicationMstVO vo) {

		HisDAO dao = null;
		int nqryIndex, nqryIndex1, nqryIndex2, nqryIndex3;
		WebRowSet wb = null, wb1 = null, wb2 = null, wb3 = null;
		String strquery = "";
		String strquery1 = "";
		String strquery2 = "";
		String strquery3 = "";
		// String str2 = null;
		// HisUtil hisutil = null;
		String strtemp[] = null;
		String chk1 = null;

		try {
			// hisutil = new HisUtil("master", "DrugSaftyAlertMstDAO");
			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");

			chk1 = vo.getStrChk1();
			chk1 = chk1.replace('@', '$');
			strtemp = chk1.replace('$', '#').split("#");

//			 //System.out.println("Inside:::"+strtemp[0]);
//			 //System.out.println("Inside 2:::"+strtemp[1]);
//			 //System.out.println("Hosp Code:::"+vo.getStrHospitalCode());

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.modify.0"); // 3 Values
			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.modify.1"); // 10 Values
			strquery3 = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.modify.2");
			strquery2 = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.data.11");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);
			nqryIndex2 = dao.setQuery(strquery2);
			nqryIndex3 = dao.setQuery(strquery3);

			dao.setQryValue(nqryIndex, 1, strtemp[0]);
			dao.setQryValue(nqryIndex, 2, strtemp[1]);

			dao.setQryValue(nqryIndex1, 1, strtemp[0]);
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 3, "1");

			dao.setQryValue(nqryIndex2, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex2, 2, "1");

			dao.setQryValue(nqryIndex3, 1, strtemp[0]);
			dao.setQryValue(nqryIndex3, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex3, 3, "1");

			wb = dao.executeQry(nqryIndex);
			// // //System.out.println("size::"+wb.size());

			wb1 = dao.executeQry(nqryIndex1);
			// //System.out.println("size::"+wb1.size());

			wb2 = dao.executeQry(nqryIndex2);
			// //System.out.println("size::"+wb2.size());

			wb3 = dao.executeQry(nqryIndex3);
			// //System.out.println("size::"+wb3.size());

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
					.setStrMsgString("--> DrugDosIndicationMstDAO.initialModifyQuery()-->"
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
	public static void insertQuery(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationDAO drugDoseIndicationDAO = null;
		HisDAO dao = null;
		HisUtil util = null;

		try {
			drugDoseIndicationDAO = new DrugDosegeIndicationDAO();
			dao = new HisDAO("mms", "DrugDosIndicationMstDAO");

			util = new HisUtil("IssueToEmployeeTransDATA",
					"IssueToEmployeeTransDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			vo.setStrCtDate(strCtDate);

			int length = vo.getStrAddedData().length;

			drugDoseIndicationDAO.setStrHstnumItemId(vo.getStrItemID());

			drugDoseIndicationDAO.setStrHospitalCode(vo.getStrHospitalCode());

			for (int i = 0; i < length; i++) {

				drugDoseIndicationDAO.setStrHstrOral(vo.getStrAddedData()[0]);

				drugDoseIndicationDAO.setStrHstrIntervanous(vo
						.getStrAddedData()[1]);

				drugDoseIndicationDAO
						.setStrHstrParentreal(vo.getStrAddedData()[2]);

				drugDoseIndicationDAO
						.setStrHstrOpthlamic(vo.getStrAddedData()[3]);

				drugDoseIndicationDAO.setStrHstrIntraActicular(vo
						.getStrAddedData()[4]);

				drugDoseIndicationDAO
						.setStrHstrTopical(vo.getStrAddedData()[5]);

				drugDoseIndicationDAO
						.setStrHstrAnyRoute(vo.getStrAddedData()[6]);

				drugDoseIndicationDAO.setStrHstrIntraMusclr(vo
						.getStrAddedData()[7]);

				drugDoseIndicationDAO
						.setStrHstrMiclanus(vo.getStrAddedData()[8]);

				drugDoseIndicationDAO.setStrHstrOtic(vo.getStrAddedData()[9]);

				drugDoseIndicationDAO.setStrHstrMouth(vo.getStrAddedData()[10]);

				drugDoseIndicationDAO
						.setStrHstrRectal(vo.getStrAddedData()[11]);

				drugDoseIndicationDAO.setStrHstrNasal(vo.getStrAddedData()[12]);

				drugDoseIndicationDAO
						.setStrHstrInhalton(vo.getStrAddedData()[13]);

				drugDoseIndicationDAO
						.setStrHstrVaginal(vo.getStrAddedData()[14]);

				drugDoseIndicationDAO
						.setStrHstrLingual(vo.getStrAddedData()[15]);

				drugDoseIndicationDAO.setStrHstrIntraThecal(vo
						.getStrAddedData()[16]);

				drugDoseIndicationDAO.setStrHstrIntraLesioNal(vo
						.getStrAddedData()[17]);

				drugDoseIndicationDAO.setStrHstrExtraAmniotic(vo
						.getStrAddedData()[18]);

				drugDoseIndicationDAO
						.setStrHstrEpidural(vo.getStrAddedData()[19]);

				drugDoseIndicationDAO.setStrHstrIntraSpinal(vo
						.getStrAddedData()[20]);

				drugDoseIndicationDAO
						.setStrHstrSubCuta(vo.getStrAddedData()[21]);

				drugDoseIndicationDAO.setStrHstrIntraVesical(vo
						.getStrAddedData()[22]);

				drugDoseIndicationDAO.setStrHstrIntraDermal(vo
						.getStrAddedData()[23]);

				drugDoseIndicationDAO
						.setStrHstrTrensDrml(vo.getStrAddedData()[24]);

			}
			drugDoseIndicationDAO.setStrRemarks(vo.getStrRemarks());

			drugDoseIndicationDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			drugDoseIndicationDAO.setStrEntryDate(vo.getStrCtDate());

			drugDoseIndicationDAO.setStrSeatId(vo.getStrSeatId());

			drugDoseIndicationDAO.setStrIsValid("1");

			drugDoseIndicationDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.insertQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
			util = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void updateQuery(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationDAO drugDoseIndicationDAO = null;
		HisDAO dao = null;
		String strtemp[] = null;
		// String strtemp2[] = null;
		String chk1 = null;

		try {
			drugDoseIndicationDAO = new DrugDosegeIndicationDAO();
			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");

		//	int length = vo.getStrAddedData().length;

			chk1 = vo.getStrChk1();
			chk1 = chk1.replace('@', '$');
			strtemp = chk1.replace('$', '#').split("#");

			// //System.out.println("strtemp[0]--->>>"+strtemp[0]);

			drugDoseIndicationDAO.setStrHstnumItemId(strtemp[0]);
			drugDoseIndicationDAO.setStrHospitalCode(strtemp[1]);
			drugDoseIndicationDAO.setStrSlNo(strtemp[1]);

			// for(int i=0;i<length;i++)
			// {

			drugDoseIndicationDAO.setStrHstrOral(vo.getStrAddedData()[0]);

			drugDoseIndicationDAO
					.setStrHstrIntervanous(vo.getStrAddedData()[1]);

			drugDoseIndicationDAO.setStrHstrParentreal(vo.getStrAddedData()[2]);

			drugDoseIndicationDAO.setStrHstrOpthlamic(vo.getStrAddedData()[3]);

			drugDoseIndicationDAO
					.setStrHstrIntraActicular(vo.getStrAddedData()[4]);

			drugDoseIndicationDAO.setStrHstrTopical(vo.getStrAddedData()[5]);

			drugDoseIndicationDAO.setStrHstrAnyRoute(vo.getStrAddedData()[6]);

			drugDoseIndicationDAO
					.setStrHstrIntraMusclr(vo.getStrAddedData()[7]);

			drugDoseIndicationDAO.setStrHstrMiclanus(vo.getStrAddedData()[8]);

			drugDoseIndicationDAO.setStrHstrOtic(vo.getStrAddedData()[9]);
			// //
			// //System.out.println("vo.getStrAddedData()[9]--->>>>"+vo.getStrAddedData()[9]);

			drugDoseIndicationDAO.setStrHstrMouth(vo.getStrAddedData()[10]);

			drugDoseIndicationDAO.setStrHstrRectal(vo.getStrAddedData()[11]);

			drugDoseIndicationDAO.setStrHstrNasal(vo.getStrAddedData()[12]);

			drugDoseIndicationDAO.setStrHstrInhalton(vo.getStrAddedData()[13]);

			drugDoseIndicationDAO.setStrHstrVaginal(vo.getStrAddedData()[14]);

			drugDoseIndicationDAO.setStrHstrLingual(vo.getStrAddedData()[15]);

			drugDoseIndicationDAO
					.setStrHstrIntraThecal(vo.getStrAddedData()[16]);

			drugDoseIndicationDAO
					.setStrHstrIntraLesioNal(vo.getStrAddedData()[17]);

			drugDoseIndicationDAO
					.setStrHstrExtraAmniotic(vo.getStrAddedData()[18]);

			drugDoseIndicationDAO.setStrHstrEpidural(vo.getStrAddedData()[19]);

			drugDoseIndicationDAO
					.setStrHstrIntraSpinal(vo.getStrAddedData()[20]);

			drugDoseIndicationDAO.setStrHstrSubCuta(vo.getStrAddedData()[21]);

			drugDoseIndicationDAO
					.setStrHstrIntraVesical(vo.getStrAddedData()[22]);

			drugDoseIndicationDAO
					.setStrHstrIntraDermal(vo.getStrAddedData()[23]);

			drugDoseIndicationDAO.setStrHstrTrensDrml(vo.getStrAddedData()[24]);
			// }
			drugDoseIndicationDAO.setStrRemarks(vo.getStrRemarks());

			drugDoseIndicationDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			drugDoseIndicationDAO.setStrLstModSeatId(vo.getStrSeatId());

			drugDoseIndicationDAO.setStrLstModDate(vo.getStrCtDate());

			drugDoseIndicationDAO.setStrEntryDate(vo.getStrCtDate());

			drugDoseIndicationDAO.setStrSeatId(vo.getStrSeatId());

			drugDoseIndicationDAO.setStrIsValid("1");

			drugDoseIndicationDAO.update(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.updateQuery()-->"
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

	public static void initialAddQuery(DrugDosegeIndicationMstVO vo) {
		// //System.out.println("inside dao");
		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		WebRowSet wb = null, wb1 = null;
		String strquery = "";
		String strquery1 = "";

		try {

			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.combo.2");

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.data.1");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);

			dao.setQryValue(nqryIndex1, 1, vo.getStrHospitalCode());

			dao.setQryValue(nqryIndex1, 2, "1");

			wb = dao.executeQry(nqryIndex);

			wb1 = dao.executeQry(nqryIndex1);

			// //System.out.println("Size is::::"+wb.size());

			while (wb1.next()) {
				vo.setStrRemarks(wb1.getString(9));
				vo.setStrEffectiveFrom(wb1.getString(10));
			}

			wb1.beforeFirst();
			// //System.out.println("WebRowSet in DAO size:::"+wb1.size());
			vo.setStrDataWs(wb1);

			vo.setStrGroupNameComboValuesWS(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.initialAddQuery()-->"
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
	public static void getSubGroupCombo(DrugDosegeIndicationMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		// String strquery1 = "";

		try {

			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.combo.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);

			vo.setStrSubGroupNameComboValuesWS(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.getSubGroupCombo()-->"
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
	public static void getDrugCombo(DrugDosegeIndicationMstVO vo) {

		HisDAO dao = null;
		int nqryIndex1;
		WebRowSet wb1 = null;
		// String strquery = "";
		String strquery1 = "";
		try {
			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");
//			//System.out.println(" vo.getStrGrpId() -->>"+vo.getStrGrpId());
//			//System.out.println(" vo.getStrSubGrpId() -->>"+vo.getStrSubGrpId());
//			//System.out.println(" vo.getStrHospitalCode() -->>"+vo.getStrHospitalCode());
			if (vo.getStrSubGrpId().equals("0")
					|| vo.getStrSubGrpId().equals("")
					|| vo.getStrSubGrpId() == null) 
			{
				strquery1 = mms.qryHandler_mms.getQuery(1,
						"select.drugDosIndicationMst.drug.combo.1");

				nqryIndex1 = dao.setQuery(strquery1);

				dao.setQryValue(nqryIndex1, 1, vo.getStrGrpId());
				dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());

			} else {
				strquery1 = mms.qryHandler_mms.getQuery(1,
						"select.drugDosIndicationMst.drug.combo.2");

				nqryIndex1 = dao.setQuery(strquery1);
				dao.setQryValue(nqryIndex1, 1, vo.getStrGrpId());
				dao.setQryValue(nqryIndex1, 2, vo.getStrSubGrpId());
				dao.setQryValue(nqryIndex1, 3, vo.getStrHospitalCode());

			}
			wb1 = dao.executeQry(nqryIndex1);

			 ////System.out.println("Size is::::"+wb1.size());

			vo.setStrDrugNameComboValuesWS(wb1);

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.getDrugCombo()-->"
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
	public static void chkDuplicate(DrugDosegeIndicationMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.duplicate.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemID());
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
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.chkDuplicate()-->"
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
	public static void modifyQuery(DrugDosegeIndicationMstVO vo) {

		HisDAO dao = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		String strquery = "";

		try {

			strtemp = vo.getStrChk1().replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");
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
			vo
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.modifyQuery()-->"
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
	public static void initialUpdateQuery(DrugDosegeIndicationMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugDosegeIndicationMstDAO");
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
					.setStrMsgString("--> DrugDosegeIndicationMstDAO.initialUpdateQuery()-->"
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
