/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;

import mms.reports.dao.IssuePatDetailRptDAO;
import mms.reports.vo.IssuePatDetailRptVO;

public class IssuePatDetailRptBO {
	
public void getInitDtl(IssuePatDetailRptVO _IssuePatDetailRptVO){
		
		IssuePatDetailRptDAO.setStoreCombo(_IssuePatDetailRptVO);
		
		if (_IssuePatDetailRptVO.getStrMsgType().equals("1")) {
			_IssuePatDetailRptVO.setStrMsgString("IssuePatDetailRptBO.getInitDtl() --> "
					+ _IssuePatDetailRptVO.getStrMsgString());
		}
		
	}
public void getItemCateg(IssuePatDetailRptVO _IssuePatDetailRptVO){
		
		IssuePatDetailRptDAO.setItemCategCombo(_IssuePatDetailRptVO);
		
		if (_IssuePatDetailRptVO.getStrMsgType().equals("1")) {
			_IssuePatDetailRptVO.setStrMsgString("IssuePatDetailRptBO.getInitDtl() --> "
					+ _IssuePatDetailRptVO.getStrMsgString());
		}
		
	}


}
