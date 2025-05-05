package mms.transactions.bo;

import mms.transactions.dao.FinancialEndYearTransDAO;
import mms.transactions.vo.FinancialEndYearTransVO;

/**
 * Developer : Tanvi Sappal
 * Date : 22/Jan/2009 version : 1.0
 * Mod Date : 23/Jun/2008
 */

public class FinancialEndYearTransBO {
	
	public void storeName(FinancialEndYearTransVO vo)
	{
		FinancialEndYearTransDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("FinancialEndYearTransBO.storeName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void insert(FinancialEndYearTransVO vo)
	{
		FinancialEndYearTransDAO.insert(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("FinancialEndYearTransBO.insert---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
		

}
