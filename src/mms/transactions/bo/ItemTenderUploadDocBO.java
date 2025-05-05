package mms.transactions.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.dao.ItemTenderUploadDocDAO;
import mms.transactions.vo.ItemTenderUploadDocVO;

public class ItemTenderUploadDocBO {
	
public void getInitializedValues(ItemTenderUploadDocVO voObj){
	ItemTenderUploadDocDAO.getGenericItemList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
			}
	}

public void getwarranty_sl_no(ItemTenderUploadDocVO VO) {
	String strPrevMantDtl=null;
		HisDAO hisDAO = new HisDAO("BMED", "BmedGlobalBO");		
		try {
			ItemTenderUploadDocDAO.getwarranty_sl_no(VO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (VO.getStrMsgType().equals("1")){
			VO.setStrMsgString("BmedTransBO.setViewPageDtl() --> "+ VO.getStrMsgString());
		  }
}

public void getITEMNameValues(ItemTenderUploadDocVO voObj) {			
	ItemTenderUploadDocDAO.getITEMNameValues(voObj);
	if (voObj.getStrMsgType().equals("1")) 
	{
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("UpdateStockStatusTransBO.getUnitComboList()-->"+strErr);
	}
}
	

public void insertRecord(ItemTenderUploadDocVO voObj) {
//	ItemTenderUploadDocDAO.insertRecord(voObj);
	if (voObj.getStrMsgType().equals("1")) 
	{
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("UpdateStockStatusTransBO.insertRecord()-->"+strErr);
	}
}
public void getFtpProperties(ItemTenderUploadDocVO vo)  {

	ItemTenderUploadDocDAO.getFtpProperties(vo);

	
	 if (vo.getStrMsgType().equals("1")) {
	 vo.setStrMsgString("OTAdviceTransBO.getPatientVisitDtls() --> " +
	  vo.getStrMsgString()); }
	 
}

public static boolean saveItemWarrantyDetails(ItemTenderUploadDocVO ItemTenderUploadDocVO) throws Exception {		
	System.out.println("------------------BmedTransBO.saveItemWarrantyDetails---------------------");
	boolean retVal = false;
	HisDAO hisDAO_p = null;
	try {	
		hisDAO_p = new HisDAO("BMED", "BmedGlobalBO");
		ItemTenderUploadDocDAO.insert(ItemTenderUploadDocVO, hisDAO_p);
		
		hisDAO_p.fire(); 
		retVal = true;
		ItemTenderUploadDocVO.setStrMsgType("0");

	} 
	catch (Exception ex) {			 
		ex.printStackTrace();
		ItemTenderUploadDocVO.setStrMsgType("1");
		throw new Exception("BmedGlobalBO.saveItemMaintenanceContactDetails(String,String)-->"+ex.getMessage());
	}
	finally {

		if (hisDAO_p != null) {

			hisDAO_p.free();

			hisDAO_p = null;

		}

	}
	return retVal;

}

}
