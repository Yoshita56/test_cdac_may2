package mms.masters.bo;

import mms.masters.dao.CommitteeMemberDetailMstDAO;

import mms.masters.vo.CommitteeMemberDetailMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstBO.
 */
public class CommitteeMemberDetailMstBO {

	/**
	 * for getting option value of category combo (by Anshul).
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getCatValue(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.getCatValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CommitteeMemberDetailMstBO.setCatValue---->"
					+ vo.getStrMsgString());
	}

	/**
	 * for getting option value of req type combo (by Anshul).
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void getReqType(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.getReqType(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getReqType---->"
					+ vo.getStrMsgString());
	}
	
	
	/**
	 * for getting option value of req type combo (by Anshul).
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void getEmpUserIdCombo(CommitteeMemberDetailMstVO vo) 
	{
		CommitteeMemberDetailMstDAO.getEmpUserIdCombo(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getReqType---->"+ vo.getStrMsgString());
	}

	/**
	 * for getting option value of committee type combo (by Anshul).
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void getCommType(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.getCommType(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getCommType---->"
					+ vo.getStrMsgString());
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialModify(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.initialModifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("CommitteeMemberDetailMstBO.initialModify() --> "
							+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.initialAddQuery(vo);
		CommitteeMemberDetailMstDAO.getContituteBy(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getCommettieeDtlHLP(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.getCommettieeDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("CommitteeMemberDetailMstBO.getCommettieeDtlHLP() --> "
							+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getUNITVAL2(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.getUNITVAL2(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getUNITVAL2() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getUNITVAL3(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.getContituteBy(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getUNITVAL3() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getUNITVAL4(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.getEmpDetailForSelectedEmpNo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getUNITVAL4() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getUNITVAL5(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.getCommMemberDtl2(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getUNITVAL5() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getDrugCombo(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.getDrugCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.getDrugCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void AddRecord(CommitteeMemberDetailMstVO vo) {

		CommitteeMemberDetailMstDAO.AddRecordQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.AddRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(CommitteeMemberDetailMstVO vo) {

		//CommitteeMemberDetailMstDAO.insertQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(CommitteeMemberDetailMstVO vo) {
		CommitteeMemberDetailMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(CommitteeMemberDetailMstVO vo) {

		// CommitteeMemberDetailMstDAO.updateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("CommitteeMemberDetailMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
