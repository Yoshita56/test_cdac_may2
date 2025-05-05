package mms.reports.bo;

import mms.reports.dao.StoreHierarchyViewDAO;
import mms.reports.vo.StoreHierarchyViewVO;

//import mms.reports.dao.StoreHierarchyViewDAO;
//import mms.reports.vo.StoreHierarchyViewVO;

public class StoreHierarchyViewBO {

	public void getInitDtl(StoreHierarchyViewVO _IssueDetailRptVO_NEW) {

		StoreHierarchyViewDAO.setStoreCombo(_IssueDetailRptVO_NEW);

		if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
							+ _IssueDetailRptVO_NEW.getStrMsgString());
		}

	}

	public void setViewPageDtl(StoreHierarchyViewVO voObj){
		StoreHierarchyViewDAO.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("-----------------ReturnItemListingRptBO_NEW.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}


}
