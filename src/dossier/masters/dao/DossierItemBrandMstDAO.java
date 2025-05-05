package dossier.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.ItemDAO;
import dossier.masters.vo.DossierItemBrandMstVO;
import dossier.masters.vo.DossierItemMstVO;

public class DossierItemBrandMstDAO {
	
	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(DossierItemBrandMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("dossier", "DossierItemBrandMstDAO");
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemBrand.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 4, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrLeftRequestTypesListWs(wb);
						
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemBrand.6");
	        nqryIndex = dao.setQuery(strquery);
	        dao.setQryValue(nqryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 4, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 5, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 6, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 7, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 8, vo.getStrGroupId());
			wb = dao.executeQry(nqryIndex);
			
			vo.setStrRightRequestTypeListWs(wb);			

		} catch (Exception e) {
			vo.setStrMsgString("DossierItemBrandMstDAO.initialAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	public static void getItemCatDtls(DossierItemBrandMstVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_dossier_view.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("Dossier Masters","DossierItemBrandMstDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),3);
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
					.setStrMsgString("DossierItemBrandMstDAO.getItemCatDtls() --> "
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
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void chkDuplicate(DossierItemBrandMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {
				dao = new HisDAO("dossier", "DossierMstDAO");
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrandMisc.9");
				nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, vo.getStrItemKitName());
				dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
				dao.setQryValue(nQueryIndex, 3, vo.getStrDeptCode());
				
				web = dao.executeQry(nQueryIndex);
				while (web.next()) {
					ncount = Integer.parseInt(web.getString(1));
				}
				System.out.println("ncount in dao --->>"+ncount);
				if (ncount == 0) {
					vo.setBExistStatus(true);
				} else {
					vo.setBExistStatus(false);
				}
				
		} catch (Exception e) {
			vo.setStrMsgString("DossierItemBrandMstDAO.chkDuplicate() --> "
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
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(DossierItemBrandMstVO vo) {
		HisDAO dao = null;
		WebRowSet web = null;
		String strquery = "";
		String[] itemId = null;
		String[] itemBrandId = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		
		String [] paramVal=null , userValue=null;
		String strMiscId="", strCatNo="",strItemTypeId="", strSlNo="", strMiscId1="";
		try{
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.miscId.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strMiscId1 = web.getString(1);
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.deptId.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDeptName());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrDeptCode(web.getString(1));
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.slNo.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strSlNo = web.getString(1);
			}
			
			if(strSlNo.equals("")){
				strSlNo="1";
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierMisc.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strMiscId1);
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrItemKitName());
			dao.setQryValue(nQueryIndex, 4, vo.getStrItemKitDescription());
			dao.setQryValue(nQueryIndex, 5, "1");
			dao.setQryValue(nQueryIndex, 6, vo.getStrItemKitName()); //service name
			dao.setQryValue(nQueryIndex, 7, vo.getStrBillingMode());
			dao.setQryValue(nQueryIndex, 8, "1");
			dao.setQryValue(nQueryIndex, 9, vo.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 10, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 11, vo.getStrIsValid());
			dao.setQryValue(nQueryIndex, 12, vo.getStrItemKitRate());
			dao.setQryValue(nQueryIndex, 13, vo.getStrDeptCode());
			dao.setQryValue(nQueryIndex, 14, vo.getStrHospiCode());
			dao.execute(nQueryIndex, 0);
			
			int strSlNoInt;
			
			if(vo.getItemParamValue() !=null){						
				
				int  length = vo.getItemParamValue().length;	
	               
					for(int k=0;k<length;k++)
					{
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{
							strSlNoInt=Integer.parseInt(strSlNo)+1;
							strSlNo=Integer.toString(strSlNoInt);
							
							String strStoreId="10201101";

							paramVal = vo.getItemParamValue()[k].split("#");						
							userValue = paramVal[2].replace('^', '#').split("#");	

							strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItemBrand.0");
							
							nQueryIndex = dao.setQuery(strQuery);
							dao.setQryValue(nQueryIndex, 1, strMiscId1);
							dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
							dao.setQryValue(nQueryIndex, 3, strSlNo);
							dao.setQryValue(nQueryIndex, 4, "1");
							dao.setQryValue(nQueryIndex, 5, userValue[0]); //item id
							dao.setQryValue(nQueryIndex, 6, userValue[1]); //itembrand id
							dao.setQryValue(nQueryIndex, 7, userValue[1].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
							dao.setQryValue(nQueryIndex, 8, "1");
							dao.setQryValue(nQueryIndex, 9, userValue[14]); //item type id
							dao.setQryValue(nQueryIndex, 10, "1");
							dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText()[k]); //default qty
							dao.setQryValue(nQueryIndex, 12, "1");
							dao.setQryValue(nQueryIndex, 13, "1"); //is misc item
							dao.setQryValue(nQueryIndex, 14, strStoreId);
							dao.setQryValue(nQueryIndex, 15, userValue[1]); //item tariff id
							dao.setQryValue(nQueryIndex, 16, vo.getStrEffectiveFrom());
							dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
							dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
							dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText()[k]); //default rate
							
						
							dao.execute(nQueryIndex, 0);
							
							System.out.println("misc id -------> "+k+"---> "+strMiscId);
							System.out.println("vo.getStrItemBrandId() -------> "+userValue[1]);
							System.out.println("item id ---->>>>>>"+userValue[0]);
							System.out.println("sl no ---->>>>>>"+strSlNo);
							System.out.println("hosp code ---->>>>>>"+vo.getStrHospCode());
							System.out.println("cat no ---->>>>>>"+userValue[1].substring(0,2));
							System.out.println("item type id ---->>>>>>"+userValue[14]);
							System.out.println("entry date ---->>>>>>"+vo.getStrEffectiveFrom());
							System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
							System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
							System.out.println("qty--->>>>>>"+vo.getStrQtyText()[k]);
							System.out.println("default rate--->>>>>>"+vo.getStrDefRateText()[k]);

						}
					}
			}
			
			
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierMiscItemBrandMst.0");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrHospiCode());
					dao.setQryValue(nQueryIndex, 2, "25000001");//Item Id is hardcoded as discussed with Shalini Ma'am. I have created a new item id in "hstt_item_mst" table under item id=25000001
					dao.setQryValue(nQueryIndex, 3, vo.getStrHospiCode());
					dao.setQryValue(nQueryIndex, 4, "25"); //misc item kit category no
					dao.setQryValue(nQueryIndex, 5, vo.getStrItemKitName());
					dao.setQryValue(nQueryIndex, 6, vo.getStrItemKitRate());
					dao.setQryValue(nQueryIndex, 7, "6301"); //rate unit id
					dao.setQryValue(nQueryIndex, 8, "1"); //approved type
					dao.setQryValue(nQueryIndex, 9, vo.getStrItemKitName()); //specifications
					dao.setQryValue(nQueryIndex, 10, "ok"); //remarks
					dao.setQryValue(nQueryIndex, 11, vo.getStrSeatId());
					dao.setQryValue(nQueryIndex, 12, "251001"); //Item Type Id is hardcoded as discussed with Shalini Ma'am. I have created a new itemtype id in "hstt_itemtype_mst" table under itemtype id=251001
					dao.setQryValue(nQueryIndex, 13, vo.getStrIsValid());
					
					dao.execute(nQueryIndex, 0);
					
					System.out.println("global hosp code ------->---> "+vo.getStrHospiCode());
					System.out.println("misc item cat no  ------->---> "+ "25"); //misc item kit category no
					System.out.println("misc item kit name  ------->---> "+vo.getStrItemKitName());
					System.out.println("misc item kit rate  ------->---> "+ vo.getStrItemKitRate());
					System.out.println("rate unit id  ------->---> "+"6301"); //rate unit id
					System.out.println("approved type  ------->---> "+ "1"); //approved type
					System.out.println("specs  ------->---> "+vo.getStrItemKitName()); //specifications
					System.out.println("remarks  ------->---> "+ "ok"); //remarks
					System.out.println("seat id  ------->---> "+vo.getStrSeatId());
					

			synchronized (dao) 
			{
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.insertQuery() --> "
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
	 * retrieves and executes modify Query.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void modifyQuery(DossierItemBrandMstVO vo) {

		HisDAO dao = new HisDAO("dossier", "DossierItemBrandMstDAO");
		WebRowSet web = null;
		int nqryIndex;
		String strquery = new String();
		String strBillingMode = "";

		try {
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierMiscData.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			dao.setQryValue(nqryIndex, 3, vo.getStrMiscId());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) 
			{
				vo.setStrItemKitName(web.getString(1));
				vo.setStrItemKitDescription(web.getString(2));
				vo.setStrBillingMode(web.getString(3));
				vo.setStrItemKitRate(web.getString(4));
			}
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DeptNameCombo.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());

			web = dao.executeQry(nqryIndex);
			vo.setStrDeptNameWS(web);
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierMiscItemNameList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrMiscId());
			dao.setQryValue(nqryIndex, 2, vo.getStrMiscId());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setItemDetailWS(web);
			
			/*
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierMiscItemData.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			dao.setQryValue(nqryIndex, 3, vo.getStrMiscId());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemBrandId());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) 
			{
				vo.setStrIsValid(web.getString(1));
				vo.setStrIsMisc(web.getString(2));
			}
			
			System.out.println("******** "+vo.getStrIsValid()+" --->> "+vo.getStrIsMisc());
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.selectedRightDossierItemBrandList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospCode());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setStrRightRequestTypeListWs(web);
			
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.selectedLeftDossierItemBrandList.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 4, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 5, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 6, vo.getStrHospCode());
			
			web = dao.executeQry(nqryIndex);
			
			vo.setStrLeftRequestTypesListWs(web);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.modifyQuery() --> "
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
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void chkUpdateDuplicate(DossierItemBrandMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("dossier", "DossierItemBrandMstDAO");
			strquery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrandMst.4");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrMiscId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospCode());

			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(false);
			} else {
				vo.setBExistStatus(true);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DossierItemBrandMstDAO.chkUpdateDuplicate() --> "
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
	 * retrieves and executes update Query.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(DossierItemBrandMstVO vo) {

		HisDAO dao = null;
		WebRowSet web = null;
		String strQuery = "";
		int nQueryIndex = 0;
		String strSlNo="",strItemTypeId="";

		try {

			dao = new HisDAO("dossier", "DossierItemBrandMstDAO");
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.DossierMiscMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrMiscId());
			
			dao.execute(nQueryIndex, 0);
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierPreviousItemBrand.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrMiscId());
			
			dao.execute(nQueryIndex, 0);
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "delete.PreviousItemBrandMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemBrandId());
			
			dao.execute(nQueryIndex, 0);
			
			synchronized (dao) 
			{
				dao.fire();
			}
			
			/*System.out.println("After dao.fire() in updateQuery()");
			for(int i=0;i<vo.getStrRightRequestTypes().length;i++){
				System.out.println("new right list --->>> "+i+" --> "+vo.getStrRightRequestTypes()[i]);
				
			}*/
			updateInsertQuery(vo);
			

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.updateQuery() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void updateInsertQuery1(DossierItemBrandMstVO vo){
		HisDAO dao = null;
		WebRowSet web = null;
		String strquery = "";
		String[] itemId = null;
		String[] itemBrandId = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		
		String [] paramVal=null , userValue=null;
		String strMiscId="", strCatNo="",strItemTypeId="", strSlNo="";
		try{
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.slNo.0");
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
			
			if(vo.getStrIsValid().equals("1")){
				if(vo.getItemParamValue() !=null){						
					
					int  length = vo.getStrQtyText1().length;	
		               
						for(int k=0;k<length;k++)
						{
							if(vo.getStrQtyText1()[k] != null && vo.getStrQtyText1()[k].length() > 0 && !vo.getStrQtyText1()[k].equals("0"))
							{
								strSlNoInt=Integer.parseInt(strSlNo)+1;
								strSlNo=Integer.toString(strSlNoInt);
								
								String strStoreId="10201101";

								strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItemBrand.0");
								
								nQueryIndex = dao.setQuery(strQuery);
								dao.setQryValue(nQueryIndex, 1, vo.getStrMiscId());
								dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
								dao.setQryValue(nQueryIndex, 3, strSlNo);
								dao.setQryValue(nQueryIndex, 4, "1");
								dao.setQryValue(nQueryIndex, 5, vo.getStrItemIdArray()[k]); //item id
								dao.setQryValue(nQueryIndex, 6, vo.getStrItemBrandIdArray()[k]); //itembrand id
								dao.setQryValue(nQueryIndex, 7, vo.getStrItemBrandIdArray()[k].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
								dao.setQryValue(nQueryIndex, 8, "1");
								dao.setQryValue(nQueryIndex, 9, vo.getStrItemTypeIdArray()[k]); //item type id
								dao.setQryValue(nQueryIndex, 10, "1");
								dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText1()[k]); //default qty
								dao.setQryValue(nQueryIndex, 12, "1");
								dao.setQryValue(nQueryIndex, 13, "1"); //is misc item
								dao.setQryValue(nQueryIndex, 14, strStoreId);
								dao.setQryValue(nQueryIndex, 15, vo.getStrItemBrandIdArray()[k]); //item tariff id
								dao.setQryValue(nQueryIndex, 16, vo.getStrCurrentDate());
								dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
								dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
								dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText1()[k]); //default rate
								
							
								dao.execute(nQueryIndex, 0);
								
								System.out.println("misc id -------> "+k+"---> "+vo.getStrMiscId());
								System.out.println("vo.getStrItemBrandId() -------> "+vo.getStrItemBrandIdArray()[k]);
								System.out.println("item id ---->>>>>>"+vo.getStrItemIdArray()[k]);
								System.out.println("sl no ---->>>>>>"+strSlNo);
								System.out.println("hosp code ---->>>>>>"+vo.getStrHospCode());
								System.out.println("cat no ---->>>>>>"+vo.getStrItemBrandIdArray()[k].substring(0,2));
								System.out.println("item type id ---->>>>>>"+vo.getStrItemTypeIdArray()[k]);
								System.out.println("entry date ---->>>>>>"+vo.getStrCurrentDate());
								System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
								System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
								System.out.println("qty--->>>>>>"+vo.getStrQtyText1()[k]);
								System.out.println("default rate--->>>>>>"+vo.getStrDefRateText1()[k]);

							}
						}
				}
				
				System.out.println("in if part of gnum is valid");
							
			}
			else{
				if(vo.getItemParamValue() !=null){						
					
					int  length = vo.getItemParamValue().length;	
		               
						for(int k=0;k<length;k++)
						{
							if(vo.getStrQtyText1()[k] != null && vo.getStrQtyText1()[k].length() > 0 && !vo.getStrQtyText1()[k].equals("0"))
							{
								strSlNoInt=Integer.parseInt(strSlNo)+1;
								strSlNo=Integer.toString(strSlNoInt);
								
								String strStoreId="10201101";

								paramVal = vo.getItemParamValue()[k].split("#");						
								userValue = paramVal[2].replace('^', '#').split("#");	

								strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItemBrand.0");
								
								nQueryIndex = dao.setQuery(strQuery);
								dao.setQryValue(nQueryIndex, 1, vo.getStrMiscId());
								dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
								dao.setQryValue(nQueryIndex, 3, strSlNo);
								dao.setQryValue(nQueryIndex, 4, "1");
								dao.setQryValue(nQueryIndex, 5, vo.getStrItemIdArray()[k]); //item id
								dao.setQryValue(nQueryIndex, 6, vo.getStrItemBrandIdArray()[k]); //itembrand id
								dao.setQryValue(nQueryIndex, 7, vo.getStrItemBrandIdArray()[k].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
								dao.setQryValue(nQueryIndex, 8, "1");
								dao.setQryValue(nQueryIndex, 9, vo.getStrItemTypeIdArray()[k]); //item type id
								dao.setQryValue(nQueryIndex, 10, "1");
								dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText1()[k]); //default qty
								dao.setQryValue(nQueryIndex, 12, "1");
								dao.setQryValue(nQueryIndex, 13, "1"); //is misc item
								dao.setQryValue(nQueryIndex, 14, strStoreId);
								dao.setQryValue(nQueryIndex, 15, vo.getStrItemBrandIdArray()[k]); //item tariff id
								dao.setQryValue(nQueryIndex, 16, vo.getStrCurrentDate());
								dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
								dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
								dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText1()[k]); //default rate
								
							
								dao.execute(nQueryIndex, 0);
								
								System.out.println("misc id -------> "+k+"---> "+vo.getStrMiscId());
								System.out.println("vo.getStrItemBrandId() -------> "+vo.getStrItemBrandIdArray()[k]);
								System.out.println("item id ---->>>>>>"+vo.getStrItemIdArray()[k]);
								System.out.println("sl no ---->>>>>>"+strSlNo);
								System.out.println("hosp code ---->>>>>>"+vo.getStrHospCode());
								System.out.println("cat no ---->>>>>>"+vo.getStrItemBrandIdArray()[k].substring(0,2));
								System.out.println("item type id ---->>>>>>"+vo.getStrItemTypeIdArray()[k]);
								System.out.println("entry date ---->>>>>>"+vo.getStrCurrentDate());
								System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
								System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
								System.out.println("qty--->>>>>>"+vo.getStrQtyText1()[k]);
								System.out.println("default rate--->>>>>>"+vo.getStrDefRateText1()[k]);
							}
						}
				}
				
				System.out.println("in else part of gnum is valid");
						
			}
			
			synchronized (dao) 
			{
				dao.fire();
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.updateInsertQuery1() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void updateInsertQuery(DossierItemBrandMstVO vo){
		HisDAO dao = null;
		WebRowSet web = null;
		String strquery = "";
		String[] itemId = null;
		String[] itemBrandId = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		
		String [] paramVal=null , userValue=null;
		String strMiscId="", strCatNo="",strItemTypeId="", strSlNo="", strMiscId1="";
		try{
			dao = new HisDAO("dossier", "DossierItemMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.miscId.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strMiscId1 = web.getString(1);
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItemBrand.slNo.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strSlNo = web.getString(1);
			}
			
			if(strSlNo.equals("")){
				strSlNo="1";
			}
			
			vo.setStrMiscId(strMiscId1);
			
			System.out.println("misc id after increment in updateInsertQuery() --->>> "+vo.getStrMiscId());
			
			System.out.println("new dept code in updateInsertQuery() --->>> "+vo.getStrNewDeptName());
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierMisc.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrMiscId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrItemKitName());
			dao.setQryValue(nQueryIndex, 4, vo.getStrItemKitDescription());
			dao.setQryValue(nQueryIndex, 5, "1");
			dao.setQryValue(nQueryIndex, 6, vo.getStrItemKitName()); //service name
			dao.setQryValue(nQueryIndex, 7, vo.getStrBillingMode());
			dao.setQryValue(nQueryIndex, 8, "1");
			dao.setQryValue(nQueryIndex, 9, vo.getStrCurrentDate());
			dao.setQryValue(nQueryIndex, 10, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 11, vo.getStrIsValid());
			dao.setQryValue(nQueryIndex, 12, vo.getStrItemKitRate());
			dao.setQryValue(nQueryIndex, 13, vo.getStrNewDeptName());
			dao.setQryValue(nQueryIndex, 14, vo.getStrHospiCode());
			dao.execute(nQueryIndex, 0);
			
			int strSlNoInt;
			
			if(vo.getStrIsValid().equals("1")){
				if(vo.getItemParamValue() !=null){						
					
					int  length = vo.getItemParamValue().length;	
		               
						for(int k=0;k<length;k++)
						{
							if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
							{
								strSlNoInt=Integer.parseInt(strSlNo)+1;
								strSlNo=Integer.toString(strSlNoInt);
								
								String strStoreId="10201101";

								paramVal = vo.getItemParamValue()[k].split("#");						
								userValue = paramVal[2].replace('^', '#').split("#");	

								strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItemBrand.0");
								
								nQueryIndex = dao.setQuery(strQuery);
								dao.setQryValue(nQueryIndex, 1, vo.getStrMiscId());
								dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
								dao.setQryValue(nQueryIndex, 3, strSlNo);
								dao.setQryValue(nQueryIndex, 4, "1");
								dao.setQryValue(nQueryIndex, 5, userValue[0]); //item id
								dao.setQryValue(nQueryIndex, 6, userValue[1]); //itembrand id
								dao.setQryValue(nQueryIndex, 7, userValue[1].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
								dao.setQryValue(nQueryIndex, 8, "1");
								dao.setQryValue(nQueryIndex, 9, userValue[14]); //item type id
								dao.setQryValue(nQueryIndex, 10, "1");
								dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText()[k]); //default qty
								dao.setQryValue(nQueryIndex, 12, "1");
								dao.setQryValue(nQueryIndex, 13, "1"); //is misc item
								dao.setQryValue(nQueryIndex, 14, strStoreId);
								dao.setQryValue(nQueryIndex, 15, userValue[1]); //item tariff id
								dao.setQryValue(nQueryIndex, 16, vo.getStrCurrentDate());
								dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
								dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
								dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText()[k]); //default rate
								
							
								dao.execute(nQueryIndex, 0);
								
								System.out.println("misc id -------> "+k+"---> "+strMiscId);
								System.out.println("vo.getStrItemBrandId() -------> "+userValue[1]);
								System.out.println("item id ---->>>>>>"+userValue[0]);
								System.out.println("sl no ---->>>>>>"+strSlNo);
								System.out.println("hosp code ---->>>>>>"+vo.getStrHospCode());
								System.out.println("cat no ---->>>>>>"+userValue[1].substring(0,2));
								System.out.println("item type id ---->>>>>>"+userValue[14]);
								System.out.println("entry date ---->>>>>>"+vo.getStrCurrentDate());
								System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
								System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
								System.out.println("qty--->>>>>>"+vo.getStrQtyText()[k]);
								System.out.println("default rate--->>>>>>"+vo.getStrDefRateText()[k]);

							}
						}
				}
				
				System.out.println("in if part of gnum is valid");
						strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierMiscItemBrandMst.0");
						nQueryIndex = dao.setQuery(strQuery);
						dao.setQryValue(nQueryIndex, 1, vo.getStrHospiCode());
						dao.setQryValue(nQueryIndex, 2, "25000001");//Item Id is hardcoded as discussed with Shalini Ma'am. I have created a new item id in "hstt_item_mst" table under item id=25000001
						dao.setQryValue(nQueryIndex, 3, vo.getStrHospiCode());
						dao.setQryValue(nQueryIndex, 4, "25"); //misc item kit category no
						dao.setQryValue(nQueryIndex, 5, vo.getStrItemKitName());
						dao.setQryValue(nQueryIndex, 6, vo.getStrItemKitRate());
						dao.setQryValue(nQueryIndex, 7, "6301"); //rate unit id
						dao.setQryValue(nQueryIndex, 8, "1"); //approved type
						dao.setQryValue(nQueryIndex, 9, vo.getStrItemKitName()); //specifications
						dao.setQryValue(nQueryIndex, 10, "ok"); //remarks
						dao.setQryValue(nQueryIndex, 11, vo.getStrSeatId());
						dao.setQryValue(nQueryIndex, 12, "251001"); //Item Type Id is hardcoded as discussed with Shalini Ma'am. I have created a new itemtype id in "hstt_itemtype_mst" table under itemtype id=251001
						dao.setQryValue(nQueryIndex, 13, vo.getStrIsValid());
						
						dao.execute(nQueryIndex, 0);
						
						System.out.println("global hosp code ------->---> "+vo.getStrHospiCode());
						System.out.println("misc item cat no  ------->---> "+ "25"); //misc item kit category no
						System.out.println("misc item kit name  ------->---> "+vo.getStrItemKitName());
						System.out.println("misc item kit rate  ------->---> "+ vo.getStrItemKitRate());
						System.out.println("rate unit id  ------->---> "+"6301"); //rate unit id
						System.out.println("approved type  ------->---> "+ "1"); //approved type
						System.out.println("specs  ------->---> "+vo.getStrItemKitName()); //specifications
						System.out.println("remarks  ------->---> "+ "ok"); //remarks
						System.out.println("seat id  ------->---> "+vo.getStrSeatId());
						
				
			}
			else{
				if(vo.getItemParamValue() !=null){						
					
					int  length = vo.getItemParamValue().length;	
		               
						for(int k=0;k<length;k++)
						{
							if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
							{
								strSlNoInt=Integer.parseInt(strSlNo)+1;
								strSlNo=Integer.toString(strSlNoInt);
								
								String strStoreId="10201101";

								paramVal = vo.getItemParamValue()[k].split("#");						
								userValue = paramVal[2].replace('^', '#').split("#");	

								strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierItemBrand.0");
								
								nQueryIndex = dao.setQuery(strQuery);
								dao.setQryValue(nQueryIndex, 1, strMiscId1);
								dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
								dao.setQryValue(nQueryIndex, 3, strSlNo);
								dao.setQryValue(nQueryIndex, 4, "1");
								dao.setQryValue(nQueryIndex, 5, userValue[0]); //item id
								dao.setQryValue(nQueryIndex, 6, userValue[1]); //itembrand id
								dao.setQryValue(nQueryIndex, 7, userValue[1].substring(0,2)); //item cat no //Category no is 1st 2 digits of itembrand no.
								dao.setQryValue(nQueryIndex, 8, "1");
								dao.setQryValue(nQueryIndex, 9, userValue[14]); //item type id
								dao.setQryValue(nQueryIndex, 10, "1");
								dao.setQryValue(nQueryIndex, 11, vo.getStrQtyText()[k]); //default qty
								dao.setQryValue(nQueryIndex, 12, "1");
								dao.setQryValue(nQueryIndex, 13, "1"); //is misc item
								dao.setQryValue(nQueryIndex, 14, strStoreId);
								dao.setQryValue(nQueryIndex, 15, userValue[1]); //item tariff id
								dao.setQryValue(nQueryIndex, 16, vo.getStrCurrentDate());
								dao.setQryValue(nQueryIndex, 17, vo.getStrSeatId());
								dao.setQryValue(nQueryIndex, 18, vo.getStrIsValid());
								dao.setQryValue(nQueryIndex, 19, vo.getStrDefRateText()[k]); //default rate
								
							
								dao.execute(nQueryIndex, 0);
								
								System.out.println("misc id -------> "+k+"---> "+strMiscId);
								System.out.println("vo.getStrItemBrandId() -------> "+userValue[1]);
								System.out.println("item id ---->>>>>>"+userValue[0]);
								System.out.println("sl no ---->>>>>>"+strSlNo);
								System.out.println("hosp code ---->>>>>>"+vo.getStrHospCode());
								System.out.println("cat no ---->>>>>>"+userValue[1].substring(0,2));
								System.out.println("item type id ---->>>>>>"+userValue[14]);
								System.out.println("entry date ---->>>>>>"+vo.getStrCurrentDate());
								System.out.println("seat id ---->>>>>>"+vo.getStrSeatId());
								System.out.println("gnum is valid ---->>>>>>"+vo.getStrIsValid());
								System.out.println("qty--->>>>>>"+vo.getStrQtyText()[k]);
								System.out.println("default rate--->>>>>>"+vo.getStrDefRateText()[k]);

							}
						}
				}
				
				System.out.println("in else part of gnum is valid");
						strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossierMiscItemBrandMst.0");
						nQueryIndex = dao.setQuery(strQuery);
						dao.setQryValue(nQueryIndex, 1, vo.getStrHospiCode());
						dao.setQryValue(nQueryIndex, 2, "25000001");//Item Id is hardcoded as discussed with Shalini Ma'am. I have created a new item id in "hstt_item_mst" table under item id=25000001
						dao.setQryValue(nQueryIndex, 3, vo.getStrHospiCode());
						dao.setQryValue(nQueryIndex, 4, "25"); //misc item kit category no
						dao.setQryValue(nQueryIndex, 5, vo.getStrItemKitName());
						dao.setQryValue(nQueryIndex, 6, vo.getStrItemKitRate());
						dao.setQryValue(nQueryIndex, 7, "6301"); //rate unit id
						dao.setQryValue(nQueryIndex, 8, "1"); //approved type
						dao.setQryValue(nQueryIndex, 9, vo.getStrItemKitName()); //specifications
						dao.setQryValue(nQueryIndex, 10, "ok"); //remarks
						dao.setQryValue(nQueryIndex, 11, vo.getStrSeatId());
						dao.setQryValue(nQueryIndex, 12, "251001"); //Item Type Id is hardcoded as discussed with Shalini Ma'am. I have created a new itemtype id in "hstt_itemtype_mst" table under itemtype id=251001
						dao.setQryValue(nQueryIndex, 13, vo.getStrIsValid());
						
						dao.execute(nQueryIndex, 0);
						
						System.out.println("global hosp code ------->---> "+vo.getStrHospiCode());
						System.out.println("misc item cat no  ------->---> "+ "25"); //misc item kit category no
						System.out.println("misc item kit name  ------->---> "+vo.getStrItemKitName());
						System.out.println("misc item kit rate  ------->---> "+ vo.getStrItemKitRate());
						System.out.println("rate unit id  ------->---> "+"6301"); //rate unit id
						System.out.println("approved type  ------->---> "+ "1"); //approved type
						System.out.println("specs  ------->---> "+vo.getStrItemKitName()); //specifications
						System.out.println("remarks  ------->---> "+ "ok"); //remarks
						System.out.println("seat id  ------->---> "+vo.getStrSeatId());
			}
			
			synchronized (dao) 
			{
				dao.fire();
			}
			updateInsertQuery1(vo);
			vo.setStrMsgType("0");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.updateInsertQuery1() --> "
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
	 * View.
	 * 
	 * @param vo the vo
	 */
	public static void view(DossierItemBrandMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("dossier", "DossierItemBrandMstDAO");
			
			String strIsValid=vo.getStrIsValid();
						
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "view.dossierMiscItemBrandMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrMiscId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 4, strIsValid);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				vo.setStrItemKitName(web.getString(1));
				vo.setStrItemKitDescription(web.getString(2));
				vo.setStrBillingMode(web.getString(3));
				vo.setStrItemKitRate(web.getString(4));
				vo.setStrIsValid(web.getString(5));
				vo.setStrDeptName(web.getString(6));
				vo.setStrEffectiveFrom(web.getString(7));
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "view.dossierMiscItemBrandMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strIsValid);
			dao.setQryValue(nQueryIndex, 2, vo.getStrMiscId());
			dao.setQryValue(nQueryIndex, 3, strIsValid);
			dao.setQryValue(nQueryIndex, 4, vo.getStrMiscId());
						
			web = dao.executeQry(nQueryIndex);
			vo.setItemDetailWS(web);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierItemBrandMstDAO.view() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}
		
}

