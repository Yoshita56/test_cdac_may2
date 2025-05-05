package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttPurIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.AnnualPurchaseIndentVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/May/2009
 * Modif Date : / /2009 
*/
public class AnnualPurchaseIndentDAO {
	/**
	 * for getting option value of combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void getStoreNADrugsList(AnnualPurchaseIndentVO vo)
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_Not_Issue_Drugs_dtls(?,?,?,?,?  , ?,?,?,?,? , ? )}";
		
		

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try 
		{
			
			    dao = new HisDAO( "mms",	"AnnualPurchaseIndentDAO.getStoreNADrugsList(AnnualPurchaseIndentVO vo)");

			    procIndex1 = dao.setProcedure(proc_name1);

			// set value			  
						
	            dao.setProcInValue(procIndex1, "modeval", 		"1",1);
				dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),2);
				dao.setProcInValue(procIndex1, "indentno", 		"0",3);
				dao.setProcInValue(procIndex1, "frmstoreid", 	vo.getStrStoreId(),4);
				dao.setProcInValue(procIndex1, "tostoreid", 	"0",5);
				dao.setProcInValue(procIndex1, "reqType", 		"17",6);
				dao.setProcInValue(procIndex1, "catgCode", 		vo.getStrItemCategoryNo(),7);
				dao.setProcInValue(procIndex1, "frmDate", 		"0",8);
				dao.setProcInValue(procIndex1, "toDate", 		"0",9);
								
				dao.setProcOutValue(procIndex1, "err", 			1,10); // 1 for string return
				// value

				dao.setProcOutValue(procIndex1, "resultset", 	2,11); // 2 for object
				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
			
			vo.setNaDrugsDetailsWs(ws);

			

		} catch (Exception e) {
			vo.setStrMsgString("AnnualPurchaseIndentDAO.ToStoreCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(AnnualPurchaseIndentVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_itemtype_list(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO dao = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("Issue To Patient", "AnnualPurchaseIndentDAO");
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);

			dao.setProcInValue(nProcIndex, "itemcatcode", vo.getStrItemCategoryNo(),2); // Check
																			// It

			dao
					.setProcInValue(nProcIndex, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(nProcIndex, "err", 1,4); // 1 for string return

			dao.setProcOutValue(nProcIndex, "resultset", 2,5); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				if (ws != null && ws.size() != 0) {
					str = hisutil.getOptionValue(ws, "-1", "0^Select",
							true);
					vo.setStrItemCatgCombo(str);
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrItemCatgCombo(str);
				}
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ReceiveFromThirdPartyTransDAO.itemCategoryCombo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void IndentPeriodCombo(AnnualPurchaseIndentVO vo)
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetDeptCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

	            dao.setProcInValue(procIndex1, "modeval", "1",1);

				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
				
				dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return
				// value

				dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "13", "0^Select Value", true);
				vo.setStrIndentPeriodCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("AnnualPurchaseIndentDAO.ToStoreCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void GetGroupNameCombo(AnnualPurchaseIndentVO vo) {
		String err = "";
	
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetGroupNameCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "1",1);
			
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);
			
			/*start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo","",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/*end*/

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupIdForItemSearch(str);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("AnnualPurchaseIndentDAO.GetGroupNameCombo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionStoreName(AnnualPurchaseIndentVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "AnnualPurchaseIndentDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) {
				vo.setStrStoreName(retVal);
			} else {
				retVal = "-----";
				vo.setStrStoreName(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void callingItemCategory(AnnualPurchaseIndentVO vo)  {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try {
			dao = new HisDAO("MMSModule", "AnnualPurchaseIndentDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_itemcat_dtl(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrItemCatg(retVal);
			} else {
				retVal = "-----";
				vo.setStrItemCatg(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of combo on add page (Grant Type Combo)
	 * 
	 * @param vo
	 */
	public static void GetItemTypeCombo(AnnualPurchaseIndentVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_grant_list(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetSoreNameCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGrantTypeCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGrantTypeCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("AnnualPurchaseIndentDAO.GetItemTypeCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * for getting option value of combo on add page (Recommende Combo)
	 * 
	 * @param vo
	 */
	public static void GetRecommendByCombo(AnnualPurchaseIndentVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.Proc_Consultant_Name(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetSoreNameCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "1",1);
			
			dao.setProcInValue(procIndex1, "deptunitcode", "0",2);
			
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcInValue(procIndex1, "seatId", vo.getStrSeatId(),4);
						
			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);


			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrRecmndByCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrRecmndByCombo(str);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("AnnualPurchaseIndentDAO.GetRecommendByCombo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static WebRowSet GetItemCategoryCombo(AnnualPurchaseIndentVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			// hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetSoreNameCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId(),2); // Check
			// It

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);
			dao
			.setProcInValue(procIndex1, "reqType","0",4);

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

		} catch (Exception e) {
			vo.setStrMsgString("AnnualPurchaseIndentDAO.GetItemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

		return ws;
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void ToStoreCombo(AnnualPurchaseIndentVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AnnualPurchaseIndentDAO");
			dao = new HisDAO("mms",
					"AnnualPurchaseIndentDAO.GetDeptCombo(AnnualPurchaseIndentVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

	           dao.setProcInValue(procIndex1, "modeval", "1",1);

				

				dao
						.setProcInValue(procIndex1, "hosp_code", vo
								.getStrHospitalCode(),2);

				dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);

				dao.setProcInValue(procIndex1, "reqType", vo.getStrReqType(),4);
				
				dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo(),5);
				

				dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
				// value

				dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object
				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "", "", true);
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("AnnualPurchaseIndentDAO.ToStoreCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	/**
	 * INSERT method is used to insert data in following table
	 * 
	 * @param vo
	 */

	public synchronized static void INSERT(AnnualPurchaseIndentVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg ="";
		DmlIndentDtlDAO globalDao = null;
		try 
		{
			
			System.out.println("----------- AnnualPurchaseIndentDAO . INSERT -----------");
    		// Createing Object for Table Specific DAO 
    		globalDao = new DmlIndentDtlDAO();	
    	    dao = new HisDAO("MMS","transactions.AnnualPurchaseIndentDAO.INSERT()");
    		
			/*
				vo.setStrStoreTypeId(strStoreTypeId);
				vo.setStrItemCategoryNo(strItemCategoryNo);
				vo.setStrReqType(strReqType);
				vo.setItemParamValue(formBean.getItemParamValue());
				vo.setStrUnitName(formBean.getStrUnitName());
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrReqQty(formBean.getStrReqQty());
				*/
  			    globalDao.setStrId(vo.getStrStoreId());
				globalDao.setHosp_code(vo.getStrHospitalCode());
				globalDao.setReqTypeId(vo.getStrReqType());
				globalDao.setToStrId(vo.getStrToStoreCombo()); 
				globalDao.setItemcatNo(vo.getStrItemCategoryNo());
				globalDao.setItemTypeId(vo.getStrItemType());  
				globalDao.setUrgentFlag(vo.getStrUrgentFlg()); 
				globalDao.setIndentPeriod(vo.getStrIndentPeriod());		
						
				globalDao.setFinStartDate(vo.getStrFinancialStartYear());
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			    globalDao.setRemarks(vo.getStrRemarks());
				globalDao.setSeatId(vo.getStrSeatId());
			    
				globalDao.setGrantTypeId("0");     // Check It
				globalDao.setPuk("0");
				globalDao.setEmpNo("0");
				globalDao.setAdmNo("0");
				globalDao.setEpisodeCode("0");
				globalDao.setConsultantId("0");
				globalDao.setMemoNo("0");
				if(vo.getStrCostRequired().equals("0"))
				{	
				   globalDao.setTotCost("0");	
				}
				else
				{
					globalDao.setTotCost(vo.getStrApproxAmt());	
				}	
				globalDao.setIndentPeriodValue(vo.getStrIndentPeriodValue());
				
				procIndex1 = globalDao.insert(dao);
									
				dao.fire();     // Here we Execute in Batch
		      
		      indentNo    = dao.getString(procIndex1, "indentNo");
		      approvalFlg = dao.getString(procIndex1, "approvalFlg");
		      vo.setStrIndentNo(indentNo);
			 			  
			  System.out.println("vo.getItemParamValue().length-->>"+vo.getItemParamValue().length);
			  System.out.println("vo.getItemParamValue()[0].length()-->>"+ vo.getItemParamValue()[0].length());			 
			  System.out.println("vo.getNaDrugPK().length-------->>"+vo.getNaDrugPK().length);
			  
			  if(vo.getItemParamValue()[0].length()>0)
			  {
			      INSERTINTABLE(vo,indentNo,approvalFlg); // PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl [ Mode - 1 ]
			  }
			  if(vo.getNaDrugPK().length>0 && vo.getNaDrugPK()!=null)
			  {
				  INSERTNADRUGS(vo,indentNo,approvalFlg); // PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl [ Mode - 3 ]
			  }
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> AnnualPurchaseIndentDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	public synchronized static void INSERTINTABLE(AnnualPurchaseIndentVO vo,String indentNo,String approvalFlg) 
	{
		HisDAO dao = null;
		HisUtil hisutil = null;
		String[] temp = null;
	
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";

		DmlHsttPurIndentItemDtlDAO tableDao = null;
		
		
		try 
		{
			
			System.out.println("----------- AnnualPurchaseIndentDAO . INSERTINTABLE -----------");
			
			// Createing Object for Table Specific DAO
			tableDao  = new DmlHsttPurIndentItemDtlDAO();
            hisutil = new HisUtil("","");
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy"); 
    		dao = new HisDAO("MMS","transactions.AnnualPurchaseIndentDAO.INSERT()");
        		
 			int length = vo.getItemParamValue().length;
			
 			for(int i = 0;i<length;i++)
			{
		    				
				temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
				/*
				//System.out.println("Display Value-->>>>"+temp[0]);
				//System.out.println("Conversion  Value-->>>>"+temp[1]);
				//System.out.println("User  Value-->>>>"+temp[2]);
			    */
				strTemp         = temp[2].replace('^', '#').split("#");
				/*
				//System.out.println("ItemID-1->>"+strTemp[0]);
				//System.out.println("ItemBrandID-2->>"+strTemp[1]);
				//System.out.println("GrpID-3->>"+strTemp[2]);
				//System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				//System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				//System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				//System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				//System.out.println("In Hand Qty-8->>"+strTemp[7]);
				//System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				//System.out.println("Last Rate-10->>"+strTemp[9]);
				//System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
				
				
				//System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				//System.out.println("Last PO No-13->>"+strTemp[12]);
				//System.out.println("Last PO Date-14->>"+strTemp[13]);
				//System.out.println("Last Supplied By [Id]-15->>"+strTemp[14]);
				//System.out.println("Batch No-16->>"+strTemp[15]);
				//System.out.println("Expiry Date-17->>"+strTemp[16]);
				//System.out.println("Manufacture Date-18->>"+strTemp[17]);
				//System.out.println("Item Serial No-19->>"+strTemp[18]);
				//System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				//System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);
				
				//System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				//System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				//System.out.println("Last Received Qty-24->>"+strTemp[23]);
				//System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				//System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				//System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]);
				//System.out.println("Prefix-28->>"+strTemp[27]);
				//System.out.println("Cost Parameter-29->>"+strTemp[28]);
				//System.out.println("Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
				//System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
				
				//System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]);
				//System.out.println("Stock Status-33->>"+strTemp[32]);
				*/
				 strReqQty      = vo.getStrReqQty()[i];
				 strReqUnit     = vo.getStrUnitName()[i];
	    	     reqQtyUnit = strReqUnit.split("\\^");
	    	     //System.out.println("strReqQty-->>"+strReqQty);
	    	     //System.out.println("reqQtyUnit[0]-->>"+reqQtyUnit[0]);
			     if(approvalFlg.equals("0"))
			     {
			    	  strSancQty     = strReqQty;
			 		  strSancQtyUnit = reqQtyUnit[0];
			     }	
			     else
			     {
			    	 strSancQty     = "0";
			    	 strSancQtyUnit = "0";
			     }	  		    	 

				
				// //System.out.println("indent Anual Purchase No-in 2..->>>"+indentNo);
				 ////System.out.println("Store ID 2.....--->>>"+vo.getStrStoreId());
				 
				 tableDao.setStrId(vo.getStrStoreId());
				 tableDao.setStrReqNo(indentNo);
				 tableDao.setItemId(strTemp[0]);
				 tableDao.setItemBrandId(strTemp[1]);
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setStrPurchseReqDate(strCtDate);
				 tableDao.setGroupId(strTemp[2]);
				 tableDao.setSubGroupId(strTemp[3]);
				 tableDao.setRate(strTemp[9]);
				 tableDao.setRateUnitId(strTemp[10]);
				 tableDao.setIndentQty(strReqQty);
				 tableDao.setIndentQtyUnitId(reqQtyUnit[0]);
				 tableDao.setSancQty(strSancQty);
				 tableDao.setSancQtyUnitId(strSancQtyUnit);
				 tableDao.setInHandQty(strTemp[7]);
				 tableDao.setInHandQtyUnitId(strTemp[8]);
				 tableDao.setReOrderLevel(strTemp[5]);
				 tableDao.setReOrderUnitId(strTemp[6]);
				 tableDao.setManufacturerId("0");
				 tableDao.setApproxRate(strTemp[9]);
				 tableDao.setApproxRateUnitId(strTemp[10]);
				 tableDao.setLstYearConsumption(strTemp[25]);
				 tableDao.setLstYearConsumptionUnitId(strTemp[26]);
				 tableDao.setStrJustification("0");
				 tableDao.setRemarks(vo.getStrRemarks());
				 tableDao.setIsValid("1");
				 tableDao.setStrLstPoNo(strTemp[12]); 
				 tableDao.setStrLstPoDate(strTemp[13]);
				 tableDao.setStrLstRecQty(strTemp[23]);
				 tableDao.setStrLstRecQtyUnitId(strTemp[24]);
				 tableDao.setStrLstRecDate("");   // Plz Check It....Dummy Value
				 tableDao.setStrLstSupplierId(strTemp[14]); 
				 		 
				 tableDao.insert(dao);
					
	          }
 			
 			dao.fire();     // Here we Execute in Batch

		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> AnnualPurchaseIndentVO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	public synchronized static void INSERTNADRUGS(AnnualPurchaseIndentVO vo,String indentNo,String approvalFlg) 
	{
		HisDAO dao = null;
		HisUtil hisutil = null;
		int nInsertedIndex=0;
		
		
		try 
		{
			
			System.out.println("----------- AnnualPurchaseIndentDAO . INSERTNADRUGS -----------");
			
    		dao = new HisDAO("MMS","transactions.AnnualPurchaseIndentDAO.INSERTNADRUGS()"); 	    			

    		nInsertedIndex = dao.setProcedure("{call PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
               			
			dao.setProcInValue(nInsertedIndex,"modval",					"3",1);                                   //1
		   	dao.setProcInValue(nInsertedIndex,"strId",					vo.getStrStoreId(),2);                           //2
	       	dao.setProcInValue(nInsertedIndex,"strReqNo",				indentNo.trim(),3);                     //3
	       	dao.setProcInValue(nInsertedIndex,"itemId",					"0",4);                         //4
			dao.setProcInValue(nInsertedIndex,"itemBrandId",			"0",5);               //5
			dao.setProcInValue(nInsertedIndex,"hosp_code",				vo.getStrHospitalCode(),6);                   //6 
			dao.setProcInValue(nInsertedIndex,"strPurchseReqDate",		"",7);   //7
			dao.setProcInValue(nInsertedIndex,"groupId",				"0",8);                       //8
			dao.setProcInValue(nInsertedIndex,"subGroupId",				"0",9);                 //9  
			dao.setProcInValue(nInsertedIndex,"rate",					"0",10);                             //10       
			dao.setProcInValue(nInsertedIndex,"rateUnitId",				"0",11);                 //11
			dao.setProcInValue(nInsertedIndex,"IndentQty",				"0",12);                   //12
			dao.setProcInValue(nInsertedIndex,"IndentQtyUnitId",		"0",13);       //13
			dao.setProcInValue(nInsertedIndex,"sancQty",				"0",14);                       //14 
			dao.setProcInValue(nInsertedIndex,"sancQtyUnitId",			"0",15);           //15
			dao.setProcInValue(nInsertedIndex,"inHandQty",				"0",16);                   //16
			dao.setProcInValue(nInsertedIndex,"inHandQtyUnitId",		"0",17);       //17
			dao.setProcInValue(nInsertedIndex,"reOrderLevel",			"0",18);             //18
			dao.setProcInValue(nInsertedIndex,"reOrderUnitId",			"0",19);           //19
			dao.setProcInValue(nInsertedIndex,"manufacturerId",			"0",20);         //20
			dao.setProcInValue(nInsertedIndex,"approxRate",				"0",21);                 //21
			dao.setProcInValue(nInsertedIndex,"approxRateUnitId",		"0",22);     //22
			dao.setProcInValue(nInsertedIndex,"lstYearConsumption",		"0",23); //23
			dao.setProcInValue(nInsertedIndex,"lstYearConsumptionUnitId","0",24); //24  
			dao.setProcInValue(nInsertedIndex,"strJustification",		"0",25);                 //25 
			dao.setProcInValue(nInsertedIndex,"remarks",				vo.getStrRemarks(),26);                                   //26  
			dao.setProcInValue(nInsertedIndex,"isValid ",				"1",27);                                 //27
			
			dao.setProcInValue(nInsertedIndex,"strLstPoNo",				"0",28);                 //28
			dao.setProcInValue(nInsertedIndex,"strLstPoDate",			"0",29);             //29  
			dao.setProcInValue(nInsertedIndex,"strLstRecQty",			"0",30);             //30 
			dao.setProcInValue(nInsertedIndex,"strLstRecQtyUnitId",		"0",31); //31  
			dao.setProcInValue(nInsertedIndex,"strLstRecDate ",			"0",32);         //32
			dao.setProcInValue(nInsertedIndex,"strLstSupplierId ",		"0",33);   //33
			
			dao.setProcInValue(nInsertedIndex,"itemSpecification",		"0",34);
			dao.setProcInValue(nInsertedIndex,"itemMake",				"0",35);
			dao.setProcInValue(nInsertedIndex,"suggSupplier",			"0",36);
			dao.setProcInValue(nInsertedIndex,"rateContractSupp",		"0",37);
			dao.setProcInValue(nInsertedIndex,"brandResFlag",			"1",38);
			dao.setProcInValue(nInsertedIndex,"itemSlNo",				"0",39);
			dao.setProcInValue(nInsertedIndex,"uploadfileid",			"0",40);
			dao.setProcInValue(nInsertedIndex,"uploadfilename",			"0",41);
			
			dao.setProcInValue(nInsertedIndex,"strChMOQty",				"0",42);
			dao.setProcInValue(nInsertedIndex,"strMCQty",				"0",43);
			//output value                        
			dao.setProcOutValue(nInsertedIndex,"err",					 1,44);                                       //34 
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
 			
 			
 			dao.fire();     // Here we Execute in Batch

		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> AnnualPurchaseIndentVO.INSERTNADRUGS()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}


}
