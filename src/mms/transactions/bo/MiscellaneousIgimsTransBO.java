package mms.transactions.bo;

import mms.transactions.dao.MiscellaneousIgimsTransDAO;
import mms.transactions.vo.MiscellaneousIgimsTransVO;

/**
 * Developer : Tanvi Sappal Version : 1.0 ModDate : 29/May/2009 Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

public class MiscellaneousIgimsTransBO {

	/**
	 * This method is used to populate the value of Store Name combo. For this
	 * activity this method called the getInitialValues() method which is define in
	 * MiscellaneousIgimsTransDAO java file.
	 * 
	 * @param vo
	 */
	public void getInitialValues(MiscellaneousIgimsTransVO vo) {

		MiscellaneousIgimsTransDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MiscellaneousConsumptionBO.getInitialValues() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Item Category combo . For this
	 * activity this method called the getItemCategoryCmb() method which is define
	 * in MiscellaneousIgimsTransDAO java file.
	 * 
	 * @param vo
	 */
	public void getItemCategoryCmb(MiscellaneousIgimsTransVO vo) {

		MiscellaneousIgimsTransDAO.getItemCategoryCmb(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MiscellaneousConsumptionBO.getItemCategoryCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to populate the value of Group name combo box and for it
	 * it will call getGroupNameValues()method which is define in
	 * MiscellaneousIgimsTransDAO java file
	 * 
	 * @param vo
	 */
	public void getGroupNameValues(MiscellaneousIgimsTransVO vo) {

		MiscellaneousIgimsTransDAO.getGroupNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MiscellaneousConsumptionBO.getGroupNameValues() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * This method is used to insert the Miscellaneous Consumptions in database for
	 * this activity this method call the insertMiscConsumpRecord() method which is
	 * define in MiscellaneousIgimsTransDAO java file.
	 * 
	 * @param vo
	 */
	public void insertMiscConsumpRecord(MiscellaneousIgimsTransVO vo) {

		MiscellaneousIgimsTransDAO.insertMiscConsumpRecord(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MiscellaneousConsumptionBO.insertMiscConsumpRecord() --> " + vo.getStrMsgString());
		}
	}

	public void getImgHeader(MiscellaneousIgimsTransVO voObj) {
		MiscellaneousIgimsTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			voObj.setStrMsgString("MiscellaneousConsumptionBO.getImgHeader() --> " + voObj.getStrMsgString());
		}
	}

	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(MiscellaneousIgimsTransVO vo) {

		MiscellaneousIgimsTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MiscellaneousConsumptionBO.getIssueDtlsInitDtls() --> " + strErr);
		}
	}
	public void initForViewPage(MiscellaneousIgimsTransVO vo)
	{

		MiscellaneousIgimsTransDAO.GetData(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("MiscellaneousConsumptionBO.initForViewPage() --> "+ vo.getStrMsgString());
		  }
	}
	
	public void ITEMCATEGORYCOMBO(MiscellaneousIgimsTransVO vo)
	{
		
		MiscellaneousIgimsTransDAO.itemCategoryCombo(vo);
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("MiscellaneousConsumptionBO.ITEMCATEGORYCOMBO() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(MiscellaneousIgimsTransVO voObj){
		
		MiscellaneousIgimsTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("MiscellaneousConsumptionTransBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
		
	}
	
}
