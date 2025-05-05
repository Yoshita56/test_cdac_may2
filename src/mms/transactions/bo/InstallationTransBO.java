package mms.transactions.bo;

import mms.transactions.dao.InstallationTransDAO;
import mms.transactions.vo.InstallationTransVO;

public class InstallationTransBO {
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(InstallationTransVO vo)
	{
		InstallationTransDAO.getStoreCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Category Name associate with Store Name:
	 * 
	 * @param vo
	 */
	public void getItemCatCmb(InstallationTransVO vo)
	{
		InstallationTransDAO.getItemCatCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getItemCatCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupCmb(InstallationTransVO vo)
	{
		InstallationTransDAO.getGroupCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getGroupCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of SubGroup Name associate with Group Name:
	 * 
	 * @param vo
	 */
	public void getSubGroupCmb(InstallationTransVO vo)
	{
		InstallationTransDAO.getSubGroupCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getSubGroupCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getGenItemCmb(InstallationTransVO vo)
	{
		InstallationTransDAO.getGenItemCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getGenItemCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Name associate with Store, Item Category, Group Name, SubGrp & GenItem Name:
	 * 
	 * @param vo
	 */
	public void getItemCmb(InstallationTransVO vo)
	{
		InstallationTransDAO.getItemCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getItemCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Batch No associate with Item Name:
	 * 
	 * @param vo
	 */
	public void getBatchSerialNo(InstallationTransVO vo)
	{
		if(vo.getStrItemCatNo().equals("10")){
			
			InstallationTransDAO.getBatchSlNo(vo);
		     
		}else{
			
			if(vo.getStrIsBatchNoReq().equals("1"))
				InstallationTransDAO.getBatchSlNo(vo);
			
			if(vo.getStrIsSerialNoReq().equals("1"))
				InstallationTransDAO.getItemSlNo(vo);
		}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.getBatchSerialNo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	
	public void insert(InstallationTransVO vo)
	{
		
		InstallationTransDAO.insert(vo);
		if(vo.getStrMsgType().equals("1"))
		{
			
			String strErr = vo.getStrMsgString();
			
				vo.setStrMsgString("InstallationTransBO.insert---->"+strErr);
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Exist Data:
	 * 
	 * @param vo
	 */
	public void goView(InstallationTransVO vo)
	{
		InstallationTransDAO.goView(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("InstallationTransBO.goView---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
