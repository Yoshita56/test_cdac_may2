/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.AgendaDeskModifyTransDAO;
import mms.transactions.vo.AgendaDeskModifyTransVO;

/**
 * @author Pankaj Kumar
 * 
 */
public class AgendaDeskModifyTransBO {
	/**
	 * for getting the Indent Details
	 * 
	 * @param _AgendaDeskModifyTransVO
	 */
	public void getIndentDetails(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		AgendaDeskModifyTransDAO.setIndentDetails(_AgendaDeskModifyTransVO);
		if (_AgendaDeskModifyTransVO.getStrMsgType().equals("1"))
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransBO.getIndentDetails() --> "
							+ _AgendaDeskModifyTransVO.getStrMsgString());
	}

	/**
	 * for getting the ToStore Values
	 * 
	 * @param _AgendaDeskModifyTransVO
	 */
	public void setToStoreValues(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		AgendaDeskModifyTransDAO.setToStoreValues(_AgendaDeskModifyTransVO);
		if (_AgendaDeskModifyTransVO.getStrMsgType().equals("1"))
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransBO.setToStoreValues() --> "
							+ _AgendaDeskModifyTransVO.getStrMsgString());
	}

	/**
	 * for getting the Item Category
	 * 
	 * @param _AgendaDeskModifyTransVO
	 */
	public void setItemCatValues(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		AgendaDeskModifyTransDAO.setItemCatValues(_AgendaDeskModifyTransVO);
		if (_AgendaDeskModifyTransVO.getStrMsgType().equals("1"))
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransBO.setItemCatValues() --> "
							+ _AgendaDeskModifyTransVO.getStrMsgString());
	}

	/**
	 * for Inserting the Data
	 * 
	 * @param _AgendaDeskModifyTransVO
	 */
	public void insert(AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		AgendaDeskModifyTransDAO.insert(_AgendaDeskModifyTransVO);
		if (_AgendaDeskModifyTransVO.getStrMsgType().equals("1"))
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransBO.insert() --> "
							+ _AgendaDeskModifyTransVO.getStrMsgString());
	}

	/**
	 * for Fetching the Saved Data
	 * 
	 * @param _AgendaDeskModifyTransVO
	 */
	public void setFetchedData(AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		AgendaDeskModifyTransDAO.setFetchedData(_AgendaDeskModifyTransVO);
		if (_AgendaDeskModifyTransVO.getStrMsgType().equals("1"))
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransBO.setFetchedData() --> "
							+ _AgendaDeskModifyTransVO.getStrMsgString());
	}
}
