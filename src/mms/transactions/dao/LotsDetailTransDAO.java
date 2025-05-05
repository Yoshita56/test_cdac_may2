/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.AgendaDetailDAO;
import mms.dao.AgendaItemDetailDAO;
import mms.transactions.vo.LotsDetailTransVO;



/**
 * @author Anurudra Goel
 * 
 */
public class LotsDetailTransDAO {
	
	
	/**
	 * This function is fetch details from database for group combo
	 * @param _LotsDetailTransVO
	 */

	public static void getStoreGroupList(LotsDetailTransVO _LotsDetailTransVO) {
		

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("mms", "LotsDetailTransDAO");
		
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "modeval", "2");
				// set value
				dao.setProcInValue(procIndex1, "item_category", _LotsDetailTransVO.getStrItemCategoryNo());
				
				dao.setProcInValue(procIndex1, "hosp_code", _LotsDetailTransVO
								.getStrHospCode());
				
				/* Setting Default Value Start*/
				dao.setProcInValue(procIndex1, "strPhyStockNo", "");
				dao.setProcInValue(procIndex1, "strStoreId", "");
				/* Setting Default Value End */
		
				dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
				// value
		
				dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
		
				// execute procedure
		
				dao.executeProcedure(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "ERR");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
		
				_LotsDetailTransVO.setGroupWS(ws);

		} catch (Exception e) {
			_LotsDetailTransVO.setStrMsgString("LotsDetailTransDAO.getStoreGroupList() --> "
					+ e.getMessage());
			_LotsDetailTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
 * This function is used to insert data into database
 * @param _LotsDetailTransVO
 */
	public static void insert(LotsDetailTransVO _LotsDetailTransVO) {
		
		HisDAO dao = null;
		
		String agendaNo="";
		int funcIndex=0;
	
		int length=0;
		String strTemp[]=null;
		String temp[]=null;
	
		String strItemId="";
		String strItemBrandId="";
		String strGroupId="";
		String strSubGroupId="";
		String strQty="";
		String strUnitId="";
		String strLastRate="";
		String strLastRateUnit="";
		String strLastPoNo="";
		String strLastSuppliedBy="";
		String strInhandQty="";
		String strInhandUnitId="";
	    String strPoDate="";
	    String strLastRecQty="";
		 String strLastRecQtyUnitId="";
		AgendaDetailDAO agendaDetailDAO=null;
		AgendaItemDetailDAO agendaItemDetailDAO=null;
		try
		{
				agendaDetailDAO=new AgendaDetailDAO();
				agendaItemDetailDAO=new AgendaItemDetailDAO();
				dao = new HisDAO("MMS", "LotsDetailTransDAO");
				
				length=_LotsDetailTransVO.getItemParamValue().length;
				
				/**
				 * This function is used to generate New Condemn No
				 */
				
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_agenda_No(?,?,?,?,?)}");
				dao.setFuncInValue(funcIndex, 2,"1" );
				dao.setFuncInValue(funcIndex, 3,"62" );
				dao.setFuncInValue(funcIndex, 4, _LotsDetailTransVO.getStrStoreId());
				dao.setFuncInValue(funcIndex, 5, _LotsDetailTransVO.getStrItemCategoryNo());
				dao.setFuncInValue(funcIndex, 6, _LotsDetailTransVO.getStrHospCode());
				dao.setFuncOutValue(funcIndex, 1);
				dao.executeFunction(funcIndex);
				agendaNo=dao.getFuncString(funcIndex);
				
				 agendaDetailDAO.setStrAgendaNo(agendaNo);
				 agendaDetailDAO.setStrHospCode(_LotsDetailTransVO.getStrHospCode());
				 agendaDetailDAO.setStrItemCategNo(_LotsDetailTransVO.getStrItemCategoryNo());
				 agendaDetailDAO.setStrRemarks(_LotsDetailTransVO.getStrRemarks());
				 agendaDetailDAO.setStrReqType("62");
				 agendaDetailDAO.setStrSeatId(_LotsDetailTransVO.getStrSeatId());
				 agendaDetailDAO.setStrStoreId(_LotsDetailTransVO.getStrStoreId());
				 agendaDetailDAO.setFin_end_date(_LotsDetailTransVO.getStrFinEndDate());
				 agendaDetailDAO.setFin_start_date(_LotsDetailTransVO.getStrFinStartDate());
				 agendaDetailDAO.setStrCondemnationType(_LotsDetailTransVO.getStrCondemnationType());
				 agendaDetailDAO.insert(dao);
				
				
				for(int i=0;i<length;i++)
				{
										 
					 temp  = _LotsDetailTransVO.getItemParamValue()[i].split("#");
					 strTemp=temp[2].replace('^', '#').split("#");
					
					 strItemId=strTemp[0];
					 strItemBrandId=strTemp[1];
					// //System.out.println("Item paramval:::"+_LotsDetailTransVO.getItemParamValue()[i]);
					// //System.out.println("strItemId"+strItemId);
					 //.out.println("strItemId"+strItemId);
					 
					 strGroupId=strTemp[2];
					 strSubGroupId=strTemp[3];
					 strQty=strTemp[7];
					 strUnitId=strTemp[8];
					 strLastRate=strTemp[9];
					 strLastRateUnit=strTemp[10];
					 strLastPoNo=strTemp[12];
					 strLastSuppliedBy=strTemp[14];
					 strInhandUnitId=strTemp[8];
					 strInhandQty=strTemp[7];
					 strPoDate=strTemp[13];
					 strLastRecQty=strTemp[19];
					 strLastRecQtyUnitId=strTemp[20];
					 agendaItemDetailDAO.setStrGroupId(strGroupId);
					 agendaItemDetailDAO.setStrHospCode(_LotsDetailTransVO.getStrHospCode());
					 agendaItemDetailDAO.setStrItemBrandId(strItemBrandId);
					 agendaItemDetailDAO.setStrItemId(strItemId);
					 agendaItemDetailDAO.setStrLstPoNo(strLastPoNo);
					 agendaItemDetailDAO.setStrLstRate(strLastRate);
					 agendaItemDetailDAO.setStrLstRateUnitId(strLastRateUnit);
					 agendaItemDetailDAO.setStrLstSupplier(strLastSuppliedBy);
					 agendaItemDetailDAO.setStrQty(strQty);
					 agendaItemDetailDAO.setStrRemarks(_LotsDetailTransVO.getStrRemarks());
					 agendaItemDetailDAO.setStrStoreId(_LotsDetailTransVO.getStrStoreId());
					 agendaItemDetailDAO.setStrSubGroupId(strSubGroupId);
					 agendaItemDetailDAO.setStrUnitId(strUnitId);
					 agendaItemDetailDAO.setStrAgendaNo(agendaNo);
					 agendaItemDetailDAO.setStrCategNo(_LotsDetailTransVO.getStrItemCategoryNo());
					 agendaItemDetailDAO.setStrInhandQty(strInhandQty);
					 agendaItemDetailDAO.setStrInhandUnitId(strInhandUnitId);
					 agendaItemDetailDAO.setStrPoDate(strPoDate);
					 agendaItemDetailDAO.setStrLastRecQty(strLastRecQty);
					 agendaItemDetailDAO.setStrLastRecQtyUnitId(strLastRecQtyUnitId);
					 agendaItemDetailDAO.insert(dao);
							
					
				}
				synchronized (dao) {
					dao.fire();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			_LotsDetailTransVO.setStrMsgString("LotsDetailTransDAO.insert() --> "
					+ e.getMessage());
			_LotsDetailTransVO.setStrMsgType("1");
		}
	
	}
	
	/**
	 * This function is used to cancel lots.
	 * @param _LotsDetailTransVO
	 */
		public static void updateCancel(LotsDetailTransVO _LotsDetailTransVO) {
			
			AgendaItemDetailDAO agendaItemDetailDAO=null;
			HisDAO dao=null;
			try
			{
					agendaItemDetailDAO=new AgendaItemDetailDAO();
					dao = new HisDAO("MMS", "LotsDetailTransDAO");
					
						 agendaItemDetailDAO.setStrHospCode(_LotsDetailTransVO.getStrHospCode());
						 agendaItemDetailDAO.setStrItemBrandId(_LotsDetailTransVO.getStrItemBrandId());
						 agendaItemDetailDAO.setStrItemId(_LotsDetailTransVO.getStrItemId());
						 agendaItemDetailDAO.setStrRemarks(_LotsDetailTransVO.getStrRemarks());
						 agendaItemDetailDAO.setStrStoreId(_LotsDetailTransVO.getStrStoreId());
						 agendaItemDetailDAO.setStrAgendaNo(_LotsDetailTransVO.getStrAgendaNo());
						 agendaItemDetailDAO.setStrCategNo(_LotsDetailTransVO.getStrItemCategoryNo());
						 agendaItemDetailDAO.setStrSeatId(_LotsDetailTransVO.getStrSeatId());
						 agendaItemDetailDAO.update(dao);
						 
						synchronized (dao) {
							dao.fire();
						}
					
			}
			catch(Exception e)
			{
				
				_LotsDetailTransVO.setStrMsgString("LotsDetailTransDAO.updateCancel() --> "
						+ e.getMessage());
				_LotsDetailTransVO.setStrMsgType("1");
			}
		
		}

		public static void getCondemnationType(LotsDetailTransVO _LotsDetailTransVO){
			
			String strQuery="";
			WebRowSet web=null;
			HisDAO dao=null;
			int nQueryIndex=0;
			String condemnationType="";
	//		String temp[]=null;
			try{
				
			 
				dao=new HisDAO("mms","LotsDetailTransDAO");
				
				strQuery="SELECT NVL(HSTSTR_CONDEMNATION_TYPE,0) FROM SSTT_ITEM_CATEGORY_MST"+
				" WHERE GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=? AND SSTNUM_ITEM_CAT_NO=?";
				
				 nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, _LotsDetailTransVO.getStrHospCode());
				dao.setQryValue(nQueryIndex, 2, _LotsDetailTransVO.getStrItemCategoryNo());
				web = dao.executeQry(nQueryIndex);
				if(web!=null){
					if(web.next())
					condemnationType=web.getString(1);
				}else{
					throw new Exception("Webrowset is null");
				}
				if(condemnationType.equals("0")){
						strQuery =  " SELECT HSTNUM_CONDEMN_TYPE_ID,HSTNUM_CONDEMN_TYPE_NAME FROM  sstt_condemnation_type_mst"+
						" WHERE GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=?";
						nQueryIndex = dao.setQuery(strQuery);
				}else{
						strQuery =  " SELECT HSTNUM_CONDEMN_TYPE_ID,HSTNUM_CONDEMN_TYPE_NAME FROM  sstt_condemnation_type_mst"+
						" WHERE GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=? AND  HSTNUM_CONDEMN_TYPE_ID IN ( ## ) ";
						nQueryIndex = dao.setQuery(strQuery.replace("##", condemnationType));
				}
				dao.setQryValue(nQueryIndex, 1, _LotsDetailTransVO.getStrHospCode());
				web = dao.executeQry(nQueryIndex);
				if(web!=null){
					_LotsDetailTransVO.setWsCondemnType(web);
				}else{
					throw new Exception("Webrowset is null");
				}
			}catch(Exception _Err){
				_Err.printStackTrace();
				_LotsDetailTransVO.setStrMsgString("LotsDetailTransDAO.getCondemnationType() --> "
						+ _Err.getMessage());
				_LotsDetailTransVO.setStrMsgType("1");
			}
		}

}
