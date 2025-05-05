package billing;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;

/**
 * 
 * @author Amit Kumar
 * 
 */
public class PrintDAO {
	/**
	 * APPROVEDBY(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */
	public static void ADVANCE_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.ADVANCE_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
 
		    dao.setProcInValue(procIndex1, "modeval", "1",1);		     
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		
			voObj.setStrMsgString("PrintDAO.ADVANCE_DUP() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	
	public static void ADVANCE(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.ADVANCE_DUP(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcInValue(procIndex1, "modeval", "23",1);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.ADVANCE() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void LFADVANCE(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.ADVANCE_DUP(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "42",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.ADVANCE() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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

	

	public static void ADVANCE_REFUND(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.ADVANCE(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			
			
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcInValue(procIndex1, "modeval", "22",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setStrAdvanceRefund(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.ADVANCE_REFUND() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	public static void PARTPAY_REFUND(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.ADVANCE(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			
			
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcInValue(procIndex1, "modeval", "22",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setStrAdvanceRefund(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.ADVANCE_REFUND() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}


	/**
	 * PART_PAYMENT(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */
	public static void PART_PAYMENT(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "24",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.PART_PAYMENT() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	public static void LF_PART_PAYMENT(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.PART_PAYMENT(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "43",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);			
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.PART_PAYMENT() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	
	
	/**
	 * PART_PAYMENT_DUP(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */
	public static void PART_PAYMENT_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
	 
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "modeval", "2",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.PART_PAYMENT_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	
	
	/**
	 * DUP_CONSOLIDATED_PRINT(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */
	public static void DUP_CONSOLIDATED_PRINT(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "modeval", "33",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.DUP_CONSOLIDATED_PRINT() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	
	
	
	/**
	 * DUP_REPLICA_PRINT(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */
	public static void DUP_REPLICA_PRINT(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
						
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "modeval", "32",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
					

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.DUP_REPLICA_PRINT() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	
	
	/**
	 * OPD_SERVICES(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void OPD_SERVICES(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		System.out.println("--------------PKG_BILL_VIEW.proc_bill_print_dtl------[ Mode - 54 ]-----------");
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "54",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

	public static void OPD_SERVICES1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			System.out.println("--------------PKG_BILL_VIEW.proc_bill_print_dtl------[ Mode - 26 ]-----------");
			
			dao.setProcInValue(procIndex1, "modeval", "26",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES1() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

	public static void OPD_ESTIMATION(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.OPD_ESTIMATION(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "48",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_ESTIMATION() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

	public static void OPD_ESTIMATION1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.OPD_ESTIMATION1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "49",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_ESTIMATION1() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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


	//get estimation certificate details..
	public static void OPD_SERVICES2(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "41",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs3(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES1() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	public static void OPD_SERVICES_OLD_DTLS(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "34",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs2(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES_OLD_DTLS() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	
	
	/**
	 * OPD_SERVICES(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void OPD_SERVICES_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			
			dao.setProcInValue(procIndex1, "modeval", "3",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	public static void OPD_SERVICES_DUP1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES_DUP1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "modeval", "4",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs2(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES_DUP1() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	
	/**
	 * IPD_SERVICES(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void IPD_SERVICES(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "27",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void IPD_SERVICES1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcInValue(procIndex1, "modeval", "28",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs2(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES1() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	
	public static void IPD_ESTIMATION(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "48",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void IPD_ESTIMATION1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcInValue(procIndex1, "modeval", "49",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs2(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES1() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	/**
	 * IPD_SERVICES_DUP(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void IPD_SERVICES_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "modeval", "5",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	public static void IPD_SERVICES_DUP1(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES_DUP1(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "modeval", "6",1);
			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs2(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES_DUP1() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * IPD_REFUND(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void IPD_REFUND(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "14",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdRefund(ws);

			} else {
				throw new Exception(err);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_REFUND() --> "
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

	public static void IPD_REFUND1(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "accNo", voHdrObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "modeval", "15",1);
			
			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdRefund1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_REFUND1() --> "
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

	/**
	 * IPD_REFUND(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void IPD_FINAL_SETTLE(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "20",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdFinalSettle(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_FINAL_SETTLE() --> "
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

	public static void IPD_FINAL_SETTLE1(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "accNo", voHdrObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "modeval", "21",1);
			
			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdFinalSettle1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_FINAL_SETTLE1() --> "
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

	/**
	 * IPD_RECONCILIATION(vo) -- > This Method is Used to get WebRowSet for
	 * Approved By Combo
	 * 
	 */

	public static void IPD_RECONCILIATION(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "18",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdReconcil(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_RECONCILIATION() --> "
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

	public static void IPD_RECONCILIATION1(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "accNo", voHdrObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "modeval", "19",1);

			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrIpdReconcil1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.IPD_RECONCILIATION1() --> "
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

	/**
	 * OPD_REFUND(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void OPD_REFUND(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "12",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrOpdRefund(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.OPD_REFUND() --> "
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

	public static void OPD_REFUND1(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "13",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrOpdRefund1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.OPD_REFUND1() --> "
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

	/**
	 * OPD_REFUND(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void OPD_RECONCILIATION(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "16",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrOpdReconcil(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.OPD_REFUND() --> "
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

	public static void OPD_RECONCILIATION1(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "recNo", voHdrObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "billNo", voHdrObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "modeval", "17",1);

			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setStrOpdReconcil1(ws);

			} else {
				throw new Exception(err);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.OPD_REFUND() --> "
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

	/**
	 * ADDMISSION_CANCELLATION(vo) -- > This Method is Used to get WebRowSet for
	 * Approved By Combo
	 * 
	 */
	public static void ADDMISSION_CANCELLATION(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String strGrpId = null;
		String strAcctNo = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing","billing.PrintDAO.ADDMISSION_CANCELLATION(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1,"billno","",1); 
			dao.setProcInValue(procIndex1, "accNo", strAcctNo,2);
			 dao.setProcInValue(procIndex1,"to_be_refund_pkg","",3); 
			dao.setProcInValue(procIndex1, "groupId", strGrpId,4);
			dao.setProcInValue(procIndex1, "modeval", "3",5);
			dao.setProcInValue(procIndex1,"hosp_code","",6);  
		    dao.setProcInValue(procIndex1,"recno","",7);
			dao.setProcInValue(procIndex1,"rectype","",8);
			dao.setProcOutValue(procIndex1, "err", 1,9); // 1 for string return													// value
			dao.setProcOutValue(procIndex1, "resultset", 2,10); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setGblWs1(ws);

			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.ADDMISSION_CANCELLATION() --> "
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

	/**
	 * RECONCELATION(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void RECONCELATION(PrintVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String strGrpId = null;
		String strAcctNo = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.RECONCELATION(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", strAcctNo);

			dao.setProcInValue(procIndex1, "groupId", strGrpId);

			dao.setProcInValue(procIndex1, "modeval", "3");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voHdrObj.setGblWs1(ws);

			}

		} catch (Exception e) {
			// e.printStackTrace();
			voHdrObj.setStrMsgString("PrintDAO.RECONCELATION() --> "
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

	/**
	 * FINAL_ADJUSTMENT_DUP(vo) -- > This Method is Used to get
	 * WebRowSet for Approved By Combo
	 * 
	 */
	public static void FINAL_ADJUSTMENT_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINAL_ADJUSTMENT_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			// dao.setProcInValue(procIndex1,"accNo",voObj.getStrAcctNo());
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "modeval", "7",1);
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs1(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINAL_ADJUSTMENT_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * FINAL_ADJUSTMENT(vo) -- > 
	 * 
	 */
	public static void FINAL_ADJUSTMENT(PrintVO voObj)//Bill & Demographic Details 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing","billing.PrintDAO.FINAL_ADJUSTMENT(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "38",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1,"recNo",voObj.getStrReceiptNo(),7);
			
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			}

		} 
		catch (Exception e) 
		{	
			voObj.setStrMsgString("PrintDAO.FINAL_ADJUSTMENT() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	
	public static void TRANSPOTATION_CHARGES(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINAL_ADJUSTMENT(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1,"recNo",voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "55",1);
			
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setTranspotationchrgs(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINAL_ADJUSTMENT() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	/**
	 * FINALADJUSTMENT_CONSOLEDATED_DUP(vo) -- > This Method is Used to get
	 * WebRowSet for Approved By Combo
	 * 
	 */
	public static void FINALADJUSTMENT_CONSOLEDATED_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINALADJUSTMENT_CONSOLEDATED_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value


			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "billNo", "",2);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcInValue(procIndex1, "modeval", "8",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs1(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_CONSOLEDATED_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * FINALADJUSTMENT_CONSOLEDATED(vo) -- > 
	 * 
	 */
	public static void FINALADJUSTMENT_CONSOLEDATED(PrintVO voObj)  //GROUP DATA-MODE 30
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.FINALADJUSTMENT_CONSOLEDATED(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "modeval", "30",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object
			
			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			{
				
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			}
		} 
		catch (Exception e) 
		{	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_CONSOLEDATED() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	
	public static void TRANSPOTATION_CHARGE_CONSOLEDATED(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINALADJUSTMENT_CONSOLEDATED(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value


			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "billNo", "",2);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcInValue(procIndex1, "modeval", "56",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setTrasnpotationcolsolidatedws(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_CONSOLEDATED() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	/**
	 * APPROVEDBY(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void FINALADJUSTMENT_DETAIL_DUP(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINALADJUSTMENT_DETAIL_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			// dao.setProcInValue(procIndex1,"billNo",voObj.getStrBillNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);

			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "billNo", "",2);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			
			dao.setProcInValue(procIndex1, "modeval", "9",1);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setGblWs1(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_DETAIL_DUP() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * APPROVEDBY(vo) -- > This Method is Used to get WebRowSet for Approved By
	 * Combo
	 * 
	 */

	public static void FINALADJUSTMENT_DETAIL(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.FINALADJUSTMENT_DETAIL_DUP(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "modeval", "35",1);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_DETAIL() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	/**
	 * APPROVEDBY(vo) -- > This Method is Used to get WebRowSet for Advance recieved
	 * Combo
	 * 
	 */

	public static void FINALADJUSTMENT_DEPOSITDATA(PrintVO voObj) //DEPOSIT DATA
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		String strFlag="0";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.FINALADJUSTMENT_DETAIL_DUP(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "accno", voObj.getStrAcctNo(),3);
			//strFlag=getBillReopenFlag(voObj);
			//if(strFlag.equals("1"))     // for Re-opened bill
				//dao.setProcInValue(procIndex1, "modeval", "40",1);
			//else
			dao.setProcInValue(procIndex1, "modeval", "37",1);			
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "billNo",voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9);
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)				
				err = "";
			{				
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_DETAIL1() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	/*
	 * Checks the Re-open flag corresponding to a patinet account no.
	 * 
	 */
	public static String getBillReopenFlag(PrintVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_get_bill_reopen_flag(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		String strFlag="";
		try {

			daoObj = new HisDAO("Print Transaction",
					"PrintVO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "patAccNo", vo.getStrAcctNo(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospCode(),2);
		
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,4);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				while (ws.next()) {
				strFlag=ws.getString(1);
				}
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo
					.setStrMsgString("PrintDAO.getBillReopenFlag() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
     return strFlag ;
	}
	/**
	 * method used to update the print status
	 * 
	 * @param voObj
	 */
	public static void UPDATE_PRINT_STATUS(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
	
		String proc_name1 = "{call PKG_BILL_DML.dml_Hblt_Bill_Reciept_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing","billing.PrintDAO.IPD_SERVICES1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
		dao.setProcInValue(procIndex1, "modval", "2",1);
		dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),41);
		dao.setProcInValue(procIndex1, "hblnum_bill_no", voObj.getStrBillNo(),2);
		dao.setProcInValue(procIndex1, "hblnum_reciept_no", voObj.getStrReceiptNo(),3);
		dao.setProcInValue(procIndex1, "printFlag", voObj.getStrPrintFlag(),42);
		dao.setProcInValue(procIndex1, "hbldt_reciept_date","",4);
		dao.setProcInValue(procIndex1, "hblnum_reciept_type","",5);
		dao.setProcInValue(procIndex1, "hblnum_req_no", "",6);
		dao.setProcInValue(procIndex1, "hbldt_req_date","",7);
		dao.setProcInValue(procIndex1, "hrgnum_puk", "",8);
		dao.setProcInValue(procIndex1, "hastr_adm_no", "",9);
		dao.setProcInValue(procIndex1, "hblnum_pataccount_no","",10);
		dao.setProcInValue(procIndex1, "hblstr_patient_name","",11);
		dao.setProcInValue(procIndex1, "hblnum_client_patient_no","",12);
		dao.setProcInValue(procIndex1, "sblnum_chargetype_id","",13);
		dao.setProcInValue(procIndex1, "sblnum_bservice_id","",14);
		dao.setProcInValue(procIndex1, "sblnum_service_id","",15);
		dao.setProcInValue(procIndex1, "gnum_dept_code", "",16);
		dao.setProcInValue(procIndex1, "gnum_patient_cat_code","",17);
		dao.setProcInValue(procIndex1, "hblnum_client_balance","",18);
		dao.setProcInValue(procIndex1, "hblnum_patient_tot_amt","",19);
		dao.setProcInValue(procIndex1, "hblnum_client_tot_amt","",20);
		dao.setProcInValue(procIndex1, "hblnum_actual_tot_amt","",21);
		dao.setProcInValue(procIndex1, "hblnum_tariff_tot_amt","",22);
		dao.setProcInValue(procIndex1, "hblnum_discount_tot_amt","",23);
		dao.setProcInValue(procIndex1, "hblnum_sertax_tot_amt","",24);
		dao.setProcInValue(procIndex1, "hblnum_penelty_amt","",25);
		dao.setProcInValue(procIndex1, "gstr_req_no", "",26);
		dao.setProcInValue(procIndex1, "hblnum_cancel_no", "",27);
		dao.setProcInValue(procIndex1, "hblnum_counter_id","",28);
		dao.setProcInValue(procIndex1, "hblnum_approval_id","",29);
		dao.setProcInValue(procIndex1, "hblstr_approved_by","",30);
		dao.setProcInValue(procIndex1, "hbldt_approved_date","",31);
		dao.setProcInValue(procIndex1, "gstr_remarks", "",32);
		dao.setProcInValue(procIndex1, "hblnum_status", "",33);
		dao.setProcInValue(procIndex1, "gdt_entry_date", "",34);
		dao.setProcInValue(procIndex1, "gnum_seatid", "",35);
		dao.setProcInValue(procIndex1, "gnum_isvalid", "",36);
		dao.setProcInValue(procIndex1, "hipnum_ward_code", "",37);
		dao.setProcInValue(procIndex1, "sblnum_ipd_chargetype_id","",38);
		dao.setProcInValue(procIndex1, "hblnum_is_online", "",39);
		dao.setProcInValue(procIndex1, "hblnum_is_bill", "",40);
		dao.setProcOutValue(procIndex1, "err", 1,43); // 1 for string return
														// value

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (!err.equals("")) {

				throw new Exception(err);

			}

		} catch (Exception e) {
			
			voObj.setStrMsgString("PrintDAO.UPDATE_PRINT_STATUS() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	
	

	/**
	 * IPD_SERVICES(vo) -- > This Method is Used to get WebRowSet for Approved
	 * By Combo
	 * 
	 */

	public static void getCounterAndUserName(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_GET_COUNTER_USER(?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.getCounterAndUserName(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modVal", "1",1);
			dao.setProcInValue(procIndex1, "ipAddress", voObj.getStrIpAddress(),3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),2);
			dao.setProcInValue(procIndex1, "seatid", voObj.getStrSeatId(),4);
			dao.setProcOutValue(procIndex1, "err", 1,5);
			dao.setProcOutValue(procIndex1, "resultset", 2,6);
			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setStrCounterAndUserName(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.getCounterAndUserName() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	
	
	public static void DAYEND_DTLS(PrintVO vo) 
	{
		String proc_name1 = "";
		HisDAO dao = null;
		proc_name1 = "{call pkg_bill_view.proc_HBLT_DAYEND_DTL(?,?,?,?,?)}";

		int procIndex1 = 0;

		String strErr = "";
		WebRowSet ws = null;

		try {
			dao = new HisDAO("Billing", "Print");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospCode(),1);
			dao.setProcInValue(procIndex1, "summ_no", vo.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "modeval", "1",3);
			dao.setProcOutValue(procIndex1, "ERR", 1,4); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,5); // 2 for object

			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			strErr = dao.getString(procIndex1, "ERR");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			if (strErr.equals("")) 
			{
				vo.setGblWs1(ws);
			}
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch (Exception e) 
		{
		    vo.setStrMsgString("PrintDAO.DAYEND_DTLS()-->"+ e.getMessage());
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

	public static void DAYEND_PAYMENT_DTLS(PrintVO vo) 
	{
		String proc_name2 = "";
		HisDAO dao = null;
		proc_name2 = "{call pkg_bill_view.proc_HBLT_DAYEND_PAYMENT_DTL(?,?,?,?,?)}";
		int procIndex2 = 0;
		String strErr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("Billing", "Print");
			procIndex2 = dao.setProcedure(proc_name2);

			// set value
			dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospCode(),1);
			
			dao.setProcInValue(procIndex2, "summ_no", vo.getStrBillNo(),2);
			
			dao.setProcInValue(procIndex2, "modeval", "1",3);

			dao.setProcOutValue(procIndex2, "ERR", 1,4); // 1 for string return
		
			dao.setProcOutValue(procIndex2, "RESULTSET", 2,5); // 2 for object

			// execute procedure
			dao.executeProcedureByPosition(procIndex2);

			// get value
			strErr = dao.getString(procIndex2, "ERR");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(procIndex2, "RESULTSET");
			if (strErr.equals("")) 
			{
				vo.setGblWs2(ws);
			}
			else
			{
				throw new Exception(strErr);
			}
		}
		catch (Exception e) 
		{
			// Set Error Msg
			vo.setStrMsgString("PrintDAO.DAYEND_PAYMENT_DTLS()-->"+ e.getMessage());
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
	
	public static void IPD_PACKAGES(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_PACKAGES(PrintVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);

			dao.setProcInValue(procIndex1, "modeval", "44",1);
			
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
						

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs3(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		
			voObj.setStrMsgString("PrintDAO.IPD_PACKAGES() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void OPD_SERVICES_REG(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "45",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES_REG() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

	public static void OPD_SERVICES1_REG(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "46",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES1_REG() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	
	public static void WALLETADVANCE(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.ADVANCE_DUP(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcInValue(procIndex1, "modeval", "47",1);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.ADVANCE() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void FINALADJUSTMENT_CONSOLEDATED_COPY(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try 
		{
			
			dao = new HisDAO("billing","billing.PrintDAO.FINALADJUSTMENT_CONSOLEDATED(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);			
			dao.setProcInValue(procIndex1, "modeval", "30",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);	
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs3(ws);
			}
		} 
		catch (Exception e) 
		{	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_CONSOLEDATED_COPY() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void NO_DUES(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.NO_DUES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcInValue(procIndex1, "modeval", "50",1);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.NO_DUES() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void OP_REF_REQ(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.NO_DUES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "modeval", "51",1);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OP_REF_REQ() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void OP_REF_REQ1(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.NO_DUES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", "",7);
			dao.setProcInValue(procIndex1, "modeval", "52",1);
			dao.setProcOutValue(procIndex1, "err", 1,8);
			dao.setProcOutValue(procIndex1, "resultset", 2,9);

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";
			
			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);

			} 
			else 
			{
				throw new Exception(err);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OP_REF_REQ1() --> " + e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void CREDIT_NOTE(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.CREDIT_NOTE(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "53",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.CREDIT_NOTE() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void IPD_CREDIT_NOTE(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.CREDIT_NOTE(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "57",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.CREDIT_NOTE() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void OPD_SERVICES_REGSERV(PrintVO voObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "58",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES_REGSERV() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

	public static void OPD_SERVICES1_REGSERV(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.OPD_SERVICES1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "59",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", "",3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES1_REGSERV() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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
	public static void IPD_SERVICES1_REGSERV(PrintVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		
		try 
		{

			dao = new HisDAO("billing","billing.PrintDAO.IPD_SERVICES1(PrintVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "60",1);
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo(),2);
			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo(),3);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode(),4);			
			dao.setProcInValue(procIndex1, "dept_code", "",5);
			dao.setProcInValue(procIndex1, "ward_code", "",6);
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); 
			dao.setProcOutValue(procIndex1, "resultset", 2,9); 

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PrintDAO.IPD_SERVICES1_REGSERV() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
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

