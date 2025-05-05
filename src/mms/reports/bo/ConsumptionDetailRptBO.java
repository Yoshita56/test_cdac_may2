/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;


import mms.reports.dao.ConsumptionDetailRptDAO;
import mms.reports.dao.ItemWiseConsumptionRptDAO;
import mms.reports.vo.ConsumptionDetailRptVO;
import mms.reports.vo.ItemWiseConsumptionRptVO;
public class ConsumptionDetailRptBO {
	
/**
 * This function is used to inoke DAO Function to set initial values in Store Combo
 * @param _ConsumptionDetailRptVO
 */	
public void getInit(ConsumptionDetailRptVO _ConsumptionDetailRptVO){
		
		ConsumptionDetailRptDAO.setStoreCombo(_ConsumptionDetailRptVO);
		if (_ConsumptionDetailRptVO.getStrMsgType().equals("1")) {
			_ConsumptionDetailRptVO.setStrMsgString("ConsumptionDetailRptBO.getInitDtl() --> "
					+ _ConsumptionDetailRptVO.getStrMsgString());
		}
		
  }
/**
 * This function is used to inoke DAO Function to set initial values in ItemCategory Combo
 * @param _ConsumptionDetailRptVO
 */	
public void getItemCateg(ConsumptionDetailRptVO _ConsumptionDetailRptVO){
		
		ConsumptionDetailRptDAO.setItemCategCombo(_ConsumptionDetailRptVO);
		if (_ConsumptionDetailRptVO.getStrMsgType().equals("1")) {
			_ConsumptionDetailRptVO.setStrMsgString("ConsumptionDetailRptBO.getInitDtl() --> "
					+ _ConsumptionDetailRptVO.getStrMsgString());
		}
		
  }
public void getHospitalName(ConsumptionDetailRptVO voObj)
{
	ConsumptionDetailRptDAO.getHospitalName(voObj);
	if (voObj.getStrMsgType().equals("1")) 
	{
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("ItemWiseConsumptionRptBO.getHospitalName()-->"+strErr);
	}		
}
}
