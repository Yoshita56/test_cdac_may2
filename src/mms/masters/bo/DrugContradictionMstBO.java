package mms.masters.bo;

import mms.masters.dao.DrugContradictionMstDAO;
import mms.masters.vo.DrugContradictionMstVO;


/**
 * @author Niharika Srivastava
 * Date Of Creation : Aug 25, 2010
 * Team Lead : Mr. Ajay Kumar Gupta
 * Module   : MMS 
 * Process  : Drug Contradiction Master
 * Description : BO for Drug Contradiction Master
 * Last Modified By : 
 * Last Modification Date : 
 */


public class DrugContradictionMstBO {

	/**
	 * for getting option value of Group name combo on add page.
	 * 
	 * @param vo_p
	 *            the vo
	 */

	public void initialAdd(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.initAddQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.initialAdd() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void getDrugNameCombo(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.getDrugNameComboQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getDrugNameCombo() --> "
							+ vo_p.getStrMsgString());
		}
	}

	public void getLeftDrugList(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.getLeftDrugList(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getLeftDrugList() --> "
							+ vo_p.getStrMsgString());
		}

	}

	public void insertRecord(DrugContradictionMstVO vo_p) {

		// DrugContradictionMstDAO.chkDuplicate(vo);

		// if(vo.getBExistStatus()==true){
		DrugContradictionMstDAO.insertQuery(vo_p);
		// }
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.insertRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void modifyRecord(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.modifyRecord(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.modifyRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void updateRecord(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.updateQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.updateRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void contradicView(DrugContradictionMstVO vo_p) {

		DrugContradictionMstDAO.contradicView(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.contradicView() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void getContDrugName(DrugContradictionMstVO vo_p) {
		DrugContradictionMstDAO.getContDrugName(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getContDrugName() --> "
							+ vo_p.getStrMsgString());
		}
	}
}
