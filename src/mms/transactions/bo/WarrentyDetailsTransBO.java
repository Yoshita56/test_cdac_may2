package mms.transactions.bo;

import mms.transactions.dao.WarrentyDetailsTransDAO;
import mms.transactions.vo.WarrentyDetailsTransVO;

public class WarrentyDetailsTransBO {
	/**
	 * for getting option value of Manufacturer Name and Item Catagory combos 
	 * 
	 * @param vo
	 * 
	 */

	public void getInitialValues(WarrentyDetailsTransVO vo) {

		WarrentyDetailsTransDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.getInitialValues() --> "
					+ vo.getStrMsgString());
		}
	}
	/**
	 * To get option value of Group name combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getGroupNameCombo(WarrentyDetailsTransVO vo) {

		WarrentyDetailsTransDAO.getGroupNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.getGroupNameCombo( --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * To get option value of Sub Group name combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getSubGroupNameCombo(WarrentyDetailsTransVO vo) {

		WarrentyDetailsTransDAO.getSubGroupNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.getSubGroupNameCombo( --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * To get option value of Item name combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getItemNameCombo(WarrentyDetailsTransVO vo) {

		WarrentyDetailsTransDAO.getItemNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.getItemNameCombo( --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * To get option value of Brand name combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getBrandNameCombo(WarrentyDetailsTransVO vo) {

		WarrentyDetailsTransDAO.getBrandNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.getBrandNameCombo( --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * to insert the data 
	 *  
	 * @param vo
	 */
	public void insertRecords(WarrentyDetailsTransVO vo) {

		
		WarrentyDetailsTransDAO.insertProcedure(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("WarrentyDetailsTransBO.insertRecords() --> "
					+ vo.getStrMsgString());
		}
		

	}
}
