package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.SampleSentTransVO;

public class SampleSentTransDAO
{
	
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void initSampleSent(SampleSentTransVO vo) 
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	try 
		{
			
    		hisutil = new HisUtil("MMSModule", "SampleSentTransDAO");
			wb      = STORENAMECOMBO(vo);
			if(wb!= null)
			{	
			   if(wb.next())
			   {
				   vo.setStrStoreId(wb.getString(1));
				   wb.beforeFirst();
			   }
				str1 = hisutil.getOptionValue(wb, vo.getStrStoreId(),"0^Select Value", true);
			   vo.setStrStoreName(str1);
			}
			 else
            {
               str1 = "<option value='0'>DATA  N/A</option>";   
               vo.setStrStoreName(str1);
            }
			
		
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
    		vo.setStrMsgString("--> SampleSentTransDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getLabNameCmb(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Lab_list(?,?,?,?,?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("MMSModule","SampleSentTransDAO");
			hisutil    = new HisUtil("mms", "SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			String str;
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, "","0^Select Value", true);
					vo.setStrLabNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrLabNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getLabNameCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * The following procedure is used to populate the value of Unit Name combo
	 * using Pkg_Mms_View.Proc_Gblt_Unit_Mst procedure.
	 * 
	 * 
	 */
	public static void unitNameCombo(SampleSentTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("SampleSentTrans", "SampleSentTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?, ?, ?, ?)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "1");
			
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrDrugBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strUnitRate = daoObj.getFuncString(nFuncIndex);
			
			vo.setStrUnitRateID(strUnitRate);
			////System.out.println("Unit Rate==>"+strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "module_id", "");//Aritra
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setWsUnitCombo(ws);

			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("SampleSentTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getCategoryCmb(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "reqType", "0");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setWsItemCategoryCombo(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getCategoryCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDrugBatchDtl(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_Batch_Details(?,?,?,?,?,?,?,?)}"; //8
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{			
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemBrandId", vo.getStrDrugBrandId());
			daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "reSendFlg", vo.getStrReSendFlg());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				if(ws.size()>0)
				{
						while(ws.next())
						{
							
							vo.setStrBatchDetails(ws.getString(1));
						}
				}
				else
				{
					vo.setStrBatchDetails("---^---^---^---^---^---");
				}
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getDrugBatchCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getViewHlp(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_SampleSent_Detail(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
				
			if(vo.getStrSearchType().equals("1"))
			{	
			    daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			}
			else
			{
				daoObj.setProcInValue(nProcIndex, "p_mode", "4");	
			}
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_strId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_catgNo", "10");
			daoObj.setProcInValue(nProcIndex, "p_frmdate", vo.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "p_todate", vo.getStrToDate());
			daoObj.setProcInValue(nProcIndex, "p_labNo",  vo.getStrLabId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("Size==>"+ws.size());
			if (strErr.equals("")) 
			{
					
				  vo.setWsLabSentHlp(ws);
				 
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			vo.setStrMsgString("SampleSentTransDAO.getViewHlp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDrugBatchCmb(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_Batch_list(?,?,?,?,?,?,?)}"; //7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemBrandId", vo.getStrDrugBrandId());
			daoObj.setProcInValue(nProcIndex, "reSendFlg", vo.getStrReSendFlg());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
					
				  vo.setWsDrugBatchCombo(ws);
				 
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getDrugBatchCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDrugNameCmb(SampleSentTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_list(?,?,?,?,?,?,?)}"; //7 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
//			//System.out.println("IN Sample Sent(getDrugNameCmb)vo.getStrHospitalCode():::"+vo.getStrHospitalCode());
//			//System.out.println("IN Sample Sent(getDrugNameCmb)vo.getStrStoreId():::"+vo.getStrStoreId());
//			//System.out.println("IN Sample Sent(getDrugNameCmb)vo.getStrReSendFlg():::"+vo.getStrReSendFlg());
						
			  		
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemCatg", "0");
			daoObj.setProcInValue(nProcIndex, "reSendFlg", vo.getStrReSendFlg());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setIndentItemWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getDrugNameCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	/**
	 * INSERT method is used to insert value in two table
	 * HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * @param vo
	 */

	public static void INSERT(SampleSentTransVO vo) 
	{
		/* Declaring Variable */ 
			
		String   strProcName3 = "";
		int       nProcIndex3 = 0;
		int funcIndex = 0 ;
		String strTempLabSendNo;
		HisDAO         daoObj = null;
		boolean flag = false;
		
    	try 
		{
    		daoObj = new HisDAO("MMSModule","SampleSentTransDAO.INSERT()");
      		/* Calling function to get Breakage No  */
       		funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_LabSend_no(?,?,?,?,?,?)}");
  		    /* Set Value */
       		daoObj.setFuncInValue(funcIndex,2,"1");
       		daoObj.setFuncInValue(funcIndex,3,vo.getStrLabId().split("\\^")[0]);
       		daoObj.setFuncInValue(funcIndex,4,"73");
       		daoObj.setFuncInValue(funcIndex,5,vo.getStrStoreId());
       		daoObj.setFuncInValue(funcIndex,6,vo.getStrItemCatg());
       		daoObj.setFuncInValue(funcIndex,7,vo.getStrHospitalCode());
       		daoObj.setFuncOutValue(funcIndex,1);
  		    /* Execute Function */
       		daoObj.executeFunction(funcIndex);
  			  			 			
  			strTempLabSendNo = daoObj.getFuncString(funcIndex);  
  			vo.setStrLabSendNo(strTempLabSendNo);
  			
  			/*
                              0                                        1
	            NVL(A.HSTNUM_INHAND_QTY,'''')||''^''||Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID)||''^''||
	                           2                                                          3                       
	            NVL(TO_CHAR(A.HSTDT_MANUF_DATE,''DD-Mon-YYYY''),'''')||''^''||NVL(TO_CHAR(A.HSTDT_EXPIRY_DATE,''DD-Mon-YYYY''),'''')||''^''||
	              --------------------      4   ----------------------------------                              
	            NVL(A.HSTNUM_PO_NO,'''')||''/''||NVL(TO_CHAR(A.HSTDT_PO_DATE,''DD-Mon-YYYY''),'''')||''^''||
	                                          5                                                  6
	            Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_SUPPLIED_BY) ||''^''||A.HSTNUM_ITEM_ID
	                            7                                    8                     9                               10     
	            ||''^''||HSTNUM_STOCK_STATUS_CODE||''^''||HSTNUM_INHAND_QTY||''^''|| HSTNUM_INHAND_QTY_UNITID  ||''^''|| HSTNUM_RATE  ||''^''||
	                11                            12                           13                        
	            HSTNUM_RATE_UNITID  ||''^''|| HSTDT_MANUF_DATE   ||''^''|| HSTDT_EXPIRY_DATE    ||''^''||
                    14                             15                          16                       17                18      19          20
	            HSTNUM_SUPPLIER_ID  ||''^''|| HSTNUM_SUPPLIED_BY   ||''^''|| HSTNUM_PO_NO    ||''^''|| HSTDT_PO_DATE ^ BATCH_NO^ITEM_BRND^STORE_ID
			 */
  			    strProcName3 = "{call PKG_MMS_DML.proc_HSTT_QC_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 44 Varibale's
 			 			    
		        nProcIndex3 = daoObj.setProcedure(strProcName3);								
				daoObj.setProcInValue(nProcIndex3, "p_mode", "1");                                    	     //1
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_ID", vo.getStrHiddenBatchDtl().split("\\^")[6]);          	     //2
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID",vo.getStrHiddenBatchDtl().split("\\^")[20]);  	     //3
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_SEND_NO", strTempLabSendNo);            	         //4
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId());            	     //5
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_SL_NO",vo.getStrBatchNo());        	     //6
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_LAB_SEND_DATE",vo.getStrCtDate());              //7
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_ITEM_SL_NO","0");    		 //8
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_REPORT_DATE","");      	 	 //9   AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STOCK_STATUS_CODE",vo.getStrHiddenBatchDtl().split("\\^")[7]);         		 //10
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_NO",vo.getStrLabId().split("\\^")[0]);    	  	 //11
				daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",	vo.getStrHospitalCode());         		 //12
				daoObj.setProcInValue(nProcIndex3, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCategoryCode());  	 		//13
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY",vo.getStrHiddenBatchDtl().split("\\^")[8]);      	 //14
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY_UNITID",vo.getStrHiddenBatchDtl().split("\\^")[9]); 	 //15
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY",vo.getStrSampleIssueQty());       				   //16
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY_UNITID",vo.getStrSampleUnitId().split("\\^")[0]);    				 //17
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PO_NO", vo.getStrHiddenBatchDtl().split("\\^")[16]);     //18
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE",vo.getStrHiddenBatchDtl().split("\\^")[10]);   //19
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_PO_DATE",vo.getStrHiddenBatchDtl().split("\\^")[17]); //20
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",vo.getStrHiddenBatchDtl().split("\\^")[11]); 			//21
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_MFG_DATE",vo.getStrHiddenBatchDtl().split("\\^")[12]);			 //22
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",vo.getStrHiddenBatchDtl().split("\\^")[15]); 				//23
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_MANUFACTURER_ID",vo.getStrHiddenBatchDtl().split("\\^")[14]); 				//24
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE",vo.getStrHiddenBatchDtl().split("\\^")[13]); //25
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FINAL_RESULT",""); //26  AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_STATUS","1"); 			//27  AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_SAMPLE_CODE_NO",vo.getStrSampleCodeNumber());			 //28
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_CTR_NO","0"); 				//29
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_START_DATE",vo.getStrFinancialStartYear()); 				//30
				daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_END_DATE",vo.getStrFinancialEndYear()); //31
				daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE",vo.getStrCtDate()); 				//32
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_ONLINE_PROCESS","1"); //33
				daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId()); //34
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_LAB_INCHARGE_NAME",""); 				//35  AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID","1"); //36
				daoObj.setProcInValue(nProcIndex3, "p_GSTR_SEND_REAMRKS",vo.getStrRemarks()); //37
				daoObj.setProcInValue(nProcIndex3, "p_GSTR_RECEIVE_REAMRKS",""); 				//38
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NO",""); //39    AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PAGE_NO",""); 				//40    AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_RESEND",vo.getStrReSendFlg()); //41
				daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NAME",""); //42       AS Per As CRD
				daoObj.setProcInValue(nProcIndex3, "p_description",vo.getStrDescription()); //43				
				daoObj.setProcOutValue(nProcIndex3, "err", 1);                         //44
				daoObj.execute(nProcIndex3, 1);
			
			
			/* Here we Execute procedure in Batch */
			synchronized(daoObj)   
			{
				daoObj.fire();     
				flag = true;
			}
			if(flag)
			{
				SampleSentTransDAO.updateCurrStock(vo);
			}
		} 
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
    		vo.setStrMsgString("--> SampleSentTransDAO.INSERT()-->"	+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}
	
	
	/**
	 * INSERT method is used to insert value in two table
	 * HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * @param vo
	 */

	public synchronized static void INSERT1(SampleSentTransVO vo) 
	{
		/* Declaring Variable */ 
			
		String   strProcName3 = "";
		int       nProcIndex3 = 0;
		int funcIndex = 0 ;
		String strTempLabSendNo;
		HisDAO         daoObj = null;
		boolean flag = false;
		int labSendNo = 0;

		int         length = 0;
		int          index = 0;

		String[]      temp = null;
		String[]   strTemp = null;
		String[]   strTemp1 = null;

		
    	try 
		{
    		    daoObj = new HisDAO("MMSModule","SampleSentTransDAO.INSERT()");
  			    strProcName3 = "{call PKG_MMS_DML.proc_HSTT_QC_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 44 Varibale's
 			 			    
		        nProcIndex3 = daoObj.setProcedure(strProcName3);
		        
		        length = vo.getItemParamValue().length;
		        
//		       //System.out.println("Length==>"+length);
				
	 			for(int i = 0;i<length;i++)
				{
	 				
	 				if(!vo.getStrNewSampleIssueQty()[i].equals("0"))
					{
//			    	//System.out.println("Req Qty:::"+vo.getStrReqQty()[i]);
//			    	//System.out.println("Issue Qty:::"+vo.getStrIssueQty()[i]);
//			    	//System.out.println("Per Item Cost:::"+vo.getStrCost()[i]);
	 				
					temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
					
//					//System.out.println("Display Value-->>>>"+temp[0]);
//					//System.out.println("Conversion  Value-->>>>"+temp[1]);
//					//System.out.println("User  Value-->>>>"+temp[2]);
				    
					strTemp          = temp[2].replace('^', '#').split("#");
//					strTemp1         = temp[1].replace('^', '#').split("#");
					
//					//System.out.println("------------------Start--PROC TWO--OrignalOffLineIssue Indent--------------------------");
//					//System.out.println("ItemID-1->>"+strTemp[0]);
//					//System.out.println("ItemBrandID-2->>"+strTemp[1]);
//					//System.out.println("GrpID-3->>"+strTemp[3]);
//					//System.out.println("Sub_GrpID-4->>"+strTemp[4]);
//					//System.out.println("Cosumble Flg-5->>"+strTemp[5]);
//					//System.out.println("In Hand Qty-6->>"+strTemp[7]);
//					//System.out.println("In Hand Qty Unit Id-7->>"+strTemp[8]);
//					//System.out.println("Last Rate-8->>"+strTemp[9]);
//					//System.out.println("Last Rate Unit Id [Mode = 3, it will be actual rate unit id]==>"+strTemp[10]);
//					//System.out.println("Last Rate Unit Id-9->>"+strTemp[34]);
//					//System.out.println("Inventory Unit Id-10->>"+strTemp[11]);
//					//System.out.println("Last PO No-11->>"+strTemp[12]);
//					//System.out.println("Last PO Date-12->>"+strTemp[13]);
//					//System.out.println("Last Supplied By [Id]-13->>"+strTemp[14]);
//					//System.out.println("Batch No-14->>"+strTemp[15]);
//					//System.out.println("Expiry Date-15->>"+strTemp[16]);
//					//System.out.println("Manufacture Date-16->>"+strTemp[18]);
//					//System.out.println("Item Serial No-17->>"+strTemp[18]);
//					//System.out.println("Prefix-18->>"+strTemp[27]);
//					//System.out.println("Cost Parameter-19->>"+strTemp[28]);
//					//System.out.println("Cost Unit [on individual item or on total cost]-20->>"+strTemp[11]);
//					//System.out.println("Stock Status-21->>"+strTemp[32]);
//					//System.out.println("Brand reserv Flag-24->>"+strTemp[35]);
//					//System.out.println("------------------End--PROC TWO--OrignalOffLineIssue Indent--------------------------");
					daoObj.setProcInValue(nProcIndex3, "p_mode", "1");                                    	     //1
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_ID", strTemp[0]);          	     //2
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID",vo.getStrStoreId());  	     //3
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_SEND_NO",  "0");            	         //4
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",strTemp[1]);            	     //5
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_SL_NO",strTemp[15]);        	     //6
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_LAB_SEND_DATE",vo.getStrCtDate());              //7
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_ITEM_SL_NO","0");    		 //8
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_REPORT_DATE","");      	 	 //9   AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STOCK_STATUS_CODE",strTemp[32]);         		 //10
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_NO",vo.getStrLabId().split("\\^")[0]);    	  	 //11
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",	vo.getStrHospitalCode());         		 //12
					daoObj.setProcInValue(nProcIndex3, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCategoryCode());  	 		//13
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY",strTemp[7]);      	 //14
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY_UNITID",strTemp[8]); 	 //15
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY",vo.getStrNewSampleIssueQty()[i]);       				   //16
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY_UNITID",strTemp[8]);    				 //17
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PO_NO", (strTemp[12]==null || strTemp[12].equals("") || strTemp[12].equals("---"))?"0":strTemp[12]);     //18
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE",strTemp[9]);   //19
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_PO_DATE",(strTemp[13]==null || strTemp[13].equals("") || strTemp[13].equals("---"))?"":strTemp[13]); //20
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",strTemp[10]); 			//21
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_MFG_DATE",(strTemp[17]==null || strTemp[17].equals("") || strTemp[17].equals("0") || strTemp[17].equals("---"))?"":strTemp[17]);			 //22
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",strTemp[14]); 				//23
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_MANUFACTURER_ID","0"); 				//24
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE",strTemp[16]); //25
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FINAL_RESULT",""); //26  AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_STATUS","1"); 			//27  AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_SAMPLE_CODE_NO",vo.getStrNewSampleCodeNumber()[i]);			 //28
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_CTR_NO","0"); 				//29
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_START_DATE",vo.getStrFinancialStartYear()); 				//30
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_END_DATE",vo.getStrFinancialEndYear()); //31
					daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE",vo.getStrCtDate()); 				//32
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_ONLINE_PROCESS","1"); //33
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId()); //34
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_LAB_INCHARGE_NAME",""); 				//35  AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID","1"); //36
					daoObj.setProcInValue(nProcIndex3, "p_GSTR_SEND_REAMRKS",vo.getStrRemarks()); //37
					daoObj.setProcInValue(nProcIndex3, "p_GSTR_RECEIVE_REAMRKS",""); 				//38
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NO",""); //39    AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PAGE_NO",""); 				//40    AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_RESEND",vo.getStrReSendFlg()); //41
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NAME",""); //42       AS Per As CRD
					daoObj.setProcInValue(nProcIndex3, "p_description",vo.getStrDescription()); //43				
					daoObj.setProcOutValue(nProcIndex3, "err", 1);                         //44
					daoObj.execute(nProcIndex3, 1);					
					
					
					}
	 			}
		        
			
			
			/* Here we Execute procedure in Batch */
			//(daoObj)   
			//{
				daoObj.fire();     
				
			//}
		} 
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
    		vo.setStrMsgString("--> SampleSentTransDAO.INSERT()-->"	+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}
	
	
	/**
	 * INSERT method is used to insert value in two table
	 * HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * @param vo
	 */

