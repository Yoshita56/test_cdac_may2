package mms.transactions.dao;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.HsttBreakageDtlDAO;
import mms.dao.HsttBreakageItemDtlDAO;
import mms.transactions.vo.BreakageItemDtlTransVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
 *  
*/
public class BreakageItemDtlTransDAO
{
	
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(BreakageItemDtlTransVO vo) 
	{
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	
		try 
		{
			hisutil = new HisUtil("MMS", "BreakageItemDtlTransDAO");
			wb      = STORENAMECOMBO(vo);
			if(wb!= null)
			{	
			   if(wb.next())
			   {
				   vo.setStrStoreId(wb.getString(1));
				   wb.beforeFirst();
			   }
				str1 = hisutil.getOptionValue(wb, "","", true);
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
			vo.setStrMsgString("--> BreakageItemDtlTransDAO.GetData()-->"+ e.getMessage());
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
	 * INSERT method is used to insert value in two table
	 * HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * @param vo
	 */

	public synchronized static void INSERT(BreakageItemDtlTransVO vo) 
	{
		HisDAO dao = null;
		
	    String[] temp = null;
		String[] temp1 = null;
		String[] temp2 = null;
		String[] strTemp = null;
		String strItemId = null;
		String strItemBrandId  = null;
		String strBatchNo = null;
		
		String strExpDate = null;
		
		String strInHandQty = null;
		String strInhandQtyPUnitID = null;
		String strGrpId = null;
		String strSubGrpId = null;
		String strItemSlNo="";
		String strConsumableFlag="";
		String strStockStaus="";
		String RateId     = null;
		String RateUnitId = null;
		String strTempBkgNo = null;
		int funcIndex = 0 ;
		
		HsttBreakageDtlDAO       BkgDtl     =  new HsttBreakageDtlDAO();
		HsttBreakageItemDtlDAO   BkgItemDtl =  new HsttBreakageItemDtlDAO();
		
    	try 
		{
      		dao = new HisDAO("MMS","BreakageItemDtlTransDAO.INSERT()");
      		
       		funcIndex = dao.setFunction("{? = call MMS_MST.generate_breakageitem_No(?,?,?,?,?)}");
  		    
       		dao.setFuncInValue(funcIndex,2,"1");
       		dao.setFuncInValue(funcIndex,3,"56");
       		dao.setFuncInValue(funcIndex,4,vo.getStrStoreName());
       		dao.setFuncInValue(funcIndex,5,vo.getStrItemCatgCombo());
  			dao.setFuncInValue(funcIndex,6,vo.getStrHospitalCode());
  			dao.setFuncOutValue(funcIndex,3);
  		    
  			dao.executeFuncForNumeric(funcIndex);
  			
  			strTempBkgNo = dao.getFuncNumeric(funcIndex);   
  			//System.out.println("X4");
  			
  			temp2 = vo.getStrStoreName().replace('^', '#').split("#");
    		
  			String storeId  = temp2[0];
  			//System.out.println("X5");

  			 BkgDtl.setStrHospCode(vo.getStrHospitalCode());
			 BkgDtl.setStrHstdtBkgDate(vo.getStrBkgEntryDate());
			 BkgDtl.setStrHstnumBkgNo(strTempBkgNo);
			 BkgDtl.setStrSstNumItemCatNo(vo.getStrItemCatgCombo());
			 BkgDtl.setStrHstNumFEndYear(vo.getStrFinancialEndYear());
			 BkgDtl.setStrHstNumFStartYear(vo.getStrFinancialStartYear());
			 BkgDtl.setStrHstNumStatus("1");
			 BkgDtl.setStrHstNumStoreId(storeId);
			 BkgDtl.setStrRemarks(vo.getStrRemarks());
			 BkgDtl.setStrSeatId(vo.getStrSeatId());
			 BkgDtl.setStrApprovedBy(vo.getStrApprovedBy());
			 BkgDtl.setStrApprovedDate(vo.getStrApprovedDate());
			 BkgDtl.setStrApprovedRemarks(vo.getStrAprovedRemarks());
			 BkgDtl.setStrNetCost(vo.getStrApproxAmt());
			 BkgDtl.setStrType(vo.getStrTypeMode());
			 //System.out.println("X6");
			 BkgDtl.insert(dao);
			 //System.out.println("X7");
     		int length = vo.getItemParamValue().length;
     		
			for(int i = 0;i<length;i++)
			{
				if(vo.getStrUnitName()[i].equals("0"))
				{	
					RateId     = "0";
					RateUnitId = "0";
				}
				else
				{
					temp1 = vo.getStrUnitName()[i].replace('^', '#').split("#");
					//System.out.println("X8");
					RateId     = temp1[1];
					RateUnitId = temp1[0];
				}	
				
				temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
				//System.out.println("X9");
				strTemp         = temp[2].replace('^', '#').split("#");
				strItemId       = strTemp[0];
				strItemBrandId  = strTemp[1];
				//System.out.println("X10");
				 strItemId                 = strTemp[0];
				 strItemBrandId            = strTemp[1];
        	   	 strBatchNo                = strTemp[15];
				 strExpDate                = strTemp[16];
				 RateId					  =	 strTemp[9];
		//		 strRateUnitId             = strTemp[10];
				 strGrpId                  = strTemp[2];
				 //System.out.println("X11");
				 strSubGrpId               = strTemp[3];
				 strItemSlNo			   = strTemp[18];
				 strInHandQty	  		   = strTemp[7];
				 strInhandQtyPUnitID       = strTemp[8];
				 strConsumableFlag		   = strTemp[4];			
		//		 strItemCost			   = strTemp[29];
				 strStockStaus				=strTemp[32];
				
				
				 BkgItemDtl.setStrHstnumBkgNo(strTempBkgNo);
				 BkgItemDtl.setStrHstNumItemId(strItemId);
				 BkgItemDtl.setStrHstNumItemBrandId(strItemBrandId);  
				 BkgItemDtl.setStrHstTstrBatchSlNo(strBatchNo);
				 BkgItemDtl.setStrHospCode(vo.getStrHospitalCode());
				 BkgItemDtl.setStrHstdtBkgDate(vo.getStrBkgEntryDate());
				 BkgItemDtl.setStrHstNumGrpId(strGrpId);
				 BkgItemDtl.setStrHstNumSubGrpId(strSubGrpId);
				 BkgItemDtl.setStrHstNumInHandQty(strInHandQty);
				 BkgItemDtl.setStrHstNumInHandQtyUnitId(strInhandQtyPUnitID);
				 BkgItemDtl.setStrHstNumRate(RateId);
				 BkgItemDtl.setStrHstNumRateUnitId(strTemp[10]);
				 BkgItemDtl.setStrHstNumBkgQty(vo.getStrBkgQty()[i]);
				 BkgItemDtl.setStrHstNumBkgQtyUnitId(RateUnitId);
				 BkgItemDtl.setStrHsTdtExpiryDate(strExpDate);
				 BkgItemDtl.setStrGstrRemarks(vo.getStrRemarks());
				 BkgItemDtl.setStrStrId(vo.getStrStoreName());	
				 BkgItemDtl.setItemSlNo(strItemSlNo);
				 BkgItemDtl.setStrConsumableFlag(strConsumableFlag);
				 BkgItemDtl.setStrItemCost(vo.getStrCostFinal()[i]);
				 BkgItemDtl.setStrSeatId(vo.getStrSeatId());
				 BkgItemDtl.setStrItemCatNo(vo.getStrItemCatgCombo());
				 BkgItemDtl.setStrStockStatus(strStockStaus);
				 //System.out.println("X12");
				 BkgItemDtl.insert(dao);
				 //System.out.println("X13");
			
			}
			synchronized(dao)   
			{
				//System.out.println("X14");
				dao.fire();
				//System.out.println("X15");
			}
		} 
    	catch (Exception e) 
    	{
    	    vo.setStrMsgString("--> BreakageItemDtlTransDAO.INSERT()-->"	+ e.getMessage());
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
	 * GROUPNAMECOMBO(vo) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	
	public static void getStoreGroupList(BreakageItemDtlTransVO vo) 
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
			hisutil    = new HisUtil("MMS", "BreakageItemDtlTransDAO");
			dao = new HisDAO("MMS", "BreakageItemDtlTransDAO.getItemParameters(BreakageItemDtlTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCatNo());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "strPhyStockNo", "");
			dao.setProcInValue(procIndex1, "strStoreId", "");
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			dao.executeProcedure(procIndex1);

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
		} 
		catch (Exception e)
		{
			vo.setStrMsgString("BreakageItemDtlTrans.getStoreGroupList() --> "+ e.getMessage());
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
	 * STORENAMECOMBO(vo) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	public static WebRowSet STORENAMECOMBO(BreakageItemDtlTransVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";		
		HisDAO dao = null;			
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;

		try 
		{
			dao = new HisDAO("MMS","transactions.BreakageItemDtlTransDAO.STORENAMECOMBO(VO)");
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "11",1);
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "storetype_id", vo.getStrStoreTypeId(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);

			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";
			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} 
			else 
			{
				throw new Exception(strerr);
			}
		}
		catch (Exception e) 
		{
			vo.setStrMsgString("-->BreakageItemDtlTransDAO.STORENAMECOMBO()"+ e.getMessage());
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
		return ws;
	}
	
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(BreakageItemDtlTransVO vo)
	{
		System.out.println("for local purchase3");
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			hisutil = new HisUtil("MMS", "BreakageItemDtlTransDAO");
			daoObj  = new HisDAO("MMS","BreakageItemDtlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType","56",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
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
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("BreakageItemDtlTransDAO.itemCategoryCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	/**
	 * This function is used to set details in approved By Combo. 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getApprovedByCombo(BreakageItemDtlTransVO _BreakageItemDtlTransVO)
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","BreakageItemDtlTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
					
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId", _BreakageItemDtlTransVO.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _BreakageItemDtlTransVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);

			daoObj.executeProcedureByPosition(nProcIndex);			
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if(strErr.equals(""))
			{
				_BreakageItemDtlTransVO.setApprovedByWS(ws);
			}
		}
		catch(Exception _err)
		{
			_BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransDAO.getApprovedByCombo() --> "+ _err.getMessage());
			_BreakageItemDtlTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to set details in view page(Brakage Item Dtl). 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getViewDtl(BreakageItemDtlTransVO _BreakageItemDtlTransVO)
	{
		
		String strProcName = "{call pkg_mms_view.proc_breakkage_Item_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","BreakageItemDtlTransDAO");			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _BreakageItemDtlTransVO.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "strId", _BreakageItemDtlTransVO.getStrStoreName(),3);
			daoObj.setProcInValue(nProcIndex, "itemCategNo", _BreakageItemDtlTransVO.getStrItemCatgCombo(),4);
			daoObj.setProcInValue(nProcIndex, "start_date", _BreakageItemDtlTransVO.getStrFromDate(),5);
			daoObj.setProcInValue(nProcIndex, "end_date", _BreakageItemDtlTransVO.getStrToDate(),6);
			daoObj.setProcOutValue(nProcIndex, "err",1,7); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,8);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if(strErr.equals(""))
			{
				_BreakageItemDtlTransVO.setBreakageItemWS(ws);
			}
		}
		catch(Exception _err)
		{
			_BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransDAO.getViewDtl() --> "	+ _err.getMessage());
			_BreakageItemDtlTransVO.setStrMsgType("1");
		}
	}
}