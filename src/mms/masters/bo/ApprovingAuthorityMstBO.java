package mms.masters.bo;

import mms.masters.dao.ApprovingAuthorityMstDAO;
import mms.masters.vo.ApprovingAuthorityMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta
 * Version : 1.0
 * Date : 14/April/2009
 * Module:MMS
 * Unit:Approving Authority Master
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Modify Date : 22/May/2009
 * 
 */

public class ApprovingAuthorityMstBO {

	/**
	 * This method is used to insert the record in database. for this activity
	 * this method call the insertRecord() method of ApprovingAuthorityMstDAO
	 * java file.
	 * 
	 * @param vo the vo
	 * 
	 * @author Administrator
	 */
	public void insertRecord(ApprovingAuthorityMstVO vo) {

		ApprovingAuthorityMstDAO.insertrecord(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ApprovingAuthorityMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * This method is used to initialize all value.
	 * 
	 * @param vo the vo
	 */
	public void addUserListValue(ApprovingAuthorityMstVO vo) {

		ApprovingAuthorityMstDAO.addUserListValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("ApprovingAuthorityMstBO.addUserListValue() --> "
							+ vo.getStrMsgString());
		}

	}

	/**
	 * This method is used to modify the recod.
	 * 
	 * @param vo the vo
	 */
	public void modifyRecord(ApprovingAuthorityMstVO vo) {

		ApprovingAuthorityMstDAO.modifyRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ApprovingAuthorityMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * This method is used to update the record in database. for this activity
	 * this method call the updateRecord() method of ApprovingAuthorityMstDAO
	 * java file.
	 * 
	 * @param vo the vo
	 * 
	 * @author Administrator
	 */
	public void updateRecord(ApprovingAuthorityMstVO vo) {

		ApprovingAuthorityMstDAO.updateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ApprovingAuthorityMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	
}
