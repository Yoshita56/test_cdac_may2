package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.BudgetComparisonDetailRptDAO;
import mms.reports.vo.BudgetComparisonDetailRptVO;
import mms.reports.vo.BudgetComparisonDetailRptVO;

public class BudgetComparisonDetailRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getDwhTypeCombo(BudgetComparisonDetailRptVO voObj)
	{
	
	BudgetComparisonDetailRptDAO.getDwhTypeCombo(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("BudgetComparisonDetailRptBO.getDwhTypeCombo()-->"+strErr);
			}
			
	}
	
	
	/**
	 * To get Store Combo based on the dwh_type_id from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public void getStoreList(BudgetComparisonDetailRptVO voObj)
		{
		if(!voObj.getStrDrugWarehouseTypeId().equals("0"))
		BudgetComparisonDetailRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BudgetComparisonDetailRptBO.getStoreList()-->"+strErr);
				}
				
		}
	
	
	public void getStoreDistrictFlag(BudgetComparisonDetailRptVO voObj)
	{
		int nFuncIndex;
		String strFuncName; 
			
		try
		{
			HisDAO  dao = new HisDAO("MMS Transactions","");
		
			strFuncName = "{? = call MMS_MST.get_store_district_flg(?,?,?)}";

				 nFuncIndex = dao.setFunction(strFuncName);
				dao.setFuncInValue(nFuncIndex, 2, voObj.getStrHospitalCode());
				dao.setFuncInValue(nFuncIndex, 3, voObj.getStrStoreId());
				dao.setFuncInValue(nFuncIndex, 4, voObj.getStrDrugWarehouseTypeId());
				dao.setFuncOutValue(nFuncIndex, 1);
				dao.executeFunction(nFuncIndex);

				String strDistrictFlg = dao.getFuncString(nFuncIndex);
				
				voObj.setStrDistrictFlg(strDistrictFlg);

	
		}		
				
				catch (Exception e) {

					voObj.setStrMsgString("BudgetComparisonDetailRptBO.getStoreDistrictFlag() --> "	+ e.getMessage());
					voObj.setStrMsgType("1");

				}
	}			
}
