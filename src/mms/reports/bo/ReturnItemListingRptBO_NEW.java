/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.bo;

import mms.reports.dao.BreakageAndLostDrugDetailsRptDAO;
import mms.reports.dao.ReturnItemListingRptDAO_NEW;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.ReturnItemListingRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptBO.
 */
public class ReturnItemListingRptBO_NEW {

	/**
	 * Gets the inits the dtl.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the inits the dtl
	 */
	public void getInitDtl(ReturnItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ReturnItemListingRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("ReturnItemListingRptBO_NEW.getInitDtl() --> "
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
	public void getItemCateg(ReturnItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ReturnItemListingRptDAO_NEW.setItemCategCombo(_IssueDetailRptVO_NEW);
		ReturnItemListingRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);
		
		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW.setStrMsgString("ReturnItemListingRptBO_NEW.getItemCateg() --> "+ _IssueDetailRptVO_NEW.getStrMsgString());
		}
	}

	/**
	 * Gets the drug name combo.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the drug name combo
	 */
	public void getDrugNameCombo(ReturnItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		ReturnItemListingRptDAO_NEW.getDrugNameCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("ReturnItemListingRptBO_NEW.getDrugNameCombo() --> "
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

	public void getExistingBatchList(ReturnItemListingRptVO_NEW vo) {
		ReturnItemListingRptDAO_NEW.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ReturnItemListingRptBO_NEW.getExistingBatchList() --> "
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
	public void getProgrammeCombo(ReturnItemListingRptVO_NEW voObj) {

		ReturnItemListingRptDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("ReturnItemListingRptBO_NEW.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	public void setViewPageDtl(ReturnItemListingRptVO_NEW voObj){
		ReturnItemListingRptDAO_NEW.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("-----------------ReturnItemListingRptBO_NEW.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	public void getImgHeader(ReturnItemListingRptVO_NEW voObj){
		ReturnItemListingRptDAO_NEW.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReturnItemListingRptBO_NEW.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}

}
