package mms.transactions.bo;

import mms.transactions.dao.IssueDtlBackLogDAO;
import mms.transactions.vo.IssueDtlBackLogVO;

public class IssueDtlBackLogBO 
{
	/**
	 * BO Method is Used To Get the DAO method
	 * to intreact with Database 
	 * @param vo
	 * @throws Exception
	 */
	
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetData(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.GetData(_IssueDtlBackLogVO);
		IssueDtlBackLogDAO.IndentPeriodCombo(_IssueDtlBackLogVO);
		
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.GetData() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(IssueDtlBackLogVO vo) 
	{
		IssueDtlBackLogDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlBackLogBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRecord(IssueDtlBackLogVO vo)
	{
		
		
		IssueDtlBackLogDAO.insertRecord(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDtlBackLogBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.itemCategoryCombo(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.ItemCatgoryCombo() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(IssueDtlBackLogVO vo) 
	{
		IssueDtlBackLogDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlBackLogBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(IssueDtlBackLogVO vo) {

		IssueDtlBackLogDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlBackLogBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.getPendingDemand(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.PendingDemand() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void IndentingStoreCombo(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.IndentingStoreCombo(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.ItemCatgoryCombo() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * BatchCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public static void BatchCombo(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.getBatchCombo(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.BatchCombo() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public static void VoucherDetails(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.VoucherDetails(_IssueDtlBackLogVO);
		//IssueDtlBackLogDAO.VoucherItemDetails(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.VoucherDetails() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherCombo(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{
		IssueDtlBackLogDAO.getVoucherCombo(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.VoucherCombo() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(IssueDtlBackLogVO _IssueDtlBackLogVO)
	{		
		IssueDtlBackLogDAO.getAvalBudgetDetails(_IssueDtlBackLogVO);
		
		  if (_IssueDtlBackLogVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.GetStoreBudget() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueDtlBackLogVO _IssueDtlBackLogVO){
		
		 
		IssueDtlBackLogDAO.GetData(_IssueDtlBackLogVO);
		IssueDtlBackLogDAO.getUnitCombo(_IssueDtlBackLogVO);
		IssueDtlBackLogDAO.getDrugNameCombo(_IssueDtlBackLogVO);
		IssueDtlBackLogDAO.IndentingStoreCombo(_IssueDtlBackLogVO);
		if (_IssueDtlBackLogVO.getStrMsgType().equals("1"))
		{
			_IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.initForViewPage() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		}
	}
	
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getVoucherCombo(IssueDtlBackLogVO _IssueDtlBackLogVO){
		
		IssueDtlBackLogDAO.getVoucherCombo(_IssueDtlBackLogVO);
		if (_IssueDtlBackLogVO.getStrMsgType().equals("1")){
			_IssueDtlBackLogVO.setStrMsgString("IssueDtlBackLogBO.getVoucherCombo() --> "+ _IssueDtlBackLogVO.getStrMsgString());
		  }
		
	}

	


}
