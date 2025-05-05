package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.sql.rowset.WebRowSet;

import mms.masters.bo.ImportExportTemplateMstBO;
import mms.masters.controller.fb.ImportExportTemplateMstFB;
import mms.masters.controller.hlp.ImportExportTemplateMstHLP;
import mms.masters.vo.ImportExportTemplateMstVO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ImportExportTemplateMstDATA {

	private static Context ic = null;
	private static DataSource ds = null;
	private static String lookUpName = "";

//	private static final String pathFileName = "hisglobal.hisconfig.hisPath";

	/**
	 * 
	 * @param request
	 * @param formBean
	 */
	public static void initMainPage(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {
		HisUtil util = null;
		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;
		try {

			util = new HisUtil("MMS", "ImportExportTemplateMstDATA");
			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			// formBean.setStrHospitalCode("108");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrTemplateType("1");
			vo.setStrProcedureType("DML%");

			bo.getMainPageValues(vo);

			if (vo.getWsTemplateValues() != null
					&& vo.getWsTemplateValues().size() > 0) {

				formBean.setStrTemplateValues(util.getOptionValue(vo
						.getWsTemplateValues(), "0", "0^New Template", false));

			} else {

				formBean
						.setStrTemplateValues("<option value='0'>New Template</option>");

			}

			if (vo.getWsProcedureValues() != null
					&& vo.getWsProcedureValues().size() > 0) {

				formBean.setStrProcedureValues(util.getOptionValue(vo
						.getWsProcedureValues(), "0", "0^Select Value", false));

			} else {

				formBean
						.setStrProcedureValues("<option value='0'>Select Value</option>");

			}

		} catch (Exception _e) {

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->initMainPage()", _e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void paramMapping(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {

		String strPackName = formBean.getStrProcedure().replace("^", "#")
				.split("#")[0];

		String strProcName = formBean.getStrProcedure().replace("^", "#")
				.split("#")[1];

		//ResultSet rs = null;
		
		WebRowSet ws = null;

		HisUtil util = null;

		ArrayList<String> excelHeaders = null;

		String strMappingContenst = "";

		try {

			util = new HisUtil("MMS", "ImportExportTemplateMstDATA");

			ws = getProcResultSet(strPackName, strProcName, null, formBean.getStrTemplateType());

			formBean.setStrParamType("1");

			if (formBean.getStrTemplateType().equals("1")) 
			{

				excelHeaders = getExcelHeader(formBean);

				String strExcelHeaderContents = util.getOptionValue(excelHeaders, "0", "0^Default Value");

				formBean.setStrExcelFilePathName(formBean.getStrExcelFilePath().getFileName());

				strMappingContenst = ImportExportTemplateMstHLP.getImportTemplateParamMappingList(strExcelHeaderContents, ws);

			} 
			else 
			{

				strMappingContenst = ImportExportTemplateMstHLP.getExportTemplateParamDefaultValList(ws);

			}

			formBean.setStrMappingContents(strMappingContenst);

			formBean.setStrProcedure(strProcName);
			formBean.setStrPackage(strPackName);

		} catch (Exception _e) {

			_e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->paramMapping()", _e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {

			try {

				if (ws != null)
					ws.close();

			} catch (SQLException e) {

				HisException eObj = new HisException("MMS",
						"ImportExportTemplateMstDATA->paramMapping()", e
								.getMessage());
				formBean.setStrErrorMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator! ");
				eObj = null;
			}

		}

	}

	public static void preExpSaveMapping(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {

		ResultSet rs = null;

		try {

			rs = getProcResultSet(formBean.getStrPackage(), formBean
					.getStrProcedure(), formBean.getStrInConstantValue(), "3");

			String strMappingContenst = ImportExportTemplateMstHLP
					.getExportTemplateParamMappingList(formBean, rs);

			formBean.setStrMappingContents(strMappingContenst);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->preSaveMapping()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void preSaveMapping(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {

		try {
			String strMappingContenst = ImportExportTemplateMstHLP
					.getParamMappedList(formBean);

			formBean.setStrMappingContents(strMappingContenst);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->preSaveMapping()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void getParamDtls(HttpServletRequest request,
			HttpServletResponse response, ImportExportTemplateMstFB formBean) {

		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;
		try {

			String strTemplateId = (String) request
					.getParameter("strTemplateId");

			String strTemplateType = (String) request
					.getParameter("strTemplateType");

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrTemplateId(strTemplateId);
			vo.setStrTemplateType(strTemplateType);

			bo.getParamDetails(vo);

			String strMappingContenst = ImportExportTemplateMstHLP
					.getTemplateDetails(vo.getWsTemplateDetails(), vo
							.getStrTemplateType());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strMappingContenst);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->preSaveMapping()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void getTemplateList(HttpServletRequest request,
			HttpServletResponse response, ImportExportTemplateMstFB formBean) {

		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;

		String strTemp = "";

		HisUtil util = null;

		try {

			util = new HisUtil("MMS", "ImportExportTemplateMstDATA");

			String strTemplateType = (String) request
					.getParameter("strTemplateType");

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrTemplateType(strTemplateType);

			bo.getTemplateList(vo);

			if (vo.getWsTemplateValues() != null
					&& vo.getWsTemplateValues().size() > 0) {

				strTemp = util.getOptionValue(vo.getWsTemplateValues(), "0",
						"0^New Template", false);

			} else {

				strTemp = "<option value='0'>New Template</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strTemp);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->getTemplateList()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void getProcedureList(HttpServletRequest request,
			HttpServletResponse response, ImportExportTemplateMstFB formBean) {

		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;

		String strTemp = "";
		HisUtil util = null;

		try {

			util = new HisUtil("MMS", "ImportExportTemplateMstDATA");
			String strTemplateType = (String) request
					.getParameter("strTemplateType");

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrTemplateType(strTemplateType);

			if (strTemplateType.equals("1")) {

				vo.setStrProcedureType("DML%");

			} else {

				vo.setStrProcedureType("PROC%");
			}

			bo.getProcedureList(vo);

			if (vo.getWsProcedureValues() != null
					&& vo.getWsProcedureValues().size() > 0) {

				strTemp = util.getOptionValue(vo.getWsProcedureValues(), "0",
						"0^Select Value", false);

			} else {

				strTemp = "<option value='0'>Select Value</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strTemp);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->getProcedureList()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void saveMapping(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {

		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;
		try {

			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			// formBean.setStrHospitalCode("108");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrProcedure(formBean.getStrProcedure());
			vo.setStrTemplate(formBean.getStrTemplate());
			vo.setStrTemplateType(formBean.getStrTemplateType());
			vo.setStrParamType(formBean.getStrParamType());
			vo.setStrParamCompType(formBean.getStrParamCompType());
			vo.setStrComboQuery(formBean.getStrComboQuery());
			vo.setStrParamDispalyName(formBean.getStrParamDispalyName());
			////System.out.println("formBean.getStrComboQuery() in DATA :::"+formBean.getStrComboQuery()[1]);
			
			
			if (vo.getStrTemplateType().equals("1")) {

				vo.setStrProcColumnDtls(formBean.getStrProcColumnDtls());
				vo.setStrExcelHeaderNames(formBean.getStrExcelHeaderNames());
				vo.setStrConstantValue(formBean.getStrConstantValue());

			} else {

				vo.setStrProcInColumnDtls(formBean.getStrProcInColumnDtls());
				vo.setStrInConstantValue(formBean.getStrInConstantValue());
				vo.setStrProcOutColumnDtls(formBean.getStrProcOutColumnDtls());
				vo
						.setStrProcOutColumnIndex(formBean
								.getStrProcOutColumnIndex());
				vo.setStrExcelHeader(formBean.getStrExcelHeader());

			}

			bo.saveMapping(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(
						"ImportExportTemplateMstDATA.saveMapping() -->"
								+ vo.getStrMsgString());

			}

			formBean.setStrMsg("Data Saved Successfully");
			formBean.setStrTemplateType("1");
		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->saveMapping()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void deleteTemplate(HttpServletRequest request,
			ImportExportTemplateMstFB formBean) {

		ImportExportTemplateMstBO bo = null;
		ImportExportTemplateMstVO vo = null;
		try {

			vo = new ImportExportTemplateMstVO();
			bo = new ImportExportTemplateMstBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			// formBean.setStrHospitalCode("108");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrTemplateId(formBean.getStrTemplate().replace("^", "#")
					.split("#")[0]);

			bo.deleteTemplate(vo);

			formBean.setStrTemplateType("1");
			
		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportExportTemplateMstDATA->deleteTemplate()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
/*
	private static void setConfigPath() throws Exception {
	
		try {
			if (lookUpName.equals("")) {

				
				lookUpName = HisUtil.getParameterFromHisPathXML("JNDI_LOOKUP");
			

			 
				//lookUpName = HisUtil.getParameterFromHisPathXML("JNDI_LOOKUP_INDIRECT");
			 

			}

		} catch (Exception e) {

			throw e;

		}

	}

	private static Connection getConnection() throws Exception {

		Connection conn = null;

		try {
			setConfigPath();
			if (lookUpName == null) {
				lookUpName = "";
			}
			if (!lookUpName.equals("")) {
				if (ic == null || ds == null) {
					ic = new InitialContext();
					ds = (DataSource) ic.lookup(lookUpName);
				}
				conn = ds.getConnection();
			}

		} catch (Exception e) {

			throw new Exception(
					"ImportExportTemplateMstDATA.getConnection() --> " + e);
		}
		return conn;

	}
*/
	private static WebRowSet getProcResultSet(String strPackName,
			String strProcName, String[] strDefaultValues, String strMode)
			throws Exception {

		///Connection conn = null;
		//DatabaseMetaData dbMetaData = null;
		//CallableStatement cstmt = null;
		//ResultSet rs = null;
		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		String query = "";

		try 
		{
			query = "SELECT ARGUMENT_NAME,DATA_TYPE " + 
					"FROM ALL_ARGUMENTS " + 
					"WHERE OBJECT_NAME = UPPER('" + strProcName + "') " +  
					"AND PACKAGE_NAME = UPPER('" + strPackName + "') " + 
					"ORDER BY POSITION";		

			//System.out.println("query ::"+query);
			daoObj = new HisDAO("Import","Import");
			int qryIndex = daoObj.setQuery(query);
			ws = daoObj.executeQry(qryIndex);
			if (strMode.equals("1") || strMode.equals("2")) 
			{
				return ws;
			}

			int size = 0;
			size = ws.size();

			//ws.close();

			//rs = dbMetaData.getProcedureColumns(strPackName.toUpperCase(), "DWH",strProcName, null);

			String strProcStart = "{ call " + strPackName + "." + strProcName
					+ "( ";

			String strProcMid = "";

			for (int i = 0; i < size; i++) {

				if (i != size - 1) {
					strProcMid = strProcMid + "?, ";
				} else {
					strProcMid = strProcMid + "? ";
				}

			}

			String strProcEnd = ") }";

			String strProcCall = strProcStart + strProcMid + strProcEnd;

			//cstmt = conn.prepareCall(strProcCall.toString().trim());
			int procIndex = daoObj.setProcedure(strProcCall.trim());

			int count = 0;

			 
			//String strProcCallMide = "";

			int index = 0;
			while (ws.next()) {

				index = index + 1;
/*
				if (index != 1)
					strProcCallMide = strProcCallMide + " , ";
*/
				 //String procedureCatalog = rs.getString(1);
				 //String procedureSchema = rs.getString(2);
				 //String procedureName = rs.getString(3);
				String columnName = ws.getString(1);
				
				// short columnReturn = rs.getShort(5);
				//int columnDataType = rs.getInt(6);
				//int columnDataType = 1;
				
				String dataType = ws.getString(2);
				// String columnReturnTypeName = rs.getString(7);
				// int columnPrecision = rs.getInt(8);
				// int columnByteLength = rs.getInt(9);
				// short columnScale = rs.getShort(10);
				// short columnRadix = rs.getShort(11);
				// short columnNullable = rs.getShort(12);
				// String columnRemarks = rs.getString(13);
				
				
				
				if (columnName.equals("ERR")) 
				{

					//cstmt.registerOutParameter(columnName,java.sql.Types.VARCHAR);
					daoObj.setProcOutValue(procIndex, columnName, 1);	
				 

				} else if (dataType.equalsIgnoreCase("REF CURSOR")) 
				{

					//cstmt.registerOutParameter(columnName, OracleTypes.CURSOR);
					daoObj.setProcOutValue(procIndex, columnName, 2);	
					 

				}else if (columnName.equals("HOSP_CODE")) 
				{

					//cstmt.setString(columnName, "999");					 
					daoObj.setProcInValue(procIndex, columnName, "999");
				} 
				else 
				{

					if (strDefaultValues[count] != null	&& strDefaultValues[count].length() > 0) 
					{

						if (strDefaultValues[count].equals("0")) 
						{

							//cstmt.setString(columnName, "1");
							daoObj.setProcInValue(procIndex, columnName, "1");
							 

						} 
						else 
						{

							//cstmt.setString(columnName,strDefaultValues[count]);
							daoObj.setProcInValue(procIndex, columnName, strDefaultValues[count]);
						}

					} else {
						//cstmt.setString(columnName, "1");
						daoObj.setProcInValue(procIndex, columnName, "1");
						//strProcCallMide = strProcCallMide + columnName + "=>1";
					}

					count = count + 1;

				}
			}

			daoObj.executeProcedure(procIndex);
			String err = daoObj.getString(procIndex, "ERR");
			if (err == null) err = "";
			
			if (!err.equals("")) throw new Exception(err);
			
			ws = daoObj.getWebRowSet(procIndex, "RESULTSET");
			
			/*
			cstmt.execute();

			String err = (String) cstmt.getString("ERR");
			ResultSet rs1 = (ResultSet) cstmt.getObject("RESULTSET");

			if (err == null) {

				rs = rs1;

			} else {

				throw new Exception(err);
			}
			*/

		} catch (Exception e) {
			throw e;
		} 

		return ws;

	}

	@SuppressWarnings("unchecked")
	private static ArrayList<String> getExcelHeader(
			ImportExportTemplateMstFB formBean) {

		ArrayList<String> columnList = null;

		InputStream inputStream = null;

		POIFSFileSystem fileSystem = null;

		int count = 0;

		try {

			columnList = new ArrayList<String>();
			inputStream = formBean.getStrExcelFilePath().getInputStream();

			fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<HSSFRow> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				HSSFRow row = rows.next();

				Iterator<HSSFCell> cells = row.cellIterator();

				while (cells.hasNext()) {

					count = count + 1;

					HSSFCell cell = cells.next();

					switch (cell.getCellType()) {

					case HSSFCell.CELL_TYPE_NUMERIC: {

						columnList.add(String.valueOf(cell
								.getNumericCellValue()
								+ "^" + ( cell.getCellNum() + 1 )));
						columnList.add(String.valueOf(cell
								.getNumericCellValue()));

						break;
					}

					case HSSFCell.CELL_TYPE_STRING: {

						String richTextString = cell.getStringCellValue();
						columnList.add(richTextString + "^" + ( cell.getCellNum() + 1 ));
						columnList.add(richTextString);

						break;
					}

					default: {

						columnList.add("Column" + count + "^" + count);
						columnList.add("Column" + count);

						break;
					}

					}

				}

				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return columnList;

	}

	
}
