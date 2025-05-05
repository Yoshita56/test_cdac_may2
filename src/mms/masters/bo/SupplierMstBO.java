package mms.masters.bo;

import mms.masters.dao.SupplierMstDAO;
import mms.masters.vo.SupplierMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstBO.
 */
public class SupplierMstBO {
	
	/**
	 * This function is used to invoke SupplierMstDAO's
	 * getInitParam,getCommiteeDtl,getSupplierGrade.
	 * 
	 * @param vo the vo
	 */
	public void setinitParam(SupplierMstVO vo) {
		SupplierMstDAO.getInitParam(vo);
		SupplierMstDAO.getCountry(vo);
		SupplierMstDAO.getState(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}
		// SupplierMstDAO.getCommiteeDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}
		SupplierMstDAO.getSupplierGrade(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.setinitParam() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insert(SupplierMstVO vo) {
		//System.out.println("Bo File 1");
		SupplierMstDAO.CheckDuplicayAdd(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.insert() --> "
					+ vo.getStrMsgString());
		} else {
			if (vo.getIsFlag())
				
				SupplierMstDAO.insert(vo);
			else
				vo.setStrWarnMsType("1");

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("SupplierMstBO.insert() --> "
						+ vo.getStrMsgString());
			}
		}

	}

	
	/**
	 * To insert the data.
	 * 
	 * @param vo the vo
	 */
	public void getState(SupplierMstVO vo) 
	{

		
		
				SupplierMstDAO.getState(vo);
			

			if (vo.getStrMsgType().equals("1")) 
			{
				vo.setStrMsgString("SupplierMstBO.insert() --> "
						+ vo.getStrMsgString());
			}
		

	}
	
	/**
	 * To get data on modify page.
	 * 
	 * @param vo the vo
	 */
	public void modify(SupplierMstVO vo) {

		SupplierMstDAO.modify(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.modify() --> "
					+ vo.getStrMsgString());
		}
		SupplierMstDAO.getCommiteeDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.modify() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To update record.
	 * 
	 * @param vo the vo
	 */
	public void update(SupplierMstVO vo) {

		SupplierMstDAO.CheckDuplicayModi(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.update() --> "
					+ vo.getStrMsgString());
		} else {
			if (vo.getIsFlag() == true) {
				SupplierMstDAO.update(vo);
			} else {
				vo.setStrWarnMsType("1");
			}
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("SupplierMstBO.update() --> "
						+ vo.getStrMsgString());
			}
		}

	}

	/**
	 * To get data on view page.
	 * 
	 * @param vo the vo
	 */
	public void getView(SupplierMstVO vo) {

		SupplierMstDAO.view(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierMstBO.view() --> "
					+ vo.getStrMsgString());
		}

	}
}
