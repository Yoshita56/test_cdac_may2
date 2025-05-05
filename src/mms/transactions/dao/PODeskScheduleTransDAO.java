/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.PODeskScheduleTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransDAO {
	public static void getPODetails(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; //6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskScheduleTransDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskScheduleTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskScheduleTransVO
					.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeid", _poDeskScheduleTransVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
			{
				if (wsResult.next()) 
				{
					_poDeskScheduleTransVO.setStrPODate(wsResult.getString(1));
					_poDeskScheduleTransVO.setStrSupplierName(wsResult.getString(2));
					_poDeskScheduleTransVO.setStrPOType(wsResult.getString(3));
					_poDeskScheduleTransVO.setStrSupplierId(wsResult.getString(7));
					_poDeskScheduleTransVO.setStrPOTypeId(wsResult.getString(8));
					_poDeskScheduleTransVO.setStrItemCat(wsResult.getString(11));
					_poDeskScheduleTransVO.setStrItemCatName(wsResult.getString(12));
					_poDeskScheduleTransVO.setStrPODeliveryDate(wsResult.getString(5));
				}
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransDAO.getPODetails() --> "
							+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getForeignPODetails(
			PODeskScheduleTransVO _poDeskScheduleTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}";//6
		HisDAO dao = null;
		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskScheduleTransDAO.getForeignPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskScheduleTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "storeId", _poDeskScheduleTransVO
					.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "pono", _poDeskScheduleTransVO
					.getStrPONo(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				if (wsResult.next()) {
					_poDeskScheduleTransVO.setStrAgentId(wsResult.getString(1));
					_poDeskScheduleTransVO.setStrCAAgent(wsResult.getString(2));
					_poDeskScheduleTransVO.setStrCurrencyCode(wsResult
							.getString(3));
					_poDeskScheduleTransVO.setStrAgentName(wsResult
							.getString(4));
					_poDeskScheduleTransVO.setStrCAAgentName(wsResult
							.getString(5));
					_poDeskScheduleTransVO
							.setStrCurrency(wsResult.getString(6));
				}
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransDAO.getForeignPODetails() --> "
							+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getPOItemDetails(
			PODeskScheduleTransVO _poDeskScheduleTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,? ,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskScheduleTransDAO.getPOItemDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskScheduleTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskScheduleTransVO
					.getStrPONo(),4);
			dao.setProcInValue(nProcIndex, "storeid", _poDeskScheduleTransVO
					.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "item_id", _poDeskScheduleTransVO.getStrItemId(),5);
			dao.setProcInValue(nProcIndex, "item_brand_id", _poDeskScheduleTransVO.getStrItemBrandIds(),6);
			dao.setProcInValue(nProcIndex, "schedule_no", _poDeskScheduleTransVO.getStrScheduledQtyUnitValues(),7);
			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_poDeskScheduleTransVO.setWbPOItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransDAO.getPOItemDetails() --> "
							+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void setDeliveryLocationValues(PODeskScheduleTransVO _poDeskScheduleTransVO)
	{

		String strproc_name = "{call pkg_mms_view.proc_hstt_store_mst(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS","transactions.PODeskGenerateTransDAO.setDeliveryLocationValues()");
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.setDeliveryLocationValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskScheduleTransVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "seatid", _poDeskScheduleTransVO.getStrSeatId(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "storeid", "0",4);
			dao.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */

			
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskScheduleTransVO.setStrDeliveryLocationValues(util.getOptionValue(wsResult, _poDeskScheduleTransVO.getStrStoreId(), "", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setDeliveryLocationValues() --> "
							+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	

	public static void setStrScheduledQtyUnitValues(
			PODeskScheduleTransVO _poDeskScheduleTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}"; //5+1=6
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskScheduleTransDAO.setRateUnitValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskScheduleTransDAO.setRateUnitValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",4);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskScheduleTransVO
					.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id", _poDeskScheduleTransVO
					.getStrInventoryUnitId(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			
			dao.setProcInValue(nProcIndex, "module_id", "",3); // Default set for module_id
			
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskScheduleTransVO.setStrScheduledQtyUnitValues(util
						.getOptionValue(wsResult, _poDeskScheduleTransVO.getStrMatchUnitCmb(), "", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransDAO.setStrScheduledQtyUnitValues() --> "
							+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public synchronized static void insert(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		String strProcName = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}"; //7+6+1=14
		String strProcName1 = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";//20+16+2=38
		String strProcName2 = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}"; //5+8+1=14
	
		
		HisDAO dao = null;
		boolean flag = false;

		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		
		double total = 0,rate=0,rateUnit=0,orderQty=0,orderQtyUnit=0;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strItemFinalTotalCost="0.00";
		try 
		{
			dao = new HisDAO("MMS","transactions.PODeskScheduleTransDAO.insert()");
			
			for (int j = 0; j < _poDeskScheduleTransVO.getStrCheckBox().length; j++) 
			{
				           rate  = Double.parseDouble(_poDeskScheduleTransVO.getStrDRate()[j]);
				       rateUnit  = Double.parseDouble(_poDeskScheduleTransVO.getStrRateUnitWithBaseValue()[j].replace("^", "#").split("#")[0]);
				       orderQty  = Double.parseDouble(_poDeskScheduleTransVO.getStrDScheduledQty()[j]);
				   orderQtyUnit  = Double.parseDouble(_poDeskScheduleTransVO.getStrDScheduledQtyUnit()[j].replace("^", "#").split("#")[0]);
				   ////System.out.println("rate==>"+rate+"::rateUnit::"+rateUnit+"::orderQty::"+orderQty+":::orderQtyUnit::"+orderQtyUnit);
				   
				    NumberFormat formatter = new DecimalFormat("############.##");  
				    
					
//				    (NVL(HSTNUM_RATE,0)/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*
//                    NVL( (HSTNUM_ORDER_QTY) , 0)*
//                    Mms_Mst.getUnitBaseValue(HSTNUM_ORDER_QTY_UNITID,GNUM_HOSPITAL_CODE)
                    
                    strItemTotCost = formatter.format(new BigDecimal((rate)*(orderQty)));  
					
				    cltamt  = Double.parseDouble(strItemTotCost);
					
				    totalCost = totalCost + cltamt;
				    
				   // //System.out.println("Total Cost==>"+totalCost);
				    strItemFinalTotalCost= String.valueOf(totalCost);
				   
			}
			
			
			nProc2Index = dao.setProcedure(strProcName2);
			dao.setProcInValue(nProc2Index, "modeval","2",1);
			dao.setProcInValue(nProc2Index, "store_id",_poDeskScheduleTransVO.getStrStoreId(),2);			
			dao.setProcInValue(nProc2Index, "pono",_poDeskScheduleTransVO.getStrPONo(),3);
			dao.setProcInValue(nProc2Index, "hosp_code",_poDeskScheduleTransVO.getStrHospitalCode(),5);
			
			dao.setProcOutValue(nProc2Index, "err",1,14);
			
			/* Start Adding Default value*/
			dao.setProcInValue(nProc2Index, "schedule_no","",4);
			dao.setProcInValue(nProc2Index, "schedule_date","",6);
			dao.setProcInValue(nProc2Index, "delivery_date","",7);
			dao.setProcInValue(nProc2Index, "schedule_status","",8);
			dao.setProcInValue(nProc2Index, "penelty","",9);
			dao.setProcInValue(nProc2Index, "cancel_date","",10);
			dao.setProcInValue(nProc2Index, "cancel_by","",11);
			dao.setProcInValue(nProc2Index, "cancel_remarks","",12);
			dao.setProcInValue(nProc2Index, "delivery_loc","",13);
			/* End Adding Default value*/
			
			dao.execute(nProc2Index,1);
					
			
			for (int nTmpI = 0; nTmpI < Integer.parseInt(_poDeskScheduleTransVO.getStrDNoOfSchedule()); nTmpI++) 
			{
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "modeval","5",1);
				dao.setProcInValue(nProcIndex, "store_id",_poDeskScheduleTransVO.getStrStoreId(),2);			
				dao.setProcInValue(nProcIndex, "pono",_poDeskScheduleTransVO.getStrPONo(),3);
				dao.setProcInValue(nProcIndex, "schedule_no",""+(nTmpI+1),4);
				dao.setProcInValue(nProcIndex, "hosp_code",_poDeskScheduleTransVO.getStrHospitalCode(),5);
				dao.setProcInValue(nProcIndex, "delivery_date",_poDeskScheduleTransVO.getStrDDeliveryDate()[nTmpI],7);
				dao.setProcOutValue(nProcIndex, "err",1,14);
				
				/* Start Adding Default value*/
				dao.setProcInValue(nProcIndex, "schedule_date","",6);
				/**
				 * This Variable is Used To Save Schedule Wise Delivery Loaction 
				 * Used Porcedure Mode = 6
				 */
				dao.setProcInValue(nProcIndex, "schedule_status",_poDeskScheduleTransVO.getStrDeliveryLocation()[nTmpI],8);
				dao.setProcInValue(nProcIndex, "penelty","",9);
				dao.setProcInValue(nProcIndex, "cancel_date","",10);
				dao.setProcInValue(nProcIndex, "cancel_by","",11);
				dao.setProcInValue(nProcIndex, "cancel_remarks","",12);
				dao.setProcInValue(nProcIndex, "delivery_loc",_poDeskScheduleTransVO.getStrDeliveryLocation()[nTmpI],13);
				/* End Adding Default value*/
				
				dao.execute(nProcIndex,1);
			}
			 
			for (int nTmpI = 0; nTmpI < _poDeskScheduleTransVO.getStrCheckBox().length; nTmpI++) 
			{
				nProc1Index = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProc1Index, "modeval", "1",1);
				dao.setProcInValue(nProc1Index, "pono", _poDeskScheduleTransVO.getStrPONo(),2);
				dao.setProcInValue(nProc1Index, "store_id", _poDeskScheduleTransVO.getStrStoreId(),3);
				dao.setProcInValue(nProc1Index, "item_id",_poDeskScheduleTransVO.getStrDItemId()[nTmpI],4);
				dao.setProcInValue(nProc1Index, "item_brand_id",_poDeskScheduleTransVO.getStrDItemBrandId()[nTmpI],5);
				dao.setProcInValue(nProc1Index, "schedule_no", _poDeskScheduleTransVO.getStrDScheduleNo()[nTmpI],6);
				dao.setProcInValue(nProc1Index, "hosp_code",_poDeskScheduleTransVO.getStrHospitalCode(),7);
				dao.setProcInValue(nProc1Index, "supplier",_poDeskScheduleTransVO.getStrSupplierId(),8);
				dao.setProcInValue(nProc1Index, "groupid",_poDeskScheduleTransVO.getStrDGroupId()[nTmpI],9);
				dao.setProcInValue(nProc1Index, "subgroup_id",_poDeskScheduleTransVO.getStrDSubGroupId()[nTmpI],10);
				dao.setProcInValue(nProc1Index, "manuf_id",_poDeskScheduleTransVO.getStrDManufacturerId()[nTmpI],11);
				dao.setProcInValue(nProc1Index, "rate",_poDeskScheduleTransVO.getStrDRate()[nTmpI],12);
				dao.setProcInValue(nProc1Index, "rate_unit",_poDeskScheduleTransVO.getStrDRateUnitId()[nTmpI],13);
				dao.setProcInValue(nProc1Index, "order_qty", _poDeskScheduleTransVO.getStrDScheduledQty()[nTmpI],14);
				dao.setProcInValue(nProc1Index, "order_qty_unit", _poDeskScheduleTransVO.getStrDScheduledQtyUnit()[nTmpI].replace("^", "#").split("#")[0],15);
				dao.setProcInValue(nProc1Index, "warrenty_req",_poDeskScheduleTransVO.getStrDWarrentyReq()[nTmpI],22);
				dao.setProcInValue(nProc1Index, "installation_req",_poDeskScheduleTransVO.getStrDInstallationReq()[nTmpI],23);
				dao.setProcInValue(nProc1Index, "remarks",_poDeskScheduleTransVO.getStrDRemarks(),24);
				dao.setProcInValue(nProc1Index, "item_tax",_poDeskScheduleTransVO.getStrDItemTax()[nTmpI],25);
				dao.setProcOutValue(nProc1Index, "err", 1,38);

				/* Start Adding Default value*/
				dao.setProcInValue(nProc1Index, "accepted_qty", "0",16); 
				dao.setProcInValue(nProc1Index, "accepted_qty_unit", "0",17);
				dao.setProcInValue(nProc1Index, "rejected_qty", "0",18);
				dao.setProcInValue(nProc1Index, "rejected_qty_unit", "0",19);
				dao.setProcInValue(nProc1Index, "breakage_qty", "0",20);
				dao.setProcInValue(nProc1Index, "breakage_qty_unit", "0",21);
				dao.setProcInValue(nProc1Index, "return_qty", "0",26); 
				dao.setProcInValue(nProc1Index, "return_qty_unit", "0",27);
				dao.setProcInValue(nProc1Index, "recieved_qty", "0",28);
				dao.setProcInValue(nProc1Index, "recieved_qty_unit", "0",29);
				dao.setProcInValue(nProc1Index, "req_no", "0",30);
				dao.setProcInValue(nProc1Index, "challanNo", "0",31);
				dao.setProcInValue(nProc1Index, "raising_store", "0",32);
				dao.setProcInValue(nProc1Index, "po_type", "0",33);
				dao.setProcInValue(nProc1Index, "item_make", "1",34);
				dao.setProcInValue(nProc1Index, "itemName", "",35);
				dao.setProcInValue(nProc1Index, "po_date", "",36);
				dao.setProcInValue(nProc1Index, "delivery_loc",_poDeskScheduleTransVO.getStrStoreId(),37); //doubt for delivery loc so store id is used
				/* End Adding Default value*/
				
				dao.execute(nProc1Index, 1);
			}
			
			
			

			dao.fire();
			flag = true;
			
			if(flag)
			{
				//PODeskScheduleTransDAO.updateCurrStock(_poDeskScheduleTransVO,strItemFinalTotalCost); commented as modeval 7 not found
			}
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskScheduleTransVO.setStrMsgString("PODeskScheduleTransDAO.insert() --> "+ _Err.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void updateCurrStock(PODeskScheduleTransVO _poDeskScheduleTransVO,String strItemFinalTotalCost ) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}"; //5+8+1=14
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex,  "modeval", "7",1);                 //1
			dao.setProcInValue(nprocIndex, "store_id",_poDeskScheduleTransVO.getStrStoreId(),2);	//2		
			dao.setProcInValue(nprocIndex, "pono",_poDeskScheduleTransVO.getStrPONo(),3);//3
			dao.setProcInValue(nprocIndex, "hosp_code",_poDeskScheduleTransVO.getStrHospitalCode(),5);//4
			dao.setProcOutValue(nprocIndex, "err",1,14);//5
			////System.out.println("Total Cost in updateCurrStock:::==>"+strItemFinalTotalCost);
			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "schedule_no","",4);//6
			dao.setProcInValue(nprocIndex, "schedule_date","",6);//7
			dao.setProcInValue(nprocIndex, "delivery_date","",7);//8
			dao.setProcInValue(nprocIndex, "schedule_status","",8);//9
			dao.setProcInValue(nprocIndex, "penelty",strItemFinalTotalCost,9);//10
			dao.setProcInValue(nprocIndex, "cancel_date","",10);//11
			dao.setProcInValue(nprocIndex, "cancel_by","",11);//12
			dao.setProcInValue(nprocIndex, "cancel_remarks","",12);//13
			dao.setProcInValue(nprocIndex, "delivery_loc","",13);//14
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			_poDeskScheduleTransVO.setStrMsgString("PODeskScheduleTransDAO.updateCurrStock() --> "+ e.getMessage());
			_poDeskScheduleTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}
