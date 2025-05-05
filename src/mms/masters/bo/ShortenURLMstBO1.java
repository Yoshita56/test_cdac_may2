package mms.masters.bo;

import mms.masters.dao.ShortenURLMstDAO1;

import mms.masters.vo.ShortenURLMstVO1;


// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstBO.
 * 
 * @author Anshul Jindal
 */
public class ShortenURLMstBO1 {
	
	/**
	 * for getting values of left store name list on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(ShortenURLMstVO1 vo) 
	{

		ShortenURLMstDAO1.initAddQuery(vo);

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
	public void insertRecord(ShortenURLMstVO1 vo) {

		ShortenURLMstDAO1.insertQuery(vo);

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
	public void modifyRecord(ShortenURLMstVO1 vo) {

		ShortenURLMstDAO1.modifyQuery(vo);
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
	public void updateRecord(ShortenURLMstVO1 vo) {

		ShortenURLMstDAO1.updateQuery(vo);

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

	public void getAssociatedStore(ShortenURLMstVO1 vo) 
	{

		ShortenURLMstDAO1.getAssociatedStore(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreHierarchyMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

}
