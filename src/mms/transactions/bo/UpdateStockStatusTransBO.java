package mms.transactions.bo;

import mms.transactions.dao.UpdateStockStatusTransDAO;
import mms.transactions.vo.UpdateStockStatusTransVO;

public class UpdateStockStatusTransBO {
	
	/**
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(UpdateStockStatusTransVO voObj){
		
		UpdateStockStatusTransDAO.getDrugWareHouseNameCombo(voObj);
		UpdateStockStatusTransDAO.getItemCatDtls(voObj);
		UpdateStockStatusTransDAO.getGroupNameCombo(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
				}
				
		}
	
	
	
	/**
	 * 
	 * @param voObj
	 */
	public void getInitializedValues1(UpdateStockStatusTransVO voObj){
		
		UpdateStockStatusTransDAO.getDrugWareHouseNameCombo(voObj);
		UpdateStockStatusTransDAO.getItemCatDtls(voObj);
			
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
				}
				
		}
	/**
	 * 
	 * @param voObj
	 */
	public void getItemCatDtls(UpdateStockStatusTransVO voObj){
		
		UpdateStockStatusTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
				}
				
		}
	
	
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getDrugCurrentStockValues(UpdateStockStatusTransVO voObj)
	{
		UpdateStockStatusTransDAO.getItemBrandName(voObj);			
		UpdateStockStatusTransDAO.getStockStatusList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
		}
	}
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getStockStatusList(UpdateStockStatusTransVO voObj)
	{
		
		
		
		UpdateStockStatusTransDAO.getStockStatusList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
		}
	}
	

	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getUnitNameCombo(UpdateStockStatusTransVO voObj)
	{
		
		
		
		UpdateStockStatusTransDAO.getUnitNameCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
		}
	}
	
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getApprovedByCombo(UpdateStockStatusTransVO voObj)
	{
		
		
		
		UpdateStockStatusTransDAO.getApprovedByCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
		}
	}
	
	/**
	 * To Save Record
	 * 
	 * @param voObj
	 */
	public void insertRecord(UpdateStockStatusTransVO voObj)
	{
		
		
		
		UpdateStockStatusTransDAO.insertRecord(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.insertRecord()-->"+strErr);
		}
	}
	
	
	
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getViewUpdatedStockStatusDetails(UpdateStockStatusTransVO voObj)
	{
		
		UpdateStockStatusTransDAO.getViewUpdatedStockStatusDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
		}
	}
	
}
