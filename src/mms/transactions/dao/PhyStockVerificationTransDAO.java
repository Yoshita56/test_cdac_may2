package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.CommitteRemarksDtlDAO;
import mms.transactions.vo.PhyStockVerificationTransVO;

public class PhyStockVerificationTransDAO {
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getGroupCmb(PhyStockVerificationTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrGrpMode(),1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex, "item_category", "1",3);
				daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
				daoObj.setProcInValue(nProcIndex, "strStoreId", voObj.getStrStoreId(),5);
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
				e.printStackTrace();
				voObj
						.setStrMsgString("PhyStockVerificationTransDAO.getGroupCmb() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}

	
	public static void getItemSearchGroupCmb(PhyStockVerificationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCategoryId(),3);
			daoObj.setProcInValue(nProcIndex, "strStoreId", voObj.getStrStoreId(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);// Default Value
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setWsItemSearchGroupList(ws);
								
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("PhyStockVerificationTransDAO.getItemSearchGroupCmb() --> "
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
	 * GROUP LIST
	 */
	public static void getBrandCmb(PhyStockVerificationTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_mms_view.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "item_id", voObj.getStrItemValId());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex, "catCode", "0");
				daoObj.setProcInValue(nProcIndex, "grpId", "0");
				daoObj.setProcInValue(nProcIndex, "subGrpId", "0");
				daoObj.setProcInValue(nProcIndex, "setFlag", "0");
				/* Setting Default Value End */
				
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrBrandWs(ws);
					
				} else {
					throw new Exception(strErr);
				}
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("PhyStockVerificationTransDAO.getBrandCmb() --> "
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
	 * UNIT LIST
	 */
	public static void getUnitCmb(PhyStockVerificationTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_mms_view.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrUnitValId());
				daoObj.setProcInValue(nProcIndex, "module_id", "1");
				
				daoObj.setProcInValue(nProcIndex, "modeval", "1"); // Default Value
				
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrUnitWs(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("PhyStockVerificationTransDAO.getUnitCmb() --> "
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
	 * GROUP LIST
	 */
	public static void getItemDtl(PhyStockVerificationTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;
			
			String strProcName = "{call pkg_mms_view.proc_Hstt_Phystock_Item_Dtl(?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "1");
				daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId());
				daoObj.setProcInValue(nProcIndex, "group_Id", voObj.getStrGroupId());
				daoObj.setProcInValue(nProcIndex, "frmRows", voObj.getStrFromRow());
				daoObj.setProcInValue(nProcIndex, "toRows", voObj.getStrToRow());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrItemDtlWs(ws);
				} else {
					throw new Exception(strErr);
				}
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("PhyStockVerificationTransDAO.getItemDtl() --> "
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
	 * GROUP LIST
	 */
	public static void getNewItemDtl(PhyStockVerificationTransVO voObj) {
	
			HisDAO daoObj = null;
			WebRowSet ws = null;
			String strProcName = "{call pkg_mms_view.proc_Item_Count_Dtls(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";
	
			try {
				daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");
	
				nProcIndex = daoObj.setProcedure(strProcName);
		
				daoObj.setProcInValue(nProcIndex, "modval", "1");
				daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId());
				daoObj.setProcInValue(nProcIndex, "group_id", voObj.getStrGroupId());
				daoObj.setProcInValue(nProcIndex, "item_id", voObj.getStrItemId());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);
	
				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
	
				if (strErr.equals("")) {
	
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrNewItemDtlWs(ws);
				} else {
					throw new Exception(strErr);
				}
			} catch (Exception e) {
				e.printStackTrace();
				voObj
						.setStrMsgString("PhyStockVerificationTransDAO.getNewItemDtl() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");
	
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
	
	
	public static void getPhysicalStockVerifiedCount(PhyStockVerificationTransVO voObj) {

		int nFuncIndex = 0;
		
		String strFuncName = "";
		String strCount = "0";

		HisDAO daoObj = null;
	
		try {
			daoObj = new HisDAO("mms", "PhyStockVerificationTransDAO");
			strFuncName = "{? = call Mms_Mst.get_phystockVerify_count(?, ?, ?)}";
			
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrItemCategoryId());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrStoreId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			
			daoObj.executeFunction(nFuncIndex);
			strCount = daoObj.getFuncString(nFuncIndex);

			voObj.setStrPhysicalCount(strCount);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("PhyStockVerificationTransDAO.getPhysicalStockVerifiedCount() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getPhysicalStockDateDtls(PhyStockVerificationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_phystockVerifyDates_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "itemCat", voObj.getStrItemCategoryId(),2);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),4);		
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				if(ws != null && ws.size() > 0){
					
					if(ws.next()){
						
					//	//System.out.println("FinancialStartDate :"+ws.getString(1));
					//	//System.out.println("LastVerifiedDate :"+ws.getString(2));
						voObj.setStrFinancialStartDate(ws.getString(1));
						voObj.setStrLastVerifiedDate(ws.getString(2));
					}
					
				}
				
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			voObj
					.setStrMsgString("PhyStockVerificationTransDAO.getPhysicalStockDateDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getPhysicalStockCountedItemsDtls(PhyStockVerificationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_phystock_view(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "3");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strGroupId", voObj.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "strStoreId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", voObj.getStrPhysicalStockNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
								
				voObj.setWsCountedItemsList(ws);
				
				
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			voObj
					.setStrMsgString("PhyStockVerificationTransDAO.getPhysicalStockCountedItemsDtls() --> "
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
	 * This function is used to insert data into database
	 * @param _PhyStockVerificationTransVO
	 */
		public static void insert(PhyStockVerificationTransVO _PhyStockVerificationTransVO) {
			
			HisDAO dao = null;
		
			int procIndex1 = 0;
			int procIndex2 = 0;
			int funcIndex=0;
			int length=0;
			String []temp=null;
			String []batchItem=null;
			String []batchTemp=null;
		
			String phyStockNo="";
			String proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_DTL(?,?,?,?,?,?,?,?,?)}";
			try
			{
				dao = new HisDAO("MMS Transactions","PhyStockVerificationTransDAO");
				
				
				if(_PhyStockVerificationTransVO.getStrPrevCountedFlag().equals("0")){
					
					funcIndex = dao.setFunction("{? = call MMS_MST.generate_phyStockNo(?,?,?,?)}");
					dao.setFuncInValue(funcIndex, 2, _PhyStockVerificationTransVO.getStrHospitalCode());
					dao.setFuncInValue(funcIndex, 3, _PhyStockVerificationTransVO.getStrStoreId());
					dao.setFuncInValue(funcIndex, 4, "69" );
					dao.setFuncInValue(funcIndex, 5, _PhyStockVerificationTransVO.getStrItemCategoryId());
				
					dao.setFuncOutValue(funcIndex, 1);
					dao.executeFunction(funcIndex);
					phyStockNo=dao.getFuncString(funcIndex);
					_PhyStockVerificationTransVO.setStrPhysicalStockNo(phyStockNo);
					
					proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);	
				
					dao.setProcInValue(procIndex1, "modval", "1");   
					dao.setProcInValue(procIndex1, "stockNo", _PhyStockVerificationTransVO.getStrPhysicalStockNo());					//2
					dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
					dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
					dao.setProcInValue(procIndex1, "catNo", _PhyStockVerificationTransVO.getStrItemCategoryId());  //5
					dao.setProcInValue(procIndex1, "remarks", "");  //6
					dao.setProcInValue(procIndex1, "seatId", _PhyStockVerificationTransVO.getStrSeatId());         //7
					dao.setProcInValue(procIndex1, "periodId",_PhyStockVerificationTransVO.getStrPeriodId());//8
					
					/* Setting Default Value Start*/
					dao.setProcInValue(procIndex1, "reqTypeId", ""); 
					dao.setProcInValue(procIndex1, "committeeType", ""); 
					dao.setProcInValue(procIndex1, "committeeNo", ""); 
					dao.setProcInValue(procIndex1, "rmksSlNo", ""); 
					dao.setProcInValue(procIndex1, "strFileNo", ""); 
					dao.setProcInValue(procIndex1, "strFileName", ""); 
					dao.setProcInValue(procIndex1, "strPageNo", ""); 
					/* Setting Default Value End */
					
					dao.setProcOutValue(procIndex1, "err",1);	
					dao.execute(procIndex1, 1);
				}
				
				if(_PhyStockVerificationTransVO.getItemParamValue()!=null){
					length=_PhyStockVerificationTransVO.getItemParamValue().length;
					proc_name1="";
					proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					for(int i=0;i<length;i++){
						
						if(!_PhyStockVerificationTransVO.getStrCountedQty()[i].equals("0.00")){
							temp=_PhyStockVerificationTransVO.getItemParamValue()[i].replace('^', '#').split("#");
							procIndex1 = dao.setProcedure(proc_name1);	
							dao.setProcInValue(procIndex1, "modval", "1");                 //1
							dao.setProcInValue(procIndex1, "stockNo", _PhyStockVerificationTransVO.getStrPhysicalStockNo());					//2
							dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
							dao.setProcInValue(procIndex1, "catNo",_PhyStockVerificationTransVO.getStrItemCategoryId());//8
							dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
							dao.setProcInValue(procIndex1, "itemId", temp[17]);  //5
							dao.setProcInValue(procIndex1, "itemBrandId", temp[18]);  //6
							dao.setProcInValue(procIndex1, "grpId", temp[19]);
							dao.setProcInValue(procIndex1, "subGroupId", temp[20]);
							dao.setProcInValue(procIndex1, "avlQty", temp[1]);					                                              
							dao.setProcInValue(procIndex1, "avlQtyUnitId", temp[2]);
							dao.setProcInValue(procIndex1, "toleranceLimit", temp[5]);
							dao.setProcInValue(procIndex1, "varQty", _PhyStockVerificationTransVO.getStrVarianceQty()[i]);
							dao.setProcInValue(procIndex1, "varQtyUnitId", temp[2]);
							dao.setProcInValue(procIndex1, "countedQty", _PhyStockVerificationTransVO.getStrCountedQty()[i]);
							dao.setProcInValue(procIndex1, "countedQtyUnitId", temp[2]);
							dao.setProcInValue(procIndex1, "varCost", _PhyStockVerificationTransVO.getStrVarianceCost()[i]);
							dao.setProcInValue(procIndex1, "appReq", "0");
							dao.setProcInValue(procIndex1, "seatId",_PhyStockVerificationTransVO.getStrSeatId());//8
							dao.setProcOutValue(procIndex1, "err",1);
							dao.execute(procIndex1, 1);
						}
					}
				}
				if(_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()!=null  ){
					
					length=_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls().length;
					for(int i=0;i<length;i++)
					{
						temp=_PhyStockVerificationTransVO.getItemParamValue()[i].replace('^', '#').split("#");
						if(_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()[i]!=null && !_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()[i].trim().equals(""))
						{
							////System.out.println("---->>>>"+_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()[i]);
						 batchItem=_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()[i].split("#");
						 if(batchItem==null){
							 batchItem=new String [1];
							 batchItem[0]=_PhyStockVerificationTransVO.getStrToBeCountedItemBatchDtls()[i];
						 }
						 proc_name1="";
						 proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_ITEMBATCH_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
						
						if(!_PhyStockVerificationTransVO.getStrCountedQty()[i].equals("0.00")){
						
							for(int j=0 , stopJ = batchItem.length;j<stopJ;j++)
							{
								batchTemp=batchItem[j].replace('^', '#').split("#");
								procIndex1 = dao.setProcedure(proc_name1);	
								dao.setProcInValue(procIndex1, "modval", "1");                 //1
								dao.setProcInValue(procIndex1, "stockNo", _PhyStockVerificationTransVO.getStrPhysicalStockNo());					//2
								dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
								dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
								dao.setProcInValue(procIndex1, "itemId", temp[17]);  //5
								dao.setProcInValue(procIndex1, "itemBrandId", temp[18]);  //6
								dao.setProcInValue(procIndex1, "batchNo", batchTemp[3]);  //6
								dao.setProcInValue(procIndex1, "itemSlNo", batchTemp[5]);  //6
								dao.setProcInValue(procIndex1, "stkStatus", batchTemp[4]);  //6
								dao.setProcInValue(procIndex1, "grpId", temp[19]);
								dao.setProcInValue(procIndex1, "subGroupId", temp[20]);
								dao.setProcInValue(procIndex1, "avlQty", batchTemp[7]);					                                              
								dao.setProcInValue(procIndex1, "avlQtyUnitId", batchTemp[9]);
								dao.setProcInValue(procIndex1, "countedQty", batchTemp[17]);
								dao.setProcInValue(procIndex1, "countedQtyUnitId", batchTemp[18]);
								dao.setProcInValue(procIndex1, "rate", batchTemp[10]);
								dao.setProcInValue(procIndex1, "rateUnitId", batchTemp[11]);
								dao.setProcInValue(procIndex1, "manufDate", batchTemp[8]);
								dao.setProcInValue(procIndex1, "expiryDate", batchTemp[6]);
								dao.setProcInValue(procIndex1, "catNo", _PhyStockVerificationTransVO.getStrItemCategoryId());
								dao.setProcInValue(procIndex1, "reqTypeId", "69");
								dao.setProcInValue(procIndex1, "seatId",_PhyStockVerificationTransVO.getStrSeatId());//8
								dao.setProcOutValue(procIndex1, "err",1);
								dao.execute(procIndex1, 1);
								
							}
								
							
						}
						}
					}
				}
				
				
				/*
				 * Cancel Mode
				 */
				if(_PhyStockVerificationTransVO.getStrCountedDtls()!=null){
					
					
					
					proc_name1="";
					proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					for(int i=0 , stopI = _PhyStockVerificationTransVO.getStrCountedDtls().length;i<stopI;i++){
						if(_PhyStockVerificationTransVO.getStrCountedDtls()[i].equals("1")){
							
							
							temp=_PhyStockVerificationTransVO.getStrCountedItemDtls()[i].replace("^", "#").split("#");
							////System.out.println("itemId Mode"+temp[0]);
							////System.out.println("itemBrandId Mode"+temp[1]);
							////System.out.println("hosp_code Mode"+_PhyStockVerificationTransVO.getStrHospitalCode());
							////System.out.println("strId Mode"+_PhyStockVerificationTransVO.getStrStoreId());
							////System.out.println("seatId Mode"+_PhyStockVerificationTransVO.getStrSeatId());
							////System.out.println("stockNo Mode"+_PhyStockVerificationTransVO.getStrPhysicalStockNo());
							
							procIndex1 = dao.setProcedure(proc_name1);	
							dao.setProcInValue(procIndex1, "modval", "2");                 //1
							dao.setProcInValue(procIndex1, "stockNo", _PhyStockVerificationTransVO.getStrPhysicalStockNo());					//2
							dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
							dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
							dao.setProcInValue(procIndex1, "itemId", temp[0]);  //5
							dao.setProcInValue(procIndex1, "itemBrandId", temp[1]);
							dao.setProcInValue(procIndex1, "seatId",_PhyStockVerificationTransVO.getStrSeatId());//8
							
							/* Setting Default Value Start*/
							dao.setProcInValue(procIndex1, "catNo", "");
							dao.setProcInValue(procIndex1, "grpId", "");
							dao.setProcInValue(procIndex1, "subGroupId", "");
							dao.setProcInValue(procIndex1, "avlQty", "0");
							dao.setProcInValue(procIndex1, "avlQtyUnitId", "");
							dao.setProcInValue(procIndex1, "toleranceLimit", "0");
							dao.setProcInValue(procIndex1, "varQty", "0");
							dao.setProcInValue(procIndex1, "varQtyUnitId", "");
							dao.setProcInValue(procIndex1, "countedQty", "0");
							dao.setProcInValue(procIndex1, "countedQtyUnitId", "");
							dao.setProcInValue(procIndex1, "varCost", "0");
							dao.setProcInValue(procIndex1, "appReq", "0");
							/* Setting Default Value End */
							
							dao.setProcOutValue(procIndex1, "err",1);
							//dao.executeProcedure(procIndex1);
							dao.execute(procIndex1, 1);
							
							
							
							
								
						}
						
					}
					
					for(int i=0 , stopI = _PhyStockVerificationTransVO.getStrCountedDtls().length;i<stopI;i++){
						if(_PhyStockVerificationTransVO.getStrCountedDtls()[i].equals("1")){
							
							
							temp=_PhyStockVerificationTransVO.getStrCountedItemDtls()[i].replace("^", "#").split("#");
							////System.out.println("itemId Mode"+temp[0]);
							////System.out.println("itemBrandId Mode"+temp[1]);
							////System.out.println("hosp_code Mode"+_PhyStockVerificationTransVO.getStrHospitalCode());
							////System.out.println("strId Mode"+_PhyStockVerificationTransVO.getStrStoreId());
							////System.out.println("seatId Mode"+_PhyStockVerificationTransVO.getStrSeatId());
							////System.out.println("stockNo Mode"+_PhyStockVerificationTransVO.getStrPhysicalStockNo());
							
						
							
							
							proc_name1="";
							proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_ITEMBATCH_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
							
								
									
							procIndex2 = dao.setProcedure(proc_name1);
							
							dao.setProcInValue(procIndex2, "modval", "2");                 //1
							dao.setProcInValue(procIndex2, "stockNo", _PhyStockVerificationTransVO.getStrPhysicalStockNo());					//2
							dao.setProcInValue(procIndex2, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
							dao.setProcInValue(procIndex2, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
							dao.setProcInValue(procIndex2, "itemId", temp[0]);  //5
							dao.setProcInValue(procIndex2, "itemBrandId", temp[1]);
							dao.setProcInValue(procIndex2, "seatId",_PhyStockVerificationTransVO.getStrSeatId());//8
							
							/* Setting Default Value Start*/
							dao.setProcInValue(procIndex2, "batchNo", "0");
							dao.setProcInValue(procIndex2, "itemSlNo", "0"); 
							dao.setProcInValue(procIndex2, "stkStatus", "0"); 
							dao.setProcInValue(procIndex2, "grpId", ""); 
							dao.setProcInValue(procIndex2, "subGroupId", ""); 
							dao.setProcInValue(procIndex2, "avlQty", "0"); 
							dao.setProcInValue(procIndex2, "avlQtyUnitId", ""); 
							dao.setProcInValue(procIndex2, "countedQty", "0"); 
							dao.setProcInValue(procIndex2, "countedQtyUnitId", "0"); 
							dao.setProcInValue(procIndex2, "rate", ""); 
							dao.setProcInValue(procIndex2, "rateUnitId", ""); 
							dao.setProcInValue(procIndex2, "manufDate", ""); 
							dao.setProcInValue(procIndex2, "expiryDate", ""); 
							dao.setProcInValue(procIndex2, "catNo", "0"); 
							dao.setProcInValue(procIndex2, "reqTypeId", "0");
							/* Setting Default Value End */
							
							dao.setProcOutValue(procIndex2, "err",1);
							//dao.executeProcedure(procIndex1);
							dao.execute(procIndex2, 1);
							
								
						}
						
					}
				
					
				}
				synchronized (dao) {
						dao.fire();
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.insert() --> "
						+ e.getMessage());
				_PhyStockVerificationTransVO.setStrMsgType("1");
			}
		
		}
		/**
		 * This function is used to fetch details for committee type combo.
		 * @param _PhyStockVerificationTransVO
		 */
		public static void setCommitteeTypeDtl(PhyStockVerificationTransVO _PhyStockVerificationTransVO)
		{
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
				dao = new HisDAO("mms", "PhyStockVerificationTransDAO");
				strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","1");
				dao.setProcInValue(nprocIndex, "catCode", _PhyStockVerificationTransVO.getStrItemCategNo());
				dao.setProcInValue(nprocIndex, "reqType", "69");
				dao.setProcInValue(nprocIndex, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				if (strerr.equals("")) {
					_PhyStockVerificationTransVO.setCommitteTypeWS(wb);
				 } else {
					throw new Exception(strerr);
				}
			} catch (Exception e) {
				_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.setCommitteeTypeDtl() --> "
						+ e.getMessage());
				_PhyStockVerificationTransVO.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
		}
		/**
		 * This function is used to fetch details for member detail combo
		 * @param _PhyStockVerificationTransVO
		 */
		
		public static void getMemberDtl(PhyStockVerificationTransVO _PhyStockVerificationTransVO) {
			
			
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
					dao = new HisDAO("mms", "PhyStockVerificationTransDAO");
					strproc_name = "{call pkg_mms_view.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";
					nprocIndex = dao.setProcedure(strproc_name);
					dao.setProcInValue(nprocIndex, "commiteeTypeId",_PhyStockVerificationTransVO.getStrCommiteeTypeId());
					dao.setProcInValue(nprocIndex, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());
					dao.setProcInValue(nprocIndex, "catCode", _PhyStockVerificationTransVO.getStrItemCategoryId());
					
					/* Setting Default Value Start*/
					dao.setProcInValue(nprocIndex, "modval","1");
					dao.setProcInValue(nprocIndex, "commNo","");
					/* Setting Default Value End */
					
					dao.setProcOutValue(nprocIndex, "err", 1);
					dao.setProcOutValue(nprocIndex, "resultset", 2); 
					dao.executeProcedure(nprocIndex);
					strerr = dao.getString(nprocIndex, "err");
					if (strerr == null)
						strerr = "";
					
					wb = dao.getWebRowSet(nprocIndex, "resultset");
					
					if (strerr.equals("")) {
					
						_PhyStockVerificationTransVO.setCommitteMemberWS(wb);
	             
					} else {
					throw new Exception(strerr);
					}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.getMemberDtl() --> "
						+ e.getMessage());
				_PhyStockVerificationTransVO.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
					wb=null;
				}
			}
		}
public static void updateReview(PhyStockVerificationTransVO _PhyStockVerificationTransVO) {
			
			
			
			HisDAO dao = null;
			int procIndex1 = 0;
			
			String strQuery="";
			String strTemp[]=null;
			int nQueryIndex=0;
			WebRowSet web=null;
			String maxSlno="";
			String proc_name1="";
			int length=0;
			CommitteRemarksDtlDAO committeRemarks=null;
			
			try {
					dao = new HisDAO("mms", "PhyStockVerificationTransDAO");
					committeRemarks=new CommitteRemarksDtlDAO();
					
					if(_PhyStockVerificationTransVO.getStrMemberRecommendation()!=null)
						length=_PhyStockVerificationTransVO.getStrMemberRecommendation().length;
					
					if(length>0 )
					{
						strTemp=_PhyStockVerificationTransVO.getStrCommitteeMemberHidden()[0].replace('@', '#').split("#");
						strQuery =  "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"+
								"	where HSTNUM_COMMITTEE_NO=?"+"and GNUM_HOSPITAL_CODE=?";
						
						nQueryIndex = dao.setQuery(strQuery);
						dao.setQryValue(nQueryIndex, 1, strTemp[1]);
						dao.setQryValue(nQueryIndex, 2, _PhyStockVerificationTransVO.getStrHospitalCode());
						web = dao.executeQry(nQueryIndex);
						if(web.next())
						{
							maxSlno=web.getString(1);
						}
						for(int i=0;i<length;i++)
						{
							strTemp=_PhyStockVerificationTransVO.getStrCommitteeMemberHidden()[i].replace('@', '#').split("#");
							committeRemarks.setStrEmpCode(strTemp[0]);
							committeRemarks.setStrCommitteNo(strTemp[1]);
							committeRemarks.setStrMemberName(strTemp[2]);
							committeRemarks.setStrChairPersonFlag(strTemp[3]);
							committeRemarks.setStrHospCode(_PhyStockVerificationTransVO.getStrHospitalCode());
							committeRemarks.setRemarks(_PhyStockVerificationTransVO.getStrMemberRecommendation()[i]);
							committeRemarks.setStrCommitteTypeId(_PhyStockVerificationTransVO.getStrCommitteeTypeId());
							committeRemarks.setStrCommRemarksSlNo(maxSlno);
							//committeRemarks.insert(dao);
						}
						
					}
					
					proc_name1 = "{call pkg_mms_dml.DML_PHYSTOCK_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);	
				
					dao.setProcInValue(procIndex1, "modval", "2");   
					dao.setProcInValue(procIndex1, "stockNo", _PhyStockVerificationTransVO.getStrStockNo());					//2
					dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());       //3
					dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());   //4
					dao.setProcInValue(procIndex1, "catNo", _PhyStockVerificationTransVO.getStrItemCategNo());  //5
					dao.setProcInValue(procIndex1, "remarks", _PhyStockVerificationTransVO.getStrRemarks());  //6
					dao.setProcInValue(procIndex1, "seatId", _PhyStockVerificationTransVO.getStrSeatId());         //7
					dao.setProcInValue(procIndex1, "reqTypeId","69");//8
					dao.setProcInValue(procIndex1, "committeeType",_PhyStockVerificationTransVO.getStrCommitteeTypeId());
					if(strTemp==null) {
						dao.setProcInValue(procIndex1, "committeeNo","");
					} else {
						dao.setProcInValue(procIndex1, "committeeNo",strTemp[1]);
					}
					
					dao.setProcInValue(procIndex1, "rmksSlNo",maxSlno);
					dao.setProcInValue(procIndex1, "periodId","30");
					dao.setProcInValue(procIndex1, "strFileNo",_PhyStockVerificationTransVO.getStrFileNo());
					dao.setProcInValue(procIndex1, "strFileName",_PhyStockVerificationTransVO.getStrFileName());
					dao.setProcInValue(procIndex1, "strPageNo",_PhyStockVerificationTransVO.getStrPageNo());
					dao.setProcOutValue(procIndex1, "err",1);	
					dao.execute(procIndex1, 1);
					synchronized (dao) {
						dao.fire();
					}
					
			} catch (Exception e) {
				e.printStackTrace();
				_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.updateReview() --> "
						+ e.getMessage());
				_PhyStockVerificationTransVO.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
					
				}
			}
		}
/*
 * This function is used to cancel the physical stock verification
 */
 
public static void cancelStock(PhyStockVerificationTransVO _PhyStockVerificationTransVO) {
	
	
	String proc_name1 = "";
	HisDAO dao = null;
	int procIndex1 = 0;
	
	
	
	try {
			dao = new HisDAO("mms", "PhyStockVerificationTransDAO");
			
			proc_name1 = "{call pkg_mms_dml.dml_phystock_cancel(?,?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);	
			dao.setProcInValue(procIndex1, "modval", "1");   
			dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());					
			dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());     
			dao.setProcInValue(procIndex1, "phyStockNo", _PhyStockVerificationTransVO.getStrStockNo());   
			dao.setProcInValue(procIndex1, "strCategNo", _PhyStockVerificationTransVO.getStrItemCategNo());  
			dao.setProcInValue(procIndex1, "strSeatId", _PhyStockVerificationTransVO.getStrSeatId());  
			dao.setProcInValue(procIndex1, "strCancelRemarks",_PhyStockVerificationTransVO.getStrRemarks());
			dao.setProcInValue(procIndex1, "strRequestType","69");
			dao.setProcOutValue(procIndex1, "err",1);	
			dao.executeProcedure(procIndex1);
		
	} catch (Exception e) {
		
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.updateReview() --> "
				+ e.getMessage());
		_PhyStockVerificationTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			
		}
	}
}
/*
 * /*
 * This function is used to update stock after physical stock verification 
 */
 
