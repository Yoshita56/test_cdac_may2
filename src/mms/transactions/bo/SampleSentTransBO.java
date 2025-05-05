package mms.transactions.bo;

import mms.transactions.dao.SampleSentTransDAO;
import mms.transactions.vo.SampleSentTransVO;

public class SampleSentTransBO 
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
	public void initSampleSent(SampleSentTransVO _SampleSentTransVO)
	{
		SampleSentTransDAO.initSampleSent(_SampleSentTransVO);
		SampleSentTransDAO.getLabNameCmb(_SampleSentTransVO);
		
		  if (_SampleSentTransVO.getStrMsgType().equals("1")) 
		  {
			  _SampleSentTransVO.setStrMsgString("SampleSentTransBO.initSampleSent() --> "+ _SampleSentTransVO.getStrMsgString());
		  }
		  
	}
	/**
	 * for getting value of unit combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void unitNameCombo(SampleSentTransVO vo) {
		SampleSentTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SampleSentTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}
	
	
	public void getDrugNameCmb(SampleSentTransVO vo)
	{
		
		SampleSentTransDAO.getDrugNameCmb(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getDrugNameCmb()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getCategoryCmb(SampleSentTransVO vo)
	{
		
		SampleSentTransDAO.getCategoryCmb(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getCategoryCmb()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getDrugBatchDtl(SampleSentTransVO vo)
	{
		
		SampleSentTransDAO.getDrugBatchDtl(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getDrugBatchDtl()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	
	public void getDrugBatchCmb(SampleSentTransVO vo)
	{
		
		SampleSentTransDAO.getDrugBatchCmb(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getDrugBatchCmb()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getViewHlp(SampleSentTransVO vo)
	{
		
		SampleSentTransDAO.getViewHlp(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getViewHlp()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void getApprovedByCombo(SampleSentTransVO _SampleSentTransVO)
	{
		
		SampleSentTransDAO.getApprovedByCombo(_SampleSentTransVO);
		
		  if (_SampleSentTransVO.getStrMsgType().equals("1")) 
		  {
			  _SampleSentTransVO.setStrMsgString("SampleSentTransBO.getApprovedByCombo() --> "+ _SampleSentTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * INSERT  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void INSERT(SampleSentTransVO vo)
	{
		  SampleSentTransDAO.INSERT1(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SampleSentTransBO.INSERT() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * CANCELRECORDS  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void CANCELRECORDS(SampleSentTransVO vo)
	{
		  SampleSentTransDAO.CANCELRECORDS(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SampleSentTransBO.CANCELRECORDS() --> "+ vo.getStrMsgString());
		  }
		  
	}
	/**
	 * GRPNAMECOMBO  Method is Used to Generate Group Name Combo 
	 * @param vo
	 */
	
	public void GRPNAMECOMBO(SampleSentTransVO vo)
	{
		SampleSentTransDAO.getStoreGroupList(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SampleSentTransBO.GRPNAMECOMBO() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ITEMCATEGORYCOMBO  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ITEMCATEGORYCOMBO(SampleSentTransVO vo)
	{
		SampleSentTransDAO.itemCategoryCombo(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SampleSentTransBO.ITEMCATEGORYCOMBO() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void initForViewPage(SampleSentTransVO _SampleSentTransVO){
		
		 
		SampleSentTransDAO.initSampleSent(_SampleSentTransVO);
		if (_SampleSentTransVO.getStrMsgType().equals("1")){
			_SampleSentTransVO.setStrMsgString("SampleSentTransBO.initForViewPage() --> "+ _SampleSentTransVO.getStrMsgString());
		  }
	}
	
	public void setViewPageDtl(SampleSentTransVO _SampleSentTransVO){
		
		SampleSentTransDAO.getViewDtl(_SampleSentTransVO);
		if (_SampleSentTransVO.getStrMsgType().equals("1")){
			_SampleSentTransVO.setStrMsgString("SampleSentTransBO.setViewPageDtl() --> "+ _SampleSentTransVO.getStrMsgString());
		  }
		
	}
	

}
