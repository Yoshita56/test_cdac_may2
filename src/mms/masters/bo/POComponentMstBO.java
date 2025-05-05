package mms.masters.bo;

import mms.masters.dao.POComponentMstDAO;

import mms.masters.vo.POComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class POComponentMstBO.
 * 
 * @author Anurudra Goel
 *  Modify By : Tanvi Sappal
 *  Modify Date : 12/05/2010
 */

public class POComponentMstBO {

	/**
	 * Sets the cat value.
	 * 
	 * @param vo the new cat value
	 */
	/*public void setCatValue(POComponentMstVO vo) {
		POComponentMstDAO.getCatValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("POComponentMstBO.setCatValue---->"
					+ vo.getStrMsgString());
	}*/

	/**
	 * Gets the component name.
	 * 
	 * @param vo the vo
	 * 
	 * @return the component name
	 */
	public void getComponentName(POComponentMstVO vo) {
		POComponentMstDAO.getComponentName(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("POComponentMstBO.getComponentName---->"
					+ vo.getStrMsgString());
	}

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */

	/*public void initAdd(POComponentMstVO vo) {

		POComponentMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("POComponentMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}
*/
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(POComponentMstVO vo) {
		POComponentMstDAO.initialAddQuery(vo);

		if (vo.getBExistStatus() == true) {
			POComponentMstDAO.insertQuery(vo);
		}

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(POComponentMstVO vo) {

		//POComponentMstDAO.initAddQuery(vo);
		POComponentMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("POComponentMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(POComponentMstVO vo) {

		// StoreTypeMstDAO.initialUpdateQuery(vo);
		/*
		 * if (vo.getStrMsgType().equals("1")) {
		 * vo.setStrMsgString("StoreTypeMstBO.updateRecord() --> " +
		 * vo.getStrMsgString()); }
		 */
		// if (vo.getBExistStatus() == true) {
		POComponentMstDAO.updateQuery(vo);
		// }
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("POComponentMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
}
