<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Dossier Master</title>
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="Javascript" src="../../mms/js/searchItems_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/DossierMaster.js"></script>

<script type="text/javascript"> 
function LeftListTransfer()
{
 var ob1=document.forms[0].strLeftReqTypes.value;
 var ob=document.getElementById("LeftReqTypes");
 shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
}

	function validateInsert()
	{
			 
		selectListRecords("strRightRequestTypes"); 
	    var hisValidator = new HISValidator("DossierMasterBean"); 

	    hisValidator.addValidation("strDossierName", "req", "Dossier Name is a Mandatory Field");
	    hisValidator.addValidation("strDossierShortName", "req", "Dossier Short Name is a Mandatory Field");
		/* hisValidator.addValidation("strDossierDescription", "req", "Dossier Description is a Mandatory Field"); */
		hisValidator.addValidation("strBillingMode", "req", "Billing Mode is a Mandatory Field");

	    var retVal = hisValidator.validate(); 
	  	
	        if(retVal){
	      		 /* var count = selectListRecords("strRightRequestTypes");
	      		 if(count==0)
	      		 {
		      		 alert("Please select an item.");
	      		 	return false;
	      		 }
	      		 else{ */
	      			var conf = confirm("Are you Sure, You Want to Modify!!!!");

			    	if(conf)
		    		{	
		    			document.forms[0].hmode.value="UPDATE";
		    			document.forms[0].submit();
		    		}else{
		    			return false;
		    		}
		      	/*  } */
	         }else{
	          return false;
		   }
		 
	}
	
	function clearRecord()
	{
		document.forms[0].strDossierName.value="";
		document.forms[0].strDossierDescription.value="";
		document.forms[0].strDepartmentName.value="";
		document.forms[0].strBillingMode.value="";
		document.getElementById("errMsgId").innerHTML="";
		document.getElementById("warningMsgId").innerHTML="";
		document.getElementById("normalMsg").innerHTML="";
		
	} 

</script>
</head>
<body onload="">
<html:form action="/masters/DossierMstCNT" name="DossierMasterBean"
	type="dossier.masters.controller.fb.DossierMstFB">
		

	<center>
	<div class="errMsg" id="errMsgId">
		<bean:write name="DossierMasterBean" property="strErrMssgstring" />
	</div>
	<div class="warningMsg" id="warningMsgId">
		<bean:write name="DossierMasterBean" property="strWarnMssgstring" />
	</div>
	<div class="normalMsg" id="normalMsg">
		<bean:write name="DossierMasterBean" property="strNormMssgstring" />
	</div>


	</center>
	<tag:tab tabLabel="Dossier Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">Dossier Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Service Type Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strServiceTypeName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%"><font color="red">*</font>Dossier Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<textarea rows="2" cols="20" name="strDossierName">${DossierMasterBean.strDossierName}</textarea> <!-- Dossier Name -->
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="LABEL" width="45%"><font color="red">*</font>Dossier Short Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<input type="text" rows="2" cols="20" maxlength="15" name="strDossierShortName" value="${DossierMasterBean.strDossierShortName}">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="LABEL" width="45%">Dossier Description</td>
			<td colspan="2" class="CONTROL" width="45%">
				<textarea rows="2" cols="20" name="strDossierDescription">${DossierMasterBean.strDossierDescription}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%"><font color="red">*</font>Billing Mode</td>
			<td colspan="2" class="CONTROL" width="45%">
				<input type="radio" name="strBillingMode" value="1" checked="true">Item-Wise Cost&nbsp;
				<input type="radio" name="strBillingMode" value="2" disabled>Dossier-Wise Cost
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%"><font color="red">*</font>Record Status</td>
			<td colspan="2" class="CONTROL" width="45%">
				<html:radio name="DossierMasterBean" property="strIsValid" value="1">Active</html:radio>
				<html:radio name="DossierMasterBean" property="strIsValid" value="2">Inactive</html:radio>
			</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr class="HEADER">
				<td colspan="8"><!-- <font color="red">*</font> -->Department Name</td>
			</tr>
			<tr>
  			 		<td class="CONTROL" colspan="3">  			 
						<div id="LeftReqTypes" align="right">
							<select name="strLeftReqTypes" size="8" multiple style="width: 280px">
								<bean:write name="DossierMasterBean" property="strLeftRequestTypeList" filter="false"/>
							</select></div>
					</td>
					<td width="6%" class="CONTROL" colspan="2">			
						<center><img src="../../hisglobal/images/forward3.gif" width="35" height="31" onclick ="LeftListTransfer();"></center>
						<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
						<br/>
						<center><img src="../../hisglobal/images/backward.gif" width="35" height="31" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);"></center>
						<center><img src="../../hisglobal/images/back3.gif" width="35" height="31" onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
					</td>
					<td colspan="3" class="CONTROL">
						<div id="RightReqTypes" align="left">
							<select name="strRightRequestTypes" id="RightReqTypes1" size="8" multiple style="width: 280px">
								<bean:write name="DossierMasterBean" property="strRightRequestTypeList" filter="false"/>
							</select></div>
			</tr> 
		</table>
	
 	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<br>
	<div align="center" id=" ">					 
		 	<a href="#" class="button" id=" " onclick='validateInsert();'><span class="save">Save</span></a>
			<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
	</div>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${DossierMasterBean.strChk}" name="chk" />
	<input type="hidden" value="${DossierMasterBean.strDossierType}" name="dossierType" />
	<input type="hidden" value="${DossierMasterBean.strCurrentDate}" name="strCurrentDate" />
	<input type="hidden" value="${DossierMasterBean.strItemIssueMode}" name="itemIssueCode" />
	<input type="hidden" value="${DossierMasterBean.strServiceName}" name="serviceName" />
	
	<input type="hidden" value="${DossierMasterBean.strDossierID}" name="strDossierID" />
	<input type="hidden" value="${DossierMasterBean.strServiceTypeID}" name="strServiceTypeID" />
	<input type="hidden" value="${DossierMasterBean.strServiceTypeName}" name="strServiceTypeName" />
	<input type="hidden" value="${DossierMasterBean.strIsValidOld}" name="strIsValidOld" />
	<%-- <input type="hidden" value="${DossierMasterBean.strDepartmentCode}" name="strDepartmentCode" />
			 --%>
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>