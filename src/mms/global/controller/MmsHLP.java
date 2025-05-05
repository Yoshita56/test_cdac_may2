package mms.global.controller;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.global.dao.MmsDAO;
import mms.global.vo.MmsVO;

import java.math.BigDecimal
;// TODO: Auto-generated Javadoc
/**
 * The Class MmsHLP.
 */
public class MmsHLP {

	/** The Constant strColor. */
	private static final String strColor = "red";

	/** The Constant defaultColor. */
	private static final String defaultColor = "blue";
	
	/**
	 * Gets the parent param view.
	 * 
	 * @param ws
	 *            the ws
	 * @param mode
	 *            the mode
	 * @param strViewMode
	 *            the str view mode
	 * @param strDivIdName
	 *            the str div id name
	 * 
	 * @return the parent param view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getParentParamView(WebRowSet ws, String mode,
			String strViewMode, String strDivIdName) throws Exception {

		StringBuffer sb = new StringBuffer("");

		if (mode.equals("1")) {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class='HEADER'>");
			
			if(!strViewMode.equals("2")){
			
				sb.append("<td colspan='2'>Item Parameter Details</td>");
			}else{
				
				sb.append("<td width='90%'>Drug Parameter Details</td>");
				sb.append("<td width='5%'><img style='cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onclick='hideParamPopup();'></td>");
			}
			
			
			sb.append("</tr>");
			sb.append("</table>");

		}

		try {

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

						sb
								.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px' > ");
						sb.append("<tr class='TITLE'> ");
						sb.append("<td width='3%'> ");
						sb.append("<div id='plusParameterId" + count
								+ "' align='center'> ");
						sb
								.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
						
						
						if(!strViewMode.equals("2")){
							
							sb
							.append("onclick='fetchParameterDetails(\"ParameterId"
									+ count
									+ "\" , \""
									+ count
									+ "\" ,\""
									+ ws.getString(1) + "\");' /></div> ");
					
							
						}else{
							
							sb
							.append("onclick='getParameterDtlsInViewMode(\"ParameterId"
									+ count
									+ "\" , \""
									+ count
									+ "\" ,\""
									+ ws.getString(1) + "\");' /></div> ");
					
							
						}
						
						
						
						
						
						sb
								.append("<div id='minusParameterId"
										+ count
										+ "' style='display: none' align='center'><img ");
						sb
								.append("src='../../hisglobal/images/minus.gif'  name='minusParameter'></div> ");
						sb.append("</td> ");
						sb.append("<td width='2%'> ");
						sb.append("<b><span id='patParamEntryDivId" + count
								+ "' style='display:none'>*</span></b> ");
						sb.append("</td> ");
						sb
								.append("<td> <input type='hidden' name='strOpenStatus' id='strOpenStatus"
										+ count + "' value='0'>");
						sb.append(ws.getString(2));
						sb
								.append("<input type='hidden' name='strIsParamFetch' id='strIsParamFetch"
										+ count + "' value='0'/>");
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table>	");
						sb.append("<div id='ParameterId" + count
								+ "' style='display: none'>");
						sb.append("</div> ");

						sb
								.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px'>");
						sb.append("<tr>");
						sb.append("<td height='1px'></td>");
						sb.append("</tr>");
						sb.append("</table>");

						count = count + 1;
					}

					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' bgcolor='white'> ");
					sb.append("<tr class='FOOTER'> ");
					sb.append("<td colspan='2'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
					
					if(!strViewMode.equals("2")){
						
						sb.append("<table border='0' width='400' align='center'> ");
						sb.append("<tr> ");
						sb
								.append("<td align='center'><img style='cursor: pointer; ' ");
						sb.append(" src='../../hisglobal/images/btn-sv.png' ");
						sb
								.append(" onClick='saveData(\"itemParameterDtlDivId\");' /> <img style='cursor: pointer; ' ");
						sb
								.append(" src='../../hisglobal/images/close_tab.png' onClick='hidePopup();' /> ");
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
						
					}
					
					
					

				} else {
					sb
							.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px' > ");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
					sb.append("</table>");

					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class='FOOTER'> ");
					sb.append("<td colspan='2'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
					
					if(!strViewMode.equals("2")){
					
						sb
								.append("<table border='0' width='400' align='center' > ");
						sb.append("<tr> ");
						sb
								.append("<td align='center'><img style='cursor: pointer; ' ");
						sb.append(" src='../../hisglobal/images/close_tab.png' ");
	
						sb.append(" onClick='hidePopup();' /> ");
	
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table> ");

					}
					
				}

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}


	
	public static String getParentParamViewNEW(WebRowSet ws, String mode,
			String strViewMode, String strDivIdName) throws Exception {

		StringBuffer sb = new StringBuffer("");

		if (mode.equals("1")) {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class=''>");
			
			if(!strViewMode.equals("2")){
			
				sb.append("<td colspan='2'>Item Parameter Details</td>");
			}else{
				
				sb.append("<td width='90%'>Drug Parameter Details</td>");
				sb.append("<td width='5%'><button type=\"button\" class=\"float-right btn btn-outline-danger mt-1 cancelbtn\" onclick='hideParamPopup();'><i class=\"fas fa-ban iround\" title=\"Cancel\"></i></button></td>");
			}
			
			
			sb.append("</tr>");
			sb.append("</table>");

		}

		try {

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

						sb
								.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px' > ");
						sb.append("<tr class=''> ");
						sb.append("<td width='3%'> ");
						sb.append("<div id='plusParameterId" + count
								+ "' align='center'> ");
						sb
								.append("<i class=\"fas fa-plus-circle\" ");
						
						
						if(!strViewMode.equals("2")){
							
							sb
							.append("onclick='fetchParameterDetails(\"ParameterId"
									+ count
									+ "\" , \""
									+ count
									+ "\" ,\""
									+ ws.getString(1) + "\");'></i></div> ");
					
							
						}else{
							
							sb
							.append("onclick='getParameterDtlsInViewMode(\"ParameterId"
									+ count
									+ "\" , \""
									+ count
									+ "\" ,\""
									+ ws.getString(1) + "\");'></i></div> ");
					
							
						}
						
						
						
						
						
						sb
								.append("<div id='minusParameterId"
										+ count
										+ "' style='display: none' align='center'><img ");
						sb
								.append("src='../../hisglobal/images/minus.gif'  name='minusParameter'></div> ");
						sb.append("</td> ");
						sb.append("<td width='2%'> ");
						sb.append("<b><span id='patParamEntryDivId" + count
								+ "' style='display:none'>*</span></b> ");
						sb.append("</td> ");
						sb
								.append("<td> <input type='hidden' name='strOpenStatus' id='strOpenStatus"
										+ count + "' value='0'>");
						sb.append(ws.getString(2));
						sb
								.append("<input type='hidden' name='strIsParamFetch' id='strIsParamFetch"
										+ count + "' value='0'/>");
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table>	");
						sb.append("<div id='ParameterId" + count
								+ "' style='display: none'>");
						sb.append("</div> ");

						sb
								.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px'>");
						sb.append("<tr>");
						sb.append("<td height='1px'></td>");
						sb.append("</tr>");
						sb.append("</table>");

						count = count + 1;
					}

					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' bgcolor='white'> ");
					sb.append("<tr class=''> ");
					sb.append("<td colspan='2'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
					
					if(!strViewMode.equals("2")){
						
						sb.append("<table border='0' width='400' align='center'> ");
						sb.append("<tr> ");
						sb
								.append("<td align='center'><img style='cursor: pointer; ' ");
						sb.append(" src='../../hisglobal/images/btn-sv.png' ");
						sb
								.append(" onClick='saveData(\"itemParameterDtlDivId\");' /> <img style='cursor: pointer; ' ");
						sb
								.append(" src='../../hisglobal/images/close_tab.png' onClick='hidePopup();' /> ");
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
						
					}
					
					
					

				} else {
					sb
							.append("<div class='row'> ");
					sb
							.append("<div class='col-md-12' align='center'><td class=''><font color='red'>No Record Found</font></td></div>");
					sb.append("</div>");

					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class=''> ");
					sb.append("<td colspan='2'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
					
					if(!strViewMode.equals("2")){
					
						sb
								.append("<table border='0' width='400' align='center' > ");
						sb.append("<tr> ");
						sb
								.append("<td align='center'>");
						sb.append("<button type='button' class='float-right btn btn-outline-info mt-1' title='Close' onClick='hidePopup();'><span>Close</span></button>");

	
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table> ");

					}
					
				}

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}

	
	
	/**
	 * Gets the parent param dtls view.
	 * 
	 * @param ws
	 *            the ws
	 * @param index
	 *            the index
	 * @param strParentParamId
	 *            the str parent param id
	 * 
	 * @return the parent param dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getParentParamDtlsView(WebRowSet ws, String index,
			String strParentParamId) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' > ");
			sb.append("<tr> ");
			sb.append("<td width='5%' class='multiLabel'>#  </td> ");
			sb
					.append("<td width='45%' class='multiLabel'>Parameter Name</td> ");
			sb
					.append("<td width='50%' class='multiLabel'>Parameter Value</td> ");
			sb.append("</tr> ");

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

						String strParamId = ws.getString(1);
						String strParamName = ws.getString(2);
						String strParamType = ws.getString(3);
						String strParamLen = ws.getString(4);

						// validationType varaible is used for javascript
						// validation validateData function index
						int validationType = 0;

						if (strParamType.equals("1")) {
							validationType = 5;
						} else if (strParamType.equals("2")) {
							validationType = 10;
						} else {
							validationType = 8;
						}

						String strChkValue = strParentParamId + "^"
								+ strParamId;

						sb.append("<tr> ");
						sb
								.append("<td width='10%' class='multiControl'><input type='checkbox' id='strParamCheck"
										+ index
										+ ""
										+ count
										+ "' name='strParamCheck' value='"
										+ strChkValue
										+ "' onclick='activateParameter(this, \""
										+ index
										+ "\" ,  \""
										+ count
										+ "\")'></td> ");
						sb.append("<td width='45%' class='multiControl'>"
								+ strParamName + "</td>");
						sb
								.append("<td width='45%' class='multiControl'><input type='text' name='strParamValue' id='strParamValue"
										+ index + "" + count + "'");
						if (strParamLen != null) {
							sb.append(" maxlength=" + strParamLen);
						}
						sb
								.append(" disabled='disabled' onkeypress='return validateData(event,"
										+ validationType + ");'></td>");
						sb.append("</tr>");

						count = count + 1;
					}

					sb.append("<tr> ");
					sb
							.append("<td class='multiControl' colspan='3' align='center'><img style='cursor: pointer; ' ");
					sb.append(" src='../../hisglobal/images/btn-ok.png'");
					sb
							.append(" onClick=' return ok(\"ParameterId\",\""
									+ index
									+ "\" , \"0\");' /> <img style='cursor: pointer; ' ");
					sb
							.append(" src='../../hisglobal/images/close_tab.png' onclick='cancel(\"ParameterId\" , \""
									+ index + "\" , 1);' /> ");
					sb.append("</td> ");
					sb.append("</tr> ");

				} else {
					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
					sb.append("</table>");

					sb
							.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px'> ");
					sb.append("<tr> ");
					sb
							.append("<td class='multiControl' colspan='3' align='center'><img style='cursor: pointer; ' ");
					sb
							.append(" src='../../hisglobal/images/close_tab.png' onclick='cancel(\"ParameterId\" , \""
									+ index + "\" ,  \"1\");' /> ");
					sb.append("</td> ");
					sb.append("</tr> ");

				}

				sb.append("</table>");

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the existing param dtls view.
	 * 
	 * @param ws
	 *            the ws
	 * @param index
	 *            the index
	 * @param strParentParamId
	 *            the str parent param id
	 * 
	 * @return the existing param dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getExistingParamDtlsView(WebRowSet ws, String index,
			String strParentParamId) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class='HEADER'>");
			sb.append("<td colspan='2'>Item Parameter Details </td>");
			sb.append("</tr>");
			sb.append("</table>");

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' > ");
			sb.append("<tr> ");
			sb.append("<td width='5%' class='multiLabel'># ");
			sb
					.append("<td width='45%' class='multiLabel'>Parameter Name</td> ");
			sb
					.append("<td width='50%' class='multiLabel'>Parameter Value</td> ");
			sb.append("</tr> ");

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

						String strParamId = ws.getString(1);
						String strParamSNo = ws.getString(2);
						String strParamValue = ws.getString(3);
						String strParamName = ws.getString(4);
						String strParamType = ws.getString(5);
						String strParamLen = ws.getString(6);

						// validationType varaible is used for javascript
						// validation validateData function index
						int validationType = 0;

						if (strParamType.equals("1")) {
							validationType = 5;
						} else if (strParamType.equals("2")) {
							validationType = 10;
						} else {
							validationType = 8;
						}

						if (strParamValue == null)
							strParamValue = "";

						String strChkValue = strParamId + "^" + strParamSNo;

						sb.append("<tr> ");
						sb.append("<td width='45%' class='multiControl'>");
						sb
								.append("<input type='hidden' id='strParamDtls0"
										+ count
										+ "' name='strParamDtls' value='"
										+ strChkValue
										+ "' > <select id='strParamStatus0"
										+ count
										+ "' name='strParamStatus' onchange='activateParameterByCombo(this, \"0\" ,\""
										+ count + "\");' > ");
						sb
								.append(" <option value='0' >Select Value</option> <option value='1' >Modify</option><option value='2' >Delete</option> </select> ");
						sb.append("</td>");
						sb.append("<td width='45%' class='multiControl'>"
								+ strParamName + "</td>");
						sb
								.append("<td width='45%' class='multiControl'><input type='text' name='strParamValue' id='strParamValue0"
										+ count + "'");
						if (strParamLen != null) {
							sb.append(" maxlength=" + strParamLen);
						}
						sb
								.append(" value='"
										+ strParamValue
										+ "' disabled='disabled' onkeypress='return validateData(event,"
										+ validationType + ");'></td>");
						sb.append("</tr>");

						count = count + 1;
					}

				} else {
					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");

				}

				sb.append("</table>");
				sb
						.append("<div id='itemParameterSubDtlDivId' style='display: none'>");
				sb.append("</div> ");

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the display parent param dtls view.
	 * 
	 * @param ws
	 *            the ws
	 * @param index
	 *            the index
	 * @param strParentParamId
	 *            the str parent param id
	 * 
	 * @return the display parent param dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getDisplayParentParamDtlsView(WebRowSet ws,
			String index, String strParentParamId) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' > ");
			sb.append("<tr> ");
			sb.append("<td width='5%' class='multiLabel'>#  </td> ");
			sb
					.append("<td width='45%' class='multiLabel'>Parameter Name</td> ");
			sb
					.append("<td width='50%' class='multiLabel'>Parameter Value</td> ");
			sb.append("</tr> ");

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

						String strParamId = ws.getString(1);
						String strParamValue = ws.getString(2);
						String strParamName = ws.getString(3);
						String strParamType = ws.getString(4);
						String strParamLen = ws.getString(5);

						// validationType variable is used for JavaScript
						// validation validateData function index
						int validationType = 0;

						if (strParamType.equals("1")) {
							validationType = 5;
						} else if (strParamType.equals("2")) {
							validationType = 10;
						} else {
							validationType = 8;
						}

						if (strParamValue == null)
							strParamValue = "";

						String strChkValue = strParentParamId + "^"
								+ strParamId;

						sb.append("<tr> ");
						sb
								.append("<td width='10%' class='multiControl'><input type='checkbox' id='strParamCheck"
										+ index
										+ ""
										+ count
										+ "' name='strParamCheck' checked='checked' value='"
										+ strChkValue
										+ "' onclick='activateParameter(this, \""
										+ index
										+ "\" ,  \""
										+ count
										+ "\")'></td> ");
						sb.append("<td width='45%' class='multiControl'>"
								+ strParamName + "</td>");
						sb
								.append("<td width='45%' class='multiControl'><input type='text' name='strParamValue' id='strParamValue"
										+ index + "" + count + "'");
						if (strParamLen != null) {
							sb.append(" maxlength=" + strParamLen);
						}
						sb.append(" value='" + strParamValue
								+ "' onkeypress='return validateData(event,"
								+ validationType + ");'></td>");
						sb.append("</tr>");

						count = count + 1;
					}

					sb.append("<tr> ");
					sb
							.append("<td class='multiControl' colspan='3' align='center'><img style='cursor: pointer; ' ");
					sb.append(" src='../../hisglobal/images/btn-ok.png'");
					sb
							.append(" onClick=' return ok(\"ParameterId\",\""
									+ index
									+ "\" , \"1\");' /> <img style='cursor: pointer; ' ");
					sb
							.append(" src='../../hisglobal/images/close_tab.png' onclick='cancel(\"ParameterId\" , \""
									+ index + "\" , 1);' /> ");
					sb.append("</td> ");
					sb.append("</tr> ");

				} else {
					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
					sb.append("</table>");

					sb
							.append("<table width='400' align='center' cellpadding='0px' cellspacing='0px'> ");
					sb.append("<tr> ");
					sb
							.append("<td class='multiControl' colspan='3' align='center'><img style='cursor: pointer; ' ");
					sb
							.append(" src='../../hisglobal/images/close_tab.png' onclick='cancel(\"ParameterId\" , \""
									+ index + "\" ,  \"1\");' /> ");
					sb.append("</td> ");
					sb.append("</tr> ");

				}

				sb.append("</table>");

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}

	
	/**
	 * Gets the display parent param dtls view.
	 * 
	 * @param ws
	 *            the ws
	 * @param index
	 *            the index
	 * @param strParentParamId
	 *            the str parent param id
	 * 
	 * @return the display parent param dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getDisplayParentParamDtlsViewForView(WebRowSet ws,
			String index, String strParentParamId) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {

			sb
					.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px' > ");
			sb.append("<tr> ");
			sb.append("<td width='5%' class='multiLabel'>#  </td> ");
			sb
					.append("<td width='45%' class='multiLabel'>Parameter Name</td> ");
			sb
					.append("<td width='50%' class='multiLabel'>Parameter Value</td> ");
			sb.append("</tr> ");

			if (ws != null) {

				if (ws.size() != 0) {

					int count = 1;

					while (ws.next()) {

					 
						String strParamValue = ws.getString(2);
						String strParamName = ws.getString(3);
					  

						if (strParamValue == null)
							strParamValue = "";

						 

						sb.append("<tr> ");
						sb
								.append("<td width='10%' class='multiControl'></td> ");
						sb.append("<td width='45%' class='multiControl'>"
								+ strParamName + "</td>");
						sb
								.append("<td width='45%' class='multiControl'>"+strParamValue+"</td>");
						sb.append("</tr>");

						count = count + 1;
					}

					 

				} else {
					sb
							.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
					sb.append("</table>");
		 

				}

				 

			} else {
				throw new Exception("WebRowSet should not be null");
			}

		} catch (Exception e) {
			throw e;
		}

		return sb.toString();
	}
	
	
	/**
	 * Gets the search item init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the search item init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getSearchItemInitViewBS(MmsFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");

		String strTableWidth = "70";

		try {

			sb.append("<div id='itemSearchPartDivId'>");
			

			sb.append("<div class='row'>");
			sb.append("<div class='col-sm-5' >");
			sb.append("<lable>Item Search For </label></div>");
			sb.append("<div class='col-sm-2' align='right'>");
			sb.append("<input type='hidden' name='strHiddenGenericItemId' value='' ><input type='hidden' name='strNewItemFlag' value='"+formBean.getStrNewItemFlag()+"' >Group Name</div>");
			sb.append("<div class='col-sm-5'>");
			sb.append(" <select name='strGroupIdForItemSearch' class='browser-default custom-select labelcaps labelbold' onchange='getBrandItemList("+formBean.getStrModeVal()+");'>"+formBean.getStrGroupList()+"</select>"); 
			sb.append("</div>");			
			sb.append("</div>");
			
			sb.append("<div class='row'>");						
			sb.append("<div class='col-sm-7' align='right'>");
			sb.append("Generic Name");
			sb.append("</div>");
			sb.append("<div class='col-sm-5'>");
			sb.append("<div id='itemListDivId'><select name='strItemList' class='browser-default custom-select labelcaps labelbold' onchange='getBrandItemList("+formBean.getStrModeVal()+");'>"+formBean.getStrItemList()+"</select>"); 
			sb.append("</div>");	
			sb.append("</div>");	
			sb.append("</div>");
			
			
			
			
			sb.append("<hr class='newhr'>");
			
			
			sb.append("<div class='row'>");
			sb.append("<div class='col-sm-3' >");
			sb.append(" <select class='browser-default custom-select' name='strSearchLeftOption' onchange='setSelectedIndexValue();'  > ");
			sb.append(" <option value='1' >Name</option> ");
			sb.append(" <option value='2' >Code</option> ");
					
					if(formBean.getStrModeVal().equals("3")){
					
						sb.append(" <option value='3' >Batch/Serial No.</option> ");
					}
					
					
			sb.append(" </select> ");
			sb.append("</div><div class='col-sm-2'>");
			sb .append(" <input class='form-control' type='text' name='strSearchLeftList' tabindex='1' onkeyup='searchItemsInPopup(event , this );'> ");
			sb.append("</div>");
			sb.append("<div class='col-sm-2'></div>");
            sb.append("<div class='col-sm-4' align='center'>");
            sb .append("<input class='form-control' type='text' name='strSearchRightList' onkeypress='return searchList(event , this , \"1\");'> ");
			sb.append("</div>");
			sb.append("<div class='col-sm-1'></div>");
			sb.append("</div>");
			sb.append("<hr class='newhr'>");

			sb.append("<div class='row'>");
			sb.append("<div class='col-sm-5' >");
			sb.append(" <div id='brandItemListDivId'><select class='browser-default custom-select' onchange='setItemName(this);' ");
			sb.append(" name='strBrandedItemList' multiple ");
			sb.append("  ></select></div> </div>");
			sb.append("<div class='col-sm-2' align='center'><br><br><br><div class='row'><div class='col-sm-12' align='center'>");
			sb.append("<img src='../../hisglobal/images/forward3.gif' width='35' height='31' onClick='return shiftToRightLogic("
					+ formBean.getStrModeVal() + ");'></div></div><br><br> ");
			sb
			.append("<div class='row'><div class='col-sm-12' align='center'><img src='../../hisglobal/images/back3.gif' width='35' height='31' onClick='shiftToLeftLogic("
					+ formBean.getStrModeVal() + ");'/></div></div> ");
			sb.append("</div>");
			sb.append("<div class='col-sm-5'>");
            sb.append("<div id='selectedItemListDivId'> ");
			
			if(formBean.getStrModeVal().equals("1")){
				
				sb
				.append("<select name='strSelectedItemList' class='browser-default custom-select' onchange='setItemName(this);setItemStockParameters(\"1\" , this);' multiple ></select> ");
	
				
			}else{

				sb
				.append("<select name='strSelectedItemList' class='browser-default custom-select' onchange='setItemName(this);setItemStockParameters(this);' multiple></select> ");
	
				
			}
			
				
			sb.append("</div> ");
			sb.append("</div>");
			sb.append("</div>");
			
		
			
		
			sb.append("<div class='row'>");
			sb.append("<div class='col-sm-12' >");
			sb.append("<div id='popUpItemNameDivId' style='color:#ff6c00;font-weight:bold'></div> ");
			sb.append("<div id='popUpItemLoadDivId' style='color:red;font-weight:bold;display:none;'>Loading.....</div> ");
			sb.append("</div>");
			sb.append("</div>");

			
			
			if (formBean.getStrModeVal().equals("1")) {

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");

				sb.append("<td width='3%'> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' style='font-size:22px;' ");
				sb.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" );' /></i></div> ");
				sb.append("<div id='minusStockParamDivId' style='display: none' align='center'> ");
				sb.append("<i class='fas fa-minus-circle' style='font-size:22px;'  name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></i></div> ");
				sb.append("</td> ");

				sb.append("<td >Item Parameters ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
				
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>Specification</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='stockParamSpecificationDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>Re-Order Level</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='stockParamReOrderDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>In Hand Quantity</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='stockParamInHandQtyDivId'></div>");
				sb.append("</div>");
				
				
				
				sb.append("</div>");

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");
				sb.append("<td width='3%' > ");
				sb.append("<div id='plusPurchaseDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' style='font-size:22px;' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"PurchaseDivId\", \"StockParamDivId\");' /></i></div> ");
				sb.append("<div id='minusPurchaseDivId' style='display: none' align='center'>");
				sb.append("<i class='fas fa-minus-circle' style='font-size:22px;' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></i></div> ");
				sb.append("</td> ");
				sb.append(" <td colspan='3'>Last Purchase Purchase Parameters 1");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>P.O. No.</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='purchaseParamPoNoDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>P.O. Date </label></div>");
				sb.append("<div class='col-sm-2' align='right' id='purchaseParamPoDateDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>Received Quantity </label></div>");
				sb.append("<div class='col-sm-2' align='right' id='purchaseParamReceivedQtyDivId'></div>");
				sb.append("</div>");
				
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>Rate/Unit</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='purchaseParamRateUnitDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable>Supplied By</label></div>");
				sb.append("<div class='col-sm-2' align='right' id='purchaseParamSuppliedByDivId'></div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<lable></label></div>");
				sb.append("<div class='col-sm-2' align='right' id=''></div>");
				sb.append("</div>");
				
				sb.append("</div>");

			} else if (formBean.getStrModeVal().equals("2")) {

				sb.append("<p class='subHeaders'>Item Details </p> ");
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2' >");
				sb.append("<label>Specification</label></div>");
				sb.append("<div class='col-sm-7' style='padding-right: 0px;padding-left: 0px;'>");
				sb.append("<div id='stockParamSpecificationDivId' style='color : #ff6c00;font-weight:bold'></div> ");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' align='right'>");
				sb.append("<label>Last Rate/Unit</label></div>");
				sb.append("<div class='col-sm-1'>");
				sb.append("<div id='stockParamLastRateUnitDivId' style='color : #ff6c00;font-weight:bold'></div>");
				sb.append("</div>");
				sb.append("</div>");
				
			

			} else if (formBean.getStrModeVal().equals("3")) {

				//sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<div class='row'>");

				sb.append("<div class='col-sm-1'>");
				sb.append("<div id='plusConsuptionDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"ConsuptionDivId\" , \"StockParamDivId\" , \"PurchaseDivId\");' /></i></div> ");
				sb
						.append("<div id='minusConsuptionDivId' style='display: none' align='center'> ");
				sb
						.append("<i class='fas fa-minus-circle' name='minusParameter' onclick='hideDetails(\"ConsuptionDivId\");'></i></div> ");
				sb.append("</div>");

				sb.append("<div class='col-sm-3'>Item Parameters ");
				sb.append(" </div>");
				sb.append(" </div>");

				//sb.append("</table> ");

				sb.append("<div id='ConsuptionDivId' style='display:none'>");
				sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
				sb.append("<div class='col-sm-2' >");
				sb.append("<label>Specification</label></div>");
				sb.append("<div class='col-sm-7' style='padding-right: 0px;padding-left: 0px;'>");
				sb.append("<div id='stockParamSpecificationDivId' style='color : #ff6c00;font-weight:bold'></div> ");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' align='right'>");
				sb.append("<label> Re-Order Level</label></div>");
				sb.append("<div class='col-sm-1'>");
				sb.append("<div id='stockParamReOrderDivId' style='color : #ff6c00;font-weight:bold'></div>");
				sb.append("</div>");
				sb.append("</div>");
				
				sb.append("</div>");

				//sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<div class='row'> ");

				sb.append("<div class='col-sm-1'> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" , \"ConsuptionDivId\");' /></i></div> ");
				sb.append("<div id='minusStockParamDivId' style='display: none' align='center'> ");
				sb.append("<i class='fas fa-minus-circle' name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></i></div> ");
				sb.append("</div> ");

				sb.append("<div class='col-sm-3'>Stock Parameters ");
				sb.append("</div>");
				sb.append("</div>");
				//sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
			//	sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				if (formBean.getStrItemCategoryId().equals("1")) {

					sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
					sb.append("<div class='col-sm-3'><label>Stock In Hand</label>");
					sb.append("</div> ");
					sb.append(" <div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseStockInHandDivId'></div> ");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3'><label>Batch/Serial No.</label>");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseBatchNoDivId'></div> ");
					sb.append("</div> ");
					sb.append("</div> ");
					sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
					sb.append("<div class='col-sm-3'><label>Expiry Date</label>");
					sb.append("</div> ");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'> <div id='purchaseExpiryDateDivId'></div>");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3'><label>Stock Status</label>");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'> <div id='purchaseStockStatusDivId'></div>");
					sb.append(" </div> ");
					sb.append("</div> ");

				} else {

					sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
					sb.append("<div class='col-sm-3'><label>Stock In Hand</label>");
					sb.append("</div>");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseStockInHandDivId'></div> ");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3'><label>Batch/Serial No.</label>");
					sb.append(" </div> ");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseBatchNoDivId'></div> ");
					sb.append(" </div>");
					sb.append("</div> ");
					sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
					sb.append("<div class='col-sm-3'><label>Serial No.</label>");
					sb.append("</div> ");
					sb.append(" <div class='col-sm-3' style='color : blue;font-weight:bold'> <div id='purchaseSerialNoDivId'></div>");
					sb.append(" </div> ");
					sb.append(" <div class='col-sm-3'>Expiry Date ");
					sb.append(" </div> ");
					sb.append(" <div class='col-sm-3' style='color : blue;font-weight:bold'> <div id='purchaseExpiryDateDivId'></div>");
					sb.append(" </div> ");
					sb.append("</div> ");
					sb.append("<div class='row' style='margin-left: 10px; background-color: aliceblue; margin-right: 10px;'>");
					sb.append("<div class='col-sm-3'><label>Stock Status</label>");
					sb.append("</div> ");
					sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'> <div id='purchaseStockStatusDivId'></div> ");
					sb.append("</div>");
					sb.append("</div>");

				}

				//sb.append("</table> ");
				sb.append("</div>");

				//sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				//sb.append(" <tr> ");
				sb.append("<div class='row'><div class='col-sm-1'> ");
				sb.append("<div id='plusPurchaseDivId' align='center'><div class='row'><div class='col-sm-12'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"PurchaseDivId\", \"ConsuptionDivId\" , \"StockParamDivId\");' /></i></div></div></div> ");
				sb.append("<div id='minusPurchaseDivId' style='display: none' align='center'><div class='row'><div class='col-sm-12'> ");
				sb.append("<i class='fas fa-minus-circle' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></i></div></div></div> ");
				sb.append("</div> ");
				sb.append(" <div class='col-sm-3' text-align='right'>Purchase Parameters");
				sb.append("</div></div> ");
				//sb.append("</tr> ");

			//	sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				//sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<div class='row' style='margin-left: 10px;\r\n" + 
						"background-color: aliceblue;\r\n" + 
						"margin-right: 10px;'> ");
				sb.append(" <div class='col-sm-3' text-align='left'><label>P.O. No.<label>");
				sb.append("</div> ");
				sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseParamPoNoDivId'></div>");
				sb.append(" </div> ");
				sb.append(" <div class='col-sm-3' text-align='left'><label>P.O. Date<label>");
				sb.append(" </div> ");
				sb.append(" <div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseParamPoDateDivId'></div> ");
				sb.append(" </div> ");
				sb.append(" </div> ");
				sb.append("<div class='row' style='margin-left: 10px;\r\n" + 
						"background-color: aliceblue;\r\n" + 
						"margin-right: 10px;'> ");
				sb.append(" <div class='col-sm-3' text-align='left'><label>Received Quantity<label>");
				sb.append("</div> ");
				sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseParamReceivedQtyDivId'></div> ");
				sb.append("</div> ");
				sb.append("<div class='col-sm-3' text-align='left'><label>Rate/Unit</label>");
				sb.append(" </div> ");
				sb.append("<div class='col-sm-3' style='color : blue;font-weight:bold'><div id='purchaseParamRateUnitDivId'></div> ");
				sb.append(" </div> ");
				sb.append(" </div> ");
				sb.append("<div class='row' style='margin-left: 10px;\r\n" + 
						"background-color: aliceblue;\r\n" + 
						"margin-right: 10px;'> ");
				sb.append(" <div class='col-sm-3' text-align='left'><label>Supplied By<label>");
				sb.append("</div> ");
				
				sb.append("<div class='col-sm-3' colspan='2' style='color : blue;font-weight:bold'><div id='purchaseParamSuppliedByDivId'></div> ");
				sb.append(" </div>");
				sb.append(" </div>");
				//sb.append("</table> ");
				sb.append("</div>");

			} else if (formBean.getStrModeVal().equals("4")) {

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");

				sb.append("<td> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" );' /></i></div> ");
				sb.append("<div id='minusStockParamDivId' style='display: none' align='center'> ");
				sb.append("<i class='fas fa-minus-circle' name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></i></div> ");
				sb.append("</td> ");

				sb.append("<td>Stock Details ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL'>In Hand Quantity ");
				sb.append("</td> ");
				sb.append(" <td class='CONTROL' style='color : blue;font-weight:bold' ><div id='stockParamInHandQtyDivId' ></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Re - Order Level");
				sb.append(" </td> ");
				sb.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='stockParamReOrderDivId'></div>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("</div>");

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");
				sb.append("<td> ");
				sb.append("<div id='plusPurchaseDivId' align='center'> ");
				sb.append("<i class='fas fa-plus-circle' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"PurchaseDivId\", \"StockParamDivId\");' /></i></div> ");
				sb.append("<div id='minusPurchaseDivId' style='display: none' align='center'>");
				sb.append("<i class='fas fa-minus-circle' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></i></div> ");
				sb.append("</td> ");
				sb.append(" <td >Last Purchase Details ");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Last P.O. No. ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPONoDivId'></div>");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Last P.O. Date ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPODateDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Last Purchase Rate / Unit ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamRateUnitDivId'></div>");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Supplied By ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamSuppliedByDivId'></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb
						.append(" <td class='LABEL' colspan='2'>Last Receive Quantity ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' colspan='2' style='color : blue;font-weight:bold'><div id='purchaseParamLastRecQtyDivId'></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("</table> ");
				sb.append("</div>");

			}
			/*
			 * sb.append("<div class='row'>");
			 * sb.append("<div class='col-sm-12' align='right'>"); sb.
			 * append("<label><font size='2' color='red'>*</font> Mandatory Fields <label>"
			 * ); sb.append("</div>"); sb.append("</div>");
			 */
			/*
			 * sb.append("<div class='row'>");
			 * sb.append("<div class='col-sm-12' align='center'>");
			 * sb.append("<button type='button' class='btn btn-success' >Ok</button> ");
			 * sb.append("</div>"); sb.append("</div>");
			 */
			
