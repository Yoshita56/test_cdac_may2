/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.bo;

import mms.reports.dao.MiscItemListingRptDAO_NEW;
import mms.reports.vo.MiscItemListingRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptBO.
 */
public class MiscItemListingRptBO_NEW {

	public void getInitDtl(MiscItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		MiscItemListingRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);
		MiscItemListingRptDAO_NEW.setItemCategCombo(_IssueDetailRptVO_NEW);
		
		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("MiscItemListingRptBO_NEW.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}
	}
	
	public void getItemCateg(MiscItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		MiscItemListingRptDAO_NEW.setItemCategCombo(_IssueDetailRptVO_NEW);
//		MiscItemListingRptDAO_NEW.setStoreCombo(_IssueDetailRptVO_NEW);
		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW.setStrMsgString("MiscItemListingRptBO_NEW.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}

	}
	
	
	public void getGroupName(MiscItemListingRptVO_NEW vo)
	{
		MiscItemListingRptDAO_NEW.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("MiscItemListingRptBO_NEW.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the drug name combo.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the drug name combo
	 */
	public void getDrugNameCombo(MiscItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		MiscItemListingRptDAO_NEW.getDrugNameCombo(_IssueDetailRptVO_NEW);

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

	public void getExistingBatchList(MiscItemListingRptVO_NEW vo) {
		MiscItemListingRptDAO_NEW.getExistingBatchList(vo);
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
	public void getProgrammeCombo(MiscItemListingRptVO_NEW voObj) {

		MiscItemListingRptDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("MiscItemListingRptBO_NEW.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void setViewPageDtl(MiscItemListingRptVO_NEW voObj){
		MiscItemListingRptDAO_NEW.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("MiscItemListingRptBO_NEW.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
    
    public void getImgHeader(MiscItemListingRptVO_NEW voObj){
    	MiscItemListingRptDAO_NEW.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("MiscItemListingRptBO_NEW.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

}
