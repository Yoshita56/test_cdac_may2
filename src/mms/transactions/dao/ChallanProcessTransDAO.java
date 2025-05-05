package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.ChallanDtlDAO;
import mms.dao.ChallanItemDtlDAO;
import mms.dao.ChallanVerifiedItemDtlDAO;
import mms.dao.CommitteRemarksDtlDAO;
import mms.global.dao.ItemParameterDetailDAO;
import mms.transactions.vo.ChallanProcessTransVO;

public class ChallanProcessTransDAO {

	public static void challanCount(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		String strCount = "0";
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_challanreceive_count(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),2);
			dao	.setProcInValue(nprocIndex, "ponostore_id", vo.getStrPoStoreId(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "challanCount", 1,7);
			dao.executeProcedureByPosition(nprocIndex);

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

			vo.setStrMsgString("ChallanProcessTransDAO.challanCount() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void receiveInit(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			
			 System.out.println("-------------- ChallanProcessTransDAO.receiveInit  -------------");
			 
			 System.out.println("-------------- PKG_MMS_VIEW.Proc_Po_Details [ Mode - 1]  -------------");
			 
			strproc_name = "{call PKG_MMS_VIEW.Proc_Po_Details(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),3);
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrPoStoreId(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (wb != null && wb.next()) 
				{

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
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void deliveryModeList(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_deliverymode_dtl(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);

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
			vo.setStrMsgString("ChallanProcessTransDAO.deliveryModeList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void scheduleNoList(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		int deliveryFlag = 0;
		
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_schedule_dtl(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			//dao.setProcInValue(nprocIndex, "po_no", vo.getStrPoNo()+"^"+vo.getStrReceiveDate(),2);
			dao.setProcInValue(nprocIndex, "po_no", vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "po_storeId", vo.getStrPoStoreId(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");
                 ////System.out.println("wb Size::::==>"+wb.size());
				if (wb != null)
				{
					while(wb.next())
					{
			            vo.setStrScheduleNo(wb.getString(1) + "^" + wb.getString(2)
								+ "^" + wb.getString(3) + "^" + wb.getString(4)
								+ "^" + wb.getString(5));
						
						deliveryFlag = Integer.parseInt(wb.getString(6));
						if(deliveryFlag >= 0)
							break;
					}
				}

				wb.first();

				vo.setWsScheduleNo(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("ChallanProcessTransDAO.scheduleNoList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void scheduleItemList(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_schedule_item_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "po_no", vo.getStrPoNo(),2);
			dao.setProcInValue(nprocIndex, "po_storeId", vo.getStrPoStoreId(),3);  // Changes By Amit Kumar 25 th Nov 2011 CR
			dao.setProcInValue(nprocIndex, "scheduleNo", vo.getStrScheduleNo().replace("^", "#").split("#")[0],4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);

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

			vo.setStrMsgString("ChallanProcessTransDAO.scheduleNoList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void unitNameCombo(ChallanProcessTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitId(),2);
			if(vo.getStrUnitId().length() == 4)
				daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			else
				daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			//daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);//Aritra
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

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
			vo.setStrMsgString("ChallanProcessTransDAO.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public synchronized static void insert(ChallanProcessTransVO vo) 
	{
		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanNo = "";
		String strReqTypeId = "68";
		int nFuncIndex = 0;
		boolean flag = false;

		ChallanDtlDAO challanDao = null;
		ChallanItemDtlDAO challanItemDao = null;
		
		try 
		{
			System.out.println("--------------- ChallanProcessTransDAO . insert -------------");
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");
			strFuncName = "{? = call Mms_Mst.generate_challanNo(?, ?, ?, ?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, strReqTypeId);
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strChallanNo = daoObj.getFuncNumeric(nFuncIndex);
            vo.setStrChallanNo(strChallanNo);
            
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
			challanDao.setStrFileNo(vo.getStrReceiveDate()); // Temprarly This Variable is Used To Enter Received date in Table 

			challanDao.insert(daoObj);
			
			 
			if (vo.getStrItemDtls() != null && vo.getStrItemDtls().length > 0) 
			{
				challanItemDao = new ChallanItemDtlDAO();
				for (int i = 0; i < vo.getStrItemDtls().length; i++) 
				{
					String[] strItemDtls = vo.getStrItemDtls()[i].replace("^","#").split("#");

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
					challanItemDao.setStrRecieveQtyUnitId(vo.getStrReceivedUnitId()[i].replace("^", "#").split("#")[0]);
					challanItemDao.setStrRemarks(vo.getStrRemarks());
					challanItemDao.setStrScheduleNo(vo.getStrScheduleNo());
					challanItemDao.setStrScheduleType(vo.getStrScheduleTypeId());
					challanItemDao.setStrStoreId(vo.getStrStoreId());
					challanItemDao.setStrSubGroupId(strItemDtls[9]);
					challanItemDao.setStrAcceptedQty(vo.getStrReceiveDate());
					challanItemDao.insert(daoObj);
				}
			}

			daoObj.fire();
			flag = true;
			
			if(flag)
			{
			  /*  if(vo.getStrDeliveryMode().equals("1"))
			    { 	
			   	   ChallanProcessTransDAO.updateDeliveryMode(vo);
			    }*/
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.insert() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;

			}
		}
	}
	
	public static void updateDeliveryMode(ChallanProcessTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;

		try 
		{			
			
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_DML.dml_update_delivery_mode(?,?,?,?,?,?,?)}"; // 7 variables
   			nprocIndex = dao.setProcedure(strproc_name);
   			 			
			dao.setProcInValue(nprocIndex,  "modval", "1",1);                 //1
			dao.setProcInValue(nprocIndex,  "challanno", vo.getStrChallanNo(),2);   //2
			dao.setProcInValue(nprocIndex,  "hosp_code", vo.getStrHospitalCode(),3);   //3
			dao.setProcInValue(nprocIndex,  "store_id", vo.getStrStoreId(),4);//4
			dao.setProcInValue(nprocIndex,  "deliveryMode", vo.getStrDeliveryMode(),5);        //5	
			dao.setProcInValue(nprocIndex,  "deliveryModeText", vo.getStrDeliveryModeTextValue(),6); //6
			dao.setProcOutValue(nprocIndex, "err", 1,7);//7
			dao.executeProcedureByPosition(nprocIndex);			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.updateDeliveryMode() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	

	public static void getChallanDetails(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			
             System.out.println("-------------- ChallanProcessTransDAO.getChallanDetails  -------------");
			 
			 System.out.println("-------------- PKG_MMS_VIEW.proc_challan_dtl [ Mode - 1]  -------------");
			 
			strproc_name = "{call PKG_MMS_VIEW.proc_challan_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			
			dao.setProcInValue(nprocIndex, "schedule_no", vo
							.getStrScheduleNo(),2);
			dao.setProcInValue(nprocIndex, "challan_no", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),4);
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);

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

				}

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("ChallanProcessTransDAO.getChallanDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getChallanItemDetails(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			
			System.out.println("-------------- ChallanProcessTransDAO.getChallanItemDetails  -------------");
				 
			System.out.println("-------------- PKG_MMS_VIEW.proc_challan_item_dtl [ Mode - 1]  -------------");
				 
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
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (wb != null && wb.next()) 
				{

					vo.setStrGroupId(wb.getString(1));
					vo.setStrSubGroupId(wb.getString(2));
					vo.setStrReceivedQuantity(wb.getString(3));
					vo.setStrReceivedQuantityUnitId(wb.getString(4));
					vo.setStrBalanceQuantity(wb.getString(5));
					vo.setStrBalanceQuantityUnitId(wb.getString(6));
					vo.setStrGroupName(wb.getString(7));
					vo.setStrSubGroupName(wb.getString(8));
					vo.setStrReceivedQuantityView(wb.getString(9));
					vo.setStrBalanceQuantityView(wb.getString(10));   // Value To Show Order Quantity on Verify Page
					vo.setStrGenericItemName(wb.getString(11));
					vo.setStrItemBrandName(wb.getString(12));
					vo.setStrRate(wb.getString(13));
					vo.setStrRateUnit(wb.getString(14));
					////System.out.println("Rate Unit:::"+wb.getString(14));
					vo.setStrRateView(wb.getString(15));
					vo.setStrManufacturerId(wb.getString(16));
					vo.setStrManufacturerName(wb.getString(17));
					vo.setStrWarrantyFlag(wb.getString(18));
					vo.setStrInstallFlag(wb.getString(19));
					vo.setStrReceivedQuantityUnitBaseValue(wb.getString(20));
					vo.setStrBalanceQuantityUnitBaseValue(wb.getString(21));
					vo.setStrVerifiedQuantity(wb.getString(22));
					vo.setStrVerifiedQuantityUnitId(vo.getStrBalanceQuantityUnitId());
					vo.setStrVerifiedQuantityView(wb.getString(22) + " "+ wb.getString(23));
					vo.setStrPreviousExcessQtyView(wb.getString(24) + " "+ wb.getString(26));
					vo.setStrAcceptedQuantityView(wb.getString(27));
					vo.setStrRejectedQuantityView(wb.getString(28));
					vo.setStrBreakageQuantityView(wb.getString(29));
					vo.setStrVerifiedQuantityInBaseVal(wb.getString(30));
					vo.setStrCompositeUnitId(wb.getString(31));
					vo.setStrCompRateUnitId(wb.getString(32));
					vo.setStrUnitId(vo.getStrReceivedQuantityUnitId());
					

				}
				vo.setStrDummySalePrice(vo.getStrRate());

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ChallanProcessTransDAO.getChallanItemDetails() --> "
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

	public static void getSuppliedByList(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			
			dao.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryId(),2);
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			/*Start*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/*End*/
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
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
					.setStrMsgString("ChallanProcessTransDAO.getSuppliedByList() --> "
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
	public static void getItemMandatoryDetails(ChallanProcessTransVO vo) {

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
			
			dao.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(procIndex1, "ERR", 1,4); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,5); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

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

	public static void rateUnitCombo(ChallanProcessTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrRateUnit(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);//Aritra
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

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

			vo.setStrMsgString("ChallanProcessTransDAO.rateUnitCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to fetch details for member detail combo
	 * 
	 * @param _SampleRegisterTransVO
	 */
	public static void getMemberDtl(ChallanProcessTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SampleRegisterTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.mms_commitee_member_dtl(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "commiteeTypeId", vo
					.getStrCommitteeType(),2);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryId(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),4);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "modval","1",1);
			//dao.setProcInValue(nprocIndex, "commNo","",3);
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nprocIndex);
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
	//FUNCTION get_SupplierPerform_Flg(modeval NUMBER, hosp_code NUMBER, store_id NUMBER,challan_no NUMBER)
	
	public static void getSupplierPerformanceFlag(ChallanProcessTransVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			String strFuncName = "{? = call mms_mst.get_SupplierPerform_Info(?,?,?,?,?)}";
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrChallanNo());
			dao.setFuncInValue(nFuncIndex, 6, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);
            
			vo.setStrSupplierPerformanceInfo(strRegFlag);
			
			
			
			String strFuncName1 = "{? = call mms_mst.get_SupplierPerform_Flg(?,?,?,?,?)}";
			int nFuncIndex1 = dao.setFunction(strFuncName1);
			dao.setFuncInValue(nFuncIndex1, 2, "1");
			dao.setFuncInValue(nFuncIndex1, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex1, 4, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex1, 5, vo.getStrChallanNo());
			dao.setFuncInValue(nFuncIndex1, 6, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex1, 1);
			dao.executeFunction(nFuncIndex1);

			String strInfoFlag = dao.getFuncString(nFuncIndex1);

			vo.setStrSupplierPerformanceFlag(strInfoFlag);
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.getSupplierPerformanceFlag() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getItemQCType(ChallanProcessTransVO vo) 
	{
		HisDAO dao = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			String strFuncName = "{? = call mms_mst.get_ItemQc_Type(?, ?, ?)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 3);
			dao.executeFuncForNumeric(nFuncIndex);

			String strRegFlag = dao.getFuncNumeric(nFuncIndex);

			vo.setStrQcTypeFlg(strRegFlag);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.getItemQCType() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}

	
	public static void getCommitteeTypeDtl(ChallanProcessTransVO vo) 
	{
		String strproc_name = "";
		String strReqTypeId = "68";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
			dao = new HisDAO("MMS", "ChallanProcessTransDAO");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryId(),3);
			dao.setProcInValue(nprocIndex, "reqType", strReqTypeId,4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) 
			{
				vo.setWsCommitteeType(wb);
			} 
			else 
			{
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("SampleRegisterTransDAO.getCommitteeTypeDtl() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}

	public static void getBalanceQtyDetails(ChallanProcessTransVO vo) {

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

			dao.setProcInValue(procIndex1, "item_id", vo.getStrGenericItemId(),2);
			dao.setProcInValue(procIndex1, "item_brand_id", vo
					.getStrItemBrandId(),3);
			
			dao.setProcInValue(procIndex1, "schedule_no", vo
							.getStrScheduleNo(),4);
			dao.setProcInValue(procIndex1, "pono", vo.getStrPoNo(),5);
			dao.setProcInValue(procIndex1, "storeid", vo.getStrPoStoreId(),6);

			
			dao.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "ERR", 1,8); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,9); // 2 for object
			// execute
			// procedure

			dao.executeProcedureByPosition(procIndex1);

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

	public static void getChallanItemCount(ChallanProcessTransVO vo) 
	{

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try 
		{
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");
			
			strFuncName = "{? = call Mms_Mst.Get_challanCount_Dtls(?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrChallanNo());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrGenericItemId());
			daoObj.setFuncInValue(nFuncIndex, 6, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strChallanItemCount = daoObj.getFuncNumeric(nFuncIndex);

			vo.setStrChallanCount(strChallanItemCount);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.getChallanItemCount() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getCancelChallanItemCount(ChallanProcessTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");

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
					.setStrMsgString("ChallanProcessTransDAO.getCancelChallanItemCount() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	public static void getCancelChallanCount(ChallanProcessTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strChallanItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");

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
					.setStrMsgString("ChallanProcessTransDAO.getCancelChallanCount() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}

	/*public static void getPoItemCount(ChallanProcessTransVO vo) {

		HisDAO daoObj = null;

		String strFuncName = "";
		String strPoItemCount = "0";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");

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
			vo.setStrMsgString("ChallanProcessTransDAO.getPoItemCount() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}*/

	public synchronized static void verifyInsert(ChallanProcessTransVO vo) 
	{
		HisDAO daoObj = null;

//		String strProcName = "";
//		String strProcName7 = "";
//		String strProcName8 = "";
//		String strProcName10 = "";
//		String strProcName14 = "";
//
//		int nProcIndex = 0;
//		int nProcIndex7 = 0;
//		int nProcIndex8 = 0;
//		int nProcIndex10 = 0;
//		int nProcIndex14 = 0;
		
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
		HisUtil hisutil = null;
		//boolean flag = false;
		
		try 
		{
			daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");
			hisutil = new HisUtil("MMS", "ChallanProcessTransDAO");
			
			System.out.println("--------------- ChallanProcessTransDAO . verifyInsert -------------");
			
			itemParameterDetailDAO = new ItemParameterDetailDAO();
			challanVerifiedItemDAO = new ChallanVerifiedItemDtlDAO();
			challanItemDao = new ChallanItemDtlDAO();
			committeRemarks = new CommitteRemarksDtlDAO();
			challanDao = new ChallanDtlDAO();
			
			//String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			String strItemCatNo="0";
			
			if(vo.getStrItemCategoryId()!=null)
			{
				strItemCatNo=vo.getStrItemCategoryId();
				if(vo.getStrItemCategoryId().equals("") || vo.getStrItemCategoryId().equals("0")){
				if(vo.getStrItemBrandId()!=null && !vo.getStrItemBrandId().equals(""))
					strItemCatNo=vo.getStrItemBrandId().substring(0, 2);
				if(strItemCatNo.equals("0"))
					if(vo.getStrGenericItemId()!=null && !vo.getStrGenericItemId().equals(""))
						strItemCatNo=vo.getStrGenericItemId().substring(0, 2);
				}
			}
			
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
			challanVerifiedItemDAO.setStrSalePrice(vo.getStrSalePrice());
			challanVerifiedItemDAO.insert(daoObj);

			/*strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenericItemId(),3);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId(),4);
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),5);
			daoObj.setProcInValue(nProcIndex, "itemcatno", strItemCatNo,6);
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),7);
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo.getStrSubGroupId(),8);
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate(),9);
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate(),10);
			if(strItemCatNo.equals("10"))
			{
				if(vo.getStrQcTypeFlg().equals("0")||vo.getStrQcTypeFlg().equals("2"))
				{	
					daoObj.setProcInValue(nProcIndex, "stockstatuscode", "10",11);
				}
				else
				{
					daoObj.setProcInValue(nProcIndex, "stockstatuscode", "15",11);	
				}
			}
			else
			{
				daoObj.setProcInValue(nProcIndex, "stockstatuscode", "10",11);	
			}
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0",12);
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrAcceptedQuantity(),13);
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrAcceptedQuantityUnitId(),14);
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrManufacturerId(),15);
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate(),16);
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo.getStrRateUnit(),17);
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice(),18);
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo.getStrSalePriceUnitId(),19);
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo(),20);
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate(),21);
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId(),22);
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo.getStrSupplierId(),23);
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo.getStrReceiveDate(),24);
			daoObj.setProcInValue(nProcIndex, "currencyCode", vo.getStrCurrencyCode(),25);
			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1",26);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0",26);
			}
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),27);
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo.getStrCurrencyValue(),28);
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1",29);
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0",30);
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0",31);
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0",32);
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0",33);
			daoObj.setProcInValue(nProcIndex, "old_strid", "0",34);
			if (vo.getStrItemParamDtls() != null && vo.getStrItemParamDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1",35);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0",35);
			}
			if (vo.getStrItemPartDtls() != null	&& vo.getStrItemPartDtls().length > 0) 
			{

				daoObj.setProcInValue(nProcIndex, "partFlag", "1",36);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "partFlag", "0",36);
			}
			if (vo.getStrWarrantyFlag().equals("1"))
            {
				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1",37);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0",37);
			}
			daoObj.setProcInValue(nProcIndex, "toStrId", "0",38);
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0",39);
			daoObj.setProcInValue(nProcIndex, "transNo", vo.getStrChallanNo(),40);
			daoObj.setProcInValue(nProcIndex, "transDate", "0",41);
			daoObj.setProcInValue(nProcIndex, "description","Recieved through Challan against PO No : " + vo.getStrPoNo(),42);
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "68",43);
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0",44);
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0",45);
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0",46);
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0",47);
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0",48);
			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrChallanNo(),49);
			daoObj.setProcInValue(nProcIndex, "invoiceDate", ctDate,50);
			if (vo.getStrPoTypeId().equals("21")|| vo.getStrPoTypeId().equals("25")	|| vo.getStrPoTypeId().equals("26")|| vo.getStrPoTypeId().equals("27")) 
			{
				daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "0",51);
			}
			else 
			{
				daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1",51);
			}
			daoObj.setProcInValue(nProcIndex, "item_specification", "0",52);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1,53);
			daoObj.setProcOutValue(nProcIndex, "err", 1,54);			

			daoObj.execute(nProcIndex, 1);

		/*
            strProcName14 = "{call PKG_MMS_DML.proc_HSTT_SUPP_PERFORMPRAM_DTL(?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?)}";// 26 Varibale's
	        nProcIndex14 = daoObj.setProcedure(strProcName14);
	        
			daoObj.setProcInValue(nProcIndex14, "p_mode", "1",1);                                    	     //1
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);          	     //2
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_CHALLAN_NO",vo.getStrChallanNo(),3);  	     //3
			daoObj.setProcInValue(nProcIndex14, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);                //4
			daoObj.setProcInValue(nProcIndex14, "p_HSTDT_CHALLAN_DATE",ctDate,5);               //5
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_SUPP_RECIEPT_NO","0",6);        //6
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_SUPPLIER_ID",vo.getStrSupplierId(),7);         //7
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_ITEM_ID",vo.getStrGenericItemId(),8);   //Challan Verify Insert      //8
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId(),9);      	 //9
			if(vo.getStrTestReportFlg().equals("1"))
			{
			 daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_REPORT_NO",	vo.getStrReportNumber(),10);         	 //10
			 daoObj.setProcInValue(nProcIndex14, "p_HSTDT_REPORT_DATE",vo.getStrReportDate(),11);    	  	 //11
			}
			else
			{
			 daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_REPORT_NO",	"0",10);         	 //10
			 daoObj.setProcInValue(nProcIndex14, "p_HSTDT_REPORT_DATE","0",11);    	  	 //11	
			}	
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_DRUG_CONDITION",	vo.getStrMedicienCondFlg(),12);         //12
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_IS_QC_PRINTED", vo.getStrGovtSupplyFlg(),13);  	 	 //13
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_IS_GENERIC",vo.getStrMedicineTypeFlg(),14);      //14
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_IS_MRP_PRINTED",vo.getStrMrpPrintedFlg(),15); 	 //15
			daoObj.setProcInValue(nProcIndex14, "p_GNUM_SEATID",vo.getStrSeatId(),16);                     //16
			daoObj.setProcInValue(nProcIndex14, "p_GDT_ENTRY_DATE","0",17);    				                         //17
			daoObj.setProcInValue(nProcIndex14, "p_GNUM_ISVALID","1",18);                              //18
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_PO_NO",vo.getStrPoNo(),19);    			          //19
			daoObj.setProcInValue(nProcIndex14, "p_HSTDT_PO_DATE",vo.getStrPoDate(),20);                     //20
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_STOCK_PAGE_NO",vo.getStrPageNumber(),21);          //21
			daoObj.setProcInValue(nProcIndex14, "p_HSTNUM_ONLINE_FLAG","1",22);                              //22
			daoObj.setProcInValue(nProcIndex14, "p_SSTSTR_PO_PREFIX","0",23);                                 //23
			daoObj.setProcInValue(nProcIndex14, "p_accepted_qty","0",24);                                     //24
			daoObj.setProcInValue(nProcIndex14, "p_HSTSTR_BATCH_NO",vo.getStrBatchNo(),25);                   //25
			daoObj.setProcOutValue(nProcIndex14, "err", 1,26);                                               //26

			daoObj.execute(nProcIndex14, 1);
	    
				*/
			
			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) {

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					daoObj.setProcInValue(nProcIndex2, "modval", "1");
					daoObj.setProcInValue(nProcIndex2, "itemid", vo
							.getStrGenericItemId());
					daoObj.setProcInValue(nProcIndex2, "itembrandid", vo
							.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex2, "batchno", vo
							.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex2, "freeitemid",
							strItemOtherVal[1]);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",
							strItemOtherVal[2]);
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
							strItemOtherVal[3]);
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",
							strItemOtherVal[0]);
					daoObj.setProcInValue(nProcIndex2, "expirydate",
							strItemOtherVal[4]);
					daoObj.setProcInValue(nProcIndex2, "manufdate",
							strItemOtherVal[5]);
					daoObj.setProcInValue(nProcIndex2, "qty",
							strItemOtherVal[6]);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",
							strItemOtherVal[7]);
					daoObj.setProcInValue(nProcIndex2, "hosp_code", vo
							.getStrHospitalCode());
					
					/* Setting Default Value Start*/
					daoObj.setProcInValue(nProcIndex2, "transNo", "0");
					daoObj.setProcInValue(nProcIndex2, "strId", "0");
					/* Setting Default Value End */
					

					daoObj.setProcOutValue(nProcIndex2, "err", 1);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1);

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

					daoObj.setProcInValue(nProcIndex3, "modval", "1");
					daoObj.setProcInValue(nProcIndex3, "itemid", vo
							.getStrGenericItemId());
					daoObj.setProcInValue(nProcIndex3, "itembrandid", vo
							.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex3, "batchno", vo
							.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex3, "partitemid",
							strItemPartVal[1]);
					daoObj.setProcInValue(nProcIndex3, "partitembrandid",
							strItemPartVal[2]);
					
					if(strItemPartVal[3] != null && strItemPartVal[3].length() != 0){
						
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								strItemPartVal[3]);
					}else{
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								"0");
					}
					
					
					daoObj.setProcInValue(nProcIndex3, "partitemcatno",
							strItemPartVal[0]);
					daoObj.setProcInValue(nProcIndex3, "expirydate",
							strItemPartVal[4]);
					daoObj.setProcInValue(nProcIndex3, "manufdate",
							strItemPartVal[5]);
					daoObj
							.setProcInValue(nProcIndex3, "qty",
									strItemPartVal[6]);
					daoObj.setProcInValue(nProcIndex3, "qtyunitid",
							strItemPartVal[7]);

					daoObj.setProcInValue(nProcIndex3, "manufid",
							strItemPartVal[8]);

					daoObj.setProcInValue(nProcIndex3, "comp_type",
							strItemPartVal[9]);
					
					daoObj.setProcInValue(nProcIndex3, "is_separate",
							strItemPartVal[10]);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_period",
							strItemPartVal[11]);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_Unit",
							strItemPartVal[12]);
					
					daoObj.setProcInValue(nProcIndex3, "hosp_code", vo
							.getStrHospitalCode());
					
					/* Start */
					daoObj.setProcInValue(nProcIndex3, "transNo","0");
					daoObj.setProcInValue(nProcIndex3, "strId","0");
					/* End */

					daoObj.setProcOutValue(nProcIndex3, "err", 1);
					daoObj.setProcOutValue(nProcIndex3, "dml_count", 1);

					daoObj.execute(nProcIndex3, 1);

				}

			if (vo.getStrWarrantyFlag().equals("1")) {

				strProcName4 = "{call PKG_MMS_DML.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex4 = daoObj.setProcedure(strProcName4);

				daoObj.setProcInValue(nProcIndex4, "modval", "1");
				daoObj.setProcInValue(nProcIndex4, "item_id", vo
						.getStrGenericItemId());
				daoObj.setProcInValue(nProcIndex4, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex4, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex4, "hosp_code", vo
						.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex4, "warrenty_date", vo
						.getStrWarrantyDate());
				daoObj.setProcInValue(nProcIndex4, "manuf_id", vo
						.getStrWarantyManufacturer());
				daoObj.setProcInValue(nProcIndex4, "po_no", vo.getStrPoNo());
				daoObj.setProcInValue(nProcIndex4, "warrenty_upto", vo
						.getStrWarrantyUpTo());
				daoObj.setProcInValue(nProcIndex4, "warrenty_unitid", vo
						.getStrWarrantyUpToUnit());
				daoObj.setProcInValue(nProcIndex4, "fin_start_yr", vo
						.getStrFinancialStartDate());
				daoObj.setProcInValue(nProcIndex4, "fin_end_yr", vo
						.getStrFinancialEndDate());
				daoObj.setProcInValue(nProcIndex4, "remarks", vo
						.getStrWarrantyRemarks());
				
				/* Start */
				daoObj.setProcInValue(nProcIndex4, "transNo","0");
				daoObj.setProcInValue(nProcIndex4, "strId","0");
				/* End */
				
				daoObj
						.setProcInValue(nProcIndex4, "seat_id", vo
								.getStrSeatId());

				daoObj.setProcOutValue(nProcIndex4, "err", 1);

				daoObj.execute(nProcIndex4, 1);

			}

			if (vo.getStrInstallFlag().equals("1")) {

				strProcName5 = "{call PKG_MMS_DML.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex5 = daoObj.setProcedure(strProcName5);

				daoObj.setProcInValue(nProcIndex5, "modval", "1");
				daoObj.setProcInValue(nProcIndex5, "item_id", vo
						.getStrGenericItemId());
				daoObj.setProcInValue(nProcIndex5, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex5, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex5, "hosp_code", vo
						.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex5, "install_start_date", vo
						.getStrInstallStartDate());

				daoObj.setProcInValue(nProcIndex5, "install_end_date", vo
						.getStrInstallEndDate());

				daoObj.setProcInValue(nProcIndex5, "po_no", vo.getStrPoNo());
				daoObj.setProcInValue(nProcIndex5, "install_status", vo
						.getStrInstallStatus());
				daoObj.setProcInValue(nProcIndex5, "install_by", vo
						.getStrInstallBy());

				daoObj.setProcInValue(nProcIndex5, "installer_contactNo", vo
						.getStrInstallerContactNo());

				daoObj.setProcInValue(nProcIndex5, "fin_start_yr", vo
						.getStrFinancialStartDate());
				daoObj.setProcInValue(nProcIndex5, "fin_end_yr", vo
						.getStrFinancialEndDate());
				daoObj.setProcInValue(nProcIndex5, "remarks", vo
						.getStrInstallRemarks());
				
				/* Start */
				daoObj.setProcInValue(nProcIndex5, "transNo","0");
				daoObj.setProcInValue(nProcIndex5, "strId","0");
				/* End */
				
				daoObj
						.setProcInValue(nProcIndex5, "seat_id", vo
								.getStrSeatId());

				daoObj.setProcOutValue(nProcIndex5, "err", 1);

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
			challanItemDao.setStrVerifyFlag(vo.getStrVerifyFlag());
			challanItemDao.setStrStoreId(vo.getStrStoreId());
			challanItemDao.setStrChallanNo(vo.getStrChallanNo());
			challanItemDao.setStrItemId(vo.getStrGenericItemId());
			challanItemDao.setStrItemBrandId(vo.getStrItemBrandId());
			challanItemDao.setStrHospitalCode(vo.getStrHospitalCode());
			
			

			challanItemDao.update(daoObj);

			if (vo.getStrVerifyFlag().equals("1")) 
			{
				strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl (?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?)}";//38

				nProcIndex7 = daoObj.setProcedure(strProcName7);

				daoObj.setProcInValue(nProcIndex7, "modeval", "4",1);
				daoObj.setProcInValue(nProcIndex7, "pono", vo.getStrPoNo(),2);				
				daoObj.setProcInValue(nProcIndex7, "store_id", vo.getStrPoStoreId(),3);
				daoObj.setProcInValue(nProcIndex7, "item_id", vo.getStrGenericItemId(),4);
				daoObj.setProcInValue(nProcIndex7, "item_brand_id", vo.getStrItemBrandId(),5);				
				daoObj.setProcInValue(nProcIndex7, "schedule_no", vo.getStrScheduleNo(),6);
				daoObj.setProcInValue(nProcIndex7, "hosp_code", vo.getStrHospitalCode(),7);
				daoObj.setProcInValue(nProcIndex7, "supplier","0",8);
				daoObj.setProcInValue(nProcIndex7, "groupid","0",9);
				daoObj.setProcInValue(nProcIndex7, "subgroup_id","0",10);
				daoObj.setProcInValue(nProcIndex7, "manuf_id","0",11);
				daoObj.setProcInValue(nProcIndex7, "rate","0",12);
				daoObj.setProcInValue(nProcIndex7, "rate_unit","0",13);
				daoObj.setProcInValue(nProcIndex7, "order_qty","0",14);
				daoObj.setProcInValue(nProcIndex7, "order_qty_unit","0",15);
				daoObj.setProcInValue(nProcIndex7, "accepted_qty", vo.getStrAcceptedQuantity(),16);
				daoObj.setProcInValue(nProcIndex7, "accepted_qty_unit", vo.getStrAcceptedQuantityUnitId(),17);				
				daoObj.setProcInValue(nProcIndex7, "rejected_qty", vo.getStrRejectedQuantity(),18);
				daoObj.setProcInValue(nProcIndex7, "rejected_qty_unit", vo.getStrRejectedQuantityUnitId(),19);
				daoObj.setProcInValue(nProcIndex7, "breakage_qty", vo.getStrBreakageQuantity(),20);
				daoObj.setProcInValue(nProcIndex7, "breakage_qty_unit", vo.getStrBreakageQuantityUnitId(),21);
				daoObj.setProcInValue(nProcIndex7, "warrenty_req","0",22);
				daoObj.setProcInValue(nProcIndex7, "installation_req","0",23);
				daoObj.setProcInValue(nProcIndex7, "remarks","0",24);
				daoObj.setProcInValue(nProcIndex7, "item_tax","0",25);
				daoObj.setProcInValue(nProcIndex7, "return_qty","0",26);
				daoObj.setProcInValue(nProcIndex7, "return_qty_unit","0",27);
				daoObj.setProcInValue(nProcIndex7, "recieved_qty","0",28);
				daoObj.setProcInValue(nProcIndex7, "recieved_qty_unit","0",29);
				daoObj.setProcInValue(nProcIndex7, "req_no","0",30);				
				daoObj.setProcInValue(nProcIndex7, "challanNo", vo.getStrChallanNo(),31);				
				daoObj.setProcInValue(nProcIndex7, "raising_store", vo.getStrStoreId(),32);
				daoObj.setProcInValue(nProcIndex7, "po_type","0",33);
				daoObj.setProcInValue(nProcIndex7, "item_make","1",34);
				daoObj.setProcInValue(nProcIndex7, "itemName","0",35);
				daoObj.setProcInValue(nProcIndex7, "po_date","0",36);
				daoObj.setProcInValue(nProcIndex7, "delivery_loc","0",37);
				daoObj.setProcOutValue(nProcIndex7, "err", 1,38);

				daoObj.execute(nProcIndex7, 1);

				getChallanItemCount(vo);

				if (vo.getStrChallanCount().equals("0")) 
				{

					strProcName8 = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

					nProcIndex8 = daoObj.setProcedure(strProcName8);

					//System.out.println("challanNo"+ vo.getStrChallanNo());
					//System.out.println( "store_id"+vo.getStrStoreId());
					//System.out.println("hosp_code"+ vo.getStrHospitalCode());
					
					daoObj.setProcInValue(nProcIndex8, "modval", "2",1);
					daoObj.setProcInValue(nProcIndex8, "challanNo", vo.getStrChallanNo(),2);
					daoObj.setProcInValue(nProcIndex8, "po_No", "0",3);
					
					daoObj.setProcInValue(nProcIndex8, "hosp_code", vo.getStrHospitalCode(),4);
					
					daoObj.setProcInValue(nProcIndex8, "cat_Code", "0",5);
					daoObj.setProcInValue(nProcIndex8, "store_id", vo.getStrStoreId(),6);
					daoObj.setProcInValue(nProcIndex8, "supplier_id", "0",7);
					daoObj.setProcInValue(nProcIndex8, "awb_No", "0",8);
					daoObj.setProcInValue(nProcIndex8, "po_Date", "0",9);
					daoObj.setProcInValue(nProcIndex8, "be_No", "0",10);
					daoObj.setProcInValue(nProcIndex8, "be_Date", "0",11);
					daoObj.setProcInValue(nProcIndex8, "packets", "0",12);
					daoObj.setProcInValue(nProcIndex8, "pkg_weight", "0",13);
					daoObj.setProcInValue(nProcIndex8, "delivery_Date", "0",14);
					daoObj.setProcInValue(nProcIndex8, "delivery_Mode", "0",15);
					daoObj.setProcInValue(nProcIndex8, "committee_type", "0",16);
					daoObj.setProcInValue(nProcIndex8, "committee_Rmks_SlNo", "0",17);
					daoObj.setProcInValue(nProcIndex8, "committee_No", "0",18);
					daoObj.setProcInValue(nProcIndex8, "challan_Status","0",19);
					daoObj.setProcInValue(nProcIndex8, "fin_start_year", "0",20);
					daoObj.setProcInValue(nProcIndex8, "fin_end_year", "0",21);
					daoObj.setProcInValue(nProcIndex8, "remarks", "0",22);
					daoObj.setProcInValue(nProcIndex8, "seat_id", "0",23);
					daoObj.setProcInValue(nProcIndex8, "po_store_id", "0",24);
					daoObj.setProcInValue(nProcIndex8, "received_By", "0",25);
					daoObj.setProcInValue(nProcIndex8, "scheduleNo", "0",26);
					daoObj.setProcInValue(nProcIndex8, "scheduleType", "0",27);
					daoObj.setProcInValue(nProcIndex8, "sup_rec_no", "0",28);
					daoObj.setProcInValue(nProcIndex8, "sup_rec_date", "0",29);
					daoObj.setProcInValue(nProcIndex8, "strFileNo", "0",30);
					daoObj.setProcInValue(nProcIndex8, "strPageNo", "0",31);
					daoObj.setProcInValue(nProcIndex8, "strFileChallanName", "0",32);
					daoObj.setProcOutValue(nProcIndex8, "err", 1,33);
                     
					daoObj.execute(nProcIndex8, 1);
           
					strProcName10 = "{call PKG_MMS_DML.DML_RETURN_SUPPLIER_DTL(?,?,?,?,?,?,?,?,?)}";

						nProcIndex10 = daoObj.setProcedure(strProcName10);

						daoObj.setProcInValue(nProcIndex10, "modval", "1",1);
						daoObj.setProcInValue(nProcIndex10, "strId", vo.getStrStoreId(),2);
						daoObj.setProcInValue(nProcIndex10, "itemcatNo", vo.getStrItemCategoryId(),3);
						daoObj.setProcInValue(nProcIndex10, "hosp_code", vo.getStrHospitalCode(),4);
						daoObj.setProcInValue(nProcIndex10, "challanNo", vo.getStrChallanNo(),5);
						daoObj.setProcInValue(nProcIndex10, "seatId", vo.getStrSeatId(),6);
						daoObj.setProcInValue(nProcIndex10, "returnNo","0",7);
						daoObj.setProcInValue(nProcIndex10, "issueNo","0",8);  
						daoObj.setProcOutValue(nProcIndex10, "err", 1,9);
						daoObj.execute(nProcIndex10, 1);
						
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
				}

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
//			flag = true;
			
//			if(flag)
//			{
//				ChallanProcessTransDAO.updateCurrStock(vo);
//			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanProcessTransDAO.verifyInsert() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;

			}
		}
	}
	
	
	public synchronized static void cancelChallan(ChallanProcessTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;
		try 
		{
			
			   System.out.println("-------------- ChallanProcessTransDAO.cancelChallan  -------------");

			    dao = new HisDAO("mms", "global.MmsDAO.updatePoDetails(MmsVO vo)");

			//    dml_challan_cancel_dtl(modval , strid , challanno , itemid , itembrandid , batchno , status , hospcode , seatid , remarks , err );
				
				String proc_name1 = "{call PKG_MMS_DML.dml_challan_cancel_dtl(?,?,?,?,?  ,?,?,?,?,?  ,?)}";  //11 Variable
				procIndex1 = dao.setProcedure(proc_name1);
				
										
				// set value
				dao.setProcInValue(procIndex1, "modval", 		"1",1);
				dao.setProcInValue(procIndex1, "store_id", 		vo.getStrStoreId(),2);
				dao.setProcInValue(procIndex1, "challanno", 	vo.getStrChallanNo(),3);
				dao.setProcInValue(procIndex1, "po_storeid",     vo.getStrPoStoreId(),4);				
				dao.setProcInValue(procIndex1, "itembrandid", 	vo.getStrItemBrandId(),5);
				dao.setProcInValue(procIndex1, "pono", 		    vo.getStrPoNo(),6);
				dao.setProcInValue(procIndex1, "status", 		"9",7);
				dao.setProcInValue(procIndex1, "hospcode", 		vo.getStrHospitalCode(),8);
				dao.setProcInValue(procIndex1, "seatid", 		vo.getStrSeatId(),9);
				dao.setProcInValue(procIndex1, "remarks", 		vo.getStrRemarks(),10);				
				dao.setProcOutValue(procIndex1, "err", 			1,11); 
				dao.executeProcedureByPosition(procIndex1);

				
				
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";

				if (!err.equals(""))
					throw new Exception(err);
				
			

			
		} catch (Exception e) 
		{
		
			e.printStackTrace();
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

	public synchronized static void cancelChallan_org(ChallanProcessTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		ChallanItemDtlDAO challanItemDao = null;
		ChallanDtlDAO challanDao = null;

		HisDAO dao = null;
		HisDAO dao2 = null;
		HisDAO dao3 = null;

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

			challanItemDao.update2(dao);

			dao.fire();
			
			getCancelChallanItemCount(vo);

					
			if (vo.getStrChallanCount().equals("0")) {

				dao2 = new HisDAO("mms", "global.MmsDAO.cancelChallan(MmsVO vo)");
				
				challanDao.setStrChallanNo(vo.getStrChallanNo());
				challanDao.setStrStoreId(vo.getStrStoreId());
				challanDao.setStrHospitalCode(vo.getStrHospitalCode());

				challanDao.update(dao2);

				dao2.fire();
				
			}

			vo.setStrChallanCount("0");

			getCancelChallanCount(vo);

				
			if (vo.getStrChallanCount().equals("0")) {

				dao3 = new HisDAO("mms", "global.MmsDAO.cancelChallan(MmsVO vo)");
				
				String proc_name1 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //34 Variable
				procIndex1 = dao3.setProcedure(proc_name1);

				// set value
				dao3.setProcInValue(procIndex1, "modeval", "3");
				dao3.setProcInValue(procIndex1, "pono", vo.getStrPoNo());
				dao3.setProcInValue(procIndex1, "store_id", vo.getStrPoStoreId());
				dao3.setProcInValue(procIndex1, "hosp_code", vo
						.getStrHospitalCode());
				
				/* Start */
				dao3.setProcInValue(procIndex1, "item_cat", "0");
				dao3.setProcInValue(procIndex1, "po_type_id", "0");
				dao3.setProcInValue(procIndex1, "currency_id", "0");
				dao3.setProcInValue(procIndex1, "pur_source", "");
				dao3.setProcInValue(procIndex1, "supplier", "0");
				dao3.setProcInValue(procIndex1, "po_Date", "");
				dao3.setProcInValue(procIndex1, "tender_no", "0");
				dao3.setProcInValue(procIndex1, "tender_date", "");
				dao3.setProcInValue(procIndex1, "quotation_no", "0");
				dao3.setProcInValue(procIndex1, "quotation_date", "");
				dao3.setProcInValue(procIndex1, "net_advance", "0");
				dao3.setProcInValue(procIndex1, "po_status", "0");
				dao3.setProcInValue(procIndex1, "fin_start_date", "");
				dao3.setProcInValue(procIndex1, "fin_end_date", "");
				dao3.setProcInValue(procIndex1, "net_penelty", "0");
				dao3.setProcInValue(procIndex1, "po_remarks", "");
				dao3.setProcInValue(procIndex1, "cancel_flag", "0");
				dao3.setProcInValue(procIndex1, "currency_value", "0");
				dao3.setProcInValue(procIndex1, "waivoff", "0");
				dao3.setProcInValue(procIndex1, "advance_adjusted", "0");
				dao3.setProcInValue(procIndex1, "po_prefix", "0");
				dao3.setProcInValue(procIndex1, "seat_id", "0");
				dao3.setProcInValue(procIndex1, "paid_bill_amt", "0");
				dao3.setProcInValue(procIndex1, "tax", "0");
				dao3.setProcInValue(procIndex1, "net_amount", "0");
				dao3.setProcInValue(procIndex1, "issueNo", "0");
				dao3.setProcInValue(procIndex1, "reqTypeId", "0");
				dao3.setProcInValue(procIndex1, "verified_by", "");
				dao3.setProcInValue(procIndex1, "verified_date", vo.getStrCtDate());//current date
				/* End */
				dao3.setProcInValue(procIndex1, "dcomments","-");
				dao3.setProcOutValue(procIndex1, "ERR", 1); // 1 for string
															// return
				dao3.execute(procIndex1, 1);

				dao3.fire();
				
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
	/**
	 * This function is used to set initial values in Received by combo.
	 * @param _ItemTransferTransVO
	 */
	public static void setRecievedByCombo(ChallanProcessTransVO _ChallanProcessTransVO)
	{
		
		String strProcName ="{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj  = new HisDAO("MMSModule","ChallanProcessTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId", _ChallanProcessTransVO.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _ChallanProcessTransVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				_ChallanProcessTransVO.setRecievedByWS(ws);
			}
		}
		catch(Exception _err)
		{_err.printStackTrace();
			_ChallanProcessTransVO.setStrMsgString("ChallanProcessTransDAO.setRecievedByCombo() --> "
					+ _err.getMessage());
			_ChallanProcessTransVO.setStrMsgType("1");
		}
	}
	
	
	public static void getPODetails(ChallanProcessTransVO vo) {		
		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			
			System.out.println("-------------- ChallanProcessTransDAO.getPODetails  -------------");
			 
			System.out.println("-------------- PKG_MMS_VIEW.proc_po_detail_info [ Mode - 8]  -------------");
			
		//	dao = new HisDAO("mms", "ChallanProcessTransDAO");
			daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_po_detail_info(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);			
			 
			//System.out.println("modval"+ "8");
			//System.out.println("item_category"+ "0");
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			//System.out.println("store_Id"+ vo.getStrStoreId());
			//System.out.println("poNo"+ vo.getStrPoNo());			
			
			
			daoObj.setProcInValue(nProcIndex, "modval", "8",1);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_Id",  vo.getStrStoreId(),4);
			daoObj.setProcInValue(nProcIndex, "poNo",  vo.getStrPoNo(),5);
			daoObj.setProcInValue(nProcIndex, "po_frmdate", "0",6);
			daoObj.setProcInValue(nProcIndex,  "po_todate", "0",7);
			daoObj.setProcInValue(nProcIndex, "schedule_no", "0",8);
		    daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
			
		/*	dao.setProcInValue(nprocIndex, "modval", "8");
			dao.setProcInValue(nprocIndex, "item_category", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "store_Id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNo());			
			dao.setProcInValue(nprocIndex, "po_frmdate", "0");
			dao.setProcInValue(nprocIndex, "po_todate", "0");
			dao.setProcInValue(nprocIndex, "schedule_no", "0");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			*/
			
				strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
			        	
				vo.setWsPODtls(ws);
				while(ws.next())
				{
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));					
				}			
			} else {
				throw new Exception(strErr);
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessTransDAO.getPODetails() --> "
					+ e.getMessage());
			//System.out.println(e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
public static void getChallanReceivedDetails(ChallanProcessTransVO vo) {		
		
		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
				daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");
				
				 System.out.println("-------------- ChallanProcessTransDAO.getChallanReceivedDetails  -------------");
				 
				 System.out.println("-------------- PKG_MMS_VIEW.proc_hstt_challan_dtl [ Mode - 1]  -------------");

			strProcName = "{call PKG_MMS_VIEW.proc_hstt_challan_dtl(?,?,?,?,?,?,?)}";
				nProcIndex = daoObj.setProcedure(strProcName);
				
				//System.out.println("hosp_code"+  vo.getStrHospitalCode());
				//System.out.println("challan_no"+ "");
				//System.out.println("pono"+vo.getStrPoNo());
				//System.out.println("store_id"+ vo.getStrStoreId());
				
				
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code",  vo.getStrHospitalCode(),2);
				daoObj.setProcInValue(nProcIndex, "challan_no", "",3);
				daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo(),4);
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),5);
					daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
				
			
//System.out.println("iN dao 2");
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
        
			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");			
				 //System.out.println("ws.size()"+ws.size());
				vo.setWsChallanDtls(ws);							
			} else {
				throw new Exception(strErr);
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("ChallanProcessTransDAO.getChallanReceivedDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
public static void getReceivedItemDetails(ChallanProcessTransVO vo) {
	
	String strProcName = "";

	int nProcIndex = 0;
	String strErr = "";
	WebRowSet ws = null;
	HisDAO daoObj = null;
	try {
		
		 System.out.println("-------------- ChallanProcessTransDAO.getReceivedItemDetails  -------------");
		 
		System.out.println("-------------- PKG_MMS_VIEW.proc_challan_item_dtl [ Mode - 4]  -------------");
			
		daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");
		strProcName = "{call PKG_MMS_VIEW.proc_challan_item_dtl(?,?,?,?,? ,?,?,?,?)}";
		nProcIndex = daoObj.setProcedure(strProcName);
		
         //System.out.println("schedule_no"+ vo.getStrPoNo());
         //System.out.println("challan_no"+ vo.getStrChallanNo());
         //System.out.println("store_id"+vo.getStrStoreId());
		//System.out.println("hosp_code"+ vo.getStrHospitalCode());
		
		daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
		daoObj.setProcInValue(nProcIndex, "schedule_no", vo.getStrPoNo(),2);
		daoObj.setProcInValue(nProcIndex, "challan_no", vo.getStrChallanNo(),3);
		daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),4);
		daoObj.setProcInValue(nProcIndex, "item_id", "0",5);
		daoObj.setProcInValue(nProcIndex, "itembrand_id", "0",6);
		daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
		daoObj.setProcOutValue(nProcIndex, "err", 1,8);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
		daoObj.executeProcedureByPosition(nProcIndex);
		
		
		
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");		
			vo.setWsReceivedItemDtls(ws);							
		} else {
			throw new Exception(strErr);
		}	

	} catch (Exception e) {
		vo.setStrMsgString("ChallanProcessTransDAO.getReceivedItemDetails() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if  (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}	

public static void getVerifiedItemDetails(ChallanProcessTransVO vo) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet ws = null;
	try {
		dao = new HisDAO("mms", "ChallanProcessTransDAO");
		
		System.out.println("-------------- ChallanProcessTransDAO.getVerifiedItemDetails  -------------");
		 
		System.out.println("-------------- PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL [ Mode - 2]  -------------");
		 
		 
		strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL(?,?,?,?,? ,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);			
		
		dao.setProcInValue(nprocIndex, "modval", "2",1);
		dao.setProcInValue(nprocIndex, "strId", vo.getStrItemId(),2);
		dao.setProcInValue(nprocIndex, "lPRequestNo", vo.getStrChallanNo(),3);
		dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);
		dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNo(),5);
		dao.setProcInValue(nprocIndex, "poStoreId", vo.getStrItemBrandId(),6);			
		dao.setProcOutValue(nprocIndex, "err", 1,7);
		dao.setProcOutValue(nprocIndex, "resultset", 2,8);
		
		dao.executeProcedureByPosition(nprocIndex);
		
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

public static void getPrintDetails(ChallanProcessTransVO vo) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet ws = null;
	try {
		dao = new HisDAO("mms", "ChallanProcessTransDAO");
		
		System.out.println("---------- ChallanProcessTransDAO . getPrintDetails ------------");
		System.out.println("---------- PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL --[ Mode - 4 ]----------");
		
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
public static void getNewReceivedItemDetails(ChallanProcessTransVO vo) {
	
	String strProcName = "";

	int nProcIndex = 0;
	String strErr = "";
	WebRowSet ws = null;
	HisDAO daoObj = null;
	try {
		
		System.out.println("-------------- ChallanProcessTransDAO.getNewReceivedItemDetails  -------------");
		 
		System.out.println("-------------- PKG_MMS_VIEW.proc_challan_item_dtl [ Mode - 3]  -------------");
		
		daoObj = new HisDAO("ChallanProcessTrans", "ChallanProcessTransDAO");
		strProcName = "{call PKG_MMS_VIEW.proc_challan_item_dtl(?,?,?,?,? ,?,?,?,?)}";
		nProcIndex = daoObj.setProcedure(strProcName);
		
         //System.out.println("schedule_no"+ vo.getStrPoNo());
         //System.out.println("challan_no"+ vo.getStrChallanNo());
         //System.out.println("store_id"+vo.getStrStoreId());
		//System.out.println("hosp_code"+ vo.getStrHospitalCode());
		
		daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
		daoObj.setProcInValue(nProcIndex, "schedule_no", vo.getStrPoNo(),2);
		daoObj.setProcInValue(nProcIndex, "challan_no", vo.getStrChallanNo(),3);
		daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),4);
		daoObj.setProcInValue(nProcIndex, "item_id", "0",5);
		daoObj.setProcInValue(nProcIndex, "itembrand_id", "0",6);
		daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
		daoObj.setProcOutValue(nProcIndex, "err", 1,8);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
		daoObj.executeProcedureByPosition(nProcIndex);
		
		
		
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");		
			//System.out.println("getNewReceivedItemDetails ws::::::::"+ws.size());
			vo.setWsNewReceivedItemDtls(ws);							
		} else {
			throw new Exception(strErr);
		}	

	} catch (Exception e) {
		vo.setStrMsgString("ChallanProcessTransDAO.getReceivedItemDetails() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if  (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}	
public static void NewreceiveInit(ChallanProcessTransVO vo) {

	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		
		System.out.println("-------------- ChallanProcessTransDAO.NewreceiveInit  -------------");
		 
		System.out.println("-------------- PKG_MMS_VIEW.Proc_Po_Details [ Mode - 1]  -------------");
		
		dao = new HisDAO("mms", "ChallanProcessTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.Proc_Po_Details(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);

		dao.setProcInValue(nprocIndex, "modeval", "1",1);
		dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNo(),3);
		dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId(),4);
		dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
		dao.setProcOutValue(nprocIndex, "err", 1,5);
		dao.setProcOutValue(nprocIndex, "resultset", 2,6);
		dao.executeProcedureByPosition(nprocIndex);

		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";

		if (strerr.equals("")) {

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("NewreceiveInitWS::::::"+wb.size());
			if (wb != null && wb.next()) 
			{

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
		vo.setStrMsgString("ChallanProcessTransDAO.receiveInit() --> "
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
