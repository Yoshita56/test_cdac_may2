package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

/**
 * 
 * @author Amit Kumar
 * 
 */
public class PrintBillDAO {
	public static void ADVANCE(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?)}";

		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.ADVANCE(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "modeval", "1");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
		 
			voObj.setStrMsgString("PrintDAO.ADVANCE() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	

	public static void ADVANCE_REFUND(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";

		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.ADVANCE(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", "");
			
			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "modeval", "11");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	public static void PART_PAYMENT(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", "");
			
			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());
			
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "modeval", "2");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	
	
	
	/**
	 * OPD_SERVICES(vo) -- > OPD Services Consolidated Bill Details 
	 * By Combo
	 * 
	 */

	public static void OPD_SERVICES(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", "");
			
			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

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

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				voObj.setGblWs1(ws);

			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
		 
			voObj.setStrMsgString("PrintDAO.OPD_SERVICES() --> "
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
	public static void DUP_CONSOLIDATED_PRINT(PrintBillVO voObj) {
	
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {
	
			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT_DUP(PrintBillVO voHdrObj)");
	
			procIndex1 = dao.setProcedure(proc_name1);
	
			// set value
	
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo());
			
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());
	
			dao.setProcInValue(procIndex1, "modeval", "33");
			
			dao.setProcInValue(procIndex1, "recNo", "");
			dao.setProcInValue(procIndex1, "accNo", "");
			dao.setProcInValue(procIndex1, "dept_code", "");
			dao.setProcInValue(procIndex1, "ward_code", "");
	
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value
	
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
	
			// execute procedure
	
			dao.executeProcedure(procIndex1);
	
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
	public static void DUP_REPLICA_PRINT(PrintBillVO voObj) {
	
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_bill_print_dtl(?,?,?,?,?,?,?,?,?)}";
		try {
	
			dao = new HisDAO("billing",
					"billing.PrintDAO.PART_PAYMENT_DUP(PrintBillVO voHdrObj)");
	
			procIndex1 = dao.setProcedure(proc_name1);
	
			// set value
	
			dao.setProcInValue(procIndex1, "billNo", voObj.getStrBillNo());
			
			dao.setProcInValue(procIndex1, "recNo", voObj.getStrReceiptNo());
						
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());
	
			dao.setProcInValue(procIndex1, "modeval", "32");
	
			
			dao.setProcInValue(procIndex1, "accNo", "");
			dao.setProcInValue(procIndex1, "dept_code", "");
			dao.setProcInValue(procIndex1, "ward_code", "");
			
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value
	
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
	
			// execute procedure
	
			dao.executeProcedure(procIndex1);
	
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
	 * OPD Services Detailed Bill Details
	 * 
	 * @param voObj
	 */
	public static void OPD_SERVICES1(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_SERVICES1(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "accNo", "");
			
			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());
			
			dao.setProcInValue(procIndex1, "modeval", "4");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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

	
	
	/**
	 * IPD_SERVICES(vo) -- > IPD Services Consolidated Bill Details
	 * By Combo
	 * 
	 */

	public static void IPD_SERVICES(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			
			dao.setProcInValue(procIndex1, "accNo", "");

			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "modeval", "5");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	
	/**
	 * IPD Services Detailed Bill Details
	 * @param voObj
	 */
	public static void IPD_SERVICES1(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES1(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			
			dao.setProcInValue(procIndex1, "accNo", "");

			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());
			
			dao.setProcInValue(procIndex1, "modeval", "6");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * IPD_REFUND(vo) -- > IPD Consolidated Refund Bill Details
	 * 
	 */

	public static void IPD_REFUND(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			
			dao.setProcInValue(procIndex1, "accNo", "");
			
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "9");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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

	/**
	 * IPD Detailed Refund Bill Details
	 * @param voHdrObj
	 */
	public static void IPD_REFUND1(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "10");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * IPD_REFUND(vo) -- > Final Settlement Reconciliation Consolidated Bill Details 
	 * 
	 */

	public static void IPD_FINAL_SETTLE(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "accNo", "");

			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "16");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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

	/**
	 * IPD Final Settlement Reconciliation Detailed Bill Details
	 * @param voHdrObj
	 */
	public static void IPD_FINAL_SETTLE1(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			
			dao.setProcInValue(procIndex1, "accNo", "");
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "accNo", voHdrObj.getStrAcctNo());

			dao.setProcInValue(procIndex1, "modeval", "17");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * IPD_RECONCILIATION(vo) -- > IPD Reconciliation Consolidated Bill Details
	 * 
	 */

	public static void IPD_RECONCILIATION(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "14");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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

	/**
	 * IPD Reconciliation Detailed Bill Details
	 * @param voHdrObj
	 */
	public static void IPD_RECONCILIATION1(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "15");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * OPD_REFUND(vo) -- > OPD Refund Consolidated Bill Details
	 * 
	 */

	public static void OPD_REFUND(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "7");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * OPD Refund Detailed Bill Details
	 * @param voHdrObj
	 */
	public static void OPD_REFUND1(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "8");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * OPD Reconciliation Consolidated Bill Details
	 * @param voHdrObj
	 */
	public static void OPD_RECONCILIATION(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "12");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * OPD Reconciliation Detailed Bill Details
	 * @param voHdrObj
	 */
	public static void OPD_RECONCILIATION1(PrintBillVO voHdrObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.OPD_REFUND(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			// set value
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj
					.getStrHospCode());

			dao.setProcInValue(procIndex1, "reqNo", voHdrObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "modeval", "13");

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

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
	 * FINAL_ADJUSTMENT(vo) -- > Final Adjustement Bill Details
	 * 
	 */
	public static void FINAL_ADJUSTMENT(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINAL_ADJUSTMENT(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "accNo", "");
			
			// set value
			dao.setProcInValue(procIndex1, "reqNo", voObj.getStrRequestNo());

			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "modeval", "18");

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

				voObj.setGblWs1(ws);

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
	 * FINALADJUSTMENT_CONSOLEDATED(vo) -- > Final Adjustment Consolidated Bill Details
	 * 
	 */
	public static void FINALADJUSTMENT_CONSOLEDATED(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
			proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINALADJUSTMENT_CONSOLEDATED(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "reqNo", "");
			
			// set value
					dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo());

			dao.setProcInValue(procIndex1, "modeval", "19");

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

				voObj.setGblWs1(ws);

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
	 * Final Adjustment Detailed Bill Details
	 * @param voObj
	 */
	public static void FINALADJUSTMENT_DETAIL(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.proc_req_print_dtl(?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.FINALADJUSTMENT_DETAIL(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			
			dao.setProcInValue(procIndex1, "reqNo", "");
			
			// set value
		
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());

			dao.setProcInValue(procIndex1, "accNo", voObj.getStrAcctNo());

			dao.setProcInValue(procIndex1, "modeval", "20");

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

				voObj.setGblWs1(ws);

			}

		} catch (Exception e) {
	
			voObj.setStrMsgString("PrintDAO.FINALADJUSTMENT_DETAIL() --> "
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
	 * method used to update the print status
	 * 
	 * @param voObj
	 */
	public static void UPDATE_PRINT_STATUS(PrintBillVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
	
		String proc_name1 = "{call PKG_BILL_DML.dml_Hblt_Bill_Reciept_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {

			dao = new HisDAO("billing",
					"billing.PrintDAO.IPD_SERVICES1(PrintBillVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modval", "2");
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospCode());
			dao.setProcInValue(procIndex1, "hblnum_bill_no", voObj
					.getStrBillNo());
			dao.setProcInValue(procIndex1, "hblnum_reciept_no", voObj
					.getStrReceiptNo());
			dao.setProcInValue(procIndex1, "printFlag", voObj.getStrPrintFlag());
			 
			dao.setProcInValue(procIndex1, "hbldt_reciept_date",
					"");
			dao.setProcInValue(procIndex1, "hblnum_reciept_type",
					"");
			dao.setProcInValue(procIndex1, "hblnum_req_no", "");
			dao
					.setProcInValue(procIndex1, "hbldt_req_date",
							"");
			dao.setProcInValue(procIndex1, "hrgnum_puk", "");
			dao.setProcInValue(procIndex1, "hastr_adm_no", "");
			dao.setProcInValue(procIndex1, "hblnum_pataccount_no",
					"");
			dao.setProcInValue(procIndex1, "hblstr_patient_name",
					"");
			dao.setProcInValue(procIndex1, "hblnum_client_patient_no",
					"");
			dao.setProcInValue(procIndex1, "sblnum_chargetype_id",
					"");
			dao.setProcInValue(procIndex1, "sblnum_bservice_id",
					"");
			dao.setProcInValue(procIndex1, "sblnum_service_id",
					"");
			dao.setProcInValue(procIndex1, "gnum_dept_code", "");
			dao.setProcInValue(procIndex1, "gnum_patient_cat_code",
					"");
			dao.setProcInValue(procIndex1, "hblnum_client_balance",
					"");
			dao.setProcInValue(procIndex1, "hblnum_patient_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_client_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_actual_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_tariff_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_discount_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_sertax_tot_amt",
					"");
			dao.setProcInValue(procIndex1, "hblnum_penelty_amt",
					"");
			dao.setProcInValue(procIndex1, "gstr_req_no", "");
			dao.setProcInValue(procIndex1, "hblnum_cancel_no", "");
			dao
					.setProcInValue(procIndex1, "hblnum_counter_id",
							"");
			dao.setProcInValue(procIndex1, "hblnum_approval_id",
					"");
			dao.setProcInValue(procIndex1, "hblstr_approved_by",
					"");
			dao.setProcInValue(procIndex1, "hbldt_approved_date",
					"");
			dao.setProcInValue(procIndex1, "gstr_remarks", "");
			dao.setProcInValue(procIndex1, "hblnum_status", "");
			dao.setProcInValue(procIndex1, "gdt_entry_date", "");
			dao.setProcInValue(procIndex1, "gnum_seatid", "");
			dao.setProcInValue(procIndex1, "gnum_isvalid", "");
			dao.setProcInValue(procIndex1, "hipnum_ward_code", "");
			dao.setProcInValue(procIndex1, "sblnum_ipd_chargetype_id",
					"");
			dao.setProcInValue(procIndex1, "hblnum_is_online", "");
			dao.setProcInValue(procIndex1, "hblnum_is_bill", "");
			 
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
														// value

			// execute procedure

			dao.executeProcedure(procIndex1);

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

}
