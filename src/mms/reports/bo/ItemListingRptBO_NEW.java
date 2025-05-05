/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.bo;

import mms.reports.dao.ItemListingRptDAO_NEW;
import mms.reports.vo.ItemListingRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptBO.
 */
public class ItemListingRptBO_NEW {

	/**
	 * Gets the inits the dtl.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the inits the dtl
	 */
	public void getInitDtl(ItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ItemListingRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
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
	public void getItemCateg(ItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ItemListingRptDAO_NEW.setItemCategCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
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
	public void getDrugNameCombo(ItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ItemListingRptDAO_NEW.getDrugNameCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
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

	public void getExistingBatchList(ItemListingRptVO_NEW vo) {
		ItemListingRptDAO_NEW.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("IssueDetailRptBO.getExistingBatchList() --> "
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
	public void getProgrammeCombo(ItemListingRptVO_NEW voObj) {

		ItemListingRptDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueDetailRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}

}
