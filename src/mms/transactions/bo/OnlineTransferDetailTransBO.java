package mms.transactions.bo;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.dao.OnlineTransferDetailTransDAO;
import mms.transactions.vo.OnlineTransferDetailTransVO;

public class OnlineTransferDetailTransBO 
{
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(OnlineTransferDetailTransVO _OfflineIssueIndentTransVO)
	{		
//		OnlineTransferDetailTransDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("OnlineTransferDetailTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
	}


	
	public void getStoreDtls(OnlineTransferDetailTransVO voObj){
		
		OnlineTransferDetailTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OnlineTransferDetailTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
      
	public void getOrderNo(OnlineTransferDetailTransVO voObj){
		
		OnlineTransferDetailTransDAO.getOrderNo(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OnlineTransferDetailTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
	
	public void getData(OnlineTransferDetailTransVO voObj)
	{		
		OnlineTransferDetailTransDAO.getData(voObj);
	
			if (voObj.getStrMsgType().equals("1")) 
			{					
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("OnlineTransferDetailTransBO.getStoreDtls()-->"+strErr);
			}
		}
	
	
	
	public void insert(OnlineTransferDetailTransVO voObj)
	{
		int funcIndex = 0 ;
		String strTransferNo ;
		HisDAO dao = null;
		int length = 0;
		try
		{
			dao = new HisDAO("MMS Transactions","OnlineTransferDetailTransBO");
			//dao1 = new HisDAO("MMS Transactions","OnlineTransferDetailTransDAO");
			
			funcIndex = dao.setFunction("{? = call MMS_MST.generate_transferNo(?,?,?,?)}");
	 	    dao.setFuncInValue(funcIndex,2,voObj.getStrHospitalCode());
	 	    dao.setFuncInValue(funcIndex,3,voObj.getStrStoreId());
	 	    dao.setFuncInValue(funcIndex,4,"51");
	 	    dao.setFuncInValue(funcIndex,5,"10"); //Drug
	 		dao.setFuncOutValue(funcIndex,1);
	 		dao.executeFunction(funcIndex);
	 		strTransferNo = dao.getFuncString(funcIndex);
	 		voObj.setStrTransferNo(strTransferNo);
	 		/* END::Retrieving Transfer No through Function */		
	 		
	 		OnlineTransferDetailTransDAO.insertDrugTransferItemDtl(voObj, dao);
	 		if (voObj.getStrMsgType().equals("1")) 
	 		{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("OnlineTransferDetailTransBO.insertDrugTransferItemDtl()-->"+strErr);
			}
	 		
	 		OnlineTransferDetailTransDAO.insertDrugTransferDtl(voObj, dao);
	 		if (voObj.getStrMsgType().equals("1")) 
	 		{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("OnlineTransferDetailTransBO.insertDrugTransferDtl()-->"+strErr);
			}
	 		
	 		synchronized (dao) 
	 		{
	 			// DAO Fire
				dao.fire();	
			}
			
			
	 		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			String strMsgText = e.getMessage();
			throw new HisException("dwh","EmployeeDetailMstBO.insertRecord(employeeDetailMstVO_p,empDependentDetailVO_p)",strMsgText);
		}
		
		
		
				
		}
	
	
	
	public void cancelDrugTransferDtl(OnlineTransferDetailTransVO voObj)
	{
		HisDAO dao = null;
		try
		{
			dao = new HisDAO("MMS Transactions","OnlineTransferDetailTransBO");
			
	 		OnlineTransferDetailTransDAO.cancelDrugTransferDtl(voObj, dao);
	 		
	 		if (voObj.getStrMsgType().equals("1")) 
	 		{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("OnlineTransferDetailTransBO.insertDrugTransferDtl()-->"+strErr);
			}
	 		
	 		
			
	 		
		}
		catch (Exception e) 
		{
			
			String strMsgText = e.getMessage();
			throw new HisException("dwh","EmployeeDetailMstBO.insertRecord(employeeDetailMstVO_p,empDependentDetailVO_p)",strMsgText);
		}
		
		
		
				
		}
	
	
	 public void getTransferDtl(OnlineTransferDetailTransVO _OnlineTransferDetailTransVO){
			
			OnlineTransferDetailTransDAO.getTransferDtl(_OnlineTransferDetailTransVO);
			if (_OnlineTransferDetailTransVO.getStrMsgType().equals("1")){
				_OnlineTransferDetailTransVO.setStrMsgString("OnlineTransferDetailTransBO.getTransferDtl() --> "+ _OnlineTransferDetailTransVO.getStrMsgString());
			  }
			
		}
		
	
	
	
	
}
