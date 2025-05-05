package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DML_ReturnToSupplierDAO;

import mms.transactions.vo.SupplierReturnSancTransVO;

public class SupplierReturnSancTransDAO {
	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","SupplierReturn");
	      try{
	       a= util.getASDate(frmt);
	      }
	      catch(Exception e){
	    	
	      }
	      /*Calendar cal = Calendar.getInstance();
	      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	      return sdf.format(cal.getTime());*/
	      return a;
	    }
	  
	  /**
		 * This method is used to call the procedure and set the values
		 * corresponding to it for populating the 
		 * GROUP LIST
		 */
		public static void getPODetails(SupplierReturnSancTransVO voObj) {

				HisDAO daoObj = null;
				WebRowSet ws = null;

				String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
				int nProcIndex = 0;
			
				String strErr = "";

				try {
					daoObj = new HisDAO("MMS Transactions","SupplierReturnSancTransDAO");

					nProcIndex = daoObj.setProcedure(strProcName);

					daoObj.setProcInValue(nProcIndex, "modval", "3");
					daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCategoryNoH());
					daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
					daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrPOStoreId());
					daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
					daoObj.setProcInValue(nProcIndex, "po_frmdate", "0");
					daoObj.setProcInValue(nProcIndex, "po_todate", "0");
					
					daoObj.setProcInValue(nProcIndex, "schedule_no", "0"); // Default Value. 
					
					daoObj.setProcOutValue(nProcIndex, "err", 1);
					daoObj.setProcOutValue(nProcIndex, "resultset", 2);

					daoObj.executeProcedure(nProcIndex);
					strErr = daoObj.getString(nProcIndex, "err");

					if (strErr == null)
						strErr = "";

					if (strErr.equals("")) {

						ws = daoObj.getWebRowSet(nProcIndex, "resultset");
						voObj.setStrPODetailsWs(ws);
					} else {
						throw new Exception(strErr);
					}

				} catch (Exception e) {
					voObj
							.setStrMsgString("SupplierReturnSancTransDAO.getPODetails() --> "
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
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * ITEM CATEGORY LIST
	 */
	public static void getItemDetails(SupplierReturnSancTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Returntosupplier_Item_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","SupplierReturnSancTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "req_no", voObj.getStrReqNo());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				voObj.setStrItemDetailsWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("SupplierReturnSancTransDAO.getItemDetails() --> "
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
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	
	public static void update_Return_Details(SupplierReturnSancTransVO voObj) {

		HisDAO daoObj = null;
		
		
		DML_ReturnToSupplierDAO returnToSupplierDAO = null;
		

		try {
			
			daoObj = new HisDAO("MMS Module", "Return To Supplier");
			returnToSupplierDAO = new DML_ReturnToSupplierDAO();
			////System.out.println("StrReturnNo->"+voObj.getStrReqNo());
			////System.out.println("StrHospitalCode->"+voObj.getStrHospitalCode());
			////System.out.println("StrStoreId->"+voObj.getStrStoreId());
			////System.out.println("StrItemCatNo->"+voObj.getStrItemCategoryNoH());
			////System.out.println("StrRemarks->"+voObj.getStrRemarks());
			returnToSupplierDAO.setStrReturnNo(voObj.getStrReqNo());										//1
			returnToSupplierDAO.setStrHospitalCode(voObj.getStrHospitalCode());					//2
			returnToSupplierDAO.setStrReturnStatus("50");											//6
			returnToSupplierDAO.setStrStoreId(voObj.getStrStoreId());
			returnToSupplierDAO.setStrItemCatNo(voObj.getStrItemCategoryNoH());
			returnToSupplierDAO.setStrGnumIsValid("1");
			returnToSupplierDAO.setStrRemarks(voObj.getStrRemarks());	
			returnToSupplierDAO.setStrReturnFlag(voObj.getStrReturnFlag());
			returnToSupplierDAO.update_Return_Details(daoObj);
			
			
			synchronized(daoObj)
			{
				daoObj.fire();
			}
		} catch (Exception e) {
			
			voObj.setStrMsgString("ReturnToSupplierSancTransDAO.update_Return_Details() -->"+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
			returnToSupplierDAO = null;
		}
	}
}
