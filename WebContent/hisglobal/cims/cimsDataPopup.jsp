<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<!-- 
/**
 * @author Amit Kumar Ateria
 * Date of Creation : 20/12/2017
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : CIMS Integration
 */
 -->
<html>
<head>
<title>CIMS Data Popup</title>
<link href="../../hisglobal/cims/cims_css/cupertino/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/cims/cims_css/excite-bike/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/cims/cims_css/mims.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/cims/cims_css/redmond/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css">
<!--  <link href="../../hisglobal/cims/cims_css/smoothness/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css">-->

<script language="JavaScript" src="../../hisglobal/cims/cims_scripts/drugalert.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="JavaScript" src="../../hisglobal/cims/cims_scripts/jquery-ui-1.8.6.custom.min.js"></script>
<script language="JavaScript" src="../../hisglobal/cims/cims_scripts/monograph.js"></script>
<script language="JavaScript" src="../../hisglobal/cims/cims_scripts/vtip.js"></script>

</head>

<body onload="">

<html:form action="/transactions/MmsCNT.cnt" method="post">

<div id="cimsDataPopup">
<bean:write name="mmsBean" property="strCIMSData" filter="false"/>
</div>
</html:form>


</body>
</html>