package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.PistDesignationMstDAO;
import mms.masters.vo.DesignationMstVO;

public class DesignationMstDAO 
{
	
	/**
	 * <p>Method::INSERT is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
		public static void insert(DesignationMstVO vo) 
		{
			HisDAO dao = null;
						
	    	try 
			{
	  		      dao = new HisDAO("dwh","transactions.DesignationMstDAO.insert()");
	  		      PistDesignationMstDAO.insert(vo,dao);
				
				  synchronized(dao)   
				  {
		        	dao.fire();     // Here we Execute in Batch
				  }
			} 
	    	catch (Exception e) 
	    	{
				vo.setStrMsgString("--> DesignationMstDAO.insert()-->"+ e.getMessage());
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
		 * retrieves and executes modify Query.
		 * 
		 * @param vo the vo
		 * 
		 * @throws Exception 	 */
		public static void modifyQuery(DesignationMstVO vo) 
		{

			HisDAO dao = new HisDAO("dwh", "DesignationMstDAO");

			int nqryIndex;
			String strquery = new String();

			try 
			{

				strquery = mms.qryHandler_mms.getQuery(1, "DesignationMst.view.1");
				nqryIndex = dao.setQuery(strquery);
				
				dao.setQryValue(nqryIndex, 1, vo.getStrDesignationId());
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

				WebRowSet web = dao.executeQry(nqryIndex);
				while (web.next()) 
				{
					vo.setStrDesignationName(web.getString(1));
					vo.setStrRemarks(web.getString(2));
					vo.setStrEffectiveFrom(web.getString(3));
					vo.setStrIsValid(web.getString(4));
				}
			} catch (Exception e) {

				vo.setStrMsgString("DesignationMstDAO.modifyQuery() --> "
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
		 * @throws Exception 	
	         */
		public static void chkDuplicate(DesignationMstVO vo)
	    {
			HisDAO dao = null;
			int nqryIndex;
			int ncount = 0;
			WebRowSet wb = null;
			String strquery = new String();

			try
	                {
				dao = new HisDAO("dwh", "LetterTypeMstDAO");
				strquery = mms.qryHandler_mms.getQuery(1, "DesignationMst.chkduplicate");
				nqryIndex = dao.setQuery(strquery);				
				dao.setQryValue(nqryIndex, 1, vo.getStrDesignationName());
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
				wb = dao.executeQry(nqryIndex);
				while (wb.next()) 
	                        {
					ncount = Integer.parseInt(wb.getString(1));
				}
				if (ncount == 0) 
	                        {
					vo.setBExistStatus(true);
				} 
	                        else 
	                        {
					vo.setBExistStatus(false);
				}
			}
	               catch (Exception e)
	               {
				vo.setStrMsgString("DesignationMstDAO.chkDuplicate() --> "
						+ e.getMessage());
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
		 * Check the Record weather data is Duplicate or not.
		 * 
		 * @param vo -
		 * FormBean Object
		 * 
		 * @return - true -record cannot be saved ,already exist false - record will
		 * save
		 * 
		 * @throws Exception 	 */
		
		public static void initialUpdateQuery(DesignationMstVO vo) 
		{
			HisDAO dao = null;
			int nqryIndex;
			int ncount = 0;
			WebRowSet wb = null;
			String strquery = new String();

			try {
				dao = new HisDAO("dwh", "LetterTypeMstDAO");
				strquery = mms.qryHandler_mms.getQuery(1, "DesignationMst.chkduplicate.update");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, vo.getStrDesignationId());
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 3, vo.getStrDesignationName());
				wb = dao.executeQry(nqryIndex);
				while (wb.next()) 
				{
					ncount = Integer.parseInt(wb.getString(1));
				}
				if (ncount == 0)
				{
					vo.setBExistStatus(true);
				} 
				else 
				{
					vo.setBExistStatus(false);
				}
			} catch (Exception e) {
				vo.setStrMsgString("LetterTypeMstDAO.initialUpdateQuery() --> "
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
