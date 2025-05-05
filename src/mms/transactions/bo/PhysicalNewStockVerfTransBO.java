package mms.transactions.bo;

import mms.transactions.dao.PhysicalNewStockVerfTransDAO;
import mms.transactions.vo.PhysicalNewStockVerfTransVO;

public class PhysicalNewStockVerfTransBO {

	/**
	 * BO Method is Used To Get the DAO method to intreact with Database.
	 * 
	 * @param vo
	 *            the _ breakage item dtl trans voS
	 */

	/**
	 * GetData Method is Used to Populate the Data for Breakage Item Details DAO
	 * 
	 * @param vo
	 */
	public void GetData(PhysicalNewStockVerfTransVO vo)
	{
		PhysicalNewStockVerfTransDAO.GetData(vo);		
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("PhysicalNewStockVerfTransBO.GetData() --> "
							+ vo.getStrMsgString());
		}
	}	

	/**
	 * GetData Method is Used to Populate the Data for Breakage Item Details DAO
	 * 
	 * @param vo
	 */
	public void CombineProc(PhysicalNewStockVerfTransVO vo)
	{
		PhysicalNewStockVerfTransDAO.UtilityProc(vo);		
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("PhysicalNewStockVerfTransBO.CombineProc() --> "
							+ vo.getStrMsgString());
		}
	}	
	
	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void DeleteRecord(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.DeleteRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.DeleteRecord() --> "
					+ vo.getStrMsgString());
		}

	}
	

	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void TOBEVERIFY(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.TOBEVERIFY(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.TOBEVERIFY() --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void MODIFY(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.MODIFY(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.MODIFY() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void STOCKUPDATECANCEL(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.STOCKUPDATECANCEL(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.STOCKUPDATECANCEL() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * GRPNAMECOMBO Method is Used to Generate Group Name Combo.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void NEWDRUGDTLS(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.groupCombo(vo);
		PhysicalNewStockVerfTransDAO.suppliedByCombo(vo);
		PhysicalNewStockVerfTransDAO.drugNameCombo(vo);
		PhysicalNewStockVerfTransDAO.unitNameCombo(vo);
		PhysicalNewStockVerfTransDAO.stockStatusCombo(vo);
		//PhysicalNewStockVerfTransDAO.ProgrammeCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.NEWDRUGDTLS() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * 
	 * method name : viewData
	 * 
	 * @param vo
	 */

	public void viewData(PhysicalNewStockVerfTransVO vo) 
	{		
		PhysicalNewStockVerfTransDAO.getIndentDetailsView(vo);
		PhysicalNewStockVerfTransDAO.callingFunctionIndentName(vo);
		PhysicalNewStockVerfTransDAO.UtilityProc(vo);
		PhysicalNewStockVerfTransDAO.getTolranceLimit(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.viewData() --> " + vo.getStrMsgString());
		}

	}
	
	
	/**
	 * GRPNAMECOMBO Method is Used to Generate Group Name Combo.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void getGroupDrug(PhysicalNewStockVerfTransVO vo) 
	{		
		PhysicalNewStockVerfTransDAO.drugNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.getGroupDrug() --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * Inits the for view page.
	 * 
	 * @param vo
	 *            the _ breakage item dtl trans vo
	 */
	public void initForViewPage(PhysicalNewStockVerfTransVO vo) {

		PhysicalNewStockVerfTransDAO.GetData(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("PhysicalNewStockVerfTransBO.initForViewPage() --> "
							+ vo.getStrMsgString());
		}
	}
	

	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertForApproval(PhysicalNewStockVerfTransVO vo) 
	{
		PhysicalNewStockVerfTransDAO.insertForApproval(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PhysicalNewStockVerfTransBO.insertForApproval() --> "
					+ vo.getStrMsgString());
		}

	}
	public void getItemCateg(PhysicalNewStockVerfTransVO _IssueDetailRptVO){
		
		PhysicalNewStockVerfTransDAO.setItemCategCombo(_IssueDetailRptVO);
		
		if (_IssueDetailRptVO.getStrMsgType().equals("1")) {
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
					+ _IssueDetailRptVO.getStrMsgString());
		}
		
	}

	
}