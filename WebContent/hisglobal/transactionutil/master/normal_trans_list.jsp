  <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<HTML>
<HEAD>
<%String str1 = (String) request.getParameter("no_of_combo");
			String cmb[] = (String[]) request.getAttribute("combo");

			String str = "";
			if (cmb != null) {
				for (int i = 0; i < cmb.length; i++) {
					str += "<input type='hidden' name='cmb' value=" + cmb[i]
							+ ">";
				}
			}

			String strJs = (String) request.getAttribute("js");
			if (strJs == null)
				strJs = "";

			%>
<TITLE><%=request.getAttribute("masterName")%> List Page</TITLE>
<meta charset=utf-8>
<script type="text/javascript">

	//The following variables used for view poup functionality
	var child = null;
	var popIndex = 0;
	var gblCntrlObj = null;

	window.history.forward(1);
	//window.document.onkeydown = _suppressKeyPress(event);
	function _suppressKeyPress(e){
	var key;
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

<script language="JavaScript" src="../../hisglobal/transactionutil/js/master.js"></script>
<script language="JavaScript" src="<%=strJs%>"></script>

<link href="../../hisglobal/transactionutil/css/master.css" rel="stylesheet"
	type="text/css">

</HEAD>

<BODY onload='fetchRecords(null,null,null);' class='bodycolor'
	onkeyup="searchData(event);"
	onKeyDown="return _suppressKeyPress(event);" onFocus="checkPopUp_master();" onUnload="closePopUp_master();">
<html:form action='<%=(String)request.getAttribute("cnt_page")%>'>
	<!--	<jsp:include page="/hisglobal/jsp/header.jsp"></jsp:include>-->
	<input type="hidden" name="totalpage">
	<TABLE ALIGN="center" class="TABLEWIDTH" CELLPADDING="1"
		CELLSPACING="1" BORDER="1">
		<TR>
			<TD ALIGN="center">
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
		<tr>
			<td width="90%">
			<DIV ID="searchid" ALIGN="top"></DIV>
			</td>
		</tr>
		<TR>
			<TD>
			<div id='footer' style='display:none'></div>
			</TD>
		</TR>
	
		<tr>
			<td class='addtoolbar' height='23' align='center' id="buttonID"></td>
		</tr>
	</table>
	
	<input type="hidden" name="record_per_page">
	<input type="hidden" name="counter" value='0'>
	<input type="hidden" name="no_of_combo" value='<%=str1%>'>
	<input type="hidden" name="actual_page_block">
	<input type="hidden" name="nextBlock">
	<input type="hidden" name="prevBlock">
	<input type="hidden" name="divisionId">
	<input type="hidden" name="divid">
	<input type="hidden" name="hmode">
	<input type="hidden" name="flag" value='1'>
	<input type="hidden" name="comboValue">
	<input type="hidden" name="chkValue" value="">
	<input type="hidden" name="chkLength" value="0">
	<input type="hidden" name="cnt_page"
		value='<%=request.getAttribute("cnt_page")%>'>
	<%=str%>
</html:form>
</BODY>

</HTML>