			sb.append("</div>");
			sb.append("<div id='newItemsAddPartDivId'>");
			sb.append("</div>");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	public static String getSearchItemInitView(MmsFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");

		String strTableWidth = "70";

		try {

			sb.append("<div id='itemSearchPartDivId'>");
			sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr class='HEADER'>");
			if (formBean.getStrModeVal().equals("2")) 
			{
				sb.append("<td colspan='3' width='95%'>Item Search For </td>");
				//sb.append("<td  width='5%'><input type='checkbox' name='strNewItem' onclick='enterData();'>New Item</td>");
				sb.append("<td  width='5%'></td>");

			} 
			else 
			{
				sb.append("<td colspan='6'>Item Search For </td>");
			}

			sb.append("</tr>");

			if(!formBean.getStrNewItemFlag().trim().equals("0"))
			{
				
				sb.append("<tr>");
				//sb.append("<td colspan='6' class='LABEL'> <input type='checkbox' name='strNewItemCheck' value='1' onclick='getAddNewItemScreen(this, document.forms[0].strHiddenGenericItemId );' > <font style='color:blue'>Check here to Add a New Item</font> </td>");
				sb.append("<td colspan='6' class='LABEL'></td>");
				sb.append("</tr>");
				
			}
			 
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='25%'><input type='hidden' name='strHiddenGenericItemId' value='' ><input type='hidden' name='strNewItemFlag' value='"+formBean.getStrNewItemFlag()+"' >Group Name</td>");
			sb.append("<td class='CONTROL' width='75%'><select  ");
			sb.append(" name='strGroupIdForItemSearch' class='comboBig' onchange='getBrandItemList("+formBean.getStrModeVal()+");' >"); // onchange='getSubGroupList(this);' > ");
			sb.append( formBean.getStrGroupList() );
			sb.append(" </select></td> ");
			/*
			sb.append(" <td class='LABEL' width='25%'>Sub Group Name</td> ");
			sb.append(" <td class='CONTROL' width='25%'><div id='subGroupdivId'><select ");
			sb.append("	name='strSubGroupIdForItemSearch' class='comboNormal' onchange='getItemList(\"" + formBean.getStrModeVal() + "\" , this);'> ");
			sb.append(formBean.getStrSubGroupValues());
			sb.append("</select></div></td> ");
			*/
			sb.append(" </tr> ");
		/*	
			sb.append(" <tr> ");
			sb.append(" <td class='LABEL' width='25%'>Generic Drug Name</td> ");
			sb.append(" <td class='CONTROL' colspan='3' ><div id='itemListDivId'><select ");
			sb.append("	onkeydown='return onPressingEnter(this,event)' ");
			sb.append("	name='strItemList' class='comboMax' > ");
			sb.append(formBean.getStrItemList());
			sb.append("	</select></div> <input name='strItemCategoryId' value='10' type='hidden'></td> ");
			sb.append("	</tr> ");
		*/	
			sb.append("	<tr> ");
			sb.append("	<td colspan='6' bgcolor='#126ea8'></td> ");
			    sb.append("	</tr> ");
			
			/*sb.append("<tr>");
			sb.append("<td width='20%' colspan='2' class='LABEL'>");
			sb.append("Sub Group Name ");
			sb.append("</td>");
			sb.append("<td width='20%' colspan='2' class='CONTROL'> ");
			sb
					.append("<select name='strSubGroupIdForItemSearch' class='comboNormal'> ");
			sb.append(formBean.getStrSubGroupValues());
			sb.append("</select> ");
			sb.append("</td> ");

			sb.append("<td width='20%' class='multiControl'> ");
			sb
					.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-search.png' onClick='getItemList("
							+ formBean.getStrModeVal() + ");' /> ");
			sb.append("<input type='hidden' name='strItemCategoryId' value='"
					+ formBean.getStrItemCategoryId() + "'>");
			sb.append("</td> ");
			sb.append("</tr> ");*/
			sb.append("</table> ");

			sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td colspan='2' class='multiControl'> ");
			
			sb.append(" <select class='comboMin' name='strSearchLeftOption' onchange='setSelectedIndexValue();' tabindex='1' > ");
					sb.append(" <option value='1' >Name</option> ");
							sb.append(" <option value='2' >Code</option> ");
							
							if(formBean.getStrModeVal().equals("3")){
							
								sb.append(" <option value='3' >Batch/Serial No.</option> ");
							}
							
							
									sb.append(" </select> &nbsp;&nbsp; ");
			
			sb
					.append(" <input class='txtFldMax' type='text' name='strSearchLeftList' tabindex='1' onkeyup='searchItemsInPopup(event , this );'> ");
			sb.append("</td> ");
			sb.append("<td colspan='1' class='LABEL' width='56'></td> ");
			sb.append("<td colspan='2' class='multiControl'> ");
			sb
					.append("<input class='txtFldMax' type='text' name='strSearchRightList' onkeypress='return searchList(event , this , \"1\");'> ");
			sb.append("</td> ");
			sb.append("</tr> ");

			/*sb.append("<tr> ");
			sb.append("<td colspan='2' class='multiLabel'>Branded Item(s) ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='55'> ");
			sb.append("</td> ");
			sb.append("<td  colspan='2' class='multiLabel'>Selected Item(s) ");
			sb.append("</td> ");
			sb.append("</tr> ");*/

			
			
			sb.append("<tr> ");
			sb.append(" <td colspan='2' rowspan='3' class='multiControl'  style='width: 48%;'> ");
			
			sb.append(" <div id='brandItemListDivId'><select tabindex='1' onchange='setItemName(this);' ");
			sb.append(" name='strBrandedItemList' multiple='multiple' size='12' ");
			sb.append(" style='width: 100%;'></select></div> ");
			sb.append(" </td> ");
			 							
			sb.append("<td class='multiLabel' rowspan='3'  style='width: 4%;'> ");

			sb.append("<table> ");
			sb.append("<tr> ");
			sb.append("<td height='15'> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td> ");
			sb
					.append("<img src='../../hisglobal/images/forward3.gif' width='35' height='31' onClick='return shiftToRightLogic("
							+ formBean.getStrModeVal() + ");'> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td height='15'> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td> ");
			sb
					.append("<img src='../../hisglobal/images/back3.gif' width='35' height='31' onClick='shiftToLeftLogic("
							+ formBean.getStrModeVal() + ");'/> ");
			sb.append("</td> ");

			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</td> ");
			sb.append("<td colspan='2' rowspan='3' class='multiControl' style='width: 48%;'> ");
			sb.append("<div id='selectedItemListDivId'> ");
			
			if(formBean.getStrModeVal().equals("1")){
				
				sb
				.append("<select name='strSelectedItemList' onchange='setItemName(this);setItemStockParameters(\"1\" , this);' multiple='multiple' size='12' style='width :100%'></select> ");
	
				
			}else{

				sb
				.append("<select name='strSelectedItemList' onchange='setItemName(this);setItemStockParameters(this);' multiple='multiple' size='12' style='width :100%'></select> ");
	
				
			}
			
				
			sb.append("</div> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			/*sb.append("<tr>  ");
			sb.append("<td colspan='2' class='multiLabel'>Item Name(s) ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td colspan='2' class='multiControl'> ");
			sb.append("<div id='brandItemListDivId'> ");

			sb
					.append("<select name='strBrandedItemList' multiple='multiple' size='5' style='width :300px'> ");

			sb.append("</select> ");
			sb.append("</div> ");
			sb.append("</td> ");
			sb.append("</tr> ");*/
			sb.append("</table> ");


			sb.append("<table align='center' cellpadding='1px' cellspacing='1px' width='700'> ");
			sb.append("<tr> ");
			sb.append("<td class='CONTROL'> ");
			sb.append("<div id='popUpItemNameDivId' style='color:blue;font-weight:bold'></div> ");
			sb.append("<div id='popUpItemLoadDivId' style='color:red;font-weight:bold;display:none;'>Loading.....</div> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
			
			if (formBean.getStrModeVal().equals("1")) {

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");

				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" );' /></div> ");
				sb
						.append("<div id='minusStockParamDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></div> ");
				sb.append("</td> ");

				sb.append("<td class='TITLE' colspan='3'>Item Parameters ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL'>Specification ");
				sb.append("</td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='stockParamSpecificationDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'> Re-Order Level");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='stockParamReOrderDivId'></div> ");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL' colspan='2'>In Hand Quantity ");
				sb.append("</td> ");
				sb
						.append(" <td class='CONTROL' colspan='2' style='color : blue;font-weight:bold'><div id='stockParamInHandQtyDivId'></div> ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("</div>");

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");
				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusPurchaseDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"PurchaseDivId\", \"StockParamDivId\");' /></div> ");
				sb
						.append("<div id='minusPurchaseDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></div> ");
				sb.append("</td> ");
				sb
						.append(" <td class='TITLE' colspan='3'>Last Purchase Purchase Parameters 1");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>P.O. No. ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPoNoDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>P.O. Date ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPoDateDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Received Quantity ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamReceivedQtyDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Rate/Unit");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamRateUnitDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL' colspan='2'>Supplied By ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' colspan='2' style='color : blue;font-weight:bold'><div id='purchaseParamSuppliedByDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("</table> ");
				sb.append("</div>");

			} else if (formBean.getStrModeVal().equals("2")) {

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='5'>Item Details ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL'>Specification ");
				sb.append("</td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='stockParamSpecificationDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Last Rate/Unit ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='stockParamLastRateUnitDivId'></div>");
				sb.append("</td> ");

				sb.append("</tr> ");
				sb.append("</table> ");

			} else if (formBean.getStrModeVal().equals("3")) {

				sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");

				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusConsuptionDivId' align='center'> ");
				sb.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb.append("onclick='showDetails(\"ConsuptionDivId\" , \"StockParamDivId\" , \"PurchaseDivId\");' /></div> ");
				sb.append("<div id='minusConsuptionDivId' style='display: none' align='center'><img ");
				sb.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"ConsuptionDivId\");'></div> ");
				sb.append("</td> ");

				sb.append("<td class='TITLE' colspan='5'>Item Parameters ");
				sb.append(" </td> ");
				sb.append(" </tr> ");

				sb.append("</table> ");

				sb.append("<div id='ConsuptionDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL'>Specification ");
				sb.append("</td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='stockParamSpecificationDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'> Re-Order Level");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='stockParamReOrderDivId'></div> ");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");
				sb.append("</div>");

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");

				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" , \"ConsuptionDivId\");' /></div> ");
				sb
						.append("<div id='minusStockParamDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></div> ");
				sb.append("</td> ");

