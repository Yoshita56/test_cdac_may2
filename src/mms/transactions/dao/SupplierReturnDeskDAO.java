/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;



import mms.transactions.vo.SupplierReturnDeskVO;


/**
 * @author pankaj
 * 
 */
public class SupplierReturnDeskDAO {
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
		public static void getPODetails(SupplierReturnDeskVO voObj) {

				HisDAO daoObj = null;
				WebRowSet ws = null;

				String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
				int nProcIndex = 0;
			
				String strErr = "";

				try {
					daoObj = new HisDAO("MMS Transactions","SupplierReturnDeskDAO");

					nProcIndex = daoObj.setProcedure(strProcName);
					
					daoObj.setProcInValue(nProcIndex, "modval", "3");
					daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCategoryNoH());
					daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
					daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrPOStoreId());
					daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
					daoObj.setProcInValue(nProcIndex, "po_frmdate", "0");
					daoObj.setProcInValue(nProcIndex, "po_todate", "0");
					daoObj.setProcInValue(nProcIndex, "schedule_no", "0");
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
							.setStrMsgString("SupplierReturnDeskDAO.getPODetails() --> "
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
	public static void getItemDetails(SupplierReturnDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Returntosupplier_Item_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","SupplierReturnDeskDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
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
					.setStrMsgString("SupplierReturnDeskDAO.getItemDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
}
