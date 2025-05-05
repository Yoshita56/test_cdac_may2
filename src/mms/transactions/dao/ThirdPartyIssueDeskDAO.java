package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;

import mms.global.vo.MmsVO;
import mms.transactions.vo.ThirdPartyIssueDeskVO;

public class ThirdPartyIssueDeskDAO {
	public static String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	public static String DATE_FORMAT_NOW = "dd-MMM-yyyy";

	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the ITEM CATEGORY LIST
	 */

	public static void getItemDetails(ThirdPartyIssueDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Thirdpartyissue_Item_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions", "ThirdPartyIssueDeskDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			// //System.out.println("hosp_code->"+voObj.getStrHospitalCode());
			// //System.out.println("req_no->"+voObj.getStrReqNo());
			// //System.out.println("store_Id->"+voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode(),4);
			daoObj.setProcInValue(nProcIndex, "req_no", voObj.getStrReqNo(),2);
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
			// strErr = daoObj.getString(nProcIndex, "err");

			/*
			 * if (strErr == null) strErr = "";
			 */

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				// //System.out.println("ws Size->"+ws.size());
				voObj.setStrItemDetailsWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("ThirdPartyIssueDeskDAO.getItemDetails() --> "
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
	 * Gets the issue dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls list
	 * This Function is Used To Get Ajax Voucher Details
	 */
	public static void getIssueDtlsList(ThirdPartyIssueDeskVO vo) {

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
			dao = new HisDAO("mms","global.MmsDAO.getStockItemDtlsList(MmsVO vo)");
			
			
			nFuncIndex = dao.setFunction(strFuncName);
			
			////System.out.println("Modeval::::"+vo.getStrModeVal());
			////System.out.println("Issue No::::"+vo.getStrIssueNo());
			////System.out.println("Store ID::::"+vo.getStrFromStoreId());
			
			System.out.println("-----------MmsDAO . getIssueDtlsList [ After Save Issue Voucher ] pkg_mms_view.proc_issue_detail [ Mode "+vo.getStrModeVal()+" ]--------------");
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval",	 	vo.getStrModeVal(),1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrFromStoreId(),3);
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrIssueNo().split("\\^")[0],2);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"err", 			1,5); // 1 for string return
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
			System.out.println("vo.setWsIssueDetails----->"+vo.getWsIssueDetails());
		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getIssueDtlsList() --> "
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
