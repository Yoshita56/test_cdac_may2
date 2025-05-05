  <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<%String str1 = (String) request.getParameter("no_of_combo");
			String cmb[] = (String[]) request.getAttribute("combo");
			String str = "";
			if (cmb != null) {
				for (int i = 0; i < cmb.length; i++) {
					str += "<input type='hidden' name='cmb' value=" + cmb[i]+ ">";
				}
			}
			String cmbReset[] = (String[]) request.getAttribute("comboReset");
			String strReset = "";
			if (cmbReset != null) {
				for (int i = 0; i < cmbReset.length; i++) {
					strReset += "<input type='hidden' name='comboReset' value=" + cmbReset[i]+ ">";
				}
			}
			
			String strJs = (String) request.getAttribute("js");
			if (strJs == null)
				strJs = "";
%>

<html>
<head>
<meta charset=utf-8>
<title><%=request.getAttribute("masterName")%></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<link rel="stylesheet" href="../../hisglobal/bootstrap/css/bootstrap.min.css">  
<link href="../../hisglobal/DataTables/css/dataTables.bootstrap4.min.css" rel="stylesheet">
	
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script type="text/javascript" src="../../hisglobal/DataTables/js/dataTables.buttons.min.js"></script>


	<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
	<!-- ADD VALIDATION.JS ON SECURITY 27-mar-2018 -->
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/transactionutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/transactionutil/js/button.js"></script>
<script language="JavaScript" src="<%=strJs%>"></script>

<style>
.affix {
  top: 0px;
  z-index: 9999 !important;
}
html{
	overflow-x: hidden;
}
#mainTablea1_length{
	text-align: left;
}
#mainTablea1_info{
	text-align: left;
	color: #0237c0;
	font-size: 1.3em;
}
#mainTablea1_paginate{
	font-size: 1.3em;
}
.buttonsCls{
	margin-right: 1px;
}
#mainTablea1_wrapper{
	font-size: 12px;
}
#mainTablea1{
	font-size: 12px;
}
#comboId select[name="combo"]{
	max-width: 220px;
}
#combosDiv #combosTable tr td b{
	font-weight: normal;
	text-transform: uppercase;
	font-size:13px;
}
.dt-buttons{
	float: left;
	padding-left: 10px;
}
#footer .ShadedTitleTagImage td div > font{
	font-size: 14px;
}
</style>

<script language="JavaScript" type="text/javascript">

function setPersistenceValues(){
document.forms[0].searchColumn.value='<%=request.getParameter("searchColumn")%>'
document.forms[0].search.value='<%=request.getParameter("search")%>'
}

function checkChangeDiv(){
var divisionId	=	'<%=request.getParameter("divisionId")%>'

changeDiv(divisionId);

}

//The following variables used for view poup functionality
var child = null;
var popIndex = 0;
var gblCntrlObj = null;
window.history.forward(1);

