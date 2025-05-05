package mms.transactions.bo;

import mms.global.dao.MmsDAO;
import mms.global.vo.MmsVO;
import mms.transactions.dao.ThirdPartyIssueDeskDAO;
import mms.transactions.vo.ThirdPartyIssueDeskVO;

public class ThirdPartyIssueDeskBO {
	
	
public void getItemDetails(ThirdPartyIssueDeskVO voObj)
{
		
	//System.out.println("InBO");
		ThirdPartyIssueDeskDAO.getItemDetails(voObj);
		//System.out.println("OutBO");
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueDeskBO.getItemDetails()-->"+strErr);
		}
		
	}

/**
 * Gets the issue dtls init dtls.
 * 
 * @param vo the vo
 * 
 * @return the issue dtls init dtls
 */
public void getIssueDtlsInitDtls(ThirdPartyIssueDeskVO vo) {
	ThirdPartyIssueDeskDAO.getIssueDtlsList(vo);
	if (vo.getStrMsgType().equals("1")) {
		String strErr = vo.getStrMsgString();
		vo.setStrMsgString("ThirdPartyIssueDeskBO.getStockItemDtlsInitDtls() --> "+ strErr);
	}
}




	
}
