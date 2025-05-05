package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.MmsConfigPenaltyDAO;
import mms.masters.vo.MmsConfigMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstDAO.
 */
public class MmsConfigMstDAO 
{
	
	

	/**
	 * Gets the .
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the penalty details
	 */
	public static void getPenaltyInitDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

		
			/**
			 * For Purchase Type Combo
			 */
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMstPurCombo.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			if(wb!=null){
				vo.setWsPurchaseType(wb);
			}
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMstPenBreakRej.1");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			if(wb!=null){
				if(wb.next()){
					vo.setStrPenRejBreak(wb.getString(1));
				}
			}
			
			/*
			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				vo.setWsPenaltyDetailsList(wb);

			}*/
			
			

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstDAO.getPenaltyInitDetails() --> "
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
	 * Gets the penalty details.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the penalty details
	 */
	public static void getPenaltyDetails(MmsConfigMstVO _MmsConfigMstVO) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, _MmsConfigMstVO.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, _MmsConfigMstVO.getStrPurchaseType());
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				_MmsConfigMstVO.setWsPenaltyDetailsList(wb);

			}
		} catch (Exception e) {

			_MmsConfigMstVO.setStrMsgString("MmsConfigMstDAO.getPenaltyDetails() --> "
					+ e.getMessage());
			_MmsConfigMstVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	

	/**
	 * Insert query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void updateStoreDtlsQuery(MmsConfigMstVO vo) {

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "MmsConfigMstDAO");

			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.2");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrFinancialStartDate());
			dao.setQryValue(nQueryIndex, 2, vo.getStrFinancialEndDate());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, vo.getStrStoreId());

			dao.execute(nQueryIndex, 0);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> MmsConfigMstDAO.updateStoreDtlsQuery()-->"
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
	 * Insert query.
	 * 
	 * @param vo
	 *            the vo
	 * @throws Exception 
	 */
	public static void updateDrugMaster(MmsConfigMstVO vo) throws Exception 
	{

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.drugMaster.mmsConfigMst");
		HisDAO hisDao = new HisDAO("MMS Setup",	"MmsConfigUpdateDAO.updateDrugMaster()");

		try 
		{
			int qryIndex1 = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex1, 1, vo.getStrConfigIssueRate());
			hisDao.setQryValue(qryIndex1, 2, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex1, 3, "SERVICE_TAX");
			hisDao.execute(qryIndex1, 0);

			
			synchronized (hisDao) 
			{
				hisDao.fire();
			}

			retVal = true;

		} 
		catch (Exception e) 
		{
			retVal = false;
			throw new Exception("DAOBillSetup.updateDrugMaster()-->"	+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

	}

	
	

	/**
	 * Insert query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertStoreHistDtlsQuery(MmsConfigMstVO vo) {

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "MmsConfigMstDAO");

			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.mmsConfigMst.1");
			nQueryIndex = dao.setQuery(strQuery);

			
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrStoreId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, vo.getStrItemCategoryCode());
			dao.setQryValue(nQueryIndex, 6, vo.getStrPreviousStockLedgerRequired());
			dao.setQryValue(nQueryIndex, 7, vo.getStrIsStockLedgerRequired());
			dao.setQryValue(nQueryIndex, 8, vo.getStrIpAddress());
			dao.setQryValue(nQueryIndex, 9, vo.getStrSeatId());

			dao.execute(nQueryIndex, 0);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			e.printStackTrace();

			vo
					.setStrMsgString("--> MmsConfigMstDAO.insertStoreHistDtlsQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void setOpenBalance(MmsConfigMstVO vo) {
		String strproc_name = "{call Pkg_Mms_Dml.Dml_opbalance_dtl(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		try {
			dao = new HisDAO("MMS", "masters.MmsConfigMstDAO.setOpenBalance()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "strId", vo.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryCode(),4);
			dao.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),5);
			
			
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "itemId", "",6);
			dao.setProcInValue(nProcIndex, "itemBrandId", "",7);
			dao.setProcInValue(nProcIndex, "batchNo", "0",8);
			dao.setProcInValue(nProcIndex, "itemSlNo", "0",9);
			dao.setProcInValue(nProcIndex, "stkStatus", "",10);
			dao.setProcInValue(nProcIndex, "particulars", "",11);
			dao.setProcInValue(nProcIndex, "transNo", "",12);
			dao.setProcInValue(nProcIndex, "reqTypeId", "",13);
			dao.setProcInValue(nProcIndex, "issueQty", "0",14);
			dao.setProcInValue(nProcIndex, "issueQtyUnitId", "",15);
			dao.setProcInValue(nProcIndex, "recQty", "0",16);
			dao.setProcInValue(nProcIndex, "recQtyUnitId", "",17);
			dao.setProcInValue(nProcIndex, "expiryDate", "",18);
			dao.setProcInValue(nProcIndex, "grpId", "",19);
			dao.setProcInValue(nProcIndex, "subGrpId", "0",20);
			dao.setProcInValue(nProcIndex, "rate", "0",21);
			dao.setProcInValue(nProcIndex, "rateUnitId", "",22);
			dao.setProcInValue(nProcIndex, "old_batchNo", "0",23);
			dao.setProcInValue(nProcIndex, "old_itemSlNo", "0",24);
			dao.setProcInValue(nProcIndex, "old_stkStatus", "",25);
			dao.setProcInValue(nProcIndex, "item_specification", "",26);
			dao.setProcInValue(nProcIndex, "suppId", "0",27);
			/* Setting Default Value End */
			 
			dao.setProcInValue(nProcIndex, "transdate", "",28);
			dao.setProcOutValue(nProcIndex, "err", 1,29);

			dao.executeProcedureByPosition(nProcIndex);

			

		} catch (Exception e) {

			e.printStackTrace();
			vo.setStrMsgString("MmsConfigMstDAO.setOpenBalance() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getStoreDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.2");
			
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
		//	dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				vo.setWsStoreDetailsList(wb);

			}

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstDAO.getStoreDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getCategoryCmb(MmsConfigMstVO vo) 
	{

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.group.itemcategory.0");
			
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
						
			wb = dao.executeQry(nqryIndex);

			if (wb != null) 
			{
				vo.setWsItemCategoryList(wb);
			}

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstDAO.getStoreDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getCountryCmb(MmsConfigMstVO vo) 
	{

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.country.0");
			
			nqryIndex = dao.setQuery(strquery);
			//dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
						
			wb = dao.executeQry(nqryIndex);

			if (wb != null) 
			{
				vo.setWsCountryList(wb);
			}

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstDAO.getCountryCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getStateCmb(MmsConfigMstVO vo) 
	{

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.state.0");
			
			nqryIndex = dao.setQuery(strquery);
			
			
			dao.setQryValue(nqryIndex, 1,"IND");
			//dao.setQryValue(nqryIndex, 2, "101");
					
			wb = dao.executeQry(nqryIndex);
           
			if (wb != null) 
			{
				vo.setWsStateList(wb);
				vo.setStrMsgType("0");
			}
			
			
			
		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstDAO.getStateCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	

	public static String getDateDetails(String strStoreId,
			String strHospitalCode) {

		HisDAO dao = null;
		String date = "";
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, strHospitalCode);
			dao.setQryValue(nqryIndex, 2, strStoreId);
			//System.out.println("-------strquery----------"+strquery.toString());
			wb = dao.executeQry(nqryIndex);

			
			
			
			if (wb != null && wb.next()) {

				date = wb.getString(1) + "^" + wb.getString(2);

			}

		} catch (Exception e) {

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

		return date;
	}
	
	
	/**
	 * Gets the .
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the penalty details
	 */
	public static String getPODemandValidity(String strHospitalCode) 
	{

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();
		String strPODemandActivePeriod ="";

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

		
			/**
			 * Demand Validity Type Added By Amit on Date 16 May 2012
			 */
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMstDemandValidity.1");
			nqryIndex = dao.setQuery(strquery);
			//dao.setQryValue(nqryIndex, 1, strHospitalCode);
			wb = dao.executeQry(nqryIndex);
			if(wb.next())
			{
				strPODemandActivePeriod = wb.getString(1);
			}
						
			

		} 
		catch (Exception e) 
		{

			
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strPODemandActivePeriod;
	}

	/**
	 * Insert query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertQuery(MmsConfigMstVO vo) {

		MmsConfigPenaltyDAO mmsConfigPenaltyDao = null;
		HisDAO dao = null;

		try {
			mmsConfigPenaltyDao = new MmsConfigPenaltyDAO();
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			if (vo.getStrToDays() != null)
				for (int i = 0 , stopI = vo.getStrToDays().length; i < stopI; i++) {

					mmsConfigPenaltyDao.setStrHospitalCode(vo
							.getStrHospitalCode());
					mmsConfigPenaltyDao.setStrFromDays(vo.getStrFromDays()[i]);
					mmsConfigPenaltyDao.setStrToDays(vo.getStrToDays()[i]);
					mmsConfigPenaltyDao.setStrPenalty(vo.getStrPenalty()[i]);
					mmsConfigPenaltyDao.setStrSeatId(vo.getStrSeatId());
					mmsConfigPenaltyDao.setStrPurchaseType(vo.getStrPurchaseType());
					mmsConfigPenaltyDao.insert(dao);

				}

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> MmsConfigMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			mmsConfigPenaltyDao = null;

		}

	}

	/**
	 * Delete query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void deleteQuery(MmsConfigMstVO vo) {

		MmsConfigPenaltyDAO mmsConfigPenaltyDao = null;
		HisDAO dao = null;

		try {
				mmsConfigPenaltyDao = new MmsConfigPenaltyDAO();
				dao = new HisDAO("mms", "MmsConfigMstDAO");
	
				mmsConfigPenaltyDao.setStrHospitalCode(vo.getStrHospitalCode());
				mmsConfigPenaltyDao.setStrPurchaseType(vo.getStrPurchaseType());
				mmsConfigPenaltyDao.delete(dao);
				synchronized (dao) {
					dao.fire();
				}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> MmsConfigMstDAO.deleteQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			mmsConfigPenaltyDao = null;

		}

	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static boolean issueUpdateQuery(MmsConfigMstVO vo) throws Exception {

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.1");
		HisDAO hisDao = new HisDAO("MMS Setup",
				"MmsConfigUpdateDAO.issueUpdateQuery()");

		try {
			int qryIndex1 = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex1, 1, vo.getStrAutoReturnRequest());
			hisDao.setQryValue(qryIndex1, 2, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex1, 3, "RETURN_SUPP_REQ");
			hisDao.execute(qryIndex1, 0);

			synchronized (hisDao) {
				hisDao.fire();
			}

			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("DAOBillSetup.issueUpdateQuery()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}
	
	/**
	 * 
	 * @param strStoreId
	 * @param strHospitalCode
	 * @return
	 * @throws Exception 
	 */
	public static String getActiveDemandDuration(String strHospitalCode) throws Exception 
	{

		HisDAO dao = null;
		String tmp = "";
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.21");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, strHospitalCode);
			dao.setQryValue(nqryIndex, 2, "DEMAND_ACTIVE_DURATION");
			wb = dao.executeQry(nqryIndex);

			if (wb != null && wb.next()) 
			{

				tmp = wb.getString(1);
				

			}

		} 
		catch (Exception e) 
		{
			throw new Exception("MmsConfigMstDAO.getActiveDemandDuration()-->"+ e.getMessage());
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

		return tmp;
	}
		
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static void issueUpdateQueryTwo(MmsConfigMstVO vo) throws Exception 
	{

		
		String tmp;
		try 
		{
			tmp = getActiveDemandDuration(vo.getStrHospitalCode());
			if(tmp.equals("")||tmp=="" ||tmp==" " )
			{
				insertIssueDemandActivePeriod(vo);
			}
			else
			{
				issueUpdateDemandPeriodQuery(vo);
			}	
		} 
		catch (Exception e)
		{
			
			throw new Exception("DAOBillSetup.issueUpdateQueryTwo()-->"
					+ e.getMessage());

		} 
		
		
	}
	

	
	/**
	 * Insert query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertIssueDemandActivePeriod(MmsConfigMstVO vo) 
	{

		HisDAO dao = null;
		try 
		{

			dao = new HisDAO("mms", "MmsConfigMstDAO");

			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.mmsConfigMst.00");
			nQueryIndex = dao.setQuery(strQuery);
	
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, "DEMAND_ACTIVE_DURATION");
			dao.setQryValue(nQueryIndex, 3, vo.getStrDemandActivePrd());
			dao.setQryValue(nQueryIndex, 4, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 5, "NA");
			

			dao.execute(nQueryIndex, 0);

			synchronized (dao) 
			{
				dao.fire();
			}
		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			vo
					.setStrMsgString("--> MmsConfigMstDAO.insertIssueDemandActivePeriod()-->"
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
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static void issueUpdateDemandPeriodQuery(MmsConfigMstVO vo) throws Exception 
	{

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.11");
		HisDAO hisDao = new HisDAO("MMS Setup",	"MmsConfigUpdateDAO.issueUpdateQueryTwo()");

		try 
		{
			
			int qryIndex1 = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex1, 1, vo.getStrDemandActivePrd());
			hisDao.setQryValue(qryIndex1, 2, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex1, 3, "DEMAND_ACTIVE_DURATION");
			hisDao.execute(qryIndex1, 0);

			
			synchronized (hisDao) 
			{
				hisDao.fire();
			}

			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("DAOBillSetup.issueUpdateQueryTwo()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		
	}
	

	/**
	 * Returns Required Value from the table "HSTT_CONFIG_DTL"
	 * 
	 * type --> Value for the Field "HSTSTR_PARAM_VALUE" in the Table
	 * "HSTT_CONFIG_DTL" name --> Value for the Field "HBLSTR_PARAM_NAME" in the
	 * Table "HSTT_CONFIG_DTL"
	 */
	public static void getRetriveValue(MmsConfigMstVO vo) throws Exception {

		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.1");
		HisDAO hisDao = new HisDAO("Mms ConfigMst ",
				"MmsConfigMstDAO.getRetriveValue()");
		String res = null;

		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex, 2, "RETURN_SUPP_REQ");

			WebRowSet wb = hisDao.executeQry(qryIndex);
			while (wb.next()) {
				res = wb.getString(1);
			}

			vo.setStrAutoReturnRequest(res);

		} catch (SQLException e) {

			throw new Exception("MmsConfigMstDAO.getRetriveValue()-->"
					+ e.getMessage());

		} catch (Exception e) {

			throw new Exception("MmsConfigMstDAO.getRetriveValue()-->"
					+ e.getMessage());
		}

	}

	public static void getPhyVerifyStoreDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.4");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			//dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				vo.setWsStoreDetailsList(wb);

			}

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("MmsConfigMstDAO.getPhyVerifyStoreDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getPhyVerifyOtherDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();
		
	
		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.41");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			wb = dao.executeQry(nqryIndex);
		//	if (wb != null) {
     			while(wb.next())
				vo.setStrStoreId(wb.getString(1));
			//}
     		
     		strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.42");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			
			wb = dao.executeQry(nqryIndex);
     	//	if (wb != null) {
     			while(wb.next())
				vo.setStrItemCategoryCode(wb.getString(1));
     		//}
     		
     		strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.43");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			wb = dao.executeQry(nqryIndex);
     		//if (wb != null) {
     			while(wb.next())
				vo.setStrPeriodId(wb.getString(1));
		//	}
     		
     		strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.44");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSeatId());
			wb = dao.executeQry(nqryIndex);
     		//if (wb != null) {
     			while(wb.next())
				vo.setStrIsStockLedgerRequired(wb.getString(1));
			//}

     		
     		
		} catch (Exception e) {
e.printStackTrace();
			vo
					.setStrMsgString("MmsConfigMstDAO.getPhyVerifyStoreDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
		}

	}

	public static void getReportParameterDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		boolean flag = false;
		
		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.8");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);

			if (wb != null && wb.size() > 0) {

				 while(wb.next()){
					 
					 if(!flag){
						 
						 vo.setStrCategoryA(wb.getString(1));
						 vo.setStrCategoryB1(wb.getString(2));
						 vo.setStrCategoryB2(wb.getString(3));
						 vo.setStrCategoryC(wb.getString(4));
						 
					 }else{
						 
						 vo.setStrCategoryF(wb.getString(1));
						 vo.setStrCategoryN1(wb.getString(2));
						 vo.setStrCategoryN2(wb.getString(3));
						 vo.setStrCategoryS(wb.getString(4));
						 
					 }
					 
					 
					 flag = true;
				 }
				

			}

		} catch (Exception e) {

			vo
					.setStrMsgString("MmsConfigMstDAO.getReportParameterDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	
	public static void getPhyVerifyItemCategoryDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.5");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, "69");
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				vo.setWsItemCategoryList(wb);

			}

		} catch (Exception e) {

			e.printStackTrace();
			vo
					.setStrMsgString("MmsConfigMstDAO.getPhyVerifyItemCategoryDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getPeriodListDetails(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.6");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);

			if (wb != null) {

				vo.setWsPeriodList(wb);

			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("MmsConfigMstDAO.getPeriodListDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getIsPeriodAvailable(MmsConfigMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.7");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCategoryCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());
			wb = dao.executeQry(nqryIndex);

			if (wb != null && wb.size() > 0) {

				if (wb.next()) {

					String[] strTemp = wb.getString(1).replace("^", "#").split(
							"#");
					
					vo.setStrPeriodId(strTemp[0]);
					vo.setStrPeriodName(strTemp[1]);
					vo.setStrIsStockLedgerRequired(strTemp[2]);

				}

				if (vo.getStrPeriodName().length() > 1) {

					vo.setStrIsPeriodAvailable("1");

				} else {

					vo.setStrIsPeriodAvailable("0");
				}

			} else {

				vo.setStrIsPeriodAvailable("0");

			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("MmsConfigMstDAO.getIsPeriodAvailable() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static boolean phyVerificationUpdateQuery(MmsConfigMstVO vo) {

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.3");
		HisDAO hisDao = new HisDAO("Bill Setup",
				"DAOBillSetup.jobsUpdateQuery()");

		try {
			
			int nqryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(nqryIndex, 1, vo.getStrPeriodId());
			hisDao.setQryValue(nqryIndex, 2, vo.getStrIsStockLedgerRequired());
			hisDao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			hisDao.setQryValue(nqryIndex, 4, vo.getStrItemCategoryCode());
			hisDao.setQryValue(nqryIndex, 5, vo.getStrStoreId());
			hisDao.execute(nqryIndex, 0);

			synchronized (hisDao) {
				hisDao.fire();
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("MmsConfigMstDAO.phyVerificationUpdateQuery() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}

	public static String getPeriodId(String strStoreId, String strItemCatCode, String strHospitalCode)throws Exception {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		String strPeriodId = "0";
		
		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.7");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, strHospitalCode);
			dao.setQryValue(nqryIndex, 2, strItemCatCode);
			dao.setQryValue(nqryIndex, 3, strStoreId);
			wb = dao.executeQry(nqryIndex);

			if (wb != null && wb.size() > 0) {

				if (wb.next()) {

					String[] strTemp = wb.getString(1).replace("^", "#").split(
							"#");
					
					strPeriodId = strTemp[0];
					  

				}

			}
		
		} catch (Exception e) {

			throw e;
 
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

		return strPeriodId;
		
	}
	
	public static boolean reportParamABCUpdateQuery(MmsConfigMstVO vo) {

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.4");
		HisDAO hisDao = new HisDAO("Mms Setup",
				"MmsConfigMstDAO.reportParamABCUpdateQuery()");
		

		try {
			int qryIndex1 = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex1, 1, vo.getStrCategoryA());
			hisDao.setQryValue(qryIndex1, 2, vo.getStrCategoryB1());
			hisDao.setQryValue(qryIndex1, 3, vo.getStrCategoryB2());
			hisDao.setQryValue(qryIndex1, 4, vo.getStrCategoryC());
			hisDao.setQryValue(qryIndex1, 5, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex1, 6, "ABC");
			hisDao.execute(qryIndex1, 0);

			synchronized (hisDao) {
				hisDao.fire();
			}

			retVal = true;

		} catch (Exception e) {
			retVal = false;
			
			vo.setStrMsgString("MmsConfigMstDAO.reportParamABCUpdateQuery()-->"+e.getMessage());
			
		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}	
	
	public static boolean reportParamFNSUpdateQuery(MmsConfigMstVO vo){

		boolean retVal = false;
		String qry = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMst.4");
		HisDAO hisDao = new HisDAO("Mms Setup",
				"MmsConfigMstDAO.reportParamFNSUpdateQuery()");
		
      
		try {
			int qryIndex1 = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex1, 1, vo.getStrCategoryF());
			hisDao.setQryValue(qryIndex1, 2, vo.getStrCategoryN1());
			hisDao.setQryValue(qryIndex1, 3, vo.getStrCategoryN2());
			hisDao.setQryValue(qryIndex1, 4, vo.getStrCategoryS());
			hisDao.setQryValue(qryIndex1, 5, vo.getStrHospitalCode());
			hisDao.setQryValue(qryIndex1, 6, "XYZ");
			hisDao.execute(qryIndex1, 0);

			synchronized (hisDao) {
				hisDao.fire();
			}

			retVal = true;

		} catch (Exception e) {
			retVal = false;
			vo.setStrMsgString("MmsConfigMstDAO.reportParamFNSUpdateQuery()-->"+e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}	
	
	
	public static String getParamValue(String strAnalysisName, int strParamIndex ,String strHospitalCode)throws Exception {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		String strPeriodId = "0";
		
		try {
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMst.9");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, strAnalysisName);
			dao.setQryValue(nqryIndex, 2, strHospitalCode);
			
			wb = dao.executeQry(nqryIndex);

			if (wb != null && wb.size() > 0) {

				if (wb.next()) {

					String[] strTemp = wb.getString(1).replace("^", "#").split(
							"#");
					
					strPeriodId = strTemp[strParamIndex];
					  

				}

			}
		
		} catch (Exception e) {

			throw e;
 
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

		return strPeriodId;
		
	}
	/*
	 * 
	 */
	public static int isDataExistConfigFile(MmsConfigMstVO vo) {
		
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();
		int count=0;
		try{
			dao = new HisDAO("mms", "MmsConfigMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.mmsConfigMstPenBreakRej.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			if (wb != null && wb.size() > 0) {
				if (wb.next()) {
					count=Integer.parseInt(wb.getString(1));
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("MmsConfigMstDAO.isDataExistConfigFile()-->"+e.getMessage());
			vo.setStrMsgType("1");
		}finally{
			wb=null;
			dao.free();
		}
		return count;
	}
	public static void configFileDml(MmsConfigMstVO vo,int count) {
		
		HisDAO dao = null;
		int nqryIndex;
		
		String strquery = new String();
		try{
			dao = new HisDAO("mms", "MmsConfigMstDAO");
			
			if(count==0){
				strquery = mms.qryHandler_mms.getQuery(1, "insert.mmsConfigMstPenBreakRej.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 2, vo.getStrPenRejBreak());
				dao.setQryValue(nqryIndex, 3, vo.getStrSeatId());
				dao.execute(nqryIndex, 0);
				
			}else{
				
					strquery = mms.qryHandler_mms.getQuery(1, "update.mmsConfigMstPenBreakRej.0");
					nqryIndex = dao.setQuery(strquery);
					dao.setQryValue(nqryIndex, 1, vo.getStrPenRejBreak());
					dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
					dao.execute(nqryIndex, 0);
				}
			synchronized(dao){
				dao.fire();
			}

			
		}catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("MmsConfigMstDAO.isDataExistConfigFile()-->"+e.getMessage());
			vo.setStrMsgType("1");
		}finally{
			dao.free();
		}
		
	}
	
	//////////////// New Codes goes here (By Adil) /////////////////////////
	public static boolean generalUpdateQuery(MmsConfigMstVO mmsConfigMstVO_p) throws Exception {

		boolean retVal = false;
		String strProcName1 ="{call pkg_mms_dml.Proc_Mms_Config(?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstDAO.generalUpdateQueryProc()");
		String[] arrParamName = { 	"STORE_NAME",
									"EXPIRY_ALERT_DAYS",
									"RESIDUAL_COST_AUCTION",
									
									"ITEM_CATEGORY",
									"DEFAULT_COUNTRY",
									"DEFAULT_STATE",
									
									"BILL_INTEGRATION",
							        "TAX_RATE",
									"INDIAN_DELIVERY_TIME",
									"IMPORTED_DELIVERY_TIME",
									"CONTRACT_VALUE",
									
									"STAMP_PAPER_AMOUNT",
									"PATH_COMMITTEE_RECOMENDATION",
									"SINGLE_ITEM_MULTI_SUPPLIER",
									"PURCHASE_LEAD_TIME",
									"SELF_LIFE",
									"TIN_NO",
									"FMS_INTEGRATION",
									"OSTF_INDENT_LIMIT_AMT"
									//,
								//	"SCM_INTEGRATION",
								//	"SCM_HOSPITAL_CODE"
									};
		
		String[] arrParamValue = {  mmsConfigMstVO_p.getStrStoreId(),  
									mmsConfigMstVO_p.getStrExpAlertDays(),
									mmsConfigMstVO_p.getStrResidualCost(),
									
									mmsConfigMstVO_p.getStrItemCatgId(),
									mmsConfigMstVO_p.getStrCountryCode(), 
									mmsConfigMstVO_p.getStrStateCode(), 
									
									mmsConfigMstVO_p.getStrBilingIntegration(),
									mmsConfigMstVO_p.getStrTaxRate(),
									mmsConfigMstVO_p.getStrIndianDeliveryTime(),
									mmsConfigMstVO_p.getStrContractValue(), 
									mmsConfigMstVO_p.getStrImportedDeliveryTime(),
									
									mmsConfigMstVO_p.getStrStampPaperAmt(),
									mmsConfigMstVO_p.getStrCommitteeFilePath(),
									mmsConfigMstVO_p.getStrWhetherSingleItemMultiSupplier(),
									mmsConfigMstVO_p.getStrPurchaseLeadTime(),
									mmsConfigMstVO_p.getStrSelfLife(),
									mmsConfigMstVO_p.getStrTinNo(),
									mmsConfigMstVO_p.getStrFMSIntegration(),
									mmsConfigMstVO_p.getStrIndentLimitAmt()
									//,
									//mmsConfigMstVO_p.getStrSCMIntegration(),
									//mmsConfigMstVO_p.getStrDefaultHospCode()
								};
		

		try {
			
			
			
			for(int i=0;i<arrParamName.length;i++)
			{
				nProcIndex1 = hisDao.setProcedure(strProcName1);
				hisDao.setProcInValue(nProcIndex1, "paraType", "1",1);
				hisDao.setProcInValue(nProcIndex1, "paraname", arrParamName[i],2);
				hisDao.setProcInValue(nProcIndex1, "paravalue", arrParamValue[i],3);
				hisDao.setProcInValue(nProcIndex1, "gnum_seatid", mmsConfigMstVO_p.getStrSeatId(),4);
				hisDao.setProcInValue(nProcIndex1, "gnum_hospital_code", mmsConfigMstVO_p.getStrHospitalCode(),5);
				hisDao.setProcOutValue(nProcIndex1, "err",1,6);
				hisDao.setProcOutValue(nProcIndex1, "dml_count",1,7);
				hisDao.execute(nProcIndex1,1);
				
			
			}
			synchronized (hisDao) 
			{
				hisDao.fire();
			}
			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("MmsConfigMstDAO.generalUpdateQueryProc()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}
	
	
	public static boolean saveissueDtlDataInDataBase(MmsConfigMstVO mmsConfigMstVO_p) throws Exception {

		boolean retVal = false;
		String strProcName1 ="{call pkg_mms_dml.Proc_Mms_Config(?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstDAO.generalUpdateQueryProc()");
		String[] arrParamName = { 	"WHETHER_KEEP_DEMAND_ACTIVE_AT_PARTIAL_ISSUE",
									"DEMAND_ACTIVE_PERIOD",
									"WHETHER_WITHOUT_CRNO_OPTION_REQUIRED",
									
									"CR_NO_REQ_WITH_OR_WITHOUR_CR_NO",
									"WHETHER_DOSAGE_FREQ_DAYS_INFO_NEED_CAPTURE",
									"RETURN_ITEM_VALIDITY",
									
									"ISSUE_MODE",
									"ONLINE_ISSUE_IN_DAYS",
									"INCASE_PATIENT_STAFF_ITEM_DAYS",
									
									"INCASE_EMPLOYEE_NONCONSUMABLE_DAYS",
									"AUTO_RETURN_REQUEST_INCASE_OF_LP",
									"ISSUE_RATE_STAFF",
									
									"ISSUE_RATE_STAFF_PRICE_TYPE",
									"ISSUE_RATE_NORMAL",
									"ISSUE_RATE_NORMAL_PRICE_TYPE"
									};
		
		String[] arrParamValue = {  mmsConfigMstVO_p.getStrDemandActiveFlg(),
									mmsConfigMstVO_p.getStrDemandActivePrd(),
									mmsConfigMstVO_p.getStrWithOutCrNoFlg(),
									
									mmsConfigMstVO_p.getStrCrNoDefault(),
									mmsConfigMstVO_p.getStrDoseFrqFlg(),
									mmsConfigMstVO_p.getStrReturnDrugValidity(),
									
									mmsConfigMstVO_p.getStrIssueMode(),
									mmsConfigMstVO_p.getStrOnlineIssueInDays(),
									mmsConfigMstVO_p.getStrLastIssuePatientStaffInDays(),
									
									mmsConfigMstVO_p.getStrLastIssueEmployeeInDays(),
									mmsConfigMstVO_p.getStrAutoReturnRequest(),
									mmsConfigMstVO_p.getStrStaffSalePrice(),
									
									mmsConfigMstVO_p.getStrStaffSalePriceType(),
									mmsConfigMstVO_p.getStrNormalSalePrice(),
									mmsConfigMstVO_p.getStrNormalSalePriceType()
									
								};
		

		try {
			
			nProcIndex1 = hisDao.setProcedure(strProcName1);
			for(int i=0;i<arrParamName.length;i++)
			{
				hisDao.setProcInValue(nProcIndex1, "paraType", "2",1);
				hisDao.setProcInValue(nProcIndex1, "paraName", arrParamName[i],2);
				hisDao.setProcInValue(nProcIndex1, "paraValue", arrParamValue[i],3);
				hisDao.setProcInValue(nProcIndex1, "gnum_seatid", mmsConfigMstVO_p.getStrSeatId(),4);
				hisDao.setProcInValue(nProcIndex1, "gnum_hospital_code", mmsConfigMstVO_p.getStrHospitalCode(),5);
				hisDao.setProcOutValue(nProcIndex1, "err",1,6);
				hisDao.setProcOutValue(nProcIndex1, "dml_count",1,7);
				hisDao.executeProcedureByPosition(nProcIndex1);
			}
			synchronized (hisDao) 
			{
				hisDao.fire();
			}
			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("MmsConfigMstDAO.generalUpdateQueryProc()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}
	
	public static boolean savePenaltyDtlDataInDataBase(MmsConfigMstVO mmsConfigMstVO_p) throws Exception {

		boolean retVal = false;
		String strProcName1 ="{call pkg_mms_dml.Proc_Mms_Config(?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstDAO.savePenaltyDtlDataInDataBase()");
		String[] arrParamName = { 	"PENALTY_INCASE_REJECTED_BREAKAGE",
									"PURCHASE_TYPE"
									};
		
		String[] arrParamValue = {  mmsConfigMstVO_p.getStrPenRejBreak(),  
									mmsConfigMstVO_p.getStrPurchaseType()
									
								};
		

		try {
			
			nProcIndex1 = hisDao.setProcedure(strProcName1);
			for(int i=0;i<arrParamName.length;i++)
			{
				hisDao.setProcInValue(nProcIndex1, "paraType", "3",1);
				hisDao.setProcInValue(nProcIndex1, "paraName", arrParamName[i],2);
				hisDao.setProcInValue(nProcIndex1, "paraValue", arrParamValue[i],3);
				hisDao.setProcInValue(nProcIndex1, "gnum_seatid", mmsConfigMstVO_p.getStrSeatId(),4);
				hisDao.setProcInValue(nProcIndex1, "gnum_hospital_code", mmsConfigMstVO_p.getStrHospitalCode(),5);
				hisDao.setProcOutValue(nProcIndex1, "err",1,6);
				hisDao.setProcOutValue(nProcIndex1, "dml_count",1,7);
				hisDao.executeProcedureByPosition(nProcIndex1);
			}
			synchronized (hisDao) 
			{
				hisDao.fire();
			}
			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("MmsConfigMstDAO.generalUpdateQueryProc()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}
	
	public static boolean savePhysicalStockDtlDataInDataBase(MmsConfigMstVO mmsConfigMstVO_p) throws Exception {

		boolean retVal = false;
		String strProcName1 ="{call pkg_mms_dml.Proc_Mms_Config(?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstDAO.generalUpdateQueryProc()");
		String[] arrParamName = { 	"PHY_STOCK_VERIFY_STORE",
									"PHY_STOCK_VERIFY_ITEM_CAT",
									"PHY_STOCK_VERIFY_PERIOD",
									"PHY_STOCK_VERIFY_STOCK_LEDGER_REQD"
									};
		
		String[] arrParamValue = {  mmsConfigMstVO_p.getStrStoreId(),  
									mmsConfigMstVO_p.getStrItemCategoryCode(),
									mmsConfigMstVO_p.getStrPeriodId(), 
									mmsConfigMstVO_p.getStrIsStockLedgerRequired()
								 };
		

		try {
			
			nProcIndex1 = hisDao.setProcedure(strProcName1);
			for(int i=0;i<arrParamName.length;i++)
			{
				hisDao.setProcInValue(nProcIndex1, "paraType", "4",1);
				hisDao.setProcInValue(nProcIndex1, "paraName", arrParamName[i],2);
				hisDao.setProcInValue(nProcIndex1, "paraValue", arrParamValue[i],3);
				hisDao.setProcInValue(nProcIndex1, "gnum_seatid", mmsConfigMstVO_p.getStrSeatId(),4);
				hisDao.setProcInValue(nProcIndex1, "gnum_hospital_code", mmsConfigMstVO_p.getStrHospitalCode(),5);
				hisDao.setProcOutValue(nProcIndex1, "err",1,6);
				hisDao.setProcOutValue(nProcIndex1, "dml_count",1,7);
				hisDao.executeProcedureByPosition(nProcIndex1);
			}
			synchronized (hisDao) 
			{
				hisDao.fire();
			}
			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("MmsConfigMstDAO.generalUpdateQueryProc()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}
	
	public static boolean saveReportDtlinDataBase(MmsConfigMstVO mmsConfigMstVO_p) throws Exception {

		boolean retVal = false;
		String strProcName1 ="{call pkg_mms_dml.Proc_Mms_Config(?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstDAO.generalUpdateQueryProc()");
		String[] arrParamName = { 	"ABC_ANALYSIS_A",
									"ABC_ANALYSIS_B1",
									"ABC_ANALYSIS_B2",
									
									"ABC_ANALYSIS_C",
									"FSN_XYZ_ANALYSIS_F_X",
									"FSN_XYZ_ANALYSIS_N_Y1",
							
									"FSN_XYZ_ANALYSIS_N_Y2",
									"FSN_XYZ_ANALYSIS_S_Z"
									};
		
		String[] arrParamValue = {  mmsConfigMstVO_p.getStrCategoryA(),  
									mmsConfigMstVO_p.getStrCategoryB1(),
									mmsConfigMstVO_p.getStrCategoryB2(),
									
									mmsConfigMstVO_p.getStrCategoryC(),
									mmsConfigMstVO_p.getStrCategoryF(), 
									mmsConfigMstVO_p.getStrCategoryN1(), 
									
									mmsConfigMstVO_p.getStrCategoryN2(),
									mmsConfigMstVO_p.getStrCategoryS()
									
								};
		

		try {
			
			nProcIndex1 = hisDao.setProcedure(strProcName1);
			for(int i=0;i<arrParamName.length;i++)
			{
				hisDao.setProcInValue(nProcIndex1, "paraType", "5",1);
				hisDao.setProcInValue(nProcIndex1, "paraName", arrParamName[i],2);
				hisDao.setProcInValue(nProcIndex1, "paraValue", arrParamValue[i],3);
				hisDao.setProcInValue(nProcIndex1, "gnum_seatid", mmsConfigMstVO_p.getStrSeatId(),4);
				hisDao.setProcInValue(nProcIndex1, "gnum_hospital_code", mmsConfigMstVO_p.getStrHospitalCode(),5);
				hisDao.setProcOutValue(nProcIndex1, "err",1,6);
				hisDao.setProcOutValue(nProcIndex1, "dml_count",1,7);
				hisDao.executeProcedureByPosition(nProcIndex1);
			}
			synchronized (hisDao) 
			{
				hisDao.fire();
			}
			retVal = true;

		} catch (Exception e) {
			retVal = false;
			throw new Exception("MmsConfigMstDAO.generalUpdateQueryProc()-->"
					+ e.getMessage());

		} finally {
			hisDao.free();
			hisDao = null;
		}

		return retVal;
	}

}
