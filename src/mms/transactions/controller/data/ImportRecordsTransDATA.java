package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.ImportRecordsTransBO;
import mms.transactions.controller.fb.ImportRecordsTransFB;
import mms.transactions.controller.hlp.ImportRecordsTransHLP;
import mms.transactions.vo.ImportRecordsTransVO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


/**
 * Developer : Balasubramaniam M  
 * Version : 1.0 
 * Date : 23/June/2009
 * 
 */

public class ImportRecordsTransDATA {

	/**
	 * gets the import template list for combo 
	 * @param request
	 * @param formBean
	 */
	public static void getImportTemplateList(HttpServletRequest request,
			ImportRecordsTransFB formBean) {
		HisUtil util = null;
		ImportRecordsTransBO bo = null;
		ImportRecordsTransVO vo = null;
		try {

			util = new HisUtil("MMS", "ImportRecordsTransDATA");
			vo = new ImportRecordsTransVO();
			bo = new ImportRecordsTransBO();

		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		 formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		//formBean.setStrHospitalCode("108");
		// formBean.setStrSeatId("10001");
			  
		 	
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrTemplateType("1");
			vo.setStrProcedureType("DML%");
			
			bo.getImportTemplateList(vo);

			if (vo.getWsTemplateList() != null
					&& vo.getWsTemplateList().size() > 0) {

				formBean.setStrTemplateValues(util.getOptionValue(vo
						.getWsTemplateList(), "0", "0^Select Value", false));

			} else {

				formBean
						.setStrTemplateValues("<option value='0'>Select Value</option>");

			}

			 
		} catch (Exception _e) {

			HisException eObj = new HisException("MMS",
					"ImportRecordsTransDATA->getImportTemplateList()", _e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
	
	/**
	 * import the records from excel to Database
	 * @param request
	 * @param formBean
	 */
	public static void importRecords(HttpServletRequest request,
			ImportRecordsTransFB formBean){
		
		
		ArrayList<String[]> excelContents = null;
	
		String strProcMid = "";
		String strProcStart = "";
		String strProcCall = "";
		
		ImportRecordsTransBO bo = null;
		ImportRecordsTransVO vo = null;
		try {

			vo = new ImportRecordsTransVO();
			bo = new ImportRecordsTransBO();
			
			
			formBean.setStrHospitalCode(request.getSession().getAttribute(
			"HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
			.toString());
			formBean.setStrIpAddress(request.getSession().getAttribute(
			"IP_ADDR").toString());
	
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrIpAddress(formBean.getStrIpAddress());
			
			vo.setStrConstantValue(formBean.getStrConstantValue());
			vo.setStrParamName(formBean.getStrParamName());
			vo.setStrXlsColumnIndex(formBean.getStrXlsColumnIndex());
			vo.setStrXlsColumnName(formBean.getStrXlsColumnName());
			vo.setStrTemplateName(formBean.getStrTemplateName());
			vo.setStrTemplateType("1");
			vo.setStrTemplate(formBean.getStrTemplate());
			
			
			excelContents = getExcelContents(formBean);
			
			vo.setStrExcelContents(excelContents);
			
			  strProcStart = "{ call PKG_IMP_EXP_UTIL."+formBean.getStrTemplate().replace("^", "#").split("#")[1] + "( ";

						
			for (int i = 0 , stopI = formBean.getStrParamName().length + 6; i <=stopI ; i++) {
				
				if (i == 0) {
					strProcMid = strProcMid + "? ";
				} else {
					strProcMid = strProcMid + " , ? ";
				}
				
				
			}
						
			  strProcCall = strProcStart + strProcMid + ") }";
			
			  vo.setStrCallProcedure(strProcCall);
			  
			bo.importRecords(vo);
			  

			if(vo.getStrMsgType().equals("1")){
				
				throw new Exception(vo.getStrMsgString());
				
			}else{
				
				
				String strMsg = vo.getStrMsgErrString();
				
				String[] temp = strMsg.split("@@");
				
				if(temp.length > 0 && temp[0].trim().length() > 0){
					
					formBean.setStrMsg(temp[0]);
					
				}
				
				if(temp.length > 1 && temp[1].trim().length() > 0){
					
					formBean.setStrErrorMsg(temp[1]);
				}
				
				
			}
			
			 
		} catch (Exception _e) {

			_e.printStackTrace();
			
			HisException eObj = new HisException("MMS",
					"ImportRecordsTransDATA->getImportTemplateList()", _e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		
		
		
	}
	/**
	 * retrieves the parameter details. when template is selected.
	 * @param request
	 * @param response
	 * @param formBean
	 */
	public static void getParamDtls(HttpServletRequest request,
			HttpServletResponse response, ImportRecordsTransFB formBean) {

		ImportRecordsTransBO bo = null;
		ImportRecordsTransVO vo = null;
		try {

			String strTemplateId = (String) request
					.getParameter("strTemplateId");

			String strTemplateType = (String) request
			.getParameter("strTemplateType");
			
			 formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			 formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			 formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
			 
			 //formBean.setStrHospitalCode("108");
			// formBean.setStrSeatId("10001");
			
			vo = new ImportRecordsTransVO();
			bo = new ImportRecordsTransBO();

			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrTemplateId(strTemplateId);
			vo.setStrTemplateType(strTemplateType);
			
			bo.getParamDetails(vo);

			String strMappingContenst = ImportRecordsTransHLP
					.getTemplateDetails(vo.getWsTemplateDetails() , vo.getStrTemplateType());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strMappingContenst);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ImportRecordsTransDATA->getParamDtls()", e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
	

	/**
	 * retrieves the excel content in the array list.
	 * @param formBean
	 * @return array list object which contains excel content.
	 */

	@SuppressWarnings("unchecked")

	private static ArrayList<String[]> getExcelContents(ImportRecordsTransFB formBean) {

		ArrayList<String[]> columnList = null;

		String[] columnContenst = null;
		
		InputStream inputStream = null;

		POIFSFileSystem fileSystem = null;

		int count = 0;
		
		int mycontent = 0;
		
		try {

			 
			
			columnList = new ArrayList<String[]>();
			inputStream = formBean.getStrExcelFilePath().getInputStream();

			fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<HSSFRow> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				HSSFRow row = rows.next();

				columnContenst = new String[formBean.getStrParamName().length];
				mycontent = 0;
				
				for (int i = 0 , stopI = formBean.getStrParamName().length; i < stopI; i++) {
					
					count = count + 1;
					
					if(!formBean.getStrXlsColumnIndex()[i].equals("0")){
						
						//System.out.print("getStrXlsColumnIndex : "+formBean.getStrXlsColumnIndex()[i]);
						
					short cellNo = Short.valueOf(formBean.getStrXlsColumnIndex()[i]);
					
					//System.out.print("\tcell No: "+cellNo+" \t act cell no : "+( cellNo - 1 ));
					
									
					HSSFCell cell = row.getCell((short)(cellNo - 1));
					
				 		
			
					switch (cell.getCellType()) {

					case HSSFCell.CELL_TYPE_NUMERIC: {

						columnContenst[mycontent] = String.valueOf(cell
								.getNumericCellValue());
						
										
						mycontent = mycontent + 1;
						
						break;
					}

					case HSSFCell.CELL_TYPE_STRING: {

						String richTextString = cell.getStringCellValue();
					
						columnContenst[mycontent] =  richTextString ;

											
						mycontent = mycontent + 1;
						
						break;
					}

					case HSSFCell.CELL_TYPE_BLANK: {

						columnContenst[mycontent] =  "" ;

						mycontent = mycontent + 1;
						
						break;
					}
					
					default: {

						columnContenst[mycontent] =  " " ;

						mycontent = mycontent + 1;
						break;
					}

					}

					}else{
						
						columnContenst[mycontent] =  " " ;
						mycontent = mycontent + 1;
					}
					
					//System.out.print("content :  "+columnContenst[mycontent - 1].toString()+" \n");
					
				}

				
				
				columnList.add(columnContenst);
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

			
		return columnList;

	}
	
}
