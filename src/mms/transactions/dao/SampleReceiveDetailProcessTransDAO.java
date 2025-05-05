package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.SampleReceiveDetailProcessTransVO;

public class SampleReceiveDetailProcessTransDAO {

	public static void getDrugWareHouseNameCombo(SampleReceiveDetailProcessTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		        if(ws.next())
		        {	
		        	voObj.setStrDrugWareHouseId(ws.getString(1));
		        }
		        ws.beforeFirst();
				voObj.setWrsDrugWareHouseNameCmb(ws);
				
				
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getDrugWareHouseNameCombo() --> "
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
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryNo(SampleReceiveDetailProcessTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}"; //5+1=6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Sample Receive Detail","SampleReceiveDetailProcessTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrDrugWareHouseId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.setProcInValue(nProcIndex, "reqType", "0"); // Default set for reqType
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(ws.size()>0)
			{
				if(ws.next())
				{	
				  vo.setStrItemCategoryNo(ws.getString(1));
				}
				ws.beforeFirst();
			}
			else
			{
				vo.setStrItemCategoryNo("10");
			}
			if (strErr.equals("")) {
				vo.setItemCategoryComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.itemCategoryNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getSampleSentDWH(SampleReceiveDetailProcessTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_SampleSentDWH_LST(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemCatg", voObj.getStrItemCategoryNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsSampleSentDWHCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getDrugWareHouseNameCombo() --> "
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
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getSampleSentDWHItemName(SampleReceiveDetailProcessTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		String strProcName = "{call Pkg_Mms_View.proc_QcSampleitembrand_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
           	daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrDrugWareHouseId());			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDWHItemCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getSampleSentDWHItemName() --> "
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
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemBatchList(SampleReceiveDetailProcessTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_QcSampleitem_Batch_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
//            //System.out.println("Hosp_code:::"+voObj.getStrHospitalCode());
//            //System.out.println("Item Catg:::"+voObj.getStrItemCategoryNo());
//            //System.out.println("Store_id:::"+voObj.getStrDrugWareHouseId());
//            //System.out.println("Item Brand ID:::"+voObj.getStrItemBrandID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrDrugWareHouseId());
			daoObj.setProcInValue(nProcIndex, "item_brand_id", voObj.getStrItemBrandID());	
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDWHItemBatchCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getItemBatchList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getIssueDrugDtls(SampleReceiveDetailProcessTransVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_SmplRec_WithDwh(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "itemCatNo", voObj.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrDrugWareHouseId());
			daoObj.setProcInValue(nProcIndex, "sampleSentDWHId", voObj.getStrSampleSentDWHId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "batch_No", voObj.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "item_brand_id", voObj.getStrItemBrandID());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDrugIssueDetail(ws);
						
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			
			e.printStackTrace();
			
			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getIssueDrugDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
			e.printStackTrace();

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static synchronized void saveRecord(SampleReceiveDetailProcessTransVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Dml.proc_sampleRec_stockStatus(?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?)}";	//20 variable
		String[] strTmpValues,strTmpCurrStockValues;
		int nProcIndex = 0;
	
		String strErr = "";
		String brkQty = "0";

		try {
			
			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");
			strTmpValues = voObj.getStrCheckHidValue();
			
			////System.out.println("strTmpValues.length ::"+strTmpValues.length);
			
			for(int i=0; i<strTmpValues.length; i++)
			{	
				if(voObj.getStrIssueChkIndex()[i].equals("1"))
				{
					strTmpCurrStockValues = strTmpValues[i].replace("^","@").split("@");
					
					if(strTmpCurrStockValues.length > 0)
					{
						/* Value Pass in Web Row Set
					    1. ISSUE DATE
						2. STORE NAME
						3. ITEM NAME
						4. BATCH NO
						5. EXPIRY DATE    
						6. ISSUE QUANTITY
						7. ISSUE NO
						8. ITEM BRAND ID
						9. ITEM SL.NO
						10.HSTNUM_STOCK_STATUS_CODE
						11.to_store_id
						12.INHAND_QTY
						13.INHAND_QTY_UNITID
						14.RATE
						15.RATE_UNITID
						16.HSTDT_MFG_DATE 
						17.HSTNUM_SUPPLIER_ID 
						18.HSTNUM_MFG_ID 
						19.HSTSTR_PO_NO 
						20.HSTDT_PO_DATE 
						21.HSTDT_RECEIVE_DATE 
						22.HSTNUM_IS_REISSUE 
						23.GSTR_REMARKS 
						24.HSTDT_FINANCIAL_START_DATE 
						25.HSTDT_FINANCIAL_END_DATE 
						26.GDT_ENTRY_DATE 
						27.GNUM_SEATID 
						28.GNUM_ISVALID
						29.HSTNUM_ITEM_ID,
						30.HSTNUM_ISSUEQTY_UNITID,
						31.HSTNUM_ISSUE_QTY
						32.SEND STORE ID
						*/
					  
						brkQty = voObj.getStrBkgQty()[i];
						if(brkQty == null || brkQty.equals("null")) brkQty = "0";
						
						nProcIndex = daoObj.setProcedure(strProcName);
						
						daoObj.setProcInValue(nProcIndex, "p_mode", "1");                                               
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", strTmpCurrStockValues[31]);
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_TOSTORE_ID", voObj.getStrDrugWareHouseId());
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_QC_ISSUE_NO", strTmpCurrStockValues[6]);
						daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", voObj.getStrHospitalCode());
						daoObj.setProcInValue(nProcIndex, "p_SSTNUM_ITEM_CAT_NO", voObj.getStrItemCategoryNo());
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_ID", strTmpCurrStockValues[28]);
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEMBRAND_ID", strTmpCurrStockValues[7]);
						daoObj.setProcInValue(nProcIndex, "p_HSTSTR_BATCH_NO", strTmpCurrStockValues[3]);
						daoObj.setProcInValue(nProcIndex, "p_HSTSTR_ITEM_SL_NO", strTmpCurrStockValues[8]);
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ISSUE_QTY", strTmpCurrStockValues[30]);
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ISSUEQTY_UNITID", strTmpCurrStockValues[29]);
						daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STOCK_STATUS_CODE", strTmpCurrStockValues[9]);
						daoObj.setProcInValue(nProcIndex, "p_GSTR_REMARKS", strTmpCurrStockValues[22]);
						daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID", voObj.getStrSeatId());
						daoObj.setProcInValue(nProcIndex, "p_GDT_ENTRY_DATE", "");
						daoObj.setProcInValue(nProcIndex, "p_GNUM_ISVALID", "1");					
						daoObj.setProcInValue(nProcIndex, "p_description", "-");
						daoObj.setProcInValue(nProcIndex, "p_bkgQty", brkQty);	
						////System.out.println("Breakage Qty::::"+strTmpCurrStockValues[47]);
						daoObj.setProcOutValue(nProcIndex, "err", 1);					
						daoObj.execute(nProcIndex,1);
					}
				}
			}
			
			daoObj.fire();
			voObj.setStrMsgType("0");
			
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.saveRecord() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}

	public static void getViewSampleReceiveHlp(
			SampleReceiveDetailProcessTransVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_SampleReceive_Detail(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "itemCatNo", voObj.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrDrugWareHouseId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "fromDate", voObj.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "toDate", voObj.getStrToDate());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsViewSampleReceiveDetail(ws);
				////System.out.println("WRS SIZE :"+voObj.getWrsViewSampleReceiveDetail().size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			
			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getViewSampleReceiveHlp() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
			e.printStackTrace();

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}

	public static void getDrugCurrStockDtl(
			SampleReceiveDetailProcessTransVO voObj, int i) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_drug_currstock_view(?,?,?,?,?,?,?,?,?)}";	//9 variables
		String[] str =voObj.getStrCheckHidValue()[i].replace("^","#").split("#");
		//String[] strCurrStockStatusDtl=null;
		String strTmp;
		
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			/* Value Pass in Web Row Set
		    1. ISSUE DATE
			2. STORE NAME
			3. ITEM NAME
			4. BATCH NO
			5. EXPIRY DATE    
			6. ISSUE QUANTITY
			7. ISSUE NO
			8. ITEM BRAND ID
			9. ITEM SL.NO
			10.HSTNUM_STOCK_STATUS_CODE
			11.to_store_id
			12.INHAND_QTY
			13.INHAND_QTY_UNITID
			14.RATE
			15.RATE_UNITID
			16.HSTDT_MFG_DATE 
			17.HSTNUM_SUPPLIER_ID 
			18.HSTNUM_MFG_ID 
			19.HSTSTR_PO_NO 
			20.HSTDT_PO_DATE 
			21.HSTDT_RECEIVE_DATE 
			22.HSTNUM_IS_REISSUE 
			23.GSTR_REMARKS 
			24.HSTDT_FINANCIAL_START_DATE 
			25.HSTDT_FINANCIAL_END_DATE 
			26.GDT_ENTRY_DATE 
			27.GNUM_SEATID 
			28.GNUM_ISVALID
			29.HSTNUM_ITEM_ID
			30.HSTNUM_ISSUEQTY_UNITID
			31.HSTNUM_ISSUE_QTY
			32.HSTNUM_STORE_ID
			
			
		  
		  //VoObj
		  STORE_ID =	vo.getStrDrugWareHouseId();
		  ITEM CAT NO=	vo.getStrItemCategoryNo();
		  
		 */
			nProcIndex = daoObj.setProcedure(strProcName);
//			//System.out.println("Inside Current Stock for Record"+(i+1));
//			//System.out.println( "item_id"+ str[28]);
//			//System.out.println( "itembrand_id"+ str[7]);
//			//System.out.println( "batch_no"+ str[3]);
//			//System.out.println( "stockStatus"+str[9]);
//			//System.out.println( "hosp_code"+ voObj.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", str[31]);
			daoObj.setProcInValue(nProcIndex, "item_id", str[28]);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", str[7]);
			daoObj.setProcInValue(nProcIndex, "batch_no", str[3]);
			daoObj.setProcInValue(nProcIndex, "stockStatus",str[9]);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				int j=0;
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				//strCurrStockStatusDtl = new String[ws.size()]; 
				////System.out.println("WRS SIZE :"+ws.size());
				if(ws != null){
					while(ws.next()){
//						//System.out.println("ws.getString(1):::::::::"+ws.getString(1));
//						//System.out.println("ws.getString(2):::::::::"+ws.getString(2));
//						//System.out.println("ws.getString(3):::::::::"+ws.getString(3));
//						//System.out.println("ws.getString(4):::::::::"+ws.getString(4));
//						//System.out.println("ws.getString(5):::::::::"+ws.getString(5));
//						//System.out.println("ws.getString(6):::::::::"+ws.getString(6));
//						//System.out.println("ws.getString(7):::::::::"+ws.getString(7));
//						//System.out.println("ws.getString(8):::::::::"+ws.getString(8));
//						//System.out.println("ws.getString(9):::::::::"+ws.getString(9));
//						//System.out.println("ws.getString(10):::::::::"+ws.getString(10));
//						//System.out.println("ws.getString(11):::::::::"+ws.getString(11));
//						//System.out.println("ws.getString(12):::::::::"+ws.getString(12));
//						//System.out.println("ws.getString(13):::::::::"+ws.getString(13));
//						//System.out.println("ws.getString(14):::::::::"+ws.getString(14));
//						//System.out.println("ws.getString(15):::::::::"+ws.getString(15));
//						//System.out.println("ws.getString(16):::::::::"+ws.getString(16));
//						//System.out.println("ws.getString(17):::::::::"+ws.getString(17));
//						//System.out.println("ws.getString(18):::::::::"+ws.getString(18));
//						//System.out.println("ws.getString(19):::::::::"+ws.getString(19));
//						//System.out.println("ws.getString(20):::::::::"+ws.getString(20));
//						//System.out.println("ws.getString(21):::::::::"+ws.getString(21));
//						//System.out.println("ws.getString(22):::::::::"+ws.getString(22));
//						//System.out.println("ws.getString(23):::::::::"+ws.getString(23));
//						//System.out.println("ws.getString(24):::::::::"+ws.getString(24));
//						//System.out.println("ws.getString(25):::::::::"+ws.getString(25));
//						//System.out.println("ws.getString(26):::::::::"+ws.getString(26));
//						//System.out.println("ws.getString(27):::::::::"+ws.getString(27));
//						//System.out.println("ws.getString(28):::::::::"+ws.getString(28));
//						//System.out.println("ws.getString(29):::::::::"+ws.getString(29));
//						//System.out.println("ws.getString(30):::::::::"+ws.getString(30));
//						//System.out.println("ws.getString(31):::::::::"+ws.getString(31));
//						//System.out.println("ws.getString(32):::::::::"+ws.getString(32));
//						strCurrStockStatusDtl[j]=(ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+
//													ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+
//													ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+
//													ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+
//													ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+
//													ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+
//													ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+
//													ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+
//													ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+
//													ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+
//													ws.getString(31)+"^"+ws.getString(32));
						
						strTmp=ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+
								ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+
								ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+
								ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+
								ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+
								ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+
								ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+
								ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+
								ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+
								ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+
								ws.getString(31)+"^"+ws.getString(32);
						strTmp=strTmp+"^"+str[16]+"^"+str[6]+"^"+str[28]+"^"+str[7]+"^"+str[3]+"^"+str[8]+"^"+str[5]+"^"+str[29]+"^"+str[9]+"^"+str[22]+"^"+str[26]+"^"+str[25]+"^"+str[27]+"^"+str[30]+"^"+str[31];
						voObj.setStrTmpVar(strTmp);
						
						j++;
					}
				}
				//voObj.setStrCurrentStockStatusDetail(strCurrStockStatusDtl);
				////System.out.println("Length::::"+voObj.getStrCurrentStockStatusDetail().length);
				
				//voObj.setWrsCurrentStockStatusDetail(ws);
				
				////System.out.println("WRS SIZE :"+voObj.getWrsCurrentStockStatusDetail().size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			
			voObj
					.setStrMsgString("SampleReceiveDetailProcessTransDAO.getDrugCurrStockDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
			e.printStackTrace();

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
			
			
			
			
		
	}

	
}
