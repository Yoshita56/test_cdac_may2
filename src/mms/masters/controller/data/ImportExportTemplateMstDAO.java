package mms.masters.controller.data;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.ImportExportTemplateMstVO;

public class ImportExportTemplateMstDAO {

	/**
	 * gets the template list from Table : HSTT_UTIL_TEMPLATE_DTL
	 * @param vo
	 */
	public static void getTemplateList(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.impexpTemplateMst.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateType());
			
			ws = dao.executeQry(nQueryIndex);

			vo.setWsTemplateValues(ws);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("ImportExportTemplateMstDAO.getTemplateList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}
	
	/**
	 * gets procedure list using the metadata query from Package : PKG_IMP_EXP_UTIL
	 * @param vo
	 */
	public static void getProcedureList(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.impexpTemplateMst.0").replace("?", vo.getStrProcedureType());
			nQueryIndex = dao.setQuery(strQuery);
						
			ws = dao.executeQry(nQueryIndex);
			
			vo.setWsProcedureValues(ws);

		} catch (Exception e) {
			
			vo.setStrMsgString("ImportExportTemplateMstDAO.getProcedureList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}
	
	/**
	 * gets the template details from Table : HSTT_UTIL_TEMPLATE_DTL
	 * @param vo
	 */
	public static void getTemplateDetails(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.impexpTemplateMst.2");			
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1,  vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2,vo.getStrTemplateId() );
			
			ws = dao.executeQry(nQueryIndex);
			
			vo.setWsTemplateDetails(ws);

		} catch (Exception e) {
			
			vo.setStrMsgString("ImportExportTemplateMstDAO.getTemplateDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}
	
	/**
	 * insert the import template details by generating a template id using db function
	 * @param vo
	 */
	public static void insertImportTemplateDetails(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int nqryIndex2;
		int nFuncIndex;
		String strTemplateId = "0";
		String strquery = "";
		String strQuery2 = "";
		String strFuncName = "";

		try {
			dao = new HisDAO("mms", "GatePassTypeMstDAO");
			
			strFuncName = "{? = call Mms_Mst.GENERATE_TEMPLATE_ID(?)}";
			nFuncIndex = dao.setFunction(strFuncName);
				 
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strTemplateId = dao.getFuncString(nFuncIndex);
			
			strquery = mms.qryHandler_mms.getQuery(1, "insert.impexpTemplateMst.0");			
			nqryIndex = dao.setQuery(strquery);
			
			
			dao.setQryValue(nqryIndex, 1, strTemplateId);
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrTemplate());
			dao.setQryValue(nqryIndex, 4, vo.getStrTemplateType());
			dao.setQryValue(nqryIndex, 5, vo.getStrProcedure());
			dao.setQryValue(nqryIndex, 6, vo.getStrSeatId());
		 
			dao.execute(nqryIndex, 0);
			
			strQuery2 = mms.qryHandler_mms.getQuery(1, "insert.impexpTemplateMst.1");
			
			if(vo.getStrProcColumnDtls() != null)
			for (int i = 0, stopI = vo.getStrProcColumnDtls().length; i < stopI; i++) {
				
				nqryIndex2 = dao.setQuery(strQuery2);
				
				String[] temp = vo.getStrProcColumnDtls()[i].replace("^", "#").split("#");
				String[] temp1 = vo.getStrExcelHeaderNames()[i].replace("^", "#").split("#");
								
				dao.setQryValue(nqryIndex2, 1, strTemplateId);
				dao.setQryValue(nqryIndex2, 2, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex2, 3, strTemplateId);
				dao.setQryValue(nqryIndex2, 4, vo.getStrParamType());
				dao.setQryValue(nqryIndex2, 5, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex2, 6, temp[0]);
				dao.setQryValue(nqryIndex2, 7, temp[0]);
				dao.setQryValue(nqryIndex2, 8, temp[1]);
				
				if(temp1.length <= 1){
				
					dao.setQryValue(nqryIndex2, 9, "");
					dao.setQryValue(nqryIndex2, 10, "");
				}else{
					
					dao.setQryValue(nqryIndex2, 9, temp1[1]);
					dao.setQryValue(nqryIndex2, 10, temp1[0]);
				}
				
				dao.setQryValue(nqryIndex2, 11, vo.getStrConstantValue()[i]);
				dao.setQryValue(nqryIndex2, 12, vo.getStrSeatId());
				dao.setQryValue(nqryIndex2, 13, "0");
				dao.setQryValue(nqryIndex2, 14, "0");
				dao.execute(nqryIndex2, 0);
				
			}
			
			
			synchronized (dao) {
			
				dao.fire();
				
			}
			
			
		 			 
		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("GatePassTypeMstDAO.initialUpdateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/**
	 * insert export template details by generating a template id though db function
	 * @param vo
	 */
	public static void insertExportTemplateDetails(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int nqryIndex2;
		int nqryIndex3;
		int nFuncIndex;
		String strTemplateId = "0";
		String strquery = "";
		String strQuery2 = "";
		String strQuery3 = "";
		String strFuncName = "";

		try {
			dao = new HisDAO("mms", "GatePassTypeMstDAO");
			
			strFuncName = "{? = call Mms_Mst.GENERATE_TEMPLATE_ID(?)}";
			nFuncIndex = dao.setFunction(strFuncName);
				 
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strTemplateId = dao.getFuncString(nFuncIndex);
			
			strquery = mms.qryHandler_mms.getQuery(1, "insert.impexpTemplateMst.0");			
			nqryIndex = dao.setQuery(strquery);
			
			
			dao.setQryValue(nqryIndex, 1, strTemplateId);
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrTemplate());
			dao.setQryValue(nqryIndex, 4, vo.getStrTemplateType());
			dao.setQryValue(nqryIndex, 5, vo.getStrProcedure());
			dao.setQryValue(nqryIndex, 6, vo.getStrSeatId());
		 
			dao.execute(nqryIndex, 0);
			
			strQuery2 = mms.qryHandler_mms.getQuery(1, "insert.impexpTemplateMst.1");
			
			if(vo.getStrProcInColumnDtls() != null)
			for (int i = 0 , stopI = vo.getStrProcInColumnDtls().length; i <stopI ; i++) {
				
				nqryIndex2 = dao.setQuery(strQuery2);
				
				String[] temp = vo.getStrProcInColumnDtls()[i].replace("^", "#").split("#");
				
				dao.setQryValue(nqryIndex2, 1, strTemplateId);
				dao.setQryValue(nqryIndex2, 2, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex2, 3, strTemplateId);
				dao.setQryValue(nqryIndex2, 4, "1");
				dao.setQryValue(nqryIndex2, 5, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex2, 6, temp[0]);
				dao.setQryValue(nqryIndex2, 7, vo.getStrParamDispalyName()[i]);
				dao.setQryValue(nqryIndex2, 8,temp[1]);
				dao.setQryValue(nqryIndex2, 9, "");
				dao.setQryValue(nqryIndex2, 10, "");
				dao.setQryValue(nqryIndex2, 11, vo.getStrInConstantValue()[i]);
				dao.setQryValue(nqryIndex2, 12, vo.getStrSeatId());
				dao.setQryValue(nqryIndex2, 13, vo.getStrParamCompType()[i]);
				dao.setQryValue(nqryIndex2, 14, vo.getStrComboQuery()[i]);
				
				
				dao.execute(nqryIndex2, 0);
				
			}
			
			
			strQuery3 = mms.qryHandler_mms.getQuery(1, "insert.impexpTemplateMst.1");
			
			if(vo.getStrProcOutColumnDtls() != null)
			for (int i = 0 , stopI = vo.getStrProcOutColumnDtls().length; i <stopI ; i++) {
				
				nqryIndex3 = dao.setQuery(strQuery3);
				
			 						
				dao.setQryValue(nqryIndex3, 1, strTemplateId);
				dao.setQryValue(nqryIndex3, 2, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex3, 3, strTemplateId);
				dao.setQryValue(nqryIndex3, 4, "2");
				dao.setQryValue(nqryIndex3, 5, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex3, 6, vo.getStrProcOutColumnDtls()[i]);
				dao.setQryValue(nqryIndex3, 7, vo.getStrProcOutColumnDtls()[i]);
				dao.setQryValue(nqryIndex3, 8, "0");
				dao.setQryValue(nqryIndex3, 9, vo.getStrProcOutColumnIndex()[i]);
				dao.setQryValue(nqryIndex3, 10, vo.getStrExcelHeader()[i]);
				dao.setQryValue(nqryIndex3, 11, "");
				dao.setQryValue(nqryIndex3, 12, vo.getStrSeatId());
				dao.setQryValue(nqryIndex3, 13, "0");
				dao.setQryValue(nqryIndex3, 14, "");
				dao.execute(nqryIndex3, 0);
				
			}
			
			
			synchronized (dao) {
			
				dao.fire();
				
			}
			
			
		 			 
		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("GatePassTypeMstDAO.initialUpdateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	/**
	 * delete's the existing template
	 * @param vo
	 */
	public static void deleteTemplateDetails(ImportExportTemplateMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int nqryIndex2;
	 
		String strquery = "";
		String strQuery2 = "";
		 

		try {
			dao = new HisDAO("mms", "GatePassTypeMstDAO");
						
			strquery = mms.qryHandler_mms.getQuery(1, "update.impexpTemplateMst.0");			
			nqryIndex = dao.setQuery(strquery);
			
			
			dao.setQryValue(nqryIndex, 1, vo.getStrTemplateId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 		 
			dao.execute(nqryIndex, 0);
			
			strQuery2 = mms.qryHandler_mms.getQuery(1, "update.impexpTemplateMst.1");
			
				nqryIndex2 = dao.setQuery(strQuery2);
					
				dao.setQryValue(nqryIndex2, 1, vo.getStrTemplateId());
				dao.setQryValue(nqryIndex2, 2, vo.getStrHospitalCode());
							
				dao.execute(nqryIndex2, 0);
				
			
			synchronized (dao) {
			
				dao.fire();
				
			}
			
			
		 			 
		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("GatePassTypeMstDAO.deleteTemplateDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	
}
