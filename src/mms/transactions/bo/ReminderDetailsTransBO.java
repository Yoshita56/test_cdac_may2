package mms.transactions.bo;

import mms.transactions.dao.ReminderDetailsTransDAO;
import mms.transactions.vo.ReminderDetailsTransVO;

public class ReminderDetailsTransBO {
	
	public void getStoreDtls(ReminderDetailsTransVO voObj){
		
		ReminderDetailsTransDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ReminderDetailsTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	public void getPONo(ReminderDetailsTransVO voObj){
		
		ReminderDetailsTransDAO.getPONo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ReminderDetailsTransBO.getPONo()-->"+strErr);
				}
				
		}
	
	public void getScheduleNo(ReminderDetailsTransVO voObj){
		
		ReminderDetailsTransDAO.getScheduleNo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ReminderDetailsTransBO.getScheduleNo()-->"+strErr);
				}
				
		}
	
	public void getPODetails(ReminderDetailsTransVO voObj){
		
		ReminderDetailsTransDAO.getPODetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ReminderDetailsTransBO.getPODetails()-->"+strErr);
				}
				
		}
	
	public void getPrevReminderDtl(ReminderDetailsTransVO voObj){
			
			ReminderDetailsTransDAO.getPrevReminderDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("ReminderDetailsTransBO.getPrevReminderDtl()-->"+strErr);
					}
					
			}
	
	public void insert(ReminderDetailsTransVO voObj){
		
		ReminderDetailsTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ReminderDetailsTransBO.insert()-->"+strErr);
				}
				
		}

}
