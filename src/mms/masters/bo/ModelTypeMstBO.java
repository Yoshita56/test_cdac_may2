package mms.masters.bo;

import mms.masters.dao.ModelTypeMstDAO;
import mms.masters.vo.ModelTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelTypeMstBO.
 * 
 * @author Anshul Jindal
 */

public class ModelTypeMstBO {

	
	/**
	 * to check duplicate before insert update.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ModelTypeMstVO vo) {

		ModelTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ModelTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ModelTypeMstDAO.updateQuery(vo);
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(ModelTypeMstVO vo) {

		ModelTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ModelTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getStoreGroupCmb(ModelTypeMstVO vo) {
		ModelTypeMstDAO.getStoreGroupCmb(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ModelTypeMstBO.GRPNAMECOMBO() --> "
					+ vo.getStrMsgString());
		}

	}
	
	public void getItemNameCombo(ModelTypeMstVO vo) {

		ModelTypeMstDAO.getItemNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ModelTypeMstDAO.getItemNameCombo() --> "
					+ vo.getStrMsgString());
		}

	}
	public void insertRecord(ModelTypeMstVO vo) 
	{
		ModelTypeMstDAO.insertRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ModelTypeMstDAO.getItemNameCombo() --> "
					+ vo.getStrMsgString());
		}

	}



}
