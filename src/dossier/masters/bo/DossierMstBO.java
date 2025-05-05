package dossier.masters.bo;

import dossier.masters.dao.DossierMstDAO;
import dossier.masters.vo.DossierMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierMstBO.
 */
public class DossierMstBO {
	
	/**
	 * This function is used to invoke DossierMstDAO's
	 * getInitParam,getCommiteeDtl,getSupplierGrade.
	 * 
	 * @param vo the vo
	 */
	public void setinitParam(DossierMstVO vo) {
		DossierMstDAO.getInitParam(vo);
		//DossierMstDAO.getCountry(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}
		// DossierMstDAO.getCommiteeDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insert(DossierMstVO vo) {

		DossierMstDAO.CheckDuplicayAdd(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.insert() --> "
					+ vo.getStrMsgString());
		} else {
			if (vo.getIsFlag())
				DossierMstDAO.insert(vo);
			else
				vo.setStrWarnMsType("1");

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierMstBO.insert() --> "
						+ vo.getStrMsgString());
			}
		}

	}


	
	/**
	 * To get data on modify page.
	 * 
	 * @param vo the vo
	 */
	public void modify(DossierMstVO vo) {

		DossierMstDAO.modify(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.modify() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.modify() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To update record.
	 * 
	 * @param vo the vo
	 */
	public void update(DossierMstVO vo) {

		//DossierMstDAO.CheckDuplicayModi(vo);
		vo.setIsFlag(true);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.update() --> "
					+ vo.getStrMsgString());
		} else {
			if (vo.getIsFlag() == true) {
				DossierMstDAO.update(vo);
			} else {
				vo.setStrWarnMsType("1");
			}
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierMstBO.update() --> "
						+ vo.getStrMsgString());
			}
		}

	}

	/**
	 * To get data on view page.
	 * 
	 * @param vo the vo
	 */
	public void getView(DossierMstVO vo) {

		DossierMstDAO.view(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierMstBO.view() --> "
					+ vo.getStrMsgString());
		}

	}
}
