/**
 * Developer : Deepak
 * Version : 1.0
 * Date : 31/Jan/2009
 */
package mms.masters.bo;

import mms.masters.dao.AuthorityHierDtlDAO;
import mms.masters.vo.AuthorityHierDtlVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlBO.
 */
public class AuthorityHierDtlBO {
	
	/**
	 * BO Method is Used To Get the DAO method to intreact with Database.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	/**
	 * GetData Method is Used to Populate the Data for
	 * 
	 * @param vo
	 */
	public void GetData(AuthorityHierDtlVO vo) {
		AuthorityHierDtlDAO.GetData(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.GetData() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * ITEMCATCMB.
	 * 
	 * @param vo the vo
	 */
	public void ITEMCATCMB(AuthorityHierDtlVO vo) {
		AuthorityHierDtlDAO.itemCategory(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.ITEMCATCMB() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * REQTYPCMB.
	 * 
	 * @param vo the vo
	 */
	public void REQTYPCMB(AuthorityHierDtlVO vo) {
		AuthorityHierDtlDAO.reqType(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.REQTYPCMB() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * GetData Method is Used to Populate the Data for Hierarchy Divs.
	 * 
	 * @param vo the vo
	 */
	public void heirdetails(AuthorityHierDtlVO vo) {
		vo.setStrTemp("1^" + vo.getStrFrmStoreId());// appTyp^storeId
		AuthorityHierDtlDAO.heirdetails(vo);
		vo.setStrHierDtlStoreWS(vo.getStrHierDtlWS());

		vo.setStrTemp("2^0");
		AuthorityHierDtlDAO.heirdetails(vo);
		vo.setStrHierDtlAdminWS(vo.getStrHierDtlWS());

		// vo.setStrTemp(vo.getStrFrmStoreId());
		AuthorityHierDtlDAO.prevHeirdetails(vo);
		vo.setStrPrevHierDtlWS(vo.getStrHierDtlWS());
		
		
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.heirdetails() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * INSERT Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo the vo
	 */
	public void INSERT(AuthorityHierDtlVO vo) {
		AuthorityHierDtlDAO.maxAuthNo(vo);

		AuthorityHierDtlDAO.INSERT_AUTH_DTL(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.INSERT() --> "
					+ vo.getStrMsgString());
		}

	}

	public void getRemarks(AuthorityHierDtlVO vo) {
		AuthorityHierDtlDAO.getRemarks(vo);
		/* Approval Flag */
		AuthorityHierDtlDAO.setApprovalFlag(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AuthorityHierDtlBO.getRemarks() --> "
					+ vo.getStrMsgString());
		}
		
	}

}
