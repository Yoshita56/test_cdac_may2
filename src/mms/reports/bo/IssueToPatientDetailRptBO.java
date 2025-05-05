/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;

import mms.reports.dao.IssueDetailRptDAO_NEW;
import mms.reports.dao.IssueToPatientDetailRptDAO;
import mms.reports.dao.ListConsumablesExpiryDateRptDAO;
import mms.reports.vo.IssueDetailRptVO_NEW;
import mms.reports.vo.IssueToPatientDetailRptVO;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;

public class IssueToPatientDetailRptBO {
	
public void getInitDtl(IssueToPatientDetailRptVO _IssueToPatientDetailRptVO){
		
		IssueToPatientDetailRptDAO.setStoreCombo(_IssueToPatientDetailRptVO);
		
		if (_IssueToPatientDetailRptVO.getStrMsgType().equals("1")) {
			_IssueToPatientDetailRptVO.setStrMsgString("IssueToPatientDetailRptBO.getInitDtl() --> "
					+ _IssueToPatientDetailRptVO.getStrMsgString());
		}
		
	}
public void getItemCateg(IssueToPatientDetailRptVO _IssueToPatientDetailRptVO){
		
		IssueToPatientDetailRptDAO.setItemCategCombo(_IssueToPatientDetailRptVO);
		
		if (_IssueToPatientDetailRptVO.getStrMsgType().equals("1")) {
			_IssueToPatientDetailRptVO.setStrMsgString("IssueToPatientDetailRptBO.getInitDtl() --> "
					+ _IssueToPatientDetailRptVO.getStrMsgString());
		}
		
	}

/**
 * Gets the drug name combo.
 * 
 * @param _IssueDetailRptVO_NEW
 *            the _ issue detail rpt vo
 * @return the drug name combo
 */
public void getDrugNameCombo(IssueToPatientDetailRptVO _IssueDetailRptVO_NEW) {

	IssueToPatientDetailRptDAO.getDrugNameCombo(_IssueDetailRptVO_NEW);

	if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
		_IssueDetailRptVO_NEW
				.setStrMsgString("IssueToPatientDetailRptBO.getDrugNameCombo() --> "
						+ _IssueDetailRptVO_NEW.getStrMsgString());
	}

}


public void getPrintDetails(IssueToPatientDetailRptVO vo) 
{
	IssueToPatientDetailRptDAO.getPrintDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("IssueToPatientDetailRptBO.getPrintDetails() --> "
				+ vo.getStrMsgString());
	}
}

public void getImgHeader(IssueToPatientDetailRptVO vo){
	IssueToPatientDetailRptDAO.getImageHeader(vo);
	if (vo.getStrMsgType().equals("1")){
		vo.setStrMsgString("IssueToPatientDetailRptBO.getImgHeader() --> "+ vo.getStrMsgString());
	  }
}


}
