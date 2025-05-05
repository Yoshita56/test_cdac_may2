package mms.transactions.bo;

import mms.transactions.dao.PatientReturnTransDAO;
import mms.transactions.dao.PatientReturnTransDAO;
import mms.transactions.vo.PatientReturnTransVO;
import mms.transactions.vo.PatientReturnTransVO;

public class PatientReturnTransBO {	

public void getStoreDtls(PatientReturnTransVO voObj)
{
	PatientReturnTransDAO.getStoreList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("testBO.getStoreDtls()-->"+strErr);
	}
}
public void getItemCategoryList(PatientReturnTransVO voObj)
{
	PatientReturnTransDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("testBO.getItemCategoryList()-->"+strErr);
	}
}

	/*public void getIssueNoCombo(PatientReturnTransVO vo)
	{
		PatientReturnTransDAO.getIssueNoCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("testBO.getIssueCombo() --> "
					+ strErr);
		}
		
	}*/

public void getRecommendName(PatientReturnTransVO vo)
{
	PatientReturnTransDAO.getRecommendName(vo);
	if(vo.getStrMsgType().equals("1"))
	{
			vo.setStrMsgString("testBO.getRecommendName---->"+vo.getStrMsgString());
			vo.setStrMsgType("1");
	}
}

public void getpatientDemographicDetail(PatientReturnTransVO vo) 
{
	PatientReturnTransDAO.getpatientDemographicDetail(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("testBO.getpatientDemographicDetail() --> "+ vo.getStrMsgString());
	}
	
}

public void getItem_ALL_LIST(PatientReturnTransVO vo) {
	PatientReturnTransDAO.getItem_ALL_LIST(vo);

	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("testBO.getItem_ALL_LIST() --> "
				+ vo.getStrMsgString());
	}

}


public void insert_LIST(PatientReturnTransVO vo) {
	
	PatientReturnTransDAO.insert_LIST(vo);

	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("testBO.insert_LIST() --> "
				+ vo.getStrMsgString());
	}
}

public void issueDtlsInitNEW_Voucher(PatientReturnTransVO vo) 
{
	PatientReturnTransDAO.issueDtlsInitNEW_Voucher(vo);
	if (vo.getStrMsgType().equals("1")) {
		String strErr = vo.getStrMsgString();
		vo.setStrMsgString("testBO.getStockItemDtlsInitDtls() --> "+ strErr);
	}
}
public void initForViewPage(PatientReturnTransVO voObj){
	PatientReturnTransDAO.GetData(voObj);
	if (voObj.getStrMsgType().equals("1")){
		voObj.setStrMsgString("testBO.initForViewPage() --> "+ voObj.getStrMsgString());
	}
}
public void setViewPageDtl(PatientReturnTransVO voObj){
	
	PatientReturnTransDAO.getReturnDetail(voObj);
	if (voObj.getStrMsgType().equals("1")){
		voObj.setStrMsgString("OfflineIssueIndentTransBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
	  }
	
}


	

	
	
}