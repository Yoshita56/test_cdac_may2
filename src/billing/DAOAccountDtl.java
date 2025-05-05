package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOAccountDtl {
	// /////////////////A/C Detail With Puk No/////////////////////////////
	public static void getAccountDtlWithPukNo(BillingVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;

		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getAccountDtlWithAcctNo(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "accNo", "",1);
			dao.setProcInValue(procIndex1, "puk", voHdrObj.getStrValue1(),2);
			dao.setProcInValue(procIndex1, "chargeTypeId", voHdrObj.getStrValue2(),3);
			dao.setProcInValue(procIndex1, "activeAccount", voHdrObj.getStrValue3(),4);
			dao.setProcInValue(procIndex1, "modeVal", "2",5);
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrValue4(),6);
			dao.setProcOutValue(procIndex1, "ERR", 1,7); // 1 for string return
												// value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,8); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value

			ws1 = dao.getWebRowSet(procIndex1, "RESULTSET");

			voHdrObj.setGblWs3(ws1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			if (!err.equals("")) {

				throw new Exception(err);

			}

		} catch (Exception e) {
		 
			voHdrObj
					.setStrMsgString("BillHeaderDAO.getAccountDtlWithAcctNo() --> "
							+ e.getMessage());
			voHdrObj.setStrMsgType("1");
		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	public static void getAllAmtForViewBill(BillingVO voHdrObj) {
		// HisDAO daoObj = null;
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String strAcctNo = voHdrObj.getStrValue1();
		String strHospCode = voHdrObj.getStrValue2();

		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getAllAmtForViewBill(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", strAcctNo,1);
			dao.setProcInValue(procIndex1, "puk", "",2);
			dao.setProcInValue(procIndex1, "chargetypeid", "",3);
			dao.setProcInValue(procIndex1, "activeaccount", "",4);
			dao.setProcInValue(procIndex1, "modeVal", "4",5);

			dao.setProcInValue(procIndex1, "hosp_code", strHospCode,6);

			dao.setProcOutValue(procIndex1, "ERR", 1,7); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value

			ws1 = dao.getWebRowSet(procIndex1, "RESULTSET");
			voHdrObj.setGblWs1(ws1);
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			if (!err.equals("")) {

				throw new Exception(err);

			}

		} catch (Exception e) {
		 
			voHdrObj
					.setStrMsgString("BillHeaderDAO.getAllAmtForViewBill() --> "
							+ e.getMessage());
			voHdrObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	// /////////////////A/C Detail With Acc No/////////////////////////////
	public static void getAccountDtlWithAcctNo(BillingVO voHdrObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String strAcctNo = voHdrObj.getStrValue1();
		String strHospCode = voHdrObj.getStrValue2();

		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		try 
		{
			dao = new HisDAO("billing","transactions.DAObilling.getAccountDtlWithAcctNo(BillingVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "accNo", strAcctNo,1);
			dao.setProcInValue(procIndex1, "puk", "",2);
			dao.setProcInValue(procIndex1, "chargetypeid", "",3);
			dao.setProcInValue(procIndex1, "activeaccount", "",4);
			dao.setProcInValue(procIndex1, "modeVal", "1",5);
			dao.setProcInValue(procIndex1, "hosp_code", strHospCode,6);
			dao.setProcOutValue(procIndex1, "ERR", 1,7);
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,8);
			dao.executeProcedureByPosition(procIndex1);
			ws1 = dao.getWebRowSet(procIndex1, "RESULTSET");
			voHdrObj.setGblWs3(ws1);
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			if (!err.equals("")) 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voHdrObj.setStrMsgString("DAOAccountDtl.getAccountDtlWithAcctNo() --> "+ e.getMessage());
			voHdrObj.setStrMsgType("1");
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
}
