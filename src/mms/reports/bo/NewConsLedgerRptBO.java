package mms.reports.bo;

import mms.reports.dao.NewConsLedgerRptDAO;
import mms.reports.vo.NewConsLedgerRptVO;

public class NewConsLedgerRptBO {

	public void getInitDtl(NewConsLedgerRptVO _NewConsLedgerRptVO)
	{
			NewConsLedgerRptDAO.setStoreCombo(_NewConsLedgerRptVO);
			NewConsLedgerRptDAO.getFYCombo(_NewConsLedgerRptVO);	// call the DAO method in BO file
			
			if (_NewConsLedgerRptVO.getStrMsgType().equals("1")) 
			{
				_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptBO.getInitDtl() --> "+ _NewConsLedgerRptVO.getStrMsgString());
			}				
	}
	public void setStoreCombo(NewConsLedgerRptVO _NewConsLedgerRptVO)
	{
		NewConsLedgerRptDAO.setStoreCombo(_NewConsLedgerRptVO);
		if (_NewConsLedgerRptVO.getStrMsgType().equals("1")) 
		{
				_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptBO.getInitDtl() --> "+ _NewConsLedgerRptVO.getStrMsgString());
		}				
	}
	
	/**
	 * 
	 * @param _NewConsLedgerRptVO
	 */
	public void getItemCateg(NewConsLedgerRptVO _NewConsLedgerRptVO){
			
			NewConsLedgerRptDAO.setItemCategCombo(_NewConsLedgerRptVO);
			
			if (_NewConsLedgerRptVO.getStrMsgType().equals("1")) {
				_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptBO.getInitDtl() --> "
						+ _NewConsLedgerRptVO.getStrMsgString());
			}
			
		}
	
	
	public void getUserCombo(NewConsLedgerRptVO _NewConsLedgerRptVO){
		
		NewConsLedgerRptDAO.getUserCombo(_NewConsLedgerRptVO);
		
		if (_NewConsLedgerRptVO.getStrMsgType().equals("1")) {
			_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptBO.getInitDtl() --> "
					+ _NewConsLedgerRptVO.getStrMsgString());
		}
		
	}


	public void getDrugNameCombo(NewConsLedgerRptVO _NewConsLedgerRptVO){
		
		NewConsLedgerRptDAO.getDrugNameCombo(_NewConsLedgerRptVO);
		
		if (_NewConsLedgerRptVO.getStrMsgType().equals("1")) 
		{
			_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptBO.getInitDtl() --> "	+ _NewConsLedgerRptVO.getStrMsgString());
		}
		
	}
	
	/**
	 * for get Existing Batch List
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchList(NewConsLedgerRptVO vo) {
		NewConsLedgerRptDAO.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("NewConsLedgerRptBO.getExistingBatchList() --> "
					+ strErr);
		}

	}
	public void getHospitalName(NewConsLedgerRptVO voObj)
	{
		NewConsLedgerRptDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("NewConsLedgerRptBO.getHospitalName()-->"+strErr);
		}		
	}
	
	public void getReportData(NewConsLedgerRptVO voObj)
	{
		NewConsLedgerRptDAO.getReportData(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("NewConsLedgerRptBO.getReportData()-->"+strErr);
		}		
	}
	public void getDetailedReportData(NewConsLedgerRptVO voObj) {
		// TODO Auto-generated method stub
		NewConsLedgerRptDAO.getDetailedReportData(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("NewConsLedgerRptBO.getDetailedReportData()-->"+strErr);
		}	
		
	}

	
}
