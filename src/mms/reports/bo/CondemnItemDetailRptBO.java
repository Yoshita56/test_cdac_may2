package mms.reports.bo;


import mms.reports.dao.CondemnItemDetailRptDAO;
import mms.reports.vo.CondemnItemDetailRptVO;

public class CondemnItemDetailRptBO {
	/**
	 * forward Control Dao to fetch values in iten category combo
	 * @param _CondemnItemDetailRptVO
	 */
	public void getInit(CondemnItemDetailRptVO _CondemnItemDetailRptVO){
		
		CondemnItemDetailRptDAO.setItemCategCombo(_CondemnItemDetailRptVO);
		if (_CondemnItemDetailRptVO.getStrMsgType().equals("1")) {
			_CondemnItemDetailRptVO.setStrMsgString("CondemnItemDetailRptBO.getInitDtl() --> "
					+ _CondemnItemDetailRptVO.getStrMsgString());
		}
		
	}
		
}


