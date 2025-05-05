package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.BudgetDetailRptDAO;
import mms.reports.vo.BudgetDetailRptVO;

public class BudgetDetailRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(BudgetDetailRptVO voObj)
	{
	
	BudgetDetailRptDAO.getDwhTypeCombo(voObj);
	BudgetDetailRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BudgetDetailRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	
	
	public void getStoreDistrictFlag(BudgetDetailRptVO voObj)
	{
		int nFuncIndex;
		String strFuncName; 
			
		try
		{
			HisDAO  dao = new HisDAO("MMS Transactions","");
		
			strFuncName = "{? = call MMS_MST.get_store_district_flg(?,?,?)}";

//			    System.out.println("voObj.getStrHospitalCode()::"+voObj.getStrHospitalCode());
//			    System.out.println("voObj.getStrStoreId():::"+voObj.getStrStoreId());
//			    System.out.println("Dwh Type:::"+voObj.getStrDrugWarehouseTypeId());
			
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

					voObj.setStrMsgString("BudgetDetailRptBO.getStoreDistrictFlag() --> "	+ e.getMessage());
					voObj.setStrMsgType("1");

				}
	}			
}
