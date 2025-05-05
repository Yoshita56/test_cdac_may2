package mms.transactions.bo;

import mms.transactions.dao.SetSachetDetailsTransDAO;
import mms.transactions.vo.SetSachetDetailsTransVO;

/**
 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 23/Jan/2009 Module:MMS
 * Unit:Set/Sachet Details
 * 
 */

public class SetSachetDetailsTransBO {
	/**
	 * This method is used to populate the value of Store name combo box and for
	 * it it will call getInitialValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getInitialValues(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getInitialValues() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Group name combo box and for
	 * it it will call getGroupNameValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getGroupNameValues(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getGroupNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getGroupNameValues() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Group name combo box and for
	 * it it will call getGroupNameValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getCategoryValues(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getCategoryValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getCategoryValues() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Sub Group name combo box and
	 * for it it will call getSubGroupNameValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getSubGroupNameValues(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getSubGroupNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getSubGroupNameValues() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Set/Sachet name combo box
	 * and for it it will call getSachetNameValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getSachetNameValues(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getSachetNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getSubGroupNameValues() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to display the value of Item details and for it it
	 * will call getItemDetails()method which is define
	 * inSetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getItemDetails(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getItemDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getItemDetails() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Unit name combo box and for
	 * it it will call getUnitCombo()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getUnitCombo(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SetSachetDetailsTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Brand name combo box and for
	 * it it will call getBrandNameCombo();method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getBrandNameCombo(SetSachetDetailsTransVO vo) {

		SetSachetDetailsTransDAO.getBrandNameCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SetSachetDetailsTransBO.getBrandNameCombo() --> "
							+ vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to save the set sachet name details and item details
	 * and for it it will call insertSachetValues()method which is define in
	 * SetSachetDetailsTransDAO java file
	 * 
	 * @param vo
	 */
	public void insertData(SetSachetDetailsTransVO vo) {
		SetSachetDetailsTransDAO.insertData(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SetSachetDetailsTransBO.insertData() --> "
					+ vo.getStrMsgString());
		}
	}

}
