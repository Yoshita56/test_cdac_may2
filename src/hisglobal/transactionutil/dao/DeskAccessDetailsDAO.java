package hisglobal.transactionutil.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.transactionutil.vo.DeskAccessDetailsVO;

import javax.sql.rowset.WebRowSet;


/**
 * @author Anshul Jindal
 *
 */
public class DeskAccessDetailsDAO {
	/**
	 * for getting option value of userName,DeskName combos and menu list 
	 * 
	 * @param vo
	 * 
	 */
	public static void getInitialValues(DeskAccessDetailsVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		
		try {
			dao = new HisDAO("transactionutil", "DeskAccessDetailsDAO");

			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("Select.DeskAccessDtls.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			
			wb = dao.executeQry(nqryIndex);

			vo.setUserNameComboWS(wb);
			
			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("Select.DeskAccessDtls.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			
			wb = dao.executeQry(nqryIndex);

			vo.setDeskNameComboWS(wb);
			
			
					

		} catch (Exception e) {
			vo.setStrMsgString("-->DeskAccessDetailsDAO.getInitialValues()-->"
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
	 * To get values of LEFT MENU LIST
	 * @param vo
	 * 
	 */
	public static void getLeftListQuery(DeskAccessDetailsVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		
		try {
			dao = new HisDAO("transactionutil", "DeskAccessDetailsDAO");

			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("Select.DeskAccessDtls.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDeskId());
			dao.setQryValue(nqryIndex, 2, vo.getStrUserId());
			dao.setQryValue(nqryIndex, 3, vo.getStrDeskId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			
			wb = dao.executeQry(nqryIndex);

			vo.setLeftMenuListWS(wb);
						

		} catch (Exception e) {
			vo.setStrMsgString("-->DeskAccessDetailsDAO.getLeftListQuery()-->"
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
	 * To get values of RIGHT MENU LIST
	 * @param vo
	 * 
	 */
	public static void getRightListQuery(DeskAccessDetailsVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		
		try {
			dao = new HisDAO("transactionutil", "DeskAccessDetailsDAO");

			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("Select.DeskAccessDtls.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDeskId());
			dao.setQryValue(nqryIndex, 2, vo.getStrUserId());
			dao.setQryValue(nqryIndex, 3, vo.getStrDeskId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			
			wb = dao.executeQry(nqryIndex);

			vo.setRightMenuListWS(wb);
			
		
					

		} catch (Exception e) {
			vo.setStrMsgString("-->DeskAccessDetailsDAO.getRightListQuery()-->"
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
	 * To delete the data before insert 
	 * @param vo
	 * 
	 */
	public static void deleteQuery(DeskAccessDetailsVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		
		
		try {
			dao = new HisDAO("transactionutil", "DeskAccessDetailsDAO");

			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("delete.DeskAccessDtls.0");
			nqryIndex = dao.setQuery(strquery);

			//System.out.println("vo.getStrDeskId()"+vo.getStrDeskId());
			//System.out.println("vo.getStrMenuId()"+vo.getStrMenuId());
			
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrUserId());
			dao.setQryValue(nqryIndex, 3, vo.getStrDeskId());
						
			dao.execute(nqryIndex,0);
			
			
			synchronized(dao)
			{
				dao.fire();
			}
						

		} catch (Exception e) {
			vo.setStrMsgString("-->DeskAccessDetailsDAO.insertQuery()-->"
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
	 * To insert the data
	 * @param vo
	 * 
	 */
	public static void insertQuery(DeskAccessDetailsVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		
		
		try {
			dao = new HisDAO("transactionutil", "DeskAccessDetailsDAO");

			
			
			strquery = hisglobal.transactionutil.qryHandler_transactionutil.getQuery("insert.DeskAccessDtls.0");
			nqryIndex = dao.setQuery(strquery);

			//System.out.println("vo.getStrDeskId()"+vo.getStrDeskId());
			//System.out.println("vo.getStrMenuId()"+vo.getStrMenuId());
			
			dao.setQryValue(nqryIndex, 1, vo.getStrUserId());
			dao.setQryValue(nqryIndex, 2, vo.getStrDeskId());
			dao.setQryValue(nqryIndex, 3, vo.getStrMenuId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 5, vo.getStrEffectiveFrom());
			dao.setQryValue(nqryIndex, 6, vo.getStrSeatId());
			dao.setQryValue(nqryIndex, 7, vo.getStrIsValid());
			dao.setQryValue(nqryIndex, 8, vo.getStrMenuId());
						
			dao.execute(nqryIndex,0);

			synchronized(dao)
			{
				dao.fire();
			}
						

		} catch (Exception e) {
			vo.setStrMsgString("-->DeskAccessDetailsDAO.insertQuery()-->"
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
