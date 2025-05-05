package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import java.util.Date;

import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.SimpleDateFormat;

import mms.MmsConfigUtil;
import mms.dao.ChallanDtlDAO;
import mms.dao.ChallanItemDtlDAO;
import mms.dao.ChallanVerifiedItemDtlDAO;
import mms.dao.CommitteRemarksDtlDAO;
import mms.global.dao.ItemParameterDetailDAO;
import mms.transactions.vo.ChallanProcessApprovalTransVO;
import mms.transactions.vo.ChallanProcessTransVO;

public class ChallanProcessApprovalTransDAO {

	public static void challanCount(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		String strCount = "0";
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_challanreceive_count(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "ponostore_id", vo.getStrPoStoreId(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "challanCount", 1,7);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				strCount = dao.getString(nprocIndex, "challanCount");

				vo.setStrChallanCount(strCount);

			} else {

				throw new Exception(strerr);

			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("ChallanProcessApprovalTransDAO.challanCount() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void receiveInit(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.Proc_Po_Details(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),3);
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrPoStoreId(),4);

			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (wb != null && wb.next()) {

					vo.setStrPoDate(wb.getString(1));
					vo.setStrSupplierName(wb.getString(2));
					vo.setStrPoType(wb.getString(3));
					vo.setStrCurrencyName(wb.getString(4));
					vo.setStrSupplierId(wb.getString(7));
					vo.setStrPoTypeId(wb.getString(8));
					vo.setStrItemCategoryId(wb.getString(11));
					vo.setStrItemCategoryName(wb.getString(12));
					vo.setStrPurchaseSourceId(wb.getString(13));
					vo.setStrPurchseSource(wb.getString(14));
					vo.setStrCurrencyCode(wb.getString(15));
					vo.setStrCurrencyValue(wb.getString(16));
					vo.setStrPoNoDisplay(wb.getString(18));

				}

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void deliveryModeList(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_deliverymode_dtl(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				vo.setWsDeliveryMode(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.deliveryModeList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void scheduleNoList(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_schedule_dtl(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "po_no", vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "po_storeId", vo.getStrPoStoreId(),3);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),4);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

							
				if (wb != null && wb.next()) {

					vo.setStrScheduleNo(wb.getString(1) + "^" + wb.getString(2)
							+ "^" + wb.getString(3) + "^" + wb.getString(4)
							+ "^" + wb.getString(5));

				}

				wb.beforeFirst();

				vo.setWsScheduleNo(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.scheduleNoList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void scheduleItemList(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_schedule_item_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "po_no",      vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "po_storeId", vo.getStrPoStoreId(),3);
			dao.setProcInValue(nprocIndex, "scheduleNo", vo.getStrScheduleNo().replace("^", "#").split("#")[0],4);
			dao.setProcInValue(nprocIndex, "hosp_code",  vo.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				vo.setWsScheduleItemList(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("ChallanProcessApprovalTransDAO.scheduleNoList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void unitNameCombo(ChallanProcessApprovalTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ChallanProcessApprovalTrans", "ChallanProcessApprovalTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitId(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);//Aritra
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.execute(nProcIndex,1);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsUnitList(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void insert(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanNo = "";
		String strReqTypeId = "68";
		int nFuncIndex = 0;

		ChallanDtlDAO challanDao = null;
		ChallanItemDtlDAO challanItemDao = null;
		// PoItemDtlDAO poItemDao = null;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");

			strFuncName = "{? = call Mms_Mst.generate_challanNo(?, ?, ?, ?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, strReqTypeId);
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strChallanNo = daoObj.getFuncString(nFuncIndex);

			challanDao = new ChallanDtlDAO();

			challanDao.setStrAwbNo(vo.getStrAwbNo());
			challanDao.setStrBeDate(vo.getStrBeDate());
			challanDao.setStrBeNo(vo.getStrBeNo());
			challanDao.setStrChallanNo(strChallanNo);
			challanDao.setStrChallanStatus("1");
			challanDao.setStrDeliverMode(vo.getStrDeliveryMode());
			challanDao.setStrDeliveryDate(vo.getStrDeliveryDate());
			challanDao.setStrFinStartDate(vo.getStrFinancialStartDate());
			challanDao.setStrFinEndDate(vo.getStrFinancialEndDate());
			challanDao.setStrHospitalCode(vo.getStrHospitalCode());
			challanDao.setStrItemCategoryId(vo.getStrItemCategoryId());
			challanDao.setStrPackets(vo.getStrNoOfPackets());
			challanDao.setStrPacketWeight(vo.getStrPackageWeight());
			challanDao.setStrPoDate(vo.getStrPoDate());
			challanDao.setStrPoNo(vo.getStrPoNo());
			challanDao.setStrPoStoreId(vo.getStrPoStoreId());
			challanDao.setStrRemarks(vo.getStrRemarks());
			challanDao.setStrSeatId(vo.getStrSeatId());
			challanDao.setStrStoreId(vo.getStrStoreId());
			challanDao.setStrSupplierId(vo.getStrSupplierId());
			challanDao.setStrReceivedBy(vo.getStrReceivedBy());
			challanDao.setStrScheduleNo(vo.getStrScheduleNo());
			challanDao.setStrScheduleType(vo.getStrScheduleTypeId());
			challanDao.setStrSupplierReceiptNo(vo.getStrSupplierReceiptNo());
			challanDao.setStrSupplierReceiptDate(vo.getStrSupplierReceiptDate());

			challanDao.insert(daoObj);

			if (vo.getStrItemDtls() != null && vo.getStrItemDtls().length > 0) {

				challanItemDao = new ChallanItemDtlDAO();

				// poItemDao = new PoItemDtlDAO();

				for (int i = 0; i < vo.getStrItemDtls().length; i++) {

					String[] strItemDtls = vo.getStrItemDtls()[i].replace("^",
							"#").split("#");

					challanItemDao.setStrChallanNo(strChallanNo);
					challanItemDao.setStrBalanceQty(strItemDtls[2]);
					challanItemDao.setStrBalanceQtyUnitId(strItemDtls[3]);
					challanItemDao.setStrGroupId(strItemDtls[8]);
					challanItemDao.setStrHospitalCode(vo.getStrHospitalCode());
					challanItemDao.setStrItemId(strItemDtls[0]);
					challanItemDao.setStrItemBrandId(strItemDtls[1]);
					challanItemDao.setStrPoNo(vo.getStrPoNo());
					challanItemDao.setStrPoStoreId(vo.getStrPoStoreId());
					challanItemDao.setStrRecieveQty(vo.getStrReceivedQty()[i]);
					challanItemDao.setStrRecieveQtyUnitId(vo
							.getStrReceivedUnitId()[i].replace("^", "#").split(
							"#")[0]);
					challanItemDao.setStrRemarks(vo.getStrRemarks());
					challanItemDao.setStrScheduleNo(vo.getStrScheduleNo());
					challanItemDao
							.setStrScheduleType(vo.getStrScheduleTypeId());
					challanItemDao.setStrStoreId(vo.getStrStoreId());
					challanItemDao.setStrSubGroupId(strItemDtls[9]);

					challanItemDao.insert(daoObj);

					/*
					 * poItemDao.setStrItemId(strItemDtls[0]);
					 * poItemDao.setStrItemBrandId(strItemDtls[1]);
					 * poItemDao.setStrPoNo(vo.getStrPoNo());
					 * poItemDao.setStrStoreId(vo.getStrPoStoreId());
					 * poItemDao.setStrScheduleNo(vo.getStrScheduleNo());
					 * poItemDao.setStrRecieveQty(vo.getStrReceivedQty()[i]);
					 * poItemDao.setStrRecieveQtyUnitId(vo.getStrReceivedUnitId()[i].replace("^",
					 * "#").split("#")[0]);
					 * poItemDao.setStrHospitalCode(vo.getStrHospitalCode());
					 * 
					 * poItemDao.update(daoObj);
					 */

				}

			}

			synchronized (daoObj) {
				daoObj.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	public static void getChallanDetails(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_challan_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao
					.setProcInValue(nprocIndex, "schedule_no", vo
							.getStrScheduleNo(),2);
			dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (wb != null && wb.next()) {

					vo.setStrDeliveryDate(wb.getString(1));
					vo.setStrActualDeliveryDate(wb.getString(2));
					vo.setStrScheduleTypeId(wb.getString(3));
					vo.setStrScheduleType(wb.getString(4));
					vo.setStrCommitteeType(wb.getString(5));
					
					vo.setStrChallanReceiptNo(wb.getString(6));//Supplier Receipt No.
					

				}

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getChallanDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getChallanItemDetails(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_challan_item_dtl(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "schedule_no", vo.getStrScheduleNo(),2);
			dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrGenericItemId(),5);
			dao.setProcInValue(nprocIndex, "itembrand_id", vo.getStrItemBrandId(),6);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.execute(nprocIndex,1);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (wb != null && wb.next()) {

					vo.setStrGroupId(wb.getString(1));
					vo.setStrSubGroupId(wb.getString(2));
					vo.setStrReceivedQuantity(wb.getString(3));
					vo.setStrReceivedQuantityUnitId(wb.getString(4));
					vo.setStrBalanceQuantity(wb.getString(5));
					vo.setStrBalanceQuantityUnitId(wb.getString(6));
					vo.setStrGroupName(wb.getString(7));
					vo.setStrSubGroupName(wb.getString(8));
					vo.setStrReceivedQuantityView(wb.getString(9));
					vo.setStrBalanceQuantityView(wb.getString(10));
					vo.setStrGenericItemName(wb.getString(11));
					vo.setStrItemBrandName(wb.getString(12));
					vo.setStrRate(wb.getString(13));
					vo.setStrRateUnit(wb.getString(14));
					vo.setStrRateView(wb.getString(15));
					vo.setStrManufacturerId(wb.getString(16));
					vo.setStrManufacturerName(wb.getString(17));
					vo.setStrWarrantyFlag(wb.getString(18));
					vo.setStrInstallFlag(wb.getString(19));
					vo.setStrReceivedQuantityUnitBaseValue(wb.getString(20));
					vo.setStrBalanceQuantityUnitBaseValue(wb.getString(21));
					vo.setStrVerifiedQuantity(wb.getString(22));
					vo.setStrVerifiedQuantityUnitId(vo
							.getStrBalanceQuantityUnitId());
					vo.setStrVerifiedQuantityView(wb.getString(22) + " "
							+ wb.getString(23));
					vo.setStrPreviousExcessQtyView(wb.getString(24) + " "
							+ wb.getString(26));
					vo.setStrAcceptedQuantityView(wb.getString(27));
					vo.setStrRejectedQuantityView(wb.getString(28));
					vo.setStrBreakageQuantityView(wb.getString(29));
					vo.setStrVerifiedQuantityInBaseVal(wb.getString(30));
					////System.out.println("Compsot Unit->>"+wb.getString(31));
					////System.out.println("rate Unit->>"+wb.getString(32));
					vo.setStrCompositeUnitId(wb.getString(31));
					vo.setStrCompRateUnitId(wb.getString(32));
					vo.setStrUnitId(vo.getStrReceivedQuantityUnitId());

				}

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getChallanItemDetails() --> "
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
	 * 
	 */

	public static void getSuppliedByList(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryId(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			/*Start*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/*End*/
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.execute(nprocIndex,1);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setWsManufacturer(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getSuppliedByList() --> "
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
	 * Gets the item mandatory details.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the item mandatory details
	 */
	public static void getItemMandatoryDetails(ChallanProcessApprovalTransVO vo) {

		String strMode = "1";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_item_mandatory_dtls(?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getItemMandatoryDetails(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode,1);

			dao.setProcInValue(procIndex1, "item_id", vo.getStrGenericItemId(),2);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(procIndex1, "ERR", 1,4); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,5); // 2 for object

			// execute procedure

			dao.execute(procIndex1,1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.next()) {

				String strTemp[] = ws.getString(1).replace("^", "#").split("#");

				vo.setIsBatchReq(strTemp[0]);
				vo.setIsExpirtReq(strTemp[2]);

			}

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemMandatoryDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void rateUnitCombo(ChallanProcessApprovalTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ChallanProcessApprovalTrans", "ChallanProcessApprovalTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrRateUnit(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",3);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);//Aritra
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);
			daoObj.execute(nProcIndex,1);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsRateUnit(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {

			vo.setStrMsgString("ChallanProcessApprovalTransDAO.rateUnitCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to fetch details for member detail combo
	 * 
	 * @param _SampleRegisterTransVO
	 */
	public static void getMemberDtl(ChallanProcessApprovalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SampleRegisterTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "commiteeTypeId", vo
					.getStrCommitteeType(),2);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryId(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),4);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "modval","1",1);
			//dao.setProcInValue(nprocIndex, "commNo","");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setWsCommitteeMemberList(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SampleRegisterTransDAO.getMemberDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCommitteeTypeDtl(ChallanProcessApprovalTransVO vo) {
		String strproc_name = "";
		String strReqTypeId = "68";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SampleRegisterTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryId(),3);
			dao.setProcInValue(nprocIndex, "reqType", strReqTypeId,4);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.execute(nprocIndex,1);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				vo.setWsCommitteeType(wb);
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();

			vo
					.setStrMsgString("SampleRegisterTransDAO.getCommitteeTypeDtl() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getBalanceQtyDetails(ChallanProcessApprovalTransVO vo) {

		String strMode = "5";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getBalanceQtyDetails(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode,1);

			dao.setProcInValue(procIndex1, "item_id", vo.getStrGenericItemId(),5);
			dao.setProcInValue(procIndex1, "item_brand_id", vo
					.getStrItemBrandId(),6);
			dao
					.setProcInValue(procIndex1, "schedule_no", vo
							.getStrScheduleNo(),7);
			dao.setProcInValue(procIndex1, "pono", vo.getStrPoNo(),4);
			dao.setProcInValue(procIndex1, "storeid", vo.getStrPoStoreId(),3);

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "ERR", 1,8); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,9); // 2 for object
			// execute
			// procedure

			dao.execute(procIndex1,1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.next()) {

				vo.setStrOrderedQuantityView(ws.getString(1));
				vo.setStrAcceptedQuantityView(ws.getString(2));
				vo.setStrRejectedQuantityView(ws.getString(3));

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getBalanceQtyDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getChallanItemCount(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");

			strFuncName = "{? = call Mms_Mst.Get_challanCount_Dtls(?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

//			//System.out.println("Hosp=(getChallanItemCount)=>"+vo.getStrHospitalCode());
//			//System.out.println("getStrChallanNo=(getChallanItemCount)=>"+vo.getStrChallanNo());
//			//System.out.println("getStrStoreId=(getChallanItemCount)=>"+vo.getStrStoreId());
//			//System.out.println("getStrGenericItemId=(getChallanItemCount)=>"+vo.getStrGenericItemId());
//			//System.out.println("getStrItemBrandId=(getChallanItemCount)=>"+vo.getStrItemBrandId());
			
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrChallanNo());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrGenericItemId());
			daoObj.setFuncInValue(nFuncIndex, 6, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strChallanItemCount = daoObj.getFuncString(nFuncIndex);

			vo.setStrChallanCount(strChallanItemCount);

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getChallanItemCount() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	public static void getCancelChallanItemCount(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");

			strFuncName = "{? = call Mms_Mst.get_cancelchallanItemCount(?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrChallanNo());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strChallanItemCount = daoObj.getFuncString(nFuncIndex);

			vo.setStrChallanCount(strChallanItemCount);

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getCancelChallanItemCount() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	public static void getCancelChallanCount(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");

			strFuncName = "{? = call Mms_Mst.get_cancelchallanCount(?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrPoNo());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrPoStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strChallanItemCount = daoObj.getFuncString(nFuncIndex);

			vo.setStrChallanCount(strChallanItemCount);

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ChallanProcessApprovalTransDAO.getCancelChallanCount() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	/*public static void getPoItemCount(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strPoItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");

			strFuncName = "{? = call Mms_Mst.Get_poItemCount_Dtls(?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrPoNo());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrScheduleNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrPoStoreId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strPoItemCount = daoObj.getFuncString(nFuncIndex);

			vo.setStrPoItemCount(strPoItemCount);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.getPoItemCount() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}*/

	public synchronized static void verifyInsert(ChallanProcessApprovalTransVO vo) {

		HisDAO daoObj = null;

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";
		String strProcName4 = "";
		String strProcName5 = "";
		// String strProcName6 = "";
		String strProcName7 = "";
		String strProcName8 = "";
	//	String strProcName9 = "";
		String strProcName10 = "";
		String strProcName11 = "";
		String strProcName12 = "";

		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		int nProcIndex4 = 0;
		int nProcIndex5 = 0;
		// int nProcIndex6 = 0;
		int nProcIndex7 = 0;
		int nProcIndex8 = 0;
		//int nProcIndex9 = 0;
		int nProcIndex10 = 0;
		int nProcIndex11 = 0;
		int nProcIndex12 = 0;

		ItemParameterDetailDAO itemParameterDetailDAO = null;
		ChallanVerifiedItemDtlDAO challanVerifiedItemDAO = null;
		ChallanItemDtlDAO challanItemDao = null;
		ChallanDtlDAO challanDao = null;
		CommitteRemarksDtlDAO committeRemarks = null;
		try {
			daoObj = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");
			itemParameterDetailDAO = new ItemParameterDetailDAO();
			challanVerifiedItemDAO = new ChallanVerifiedItemDtlDAO();
			challanItemDao = new ChallanItemDtlDAO();
			committeRemarks = new CommitteRemarksDtlDAO();
			challanDao = new ChallanDtlDAO();
			
			challanVerifiedItemDAO.setExpiryDate(vo.getStrExpiryDate());
			challanVerifiedItemDAO.setManufactureDate(vo.getStrManufactureDate());
			challanVerifiedItemDAO.setStrAcceptedQty(vo.getStrAcceptedQuantity());
			challanVerifiedItemDAO.setStrAcceptedQtyUnitId(vo.getStrAcceptedQuantityUnitId());
			challanVerifiedItemDAO.setStrBatchSlNo(vo.getStrBatchNo());
			challanVerifiedItemDAO.setStrBreakageQty(vo.getStrBreakageQuantity());
			challanVerifiedItemDAO.setStrBreakageQtyUnitId(vo.getStrBreakageQuantityUnitId());
			challanVerifiedItemDAO.setStrChallanNo(vo.getStrChallanNo());
			challanVerifiedItemDAO.setStrExcessQty(vo.getStrExcessQty());
			challanVerifiedItemDAO.setStrExcessQtyUnitId(vo.getStrExcessQtyUnitId());
			challanVerifiedItemDAO.setStrGroupId(vo.getStrGroupId());
			challanVerifiedItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			challanVerifiedItemDAO.setStrInHandQty(vo.getStrAcceptedQuantity());
			challanVerifiedItemDAO.setStrInHandQtyUnitId(vo.getStrAcceptedQuantityUnitId());
			challanVerifiedItemDAO.setStrItemBrandId(vo.getStrItemBrandId());
			challanVerifiedItemDAO.setStrItemId(vo.getStrGenericItemId());
			challanVerifiedItemDAO.setStrPoNo(vo.getStrPoNo());
			challanVerifiedItemDAO.setStrPoStoreId(vo.getStrPoStoreId());
			challanVerifiedItemDAO.setStrRate(vo.getStrRate());
			challanVerifiedItemDAO.setStrRateUnitId(vo.getStrRateUnit());
			challanVerifiedItemDAO.setStrRejectedQty(vo.getStrRejectedQuantity());
			challanVerifiedItemDAO.setStrRejectedQtyUnitId(vo.getStrRejectedQuantityUnitId());
			challanVerifiedItemDAO.setStrRemarks(vo.getStrRemarks());
			challanVerifiedItemDAO.setStrScheduleNo(vo.getStrScheduleNo());
			challanVerifiedItemDAO.setStrSeatId(vo.getStrSeatId());
			challanVerifiedItemDAO.setStrStoreId(vo.getStrStoreId());
			challanVerifiedItemDAO.setStrSubGroupId(vo.getStrSubGroupId());
			challanVerifiedItemDAO.setStrMode("1");
			
			challanVerifiedItemDAO.insert(daoObj);  // PKG_MMS_DML.Dml_CHALLAN_VERIFIEDITEM_DTL  Mode =1

			/*
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenericItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo	.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCategoryId());
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", "10");
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0");
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrAcceptedQuantity());
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrAcceptedQuantityUnitId());
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrManufacturerId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo.getStrRateUnit());
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice());
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo.getStrSalePriceUnitId());
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate());
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo.getStrSupplierId());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo.getStrReceiveDate());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "description","Through Item Inventory Process");

			daoObj.setProcInValue(nProcIndex, "currencyCode", vo.getStrCurrencyCode());
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo.getStrCurrencyValue());

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0");
			}

			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "partFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "partFlag", "0");
			}

			if (vo.getStrWarrantyFlag().equals("1")) {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
			}

			if (vo.getStrItemParamDtls() != null
					&& vo.getStrItemParamDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
			}

			if (vo.getStrPoTypeId().equals("21")
					|| vo.getStrPoTypeId().equals("25")
					|| vo.getStrPoTypeId().equals("26")
					|| vo.getStrPoTypeId().equals("27")) {

				daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "0");

			} else {

				daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1");

			}
			
			 Start 
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1");
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0");
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0");
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0");
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0");
			daoObj.setProcInValue(nProcIndex, "old_strid", "0");
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
			daoObj.setProcInValue(nProcIndex, "invoiceNo", "");
			daoObj.setProcInValue(nProcIndex, "invoiceDate", "");
			daoObj.setProcInValue(nProcIndex, "item_specification", "");
			 End 

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);

			daoObj.execute(nProcIndex, 1);
*/			// no stock update wrt Req No. 1 (CR No /GGSH/488) ,doc MMS_GGSH_ DCD_28Feb13_2.doc
			
			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) {

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					daoObj.setProcInValue(nProcIndex2, "modval", "1",1);
					daoObj.setProcInValue(nProcIndex2, "itemid", vo
							.getStrGenericItemId(),2);
					daoObj.setProcInValue(nProcIndex2, "itembrandid", vo
							.getStrItemBrandId(),3);
					daoObj.setProcInValue(nProcIndex2, "batchno", vo
							.getStrBatchNo(),4);
					daoObj.setProcInValue(nProcIndex2, "freeitemid",
							strItemOtherVal[1],5);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",
							strItemOtherVal[2],6);
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
							strItemOtherVal[3],7);
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",
							strItemOtherVal[0],8);
					daoObj.setProcInValue(nProcIndex2, "expirydate",
							strItemOtherVal[4],9);
					daoObj.setProcInValue(nProcIndex2, "manufdate",
							strItemOtherVal[5],10);
					daoObj.setProcInValue(nProcIndex2, "qty",
							strItemOtherVal[6],11);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",
							strItemOtherVal[7],12);
					daoObj.setProcInValue(nProcIndex2, "hosp_code", vo
							.getStrHospitalCode(),13);
					
					/* Setting Default Value Start*/
					daoObj.setProcInValue(nProcIndex2, "transNo", "0",14);
					daoObj.setProcInValue(nProcIndex2, "strId", "0",15);
					/* Setting Default Value End */
					

					daoObj.setProcOutValue(nProcIndex2, "err", 1,16);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1,17);

					daoObj.execute(nProcIndex2, 1);

				}

			strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Part_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0)
				for (int i = 0; i < vo.getStrItemPartDtls().length; i++) {

					String strTemp = vo.getStrItemPartDtls()[i];
					String[] strItemPartVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex3 = daoObj.setProcedure(strProcName3);

					daoObj.setProcInValue(nProcIndex3, "modval", "1",1);
					daoObj.setProcInValue(nProcIndex3, "itemid", vo
							.getStrGenericItemId(),2);
					daoObj.setProcInValue(nProcIndex3, "itembrandid", vo
							.getStrItemBrandId(),3);
					daoObj.setProcInValue(nProcIndex3, "batchno", vo
							.getStrBatchNo(),4);
					daoObj.setProcInValue(nProcIndex3, "partitemid",
							strItemPartVal[1],5);
					daoObj.setProcInValue(nProcIndex3, "partitembrandid",
							strItemPartVal[2],6);
					
					if(strItemPartVal[3] != null && strItemPartVal[3].length() != 0){
						
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								strItemPartVal[3],7);
					}else{
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								"0",7);
					}
					
					
					daoObj.setProcInValue(nProcIndex3, "partitemcatno",
							strItemPartVal[0],8);
					daoObj.setProcInValue(nProcIndex3, "expirydate",
							strItemPartVal[4],9);
					daoObj.setProcInValue(nProcIndex3, "manufdate",
							strItemPartVal[5],10);
					daoObj
							.setProcInValue(nProcIndex3, "qty",
									strItemPartVal[6],12);
					daoObj.setProcInValue(nProcIndex3, "qtyunitid",
							strItemPartVal[7],13);

					daoObj.setProcInValue(nProcIndex3, "manufid",
							strItemPartVal[8],11);

					daoObj.setProcInValue(nProcIndex3, "comp_type",
							strItemPartVal[9],15);
					
					daoObj.setProcInValue(nProcIndex3, "is_separate",
							strItemPartVal[10],16);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_period",
							strItemPartVal[11],17);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_Unit",
							strItemPartVal[12],18);
					
					daoObj.setProcInValue(nProcIndex3, "hosp_code", vo
							.getStrHospitalCode(),14);
					
					/* Start */
					daoObj.setProcInValue(nProcIndex3, "transNo","0",19);
					daoObj.setProcInValue(nProcIndex3, "strId","0",20);
					/* End */

					daoObj.setProcOutValue(nProcIndex3, "err", 1,21);
					daoObj.setProcOutValue(nProcIndex3, "dml_count", 1,22);

					daoObj.execute(nProcIndex3, 1);

				}

			if (vo.getStrWarrantyFlag().equals("1")) {

				strProcName4 = "{call PKG_MMS_DML.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex4 = daoObj.setProcedure(strProcName4);

				daoObj.setProcInValue(nProcIndex4, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex4, "item_id", vo
						.getStrGenericItemId(),2);
				daoObj.setProcInValue(nProcIndex4, "item_brand_id", vo
						.getStrItemBrandId(),3);
				daoObj.setProcInValue(nProcIndex4, "batch_sl_no", vo
						.getStrBatchNo(),4);
				daoObj.setProcInValue(nProcIndex4, "hosp_code", vo
						.getStrHospitalCode(),5);
				daoObj.setProcInValue(nProcIndex4, "warrenty_date", vo
						.getStrWarrantyDate(),6);
				daoObj.setProcInValue(nProcIndex4, "manuf_id", vo
						.getStrWarantyManufacturer(),7);
				daoObj.setProcInValue(nProcIndex4, "po_no", vo.getStrPoNo(),8);
				daoObj.setProcInValue(nProcIndex4, "warrenty_upto", vo
						.getStrWarrantyUpTo(),9);
				daoObj.setProcInValue(nProcIndex4, "warrenty_unitid", vo
						.getStrWarrantyUpToUnit(),10);
				daoObj.setProcInValue(nProcIndex4, "fin_start_yr", vo
						.getStrFinancialStartDate(),11);
				daoObj.setProcInValue(nProcIndex4, "fin_end_yr", vo
						.getStrFinancialEndDate(),12);
				daoObj.setProcInValue(nProcIndex4, "remarks", vo
						.getStrWarrantyRemarks(),13);
				
				/* Start */
				daoObj.setProcInValue(nProcIndex4, "transNo","0",16);
				daoObj.setProcInValue(nProcIndex4, "strId","0",15);
				/* End */
				
				daoObj
						.setProcInValue(nProcIndex4, "seat_id", vo
								.getStrSeatId(),14);

				daoObj.setProcOutValue(nProcIndex4, "err", 1,17);

				daoObj.execute(nProcIndex4, 1);

			}

			if (vo.getStrInstallFlag().equals("1")) {

				strProcName5 = "{call PKG_MMS_DML.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex5 = daoObj.setProcedure(strProcName5);

				daoObj.setProcInValue(nProcIndex5, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex5, "item_id", vo
						.getStrGenericItemId(),2);
				daoObj.setProcInValue(nProcIndex5, "item_brand_id", vo
						.getStrItemBrandId(),3);
				daoObj.setProcInValue(nProcIndex5, "batch_sl_no", vo
						.getStrBatchNo(),4);
				daoObj.setProcInValue(nProcIndex5, "hosp_code", vo
						.getStrHospitalCode(),5);
				daoObj.setProcInValue(nProcIndex5, "install_start_date", vo
						.getStrInstallStartDate(),6);

				daoObj.setProcInValue(nProcIndex5, "install_end_date", vo
						.getStrInstallEndDate(),7);

				daoObj.setProcInValue(nProcIndex5, "po_no", vo.getStrPoNo(),8);
				daoObj.setProcInValue(nProcIndex5, "install_status", vo
						.getStrInstallStatus(),9);
				daoObj.setProcInValue(nProcIndex5, "install_by", vo
						.getStrInstallBy(),10);

				daoObj.setProcInValue(nProcIndex5, "installer_contactNo", vo
						.getStrInstallerContactNo(),11);

				daoObj.setProcInValue(nProcIndex5, "fin_start_yr", vo
						.getStrFinancialStartDate(),12);
				daoObj.setProcInValue(nProcIndex5, "fin_end_yr", vo
						.getStrFinancialEndDate(),13);
				daoObj.setProcInValue(nProcIndex5, "remarks", vo
						.getStrInstallRemarks(),14);
				
				/* Start */
				daoObj.setProcInValue(nProcIndex5, "transNo","0",17);
				daoObj.setProcInValue(nProcIndex5, "strId","0",16);
				/* End */
				
				daoObj
						.setProcInValue(nProcIndex5, "seat_id", vo
								.getStrSeatId(),15);

				daoObj.setProcOutValue(nProcIndex5, "err", 1,18);

				daoObj.execute(nProcIndex5, 1);

			}

			if (vo.getStrParamCheck() != null)
				if (vo.getStrParamCheck().length > 0) {

					for (int i = 0; i < vo.getStrParamCheck().length; i++) {

						String[] strTemp = vo.getStrParamCheck()[i].replace(
								"^", "#").split("#");

						itemParameterDetailDAO.setStrHospitalCode(vo
								.getStrHospitalCode());
						itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());
						itemParameterDetailDAO.setStrItemId(vo
								.getStrItemBrandId());
						itemParameterDetailDAO.setStrParentParamId(strTemp[0]);
						itemParameterDetailDAO.setStrParamId(strTemp[1]);
						itemParameterDetailDAO.setStrParamValue(vo
								.getStrParamValue()[i]);
						itemParameterDetailDAO.setStrRemarks("");

						itemParameterDetailDAO.insertItemParameterDtls(daoObj);

					}

				}

			challanItemDao.setStrAcceptedQty(vo.getStrAcceptedQuantity());
			challanItemDao.setStrAcceptedQtyUnitId(vo
					.getStrAcceptedQuantityUnitId());
			challanItemDao.setStrBreakageQty(vo.getStrBreakageQuantity());
			challanItemDao.setStrBreakageQtyUnitId(vo
					.getStrBreakageQuantityUnitId());
			challanItemDao.setStrRejectedQty(vo.getStrRejectedQuantity());
			challanItemDao.setStrRejectedQtyUnitId(vo
					.getStrRejectedQuantityUnitId());
			challanItemDao.setStrExcessQty(vo.getStrExcessQty());
			challanItemDao.setStrExcessQtyUnitId(vo.getStrExcessQtyUnitId());
			//System.out.println("******vo.getStrVerifyFlag(INSERT)==>"+vo.getStrVerifyFlag());
			challanItemDao.setStrVerifyFlag(vo.getStrVerifyFlag());
			challanItemDao.setStrStoreId(vo.getStrStoreId());
			challanItemDao.setStrChallanNo(vo.getStrChallanNo());
			challanItemDao.setStrItemId(vo.getStrGenericItemId());
			challanItemDao.setStrItemBrandId(vo.getStrItemBrandId());
			challanItemDao.setStrHospitalCode(vo.getStrHospitalCode());

			challanItemDao.update(daoObj);

			if (vo.getStrVerifyFlag().equals("1")) {

				strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";//37

				nProcIndex7 = daoObj.setProcedure(strProcName7);

				daoObj.setProcInValue(nProcIndex7, "modeval", "4",1);
				daoObj.setProcInValue(nProcIndex7, "store_id", vo
						.getStrPoStoreId(),3);
				daoObj.setProcInValue(nProcIndex7, "pono", vo.getStrPoNo(),2);
				daoObj.setProcInValue(nProcIndex7, "schedule_no", vo
						.getStrScheduleNo(),6);
				daoObj.setProcInValue(nProcIndex7, "item_id", vo
						.getStrGenericItemId(),4);
				daoObj.setProcInValue(nProcIndex7, "item_brand_id", vo
						.getStrItemBrandId(),5);
				daoObj.setProcInValue(nProcIndex7, "hosp_code", vo
						.getStrHospitalCode(),7);
				daoObj.setProcInValue(nProcIndex7, "rejected_qty", vo
						.getStrRejectedQuantity(),18);
				daoObj.setProcInValue(nProcIndex7, "rejected_qty_unit", vo
						.getStrRejectedQuantityUnitId(),19);
				daoObj.setProcInValue(nProcIndex7, "breakage_qty", vo
						.getStrBreakageQuantity(),20);
				daoObj.setProcInValue(nProcIndex7, "breakage_qty_unit", vo
						.getStrBreakageQuantityUnitId(),21);
				daoObj.setProcInValue(nProcIndex7, "accepted_qty", vo
						.getStrAcceptedQuantity(),16);
				daoObj.setProcInValue(nProcIndex7, "accepted_qty_unit", vo
						.getStrAcceptedQuantityUnitId(),17);

				daoObj.setProcInValue(nProcIndex7, "challanNo", vo.getStrChallanNo(),31);
				
				daoObj.setProcInValue(nProcIndex7, "raising_store", vo.getStrStoreId(),32);
				
				
				/* Start */
				daoObj.setProcInValue(nProcIndex7, "supplier","0",8);
				daoObj.setProcInValue(nProcIndex7, "groupid","0",9);
				daoObj.setProcInValue(nProcIndex7, "subgroup_id","0",10);
				daoObj.setProcInValue(nProcIndex7, "manuf_id","0",11);
				daoObj.setProcInValue(nProcIndex7, "rate","0",12);
				daoObj.setProcInValue(nProcIndex7, "rate_unit","0",13);
				daoObj.setProcInValue(nProcIndex7, "order_qty","0",14);
				daoObj.setProcInValue(nProcIndex7, "order_qty_unit","0",15);
				daoObj.setProcInValue(nProcIndex7, "warrenty_req","0",22);
				daoObj.setProcInValue(nProcIndex7, "installation_req","0",23);
				daoObj.setProcInValue(nProcIndex7, "remarks","",24);
				daoObj.setProcInValue(nProcIndex7, "item_tax","0",25);
				daoObj.setProcInValue(nProcIndex7, "return_qty","0",26);
				daoObj.setProcInValue(nProcIndex7, "return_qty_unit","0",27);
				daoObj.setProcInValue(nProcIndex7, "recieved_qty","0",28);
				daoObj.setProcInValue(nProcIndex7, "recieved_qty_unit","0",29);
				daoObj.setProcInValue(nProcIndex7, "req_no","0",30);
				daoObj.setProcInValue(nProcIndex7, "po_type","0",33);
				daoObj.setProcInValue(nProcIndex7, "item_make","1",34);
				daoObj.setProcInValue(nProcIndex7, "delivery_loc","-",35);
				daoObj.setProcInValue(nProcIndex7, "itemName","",36);
				//daoObj.setProcInValue(nProcIndex7, "po_date","");
				
				/* End */
				
				daoObj.setProcOutValue(nProcIndex7, "err", 1,37);

				daoObj.execute(nProcIndex7, 1);

				getChallanItemCount(vo);
				
				//System.out.println("In Challan Verify Insert Count==>"+vo.getStrChallanCount());

				if (vo.getStrChallanCount().equals("0")) 
				{

					strProcName8 = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	// 34 Variable

					nProcIndex8 = daoObj.setProcedure(strProcName8);

					daoObj.setProcInValue(nProcIndex8, "modval", "2",1);
					daoObj.setProcInValue(nProcIndex8, "challanNo", vo.getStrChallanNo(),2);
					daoObj.setProcInValue(nProcIndex8, "store_id", vo.getStrStoreId(),6);
					daoObj.setProcInValue(nProcIndex8, "hosp_code", vo.getStrHospitalCode(),4);
					
					/* Start */
					daoObj.setProcInValue(nProcIndex8, "po_No", "",3);
					
					
					
					daoObj.setProcInValue(nProcIndex8, "cat_Code", "0",5);
					daoObj.setProcInValue(nProcIndex8, "supplier_id", "",7);
					daoObj.setProcInValue(nProcIndex8, "awb_No", "",8);
					daoObj.setProcInValue(nProcIndex8, "po_Date", "",9);
					daoObj.setProcInValue(nProcIndex8, "be_No", "",10);
					
					daoObj.setProcInValue(nProcIndex8, "be_Date", "",11);
					daoObj.setProcInValue(nProcIndex8, "packets", "",12);
					daoObj.setProcInValue(nProcIndex8, "pkg_weight", "",13);
					daoObj.setProcInValue(nProcIndex8, "delivery_Date", "",14);
					daoObj.setProcInValue(nProcIndex8, "delivery_Mode", "",15);
					
					daoObj.setProcInValue(nProcIndex8, "committee_type", "",16);
					daoObj.setProcInValue(nProcIndex8, "committee_Rmks_SlNo", "",17);
					daoObj.setProcInValue(nProcIndex8, "committee_No", "",18);
					daoObj.setProcInValue(nProcIndex8, "challan_Status", "",19);
					daoObj.setProcInValue(nProcIndex8, "fin_start_year", "",20);
					
					daoObj.setProcInValue(nProcIndex8, "fin_end_year", "",21);
					daoObj.setProcInValue(nProcIndex8, "remarks", "",22);
					daoObj.setProcInValue(nProcIndex8, "seat_id", "",23);
					daoObj.setProcInValue(nProcIndex8, "po_store_id", "",24);
					daoObj.setProcInValue(nProcIndex8, "received_By", "",25);
					
					daoObj.setProcInValue(nProcIndex8, "scheduleNo", "0",26);
					daoObj.setProcInValue(nProcIndex8, "scheduleType", "0",27);
					daoObj.setProcInValue(nProcIndex8, "sup_rec_no", "0",28);
					daoObj.setProcInValue(nProcIndex8, "sup_rec_date", "",29);
					//daoObj.setProcInValue(nProcIndex8, "challan_recv_date", "");
					
					daoObj.setProcInValue(nProcIndex8, "strFileNo", "",30);
					daoObj.setProcInValue(nProcIndex8, "strPageNo", "",31);
					daoObj.setProcInValue(nProcIndex8, "strFileChallanName", "",32);
					/* End */

					daoObj.setProcOutValue(nProcIndex8, "err", 1,33);

					daoObj.execute(nProcIndex8, 1);

				/*	if (Double.parseDouble(vo.getStrBreakageQuantity()) > 0
							|| Double.parseDouble(vo.getStrRejectedQuantity()) > 0
							|| Double.parseDouble(vo.getStrExcessQty()) > 0) {
*/
						strProcName10 = "{call PKG_MMS_DML.DML_RETURN_SUPPLIER_DTL(?,?,?,?,?,?,?,?,?)}";

						nProcIndex10 = daoObj.setProcedure(strProcName10);

						daoObj.setProcInValue(nProcIndex10, "modval", "1",1);

						daoObj.setProcInValue(nProcIndex10, "strId", vo
								.getStrStoreId(),2);
						daoObj.setProcInValue(nProcIndex10, "itemcatNo", vo
								.getStrItemCategoryId(),4);
						daoObj.setProcInValue(nProcIndex10, "hosp_code", vo
								.getStrHospitalCode(),3);
						daoObj.setProcInValue(nProcIndex10, "challanNo", vo
								.getStrChallanNo(),6);
						
						daoObj.setProcInValue(nProcIndex10, "seatId", vo.getStrSeatId(),5);
						
						/* Start */
						daoObj.setProcInValue(nProcIndex10, "returnNo","",7);
						daoObj.setProcInValue(nProcIndex10, "issueNo","",8);  
						/* End */

						daoObj.setProcOutValue(nProcIndex10, "err", 1,9);
						daoObj.execute(nProcIndex10, 1);

			//		}

					/*if (vo.getStrPoTypeId().equals("21")
							|| vo.getStrPoTypeId().equals("25")
							|| vo.getStrPoTypeId().equals("26")
							|| vo.getStrPoTypeId().equals("27")) {*/

						strProcName11 = "{call PKG_MMS_DML.DML_LP_RECIEVE_AUTO_DTL(?,?,?,?,?,?,?,?,?,?,?)}";

						nProcIndex11 = daoObj.setProcedure(strProcName11);

					
						daoObj.setProcInValue(nProcIndex11, "strId", vo
								.getStrStoreId(),2);
						daoObj.setProcInValue(nProcIndex11, "itemcatNo", vo
								.getStrItemCategoryId(),3);
						daoObj.setProcInValue(nProcIndex11, "hosp_code", vo
								.getStrHospitalCode(),1);
						daoObj.setProcInValue(nProcIndex11, "seatId", vo
								.getStrSeatId(),4);
						daoObj.setProcInValue(nProcIndex11, "poNo", vo
								.getStrPoNo(),5);
						daoObj.setProcInValue(nProcIndex11, "poDate", vo
								.getStrPoDate(),6);
						daoObj.setProcInValue(nProcIndex11, "poStrId", vo
								.getStrPoStoreId(),7);
						daoObj.setProcInValue(nProcIndex11, "poTypeId", vo
								.getStrPoTypeId(),8);
						daoObj.setProcInValue(nProcIndex11, "challanNo", vo
								.getStrChallanNo(),9);
						daoObj.setProcInValue(nProcIndex11, "challanDate", vo.getStrReceiveDate(),10);

						daoObj.setProcOutValue(nProcIndex11, "err", 1,11);
						daoObj.execute(nProcIndex11, 1);

						strProcName12 = "{call PKG_MMS_DML.DML_PENELTY_CALCULATE_DTL(?,?,?,?,?,?,?,?,?,?,?)}";

						nProcIndex12 = daoObj.setProcedure(strProcName12);

						daoObj.setProcInValue(nProcIndex12, "modval", "1",1);
						
						daoObj.setProcInValue(nProcIndex12, "hosp_code", vo.getStrHospitalCode(),2);
						daoObj.setProcInValue(nProcIndex12, "challanNo", vo
								.getStrChallanNo(),3);
						daoObj.setProcInValue(nProcIndex12, "strId", vo
								.getStrStoreId(),4);
						daoObj.setProcInValue(nProcIndex12, "challanDate", vo.getStrReceiveDate(),5);
						daoObj.setProcInValue(nProcIndex12, "deliveryDate", vo
								.getStrActualDeliveryDate(),6);
						daoObj.setProcInValue(nProcIndex12, "poNo", vo
								.getStrPoNo(),7);
						daoObj.setProcInValue(nProcIndex12, "scheduleNo", vo
								.getStrScheduleNo(),8);
						daoObj.setProcInValue(nProcIndex12, "poStrId", vo
								.getStrPoStoreId(),9);
						daoObj.setProcInValue(nProcIndex12, "seatId", vo
								.getStrSeatId(),10);

						daoObj.setProcOutValue(nProcIndex12, "err", 1,11);
						daoObj.execute(nProcIndex12, 1);

					//}

				}

			//	getPoItemCount(vo);

			/*	if (vo.getStrPoItemCount().equals("0")) {

					strProcName9 = "{call dml_hstt_po_schedule_dtl(?,?,?,?,?,?)}";

					nProcIndex9 = daoObj.setProcedure(strProcName9);

					daoObj.setProcInValue(nProcIndex9, "modeval", "5");

					daoObj.setProcInValue(nProcIndex9, "pono", vo.getStrPoNo());
					daoObj.setProcInValue(nProcIndex9, "schedule_no", vo
							.getStrScheduleNo());
					daoObj.setProcInValue(nProcIndex9, "store_id", vo
							.getStrPoStoreId());
					daoObj.setProcInValue(nProcIndex9, "hosp_code", vo
							.getStrHospitalCode());
					daoObj.setProcOutValue(nProcIndex9, "err", 1);

					daoObj.execute(nProcIndex9, 1);

				}*/

			}
			if (vo.getStrCommitteeMemberHidden() != null)
			{

				String strQuery = "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"
						+ "	where HSTNUM_COMMITTEE_NO= ?  and GNUM_HOSPITAL_CODE=? ";

				String[] strTemp = vo.getStrCommitteeMemberHidden()[0].replace('@','#').split("#");

				int nQueryIndex = daoObj.setQuery(strQuery);
				daoObj.setQryValue(nQueryIndex, 1, strTemp[1]);
				daoObj.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
				WebRowSet web = daoObj.executeQry(nQueryIndex);
				String maxSlno = "0";
				if (web != null && web.next()) 
				{
					maxSlno = web.getString(1);
				}
				challanDao.setStrCommitteeNo(strTemp[1]);
				challanDao.setStrCommitteeType(vo.getStrCommitteeType());
				challanDao.setStrCommitteeRemarksSlNo(maxSlno);
				challanDao.setStrChallanNo(vo.getStrChallanNo());
				challanDao.setStrStoreId(vo.getStrStoreId());
				challanDao.setStrHospitalCode(vo.getStrHospitalCode());
				challanDao.setStrFileNo(vo.getStrFileNo());
				challanDao.setStrPageNo(vo.getStrPageNo());
				challanDao.setStrFileChallanName(vo.getStrFileName());
				challanDao.update2(daoObj);
								
				for (int i = 0; i < vo.getStrCommitteeMemberHidden().length; i++)
				{
					strTemp = vo.getStrCommitteeMemberHidden()[i].replace('@','#').split("#");
					committeRemarks.setStrEmpCode(strTemp[0]);
					committeRemarks.setStrCommitteNo(strTemp[1]);
					committeRemarks.setStrMemberName(strTemp[2]);
					committeRemarks.setStrHospCode(vo.getStrHospitalCode());
					committeRemarks.setRemarks(vo.getStrMemberRecommendation()[i]);
					committeRemarks.setStrCommitteTypeId(vo.getStrCommitteeType());
					committeRemarks.setStrCommRemarksSlNo(maxSlno);
					committeRemarks.insert(daoObj);
				}
			}
			
			daoObj.fire();
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.verifyInsert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	public static void cancelChallan(ChallanProcessApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		ChallanItemDtlDAO challanItemDao = null;
		ChallanDtlDAO challanDao = null;
		ChallanVerifiedItemDtlDAO challanVerifiedItemDAO = null;
		HisDAO dao = null;
		HisDAO dao2 = null;
		HisDAO dao3 = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.updatePoDetails(MmsVO vo)");

			challanItemDao = new ChallanItemDtlDAO();
			challanDao = new ChallanDtlDAO();
			challanVerifiedItemDAO	=	new ChallanVerifiedItemDtlDAO();
			
			challanVerifiedItemDAO.setExpiryDate("");
			challanVerifiedItemDAO.setManufactureDate("");
			challanVerifiedItemDAO.setStrAcceptedQty("");
			challanVerifiedItemDAO.setStrAcceptedQtyUnitId("");
			challanVerifiedItemDAO.setStrBatchSlNo("");
			challanVerifiedItemDAO.setStrBreakageQty("");
			challanVerifiedItemDAO.setStrBreakageQtyUnitId("");
			challanVerifiedItemDAO.setStrChallanNo(vo.getStrChallanNo());
			challanVerifiedItemDAO.setStrExcessQty("");
			challanVerifiedItemDAO.setStrExcessQtyUnitId("");
			challanVerifiedItemDAO.setStrGroupId("");
			challanVerifiedItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			challanVerifiedItemDAO.setStrInHandQty("");
			challanVerifiedItemDAO.setStrInHandQtyUnitId("");
			challanVerifiedItemDAO.setStrItemBrandId(vo.getStrItemBrandId());
			challanVerifiedItemDAO.setStrItemId(vo.getStrGenericItemId());
			challanVerifiedItemDAO.setStrPoNo("");
			challanVerifiedItemDAO.setStrPoStoreId("");
			challanVerifiedItemDAO.setStrRate("");
			challanVerifiedItemDAO.setStrRateUnitId("");
			challanVerifiedItemDAO.setStrRejectedQty("");
			challanVerifiedItemDAO.setStrRejectedQtyUnitId("");
			challanVerifiedItemDAO.setStrRemarks("");
			challanVerifiedItemDAO.setStrScheduleNo("");
			challanVerifiedItemDAO.setStrSeatId("");
			challanVerifiedItemDAO.setStrStoreId(vo.getStrStoreId());
			challanVerifiedItemDAO.setStrSubGroupId("");
			challanVerifiedItemDAO.setStrMode("2");
			
			challanVerifiedItemDAO.insert(dao);
			
			
			
			
			
			challanItemDao.setStrChallanNo(vo.getStrChallanNo());
			challanItemDao.setStrHospitalCode(vo.getStrHospitalCode());
			challanItemDao.setStrStoreId(vo.getStrStoreId());
			challanItemDao.setStrItemId(vo.getStrGenericItemId());
			challanItemDao.setStrItemBrandId(vo.getStrItemBrandId());
			challanItemDao.setStrRemarks(vo.getStrRemarks());
			challanItemDao.setStrSeatId(vo.getStrSeatId());

			challanItemDao.update2(dao);

			synchronized (dao) {
				dao.fire();
			}	
			
			getCancelChallanItemCount(vo);

					
			if (vo.getStrChallanCount().equals("0")) {

				dao2 = new HisDAO("mms", "global.MmsDAO.cancelChallan(MmsVO vo)");
				
				challanDao.setStrChallanNo(vo.getStrChallanNo());
				challanDao.setStrStoreId(vo.getStrStoreId());
				challanDao.setStrHospitalCode(vo.getStrHospitalCode());

				challanDao.update(dao2);

				synchronized (dao2) {
					dao2.fire();
				}
				
			}

			vo.setStrChallanCount("0");

			getCancelChallanCount(vo);

				
			if (vo.getStrChallanCount().equals("0")) {

				dao3 = new HisDAO("mms", "global.MmsDAO.cancelChallan(MmsVO vo)");
				
				String proc_name1 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?)}"; //34+2=36 variable
				procIndex1 = dao3.setProcedure(proc_name1);

				// set value
				dao3.setProcInValue(procIndex1, "modeval", "3",1);
				dao3.setProcInValue(procIndex1, "pono", vo.getStrPoNo(),2);
				dao3.setProcInValue(procIndex1, "store_id", vo.getStrPoStoreId(),8);
				dao3.setProcInValue(procIndex1, "hosp_code", vo
						.getStrHospitalCode(),3);
				
				/* Start */
				dao3.setProcInValue(procIndex1, "item_cat", "0",4);
				dao3.setProcInValue(procIndex1, "po_type_id", "0",5);
				dao3.setProcInValue(procIndex1, "currency_id", "0",6);
				dao3.setProcInValue(procIndex1, "pur_source", "",7);
				dao3.setProcInValue(procIndex1, "supplier", "0",9);
				//dao3.setProcInValue(procIndex1, "delevery_location", "0");
				dao3.setProcInValue(procIndex1, "tender_no", "0",11);
				dao3.setProcInValue(procIndex1, "tender_date", "",12);
				dao3.setProcInValue(procIndex1, "quotation_no", "0",13);
				dao3.setProcInValue(procIndex1, "quotation_date", "",14);
				dao3.setProcInValue(procIndex1, "net_advance", "0",15);
				dao3.setProcInValue(procIndex1, "po_status", "0",16);
				dao3.setProcInValue(procIndex1, "fin_start_date", "",17);
				dao3.setProcInValue(procIndex1, "fin_end_date", "",18);
				dao3.setProcInValue(procIndex1, "net_penelty", "0",19);
				dao3.setProcInValue(procIndex1, "po_remarks", "",20);
				dao3.setProcInValue(procIndex1, "cancel_flag", "0",21);
				dao3.setProcInValue(procIndex1, "currency_value", "0",22);
				dao3.setProcInValue(procIndex1, "waivoff", "0",23);
				dao3.setProcInValue(procIndex1, "advance_adjusted", "0",24);
				dao3.setProcInValue(procIndex1, "po_prefix", "0",25);
				dao3.setProcInValue(procIndex1, "seat_id", "0",26);
				dao3.setProcInValue(procIndex1, "paid_bill_amt", "0",27);
				dao3.setProcInValue(procIndex1, "tax", "0",28);
				dao3.setProcInValue(procIndex1, "net_amount", "0",29);
				dao3.setProcInValue(procIndex1, "issueNo", "0",30);
				dao3.setProcInValue(procIndex1, "reqTypeId", "0",31);
				dao3.setProcInValue(procIndex1, "verified_by", "",32);
				dao3.setProcInValue(procIndex1, "verified_date", vo.getStrCtDate(),33);//current date
				//dao3.setProcInValue(procIndex1, "po_ref_no","",34);
				dao3.setProcInValue(procIndex1, "po_date","",10);
				/* End */
				dao3.setProcInValue(procIndex1, "dcomments","-");
				dao3.setProcInValue(procIndex1, "dnotes","-");
				dao3.setProcOutValue(procIndex1, "ERR", 1,34); // 1 for string
															// return
				dao3.execute(procIndex1, 1);

				synchronized (dao3) {
					dao3.fire();
				}
				
				err = dao3.getString(procIndex1, "ERR");

				if (err == null)
					err = "";

				if (!err.equals(""))
					throw new Exception(err);
				
			}

			
		} catch (Exception e) {
		
			vo
					.setStrMsgString("MmsDAO.cancelChallan() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	
	public static void cancelVerifiedChallan(ChallanProcessApprovalTransVO vo) {

		String err = "",strProcName="";
		int procIndex1 = 0,nProc1Index=0;

		ChallanItemDtlDAO challanItemDao = null;
		ChallanDtlDAO challanDao = null;
		ChallanVerifiedItemDtlDAO challanVerifiedItemDAO = null;
		HisDAO dao = null;		

		try {

			dao = new HisDAO("mms", "global.MmsDAO.updatePoDetails(MmsVO vo)");

			challanItemDao = new ChallanItemDtlDAO();
			challanDao = new ChallanDtlDAO();	
			
			
			
			
			challanItemDao.setStrChallanNo(vo.getStrChallanNo());
			challanItemDao.setStrHospitalCode(vo.getStrHospitalCode());
			challanItemDao.setStrStoreId(vo.getStrStoreId());
			challanItemDao.setStrItemId(vo.getStrGenericItemId());
			challanItemDao.setStrItemBrandId(vo.getStrItemBrandId());
			challanItemDao.setStrRemarks(vo.getStrRemarks());
			challanItemDao.setStrSeatId(vo.getStrSeatId());

			challanItemDao.updateCancelVerifiedChallan(dao);

			
		
					
				challanDao.setStrChallanNo(vo.getStrChallanNo());
				challanDao.setStrStoreId(vo.getStrStoreId());
				challanDao.setStrHospitalCode(vo.getStrHospitalCode());
				challanDao.updateCancelVerifiedChallanDetails(dao);	
		

				
				strProcName = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//20+16+1=37
				nProc1Index = dao.setProcedure(strProcName);        			
	 			
	 			
	 			dao.setProcInValue(nProc1Index, "modeval", "1",1);
				dao.setProcInValue(nProc1Index, "pono", vo.getStrPoNo(),2);
				dao.setProcInValue(nProc1Index, "store_id", vo.getStrStoreId(),3);
				dao.setProcInValue(nProc1Index, "item_id",vo.getStrGenericItemId(),4);
				dao.setProcInValue(nProc1Index, "item_brand_id",vo.getStrItemBrandId(),5);
				dao.setProcInValue(nProc1Index, "schedule_no", vo.getStrScheduleNo(),6);
				dao.setProcInValue(nProc1Index, "hosp_code",vo.getStrHospitalCode(),7);
				dao.setProcInValue(nProc1Index, "supplier","0",8);
				dao.setProcInValue(nProc1Index, "groupid","0",9);
				dao.setProcInValue(nProc1Index, "subgroup_id","0",10);
				dao.setProcInValue(nProc1Index, "manuf_id","0",11);
				dao.setProcInValue(nProc1Index, "rate","0",12);
				dao.setProcInValue(nProc1Index, "rate_unit","0",13);
				dao.setProcInValue(nProc1Index, "order_qty", "0",14);
				dao.setProcInValue(nProc1Index, "order_qty_unit", "0",15);
				dao.setProcInValue(nProc1Index, "warrenty_req","0",22);
				dao.setProcInValue(nProc1Index, "installation_req","0",23);
				dao.setProcInValue(nProc1Index, "remarks","0",24);
				dao.setProcInValue(nProc1Index, "item_tax","0",25);
				dao.setProcOutValue(nProc1Index, "err", 1,37);

				/* Start Adding Default value*/
				dao.setProcInValue(nProc1Index, "accepted_qty", "0",16); 
				dao.setProcInValue(nProc1Index, "accepted_qty_unit", "0",17);
				dao.setProcInValue(nProc1Index, "rejected_qty", "0",18);
				dao.setProcInValue(nProc1Index, "rejected_qty_unit", "0",19);
				dao.setProcInValue(nProc1Index, "breakage_qty", "0",20);
				dao.setProcInValue(nProc1Index, "breakage_qty_unit", "0",21);
				dao.setProcInValue(nProc1Index, "return_qty", "0",26); 
				dao.setProcInValue(nProc1Index, "return_qty_unit", "0",27);
				dao.setProcInValue(nProc1Index, "recieved_qty", "0",28);
				dao.setProcInValue(nProc1Index, "recieved_qty_unit", "0",29);
				dao.setProcInValue(nProc1Index, "req_no", "0",30);
				dao.setProcInValue(nProc1Index, "challanNo", "0",31);
				dao.setProcInValue(nProc1Index, "raising_store", "0",32);
				dao.setProcInValue(nProc1Index, "po_type", "0",33);
				dao.setProcInValue(nProc1Index, "item_make", "1",34);
				dao.setProcInValue(nProc1Index, "delivery_loc", "1",35);
				dao.setProcInValue(nProc1Index, "itemName", "",36);
			//	dao.setProcInValue(nProc1Index, "po_date","");
				
			
	 		     
				synchronized (dao) {
					dao.fire();
				}
				
				err = dao.getString(procIndex1, "ERR");

				if (err == null)
					err = "";

				if (!err.equals(""))
					throw new Exception(err);				
		
			
		} catch (Exception e) {
		
			vo
					.setStrMsgString("MmsDAO.cancelChallan() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} 
		finally 
		{

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	/**
	 * This function is used to set initial values in Received by combo.
	 * @param _ItemTransferTransVO
	 */
	public static void setRecievedByCombo(ChallanProcessApprovalTransVO _ChallanProcessApprovalTransVO)
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			System.out.println("-- ChallanProcessApprovalTransDAO . setRecievedByCombo --");
			daoObj  = new HisDAO("MMSModule","ChallanProcessApprovalTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _ChallanProcessApprovalTransVO.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId", _ChallanProcessApprovalTransVO.getStrSeatId(),4);
			daoObj.setProcInValue(nProcIndex, "deptunitcode","0",2);//Aritra
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
			daoObj.execute(nProcIndex,1);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				_ChallanProcessApprovalTransVO.setRecievedByWS(ws);
			}
		}
		catch(Exception _err)
		{
			_ChallanProcessApprovalTransVO.setStrMsgString("ChallanProcessApprovalTransDAO.setRecievedByCombo() --> "
					+ _err.getMessage());
			_ChallanProcessApprovalTransVO.setStrMsgType("1");
		}
	}
	
		/**
	 * Gets the pO details.
	 * @author santoshsinghchauhan
	 * @param vo the vo
	 * 
	 * @return the pO details
	 */
	public static void getPODetails(ChallanProcessApprovalTransVO vo) {		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_po_detail_info(?,?,?,?,?, ?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
						
			dao.setProcInValue(nprocIndex, "modval", "8",1);
			dao.setProcInValue(nprocIndex, "item_category", "0",2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nprocIndex, "store_Id", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNo(),5);			
			dao.setProcInValue(nprocIndex, "po_frmdate", "0",6);
			dao.setProcInValue(nprocIndex, "po_todate", "0",7);
			dao.setProcInValue(nprocIndex, "schedule_no", "0",8);
			dao.setProcOutValue(nprocIndex, "err", 1,9);
			dao.setProcOutValue(nprocIndex, "resultset", 2,10);
			
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");					        	
				vo.setWsPODtls(ws);
				while(ws.next())
				{
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));
				}				
			} else {
				throw new Exception(strerr);
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.getPODetails() --> "
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
	 * Gets the challan received details.
	 * @author santoshsinghchauhan
	 * @param vo the vo
	 * 
	 * @return the challan received details
	 */
	public static void getChallanReceivedDetails(ChallanProcessApprovalTransVO vo) {		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_challan_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "challan_no", "",3);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),4);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),5);			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");					        	
				vo.setWsChallanDtls(ws);							
			} else {
				throw new Exception(strerr);
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.getChallanReceivedDetails() --> "
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
	 * Gets the received item details.
	 * @author santoshsinghchauhan
	 * @param vo the vo
	 * 
	 * @return the received item details
	 */
	public static void getReceivedItemDetails(ChallanProcessApprovalTransVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_challan_item_dtl(?,?,?,?,? ,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "2",1);
			dao.setProcInValue(nprocIndex, "schedule_no", vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "item_id", "0",5);
			dao.setProcInValue(nprocIndex, "itembrand_id", "0",6);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			
			dao.execute(nprocIndex,1);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsReceivedItemDtls(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.getReceivedItemDetails() --> "
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
 * Gets the verified item details.
 * @author santoshsinghchauhan
 * @param vo the vo
 * 
 * @return the verified item details
 */
public static void getVerifiedItemDetails(ChallanProcessApprovalTransVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL(?,?,?,?,? ,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval", "2",1);
			dao.setProcInValue(nprocIndex, "strId", vo.getStrItemId(),2);
			dao.setProcInValue(nprocIndex, "lPRequestNo", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo", "0",5);
			dao.setProcInValue(nprocIndex, "poStoreId", vo.getStrItemBrandId(),6);			
			dao.setProcOutValue(nprocIndex, "err", 1,7);
			dao.setProcOutValue(nprocIndex, "resultset", 2,8);
			
			dao.execute(nprocIndex,1);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsVerifiedItemDtls(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessApprovalTransDAO.getVerifiedItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}


public static void getChallanDetailFreeze(ChallanProcessApprovalTransVO vo) {		
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet ws = null;
	try {
		dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
		
		System.out.println("-------- ChallanProcessApprovalTransDATA. getChallanDetailFreeze --[ PKG_MMS_VIEW.Proc_Challan_Approval_Detail Mode - 1]--");
		 
		strproc_name = "{call PKG_MMS_VIEW.Proc_Challan_Approval_Detail(?,?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
					
		dao.setProcInValue(nprocIndex, "modeval", "1",1);
		dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
		dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
		dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),4);
		dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),5);			
		dao.setProcOutValue(nprocIndex, "err", 1,6);
		dao.setProcOutValue(nprocIndex, "challan_app_dtl_cursor", 2,7);
		dao.executeProcedureByPosition(nprocIndex);

		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";

		if (strerr.equals("")) {
			ws = dao.getWebRowSet(nprocIndex, "challan_app_dtl_cursor");					        	
			vo.setWrsChallanDtl(ws);							
		} else {
			throw new Exception(strerr);
		}
		
	} catch (Exception e) {
		vo.setStrMsgString("ChallanProcessApprovalTransDAO.getChallanDetailFreeze() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}

public static void getVerifiedItemDetailsForFreeze(ChallanProcessApprovalTransVO vo) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet ws = null;
	try {
		dao = new HisDAO("mms", "ChallanProcessApprovalTransDAO");
		
		System.out.println("-------- ChallanProcessApprovalTransDATA. getVerifiedItemDetailsForFreeze --[ PKG_MMS_VIEW.proc_challan_approvalItem_dtl Mode - 1]--");
		
		strproc_name = "{call PKG_MMS_VIEW.proc_challan_approvalItem_dtl(?,?,?,?,?,?,?,?,?)}"; // total 9 Var
		nprocIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nprocIndex, "modeval", "1",1);
//		//System.out.println("hosp_code==>"+vo.getStrHospitalCode());
//		//System.out.println("challan_no==>"+vo.getStrChallanNo());
//		//System.out.println("itemId==>"+vo.getStrGenericItemId());
//		//System.out.println("itembrandId==>"+vo.getStrItemBrandId());
//		//System.out.println("store_id==>"+vo.getStrPoStoreId());
//		//System.out.println("pono==>"+vo.getStrPoNo());
		
		
		dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
		dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
		dao.setProcInValue(nprocIndex, "itemId", "0",4);//vo.getStrGenericItemId(),4);
		dao.setProcInValue(nprocIndex, "itembrandId", "0",5);//vo.getStrItemBrandId(),5);
		dao.setProcInValue(nprocIndex, "store_id", vo.getStrPoStoreId(),6);
		dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),7);	
		dao.setProcOutValue(nprocIndex, "err", 1,8);
		dao.setProcOutValue(nprocIndex, "resultset", 2,9);
		dao.executeProcedureByPosition(nprocIndex);
		
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";

		if (strerr.equals("")) {
			ws = dao.getWebRowSet(nprocIndex, "resultset");		
			vo.setWrsVerifiedItemDtl(ws);							
		} else {
			throw new Exception(strerr);
		}	

	} catch (Exception e) {
		vo.setStrMsgString("ChallanProcessApprovalTransDAO.getVerifiedItemDetails() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}


// Methods starts from here

public synchronized static void insertFreezeChallan(ChallanProcessApprovalTransVO vo) {

	HisDAO dao = null;

	String   strFuncName = "";
	String  strChallanNo = "";
	String  strReqTypeId = "68";
	String   strProcName = "";
	int       nProcIndex = 0;
	int       nFuncIndex = 0;
	ChallanDtlDAO                          challanDao = null;
	ChallanItemDtlDAO                  challanItemDao = null;
	ChallanVerifiedItemDtlDAO  challanVerifiedItemDAO = null;
	try 
	{
		dao = new HisDAO("MMS", "ChallanProcessApprovalTransDAO");
		
		int len = vo.getStrHiddenVerifiedChallanValue().length;
		
		/* Resultset of  strHiddenVerifiedChallanValue
		 * 
		 * 
		 * 1.hstnum_item_id
		 * 2.hstnum_itembrand_id
		 * 3.Drug Name 
		 * 4.hststr_batch_sl_no
		 * 5.expiry_date
		 * 6.qty [hstnum_accepted_qty ||''^''|| NVL(HSTNUM_ACCEPTEDQTY_UNITID,0)|| '^'|| hstnum_breakage_qty ||''^''|| NVL(HSTNUM_BREAKQTY_UNITID,0) || '^'|| hblnum_rejected_qty||''^''|| NVL(HBLNUM_REJECTEDQTY_UNITID,0)  || '^' || hstnum_inhand_qty||''^''|| NVL(HSTNUM_INHAND_QTY_UNITID,0) ||'^'|| hstnum_excess_qty ||''^''|| NVL(HSTNUM_EXCESSQTY_UNITID,0)||'^'|| hstnum_shortage_qty||''^''|| NVL(HSTNUM_SHORT_QTY_UNITID,0) ||'^'|| hstnum_recieved_qty||''^''|| NVL(HSTNUM_RECQTY_UNITID,0) ||'^'|| hstnum_qc_rej_qty||''^''|| NVL(HSTNUM_QC_REJQTY_UNITID,0) ||'^'|| hstnum_temp_qty ||'^'|| hstnum_rate||''^''|| NVL(HSTNUM_RATE_UNITID,0)||''^''|| NVL(HSTNUM_RATE,0)] 
		 * 7.status [decode(gnum_isvalid,9, 'Active',2, 'Verified',1, 'Freezed')]
		 * 8.hstnum_store_id 
		 * 9.hstnum_po_store_id
		 * 10.hstnum_supplier_id
		 * 11.hstnum_group_id
		 * 12.hstnum_subgroup_id
		 * 13.hstnum_po_no
		 * 14.hstnum_schedule_no
		 * 15.verify_date
		 * 16.mfg_date
		 * 17.cancel_date
		 * 17.flags [hstnum_qc_req_flag || '^'|| hstnum_backlog_verify_flag || '^'|| hstnum_qc_report_status || '^'|| hstnum_is_online_data]
		 * 19.gstr_remarks 
		 * 20.hststr_cancel_remarks
		 * 21.hstnum_tax
		 * 22.hstnum_penelty
		 * 23.hstnum_modify_count
		 * 24.max(hstnum_slno)
		 * 25.base_unit_name
		 * 26.total_batch
		 * 27. QC_FLAG
		 * 28. HSTDT_PO_DATE
	     * 29 HSTSTR_DEMAND_YEAR
	     * 30 HSTDT_CHALLAN_DATE
		 * 31 HSTDT_RECIEVED_DATE
		 * 32 SSTNUM_POTYPE_ID
		 * 33.Item Catg
		 * 34.Manufacter Id
		 */
		
		
		challanDao = new ChallanDtlDAO();

					
		/*********************************************** 1 ******************************************************/
		
		System.out.println("-------- ChallanProcessApprovalTransDAO. insertFreezeChallan----- START ----");
		
		
//		    for(int i=0;i<len;i++) 	// There is no need of loop, so running the loop only once but loop is kept for future use
			for(int i=0;i<len;i++)
			{				
								
				System.out.println("-------- PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL [ Mode - 5 ] --------");
				
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "modval", 			"5",1);
				dao.setProcInValue(nProcIndex, "challanNo", 		vo.getStrChallanNo(),4);
				dao.setProcInValue(nProcIndex, "po_No", 			vo.getStrPoNo(),2);
				dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),7);
				dao.setProcInValue(nProcIndex, "store_id", 			vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex, "item_id",			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[0],5);
				dao.setProcInValue(nProcIndex, "item_brand_id", 	vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[1],6);
				dao.setProcInValue(nProcIndex, "schedule_No", 		"0",8);
				dao.setProcInValue(nProcIndex, "schedule_Type", 	"0",10);
				dao.setProcInValue(nProcIndex, "group_id", 			"0",9);
				dao.setProcInValue(nProcIndex, "subgroup_id", 		"0",11);
				dao.setProcInValue(nProcIndex, "balance_qty", 		"0",12);
				dao.setProcInValue(nProcIndex, "balance_qtyUnitId", "0",13);
				dao.setProcInValue(nProcIndex, "recieve_qty", 		"0",14);
				dao.setProcInValue(nProcIndex, "recieve_qtyUnitId",	"0",15);
				dao.setProcInValue(nProcIndex, "remarks", 			vo.getStrRemarks(),16);
				dao.setProcInValue(nProcIndex, "po_store_id", 		vo.getStrPoStoreId(),17);
				
				/* Setting Default Value Start*/
				dao.setProcInValue(nProcIndex, "acceptedQty", 		"0",18); // Temporarly This Variable is Used To Enter Received date in Table 
				dao.setProcInValue(nProcIndex, "acceptedQtyUnitId", "",19);
				dao.setProcInValue(nProcIndex, "breakageQty", 		"",20);
				dao.setProcInValue(nProcIndex, "breakageQtyUnitId", "",21);
				dao.setProcInValue(nProcIndex, "rejectedQty", 		"",22);
				dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", "",23);
				dao.setProcInValue(nProcIndex, "excessQty", 		"",24);
				dao.setProcInValue(nProcIndex, "excessQtyUnitId",	"",25);
				dao.setProcInValue(nProcIndex, "verifyFlag", 		"0",26);
				dao.setProcInValue(nProcIndex, "cancelSeatId", 		vo.getStrSeatId(),27);
				dao.setProcInValue(nProcIndex, "cancelRemarks", 	"",28);
				/* Setting Default Value End */
				

				dao.setProcOutValue(nProcIndex, "err", 1,29);

				dao.execute(nProcIndex, 1);
			}
		
			
			MmsConfigUtil mcu = new MmsConfigUtil(vo.getStrHospitalCode());
			
			double strIssueRatePercent	=	Double.parseDouble((mcu.getStrConfigIssueRate()!=null && !mcu.getStrConfigIssueRate().equals(""))? mcu.getStrConfigIssueRate():"100");
			double strRate 	=	0;
			/*
              If Stock Not Exist
                A) Insert Data into hstt_drug_currstock_dtl Table
                B) Update  hstnum_lstpo_no , hstdt_lstpo_date , hstnum_lstinvoice_no , hstnum_lstinvoice_date....HSTNUM_DEFAULT_RATE etc
                   following field hstt_drugbrand_mst  
                C) PKG_MMS_DML.DML_OPBALANCE_DTL  [Mode = 3 ]   
              If Stock Exist
                A) UPDATE    hstnum_inhand_qty & hstnum_reserved_qty  in hstt_drug_currstock_dtl
                B) PKG_MMS_DML.DML_OPBALANCE_DTL  [Mode = 2 ]
                C) UPDATE hstt_storeitem_mst
                   SET hstnum_inhand_qty = NVL (hstnum_inhand_qty, 0) + stockvalue,                
             */	
						
			/* Resultset of  strHiddenVerifiedChallanValue
			 * 
			 * 
			 * 1.hstnum_item_id
			 * 2.hstnum_itembrand_id
			 * 3.Drug Name 
			 * 4.hststr_batch_sl_no
			 * 5.expiry_date
			 * 6.qty [hstnum_accepted_qty ||''^''|| NVL(HSTNUM_ACCEPTEDQTY_UNITID,0)|| '^'|| hstnum_breakage_qty ||''^''|| NVL(HSTNUM_BREAKQTY_UNITID,0) || '^'|| hblnum_rejected_qty||''^''|| NVL(HBLNUM_REJECTEDQTY_UNITID,0)  || '^' || hstnum_inhand_qty||''^''|| NVL(HSTNUM_INHAND_QTY_UNITID,0) ||'^'|| hstnum_excess_qty ||''^''|| NVL(HSTNUM_EXCESSQTY_UNITID,0)||'^'|| hstnum_shortage_qty||''^''|| NVL(HSTNUM_SHORT_QTY_UNITID,0) ||'^'|| hstnum_recieved_qty||''^''|| NVL(HSTNUM_RECQTY_UNITID,0) ||'^'|| hstnum_qc_rej_qty||''^''|| NVL(HSTNUM_QC_REJQTY_UNITID,0) ||'^'|| hstnum_temp_qty ||'^'|| hstnum_rate||''^''|| NVL(HSTNUM_RATE_UNITID,0)||''^''|| NVL(HSTNUM_RATE,0)] 
			 * 7.status [decode(gnum_isvalid,9, 'Active',2, 'Verified',1, 'Freezed')]
			 * 8.hstnum_store_id 
			 * 9.hstnum_po_store_id
			 * 10.hstnum_supplier_id
			 * 11.hstnum_group_id
			 * 12.hstnum_subgroup_id
			 * 13.hstnum_po_no
			 * 14.hstnum_schedule_no
			 * 15.verify_date
			 * 16.mfg_date
			 * 17.cancel_date
			 * 17.flags [hstnum_qc_req_flag || '^'|| hstnum_backlog_verify_flag || '^'|| hstnum_qc_report_status || '^'|| hstnum_is_online_data]
			 * 19.gstr_remarks 
			 * 20.hststr_cancel_remarks
			 * 21.hstnum_tax
			 * 22.hstnum_penelty
			 * 23.hstnum_modify_count
			 * 24.max(hstnum_slno)
			 * 25.base_unit_name
			 * 26.total_batch
			 * 27.QC_FLAG
			 * 28. HSTDT_PO_DATE
			 * 29 HSTSTR_DEMAND_YEAR
			 * 30 HSTDT_CHALLAN_DATE
			 * 31 HSTDT_RECIEVED_DATE
			 * 32 SSTNUM_POTYPE_ID
			 * 33.Item Catg
			 */			
			Date date = new Date();  
		    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
		    String strDate = formatter.format(date);					    
		    System.out.println("-------- PKG_MMS_DML.Dml_Stock_Update [ Mode - 1 ] --------");		    
			for(int i=0;i<len;i++) 	
			{
				
				strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				nProcIndex = dao.setProcedure(strProcName);

				strRate =	Double.parseDouble(vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[19] );
                
				vo.setStrSalePrice(Double.toString((strRate*strIssueRatePercent)/100));
				vo.setStrSalePriceUnitId(vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[18] );
				
//				//System.out.println( "modval"+ "1");
//				//System.out.println( "strid"+ vo.getStrStoreId());
//				//System.out.println( "itemid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[0]);
//				//System.out.println( "itembrandid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[1]);
//				//System.out.println( "batchno"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[3]);
//				//System.out.println( "itemcatno"+ "10");
//				//System.out.println( "groupid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[10]);
//				//System.out.println( "subgroupid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[11]);
//				//System.out.println( "expirydate"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[4]);
//				//System.out.println( "manufdate"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[15]);
//				//System.out.println( "stockstatuscode"+ "10");
//				//System.out.println( "inventoryflag"+ "0");
//				//System.out.println( "inhandqty"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[0]);
//				//System.out.println( "inhandqtyunitid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[1]);
//				//System.out.println( "suppid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[10]); //vo.getStrManufacturerId()
//				//System.out.println( "rate"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[19]);
//				//System.out.println( "rateunitid"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[18]);
//				//System.out.println( "saleprice"+ vo.getStrSalePrice());
//				//System.out.println( "salepriceunitid"+ vo.getStrSalePriceUnitId());
//				//System.out.println( "pono"+ vo.getStrPoNo());
//				//System.out.println( "podate"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[27]);
//				//System.out.println( "suppliedBy"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[10]);
//				//System.out.println( "recievedDate"+ vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[30]);
//				//System.out.println( "seatid"+ vo.getStrSeatId());
//				//System.out.println( "hosp_code"+ vo.getStrHospitalCode());
//				//System.out.println( "description"+"Recieved through Challan against PO No : " + vo.getStrPoNo());
//				//System.out.println( "currencyCode"+ "100");
//				//System.out.println( "currencyValue"+ "1");
						
				dao.setProcInValue(nProcIndex, "modval", 			"1",1);
				dao.setProcInValue(nProcIndex, "strid", 			vo.getStrStoreId(),2);
				dao.setProcInValue(nProcIndex, "itemid", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[0],3);
				dao.setProcInValue(nProcIndex, "itembrandid", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[1],4);
				//dao.setProcInValue(nProcIndex, "batchno", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[3]+"~"+strDate,5);
				dao.setProcInValue(nProcIndex, "batchno", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[3],5);
				
				dao.setProcInValue(nProcIndex, "itemcatno", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[32],6);
				dao.setProcInValue(nProcIndex, "groupid", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[10],7);
				dao.setProcInValue(nProcIndex, "subgroupid", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[11],8);
				dao.setProcInValue(nProcIndex, "expirydate",   	   (vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[4].equals("NA")?"":vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[4]),9);
				dao.setProcInValue(nProcIndex, "manufdate", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[15],10);
				dao.setProcInValue(nProcIndex, "stockstatuscode", 	"10",11);
				dao.setProcInValue(nProcIndex, "inventoryflag", 	"0",12);
				dao.setProcInValue(nProcIndex, "inhandqty", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[0],13);
				dao.setProcInValue(nProcIndex, "inhandqtyunitid", 	vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[1],14);
				dao.setProcInValue(nProcIndex, "suppid", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[9],15); //vo.getStrManufacturerId()
				dao.setProcInValue(nProcIndex, "rate", 				vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[22],16);
				dao.setProcInValue(nProcIndex, "rateunitid", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[18],17);
				dao.setProcInValue(nProcIndex, "saleprice", 		vo.getStrSalePrice(),18);
				dao.setProcInValue(nProcIndex, "salepriceunitid", 	vo.getStrSalePriceUnitId(),19);
				dao.setProcInValue(nProcIndex, "pono", 				vo.getStrPoNo(),20);
				dao.setProcInValue(nProcIndex, "podate", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[27],21);
				
				dao.setProcInValue(nProcIndex, "suppliedBy", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[9],23);
				dao.setProcInValue(nProcIndex, "recievedDate", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[30],24);
				dao.setProcInValue(nProcIndex, "seatid", 			vo.getStrSeatId(),22);
				dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),27);
				dao.setProcInValue(nProcIndex, "description",		"Recieved through Challan against PO No : " + vo.getStrPoNo(),42);
				dao.setProcInValue(nProcIndex, "currencyCode", 		"100",25);
				dao.setProcInValue(nProcIndex, "currencyValue", 	"1",28);
				
			

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) {

				dao.setProcInValue(nProcIndex, "freeItemFlag", "1",26);

			} else {

				dao.setProcInValue(nProcIndex, "freeItemFlag", "0",26);
			}

			if (vo.getStrItemPartDtls() != null && vo.getStrItemPartDtls().length > 0) {

				dao.setProcInValue(nProcIndex, "partFlag", "1",36);

			} else {

				dao.setProcInValue(nProcIndex, "partFlag", "0",36);
			}

			if (vo.getStrWarrantyFlag()!=null && vo.getStrWarrantyFlag().equals("1")) {

				dao.setProcInValue(nProcIndex, "warrentyFlag", "1",37);

			} else {

				dao.setProcInValue(nProcIndex, "warrentyFlag", "0",37);
			}

			if (vo.getStrItemParamDtls() != null && vo.getStrItemParamDtls().length > 0) {

				dao.setProcInValue(nProcIndex, "itemParamFlag", "1",35);

			} else {

				dao.setProcInValue(nProcIndex, "itemParamFlag", "0",35);
			}

			if (vo.getStrPoTypeId().equals("21")
					|| vo.getStrPoTypeId().equals("25")
					|| vo.getStrPoTypeId().equals("26")
					|| vo.getStrPoTypeId().equals("27")) {

				dao.setProcInValue(nProcIndex, "item_serialNoFlag", "0",51);

			} else {

				dao.setProcInValue(nProcIndex, "item_serialNoFlag", "1",51);

			}
			
			/* Start*/ 
			dao.setProcInValue(nProcIndex, "old_stockstatuscode", 	"1",29);
			dao.setProcInValue(nProcIndex, "old_batchno", 			"0",30);
			dao.setProcInValue(nProcIndex, "old_itemSerialNo", 		"0",31);
			dao.setProcInValue(nProcIndex, "old_itemid", 			"0",32);
			dao.setProcInValue(nProcIndex, "old_itembrandid", 		"0",33);
			dao.setProcInValue(nProcIndex, "old_strid", 			"0",34);
			dao.setProcInValue(nProcIndex, "toStrId", 				"",38);
			dao.setProcInValue(nProcIndex, "reservedFlag", 			"0",39);
			dao.setProcInValue(nProcIndex, "transNo",				vo.getStrChallanNo(),40);
			dao.setProcInValue(nProcIndex, "transDate", 			"",41);
			dao.setProcInValue(nProcIndex, "reqTypeId", 			vo.getStrChallanNo().substring(2,2),43);
			dao.setProcInValue(nProcIndex, "blockQtyFlag", 			"0",44);
			dao.setProcInValue(nProcIndex, "blockedQty", 			"0",45);
			dao.setProcInValue(nProcIndex, "blockedQtyUnitId", 		"0",46);
			dao.setProcInValue(nProcIndex, "releaseQty", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[21],47);
			dao.setProcInValue(nProcIndex, "releaseQtyUnitId", 		vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[5].split("\\^")[20],48);
			dao.setProcInValue(nProcIndex, "invoiceNo", 			vo.getStrHiddenVerifiedChallanValue()[i].split("\\$")[34].split("\\@")[0],49);
			dao.setProcInValue(nProcIndex, "invoiceDate", 			"",50);
			dao.setProcInValue(nProcIndex, "item_specification", 	"",52);
			 /*End*/ 

			dao.setProcOutValue(nProcIndex, "err", 					1,54);
			dao.setProcOutValue(nProcIndex, "retSerialNo", 			1,53);

			dao.execute(nProcIndex, 1);
			}
		
			
			
		    dao.fire();
		    
		    System.out.println("-------- ChallanProcessApprovalTransDAO. insertFreezeChallan----- END ----");
		

	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("ChallanProcessApprovalTransDAO.insertFreezeChallan() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;

		}

	}

}

public static void getPrintDetails(ChallanProcessApprovalTransVO vo) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet ws = null;
	try {
		dao = new HisDAO("mms", "ChallanProcessTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL(?,?,?,?,? ,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);			
		
		dao.setProcInValue(nprocIndex, "modval", "4",1);
		dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId(),2);
		dao.setProcInValue(nprocIndex, "lPRequestNo", vo.getStrChallanNo(),3);
		dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);
		dao.setProcInValue(nprocIndex, "poNo", "0",5);
		dao.setProcInValue(nprocIndex, "poStoreId", "0",6);			
		dao.setProcOutValue(nprocIndex, "err", 1,7);
		dao.setProcOutValue(nprocIndex, "resultset", 2,8);
		
		dao.executeProcedureByPosition(nprocIndex);
		
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";

		if (strerr.equals("")) {
			ws = dao.getWebRowSet(nprocIndex, "resultset");		
			vo.setWsPrintItemDtls(ws);							
		} else {
			throw new Exception(strerr);
		}	

	} catch (Exception e) {
		vo.setStrMsgString("ChallanProcessTransDAO.getVerifiedItemDetails() --> "
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
