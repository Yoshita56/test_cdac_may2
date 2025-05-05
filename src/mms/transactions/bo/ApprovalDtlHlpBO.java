package mms.transactions.bo;

import mms.transactions.dao.ApprovalDtlHlpDAO;
import mms.transactions.vo.ApprovalDtlHlpVO;
/**
 * @author Amit Kumar
 * Date of Creation : 4/6/2009
 * Date of Modification :  /  / 2009
 * Version : 1.0
 * Module  : Store
 * Description : ApprovalDtlHLPBO file used globally to provide access to BO file method
 */
public class ApprovalDtlHlpBO 
{
	
	public void getApprovalDtlLevel1(ApprovalDtlHlpVO voObj)
    {
		ApprovalDtlHlpDAO.getLevelOneDtl(voObj); 
    }
	public void getApprovalDtlLevel2(ApprovalDtlHlpVO voObj)
    {
		ApprovalDtlHlpDAO.getLevelTwoDtl(voObj); 
    }
    
	public void getPreTechApprovalDtl(ApprovalDtlHlpVO voObj)
    {
		ApprovalDtlHlpDAO.getPreTechApprovalDtl(voObj); 
    }
	
	public void getApprovalDtl(ApprovalDtlHlpVO voObj) {
		ApprovalDtlHlpDAO.getApprovalDtl(voObj);
	}
}
