<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Patient Listing</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/search_mms_Listing.js"></script>




</head>
<body onload="configMmsListType(),fetchMmsList('1','1');">
<html:form action="/transactions/MmsCNT.cnt"
	 method="post">
	
	<div id = "errMsg" class="errMsg"><bean:write name="mmsBean" property="strErrMsg"/></div> 
 <div id='normalMsg'></div>
	
<table width="100%" cellspacing="1px">

	<tr>
		<td>
		<table width='100%' align="center" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4"></td>
			</tr>
			<tr>
			</tr>
		</table>
		<div id="fetchRecordDivId"></div>
				<table width='100%' align="center" cellspacing="1px">
		<tr>
		<td class='LABEL'>
		<b>Find By</b> <select name='strSearchType' class='comboNormal'><option value='1'>P.O. No.</option><option value='2'>Supplier Name</option></select> <input type='text' name='strSearchString' class="txtFldMax" style="height: 19px" onkeyup="return getMmsListOnEnter(event);"  onkeypress="return validateSearchText(event);"> <label for="sn"><img style="cursor:pointer;cursor:pointer" src="../../hisglobal/images/btn-search.png" title="Search Record"
						name="search" onClick="getSearchMmsListBySearch();"
						onKeyPress="getSearchMmsListBySearch();" align="middle" height="19" width="70"></label>  &nbsp;</td>
		</tr>
		</table>
				
		
			<table width='100%'  cellspacing="0px">
				<tr class="FOOTER">
				<td width='3%'><div id="plusHelpId" align="center"><img
						src="../../hisglobal/images/plus.gif" name="plusHelp" style="cursor:pointer;cursor:pointer"
						align="middle"
						onclick="showHelpDetails('HelpId');" /></div>
					<div id="minusHelpId" style="display: none" align="center"><img
						src="../../hisglobal/images/minus.gif" name="minusHelp" style="cursor:pointer;cursor:pointer"
							onclick="hideHelpDetails('HelpId');"> </div></td>
						<td><div align="left">Help</div></td>
					
				</tr>
			</table>
			<div id="HelpId" style="display:none">
			<table width='100%' align="center" cellspacing="1px">
			<tr >
			<td class="CONTROL"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 Use <b>%</b> to Find Any Data of Any Length (Including zero length)
			</td>
			</tr>
			<tr >
			<td class="CONTROL"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Use <b>_</b> to Find Data on a Single Character Exclusion
			</td>
			</tr>
			<tr class=FOOTER>
			<td ></td>
			</tr>
			</table>
			</div>
			
		
		<table border="0" width='100%' align="center">
				<tr>
<td align="right"><img style="cursor:pointer;cursor:pointer"
						src="../../hisglobal/images/btn-ok.png" onClick="setPONo();" title="Select the P.O."></td>
					
					<td align="left"><img style="cursor:pointer;cursor:pointer"
						src="../../hisglobal/images/btn-ccl.png" onClick="window.close();" title="Cancel and Close the Window"></td>
				</tr>
			</table>
					
		</td>
		</tr>
		</table>
		
		<input type="hidden" name="mmsListType" value="${mmsBean.usrArg }" />
		<input type="hidden" name="userJsFunctionName" value="${mmsBean.usrFuncName }" />	
		
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>