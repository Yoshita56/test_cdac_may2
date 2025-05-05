package mms.masters.controller.hlp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.rowset.WebRowSet;

import mms.masters.controller.fb.ImportExportTemplateMstFB;

public class ImportExportTemplateMstHLP {

	public static String getImportTemplateParamMappingList(
			String excelHeaderOptions, ResultSet rs) throws Exception {

		StringBuffer sb = new StringBuffer("");

		int count = 0;

		try {

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='TITLE'> ");
			sb.append("<td colspan='3'>Parameter Mapping ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='multiLabel' width='35%'>Parameter Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='35%'>XLS Column Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='30%'>Constant Values ");
			sb.append("</td> ");
			sb.append("</tr> ");

			while (rs.next()) {

				count = count + 1;

				String strColumnName = rs.getString(1);
				//int nIsNull = rs.getShort(12);
				int nIsNull = 1;

							
				if ( !strColumnName.trim().equalsIgnoreCase("COUNTER") && !strColumnName.trim().equalsIgnoreCase("IMPEXPTYPE") 
					 && !strColumnName.trim().equalsIgnoreCase("TEMPNAME") && !strColumnName.trim().equalsIgnoreCase("IPADDR")
					 && !strColumnName.trim().equalsIgnoreCase("SEATID") && !strColumnName.trim().equalsIgnoreCase("HOSP_CODE")	
					  && !strColumnName.trim().equalsIgnoreCase("ERR") && !strColumnName.trim().equalsIgnoreCase("RESULTSET")
						) {

					sb.append("<tr>");
					sb.append("<td class='multiControl' width='35%' >");

					if (nIsNull == 0) {
						sb.append("<font color='red'>*</font>");
					}
					sb
							.append("<input type='hidden' name='strProcColumnDtls' value='"
									).append( strColumnName ).append( "^" ).append( nIsNull ).append( "' >");
					sb.append(strColumnName);

					sb.append("</td>");

					sb
							.append("<td class='multiControl'  width='35%' ><select name='strExcelHeaderNames' class='comboNormal' id='strExcelHeaderNamesDivId"
									).append( count
									).append( "'  onChange='disabledConstant(this, \""
									).append( count
									).append( "\");' ><option value='0'>"
									).append( excelHeaderOptions
									).append( "</option> </select>");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='30%' >");
					sb
							.append("<input type='text' name='strConstantValue' id='strConstantValueDivId"
									).append( count
									).append( "'  class='txtFldNormal'   onkeypress='return validateData(event,9);' >");
					sb.append("</td>");
					sb.append("</tr>");

				}
			}

			sb.append("</table>");

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	public static String getExportTemplateParamDefaultValList(WebRowSet rs)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		int count = 0;

		try {

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='TITLE'> ");
			sb.append("<td colspan='3'>Parameter Mapping ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='multiLabel' width='40%'>Parameter Name ");
			sb.append("</td> ");
			sb
					.append("<td class='multiLabel' width='30%'><font color='red'>*</font>Default Values ");
			sb.append("</td> ");
			sb
			.append("<td class='multiLabel' width='30%'>Type");
			sb.append("</td> ");
	
			sb.append("</tr> ");

			while (rs.next()) {

			
				String strColumnName = rs.getString(1);
				//int nIsNull = rs.getShort(12);
				int nIsNull = 1;
				////System.out.println("Ajay Gupta:::"+nIsNull);
				
				count = count + 1;

				if (!strColumnName.trim().equalsIgnoreCase("SEATID") && !strColumnName.trim().equalsIgnoreCase("HOSP_CODE")
						&& !strColumnName.trim().equalsIgnoreCase("ERR")
						&& !strColumnName.trim().equalsIgnoreCase("RESULTSET")) {

					sb.append("<tr>");
					sb.append("<td class='multiControl' width='40%' >");
					
					sb
							.append("<input type='hidden' name='strProcInColumnDtls' value='"
									).append( strColumnName ).append( "^" ).append( nIsNull ).append( "' >");
					sb.append(strColumnName);

					sb.append("</td>");

					sb.append("<td class='multiControl' width='30%' >");
					sb
							.append("<input type='text' name='strInConstantValue' id='strInConstantValueDivId"
									).append( count
									).append( "'  class='txtFldNormal' value='0'   onkeypress='return validateData(event,9);' >");
					sb.append("</td>");
					
					sb.append("<td class='multiControl' width='30%' >");
					sb.append("<select name='strParamCompType' id='strParamCompType").append(count).append("' class='comboNormal' onChange='getQuery(this , \"").append(count).append("\");'><option value='0'>Fixed</option><option value='1'>Text Box</option><option value='2'>Combo Box</option></select>");
					sb.append("<input type='hidden' name='strComboQuery' id='strComboQuery").append(count).append("' value=''></td>");
					sb.append("</tr>");

				}
			}

			sb.append("</table>");

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	public static String getExportTemplateParamMappingList(
			ImportExportTemplateMstFB formBean, ResultSet rs) throws Exception {

		ResultSetMetaData rsmd = rs.getMetaData();

		StringBuffer sb = new StringBuffer("");

		int colCount = rsmd.getColumnCount();

		try {

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='TITLE'> ");
			sb.append("<td colspan='3'>Input Parameter ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='multiLabel' width='30%'>Parameter Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='30%'><font color='red'>*</font>Display Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='40%'>Default Values ");
			sb.append("</td> ");
			sb.append("</tr> ");

			for (int i = 0 , stopI = formBean.getStrProcInColumnDtls().length; i < stopI; i++) {

				sb.append("<tr> ");
				sb.append("<td class='multiControl' width='30%'>");
				sb
						.append("<input type='hidden' name='strProcInColumnDtls' value='"
								).append( formBean.getStrProcInColumnDtls()[i] ).append( "' >");
				sb.append(formBean.getStrProcInColumnDtls()[i]
						.replace("^", "#").split("#")[0]);
				sb.append("");
				sb.append("</td> ");
				
				sb.append("<td class='multiControl' width='30%'>");
				
				if(!formBean.getStrParamCompType()[i].equals("0")){
					
					if(formBean.getStrParamCompType()[i].equals("1")){
						
						sb.append("<input type='text' name='strParamDispalyName' value='' onkeypress='return validateData(event,4);' >");
						
					}else{
						
						sb.append("<input type='text' name='strParamDispalyName' value='' onkeypress='return validateData(event,4);' >");
					}
					
				}else{
					
					sb.append("<input type='hidden' name='strParamDispalyName' value='").append(formBean.getStrProcInColumnDtls()[i]
					                                                                              						.replace("^", "#").split("#")[0]).append("'>");
					
				}
				sb.append("</td> ");
				
				sb.append("<td class='multiControl' width='40%'>");
				
				if(!formBean.getStrParamCompType()[i].equals("0")){
					
					if(formBean.getStrParamCompType()[i].equals("1")){
						
						sb.append("Text Box");
						
					}else{
						
						sb.append("Combo Box");
					}
					
				}else{
					
					sb.append(formBean.getStrInConstantValue()[i]);
					
				}
				
				
				sb
						.append("<input type='hidden' name='strInConstantValue' value='"
								).append( formBean.getStrInConstantValue()[i] ).append( "' >");
				
				sb
				.append("<input type='hidden' name='strParamCompType' value='"
						).append( formBean.getStrParamCompType()[i] ).append( "' >");
				
				sb
				.append("<input type='hidden' name='strComboQuery' value=\""
						).append( formBean.getStrComboQuery()[i] ).append( "\" >");
				
				sb.append("</td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='TITLE'> ");
			sb.append("<td colspan='3'>Parameter Mapping ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='multiLabel' width='35%'>Parameter Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='35%'>XLS Column Index ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='30%'>XLS Column Header");
			sb.append("</td> ");
			sb.append("</tr> ");

			for (int i = 1; i <= colCount; i++) {

				String strColumnName = rsmd.getColumnName(i);
				
								
						sb.append("<tr>");
						sb.append("<td class='multiControl' width='35%' >");
		
						sb
								.append("<input type='hidden' name='strProcOutColumnDtls' value='"
										).append( strColumnName ).append( "' >");
						sb.append(strColumnName);
		
						sb.append("</td>");
		
						sb.append("<td class='multiControl'  width='35%' >");
						sb
								.append("<input type='hidden' name='strProcOutColumnIndex' value='"
										).append( (i) ).append( "' >");
						sb.append(i);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='30%' >");
						sb
								.append("<input type='text' name='strExcelHeader'  class='txtFldNormal'   onkeypress='return validateData(event,9);' >");
						sb.append("</td>");
						sb.append("</tr>");

				
			}
			sb.append("</table>");

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	public static String getParamMappedList(ImportExportTemplateMstFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			
			sb
			.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
	sb.append("<tr class='TITLE'>");
	sb.append("<td colspan='3'>Parameter Mapping Details");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("<tr>");
	sb.append("<td class='multiLabel' width='35%'>Parameter Name");
	sb.append("</td>");
	sb.append("<td class='multiLabel' width='35%'>XLS Column Name");
	sb.append("</td>");
	sb.append("<td class='multiLabel' width='30%'>Constant Values");
	sb.append("</td>");
	sb.append("</tr>");

			for (int i = 0 , stopI = formBean.getStrProcColumnDtls().length; i < stopI; i++) {

				String temp[] = formBean.getStrProcColumnDtls()[i].replace("^",
						"#").split("#");

				sb
						.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='multiControl' width='35%' >");
				sb
						.append("<input type='hidden' name='strProcColumnDtls' value='"
								).append( formBean.getStrProcColumnDtls()[i] ).append( "' >");
				sb.append(temp[0]);

				sb.append("</td>");
				sb
						.append("<td class='multiControl'  width='35%' ><input type='hidden' name='strExcelHeaderNames' value='"
								).append( formBean.getStrExcelHeaderNames()[i] ).append( "' >");
				if (formBean.getStrExcelHeaderNames()[i].length() <= 1) {
					sb.append("---");
				} else {
					sb.append(formBean.getStrExcelHeaderNames()[i].replace("^",
							"#").split("#")[0]);
				}

				sb.append("</td>");
				sb.append("<td class='multiControl' width='30%' >");
				sb
						.append("<input type='hidden' name='strConstantValue'  value='"
								).append( formBean.getStrConstantValue()[i] ).append( "'   >");
				sb.append(formBean.getStrConstantValue()[i]);
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	public static String getTemplateDetails(WebRowSet ws, String strTemplateType)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		StringBuffer sb2 = new StringBuffer("");

		boolean flag = true;

		if (strTemplateType.equals("1")) {

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class='TITLE'>");
			sb.append("<td colspan='4'>Parameter Mapping Details");
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='30%'>Parameter Name");
			sb.append("</td>");
			sb.append("<td class='multiLabel' width='10%'>XLS Column Index");
			sb.append("</td>");
			sb.append("<td class='multiLabel' width='30%'>XLS Column Name");
			sb.append("</td>");
			sb.append("<td class='multiLabel' width='30%'>Constant Values");
			sb.append("</td>");
			sb.append("</tr>");

		} else {

			sb
					.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class='TITLE'>");
			sb.append("<td colspan='2'>Input Parameter Details");
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='50%'>Parameter Name");
			sb.append("</td>");
			sb.append("<td class='multiLabel' width='50%'>Constant Values");
			sb.append("</td>");
			sb.append("</tr>");

			
			sb2
			.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
			sb2.append("<tr class='TITLE'>");
			sb2.append("<td colspan='4'>Parameter Mapping Details");
			sb2.append("</td>");
			sb2.append("</tr>");
			sb2.append("<tr>");
			sb2.append("<td class='multiLabel' width='30%'>Parameter Name");
			sb2.append("</td>");
			sb2.append("<td class='multiLabel' width='10%'>XLS Column Index");
			sb2.append("</td>");
			sb2.append("<td class='multiLabel' width='30%'>XLS Column Name");
			sb2.append("</td>");
			sb2.append("<td class='multiLabel' width='30%'>Constant Values");
			sb2.append("</td>");
			sb2.append("</tr>");

		}

		try {

			if (ws != null && ws.size() > 0){
				while (ws.next()) {

					if (strTemplateType.equals("1")) {

						sb.append("<tr>");
						sb.append("<td class='multiControl' width='30%' >");

						sb.append(ws.getString(1));

						sb.append("</td>");
						sb.append("<td class='multiControl'  width='10%' >");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td class='multiControl'  width='30%' >");
						sb.append(ws.getString(3));
						sb.append("</td>");
						sb.append("<td class='multiControl' width='30%' >");
						sb.append(ws.getString(4));
						sb.append("</td>");
						sb.append("</tr>");

					} else {

						if (ws.getString(5).trim().equals("1")) {

							sb.append("<tr>");
							sb.append("<td class='multiControl' width='50%' >");
							sb.append(ws.getString(1));
							sb.append("</td>");
							sb.append("<td class='multiControl' width='50%' >");
							sb.append(ws.getString(4));
							sb.append("</td>");
							sb.append("</tr>");

						} else {
							
							if (flag) {

								sb.append("</table>");
								
								sb.append(sb2.toString());
								flag = false;

							}

							sb.append("<tr>");
							sb.append("<td class='multiControl' width='30%' >");

							sb.append(ws.getString(1));

							sb.append("</td>");
							sb
									.append("<td class='multiControl'  width='10%' >");
							sb.append(ws.getString(2));
							sb.append("</td>");
							sb
									.append("<td class='multiControl'  width='30%' >");
							sb.append(ws.getString(3));
							sb.append("</td>");
							sb.append("<td class='multiControl' width='30%' >");
							sb.append(ws.getString(4));
							sb.append("</td>");
							sb.append("</tr>");

						}

					}

				}
			 
				sb.append("</table>");
				
				}else {

				sb
						.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='multiControl'  colspan='4' style='color:red'>No Detail(s) Available");
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

}
