package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DML_ThirdPartyIssueSancDAO;
import mms.transactions.vo.ThirdPartyIssueSancTransVO;

public class ThirdPartyIssueSancTransDAO {
	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","ThirdPartyIssue");
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
	 * ITEM CATEGORY LIST
	 */
	public static void getItemDetails(ThirdPartyIssueSancTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Thirdpartyissue_Item_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","ThirdPartyIssueSancTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),4);
			daoObj.setProcInValue(nProcIndex, "req_no", voObj.getStrReqNo(),2);
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
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
					.setStrMsgString("ThirdPartyIssueSancTransDAO.getItemDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	/** This function is used to to populate the value of Unit combo using Pkg_Mms_View.proc_GBLT_UNIT_MST() procedure
	 * @param voObj
	 */
	/*public static void getIssueQtyUnitCmbDetails(ThirdPartyIssueSancTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("mms","SupplierReturnReqTransDAO");
			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrItemUnitId());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setUnitNameWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			voObj
					.setStrMsgString("ThirdPartyIssueSancTransDAO.getIssueQtyUnitCmbDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}*/
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	
	public synchronized static void insert(ThirdPartyIssueSancTransVO voObj) 
	{

		HisDAO daoObj = null;
	//	int i = 0;
	//	int lenItemsList = 0;
		String strReqNo = "";
		String strHosp_code = "";
	//	String strItemId = null;						
		String[] temp = null;
	//	String[] temp1 = null;
	//	String[] temp2 = null;
		
		DML_ThirdPartyIssueSancDAO thirdPartyIssueSancDAO = null;
	//	DML_ThirdPartyIssueItemSancDAO thirdPartyIssueSancItemDAO = null;
		
	//	WebRowSet ws = null;
	//	int nProcIndex = 0;
	//	String strErr = "";

		try {
			temp=voObj.getStrChk().replace('@', '#').split("#");
	//		lenItemsList = temp.length;		
			
			daoObj = new HisDAO("MMS Module", "Third Party Issued");
			thirdPartyIssueSancDAO = new DML_ThirdPartyIssueSancDAO();
		//	thirdPartyIssueSancItemDAO = new DML_ThirdPartyIssueItemSancDAO();
			strHosp_code=temp[0];
			strReqNo=temp[1];
			thirdPartyIssueSancDAO.setStrTReqNo(strReqNo);											//1
			thirdPartyIssueSancDAO.setStrHospitalCode(strHosp_code);					//2
			thirdPartyIssueSancDAO.setStrReqStatus("50");											//6
			thirdPartyIssueSancDAO.setStrIssueDate(now(DATE_FORMAT_NOW));
			thirdPartyIssueSancDAO.setStrStoreId(voObj.getStrStoreId());
			thirdPartyIssueSancDAO.setStrItemCatNo(voObj.getStrItemCatNo());
			thirdPartyIssueSancDAO.setStrReceiveBy(voObj.getStrReceiveBy());
			thirdPartyIssueSancDAO.setStrRemarks(voObj.getStrRemarks());
			thirdPartyIssueSancDAO.setStrSeatId(voObj.getStrSeatId());
			thirdPartyIssueSancDAO.setStrGnumIsValid("1");
							 
			thirdPartyIssueSancDAO.insert(daoObj);
			
			//System.out.println("Step 4");
		
			/*synchronized(daoObj)
			{
				daoObj.fire();
				//System.out.println("Step 5");
			}*/
		} catch (Exception e) {
			
			voObj.setStrMsgString("ThirdPartyIssueSancTransDAO.insert() -->"+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		//	thirdPartyIssueSancItemDAO = null;
			thirdPartyIssueSancDAO = null;
		}
	}
}
