<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 05/June/2009
 * 
 */
-->
<html>
<head>
<meta charset=UTF-8">
<title>Installation Detail</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/installationTrans_mms.js">




</script>
</head>
<body onload="ViewHideandBlock();">

<html:form action="/transactions/InstallationTransCNT.cnt" name="installationTransBean" type="mms.transactions.controller.fb.InstallationTransFB" method="post" >
	<center><div class="errMsg" id="errMsg"><bean:write name="installationTransBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="installationTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="installationTransBean" property="strNormalMsg" /></div>
		
	<tag:tab tabLabel="Installation Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
		<td colspan="4"></td>
	</tr>
	<tr class="TITLE" >
		<td align="right" colspan="4"><input name="strView" type="checkbox"
				value="1" onclick="diplayView();">View</td>
	</tr>
	
	
	<tr> 
		<td colspan="2" class="LABEL"><font color="red">*</font>Store Name</td>
		<td colspan="2" class="CONTROL">
			<div id="StoreDivId" style="display: block;">
			<select name="strStoreId" class='comboNormal' onchange="getItemCatCmb();">
					<bean:write name="installationTransBean" property="strStoreValues"filter="false" />
			</select></div>
			<div align="left" id="StoreNameDivId" style="display:none;" >
               			 <bean:write name="installationTransBean" property="strHidStoreName" filter="false"/>
            </div>
		</td>
		</tr>
	<tr>
         <td class="LABEL" colspan="2"><font color="red">*</font>Item Category</td>
         <td class="CONTROL" colspan="1">
            <div align="left" id="itemCategoryId" style="display:block;" >
            <select name="strItemCatNo" class="comboNormal"  >
                      <bean:write name="installationTransBean" property="strCategoryValues" filter="false" />	
            </select></div>
            <div align="left" id="ItemCatNamedivId" style="display:none;" >
           			 <bean:write name="installationTransBean" property="strItemCategoryName" filter="false"/>
            </div>
         </td>   
         <td  class="CONTROL" colspan="1" nowrap> 
            <div align="left" id="imageDivId" style="display:block;" >
            <input type="image" style="cursor:pointer;cursor:pointer" title="Quality Detail" align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" onclick="return goFuncView();" >
           </div>
	     </td>
	    
	</tr>
	</table>
	
	<div id="installationDivId" style="display: none;">
	  <bean:write name="installationTransBean" property="strInstallationViewDetails" filter="false"/>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr>
			<td colspan="4" align="center">
			<img style="cursor: pointer; " title="To Reset" src="../../hisglobal/images/btn-clr.png" onClick="clearView();" />
            <img style="cursor: pointer; " title="Go to Main Page" src="../../hisglobal/images/back_tab.png" onclick="back();" /></td>
		</tr>
	</table>
	
	<input type="hidden" name="hmode"/>
	
	<input type="hidden" name="displayFlag" value="${installationTransBean.displayFlag}"/>
	<input type="hidden" name="strItemCategoryName" value="${installationTransBean.strItemCategoryName}"/>
	<input type="hidden" name="strHidStoreName" value="${installationTransBean.strHidStoreName}"/>
</html:form>
	<tag:autoIndex></tag:autoIndex>  
</body>
</html>