package mms.transactions.bo;

import mms.transactions.dao.IssueDtlModificationTransDAO;
import mms.transactions.vo.IssueDtlModificationTransVO;

public class IssueDtlModificationTransBO 
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
	public void GetData(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.GetData(_IssueDtlModificationTransVO);
		IssueDtlModificationTransDAO.IndentPeriodCombo(_IssueDtlModificationTransVO);
		
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.GetData() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(IssueDtlModificationTransVO vo) 
	{
		IssueDtlModificationTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlModificationTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRecord(IssueDtlModificationTransVO vo)
	{
		
		
		IssueDtlModificationTransDAO.insertRecord(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDtlModificationTransBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.itemCategoryCombo(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.ItemCatgoryCombo() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(IssueDtlModificationTransVO vo) 
	{
		IssueDtlModificationTransDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlModificationTransBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(IssueDtlModificationTransVO vo) {

		IssueDtlModificationTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDtlModificationTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.getPendingDemand(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.PendingDemand() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void IndentingStoreCombo(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.IndentingStoreCombo(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.ItemCatgoryCombo() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * BatchCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public static void BatchCombo(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.getBatchCombo(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.BatchCombo() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherDetails(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.VoucherDetails(_IssueDtlModificationTransVO);
		//IssueDtlModificationTransDAO.VoucherItemDetails(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.VoucherDetails() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherCombo(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.getVoucherCombo(_IssueDtlModificationTransVO);
		IssueDtlModificationTransDAO.getVerifyByCombo(_IssueDtlModificationTransVO);
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.VoucherCombo() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{		
		IssueDtlModificationTransDAO.getAvalBudgetDetails(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.GetStoreBudget() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueDtlModificationTransVO _IssueDtlModificationTransVO){
		
		 
		IssueDtlModificationTransDAO.GetData(_IssueDtlModificationTransVO);
		IssueDtlModificationTransDAO.getUnitCombo(_IssueDtlModificationTransVO);
		IssueDtlModificationTransDAO.getDrugNameCombo(_IssueDtlModificationTransVO);
		IssueDtlModificationTransDAO.IndentingStoreCombo(_IssueDtlModificationTransVO);
		if (_IssueDtlModificationTransVO.getStrMsgType().equals("1"))
		{
			_IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.initForViewPage() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		}
	}
	
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getVoucherCombo(IssueDtlModificationTransVO _IssueDtlModificationTransVO){
		
		IssueDtlModificationTransDAO.getVoucherCombo(_IssueDtlModificationTransVO);
		if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")){
			_IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.getVoucherCombo() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		
	}

	
	
	/**
	 * getAvlQty  Method 
	 * @param vo
	 */
	
	public void getAvlQty(IssueDtlModificationTransVO _IssueDtlModificationTransVO)
	{
		IssueDtlModificationTransDAO.getAvlQty(_IssueDtlModificationTransVO);
		
		  if (_IssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueDtlModificationTransVO.setStrMsgString("IssueDtlModificationTransBO.getAvlQty() --> "+ _IssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
}
