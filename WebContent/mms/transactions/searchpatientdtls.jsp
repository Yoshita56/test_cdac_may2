<%@ page language="java" contentType="text/html;"	%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Patient Listing</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/patientListing.js"></script>

<script language="Javascript">

function autoTabIndexing()
{ 
	var fFlagFocusFirst=true;
	var allImageObj = document.getElementsByTagName('img');
	var allAnchorObj = document.getElementsByTagName('A');
	var allSelectObj = document.getElementsByTagName('SELECT');
	var allInputObj = document.getElementsByTagName('INPUT');
	var allTxtObj = document.getElementsByTagName('TEXTAREA');
	
	/*for(var nTmpI=0; nTmpI<document.forms[0].elements.length; nTmpI++)
	{
		document.forms[0].elements[nTmpI].setAttribute('tabIndex','1');
		if(fFlagFocusFirst && document.forms[0].elements[nTmpI].type!='hidden' 
			&& (document.forms[0].elements[nTmpI].tagName=='INPUT' 
			||document.forms[0].elements[nTmpI].tagName=='SELECT' 
			|| document.forms[0].elements[nTmpI].tagName=='TEXTAREA'))
		{
			document.forms[0].elements[nTmpI].focus();
	    if(((document.forms[0].elements[nTmpI].tagName=='INPUT' 
	    	&& document.forms[0].elements[nTmpI].type=='text') 
	    	|| document.forms[0].elements[nTmpI].tagName=='TEXTAREA') 
	    	&& document.forms[0].elements[nTmpI].value.length >0)
	    {
			document.forms[0].elements[nTmpI].select();
			fFlagFocusFirst=false;
		}
	}
	}*/
	for(var nTmpI=0; nTmpI<allImageObj.length; nTmpI++)
	{
		allImageObj[nTmpI].setAttribute('tabIndex','1');
		if(allImageObj[nTmpI].src.split('/')[allImageObj[nTmpI].src.split('/').length-1]=='tp.gif')
		allImageObj[nTmpI].setAttribute('tabIndex','0');
	}
	for(var nTmpI=0; nTmpI<allAnchorObj.length; nTmpI++)
	{
		allAnchorObj[nTmpI].setAttribute('tabIndex','1');
	}
	for(var nTmpI=0; nTmpI<allSelectObj.length; nTmpI++)
	{
		allSelectObj[nTmpI].setAttribute('tabIndex','1');
	}
	for(var nTmpI=0; nTmpI<allInputObj.length; nTmpI++)
	{
		allInputObj[nTmpI].setAttribute('tabIndex','1');
	}
	for(var nTmpI=0; nTmpI<allTxtObj.length; nTmpI++)
	{
		allTxtObj[nTmpI].setAttribute('tabIndex','1');
	}
}
</script>
</head>
<body onload="configPatListType(),fetchPatientList('1','1'),resize_popUp_Search();">
<html:form action="/transactions/IpdCNT.cnt" method="post">
<div class="normalMsg" id="normalMsg"></div>
<table width="100%" cellspacing="1px">
<tr>
	<td>
	<table width='100%' align="center" cellspacing="1px">
		<tr class="HEADER"><td colspan="4">Patient Listing</td></tr>
		<tr></tr>
	</table>
	<div id="fetchRecordDivId"></div>
	<table width='100%' align="center" cellspacing="0">
		<tr>
			<td class='LABEL' width="35%"></td>
			<td class='LABEL' width="65%" align="left"><div align="left"><b>Find By&nbsp;</b>
			<select name='strSearchType' class='comboNormal'>
				<option value='1'>CR No.</option>
				<option value='2'>Patient Name</option>
			</select> 
			<input type='text' name='strSearchString' class="txtFldMax"
					style="" onkeypress="return validateSearchText(event);">
			<img style="cursor: pointer;position: absolute;" src="../../hisglobal/images/btn-search.png"
					title="Search Record" name="Search" onClick="getSearchPatListBySearch();" 
					onKeyPress="getSearchPatListBySearch();" width="70"> &nbsp;</div></td>
		</tr>
	</table>
	<table width='100%' cellspacing="0px">
		<tr class="FOOTER">
			<td width='3%'>
			<div id="plusHelpId" align="center">
			<img src="../../hisglobal/images/plus.gif" name="plusHelp" style="cursor: pointer;"
						align="middle" onclick="showHelpDetails('HelpId');" /></div>
			<div id="minusHelpId" style="display: none" align="center">
			<img  src="../../hisglobal/images/minus.gif" name="minusHelp" style="cursor: pointer;"
					onclick="hideHelpDetails('HelpId');"></div>
			</td>
			<td>
			<div align="left">Help</div>
			</td>
		</tr>
	</table>
	<div id="HelpId" style="display: none">
	<table width='100%' align="center" cellspacing="1px">
				<tr>
					<td class="CONTROL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Use <b>%</b>
					to Find Any Data of Any Length (Including zero length)</td>
				</tr>
				<tr>
					<td class="CONTROL">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Use <b>_</b>
					to Find Data on a Single Character Exclusion</td>
				</tr>
				<tr class=FOOTER>
					<td></td>
				</tr>
	</table>
	</div>
	<table border="0" width='100%' align="center">
		<tr>
			<td align="right">
			<img style="cursor: pointer;" src="../../hisglobal/images/btn-ok.png" 
			onClick="setCrNo();" title="Select the Patient"></td>
			<td align="left">
			<img style="cursor: pointer;" src="../../hisglobal/images/btn-ccl.png"
				onClick="window.close();" title="Cancel and Close the Window"></td>
		</tr>
	</table>

</td></tr></table>
		<input type="hidden" name="strWinResize" value="${ipdBean.strWinResize}">
		<input type="hidden" name="patListType" value="${ipdBean.usrArg }" />
		<input type="hidden" name="userJsFunctionName" value="${ipdBean.usrFuncName }" />		
</html:form>
</body>
</html>