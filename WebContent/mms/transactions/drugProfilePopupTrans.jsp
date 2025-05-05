<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Drug Profile</title>
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/DrugProfileWithPopup.js"></script>

</head>
<body onload="showPopup();">
<form action="DrugProfileCNT.cnt" method="post">
<div id="normalMsg"></div>

<input type="hidden" name="hmode"/>
<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDivId" style="display: none;">
	<table bgcolor="white" class='TABLEWIDTH'>
		<tr>
			<td>
			<div id="itemParameterDtlDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
</div>
<cmbPers:cmbPers />

<input type="hidden" name="strChkVal" value="${drugProfileBean.strChkVal }">
</form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>