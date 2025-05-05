package mms.masters.bo;

import mms.masters.dao.DrugMstDAO;
import mms.masters.dao.GenericDrugMstDAO;
import mms.masters.vo.DrugMstVO;
import mms.masters.vo.GenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class DrugMstBO {

	
	
	public void getCPACODE(DrugMstVO vo) {
		DrugMstDAO.getCPACode(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getCPACODE---->"
					+ vo.getStrMsgString());
	}
	
	
	public void getItemCodeRequired(DrugMstVO vo) {
		DrugMstDAO.getItemCodeRequired(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getItemCodeRequired---->"
					+ vo.getStrMsgString());
	}
	
	public void getUnitNameComboBasedOnItemId(DrugMstVO vo) {
		DrugMstDAO.getUnitNameComboBasedOnItemId(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getItemCodeRequired---->"
					+ vo.getStrMsgString());
	}
	
	
	/**
	 * Gets the item values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item values
	 */
	public void getItemValues(DrugMstVO vo) {
		DrugMstDAO.getItemValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getItemValues---->"
					+ vo.getStrMsgString());
	}

	
	public void getGenItemValues(DrugMstVO vo) {
		DrugMstDAO.getGenericItemValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getGenItemValues---->"
					+ vo.getStrMsgString());
	}
	
	
	/**
	 * Gets the manufacturer values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the manufacturer values
	 */
	public void getManufacturerValues(DrugMstVO vo) {
		DrugMstDAO.getManufacturerValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getManufacturerValues---->"
					+ vo.getStrMsgString());
	}

	/**
	 * Gets the unit values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit values
	 */
	public void getUnitValues(DrugMstVO vo) {
		DrugMstDAO.getUnitValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getUnitValues---->"
					+ vo.getStrMsgString());
	}

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public void insert(DrugMstVO vo) {

		DrugMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugMstBO.chkDuplicate() --> " + strErr);
		}
		//if (vo.getBExistStatus() == true) {

			DrugMstDAO.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DrugMstBO.insert---->"
						+ vo.getStrMsgString());
			}
		//}
	}

	/**
	 * Modify.
	 * 
	 * @param vo the vo
	 */
	public void modify(DrugMstVO vo)
	{
		
		DrugMstDAO.modify(vo);
		DrugMstDAO.getManufacturerValues(vo);
		DrugMstDAO.getItemValues(vo);
		DrugMstDAO.getUnitValues(vo);
		DrugMstDAO.getIssueType(vo);		
		DrugMstDAO.getModifyUnitNameComboBasedOnItemId(vo);		
		/*
		 * This Line of code is added on 07 Jan 2011.
		 * Added by Aritra.
		 * Reason: Generic Drug code is required for building drug code. 
		 */
		DrugMstDAO.setGenericDrugCode(vo);
		
		/*
		 * This Line of code is added on 08 Feb 2011.
		 * Added by Aritra.
		 * Reason: Approved Type will come from System table. 
		 */
		DrugMstDAO.setApprovedType(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.modify---->" + vo.getStrMsgString());
	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public void update(DrugMstVO vo) {

		DrugMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugMstDAO.update() --> " + strErr);
		}

		if (vo.getBExistStatus() == true) {
			DrugMstDAO.update(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("DrugMstBO.update---->"
						+ vo.getStrMsgString());
		}
	}

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(DrugMstVO vo) {
		DrugMstDAO.view(vo);
		// DrugMstDAO.getItemValues(vo);
		// DrugMstDAO.getUnitValues(vo);
		// DrugMstDAO.getManufacturerValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.view---->" + vo.getStrMsgString());
	}

	public void getIssueType(DrugMstVO vo) {
		DrugMstDAO.getIssueType(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getIssueType---->"+ vo.getStrMsgString());
	}
	

	public void initializeAdd(DrugMstVO vo)
	{
		getDrugClass(vo);
		getItemValues(vo);
		getGenItemValues(vo);
		getManufacturerValues(vo);
		getUnitValues(vo);
		getItemCodeRequired(vo);
		getIssueType(vo);
		getUnitNameComboBasedOnItemId(vo);
		/* Populate Approved Type List in WebRowSet and Set to vo*/
		
		DrugMstDAO.setApprovedType(vo);		
	}
	
	public static void checkDataExists(DrugMstVO vo,String[] chk)
	{
			DrugMstDAO.checkDataExists(vo,chk);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DrugMstBO.checkDataExists() --> " + vo.getStrMsgString());
				
			}
		
	}
	public void getDrugClass(DrugMstVO vo) {
		DrugMstDAO.getDrugClass(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.getDrugClass---->"
					+ vo.getStrMsgString());
	}
	
	public static void checkDrugDuplicacy(DrugMstVO vo)
	{
			DrugMstDAO.checkDrugDuplicacy(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DrugMstBO.checkdrugname() --> " 
						+ vo.getStrMsgString());
			}
	}
}
