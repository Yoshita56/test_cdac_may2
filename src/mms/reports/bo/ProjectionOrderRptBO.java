package mms.reports.bo;

import mms.reports.dao.ProjectionOrderRptDAO;
import mms.reports.vo.ProjectionOrderRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectionOrderRptBO.
 */
public class ProjectionOrderRptBO {
	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getCircleList()-->"
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
	public void getDistrictList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getDistrictList()-->"
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
	public void getStoreList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getStoreList(voObj);	
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getStoreList()-->" + strErr);
		}

	}
	
	public void getFYCombo(ProjectionOrderRptVO voObj) {

	
		ProjectionOrderRptDAO.getFYCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getFYCombo()-->" + strErr);
		}

	}

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store type list
	 */
	public void getStoreTypeList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getStoreTypeList()-->"
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
	public void getSubStoreList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getStoreList()-->" + strErr);
		}

	}

	
	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the item cat list
	 */
	public void getItemCatList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getItemCatList()-->"
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
	public void getGroupList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getGroupList(voObj);
		ProjectionOrderRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getGroupList()-->" + strErr);
		}

	}
	/**
	 * Gets the drug list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the drug list
	 */
	public void getDrugList(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getDrugList()-->" + strErr);
		}

	}

	/**
	 * Gets the user level.
	 * 
	 * @param voObj
	 *            the vo obj
	 */
	public void GetUserLevel(ProjectionOrderRptVO voObj) {
		ProjectionOrderRptDAO.GetUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.GetUserLevel()-->" + strErr);
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the programme combo
	 */
	public void getProgrammeCombo(ProjectionOrderRptVO voObj) {

		ProjectionOrderRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	
	public void getReport(ProjectionOrderRptVO vo) {
		ProjectionOrderRptDAO.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ProjectionOrderRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}

}
