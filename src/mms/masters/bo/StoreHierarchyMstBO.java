package mms.masters.bo;

import mms.masters.dao.StoreHierarchyMstDAO;
import mms.masters.vo.StoreHierarchyMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstBO.
 * 
 * @author Anshul Jindal
 */
public class StoreHierarchyMstBO {
	
	/**
	 * for getting values of left store name list on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(StoreHierarchyMstVO vo) 
	{

		StoreHierarchyMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreHierarchyMstVO vo) {

		StoreHierarchyMstDAO.insertQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(StoreHierarchyMstVO vo) {

		StoreHierarchyMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreHierarchyMstVO vo) {

		StoreHierarchyMstDAO.updateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * for getting values of left store name list on add page.
	 * 
	 * @param vo the vo
	 */

	public void getAssociatedStore(StoreHierarchyMstVO vo) 
	{

		StoreHierarchyMstDAO.getAssociatedStore(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

}
