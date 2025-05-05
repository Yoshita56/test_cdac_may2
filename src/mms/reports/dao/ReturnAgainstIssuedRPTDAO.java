package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.ReturnAgainstIssuedRPTVO;

public class ReturnAgainstIssuedRPTDAO {
	
   public static void storeName(ReturnAgainstIssuedRPTVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("DWH","ReturnAgainstIssuedRPTDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			// Start Adding Default value
			daoObj.setProcInValue(nProcIndex, "modeval","11",1);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
			// End Adding Default value
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReturnAgainstIssuedRPTDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	} 
	
	public static void getImageHeader(ReturnAgainstIssuedRPTVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","ReturnAgainstIssuedRPTDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);
			System.out.println("--------strLogoName--------"+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("ReturnAgainstIssuedRPTDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}

	public static void getIssueDetail(ReturnAgainstIssuedRPTVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws1 = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

		try 
		{
			System.out.println("---------Pkg_Mms_View.proc_OffLine_IssueNo_dtl-[ Mode -4 ]---------"); 
            // Cerating Object			
			       dao = new HisDAO("MMS",	"ReturnFromTransDAO.getIssueDetail(ReturnFromTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", 	"4",1);                  //1
			dao.setProcInValue(procIndex1, "storeid", 	vo.getStrStoreName(),2);//2			
			dao.setProcInValue(procIndex1, "itemCatg", 	vo.getStrCrNo(),3);//3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);//4
			dao.setProcInValue(procIndex1, "too_date", 	vo.getStrToDate(),5);//5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); //6
			dao.setProcOutValue(procIndex1,"err", 		1,7); // 1 for string return //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws1 = dao.getWebRowSet(procIndex1, "resultset");
				vo.setIssueNoDtlWs(ws1);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("ReturnFromTransDAO.getIssueDetail() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getReturnDetail(ReturnAgainstIssuedRPTVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

		try 
		{
            // Cerating Object			
			       dao = new HisDAO("MMS",	"ReturnFromTransDAO.getIssueDetail(ReturnFromTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", 	"2",1);                  //1
			dao.setProcInValue(procIndex1, "storeid", 	vo.getStrStoreName(),2);//2
			dao.setProcInValue(procIndex1, "itemCatg", 	vo.getStrCrNo(),3);//3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);//4
			dao.setProcInValue(procIndex1, "too_date", 	vo.getStrToDate(),5);//5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); //6
			dao.setProcOutValue(procIndex1,"err", 		1,7); // 1 for string return //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setReturnNoDtlWs(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("ReturnFromTransDAO.getIssueDetail() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueVoucherDtl(ReturnAgainstIssuedRPTVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- ReturnAgainstIssuedRPTDAO .getIssueVoucherDtl  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 3 ]------ ");
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransODAO.getStockItemDtlsList(IssueTransOVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 		"3",1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrStoreId(),3);			
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrIssueNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 			1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 	2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("ReturnAgainstIssuedRPTDAO.getIssueVoucherDtl() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getReturnVoucherDtl(ReturnAgainstIssuedRPTVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- ReturnAgainstIssuedRPTDAO .getReturnVoucherDtl  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 5 ]------ ");
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransODAO.getStockItemDtlsList(IssueTransOVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 		"5",1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrStoreId(),3);	
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrReturnNo(),2);
			System.out.println(" ------- issueNo^ returnNo ------- "+vo.getStrReturnNo());

			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 			1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 	2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransODAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
}