				sb.append("<td class='TITLE' colspan='3'>Stock Parameters ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				if (formBean.getStrItemCategoryId().equals("1")) {

					sb.append("<tr> ");
					sb.append("<td class='LABEL'>Stock In Hand");
					sb.append("</td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseStockInHandDivId'></div> ");
					sb.append(" </td> ");
					sb.append(" <td class='LABEL'>Batch/Serial No. ");
					sb.append(" </td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseBatchNoDivId'></div> ");
					sb.append(" </td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td class='LABEL' >Expiry Date");
					sb.append("</td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='purchaseExpiryDateDivId'></div>");
					sb.append(" </td> ");
					sb.append(" <td class='LABEL'>Stock Status ");
					sb.append(" </td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='purchaseStockStatusDivId'></div>");
					sb.append(" </td> ");
					sb.append("</tr> ");

				} else {

					sb.append("<tr> ");
					sb.append("<td class='LABEL'>Stock In Hand");
					sb.append("</td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseStockInHandDivId'></div> ");
					sb.append(" </td> ");
					sb.append(" <td class='LABEL'>Batch/Serial No. ");
					sb.append(" </td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseBatchNoDivId'></div> ");
					sb.append(" </td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td class='LABEL'>Serial No.");
					sb.append("</td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='purchaseSerialNoDivId'></div>");
					sb.append(" </td> ");
					sb.append(" <td class='LABEL'>Expiry Date ");
					sb.append(" </td> ");
					sb
							.append(" <td class='CONTROL' style='color : blue;font-weight:bold'> <div id='purchaseExpiryDateDivId'></div>");
					sb.append(" </td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td colspan='2' class='LABEL'>Stock Status ");
					sb.append("</td> ");
					sb
							.append("<td colspan='2' class='CONTROL' style='color : blue;font-weight:bold'> <div id='purchaseStockStatusDivId'></div> ");
					sb.append("</td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");
				sb.append("</div>");

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");
				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusPurchaseDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"PurchaseDivId\", \"ConsuptionDivId\" , \"StockParamDivId\");' /></div> ");
				sb
						.append("<div id='minusPurchaseDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></div> ");
				sb.append("</td> ");
				sb
						.append(" <td class='TITLE' colspan='3'>Purchase Parameters ");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>P.O. No. ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPoNoDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>P.O. Date ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPoDateDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Received Quantity ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamReceivedQtyDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Rate/Unit");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamRateUnitDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL' colspan='2'>Supplied By ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' colspan='2' style='color : blue;font-weight:bold'><div id='purchaseParamSuppliedByDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("</table> ");
				sb.append("</div>");

			} else if (formBean.getStrModeVal().equals("4")) {

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");

				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusStockParamDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"StockParamDivId\", \"PurchaseDivId\" );' /></div> ");
				sb
						.append("<div id='minusStockParamDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"StockParamDivId\");' ></div> ");
				sb.append("</td> ");

				sb.append("<td class='TITLE' colspan='3'>Stock Details ");
				sb.append(" </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div id='StockParamDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='LABEL'>In Hand Quantity ");
				sb.append("</td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold' ><div id='stockParamInHandQtyDivId' ></div> ");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Re - Order Level");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='stockParamReOrderDivId'></div>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("</div>");

				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(" <tr> ");
				sb.append("<td width='3%' class='TITLE'> ");
				sb.append("<div id='plusPurchaseDivId' align='center'> ");
				sb
						.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; ' name='plusParameter' align='middle' ");
				sb
						.append("onclick='showDetails(\"PurchaseDivId\", \"StockParamDivId\");' /></div> ");
				sb
						.append("<div id='minusPurchaseDivId' style='display: none' align='center'><img ");
				sb
						.append("src='../../hisglobal/images/minus.gif' style='cursor: pointer; ' name='minusParameter' onclick='hideDetails(\"PurchaseDivId\");'></div> ");
				sb.append("</td> ");
				sb
						.append(" <td class='TITLE' colspan='3'>Last Purchase Details ");
				sb.append("</td> ");
				sb.append("</tr> ");

				sb.append("</table> ");

				sb.append("<div id='PurchaseDivId' style='display:none'>");
				sb
						.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Last P.O. No. ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPONoDivId'></div>");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Last P.O. Date ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamPODateDivId'></div> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb.append(" <td class='LABEL'>Last Purchase Rate / Unit ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamRateUnitDivId'></div>");
				sb.append(" </td> ");
				sb.append(" <td class='LABEL'>Supplied By ");
				sb.append(" </td> ");
				sb
						.append(" <td class='CONTROL' style='color : blue;font-weight:bold'><div id='purchaseParamSuppliedByDivId'></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("<tr> ");
				sb
						.append(" <td class='LABEL' colspan='2'>Last Receive Quantity ");
				sb.append("</td> ");
				sb
						.append("<td class='CONTROL' colspan='2' style='color : blue;font-weight:bold'><div id='purchaseParamLastRecQtyDivId'></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append("</table> ");
				sb.append("</div>");

			}

			sb.append("<table style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='FOOTER'> ");
			sb
					.append("<td colspan='5'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table border='0' style='width:"+strTableWidth+"vw;' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td align='center'> ");
			sb
					.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-ok1.png' tabindex='1' onkeypress='createSelectedList();'  onClick='createSelectedList();' /> ");
			sb
					.append("<img style='cursor: pointer; ' src='../../hisglobal/images/back_tab1.png' tabindex='1' onkeypress='hidePopup();'  onClick='hidePopup();' /> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div>");
			sb.append("<div id='newItemsAddPartDivId'>");
			sb.append("</div>");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the mms listing view.
	 * 
	 * @param voObj
	 *            the vo obj
	 * 
	 * @return the mms listing view
	 */
	public static String getMmsListingView(MmsVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getGblWs1();

		try {

			int start = Integer.parseInt(voObj.getStrValue4());
			int actualBlockSet = Integer.parseInt(voObj.getStrValue7());

			final int REC_PER_PAGE = Integer.parseInt(voObj.getStrValue6());
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;

			int previous = 1;
			int next = 0;

			if (ws != null) {

				if (ws.size() != 0) {

					int actualFetchRecord = ws.size();

					if (actualBlockSet == 1)
						actualBlockSet = actualBlockSet + 1;

					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;

					if (totalFetchRecord != actualFetchRecord) {

						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;

					}

					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;

					if (reminder > 0)
						totalLayer = totalLayer + 1;

					/*
					 * sb.append( "<table width='100%'align='center'
					 * cellspacing='1px'>");
					 * 
					 * sb.append("<tr>"); sb.append("<td class='LABEL'>&nbsp;");
					 * 
					 * if (start != 1){ sb .append("<a href='#'
					 * onClick='fetchPatientList(\""
					 * +previous+"\",\""+(actualBlockSet - 1)+"\");'> &lt;&lt;
					 * Previous</a> &nbsp;"); } for (int i = 1; i <=
					 * totalLayer; i++) { sb.append("<a href='#'
					 * onClick='layerIndexNavigator(\"" + i + "\",\"" +
					 * totalLayer + "\")'>" + (i + start - 1) + "</a> &nbsp;"); }
					 * 
					 * if (next > 0 ) sb.append("<a href='#'
					 * onClick='fetchPatientList(\""
					 * +next+"\",\""+(actualBlockSet + 1)+"\");'> Next &gt;&gt;</a>");
					 * 
					 * sb.append("</td>"); sb.append("</tr>"); sb.append("</table>");
					 */

					// added content
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");

					if (start != 1) {
						sb
								.append("<a STYLE='CURSOR:POINTER'  onClick='fetchMmsList(\""
										+ previous
										+ "\",\""
										+ (actualBlockSet - 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> &lt;&lt; Previous</FONT> </a> &nbsp;");

					}
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));

						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}

					if (next > 0)
						sb
								.append("<a STYLE='CURSOR:POINTER' onClick='fetchMmsList(\""
										+ next
										+ "\",\""
										+ (actualBlockSet + 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> Next &gt;&gt;</FONT></a>");

					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td width='5%'class='multiLabel'>");
					sb.append("</td>");

					sb.append("<td width='18%'class='multiLabel'>P.O. No.");
					sb.append("</td>");

					sb.append("<td width='23%'class='multiLabel'>P.O. Date");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>P.O. Type");
					sb.append("</td>");
					sb
							.append("<td width='18%'class='multiLabel'>Item Category");
					sb.append("</td>");
					sb
							.append("<td width='18%'class='multiLabel'>Supplier Name");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					for (int i = 1; i <= totalLayer; i++) {

						if (i < totalLayer
								|| (i == totalLayer && reminder == 0)) {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}

							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int j = 0; j < REC_PER_PAGE; j++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strPoNo' value='");
								sb.append(ws.getString(5));
								sb.append("'></td>");

								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(5));
								sb.append("</td>");

								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						} else {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}
							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strPoNo' value='");
								sb.append(ws.getString(5));
								sb.append("'></td>");

								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(5));
								sb.append("</td>");

								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						}

					}

					sb.append("</td>");
					sb.append("</'tr>");

					sb.append("</table>");

				} else {
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

			} else {

				throw new Exception("Mms List WebRowSet is Null");

			}

		} catch (Exception e) {
			new HisException("Global Mms Listing",
					"mms.global.controller.MmsHLP.getMmsListingView()-->", e
							.getMessage());
		}

		return sb.toString();

	}

	/**
	 * Gets the stock item dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the stock item dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getStockItemDtlsInitView(MmsFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsStockDetails();
		HisUtil util = new HisUtil("Mms Stock Detail Util", "MmsHLP");
		MmsVO vo = new MmsVO();
		int count = 0;

		boolean flag = false;

		String strHiddenVal = "0";
		String[] strHiddenValList = null;
		String[] strTemp = null;
		String[] strChkList = null;
		String[] strQtyList = null;
		String[] strUnitList = null;
		
		String[] strHiddenCost = null;
		String[] strHiddenTotalCost = null;

		String strTempQtyVal = "";
		String strTempUnitVal = "";
		String strTempCost = "0.00";
		String strTempTotalCost = "0.00";

		String strTableWidth = "800";
		//formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]); 
		// This Variable is Used As Budget Avalaible Flag 
		// Change By Amit Kumar 10-Aug-2011

		try {

			/*
			 * if(formBean.getStrHiddenVal().trim().length() > 1) strHiddenVal =
			 * formBean.getStrHiddenVal();
			 */

			StringBuffer strChkVal = new StringBuffer("");
			if (formBean.getStrModeVal().equals("1")) 
			{

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='HEADER'> ");
				sb.append("<input type='hidden' name='strIndex' id='strIndex' value='"+formBean.getStrIndex()+"'>");
				if (formBean.getStrItemCategoryId().equals("10")) 
				{

					sb.append("<td colspan='4'>Drug Stock Details </td> ");

				} 
				else 
				{
					sb.append("<td colspan='4'>Item Stock Details </td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) 
				{

					sb.append("<td width='50%' class='LABEL'>Drug Name</td> ");

				}
				else 
				{
					sb.append("<td width='50%' class='LABEL'>Item Name</td> ");
				}
                 
				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrItemName() + "</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='50%' class='LABEL'>Issue Qty.</td> ");
				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrIssueQty() + " "+ formBean.getStrUnitName()+ "<input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQty' value='"+ formBean.getStrIssueQty()+ "'><input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQtyBaseVal' value='"+ formBean.getStrIssueQtyInBase() + "'></td> ");
				sb.append("</tr> ");
				
//				sb.append("<tr> ");
//				sb.append("<td width='50%' class='LABEL'>Rack No.</td> ");
//				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrRackNo()+"</td> ");
//				sb.append("</tr> ");
				
				
				sb.append("</table> ");

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='TITLE'> ");

				if (!formBean.getStrItemCategoryId().equals("10"))
				{
					sb.append("<td colspan='10'>Item Details</td> ");
				} 
				else
				{
					sb.append("<td colspan='10'>Drug Details</td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='multiRPTLabel' width='5%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='9%'>Rack No");
				sb.append("</td> ");
				if (!formBean.getStrItemCategoryId().equals("10")) 
				{
					sb.append("<td class='multiRPTLabel' width='14%'>Serial No. ");
					sb.append("</td> ");
				}
				sb.append("<td class='multiRPTLabel' width='14%'>Batch/Serial No. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='14%'>Manufacturer ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. ");
				sb.append("</td> ");				
				sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
				sb.append("</td> ");
				if (formBean.getUsrArg().equals("1")) // Means Budget Required
				{
				  sb.append("<td class='multiRPTLabel' width='14%'>Cost");
				  sb.append("</td> ");
				} 
				sb.append("</tr> ");

				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{
						/*
						 * This part is added by Aritra on May 26, 2010. It will
						 * cause to produce distinct value for strStockDtlsChk
						 * checkbox, not appending with the value of previous
						 * check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						/*
						 * 11. Store id, 12. Generic Item Id 13. Item Id 14.
						 * Stock Status Code 15. Batch No. 18. Expiry Date 19.
						 * Manufacture Date 20. Inhand Qty 21. Inhand Qty Unit
						 * Id 23. Rate 24. Rate Unit Id 37. Serial No. 38. Sale
						 * Price 39. Sale Price Unit Id
						 */

						String strExpDate = "";

						if (ws.getString(18) != null && ws.getString(18).length() > 10)
						{
							strExpDate = ws.getString(18);
						}

						if (formBean.getStrItemCategoryId().equals("10")) 
						{

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^0")
									.append("^").append(strExpDate).append("^")
									.append(ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39));
						} 
						else 
						{

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^")
									.append(ws.getString(37)).append("^")
									.append(strExpDate).append("^").append(
											ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39));

						}
						count = count + 1;

						sb.append("<tr> ");

						strHiddenVal = formBean.getStrHiddenVal();

						if (strHiddenVal.length() > 1) 
						{

							strHiddenValList = strHiddenVal.split("@");

							strChkList = new String[strHiddenValList.length];
							strQtyList = new String[strHiddenValList.length];
							strUnitList = new String[strHiddenValList.length];
							
							strHiddenTotalCost = new String[strHiddenValList.length];
							strHiddenCost = new String[strHiddenValList.length];
							
							//System.out.println("length::::::"+strHiddenValList.length);

							for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) 
							{
                               // System.out.println("Hidden val:::"+strHiddenValList[i]);
								strTemp = strHiddenValList[i].replace("^", "#").split("#");
                               
								strChkList[i] = new StringBuffer(strTemp[0])
										.append("^").append(strTemp[1]).append(
												"^").append(strTemp[2]).append(
												"^").append(strTemp[3]).append(
												"^").append(strTemp[4]).append(
												"^").append(strTemp[5]).append(
												"^").append(strTemp[6]).append(
												"^").append(strTemp[7]).append(
												"^").append(strTemp[8]).append(
												"^").append(strTemp[9]).append(
												"^").append(strTemp[10])
										.append("^").append(strTemp[11])
										.append("^").append(strTemp[12])
										.append("^").append(strTemp[13])
										.toString();

								        strQtyList[i] = strTemp[14];
								       strUnitList[i] = strTemp[15];
								     strHiddenCost[i] = strTemp[18];
								strHiddenTotalCost[i] = strTemp[19];
							}
						}

						if (strChkList != null) 
						{

							for (int i = 0, stopI = strChkList.length; i < stopI; i++) 
							{

								String content = strChkList[i];

								if (content.equalsIgnoreCase(strChkVal.toString())) 
								{

									            flag = true;
									   strTempQtyVal = strQtyList[i];
									  strTempUnitVal = strUnitList[i];
									
									    strTempCost  = strHiddenCost[i];
									strTempTotalCost = strHiddenTotalCost[i];
									

								}

							}

						}

						if (flag) 
						{

							sb.append("<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count
											+ "' checked='checked'  value='"
											+ strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\""
											+ count + "\");'> ");

						} 
						else
						{

							sb.append("<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count
											+ "' value='"
											+ strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\""
											+ count + "\");'> ");

						}

						sb.append("</td> ");
						
						String strRackNo = "-----";

						if (ws.getString(44) != null || ws.getString(44)!="")
						{
							strRackNo = ws.getString(44);
						}

						
						sb.append("<td class='multiPOControl' width='9%'>");   // Rack No::::
						sb.append(strRackNo);
						sb.append("</td> ");

						if (!formBean.getStrItemCategoryId().equals("10")) 
						{
							sb.append("<td class='multiPOControl' width='14%'>");
							sb.append(ws.getString(37));
							sb.append("</td> ");
						}

						sb.append("<td class='multiPOControl' width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>");
						sb.append(strExpDate);
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='14%'>");

						if (ws.getString(5) != null	&& !ws.getString(5).equals("null"))
							
							sb.append(ws.getString(5));

						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>");
						sb.append(ws.getString(9).split("\\ ")[0]);
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='7%'>");
						sb.append(ws.getString(45)+"/"+ws.getString(9).split("\\ ")[1]);
						sb.append("<input type='hidden' name='strRate' id='strRate"+count+"' value='"+ws.getString(23)+"'>");
						sb.append("<input type='hidden' name='strRate' id='strPurchaseRate"+count+"' value='"+ws.getString(45)+"'>");
						sb.append("</td> ");
						
						sb.append("<td class='multiPOControl' width='12%'>");

						if (flag) 
						{
                            // Method in issueDesk_trans.js File
							sb.append("<input type='text' class='txtFldMin' maxlength='7' value='"
											+ strTempQtyVal
											+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyTwo(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
											+ count + "'>");

						} 
						else 
						{

							sb.append("<input type='text' class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyTwo(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
											+ count + "'>");

						}

						sb.append("</td> ");
						
						sb.append("<td class='multiPOControl' width='8%'>");

						if (flag) 
						{

							sb.append("<select name='strAvailableQtyUnit' class='comboMin' id='strAvailableQtyUnit"  
											+ count
											+ "' onchange='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							MmsDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) 
							{

								sb.append(util.getOptionValue(vo.getStrUnitListWs(), strTempUnitVal,"", true, true));

							} 
							else 
							{

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						 } 
						else 
						{

							sb.append("<select name='strAvailableQtyUnit' disabled='disabled' class='comboMin' id='strAvailableQtyUnit"
											+ count
											+ "' onchange='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							MmsDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) 
							{

								sb.append(util.getOptionValue(vo.getStrUnitListWs(), vo.getStrUnitId(),"", true, true));

							} 
							else 
							{

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						}

						sb.append("</td> ");
						if (formBean.getUsrArg().equals("1")) // Means Budget Required
						{
							
									
									if (formBean.getStrItemCategoryId().equals("10")) 
									{
										sb.append("<td class='multiPOControl' width='14%'>");
										if (flag) 
										{
										     sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"+strTempCost+"' name='strStockCost' id='strStockCost"+count+"' >");
										     sb.append("<input type='hidden' value='"+strTempCost+"' name='strCost' id='strCost"+count+"' >");
										} 
										else
										{
											  sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"+count+"' >");
											  sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"+count+"' >");
										}	
				
									 } 
									else 
									{
			
										sb.append("<td class='multiPOControl' width='14%'>");
										if (flag) 
										{
										     sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"+strTempCost+"' name='strStockCost' id='strStockCost"+count+"' >");
										     sb.append("<input type='hidden' value='"+strTempCost+"' name='strCost' id='strCost"+count+"' >");
										} 
										else
										{
											  sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"+count+"' >");
											  sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"+count+"' >");
										}	
			
								}	
							sb.append("</td> ");
						}
				   	   

						
						sb.append("</tr> ");

						flag = false;

						strTempQtyVal = "";
						strTempUnitVal = "0";
					}

				}
				else 
				{

					sb.append("<tr> ");
					sb
							.append("<td colspan='8' class='multiPOControl'><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");
				if (formBean.getUsrArg().equals("1"))
				{
						sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td width='90%' class='LABEL'>Total Cost(Rs):</td> ");
						sb.append("<td width='13%' class='CONTROL' style='color: red; font-weight: bold'> ");
						sb.append("<input type='text' name='strTotalCostDivId' class='txtFldNormal'  value='"+strTempTotalCost+"'  disabled='disabled' id='strTotalCostDivId' >");
						sb.append("<input type='hidden' name='strApproxAmt' value='"+strTempTotalCost+"'></td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
				}
				

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='" + strTableWidth+ "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'><img style='cursor: pointer; ' ");
				sb.append(" src='../../hisglobal/images/btn-ok.png' ");
				sb.append(" onClick='return validatePopUp();' title='Save Record'/>  ");
				sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockDetails(this,\""	+ (count-1) + "\");' /> ");				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

			} 
			else 
				if (formBean.getStrModeVal().equals("2")) 
				{

				sb
						.append("<table width='"
								+ strTableWidth
								+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='HEADER'> ");

				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td colspan='4'>Drug Stock Details </td> ");

				} else {
					sb.append("<td colspan='4'>Item Stock Details </td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb
							.append("<td width='50%' colspan='2' class='LABEL'>Drug Name</td> ");

				} else {
					sb
							.append("<td width='50%' colspan='2' class='LABEL'>Item Name</td> ");
				}

				sb.append("<td width='50%' colspan='2' class='CONTROL'>"
						+ formBean.getStrItemName() + "</td> ");

				sb.append("</tr> ");
				sb.append("</table> ");

				sb
						.append("<table width='"
								+ strTableWidth
								+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='TITLE'> ");

				if (!formBean.getStrItemCategoryId().equals("10")) {
					sb.append("<td colspan='6'>Details</td> ");
				} else {
					sb.append("<td colspan='5'>Details</td> ");
				}
				sb.append("</tr> ");
				sb.append("<tr> ");

				if (!formBean.getStrItemCategoryId().equals("10")) {
					sb.append("<td class='multiLabel' width='14%'>Serial No. ");
					sb.append("</td> ");
				}

				sb.append("<td class='multiLabel' width='14%'>Batch/Serial No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'>Expiry Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'>Manufacturer ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'>Avl. Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'>Details ");
				sb.append("</td> ");
				sb.append("</tr> ");

				if (ws != null && ws.size() > 0) {

					while (ws.next()) {
						/*
						 * This part is added by Aritra on May 26, 2010. It will
						 * cause to produce distinct value for strStockDtlsChk
						 * checkbox, not appending with the value of previous
						 * check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						/*
						 * 11. Store id, 12. Generic Item Id 13. Item Id 14.
						 * Stock Status Code 15. Batch No.
						 */
						if (formBean.getStrItemCategoryId().equals("10")) {
							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^0");
						} else {

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^")
									.append(ws.getString(37));

						}

						sb.append("<tr> ");
						if (!formBean.getStrItemCategoryId().equals("10")) {
							sb.append("<td class='multiControl' width='14%'>");
							sb.append(ws.getString(37));
							sb.append("</td> ");
						}

						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(18));
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");

						if (ws.getString(5) != null
								&& !ws.getString(5).equals("null"))
							sb.append(ws.getString(5));

						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(9));
						sb.append("</td> ");

						sb.append("<td class='multiControl' width='14%'>");
						if (formBean.getStrItemCategoryId().equals("10")) 
						{

							int nFreeItem = Integer.parseInt(ws.getString(33));

							if (nFreeItem == 1) {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='showItemOtherDetailsPopup(\"1\",this,\""
												+ strChkVal + "\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='javascript:alert(\"No Free Item(s) Available\");'> ");
							}

						} 
						else 
						{

							int nFreeItem = Integer.parseInt(ws.getString(33));

							if (nFreeItem == 1) {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='showItemOtherDetailsPopup(\"1\",this,\""
												+ strChkVal + "\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='javascript:alert(\"No Free Item(s) Available\");'> ");
							}

							int nPartItem = Integer.parseInt(ws.getString(34));

							if (nPartItem == 1) {

								sb
										.append("<img style='cursor: pointer;' title='Part Items' height='20' width='20' src='../../hisglobal/images/partItems.jpg' onclick='showItemOtherDetailsPopup(\"2\",this,\""
												+ strChkVal + "\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Part Items' height='20' width='20' src='../../hisglobal/images/partItems.jpg' onclick='javascript:alert(\"No Part Item(s) Available\");'> ");
							}

							int nParamItem = Integer.parseInt(ws.getString(35));

							if (nParamItem == 1) {

								sb
										.append("<img style='cursor: pointer;' title='Item Parameters' height='20' width='20' src='../../hisglobal/images/parameters.jpg' onclick='showItemOtherDetailsPopup(\"3\",this,\""
												+ strChkVal + "\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Item Parameters' height='20' width='20' src='../../hisglobal/images/parameters.jpg' onclick='javascript:alert(\"Item Parameters Not Available\");'> ");
							}
							int nWarrenty = Integer.parseInt(ws.getString(36));

							if (nWarrenty == 1) {

								sb
										.append("<img style='cursor: pointer;' title='Warranty Details' height='20' width='20' src='../../hisglobal/images/warranty.jpg' onclick='showItemOtherDetailsPopup(\"4\",this,\""
												+ strChkVal + "\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Warranty Details' height='20' width='20' src='../../hisglobal/images/warranty.jpg' onclick='javascript:alert(\"No Warranty Details\");'> ");
							}

						}

						sb.append("</td> ");
						sb.append("</tr> ");

					}

				} else {

					sb.append("<tr> ");
					sb
							.append("<td colspan='8' class='multiControl'><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");

				sb
						.append("<table width='"
								+ strTableWidth
								+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'></td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='" + strTableWidth
						+ "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'>");
				if (formBean.getStrModeVal().equals("1")) {

					sb.append("<img style='cursor: pointer; ' ");
					sb.append(" src='../../hisglobal/images/btn-ok.png' ");
					sb
							.append(" onClick='return validatePopUp();' title='Save Record'/>  ");
				}

				sb
						.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb
						.append(" src='../../hisglobal/images/close_tab.png' onClick='hidePopup();' /> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

			} else if (formBean.getStrModeVal().equals("3")) {

				sb
						.append("<table width='"
								+ strTableWidth
								+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='HEADER'> ");

				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td colspan='4'>Drug Stock Details </td> ");

				} else {
					sb.append("<td colspan='4'>Item Stock Details </td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td width='50%' class='LABEL' >Drug Name</td> ");

				} else {
					sb.append("<td width='50%' class='LABEL >Item Name</td> ");
				}

				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrItemName() + "</td> ");
				/*
				 * sb.append("<td width='25%' class='LABEL'>Rate/Unit</td>
				 * "); sb.append("<td width='25%' class='CONTROL'>" +
				 * formBean.getStrRateUnit() + "<input type='hidden'
				 * name='strStockRateInBaseValue'
				 * value='"+formBean.getStrRateInBaseValue()+"'></td> ");
				 */
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='TITLE'> ");

				if (!formBean.getStrItemCategoryId().equals("10")) 
				{
					sb.append("<td colspan='9'>Details</td> ");
				}
				else
				{
					sb.append("<td colspan='9'>Details</td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='5%'># ");
				sb.append("</td> ");
				if (!formBean.getStrItemCategoryId().equals("10"))
				{
					sb.append("<td class='multiLabel' width='14%'>Serial No. ");
					sb.append("</td> ");
				}
				sb.append("<td class='multiLabel' width='16%'>Batch/Serial No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='16%'>Expiry Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='19%'>Manufacturer ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='19%'>Avl. Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'>Rate/Unit ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'><font color='red'>*</font>Counted Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='14%'><font color='red'>*</font>Unit ");
				sb.append("</td> ");
				//sb.append("<td class='multiLabel' width='14%'>Details ");
				//sb.append("</td> ");
				sb.append("</tr> ");
							
				// System.out.println("Size Of Physical Stock
				// Verification:::"+ws.size());
				if (ws != null && ws.size() > 0) {

					while (ws.next()) {

						/*
						 * This part is added by Aritra on May 26, 2010. It will
						 * cause to produce distinct value for strStockDtlsChk
						 * checkbox, not appending with the value of previous
						 * check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						/*
						 * 11. Store id, 12. Generic Item Id 13. Item Id 14.
						 * Stock Status Code 15. Batch No. 18. Expiry Date 19.
						 * Manufacture Date 20. Inhand Qty 21. Inhand Qty Unit
						 * Id 23. Rate 24. Rate Unit Id 37. Serial No. 38. Sale
						 * Price 39. Sale Price Unit Id 42 Rate/Base Unit 10
						 * Avail qty in base value
						 */

						String strExpDate = "";

						if (ws.getString(18) != null
								&& ws.getString(18).length() > 10) {
							strExpDate = ws.getString(18);
						}
						if (formBean.getStrItemCategoryId().equals("10")) {

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^0")
									.append("^").append(strExpDate).append("^")
									.append(ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39)).append("^")
									.append(ws.getString(43)).append("^")
									.append(ws.getString(42)).append("^")
									.append(ws.getString(10));
						} else {

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^")
									.append(ws.getString(37)).append("^")
									.append(strExpDate).append("^").append(
											ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39)).append("^")
									.append(ws.getString(43)).append("^")
									.append(ws.getString(42)).append("^")
									.append(ws.getString(10));

						}
						// System.out.println("strChkVal"+strChkVal);
						count = count + 1;

						sb.append("<tr> ");

						strHiddenVal = formBean.getStrHiddenVal();

						if (strHiddenVal.length() > 1) {

							strHiddenValList = strHiddenVal.split("@");

							strChkList = new String[strHiddenValList.length];
							strQtyList = new String[strHiddenValList.length];
							strUnitList = new String[strHiddenValList.length];

							for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) {

								// System.out.println("strHiddenValList"+i+strHiddenValList[i]);

								strTemp = strHiddenValList[i].replace("^", "#")
										.split("#");

								strChkList[i] = new StringBuffer(strTemp[0])
										.append("^").append(strTemp[1]).append(
												"^").append(strTemp[2]).append(
												"^").append(strTemp[3]).append(
												"^").append(strTemp[4]).append(
												"^").append(strTemp[5]).append(
												"^").append(strTemp[6]).append(
												"^").append(strTemp[7]).append(
												"^").append(strTemp[8]).append(
												"^").append(strTemp[9]).append(
												"^").append(strTemp[10])
										.append("^").append(strTemp[11])
										.append("^").append(strTemp[12])
										.append("^").append(strTemp[13])
										.append("^").append(strTemp[14])
										.append("^").append(strTemp[15])
										.append("^").append(strTemp[16])
										.toString();
								strQtyList[i] = strTemp[17];
								strUnitList[i] = new StringBuffer(strTemp[18])
										.append("^").append(strTemp[19])
										.append("^").append(strTemp[20])
										.toString();
							}
						}

						if (strChkList != null) {

							for (int i = 0, stopI = strChkList.length; i < stopI; i++) {

								String content = strChkList[i];

								if (content.equalsIgnoreCase(strChkVal
										.toString())) {

									flag = true;
									strTempQtyVal = strQtyList[i];
									strTempUnitVal = strUnitList[i];

								} else {
									// ystem.out.println("NOT OK");
								}

							}

						}
						if (flag) {

							sb
									.append(
											"<td class='multiControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk")
									.append(count)
									.append("' checked='checked'  value='")
									.append(strChkVal.toString())
									.append(
											"' onclick='checkStockDetails(this,\"")
									.append(count).append("\");'> ");

						} else {

							sb
									.append(
											"<td class='multiControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk")
									.append(count)
									.append("' value='")
									.append(strChkVal.toString())
									.append(
											"' onclick='checkStockDetails(this,\"")
									.append(count).append("\");'> ");

						}

						sb.append("</td> ");

						if (!formBean.getStrItemCategoryId().equals("10")) {
							sb.append("<td class='multiControl' width='14%'>");
							sb.append(ws.getString(37));
							sb.append("</td> ");
						}

						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");
						sb.append(strExpDate);
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");

						if (ws.getString(5) != null
								&& !ws.getString(5).equals("null"))
							sb.append(ws.getString(5));

						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(9));
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");
						sb.append(ws.getString(41));
						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");

						if (flag) {

							sb
									.append(
											"<input type='text' class='txtFldNormal' maxlength='7' value='")
									.append(strTempQtyVal)
									.append(
											"' onkeypress='return validateData(event,7);' onkeyup='checkAvailQty(\"")
									.append(count)
									.append(
											"\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty")
									.append(count).append("'>");

						} else {

							sb
									.append(
											"<input type='text' class='txtFldNormal' maxlength='7' value='0' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQty(\"")
									.append(count)
									.append(
											"\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty")
									.append(count).append("' >");

						}

						sb.append("</td> ");
						sb.append("<td class='multiControl' width='14%'>");

						if (flag) {

							sb
									.append(
											"<select name='strAvailableQtyUnit' id='strAvailableQtyUnit")
									.append(count)
									.append("' onchange='checkAvailQty(\"")
									.append(count)
									.append(
											"\",\"strAvailableQty\",\"strAvailableQtyUnit\");' class='comboMin'>");

							vo.setStrUnitId(ws.getString(21));
							vo
									.setStrHospitalCode(formBean
											.getStrHospitalCode());
							MmsDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null
									&& vo.getStrUnitListWs().size() > 0) {
								sb.append(util.getOptionValue(vo
										.getStrUnitListWs(), strTempUnitVal,
										"", true, true));

							} else {

								sb
										.append("<option value='0'>Select Value</option>");
							}

							sb.append("</select>");

						} else {

							sb
									.append(
											"<select name='strAvailableQtyUnit' disabled='disabled' id='strAvailableQtyUnit")
									.append(count)
									.append("' onchange='checkAvailQty(\"")
									.append(count)
									.append(
											"\",\"strAvailableQty\",\"strAvailableQtyUnit\");' class='comboMin'>");

							vo.setStrUnitId(ws.getString(21));
							vo
									.setStrHospitalCode(formBean
											.getStrHospitalCode());
							MmsDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null
									&& vo.getStrUnitListWs().size() > 0) {

								sb.append(util.getOptionValue(vo
										.getStrUnitListWs(), vo.getStrUnitId(),
										"", true, true));

							} else {

								sb
										.append("<option value='0'>Select Value</option>");
							}

							sb.append("</select>");

						}

						sb.append("</td> ");
						/**
						 * Commented By Amit On Date 04-March-2011[Un-Necessary information]
						 */
                        /*
						sb.append("<td class='multiControl' width='14%'>");
						
						if (formBean.getStrItemCategoryId().equals("1"))
						{

							int nFreeItem = Integer.parseInt(ws.getString(33));

							if (nFreeItem == 1) {

								sb
										.append(
												"<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='showItemOtherDetailsPopup(\"1\",this,\"")
										.append(strChkVal).append("\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='javascript:alert(\"No Free Item(s) Available\");'> ");
							}

						} 
						else 
						{

							int nFreeItem = Integer.parseInt(ws.getString(33));

							if (nFreeItem == 1) {

								sb
										.append(
												"<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='showItemOtherDetailsPopup(\"1\",this,\"")
										.append(strChkVal).append("\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Free Items' height='20' width='20' src='../../hisglobal/images/freeItems.jpg' onclick='javascript:alert(\"No Free Item(s) Available\");'> ");
							}

							int nPartItem = Integer.parseInt(ws.getString(34));

							if (nPartItem == 1) {

								sb
										.append(
												"<img style='cursor: pointer;' title='Part Items' height='20' width='20' src='../../hisglobal/images/partItems.jpg' onclick='showItemOtherDetailsPopup(\"2\",this,\"")
										.append(strChkVal).append("\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Part Items' height='20' width='20' src='../../hisglobal/images/partItems.jpg' onclick='javascript:alert(\"No Part Item(s) Available\");'> ");
							}

							int nParamItem = Integer.parseInt(ws.getString(35));

							if (nParamItem == 1) {

								sb
										.append(
												"<img style='cursor: pointer;' title='Item Parameters' height='20' width='20' src='../../hisglobal/images/parameters.jpg' onclick='showItemOtherDetailsPopup(\"3\",this,\"")
										.append(strChkVal).append("\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Item Parameters' height='20' width='20' src='../../hisglobal/images/parameters.jpg' onclick='javascript:alert(\"Item Parameters Not Available\");'> ");
							}
							int nWarrenty = Integer.parseInt(ws.getString(36));

							if (nWarrenty == 1) {

								sb
										.append(
												"<img style='cursor: pointer;' title='Warranty Details' height='20' width='20' src='../../hisglobal/images/warranty.jpg' onclick='showItemOtherDetailsPopup(\"4\",this,\"")
										.append(strChkVal).append("\");'> ");

							} else {

								sb
										.append("<img style='cursor: pointer;' title='Warranty Details' height='20' width='20' src='../../hisglobal/images/warranty.jpg' onclick='javascript:alert(\"No Warranty Details\");'> ");
							}

						}

						sb.append("</td> ");
						*/
						sb.append("</tr> ");

						flag = false;

						strTempQtyVal = "";
						strTempUnitVal = "0";
					}

				} else {

					sb.append("<tr> ");
					sb
							.append("<td colspan='9' class='multiControl'><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");

				sb
						.append("<table width='")
						.append(strTableWidth)
						.append(
								"' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb
						.append("<td colspan='4'>['*'] Reserved/Branded Item  <font size='2' color='red'>*</font> Mandatory Fields  </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='").append(strTableWidth)
						.append("' align='center'> ");
				sb.append("<tr> ");
				sb
						.append("<td align='center'><img style='cursor: pointer; ' ");
				sb.append(" src='../../hisglobal/images/btn-ok.png' ");
				sb
						.append(" onClick='return validatePhyStockPopUp();' title='Save Record'/>  ");
				sb
						.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb
						.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockDetails(),cancelPhyStockStockDetails();' /> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getIssueDtlsInitView(MmsVO vo,MmsFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;
		
		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			
			System.out.println("------------ MMSHLP.getIssueDtlsInitView ------[ Mode - "+formBean.getStrModeVal()+"]----------");
		
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "					
				//	+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_header_10811.png' ></div></td>");
			+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' ></div></td>");

			sb.append("</tr></table>");

			if (formBean.getStrModeVal().equals("3")) 
			{

				sb.append(
								"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");

			} 
			else 
				if 
				(formBean.getStrModeVal().equals("4")) 
				{
				sb
						.append(
								"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
			} 
			else 
			{
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{
				     sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details</b></font></td></tr></table> ");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth)
					.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details</b></font></td></tr></table> ");

					
				}	

			}

			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}
			
			
			sb.append("<table border='0' width='").append(strTableWidth)
					.append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
            /*   Hide Save Button by Amit 24-Sep-2010
			 
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <img style='cursor: pointer; ' title='Save Page'  ");
			sb.append(" src='../../hisglobal/images/save_all.png' onClick='saveData(\"").append(formBean.getStrIssueNo())
					.append("\");' /> <img style='cursor: pointer; ' title='Print Page'  ");
			*/
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				/*
				 * This is for Only Issue To
				  sb.append("<tr> ");
				  sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
			 	  sb.append("<td width='75%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueTo()).append("</b></font></td> ");
				 */
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4"))
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
							.append("</b></font></td> ");

					if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4"))
					{
										
					 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("CR No.", 15,0)).append(	":</b></font></td> ");
					 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrCrno()).append("</b></font></td> ");
					 
					}
					sb.append("</tr> ");
					
					if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4") && formBean.getStrModeVal().equals("1"))
					{
						/*
						 *             0 - General                                              Patient Category
								       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
								       2 - 0                                                    HRGNUM_IS_MLC            
								       3 - 0                                                    HRGNUM_ISNEWBORN  
								       4 - Sdds                                                 HRGSTR_FATHER_NAME
								       5 - 0                                                    HRGNUM_IS_DEAD
								       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
								       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
								       8 -                                                      HRGSTR_EMG_CNTC
								       9 - NO                                                   HRGNUM_ISNEWBORN 
								       10 - Dept Name                                            
								       11 - Dept Unit Name                                       
								       12 - Ward Name                                                      
								       13 - Room No                                             
								       14 - Bed No                                               
								       15 - Patient Catg                                         
								       16 - Consultant Name                                       
								       17 - IS New Born                                          
								       18 - Bill Catg 
								       19 - Addmission No
								       20 - Admission Date 
								       
						 * 
						 * */
					 String strAddmArr[] = formBean.getUsrArg().split("\\^");
					 
					 sb.append("<tr> ");
					 sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Patient Dtl :", 15,0)).append(strAddmArr[1])
								.append("</b></font></td> ");
					 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Category", 15,0)).append(	":</b></font></td> ");
					 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strAddmArr[0]).append("</b></font></td> ");
					 sb.append("</tr> ");
					 
					 sb.append("<tr> ");
					 sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Department Name :", 15,0)).append(strAddmArr[10])
								.append("</b></font></td> ");
					 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Unit Name", 15,0)).append(	":</b></font></td> ");
					 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strAddmArr[11]).append("</b></font></td> ");
					 sb.append("</tr> ");
		
					 
					 sb.append("<tr> ");
					 sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Ward Name :", 15,0)).append(strAddmArr[12])
								.append("</b></font></td> ");
					 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Room / Bed", 15,0)).append(	":</b></font></td> ");
					 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strAddmArr[13]+""+strAddmArr[14]).append("</b></font></td> ");
					 sb.append("</tr> ");
					 
					 sb.append("<tr> ");
					 sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Addmission No :", 15,0)).append(strAddmArr[19])
								.append("</b></font></td> ");
					 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Addmission Date", 15,0)).append(	":</b></font></td> ");
					 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strAddmArr[20]).append("</b></font></td> ");
					 sb.append("</tr> ");
					 
					}
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				}
				else
				{
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
						
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("", 15,0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
					}
					else
					{
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issuing Store :", 15,0)).append(formBean.getStrOrgName())
								.append("</b></font></td> ");	
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
					}
	
					
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					
				}	
			}
			else
			{
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if(formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6"))
				{
					if(formBean.getStrReturnReqNo()!=null && !formBean.getStrReturnReqNo().equals("") && !formBean.getStrReturnReqNo().equals("0"))
					{
						sb.append("<tr> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. No.", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrReturnReqNo()).append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. Date", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
					}
				}
					
	               
					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{
							returnTo = ws.getString(4);
							
						}
						ws.beforeFirst();
					}	
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							returnTo).append("</b></font></td> ");


					sb.append("</tr> ");
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

