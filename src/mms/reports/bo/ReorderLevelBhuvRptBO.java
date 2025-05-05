package mms.reports.bo;

import mms.reports.dao.JobDetailsRptDAO;
import mms.reports.dao.ReorderLevelBhuvRptDAO;
import mms.reports.vo.JobDetailsRptVO;
import mms.reports.vo.ReorderLevelBhuvRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectionOrderRptBO.
 */
public class ReorderLevelBhuvRptBO {
	/**
	 * Gets the circle list.
	 * 
//	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getCircleList(voObj);
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
	public void getDistrictList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getDistrictList(voObj);
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
	public void getStoreList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getStoreList(voObj);	
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getStoreList()-->" + strErr);
		}

	}
	
	public void getFYCombo(ReorderLevelBhuvRptVO voObj) {

	
		ReorderLevelBhuvRptDAO.getFYCombo(voObj);
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
	public void getStoreTypeList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getDwhTypeCombo(voObj);
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
	public void getSubStoreList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getSubStoreList(voObj);
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
	public void getItemCatList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getItemCatList(voObj);
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
	public void getGroupList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getGroupList(voObj);
		ReorderLevelBhuvRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getItemTypeValues(voObj);
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
	public void getDrugList(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getDrugList(voObj);
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
	public void GetUserLevel(ReorderLevelBhuvRptVO voObj) {
		ReorderLevelBhuvRptDAO.GetUserLevel(voObj);
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
	public void getProgrammeCombo(ReorderLevelBhuvRptVO voObj) {

		ReorderLevelBhuvRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ProjectionOrderRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void getImgHeader(ReorderLevelBhuvRptVO voObj){
		ReorderLevelBhuvRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReorderLevelBhuvRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
	public void getReport(ReorderLevelBhuvRptVO vo) {
		ReorderLevelBhuvRptDAO.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReorderLevelBhuvRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}

}
