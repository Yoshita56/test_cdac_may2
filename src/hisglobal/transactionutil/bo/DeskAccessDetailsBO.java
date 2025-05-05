package hisglobal.transactionutil.bo;


import hisglobal.transactionutil.dao.DeskAccessDetailsDAO;
import hisglobal.transactionutil.vo.DeskAccessDetailsVO;


/**
 * @author Anshul Jindal
 *
 */
public class DeskAccessDetailsBO {

	
	/**
	 * for getting option value of userName,DeskName combos and menu list 
	 * 
	 * @param vo
	 * 
	 */

	public void getInitialValues(DeskAccessDetailsVO vo) {

		DeskAccessDetailsDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeskAccessDetailsBO.getInitialValues() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * To get values of LEFT MENU LIST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getLeftList(DeskAccessDetailsVO vo) {

		DeskAccessDetailsDAO.getLeftListQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeskAccessDetailsBO.getLeftList() --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * To get values of RIGHT MENU LIST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getRightList(DeskAccessDetailsVO vo) {

		DeskAccessDetailsDAO.getRightListQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeskAccessDetailsBO.getRightList() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * to delete the data before insert 
	 *  
	 * @param vo
	 */
	public void deleteRecords(DeskAccessDetailsVO vo) {

		
		DeskAccessDetailsDAO.deleteQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeskAccessDetailsBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		

	}
	/**
	 * to insert the data 
	 *  
	 * @param vo
	 */
	public void insertRecord(DeskAccessDetailsVO vo) {

		
		DeskAccessDetailsDAO.insertQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeskAccessDetailsBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		

	}

}
