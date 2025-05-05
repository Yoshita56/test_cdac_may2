package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.ExportRecordsTransBO;
import mms.transactions.controller.fb.ExportRecordsTransFB;
import mms.transactions.controller.hlp.ExportRecordsTransHLP;
import mms.transactions.vo.ExportRecordsTransVO;

/**
 * Developer : Balasubramaniam M  
 * Version : 1.0 
 * Date : 23/June/2009
 * 
 */
public class ExportRecordsTransDATA {

	public static void getExportTemplateList(HttpServletRequest request,
			ExportRecordsTransFB formBean) {
		HisUtil util = null;
		ExportRecordsTransBO bo = null;
		ExportRecordsTransVO vo = null;
		try {

			util = new HisUtil("MMS", "ImportRecordsTransDATA");
			vo = new ExportRecordsTransVO();
			bo = new ExportRecordsTransBO();

			 formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			 formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			//formBean.setStrHospitalCode("108");
			//formBean.setStrSeatId("10001");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrTemplateType("2");
			vo.setStrProcedureType("PROC%");
			//("Template ID:::"+request.getParameter("templateId"));
			String strTemplateId = request.getParameter("templateId");
              
			vo.setStrTemplateId(strTemplateId);
			
			bo.getExportTemplateList(vo);

			if (vo.getWsTemplateList() != null
					&& vo.getWsTemplateList().size() > 0) 
			{

				formBean.setStrTemplateValues(util.getOptionValue(vo.getWsTemplateList(), "0", "0^Select Value", false));

			} else {

				formBean
						.setStrTemplateValues("<option value='0'>Select Value</option>");

			}
			//("O/P:::"+formBean.getStrTemplateValues());

		} catch (Exception _e) {

			HisException eObj = new HisException("MMS",
					"ExportRecordsTransDATA->getExportTemplateList()", _e
							.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void exportRecords(HttpServletRequest request,
			HttpServletResponse response, ExportRecordsTransFB formBean) {

		String strProcMid = "";
		String strProcStart = "";
		String strProcCall = "";

		ExportRecordsTransBO bo = null;
		ExportRecordsTransVO vo = null;
		try {

			 formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			 formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			//formBean.setStrHospitalCode("108");
			//formBean.setStrSeatId("10001");

			vo = new ExportRecordsTransVO();
			bo = new ExportRecordsTransBO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			String[] strTempleteDetails = formBean.getStrTemplate().replace("^", "#").split("#");
			
			formBean.setStrTableWidth(strTempleteDetails[2]);
			formBean.setStrTableWidthUnit(strTempleteDetails[3]);
			formBean.setStrIsBorderReq(strTempleteDetails[4]);

			strProcStart = "{ call PKG_IMP_EXP_UTIL."

								+ strTempleteDetails[1]
					+ "( ";

			for (int i = 0 , stopI = formBean.getStrInParamName().length + 2; i <= stopI ; i++) {

				if (i == 0) {
					strProcMid = strProcMid + "? ";
				} else {
					strProcMid = strProcMid + " , ? ";
				}

			}
			
			//("formBean.getStrTemplate():::"+formBean.getStrTemplate());
			String strTemplateName = formBean.getStrTemplate().replace("^", "#").split("#")[1];

			strTemplateName = strTemplateName.replace(" ", "_");
			
			strProcCall = strProcStart + strProcMid + ") }";

			vo.setStrCallProcedure(strProcCall);

			
			
			vo.setStrInParamName(formBean.getStrInParamName());
			vo.setStrInConstantValue(formBean.getStrInConstantValue());

			bo.exportRecords(vo);

			String strExportContents = "";

			if (formBean.getStrExportType().equals("2")) {

				strExportContents = ExportRecordsTransHLP
						.exportHTML(formBean.getStrReportName() , vo.getWsExportedDatas(), formBean);

				response.setHeader("Content-Disposition",
						"filename="+formBean.getStrReportName().replace(" ", "_")+".html");

							
				response.getOutputStream().write(strExportContents.getBytes());

			} else if (formBean.getStrExportType().equals("3")) {

				strExportContents = ExportRecordsTransHLP
						.exportHTML(formBean.getStrReportName(), vo.getWsExportedDatas(), formBean);

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
					"attachment; filename="+formBean.getStrReportName().replace(" ", "_")+".pdf");

				//response.getOutputStream().write(generatePDFDocumentBytes(request, strExportContents,"", formBean.getStrFooter()).toByteArray());

				//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strExportContents);
				
		//	OutputStream out = response.getOutputStream();

				 
			
		//	out.write(HTMLToPDFUTIL.convertHtmlToPDFDirect(request,
		//			strExportContents).toByteArray());
//			out.write(generatePDFDocumentBytes(request, strExportContents, "", "").toByteArray());
			

			} else {

				HSSFWorkbook workBook = createXLS(vo.getWsExportedDatas(),
						formBean.getStrXlsColumnName(), formBean
								.getStrOutParamName() , formBean.getStrGrandTotalStatus(), formBean.getStrXlsColumnIndex());

				response.setContentType("application/xls");
				response.setHeader("Content-Disposition",
						"attachment; filename="+formBean.getStrReportName().replace(" ", "_")+".xls");

				workBook.write(response.getOutputStream());

			}

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ExportRecordsTransDATA->exportRecords()", e.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void getParamDtls(HttpServletRequest request,
			HttpServletResponse response, ExportRecordsTransFB formBean) {

		ExportRecordsTransBO bo = null;
		ExportRecordsTransVO vo = null;
		try {

			String strTemplateId = (String) request
					.getParameter("strTemplateId");

			String strTemplateType = (String) request
					.getParameter("strTemplateType");

			 formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			 formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			//formBean.setStrHospitalCode("108");
			//formBean.setStrSeatId("10001");

			vo = new ExportRecordsTransVO();
			bo = new ExportRecordsTransBO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrTemplateId(strTemplateId);
			vo.setStrTemplateType(strTemplateType);

			bo.getParamDetails(vo);

			String strMappingContenst = ExportRecordsTransHLP
					.getTemplateDetails(vo.getWsTemplateDetails(), vo.getStrHospitalCode());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strMappingContenst);

		} catch (Exception e) {

			e.printStackTrace();

			HisException eObj = new HisException("MMS",
					"ExportRecordsTransDATA->getParamDtls()", e.getMessage());
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	/*private static ByteArrayOutputStream generatePDFDocumentBytes(
			final HttpServletRequest req, String strContent, String strTitle,
			String strFooter) throws DocumentException

	{
		Document doc = new Document();

		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
		PdfWriter docWriter = null;

		try {
			docWriter = PdfWriter.getInstance(doc, baosPDF);

			doc.addAuthor("");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("");
			doc.addTitle(strTitle);
			// doc.addKeywords("pdf, itext, Java, open source, http");

			doc.setPageSize(PageSize.A4);

			doc.open();

			doc.add(new Paragraph(strContent));

		} catch (DocumentException dex) {
			baosPDF.reset();
			throw dex;
		} finally {
			if (doc != null) {
				doc.close();
			}
			if (docWriter != null) {
				docWriter.close();
			}
		}

		if (baosPDF.size() < 1) {
			throw new DocumentException("document has " + baosPDF.size()
					+ " bytes");
		}
		return baosPDF;
	}*/

	private static HSSFWorkbook createXLS(WebRowSet ws, String[] strHeader,
			String[] strOutParam , String[] isGrandTotal , String[] columnIndex) throws Exception{

		HSSFWorkbook dataWorkbook = null;
		HSSFSheet dataSheet = null;

		int rowCount = 0;

		double[] dTotal = new double[strOutParam.length];
		
		try {

			dataWorkbook = new HSSFWorkbook();
			dataSheet = dataWorkbook.createSheet("Sheet 1");

			if (strHeader != null && strHeader.length > 0) {

				HSSFRow headerRow = dataSheet.createRow((short) rowCount);

				rowCount = rowCount + 1;

				for (int i = 0 , stopI = strHeader.length; i < stopI; i++) {

					headerRow.createCell((short) i).setCellValue(strHeader[(Integer.parseInt(columnIndex[i]) - 1)]);

				}

			}

			  				
				
			 
			
			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					HSSFRow newRow = dataSheet.createRow((short) rowCount);
					rowCount = rowCount + 1;

					for (int i = 0 , stopI = strOutParam.length; i < stopI; i++) {

						String strVal = ws.getString(strOutParam[(Integer.parseInt(columnIndex[i]) - 1 ) ]);

						if (NumberUtils.isNumber(strVal)) {

							HSSFCell cell = newRow.createCell((short) i);
							cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
							cell.setCellValue( Double.parseDouble(strVal));

							dTotal[i] = dTotal[i] + Double.parseDouble(strVal);
							
						} else {

							newRow.createCell((short) i).setCellValue(strVal);

							dTotal[i] = 0;
							
						}

					}

				}

			}

	if(isGrandTotal != null){
		
		HSSFRow newRow = dataSheet.createRow((short) rowCount);
		
for (int i = 0 , stopI = isGrandTotal.length; i <stopI ; i++) {
				
				if( Integer.parseInt(isGrandTotal[i]) == 1){
					
					HSSFCell cell = newRow.createCell((short) i);
					cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					cell.setCellValue(dTotal[i]);
					
				}else{
					
					newRow.createCell((short) i).setCellValue("");
				}
				
			}
	}
		} catch (Exception e) {
			 throw e;
		}

		return dataWorkbook;
	}

}
