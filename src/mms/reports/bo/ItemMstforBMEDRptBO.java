/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;

import mms.reports.dao.ItemMstforBMEDRptDAO;
import mms.reports.vo.ItemMstforBMEDRptVO;

public class ItemMstforBMEDRptBO {
	
public void getInitDtl(ItemMstforBMEDRptVO _ItemMstforBMEDRptVO){
		
		ItemMstforBMEDRptDAO.setStoreCombo(_ItemMstforBMEDRptVO);
		
		if (_ItemMstforBMEDRptVO.getStrMsgType().equals("1")) {
			_ItemMstforBMEDRptVO.setStrMsgString("IssueToPatientDetailRptBO.getInitDtl() --> "
					+ _ItemMstforBMEDRptVO.getStrMsgString());
		}
		
	}
public void getItemCateg(ItemMstforBMEDRptVO _ItemMstforBMEDRptVO){
		
		ItemMstforBMEDRptDAO.setItemCategCombo(_ItemMstforBMEDRptVO);
		
		if (_ItemMstforBMEDRptVO.getStrMsgType().equals("1")) {
			_ItemMstforBMEDRptVO.setStrMsgString("IssueToPatientDetailRptBO.getInitDtl() --> "
					+ _ItemMstforBMEDRptVO.getStrMsgString());
		}
		
	}

/**
 * Gets the drug name combo.
 * 
 * @param _IssueDetailRptVO_NEW
 *            the _ issue detail rpt vo
 * @return the drug name combo
 */
public void getDrugNameCombo(ItemMstforBMEDRptVO _IssueDetailRptVO_NEW) {

	ItemMstforBMEDRptDAO.getDrugNameCombo(_IssueDetailRptVO_NEW);

	if (_IssueDetailRptVO_NEW.getStrMsgType().equals("1")) {
		_IssueDetailRptVO_NEW
				.setStrMsgString("IssueToPatientDetailRptBO.getDrugNameCombo() --> "
						+ _IssueDetailRptVO_NEW.getStrMsgString());
	}

}


public void getPrintDetails(ItemMstforBMEDRptVO vo) 
{
	ItemMstforBMEDRptDAO.getPrintDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("IssueToPatientDetailRptBO.getPrintDetails() --> "
				+ vo.getStrMsgString());
	}
}


}
