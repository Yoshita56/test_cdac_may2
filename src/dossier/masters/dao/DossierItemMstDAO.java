package dossier.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.StoreDAO;
import mms.dao.StoreItemDAO;
import dossier.masters.vo.DossierItemMstVO;
import dossier.masters.vo.DossierMstVO;
import dossier.transaction.vo.DossierRequisitionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierItemMstDAO.
 */
public class DossierItemMstDAO {

	
	/**
	 * for getting option value of item name combo and level unit combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(DossierItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		// String strTableName = "";
		try {
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			
			/*strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierDeptAndServiceType.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSeatId());

			wb = dao.executeQry(nqryIndex);
			
			if(wb.next()){
				vo.setStrDeptCode(wb.getString(1));
				vo.setStrServiceTypeId(wb.getString(2));
			}
			*/
			/*strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierDeptNameAndServiceTypeName.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDeptCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrServiceTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 5, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 6, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 7, vo.getStrSeatId());

			wb = dao.executeQry(nqryIndex);
			
			if(wb.next()){
				vo.setStrDeptName(wb.getString(1));
				vo.setStrServiceTypeName(wb.getString(2));
			}
			
*/
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.StoreNameCombo.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrStoreNameWS(wb);
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItem.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);

			wb = dao.executeQry(nqryIndex);
			vo.setStrLeftRequestTypesListWs(wb);
						
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItem.6");
	        nqryIndex = dao.setQuery(strquery);
	        dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 3, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 4, Config.SUPER_USER_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			vo.setStrRightRequestTypeListWs(wb);
						
		} catch (Exception e) {
			vo.setStrMsgString("--> DossierItemMstDAO.initAddQuery()-->"
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
	 * 
	 * Function to get Item Category Combo values
	 * @param voObj
	 */
	public static void getItemCatDtls(DossierItemMstVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_dossier_view.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("Dossier Masters","DossierItemMstDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", "",2);
			daoObj.setProcInValue(nProcIndex, "reqType", "",4);
			
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
			e.printStackTrace();
			voObj
					.setStrMsgString("DossierItemMstDAO.getItemCatDtls() --> "
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
	 * to insert the data.
	 * @param vo the vo
	 */
	public static void InsertQueryLogic(DossierItemMstVO vo) 
	{
				HisDAO dao = null;
				WebRowSet web = null;
				String strquery = "";
				String[] itemId = null;
				String[] itemBrandId = null;
				String strQuery = "";
				int nQueryIndex = 0;
				int j=0;
				
				String strSlNo="", strCatNo="",strItemTypeId="";
				try{
					dao = new HisDAO("dossier", "DossierItemMstDAO");
					
					vo.setStrStoreId(vo.getStrStoreName());
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItem.slNo.0");
					nQueryIndex = dao.setQuery(strQuery);
					
					web = dao.executeQry(nQueryIndex);
					if (web.next()) 
					{
						strSlNo = web.getString(1);
					}
					
					if(strSlNo.equals("")){
						strSlNo="1";
					}
					
					int strSlNoInt;
					String strIsMisc="";
					String strIsReturnable = "", strIsRC = "";
					String [] paramVal=null , userValue=null;
					
					if(vo.getItemParamValue() !=null){						
					
						int  length = vo.getItemParamValue().length;	
			               
							for(int k=0;k<length;k++)
							{
								if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
								{
								
									strSlNoInt=Integer.parseInt(strSlNo)+1;
									strSlNo=Integer.toString(strSlNoInt);
									System.out.println("vo.getItemParamValue()"+vo.getItemParamValue()[k]);
	
									paramVal = vo.getItemParamValue()[k].split("#");						
									userValue = paramVal[2].replace('^', '#').split("#");
									
									if(vo.getStrIsMisc()[k].equals("Yes")){
										strIsMisc="1";
									}
									else{
										strIsMisc="0";
									}
									
									if(vo.getStrIsReturnableArr()[k].equals("Yes")){
										strIsReturnable="1";
									}
									else{
										strIsReturnable="0";
									}
									
									if(vo.getStrIsRC()[k].equals("Yes")){
										strIsRC="1";
									}
									else{
										strIsRC="0";
									}
									
									
									strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItem.0");
									nQueryIndex = dao.setQuery(strQuery);
									dao.setQryValue(nQueryIndex, 1, vo.getStrDossierId());
									dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
									dao.setQryValue(nQueryIndex, 3, strSlNo);
									dao.setQryValue(nQueryIndex, 4, "1");
									dao.setQryValue(nQueryIndex, 5, userValue[0]); // item id
									dao.setQryValue(nQueryIndex, 6, userValue[1]); //item brand id
									dao.setQryValue(nQueryIndex, 7, userValue[1].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
									dao.setQryValue(nQueryIndex, 8, "1");
									dao.setQryValue(nQueryIndex, 9, userValue[14]); //item type id
									dao.setQryValue(nQueryIndex, 10, "1");
									dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText()[k]);
									dao.setQryValue(nQueryIndex, 12, "1");
									dao.setQryValue(nQueryIndex, 13, strIsMisc);
									dao.setQryValue(nQueryIndex, 14, vo.getStrStoreId());
									dao.setQryValue(nQueryIndex, 15, userValue[1]); //item tariff id
									dao.setQryValue(nQueryIndex, 16, vo.getStrEntryDate()); 
									dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
									dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
									dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText()[k]); //Default Rate
									dao.setQryValue(nQueryIndex, 20, vo.getIsBroughtByPatient()[k]);
									dao.setQryValue(nQueryIndex, 21, strIsReturnable);
									dao.setQryValue(nQueryIndex, 22, strIsRC);
									dao.setQryValue(nQueryIndex, 23, vo.getStrRemarksText()[k]);
									
									dao.execute(nQueryIndex, 0);
													
									System.out.println("sl no in InsertQueryLogic()-------> "+k+"---> "+strSlNo);
									System.out.println("vo.getStrItemBrandId() -------> "+userValue[1]);

									System.out.println("dossier id ---->>>>>>"+vo.getStrDossierId());
									System.out.println("hosp code ---->>>>>>"+vo.getStrHospitalCode());
									System.out.println("sl no ---->>>>>>"+strSlNo);
									System.out.println("item id ---->>>>>>"+userValue[0]);
									System.out.println("item brand id ---->>>>>>"+userValue[1]);
									System.out.println("cat no ---->>>>>>"+vo.getStritemcat());
									System.out.println("item type id ---->>>>>>"+userValue[14]);
									System.out.println("display order no ---->>>>>>"+strSlNo);
									System.out.println("store id ---->>>>>>"+vo.getStrStoreId());
									System.out.println("item tariff id ---->>>>>>"+userValue[1]);
									System.out.println("entry date ---->>>>>>"+vo.getStrEntryDate()); 
									System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
									System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
									System.out.println("default rate ---->>>>>>"+vo.getStrDefRateText()[k]);
									System.out.println("brought by patient ---->>>>>>"+vo.getIsBroughtByPatient()[k]);
								}	
								
							}
								
					}
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierMst.TotalCost.0");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrDossierTotalCost());
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
				//	dao.setQryValue(nQueryIndex, 3, vo.getStrSeatId());
					dao.setQryValue(nQueryIndex, 3, vo.getStrDossierId());
					dao.setQryValue(nQueryIndex, 4, vo.getStrIsValid());
					
				
					dao.execute(nQueryIndex, 0);

					synchronized (dao) 
					{
						dao.fire();
					}
												
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					vo.setStrMsgString("--> DossierItemMstDAO.InsertQueryLogic()-->"
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
	 * to insert the updated previously existing item details into table after update.
	 * @param vo the vo
	 */
	public static void InsertQueryLogicUpdate(DossierItemMstVO vo) 
	{
				HisDAO dao = null;
				WebRowSet web = null;
				String strquery = "";
				String[] itemId = null;
				String[] itemBrandId = null;
				String strQuery = "";
				int nQueryIndex = 0;
				int j=0;
				
				String strSlNo="", strCatNo="",strItemTypeId="";
				try{
					dao = new HisDAO("dossier", "DossierItemMstDAO");
					
					vo.setStrStoreId(vo.getStrStoreName());
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItem.slNo.0");
					nQueryIndex = dao.setQuery(strQuery);
					
					web = dao.executeQry(nQueryIndex);
					if (web.next()) 
					{
						strSlNo = web.getString(1);
					}
					
					if(strSlNo.equals("")){
						strSlNo="1";
					}
					
					int strSlNoInt;
					String strIsMisc="" , strIsReturnable="" , strIsRC="";
					String [] paramVal=null , userValue=null;
					
					if(vo.getItemParamValue() !=null){						
					
						int  length = vo.getItemParamValue().length;	
			               
							for(int k=0;k<length;k++)
							{
								if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
								{
								
									strSlNoInt=Integer.parseInt(strSlNo)+1;
									strSlNo=Integer.toString(strSlNoInt);
									System.out.println("vo.getItemParamValue()"+vo.getItemParamValue()[k]);
	
									paramVal = vo.getItemParamValue()[k].split("#");						
									userValue = paramVal[2].replace('^', '#').split("#");

									if(vo.getStrIsMisc()[k].equals("Yes")){
										strIsMisc="1";
									}
									else{
										strIsMisc="0";
									}

									if(vo.getStrIsReturnableArr()[k].equals("Yes")){
										strIsReturnable="1";
									}
									else{
										strIsReturnable="0";
									}
									
									if(vo.getStrIsRC()[k].equals("Yes")){
										strIsRC="1";
									}
									else{
										strIsRC="0";
									}
									
									
									strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItem.0");
									nQueryIndex = dao.setQuery(strQuery);
									dao.setQryValue(nQueryIndex, 1, vo.getStrDossierId());
									dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
									dao.setQryValue(nQueryIndex, 3, strSlNo);
									dao.setQryValue(nQueryIndex, 4, "1");
									dao.setQryValue(nQueryIndex, 5, userValue[0]); // item id
									dao.setQryValue(nQueryIndex, 6, userValue[1]); //item brand id
									dao.setQryValue(nQueryIndex, 7, userValue[1].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
									dao.setQryValue(nQueryIndex, 8, "1");
									dao.setQryValue(nQueryIndex, 9, userValue[14]); //item type id
									dao.setQryValue(nQueryIndex, 10, "1");
									dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText()[k]);
									dao.setQryValue(nQueryIndex, 12, "1");
									dao.setQryValue(nQueryIndex, 13, strIsMisc);
									dao.setQryValue(nQueryIndex, 14, vo.getStrNewStoreName()); //Store Id
									dao.setQryValue(nQueryIndex, 15, userValue[1]); //item tariff id
									dao.setQryValue(nQueryIndex, 16, vo.getStrEntryDate()); 
									dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
									dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid()); //vo.getStrIsValid()
									dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText()[k]); //Default Rate
									dao.setQryValue(nQueryIndex, 20, vo.getIsBroughtByPatient()[k]);
									dao.setQryValue(nQueryIndex, 21, strIsReturnable);
									dao.setQryValue(nQueryIndex, 22, strIsRC);
									dao.setQryValue(nQueryIndex, 23, vo.getStrRemarksText()[k]);
									
								
									dao.execute(nQueryIndex, 0);
													
									System.out.println("sl no in InsertQueryLogic()-------> "+k+"---> "+strSlNo);
									System.out.println("vo.getStrItemBrandId() -------> "+userValue[1]);

									System.out.println("dossier id ---->>>>>>"+vo.getStrDossierId());
									System.out.println("hosp code ---->>>>>>"+vo.getStrHospitalCode());
									System.out.println("sl no ---->>>>>>"+strSlNo);
									System.out.println("item id ---->>>>>>"+userValue[0]);
									System.out.println("item brand id ---->>>>>>"+userValue[1]);
									System.out.println("cat no ---->>>>>>"+vo.getStritemcat());
									System.out.println("item type id ---->>>>>>"+userValue[14]);
									System.out.println("display order no ---->>>>>>"+strSlNo);
									System.out.println("store id ---->>>>>>"+vo.getStrNewStoreName());
									System.out.println("item tariff id ---->>>>>>"+userValue[1]);
									System.out.println("entry date ---->>>>>>"+vo.getStrEntryDate()); 
									System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
									System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
									System.out.println("default rate ---->>>>>>"+vo.getStrDefRateText()[k]);
									System.out.println("brought by patient ---->>>>>>"+vo.getIsBroughtByPatient()[k]);
								}	
								
							}
								
					}
					synchronized (dao) 
					{
						dao.fire();
					}
												
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					vo.setStrMsgString("--> DossierItemMstDAO.InsertQueryLogicUpdate()-->"
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
	 * Function to insert new item details after update.
	 * @param vo
	 */
	public static void InsertQueryLogic1(DossierItemMstVO vo) 
	{
				HisDAO dao = null;
				WebRowSet web = null;
				String strquery = "";
				String[] itemId = null;
				String[] itemBrandId = null;
				String strQuery = "";
				int nQueryIndex = 0;
				int j=0;
				
				String strSlNo="", strCatNo="",strItemTypeId="";
				try{
					dao = new HisDAO("dossier", "DossierItemMstDAO");
					
					vo.setStrStoreId(vo.getStrStoreName());
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItem.slNo.0");
					nQueryIndex = dao.setQuery(strQuery);
					
					web = dao.executeQry(nQueryIndex);
					if (web.next()) 
					{
						strSlNo = web.getString(1);
					}
					
					if(strSlNo.equals("")){
						strSlNo="1";
					}
					
					int strSlNoInt;
					String strIsMisc="" , strIsReturnable="", strIsRC="" ;
					
					String [] paramVal=null , userValue=null;					
					
						int  length = vo.getStrQtyText1().length;	
			               
							for(int k=0;k<length;k++)
							{
								if(vo.getStrQtyText1()[k] != null && vo.getStrQtyText1()[k].length() > 0 && !vo.getStrQtyText1()[k].equals("0"))
								{
								
									strSlNoInt=Integer.parseInt(strSlNo)+1;
									strSlNo=Integer.toString(strSlNoInt);
									/*System.out.println("vo.getItemParamValue()"+vo.getItemParamValue()[k]);
	
									paramVal = vo.getItemParamValue()[k].split("#");						
									userValue = paramVal[2].replace('^', '#').split("#");	
									 */	
									if(vo.getStrIsMisc1()[k].equals("Yes")){
										strIsMisc="1";
									}
									else{
										strIsMisc="0";
									}
									
									if(vo.getStrIsReturnableArr1()[k].equals("Yes")){
										strIsReturnable="1";
									}
									else{
										strIsReturnable="0";
									}
									
									if(vo.getStrIsRC1()[k].equals("Yes")){
										strIsRC="1";
									}
									else{
										strIsRC="0";
									}
									
									strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItem.0");
									nQueryIndex = dao.setQuery(strQuery);
									dao.setQryValue(nQueryIndex, 1, vo.getStrDossierId());
									dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
									dao.setQryValue(nQueryIndex, 3, strSlNo);
									dao.setQryValue(nQueryIndex, 4, "1");
									dao.setQryValue(nQueryIndex, 5, vo.getStrItemIdArray()[k]); // item id
									dao.setQryValue(nQueryIndex, 6, vo.getStrItemBrandIdArray()[k]); //item brand id
									dao.setQryValue(nQueryIndex, 7, vo.getStrItemBrandIdArray()[k].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
									dao.setQryValue(nQueryIndex, 8, "1");
									dao.setQryValue(nQueryIndex, 9, vo.getStrItemTypeIdArray()[k]); //item type id
									dao.setQryValue(nQueryIndex, 10, "1");
									dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText1()[k]);
									dao.setQryValue(nQueryIndex, 12, "1");
									dao.setQryValue(nQueryIndex, 13, strIsMisc);
									dao.setQryValue(nQueryIndex, 14, vo.getStrNewStoreName()); //store id
									dao.setQryValue(nQueryIndex, 15, vo.getStrItemBrandIdArray()[k]); //item tariff id
									dao.setQryValue(nQueryIndex, 16, vo.getStrEntryDate()); 
									dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
									dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid()); //vo.getStrIsValid()
									dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText1()[k]); //Default Rate
									dao.setQryValue(nQueryIndex, 20, vo.getIsBroughtByPatient1()[k]);
									dao.setQryValue(nQueryIndex, 21, strIsReturnable);
									dao.setQryValue(nQueryIndex, 22, strIsRC);
									dao.setQryValue(nQueryIndex, 23, vo.getStrRemarksText1()[k]);
									
									dao.execute(nQueryIndex, 0);
													
									System.out.println("sl no in InsertQueryLogic1()-------> "+k+"---> "+strSlNo);
									System.out.println("dossier id ---->>>>>>"+vo.getStrDossierId());
									System.out.println("hosp code ---->>>>>>"+vo.getStrHospitalCode());
									System.out.println("sl no ---->>>>>>"+strSlNo);
									System.out.println("item id ---->>>>>>"+vo.getStrItemIdArray()[k]);
									System.out.println("item brand id ---->>>>>>"+vo.getStrItemBrandIdArray()[k]);
									System.out.println("cat no ---->>>>>>"+vo.getStrItemBrandIdArray()[k].substring(0,2));
									System.out.println("item type id ---->>>>>>"+vo.getStrItemTypeIdArray()[k]);
									System.out.println("display order no ---->>>>>>"+strSlNo);
									System.out.println("store id ---->>>>>>"+vo.getStrNewStoreName());
									System.out.println("item tariff id ---->>>>>>"+vo.getStrItemBrandIdArray()[k]);
									System.out.println("entry date ---->>>>>>"+vo.getStrEntryDate()); 
									System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
									System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
									System.out.println("default rate ---->>>>>>"+vo.getStrDefRateText1()[k]);
									System.out.println("brought by patient ---->>>>>>"+vo.getIsBroughtByPatient1()[k]);
								}	
								
							}
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierMst.TotalCost.0");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrDossierTotalCost());
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
					//dao.setQryValue(nQueryIndex, 3, vo.getStrSeatId());
					dao.setQryValue(nQueryIndex, 3, vo.getStrDossierId());
					dao.setQryValue(nQueryIndex, 4, vo.getStrIsValid());
					
				
					dao.execute(nQueryIndex, 0);
							
					synchronized (dao) 
					{
						dao.fire();
					}
												
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					vo.setStrMsgString("--> DossierItemMstDAO.InsertQueryLogic1()-->"
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
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(DossierItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			System.out.println("item brand id : =------>>>>>>>>>> "+vo.getStrRightRequestTypes());
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItem.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrDossierId());
			//dao.setQryValue(nqryIndex, 3, vo.getStrItemBrandId());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> DossierItemMstDAO.chkDuplicate()-->"
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
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(DossierItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try 
		{
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.StoreNameCombo.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());

			web = dao.executeQry(nqryIndex);
			vo.setStrStoreNameWS(web);
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierName.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			if(web.next()){
				vo.setStrDossierName(web.getString(1));
			}
			
			
			/*strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DepartmentName.DossierItem.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			if(web.next()){
				vo.setStrDeptName(web.getString(1));
			}*/
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.ServiceTypeName.DossierItem.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			if(web.next()){
				vo.setStrServiceTypeName(web.getString(1));
			}
			
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemNameList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrIsValid());
			dao.setQryValue(nqryIndex, 2, vo.getStrDossierId());
			//dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrIsValid());
			dao.setQryValue(nqryIndex, 4, vo.getStrDossierId());
			//dao.setQryValue(nqryIndex, 6, vo.getStrStoreId());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setItemDetailWS(web);
					
			/*strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierStoreName.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			if(web.next()){
				vo.setStrStoreName(web.getString(1));
			}
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.selectedRightDossierItemList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setStrRightRequestTypeListWs(web);
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.selectedLeftDossierItemList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setStrLeftRequestTypesListWs(web);
			*/
		} catch (Exception e) {
			vo.setStrMsgString("--> DossierItemMstDAO.modifyQuery()-->"
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
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(DossierItemMstVO vo) {

		HisDAO hisdao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {

			hisdao = new HisDAO("dossier", "DossierItemMstDAO");
			String strquery = dossier.masters.qryHandler_dossier.getQuery(1,
					"select.StoreItem.4");

			nqryIndex = hisdao.setQuery(strquery);

			hisdao.setQryValue(nqryIndex, 1, vo.getStrItemShortName());
			hisdao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			hisdao.setQryValue(nqryIndex, 3, vo.getStrItemSlNo());
			hisdao.setQryValue(nqryIndex, 4, vo.getStrStoreId());

			wb = hisdao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));

			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> DossierItemMstDAO.initialUpdateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (hisdao != null) {
				hisdao.free();
				hisdao = null;
			}
		}

	}

	/**
	 * to update the previously existing records.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(DossierItemMstVO vo) {

		HisDAO dao = null;
		WebRowSet web = null;
		String strQuery = "";
		int nQueryIndex = 0;
		
		String strSlNo="", strCatNo="",strItemTypeId="";
		try{
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierPreviousItem.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDossierId());
			//dao.setQryValue(nQueryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			dao.execute(nQueryIndex, 0);

			synchronized (dao) 
			{
				dao.fire();
			}
			
			/*System.out.println("After dao.fire() in updateQuery()");
			for(int i=0;i<vo.getStrRightRequestTypes().length;i++){
				System.out.println("new right list --->>> "+i+" --> "+vo.getStrRightRequestTypes()[i]);
				
			}*/
			InsertQueryLogicUpdate(vo);
			InsertQueryLogic1(vo);
			vo.setStrMsgType("0");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> DossierItemMstDAO.updateQuery()-->"
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
	 * This function is used set initial parameters for view page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void view(DossierItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int j=0;
		String strDeptCode="",strBillingMode="",strBillingModeName="",strDeptName="";
		try {

			dao = new HisDAO("dossier", "DossierItemMstDAO");
			String strIsValid=vo.getStrIsValid();
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemMst.View.0");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrDossierId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, vo.getStrDossierId());
			dao.setQryValue(nQueryIndex, 5, vo.getStrHospitalCode());
			
			web = dao.executeQry(nQueryIndex);
			if(web.next()) {
				vo.setStrDossierName(web.getString(1));
				vo.setStrServiceTypeName(web.getString(2));
				
			}	
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemMst.View.1");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDossierId());
			//dao.setQryValue(nQueryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			
			web = dao.executeQry(nQueryIndex);
			if(web.next()) {
				//vo.setStrStoreName(web.getString(1));
				vo.setStrIsValid(web.getString(1));
				vo.setStrEffectiveFrom(web.getString(2));
				
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemMst.View.2");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, strIsValid);
			dao.setQryValue(nQueryIndex, 2, vo.getStrDossierId());
			//dao.setQryValue(nQueryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nQueryIndex, 3, strIsValid);
			dao.setQryValue(nQueryIndex, 4, vo.getStrDossierId());
			//dao.setQryValue(nQueryIndex, 6, vo.getStrStoreId());
			
			web = dao.executeQry(nQueryIndex);
			vo.setItemDetailWS(web);
			
		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("DossierItemMstDAO.view() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			web = null;
		}
	}



	
}

///////////////////////////////////////////////////////////////////////////////////////////////
