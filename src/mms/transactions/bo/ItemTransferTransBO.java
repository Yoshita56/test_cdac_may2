			
			/******************************************************************************************
			 *                                Process Name : Item Transfer                            *
			 ******************************************************************************************
			 * File Name       : ItemTransferTransBO.java                                             *
			 * Module Name     : MMS                                                                  *
			 * Developer       : Deepak Tiwari                                                        * 
			 * Version         : 1.0                                                                  * 
			 * Assigned Date   : 1-May-2009                                                           *                                               
			 * Completion Date : 3-May-2009                                                           *
			 * Assigned By     : Ajay Kr. Gupta                                                       *
			 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
			 * Hand over date  : 30-May-2009                                                          *
			 ******************************************************************************************
			 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
			 ******************************************************************************************/

package mms.transactions.bo;
import mms.transactions.dao.BreakageItemDtlTransDAO;
import mms.transactions.dao.ItemTransferTransDAO;
import mms.transactions.vo.BreakageItemDtlTransVO;
import mms.transactions.vo.ItemTransferTransVO;

public class ItemTransferTransBO {
	
	/**
	 * <p>Method::GetData is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
	public void GetData(ItemTransferTransVO vo) {
		ItemTransferTransDAO.GetData(vo);
		//ItemTransferTransDAO.setRecievedByCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTransferTransBO.GetData() --> "
					+ vo.getStrMsgString());
		}

	}
	

	/**
	 * <p>Method::INSERT is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
	public void INSERT(ItemTransferTransVO vo) {
		ItemTransferTransDAO.INSERT(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTransferTransBO.INSERT() --> "
					+ vo.getStrMsgString());
		}

	}
	

	/**
	 * <p>Method::GRPNAMECOMBO is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
	public void GRPNAMECOMBO(ItemTransferTransVO vo) {
		ItemTransferTransDAO.getStoreGroupList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTransferTransBO.GRPNAMECOMBO() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * <p>Method::RECEVBYCMB is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
	public void RECEVBYCMB(ItemTransferTransVO vo) {
		ItemTransferTransDAO.setRecievedByCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTransferTransBO.RECEVBYCMB() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * <p>Method::ITEMCATCOMBO is Used to invoke Data Access Object.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <ItemTransferTransVO>vo
	 */
	public void ITEMCATCOMBO(ItemTransferTransVO vo) {
		ItemTransferTransDAO.itemCategory(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTransferTransBO.ITEMCATCOMBO() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void initForViewPage(ItemTransferTransVO _ItemTransferTransVO){
		
		 
		ItemTransferTransDAO.GetData(_ItemTransferTransVO);
		if (_ItemTransferTransVO.getStrMsgType().equals("1")){
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransBO.initForViewPage() --> "+ _ItemTransferTransVO.getStrMsgString());
		  }
	}
	
	public void setViewPageDtl(ItemTransferTransVO _ItemTransferTransVO){
		
		ItemTransferTransDAO.getViewDtl(_ItemTransferTransVO);
		if (_ItemTransferTransVO.getStrMsgType().equals("1")){
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransBO.setViewPageDtl() --> "+ _ItemTransferTransVO.getStrMsgString());
		  }
		
	}
	
    public void getTransferDtl(ItemTransferTransVO _ItemTransferTransVO){
		
		ItemTransferTransDAO.getTransferDtl(_ItemTransferTransVO);
		if (_ItemTransferTransVO.getStrMsgType().equals("1")){
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransBO.getTransferDtl() --> "+ _ItemTransferTransVO.getStrMsgString());
		  }
		
	}
	
}
