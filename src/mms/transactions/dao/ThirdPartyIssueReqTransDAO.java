package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DML_ThirdPartyIssueItemReqDAO;
import mms.dao.DML_ThirdPartyIssueReqDAO;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;
import mms.transactions.controller.data.ThirdPartyIssueReqTransDATA;

public class ThirdPartyIssueReqTransDAO {
	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * ITEM CATEGORY LIST
	 */
	public static void getItemCategoryCmb(ThirdPartyIssueReqTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", "65",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setStrItemCatWs(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("ThirdPartyIssueReqTransDAO.getItemCategoryCmb() --> "
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
	 * THIRD PARTY LIST
	 */
	public static void getThirdPartyCmb(ThirdPartyIssueReqTransVO vo) {
		
		HisDAO daoObj = null;
		String strErr = "";
		
		int nProcIndex = 0;
		WebRowSet wb = null;
		try {
			String strProcName = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}";
			daoObj = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrInstituteWs(wb);
			} else {
				throw new Exception(strErr);
			}

		}  catch (Exception e) {
				vo
						.setStrMsgString("ThirdPartyIssueReqTransDAO.getThirdPartyCmb() --> "
							+ e.getMessage());
				vo.setStrMsgType("1");

		}finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getGroupCmb(ThirdPartyIssueReqTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
				daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatNo(),3);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
				daoObj.setProcInValue(nProcIndex, "strStoreId", "",5);
				/* Setting Default Value End */
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrGroupWs(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				voObj
						.setStrMsgString("ThirdPartyIssueReqTransDAO.getGroupCmb() --> "
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
	public static void CANCEL_REQUEST(ThirdPartyIssueReqTransVO voObj) 
	{
		String strProcName = "{call Pkg_Mms_Dml.Dml_Third_Party_Issue(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?,?)}";
	    int nProcIndex = 0;
	    HisDAO daoObj = null;
			
		try {
			
			//check mandatory information
			
			if(voObj.getStrReqNo().equals("0") || voObj.getStrReqNo().equals("")) {
				throw new Exception("ReqNo can not be blank");
			}
			if(voObj.getStrHospitalCode().equals("0") || voObj.getStrHospitalCode().equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			////System.out.println("t1---reqno------------->"+voObj.getStrReqNo());
			////System.out.println("t1---hospcode---------->"+voObj.getStrHospitalCode());
			////System.out.println("t1---itemcat----------->"+voObj.getStrItemCatNo());
			////System.out.println("t1---storeid----------->"+voObj.getStrStoreId());
			////System.out.println("t1---remarks----------->"+voObj.getStrRemarks());
			////System.out.println("t1---seatid------------>"+voObj.getStrSeatId());
		
			daoObj = new HisDAO("Third Party Issue","ThirdPartyIssueReqTransDAO");
		    nProcIndex = daoObj.setProcedure(strProcName);
			
		    daoObj.setProcInValue(nProcIndex, "modval", "3",1);
		    daoObj.setProcInValue(nProcIndex, "req_no", voObj.getStrReqNo(),2);
		    daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
		    daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatNo(),5);
		    daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),7);
		    daoObj.setProcInValue(nProcIndex, "remarks", voObj.getStrRemarks(),14);
		    daoObj.setProcInValue(nProcIndex, "seat_id", voObj.getStrSeatId(),16);
		    daoObj.setProcInValue(nProcIndex, "isvalid", "1",17);
		    
		    /* Setting Default Value Start*/
		    HisUtil hisutil = new HisUtil("MMS", "PODeskCancelTransDAO");				
		    String  strCurrentDate	= hisutil.getASDate("dd-MMM-yyyy");
		    
		    daoObj.setProcInValue(nProcIndex, "req_date", strCurrentDate,4);
		    daoObj.setProcInValue(nProcIndex, "issue_date", "",6);
		    daoObj.setProcInValue(nProcIndex, "institute_code", "",8);
		    daoObj.setProcInValue(nProcIndex, "institute_slno", "0",9);
		    daoObj.setProcInValue(nProcIndex, "req_status", "1",10);
		    daoObj.setProcInValue(nProcIndex, "financial_start_date", "",11);
		    daoObj.setProcInValue(nProcIndex, "financial_end_date", "",12);
		    daoObj.setProcInValue(nProcIndex, "recieve_by", "",13);
		    daoObj.setProcInValue(nProcIndex, "entry_date", strCurrentDate,15);
		    daoObj.setProcInValue(nProcIndex, "issuedate", strCurrentDate,18);
		    daoObj.setProcInValue(nProcIndex, "approvalflag", "1",19);
		    /* Setting Default Value End */
		    
		    daoObj.setProcOutValue(nProcIndex, "err", 1,21);
		    daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1,20);
		    daoObj.setProcOutValue(nProcIndex, "dml_count", 1,22);
		    daoObj.setProcOutValue(nProcIndex, "approval_level", 1,23);
		    daoObj.executeProcedureByPosition(nProcIndex);
		    ////System.out.println("approval_level->"+daoObj.getString(nProcIndex, "approval_level"));
		    ////System.out.println("updateCount->"+daoObj.getString(nProcIndex, "dml_count"));
		   
		} 
		catch(Exception e) {
			voObj.setStrMsgString("ThirdPartyIssueReqTransDAO.CANCEL_REQUEST() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		}
		finally {
			daoObj=null;	//to reset the variables
		}
	}

	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	public static void insert(ThirdPartyIssueReqTransVO voObj) {

		HisDAO daoObj = null;
	 
		int funcIndex = 0;
		
		String strReqNo = "";
		
		String strItemId = null;						
		String strItemBrandId  = null;					
		String strBatchSlNo = null;						
	//	String strItemCatNo = null;						
		String strExpiryDate = null;					
	//	String strMaufDate = null;						
	//	String strInHandQtyPlusUnitName = null;			
	//	String strInhandQtyPlusQtyUnitID = null;		
	//	String strInHandQtyUnitBaseValue = null;		
		String strRate = null;							
		String strRateUnitId = null;					
	//	String strUnitName = null;							
	//	String strItemStatus = null;					
		String strConsumablesFlag = null;				
		String strGroupId = null;						
		String strSubGroupId = null;					
	//	String strItemDtl = null;						
		String strSanctionQty ="0";
		String strSanctionQtyUnitId ="0";
		String strIssueQty ="0";
		String strIssueQtyUnitId ="0";
	//	String strInstituteCode = null;
	//	String strInstituteSlNo = null;
	//	String rateId     = null;
	//	String rateUnitId = null;
		String strInhandQty = null;
		String strInhandQtyUnitId = null;
		String strItemSlNo="0";
		String strStock_status_code="0";
		String[] temp = null;
	//	String[] temp1 = null;
	//	String[] temp2 = null;
	//	String[] strTemp = null;
		DML_ThirdPartyIssueReqDAO thirdPartyIssueReqDAO = null;
		DML_ThirdPartyIssueItemReqDAO thirdPartyIssueReqItemDAO = null;
	//	WebRowSet ws = null;
		int nProcIndex = 0;
	//	String strErr = "";
      //  int thirdPartyIssueReqDAOProcIndex=0; 
		try {
			daoObj = new HisDAO("MMS Module", "Third Party Issue");
			thirdPartyIssueReqDAO = new DML_ThirdPartyIssueReqDAO();
			thirdPartyIssueReqItemDAO = new DML_ThirdPartyIssueItemReqDAO();
		    //generate_third_party_req_no (hosp_code NUMBER,store_id NUMBER,reqType NUMBER,itemCat NUMBER)	 	 
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_third_party_req_no(?::numeric,?::numeric,?::numeric,?::numeric)}");
				// Set Value
			daoObj.setFuncInValue(funcIndex,2,voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex,3,voObj.getStrStoreId());
			daoObj.setFuncInValue(funcIndex,4,"65");
			daoObj.setFuncInValue(funcIndex,5,voObj.getStrItemCatNo());
			daoObj.setFuncOutValue(funcIndex,3);
			daoObj.executeFuncForNumeric(funcIndex);
			
			strReqNo = daoObj.getFuncNumeric(funcIndex).toString(); // getting the req no.	
			 /**
			  * insert data into HSTT_THIRD_PARTY_ISSUE_DTL
			  */
			
		    ////System.out.println("t1---reqno------------->"+strReqNo);
			////System.out.println("t1---hospcode---------->"+voObj.getStrHospitalCode());
			////System.out.println("t1---itemcat----------->"+voObj.getStrItemCatNo());
			////System.out.println("t1---storeid----------->"+voObj.getStrStoreId());
			////System.out.println("t1---institutecode----->"+voObj.getStrInstituteCode().replace('^', '#').split("#")[0]);
			////System.out.println("t1---instituteslNo----->"+voObj.getStrInstituteCode().replace('^', '#').split("#")[1]);
			////System.out.println("t1---financialstartyr-->"+voObj.getStrFinancialStartYear());
			////System.out.println("t1---financialendyr---->"+voObj.getStrFinancialEndYear());
			////System.out.println("t1---remarks----------->"+voObj.getStrRemarks());
			////System.out.println("t1---seatid------------>"+voObj.getStrSeatId());
			voObj.setStrCurrentDate(ThirdPartyIssueReqTransDATA.now(DATE_FORMAT_NOW));
			////System.out.println("---hello---IN");
			 thirdPartyIssueReqDAO.setStrTReqNo(strReqNo);											//1
			 thirdPartyIssueReqDAO.setStrHospitalCode(voObj.getStrHospitalCode());					//2
			 thirdPartyIssueReqDAO.setStrItemCatNo(voObj.getStrItemCatNo());		//3	
			 thirdPartyIssueReqDAO.setStrStoreId(voObj.getStrStoreId());							//4
			
			 //thirdPartyIssueReqDAO.setStrInstituteCode(voObj.getStrInstituteCode().replace('^', '#').split("#")[0]);	
			 //thirdPartyIssueReqDAO.setStrInstituteSlNo(voObj.getStrInstituteCode().replace('^', '#').split("#")[1]);	//5
			 
			 thirdPartyIssueReqDAO.setStrInstituteCode(voObj.getStrInstituteCode());	
			 thirdPartyIssueReqDAO.setStrInstituteSlNo("0");	//5
			 
			 thirdPartyIssueReqDAO.setStrReqStatus("0");											//6
			 thirdPartyIssueReqDAO.setStrFinancialStartYear(voObj.getStrFinancialStartYear());		//7
			 thirdPartyIssueReqDAO.setStrFinancialEndYear(voObj.getStrFinancialEndYear());			//8
			 thirdPartyIssueReqDAO.setStrRemarks(voObj.getStrRemarks());							//9
			 thirdPartyIssueReqDAO.setStrSeatId(voObj.getStrSeatId());		
			 thirdPartyIssueReqDAO.setStrEntryDate(voObj.getStrCurrentDate());//10
			 thirdPartyIssueReqDAO.setStrReqDate(voObj.getStrCurrentDate());
			 //thirdPartyIssueReqDAO.setStrIssueDate(strIssueDate)
			 thirdPartyIssueReqDAO.setStrGnumIsValid("1");
			 thirdPartyIssueReqDAO.setIssueDate("");
			 thirdPartyIssueReqDAO.setApprovalFlag("1");

			 thirdPartyIssueReqDAO.insert(daoObj);
			 
			 
			 ////System.out.println("---hello---OUT-->"+thirdPartyIssueReqDAOProcIndex);
			/**
			 * Hidden Values corresponding to particular
			 * ITEM DETAILS
			 */	
			 ////System.out.println("---voObj.getStrQty().length-->"+voObj.getStrQty().length);
			for(int i=0 , stopI = voObj.getStrQty().length;i<stopI;i++){
				 ////System.out.println("---voObj.getItemUserValue()[i]-->"+voObj.getItemUserValue()[i]);
				 temp  = voObj.getItemUserValue()[i].replace('^', '#').split("#");
				 strItemSlNo=temp[18];	
				 strStock_status_code=temp[32];
				 strItemId =temp[0];
				 
				 if(temp[1]== null||temp[1].equals(""))
        	     {               
					 strItemBrandId  = "0";
        	     }
        	     else
        	     {
        	    	 strItemBrandId = temp[1];
        	     }
				 
				 strBatchSlNo = temp[15];
				 if(temp[16].trim().equals("/"))
					 strExpiryDate = ""; 
				 else	 
					 strExpiryDate = temp[16];
				 
			//	 strMaufDate = temp[17];
				 strInhandQty=temp[7];
				 strInhandQtyUnitId=temp[8];
				 strRate = temp[9];
				 strRateUnitId = temp[10];
				 strConsumablesFlag = temp[4];
				 strGroupId = temp[2];
				 strSubGroupId = temp[3];
				 /**
				  * insert data into HSTT_THIRD_PARTY_ISSUE_ITEM_DTL
				  */
				////System.out.println("/**************************************************/"); 
				////System.out.println("t2---approval LEVEL------------>"+thirdPartyIssueReqDAO.getStrApproval_level());
				////System.out.println("t2---storeid----------->"+voObj.getStrStoreId());
				////System.out.println("t2---reqno------------>"+strReqNo);
				////System.out.println("t2---itemSlNo------------>"+strItemSlNo);
				////System.out.println("t2---stock_status_code------------>"+strStock_status_code);
				////System.out.println("t2---itemid----------->"+strItemId);
				////System.out.println("t2---itembrandid------>"+strItemBrandId);
				////System.out.println("t2---batchslno-------->"+strBatchSlNo);
				////System.out.println("t2---hospcode--------->"+voObj.getStrHospitalCode());
				////System.out.println("t2---groupid---------->"+strGroupId);
				////System.out.println("t2---subgroupid------->"+strSubGroupId);
				////System.out.println("t2---qty-------------->"+voObj.getStrQty()[i]);
				////System.out.println("t2---unitid----------->"+rateUnitId);
				////System.out.println("t2---inhandqty-------->"+strInhandQty);
				////System.out.println("t2---inhandqtyid------>"+strInhandQtyUnitId);
				////System.out.println("t2---rate------------->"+strRate);
				////System.out.println("t2---rateunitid------->"+strRateUnitId);
				////System.out.println("t2---expiryid--------->"+strExpiryDate);
				////System.out.println("t2---consumablesflag-->"+strConsumablesFlag);
				////System.out.println("t2---req Qty-->"+voObj.getStrQty()[i]);
				////System.out.println("t2---req Qty UnitId-->"+voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);
				
				thirdPartyIssueReqItemDAO.setStrApproval_level(thirdPartyIssueReqDAO.getStrApproval_level());
				thirdPartyIssueReqItemDAO.setStrReqNo(strReqNo);								 		//1
				thirdPartyIssueReqItemDAO.setStrHstNumStoreId(voObj.getStrStoreId());
				thirdPartyIssueReqItemDAO.setStrSstNumItemCatNo(voObj.getStrItemCatNo());
				thirdPartyIssueReqItemDAO.setStrHstNumItemSlNo(strItemSlNo);
				thirdPartyIssueReqItemDAO.setStrHstNumStockStatusCode(strStock_status_code);
				thirdPartyIssueReqItemDAO.setStrItemId(strItemId);								 		//2
				thirdPartyIssueReqItemDAO.setStrItemBrandId(strItemBrandId);					 		//3
				thirdPartyIssueReqItemDAO.setStrBatchSlNo(strBatchSlNo);						 		//4	
				thirdPartyIssueReqItemDAO.setStrHospitalCode(voObj.getStrHospitalCode());	
				//thirdPartyIssueReqDAO.setStrInstituteCode(voObj.getStrInstituteCode().replace('^', '#').split("#")[0]);	
				 //thirdPartyIssueReqDAO.setStrInstituteSlNo(voObj.getStrInstituteCode().replace('^', '#').split("#")[1]);	//5
				 
				 thirdPartyIssueReqDAO.setStrInstituteCode(voObj.getStrInstituteCode());	
				 thirdPartyIssueReqDAO.setStrInstituteSlNo("0");	//5
				thirdPartyIssueReqItemDAO.setStrSeatId(voObj.getStrSeatId());//5
				thirdPartyIssueReqItemDAO.setStrGroupId(strGroupId);							 		//6
				thirdPartyIssueReqItemDAO.setStrSubGroupId(strSubGroupId);						 		//7
				thirdPartyIssueReqItemDAO.setStrReqQty(voObj.getStrQty()[i]);					 		//8
				thirdPartyIssueReqItemDAO.setStrReqQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);	
				if(thirdPartyIssueReqDAO.getStrApproval_level().equals("0"))//if Approval_level=0 then no approval req::Sanc Qty & Unit Id updated
				{
				   thirdPartyIssueReqItemDAO.setStrSanctionQty(voObj.getStrQty()[i]);//9
				   thirdPartyIssueReqItemDAO.setStrSanctionQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);//10
				}
				else
				{
				   thirdPartyIssueReqItemDAO.setStrSanctionQty(strSanctionQty);//9
				   thirdPartyIssueReqItemDAO.setStrSanctionQtyUnitId(strSanctionQtyUnitId);//10	
				}
				thirdPartyIssueReqItemDAO.setStrIssueQty(strIssueQty);
				thirdPartyIssueReqItemDAO.setStrIssueQtyUnitId(strIssueQtyUnitId);
				thirdPartyIssueReqItemDAO.setStrInhandQty(strInhandQty);						 		//10
				thirdPartyIssueReqItemDAO.setStrInhandQtyUnitId(strInhandQtyUnitId);			 		//11	
				thirdPartyIssueReqItemDAO.setStrRate(strRate);									 		//12
				thirdPartyIssueReqItemDAO.setStrRateUnitId(strRateUnitId);		
				if(strExpiryDate.trim().equals("/"))                                                //13
					strExpiryDate="";
				thirdPartyIssueReqItemDAO.setStrExpiryDate(strExpiryDate);						 		//14
				thirdPartyIssueReqItemDAO.setStrConsumablesFlag(strConsumablesFlag);			 		//16
				thirdPartyIssueReqItemDAO.setIssueDate("");
				thirdPartyIssueReqItemDAO.setApprovalFlag("1");
				thirdPartyIssueReqItemDAO.insert(daoObj);
			 }	
			synchronized(daoObj)
			{
				daoObj.fire();
				thirdPartyIssueReqDAO.setStrApproval_level(daoObj.getString(nProcIndex, "approval_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ThirdPartyIssueReqTransDAO.insert() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
			thirdPartyIssueReqItemDAO = null;
			thirdPartyIssueReqDAO = null;
		}
	}
	
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	public static void insertNew(ThirdPartyIssueReqTransVO voObj) {

		HisDAO daoObj = null;
	 
		int funcIndex = 0;
		
		String strReqNo = "";
		
		String strItemId = null;						
		String strItemBrandId  = null;					
		String strBatchSlNo = null;						
		String strExpiryDate = null;					
		String strRate = null;							
		String strRateUnitId = null;					
		String strConsumablesFlag = null;				
		String strGroupId = null;						
		String strSubGroupId = null;					
		String strSanctionQty ="0";
		String strSanctionQtyUnitId ="0";
		String strIssueQty ="0";
		String strIssueQtyUnitId ="0";
		String strInhandQty = null;
		String strInhandQtyUnitId = null;
		String strItemSlNo="0";
		String strStock_status_code="0";
		String[] temp = null;
		DML_ThirdPartyIssueReqDAO thirdPartyIssueReqDAO = null;
		DML_ThirdPartyIssueItemReqDAO thirdPartyIssueReqItemDAO = null;
		int nProcIndex = 0;
		try
		{
			daoObj = new HisDAO("MMS Module", "Third Party Issue");
			thirdPartyIssueReqDAO = new DML_ThirdPartyIssueReqDAO();
			thirdPartyIssueReqItemDAO = new DML_ThirdPartyIssueItemReqDAO();		    
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_third_party_req_no(?,?,?,?)}");
				// Set Value
			daoObj.setFuncInValue(funcIndex,2,voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex,3,voObj.getStrStoreId());
			daoObj.setFuncInValue(funcIndex,4,"65");
			daoObj.setFuncInValue(funcIndex,5,voObj.getStrItemCatNo());
			daoObj.setFuncOutValue(funcIndex,1);
			daoObj.executeFunction(funcIndex);
			
			strReqNo = daoObj.getFuncString(funcIndex); // getting the req no.	
			 /**
			  * insert data into HSTT_THIRD_PARTY_ISSUE_DTL
			  */
			
		    ////System.out.println("t1---reqno------------->"+strReqNo);
			////System.out.println("t1---hospcode---------->"+voObj.getStrHospitalCode());
			////System.out.println("t1---itemcat----------->"+voObj.getStrItemCatNo());
			////System.out.println("t1---storeid----------->"+voObj.getStrStoreId());
			////System.out.println("t1---institutecode----->"+voObj.getStrInstituteCode().replace('^', '#').split("#")[0]);
			////System.out.println("t1---instituteslNo----->"+voObj.getStrInstituteCode().replace('^', '#').split("#")[1]);
			////System.out.println("t1---financialstartyr-->"+voObj.getStrFinancialStartYear());
			////System.out.println("t1---financialendyr---->"+voObj.getStrFinancialEndYear());
			////System.out.println("t1---remarks----------->"+voObj.getStrRemarks());
			////System.out.println("t1---seatid------------>"+voObj.getStrSeatId());
			 voObj.setStrCurrentDate(ThirdPartyIssueReqTransDATA.now(DATE_FORMAT_NOW));
			////System.out.println("---hello---IN");
			 thirdPartyIssueReqDAO.setStrTReqNo(strReqNo);											//1
			 thirdPartyIssueReqDAO.setStrHospitalCode(voObj.getStrHospitalCode());					//2
			 thirdPartyIssueReqDAO.setStrItemCatNo(voObj.getStrItemCatNo());		                //3	
			 thirdPartyIssueReqDAO.setStrStoreId(voObj.getStrStoreId());							//4
			 thirdPartyIssueReqDAO.setStrInstituteCode(voObj.getStrInstituteCode());	            //5
			 thirdPartyIssueReqDAO.setStrInstituteSlNo("0");	                                    //6			 
			 thirdPartyIssueReqDAO.setStrReqStatus("0");											//7
			 thirdPartyIssueReqDAO.setStrFinancialStartYear(voObj.getStrFinancialStartYear());		//8
			 thirdPartyIssueReqDAO.setStrFinancialEndYear(voObj.getStrFinancialEndYear());			//9
			 thirdPartyIssueReqDAO.setStrRemarks(voObj.getStrRemarks());							//10
			 thirdPartyIssueReqDAO.setStrSeatId(voObj.getStrSeatId());		                        //11
			 thirdPartyIssueReqDAO.setStrEntryDate(voObj.getStrCurrentDate());                      //12
			 thirdPartyIssueReqDAO.setStrReqDate(voObj.getStrCurrentDate());                        //13 
			 thirdPartyIssueReqDAO.setStrGnumIsValid("1");                                          //14 
			 thirdPartyIssueReqDAO.setIssueDate(voObj.getStrThirdPartyIssueDate());                 //15  
			 thirdPartyIssueReqDAO.setApprovalFlag("0");                                            //16
			 thirdPartyIssueReqDAO.setStrReceiveBy(voObj.getStrReceiveBy());                        //17 
			 thirdPartyIssueReqDAO.insert(daoObj);
			 
			 
			 ////System.out.println("---hello---OUT-->"+thirdPartyIssueReqDAOProcIndex);
			/**
			 * Hidden Values corresponding to particular
			 * ITEM DETAILS
			 */	
			 ////System.out.println("---voObj.getStrQty().length-->"+voObj.getStrQty().length);
			for(int i=0 , stopI = voObj.getStrQty().length;i<stopI;i++){
				 ////System.out.println("---voObj.getItemUserValue()[i]-->"+voObj.getItemUserValue()[i]);
				 temp  = voObj.getItemUserValue()[i].replace('^', '#').split("#");
				 strItemSlNo=temp[18];	
				 strStock_status_code=temp[32];
				 strItemId =temp[0];
				 
				 if(temp[1]== null||temp[1].equals(""))
        	     {               
					 strItemBrandId  = "0";
        	     }
        	     else
        	     {
        	    	 strItemBrandId = temp[1];
        	     }
				 
				 strBatchSlNo = temp[15];
				 if(temp[16].trim().equals("/"))
					 strExpiryDate = ""; 
				 else	 
					 strExpiryDate = temp[16];
				 
			//	 strMaufDate = temp[17];
				 strInhandQty=temp[7];
				 strInhandQtyUnitId=temp[8];
				 strRate = temp[9];
				 strRateUnitId = temp[10];
				 strConsumablesFlag = temp[4];
				 strGroupId = temp[2];
				 strSubGroupId = temp[3];
				 /**
				  * insert data into HSTT_THIRD_PARTY_ISSUE_ITEM_DTL
				  */
				////System.out.println("/**************************************************/"); 
				////System.out.println("t2---approval LEVEL------------>"+thirdPartyIssueReqDAO.getStrApproval_level());
				////System.out.println("t2---storeid----------->"+voObj.getStrStoreId());
				////System.out.println("t2---reqno------------>"+strReqNo);
				////System.out.println("t2---itemSlNo------------>"+strItemSlNo);
				////System.out.println("t2---stock_status_code------------>"+strStock_status_code);
				////System.out.println("t2---itemid----------->"+strItemId);
				////System.out.println("t2---itembrandid------>"+strItemBrandId);
				////System.out.println("t2---batchslno-------->"+strBatchSlNo);
				////System.out.println("t2---hospcode--------->"+voObj.getStrHospitalCode());
				////System.out.println("t2---groupid---------->"+strGroupId);
				////System.out.println("t2---subgroupid------->"+strSubGroupId);
				////System.out.println("t2---qty-------------->"+voObj.getStrQty()[i]);
				////System.out.println("t2---unitid----------->"+rateUnitId);
				////System.out.println("t2---inhandqty-------->"+strInhandQty);
				////System.out.println("t2---inhandqtyid------>"+strInhandQtyUnitId);
				////System.out.println("t2---rate------------->"+strRate);
				////System.out.println("t2---rateunitid------->"+strRateUnitId);
				////System.out.println("t2---expiryid--------->"+strExpiryDate);
				////System.out.println("t2---consumablesflag-->"+strConsumablesFlag);
				////System.out.println("t2---req Qty-->"+voObj.getStrQty()[i]);
				////System.out.println("t2---req Qty UnitId-->"+voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);
				
				thirdPartyIssueReqItemDAO.setStrApproval_level(thirdPartyIssueReqDAO.getStrApproval_level());
				thirdPartyIssueReqItemDAO.setStrReqNo(strReqNo);								 		//1
				thirdPartyIssueReqItemDAO.setStrHstNumStoreId(voObj.getStrStoreId());
				thirdPartyIssueReqItemDAO.setStrSstNumItemCatNo(voObj.getStrItemCatNo());
				thirdPartyIssueReqItemDAO.setStrHstNumItemSlNo(strItemSlNo);
				thirdPartyIssueReqItemDAO.setStrHstNumStockStatusCode(strStock_status_code);
				thirdPartyIssueReqItemDAO.setStrItemId(strItemId);								 		//2
				thirdPartyIssueReqItemDAO.setStrItemBrandId(strItemBrandId);					 		//3
				thirdPartyIssueReqItemDAO.setStrBatchSlNo(strBatchSlNo);						 		//4	
				thirdPartyIssueReqItemDAO.setStrHospitalCode(voObj.getStrHospitalCode());	
				thirdPartyIssueReqItemDAO.setStrInstituteCode(voObj.getStrInstituteCode());	
				thirdPartyIssueReqItemDAO.setStrInstituteSlNo("0");	//5
				thirdPartyIssueReqItemDAO.setStrSeatId(voObj.getStrSeatId());//5
				thirdPartyIssueReqItemDAO.setStrGroupId(strGroupId);							 		//6
				thirdPartyIssueReqItemDAO.setStrSubGroupId(strSubGroupId);						 		//7
				thirdPartyIssueReqItemDAO.setStrReqQty(voObj.getStrQty()[i]);					 		//8
				thirdPartyIssueReqItemDAO.setStrReqQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);	
//				if(thirdPartyIssueReqDAO.getStrApproval_level().equals("0"))//if Approval_level=0 then no approval req::Sanc Qty & Unit Id updated
//				{
//				   thirdPartyIssueReqItemDAO.setStrSanctionQty(voObj.getStrQty()[i]);//9
//				   thirdPartyIssueReqItemDAO.setStrSanctionQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);//10
//				}
//				else
//				{
//				   thirdPartyIssueReqItemDAO.setStrSanctionQty(strSanctionQty);//9
//				   thirdPartyIssueReqItemDAO.setStrSanctionQtyUnitId(strSanctionQtyUnitId);//10	
//				}
				
				thirdPartyIssueReqItemDAO.setStrSanctionQty(voObj.getStrQty()[i]);//9
				thirdPartyIssueReqItemDAO.setStrSanctionQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);//10
				thirdPartyIssueReqItemDAO.setStrIssueQty(voObj.getStrQty()[i]);
				thirdPartyIssueReqItemDAO.setStrIssueQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);
				thirdPartyIssueReqItemDAO.setStrInhandQty(strInhandQty);						 		//10
				thirdPartyIssueReqItemDAO.setStrInhandQtyUnitId(strInhandQtyUnitId);			 		//11	
				thirdPartyIssueReqItemDAO.setStrRate(strRate);									 		//12
				thirdPartyIssueReqItemDAO.setStrRateUnitId(strRateUnitId);		
				if(strExpiryDate.trim().equals("/"))                                                //13
					strExpiryDate="";
				thirdPartyIssueReqItemDAO.setStrExpiryDate(strExpiryDate);						 		//14
				thirdPartyIssueReqItemDAO.setStrConsumablesFlag(strConsumablesFlag);			 		//16
				thirdPartyIssueReqItemDAO.setIssueDate(voObj.getStrThirdPartyIssueDate());
				thirdPartyIssueReqItemDAO.setApprovalFlag("0");
				thirdPartyIssueReqItemDAO.insert(daoObj);
			 }	
			synchronized(daoObj)
			{
				daoObj.fire();
				voObj.setStrReqNo(strReqNo);
				thirdPartyIssueReqDAO.setStrApproval_level(daoObj.getString(nProcIndex, "approval_level"));
			}
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			
			if(e.getMessage().split("\\##").length>1)
			{
				voObj.setStrMsgString("ThirdPartyIssueReqTransDAO.insert() -->"+ e.getMessage());
			}
			else
				voObj.setStrMsgString("ThirdPartyIssueReqTransDAO.insert() -->## "+ e.getMessage());
				
			
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
			thirdPartyIssueReqItemDAO = null;
			thirdPartyIssueReqDAO = null;
		}
	}
	
	public static void getItemDetails(ThirdPartyIssueReqTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Thirdpartyissue_Item_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),4);
			daoObj.setProcInValue(nProcIndex, "req_no", voObj.getStrReqNo(),2);
			
			daoObj.setProcInValue(nProcIndex, "store_Id", "",3); // Default Value
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				voObj.setStrItemCatWs(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("ThirdPartyIssueReqTransDAO.getItemDetails() -->"+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
}
