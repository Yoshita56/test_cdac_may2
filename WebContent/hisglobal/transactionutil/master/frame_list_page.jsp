  <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%String strJs = "";
			String str1 = "";
			String cmb[] = null;
			String str = "";
			try {
				str1 = (String) request.getParameter("no_of_combo");
				cmb = (String[]) request.getAttribute("combo");
				str = "";
				if (cmb != null) {
					for (int i = 0; i < cmb.length; i++) {
						str += "<input type='hidden' name='cmb' value="
								+ cmb[i] + ">";
					}
				}
				strJs = (String) request.getAttribute("js");
				if (strJs == null)
					strJs = "";
			} catch (Exception e) {
				System.out.println("e = " + e);
			}
%>
<html>
<head>
<meta charset=utf-8>
<link href="../../transactionutil/css/master.css" rel="stylesheet"
	type="text/css">
<script language="JavaScript" src="../../transactionutil/js/master.js"></script>
<script type="text/javascript">

	//The following variables used for view poup functionality
	var child = null;
	var popIndex = 0;
	var gblCntrlObj = null;

	window.history.forward(1);
	//window.document.onkeydown = _suppressKeyPress(event);
	function _suppressKeyPress(e){
	keys = new Array();
	keys[0] = 'Ctrl';
	keys[1] = 'Backspace';
	saveCode="";
	if (window.event)
		key = window.event.keyCode;
	else
		key = e.which;
	if(key == 116){
		saveCode = key;
		key = 505;
	}
	if(key == 505){
		alert('Ctrl has been disabled');
		return false;
	}
	if(window.event && key == 8 && !window.document.activeElement.isTextEdit){
	alert("window.event.keyCode"+key);
	saveCode=window.event.keyCode;
	window.event.keyCode = 506;
	}
	if(window.event && key == 506){
	alert('Backspace has been disabled');
	return false;
	}
}
</script>
</head>
<body onload='fetchRecords(null,null,null);'
	onkeyup="searchData(event);"
	onKeyDown="return _suppressKeyPress(event);" onFocus="checkPopUp_master();" onUnload="closePopUp_master();">
<html:form action='<%=request.getParameter("cnt_page")%>'>
	<TABLE ALIGN="center" WIDTH="100%" CELLPADDING="1" CELLSPACING="1"
		BORDER="1">
		<TR>
			<TD ALIGN="center" width="100%">
			<div id="comboId"></div>
			</TD>
		</TR>
		<TR>
			<TD ALIGN="center">
			<DIV ID="message" ALIGN="top"></DIV>
			</TD>
		</TR>
		<TR>
			<TD ALIGN="center">

			<DIV ID="start" ALIGN="top"></DIV>
			</TD>
		</TR>
	</TABLE>
	
	<DIV style="display: block;" ID="searchid" ALIGN="top"></DIV>
	<div id='footer' style='display:none'></div>
	<table align=center width="100%">
		<tr>
			<td class='addtoolbar' height='23' align='center' id="buttonID"></td>
		</tr>
	</table>
	
	<input type="hidden" name="totalpage">
	<input type="hidden" name="record_per_page">
	<input type="hidden" name="counter" value='1111'>
	<input type="hidden" name="no_of_combo" value='<%=str1%>'>
	<input type="hidden" name="actual_page_block">
	<input type="hidden" name="nextBlock">
	<input type="hidden" name="prevBlock">
	<input type="hidden" name="divisionId" value="">
	<input type="hidden" name="divid">
	<input type="hidden" name="hmode">
	<input type="hidden" name="flag" value='1'>
	<input type="hidden" name="comboValue">
	<input type="hidden" name="chkValue" value="">
	<input type="hidden" name="chkLength" value="0">
	<input type="hidden" name="cnt_page"
		value='<%=request.getParameter("cnt_page")%>'>
	<%=str%>
</html:form>
</body>
</html>
