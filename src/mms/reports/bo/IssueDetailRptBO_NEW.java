/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.bo;

import mms.reports.dao.IssueDetailRptDAO_NEW;
import mms.reports.vo.IssueDetailRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptBO.
 */
public class IssueDetailRptBO_NEW {

	/**
	 * Gets the inits the dtl.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the inits the dtl
	 */
	public void getInitDtl(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {

		IssueDetailRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO_NEW.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}

	}

	/**
	 * Gets the item categ.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the item categ
	 */
	public void getItemCateg(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {

		IssueDetailRptDAO_NEW.setItemCategCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO_NEW.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}

	}

	/**
	 * Gets the drug name combo.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the drug name combo
	 */
	public void getDrugNameCombo(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {

		IssueDetailRptDAO_NEW.getDrugNameCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO_NEW.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}

	}

	/**
	 * for get Existing Batch List.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch list
	 */

	public void getExistingBatchList(IssueDetailRptVO_NEW vo) {
		IssueDetailRptDAO_NEW.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("IssueDetailRptBO_NEW.getExistingBatchList() --> "
					+ strErr);
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the programme combo
	 */
	public void getProgrammeCombo(IssueDetailRptVO_NEW voObj) {

		IssueDetailRptDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueDetailRptBO_NEW.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void showReportNew(IssueDetailRptVO_NEW voObj) {

		IssueDetailRptDAO_NEW.showReportNew(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueDetailRptBO_NEW.showReportNew()-->"
					+ strErr);
		}

	}

}
