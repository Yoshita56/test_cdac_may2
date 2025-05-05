package mms.reports.bo;
import mms.reports.dao.ReturnDetailRptDAO;
import mms.reports.vo.ReturnDetailRptVO;

public class ReturnDetailRptBO {
public void getInitDtl(ReturnDetailRptVO _ReturnDetailRptVO){
		
/*	ReturnDetailRptDAO.setStoreCombo(_ReturnDetailRptVO);
		
		if (_ReturnDetailRptVO.getStrMsgType().equals("1")) {
			_ReturnDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
					+ _ReturnDetailRptVO.getStrMsgString());
		}
		*/
	}
public void getItemCateg(ReturnDetailRptVO _ReturnDetailRptVO){
		
		ReturnDetailRptDAO.setItemCategCombo(_ReturnDetailRptVO);
		
		if (_ReturnDetailRptVO.getStrMsgType().equals("1")) {
			_ReturnDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
					+ _ReturnDetailRptVO.getStrMsgString());
		}
		
	}


public void setStoreCombo(ReturnDetailRptVO _ReturnDetailRptVO){
	
	ReturnDetailRptDAO.setStoreCombo(_ReturnDetailRptVO);
	
	if (_ReturnDetailRptVO.getStrMsgType().equals("1")) {
		_ReturnDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
				+ _ReturnDetailRptVO.getStrMsgString());
	}
	
}
public void getHospitalName(ReturnDetailRptVO voObj)
{
	ReturnDetailRptDAO.getHospitalName(voObj);
	if (voObj.getStrMsgType().equals("1")) 
	{
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("IssueDetailRptBO.getHospitalName()-->"+strErr);
	}		
}


}