public static void updateStock(PhyStockVerificationTransVO _PhyStockVerificationTransVO) {
	
	
	String proc_name1 = "";
	HisDAO dao = null;
	int procIndex1 = 0;
	
	
	
	try {
			dao = new HisDAO("mms", "PhyStockVerificationTransDAO");
			proc_name1 = "{call pkg_mms_dml.dml_phystock_updateStock(?,?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);	
			dao.setProcInValue(procIndex1, "modval", "1");   
			dao.setProcInValue(procIndex1, "hosp_code", _PhyStockVerificationTransVO.getStrHospitalCode());					
			dao.setProcInValue(procIndex1, "strId", _PhyStockVerificationTransVO.getStrStoreId());     
			dao.setProcInValue(procIndex1, "phyStockNo", _PhyStockVerificationTransVO.getStrStockNo());   
			dao.setProcInValue(procIndex1, "strCategNo", _PhyStockVerificationTransVO.getStrItemCategNo());  
			dao.setProcInValue(procIndex1, "strSeatId", _PhyStockVerificationTransVO.getStrSeatId());  
			dao.setProcInValue(procIndex1, "strStockRemarks",_PhyStockVerificationTransVO.getStrRemarks());
			dao.setProcInValue(procIndex1, "strRequestType","69");
			dao.setProcOutValue(procIndex1, "err",1);	
			dao.executeProcedure(procIndex1);
		
	} catch (Exception e) {
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransDAO.updateStock() --> "
				+ e.getMessage());
		_PhyStockVerificationTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			
		}
	}
}	
}