	public synchronized static void CANCELRECORDS(SampleSentTransVO vo) 
	{
		/* Declaring Variable */ 
			
		String   strProcName3 = "";
		int       nProcIndex3 = 0;
		HisDAO         daoObj = null;
	
    	try 
		{
    		    daoObj = new HisDAO("MMSModule","SampleSentTransDAO.INSERT()");
  			    strProcName3 = "{call PKG_MMS_DML.dml_iss_sample_lab_cancel_dtl(?,?,?,?,?,?,?)}";// 7 Varibale's   	        
		        nProcIndex3 = daoObj.setProcedure(strProcName3);   
		        
		        /*
				 1- Item Id
				 2- Lab Sent Date
				 3- Sent Store Name
				 4- Generic Name
				 5-Brand Name
				 6- Batch
				 7-Exp Date
				 8-Transfer Qty
				 9-Store Id Sent
				 10-Item Id
				 11-Item Brand ID
				 12-Rate With Unit
				 13-Rate Base value
				 14-Consumed Qty
				 15=Consumed Qty Wit Unit
				 16-Qty Base Value
				 17-Item Sl No
				 18-Item Sl No
				 19-Catg Code
				 20- Lab Send No
				 21-Lab Name
				 22-CTR Number
				 23-Net Cost
				 24-PO No
				 25-PO Date
				 26-Mfd Date
				 27-Is Send Decode Value
                28-Lab No
                29-Manufacter By
                30.QC Status
                31. Report Date
                32.Seceret Code No.
                33.REPORT PENDING/RECEIVED (RP Stand for Report Pending / RR Report Received)
                34.Index
              */
		        for(int i=0;i<vo.getStrCheckHidValue().length;i++)
				{
		        	
					if(vo.getChkFlg()[i].equals("1"))
					{
//						//System.out.println("Store Id==>"+vo.getStrCheckHidValue()[i].split("\\^")[8]);
//						//System.out.println("p_HSTNUM_LAB_SEND_NO==>"+vo.getStrCheckHidValue()[i].split("\\^")[19]);
//						//System.out.println("Remarsk==>"+vo.getStrRemarks());
//						//System.out.println("Batch No==>"+vo.getStrCheckHidValue()[i].split("\\^")[5]);
//						//System.out.println("Secret Code==>"+vo.getStrCheckHidValue()[i].split("\\^")[31]);
						daoObj.setProcInValue(nProcIndex3, "p_mode", "1");                             	     //1
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID", vo.getStrCheckHidValue()[i].split("\\^")[8]);          	     //2
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_SEND_NO",vo.getStrCheckHidValue()[i].split("\\^")[19]);	     //3
						daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode());  //4
						daoObj.setProcInValue(nProcIndex3, "p_GSTR_REMARKS",vo.getStrRemarks());            	     //5
						daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId());        	         //6
						daoObj.setProcOutValue(nProcIndex3, "err", 1);                                       //7
						daoObj.execute(nProcIndex3, 1);		
					}
				}
				daoObj.fire();     
				
		
		} 
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
    		vo.setStrMsgString("--> SampleSentTransDAO.CANCELRECORDS()-->"	+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}
	
	
	public static void updateCurrStock(SampleSentTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		try 
		{
			dao = new HisDAO("mms", "SampleSentTransDAO");
			strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?,?,?,?,?,?,?)}"; // 11 variables
   
			
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex,  "modval", "2");                 //1
			dao.setProcInValue(nprocIndex,  "strid", vo.getStrStoreId());   //2
			dao.setProcInValue(nprocIndex,  "itemid", vo.getStrHiddenBatchDtl().split("\\^")[6]);   //3
			dao.setProcInValue(nprocIndex,  "itembrandid", vo.getStrItemBrandId());//4
			dao.setProcInValue(nprocIndex,  "batchno", vo.getStrBatchNo());        //5
			dao.setProcInValue(nprocIndex,  "hosp_code", vo.getStrHospitalCode()); //6
			dao.setProcInValue(nprocIndex,  "item_cat_no", vo.getStrItemCategoryCode());//7
			dao.setProcInValue(nprocIndex,  "stockstatuscode", vo.getStrHiddenBatchDtl().split("\\^")[7]);        //8
			dao.setProcInValue(nprocIndex,  "rackNumber", "");//9
			dao.setProcInValue(nprocIndex,  "old_itemserialno", "0");//10
			dao.setProcOutValue(nprocIndex, "err", 1);//11
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("SampleSentTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	/**
	 * GROUPNAMECOMBO(vo) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	
	public static void getStoreGroupList(SampleSentTransVO vo) 
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
				
			hisutil    = new HisUtil("mms", "SampleSentTransDAO");
			dao = new HisDAO("mms", "SampleSentTransDAO.getItemParameters(SampleSentTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "2");

			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCatNo());

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());
			
			/* Start */
			dao.setProcInValue(procIndex1, "strPhyStockNo", "");
			dao.setProcInValue(procIndex1, "strStoreId", "");
			/* End */

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");
			
			

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			
			
			if(ws!=null)
			{
				str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);					
			}	
			else
			{
				str = "<option value='0'>DATA N/A</option>";  
				vo.setStrGroupIdForItemSearch(str);
			}	
			
			

		} catch (Exception e)
		{
			
			vo.setStrMsgString("SampleSentTrans.getStoreGroupList() --> "
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
	 * STORENAMECOMBO(vo) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	public static WebRowSet STORENAMECOMBO(SampleSentTransVO vo)
	{
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		HisDAO dao = null;
			
		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMSModule",
					"transactions.SampleSentTransDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "modeval", "1");

			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());

			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());

			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId());
			
			dao.setProcInValue(nprocIndex, "storetype_id", vo.getStrStoreTypeId());
			
			
			dao.setProcOutValue(nprocIndex, "err", 1); // 1 for string return

			dao.setProcOutValue(nprocIndex, "resultset", 2); // 2 for object
			// execute procedure

			dao.executeProcedure(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}

		}

		catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("-->SampleSentTransDAO.STORENAMECOMBO()"
							+ e.getMessage());

			vo.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

		return ws;
	}
	
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(SampleSentTransVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			hisutil = new HisUtil("MMSModule", "SampleSentTransDAO");
			daoObj  = new HisDAO("MMSModule","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType","56");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, "","", true);
					vo.setStrItemCatgCombo(str);
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrItemCatgCombo(str);
				}	
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	/**
	 * This function is used to set details in approved By Combo. 
	 * @param _SampleSentTransVO
	 */
	public static void getApprovedByCombo(SampleSentTransVO _SampleSentTransVO)
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj  = new HisDAO("MMSModule","SampleSentTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
					
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", _SampleSentTransVO.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", _SampleSentTransVO.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex,"err",1); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2);
			// Execute Procedure
			daoObj.executeProcedure(nProcIndex);
			
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				_SampleSentTransVO.setApprovedByWS(ws);
			}
		}
		catch(Exception _err)
		{
			_SampleSentTransVO.setStrMsgString("SampleSentTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			_SampleSentTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to set details in view page(Brakage Item Dtl). 
	 * @param _SampleSentTransVO
	 */
	public static void getViewDtl(SampleSentTransVO _SampleSentTransVO)
	{
		
		String strProcName = "{call pkg_mms_view.proc_breakkage_Item_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			////System.out.println("Welcome to View Dtl");
			daoObj  = new HisDAO("MMSModule","SampleSentTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println( "modeval"+ "1");
//			//System.out.println( "hosp_code"+ _SampleSentTransVO.getStrHospitalCode());
//			//System.out.println( "strId"+ _SampleSentTransVO.getStrStoreName());
//			//System.out.println( "itemCategNo"+ _SampleSentTransVO.getStrItemCatgCombo());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", _SampleSentTransVO.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strId", _SampleSentTransVO.getStrStoreName());
			daoObj.setProcInValue(nProcIndex, "itemCategNo", _SampleSentTransVO.getStrItemCatgCombo());
			daoObj.setProcInValue(nProcIndex, "start_date", _SampleSentTransVO.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "end_date", _SampleSentTransVO.getStrToDate());
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				_SampleSentTransVO.setBreakageItemWS(ws);
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			_SampleSentTransVO.setStrMsgString("SampleSentTransDAO.getViewDtl() --> "
					+ _err.getMessage());
			_SampleSentTransVO.setStrMsgType("1");
		}
	}
}
	