//			if (!formBean.getStrSlNoflg().equals("0")) 
//			{
//				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Serial No.</b></font> ");
//				sb.append("</td> ");
//			}

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{
				if(formBean.getStrModeVal().equals("2"))
				{
					sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sanc. Qty</b></font>");
					 sb.append("</td> ");
				}
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty/Approved Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{
//				  if(!formBean.getStrModeVal().equals("1"))
//				  {
//					  sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase Rate</b></font>");
//					  sb.append("</td> ");
//				  }
			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
				}
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				 sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	

					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
						//System.out.println("ws.getString(33)::::::::::::::::::::::"+ws.getString(33));
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
								{
									
									if(formBean.getStrModeVal().equals("1"))
									{
										strRemarks   = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}
								
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

//					if (!formBean.getStrSlNoflg().equals("0")) 
//					{
//						sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//						sb.append(ws.getString(22));
//						sb.append("</font></td> ");
//					}

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					if(formBean.getStrModeVal().equals("2"))
					{
						sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(37));
						sb.append("</font></td> ");
					}
					sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{
//						if(!formBean.getStrModeVal().equals("1")) //1 for issue to patient thru LP & 2 for issue desk
//						{
//							sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//							sb.append(strPurchaseCost);
//						}
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
					{
						/*  pkg_mms_view.proc_issue_detail [ Mode 1 ]
						 1.Issue No( Indent Store) , 
						 2.Issue Date 
						 3.Issue To (Pateint Name @ User) 
						 4.Issue Store Name To Issue To 
						 5.Generic name 
						 6.Drug name 
						 7.EXP_Date[DD-MON-YYYY] 
						 8. Rate/Unit 
						 9. Issue Qty/Unit 
						 10.Store Is 
						 11.Item_Id 
						 12. Brand_ID 
						 13.BATCH 
						 14. Exp_Date 
						 15. Rate 
						 16. Rate Unit Id 
						 17. Base Value 
						 18.Issue Qty 
						 19.Issue Qty Unit Id 
						 20.Qty Base Value 
						 21. Item Sl No 
						 22.SL_no 
						 23.Catg_Code 
						 24.Req_Type_Name 
						 25.RECIEVE_BY  
						 26.REMARKS 
						 27.BS_NO 
						 28.HSTSTR_LOCATION @ DL_NO 
						 29.HBLNUM_REQ_NO 
						 30.INDENT_NO^INDENT_DATE^ADMN_NO
						 31.HSTNUM_ICD_CODE 
						 32.SUPP_NAME 
						 33.OPERATION_DTL 
						 34.Issue_By_user_Name 
						 */			
						
						
						/* pkg_mms_view.proc_issue_detail [ Mode 2 ]
						  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
						  1.Issue No
						  2.Issue Date
						  3.Issue To 
						  4.Issue By
						  5.Generic Name
						  6.Brand Name
						  7.Batch No
						  8.Expiry date
						  9.Issue rate
						  10.Issue Qty
						  11.Store Id
						  12.Item Id
						  13.Item Brand ID
						  14.Batch No
						  15.Expiry Date
						  16.Issue Rate
						  17.Issue Rate Unit Id
						  18.Issue Rate Base Unit Id
						  19.Issue Qty
						  20.Issue Qty Unit Id
						  21.Issue Qty Base Value
						  22.Item Sl No
						  23.Item SL No
						  24,Category Code
						  25.Issue Qty
						  26.Remarks
						  27.Final remarks
						  28.Received By
						  29.Cost
						  30.Total Avl Budget
						  31.Indent No
						  32.Indent Date
						  33.Purchase Rate e.g 101 No.
						  34.Cost With Purchae Rate 
						  35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
						//System.out.println("IssueRatePercentage==>"+IssueRatePercentage);
						//System.out.println("Total Cost Of Item Without SC==>"+FinaltotalCostWithoutSc);
						//System.out.println("Total Cost of Ite With SC==>"+FinaltotalCost);
						
						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						//double serviceCharge        = totalCost *((IssueRatePercentage-100)/100);
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
						//System.out.println("Service Charge==>"+ServiceCharge);
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;
						
						//Below lines are commented by Adil Wasi, since Budget s not required in RAOL MMS. 
						/*sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Purchase Price(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(formatter.format(new BigDecimal(costWithoutServiceChag)));
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCostWithoutSc)));	
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(ServiceCharge)));				
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issue Value(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
						//sb.append(formatter.format(new BigDecimal(costWithServiceChag)));
						
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						
						sb.append("</tr>");	*/				
						
					}				 
					
				//	double           avlBudget = Double.parseDouble(formBean.getStrBudget());
										
					//double     remainingBudget = avlBudget - totalCost;
										
					//System.out.println(new BigDecimal(remainingBudget));  
						
					    
				//	String          finalBudget = formatter.format(new BigDecimal(remainingBudget));  
					
				//	double           budgetUsed = Double.parseDouble(strBudgetUsed);
					
				//	double      cumlativeBudget = budgetUsed + totalCost;
					
				//	String finalcumlativeBudget = formatter.format(new BigDecimal(cumlativeBudget));  
					
					//System.out.println("O/P::::"+f);// output --> 0.00007 
					
										 
				       
					/*sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cummulative Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalcumlativeBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");*/
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
	//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(
										")<br><b> &nbsp;&nbsp;</font></td> ");
					}
					else
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrUserName()).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");   
					        
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approval Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(formBean.getStrApprovalRemarks().trim());	
							sb.append("</font></td>");
					        sb.append("</tr> ");    
					        					       					        
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							sb.append("</tr> ");
							if(formBean.getStrModeVal().equals("2"))
					        {
							sb.append("<tr> ");
				        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Approval Remarks :<b>&nbsp;&nbsp;</font></td></tr> ");
				        	int lth = formBean.getStrApprovalRemarks().split("#").length;
				        	for(int q=0;q<lth;q++)
				        		sb.append("<tr><td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b> "+(q+1)+'.' +formBean.getStrApprovalRemarks().split("#")[q]+"<b>&nbsp;&nbsp;</font></td></tr> ");
				        	//sb.append("</tr> ");
					        }
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);	
								sb.append("<br></font></td>");
						        sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								
							}
							else
							{
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			
			System.out.println("------------ MMSHLP.getIssueDtlsInitView ------[ Mode - "+formBean.getStrModeVal()+"]-----END-----");
			

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}


	
	public static String getIssueDtlsInitViewNEW(MmsVO vo,MmsFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;
		
		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
		
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "					
				//	+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_header_10811.png' ></div></td>");
			+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' ></div></td>");

			sb.append("</tr></table>");
			

			if (formBean.getStrModeVal().equals("3")) 
			{

				sb.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");

			} 
			else 
				if 
				(formBean.getStrModeVal().equals("4")) 
				{
				sb
						.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
			} 
			else 
			{
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{
				     sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details</b></font></td></tr></table> ");
				}
				else
				{
					sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth)
					.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details</b></font></td></tr></table> ");

					
				}	

			}

			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE class='table' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}
			
			
			sb.append("<table border='0' width='").append(strTableWidth)
					.append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
            /*   Hide Save Button by Amit 24-Sep-2010
			 
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <img style='cursor: pointer; ' title='Save Page'  ");
			sb.append(" src='../../hisglobal/images/save_all.png' onClick='saveData(\"").append(formBean.getStrIssueNo())
					.append("\");' /> <img style='cursor: pointer; ' title='Print Page'  ");
			*/
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");
//					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							util.appendSpace("Request No.", 15,0)).append(":</b></font></td> ");
//					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							formBean.getStrIndentNo()).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				/*
				 * This is for Only Issue To
				  sb.append("<tr> ");
				  sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
			 	  sb.append("<td width='75%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueTo()).append("</b></font></td> ");
				 */
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4"))
				{
					
					
					//formBean.setUsrArg(formBean.getWsIssueDetails().getString(35));  // Pass Patient Hidden  Value
					/*
					 *  General
					 * ^Venkataappaiah Posani - 83 Yr/Male
					 * ^0
					 * ^0
					 * ^Hanumaiah
					 * ^0
					 * ^Hospital Management Information System
					 * ^12-MAR-2019 11:21:46
					 * ^-
					 * ^NO
					 * ^Dental
					 * ^Dental Unit 1
					 * ^General
					 * ^Cubicle 07
					 * ^Cub07 111
					 * ^General
					 * ^Navaneeth Y
					 * ^No
					 * ^0
					 * ^379132022000039
					 * ^03-Nov-2022 11:58:35
					 * 
					 */
					/*
					 * 0 - Dept Name                                            
				       1 - Dept Unit Name                                       
				       2 - Ward Name                                                      
				       3 - Room No                                             
				       4 - Bed No                                               
				       5 - Patient Catg                                         
				       6 - Consultant Name                                       
				       7 - IS New Born                                          
				       8 - Bill Catg 
				       9 - Addmission No
				      10 - Admission Date 						
					  11 - General                                              Patient Category
				      12 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
				      13 - 0                                                    HRGNUM_IS_MLC            
				      14 - 0                                                    HRGNUM_ISNEWBORN  
				      15 - Sdds                                                 HRGSTR_FATHER_NAME
				      16 - 0                                                    HRGNUM_IS_DEAD
				      17 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
				      18 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
				      19 -                                                      HRGSTR_EMG_CNTC
				      20 - NO                                                   HRGNUM_ISNEWBORN 
					 * 
					 * */
					
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
							.append("</b></font></td> ");
					if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4")){
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("CR No.:", 15,0)).append("</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrCrno()).append("</b></font></td> ");
					}
					sb.append("</tr> ");
					
					
					
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				}
				else
				{
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
						
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("", 15,0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
					}
					else
					{
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issuing Store :", 15,0)).append(formBean.getStrOrgName())
								.append("</b></font></td> ");	
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
					}
	
					
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					
				}	
			}
			else
			{
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if(formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6"))
				{
					if(formBean.getStrReturnReqNo()!=null && !formBean.getStrReturnReqNo().equals("") && !formBean.getStrReturnReqNo().equals("0"))
					{
						sb.append("<tr> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. No.", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrReturnReqNo()).append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. Date", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
					}
				}
					
	               
					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{
							returnTo = ws.getString(4);
							
						}
						ws.beforeFirst();
					}	
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							returnTo).append("</b></font></td> ");


					sb.append("</tr> ");
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

