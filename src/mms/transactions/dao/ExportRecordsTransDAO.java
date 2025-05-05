package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ExportRecordsTransVO;

public class ExportRecordsTransDAO {

	public static void getTemplateList(ExportRecordsTransVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			
			if (!vo.getStrTemplateId().equals("0")) {
				strQuery = mms.qryHandler_mms.getQuery(2,
						"select.importRecordTrans.01");
				nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
				dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateType());
				dao.setQryValue(nQueryIndex, 3, vo.getStrTemplateId());
			} else {
				strQuery = mms.qryHandler_mms.getQuery(2,
						"select.importRecordTrans.0");
				nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
				dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateType());

			}

			ws = dao.executeQry(nQueryIndex);
			// //System.out.println("Size:::"+ws.size());
			vo.setWsTemplateList(ws);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("ExportRecordsTransDAO.getTemplateList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}

	public static void getTemplateDetails(ExportRecordsTransVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			//
			strQuery = mms.qryHandler_mms.getQuery(2,
					"select.exportRecordTrans.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateId());

			ws = dao.executeQry(nQueryIndex);

			vo.setWsTemplateDetails(ws);

		} catch (Exception e) {

			vo
					.setStrMsgString("ExportRecordsTransDAO.getTemplateDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}

	public static void exportData(ExportRecordsTransVO vo) {
		String strProcName = "";
		HisDAO dao = null;

		int nProcIndex = 0;
		String tempStr = "";

		WebRowSet ws = null;

		try {

			strProcName = vo.getStrCallProcedure();

			dao = new HisDAO("MMS",
					"transactions.ImportRecordsTransDAO.importData()");
			//

			nProcIndex = dao.setProcedure(strProcName);

			if (vo.getStrInParamName() != null
					&& vo.getStrInParamName().length > 0) {
				for (int j = 0; j <= vo.getStrInParamName().length + 2; j++) {

					if (j == vo.getStrInParamName().length) {

						dao.setProcInValue(nProcIndex, "HOSP_CODE", vo
								.getStrHospitalCode());

					} else if (j == vo.getStrInParamName().length + 1) {

						dao.setProcOutValue(nProcIndex, "ERR", 1);

					} else if (j == (vo.getStrInParamName().length + 2)) {

						dao.setProcOutValue(nProcIndex, "resultset", 2);
					} else {

						if (!vo.getStrInConstantValue()[j].equals("0")
								|| vo.getStrInConstantValue()[j].length() != 0) {

							tempStr = ((vo.getStrInConstantValue()[j])
									.split("\\^"))[0];

							dao.setProcInValue(nProcIndex, vo
									.getStrInParamName()[j], tempStr);

						} else {

							dao.setProcInValue(nProcIndex, vo
									.getStrInParamName()[j], "1");
						}

					}

				}

				dao.executeProcedure(nProcIndex);

				String err = dao.getString(nProcIndex, "ERR");

				if (err == null)
					err = "";

				if (err.equals("")) {

					ws = dao.getWebRowSet(nProcIndex, "resultset");

				} else {

					throw new Exception(err);

				}

				vo.setWsExportedDatas(ws);

			} else {

				throw new Exception("No Parameter Exists");

			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("DrugProfileDAO.exportData() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static WebRowSet getResultSetForQuery(String strQuery,
			String strHospitalCode) throws Exception {
		HisDAO dao = null;
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			//
			strQuery = strQuery.replace("?", strHospitalCode);

			nQueryIndex = dao.setQuery(strQuery);

			ws = dao.executeQry(nQueryIndex);

		} catch (Exception e) {

			throw e;
		} finally {
			dao = null;

		}

		return ws;

	}
	
	public static WebRowSet getResultSetForQuery(String strQuery,
			String strHospitalCode, String strseatid) throws Exception {
		HisDAO dao = null;
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
		//	
			strQuery = strQuery.replace("?", strHospitalCode);
			strQuery = strQuery.replace("#", strseatid);

			nQueryIndex = dao.setQuery(strQuery);

			ws = dao.executeQry(nQueryIndex);

		} catch (Exception e) {

			throw e;
		} finally {
			dao = null;

		}

		return ws;

	}

}
