/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
 *  
*/
package mms.transactions.bo;
import mms.transactions.dao.BreakageItemDtlTransDAO;
import mms.transactions.vo.BreakageItemDtlTransVO;

public class BreakageItemDtlTransBO 
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
	public void GetData(BreakageItemDtlTransVO _BreakageItemDtlTransVO)
	{
		BreakageItemDtlTransDAO.GetData(_BreakageItemDtlTransVO);
		
		
		  if (_BreakageItemDtlTransVO.getStrMsgType().equals("1")) 
		  {
			  _BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransBO.GetData() --> "+ _BreakageItemDtlTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void getApprovedByCombo(BreakageItemDtlTransVO _BreakageItemDtlTransVO)
	{
		
		BreakageItemDtlTransDAO.getApprovedByCombo(_BreakageItemDtlTransVO);
		
		  if (_BreakageItemDtlTransVO.getStrMsgType().equals("1")) 
		  {
			  _BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransBO.getApprovedByCombo() --> "+ _BreakageItemDtlTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(BreakageItemDtlTransVO vo)
	{
		BreakageItemDtlTransDAO.INSERT(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("BreakageItemDtlTransBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	/**
	 * GRPNAMECOMBO  Method is Used to Generate Group Name Combo 
	 * @param vo
	 */
	
	public void GRPNAMECOMBO(BreakageItemDtlTransVO vo)
	{
		BreakageItemDtlTransDAO.getStoreGroupList(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("BreakageItemDtlTransBO.GRPNAMECOMBO() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ITEMCATEGORYCOMBO  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ITEMCATEGORYCOMBO(BreakageItemDtlTransVO vo)
	{
		System.out.println("for local purchase3");
		BreakageItemDtlTransDAO.itemCategoryCombo(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("BreakageItemDtlTransBO.ITEMCATEGORYCOMBO() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void initForViewPage(BreakageItemDtlTransVO _BreakageItemDtlTransVO){
		
		 
		BreakageItemDtlTransDAO.GetData(_BreakageItemDtlTransVO);
		if (_BreakageItemDtlTransVO.getStrMsgType().equals("1")){
			_BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransBO.initForViewPage() --> "+ _BreakageItemDtlTransVO.getStrMsgString());
		  }
	}
	
	public void setViewPageDtl(BreakageItemDtlTransVO _BreakageItemDtlTransVO){
		
		BreakageItemDtlTransDAO.getViewDtl(_BreakageItemDtlTransVO);
		if (_BreakageItemDtlTransVO.getStrMsgType().equals("1")){
			_BreakageItemDtlTransVO.setStrMsgString("BreakageItemDtlTransBO.setViewPageDtl() --> "+ _BreakageItemDtlTransVO.getStrMsgString());
		  }
		
	}
	

}
