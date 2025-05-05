package mms.transactions.bo;

import mms.transactions.dao.AdvanceRequestTransDAO;
import mms.transactions.vo.AdvanceRequestTransVO;

public class AdvanceRequestTransBO {
	
	public void getStoreDtls(AdvanceRequestTransVO voObj){
			
		AdvanceRequestTransDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("AdvanceRequestTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
	public void getItemCatDtls(AdvanceRequestTransVO voObj){
		
		AdvanceRequestTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("AdvanceRequestTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	public void getPONODtls(AdvanceRequestTransVO voObj){
		
		AdvanceRequestTransDAO.getPONODtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("AdvanceRequestTransBO.getPONODtls()-->"+strErr);
				}
				
		}
	
	public void getPODetails(AdvanceRequestTransVO voObj){
			
			AdvanceRequestTransDAO.getPODetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("AdvanceRequestTransBO.getPODetails()-->"+strErr);
					}
					
			}
	
	public void getBankDetails(AdvanceRequestTransVO voObj){
		
		AdvanceRequestTransDAO.getBankDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("AdvanceRequestTransBO.getBankDetails()-->"+strErr);
				}
				
		}
	
	public void getReqDetails(AdvanceRequestTransVO voObj){
		
		AdvanceRequestTransDAO.getReqDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("AdvanceRequestTransBO.getReqDetails()-->"+strErr);
				}
				
		}

	public void insertNew(AdvanceRequestTransVO voObj){
		
			AdvanceRequestTransDAO.insertNew(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("AdvanceRequestTransBO.insertNew()-->"+strErr);
					}
					
			}


	}
