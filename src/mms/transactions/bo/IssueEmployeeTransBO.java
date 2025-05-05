package mms.transactions.bo;

import mms.transactions.dao.IssueEmployeeTransDAO;
import mms.transactions.vo.IssueEmployeeTransVO;

public class IssueEmployeeTransBO {
	
	public void getStoreDtls(IssueEmployeeTransVO voObj){
			
			IssueEmployeeTransDAO.getStoreList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueEmployeeTransBO.getStoreDtls()-->"+strErr);
					}
					
			}
	
	public void getItemCatDtls(IssueEmployeeTransVO voObj){
		
		IssueEmployeeTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueEmployeeTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
	public void getPrescribedBy(IssueEmployeeTransVO voObj){
		
		IssueEmployeeTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueEmployeeTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getStoreGroupDtls(IssueEmployeeTransVO voObj){
			
			IssueEmployeeTransDAO.getStoreGroupList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueEmployeeTransBO.getStoreGroupDtls()-->"+strErr);
					}
					
			}
	
	public void getIssueDetail(IssueEmployeeTransVO voObj){
			
			IssueEmployeeTransDAO.getIssueDetail(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueEmployeeTransBO.getIssueDetail()-->"+strErr);
					}
					
			}
			public void getEmployeeDtl(IssueEmployeeTransVO voObj){
				
				IssueEmployeeTransDAO.getEmployeeDtl(voObj);
				if (voObj.getStrMsgType().equals("1")) {
							
							String strErr = voObj.getStrMsgString();
								
							voObj.setStrMsgString("IssueEmployeeTransBO.getEmployeeDtl()-->"+strErr);
						}
						
				}
			
public void insert(IssueEmployeeTransVO voObj){
				
				IssueEmployeeTransDAO.insert(voObj);
				if (voObj.getStrMsgType().equals("1")) {
							
							String strErr = voObj.getStrMsgString();
								
							voObj.setStrMsgString("IssueEmployeeTransBO.insert()-->"+strErr);
						}
						
				}
}
