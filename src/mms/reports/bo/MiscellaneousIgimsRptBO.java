package mms.reports.bo;

import mms.reports.dao.MiscellaneousIgimsRptDAO;
import mms.reports.vo.MiscellaneousIgimsRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptBO.
 */
public class MiscellaneousIgimsRptBO {

	/**
	 * Gets the inits the dtl.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the inits the dtl
	 */
	public void getInitDtl(MiscellaneousIgimsRptVO _IssueDetailRptVO_NEW) {

		MiscellaneousIgimsRptDAO.setStoreCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("MiscItemListingRptBO_NEW.getInitDtl() --> "
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
	public void getItemCateg(MiscellaneousIgimsRptVO _IssueDetailRptVO_NEW) {

		MiscellaneousIgimsRptDAO.setItemCategCombo(_IssueDetailRptVO_NEW);
		MiscellaneousIgimsRptDAO.setStoreCombo(_IssueDetailRptVO_NEW);
		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW.setStrMsgString("MiscItemListingRptBO_NEW.getInitDtl() --> "
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
	public void getDrugNameCombo(MiscellaneousIgimsRptVO _IssueDetailRptVO_NEW) {

		MiscellaneousIgimsRptDAO.getDrugNameCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("MiscItemListingRptBO_NEW.getInitDtl() --> "
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

	public void getExistingBatchList(MiscellaneousIgimsRptVO vo) {
		MiscellaneousIgimsRptDAO.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MiscItemListingRptBO_NEW.getExistingBatchList() --> "
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
	public void getProgrammeCombo(MiscellaneousIgimsRptVO voObj) {

		MiscellaneousIgimsRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("MiscItemListingRptBO_NEW.getProgrammeCombo()-->"
					+ strErr);
		}
	}
	
	public void setViewPageDtl(MiscellaneousIgimsRptVO voObj){
		MiscellaneousIgimsRptDAO.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("MiscItemListingRptBO_NEW.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
    
    public void getImgHeader(MiscellaneousIgimsRptVO voObj){
    	MiscellaneousIgimsRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("MiscItemListingRptBO_NEW.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

}
