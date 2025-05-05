package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.AcknowledgeDAO;
import mms.dao.AcknowledgeStockDAO;
import mms.transactions.vo.AcknowledgeTransVO;


public class AcknowledgeTransDAO {
	
	public static void getAcknowledgeVal(AcknowledgeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","AcknowledgeTransDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_Acknowledge_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			System.out.println("-------------PKG_MMS_VIEW.Proc_Acknowledge_Details------------------");
			System.out.println("storeId"+ voObj.getStrStoreId());
			System.out.println("hosp_code"+ voObj.getStrHospitalCode());
			System.out.println("transNo"+ voObj.getStrTransNo());
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("In getAcknowldegeVal ::"+ws.size());
			if (strErr.equals("")) {

				voObj.setStrAcknowledgeDtlWs(ws);
				

			} else {
				throw new Exception(strErr);
			}
			System.out.println("In the AcknowledgeTransDAO");
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AcknowledgeTransDAO.getAcknowledgeVal() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getAcknowledgeValVoucher(AcknowledgeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","AcknowledgeTransDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_Acknowledge_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			System.out.println("-------------PKG_MMS_VIEW.getAcknowledgeValVoucher------------------");
			System.out.println("storeId"+ voObj.getStrStoreId());
			System.out.println("hosp_code"+ voObj.getStrHospitalCode());
			System.out.println("transNo"+ voObj.getStrTransNo());
			
			daoObj.setProcInValue(nProcIndex, "modval", "3",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("In getAcknowldegeVal ::"+ws.size());
			if (strErr.equals("")) {

				voObj.setStrAcknowledgeDtlWs(ws);
				

			} else {
				throw new Exception(strErr);
			}
			System.out.println("In the AcknowledgeTransDAO");
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AcknowledgeTransDAO.getAcknowledgeVal() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getAcknowledgeValView(AcknowledgeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","AcknowledgeTransDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_Acknowledge_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex,"modval", "2",1);
			daoObj.setProcInValue(nProcIndex,"storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex,"hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex,"transNo", voObj.getStrTransNo(),4);
			daoObj.setProcOutValue(nProcIndex,"err", 1,5);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrAcknowledgeDtlWs(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AcknowledgeTransDAO.getAcknowledgeValView() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
		public static void getItemVal(AcknowledgeTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "";
			int nProcIndex = 0;

			String strErr = "";

			try {
				// value does not set
				daoObj = new HisDAO("mms","AcknowledgeTransDAO");

				strProcName = "{call PKG_MMS_VIEW.Proc_Ack_Item_Dtls(?,?,?,?,?,?,?)}";
				nProcIndex = daoObj.setProcedure(strProcName);
				
				System.out.println("Store Id-->>>"+voObj.getStrStoreId());
				System.out.println("Trans No-->>>"+voObj.getStrTransNo());
				System.out.println("Req Type Id-->>"+voObj.getStrReqTypeId());

				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
				
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo(),4);
				
				daoObj.setProcInValue(nProcIndex, "reqTypeId", voObj.getStrReqTypeId(),5);
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("in getItemVal size::"+ws.size());
				if (strErr.equals("")) {

					voObj.setStrItemDtlWs(ws);
					

				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				voObj.setStrMsgString("AcknowledgeTransDAO.getItemVal() --> "+e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

	}
		
		public static void getAckVal(AcknowledgeTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "";
			int nProcIndex = 0;

			String strErr = "";

			try {
				// value does not set
				daoObj = new HisDAO("mms","AcknowledgeTransDAO");

				strProcName = "{call  PKG_MMS_VIEW.Proc_Ack_Dtls(?,?,?,?,?,?)}";
				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo(),4);
				daoObj.setProcOutValue(nProcIndex, "err", 1,5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) {

					voObj.setStrAckDtlWs(ws);
					

				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("AcknowledgeTransDAO.getAckVal() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

	}
		
		public synchronized static void insertRecord(AcknowledgeTransVO voObj) 
		{

			HisDAO daoObj = null;
			
			AcknowledgeDAO ackDAO = null;
			AcknowledgeStockDAO ackStockDAO = null;

			try {
				// value does not set
				daoObj = new HisDAO("mms","AcknowledgeTransDAO");
				ackDAO = new AcknowledgeDAO();
				ackStockDAO = new AcknowledgeStockDAO();
				
				String strReqId = voObj.getStrReqTypeId();
				
				if(voObj.getStrHiddenValue() == null)
				{
					throw new Exception("999voObj.getStrHiddenValue is null !!");
				}
				
				System.out.println("--voObj.getStrHiddenValue().length.Length---- "+voObj.getStrHiddenValue().length);
				
				//for(int i = 0, stopI = voObj.getStrHiddenValue().length; i<stopI; i++)
				for (int i = 0; i < voObj.getStrHiddenValue().length; i++) 
				{
					System.out.println("-----------------------------------------------------");
					String[] strTemp = voObj.getStrHiddenValue()[i].replace("^", "#").split("#");
					System.out.println("--------index no ------"+i);
					System.out.println("-------- voObj.getStrHiddenValue()["+i+"]------"+ voObj.getStrHiddenValue()[i]);
					
					System.out.println("--------voObj.getStrToStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------voObj.getStrStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------strTemp[3]------------"+strTemp[3]);
					System.out.println("--------strTemp[4]------------"+strTemp[4]);
					System.out.println("--------strTemp[1]------------"+strTemp[1]);
					System.out.println("--------voObj.getStrItemCatNo()------------"+voObj.getStrItemCatNo());
					System.out.println("--------voObj.getStrReceivedQty()------------"+voObj.getStrReceivedQty()[i]);
					System.out.println("--------voObj.getStrSeatId()------------"+voObj.getStrSeatId());
					System.out.println("--------voObj.getStrHospitalCode()------------"+voObj.getStrHospitalCode());
					System.out.println("--------voObj.getStrTransNo()------------"+voObj.getStrTransNo());
					System.out.println("--------strTemp[6]------------"+strTemp[6]);
					System.out.println("--------strTemp[5]------------"+strTemp[5]);
					System.out.println("--------voObj.getStrReqTypeId()------------"+voObj.getStrReqTypeId());
					
					
					ackStockDAO.setStrToStoreId(voObj.getStrToStrId());//str id
					ackStockDAO.setStrStoreId(voObj.getStrStrId());   // Issuing Store
					ackStockDAO.setStrOldItemId(strTemp[3]);
					ackStockDAO.setStrOldItemBrandId(strTemp[4]);
					ackStockDAO.setStrOldBatchNo(strTemp[1]);
					ackStockDAO.setStrItemCatNo(voObj.getStrItemCatNo());					
					ackStockDAO.setStrInHandQty(voObj.getStrReceivedQty()[i]);				
					ackStockDAO.setStrSeatId(voObj.getStrSeatId());
					ackStockDAO.setStrHospitalCode(voObj.getStrHospitalCode());
					ackStockDAO.setStrAckNo(voObj.getStrTransNo());
					ackStockDAO.setStrOldStockStatusCode(strTemp[6]);
					ackStockDAO.setStrOldItemSerialNo(strTemp[5]);
					ackStockDAO.setStrReqTypeId(voObj.getStrReqTypeId());				
					ackStockDAO.update(daoObj);  // PKG_MMS_DML.dml_ack_item_dtl [ Mode - 1 ]
					
					
					System.out.println("-----------------------------------------------------");
				
				}
				ackDAO.setStrRemarks(voObj.getStrRemarks());
				ackDAO.setStrStoreId(voObj.getStrStoreId());//to store id
				ackDAO.setStrTransNo(voObj.getStrTransNo());
				ackDAO.setStrHospitalCode(voObj.getStrHospitalCode());
				ackDAO.setStrReqTypeId(strReqId);
				ackDAO.setStrAckBy(voObj.getStrSeatId());
				
				ackDAO.insert(daoObj);  // PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl [ Mode - 1 ]
				
				daoObj.fire();
				
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("AcknowledgeTransDAO.insertRecord() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

	}
		
		
		public synchronized static void rejectRecord(AcknowledgeTransVO voObj) 
		{

			HisDAO daoObj = null;

			try 
			{
				System.out.println("----------------------AcknowledgeTransDAO.rejectRecord---------------------------");
				
				// value does not set
				daoObj = new HisDAO("mms","AcknowledgeTransDAO");
				
				String strReqId = voObj.getStrReqTypeId();
				
				if(voObj.getStrHiddenValue() == null)
				{
					throw new Exception("voObj.getStrHiddenValue is null !!");
				}
				System.out.println("----------------------PKG_MMS_DML.dml_reject_return_item_dtl-[ Mode - 1 ]---------------------------");
				for (int i = 0; i < voObj.getStrHiddenValue().length; i++) 
				{
					
					String[] strTemp = voObj.getStrHiddenValue()[i].replace("^", "#").split("#");
					
					System.out.println("--------index no ------"+i);
					System.out.println("--------voObj.getStrHiddenValue()["+i+"]------"+ voObj.getStrHiddenValue()[i]);					
					System.out.println("--------voObj.getStrToStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------voObj.getStrStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------strTemp[3]------------"+strTemp[3]);
					System.out.println("--------strTemp[4]------------"+strTemp[4]);
					System.out.println("--------strTemp[1]------------"+strTemp[1]);
					System.out.println("--------voObj.getStrItemCatNo()------------"+voObj.getStrItemCatNo());
					System.out.println("--------voObj.getStrReceivedQty()------------"+voObj.getStrReceivedQty()[i]);
					System.out.println("--------voObj.getStrSeatId()------------"+voObj.getStrSeatId());
					System.out.println("--------voObj.getStrHospitalCode()------------"+voObj.getStrHospitalCode());
					System.out.println("--------voObj.getStrTransNo()------------"+voObj.getStrTransNo());
					System.out.println("--------strTemp[6]------------"+strTemp[6]);
					System.out.println("--------strTemp[5]------------"+strTemp[5]);
					System.out.println("--------voObj.getStrReqTypeId()------------"+voObj.getStrReqTypeId());
					
					String proc_name1 = "{call PKG_MMS_DML.dml_reject_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  // 17 Variable	
										
					int nprocIndex1 = daoObj.setProcedure(proc_name1);
					daoObj.setProcInValue(nprocIndex1, "modval", 			"1",1); 
					daoObj.setProcInValue(nprocIndex1, "nstrid",            voObj.getStrToStrId(),2);   //str id
					daoObj.setProcInValue(nprocIndex1, "nitemid",           strTemp[3],3);
					daoObj.setProcInValue(nprocIndex1, "nitembrandid",  	strTemp[4],4);
					daoObj.setProcInValue(nprocIndex1, "nbatchno", 			strTemp[1],5);
					daoObj.setProcInValue(nprocIndex1, "nitemcatno",		voObj.getStrItemCatNo(),6);
					daoObj.setProcInValue(nprocIndex1, "nstockstatuscode",  strTemp[6],7);
					daoObj.setProcInValue(nprocIndex1, "ninhandqty",		voObj.getStrReceivedQty()[i],8);
					daoObj.setProcInValue(nprocIndex1, "nseatid", 			voObj.getStrSeatId(),9);
					daoObj.setProcInValue(nprocIndex1, "nhosp_code", 		voObj.getStrHospitalCode(),10);
					daoObj.setProcInValue(nprocIndex1, "nold_itemserialno", strTemp[5],11);
					daoObj.setProcInValue(nprocIndex1, "ntostrid", 			voObj.getStrStrId(),12);     // Issuing Store
					daoObj.setProcInValue(nprocIndex1, "nreqtypeid",		voObj.getStrReqTypeId(),13);
					daoObj.setProcInValue(nprocIndex1, "nackNo",			voObj.getStrTransNo(),14);
					daoObj.setProcInValue(nprocIndex1, "ntransNo", 			voObj.getStrTransNo(),15);
					daoObj.setProcInValue(nprocIndex1, "nStockRegNo", 		"0",16);				
					daoObj.setProcOutValue(nprocIndex1, "err", 				1,17); 
					daoObj.execute(nprocIndex1, 1);
					
					
					System.out.println("-----------------------------------------------------");
				
				}
				
				System.out.println("----------------------PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl-[ Mode - 2 ]---------------------------");
				
				String proc_name = "{call PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?,?,?,?)}";
				int nprocIndex = daoObj.setProcedure(proc_name);
				
				daoObj.setProcInValue(nprocIndex, "modval", 	"2",1);
				daoObj.setProcInValue(nprocIndex, "storeId", 	voObj.getStrStoreId(),2);
				daoObj.setProcInValue(nprocIndex, "transNo", 	voObj.getStrTransNo(),3);
				daoObj.setProcInValue(nprocIndex, "hosp_code", 	voObj.getStrHospitalCode(),4);
				daoObj.setProcInValue(nprocIndex, "seatId", 	voObj.getStrSeatId(),5);
				daoObj.setProcInValue(nprocIndex, "reqTypeId",  strReqId,6);
				daoObj.setProcInValue(nprocIndex, "remarks", 	voObj.getStrRemarks(),7);
				daoObj.setProcOutValue(nprocIndex, "err", 		1,8);
				daoObj.execute(nprocIndex, 1);
				
				daoObj.fire();
				
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("AcknowledgeTransDAO.rejectRecord() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

	}
		
		public synchronized static void insertRecord_ORG(AcknowledgeTransVO voObj) 
		{

			HisDAO daoObj = null;
			
			AcknowledgeDAO ackDAO = null;
			AcknowledgeStockDAO ackStockDAO = null;

			try {
				// value does not set
				daoObj = new HisDAO("mms","AcknowledgeTransDAO");
				ackDAO = new AcknowledgeDAO();
				ackStockDAO = new AcknowledgeStockDAO();
				
				String strReqId = voObj.getStrReqTypeId();
				
				if(voObj.getStrHiddenValue() == null)
				{
					throw new Exception("999voObj.getStrHiddenValue is null !!");
				}
				
				System.out.println("--voObj.getStrHiddenValue().length.Length---- "+voObj.getStrHiddenValue().length);
				
				//for(int i = 0, stopI = voObj.getStrHiddenValue().length; i<stopI; i++)
				for (int i = 0; i < voObj.getStrHiddenValue().length; i++) 
				{
					System.out.println("-----------------------------------------------------");
					String[] strTemp = voObj.getStrHiddenValue()[i].replace("^", "#").split("#");
					System.out.println("--------index no ------"+i);
					System.out.println("-------- voObj.getStrHiddenValue()["+i+"]------"+ voObj.getStrHiddenValue()[i]);
					
					System.out.println("--------voObj.getStrToStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------voObj.getStrStrId()------------"+voObj.getStrToStrId());
					System.out.println("--------strTemp[3]------------"+strTemp[3]);
					System.out.println("--------strTemp[4]------------"+strTemp[4]);
					System.out.println("--------strTemp[1]------------"+strTemp[1]);
					System.out.println("--------voObj.getStrItemCatNo()------------"+voObj.getStrItemCatNo());
					System.out.println("--------voObj.getStrReceivedQty()------------"+voObj.getStrReceivedQty()[i]);
					System.out.println("--------voObj.getStrSeatId()------------"+voObj.getStrSeatId());
					System.out.println("--------voObj.getStrHospitalCode()------------"+voObj.getStrHospitalCode());
					System.out.println("--------voObj.getStrTransNo()------------"+voObj.getStrTransNo());
					System.out.println("--------strTemp[6]------------"+strTemp[6]);
					System.out.println("--------strTemp[5]------------"+strTemp[5]);
					System.out.println("--------voObj.getStrReqTypeId()------------"+voObj.getStrReqTypeId());
					
					
					ackStockDAO.setStrToStoreId(voObj.getStrToStrId());//str id
					ackStockDAO.setStrStoreId(voObj.getStrStrId());   // Issuing Store
					ackStockDAO.setStrOldItemId(strTemp[3]);
					ackStockDAO.setStrOldItemBrandId(strTemp[4]);
					ackStockDAO.setStrOldBatchNo(strTemp[1]);
					ackStockDAO.setStrItemCatNo(voObj.getStrItemCatNo());					
					ackStockDAO.setStrInHandQty(voObj.getStrReceivedQty()[i]);				
					ackStockDAO.setStrSeatId(voObj.getStrSeatId());
					ackStockDAO.setStrHospitalCode(voObj.getStrHospitalCode());
					ackStockDAO.setStrAckNo(voObj.getStrTransNo());
					ackStockDAO.setStrOldStockStatusCode(strTemp[6]);
					ackStockDAO.setStrOldItemSerialNo(strTemp[5]);
					ackStockDAO.setStrReqTypeId(voObj.getStrReqTypeId());				
					ackStockDAO.update(daoObj);  // PKG_MMS_DML.dml_ack_item_dtl [ Mode - 1 ]
					
					
					System.out.println("-----------------------------------------------------");
				
				}
				ackDAO.setStrRemarks(voObj.getStrRemarks());
				ackDAO.setStrStoreId(voObj.getStrStoreId());//to store id
				ackDAO.setStrTransNo(voObj.getStrTransNo());
				ackDAO.setStrHospitalCode(voObj.getStrHospitalCode());
				ackDAO.setStrReqTypeId(strReqId);
				ackDAO.setStrAckBy(voObj.getStrSeatId());
				
				ackDAO.insert(daoObj);  // PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl [ Mode - 1 ]
				
				daoObj.fire();
				
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("AcknowledgeTransDAO.insertRecord() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

	}
		
		
		/**
		 * This function is used to set details in view page(Brakage Item Dtl). 
		 * @param _BreakageItemDtlTransVO
		 */
		public static void getTransferDtl(AcknowledgeTransVO _AcknowledgeTransVO)
		{
			
			String strProcName = "{call pkg_mms_view.Proc_Transfer_Detail(?,?,?,?,?,?)}";  // Total 6 Variables
			int nProcIndex = 0;
			String strErr = "";
			
			WebRowSet ws = null;
			HisDAO daoObj=null;
			try
			{
				////System.out.println("Welcome to View Dtl");
				daoObj  = new HisDAO("MMSModule","AcknowledgeTransDAO");
				
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "hosp_code",  _AcknowledgeTransVO.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "strId",      _AcknowledgeTransVO.getStrStoreId());
				////System.out.println("Transfer Dtl Store ID==>"+_AcknowledgeTransVO.getStrStoreId());
				daoObj.setProcInValue(nProcIndex, "transferNo", _AcknowledgeTransVO.getStrTransNo());
				daoObj.setProcOutValue(nProcIndex, "err",1); 
				daoObj.setProcOutValue(nProcIndex, "resultset",2);
				
				daoObj.executeProcedure(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if(strErr.equals(""))
				{
					
					_AcknowledgeTransVO.setTransferDtlWs(ws);
					
				}
			}
			catch(Exception _err)
			{
				_err.printStackTrace();
				_AcknowledgeTransVO.setStrMsgString("AcknowledgeTransDAO.getTransferDtl() --> "
						+ _err.getMessage());
				_AcknowledgeTransVO.setStrMsgType("1");
			}
		}	
		
		
		/**
		 * Gets the issue dtls list.
		 * 
		 * @param vo the vo
		 * 
		 * @return the issue dtls list
		 * This Function is Used To Get Ajax Voucher Details
		 */
		public static void getAckVoucherDtl(AcknowledgeTransVO vo) {

			String err;
			String strSlNoflg;
			HisDAO     dao = null;
			WebRowSet   ws = null;
			int procIndex1 = 0;
			int nFuncIndex = 0;
			 /* Function Added By Amit on Date 24/09/2010  */
			 /* Function Used to get Flag whether SlNo Coloum will be shown or not in Report*/
			String strFuncName = "{? = call MMS_MST.get_reqperfix(?::numeric,?::numeric,?::numeric)}";
			String proc_name1 = "{call pkg_mms_view.proc_issue_detail(?,?,?,?,?,?)}"; //6
			try 
			{
				/*
				  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
				  1.Issue No
				  2.Issue Date
				  3.Issue To 
				  4.Issue By
				  5.Generic Name
				  6.Brand Name
				  7.Batch No
				  8.Expiry date
				  9.Issue rate
				  10.Issue Qty
				  11.Store Id
				  12.Item Id
				  13.Item Brand ID
				  14.Batch No
				  15.Expiry Date
				  16.Issue Rate
				  17.Issue Rate Unit Id
				  18.Issue Rate Base Unit Id
				  19.Issue Qty
				  20.Issue Qty Unit Id
				  21.Issue Qty Base Value
				  22.Item Sl No
				  23.Item SL No
				  24,Category Code
				  25.Issue Qty
				  26.Remarks
				  27.Final remarks
				  28.Received By
				  29.Cost
				  30.Total Avl Budget
				  31.Indent No
				  32.Indent Date
				  33.Purchase Rate With Unit e.g 101 No. 
				  34.Cost With Purchase Rate
				  35.Budget Used
				 */			
				/*
				  Total 33 Value Return In Case of ModeVal 4 (Which Call in Case of On-Line Acknowledge Voucher)
				  1.Issue No
				  2.Issue Date
				  3.Issue To 
				  4.Issue By
				  5.Generic Name
				  6.Brand Name
				  7.Batch No
				  8.Expiry date
				  9.Issue rate
				  10.Issue Qty
				  11.Store Id
				  12.Item Id
				  13.Item Brand ID
				  14.Batch No
				  15.Expiry Date
				  16.Issue Rate
				  17.Issue Rate Unit Id
				  18.Issue Rate Base Unit Id
				  19.Issue Qty
				  20.Issue Qty Unit Id
				  21.Issue Qty Base Value
				  22.Item Sl No
				  23.Item SL No
				  24,Category Code
				  25.Issue Qty
				  26.Remarks
				  27.Received By
				  28.Issued by 
				  29.Final Remarks
				  30.Cost
				  31.Total Avlaible Budget
				  32.Purchase Rate With Unit e.g 45 10*10 No.
				  33.Cost With Purchase Rate
				 
				 */
				dao = new HisDAO("mms","AcknowledgeTransDAO.getAckVoucherDtl(AcknowledgeTransVO vo)");
				
				
				nFuncIndex = dao.setFunction(strFuncName);
				
				////System.out.println("Modeval::::"+vo.getStrModeVal());
				////System.out.println("Issue No::::"+vo.getStrIssueNo());
				////System.out.println("Store ID::::"+vo.getStrFromStoreId());
				
				System.out.println("-----------AcknowledgeTransDAO . getAckVoucherDtl [ After Save Ack Voucher ] pkg_mms_view.proc_issue_detail [ Mode "+vo.getStrModeVal()+" ]--------------");
				
				procIndex1 = dao.setProcedure(proc_name1);

				// set value

				dao.setProcInValue(procIndex1, "modeval", vo.getStrModeVal(),1);
				dao.setProcInValue(procIndex1, "strId", vo.getStrFromStoreId(),3);
				dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo().split("\\^")[0],2);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4);
				dao.setProcOutValue(procIndex1,"err", 1,5); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);
				// get value
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";

				ws = dao.getWebRowSet(procIndex1, "resultset");
	            ////System.out.println("MMs DAO size:::"+ws.size());
				if (ws != null && ws.size() > 0) {

					if (ws.next()) 
					{

						vo.setStrIssueDate(ws.getString(2));
						vo.setStrIssueTo(ws.getString(3));
						////System.out.println("ws.getString(3)-------------------------"+ws.getString(3));
						vo.setStrStoreName(ws.getString(4));
						vo.setStrItemCategoryNo(ws.getString(24));
					    if(vo.getStrModeVal().equals("5"))
					    {
					    	vo.setStrReturnReqNo(ws.getString(26));				    	
					    }						
						dao.setFuncInValue(nFuncIndex, 2, "4");
						dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
						dao.setFuncInValue(nFuncIndex, 4, ws.getString(24));
						dao.setFuncOutValue(nFuncIndex, 1);
						dao.executeFunction(nFuncIndex);
						strSlNoflg = dao.getFuncString(nFuncIndex);
						vo.setStrSlNoflg(strSlNoflg);
						
					}
	  
					ws.beforeFirst();

				}

				vo.setWsIssueDetails(ws);

			} catch (Exception e) {
	            e.printStackTrace();
				vo.setStrMsgString("AcknowledgeTransDAO.getAckVoucherDtl() --> "
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
