package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.ShortenURLMstVO;
import mms.transactions.vo.LocalPurchaseMRN_VO;


/**
 * @author Niharika Srivastava 
 * Date Of Creation : Aug 25, 2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Drug Contradiction Master
 * Description : Data Access Object for Drug Contradiction Master 
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class ShortenURLMstDAO {

	/*
	 * for getting option value of Group Name combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(ShortenURLMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		System.out.println("--------ShortenURLMstDAO.initAddQuery-------");
		try {

			dao = new HisDAO("mms", "ShortenURLMstDAO");

//			strquery = mms.qryHandler_mms.getQuery(1,"select.ContradictedDrug.1");
//			nqryIndex = dao.setQuery(strquery);

//			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
//			dao.setQryValue(nqryIndex, 2, "10");
//
//			wb = dao.executeQry(nqryIndex);
//
//			vo.setStrGroupComboWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> ShortenURLMstDAO.initAddQuery()-->"
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
	 * for getting option value of Drug Name combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void getDrugNameComboQuery(ShortenURLMstVO vo) {
		
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		System.out.println("--------ShortenURLMstDAO.getDrugNameComboQuery-------");
		try {
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.ContradictedDrug.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrDrugNameComboWs(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString(" --> DrugContradictionMstDAO.getDrugNameComboQuery()-->"
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
	 * for getting option value of Contradicted Drugs Left & Right List Boxes on add page.
	 * 
	 * @param vo the vo
	 */
	public static void getLeftDrugList(ShortenURLMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		System.out.println("--------ShortenURLMstDAO.getLeftDrugList-------");
		try {

			dao = new HisDAO("mms", "DrugContradictionMstDAO");

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.ContraDrugList.0");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, "10");
			dao.setQryValue(nqryIndex, 2, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 5, vo.getStrHospitalCode());

			 wb = dao.executeQry(nqryIndex);
			 vo.setLeftItemListWS(wb);

			 dao = new HisDAO("mms", "DrugContradictionMstDAO");
			 strquery =
			 mms.qryHandler_mms.getQuery(1,"select.ContraDrugList.1");
			 nqryIndex = dao.setQuery(strquery);
			 
			 dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			 dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 

			 wb = dao.executeQry(nqryIndex);
			 vo.setRightItemListWS(wb);
			 	
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugContradictionMstDAO.getLeftDrugList()-->"
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
	 * for inserting the record.
	 * 
	 * @param vo the vo
	 */
	
	public static void insertQuery(ShortenURLMstVO vo)
	{
		
		String strProcName = "{call pkg_mms_view.proc_shorten_url_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","ShortenURLMstDAO");
			
//			System.out.println("-------formBean.getStrBaseId()------"+vo.getStrBaseId());
//			System.out.println("-------formBean.getStrOrgID()------"+vo.getStrOrgID());
//			System.out.println("-------formBean.getStrProId()------"+vo.getStrProId());
//			System.out.println("-------formBean.getStrHospitalCode()------"+vo.getStrHospitalCode());
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);  	                 //------------------------1
			daoObj.setProcInValue(nProcIndex, "baseURL", vo.getStrBaseId(),2);       //------------------------2
			daoObj.setProcInValue(nProcIndex, "orgURL", vo.getStrOrgID(),3);	     //------------------------3
			daoObj.setProcInValue(nProcIndex, "proURL", vo.getStrProId(),4);         //------------------------4
			daoObj.setProcInValue(nProcIndex, "hosp", vo.getStrHospitalCode(),5);    //------------------------5
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 						     //------------------------6
			daoObj.execute(nProcIndex,1);	
			
			synchronized (daoObj) 
			{
				daoObj.fire();
			}
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (!strErr.equals("")) 
			{
				throw new Exception(strErr);
			}			

		}
		catch(Exception _err)
		{
			vo.setStrMsgString("ShortenURLMstDAO.insertQuery() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}
	
	
	/**
	 * Not In Use
	 * 
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	
	public static void chkDuplicate(ShortenURLMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();
		System.out.println("--------ShortenURLMstDAO.chkDuplicate-------");
		try {
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ContradictedDrug.5");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());
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
			vo.setStrMsgString("DrugContradictionMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	
	public static void modifyRecord(ShortenURLMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		System.out.println("--------ShortenURLMstDAO.modifyRecord-------");
		try {
			/*Set Left List*/
			
			dao = new HisDAO("mms", "DrugContradictionMstDAO");

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.ContraDrugList.0");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, "10");
			dao.setQryValue(nqryIndex, 2, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 5, vo.getStrHospitalCode());

			 wb = dao.executeQry(nqryIndex);
			 vo.setLeftItemListWS(wb);
			 if (dao != null) {
					dao.free();
					dao = null;
				}
			 dao = new HisDAO("mms", "DrugContradictionMstDAO");
			 strquery =
			 mms.qryHandler_mms.getQuery(1,"select.ContraDrugList.2");
			 nqryIndex = dao.setQuery(strquery);
			 
			 dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			 dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());

			 wb = dao.executeQry(nqryIndex);
			 vo.setRightItemListWS(wb);
			 if (dao != null) {
					dao.free();
					dao = null;
				}
			 
			/*Set Other Fields*/ 
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.ContradictedDrug.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrDrugName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrIsValid(web.getString(4));
				
			}
		} catch (Exception e) {

			vo.setStrMsgString("DrugContradictionMstDAO.modifyQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

		
	}
	
	public static void updateQuery(ShortenURLMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		int nqryIndex1;
		int nFuncIndex;
		String strFuncName="";
		String strquery = "";
		String strquery1 = "";
		System.out.println("--------ShortenURLMstDAO.updateQuery-------");
		try {
		
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			
			strquery = mms.qryHandler_mms.getQuery(1,"update.ContradictedDrug.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());
			
			dao.execute(nqryIndex,0);
			
			strFuncName = "{? = call MMS_MST.get_contra_drug_slno(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrDrugId());
			
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String strContraSlNo = dao.getFuncString(nFuncIndex);
			vo.setStrContraDrugSlNo(strContraSlNo);
				
			strquery1 = mms.qryHandler_mms.getQuery(1, "insert.ContradictedDrug.0");
			nqryIndex1 = dao.setQuery(strquery1);
					
			dao.setQryValue(nqryIndex1, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 3, vo.getStrContraDrugsId());
			dao.setQryValue(nqryIndex1, 4, vo.getStrContraDrugSlNo());
			dao.setQryValue(nqryIndex1, 5, vo.getStrRemarks());
			dao.setQryValue(nqryIndex1, 6, vo.getStrEffectiveFrom());
			dao.setQryValue(nqryIndex1, 7, vo.getStrSeatId());
			dao.setQryValue(nqryIndex1, 8, vo.getStrIsValid());
			
			dao.execute(nqryIndex1,0);
			
			synchronized (dao) {
				dao.fire();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugContradictionMstDAO.updateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}
	
	public static void contradicView(ShortenURLMstVO vo){
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		System.out.println("--------ShortenURLMstDAO.contradicView-------");
	try {
		
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			
			strquery = mms.qryHandler_mms.getQuery(1,"select.ContradictedDrug.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());
			
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				vo.setStrDrugName(wb.getString(1));
				vo.setStrRemarks(wb.getString(3));
				vo.setStrEffectiveFrom(wb.getString(2));
				vo.setStrIsValid(wb.getString(4));
				
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("DrugContradictionMstDAO.updateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getContDrugName(ShortenURLMstVO vo){
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		System.out.println("--------ShortenURLMstDAO.getContDrugName-------");
	try {
		
			dao = new HisDAO("mms", "DrugContradictionMstDAO");
			
			strquery = mms.qryHandler_mms.getQuery(1,"select.ContradictedDrug.6");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDrugId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrContraDrugSlNo());
			
			wb = dao.executeQry(nqryIndex);
			vo.setContraDrugNameWs(wb);
		} catch (Exception e) {
			vo.setStrMsgString("DrugContradictionMstDAO.updateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
}
