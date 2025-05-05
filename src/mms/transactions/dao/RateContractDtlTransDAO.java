/**
 * 
 */
package mms.transactions.dao;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.RateContractItemDtlDAO;
import mms.transactions.vo.RateContractDtlTransVO;

/**
 * @author Administrator
 * 
 */
public class RateContractDtlTransDAO {

	/**
	 * The following procedure is used to populate the value of Group Name combo
	 * using Pkg_Mms_View.proc_store_group_list procedure.
	 * 
	 * @param voObj
	 */
	public static void getGroupCombo(RateContractDtlTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("RateContractDtlTransDAO_1");
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}"; // 5+2=7
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "item_category",
					vo.getStrItemCategoryNo(), 3);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode(), 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			/* Start Adding Default value */
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "", 4);
			daoObj.setProcInValue(nProcIndex, "strStoreId", "", 5);
			/* End Adding Default value */

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setGroupCmbWS(ws);
				// System.out.println("vo.setGroupCmbWS()-" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("RateContractDtlTransDAO.getGroupCombo() --> "
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
	 * to check duplicate before insert the data
	 * 
	 * @param vo
	 */
	public static void chkDuplicate(RateContractDtlTransVO vo) {

		HisDAO dao = null;

		int ncount = 0;
		String strFuncName = "";
		int nFuncIndex = 0;

		try {
			System.out.println("RateContractDtlTransDAO_2");
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println(" chkDuplicate");
			strFuncName = "{? = call MMS_MST.count_supp_item_contract_check_count(?::numeric,?::numeric,?::numeric,?::numeric,?::numeric,?::character varying,?::character varying)}"; // 6
			nFuncIndex = dao.setFunction(strFuncName);
			// System.out.println(" vo.getStrSU" + vo.getStrSupplierId());
			// System.out.println(" vo.getStrContractTypeID()" + vo.getStrContractTypeID());
			// System.out.println(" vo.getStrHospitalCode()"	 + vo.getStrHospitalCode());

			// System.out.println("vo.getStrRate().length"
			// + vo.getStrRateArray().length);
			int nMultiRowLen = vo.getStrRateArray().length;
			for (int i = 0; i < nMultiRowLen; i++) {
				// System.out.println(" vo.getStrItemID()"
				// + vo.getStrItemIDArray()[i]);
				// System.out.println(" vo.getStrItemBrandID()"
				// + vo.getStrItemBrandIDArray()[i]);

				dao.setFuncInValue(nFuncIndex, 2, vo.getStrSupplierId());
				dao.setFuncInValue(nFuncIndex, 3, vo.getStrContractTypeID());
				dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
				dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemIDArray()[i]);
				dao.setFuncInValue(nFuncIndex, 6, vo.getStrItemBrandIDArray()[i]);
				dao.setFuncInValue(nFuncIndex, 7, vo.getStrContractToDate());
				dao.setFuncInValue(nFuncIndex, 8, vo.getStrContractFromDate());
				
				dao.setFuncOutValue(nFuncIndex, 3);
				dao.executeFuncForNumeric(nFuncIndex);
				ncount = Integer.parseInt(dao.getFuncNumeric(nFuncIndex));
				// System.out.println("DAO ncount" + ncount);
				System.out.println(" vo.ContractToDate()"	 + vo.getStrContractToDate());
				System.out.println(" vo.ContractFromDate()"	 + vo.getStrContractFromDate());
				System.out.println(" vo.Supplier"+ vo.getStrSupplierId());
				System.out.println(" vo.ContractFromDate()"	 + vo.getStrContractFromDate());

				if (ncount == 1) {
					vo.setBExistStatus(true);
				} 
				else if(ncount == -1)
					{
					  throw new Exception(); 
					}
				else {
					vo.setBExistStatus(false);
					break;
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.chkDuplicate()-->"
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
	 * to check duplicate before insert the data
	 * 
	 * @param vo
	 */
	public static void chkLevel(RateContractDtlTransVO vo) {

		HisDAO dao = null;

		int ncount = 0;
		String strFuncName = "";
		int nFuncIndex = 0;

		try {
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println("RateContractDtlTransDAO_3");
			strFuncName = "{? = call MMS_MST.count_supp_item_contract_check_level(?::numeric,?::numeric,?::numeric,?::numeric,?::numeric,?::character varying,?::character varying)}"; // 6
			nFuncIndex = dao.setFunction(strFuncName);
			// System.out.println(" vo.getStrSU" + vo.getStrSupplierId());
			// System.out.println(" vo.getStrContractTypeID()"
			// + vo.getStrContractTypeID());
			// System.out.println(" vo.getStrHospitalCode()"
			// + vo.getStrHospitalCode());

			// System.out.println("vo.getStrRate().length"
			// + vo.getStrRateArray().length);
			int nMultiRowLen = vo.getStrRateArray().length;
			for (int i = 0; i < nMultiRowLen; i++) {
				// System.out.println(" vo.getStrItemID()"
				// + vo.getStrItemIDArray()[i]);
				// System.out.println(" vo.getStrItemBrandID()"
				// + vo.getStrItemBrandIDArray()[i]);

				dao.setFuncInValue(nFuncIndex, 2, vo.getStrSupplierId());
				dao.setFuncInValue(nFuncIndex, 3, vo.getStrContractTypeID());
				dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
				dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemIDArray()[i]);
				dao.setFuncInValue(nFuncIndex, 6,vo.getStrItemBrandIDArray()[i]);
				dao.setFuncInValue(nFuncIndex, 7,vo.getStrContractToDate());
				dao.setFuncInValue(nFuncIndex, 8, vo.getStrContractFromDate());
				
				dao.setFuncOutValue(nFuncIndex, 3);
				dao.executeFuncForNumeric(nFuncIndex);
				ncount = Integer.parseInt(dao.getFuncNumeric(nFuncIndex));
				// System.out.println("DAO ncount" + ncount);

				if (ncount == 1) {
					vo.setBExistStatus(true);
				} 
				else if(ncount == -1)
					{
					  throw new Exception(); 
					}
				else {
					vo.setBExistStatus(false);
					break;
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.chkDuplicate()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	// NOT USED AFTER 3rd JULY 09
	/*	*//**
	 * to check duplicate before renew the contract
	 * 
	 * @param vo
	 */
	/*
	 * public static void chkDuplicateAtRenew(RateContractDtlTransVO vo) {
	 * 
	 * HisDAO dao = null;
	 * 
	 * int ncount = 0; String strFuncName = ""; int nFuncIndex = 0;
	 * 
	 * try { dao = new HisDAO("mms", "RateContractDtlTransDAO");
	 * 
	 * strFuncName = "{? = call Count_SUPP_ITEM_Contract(?,?,?,?,?)}";
	 * nFuncIndex = dao.setFunction(strFuncName); //
	 * System.out.println(" vo.getStrSU" + vo.getStrSupplierId()); //
	 * System.out.println(" vo.getStrContractTypeID()" // +
	 * vo.getStrContractTypeID()); //
	 * System.out.println(" vo.getStrHospitalCode()" // +
	 * vo.getStrHospitalCode());
	 * 
	 * dao.setFuncInValue(nFuncIndex, 2, vo.getStrSupplierId());
	 * dao.setFuncInValue(nFuncIndex, 3, vo.getStrContractTypeID());
	 * dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
	 * dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemID());
	 * dao.setFuncInValue(nFuncIndex, 6, vo.getStrItemBrandID());
	 * dao.setFuncOutValue(nFuncIndex, 1); dao.executeFunction(nFuncIndex);
	 * ncount = Integer.parseInt(dao.getFuncString(nFuncIndex)); //
	 * System.out.println("DAO ncount" + ncount);
	 * 
	 * if (ncount > 1) { vo.setBExistStatus(false); } else {
	 * vo.setBExistStatus(true);
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("--> StoreItemMstDAO.chkDuplicateAtRenew()-->" +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { if (dao != null) {
	 * dao.free(); dao = null; }
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public synchronized static void insertRecord(RateContractDtlTransVO vo) {

		HisDAO dao = null;
		// RateContractDtlDAO rateContractDAO = null;
		RateContractItemDtlDAO rateContractItemDAO = null;
		/*
		 * String strRateContractNo = ""; String strFuncName = ""; int
		 * nFuncIndex = 0;
		 */
		try {
			System.out.println("RateContractDtlTransDAO_4");
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			// rateContractDAO = new RateContractDtlDAO();
			rateContractItemDAO = new RateContractItemDtlDAO();
			int nMultiRowLen = vo.getStrRateArray().length;
			for (int i = 0; i < nMultiRowLen; i++) {
				// rateContractItemDAO.setStrGroupID(vo.getStrGroupIdForItemSearch());
				rateContractItemDAO.setStrHospitalCode(vo.getStrHospitalCode()); // 1
				// rateContractItemDAO.setStrHospitalCode("101"); //1
				rateContractItemDAO.setStrItemBrandID(vo.getStrItemBrandIDArray()[i]);// 2
				rateContractItemDAO.setStrItemID(vo.getStrItemIDArray()[i]);// 3
				rateContractItemDAO.setStrRate(vo.getStrRateArray()[i]);// 4
				rateContractItemDAO.setStrRateUnitID(vo.getStrRateUnitIDArray()[i]);// 5
				rateContractItemDAO.setStrSupplierId(vo.getStrSupplierId());// 6
				rateContractItemDAO.setStrContractFromDate(vo.getStrContractFromDate());// 7
				rateContractItemDAO.setStrContractToDate(vo.getStrContractToDate());// 8
				rateContractItemDAO.setStrContractTypeID(vo.getStrContractTypeID());// 9
				System.out.println("Contract Type :"+ vo.getStrContractTypeID());
				rateContractItemDAO.setStrDeiveryLeadTime(vo.getStrDeiveryLeadTime());// 10
				rateContractItemDAO.setStrDeiveryLeadTimeUnit(vo.getStrDeiveryLeadTimeUnit());// 11
				rateContractItemDAO.setStrFinancialEndYr(vo.getStrFinancialEndYr());// 12
				rateContractItemDAO.setStrFinancialStartYr(vo.getStrFinancialStartYr());// 13
				rateContractItemDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());// 14
				rateContractItemDAO.setStrQuotationNo(vo.getStrQuotationNo());// 15
				rateContractItemDAO.setStrTenderNo(vo.getStrTenderNo());// 16
				rateContractItemDAO.setStrSeatId(vo.getStrSeatId());// 17
				rateContractItemDAO.setStrRemarks(vo.getStrRemarks());// 18
				rateContractItemDAO.setStrTax(vo.getStrItemTax()[i]);// 19
				rateContractItemDAO.setStrTaxType(vo.getStrTaxType());// 20
				rateContractItemDAO.setStrTenderDate(vo.getStrTenderDate());// 21
				rateContractItemDAO.setStrQutationDate(vo.getStrQuotationDate());// 22
				rateContractItemDAO.setStrSecurityAmt(vo.getStrSecurityAmtPercent()[i]);// 23
				rateContractItemDAO.setStrContractQty(vo.getStrRateContQty()[i]);// 24
				rateContractItemDAO.setStrDeliveryDays(vo.getStrDeliveryDays());// 25
		        rateContractItemDAO	.setStrImportedType(vo.getStrImportedType()[i]);// 26
				rateContractItemDAO.setStrShelfLife(vo.getStrShelfLife()[i]); // 27
				rateContractItemDAO.setStrLevel(vo.getStrLevel()[i]);
				rateContractItemDAO.setStrNtDate(vo.getStrNtDate());
				rateContractItemDAO.setStrRCChk("0");//vo.getStrRCChk()[i]);
				rateContractItemDAO.setStrTenderItemNo(vo.getStrTenderItemNo()[i]);
				rateContractItemDAO.setStrPackSize(vo.getStrPackSize()[i]);
				rateContractItemDAO.insert(dao);
			}

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RateContractDtlTransDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			// rateContractDAO = null;
			rateContractItemDAO = null;
		}

	}

	/**
	 * This method is used to all the data from HSTT_RATECONTRACT_DTL and
	 * HSTT_RATECONTRACT_ITEM_DTL table using proc_rate_contract_item_dtls
	 * procedure.
	 * 
	 * @param voObj
	 */
	public static void viewDetails(RateContractDtlTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";
		String strBrandName = "";
		String strItemName = "";

		try {
			daoObj = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println("RateContractDtlTransDAO_5");
			strProcName = "{call Pkg_Mms_View.proc_rate_contract_item_dtls(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);

			// daoObj.setProcInValue(nProcIndex, "rate_contract_no","0",2);
			daoObj.setProcInValue(nProcIndex, "contract_type_id",
					vo.getStrContractTypeID(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "rate_contract_slno",
					vo.getStrSlNo(), 4);
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemID(), 5);
			daoObj.setProcInValue(nProcIndex, "item_brand_id",
					vo.getStrItemBrandID(), 6);
			daoObj.setProcInValue(nProcIndex, "supplier_id",
					vo.getStrSupplierId(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setDetailsWS(ws);
				System.out.println("vo.setDetailsWS()-" + ws.size());
				while (ws.next()) {
					vo.setStrTenderNo(ws.getString(1));
					vo.setStrQuotationNo(ws.getString(2));
					vo.setStrContractDate(ws.getString(3));
					vo.setStrContractFromDate(ws.getString(4));
					vo.setStrContractToDate(ws.getString(5));
					strItemName = ws.getString(6);
					if (strItemName == null) {
						strItemName = "/";
					}
					vo.setStrItemName(strItemName);
					strBrandName = ws.getString(7);
					if (strBrandName == null) {
						strBrandName = "/";
					}
					vo.setStrItemBrandName(strBrandName);
					vo.setStrLastPurchaseRate(ws.getString(8));
					vo.setStrLastPurchaseRateUnit(ws.getString(9));
					vo.setStrRemarks(ws.getString(10));
					vo.setStrDeiveryLeadTime(ws.getString(11));
					vo.setStrDeiveryLeadTimeUnitName(ws.getString(12));
					vo.setStrNextContractFromDate(ws.getString(13));
					vo.setStrRateUnitID(ws.getString(14));
					vo.setStrDeiveryLeadTimeUnit(ws.getString(15));
					if (ws.getString(16) != null) {
						vo.setStrCancelDate(ws.getString(16));
						vo.setStrCancelSeatId(ws.getString(17));
						vo.setStrCancelRemarks(ws.getString(18));
						vo.setStrCancelDtlsFlag("1");

					}
					vo.setStrTenderDate(ws.getString(19));
					vo.setStrQuotationDate(ws.getString(20));
					vo.setStrTax(ws.getString(21));
					vo.setStrTaxType(ws.getString(22));
					vo.setStrTaxTypeValue(ws.getString(23));
					vo.setStrItemBrandID(ws.getString(24));
					vo.setStrContractValidity(ws.getString(25));
					// vo.setStrLastSecurityAmount(ws.getString(26));
					// vo.setStrLastContractQty(ws.getString(27));
					vo.setStrDeliveryDays(ws.getString(26));
					vo.setStrLastSecurityAmount(ws.getString(27));
					// vo.setStrPreviousContractFromDate(ws.getString(29));
					vo.setStrRenewShelfLife(ws.getString(28));
					vo.setStrRenewLevel(ws.getString(29));
					vo.setStrLastContractQty(ws.getString(30));
					vo.setStrImportTypeViewFlag(ws.getString(31));
					vo.setStrRcTenderSno(ws.getString(32));
					vo.setStrRenewPackSize(ws.getString(33));
					System.out.println("rc no---------------"+ws.getString(32));

				}
				getUnitCombo(vo);
				System.out.println("Going inside Prev Contract Dtl.....");
				getPreviousContractDtl(vo);
				System.out.println("cmng outside Prev Contract Dtl.....");

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("RateContractDtlTransDAO.viewDetails() --> "
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
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getPreviousContractDtl(RateContractDtlTransVO vo) {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		String strBrandName = "";
		String strItemName = "";
		try {
			System.out.println("RateContractDtlTransDAO_5");
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");
			strProcName = "{call Pkg_Mms_View.proc_rate_contract_item_dtls(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "contract_type_id",
					vo.getStrContractTypeID(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "rate_contract_slno",
					vo.getStrSlNo(), 4);
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemID(), 5);
			daoObj.setProcInValue(nProcIndex, "item_brand_id",
					vo.getStrItemBrandID(), 6);
			daoObj.setProcInValue(nProcIndex, "supplier_id",
					vo.getStrSupplierId(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (ws.size() != 0) {
					while (ws.next()) {
						vo.setStrPrevRenewTenderNo(ws.getString(1));
						vo.setStrPrevRenewQuotationNo(ws.getString(2));
						vo.setStrPrevRenewDate(ws.getString(3));
						vo.setStrPrevRenewContractFromDate(ws.getString(4));
						vo.setStrPrevRenewContractToDate(ws.getString(5));
						strItemName = ws.getString(6);
						if (strItemName == null) {
							strItemName = "/";
						}
						vo.setStrItemName(strItemName);
						strBrandName = ws.getString(7);
						if (strBrandName == null) {
							strBrandName = "/";
						}
						vo.setStrPrevRenewItemName(strBrandName);
						vo.setStrPrevRenewRate(ws.getString(8));
						vo.setStrPrevRenewRateUnit(ws.getString(9));
						vo.setStrPrevRenewRemarks(ws.getString(10));
						vo.setStrPrevRenewDlvryLeadTime(ws.getString(11));
						vo.setStrPrevRenewDlvryLeadTimeUnitName(ws
								.getString(12));
						vo.setStrPrevTenderDate(ws.getString(16));
						vo.setStrPrevQuotationDate(ws.getString(17));
						vo.setStrPrevTax(ws.getString(18));
						vo.setStrPrevTaxType(ws.getString(19));
						vo.setStrPrevTaxTypeValue(ws.getString(20));
						vo.setStrPrevSecurityAmt(ws.getString(21));
						vo.setStrPrevContractQty(ws.getString(22));

						vo.setStrPrevRenewFlag("1");
					}
				} else {
					vo.setStrPrevRenewFlag("0");
				}
			}

			else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("RateContractDtlTransDAO.getPreviousContractDtl() --> "
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
	 * to insert the data
	 * 
	 * @param vo
	 */
	public synchronized static void insertRenewData(RateContractDtlTransVO vo) {

		HisDAO dao = null;

		RateContractItemDtlDAO rateContractItemDAO = null;
		String[] strRateUnitId = null;

		try {
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println(" ********* RateContractDtlTransDAO. insertRenewData *********  ");
			rateContractItemDAO = new RateContractItemDtlDAO();

			rateContractItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			rateContractItemDAO.setStrItemBrandID(vo.getStrItemBrandID());
			rateContractItemDAO.setStrItemID(vo.getStrItemID());
			rateContractItemDAO.setStrRate(vo.getStrRenewRate());
			strRateUnitId = vo.getStrRenewRateUnitId().replace("^", "#")
					.split("#");

			rateContractItemDAO.setStrRateUnitID(strRateUnitId[0]);

			rateContractItemDAO.setStrSupplierId(vo.getStrSupplierId());
			rateContractItemDAO.setStrContractFromDate(vo
					.getStrContractFromDate());
			rateContractItemDAO.setStrContractToDate(vo.getStrContractToDate());
			rateContractItemDAO.setStrContractTypeID(vo.getStrContractTypeID());
			rateContractItemDAO.setStrDeiveryLeadTime(vo
					.getStrDeiveryLeadTime());
			rateContractItemDAO.setStrDeiveryLeadTimeUnit(vo
					.getStrDeiveryLeadTimeUnit());
			rateContractItemDAO.setStrFinancialEndYr(vo.getStrFinancialEndYr());
			rateContractItemDAO.setStrFinancialStartYr(vo
					.getStrFinancialStartYr());
			rateContractItemDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());
			rateContractItemDAO.setStrQuotationNo(vo.getStrQuotationNo());
			rateContractItemDAO.setStrTenderNo(vo.getStrTenderNo());
			rateContractItemDAO.setStrSeatId(vo.getStrSeatId());
			rateContractItemDAO.setStrRemarks(vo.getStrRemarks());
			rateContractItemDAO.setStrSlNo(vo.getStrSlNo());
			rateContractItemDAO.setStrTax(vo.getStrTax());
			rateContractItemDAO.setStrTaxType(vo.getStrTaxType());
			rateContractItemDAO.setStrTenderDate(vo.getStrTenderDate());
			rateContractItemDAO.setStrQutationDate(vo.getStrQuotationDate());
			rateContractItemDAO.setStrSecurityAmt(vo
					.getStrRenewSecurityAmtPercent());
			rateContractItemDAO.setStrContractQty(vo.getStrRenewRateContQty());
			rateContractItemDAO.setStrDeliveryDays(vo.getStrDeliveryDays());
			rateContractItemDAO.setStrShelfLife(vo.getStrRenewShelfLife());
			rateContractItemDAO.setStrLevel(vo.getStrRenewLevel());
			rateContractItemDAO.setStrNtDate(vo.getStrNtDate());
			rateContractItemDAO.setStrRCChk("0");
			rateContractItemDAO.setStrPackSize(vo.getStrPackSize()[0]);
			rateContractItemDAO.setStrTenderItemNo(vo.getStrRcTenderSno());
			rateContractItemDAO.insert(dao);
			
			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RateContractDtlTransDAO.insertRenewData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			// rateContractDAO = null;
			rateContractItemDAO = null;
		}

	}

	public synchronized static void modifyRecord(RateContractDtlTransVO vo) {

		HisDAO dao = null;

		RateContractItemDtlDAO rateContractItemDAO = null;
		String[] strRateUnitId = null;

		try {
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println("RateContractDtlTransDAO_7");
			rateContractItemDAO = new RateContractItemDtlDAO();

			rateContractItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			rateContractItemDAO.setStrItemBrandID(vo.getStrItemBrandID());
			rateContractItemDAO.setStrItemID(vo.getStrItemID());
			rateContractItemDAO.setStrRate(vo.getStrLastPurchaseRate());
			strRateUnitId = vo.getStrRenewRateUnitId().replace("^", "#")
					.split("#");

			rateContractItemDAO.setStrRateUnitID(strRateUnitId[0]);

			rateContractItemDAO.setStrSupplierId(vo.getStrSupplierId());
			rateContractItemDAO.setStrContractFromDate(vo
					.getStrContractFromDate());
			rateContractItemDAO.setStrContractToDate(vo.getStrContractToDate());
			rateContractItemDAO.setStrContractTypeID(vo.getStrContractTypeID());
			rateContractItemDAO.setStrDeiveryLeadTime(vo
					.getStrDeiveryLeadTime());
			rateContractItemDAO.setStrDeiveryLeadTimeUnit(vo
					.getStrDeiveryLeadTimeUnit());
			rateContractItemDAO.setStrFinancialEndYr(vo.getStrFinancialEndYr());
			rateContractItemDAO.setStrFinancialStartYr(vo
					.getStrFinancialStartYr());
			rateContractItemDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());
			rateContractItemDAO.setStrQuotationNo(vo.getStrQuotationNo());
			rateContractItemDAO.setStrTenderNo(vo.getStrTenderNo());
			rateContractItemDAO.setStrSeatId(vo.getStrSeatId());
			rateContractItemDAO.setStrRemarks(vo.getStrRemarks());
			rateContractItemDAO.setStrSlNo(vo.getStrSlNo());
			rateContractItemDAO.setStrTax(vo.getStrTax());
			rateContractItemDAO.setStrTaxType(vo.getStrTaxType());
			rateContractItemDAO.setStrTenderDate(vo.getStrTenderDate());
			rateContractItemDAO.setStrQutationDate(vo.getStrQuotationDate());
			rateContractItemDAO.setStrSecurityAmt(vo
					.getStrRenewSecurityAmtPercent());
			rateContractItemDAO.setStrContractQty(vo.getStrRenewRateContQty());
			rateContractItemDAO.setStrDeliveryDays(vo.getStrDeliveryDays());
			rateContractItemDAO.setStrShelfLife(vo.getStrRenewShelfLife());
			rateContractItemDAO.setStrLevel(vo.getStrRenewLevel());
			rateContractItemDAO.setStrNtDate(vo.getStrNtDate());
			rateContractItemDAO.setStrTenderItemNo(vo.getStrRcTenderSno());
			rateContractItemDAO.setStrPackSize(vo.getStrPackSize()[0]);
			//rateContractItemDAO.setStrRCChk(vo.getStrRCChk()[0]);
			rateContractItemDAO.modify(dao);

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RateContractDtlTransDAO.insertRenewData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			// rateContractDAO = null;
			rateContractItemDAO = null;
		}

	}

	
	/**
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getUnitCombo(RateContractDtlTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("RateContractDtlTransDAO_8");
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}"; // 5+1=6
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode(), 1);
			dao.setProcInValue(nProcIndex, "unit_id", vo.getStrRateUnitID(), 2);
			System.out.println("unit id:::    " + vo.getStrRateUnitID());
			dao.setProcInValue(nProcIndex, "module_id", "63", 3); // default set
																	// for
																	// module_id
			dao.setProcInValue(nProcIndex, "modeval", "4", 4);
			dao.setProcOutValue(nProcIndex, "err", 1, 5);
			dao.setProcOutValue(nProcIndex, "resultset", 2, 6);
			dao.executeProcedureByPosition(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				vo.setRateUnitWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("RateContractDtlTransDAO.getUnitCombo() --> "
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
	 * to update the record in case of terminate
	 * 
	 * @param vo
	 */
	public synchronized static void updateRecord(RateContractDtlTransVO vo) {

		HisDAO dao = null;

		RateContractItemDtlDAO rateContractItemDAO = null;

		try {
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			System.out.println("RateContractDtlTransDAO_9");
			rateContractItemDAO = new RateContractItemDtlDAO();

			rateContractItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			rateContractItemDAO.setStrItemBrandID(vo.getStrItemBrandID());
			rateContractItemDAO.setStrItemID(vo.getStrItemID());

			rateContractItemDAO.setStrSupplierId(vo.getStrSupplierId());

			rateContractItemDAO.setStrContractTypeID(vo.getStrContractTypeID());

			rateContractItemDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());

			rateContractItemDAO.setStrSeatId(vo.getStrSeatId());
			rateContractItemDAO.setStrCancelRemarks(vo.getStrCancelRemarks());

			rateContractItemDAO.setStrRateContractSLNo(vo.getStrSlNo());
			rateContractItemDAO.update(dao);

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RateContractDtlTransDAO.updateRecord()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			rateContractItemDAO = null;

		}

	}
	
	
	public static void insertRateContractExtension(RateContractDtlTransVO vo) {

		int nProcIndex_U;

		String strProcName_U = "";
		HisDAO dao=null;
		try {
			System.out.println("RateContractDtlTransDAO_9");
			dao = new HisDAO("mms", "RateContractDtlTransDAO");
			
			strProcName_U = "{call pkg_mms_dml.dml_ratecontract_extn_dtls(?,?,?,?,?,  ?,?,?,?,? )}"; // Total 10 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			HisUtil.replaceNullValueWithEmptyString(vo);
			
			/*System.out.println( "p_mode"+ "1");//1				
			System.out.println( "p_hospital_code"+ vo.getStrHospitalCode());//2
			System.out.println( "p_rateContractId"+ vo.getStrContractId());//3
			System.out.println( "p_contract_todate"+ vo.getStrContractToDate());//3
			System.out.println( "p_new_contract_todate"+	vo.getStrNewContractToDate());//4
			System.out.println( "p_letter_no"+	vo.getStrLetterNo());//5
			System.out.println( "p_letter_date"+	vo.getStrLetterDate());//6
			System.out.println( "p_letter_remarks"+ vo.getStrRemarks());//7
			System.out.println( "p_seat_id"+	vo.getStrSeatId());//8
			*/			
			dao.setProcInValue(nProcIndex_U, "p_mode", "1",1);			
			dao.setProcInValue(nProcIndex_U, "p_hospital_code",	vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex_U, "p_rateContractId", vo.getStrContractId(),3);
			dao.setProcInValue(nProcIndex_U, "p_contract_todate", vo.getStrContractToDate(),4);
			dao.setProcInValue(nProcIndex_U, "p_new_contract_todate", vo.getStrNewContractToDate(),5);
			dao.setProcInValue(nProcIndex_U, "p_letter_no",	vo.getStrLettrNo(),6);
			dao.setProcInValue(nProcIndex_U, "p_letter_date",	vo.getStrLetterDate(),7);
			dao.setProcInValue(nProcIndex_U, "p_letter_remarks", vo.getStrRemarks(),8);
			dao.setProcInValue(nProcIndex_U, "p_seat_id",	vo.getStrSeatId(),9);
			dao.setProcOutValue(nProcIndex_U, "err", 1,10);

			dao.execute(nProcIndex_U,1);
			synchronized (dao) {
				dao.fire();
			}
			vo.setStrMsgType("0");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new HisException("DWH","RateContractDtlTransDAO",e.getMessage());
		}
	}

}