//			if (!formBean.getStrSlNoflg().equals("0")) 
//			{
//				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Serial No.</b></font> ");
//				sb.append("</td> ");
//			}

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{
//				  if(!formBean.getStrModeVal().equals("1"))
//				  {
//					  sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase Rate</b></font>");
//					  sb.append("</td> ");
//				  }
			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
				}
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				 sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	

					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
						System.out.println("ws.getString(33)::::::::::::::::::::::"+ws.getString(33));
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
								{
									
									if(formBean.getStrModeVal().equals("1"))
									{
										strRemarks   = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}
								
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

//					if (!formBean.getStrSlNoflg().equals("0")) 
//					{
//						sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//						sb.append(ws.getString(22));
//						sb.append("</font></td> ");
//					}

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{
//						if(!formBean.getStrModeVal().equals("1")) //1 for issue to patient thru LP & 2 for issue desk
//						{
//							sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//							sb.append(strPurchaseCost);
//						}
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
					{
						
						/*
						  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
						  1.Issue No
						  2.Issue Date
						  3.Issue To 
						  4.Issue By
						  5.Generic Name
						  6.Brand Name
						  7.Batch No
						  8.Expiry date
						  9.Issue rate
						  10.Issue Qty
						  11.Store Id
						  12.Item Id
						  13.Item Brand ID
						  14.Batch No
						  15.Expiry Date
						  16.Issue Rate
						  17.Issue Rate Unit Id
						  18.Issue Rate Base Unit Id
						  19.Issue Qty
						  20.Issue Qty Unit Id
						  21.Issue Qty Base Value
						  22.Item Sl No
						  23.Item SL No
						  24,Category Code
						  25.Issue Qty
						  26.Remarks
						  27.Final remarks
						  28.Received By
						  29.Cost
						  30.Total Avl Budget
						  31.Indent No
						  32.Indent Date
						  33.Purchase Rate e.g 101 No.
						  34.Cost With Purchae Rate 
						  35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
						//System.out.println("IssueRatePercentage==>"+IssueRatePercentage);
						//System.out.println("Total Cost Of Item Without SC==>"+FinaltotalCostWithoutSc);
						//System.out.println("Total Cost of Ite With SC==>"+FinaltotalCost);
						
						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						//double serviceCharge        = totalCost *((IssueRatePercentage-100)/100);
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
						//System.out.println("Service Charge==>"+ServiceCharge);
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;
						
						//Below lines are commented by Adil Wasi, since Budget s not required in RAOL MMS. 
						/*sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Purchase Price(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(formatter.format(new BigDecimal(costWithoutServiceChag)));
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCostWithoutSc)));	
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(ServiceCharge)));				
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issue Value(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
						//sb.append(formatter.format(new BigDecimal(costWithServiceChag)));
						
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						
						sb.append("</tr>");	*/				
						
					}				 
					
				//	double           avlBudget = Double.parseDouble(formBean.getStrBudget());
										
					//double     remainingBudget = avlBudget - totalCost;
										
					//System.out.println(new BigDecimal(remainingBudget));  
						
					    
				//	String          finalBudget = formatter.format(new BigDecimal(remainingBudget));  
					
				//	double           budgetUsed = Double.parseDouble(strBudgetUsed);
					
				//	double      cumlativeBudget = budgetUsed + totalCost;
					
				//	String finalcumlativeBudget = formatter.format(new BigDecimal(cumlativeBudget));  
					
					//System.out.println("O/P::::"+f);// output --> 0.00007 
					
										 
				       
					/*sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cummulative Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalcumlativeBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");*/
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
	//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(
										")<br><b> &nbsp;&nbsp;</font></td> ");
					}
					else
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrIssueTo().split("@")[1]).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							System.out.println("check Params::"+formBean.getStrFinalRemarks());
							
							
							/*if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().equals(" ")||!formBean.getStrFinalRemarks().equals(null))
							{
							    sb.append(formBean.getStrFinalRemarks().trim());
							} 
							else
							{
								sb.append("--------");	
							}	*/
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");      
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							
							sb.append("</tr> ");
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);	
								sb.append("<br></font></td>");
						        sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								
							}
							else
							{
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}

	
	public static String getDuplicateIssueDtlsInitViewNEW(MmsFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;
		
		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			//sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			if (formBean.getStrModeVal().equals("3")) 
			{

				sb.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details(Duplicate)</b></font></td></tr></table> ");

			} 
			else 
				if 
				(formBean.getStrModeVal().equals("4")) 
				{
				sb
						.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge(Duplicate)</b></font></td></tr></table> ");
			} 
			else 
			{
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{
				     sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details(Duplicate)</b></font></td></tr></table> ");
				}
				else
				{
					sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth)
					.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details(Duplicate)</b></font></td></tr></table> ");

					
				}	

			}

			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE class='table' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}
			
			
			sb.append("<table border='0' width='").append(strTableWidth)
					.append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
            /*   Hide Save Button by Amit 24-Sep-2010
			 
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <img style='cursor: pointer; ' title='Save Page'  ");
			sb.append(" src='../../hisglobal/images/save_all.png' onClick='saveData(\"").append(formBean.getStrIssueNo())
					.append("\");' /> <img style='cursor: pointer; ' title='Print Page'  ");
			*/
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='left' style='padding-left:30px;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='50%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font>"+strIssueDate+"</td> ");
				/*
				 * sb.
				 * append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				 * ).append().append( "</b></font></td> ");
				 */
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");
//					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							util.appendSpace("Request No.", 15,0)).append(":</b></font></td> ");
//					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							formBean.getStrIndentNo()).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				/*
				 * This is for Only Issue To
				  sb.append("<tr> ");
				  sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
			 	  sb.append("<td width='75%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueTo()).append("</b></font></td> ");
				 */
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4"))
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='left' style='padding-left:30px;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
							.append("</b></font></td> ");
//					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
//					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
//							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4")){
					sb.append("<td width='50%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("CR No.:", 15,0)).append("</b></font>"+formBean.getStrCrno()+"</td> ");
						/*
						 * sb.
						 * append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						 * ).append( ).append("</b></font></td> ");
						 */
					}
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				}
				else
				{
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
						
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("", 15,0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
					}
					else
					{
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issuing Store :", 15,0)).append(formBean.getStrOrgName())
								.append("</b></font></td> ");	
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
					}
	
					
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					
				}	
			}
			else
			{
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if(formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6"))
				{
					if(formBean.getStrReturnReqNo()!=null && !formBean.getStrReturnReqNo().equals("") && !formBean.getStrReturnReqNo().equals("0"))
					{
						sb.append("<tr> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. No.", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrReturnReqNo()).append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. Date", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
					}
				}
					
	               
					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{
							returnTo = ws.getString(4);
							
						}
						ws.beforeFirst();
					}	
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							returnTo).append("</b></font></td> ");


					sb.append("</tr> ");
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

