package mms.reports.bo;

import mms.reports.dao.IssueReceiveLedgerRptDAO;
import mms.reports.vo.IssueReceiveLedgerRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueReceiveLedgerRptBO.
 */
public class IssueReceiveLedgerRptBO {
	/**
	 * Gets the circle list.
	 * 
//	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getCircleList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the district list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the district list
	 */
	public void getDistrictList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getDistrictList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the store list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store list
	 */
	public void getStoreList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getStoreList(voObj);	
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getStoreList()-->" + strErr);
		}

	}
	
	public void getFYCombo(IssueReceiveLedgerRptVO voObj) {

	
		IssueReceiveLedgerRptDAO.getFYCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getFYCombo()-->" + strErr);
		}

	}

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store type list
	 */
	public void getStoreTypeList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getStoreTypeList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the sub store list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the sub store list
	 */
	public void getSubStoreList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getStoreList()-->" + strErr);
		}

	}

	
	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the item cat list
	 */
	public void getItemCatList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getItemCatList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the group list
	 */
	public void getGroupList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getGroupList(voObj);
		IssueReceiveLedgerRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getGroupList()-->" + strErr);
		}

	}
	/**
	 * Gets the drug list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the drug list
	 */
	public void getDrugList(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getDrugList()-->" + strErr);
		}

	}

	/**
	 * Gets the user level.
	 * 
	 * @param voObj
	 *            the vo obj
	 */
	public void GetUserLevel(IssueReceiveLedgerRptVO voObj) {
		IssueReceiveLedgerRptDAO.GetUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.GetUserLevel()-->" + strErr);
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the programme combo
	 */
	public void getProgrammeCombo(IssueReceiveLedgerRptVO voObj) {

		IssueReceiveLedgerRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void getImgHeader(IssueReceiveLedgerRptVO voObj){
		IssueReceiveLedgerRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IssueReceiveLedgerRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
	public void getReport(IssueReceiveLedgerRptVO vo) {
		IssueReceiveLedgerRptDAO.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueReceiveLedgerRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}

}
