/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.QualityCheckControlTransDAO;
import mms.transactions.dao.SampleSentTransDAO;
import mms.transactions.vo.QualityCheckControlTransVO;
import mms.transactions.vo.SampleSentTransVO;

/**
 * Developer : Tanvi Sappal
 * Date : 04/Jun/2009
 * Version : 1.0
 *
 */
public class QualityCheckControlTransBO {
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.storeName(vo);
		QualityCheckControlTransDAO.getLabNameCmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getDrugBatchCmb(QualityCheckControlTransVO vo)
	{
		
		QualityCheckControlTransDAO.getDrugBatchCmb(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getDrugBatchCmb()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Category Name associate with Store Name:
	 * 
	 * @param vo
	 */
	public void getItemCatNo(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.itemCategoryNo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getItemCatNo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getDrugNameCmb(QualityCheckControlTransVO vo)
	{
		
		QualityCheckControlTransDAO.getDrugNameCmb(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getDrugNameCmb()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupName(QualityCheckControlTransVO vo)
	{
		
		QualityCheckControlTransDAO.groupName(vo);
		QualityCheckControlTransDAO.setCommitteeTypeDtl(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getDrugList(QualityCheckControlTransVO vo)
	{
		
		
		QualityCheckControlTransDAO.getDrugNameCmb(vo);
	
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getDrugList()->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of SubGroup Name associate with Group Name:
	 * 
	 * @param vo
	 */
	public void getSubGroupName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.subGroupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getSubGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getGenItemName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.genItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getGenItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Name associate with Store, Item Category, Group Name, SubGrp & GenItem Name:
	 * 
	 * @param vo
	 */
	public void getItemName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.itemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Batch No associate with Item Name:
	 * 
	 * @param vo
	 */
	public void getBatcNo(QualityCheckControlTransVO vo)
	{
		if(vo.getStrItemCategoryNo().equals("10")){
			
			QualityCheckControlTransDAO.batchNo(vo);
		     
		}else{
			
			if(vo.getStrIsBatchNo().equals("1"))
				QualityCheckControlTransDAO.batchNo(vo);
			
			if(vo.getStrIsSlNo().equals("1"))
				QualityCheckControlTransDAO.serialNo(vo);
		}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getBatcNo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * To get values of Committee Name:
	 * 
	 * @param vo
	 */
	public void getCommitteeName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.setCommitteeTypeDtl(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getCommitteeName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	

	/**
	 * To get Member Details.
	 * 
	 * @param vo
	 */
	public void getMemberDetails(QualityCheckControlTransVO vo)
		{
		QualityCheckControlTransDAO.getMemberDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
				String strErr = vo.getStrMsgString();
				vo.setStrMsgString("SampleRegisterTransBO.getMemberDetails() --> "
						+ strErr);
				}
		}
			
	/**
	 * To get values of Unit Name associate with Item Name:
	 * 
	 * @param vo
	 */
	public void getUnitName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.unitName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getUnitName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	
	public void insert(QualityCheckControlTransVO vo)
	{
		
		QualityCheckControlTransDAO.insertWithNewProcedure(vo);
		if(vo.getStrMsgType().equals("1"))
		{
			
			String strErr = vo.getStrMsgString();
			
				vo.setStrMsgString("QualityCheckControlTransBO.insert---->"+strErr);
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Category:
	 * 
	 * @param vo
	 */
	public void getStoreName(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.getStoreName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getStoreName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}


	/**
	 * To get values of Item Category:
	 * 
	 * @param vo
	 */
	public void getItemCategory(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.itemCategory(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.getItemCategory---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Exist Data:
	 * 
	 * @param vo
	 */
	public void goView(QualityCheckControlTransVO vo)
	{
		QualityCheckControlTransDAO.goView(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("QualityCheckControlTransBO.goView---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}


}
