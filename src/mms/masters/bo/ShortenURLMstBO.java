package mms.masters.bo;

import mms.masters.dao.ShortenURLMstDAO;

import mms.masters.vo.ShortenURLMstVO;



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


public class ShortenURLMstBO {

	/**
	 * for getting option value of Group name combo on add page.
	 * 
	 * @param vo_p
	 *            the vo
	 */

	public void initialAdd(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.initialAdd-------");
		ShortenURLMstDAO.initAddQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("ShortenURLMstBO.initialAdd() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void getDrugNameCombo(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.getDrugNameCombo-------");
		ShortenURLMstDAO.getDrugNameComboQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getDrugNameCombo() --> "
							+ vo_p.getStrMsgString());
		}
	}

	public void getLeftDrugList(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.getLeftDrugList-------");
		ShortenURLMstDAO.getLeftDrugList(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getLeftDrugList() --> "
							+ vo_p.getStrMsgString());
		}

	}

	public void insertRecord(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.insertRecord-------");

		ShortenURLMstDAO.insertQuery(vo_p);
		
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("ShortenURLMstBO.insertRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void modifyRecord(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.modifyRecord-------");
		ShortenURLMstDAO.modifyRecord(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.modifyRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void updateRecord(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.updateRecord-------");
		ShortenURLMstDAO.updateQuery(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.updateRecord() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void contradicView(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.contradicView-------");
		ShortenURLMstDAO.contradicView(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("DrugContradictionMstBO.contradicView() --> "
					+ vo_p.getStrMsgString());
		}
	}

	public void getContDrugName(ShortenURLMstVO vo_p) {
		System.out.println("--------ShortenURLMstBO.getContDrugName-------");
		ShortenURLMstDAO.getContDrugName(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p
					.setStrMsgString("DrugContradictionMstBO.getContDrugName() --> "
							+ vo_p.getStrMsgString());
		}
	}
}