//			if (!formBean.getStrSlNoflg().equals("0")) 
//			{
//				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Serial No.</b></font> ");
//				sb.append("</td> ");
//			}

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{
//				  if(!formBean.getStrModeVal().equals("1"))
//				  {
//					  sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase Rate</b></font>");
//					  sb.append("</td> ");
//				  }
			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
				}
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				 sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	

					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
						System.out.println("ws.getString(33)::::::::::::::::::::::"+ws.getString(33));
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
								{
									
									if(formBean.getStrModeVal().equals("1"))
									{
										strRemarks   = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}
								
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

//					if (!formBean.getStrSlNoflg().equals("0")) 
//					{
//						sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//						sb.append(ws.getString(22));
//						sb.append("</font></td> ");
//					}

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{
//						if(!formBean.getStrModeVal().equals("1")) //1 for issue to patient thru LP & 2 for issue desk
//						{
//							sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//							sb.append(strPurchaseCost);
//						}
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
					{
						
						/*
						  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
						  1.Issue No
						  2.Issue Date
						  3.Issue To 
						  4.Issue By
						  5.Generic Name
						  6.Brand Name
						  7.Batch No
						  8.Expiry date
						  9.Issue rate
						  10.Issue Qty
						  11.Store Id
						  12.Item Id
						  13.Item Brand ID
						  14.Batch No
						  15.Expiry Date
						  16.Issue Rate
						  17.Issue Rate Unit Id
						  18.Issue Rate Base Unit Id
						  19.Issue Qty
						  20.Issue Qty Unit Id
						  21.Issue Qty Base Value
						  22.Item Sl No
						  23.Item SL No
						  24,Category Code
						  25.Issue Qty
						  26.Remarks
						  27.Final remarks
						  28.Received By
						  29.Cost
						  30.Total Avl Budget
						  31.Indent No
						  32.Indent Date
						  33.Purchase Rate e.g 101 No.
						  34.Cost With Purchae Rate 
						  35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
						//System.out.println("IssueRatePercentage==>"+IssueRatePercentage);
						//System.out.println("Total Cost Of Item Without SC==>"+FinaltotalCostWithoutSc);
						//System.out.println("Total Cost of Ite With SC==>"+FinaltotalCost);
						
						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						//double serviceCharge        = totalCost *((IssueRatePercentage-100)/100);
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
						//System.out.println("Service Charge==>"+ServiceCharge);
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;
						
						//Below lines are commented by Adil Wasi, since Budget s not required in RAOL MMS. 
						/*sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Purchase Price(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(formatter.format(new BigDecimal(costWithoutServiceChag)));
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCostWithoutSc)));	
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(ServiceCharge)));				
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issue Value(Rs.)</b></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
						//sb.append(formatter.format(new BigDecimal(costWithServiceChag)));
						
						sb.append("</font></td>");
						sb.append("<td colspan='1' align='center'></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='center'></td>");
						sb.append("<td colspan='3' align='right'><hr size='2' width='50%'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
						
						sb.append("</tr>");	*/				
						
					}				 
					
				//	double           avlBudget = Double.parseDouble(formBean.getStrBudget());
										
					//double     remainingBudget = avlBudget - totalCost;
										
					//System.out.println(new BigDecimal(remainingBudget));  
						
					    
				//	String          finalBudget = formatter.format(new BigDecimal(remainingBudget));  
					
				//	double           budgetUsed = Double.parseDouble(strBudgetUsed);
					
				//	double      cumlativeBudget = budgetUsed + totalCost;
					
				//	String finalcumlativeBudget = formatter.format(new BigDecimal(cumlativeBudget));  
					
					//System.out.println("O/P::::"+f);// output --> 0.00007 
					
										 
				       
					/*sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cummulative Budget(Rs.)</b></td>");
					sb.append("<td colspan='2'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(finalcumlativeBudget)));				
					sb.append("</font></td>");
					sb.append("<td colspan='1' align='center'></td>");
					sb.append("</tr>");*/
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
	//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(
										")<br><b> &nbsp;&nbsp;</font></td> ");
					}
					else
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrIssueTo().split("@")[1]).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							System.out.println("check Params::"+formBean.getStrFinalRemarks());
							
							
							/*if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().equals(" ")||!formBean.getStrFinalRemarks().equals(null))
							{
							    sb.append(formBean.getStrFinalRemarks().trim());
							} 
							else
							{
								sb.append("--------");	
							}	*/
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");      
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							
							sb.append("</tr> ");
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);	
								sb.append("<br></font></td>");
						        sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								
							}
							else
							{
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}

	
	
	
	/**
	 * Gets the free and part item dtls view.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param viewMode
	 *            the view mode
	 * 
	 * @return the free and part item dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getFreeAndPartItemDtlsView(MmsFB formBean,
			String viewMode) throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsItemOtherDtls();

		String strTableWidth = "350";

		try {

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='0px' cellspacing='0px'> ");
			sb.append("<tr class='HEADER'> ");

			if (viewMode.equals("1")) {

				sb.append("<td colspan='3'>Free Item Details </td> ");

			} else {
				sb.append("<td colspan='3'>Part Item Details </td> ");
			}

			sb
					.append("<td align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/close_tab.png' onClick='hide_popup_menu(\"itemOtherDtlsDiv\");'></td>");

			sb.append("</tr> ");

			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr> ");

			sb.append("<td class='multiLabel' width='25%'>Item Name ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='25%'>Batch/Serial No. ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='25%'>Expiry Date ");
			sb.append("</td> ");

			if (viewMode.equals("1")) {

				sb.append("<td class='multiLabel' width='25%'>Free Qty. ");
				sb.append("</td> ");

			} else {

				sb.append("<td class='multiLabel' width='25%'>Part Qty. ");
				sb.append("</td> ");
			}

			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					sb.append("<tr> ");

					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(1));
					sb.append("</td> ");
					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(2));
					sb.append("</td> ");
					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(3));
					sb.append("</td> ");
					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(4));
					sb.append("</td> ");
					sb.append("</tr> ");

				}

			} else {

				sb.append("<tr> ");
				sb
						.append("<td colspan='4' class='multiControl'><font color='red'><b>Details Not Available</b></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='FOOTER'> ");
			sb.append("<td colspan='4'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the item warranty dtls view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the item warranty dtls view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getItemWarrantyDtlsView(MmsFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsItemOtherDtls();

		String strTableWidth = "350";

		try {

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='0px' cellspacing='0px'> ");
			sb.append("<tr class='HEADER'> ");

			sb.append("<td colspan='2'>Item Warranty Details </td> ");
			sb
					.append("<td align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/close_tab.png' onClick='hide_popup_menu(\"itemOtherDtlsDiv\");'></td>");
			sb.append("</tr> ");

			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr> ");

			sb.append("<td class='multiLabel' width='25%'>Warranty Date ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='25%'>Warranty Upto ");
			sb.append("</td> ");
			sb.append("<td class='multiLabel' width='25%'>Manufacturer ");
			sb.append("</td> ");
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					sb.append("<tr> ");

					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(1));
					sb.append("</td> ");
					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(2));
					sb.append("</td> ");
					sb.append("<td class='multiControl' width='25%'>");
					sb.append(ws.getString(3));
					sb.append("</td> ");
					sb.append("</tr> ");

				}

			} else {

				sb.append("<tr> ");
				sb
						.append("<td colspan='3' class='multiControl'><font color='red'><b>Details Not Available</b></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='FOOTER'> ");
			sb.append("<td colspan='4'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the free or part item init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param viewMode
	 *            the view mode
	 * 
	 * @return the free or part item init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getFreeOrPartItemInitView(MmsFB formBean,
			String viewMode) throws Exception {

		StringBuffer sb = new StringBuffer("");

		String strTableWidth = "600";

		try {

			sb
					.append("<table width='")
					.append(strTableWidth)
					.append(
							"' align='center' cellpadding='1px' cellspacing='1px' cellspacing='1px'> ");
			sb.append("<tr class='HEADER'> ");

			if (viewMode.equals("1")) {

				sb.append("<td colspan='2'>Free Item Details</td> ");
			} else {
				sb.append("<td colspan='2'>Component Item Details</td> ");
			}

			sb.append("</tr> ");
			sb.append("</table> ");

			sb
					.append(" <table width='")
					.append(strTableWidth)
					.append(
							"' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>Item Category</td> ");
			sb
					.append("<td class='CONTROL' width='25%'><select name='strOtherItemCategory' onchange='getGroupList(this);' class='comboNormal'>");
			sb.append(formBean.getStrItemCategoryList());
			sb.append("</select></td> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>Group </td> ");
			sb
					.append("<td class='CONTROL' width='25%'><div id='otherItemGroupDivId'><select name='strOtherItemGroup' class='comboNormal'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='LABEL' width='25%'>Sub Group</td> ");
			sb
					.append("<td class='CONTROL' width='25%'><div id='otherItemSubGroupDivId'><select name='strOtherItemSubGroup' class='comboNormal'><option value='0'>Select Value</option></select></div></td> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>Generic Item Name </td> ");
			sb
					.append("<td class='CONTROL' width='25%'><div id='otherGenItemDivId'><select name='strOtherGenericItem' class='comboNormal'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>Item Name </td> ");
			sb
					.append("<td class='CONTROL' width='25%'><div id='otherItemDivId'><select name='strOtherItem' class='comboNormal'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("<td class='LABEL'> ");

			if (formBean.getStrIsBatchReq().equals("1")) {

				sb.append("<font color='red'>*</font>Batch/Serial No.");
				sb
						.append("<input type='hidden' name='isOtherBatchReq' value='1'></td> ");

			} else {
				sb.append("Batch/Serial No.");
				sb
						.append("<input type='hidden' name='isOtherBatchReq' value='0'></td> ");
			}

			sb
					.append("<td class='CONTROL' width='25%'><input type='text' name='strOtherItemBatchNo' maxlength='20' class='txtFldMax' ");
			sb.append(" onkeypress='return validateData(event,17);' /></td> ");
			sb.append("</tr> ");
			sb.append(" <tr> ");

			sb.append(" <td class='LABEL' width='25%'>Manufacture Date</td> ");
			sb
					.append(" <td class='CONTROL'  width='25%'><input type='text' name='strOtherManufDate' class='txtFldDate' ></td> ");

			sb.append(" <td class='LABEL'> ");

			if (formBean.getStrIsExpDtReq().equals("1")) {

				sb.append("<font color='red'>*</font>Expiry Date");
				sb
						.append("<input type='hidden' name='isOtherExpDtReq' value='1'></td> ");

			} else {
				sb.append("Expiry Date ");
				sb
						.append(" <input type='hidden' name='isOtherExpDtReq' value='0'></td> ");
			}
			sb
					.append("<td class='CONTROL' width='25%'><input type='text' name='strOtherExpiryDate' class='txtFldDate' ></td> ");

			sb.append("</tr> ");
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>InHand Quantity</td> ");
			sb
					.append("<td class='CONTROL' width='25%'><input type='text' name='strOtherInHandQuantity' maxlength='8' class='txtFldMin' onkeyup='validateOtherDtlsQty(\"strOtherInHandQuantity\", \"strOtherInHandQuantityUnitID\");' ");
			sb.append(" onkeypress='return validateData(event,5);' /></td> ");
			sb
					.append("<td class='LABEL' width='25%'><font color='red'>*</font>InHand Quantity Unit</td> ");
			sb
					.append("<td class='CONTROL' width='25%'><div id='otherInHandQtyUnitDivId'><select name='strOtherInHandQuantityUnitID' class='comboNormal' onchange='validateOtherDtlsQty(\"strOtherInHandQuantity\", \"strOtherInHandQuantityUnitID\");' > ");
			sb.append(" <option value='0'>Select Value</option> ");
			sb.append(" </select></div> ");
			sb.append(" </td> ");
			sb.append("</tr> ");

			if (viewMode.equals("2")) {

				sb.append("<tr> ");
				sb
						.append("<td class='LABEL' width='25%'><font color='red'>*</font>Component Type</td> ");
				sb
						.append(
								"<td class='CONTROL' width='25%'><select id='strItemOtherDtlsComponentTypeId' name='strItemOtherDtlsComponentType' class='comboNormal'>")
						.append(formBean.getStrComponentTypeList()).append(
								"</select></td> ");
				sb
						.append("<td class='LABEL' width='25%'>Separate Entity</td> ");
				sb
						.append("<td class='CONTROL' width='25%'><input type='checkbox' id='strItemOtherDtlsSeparateEntityId' name='strItemOtherDtlsSeparateEntity' value='1'></td> ");

				sb.append("</tr> ");

				sb.append("<tr> ");
				sb
						.append("<td class='LABEL' width='25%'>Warranty Period</td> ");
				sb
						.append("<td class='CONTROL' width='25%'><input type='text' id='strItemOtherDtlsWarrantyPeriodId' name='strItemOtherDtlsWarrantyPeriod' value='' class='txtFldMin' maxlength='3' onkeypress='return validateData(event,5);'></td> ");
				sb.append("<td class='LABEL' width='25%'>Warranty Unit</td> ");
				sb
						.append("<td class='CONTROL' width='25%'><select id='strItemOtherDtlsWarrantyUnitId' name='strItemOtherDtlsWarrantyUnit' class='comboNormal'><option value='0'>Select Value</option><option value='1'>Days</option><option value='2'>Months</option><option value='3'>Years</option></select></td> ");

				sb.append("</tr> ");

				sb.append("<tr> ");
				sb
						.append("<td class='LABEL' colspan='2' width='25%'><font color='red'>*</font>Manufacturer</td> ");
				sb
						.append("<td class='CONTROL' colspan='2' width='25%'><div id='itemOtherDtlsManufDivId'><select name='strItemOtherDtlsManufactureId' class='comboNormal'><option value='0'>Select Value</option></select></div></td> ");

				sb.append("</tr> ");
			}
			sb.append("</table> ");

			sb
					.append("<table width='")
					.append(strTableWidth)
					.append(
							"' align='center' cellpadding='1px' cellspacing='1px' cellspacing='1px'> ");
			sb.append("<tr class='FOOTER'> ");
			sb.append("<td colspan='2'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			sb
					.append(" <table width='")
					.append(strTableWidth)
					.append(
							"' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
			sb.append(" <tr> ");
			sb
					.append(" <td align='center'><img style='cursor: pointer; ' ");
			sb
					.append(
							" src='../../hisglobal/images/btn-add.png' onClick='validateAndAddItemOtherDtls(\"")
					.append(viewMode).append("\");' /> ");
			sb
					.append(" <img style='cursor: pointer; ' src='../../hisglobal/images/close_tab.png' onClick='hideItemOtherDtlsView();' /></td> ");
			sb.append(" </tr> </table> ");

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();
	}


	public static String getFreeOrPartItemInitViewNEW(MmsFB formBean,
			String viewMode) throws Exception {

		StringBuffer sb = new StringBuffer("");

		String strTableWidth = "600";

		try {

			sb
				.append("<div class='row rowFlex reFlex' style='width:")
				.append(strTableWidth)
				.append("'>");
			sb
					.append("<table width='")
					.append(strTableWidth)
					.append(
							"' align='center' style='color:rgba(75, 75, 75, 0.7);backgroung-color:rgba(162, 159, 159, 0.7);' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr class='font-weight-bold'> ");

			if (viewMode.equals("1")) {

				sb.append("<td colspan='2'>Free Item Details</td> ");
			} else {
				sb.append("<td colspan='2'>Component Item Details</td> ");
			}

			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div>");
			
			//sb.append("<div class='row rowFlex reFlex'>");
			sb
					.append(" <table width='")
					.append(strTableWidth)
					.append(
							"' align='center' style='color:rgba(75, 75, 75, 0.7);' border='0' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Item Category</td> ");
			sb
					.append("<td class='' width='25%'><select name='strOtherItemCategory' onchange='getGroupList(this);' class='form-control'>");
			sb.append(formBean.getStrItemCategoryList());
			sb.append("</select></td> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Group </td> ");
			sb
					.append("<td class='' width='25%'><div id='otherItemGroupDivId'><select name='strOtherItemGroup' class='form-control'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='font-weight-bold' width='25%'>Sub Group</td> ");
			sb
					.append("<td class='' width='25%'><div id='otherItemSubGroupDivId'><select name='strOtherItemSubGroup' class='form-control'><option value='0'>Select Value</option></select></div></td> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Generic Item Name </td> ");
			sb
					.append("<td class='' width='25%'><div id='otherGenItemDivId'><select name='strOtherGenericItem' class='form-control'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Item Name </td> ");
			sb
					.append("<td class='' width='25%'><div id='otherItemDivId'><select name='strOtherItem' class='form-control'><option value='0'>Select Value</option></select></div></td> ");
			sb.append("<td class='font-weight-bold'> ");

			if (formBean.getStrIsBatchReq().equals("1")) {

				sb.append("<font color='red'>*</font>Batch/Serial No.");
				sb
						.append("<input type='hidden' name='isOtherBatchReq' value='1'></td> ");

			} else {
				sb.append("Batch/Serial No.");
				sb
						.append("<input type='hidden' name='isOtherBatchReq' value='0'></td> ");
			}

			sb
					.append("<td class='' width='25%'><input type='text' name='strOtherItemBatchNo' maxlength='20' class='form-control' ");
			sb.append(" onkeypress='return validateData(event,17);' /></td> ");
			sb.append("</tr> ");
			sb.append(" <tr> ");

			sb.append(" <td class='font-weight-bold' width='25%'>Manufacture Date</td> ");
			sb
					.append(" <td class=''  width='25%'><input type='text' name='strOtherManufDate' class='form-control' ></td> ");

			sb.append(" <td class='font-weight-bold'> ");

			if (formBean.getStrIsExpDtReq().equals("1")) {

				sb.append("<font color='red'>*</font>Expiry Date");
				sb
						.append("<input type='hidden' name='isOtherExpDtReq' value='1'></td> ");

			} else {
				sb.append("Expiry Date ");
				sb
						.append(" <input type='hidden' name='isOtherExpDtReq' value='0'></td> ");
			}
			sb
					.append("<td class='' width='25%'><input type='text' name='strOtherExpiryDate' class='form-control' ></td> ");

			sb.append("</tr> ");
			sb.append("<tr> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>InHand Quantity</td> ");
			sb
					.append("<td class='' width='25%'><input type='text' name='strOtherInHandQuantity' maxlength='8' class='form-control' onkeyup='validateOtherDtlsQty(\"strOtherInHandQuantity\", \"strOtherInHandQuantityUnitID\");' ");
			sb.append(" onkeypress='return validateData(event,5);' /></td> ");
			sb
					.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>InHand Quantity Unit</td> ");
			sb
					.append("<td class='' width='25%'><div id='otherInHandQtyUnitDivId'><select name='strOtherInHandQuantityUnitID' class='form-control' onchange='validateOtherDtlsQty(\"strOtherInHandQuantity\", \"strOtherInHandQuantityUnitID\");' > ");
			sb.append(" <option value='0'>Select Value</option> ");
			sb.append(" </select></div> ");
			sb.append(" </td> ");
			sb.append("</tr> ");

			if (viewMode.equals("2")) {

				sb.append("<tr> ");
				sb
						.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Component Type</td> ");
				sb
						.append(
								"<td class='' width='25%'><select id='strItemOtherDtlsComponentTypeId' name='strItemOtherDtlsComponentType' class='form-control'>")
						.append(formBean.getStrComponentTypeList()).append(
								"</select></td> ");
				sb
						.append("<td class='font-weight-bold' width='25%'>Separate Entity</td> ");
				sb
						.append("<td class='' width='25%'><input type='checkbox' id='strItemOtherDtlsSeparateEntityId' name='strItemOtherDtlsSeparateEntity' value='1'></td> ");

				sb.append("</tr> ");

				sb.append("<tr> ");
				sb
						.append("<td class='font-weight-bold' width='25%'>Warranty Period</td> ");
				sb
						.append("<td class='' width='25%'><input type='text' id='strItemOtherDtlsWarrantyPeriodId' name='strItemOtherDtlsWarrantyPeriod' value='' class='form-control' maxlength='3' onkeypress='return validateData(event,5);'></td> ");
				sb.append("<td class='font-weight-bold' width='25%'>Warranty Unit</td> ");
				sb
						.append("<td class='' width='25%'><select id='strItemOtherDtlsWarrantyUnitId' name='strItemOtherDtlsWarrantyUnit' class='form-control'><option value='0'>Select Value</option><option value='1'>Days</option><option value='2'>Months</option><option value='3'>Years</option></select></td> ");

				sb.append("</tr> ");

				sb.append("<tr> ");
				sb
						.append("<td class='font-weight-bold' width='25%'><font color='red'>*</font>Manufacturer</td> ");
				sb
						.append("<td class='' width='25%'><div id='itemOtherDtlsManufDivId'><select name='strItemOtherDtlsManufactureId' class='form-control'><option value='0'>Select Value</option></select></div></td> ");

				sb.append("</tr> ");
			}
			sb.append("</table> ");

			/*
			 * sb .append("<table width='") .append(strTableWidth) .append(
			 * "' align='center' cellpadding='1px' cellspacing='1px' cellspacing='1px'> ");
			 * sb.append("<tr class=''> "); sb.append("<td colspan='2'></td> ");
			 * sb.append("</tr> "); sb.append("</table> ");
			 */

			sb.append("<div class='row rowFlex reFlex'>");
			sb.append("<div class='col-md-12' align='center'>");
			sb.append("<button type='button' class='btn btn-info mt-1' title='Add'");
			sb
			.append(
					"onClick='validateAndAddItemOtherDtls(\"")
			.append(viewMode).append("\");' /> ");
			sb.append("<i class='fas fa-check'></i></button>");
			/*
			 * sb .append(" <table width='") .append(strTableWidth) .append(
			 * "' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
			 * sb.append(" <tr> "); sb .append(" <td align='center'><i></i> "); sb .append(
			 * "onClick='validateAndAddItemOtherDtls(\"")
			 * .append(viewMode).append("\");' /> ");
			 */
			sb.append("<button type='button' class='btn btn-danger mt-1' onClick='hideItemOtherDtlsView();'> <i class='fas fa-times' title='Cancel'></i> </button></td> ");
			//sb.append(" </tr> </table> ");
			 sb.append("</div>");
			 sb.append("</div>");
		} catch (Exception e) {

			throw e;
		}

		return sb.toString();
	}

	
	
	/**
	 * Gets the free or part item init modify view.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param viewMode
	 *            the view mode
	 * 
	 * @return the free or part item init modify view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getFreeOrPartItemInitModifyView(MmsFB formBean,
			String viewMode) throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsItemOtherDtls();

		String strWidth = "20%";
		String strHiddenFieldName="strItemOtherDtls";
		
		if("1".equals(formBean.getStrOtherItemMode())) {
			
			strHiddenFieldName = "strItemOtherDtls";
			
		}else if("2".equals(formBean.getStrOtherItemMode())) {
			strHiddenFieldName = "strItemPartDtls";
		}

		if (viewMode.equals("2")) {
			strWidth = "15%";
		}

		int count = 0;

		String strTableWidth = "TABLEWIDTH";

		try {

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					count = count + 1;

					String strIndex = formBean.getStrLayerIndex() + "-" + count;

					sb.append(" <div id='id").append(strIndex).append("'> ");
					sb
							.append("<table class='")
							.append(strTableWidth)
							.append(
									"' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb
							.append("<td class='multiControl' width='")
							.append(strWidth)
							.append(
									"'><input type='hidden' name='"+strHiddenFieldName+"' id='"+strHiddenFieldName+"")
							.append(strIndex).append("' value='").append(
									ws.getString(1)).append("'>");

					if (viewMode.equals("1")) {

						sb.append(ws.getString(2));

					} else {

						sb.append(ws.getString(7));

						sb.append("</td> ");

						sb.append("<td class='multiControl' width='").append(
								strWidth).append("'>");
						sb.append(ws.getString(2));
						sb.append("</td> ");

					}

					sb.append("</td> ");
					sb.append("<td class='multiControl' width='").append(
							strWidth).append("'>");

					if (ws.getString(3) != null)
						sb.append(ws.getString(3));

					sb.append("</td> ");

					sb.append("<td class='multiControl'  width='").append(
							strWidth).append("'>");

					if (viewMode.equals("2")) {

						if (ws.getString(6) != null)
							sb.append(ws.getString(6));

						sb.append("</td> ");

						sb.append("<td class='multiControl' width='15%'>");

					}

					if (ws.getString(4) != null)
						sb.append(ws.getString(4));

					sb.append("</td> ");
					sb.append("<td class='multiControl' width='20%'>").append(
							ws.getString(5));
					sb.append("</td> ");
					sb
							.append("<td class='multiControl' width='5%'><img src='../../hisglobal/images/minus.gif' ");
					sb.append(" onClick='deleteRow(\"").append(strIndex)
							.append("\",\"")
							.append(formBean.getStrLayerIndex()).append(
									"\",\"0\");' ");
					sb.append(" style='cursor: pointer; ' /> ");
					sb.append("</td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
					sb.append("</div> ");

				}

			}

			sb.append("@@").append(ws.size());

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();
	}

	
	public static String getNewItemAddDetails(MmsFB formBean,
			String strHiddenVal) throws Exception {

		String strTableWidth = "700";

		String strIsStoreBound = strHiddenVal.replace("^", "#").split("#")[4];

		StringBuffer sb = new StringBuffer("");

		sb.append("<table width='").append(strTableWidth).append(
				"' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr class='HEADER'> ");
		sb.append("<td colspan='4'>New Items &gt;&gt; Add</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");

		sb.append("<div id='newItemErrorPartDivId' style='display:none'>");
		sb.append("<table width='").append(strTableWidth).append(
				"' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr class='multiControl'> ");
		sb
				.append("<td colspan='4'><div id='newItemErrorContentDivId' style='color:red;font-weight:bold;color:white;background-color:red;' ></div></td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		sb.append("</div> ");

		
		sb.append("<table width='").append(strTableWidth).append(
		"' align='center' cellpadding='1px' cellspacing='1px'> ");
		
				
		if(formBean.getStrNewItemFlag().trim().equals("2")){
			
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' colspan='2' ><font color='red'>*</font>Item Name</td> ");
			sb
					.append("<td class='CONTROL' colspan='2' ><input type='hidden' name='strDefaultUnitId' value='"+MmsConfigUtil.UNIT_ID_PATNA+"' ><input type='text' class='txtFldMax' maxlength='100' name='strNewItemName' onkeypress='return validateData(event,4);' ></td> ");
			sb.append("</tr> ");
			
		}else{
			
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' ><font color='red'>*</font>Item Name</td> ");
			sb
					.append("<td class='CONTROL'><input type='text' class='txtFldMax' maxlength='100' name='strNewItemName' onkeypress='return validateData(event,4);' ></td> ");
			sb
					.append("<td class='LABEL' ><font color='red'>*</font>Item Type</td> ");
			sb
					.append(
							"<td class='CONTROL'> <select name='strNewItemType' class='comboNormal' >")
					.append(formBean.getStrItemTypeList()).append(
							"</select> </td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb
					.append("<td class='LABEL' ><font color='red'>*</font>Item Make</td> ");
			sb
					.append("<td class='CONTROL'><select name='strNewItemMake' class='comboNormal' ><option value='1'>Indian</option> <option value='2'>Foreign</option> </select></td> ");
			sb
					.append("<td class='LABEL' ><font color='red'>*</font>Manufacturer</td> ");
			sb
					.append(
							"<td class='CONTROL'><select name='strNewItemManufacturer' class='comboMax' >")
					.append(formBean.getStrManufacturerList()).append(
							"</select></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td class='LABEL' >Whether Quantifiable</td> ");
			sb
					.append("<td class='CONTROL'><input type='checkbox'  name='strNewItemIsQuantifiable' checked='checked' value='1'></td> ");
			sb.append("<td class='LABEL' >Whether Set/Sachet</td> ");
			sb
					.append("<td class='CONTROL'><input type='checkbox'  name='strNewItemIsSetSachet' value='1'></td> ");
			sb.append("	</tr> ");
			sb.append("	<tr> ");
			sb
					.append("	<td colspan='2' class='LABEL' ><font color='red'>*</font>Specification</td> ");
			sb
					.append("	<td colspan='2' class='CONTROL'><textarea name='strNewItemSpecification' cols='25' rows='2' onkeypress='return validateData(event,9);' ></textarea></td> ");
			sb.append("	</tr> ");

			if (strIsStoreBound.equals("1")) {

				sb.append("	<tr class='TITLE'> ");
				sb.append("	<td colspan='4'>Store Item Details</td> ");
				sb.append("	</tr> ");
				sb.append("<tr> ");
				sb
						.append("<td colspan='2' class='LABEL' ><font color='red'>*</font>Short Name</td> ");
				sb
						.append("	<td colspan='2' class='CONTROL'><input type='text' class='txtFldNormal' maxlength='20' name='strNewItemShortName' onkeypress='return validateData(event,18);' ></td> ");
				sb.append("</tr> ");
				sb.append("	<tr> ");
				sb
						.append("	<td class='LABEL' ><font color='red'>*</font>Re-Order / Max Level</td> ");
				sb
						.append("	<td class='CONTROL'> <input type='text' class='txtFldNormal' maxlength='10' name='strNewItemReorderLevel' onkeypress='return validateData(event,7);' > / <input type='text' class='txtFldNormal' maxlength='10' name='strNewItemMaxLevel' onkeypress='return validateData(event,7);' >  </td> ");
				sb
						.append("	<td class='LABEL' ><font color='red'>*</font>Unit</td> ");
				sb
						.append(
								"	<td  class='CONTROL'><select name='strNewItemLevelUnit' class='comboNormal' >")
						.append(formBean.getStrUnitList())
						.append("</select></td> ");
				sb.append("	</tr> ");

			}
			
			
			
		}
		
		
		
		
		sb.append("<tr class='FOOTER'> ");
		sb
				.append(" <td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
		sb.append("</tr> ");
		sb.append("</table> ");

		sb.append("<table border='0' width='").append(strTableWidth).append(
				"' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb.append("<td align='center'> ");
		sb
				.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-sv.png' title='Save Record' onClick=' return saveNewItemDetails();'/> ");
		sb
				.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-clr.png' title='Reset Content' onClick='resetNewItemDetails();'/> ");
		sb
				.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-ccl.png' title='Cancel Process' onClick='cancelAddNewItemPopup();'/> ");
		sb.append("<input type='hidden' name='strAddNewItemHiddenVal' value='")
				.append(strHiddenVal).append("'>");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");

		return sb.toString();

	}
	
	public static String getPrintItemDetails(WebRowSet ws,String hosCode) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "";
		String strMrnDate = "";
		String strPONo="";
		String strPODate="";
		String strInvNo="";
		String strInvDate="";
		String strVendor="",strdcno="";
		String strItem="";
		String strSup="",strRej="",strRcd="";
		String strAmount="0.00";
		double tot = 0.000,tmpRcd=0.0;
		String strOrderQty="";
		String strExpiryDt="",strbtch="",strmrp="",strPurRate="",strUser="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
	//	double cltamt  = 0.00;
	///	double totalCost = 0.00;
		
	//	double cltamt1  = 0.00;
		//double totalCostWithoutSC = 0.00;
		
		
	//	String strStoreName="";
	//	 String returnTo="";
		int i=1;
	//	String strItemTotCost="0.00";
	//	String strItemTotCostWithOutSC ="0.00";
	//	String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
		
		//String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		//WebRowSet ws = formBean.getWsIssueDetails();
        
		//String strIssueDate = "";

//		if (formBean.getStrIssueDate().length() > 2) 
//		{
//			strIssueDate = formBean.getStrIssueDate();
//		}
//		
		String strTableWidth = "700";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
		//	System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			//sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("Material Receipt Note </font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<br> ");
			sb.append("<br> ");
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();
				strMrnNo              = ws.getString("lpno");
				strMrnDate            = ws.getString("lpdate");
				strPONo  		 	  = ws.getString("lpno");
				strPODate	  		  = ws.getString("dcdate");
				strInvNo  		 	  = ws.getString("invno");
				strInvDate	  		  = ws.getString("invdate");
				strVendor             = ws.getString("supp");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>LP No. : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnNo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>LP Date. : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate +"</b></font></td>");
				sb.append("</tr> ");
				
			//	sb.append("<tr><td width='100%'>--------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				//sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DC No.  : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No.: </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strInvNo+"</b></font></td>");
				sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strInvDate+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='5'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("</table> ");
				
			
			
			sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No..</b></font></td>");
			sb.append("<td align='center' width='28%' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
			sb.append("<td align='center' width='5%'  colspan='7'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sup. Qty</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rej. Qty</b></font></td>");
			sb.append("<td align='center' width='8%' colspan=2><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'></td>");
			/*sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Generic</b></font></td>");*/
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
			//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Manufacturer Name</b></font></td>");
			//sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
			sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
			sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur. Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			sb.append("</tr> ");
			
			ws.beforeFirst();

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	
						
						strItem				  = ws.getString("brnd");
						strSup				  = ws.getString("qty");
						//strRej				  = ws.getString("rej_qty");
						//strRcd				  = ws.getString("rcd_qty");
						strAmount			  = ws.getString("rate");
						//strOrderQty			  = ws.getString("po_qty");
						strmrp				  = ws.getString("mrp");
						strExpiryDt			  = ws.getString("expiry");
						strbtch 			  = ws.getString("batch");
						strPurRate			  = ws.getString("pur_rate");
						//strBrandId			  = ws.getString("id");
						//strBal				  = ws.getString("bal_qty");
						stritemTax				  = ws.getString("tax");
						//strRateWithTax = ws.getString("RATE_WITH_TAX");
						//manuf = ws.getString("manuf");
						
						//if(strBrandId.equals(tmpId))
						//	tmpRcd = tmpRcd+Double.parseDouble(strRcd);
						//else
						//	tmpRcd = Double.parseDouble(strRcd);
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(stritemTax);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strPurRate);
					sb.append("</font></td> ");
					/*
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRateWithTax);
					sb.append("</font></td> ");*/
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strSup);
					sb.append("</font></td> ");
					/*sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+Math.round(Double.parseDouble(strSup))+"</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strBal+"</font></td> ");*/
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strAmount);
					sb.append("</font></td></tr> ");
					
					
					
					i++;
					tot=tot+Math.round((Double.parseDouble(ws.getString("rate")) * Double.parseDouble(strSup))*100.0)/100.0;
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='11'></td>");
				sb.append("<td align='center' colspan='13'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisUtil.getAmountWithDecimal(tot, 3)+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
////			sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
			sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By <br><b> &nbsp;&nbsp;</font></td> ");
				//sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Checked By <br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>signature<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
////				sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("</table>");
				
			}
				
				
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}

	public static String getDBData(WebRowSet wb,String hosCode) 
	{
		StringBuffer br = null;
		int i=0,x=0 ;
		
		try 
		{
			br = new StringBuffer();
			//System.out.println("size-----------"+wb.size());
			
			if(wb.size()>0)
			{
				//System.out.println("wb.size-------"+wb.size());
				//br.append("<div class='tracking-item' id='item'>");
				
				String id="opdbg";
				while(wb.next())
				{
					/*
					 * id="opdbg"; if(x%2==0) id="ipdbg";
					 * 
					 * br.append("<div class='tracking-content' id='"+id+"'><span id='job'>"+wb.
					 * getString(1)+"</span><span id='job'>"+wb.getString(2)+"</span></div>");
					 * br.append("<br>"); x++;
					 */
					
					if(i==3) 
					{
							i=0;
					}
					
					String[] arr= {"00B5B8 ","FF7588","16D39A"};
					
					if(x!=0 && x%3==0 )
						br.append("</div><div class='row'>");
					if(x==0)
						br.append("<div class='row'>");
					
					
					br.append("<div class='col-sm-4'>");
					br.append("<div class='card' style='background-color:#"+arr[i]+";color:white;'>");
					br.append("<div class='card-content'>");
					br.append("<div class='card-body'>");
					br.append("<div class='media d-flex'>");
					
					if(x==0) 
					{
						br.append("<div class='media-body text-left'>");
						br.append("<h6 class='success'>Database Size</h6>");
						br.append("<span>"+wb.getString(1)+"</span>");
						br.append("<h6 class='success'>"+wb.getString(2)+"</h6>");
						br.append("</div>");
						br.append("<div class='align-self-center'>");
						br.append("<i class='fas fa-database' style='font-size:50px;'></i>");
						br.append("</div>");
					}
					else 
					{
						br.append("<div class='media-body text-left'>");
						br.append("<h6 class='success'>Large Tables Size</h6>");
						br.append("<span>"+wb.getString(1)+"</span>");
						br.append("<h6 class='success'>"+wb.getString(2)+"</h6>");
						br.append("</div>");
						br.append("<div class='align-self-center'>");
						br.append("<i class='fas fa-table' style='font-size:50px;'></i>");
						br.append("</div>");
					}
					br.append("</div></div></div></div></div>");
					i++;
					x++;
					
				}
				/*
				 * if(wb.size()%3!=0) br.append("</div>");
				 */
				//br.append("</div>");
				
			}
			else
			{
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR ENTERED DATA </div>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		finally 
		{
			if (wb != null)
				wb = null;
		}
		return br.toString();
	}
}
