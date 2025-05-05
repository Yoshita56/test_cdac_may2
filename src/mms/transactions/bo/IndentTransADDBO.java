package mms.transactions.bo;

import mms.transactions.dao.IndentTransADDDAO;
import mms.transactions.dao.IssueToPatOPDTransDAO;
import mms.transactions.vo.IndentTransADDVO;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentTransADDBO 
{
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetData(IndentTransADDVO vo)
	{
		IndentTransADDDAO.GetData(vo);
		IndentTransADDDAO.itemCategoryCombo(vo);
		IndentTransADDDAO.getAvalBudgetDetails(vo);
		IndentTransADDDAO.ToStoreCombo(vo);
		IndentTransADDDAO.IndentPeriodCombo(vo);
		IndentTransADDDAO.getItemBrandList(vo);	
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.GetData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetData Method is Used to Populate the Data  for
	 * @param vo
	 */
	public void GetItemDrugList(IndentTransADDVO vo)
	{
		
		IndentTransADDDAO.getItemBrandList(vo);	
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.GetItemDrugList() --> "+ vo.getStrMsgString());
		  }
		  
	}
	public void getIssueDtlsInitDtls(IndentTransADDVO vo) 
	{

		IndentTransADDDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IndentTransADDBO.IndentTransADDDAO() --> "+ strErr);

		}

	}
	/**
	 * Calling Function Method is Used to Populate the Data  for add page
	 * here we get Store Name & Indent Type & Item Category
	 * @param vo
	 */
	public void CallFunction(IndentTransADDVO vo)
	{
 
		  IndentTransADDDAO.callingFunctionStoreName(vo);
		  IndentTransADDDAO.callingFunctionIndentType(vo);
		  IndentTransADDDAO.callingItemCategory(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.CallFunction() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(IndentTransADDVO vo)
	{
		IndentTransADDDAO.INSERT_NEW(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT_NEW_FINDER_DATA  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT_NEW_FINDER_DATA(IndentTransADDVO vo)
	{
		IndentTransADDDAO.INSERT_NEW_FINDER_DATA(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.INSERT_NEW_FINDER_DATA() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT_NA_NEW  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT_NA_NEW(IndentTransADDVO vo)
	{
		IndentTransADDDAO.INSERT_NA_NEW(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.INSERT_NA_NEW() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	
	
	public void rejectIndentBczNA(IndentTransADDVO vo)
	{
		IndentTransADDDAO.rejectIndentBczNA(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.rejectIndentBczNA() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void PLACEREGULARINDENT(IndentTransADDVO vo)
	{
		IndentTransADDDAO.PLACEREGULARINDENT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IndentTransADDBO.PLACEREGULARINDENT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	

}