function _suppressKeyPress(e){
		keys = new Array();
		keys[0] = 'Ctrl';
		//keys[1] = 'Backspace';
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
function hideMenu()
{
		if(document.getElementsByName("strVisibilityMode")[0].value=="1")
		{
			hideMenuFrame();
		}

}
function hideMenuFrame()
{	
//alert("parent.document.getElementById('fs2').cols="+parent.document.getElementById("fs2").cols)
	if(window.XMLHttpRequest) // Mozilla
	{
		if(parent.document.getElementById("fs2").cols == "230,*")
		{
			parent.document.getElementById("fs2").cols = "0,*";
			parent.document.getElementById("f7").contentDocument.getElementById("Image").src="../hisglobal/images/arrsingle-right.png";
		}
	}
	//if (window.ActiveXObject)
	else
	{
		if(parent.document.getElementById("fs2").cols == "230,*")
		{
			parent.document.getElementById("fs2").cols = "0,*";
			parent.document.getElementById("f7").Document.getElementById("Image").src="../hisglobal/images/arrsingle-right.png";
		}
	}	
}
function showMenuFrame()
{	
//alert("showMenuFrame in reg");
	if(window.XMLHttpRequest) // Mozilla
	{
		parent.document.getElementById("fs2").cols = "230,*";
		parent.document.getElementById("f7").contentDocument.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
	}
	//if (window.ActiveXObject)
	else
	{
		parent.document.getElementById("fs2").cols = "230,*";
		parent.document.getElementById("f7").Document.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
	}	
}

function filterBlckTggl(e,event){
	$('.topHeaderTbl').slideToggle('4000'); 
}
var masterName = "<%=(String)request.getAttribute("masterName")%>";

</script>
</head>

<%
String blockNo=request.getParameter("blockNo");
String rowNum=request.getParameter("rowNum");
String prevNext=request.getParameter("prevNext") ;
String functionname="fetchRecords(null,null,null)";

if(blockNo != null && !blockNo.equals(""))
	functionname="fetchRecords('m^"+blockNo+"^0','"+rowNum+"','"+prevNext+"')";


	
%>

<body onload="setPersistenceValues();<%=functionname %>;hideMenu();" onkeydown="searchData(event);" onKeyDown="return _suppressKeyPress(event);" onFocus="checkPopUp_master();" onUnload="closePopUp_master();">
<html:form action='<%=(String)request.getAttribute("cnt_page")%>'>


	<table height="35px" width="100%" cellpadding="0" cellspacing="0" style="background-color: #efefef;">
		<tbody><tr><td class="ShadedTitleTagImage" width='100%'>
			<table height="100%" width="100%" cellpadding="2" cellspacing="0">
				<tbody>
				<%-- <tr>
					<td valign="top" width="30%" align="left"></td>
					<td width="30%"><div id="doctorDeskHeader" align="center"><%=(String)request.getAttribute("masterName")%></div></td>
					<td width="40%"><div id="divPatDeskStatistics" align="right"></div></td>
				</tr> --%>
				<tr> 
					<th width="40%">
						<div id="doctorDeskHeader" align="left" style="text-transform:uppercase;color:steelblue; padding-left:5px;"><%=(String)request.getAttribute("masterName")%>
						</div>
					</th> 
					<td width="60%" style="padding-top: 5px;">
						<tiles:insert attribute="menu" />
					</td>
				</tr> 
				</tbody>
			</table>
		</td></tr>
	</tbody></table>
	<div class="row topHeaderTbl">
		<div class="col-sm-12">
			<br>
			<div id="comboId" style="margin-bottom: 5px;"></div>
		</div>
	</div>
	
	<table align="center" width="100%" CELLPADDING="0" CELLSPACING="0"  style="border: 0px solid #013157; border-collapse: collapse;margin-top: 10px;">
<%-- 		<tr>
			<td valign="top" width="100%" colspan='3'><div id="comboId" ></div></td>
		</tr>
		<tr>
			<td colspan="1" width='3%' valign="top"><tiles:insert attribute="menu" /></td>
			<td colspan="2" width='97%' valign="top"><tiles:insert attribute="ListPage" /></td>				
		</tr> --%>
		<tr>
			<td colspan='3' width='100%'><tiles:insert attribute="ListPage" /></td>				
		</tr>
		<tr>
			<%String strAlign = (String) request.getAttribute("buttonConfig");
				if(strAlign==null || strAlign.equals(""))
					strAlign = "left";
				if (strAlign.equalsIgnoreCase("left")) {

				%>
				
				<td colspan="1" width='3%' valign="top"><tiles:insert attribute="menu" /></td>
				<td colspan="2" width='97%' valign="top"><div onmouseover="if(child!=null) {child.close();}" ><tiles:insert attribute="ListPage" /></div></td>		
			
			<!--  <td valign="top" width="10%"></td>
			<td  colspan="2" valign="top" width="85%"><div onmouseover="if(child!=null) {child.close();}" ><tiles:insert attribute="ListPage" /></div></td>-->
			<%} else if (strAlign.equalsIgnoreCase("right")) {

				%>
				<td colspan="2" width='97%' valign="top"><div onmouseover="if(child!=null) {child.close();}" ><tiles:insert attribute="ListPage" /></div></td>
				<td colspan="1" width='3%' valign="top"><tiles:insert attribute="menu" /></td>				
				
			<!--<td valign="top" width="85%"><div onmouseover="if(child!=null) {child.close();}"><tiles:insert attribute="ListPage" /></div></td>
			<td colspan="2" valign="top" width="10%"></td>-->
			<%} else if (strAlign.equalsIgnoreCase("both")) {

				%>
				
				<td colspan="1" width='3%' valign="top"><tiles:insert attribute="menu" /></td>
				<td colspan="1" width='94%' valign="top"><div onmouseover="if(child!=null) {child.close();}" ><tiles:insert attribute="ListPage" /></div></td>
				<td colspan="1" width='3%' valign="top"><tiles:insert attribute="menu1" /></td>	
				
			<!--<td valign="top"></td>
			<td valign="top"><div onmouseover="if(child!=null) {child.close();}"><tiles:insert attribute="ListPage" /></div></td>
			<td valign="top"></td>-->
			<%}%>
		</tr>
	
	
		<tr>
			<td colspan="3" width="100%">
			<DIV ID="searchid" ALIGN="top"></DIV>
			</td>
		</tr>
	
		<tr>
			<td colspan="3">
			<div id='footer' style='display:none'></div>
			<div class="col-sm-12" style="font-size: 13px;">
				<p><b>Instructions : </b>Please select the correct filters (store etc) options to populate data, Search would work on filtered records, Sorting option is on right side for each column, Please <a href='javascript:;' onclick='window.parent.tabRefresh();'>refresh</a> the page in case page is not loaded.  <!-- Click on <a style="text-decoration:none;" href="javascript:;" onclick="$('.prevPageBtn').click();">...Latest</a> and <a style="text-decoration:none;" href="javascript:;" onclick="$('.nextPageBtn').click();">Older...</a> to switching pages. --> </p>
			   <!-- Click on <a style="text-decoration:none;" href="javascript:;" onclick="$('.prevPageBtn').click();">...prev</a> and <a style="text-decoration:none;" href="javascript:;" onclick="$('.nextPageBtn').click();">more...</a> to switching pages. --> 
			</div>
			</td>
		</tr>
	</table>
	
	<table align="center" width="100%" border="0" CELLPADDING="0" CELLSPACING="0" bgcolor="" bordercolor="#013157 ">
		<TR><TD colspan="3" ALIGN="center"><DIV ID="message" ALIGN="top"></DIV></TD></TR>	
	</table>
	
	<table align=center width="90%">
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
	<input type="hidden" name="divisionId" >
	<input type="hidden" name="divid">
	<input type="hidden" name="hmode">
	<input type="hidden" name="checkCount">
	<input type="hidden" name="flag" value='1'>
	<input type="hidden" name="comboValue">
	<input type="hidden" name="chkValue" value="">
	<input type="hidden" name="chkLength" value="0">
	<input type="hidden" name="totalpage">
	<input type="hidden" name="cnt_page" value='<%=request.getAttribute("cnt_page")%>'>
	<input type="hidden" name="search" >
	<input type="hidden" name="searchColumn">
	<input type="hidden" name="rowNum" >
	<input type="hidden" name="prevNext">
	<%=str%>
	<%=strReset%>
	<input type="hidden" name="strVisibilityMode" value='<%=request.getAttribute("visibilityMode")%>'>

</html:form>
</body>
</html>
