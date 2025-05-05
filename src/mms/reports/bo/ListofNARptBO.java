package mms.reports.bo;

import mms.reports.dao.ListofNARptDAO;
import mms.reports.vo.ListofNARptVO;

public class ListofNARptBO {

	/**
	 * Gets the inits the dtl.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the inits the dtl
	 */
	public void getInitDtl(ListofNARptVO _IssueDetailRptVO_NEW) {

		ListofNARptDAO.setStoreCombo(_IssueDetailRptVO_NEW);

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
	public void getItemCateg(ListofNARptVO _IssueDetailRptVO_NEW) {

		ListofNARptDAO.setItemCategCombo(_IssueDetailRptVO_NEW);
		ListofNARptDAO.setStoreCombo(_IssueDetailRptVO_NEW);
		
		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _IssueDetailRptVO_NEW.getStrMsgString());
		}
	}

	/**
	 * Gets the drug name combo.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the _ issue detail rpt vo
	 * @return the drug name combo
	 */
	public void getDrugNameCombo(ListofNARptVO _IssueDetailRptVO_NEW) {

		ListofNARptDAO.getDrugNameCombo(_IssueDetailRptVO_NEW);

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

	public void getExistingBatchList(ListofNARptVO vo) {
		ListofNARptDAO.getExistingBatchList(vo);
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
	public void getProgrammeCombo(ListofNARptVO voObj) {

		ListofNARptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("IssueDetailRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	public void setViewPageDtl(ListofNARptVO voObj){
		ListofNARptDAO.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("-----------------IssueDetailRptBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
	public void getItemCatList(ListofNARptVO voObj){
		
		ListofNARptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueDetailRptBO.getItemCatList()-->"+strErr);
				}
				
		}
	public void getReqTypeList(ListofNARptVO voObj){
		
		ListofNARptDAO.getIReqTypeList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueDetailRptBO.getReqTypeList()-->"+strErr);
				}
				
		}
	
      public void getIssuingStoreList(ListofNARptVO voObj)
      {
		
		ListofNARptDAO.getIssuingStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueDetailRptBO.getIssuingStoreList()-->"+strErr);
				}
				
		}
      
      public void getImgHeader(ListofNARptVO voObj){
    	  ListofNARptDAO.getImageHeader(voObj);
  		if (voObj.getStrMsgType().equals("1")){
  			voObj.setStrMsgString("IssueDetailRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
  		  }
  	}

}
