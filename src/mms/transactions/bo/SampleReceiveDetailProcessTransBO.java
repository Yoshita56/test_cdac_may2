package mms.transactions.bo;

import mms.transactions.dao.SampleReceiveDetailProcessTransDAO;
import mms.transactions.vo.SampleReceiveDetailProcessTransVO;

public class SampleReceiveDetailProcessTransBO {
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDrugWareHouseNameCombo(SampleReceiveDetailProcessTransVO voObj)
	{
		
		SampleReceiveDetailProcessTransDAO.getDrugWareHouseNameCombo(voObj);
		SampleReceiveDetailProcessTransDAO.itemCategoryNo(voObj);
		SampleReceiveDetailProcessTransDAO.getSampleSentDWH(voObj);
		SampleReceiveDetailProcessTransDAO.getSampleSentDWHItemName(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getDrugWareHouseNameCombo()-itemCategoryNo()-getSampleSentDWH(voObj)-getSampleSentDWHItemName(voObj)->"+strErr);
				}
				
		}

	
	/**
	 * To get values of Item Category Name associate with Drug Warehouse Name:
	 * 
	 * @param vo
	 */
	public void getItemCatNo(SampleReceiveDetailProcessTransVO voObj)
	{
		SampleReceiveDetailProcessTransDAO.itemCategoryNo(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getItemCatNo---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Category Name associate with Drug Warehouse Name:
	 * 
	 * @param vo
	 */
	public void getSampleSentDWH(SampleReceiveDetailProcessTransVO voObj)
	{
		SampleReceiveDetailProcessTransDAO.getSampleSentDWH(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getSampleSentDWH()---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
	}

	
	/**
	 * To get values of Item Category Name associate with Drug Warehouse Name:
	 * 
	 * @param vo
	 */
	public void getSampleSentDWHItemName(SampleReceiveDetailProcessTransVO voObj)
	{
		SampleReceiveDetailProcessTransDAO.getSampleSentDWHItemName(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getSampleSentDWHItemName()---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Category Name associate with Drug Warehouse Name:
	 * 
	 * @param vo
	 */
	public void getItemBatchList(SampleReceiveDetailProcessTransVO voObj)
	{
		SampleReceiveDetailProcessTransDAO.getItemBatchList(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getItemBatchList()---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
	}


	public void getIssueDrugDtls(SampleReceiveDetailProcessTransVO voObj) {
		// TODO Auto-generated method stub
		
		SampleReceiveDetailProcessTransDAO.getIssueDrugDtls(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getIssueDrugDtls---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
	}


	public void saveSampleReceiveDtl(SampleReceiveDetailProcessTransVO voObj) {
		
		SampleReceiveDetailProcessTransDAO.saveRecord(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.saveSampleReceiveDtl---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
		
	}


	public void getViewSampleReceiveHlp(SampleReceiveDetailProcessTransVO voObj) {
		
		SampleReceiveDetailProcessTransDAO.getViewSampleReceiveHlp(voObj);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getViewSampleReceiveHlp---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
		
	}


	public void getDrugCurrStockDtl(SampleReceiveDetailProcessTransVO voObj, int i) {
		
		SampleReceiveDetailProcessTransDAO.getDrugCurrStockDtl(voObj,i);
		if(voObj.getStrMsgType().equals("1"))
		{
			voObj.setStrMsgString("SampleReceiveDetailProcessTransBO.getDrugCurrStockDtl---->"+voObj.getStrMsgString());
			voObj.setStrMsgType("1");
		}
		
	}
}
