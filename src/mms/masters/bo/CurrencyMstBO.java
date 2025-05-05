package mms.masters.bo;

import mms.masters.dao.CurrencyMstDAO;
import mms.masters.vo.CurrencyMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyMstBO.
 */
public class CurrencyMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(CurrencyMstVO vo) {
		CurrencyMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CurrencyMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			CurrencyMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("CurrencyMstBO.insertQuery() --> " + strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyQuery(CurrencyMstVO vo) {
		CurrencyMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CurrencyMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateQuery(CurrencyMstVO vo) {

		CurrencyMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CurrencyMstBO.updateQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			CurrencyMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("CurrencyMstBO.updateQuery() --> " + strErr);
			}
		}
	}
	
	public void chkDuplicateDefault(CurrencyMstVO vo) {
		CurrencyMstDAO.chkDuplicateDefault(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CurrencyMstBO.chkDuplicateDefault() --> " + strErr);
		}
	}

}
