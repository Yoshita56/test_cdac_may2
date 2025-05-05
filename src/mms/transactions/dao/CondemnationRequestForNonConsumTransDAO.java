package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttCondemnReqItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.dao.DmlIndentReturnRequestDAO;
import mms.transactions.vo.CondemnationRequestForNonConsumTransVO;


public class CondemnationRequestForNonConsumTransDAO {
	/**
	 * This Method is used to get group name 
	 * for Item Search Utility
	 * @param vo
	 */
	public static void GetData(CondemnationRequestForNonConsumTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try 
		{
			hisutil    = new HisUtil("master", "CondemnationRequestForNonConsumTransDAO");
			dao = new HisDAO("mms", "CondemnationRequestForNonConsumTransDAO.GetData(CondemnationRequestForNonConsumTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
	
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategory(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);
			
			/*Start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/*End*/

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
			
			if(ws!=null && ws.size()!=0)
			{
				str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);					
			}	
			else
			{
				str = "<option value='0'>DATA N/A</option>";  
				vo.setStrGroupIdForItemSearch(str);
			}	
         } 
		 catch (Exception e)
		 {
			vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.GetData() --> "+ e.getMessage());
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
	/*
	 * This Method is Used to get Item Type Combo (Check It ........)
	 * by passing two variable 
	 * a) Store_type_id
	 * b) Hospital Code
	 * 
	 */
	
	public static void GetItemType(CondemnationRequestForNonConsumTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_DML.dml_hstt_item_dtl(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try 
		{
			hisutil    = new HisUtil("master", "IndentTransADDDAO");
			dao = new HisDAO("mms", "CondemnationRequestForNonConsumTransDAO.GetData(CondemnationRequestForNonConsumTransVO vo)");

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
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			
			if(ws!=null && ws.size()!=0)
			{
				str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
				vo.setStrItemTypeCombo(str);					
			}	
			else
			{
				str = "<option value='0'>DATA N/A</option>";  
				vo.setStrItemTypeCombo(str);
			}	
         } 
		 catch (Exception e)
		 {
			vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.GetItemType() --> "+ e.getMessage());
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
	

	/**
		 * for getting option value of combo on add page (store type name )
		 * 
		 * @param vo
		 */
		public static void ToStoreCombo(CondemnationRequestForNonConsumTransVO vo) {
			String err = "";
			String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

			int procIndex1 = 0;
			HisDAO dao = null;
			WebRowSet ws = null;
			HisUtil hisutil = null;
			String str = null;

			try {
				hisutil = new HisUtil("master", "CondemnationRequestForNonConsumTransDAO");
				dao = new HisDAO("mms",
						"CondemnationRequestForNonConsumTransDAO.GetDeptCombo(CondemnationRequestForNonConsumTransVO vo)");

				procIndex1 = dao.setProcedure(proc_name1);

				// set value

		           dao.setProcInValue(procIndex1, "modeval", "1",1);

					

					dao
							.setProcInValue(procIndex1, "hosp_code", vo
									.getStrHospitalCode(),2);

					dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);

					dao.setProcInValue(procIndex1, "reqType", vo.getStrIndentTypeId(),4);
					
					dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategory(),5);
					

					dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
					// value

					dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object
					// execute procedure

					dao.executeProcedureByPosition(procIndex1);

				// get value
				err = dao.getString(procIndex1, "ERR");

				if (err == null)
					err = "";

				ws = dao.getWebRowSet(procIndex1, "RESULTSET");

				if (ws != null && ws.size() != 0) {
					str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
					vo.setStrToStoreCombo(str);
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrToStoreCombo(str);
				}

			} catch (Exception e) {
				vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.ToStoreCombo() --> "
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
	 * This Method is Used to get Item Combo
	 * by passing two variable 
	 * a) Store_type_id
	 * b) Hospital Code
	 * 
	 */
	
	
	public static void GetItemCombo(CondemnationRequestForNonConsumTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try 
		{
			hisutil    = new HisUtil("master", "IndentTransADDDAO");
			dao = new HisDAO("mms", "CondemnationRequestForNonConsumTransDAO.GetData(CondemnationRequestForNonConsumTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
	
			dao.setProcInValue(procIndex1, "modeval", "2",1);
					
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			////System.out.println("Item category-->>>"+vo.getStrItemCategory());
			dao.setProcInValue(procIndex1, "item_category",vo.getStrItemCategory(),3);
			
			/* Start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			
			/* End */

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
			if(ws!=null && ws.size()!=0)
			{
				str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);					
			}	
			else
			{
				str = "<option value='0'>DATA N/A</option>";  
				vo.setStrGroupIdForItemSearch(str);
			}	
         } 
		 catch (Exception e)
		 {
			 e.printStackTrace();
			vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.GetItemCombo() --> "+ e.getMessage());
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
	/*
	 * This Function is used to get Store Name
	 * by Passing 2 variable 
	 * a) Hospital Code
	 * b) Store Id 
	 */
	public static void callingFunctionStoreName(CondemnationRequestForNonConsumTransVO vo)
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("MMSModule", "CondemnationRequestForNonConsumTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_store_dtl(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if(retVal!=null)
			{
				vo.setStrStoreName(retVal);					
			}	
			else
			{
				retVal = "-----";  
				vo.setStrStoreName(retVal);
			}	

		}
		catch (Exception e) 
		{
			vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.callingFunctionStoreName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	/*
	 * This Function is used to get Item Category Name
	 * by Passing 2 variable 
	 * a) Hospital Code
	 * b) Item Category
	 */
   
	public static void callingItemCategory(CondemnationRequestForNonConsumTransVO vo)
	{
		
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try 
		{
			dao = new HisDAO("MMSModule", "CondemnationRequestForNonConsumTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_itemcat_dtl(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCategory());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			
			if(retVal!=null)
			{
				vo.setStrItemCatName(retVal);					
			}	
			else
			{
				retVal = "-----";  
				vo.setStrItemCatName(retVal);	
			}	

		}
		catch (Exception e) 
		{
			vo.setStrMsgString("CondemnationRequestForNonConsumTransDAO.callingItemCategory() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * INSERT method is used to insert data in following table
	 * SSTT_INDENT_DTL,SSTT_APPROVALREQ_DTL,HSTT_CONDEMN_REQ_DTL,
	 * HSTT_CONDEMN_REQITEM_DTL
	 * @param vo
	 */

	public static void INSERT(CondemnationRequestForNonConsumTransVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg ="";
		DmlIndentDtlDAO globalDao = null;
		String strCostRequired = null;
    	try 
		{
    		// Createing Object for Table Specific DAO
    		globalDao = new DmlIndentDtlDAO();	
    		dao = new HisDAO("MMS","transactions.CondemnationRequestForNonConsumTransDAO.INSERT()");
    			globalDao.setStrId(vo.getStrStoreId());
				globalDao.setHosp_code(vo.getStrHospitalCode());
				globalDao.setReqTypeId(vo.getStrReqType());
				globalDao.setToStrId(vo.getStrToStoreCombo());   
				globalDao.setItemcatNo(vo.getStrItemCatNo());
				globalDao.setItemTypeId("0");    //No Need
				globalDao.setUrgentFlag("0");   
				globalDao.setIndentPeriod("0");	 	
							
				globalDao.setFinStartDate(vo.getStrFinancialStartYear());
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			    globalDao.setRemarks(vo.getStrRemarks());
				globalDao.setSeatId(vo.getStrSeatId());
			    
				globalDao.setGrantTypeId("0");
				globalDao.setPuk("0");
				globalDao.setEmpNo("0");
				globalDao.setAdmNo("0");
				globalDao.setEpisodeCode("0");
				globalDao.setConsultantId("0");
				globalDao.setMemoNo("0");
				
				strCostRequired = vo.getStrCostRequired();
				if(strCostRequired==null || "".equals(strCostRequired.trim())) {
					strCostRequired = "0";
				}
				
				if("0".equals(strCostRequired)) {
					globalDao.setTotCost("0");
				} else {
					globalDao.setTotCost(vo.getStrApproxAmt());
				}
				
				//globalDao.setTotCost(vo.getStrApproxAmt());	
				
				procIndex1 = globalDao.insert(dao);
									
	          
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
			  }
		      indentNo    = dao.getString(procIndex1, "indentNo");
		      approvalFlg = dao.getString(procIndex1, "approvalFlg");
			/*  //System.out.println("Indent No-->>"+indentNo);
			  //System.out.println("Approval Flg-->>"+approvalFlg);*/
			  INSERTINTABLE(vo,indentNo,approvalFlg); 
	    } 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> CondemnationRequestForNonConsumTransDAO.INSERT()-->"
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
	
	/**
	 * INSERT method is used to insert data in following table
	 * HSTT_CONDEMN_REQITEM_DTL
	 * @param vo
	 * @param indentNo
	 */
	
	public static void INSERTINTABLE(CondemnationRequestForNonConsumTransVO vo,String indentNo,String approvalFlg) 
	{
		HisDAO dao = null;
		String[] reqQtyUnit=null;
		
	//	String[] sancQtyUnit=null;
		
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";
	
		HisUtil hisutil = null;
		String[] temp = null;
		String[] strTemp = null;
		DmlHsttCondemnReqItemDtlDAO tableDao = null;
		DmlIndentReturnRequestDAO tableDao1 = null;
		try 
		{
			hisutil = new HisUtil("MMS","transactions.CondemnationRequestForNonConsumTransDAO.INSERTINTABLE()");
			
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			
			// Createing Object for Table Specific DAO
			tableDao1 = new DmlIndentReturnRequestDAO();
			tableDao  = new DmlHsttCondemnReqItemDtlDAO();
    		dao = new HisDAO("MMS","transactions.CondemnationRequestForNonConsumTransDAO.INSERTINTABLE()");
    		 		    		
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
							
				/*//System.out.println("ItemID-1->>"+strTemp[0]);
				//System.out.println("ItemBrandID-2->>"+strTemp[1]);*/
				/*
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
				 ////System.out.println("Condem Qty-->"+vo.getStrCondemnationQty()[i]);
				 strReqQty      = vo.getStrCondemnationQty()[i];
				 ////System.out.println("Unit Name-->>"+vo.getStrUnitName()[i]);
				 strReqUnit     = vo.getStrUnitName()[i];
	    	     reqQtyUnit = strReqUnit.split("\\^");

		    	 
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
			   			 
				  tableDao.setStrStoreId(vo.getStrStoreId());
				  tableDao.setStrReqNo(indentNo);
				  tableDao.setStrItemId(strTemp[0]);
				  tableDao.setStrItemBrandId(strTemp[1]);
				  tableDao.setStrBatchNo(strTemp[15]);    
				  tableDao.setStrHospCode(vo.getStrHospitalCode());    
				  tableDao.setStrItemSlNo(strTemp[18]);
				  tableDao.setStrStockStatusCode(strTemp[32]); 
				  tableDao.setStrGroupId(strTemp[2]);
				  tableDao.setStrSubGroupId(strTemp[3]);
				  tableDao.setStrExpiryDate(strTemp[16]);
				  tableDao.setStrInHandQty(strTemp[7]);   
				  tableDao.setStrInHandQtyUnitId(strTemp[8]);
				  tableDao.setStrRate(strTemp[9]);  
				  tableDao.setStrRateUnitId(strTemp[10]);
				  tableDao.setStrReqQty(strReqQty);
				  tableDao.setStrReqQtyUnitId(reqQtyUnit[0]);
				  tableDao.setStrSancQty(strSancQty);
				  tableDao.setStrSancQtyUnitId(strSancQtyUnit);
				  tableDao.setStrSuppId(strTemp[14]);
				  tableDao.setStrLastPONo(strTemp[12]);
				  tableDao.setStrLastPODate(strTemp[13]);
				  tableDao.setStrLastRecDate(strCtDate);
				  tableDao.setStrRemarks(vo.getStrRemarks());
				  tableDao.setStrReturnFlag("0");    // Check It
					 
					 tableDao1.setStrId(vo.getStrStoreId()); 
					 tableDao1.setToStoreId(vo.getStrToStoreCombo());
					 tableDao1.setHosp_code(vo.getStrHospitalCode());
					 tableDao1.setReqNo(indentNo); 
					 tableDao1.setItemId(strTemp[0]);
					 tableDao1.setItemBrandId(strTemp[1]);
					 tableDao1.setReqTypeId(vo.getStrReqType());
					 tableDao1.setStrBatchNo(strTemp[15]);
					 tableDao1.setStrFinancialEndDate(vo.getStrFinancialEndYear());
					 tableDao1.setStrFinancialStarDate(vo.getStrFinancialStartYear());
					 tableDao1.setStrIsValid("1");
					 tableDao1.setStrItemCatgNo(vo.getStrItemCatNo());
					 tableDao1.setStrQty(strTemp[7]);
					 tableDao1.setStrSancQty(strReqQty);
					 tableDao1.setStrRecevedBy("");
					 tableDao1.setStrRemarks(vo.getStrRemarks());
					 tableDao1.setStrSancQtyUnit(reqQtyUnit[0]);
					 tableDao1.setStrStockStatusCode(strTemp[32]);
					 tableDao1.setStrUnitId(strTemp[8]);
					 tableDao1.setStrSeatId(vo.getStrSeatId());
					 tableDao1.setStrSlNo(strTemp[18]);
					 
//					 //System.out.println("Sanc Qty-->>"+strReqQty);
//					 //System.out.println("Sanc Qty Unit-->>"+reqQtyUnit[0]);
//				 	 //System.out.println("Store Id-->>"+vo.getStrStoreId());
//					 //System.out.println("Catg No-->>"+vo.getStrItemCatNo());
//				 	 //System.out.println("Staus Code-->>"+strTemp[32]);
//				 	 //System.out.println("Sl No-->>"+strTemp[18]);
//				 	 //System.out.println("item ID -->>"+strTemp[0]);
//				 	 //System.out.println("item Brand ID -->>"+strTemp[1]);
					 
					tableDao.insert(dao);
				    tableDao1.insertCondemnation(dao);
				  		  
			
	          }
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
			  }
		    
		} 
    	catch (Exception e) 
    	{
    		//e.printStackTrace();
			vo.setStrMsgString("-->CondemnationRequestForNonConsumTransDAO.INSERTINTABLE()-->"
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
